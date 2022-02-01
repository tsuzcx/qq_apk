package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundRunningOperationParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundRunningOperationParcel> CREATOR;
  public String appId;
  public int beL;
  public int dDe;
  public int iOo;
  public String icon;
  public String kYe;
  public String kYf;
  public boolean kYo;
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
    this.kYo = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.kYo = false;
    this.appId = paramParcel.readString();
    this.iOo = paramParcel.readInt();
    this.beL = paramParcel.readInt();
    this.dDe = paramParcel.readInt();
    this.kYe = paramParcel.readString();
    this.name = paramParcel.readString();
    this.icon = paramParcel.readString();
    this.username = paramParcel.readString();
    this.process = paramParcel.readString();
    this.kYf = paramParcel.readString();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.iOo + ", usage=" + this.beL + ", operation=" + this.dDe + ", uiclass='" + this.kYe + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.icon + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.kYf + '\'' + ", justNotify=" + this.kYo + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iOo);
    paramParcel.writeInt(this.beL);
    paramParcel.writeInt(this.dDe);
    paramParcel.writeString(this.kYe);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.kYf);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */