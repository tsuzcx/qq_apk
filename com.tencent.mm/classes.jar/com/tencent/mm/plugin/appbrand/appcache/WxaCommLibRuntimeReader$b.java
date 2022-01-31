package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Locale;

final class WxaCommLibRuntimeReader$b
  extends a
{
  private final WxaPkgWrappingInfo gTO;
  private final ao gVr;
  
  private WxaCommLibRuntimeReader$b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(59460);
    this.gTO = paramWxaPkgWrappingInfo;
    this.gVr = new ao(paramWxaPkgWrappingInfo.gUy);
    AppMethodBeat.o(59460);
  }
  
  public final WxaPkgWrappingInfo ave()
  {
    return this.gTO;
  }
  
  public final void init()
  {
    AppMethodBeat.i(59461);
    this.gVr.avO();
    AppMethodBeat.o(59461);
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(59462);
    this.gVr.avO();
    paramString = this.gVr.yw(paramString);
    AppMethodBeat.o(59462);
    return paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59463);
    String str = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[] { Integer.valueOf(this.gTO.gXf), avc() });
    AppMethodBeat.o(59463);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.b
 * JD-Core Version:    0.7.0.1
 */