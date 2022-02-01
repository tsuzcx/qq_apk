package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public final String appId;
  public final String dki;
  public final String videoUrl;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.dki = paramString2;
    this.videoUrl = paramString3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197365);
    String str = "AppBrandPipEventBaseInfo{appId='" + this.appId + '\'' + ", pagePath='" + this.dki + '\'' + ", videoUrl='" + this.videoUrl + '\'' + '}';
    AppMethodBeat.o(197365);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.c
 * JD-Core Version:    0.7.0.1
 */