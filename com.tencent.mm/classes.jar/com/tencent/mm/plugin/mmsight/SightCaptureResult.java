package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR;
  public boolean oWm;
  public boolean uJm;
  public boolean uJn;
  public String uJo;
  public String uJp;
  public String uJq;
  public String uJr;
  public int uJs;
  public bsz uJt;
  public String uJu;
  
  static
  {
    AppMethodBeat.i(148782);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148782);
  }
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    AppMethodBeat.i(148780);
    this.oWm = false;
    this.uJm = false;
    this.uJn = true;
    this.uJo = "";
    this.uJp = "";
    this.uJq = "";
    this.uJr = "";
    this.uJs = 0;
    this.uJt = new bsz();
    this.uJu = "";
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.oWm = bool;
      if (paramParcel.readByte() == 0) {
        break label203;
      }
      bool = true;
      label93:
      this.uJm = bool;
      if (paramParcel.readByte() == 0) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool = true;; bool = false)
    {
      this.uJn = bool;
      this.uJo = paramParcel.readString();
      this.uJp = paramParcel.readString();
      this.uJq = paramParcel.readString();
      this.uJr = paramParcel.readString();
      this.uJs = paramParcel.readInt();
      this.uJu = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.uJt = new bsz();
        this.uJt.parseFrom(arrayOfByte);
        AppMethodBeat.o(148780);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
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
    this.oWm = false;
    this.uJm = false;
    this.uJn = true;
    this.uJo = "";
    this.uJp = "";
    this.uJq = "";
    this.uJr = "";
    this.uJs = 0;
    this.uJt = new bsz();
    this.uJu = "";
    this.uJn = paramBoolean;
    this.uJu = paramString;
    this.oWm = false;
    this.uJm = true;
    AppMethodBeat.o(148779);
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, bsz parambsz)
  {
    AppMethodBeat.i(148778);
    this.oWm = false;
    this.uJm = false;
    this.uJn = true;
    this.uJo = "";
    this.uJp = "";
    this.uJq = "";
    this.uJr = "";
    this.uJs = 0;
    this.uJt = new bsz();
    this.uJu = "";
    this.uJn = paramBoolean;
    this.uJo = paramString1;
    this.uJp = paramString2;
    this.uJq = paramString3;
    this.uJs = paramInt;
    this.uJt = parambsz;
    this.uJr = paramString4;
    this.oWm = true;
    this.uJm = false;
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
    if (this.oWm)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.uJm) {
        break label133;
      }
      paramInt = 1;
      label31:
      paramParcel.writeByte((byte)paramInt);
      if (!this.uJn) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.uJo);
      paramParcel.writeString(this.uJp);
      paramParcel.writeString(this.uJq);
      paramParcel.writeString(this.uJr);
      paramParcel.writeInt(this.uJs);
      paramParcel.writeString(this.uJu);
      try
      {
        byte[] arrayOfByte = this.uJt.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        AppMethodBeat.o(148781);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.SightCaptureResult", "write ext info error");
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