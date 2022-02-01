package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FileDownloadTaskInfo
  implements Parcelable
{
  public static Parcelable.Creator<FileDownloadTaskInfo> CREATOR;
  public String appId;
  public int dvO;
  public long id;
  public String md5;
  public long nyl;
  public String path;
  public long ptA;
  public boolean ptB;
  public boolean ptC;
  public boolean ptD;
  public int status;
  public String url;
  
  static
  {
    AppMethodBeat.i(89014);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(89014);
  }
  
  public FileDownloadTaskInfo()
  {
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.md5 = "";
    this.appId = "";
    this.ptA = 0L;
    this.nyl = 0L;
    this.ptB = false;
    this.dvO = 2;
    this.ptC = false;
    this.ptD = false;
  }
  
  private FileDownloadTaskInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(89013);
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.md5 = "";
    this.appId = "";
    this.ptA = 0L;
    this.nyl = 0L;
    this.ptB = false;
    this.dvO = 2;
    this.ptC = false;
    this.ptD = false;
    this.id = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.ptA = paramParcel.readLong();
    this.nyl = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.ptB = bool1;
      this.dvO = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label205;
      }
      bool1 = true;
      label174:
      this.ptC = bool1;
      if (paramParcel.readByte() != 1) {
        break label210;
      }
    }
    label205:
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ptD = bool1;
      AppMethodBeat.o(89013);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label174;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(89012);
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.ptA);
    paramParcel.writeLong(this.nyl);
    if (this.ptB)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.dvO);
      if (!this.ptC) {
        break label135;
      }
      paramInt = 1;
      label103:
      paramParcel.writeByte((byte)paramInt);
      if (!this.ptD) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(89012);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label103;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */