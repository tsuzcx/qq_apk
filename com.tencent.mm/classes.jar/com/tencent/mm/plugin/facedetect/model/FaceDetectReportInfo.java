package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int cVl;
  protected int qvZ;
  protected int qxJ;
  protected int qxK;
  protected int qxL;
  protected int qxM;
  protected int qxN;
  protected int qxO;
  protected int qxP;
  protected int qxQ;
  protected int qxR;
  protected int qxS;
  protected int qxT;
  protected int qxU;
  protected int qxV;
  protected int qxW;
  protected int qxX;
  protected int qxY;
  protected int qxZ;
  protected HashMap<Integer, Long> qya;
  protected HashMap<Integer, Long> qyb;
  protected long sessionId;
  
  static
  {
    AppMethodBeat.i(103751);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103751);
  }
  
  public FaceDetectReportInfo()
  {
    AppMethodBeat.i(103746);
    this.sessionId = 0L;
    this.qxJ = 0;
    this.qxK = 0;
    this.qxL = 0;
    this.qxM = 0;
    this.qxN = 0;
    this.qxO = 0;
    this.qxP = 0;
    this.qxQ = 0;
    this.qxR = 0;
    this.qxS = 0;
    this.qxT = 0;
    this.qxU = 0;
    this.qxV = 0;
    this.qxW = 0;
    this.qxX = 0;
    this.cVl = 0;
    this.qvZ = 0;
    this.qxY = 0;
    this.qxZ = 0;
    this.qya = new HashMap();
    this.qyb = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.qxJ = 0;
    this.qxK = 0;
    this.qxL = 0;
    this.qxM = 0;
    this.qxN = 0;
    this.qxO = 0;
    this.qxP = 0;
    this.qxQ = 0;
    this.qxR = 0;
    this.qxS = 0;
    this.qxT = 0;
    this.qxU = 0;
    this.qxV = 0;
    this.qxW = 0;
    this.qxX = 0;
    this.cVl = 0;
    this.qvZ = 0;
    this.qxY = 0;
    this.qxZ = 0;
    this.qya = new HashMap();
    this.qyb = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.qxJ = paramParcel.readInt();
    this.qxK = paramParcel.readInt();
    this.qxL = paramParcel.readInt();
    this.qxM = paramParcel.readInt();
    this.qxN = paramParcel.readInt();
    this.qxO = paramParcel.readInt();
    this.qxP = paramParcel.readInt();
    this.qxQ = paramParcel.readInt();
    this.qxR = paramParcel.readInt();
    this.qxS = paramParcel.readInt();
    this.qxT = paramParcel.readInt();
    this.qxU = paramParcel.readInt();
    this.qxV = paramParcel.readInt();
    this.qxW = paramParcel.readInt();
    this.qxX = paramParcel.readInt();
    this.cVl = paramParcel.readInt();
    this.qvZ = paramParcel.readInt();
    this.qxY = paramParcel.readInt();
    this.qxZ = paramParcel.readInt();
    try
    {
      this.qya = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.qyb = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      ac.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void CS(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.qxK += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.qxL += 1;
        return;
      }
      this.qxK += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.qxM += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.qxO += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.qxP += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.qxQ += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.qxU += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.qxR += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.qxS += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.qxT += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.qxN += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.qxV += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.qxW += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.qxX += 1;
      return;
    }
    this.qxJ += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.qxK = 0;
    this.qxL = 0;
    this.qxM = 0;
    this.qxJ = 0;
    this.qxN = 0;
    this.qxO = 0;
    this.qxP = 0;
    this.qxQ = 0;
    this.qxR = 0;
    this.qxS = 0;
    this.qxT = 0;
    this.qxU = 0;
    this.qxV = 0;
    this.cVl = 0;
    this.qvZ = 0;
    this.qxY = 0;
    this.qxZ = 0;
    this.qya.clear();
    this.qyb.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.qxK + ", motionOk: " + this.qxL + ", noFace: " + this.qxM + ", systemErr: " + this.qxJ + ", noLiveFace: " + this.qxN + ", tooDark: " + this.qxO + ", tooLight: " + this.qxP + ", backLight: " + this.qxQ + ", tooSmall: " + this.qxR + ", tooBig: " + this.qxS + ", tooActive: " + this.qxT + ", poseNotValid: " + this.qxU + ", timeOut: " + this.qxV + ", totalFrame: " + this.cVl + ", verifyTime: " + this.qvZ + ", processTimePerFrame: " + this.qxZ;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.qxJ);
    paramParcel.writeInt(this.qxK);
    paramParcel.writeInt(this.qxL);
    paramParcel.writeInt(this.qxM);
    paramParcel.writeInt(this.qxN);
    paramParcel.writeInt(this.qxO);
    paramParcel.writeInt(this.qxP);
    paramParcel.writeInt(this.qxQ);
    paramParcel.writeInt(this.qxR);
    paramParcel.writeInt(this.qxS);
    paramParcel.writeInt(this.qxT);
    paramParcel.writeInt(this.qxU);
    paramParcel.writeInt(this.qxV);
    paramParcel.writeInt(this.qxW);
    paramParcel.writeInt(this.qxX);
    paramParcel.writeInt(this.cVl);
    paramParcel.writeInt(this.qvZ);
    paramParcel.writeInt(this.qxY);
    paramParcel.writeInt(this.qxZ);
    paramParcel.writeMap(this.qya);
    paramParcel.writeMap(this.qyb);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */