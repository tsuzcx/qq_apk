package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h lhv;
  
  static
  {
    AppMethodBeat.i(50996);
    lhv = new h();
    AppMethodBeat.o(50996);
  }
  
  public static final String LZ(String paramString)
  {
    AppMethodBeat.i(50994);
    k.h(paramString, "appId");
    paramString = bkQ() + '/' + paramString;
    i.aMF(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String bkQ()
  {
    AppMethodBeat.i(50995);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    String str = ((e)localObject).aff();
    k.g(str, "path");
    localObject = str;
    if (!n.a((CharSequence)str, '/')) {
      localObject = str + '/';
    }
    localObject = (String)localObject + "appbrand/web_renderingcache";
    k.g(localObject, "path");
    AppMethodBeat.o(50995);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.h
 * JD-Core Version:    0.7.0.1
 */