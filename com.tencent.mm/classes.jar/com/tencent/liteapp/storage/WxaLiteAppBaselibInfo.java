package com.tencent.liteapp.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppBaselibInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppBaselibInfo> CREATOR;
  public String egH;
  public String egI;
  public String egJ;
  public long egK;
  public long egL;
  public String md5;
  public String path;
  public String type;
  public String url;
  
  static
  {
    AppMethodBeat.i(219022);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(219022);
  }
  
  public final boolean anH()
  {
    AppMethodBeat.i(219028);
    boolean bool = "debug".equalsIgnoreCase(this.type);
    AppMethodBeat.o(219028);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219047);
    String str = "WxaLiteAppBaseLibInfo{majorVersion='" + this.egH + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", signatureKey='" + this.egI + '\'' + ", path='" + this.path + '\'' + ", type='" + this.type + '\'' + ", patchId='" + this.egJ + '\'' + ", updateTime=" + this.egK + ", lastUseTime=" + this.egL + '}';
    AppMethodBeat.o(219047);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(219038);
    paramParcel.writeString(this.egH);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.egI);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.egJ);
    paramParcel.writeLong(this.egK);
    paramParcel.writeLong(this.egL);
    AppMethodBeat.o(219038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.storage.WxaLiteAppBaselibInfo
 * JD-Core Version:    0.7.0.1
 */