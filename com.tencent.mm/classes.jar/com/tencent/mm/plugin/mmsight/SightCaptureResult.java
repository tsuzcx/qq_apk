package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean pzW;
  public String vMA;
  public boolean vMs;
  public boolean vMt;
  public String vMu;
  public String vMv;
  public String vMw;
  public String vMx;
  public int vMy;
  public bxm vMz;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.pzW = false;
    this.vMs = false;
    this.vMt = true;
    this.vMu = "";
    this.vMv = "";
    this.vMw = "";
    this.vMx = "";
    this.vMy = 0;
    this.vMz = new bxm();
    this.vMA = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.pzW = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.vMs = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.vMt = bool;
      this.vMu = paramParcel.readString();
      this.vMv = paramParcel.readString();
      this.vMw = paramParcel.readString();
      this.vMx = paramParcel.readString();
      this.vMy = paramParcel.readInt();
      this.vMA = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.vMz = new bxm();
        this.vMz.parseFrom(arrayOfByte);
        AppMethodBeat.o(148780);
        return;
      }
      catch (Exception paramParcel)
      {
        ad.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
        AppMethodBeat.o(148780);
      }
      bool = false;
      break;
      bool = false;
      break label93;
    }
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(148779);
    this.pzW = false;
    this.vMs = false;
    this.vMt = true;
    this.vMu = "";
    this.vMv = "";
    this.vMw = "";
    this.vMx = "";
    this.vMy = 0;
    this.vMz = new bxm();
    this.vMA = "";
    this.vMt = paramBoolean;
    this.vMA = paramString;
    this.pzW = false;
    this.vMs = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, bxm parambxm)
  {
    AppMethodBeat.i(148778);
    this.pzW = false;
    this.vMs = false;
    this.vMt = true;
    this.vMu = "";
    this.vMv = "";
    this.vMw = "";
    this.vMx = "";
    this.vMy = 0;
    this.vMz = new bxm();
    this.vMA = "";
    this.vMt = paramBoolean;
    this.vMu = paramString1;
    this.vMv = paramString2;
    this.vMw = paramString3;
    this.vMy = paramInt;
    this.vMz = parambxm;
    this.vMx = paramString4;
    this.pzW = true;
    this.vMs = false;
    AppMethodBeat.o(148778);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148781);
    if (this.pzW)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.vMs) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vMt) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.vMu);
      paramParcel.writeString(this.vMv);
      paramParcel.writeString(this.vMw);
      paramParcel.writeString(this.vMx);
      paramParcel.writeInt(this.vMy);
      paramParcel.writeString(this.vMA);
      try
      {
        byte[] arrayOfByte = this.vMz.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        AppMethodBeat.o(148781);
        return;
      }
      catch (Exception paramParcel)
      {
        ad.e("MicroMsg.SightCaptureResult", "write ext info error");
        AppMethodBeat.o(148781);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */