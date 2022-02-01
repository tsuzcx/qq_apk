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
  public int chatType;
  public String hzx;
  public int icW;
  public int icZ;
  public String ida;
  public int scene;
  public String shW;
  public int tOj;
  public String tOk;
  public AppBrandRecommendStatObj tOl;
  public Bundle tOm;
  public int tOn;
  
  static
  {
    AppMethodBeat.i(123536);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123536);
  }
  
  public AppBrandStatObject()
  {
    this.chatType = -1;
    this.tOn = 0;
  }
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    AppMethodBeat.i(123535);
    this.chatType = -1;
    this.tOn = 0;
    this.icZ = paramParcel.readInt();
    this.ida = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.hzx = paramParcel.readString();
    this.tOj = paramParcel.readInt();
    this.icW = paramParcel.readInt();
    this.shW = paramParcel.readString();
    this.tOl = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.tOk = paramParcel.readString();
    this.tOm = paramParcel.readBundle(getClass().getClassLoader());
    this.chatType = paramParcel.readInt();
    this.tOn = paramParcel.readInt();
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.icZ + ", preSceneNote='" + this.ida + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.hzx + '\'' + ", usedState=" + this.tOj + '\'' + ", codeScene=" + this.tOn + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.icZ);
    paramParcel.writeString(this.ida);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.hzx);
    paramParcel.writeInt(this.tOj);
    paramParcel.writeInt(this.icW);
    paramParcel.writeString(this.shW);
    paramParcel.writeParcelable(this.tOl, paramInt);
    paramParcel.writeString(this.tOk);
    paramParcel.writeBundle(this.tOm);
    paramParcel.writeInt(this.chatType);
    paramParcel.writeInt(this.tOn);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */