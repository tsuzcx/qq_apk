package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean AnF;
  public boolean KTL;
  public boolean KTM;
  public String KTN;
  public String KTO;
  public String KTP;
  public String KTQ;
  public int KTR;
  public dmb KTS;
  public String KTT;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new SightCaptureResult.1();
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.AnF = false;
    this.KTL = false;
    this.KTM = true;
    this.KTN = "";
    this.KTO = "";
    this.KTP = "";
    this.KTQ = "";
    this.KTR = 0;
    this.KTS = new dmb();
    this.KTT = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.AnF = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.KTL = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.KTM = bool;
      this.KTN = paramParcel.readString();
      this.KTO = paramParcel.readString();
      this.KTP = paramParcel.readString();
      this.KTQ = paramParcel.readString();
      this.KTR = paramParcel.readInt();
      this.KTT = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.KTS = new dmb();
        this.KTS.parseFrom(arrayOfByte);
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
    this.AnF = false;
    this.KTL = false;
    this.KTM = true;
    this.KTN = "";
    this.KTO = "";
    this.KTP = "";
    this.KTQ = "";
    this.KTR = 0;
    this.KTS = new dmb();
    this.KTT = "";
    this.KTM = paramBoolean;
    this.KTT = paramString;
    this.AnF = false;
    this.KTL = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, dmb paramdmb)
  {
    AppMethodBeat.i(148778);
    this.AnF = false;
    this.KTL = false;
    this.KTM = true;
    this.KTN = "";
    this.KTO = "";
    this.KTP = "";
    this.KTQ = "";
    this.KTR = 0;
    this.KTS = new dmb();
    this.KTT = "";
    this.KTM = paramBoolean;
    this.KTN = paramString1;
    this.KTO = paramString2;
    this.KTP = paramString3;
    this.KTR = paramInt;
    this.KTS = paramdmb;
    this.KTQ = paramString4;
    this.AnF = true;
    this.KTL = false;
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
    if (this.AnF)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.KTL) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.KTM) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.KTN);
      paramParcel.writeString(this.KTO);
      paramParcel.writeString(this.KTP);
      paramParcel.writeString(this.KTQ);
      paramParcel.writeInt(this.KTR);
      paramParcel.writeString(this.KTT);
      try
      {
        byte[] arrayOfByte = this.KTS.toByteArray();
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