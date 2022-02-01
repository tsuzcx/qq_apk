package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

public final class c
  implements cl.a
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
    if (parama.xPa > 0)
    {
      h.baE().ban().B(208899, Boolean.TRUE);
      com.tencent.mm.aa.c.aYo().Q(262147, true);
    }
    if (parama.xPb > 0)
    {
      h.baE().ban().B(208913, Boolean.TRUE);
      com.tencent.mm.aa.c.aYo().Q(262149, true);
    }
    if (!Util.isNullOrNil(parama.thumburl))
    {
      Log.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[] { parama.thumburl });
      h.baE().ban().B(229633, parama.thumburl);
      h.baE().ban().B(229634, System.currentTimeMillis());
      AppMethodBeat.o(108734);
      return;
    }
    h.baE().ban().B(229633, "");
    h.baE().ban().B(229634, "");
    AppMethodBeat.o(108734);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(108733);
    parama = parama.mpN;
    Object localObject1;
    if (parama.IIs == 10002)
    {
      parama = w.a(parama.YFG);
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
          h.baD().mCm.a((p)localObject1, 0);
          localObject1 = (String)parama.get(".sysmsg.personalemotion.newcount");
          if ((!Util.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() > 0)) {
            h.baE().ban().set(at.a.acIc, Boolean.TRUE);
          }
          parama = (String)parama.get(".sysmsg.personalemoji.emojicount");
          if ((!Util.isNullOrNil(parama)) && (Integer.valueOf(parama).intValue() > 0)) {
            h.baE().ban().set(at.a.acIh, Boolean.TRUE);
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
      Log.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(parama.IIs) });
      AppMethodBeat.o(108733);
      return;
      label431:
      int j = 0;
      continue;
      label436:
      int i = 0;
    }
  }
  
  public final void a(g.c paramc) {}
  
  public final class a
  {
    private String hBT;
    String thumburl;
    int xPa;
    int xPb;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.xPa = paramInt1;
      this.xPb = paramInt2;
      this.thumburl = paramString1;
      this.hBT = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.c
 * JD-Core Version:    0.7.0.1
 */