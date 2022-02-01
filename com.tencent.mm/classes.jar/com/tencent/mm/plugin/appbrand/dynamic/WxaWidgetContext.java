package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int bGn();
  
  public abstract WxaPkgWrappingInfo bNk();
  
  public abstract WxaPkgWrappingInfo bNl();
  
  public abstract int bNm();
  
  public abstract byte[] bNn();
  
  public abstract int bNo();
  
  public abstract DebuggerInfo bNp();
  
  public abstract WidgetSysConfig bNq();
  
  public abstract WidgetRuntimeConfig bNr();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */