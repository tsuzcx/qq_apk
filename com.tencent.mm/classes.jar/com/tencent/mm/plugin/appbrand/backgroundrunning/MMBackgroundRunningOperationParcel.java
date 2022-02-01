package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMBackgroundRunningOperationParcel
  implements Parcelable
{
  public static final Parcelable.Creator<MMBackgroundRunningOperationParcel> CREATOR;
  public String appId;
  public int beO;
  public int dlO;
  
  static
  {
    AppMethodBeat.i(153218);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153218);
  }
  
  public MMBackgroundRunningOperationParcel() {}
  
  protected MMBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153215);
    this.appId = paramParcel.readString();
    this.beO = paramParcel.readInt();
    this.dlO = paramParcel.readInt();
    AppMethodBeat.o(153215);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153216);
    String str = "operation{appId='" + this.appId + '\'' + ", usage=" + this.beO + ", operation=" + this.dlO + '}';
    AppMethodBeat.o(153216);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153217);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.beO);
    paramParcel.writeInt(this.dlO);
    AppMethodBeat.o(153217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */