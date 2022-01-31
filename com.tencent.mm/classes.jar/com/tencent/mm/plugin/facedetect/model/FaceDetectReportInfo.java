package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR = new FaceDetectReportInfo.1();
  protected int bCi = 0;
  protected long fKz = 0L;
  protected int jMw = 0;
  protected int jOb = 0;
  protected int jOc = 0;
  protected int jOd = 0;
  protected int jOe = 0;
  protected int jOf = 0;
  protected int jOg = 0;
  protected int jOh = 0;
  protected int jOi = 0;
  protected int jOj = 0;
  protected int jOk = 0;
  protected int jOl = 0;
  protected int jOm = 0;
  protected int jOn = 0;
  protected int jOo = 0;
  protected int jOp = 0;
  protected int jOq = 0;
  protected int jOr = 0;
  protected HashMap<Integer, Long> jOs = new HashMap();
  protected HashMap<Integer, Long> jOt = new HashMap();
  
  public FaceDetectReportInfo() {}
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    this.fKz = paramParcel.readLong();
    this.jOb = paramParcel.readInt();
    this.jOc = paramParcel.readInt();
    this.jOd = paramParcel.readInt();
    this.jOe = paramParcel.readInt();
    this.jOf = paramParcel.readInt();
    this.jOg = paramParcel.readInt();
    this.jOh = paramParcel.readInt();
    this.jOi = paramParcel.readInt();
    this.jOj = paramParcel.readInt();
    this.jOk = paramParcel.readInt();
    this.jOl = paramParcel.readInt();
    this.jOm = paramParcel.readInt();
    this.jOn = paramParcel.readInt();
    this.jOo = paramParcel.readInt();
    this.jOp = paramParcel.readInt();
    this.bCi = paramParcel.readInt();
    this.jMw = paramParcel.readInt();
    this.jOq = paramParcel.readInt();
    this.jOr = paramParcel.readInt();
    try
    {
      this.jOs = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.jOt = paramParcel.readHashMap(HashMap.class.getClassLoader());
      return;
    }
    catch (Exception paramParcel)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void qK(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.jOc += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.jOd += 1;
        return;
      }
      this.jOc += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.jOe += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.jOg += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.jOh += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.jOi += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.jOm += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.jOj += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.jOk += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.jOl += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.jOf += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.jOn += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.jOo += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.jOp += 1;
      return;
    }
    this.jOb += 1;
  }
  
  public final void reset()
  {
    this.fKz = 0L;
    this.jOc = 0;
    this.jOd = 0;
    this.jOe = 0;
    this.jOb = 0;
    this.jOf = 0;
    this.jOg = 0;
    this.jOh = 0;
    this.jOi = 0;
    this.jOj = 0;
    this.jOk = 0;
    this.jOl = 0;
    this.jOm = 0;
    this.jOn = 0;
    this.bCi = 0;
    this.jMw = 0;
    this.jOq = 0;
    this.jOr = 0;
    this.jOs.clear();
    this.jOt.clear();
  }
  
  public String toString()
  {
    return "detectOk: " + this.jOc + ", motionOk: " + this.jOd + ", noFace: " + this.jOe + ", systemErr: " + this.jOb + ", noLiveFace: " + this.jOf + ", tooDark: " + this.jOg + ", tooLight: " + this.jOh + ", backLight: " + this.jOi + ", tooSmall: " + this.jOj + ", tooBig: " + this.jOk + ", tooActive: " + this.jOl + ", poseNotValid: " + this.jOm + ", timeOut: " + this.jOn + ", totalFrame: " + this.bCi + ", verifyTime: " + this.jMw + ", processTimePerFrame: " + this.jOr;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.fKz);
    paramParcel.writeInt(this.jOb);
    paramParcel.writeInt(this.jOc);
    paramParcel.writeInt(this.jOd);
    paramParcel.writeInt(this.jOe);
    paramParcel.writeInt(this.jOf);
    paramParcel.writeInt(this.jOg);
    paramParcel.writeInt(this.jOh);
    paramParcel.writeInt(this.jOi);
    paramParcel.writeInt(this.jOj);
    paramParcel.writeInt(this.jOk);
    paramParcel.writeInt(this.jOl);
    paramParcel.writeInt(this.jOm);
    paramParcel.writeInt(this.jOn);
    paramParcel.writeInt(this.jOo);
    paramParcel.writeInt(this.jOp);
    paramParcel.writeInt(this.bCi);
    paramParcel.writeInt(this.jMw);
    paramParcel.writeInt(this.jOq);
    paramParcel.writeInt(this.jOr);
    paramParcel.writeMap(this.jOs);
    paramParcel.writeMap(this.jOt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */