package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundRunningOperationParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundRunningOperationParcel> CREATOR;
  public int aTC;
  public String appId;
  public int dbV;
  public String dub;
  public int gXn;
  public String iXE;
  public String iXF;
  public boolean iXO;
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
    this.iXO = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.iXO = false;
    this.appId = paramParcel.readString();
    this.gXn = paramParcel.readInt();
    this.aTC = paramParcel.readInt();
    this.dbV = paramParcel.readInt();
    this.iXE = paramParcel.readString();
    this.name = paramParcel.readString();
    this.dub = paramParcel.readString();
    this.username = paramParcel.readString();
    this.process = paramParcel.readString();
    this.iXF = paramParcel.readString();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.gXn + ", usage=" + this.aTC + ", operation=" + this.dbV + ", uiclass='" + this.iXE + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.dub + '\'' + ", username='" + this.username + '\'' + ", process='" + this.process + '\'' + ", customNotificationLogicClassName='" + this.iXF + '\'' + ", justNotify=" + this.iXO + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.gXn);
    paramParcel.writeInt(this.aTC);
    paramParcel.writeInt(this.dbV);
    paramParcel.writeString(this.iXE);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.dub);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.process);
    paramParcel.writeString(this.iXF);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */