package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.util.Map;

public final class c
  implements bz.a
{
  public static void a(a parama)
  {
    AppMethodBeat.i(53161);
    if (parama == null)
    {
      ab.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
      AppMethodBeat.o(53161);
      return;
    }
    if (parama.lja > 0)
    {
      g.RL().Ru().set(208899, Boolean.TRUE);
      com.tencent.mm.x.c.PJ().x(262147, true);
    }
    if (parama.ljb > 0)
    {
      g.RL().Ru().set(208913, Boolean.TRUE);
      com.tencent.mm.x.c.PJ().x(262149, true);
    }
    if (!bo.isNullOrNil(parama.thumburl))
    {
      ab.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      g.RL().Ru().set(229633, parama.thumburl);
      g.RL().Ru().set(229634, System.currentTimeMillis());
      AppMethodBeat.o(53161);
      return;
    }
    g.RL().Ru().set(229633, "");
    g.RL().Ru().set(229634, "");
    AppMethodBeat.o(53161);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(53160);
    parama = parama.eyJ;
    Object localObject1;
    if (parama.nqW == 10002)
    {
      parama = aa.a(parama.woR);
      if (bo.isNullOrNil(parama))
      {
        ab.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(53160);
        return;
      }
      parama = br.F(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject1 = (String)parama.get(".sysmsg.$type");
        if ((bo.isNullOrNil((String)localObject1)) || (!((String)localObject1).equalsIgnoreCase("emotionstore"))) {}
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
        if (bo.isNullOrNil((String)localObject2)) {
          break label435;
        }
        i = Integer.valueOf((String)localObject2).intValue();
        if (TextUtils.isEmpty(str1)) {
          break label430;
        }
        j = Integer.valueOf(str1).intValue();
        localObject2 = new a(i, j, str2, (String)localObject1);
        if (!bo.isNullOrNil((String)localObject1))
        {
          ab.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[] { localObject1 });
          localObject1 = new k((String)localObject1, (a)localObject2);
          g.RK().eHt.a((m)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!bo.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            g.RL().Ru().set(ac.a.yxT, Boolean.TRUE);
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((!bo.isNullOrNil(parama)) && (Integer.valueOf(parama).intValue() > 0)) {
            g.RL().Ru().set(ac.a.yxX, Boolean.TRUE);
          }
          AppMethodBeat.o(53160);
          return;
        }
        a((a)localObject2);
        continue;
        ab.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject1)));
      }
      catch (Exception parama)
      {
        ab.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[] { bo.l(parama) });
        AppMethodBeat.o(53160);
        return;
      }
      AppMethodBeat.o(53160);
      return;
      ab.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.nqW) });
      AppMethodBeat.o(53160);
      return;
      label430:
      int j = 0;
      continue;
      label435:
      int i = 0;
    }
  }
  
  public final class a
  {
    private String cot;
    int lja;
    int ljb;
    String thumburl;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.lja = paramInt1;
      this.ljb = paramInt2;
      this.thumburl = paramString1;
      this.cot = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */