package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h mlZ;
  
  static
  {
    AppMethodBeat.i(50996);
    mlZ = new h();
    AppMethodBeat.o(50996);
  }
  
  public static final String Ut(String paramString)
  {
    AppMethodBeat.i(50994);
    p.h(paramString, "appId");
    paramString = bwA() + '/' + paramString;
    o.aZI(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String bwA()
  {
    AppMethodBeat.i(50995);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    String str = ((e)localObject).ajw();
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