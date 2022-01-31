package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.util.Map;

public final class c
  implements bx.a
{
  public static void a(a parama)
  {
    if (parama == null)
    {
      y.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
      return;
    }
    if (parama.jaj > 0)
    {
      g.DP().Dz().o(208899, Boolean.valueOf(true));
      com.tencent.mm.y.c.BS().v(262147, true);
    }
    if (parama.jak > 0)
    {
      g.DP().Dz().o(208913, Boolean.valueOf(true));
      com.tencent.mm.y.c.BS().v(262149, true);
    }
    if (!bk.bl(parama.thumburl))
    {
      y.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      g.DP().Dz().o(229633, parama.thumburl);
      g.DP().Dz().o(229634, System.currentTimeMillis());
      return;
    }
    g.DP().Dz().o(229633, "");
    g.DP().Dz().o(229634, "");
  }
  
  public final void a(e.a parama)
  {
    parama = parama.dBs;
    Object localObject1;
    if (parama.kSW == 10002)
    {
      parama = aa.a(parama.svH);
      if (bk.bl(parama)) {
        y.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
      }
      do
      {
        return;
        parama = bn.s(parama, "sysmsg");
      } while ((parama == null) || (parama.size() <= 0));
      localObject1 = (String)parama.get(".sysmsg.$type");
      if ((bk.bl((String)localObject1)) || (!((String)localObject1).equalsIgnoreCase("emotionstore"))) {}
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = (String)parama.get(".sysmsg.emotionstore.productid");
        localObject2 = (String)parama.get(".sysmsg.emotionstore.newcount");
        String str1 = (String)parama.get(".sysmsg.emotionstore.freecount");
        String str2 = (String)parama.get(".sysmsg.emotionstore.thumburl");
        if (bk.bl((String)localObject2)) {
          break label413;
        }
        i = Integer.valueOf((String)localObject2).intValue();
        if (TextUtils.isEmpty(str1)) {
          break label408;
        }
        j = Integer.valueOf(str1).intValue();
        localObject2 = new a(i, j, str2, (String)localObject1);
        if (!bk.bl((String)localObject1))
        {
          y.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[] { localObject1 });
          localObject1 = new l((String)localObject1, (a)localObject2);
          g.DO().dJT.a((m)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!bk.bl((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            g.DP().Dz().c(ac.a.uoc, Boolean.valueOf(true));
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((bk.bl(parama)) || (Integer.valueOf(parama).intValue() <= 0)) {
            break;
          }
          g.DP().Dz().c(ac.a.uof, Boolean.valueOf(true));
          return;
        }
      }
      catch (Exception parama)
      {
        y.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[] { bk.j(parama) });
        return;
      }
      a((a)localObject2);
      continue;
      y.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :" + (String)localObject1);
      return;
      y.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.kSW) });
      return;
      label408:
      int j = 0;
      continue;
      label413:
      int i = 0;
    }
  }
  
  public final class a
  {
    private String bHe;
    int jaj;
    int jak;
    String thumburl;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.jaj = paramInt1;
      this.jak = paramInt2;
      this.thumburl = paramString1;
      this.bHe = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */