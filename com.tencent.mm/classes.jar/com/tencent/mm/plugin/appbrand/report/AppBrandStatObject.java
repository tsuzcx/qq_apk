package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandStatObject
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandStatObject> CREATOR;
  public String dbt;
  public int dzQ;
  public int dzS;
  public String dzT;
  public String jYX;
  public int lpL;
  public String lpM;
  public AppBrandRecommendStatObj lpN;
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
    this.dzS = paramParcel.readInt();
    this.dzT = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.dbt = paramParcel.readString();
    this.lpL = paramParcel.readInt();
    this.dzQ = paramParcel.readInt();
    this.jYX = paramParcel.readString();
    this.lpN = ((AppBrandRecommendStatObj)paramParcel.readParcelable(AppBrandRecommendStatObj.class.getClassLoader()));
    this.lpM = paramParcel.readString();
    AppMethodBeat.o(123535);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123533);
    String str = "AppBrandStatObject{preScene=" + this.dzS + ", preSceneNote='" + this.dzT + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dbt + '\'' + ", usedState=" + this.lpL + '}';
    AppMethodBeat.o(123533);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123534);
    paramParcel.writeInt(this.dzS);
    paramParcel.writeString(this.dzT);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dbt);
    paramParcel.writeInt(this.lpL);
    paramParcel.writeInt(this.dzQ);
    paramParcel.writeString(this.jYX);
    paramParcel.writeParcelable(this.lpN, paramInt);
    paramParcel.writeString(this.lpM);
    AppMethodBeat.o(123534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandStatObject
 * JD-Core Version:    0.7.0.1
 */