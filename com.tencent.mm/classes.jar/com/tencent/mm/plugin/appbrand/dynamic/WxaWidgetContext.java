package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int abp();
  
  public abstract WxaPkgWrappingInfo afa();
  
  public abstract WxaPkgWrappingInfo afb();
  
  public abstract int afc();
  
  public abstract byte[] afd();
  
  public abstract int afe();
  
  public abstract DebuggerInfo aff();
  
  public abstract WidgetSysConfig afg();
  
  public abstract WidgetRuntimeConfig afh();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */