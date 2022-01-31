package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.debugger.b;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ap
  implements bx.a
{
  public static final Map<String, ap.c> fEo;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("AppBrandNotify", new ap.b((byte)0));
    localHashMap.put("AppPublicLibraryNotify", new ap.d((byte)0));
    localHashMap.put("mmbizwxaconfig", new ap.a((byte)0));
    localHashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.c());
    localHashMap.put("AppBrandForceKill", new b());
    fEo = Collections.unmodifiableMap(localHashMap);
  }
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if (bk.bl(parama))
    {
      y.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
      return;
    }
    com.tencent.mm.plugin.appbrand.v.c.DS().O(new ap.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */