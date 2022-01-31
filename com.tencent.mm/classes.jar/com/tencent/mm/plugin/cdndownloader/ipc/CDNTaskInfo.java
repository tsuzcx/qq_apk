package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CDNTaskInfo> CREATOR = new CDNTaskInfo.1();
  public String bUi;
  public boolean dlW;
  public String downloadUrl;
  public String filePath;
  public String iAH;
  public String iAI;
  public int iAJ;
  public int iAK;
  public boolean iAL;
  public boolean iAM;
  public boolean iAN;
  
  public CDNTaskInfo() {}
  
  private CDNTaskInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.dlW = bool1;
      this.downloadUrl = paramParcel.readString();
      this.bUi = paramParcel.readString();
      this.filePath = paramParcel.readString();
      this.iAH = paramParcel.readString();
      this.iAI = paramParcel.readString();
      this.iAJ = paramParcel.readInt();
      this.iAK = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label113;
      }
      bool1 = true;
      label87:
      this.iAL = bool1;
      if (paramParcel.readByte() != 1) {
        break label118;
      }
    }
    label113:
    label118:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.iAN = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label87;
    }
  }
  
  public CDNTaskInfo(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || ((paramObject != null) && ((paramObject instanceof CDNTaskInfo)) && (((CDNTaskInfo)paramObject).downloadUrl.equals(this.downloadUrl)));
  }
  
  public int hashCode()
  {
    return this.downloadUrl.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.dlW)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.bUi);
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.iAH);
      paramParcel.writeString(this.iAI);
      paramParcel.writeInt(this.iAJ);
      paramParcel.writeInt(this.iAK);
      if (!this.iAL) {
        break label108;
      }
      b1 = 1;
      label82:
      paramParcel.writeByte(b1);
      if (!this.iAN) {
        break label113;
      }
    }
    label108:
    label113:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
 * JD-Core Version:    0.7.0.1
 */