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
  public int beO;
  public String dDH;
  public int dkM;
  public int hQh;
  public String jRQ;
  public String jRR;
  public boolean jSb;
  public String name;
  public String process;
  public String username;
  
  static
  {
    AppMethodBeat.i(153213);
    CREATOR = new AppBrandBackgroundRunningOperationParcel.1();
    AppMethodBeat.o(153213);
  }
  
  public AppBrandBackgroundRunningOperationParcel()
  {
    this.jSb = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.jSb = false;
    this.appId = paramParcel.readString();
    this.hQh = paramParcel.readInt();
    this.beO = paramParcel.readInt();
    this.dkM = paramParcel.readInt();
    this.jRQ = paramParcel.readString();
    this.name = paramParcel.readString();
    this.dDH = paramParcel.readString();
    this.username = paramParcel.readString();
    this.process = paramParcel.readString();
    this.jRR = paramParcel.readString();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.hQh + ", usage=" + this.beO + ", operation=" + this.dkM + ", uiclass='" + this.jRQ + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.dDH + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.jRR + '\'' + ", justNotify=" + this.jSb + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hQh);
    paramParcel.writeInt(this.beO);
    paramParcel.writeInt(this.dkM);
    paramParcel.writeString(this.jRQ);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.dDH);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.jRR);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */