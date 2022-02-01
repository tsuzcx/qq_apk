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
  public String dEM;
  public int dlO;
  public int hSZ;
  public String jVi;
  public String jVj;
  public boolean jVs;
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
    this.jVs = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.jVs = false;
    this.appId = paramParcel.readString();
    this.hSZ = paramParcel.readInt();
    this.beO = paramParcel.readInt();
    this.dlO = paramParcel.readInt();
    this.jVi = paramParcel.readString();
    this.name = paramParcel.readString();
    this.dEM = paramParcel.readString();
    this.username = paramParcel.readString();
    this.process = paramParcel.readString();
    this.jVj = paramParcel.readString();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.hSZ + ", usage=" + this.beO + ", operation=" + this.dlO + ", uiclass='" + this.jVi + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.dEM + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.jVj + '\'' + ", justNotify=" + this.jVs + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hSZ);
    paramParcel.writeInt(this.beO);
    paramParcel.writeInt(this.dlO);
    paramParcel.writeString(this.jVi);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.dEM);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.jVj);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */