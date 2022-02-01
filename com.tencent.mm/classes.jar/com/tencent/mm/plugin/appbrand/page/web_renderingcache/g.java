package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g qyA;
  
  static
  {
    AppMethodBeat.i(50996);
    qyA = new g();
    AppMethodBeat.o(50996);
  }
  
  public static final String amb(String paramString)
  {
    AppMethodBeat.i(50994);
    p.k(paramString, "appId");
    paramString = cfL() + '/' + paramString;
    u.bBD(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String cfL()
  {
    AppMethodBeat.i(50995);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    String str = ((f)localObject).aHl();
    p.j(str, "path");
    localObject = str;
    if (!n.a((CharSequence)str, '/')) {
      localObject = str + '/';
    }
    localObject = (String)localObject + "appbrand/web_renderingcache";
    p.j(localObject, "path");
    AppMethodBeat.o(50995);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */