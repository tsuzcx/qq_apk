package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

class RuntimeLoadModuleTask$WxaPkgResultProgressPair
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR = new RuntimeLoadModuleTask.WxaPkgResultProgressPair.1();
  WxaPkgWrappingInfo gLI;
  WxaPkgLoadProgress gLJ;
  private RuntimeLoadModuleTask.WxaPkgResultProgressPair.a gLK;
  
  RuntimeLoadModuleTask$WxaPkgResultProgressPair(Parcel paramParcel)
  {
    this.gLI = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
    this.gLJ = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
    this.gLK = ((RuntimeLoadModuleTask.WxaPkgResultProgressPair.a)paramParcel.readSerializable());
  }
  
  RuntimeLoadModuleTask$WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    this.gLJ = paramWxaPkgLoadProgress;
    this.gLK = RuntimeLoadModuleTask.WxaPkgResultProgressPair.a.gLM;
  }
  
  RuntimeLoadModuleTask$WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.gLI = paramWxaPkgWrappingInfo;
    this.gLK = RuntimeLoadModuleTask.WxaPkgResultProgressPair.a.gLL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.gLI, paramInt);
    paramParcel.writeParcelable(this.gLJ, paramInt);
    paramParcel.writeSerializable(this.gLK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.WxaPkgResultProgressPair
 * JD-Core Version:    0.7.0.1
 */