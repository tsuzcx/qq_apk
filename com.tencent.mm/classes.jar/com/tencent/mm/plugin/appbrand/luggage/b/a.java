package com.tencent.mm.plugin.appbrand.luggage.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/CustomizeCommLibReaderWrapper;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "()V", "info", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "init", "", "openRead", "Ljava/io/InputStream;", "fileName", "", "readAsString", "versionBuildInfo", "versionName", "plugin-appbrand-integration_release"})
public final class a
  implements n
{
  public static final a iom;
  
  static
  {
    AppMethodBeat.i(134723);
    iom = new a();
    AppMethodBeat.o(134723);
  }
  
  public final String avc()
  {
    AppMethodBeat.i(134721);
    String str = WxaCommLibRuntimeReader.avH().avc();
    j.p(str, "WxaCommLibRuntimeReader.getReader().versionName()");
    AppMethodBeat.o(134721);
    return str;
  }
  
  public final String avd()
  {
    AppMethodBeat.i(134722);
    String str = WxaCommLibRuntimeReader.avH().avd();
    j.p(str, "WxaCommLibRuntimeReader.…ader().versionBuildInfo()");
    AppMethodBeat.o(134722);
    return str;
  }
  
  public final WxaPkgWrappingInfo ave()
  {
    AppMethodBeat.i(134720);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.avH().ave();
    j.p(localWxaPkgWrappingInfo, "WxaCommLibRuntimeReader.getReader().info()");
    AppMethodBeat.o(134720);
    return localWxaPkgWrappingInfo;
  }
  
  public final void init() {}
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(134719);
    paramString = WxaCommLibRuntimeReader.avH().openRead(paramString);
    AppMethodBeat.o(134719);
    return paramString;
  }
  
  public final String yl(String paramString)
  {
    AppMethodBeat.i(143903);
    paramString = WxaCommLibRuntimeReader.yt(paramString);
    j.p(paramString, "WxaCommLibRuntimeReader.readFileContent(fileName)");
    AppMethodBeat.o(143903);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.a
 * JD-Core Version:    0.7.0.1
 */