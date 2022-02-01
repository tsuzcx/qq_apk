package com.tencent.liteapp.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppInfo> CREATOR;
  public String appId;
  public String egI;
  public String egJ;
  public long egK;
  public long egL;
  public String egM;
  public String egN = "";
  public String egO = "";
  public byte[] egP;
  public String groupId;
  public String md5;
  public String path;
  public String type;
  public String url;
  public String version;
  
  static
  {
    AppMethodBeat.i(219018);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(219018);
  }
  
  public final boolean anH()
  {
    AppMethodBeat.i(219021);
    boolean bool = "debug".equalsIgnoreCase(this.type);
    AppMethodBeat.o(219021);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219040);
    String str = "WxaLiteAppInfo{appId='" + this.appId + '\'' + ", groupId='" + this.groupId + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", signatureKey='" + this.egI + '\'' + ", path='" + this.path + '\'' + ", type='" + this.type + '\'' + ", patchId='" + this.egJ + '\'' + ", version='" + this.version + '\'' + ", minliteappversion='" + this.egM + '\'' + ", minlvcppversion='" + this.egN + '\'' + ", updateTime=" + this.egK + ", lastUseTime=" + this.egL + '}';
    AppMethodBeat.o(219040);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(219033);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.egI);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.egJ);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.egM);
    paramParcel.writeString(this.egN);
    paramParcel.writeLong(this.egK);
    paramParcel.writeLong(this.egL);
    paramParcel.writeByteArray(this.egP);
    AppMethodBeat.o(219033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.storage.WxaLiteAppInfo
 * JD-Core Version:    0.7.0.1
 */