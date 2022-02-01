package com.tencent.mm.plugin.hp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tinkerboots.sdk.a;
import java.util.Map;

public final class g
  implements cl.a
{
  public final void a(g.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.mpN;
    Object localObject;
    if (parama.IIs == 10002)
    {
      parama = w.a(parama.YFG);
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
          long l = b.aZP();
          localObject = a.kkr().rg("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (i != 1)) {
            break label251;
          }
        }
      }
    }
    label251:
    for (int i = 3;; i = 2)
    {
      ((a)localObject).rg("network", String.valueOf(i));
      if (!Util.isNullOrNil(parama)) {
        a.kkr().rg("xmlkey", parama);
      }
      a.kkr().Pi(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.g
 * JD-Core Version:    0.7.0.1
 */