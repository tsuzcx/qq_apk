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
  public int dLd;
  public int dLf;
  public String dLg;
  public String dlj;
  public String kZC;
  public int mwv;
  public String mww;
  public AppBrandRecommendStatObj mwx;
  public Bundle mwy;
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
    this.dLf = paramParcel.readInt();
    this.dLg = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.dlj = paramParcel.readString();
    this.mwv = paramParcel.readInt();
    this.dLd = paramParcel.readInt();
    this.kZC = paramParcel.readString();
    this.mwx = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.mww = paramParcel.readString();
    this.mwy = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.dLf + ", preSceneNote='" + this.dLg + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dlj + '\'' + ", usedState=" + this.mwv + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.dLf);
    paramParcel.writeString(this.dLg);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dlj);
    paramParcel.writeInt(this.mwv);
    paramParcel.writeInt(this.dLd);
    paramParcel.writeString(this.kZC);
    paramParcel.writeParcelable(this.mwx, paramInt);
    paramParcel.writeString(this.mww);
    paramParcel.writeBundle(this.mwy);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */