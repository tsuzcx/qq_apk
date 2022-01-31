package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.c;
import com.tencent.mm.plugin.appbrand.debugger.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class av
  implements bz.a
{
  public static final Map<String, av.c> gWE;
  
  static
  {
    AppMethodBeat.i(129438);
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new av.b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new av.d((byte)0));
    localHashMap.put("mmbizwxaconfig", new av.a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.d());
    localHashMap.put("AppBrandForceKill", new c());
    if (DebuggerShell.ayQ()) {
      localHashMap.put("AppBrandTestUpdateWxaUsageListNotify", new h());
    }
    gWE = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(129438);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(129436);
    parama = aa.a(parama.eyJ.woR);
    if (bo.isNullOrNil(parama))
    {
      ab.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      AppMethodBeat.o(129436);
      return;
    }
    com.tencent.mm.sdk.g.d.ysm.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(129429);
        av.yz(parama);
        AppMethodBeat.o(129429);
      }
    }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
    AppMethodBeat.o(129436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av
 * JD-Core Version:    0.7.0.1
 */