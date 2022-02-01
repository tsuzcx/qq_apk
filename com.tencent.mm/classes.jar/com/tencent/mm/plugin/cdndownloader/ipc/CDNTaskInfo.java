package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CDNTaskInfo> CREATOR;
  public String downloadUrl;
  public String filePath;
  public boolean fnQ;
  public String mediaId;
  public String nKN;
  public String nKO;
  public int nKP;
  public int nKQ;
  public boolean nKR;
  public boolean nKS;
  public boolean nKT;
  
  static
  {
    AppMethodBeat.i(120760);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(120760);
  }
  
  public CDNTaskInfo() {}
  
  private CDNTaskInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(120757);
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.fnQ = bool1;
      this.downloadUrl = paramParcel.readString();
      this.mediaId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      this.nKN = paramParcel.readString();
      this.nKO = paramParcel.readString();
      this.nKP = paramParcel.readInt();
      this.nKQ = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label123;
      }
      bool1 = true;
      label92:
      this.nKR = bool1;
      if (paramParcel.readByte() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nKT = bool1;
      AppMethodBeat.o(120757);
      return;
      bool1 = false;
      break;
      label123:
      bool1 = false;
      break label92;
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
    AppMethodBeat.i(120758);
    if ((paramObject == this) || ((paramObject != null) && ((paramObject instanceof CDNTaskInfo)) && (((CDNTaskInfo)paramObject).downloadUrl.equals(this.downloadUrl))))
    {
      AppMethodBeat.o(120758);
      return true;
    }
    AppMethodBeat.o(120758);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(120759);
    int i = this.downloadUrl.hashCode();
    AppMethodBeat.o(120759);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(120756);
    if (this.fnQ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.mediaId);
      paramParcel.writeString(this.filePath);
      paramParcel.writeString(this.nKN);
      paramParcel.writeString(this.nKO);
      paramParcel.writeInt(this.nKP);
      paramParcel.writeInt(this.nKQ);
      if (!this.nKR) {
        break label118;
      }
      b1 = 1;
      label87:
      paramParcel.writeByte(b1);
      if (!this.nKT) {
        break label123;
      }
    }
    label118:
    label123:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(120756);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo
 * JD-Core Version:    0.7.0.1
 */