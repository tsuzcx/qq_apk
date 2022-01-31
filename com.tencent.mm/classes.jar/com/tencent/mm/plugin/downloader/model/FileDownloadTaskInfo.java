package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileDownloadTaskInfo
  implements Parcelable
{
  public static Parcelable.Creator<FileDownloadTaskInfo> CREATOR = new FileDownloadTaskInfo.1();
  public String appId = "";
  public String bIW = "";
  public int bOz = 2;
  public long hFz = 0L;
  public long iPM = 0L;
  public boolean iPN = false;
  public boolean iPO = false;
  public long id = -1L;
  public String path = "";
  public int status = 0;
  public String url = "";
  
  public FileDownloadTaskInfo() {}
  
  private FileDownloadTaskInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.bIW = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iPM = paramParcel.readLong();
    this.hFz = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.iPN = bool;
      this.bOz = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.bIW);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.iPM);
    paramParcel.writeLong(this.hFz);
    if (this.iPN) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.bOz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */