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
  public String coX;
  public String coY;
  public long coZ;
  public long cpa;
  public String groupId;
  public String md5;
  public String path;
  public String type;
  public String url;
  
  static
  {
    AppMethodBeat.i(258548);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(258548);
  }
  
  public final boolean No()
  {
    AppMethodBeat.i(258540);
    boolean bool = "debug".equalsIgnoreCase(this.type);
    AppMethodBeat.o(258540);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(258546);
    String str = "WxaLiteAppInfo{appId='" + this.appId + '\'' + ", groupId='" + this.groupId + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", signatureKey='" + this.coX + '\'' + ", path='" + this.path + '\'' + ", type='" + this.type + '\'' + ", patchId='" + this.coY + '\'' + ", updateTime=" + this.coZ + ", lastUseTime=" + this.cpa + '}';
    AppMethodBeat.o(258546);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(258542);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.coX);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.coY);
    paramParcel.writeLong(this.coZ);
    paramParcel.writeLong(this.cpa);
    AppMethodBeat.o(258542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.storage.WxaLiteAppInfo
 * JD-Core Version:    0.7.0.1
 */