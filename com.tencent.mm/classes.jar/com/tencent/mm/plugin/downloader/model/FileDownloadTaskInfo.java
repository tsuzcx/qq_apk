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
  public int fGH;
  public long id;
  public String md5;
  public String path;
  public long rKZ;
  public int status;
  public long uih;
  public boolean uii;
  public boolean uij;
  public boolean uik;
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
    this.uih = 0L;
    this.rKZ = 0L;
    this.uii = false;
    this.fGH = 2;
    this.uij = false;
    this.uik = false;
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
    this.uih = 0L;
    this.rKZ = 0L;
    this.uii = false;
    this.fGH = 2;
    this.uij = false;
    this.uik = false;
    this.id = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.md5 = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.uih = paramParcel.readLong();
    this.rKZ = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.uii = bool1;
      this.fGH = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label205;
      }
      bool1 = true;
      label174:
      this.uij = bool1;
      if (paramParcel.readByte() != 1) {
        break label210;
      }
    }
    label205:
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uik = bool1;
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
    paramParcel.writeLong(this.uih);
    paramParcel.writeLong(this.rKZ);
    if (this.uii)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.fGH);
      if (!this.uij) {
        break label135;
      }
      paramInt = 1;
      label103:
      paramParcel.writeByte((byte)paramInt);
      if (!this.uik) {
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