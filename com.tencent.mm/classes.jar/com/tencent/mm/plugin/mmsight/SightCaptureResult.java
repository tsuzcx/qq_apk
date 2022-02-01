package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ae;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean pGA;
  public String vYA;
  public String vYB;
  public int vYC;
  public byg vYD;
  public String vYE;
  public boolean vYw;
  public boolean vYx;
  public String vYy;
  public String vYz;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new SightCaptureResult.1();
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.pGA = false;
    this.vYw = false;
    this.vYx = true;
    this.vYy = "";
    this.vYz = "";
    this.vYA = "";
    this.vYB = "";
    this.vYC = 0;
    this.vYD = new byg();
    this.vYE = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.pGA = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.vYw = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.vYx = bool;
      this.vYy = paramParcel.readString();
      this.vYz = paramParcel.readString();
      this.vYA = paramParcel.readString();
      this.vYB = paramParcel.readString();
      this.vYC = paramParcel.readInt();
      this.vYE = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.vYD = new byg();
        this.vYD.parseFrom(arrayOfByte);
        AppMethodBeat.o(148780);
        return;
      }
      catch (Exception paramParcel)
      {
        ae.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
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
    this.pGA = false;
    this.vYw = false;
    this.vYx = true;
    this.vYy = "";
    this.vYz = "";
    this.vYA = "";
    this.vYB = "";
    this.vYC = 0;
    this.vYD = new byg();
    this.vYE = "";
    this.vYx = paramBoolean;
    this.vYE = paramString;
    this.pGA = false;
    this.vYw = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, byg parambyg)
  {
    AppMethodBeat.i(148778);
    this.pGA = false;
    this.vYw = false;
    this.vYx = true;
    this.vYy = "";
    this.vYz = "";
    this.vYA = "";
    this.vYB = "";
    this.vYC = 0;
    this.vYD = new byg();
    this.vYE = "";
    this.vYx = paramBoolean;
    this.vYy = paramString1;
    this.vYz = paramString2;
    this.vYA = paramString3;
    this.vYC = paramInt;
    this.vYD = parambyg;
    this.vYB = paramString4;
    this.pGA = true;
    this.vYw = false;
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
    if (this.pGA)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.vYw) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vYx) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.vYy);
      paramParcel.writeString(this.vYz);
      paramParcel.writeString(this.vYA);
      paramParcel.writeString(this.vYB);
      paramParcel.writeInt(this.vYC);
      paramParcel.writeString(this.vYE);
      try
      {
        byte[] arrayOfByte = this.vYD.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        AppMethodBeat.o(148781);
        return;
      }
      catch (Exception paramParcel)
      {
        ae.e("MicroMsg.SightCaptureResult", "write ext info error");
        AppMethodBeat.o(148781);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */