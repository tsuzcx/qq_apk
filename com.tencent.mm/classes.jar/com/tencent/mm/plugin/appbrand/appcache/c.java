package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class c
  extends a
{
  public static final c gTP;
  final WxaPkgWrappingInfo gTO;
  
  static
  {
    AppMethodBeat.i(114304);
    gTP = new c();
    AppMethodBeat.o(114304);
  }
  
  public c()
  {
    AppMethodBeat.i(114303);
    this.gTO = new WxaPkgWrappingInfo();
    this.gTO.gXh = true;
    this.gTO.gXe = 0;
    this.gTO.gXf = an.VERSION;
    this.gTO.cqq = "";
    AppMethodBeat.o(114303);
  }
  
  public final WxaPkgWrappingInfo ave()
  {
    return this.gTO;
  }
  
  public final void init() {}
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(114302);
    paramString = an.openRead(paramString);
    AppMethodBeat.o(114302);
    return paramString;
  }
  
  public final String toString()
  {
    return "AssetReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.c
 * JD-Core Version:    0.7.0.1
 */