package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g tDv;
  
  static
  {
    AppMethodBeat.i(50996);
    tDv = new g();
    AppMethodBeat.o(50996);
  }
  
  public static final String afj(String paramString)
  {
    AppMethodBeat.i(50994);
    s.u(paramString, "appId");
    paramString = cGy() + '/' + paramString;
    y.bDX(paramString);
    AppMethodBeat.o(50994);
    return paramString;
  }
  
  public static final String cGy()
  {
    AppMethodBeat.i(50995);
    String str2 = h.baE().cachePath;
    s.s(str2, "path");
    String str1 = str2;
    if (!n.a((CharSequence)str2, '/')) {
      str1 = s.X(str2, "/");
    }
    str1 = s.X(str1, "appbrand/web_renderingcache");
    s.s(str1, "path");
    AppMethodBeat.o(50995);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */