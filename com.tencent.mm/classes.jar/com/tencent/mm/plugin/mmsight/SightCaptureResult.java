package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean osM;
  public boolean tAP;
  public boolean tAQ;
  public String tAR;
  public String tAS;
  public String tAT;
  public String tAU;
  public int tAV;
  public boj tAW;
  public String tAX;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.osM = false;
    this.tAP = false;
    this.tAQ = true;
    this.tAR = "";
    this.tAS = "";
    this.tAT = "";
    this.tAU = "";
    this.tAV = 0;
    this.tAW = new boj();
    this.tAX = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.osM = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.tAP = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.tAQ = bool;
      this.tAR = paramParcel.readString();
      this.tAS = paramParcel.readString();
      this.tAT = paramParcel.readString();
      this.tAU = paramParcel.readString();
      this.tAV = paramParcel.readInt();
      this.tAX = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.tAW = new boj();
        this.tAW.parseFrom(arrayOfByte);
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
    this.osM = false;
    this.tAP = false;
    this.tAQ = true;
    this.tAR = "";
    this.tAS = "";
    this.tAT = "";
    this.tAU = "";
    this.tAV = 0;
    this.tAW = new boj();
    this.tAX = "";
    this.tAQ = paramBoolean;
    this.tAX = paramString;
    this.osM = false;
    this.tAP = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boj paramboj)
  {
    AppMethodBeat.i(148778);
    this.osM = false;
    this.tAP = false;
    this.tAQ = true;
    this.tAR = "";
    this.tAS = "";
    this.tAT = "";
    this.tAU = "";
    this.tAV = 0;
    this.tAW = new boj();
    this.tAX = "";
    this.tAQ = paramBoolean;
    this.tAR = paramString1;
    this.tAS = paramString2;
    this.tAT = paramString3;
    this.tAV = paramInt;
    this.tAW = paramboj;
    this.tAU = paramString4;
    this.osM = true;
    this.tAP = false;
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
    if (this.osM)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.tAP) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.tAQ) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.tAR);
      paramParcel.writeString(this.tAS);
      paramParcel.writeString(this.tAT);
      paramParcel.writeString(this.tAU);
      paramParcel.writeInt(this.tAV);
      paramParcel.writeString(this.tAX);
      try
      {
        byte[] arrayOfByte = this.tAW.toByteArray();
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