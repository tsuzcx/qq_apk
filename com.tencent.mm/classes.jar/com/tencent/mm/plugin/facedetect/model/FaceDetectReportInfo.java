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
  protected int hvP;
  protected long sessionId;
  protected int unstableCount;
  protected int zRw;
  protected int zTd;
  protected int zTe;
  protected int zTf;
  protected int zTg;
  protected int zTh;
  protected int zTi;
  protected int zTj;
  protected int zTk;
  protected int zTl;
  protected int zTm;
  protected int zTn;
  protected int zTo;
  protected int zTp;
  protected int zTq;
  protected int zTr;
  protected int zTs;
  protected HashMap<Integer, Long> zTt;
  protected HashMap<Integer, Long> zTu;
  
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
    this.zTd = 0;
    this.zTe = 0;
    this.zTf = 0;
    this.zTg = 0;
    this.zTh = 0;
    this.zTi = 0;
    this.zTj = 0;
    this.zTk = 0;
    this.zTl = 0;
    this.zTm = 0;
    this.zTn = 0;
    this.zTo = 0;
    this.zTp = 0;
    this.zTq = 0;
    this.unstableCount = 0;
    this.hvP = 0;
    this.zRw = 0;
    this.zTr = 0;
    this.zTs = 0;
    this.zTt = new HashMap();
    this.zTu = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.zTd = 0;
    this.zTe = 0;
    this.zTf = 0;
    this.zTg = 0;
    this.zTh = 0;
    this.zTi = 0;
    this.zTj = 0;
    this.zTk = 0;
    this.zTl = 0;
    this.zTm = 0;
    this.zTn = 0;
    this.zTo = 0;
    this.zTp = 0;
    this.zTq = 0;
    this.unstableCount = 0;
    this.hvP = 0;
    this.zRw = 0;
    this.zTr = 0;
    this.zTs = 0;
    this.zTt = new HashMap();
    this.zTu = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.zTd = paramParcel.readInt();
    this.zTe = paramParcel.readInt();
    this.zTf = paramParcel.readInt();
    this.zTg = paramParcel.readInt();
    this.zTh = paramParcel.readInt();
    this.zTi = paramParcel.readInt();
    this.zTj = paramParcel.readInt();
    this.zTk = paramParcel.readInt();
    this.zTl = paramParcel.readInt();
    this.zTm = paramParcel.readInt();
    this.zTn = paramParcel.readInt();
    this.zTo = paramParcel.readInt();
    this.zTp = paramParcel.readInt();
    this.zTq = paramParcel.readInt();
    this.unstableCount = paramParcel.readInt();
    this.hvP = paramParcel.readInt();
    this.zRw = paramParcel.readInt();
    this.zTr = paramParcel.readInt();
    this.zTs = paramParcel.readInt();
    try
    {
      this.zTt = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.zTu = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void Mq(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.zTe += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.zTf += 1;
        return;
      }
      this.zTe += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.zTg += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.zTi += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.zTj += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.zTk += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.zTo += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.zTl += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.zTm += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.zTn += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.zTh += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.zTp += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.zTq += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.unstableCount += 1;
      return;
    }
    this.zTd += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.zTe = 0;
    this.zTf = 0;
    this.zTg = 0;
    this.zTd = 0;
    this.zTh = 0;
    this.zTi = 0;
    this.zTj = 0;
    this.zTk = 0;
    this.zTl = 0;
    this.zTm = 0;
    this.zTn = 0;
    this.zTo = 0;
    this.zTp = 0;
    this.hvP = 0;
    this.zRw = 0;
    this.zTr = 0;
    this.zTs = 0;
    this.zTt.clear();
    this.zTu.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.zTe + ", motionOk: " + this.zTf + ", noFace: " + this.zTg + ", systemErr: " + this.zTd + ", noLiveFace: " + this.zTh + ", tooDark: " + this.zTi + ", tooLight: " + this.zTj + ", backLight: " + this.zTk + ", tooSmall: " + this.zTl + ", tooBig: " + this.zTm + ", tooActive: " + this.zTn + ", poseNotValid: " + this.zTo + ", timeOut: " + this.zTp + ", totalFrame: " + this.hvP + ", verifyTime: " + this.zRw + ", processTimePerFrame: " + this.zTs;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.zTd);
    paramParcel.writeInt(this.zTe);
    paramParcel.writeInt(this.zTf);
    paramParcel.writeInt(this.zTg);
    paramParcel.writeInt(this.zTh);
    paramParcel.writeInt(this.zTi);
    paramParcel.writeInt(this.zTj);
    paramParcel.writeInt(this.zTk);
    paramParcel.writeInt(this.zTl);
    paramParcel.writeInt(this.zTm);
    paramParcel.writeInt(this.zTn);
    paramParcel.writeInt(this.zTo);
    paramParcel.writeInt(this.zTp);
    paramParcel.writeInt(this.zTq);
    paramParcel.writeInt(this.unstableCount);
    paramParcel.writeInt(this.hvP);
    paramParcel.writeInt(this.zRw);
    paramParcel.writeInt(this.zTr);
    paramParcel.writeInt(this.zTs);
    paramParcel.writeMap(this.zTt);
    paramParcel.writeMap(this.zTu);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */