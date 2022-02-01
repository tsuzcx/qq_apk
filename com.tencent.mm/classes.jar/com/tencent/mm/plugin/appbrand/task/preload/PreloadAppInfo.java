package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

class PreloadAppInfo
{
  private static final String TAG = "PreloadAppInfo";
  String appId;
  int appType;
  float openRate;
  String path;
  
  public String toString()
  {
    AppMethodBeat.i(48509);
    String str = String.format("preloadAppInfo appId:%s,appType:%d,path:%s,openRate:%f", new Object[] { this.appId, Integer.valueOf(this.appType), this.path, Float.valueOf(this.openRate) });
    AppMethodBeat.o(48509);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.PreloadAppInfo
 * JD-Core Version:    0.7.0.1
 */