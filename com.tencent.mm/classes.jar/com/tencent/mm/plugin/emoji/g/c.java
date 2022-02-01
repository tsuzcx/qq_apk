package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.y.a;
import java.util.Map;

public final class c
  implements cj.a
{
  public static void a(a parama)
  {
    AppMethodBeat.i(108734);
    if (parama == null)
    {
      Log.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
      AppMethodBeat.o(108734);
      return;
    }
    if (parama.rdo > 0)
    {
      g.aAh().azQ().set(208899, Boolean.TRUE);
      com.tencent.mm.y.c.axV().A(262147, true);
    }
    if (parama.rdp > 0)
    {
      g.aAh().azQ().set(208913, Boolean.TRUE);
      com.tencent.mm.y.c.axV().A(262149, true);
    }
    if (!Util.isNullOrNil(parama.thumburl))
    {
      Log.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      g.aAh().azQ().set(229633, parama.thumburl);
      g.aAh().azQ().set(229634, System.currentTimeMillis());
      AppMethodBeat.o(108734);
      return;
    }
    g.aAh().azQ().set(229633, "");
    g.aAh().azQ().set(229634, "");
    AppMethodBeat.o(108734);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(108733);
    parama = parama.heO;
    Object localObject1;
    if (parama.xKb == 10002)
    {
      parama = z.a(parama.KHn);
      if (Util.isNullOrNil(parama))
      {
        Log.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(108733);
        return;
      }
      parama = XmlParser.parseXml(parama, "sysmsg", null);
      if ((parama != null) && (parama.size() > 0))
      {
        localObject1 = (String)parama.get(".sysmsg.$type");
        if ((Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).equalsIgnoreCase("emotionstore"))) {}
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
        if (Util.isNullOrNil((String)localObject2)) {
          break label436;
        }
        i = Integer.valueOf((String)localObject2).intValue();
        if (TextUtils.isEmpty(str1)) {
          break label431;
        }
        j = Integer.valueOf(str1).intValue();
        localObject2 = new a(i, j, str2, (String)localObject1);
        if (!Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[] { localObject1 });
          localObject1 = new l((String)localObject1, (a)localObject2);
          g.aAg().hqi.a((q)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!Util.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            g.aAh().azQ().set(ar.a.NSO, Boolean.TRUE);
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((!Util.isNullOrNil(parama)) && (Integer.valueOf(parama).intValue() > 0)) {
            g.aAh().azQ().set(ar.a.NSS, Boolean.TRUE);
          }
          AppMethodBeat.o(108733);
          return;
        }
        a((a)localObject2);
        continue;
        Log.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(localObject1)));
      }
      catch (Exception parama)
      {
        Log.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[] { Util.stackTraceToString(parama) });
        AppMethodBeat.o(108733);
        return;
      }
      AppMethodBeat.o(108733);
      return;
      Log.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.xKb) });
      AppMethodBeat.o(108733);
      return;
      label431:
      int j = 0;
      continue;
      label436:
      int i = 0;
    }
  }
  
  public final void a(h.c paramc) {}
  
  public final class a
  {
    private String dEA;
    int rdo;
    int rdp;
    String thumburl;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.rdo = paramInt1;
      this.rdp = paramInt2;
      this.thumburl = paramString1;
      this.dEA = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */