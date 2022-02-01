package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean EXZ;
  public boolean EYa;
  public String EYb;
  public String EYc;
  public String EYd;
  public String EYe;
  public int EYf;
  public cuv EYg;
  public String EYh;
  public boolean wRb;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.wRb = false;
    this.EXZ = false;
    this.EYa = true;
    this.EYb = "";
    this.EYc = "";
    this.EYd = "";
    this.EYe = "";
    this.EYf = 0;
    this.EYg = new cuv();
    this.EYh = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.wRb = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.EXZ = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.EYa = bool;
      this.EYb = paramParcel.readString();
      this.EYc = paramParcel.readString();
      this.EYd = paramParcel.readString();
      this.EYe = paramParcel.readString();
      this.EYf = paramParcel.readInt();
      this.EYh = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.EYg = new cuv();
        this.EYg.parseFrom(arrayOfByte);
        AppMethodBeat.o(148780);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
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
    this.wRb = false;
    this.EXZ = false;
    this.EYa = true;
    this.EYb = "";
    this.EYc = "";
    this.EYd = "";
    this.EYe = "";
    this.EYf = 0;
    this.EYg = new cuv();
    this.EYh = "";
    this.EYa = paramBoolean;
    this.EYh = paramString;
    this.wRb = false;
    this.EXZ = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, cuv paramcuv)
  {
    AppMethodBeat.i(148778);
    this.wRb = false;
    this.EXZ = false;
    this.EYa = true;
    this.EYb = "";
    this.EYc = "";
    this.EYd = "";
    this.EYe = "";
    this.EYf = 0;
    this.EYg = new cuv();
    this.EYh = "";
    this.EYa = paramBoolean;
    this.EYb = paramString1;
    this.EYc = paramString2;
    this.EYd = paramString3;
    this.EYf = paramInt;
    this.EYg = paramcuv;
    this.EYe = paramString4;
    this.wRb = true;
    this.EXZ = false;
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
    if (this.wRb)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.EXZ) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EYa) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.EYb);
      paramParcel.writeString(this.EYc);
      paramParcel.writeString(this.EYd);
      paramParcel.writeString(this.EYe);
      paramParcel.writeInt(this.EYf);
      paramParcel.writeString(this.EYh);
      try
      {
        byte[] arrayOfByte = this.EYg.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        AppMethodBeat.o(148781);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.e("MicroMsg.SightCaptureResult", "write ext info error");
        AppMethodBeat.o(148781);
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */