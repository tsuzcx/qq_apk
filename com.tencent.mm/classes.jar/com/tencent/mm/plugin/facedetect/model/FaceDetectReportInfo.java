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
  protected int cXP;
  protected int pNr;
  protected int pPb;
  protected int pPc;
  protected int pPd;
  protected int pPe;
  protected int pPf;
  protected int pPg;
  protected int pPh;
  protected int pPi;
  protected int pPj;
  protected int pPk;
  protected int pPl;
  protected int pPm;
  protected int pPn;
  protected int pPo;
  protected int pPp;
  protected int pPq;
  protected int pPr;
  protected HashMap<Integer, Long> pPs;
  protected HashMap<Integer, Long> pPt;
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
    this.pPb = 0;
    this.pPc = 0;
    this.pPd = 0;
    this.pPe = 0;
    this.pPf = 0;
    this.pPg = 0;
    this.pPh = 0;
    this.pPi = 0;
    this.pPj = 0;
    this.pPk = 0;
    this.pPl = 0;
    this.pPm = 0;
    this.pPn = 0;
    this.pPo = 0;
    this.pPp = 0;
    this.cXP = 0;
    this.pNr = 0;
    this.pPq = 0;
    this.pPr = 0;
    this.pPs = new HashMap();
    this.pPt = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.pPb = 0;
    this.pPc = 0;
    this.pPd = 0;
    this.pPe = 0;
    this.pPf = 0;
    this.pPg = 0;
    this.pPh = 0;
    this.pPi = 0;
    this.pPj = 0;
    this.pPk = 0;
    this.pPl = 0;
    this.pPm = 0;
    this.pPn = 0;
    this.pPo = 0;
    this.pPp = 0;
    this.cXP = 0;
    this.pNr = 0;
    this.pPq = 0;
    this.pPr = 0;
    this.pPs = new HashMap();
    this.pPt = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.pPb = paramParcel.readInt();
    this.pPc = paramParcel.readInt();
    this.pPd = paramParcel.readInt();
    this.pPe = paramParcel.readInt();
    this.pPf = paramParcel.readInt();
    this.pPg = paramParcel.readInt();
    this.pPh = paramParcel.readInt();
    this.pPi = paramParcel.readInt();
    this.pPj = paramParcel.readInt();
    this.pPk = paramParcel.readInt();
    this.pPl = paramParcel.readInt();
    this.pPm = paramParcel.readInt();
    this.pPn = paramParcel.readInt();
    this.pPo = paramParcel.readInt();
    this.pPp = paramParcel.readInt();
    this.cXP = paramParcel.readInt();
    this.pNr = paramParcel.readInt();
    this.pPq = paramParcel.readInt();
    this.pPr = paramParcel.readInt();
    try
    {
      this.pPs = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.pPt = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      ad.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void BX(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.pPc += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.pPd += 1;
        return;
      }
      this.pPc += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.pPe += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.pPg += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.pPh += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.pPi += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.pPm += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.pPj += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.pPk += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.pPl += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.pPf += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.pPn += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.pPo += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.pPp += 1;
      return;
    }
    this.pPb += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.pPc = 0;
    this.pPd = 0;
    this.pPe = 0;
    this.pPb = 0;
    this.pPf = 0;
    this.pPg = 0;
    this.pPh = 0;
    this.pPi = 0;
    this.pPj = 0;
    this.pPk = 0;
    this.pPl = 0;
    this.pPm = 0;
    this.pPn = 0;
    this.cXP = 0;
    this.pNr = 0;
    this.pPq = 0;
    this.pPr = 0;
    this.pPs.clear();
    this.pPt.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.pPc + ", motionOk: " + this.pPd + ", noFace: " + this.pPe + ", systemErr: " + this.pPb + ", noLiveFace: " + this.pPf + ", tooDark: " + this.pPg + ", tooLight: " + this.pPh + ", backLight: " + this.pPi + ", tooSmall: " + this.pPj + ", tooBig: " + this.pPk + ", tooActive: " + this.pPl + ", poseNotValid: " + this.pPm + ", timeOut: " + this.pPn + ", totalFrame: " + this.cXP + ", verifyTime: " + this.pNr + ", processTimePerFrame: " + this.pPr;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.pPb);
    paramParcel.writeInt(this.pPc);
    paramParcel.writeInt(this.pPd);
    paramParcel.writeInt(this.pPe);
    paramParcel.writeInt(this.pPf);
    paramParcel.writeInt(this.pPg);
    paramParcel.writeInt(this.pPh);
    paramParcel.writeInt(this.pPi);
    paramParcel.writeInt(this.pPj);
    paramParcel.writeInt(this.pPk);
    paramParcel.writeInt(this.pPl);
    paramParcel.writeInt(this.pPm);
    paramParcel.writeInt(this.pPn);
    paramParcel.writeInt(this.pPo);
    paramParcel.writeInt(this.pPp);
    paramParcel.writeInt(this.cXP);
    paramParcel.writeInt(this.pNr);
    paramParcel.writeInt(this.pPq);
    paramParcel.writeInt(this.pPr);
    paramParcel.writeMap(this.pPs);
    paramParcel.writeMap(this.pPt);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */