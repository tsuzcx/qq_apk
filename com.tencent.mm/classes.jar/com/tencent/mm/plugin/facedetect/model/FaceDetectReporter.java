package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter rhX;
  public String appId;
  public boolean rhS;
  private FaceDetectReportInfo rhT;
  public int rhU;
  public int rhV;
  public int rhW;
  private long rhY;
  public long rhZ;
  public long ria;
  public int rib;
  public boolean ric;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(103767);
    rhX = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.rhS = false;
    this.rhT = null;
    this.appId = "";
    this.rhU = -1;
    this.rhV = 0;
    this.rhW = 0;
    this.rhY = 0L;
    this.rhZ = -1L;
    this.ria = -1L;
    this.rib = 0;
    this.ric = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.rhS = false;
    this.rhT = null;
    this.appId = "";
    this.rhU = -1;
    this.rhV = 0;
    this.rhW = 0;
    this.rhY = 0L;
    this.rhZ = -1L;
    this.ria = -1L;
    this.rib = 0;
    this.ric = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.rhS = bool1;
      this.rhT = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.rhU = paramParcel.readInt();
      this.rhV = paramParcel.readInt();
      this.rhW = paramParcel.readInt();
      this.rhY = paramParcel.readLong();
      this.rhZ = paramParcel.readLong();
      this.ria = paramParcel.readLong();
      this.rib = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ric = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int DL(int paramInt)
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
  
  public static FaceDetectReporter cth()
  {
    AppMethodBeat.i(103755);
    if (rhX == null) {
      try
      {
        if (rhX == null) {
          rhX = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = rhX;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = rhX;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    ad.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.yhR.f(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
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
    ad.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.rhS), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i;
    if ((this.rhT != null) && (!this.rhS))
    {
      ad.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.rhT.toString() });
      this.rhS = true;
      this.rhT.rfP = paramInt5;
      if (this.rhT.dgB != 0) {
        this.rhT.rhP = (this.rhT.rhO / this.rhT.dgB);
      }
      paramInt5 = 0;
      i = paramInt5;
      if (this.rhT.rhQ.containsKey(Integer.valueOf(0)))
      {
        i = paramInt5;
        if (this.rhT.rhR.containsKey(Integer.valueOf(0)))
        {
          i = (int)(((Long)this.rhT.rhR.get(Integer.valueOf(0))).longValue() - ((Long)this.rhT.rhQ.get(Integer.valueOf(0))).longValue());
          ad.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i + "  hashCode :" + hashCode());
        }
      }
      if ((!this.rhT.rhQ.containsKey(Integer.valueOf(4))) || (!this.rhT.rhR.containsKey(Integer.valueOf(4)))) {
        break label938;
      }
      paramInt5 = (int)(((Long)this.rhT.rhR.get(Integer.valueOf(4))).longValue() - ((Long)this.rhT.rhQ.get(Integer.valueOf(4))).longValue());
      ad.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + paramInt5 + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int j = paramInt5;
      if (this.rhT.rhQ.containsKey(Integer.valueOf(6)))
      {
        j = paramInt5;
        if (this.rhT.rhR.containsKey(Integer.valueOf(6)))
        {
          j = (int)(((Long)this.rhT.rhR.get(Integer.valueOf(6))).longValue() - ((Long)this.rhT.rhQ.get(Integer.valueOf(6))).longValue());
          ad.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + j + "  hashCode :" + hashCode());
        }
      }
      ad.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(hashCode()) });
      g localg = g.yhR;
      long l = this.sessionId;
      if (paramBoolean) {}
      for (paramInt5 = 1;; paramInt5 = 0)
      {
        localg.f(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.rhT.rhA), Integer.valueOf(this.rhT.rhB), Integer.valueOf(this.rhT.rhC), Integer.valueOf(this.rhT.rhz), Integer.valueOf(this.rhT.rhD), Integer.valueOf(this.rhT.rhE), Integer.valueOf(this.rhT.rhF), Integer.valueOf(this.rhT.rhG), Integer.valueOf(this.rhT.rhH), Integer.valueOf(this.rhT.rhI), Integer.valueOf(this.rhT.rhJ), Integer.valueOf(this.rhT.rhK), Integer.valueOf(this.rhT.rhL), Integer.valueOf(this.rhT.rfP), Integer.valueOf(this.rhT.rhM), Integer.valueOf(this.rhT.rhN), Integer.valueOf(this.rhT.rhP), Integer.valueOf(i), Integer.valueOf(j), this.appId, Integer.valueOf(this.rhU), Integer.valueOf(this.rhV), Integer.valueOf(this.rhW) });
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
    ad.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bt.flS().toString() });
    this.rhT = paramFaceDetectReporter.rhT;
    this.rhS = paramFaceDetectReporter.rhS;
    this.sessionId = paramFaceDetectReporter.sessionId;
    this.rhV = paramFaceDetectReporter.rhV;
    this.rhW = paramFaceDetectReporter.rhW;
    long l = this.sessionId;
    if (this.rhT != null) {}
    for (paramFaceDetectReporter = this.rhT.toString();; paramFaceDetectReporter = "null")
    {
      ad.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      AppMethodBeat.o(103759);
      return;
    }
  }
  
  public final void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.rhT != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.rhT;
      localFaceDetectReportInfo.dgB += 1;
      localFaceDetectReportInfo = this.rhT;
      localFaceDetectReportInfo.rhO = ((int)(localFaceDetectReportInfo.rhO + paramLong));
      this.rhT.DK(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.rhT != null)
    {
      ad.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.rhT.rhQ.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(103760);
    ad.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    g localg = g.yhR;
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
  
  public final void ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.rhT != null)
    {
      ad.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.rhT.rhR.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final long cti()
  {
    AppMethodBeat.i(103757);
    ad.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.rhT == null) {
      this.rhT = new FaceDetectReportInfo();
    }
    this.rhT.reset();
    this.rhS = false;
    this.sessionId = System.currentTimeMillis();
    this.rhT.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public final long ctj()
  {
    AppMethodBeat.i(103758);
    ad.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.rhY = System.currentTimeMillis();
    this.rib = 0;
    this.ric = false;
    this.rhZ = -1L;
    this.ria = -1L;
    long l = this.rhY;
    AppMethodBeat.o(103758);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void dh(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    g localg;
    long l2;
    String str;
    if ((this.rhZ == -1L) || (this.ria == -1L) || (this.ria < this.rhZ))
    {
      ad.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.rhZ), Long.valueOf(this.ria) });
      ad.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.rhY), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.ric), this.appId, Integer.valueOf(this.rib) });
      localg = g.yhR;
      l2 = this.rhY;
      str = this.appId;
      if (!this.ric) {
        break label273;
      }
    }
    for (;;)
    {
      localg.f(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.rib) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.ria - this.rhZ;
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
    if (this.rhS)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.rhT, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.rhU);
      paramParcel.writeInt(this.rhV);
      paramParcel.writeInt(this.rhW);
      paramParcel.writeLong(this.rhY);
      paramParcel.writeLong(this.rhZ);
      paramParcel.writeLong(this.ria);
      paramParcel.writeInt(this.rib);
      if (!this.ric) {
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