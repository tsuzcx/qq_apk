package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract WxaPkgWrappingInfo bBO();
  
  public abstract WxaPkgWrappingInfo bBP();
  
  public abstract int bBQ();
  
  public abstract byte[] bBR();
  
  public abstract int bBS();
  
  public abstract DebuggerInfo bBT();
  
  public abstract WidgetSysConfig bBU();
  
  public abstract WidgetRuntimeConfig bBV();
  
  public abstract int bvh();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */