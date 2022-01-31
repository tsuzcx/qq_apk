package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import junit.framework.Assert;

class WxaWidgetInitializer$WxaWidgetContextImpl
  implements WxaWidgetContext
{
  public static final Parcelable.Creator<WxaWidgetContextImpl> CREATOR;
  String equ;
  WxaPkgWrappingInfo hnO;
  WxaPkgWrappingInfo hnP;
  byte[] hnQ;
  int hnR;
  DebuggerInfo hnS;
  WidgetSysConfig hnT;
  WidgetRuntimeConfig hnU;
  String mAppId;
  
  static
  {
    AppMethodBeat.i(10723);
    CREATOR = new WxaWidgetInitializer.WxaWidgetContextImpl.1();
    AppMethodBeat.o(10723);
  }
  
  public WxaWidgetInitializer$WxaWidgetContextImpl(Parcel paramParcel)
  {
    AppMethodBeat.i(10720);
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.equ = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.hnP = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
    this.hnO = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
    this.hnQ = paramParcel.createByteArray();
    this.hnR = paramParcel.readInt();
    this.hnS = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
    this.hnT = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
    this.hnU = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
    AppMethodBeat.o(10720);
  }
  
  public WxaWidgetInitializer$WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
  {
    AppMethodBeat.i(10721);
    Assert.assertNotNull(paramWxaPkgWrappingInfo1);
    Assert.assertNotNull(paramWxaPkgWrappingInfo2);
    this.hnP = paramWxaPkgWrappingInfo1;
    this.hnO = paramWxaPkgWrappingInfo2;
    AppMethodBeat.o(10721);
  }
  
  public final int avf()
  {
    if (this.hnO != null) {
      return this.hnO.gXe;
    }
    return 0;
  }
  
  public final WxaPkgWrappingInfo azE()
  {
    return this.hnO;
  }
  
  public final WxaPkgWrappingInfo azF()
  {
    return this.hnP;
  }
  
  public final int azG()
  {
    if (this.hnO != null) {
      return this.hnO.gXf;
    }
    return 0;
  }
  
  public final byte[] azH()
  {
    return this.hnQ;
  }
  
  public final int azI()
  {
    return this.hnR;
  }
  
  public final DebuggerInfo azJ()
  {
    return this.hnS;
  }
  
  public final WidgetSysConfig azK()
  {
    return this.hnT;
  }
  
  public final WidgetRuntimeConfig azL()
  {
    return this.hnU;
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
    return this.equ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10722);
    paramParcel.writeString(this.equ);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeParcelable(this.hnP, paramInt);
    paramParcel.writeParcelable(this.hnO, paramInt);
    paramParcel.writeByteArray(this.hnQ);
    paramParcel.writeInt(this.hnR);
    paramParcel.writeParcelable(this.hnS, paramInt);
    paramParcel.writeParcelable(this.hnT, paramInt);
    paramParcel.writeParcelable(this.hnU, paramInt);
    AppMethodBeat.o(10722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.WxaWidgetContextImpl
 * JD-Core Version:    0.7.0.1
 */