package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

class ModularizingPkgRetrieverWC$WxaPkgResultProgressPair
  implements Parcelable
{
  public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
  WxaPkgWrappingInfo imm;
  WxaPkgLoadProgress imn;
  private ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.a imo;
  
  static
  {
    AppMethodBeat.i(131942);
    CREATOR = new ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.1();
    AppMethodBeat.o(131942);
  }
  
  ModularizingPkgRetrieverWC$WxaPkgResultProgressPair(Parcel paramParcel)
  {
    AppMethodBeat.i(131940);
    this.imm = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
    this.imn = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
    this.imo = ((ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.a)paramParcel.readSerializable());
    AppMethodBeat.o(131940);
  }
  
  ModularizingPkgRetrieverWC$WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    this.imn = paramWxaPkgLoadProgress;
    this.imo = ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.a.imq;
  }
  
  ModularizingPkgRetrieverWC$WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    this.imm = paramWxaPkgWrappingInfo;
    this.imo = ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.a.imp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131941);
    paramParcel.writeParcelable(this.imm, paramInt);
    paramParcel.writeParcelable(this.imn, paramInt);
    paramParcel.writeSerializable(this.imo);
    AppMethodBeat.o(131941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.WxaPkgResultProgressPair
 * JD-Core Version:    0.7.0.1
 */