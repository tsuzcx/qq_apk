package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int aPg();
  
  public abstract WxaPkgWrappingInfo aVl();
  
  public abstract WxaPkgWrappingInfo aVm();
  
  public abstract int aVn();
  
  public abstract byte[] aVo();
  
  public abstract int aVp();
  
  public abstract DebuggerInfo aVq();
  
  public abstract WidgetSysConfig aVr();
  
  public abstract WidgetRuntimeConfig aVs();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */