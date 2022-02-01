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
  public int fWX;
  public int fXa;
  public String fXb;
  public String fvd;
  public String pcH;
  public int qJF;
  public String qJG;
  public AppBrandRecommendStatObj qJH;
  public Bundle qJI;
  public int scene;
  
  static
  {
    AppMethodBeat.i(123536);
    CREATOR = new AppBrandStatObject.1();
    AppMethodBeat.o(123536);
  }
  
  public AppBrandStatObject()
  {
    this.chatType = -1;
  }
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    AppMethodBeat.i(123535);
    this.chatType = -1;
    this.fXa = paramParcel.readInt();
    this.fXb = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fvd = paramParcel.readString();
    this.qJF = paramParcel.readInt();
    this.fWX = paramParcel.readInt();
    this.pcH = paramParcel.readString();
    this.qJH = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.qJG = paramParcel.readString();
    this.qJI = paramParcel.readBundle(getClass().getClassLoader());
    this.chatType = paramParcel.readInt();
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.fXa + ", preSceneNote='" + this.fXb + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.fvd + '\'' + ", usedState=" + this.qJF + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.fXa);
    paramParcel.writeString(this.fXb);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.fvd);
    paramParcel.writeInt(this.qJF);
    paramParcel.writeInt(this.fWX);
    paramParcel.writeString(this.pcH);
    paramParcel.writeParcelable(this.qJH, paramInt);
    paramParcel.writeString(this.qJG);
    paramParcel.writeBundle(this.qJI);
    paramParcel.writeInt(this.chatType);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */