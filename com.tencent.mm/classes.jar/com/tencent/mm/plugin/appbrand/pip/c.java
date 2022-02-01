package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public final String appId;
  public final String cYQ;
  public final String videoUrl;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.cYQ = paramString2;
    this.videoUrl = paramString3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193448);
    String str = "AppBrandPipEventBaseInfo{appId='" + this.appId + '\'' + ", pagePath='" + this.cYQ + '\'' + ", videoUrl='" + this.videoUrl + '\'' + '}';
    AppMethodBeat.o(193448);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.c
 * JD-Core Version:    0.7.0.1
 */