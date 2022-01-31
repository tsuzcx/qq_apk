package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import junit.framework.Assert;

class WxaWidgetInitializer$WxaWidgetContextImpl
  implements WxaWidgetContext
{
  public static final Parcelable.Creator<WxaWidgetContextImpl> CREATOR = new WxaWidgetInitializer.WxaWidgetContextImpl.1();
  String dIX;
  WxaPkgWrappingInfo fUm;
  WxaPkgWrappingInfo fUn;
  byte[] fUo;
  int fUp;
  DebuggerInfo fUq;
  WidgetSysConfig fUr;
  WidgetRuntimeConfig fUs;
  String mAppId;
  
  public WxaWidgetInitializer$WxaWidgetContextImpl(Parcel paramParcel)
  {
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.dIX = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.fUn = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
    this.fUm = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
    this.fUo = paramParcel.createByteArray();
    this.fUp = paramParcel.readInt();
    this.fUq = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
    this.fUr = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
    this.fUs = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
  }
  
  public WxaWidgetInitializer$WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
  {
    Assert.assertNotNull(paramWxaPkgWrappingInfo1);
    Assert.assertNotNull(paramWxaPkgWrappingInfo2);
    this.fUn = paramWxaPkgWrappingInfo1;
    this.fUm = paramWxaPkgWrappingInfo2;
  }
  
  public final int abp()
  {
    if (this.fUm != null) {
      return this.fUm.fEM;
    }
    return 0;
  }
  
  public final WxaPkgWrappingInfo afa()
  {
    return this.fUm;
  }
  
  public final WxaPkgWrappingInfo afb()
  {
    return this.fUn;
  }
  
  public final int afc()
  {
    if (this.fUm != null) {
      return this.fUm.fEN;
    }
    return 0;
  }
  
  public final byte[] afd()
  {
    return this.fUo;
  }
  
  public final int afe()
  {
    return this.fUp;
  }
  
  public final DebuggerInfo aff()
  {
    return this.fUq;
  }
  
  public final WidgetSysConfig afg()
  {
    return this.fUr;
  }
  
  public final WidgetRuntimeConfig afh()
  {
    return this.fUs;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final String getId()
  {
    return this.dIX;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dIX);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeParcelable(this.fUn, paramInt);
    paramParcel.writeParcelable(this.fUm, paramInt);
    paramParcel.writeByteArray(this.fUo);
    paramParcel.writeInt(this.fUp);
    paramParcel.writeParcelable(this.fUq, paramInt);
    paramParcel.writeParcelable(this.fUr, paramInt);
    paramParcel.writeParcelable(this.fUs, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.WxaWidgetContextImpl
 * JD-Core Version:    0.7.0.1
 */