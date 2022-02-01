package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR;
  public String cYP;
  public int dxC;
  public int dxE;
  public String dxF;
  public String kzK;
  public int lRH;
  public String lRI;
  public AppBrandRecommendStatObj lRJ;
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
    this.dxE = paramParcel.readInt();
    this.dxF = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.cYP = paramParcel.readString();
    this.lRH = paramParcel.readInt();
    this.dxC = paramParcel.readInt();
    this.kzK = paramParcel.readString();
    this.lRJ = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.lRI = paramParcel.readString();
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.dxE + ", preSceneNote='" + this.dxF + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cYP + '\'' + ", usedState=" + this.lRH + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.dxE);
    paramParcel.writeString(this.dxF);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.cYP);
    paramParcel.writeInt(this.lRH);
    paramParcel.writeInt(this.dxC);
    paramParcel.writeString(this.kzK);
    paramParcel.writeParcelable(this.lRJ, paramInt);
    paramParcel.writeString(this.lRI);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */