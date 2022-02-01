package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.y.a;
import java.util.Map;

public final class c
  implements cc.a
{
  public static void a(a parama)
  {
    AppMethodBeat.i(108734);
    if (parama == null)
    {
      ac.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
      AppMethodBeat.o(108734);
      return;
    }
    if (parama.pcG > 0)
    {
      g.agR().agA().set(208899, Boolean.TRUE);
      com.tencent.mm.y.c.aeH().w(262147, true);
    }
    if (parama.pcH > 0)
    {
      g.agR().agA().set(208913, Boolean.TRUE);
      com.tencent.mm.y.c.aeH().w(262149, true);
    }
    if (!bs.isNullOrNil(parama.thumburl))
    {
      ac.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      g.agR().agA().set(229633, parama.thumburl);
      g.agR().agA().set(229634, System.currentTimeMillis());
      AppMethodBeat.o(108734);
      return;
    }
    g.agR().agA().set(229633, "");
    g.agR().agA().set(229634, "");
    AppMethodBeat.o(108734);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(108733);
    parama = parama.fXi;
    Object localObject1;
    if (parama.tit == 10002)
    {
      parama = z.a(parama.DPV);
      if (bs.isNullOrNil(parama))
      {
        ac.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108733);
        return;
      }
      parama = bv.L(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject1 = (String)parama.get(".sysmsg.$type");
        if ((bs.isNullOrNil((String)localObject1)) || (!((String)localObject1).equalsIgnoreCase("emotionstore"))) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = (String)parama.get(".sysmsg.emotionstore.productid");
        Object localObject2 = (String)parama.get(".sysmsg.emotionstore.newcount");
        String str1 = (String)parama.get(".sysmsg.emotionstore.freecount");
        String str2 = (String)parama.get(".sysmsg.emotionstore.thumburl");
        if (bs.isNullOrNil((String)localObject2)) {
          break label435;
        }
        i = Integer.valueOf((String)localObject2).intValue();
        if (TextUtils.isEmpty(str1)) {
          break label430;
        }
        j = Integer.valueOf(str1).intValue();
        localObject2 = new a(i, j, str2, (String)localObject1);
        if (!bs.isNullOrNil((String)localObject1))
        {
          ac.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[] { localObject1 });
          localObject1 = new k((String)localObject1, (a)localObject2);
          g.agQ().ghe.a((n)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!bs.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            g.agR().agA().set(ah.a.GEb, Boolean.TRUE);
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((!bs.isNullOrNil(parama)) && (Integer.valueOf(parama).intValue() > 0)) {
            g.agR().agA().set(ah.a.GEf, Boolean.TRUE);
          }
          AppMethodBeat.o(108733);
          return;
        }
        a((a)localObject2);
        continue;
        ac.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject1)));
      }
      catch (Exception parama)
      {
        ac.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[] { bs.m(parama) });
        AppMethodBeat.o(108733);
        return;
      }
      AppMethodBeat.o(108733);
      return;
      ac.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.tit) });
      AppMethodBeat.o(108733);
      return;
      label430:
      int j = 0;
      continue;
      label435:
      int i = 0;
    }
  }
  
  public final void a(f.c paramc) {}
  
  public final class a
  {
    private String daP;
    int pcG;
    int pcH;
    String thumburl;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.pcG = paramInt1;
      this.pcH = paramInt2;
      this.thumburl = paramString1;
      this.daP = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */