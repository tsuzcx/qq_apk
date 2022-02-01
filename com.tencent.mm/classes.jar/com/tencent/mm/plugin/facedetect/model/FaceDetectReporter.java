package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter rqb;
  public String appId;
  public boolean rpW;
  private FaceDetectReportInfo rpX;
  public int rpY;
  public int rpZ;
  public int rqa;
  private long rqc;
  public long rqd;
  public long rqe;
  public int rqf;
  public boolean rqg;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(103767);
    rqb = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.rpW = false;
    this.rpX = null;
    this.appId = "";
    this.rpY = -1;
    this.rpZ = 0;
    this.rqa = 0;
    this.rqc = 0L;
    this.rqd = -1L;
    this.rqe = -1L;
    this.rqf = 0;
    this.rqg = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.rpW = false;
    this.rpX = null;
    this.appId = "";
    this.rpY = -1;
    this.rpZ = 0;
    this.rqa = 0;
    this.rqc = 0L;
    this.rqd = -1L;
    this.rqe = -1L;
    this.rqf = 0;
    this.rqg = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.rpW = bool1;
      this.rpX = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.rpY = paramParcel.readInt();
      this.rpZ = paramParcel.readInt();
      this.rqa = paramParcel.readInt();
      this.rqc = paramParcel.readLong();
      this.rqd = paramParcel.readLong();
      this.rqe = paramParcel.readLong();
      this.rqf = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.rqg = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int DY(int paramInt)
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
  
  public static FaceDetectReporter cuI()
  {
    AppMethodBeat.i(103755);
    if (rqb == null) {
      try
      {
        if (rqb == null) {
          rqb = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = rqb;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = rqb;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    ae.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.yxI.f(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.rpX != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.rpX;
      localFaceDetectReportInfo.dhD += 1;
      localFaceDetectReportInfo = this.rpX;
      localFaceDetectReportInfo.rpS = ((int)(localFaceDetectReportInfo.rpS + paramLong));
      this.rpX.DX(paramInt);
    }
    AppMethodBeat.o(103764);
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
    ae.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.rpW), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i;
    if ((this.rpX != null) && (!this.rpW))
    {
      ae.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.rpX.toString() });
      this.rpW = true;
      this.rpX.rnS = paramInt5;
      if (this.rpX.dhD != 0) {
        this.rpX.rpT = (this.rpX.rpS / this.rpX.dhD);
      }
      paramInt5 = 0;
      i = paramInt5;
      if (this.rpX.rpU.containsKey(Integer.valueOf(0)))
      {
        i = paramInt5;
        if (this.rpX.rpV.containsKey(Integer.valueOf(0)))
        {
          i = (int)(((Long)this.rpX.rpV.get(Integer.valueOf(0))).longValue() - ((Long)this.rpX.rpU.get(Integer.valueOf(0))).longValue());
          ae.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i + "  hashCode :" + hashCode());
        }
      }
      if ((!this.rpX.rpU.containsKey(Integer.valueOf(4))) || (!this.rpX.rpV.containsKey(Integer.valueOf(4)))) {
        break label938;
      }
      paramInt5 = (int)(((Long)this.rpX.rpV.get(Integer.valueOf(4))).longValue() - ((Long)this.rpX.rpU.get(Integer.valueOf(4))).longValue());
      ae.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + paramInt5 + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int j = paramInt5;
      if (this.rpX.rpU.containsKey(Integer.valueOf(6)))
      {
        j = paramInt5;
        if (this.rpX.rpV.containsKey(Integer.valueOf(6)))
        {
          j = (int)(((Long)this.rpX.rpV.get(Integer.valueOf(6))).longValue() - ((Long)this.rpX.rpU.get(Integer.valueOf(6))).longValue());
          ae.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + j + "  hashCode :" + hashCode());
        }
      }
      ae.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(hashCode()) });
      g localg = g.yxI;
      long l = this.sessionId;
      if (paramBoolean) {}
      for (paramInt5 = 1;; paramInt5 = 0)
      {
        localg.f(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.rpX.rpE), Integer.valueOf(this.rpX.rpF), Integer.valueOf(this.rpX.rpG), Integer.valueOf(this.rpX.rpD), Integer.valueOf(this.rpX.rpH), Integer.valueOf(this.rpX.rpI), Integer.valueOf(this.rpX.rpJ), Integer.valueOf(this.rpX.rpK), Integer.valueOf(this.rpX.rpL), Integer.valueOf(this.rpX.rpM), Integer.valueOf(this.rpX.rpN), Integer.valueOf(this.rpX.rpO), Integer.valueOf(this.rpX.rpP), Integer.valueOf(this.rpX.rnS), Integer.valueOf(this.rpX.rpQ), Integer.valueOf(this.rpX.rpR), Integer.valueOf(this.rpX.rpT), Integer.valueOf(i), Integer.valueOf(j), this.appId, Integer.valueOf(this.rpY), Integer.valueOf(this.rpZ), Integer.valueOf(this.rqa) });
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
    ae.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bu.fpN().toString() });
    this.rpX = paramFaceDetectReporter.rpX;
    this.rpW = paramFaceDetectReporter.rpW;
    this.sessionId = paramFaceDetectReporter.sessionId;
    this.rpZ = paramFaceDetectReporter.rpZ;
    this.rqa = paramFaceDetectReporter.rqa;
    long l = this.sessionId;
    if (this.rpX != null) {}
    for (paramFaceDetectReporter = this.rpX.toString();; paramFaceDetectReporter = "null")
    {
      ae.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      AppMethodBeat.o(103759);
      return;
    }
  }
  
  public final void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.rpX != null)
    {
      ae.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.rpX.rpU.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.rpX != null)
    {
      ae.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.rpX.rpV.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(103760);
    ae.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    g localg = g.yxI;
    long l = this.sessionId;
    if (paramBoolean) {}
    for (;;)
    {
      localg.f(14005, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(103760);
      return;
      i = 0;
    }
  }
  
  public final long cuJ()
  {
    AppMethodBeat.i(103757);
    ae.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.rpX == null) {
      this.rpX = new FaceDetectReportInfo();
    }
    this.rpX.reset();
    this.rpW = false;
    this.sessionId = System.currentTimeMillis();
    this.rpX.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public final long cuK()
  {
    AppMethodBeat.i(103758);
    ae.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.rqc = System.currentTimeMillis();
    this.rqf = 0;
    this.rqg = false;
    this.rqd = -1L;
    this.rqe = -1L;
    long l = this.rqc;
    AppMethodBeat.o(103758);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void dl(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    g localg;
    long l2;
    String str;
    if ((this.rqd == -1L) || (this.rqe == -1L) || (this.rqe < this.rqd))
    {
      ae.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.rqd), Long.valueOf(this.rqe) });
      ae.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.rqc), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.rqg), this.appId, Integer.valueOf(this.rqf) });
      localg = g.yxI;
      l2 = this.rqc;
      str = this.appId;
      if (!this.rqg) {
        break label273;
      }
    }
    for (;;)
    {
      localg.f(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.rqf) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.rqe - this.rqd;
      break;
      label273:
      i = 0;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(103754);
    paramParcel.writeLong(this.sessionId);
    int i;
    if (this.rpW)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.rpX, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.rpY);
      paramParcel.writeInt(this.rpZ);
      paramParcel.writeInt(this.rqa);
      paramParcel.writeLong(this.rqc);
      paramParcel.writeLong(this.rqd);
      paramParcel.writeLong(this.rqe);
      paramParcel.writeInt(this.rqf);
      if (!this.rqg) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReporter
 * JD-Core Version:    0.7.0.1
 */