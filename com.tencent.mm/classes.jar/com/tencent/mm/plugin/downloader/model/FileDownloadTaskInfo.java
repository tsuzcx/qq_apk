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
  public String cqq;
  public int cvQ;
  public long id;
  public long jyU;
  public long kYX;
  public boolean kYY;
  public boolean kYZ;
  public boolean kZa;
  public String path;
  public int status;
  public String url;
  
  static
  {
    AppMethodBeat.i(2449);
    CREATOR = new FileDownloadTaskInfo.1();
    AppMethodBeat.o(2449);
  }
  
  public FileDownloadTaskInfo()
  {
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.cqq = "";
    this.appId = "";
    this.kYX = 0L;
    this.jyU = 0L;
    this.kYY = false;
    this.cvQ = 2;
    this.kYZ = false;
    this.kZa = false;
  }
  
  private FileDownloadTaskInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(2448);
    this.id = -1L;
    this.url = "";
    this.status = 0;
    this.path = "";
    this.cqq = "";
    this.appId = "";
    this.kYX = 0L;
    this.jyU = 0L;
    this.kYY = false;
    this.cvQ = 2;
    this.kYZ = false;
    this.kZa = false;
    this.id = paramParcel.readLong();
    this.url = paramParcel.readString();
    this.status = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.cqq = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.kYX = paramParcel.readLong();
    this.jyU = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.kYY = bool1;
      this.cvQ = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label207;
      }
      bool1 = true;
      label175:
      this.kYZ = bool1;
      if (paramParcel.readByte() != 1) {
        break label212;
      }
    }
    label207:
    label212:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kZa = bool1;
      AppMethodBeat.o(2448);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label175;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(2447);
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.status);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.cqq);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.kYX);
    paramParcel.writeLong(this.jyU);
    if (this.kYY)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.cvQ);
      if (!this.kYZ) {
        break label137;
      }
      paramInt = 1;
      label104:
      paramParcel.writeByte((byte)paramInt);
      if (!this.kZa) {
        break label142;
      }
    }
    label137:
    label142:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(2447);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo
 * JD-Core Version:    0.7.0.1
 */