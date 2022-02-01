package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int dgB;
  protected int rfP;
  protected int rhA;
  protected int rhB;
  protected int rhC;
  protected int rhD;
  protected int rhE;
  protected int rhF;
  protected int rhG;
  protected int rhH;
  protected int rhI;
  protected int rhJ;
  protected int rhK;
  protected int rhL;
  protected int rhM;
  protected int rhN;
  protected int rhO;
  protected int rhP;
  protected HashMap<Integer, Long> rhQ;
  protected HashMap<Integer, Long> rhR;
  protected int rhz;
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
    this.rhz = 0;
    this.rhA = 0;
    this.rhB = 0;
    this.rhC = 0;
    this.rhD = 0;
    this.rhE = 0;
    this.rhF = 0;
    this.rhG = 0;
    this.rhH = 0;
    this.rhI = 0;
    this.rhJ = 0;
    this.rhK = 0;
    this.rhL = 0;
    this.rhM = 0;
    this.rhN = 0;
    this.dgB = 0;
    this.rfP = 0;
    this.rhO = 0;
    this.rhP = 0;
    this.rhQ = new HashMap();
    this.rhR = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.rhz = 0;
    this.rhA = 0;
    this.rhB = 0;
    this.rhC = 0;
    this.rhD = 0;
    this.rhE = 0;
    this.rhF = 0;
    this.rhG = 0;
    this.rhH = 0;
    this.rhI = 0;
    this.rhJ = 0;
    this.rhK = 0;
    this.rhL = 0;
    this.rhM = 0;
    this.rhN = 0;
    this.dgB = 0;
    this.rfP = 0;
    this.rhO = 0;
    this.rhP = 0;
    this.rhQ = new HashMap();
    this.rhR = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.rhz = paramParcel.readInt();
    this.rhA = paramParcel.readInt();
    this.rhB = paramParcel.readInt();
    this.rhC = paramParcel.readInt();
    this.rhD = paramParcel.readInt();
    this.rhE = paramParcel.readInt();
    this.rhF = paramParcel.readInt();
    this.rhG = paramParcel.readInt();
    this.rhH = paramParcel.readInt();
    this.rhI = paramParcel.readInt();
    this.rhJ = paramParcel.readInt();
    this.rhK = paramParcel.readInt();
    this.rhL = paramParcel.readInt();
    this.rhM = paramParcel.readInt();
    this.rhN = paramParcel.readInt();
    this.dgB = paramParcel.readInt();
    this.rfP = paramParcel.readInt();
    this.rhO = paramParcel.readInt();
    this.rhP = paramParcel.readInt();
    try
    {
      this.rhQ = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.rhR = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      ad.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void DK(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.rhA += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.rhB += 1;
        return;
      }
      this.rhA += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.rhC += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.rhE += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.rhF += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.rhG += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.rhK += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.rhH += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.rhI += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.rhJ += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.rhD += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.rhL += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.rhM += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.rhN += 1;
      return;
    }
    this.rhz += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.rhA = 0;
    this.rhB = 0;
    this.rhC = 0;
    this.rhz = 0;
    this.rhD = 0;
    this.rhE = 0;
    this.rhF = 0;
    this.rhG = 0;
    this.rhH = 0;
    this.rhI = 0;
    this.rhJ = 0;
    this.rhK = 0;
    this.rhL = 0;
    this.dgB = 0;
    this.rfP = 0;
    this.rhO = 0;
    this.rhP = 0;
    this.rhQ.clear();
    this.rhR.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.rhA + ", motionOk: " + this.rhB + ", noFace: " + this.rhC + ", systemErr: " + this.rhz + ", noLiveFace: " + this.rhD + ", tooDark: " + this.rhE + ", tooLight: " + this.rhF + ", backLight: " + this.rhG + ", tooSmall: " + this.rhH + ", tooBig: " + this.rhI + ", tooActive: " + this.rhJ + ", poseNotValid: " + this.rhK + ", timeOut: " + this.rhL + ", totalFrame: " + this.dgB + ", verifyTime: " + this.rfP + ", processTimePerFrame: " + this.rhP;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.rhz);
    paramParcel.writeInt(this.rhA);
    paramParcel.writeInt(this.rhB);
    paramParcel.writeInt(this.rhC);
    paramParcel.writeInt(this.rhD);
    paramParcel.writeInt(this.rhE);
    paramParcel.writeInt(this.rhF);
    paramParcel.writeInt(this.rhG);
    paramParcel.writeInt(this.rhH);
    paramParcel.writeInt(this.rhI);
    paramParcel.writeInt(this.rhJ);
    paramParcel.writeInt(this.rhK);
    paramParcel.writeInt(this.rhL);
    paramParcel.writeInt(this.rhM);
    paramParcel.writeInt(this.rhN);
    paramParcel.writeInt(this.dgB);
    paramParcel.writeInt(this.rfP);
    paramParcel.writeInt(this.rhO);
    paramParcel.writeInt(this.rhP);
    paramParcel.writeMap(this.rhQ);
    paramParcel.writeMap(this.rhR);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */