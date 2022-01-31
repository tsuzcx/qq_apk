package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CDNTaskInfo> CREATOR;
  public String cBO;
  public String downloadUrl;
  public boolean edy;
  public String filePath;
  public String kDN;
  public String kDO;
  public int kDP;
  public int kDQ;
  public boolean kDR;
  public boolean kDS;
  public boolean kDT;
  
  static
  {
    AppMethodBeat.i(928);
    CREATOR = new CDNTaskInfo.1();
    AppMethodBeat.o(928);
  }
  
  public CDNTaskInfo() {}
  
  private CDNTaskInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(925);
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.edy = bool1;
      this.downloadUrl = paramParcel.readString();
      this.cBO = paramParcel.readString();
      this.filePath = paramParcel.readString();
      this.kDN = paramParcel.readString();
      this.kDO = paramParcel.readString();
      this.kDP = paramParcel.readInt();
      this.kDQ = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label125;
      }
      bool1 = true;
      label93:
      this.kDR = bool1;
      if (paramParcel.readByte() != 1) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kDT = bool1;
      AppMethodBeat.o(925);
      return;
      bool1 = false;
      break;
      label125:
      bool1 = false;
      break label93;
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
    AppMethodBeat.i(926);
    if ((paramObject == this) || ((paramObject != null) && ((paramObject instanceof CDNTaskInfo)) && (((CDNTaskInfo)paramObject).downloadUrl.equals(this.downloadUrl))))
    {
      AppMethodBeat.o(926);
      return true;
    }
    AppMethodBeat.o(926);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(927);
    int i = this.downloadUrl.hashCode();
    AppMethodBeat.o(927);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(924);
    if (this.edy)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.cBO);
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.kDN);
      paramParcel.writeString(this.kDO);
      paramParcel.writeInt(this.kDP);
      paramParcel.writeInt(this.kDQ);
      if (!this.kDR) {
        break label120;
      }
      b1 = 1;
      label88:
      paramParcel.writeByte(b1);
      if (!this.kDT) {
        break label125;
      }
    }
    label120:
    label125:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(924);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
 * JD-Core Version:    0.7.0.1
 */