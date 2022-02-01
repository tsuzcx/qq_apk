package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class h
  implements cj.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.heO;
    Object localObject;
    if (parama.xKb == 10002)
    {
      parama = z.a(parama.KHn);
      if (Util.isNullOrNil(parama))
      {
        Log.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(117441);
        return;
      }
      Log.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = XmlParser.parseXml(parama, "sysmsg", null);
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = Util.safeParseInt((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = Util.nullAs((String)parama.get(".sysmsg.boots.xmlkey"), "");
          Log.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.azs();
          localObject = com.tinkerboots.sdk.a.hvX().ol("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (i != 1)) {
            break label251;
          }
        }
      }
    }
    label251:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ol("network", String.valueOf(i));
      if (!Util.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.hvX().ol("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.hvX().Ey(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */