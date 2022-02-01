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
  public int cIi;
  public int epc;
  public int euz;
  public int hAf;
  public String icon;
  public String mzg;
  public String name;
  public String qSb;
  public String qSc;
  public boolean qSl;
  public String username;
  
  static
  {
    AppMethodBeat.i(153213);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153213);
  }
  
  public AppBrandBackgroundRunningOperationParcel()
  {
    this.epc = -1;
    this.qSl = false;
  }
  
  protected AppBrandBackgroundRunningOperationParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(153210);
    this.epc = -1;
    this.qSl = false;
    this.appId = paramParcel.readString();
    this.euz = paramParcel.readInt();
    this.cIi = paramParcel.readInt();
    this.hAf = paramParcel.readInt();
    this.qSb = paramParcel.readString();
    this.name = paramParcel.readString();
    this.icon = paramParcel.readString();
    this.username = paramParcel.readString();
    this.mzg = paramParcel.readString();
    this.qSc = paramParcel.readString();
    this.epc = paramParcel.readInt();
    AppMethodBeat.o(153210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153211);
    String str = "operation{appId='" + this.appId + '\'' + ", versionType=" + this.euz + ", usage=" + this.cIi + ", operation=" + this.hAf + ", uiclass='" + this.qSb + '\'' + ", name='" + this.name + '\'' + ", icon='" + this.icon + '\'' + ", username='" + this.username + '\'' + ", process='" + this.mzg + '\'' + ", customNotificationLogicClassName='" + this.qSc + '\'' + ", justNotify=" + this.qSl + '}';
    AppMethodBeat.o(153211);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153212);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    paramParcel.writeInt(this.cIi);
    paramParcel.writeInt(this.hAf);
    paramParcel.writeString(this.qSb);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.mzg);
    paramParcel.writeString(this.qSc);
    paramParcel.writeInt(this.epc);
    AppMethodBeat.o(153212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel
 * JD-Core Version:    0.7.0.1
 */