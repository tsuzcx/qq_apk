package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int dyP;
  protected int sPx;
  protected int sRb;
  protected int sRc;
  protected int sRd;
  protected int sRe;
  protected int sRf;
  protected int sRg;
  protected int sRh;
  protected int sRi;
  protected int sRj;
  protected int sRk;
  protected int sRl;
  protected int sRm;
  protected int sRn;
  protected int sRo;
  protected int sRp;
  protected int sRq;
  protected HashMap<Integer, Long> sRr;
  protected HashMap<Integer, Long> sRs;
  protected long sessionId;
  protected int unstableCount;
  
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
    this.sRb = 0;
    this.sRc = 0;
    this.sRd = 0;
    this.sRe = 0;
    this.sRf = 0;
    this.sRg = 0;
    this.sRh = 0;
    this.sRi = 0;
    this.sRj = 0;
    this.sRk = 0;
    this.sRl = 0;
    this.sRm = 0;
    this.sRn = 0;
    this.sRo = 0;
    this.unstableCount = 0;
    this.dyP = 0;
    this.sPx = 0;
    this.sRp = 0;
    this.sRq = 0;
    this.sRr = new HashMap();
    this.sRs = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.sRb = 0;
    this.sRc = 0;
    this.sRd = 0;
    this.sRe = 0;
    this.sRf = 0;
    this.sRg = 0;
    this.sRh = 0;
    this.sRi = 0;
    this.sRj = 0;
    this.sRk = 0;
    this.sRl = 0;
    this.sRm = 0;
    this.sRn = 0;
    this.sRo = 0;
    this.unstableCount = 0;
    this.dyP = 0;
    this.sPx = 0;
    this.sRp = 0;
    this.sRq = 0;
    this.sRr = new HashMap();
    this.sRs = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.sRb = paramParcel.readInt();
    this.sRc = paramParcel.readInt();
    this.sRd = paramParcel.readInt();
    this.sRe = paramParcel.readInt();
    this.sRf = paramParcel.readInt();
    this.sRg = paramParcel.readInt();
    this.sRh = paramParcel.readInt();
    this.sRi = paramParcel.readInt();
    this.sRj = paramParcel.readInt();
    this.sRk = paramParcel.readInt();
    this.sRl = paramParcel.readInt();
    this.sRm = paramParcel.readInt();
    this.sRn = paramParcel.readInt();
    this.sRo = paramParcel.readInt();
    this.unstableCount = paramParcel.readInt();
    this.dyP = paramParcel.readInt();
    this.sPx = paramParcel.readInt();
    this.sRp = paramParcel.readInt();
    this.sRq = paramParcel.readInt();
    try
    {
      this.sRr = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.sRs = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void HJ(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.sRc += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.sRd += 1;
        return;
      }
      this.sRc += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.sRe += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.sRg += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.sRh += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.sRi += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.sRm += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.sRj += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.sRk += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.sRl += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.sRf += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.sRn += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.sRo += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.unstableCount += 1;
      return;
    }
    this.sRb += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.sRc = 0;
    this.sRd = 0;
    this.sRe = 0;
    this.sRb = 0;
    this.sRf = 0;
    this.sRg = 0;
    this.sRh = 0;
    this.sRi = 0;
    this.sRj = 0;
    this.sRk = 0;
    this.sRl = 0;
    this.sRm = 0;
    this.sRn = 0;
    this.dyP = 0;
    this.sPx = 0;
    this.sRp = 0;
    this.sRq = 0;
    this.sRr.clear();
    this.sRs.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.sRc + ", motionOk: " + this.sRd + ", noFace: " + this.sRe + ", systemErr: " + this.sRb + ", noLiveFace: " + this.sRf + ", tooDark: " + this.sRg + ", tooLight: " + this.sRh + ", backLight: " + this.sRi + ", tooSmall: " + this.sRj + ", tooBig: " + this.sRk + ", tooActive: " + this.sRl + ", poseNotValid: " + this.sRm + ", timeOut: " + this.sRn + ", totalFrame: " + this.dyP + ", verifyTime: " + this.sPx + ", processTimePerFrame: " + this.sRq;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.sRb);
    paramParcel.writeInt(this.sRc);
    paramParcel.writeInt(this.sRd);
    paramParcel.writeInt(this.sRe);
    paramParcel.writeInt(this.sRf);
    paramParcel.writeInt(this.sRg);
    paramParcel.writeInt(this.sRh);
    paramParcel.writeInt(this.sRi);
    paramParcel.writeInt(this.sRj);
    paramParcel.writeInt(this.sRk);
    paramParcel.writeInt(this.sRl);
    paramParcel.writeInt(this.sRm);
    paramParcel.writeInt(this.sRn);
    paramParcel.writeInt(this.sRo);
    paramParcel.writeInt(this.unstableCount);
    paramParcel.writeInt(this.dyP);
    paramParcel.writeInt(this.sPx);
    paramParcel.writeInt(this.sRp);
    paramParcel.writeInt(this.sRq);
    paramParcel.writeMap(this.sRr);
    paramParcel.writeMap(this.sRs);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */