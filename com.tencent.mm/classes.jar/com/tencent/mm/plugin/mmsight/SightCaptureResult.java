package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean tkD;
  public String zsA;
  public String zsB;
  public String zsC;
  public String zsD;
  public int zsE;
  public cly zsF;
  public String zsG;
  public boolean zsy;
  public boolean zsz;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.tkD = false;
    this.zsy = false;
    this.zsz = true;
    this.zsA = "";
    this.zsB = "";
    this.zsC = "";
    this.zsD = "";
    this.zsE = 0;
    this.zsF = new cly();
    this.zsG = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.tkD = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.zsy = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.zsz = bool;
      this.zsA = paramParcel.readString();
      this.zsB = paramParcel.readString();
      this.zsC = paramParcel.readString();
      this.zsD = paramParcel.readString();
      this.zsE = paramParcel.readInt();
      this.zsG = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.zsF = new cly();
        this.zsF.parseFrom(arrayOfByte);
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
    this.tkD = false;
    this.zsy = false;
    this.zsz = true;
    this.zsA = "";
    this.zsB = "";
    this.zsC = "";
    this.zsD = "";
    this.zsE = 0;
    this.zsF = new cly();
    this.zsG = "";
    this.zsz = paramBoolean;
    this.zsG = paramString;
    this.tkD = false;
    this.zsy = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, cly paramcly)
  {
    AppMethodBeat.i(148778);
    this.tkD = false;
    this.zsy = false;
    this.zsz = true;
    this.zsA = "";
    this.zsB = "";
    this.zsC = "";
    this.zsD = "";
    this.zsE = 0;
    this.zsF = new cly();
    this.zsG = "";
    this.zsz = paramBoolean;
    this.zsA = paramString1;
    this.zsB = paramString2;
    this.zsC = paramString3;
    this.zsE = paramInt;
    this.zsF = paramcly;
    this.zsD = paramString4;
    this.tkD = true;
    this.zsy = false;
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
    if (this.tkD)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.zsy) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.zsz) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.zsA);
      paramParcel.writeString(this.zsB);
      paramParcel.writeString(this.zsC);
      paramParcel.writeString(this.zsD);
      paramParcel.writeInt(this.zsE);
      paramParcel.writeString(this.zsG);
      try
      {
        byte[] arrayOfByte = this.zsF.toByteArray();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */