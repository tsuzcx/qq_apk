package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int dhD;
  protected int rnS;
  protected int rpD;
  protected int rpE;
  protected int rpF;
  protected int rpG;
  protected int rpH;
  protected int rpI;
  protected int rpJ;
  protected int rpK;
  protected int rpL;
  protected int rpM;
  protected int rpN;
  protected int rpO;
  protected int rpP;
  protected int rpQ;
  protected int rpR;
  protected int rpS;
  protected int rpT;
  protected HashMap<Integer, Long> rpU;
  protected HashMap<Integer, Long> rpV;
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
    this.rpD = 0;
    this.rpE = 0;
    this.rpF = 0;
    this.rpG = 0;
    this.rpH = 0;
    this.rpI = 0;
    this.rpJ = 0;
    this.rpK = 0;
    this.rpL = 0;
    this.rpM = 0;
    this.rpN = 0;
    this.rpO = 0;
    this.rpP = 0;
    this.rpQ = 0;
    this.rpR = 0;
    this.dhD = 0;
    this.rnS = 0;
    this.rpS = 0;
    this.rpT = 0;
    this.rpU = new HashMap();
    this.rpV = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.rpD = 0;
    this.rpE = 0;
    this.rpF = 0;
    this.rpG = 0;
    this.rpH = 0;
    this.rpI = 0;
    this.rpJ = 0;
    this.rpK = 0;
    this.rpL = 0;
    this.rpM = 0;
    this.rpN = 0;
    this.rpO = 0;
    this.rpP = 0;
    this.rpQ = 0;
    this.rpR = 0;
    this.dhD = 0;
    this.rnS = 0;
    this.rpS = 0;
    this.rpT = 0;
    this.rpU = new HashMap();
    this.rpV = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.rpD = paramParcel.readInt();
    this.rpE = paramParcel.readInt();
    this.rpF = paramParcel.readInt();
    this.rpG = paramParcel.readInt();
    this.rpH = paramParcel.readInt();
    this.rpI = paramParcel.readInt();
    this.rpJ = paramParcel.readInt();
    this.rpK = paramParcel.readInt();
    this.rpL = paramParcel.readInt();
    this.rpM = paramParcel.readInt();
    this.rpN = paramParcel.readInt();
    this.rpO = paramParcel.readInt();
    this.rpP = paramParcel.readInt();
    this.rpQ = paramParcel.readInt();
    this.rpR = paramParcel.readInt();
    this.dhD = paramParcel.readInt();
    this.rnS = paramParcel.readInt();
    this.rpS = paramParcel.readInt();
    this.rpT = paramParcel.readInt();
    try
    {
      this.rpU = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.rpV = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      ae.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void DX(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.rpE += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.rpF += 1;
        return;
      }
      this.rpE += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.rpG += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.rpI += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.rpJ += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.rpK += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.rpO += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.rpL += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.rpM += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.rpN += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.rpH += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.rpP += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.rpQ += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.rpR += 1;
      return;
    }
    this.rpD += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.rpE = 0;
    this.rpF = 0;
    this.rpG = 0;
    this.rpD = 0;
    this.rpH = 0;
    this.rpI = 0;
    this.rpJ = 0;
    this.rpK = 0;
    this.rpL = 0;
    this.rpM = 0;
    this.rpN = 0;
    this.rpO = 0;
    this.rpP = 0;
    this.dhD = 0;
    this.rnS = 0;
    this.rpS = 0;
    this.rpT = 0;
    this.rpU.clear();
    this.rpV.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.rpE + ", motionOk: " + this.rpF + ", noFace: " + this.rpG + ", systemErr: " + this.rpD + ", noLiveFace: " + this.rpH + ", tooDark: " + this.rpI + ", tooLight: " + this.rpJ + ", backLight: " + this.rpK + ", tooSmall: " + this.rpL + ", tooBig: " + this.rpM + ", tooActive: " + this.rpN + ", poseNotValid: " + this.rpO + ", timeOut: " + this.rpP + ", totalFrame: " + this.dhD + ", verifyTime: " + this.rnS + ", processTimePerFrame: " + this.rpT;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.rpD);
    paramParcel.writeInt(this.rpE);
    paramParcel.writeInt(this.rpF);
    paramParcel.writeInt(this.rpG);
    paramParcel.writeInt(this.rpH);
    paramParcel.writeInt(this.rpI);
    paramParcel.writeInt(this.rpJ);
    paramParcel.writeInt(this.rpK);
    paramParcel.writeInt(this.rpL);
    paramParcel.writeInt(this.rpM);
    paramParcel.writeInt(this.rpN);
    paramParcel.writeInt(this.rpO);
    paramParcel.writeInt(this.rpP);
    paramParcel.writeInt(this.rpQ);
    paramParcel.writeInt(this.rpR);
    paramParcel.writeInt(this.dhD);
    paramParcel.writeInt(this.rnS);
    paramParcel.writeInt(this.rpS);
    paramParcel.writeInt(this.rpT);
    paramParcel.writeMap(this.rpU);
    paramParcel.writeMap(this.rpV);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */