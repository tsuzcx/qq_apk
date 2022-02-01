package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
{
  public final String appId;
  public final String dbu;
  public final String videoUrl;
  
  public ag(String paramString1, String paramString2, String paramString3)
  {
    this.appId = paramString1;
    this.dbu = paramString2;
    this.videoUrl = paramString3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(176642);
    String str = "AppBrandPipEventBaseInfo{appId='" + this.appId + '\'' + ", pagePath='" + this.dbu + '\'' + ", videoUrl='" + this.videoUrl + '\'' + '}';
    AppMethodBeat.o(176642);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */