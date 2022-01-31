package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR = new AppBrandStatObject.1();
  public String bFv;
  public int caA;
  public int caB;
  public String caC;
  public int gXG;
  public String gxg;
  public int scene;
  
  public AppBrandStatObject() {}
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    this.caB = paramParcel.readInt();
    this.caC = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.bFv = paramParcel.readString();
    this.gXG = paramParcel.readInt();
    this.caA = paramParcel.readInt();
    this.gxg = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "AppBrandStatObject{preScene=" + this.caB + ", preSceneNote='" + this.caC + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.bFv + '\'' + ", usedState=" + this.gXG + '}';
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.caB);
    paramParcel.writeString(this.caC);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.bFv);
    paramParcel.writeInt(this.gXG);
    paramParcel.writeInt(this.caA);
    paramParcel.writeString(this.gxg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */