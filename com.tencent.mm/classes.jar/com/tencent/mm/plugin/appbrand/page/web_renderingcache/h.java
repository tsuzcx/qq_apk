package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h nwx;
  
  static
  {
    AppMethodBeat.i(50996);
    nwx = new h();
    AppMethodBeat.o(50996);
  }
  
  public static final String aeh(String paramString)
  {
    AppMethodBeat.i(50994);
    p.h(paramString, "appId");
    paramString = bSI() + '/' + paramString;
    s.boN(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String bSI()
  {
    AppMethodBeat.i(50995);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    String str = ((e)localObject).azM();
    p.g(str, "path");
    localObject = str;
    if (!n.a((CharSequence)str, '/')) {
      localObject = str + '/';
    }
    localObject = (String)localObject + "appbrand/web_renderingcache";
    p.g(localObject, "path");
    AppMethodBeat.o(50995);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.h
 * JD-Core Version:    0.7.0.1
 */