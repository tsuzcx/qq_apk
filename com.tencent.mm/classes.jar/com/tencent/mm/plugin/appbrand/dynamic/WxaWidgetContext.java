package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int aZt();
  
  public abstract WxaPkgWrappingInfo bfN();
  
  public abstract WxaPkgWrappingInfo bfO();
  
  public abstract int bfP();
  
  public abstract byte[] bfQ();
  
  public abstract int bfR();
  
  public abstract DebuggerInfo bfS();
  
  public abstract WidgetSysConfig bfT();
  
  public abstract WidgetRuntimeConfig bfU();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */