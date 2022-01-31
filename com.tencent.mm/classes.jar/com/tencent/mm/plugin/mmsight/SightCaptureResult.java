package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean mCu;
  public boolean oFG;
  public boolean oFH;
  public String oFI;
  public String oFJ;
  public String oFK;
  public String oFL;
  public int oFM;
  public bby oFN;
  public String oFO;
  
  static
  {
    AppMethodBeat.i(60276);
    CREATOR = new SightCaptureResult.1();
    AppMethodBeat.o(60276);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(60274);
    this.mCu = false;
    this.oFG = false;
    this.oFH = true;
    this.oFI = "";
    this.oFJ = "";
    this.oFK = "";
    this.oFL = "";
    this.oFM = 0;
    this.oFN = new bby();
    this.oFO = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.mCu = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.oFG = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.oFH = bool;
      this.oFI = paramParcel.readString();
      this.oFJ = paramParcel.readString();
      this.oFK = paramParcel.readString();
      this.oFL = paramParcel.readString();
      this.oFM = paramParcel.readInt();
      this.oFO = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.oFN = new bby();
        this.oFN.parseFrom(arrayOfByte);
        AppMethodBeat.o(60274);
        return;
      }
      catch (Exception paramParcel)
      {
        ab.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
        AppMethodBeat.o(60274);
      }
      bool = false;
      break;
      bool = false;
      break label93;
    }
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(60273);
    this.mCu = false;
    this.oFG = false;
    this.oFH = true;
    this.oFI = "";
    this.oFJ = "";
    this.oFK = "";
    this.oFL = "";
    this.oFM = 0;
    this.oFN = new bby();
    this.oFO = "";
    this.oFH = paramBoolean;
    this.oFO = paramString;
    this.mCu = false;
    this.oFG = true;
    AppMethodBeat.o(60273);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, bby parambby)
  {
    AppMethodBeat.i(60272);
    this.mCu = false;
    this.oFG = false;
    this.oFH = true;
    this.oFI = "";
    this.oFJ = "";
    this.oFK = "";
    this.oFL = "";
    this.oFM = 0;
    this.oFN = new bby();
    this.oFO = "";
    this.oFH = paramBoolean;
    this.oFI = paramString1;
    this.oFJ = paramString2;
    this.oFK = paramString3;
    this.oFM = paramInt;
    this.oFN = parambby;
    this.oFL = paramString4;
    this.mCu = true;
    this.oFG = false;
    AppMethodBeat.o(60272);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(60275);
    if (this.mCu)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.oFG) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.oFH) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.oFI);
      paramParcel.writeString(this.oFJ);
      paramParcel.writeString(this.oFK);
      paramParcel.writeString(this.oFL);
      paramParcel.writeInt(this.oFM);
      paramParcel.writeString(this.oFO);
      try
      {
        byte[] arrayOfByte = this.oFN.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        AppMethodBeat.o(60275);
        return;
      }
      catch (Exception paramParcel)
      {
        ab.e("MicroMsg.SightCaptureResult", "write ext info error");
        AppMethodBeat.o(60275);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */