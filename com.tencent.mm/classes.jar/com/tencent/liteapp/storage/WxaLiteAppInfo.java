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
  public String crh;
  public String cri;
  public long crj;
  public long crk;
  public String groupId;
  public String md5;
  public String path;
  public String type;
  public String url;
  
  static
  {
    AppMethodBeat.i(197718);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(197718);
  }
  
  public final boolean KB()
  {
    AppMethodBeat.i(197715);
    boolean bool = "debug".equalsIgnoreCase(this.type);
    AppMethodBeat.o(197715);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197717);
    String str = "WxaLiteAppInfo{appId='" + this.appId + '\'' + ", groupId='" + this.groupId + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", signatureKey='" + this.crh + '\'' + ", path='" + this.path + '\'' + ", type='" + this.type + '\'' + ", patchId='" + this.cri + '\'' + ", updateTime=" + this.crj + ", lastUseTime=" + this.crk + '}';
    AppMethodBeat.o(197717);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(197716);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.crh);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.cri);
    paramParcel.writeLong(this.crj);
    paramParcel.writeLong(this.crk);
    AppMethodBeat.o(197716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.storage.WxaLiteAppInfo
 * JD-Core Version:    0.7.0.1
 */