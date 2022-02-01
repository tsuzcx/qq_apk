package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.z.a;
import java.util.Map;

public final class c
  implements cc.a
{
  public static void a(a parama)
  {
    AppMethodBeat.i(108734);
    if (parama == null)
    {
      ad.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
      AppMethodBeat.o(108734);
      return;
    }
    if (parama.ozg > 0)
    {
      g.afB().afk().set(208899, Boolean.TRUE);
      com.tencent.mm.z.c.adr().w(262147, true);
    }
    if (parama.ozh > 0)
    {
      g.afB().afk().set(208913, Boolean.TRUE);
      com.tencent.mm.z.c.adr().w(262149, true);
    }
    if (!bt.isNullOrNil(parama.thumburl))
    {
      ad.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      g.afB().afk().set(229633, parama.thumburl);
      g.afB().afk().set(229634, System.currentTimeMillis());
      AppMethodBeat.o(108734);
      return;
    }
    g.afB().afk().set(229633, "");
    g.afB().afk().set(229634, "");
    AppMethodBeat.o(108734);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(108733);
    parama = parama.fTo;
    Object localObject1;
    if (parama.saz == 10002)
    {
      parama = z.a(parama.Cxz);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108733);
        return;
      }
      parama = bw.K(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject1 = (String)parama.get(".sysmsg.$type");
        if ((bt.isNullOrNil((String)localObject1)) || (!((String)localObject1).equalsIgnoreCase("emotionstore"))) {}
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
        if (bt.isNullOrNil((String)localObject2)) {
          break label435;
        }
        i = Integer.valueOf((String)localObject2).intValue();
        if (TextUtils.isEmpty(str1)) {
          break label430;
        }
        j = Integer.valueOf(str1).intValue();
        localObject2 = new a(i, j, str2, (String)localObject1);
        if (!bt.isNullOrNil((String)localObject1))
        {
          ad.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[] { localObject1 });
          localObject1 = new k((String)localObject1, (a)localObject2);
          g.afA().gcy.a((n)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!bt.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            g.afB().afk().set(ae.a.Fgn, Boolean.TRUE);
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((!bt.isNullOrNil(parama)) && (Integer.valueOf(parama).intValue() > 0)) {
            g.afB().afk().set(ae.a.Fgr, Boolean.TRUE);
          }
          AppMethodBeat.o(108733);
          return;
        }
        a((a)localObject2);
        continue;
        ad.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject1)));
      }
      catch (Exception parama)
      {
        ad.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[] { bt.m(parama) });
        AppMethodBeat.o(108733);
        return;
      }
      AppMethodBeat.o(108733);
      return;
      ad.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.saz) });
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
    private String ddr;
    int ozg;
    int ozh;
    String thumburl;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.ozg = paramInt1;
      this.ozh = paramInt2;
      this.thumburl = paramString1;
      this.ddr = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */