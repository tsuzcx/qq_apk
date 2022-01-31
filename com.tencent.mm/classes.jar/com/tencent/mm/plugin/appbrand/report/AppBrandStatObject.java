package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR;
  public int cIZ;
  public int cJb;
  public String cJc;
  public String cmF;
  public String hST;
  public int iFX;
  public AppBrandRecommendStatObj iFY;
  public int scene;
  
  static
  {
    AppMethodBeat.i(96188);
    CREATOR = new AppBrandStatObject.1();
    AppMethodBeat.o(96188);
  }
  
  public AppBrandStatObject() {}
  
  protected AppBrandStatObject(Parcel paramParcel)
  {
    AppMethodBeat.i(96187);
    this.cJb = paramParcel.readInt();
    this.cJc = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.cmF = paramParcel.readString();
    this.iFX = paramParcel.readInt();
    this.cIZ = paramParcel.readInt();
    this.hST = paramParcel.readString();
    this.iFY = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    AppMethodBeat.o(96187);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(96185);
    String str = "AppBrandStatObject{preScene=" + this.cJb + ", preSceneNote='" + this.cJc + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cmF + '\'' + ", usedState=" + this.iFX + '}';
    AppMethodBeat.o(96185);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96186);
    paramParcel.writeInt(this.cJb);
    paramParcel.writeString(this.cJc);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.cmF);
    paramParcel.writeInt(this.iFX);
    paramParcel.writeInt(this.cIZ);
    paramParcel.writeString(this.hST);
    paramParcel.writeParcelable(this.iFY, paramInt);
    AppMethodBeat.o(96186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */