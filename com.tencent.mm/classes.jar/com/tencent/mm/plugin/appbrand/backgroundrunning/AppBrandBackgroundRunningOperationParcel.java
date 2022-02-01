package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundRunningOperationParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundRunningOperationParcel> CREATOR;
  public int aUu;
  public String appId;
  public int cZu;
  public String drM;
  public int hxM;
  public String jxU;
  public String jxV;
  public boolean jye;
  public String name;
  public String process;
  public String username;
  
  static
  {
    AppMethodBeat.i(153213);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153213);
  }
  
  public AppBrandBackgroundRunningOperationParcel()
  {
    this.jye = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.jye = false;
    this.appId = paramParcel.readString();
    this.hxM = paramParcel.readInt();
    this.aUu = paramParcel.readInt();
    this.cZu = paramParcel.readInt();
    this.jxU = paramParcel.readString();
    this.name = paramParcel.readString();
    this.drM = paramParcel.readString();
    this.username = paramParcel.readString();
    this.process = paramParcel.readString();
    this.jxV = paramParcel.readString();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.hxM + ", usage=" + this.aUu + ", operation=" + this.cZu + ", uiclass='" + this.jxU + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.drM + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.jxV + '\'' + ", justNotify=" + this.jye + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hxM);
    paramParcel.writeInt(this.aUu);
    paramParcel.writeInt(this.cZu);
    paramParcel.writeString(this.jxU);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.drM);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.jxV);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */