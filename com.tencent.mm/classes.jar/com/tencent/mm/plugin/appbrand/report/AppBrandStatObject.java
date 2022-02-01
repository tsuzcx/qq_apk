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
  public String dCw;
  public int ecS;
  public int ecU;
  public String ecV;
  public String meP;
  public int nHt;
  public String nHu;
  public AppBrandRecommendStatObj nHv;
  public Bundle nHw;
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
    this.ecU = paramParcel.readInt();
    this.ecV = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.dCw = paramParcel.readString();
    this.nHt = paramParcel.readInt();
    this.ecS = paramParcel.readInt();
    this.meP = paramParcel.readString();
    this.nHv = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.nHu = paramParcel.readString();
    this.nHw = paramParcel.readBundle(getClass().getClassLoader());
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", usedState=" + this.nHt + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.ecU);
    paramParcel.writeString(this.ecV);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dCw);
    paramParcel.writeInt(this.nHt);
    paramParcel.writeInt(this.ecS);
    paramParcel.writeString(this.meP);
    paramParcel.writeParcelable(this.nHv, paramInt);
    paramParcel.writeString(this.nHu);
    paramParcel.writeBundle(this.nHw);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */