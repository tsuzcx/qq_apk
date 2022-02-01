package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.z;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getByWxaAttrs", "", "appId", "", "invoke"})
final class c$d
  extends q
  implements b<String, Integer>
{
  public static final d nKA;
  
  static
  {
    AppMethodBeat.i(279747);
    nKA = new d();
    AppMethodBeat.o(279747);
  }
  
  c$d()
  {
    super(1);
  }
  
  public static int adq(String paramString)
  {
    AppMethodBeat.i(279745);
    p.k(paramString, "appId");
    z localz = m.bFF();
    if (localz != null)
    {
      paramString = localz.d(paramString, new String[] { "versionInfo" });
      if (paramString != null)
      {
        paramString = paramString.bLH();
        if (paramString != null)
        {
          int i = paramString.appVersion;
          AppMethodBeat.o(279745);
          return i;
        }
      }
    }
    AppMethodBeat.o(279745);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.d
 * JD-Core Version:    0.7.0.1
 */