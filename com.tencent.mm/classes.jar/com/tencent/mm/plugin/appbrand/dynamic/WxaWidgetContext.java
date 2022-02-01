package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int aVY();
  
  public abstract WxaPkgWrappingInfo bcj();
  
  public abstract WxaPkgWrappingInfo bck();
  
  public abstract int bcl();
  
  public abstract byte[] bcm();
  
  public abstract int bcn();
  
  public abstract DebuggerInfo bco();
  
  public abstract WidgetSysConfig bcp();
  
  public abstract WidgetRuntimeConfig bcq();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */