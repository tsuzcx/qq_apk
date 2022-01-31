package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.y;

public class SightCaptureResult
  implements Parcelable
{
  public static final Parcelable.Creator<SightCaptureResult> CREATOR = new SightCaptureResult.1();
  public boolean khM = false;
  public boolean mfh = false;
  public boolean mfi = true;
  public String mfj = "";
  public String mfk = "";
  public String mfl = "";
  public String mfm = "";
  public int mfn = 0;
  public avn mfo = new avn();
  public String mfp = "";
  
  protected SightCaptureResult(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.khM = bool;
      if (paramParcel.readByte() == 0) {
        break label193;
      }
      bool = true;
      label88:
      this.mfh = bool;
      if (paramParcel.readByte() == 0) {
        break label198;
      }
    }
    label193:
    label198:
    for (boolean bool = true;; bool = false)
    {
      this.mfi = bool;
      this.mfj = paramParcel.readString();
      this.mfk = paramParcel.readString();
      this.mfl = paramParcel.readString();
      this.mfm = paramParcel.readString();
      this.mfn = paramParcel.readInt();
      this.mfp = paramParcel.readString();
      try
      {
        byte[] arrayOfByte = new byte[paramParcel.readInt()];
        paramParcel.readByteArray(arrayOfByte);
        this.mfo = new avn();
        this.mfo.aH(arrayOfByte);
        return;
      }
      catch (Exception paramParcel)
      {
        y.e("MicroMsg.SightCaptureResult", "read ext info error: %s", new Object[] { paramParcel.getMessage() });
      }
      bool = false;
      break;
      bool = false;
      break label88;
    }
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString)
  {
    this.mfi = paramBoolean;
    this.mfp = paramString;
    this.khM = false;
    this.mfh = true;
  }
  
  public SightCaptureResult(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, avn paramavn)
  {
    this.mfi = paramBoolean;
    this.mfj = paramString1;
    this.mfk = paramString2;
    this.mfl = paramString3;
    this.mfn = paramInt;
    this.mfo = paramavn;
    this.mfm = paramString4;
    this.khM = true;
    this.mfh = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.khM)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.mfh) {
        break label123;
      }
      paramInt = 1;
      label26:
      paramParcel.writeByte((byte)paramInt);
      if (!this.mfi) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.mfj);
      paramParcel.writeString(this.mfk);
      paramParcel.writeString(this.mfl);
      paramParcel.writeString(this.mfm);
      paramParcel.writeInt(this.mfn);
      paramParcel.writeString(this.mfp);
      try
      {
        byte[] arrayOfByte = this.mfo.toByteArray();
        paramParcel.writeInt(arrayOfByte.length);
        paramParcel.writeByteArray(arrayOfByte);
        return;
      }
      catch (Exception paramParcel)
      {
        y.e("MicroMsg.SightCaptureResult", "write ext info error");
      }
      paramInt = 0;
      break;
      label123:
      paramInt = 0;
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightCaptureResult
 * JD-Core Version:    0.7.0.1
 */