package com.tencent.mm.plugin.appbrand.networking;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.cm.g;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.vending.h.h;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class f
  implements a
{
  protected static final boolean gPS;
  public static final f itR;
  protected static final h itS;
  protected static final Map<String, Integer> itT;
  
  static
  {
    AppMethodBeat.i(132321);
    itR = new f();
    gPS = bp.dud();
    itS = new h(new al("MicroMsg.WxaCgiServiceWC").oNc.getLooper(), "MicroMsg.WxaCgiServiceWC");
    HashMap local1 = new HashMap() {};
    itT = local1;
    local1.put("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", Integer.valueOf(1714));
    itT.put("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", Integer.valueOf(1345));
    itT.put("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", Integer.valueOf(1115));
    itT.put("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", Integer.valueOf(1862));
    itT.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", Integer.valueOf(1194));
    itT.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", Integer.valueOf(1191));
    itT.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", Integer.valueOf(1180));
    itT.put("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", Integer.valueOf(1183));
    itT.put("/cgi-bin/mmbiz-bin/js-authorize", Integer.valueOf(1157));
    itT.put("/cgi-bin/mmbiz-bin/js-authorize-confirm", Integer.valueOf(1158));
    AppMethodBeat.o(132321);
  }
  
  private <Resp extends bvk> com.tencent.mm.cm.f<Resp> b(String paramString, com.tencent.mm.bv.a parama, Class<Resp> paramClass)
  {
    AppMethodBeat.i(132319);
    final com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.funcId = ((Integer)itT.get(paramString)).intValue();
    locala.uri = paramString;
    locala.fsX = parama;
    try
    {
      locala.fsY = ((com.tencent.mm.bv.a)paramClass.newInstance());
      paramString = g.dTg().d(itS).g(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(132319);
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      do
      {
        ab.e("MicroMsg.WxaCgiServiceWC", "new Response failed %s", new Object[] { paramClass.getName() });
      } while (!gPS);
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(132319);
      throw paramString;
    }
    catch (IllegalAccessException paramString)
    {
      label89:
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.f
 * JD-Core Version:    0.7.0.1
 */