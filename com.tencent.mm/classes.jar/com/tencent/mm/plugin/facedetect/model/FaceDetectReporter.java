package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter pPz;
  public String appId;
  private long pPA;
  public long pPB;
  public long pPC;
  public int pPD;
  public boolean pPE;
  public boolean pPu;
  private FaceDetectReportInfo pPv;
  public int pPw;
  public int pPx;
  public int pPy;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(103767);
    pPz = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.pPu = false;
    this.pPv = null;
    this.appId = "";
    this.pPw = -1;
    this.pPx = 0;
    this.pPy = 0;
    this.pPA = 0L;
    this.pPB = -1L;
    this.pPC = -1L;
    this.pPD = 0;
    this.pPE = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.pPu = false;
    this.pPv = null;
    this.appId = "";
    this.pPw = -1;
    this.pPx = 0;
    this.pPy = 0;
    this.pPA = 0L;
    this.pPB = -1L;
    this.pPC = -1L;
    this.pPD = 0;
    this.pPE = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.pPu = bool1;
      this.pPv = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.pPw = paramParcel.readInt();
      this.pPx = paramParcel.readInt();
      this.pPy = paramParcel.readInt();
      this.pPA = paramParcel.readLong();
      this.pPB = paramParcel.readLong();
      this.pPC = paramParcel.readLong();
      this.pPD = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pPE = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int BY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
    case 3: 
      return 2;
    case 1: 
    case 4: 
      return 3;
    case 5: 
      return 4;
    }
    return 1;
  }
  
  public static FaceDetectReporter cfV()
  {
    AppMethodBeat.i(103755);
    if (pPz == null) {
      try
      {
        if (pPz == null) {
          pPz = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = pPz;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = pPz;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    ad.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.vKh.f(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.pPv != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.pPv;
      localFaceDetectReportInfo.cXP += 1;
      localFaceDetectReportInfo = this.pPv;
      localFaceDetectReportInfo.pPq = ((int)(localFaceDetectReportInfo.pPq + paramLong));
      this.pPv.BX(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.pPv != null)
    {
      ad.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.pPv.pPs.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(103761);
    a(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(103761);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(103762);
    ad.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.pPu), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i;
    if ((this.pPv != null) && (!this.pPu))
    {
      ad.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.pPv.toString() });
      this.pPu = true;
      this.pPv.pNr = paramInt5;
      if (this.pPv.cXP != 0) {
        this.pPv.pPr = (this.pPv.pPq / this.pPv.cXP);
      }
      paramInt5 = 0;
      i = paramInt5;
      if (this.pPv.pPs.containsKey(Integer.valueOf(0)))
      {
        i = paramInt5;
        if (this.pPv.pPt.containsKey(Integer.valueOf(0)))
        {
          i = (int)(((Long)this.pPv.pPt.get(Integer.valueOf(0))).longValue() - ((Long)this.pPv.pPs.get(Integer.valueOf(0))).longValue());
          ad.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i + "  hashCode :" + hashCode());
        }
      }
      if ((!this.pPv.pPs.containsKey(Integer.valueOf(4))) || (!this.pPv.pPt.containsKey(Integer.valueOf(4)))) {
        break label938;
      }
      paramInt5 = (int)(((Long)this.pPv.pPt.get(Integer.valueOf(4))).longValue() - ((Long)this.pPv.pPs.get(Integer.valueOf(4))).longValue());
      ad.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + paramInt5 + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int j = paramInt5;
      if (this.pPv.pPs.containsKey(Integer.valueOf(6)))
      {
        j = paramInt5;
        if (this.pPv.pPt.containsKey(Integer.valueOf(6)))
        {
          j = (int)(((Long)this.pPv.pPt.get(Integer.valueOf(6))).longValue() - ((Long)this.pPv.pPs.get(Integer.valueOf(6))).longValue());
          ad.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + j + "  hashCode :" + hashCode());
        }
      }
      ad.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(hashCode()) });
      h localh = h.vKh;
      long l = this.sessionId;
      if (paramBoolean) {}
      for (paramInt5 = 1;; paramInt5 = 0)
      {
        localh.f(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.pPv.pPc), Integer.valueOf(this.pPv.pPd), Integer.valueOf(this.pPv.pPe), Integer.valueOf(this.pPv.pPb), Integer.valueOf(this.pPv.pPf), Integer.valueOf(this.pPv.pPg), Integer.valueOf(this.pPv.pPh), Integer.valueOf(this.pPv.pPi), Integer.valueOf(this.pPv.pPj), Integer.valueOf(this.pPv.pPk), Integer.valueOf(this.pPv.pPl), Integer.valueOf(this.pPv.pPm), Integer.valueOf(this.pPv.pPn), Integer.valueOf(this.pPv.pNr), Integer.valueOf(this.pPv.pPo), Integer.valueOf(this.pPv.pPp), Integer.valueOf(this.pPv.pPr), Integer.valueOf(i), Integer.valueOf(j), this.appId, Integer.valueOf(this.pPw), Integer.valueOf(this.pPx), Integer.valueOf(this.pPy) });
        AppMethodBeat.o(103762);
        return;
      }
      label938:
      paramInt5 = 0;
    }
  }
  
  public final void a(FaceDetectReporter paramFaceDetectReporter)
  {
    AppMethodBeat.i(103759);
    ad.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bt.eGN().toString() });
    this.pPv = paramFaceDetectReporter.pPv;
    this.pPu = paramFaceDetectReporter.pPu;
    this.sessionId = paramFaceDetectReporter.sessionId;
    this.pPx = paramFaceDetectReporter.pPx;
    this.pPy = paramFaceDetectReporter.pPy;
    long l = this.sessionId;
    if (this.pPv != null) {}
    for (paramFaceDetectReporter = this.pPv.toString();; paramFaceDetectReporter = "null")
    {
      ad.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      AppMethodBeat.o(103759);
      return;
    }
  }
  
  public final void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.pPv != null)
    {
      ad.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.pPv.pPt.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(103760);
    ad.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    h localh = h.vKh;
    long l = this.sessionId;
    if (paramBoolean) {}
    for (;;)
    {
      localh.f(14005, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(103760);
      return;
      i = 0;
    }
  }
  
  public final void cS(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    h localh;
    long l2;
    String str;
    if ((this.pPB == -1L) || (this.pPC == -1L) || (this.pPC < this.pPB))
    {
      ad.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.pPB), Long.valueOf(this.pPC) });
      ad.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.pPA), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.pPE), this.appId, Integer.valueOf(this.pPD) });
      localh = h.vKh;
      l2 = this.pPA;
      str = this.appId;
      if (!this.pPE) {
        break label273;
      }
    }
    for (;;)
    {
      localh.f(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.pPD) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.pPC - this.pPB;
      break;
      label273:
      i = 0;
    }
  }
  
  public final long cfW()
  {
    AppMethodBeat.i(103757);
    ad.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.pPv == null) {
      this.pPv = new FaceDetectReportInfo();
    }
    this.pPv.reset();
    this.pPu = false;
    this.sessionId = System.currentTimeMillis();
    this.pPv.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public final long cfX()
  {
    AppMethodBeat.i(103758);
    ad.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.pPA = System.currentTimeMillis();
    this.pPD = 0;
    this.pPE = false;
    this.pPB = -1L;
    this.pPC = -1L;
    long l = this.pPA;
    AppMethodBeat.o(103758);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(103754);
    paramParcel.writeLong(this.sessionId);
    int i;
    if (this.pPu)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.pPv, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.pPw);
      paramParcel.writeInt(this.pPx);
      paramParcel.writeInt(this.pPy);
      paramParcel.writeLong(this.pPA);
      paramParcel.writeLong(this.pPB);
      paramParcel.writeLong(this.pPC);
      paramParcel.writeInt(this.pPD);
      if (!this.pPE) {
        break label133;
      }
    }
    label133:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(103754);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReporter
 * JD-Core Version:    0.7.0.1
 */