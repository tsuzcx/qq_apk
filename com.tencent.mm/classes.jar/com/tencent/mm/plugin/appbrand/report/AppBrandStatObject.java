package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR;
  public int dJO;
  public int dJQ;
  public String dJR;
  public String dkh;
  public String kVU;
  public Bundle mrA;
  public int mrx;
  public String mry;
  public AppBrandRecommendStatObj mrz;
  public int scene;
  
  static
  {
    AppMethodBeat.i(123536);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123536);
  }
  
  public AppBrandStatObject() {}
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    AppMethodBeat.i(123535);
    this.dJQ = paramParcel.readInt();
    this.dJR = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.dkh = paramParcel.readString();
    this.mrx = paramParcel.readInt();
    this.dJO = paramParcel.readInt();
    this.kVU = paramParcel.readString();
    this.mrz = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.mry = paramParcel.readString();
    this.mrA = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.dJQ + ", preSceneNote='" + this.dJR + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dkh + '\'' + ", usedState=" + this.mrx + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.dJQ);
    paramParcel.writeString(this.dJR);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dkh);
    paramParcel.writeInt(this.mrx);
    paramParcel.writeInt(this.dJO);
    paramParcel.writeString(this.kVU);
    paramParcel.writeParcelable(this.mrz, paramInt);
    paramParcel.writeString(this.mry);
    paramParcel.writeBundle(this.mrA);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */