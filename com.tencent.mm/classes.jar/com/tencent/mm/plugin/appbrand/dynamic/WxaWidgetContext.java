package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public abstract interface WxaWidgetContext
  extends Parcelable
{
  public abstract int cfM();
  
  public abstract WxaPkgWrappingInfo cnA();
  
  public abstract int cnB();
  
  public abstract byte[] cnC();
  
  public abstract int cnD();
  
  public abstract DebuggerInfo cnE();
  
  public abstract WidgetSysConfig cnF();
  
  public abstract WidgetRuntimeConfig cnG();
  
  public abstract WxaPkgWrappingInfo cnz();
  
  public abstract String getAppId();
  
  public abstract String getId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext
 * JD-Core Version:    0.7.0.1
 */