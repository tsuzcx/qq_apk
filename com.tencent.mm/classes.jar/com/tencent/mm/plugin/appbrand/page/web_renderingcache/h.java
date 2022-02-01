package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h lHo;
  
  static
  {
    AppMethodBeat.i(50996);
    lHo = new h();
    AppMethodBeat.o(50996);
  }
  
  public static final String Qf(String paramString)
  {
    AppMethodBeat.i(50994);
    k.h(paramString, "appId");
    paramString = brF() + '/' + paramString;
    i.aSh(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String brF()
  {
    AppMethodBeat.i(50995);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    String str = ((e)localObject).agv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.h
 * JD-Core Version:    0.7.0.1
 */