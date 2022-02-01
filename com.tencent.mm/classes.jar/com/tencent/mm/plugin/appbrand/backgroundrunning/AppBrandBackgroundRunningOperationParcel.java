package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundRunningOperationParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundRunningOperationParcel> CREATOR;
  public int aOm;
  public String appId;
  public int cBU;
  public int cxa;
  public int fvK;
  public String icon;
  public String jZi;
  public boolean nSA;
  public String nSq;
  public String nSr;
  public String name;
  public String username;
  
  static
  {
    AppMethodBeat.i(153213);
    CREATOR = new AppBrandBackgroundRunningOperationParcel.1();
    AppMethodBeat.o(153213);
  }
  
  public AppBrandBackgroundRunningOperationParcel()
  {
    this.cxa = -1;
    this.nSA = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.cxa = -1;
    this.nSA = false;
    this.appId = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.aOm = paramParcel.readInt();
    this.fvK = paramParcel.readInt();
    this.nSq = paramParcel.readString();
    this.name = paramParcel.readString();
    this.icon = paramParcel.readString();
    this.username = paramParcel.readString();
    this.jZi = paramParcel.readString();
    this.nSr = paramParcel.readString();
    this.cxa = paramParcel.readInt();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.cBU + ", usage=" + this.aOm + ", operation=" + this.fvK + ", uiclass='" + this.nSq + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.icon + '\'' + ", username='" + this.username + '\'' + ", process='" + this.jZi + '\'' + ", customNotificationLogicClassName='" + this.nSr + '\'' + ", justNotify=" + this.nSA + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeInt(this.aOm);
    paramParcel.writeInt(this.fvK);
    paramParcel.writeString(this.nSq);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.jZi);
    paramParcel.writeString(this.nSr);
    paramParcel.writeInt(this.cxa);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */