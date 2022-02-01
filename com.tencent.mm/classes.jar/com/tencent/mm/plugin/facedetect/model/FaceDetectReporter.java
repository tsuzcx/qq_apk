package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter sRy;
  String appId;
  long sRA;
  public long sRB;
  int sRC;
  boolean sRD;
  public boolean sRt;
  public FaceDetectReportInfo sRu;
  private int sRv;
  public int sRw;
  public int sRx;
  long sRz;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(103767);
    sRy = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.sRt = false;
    this.sRu = null;
    this.appId = "";
    this.sRv = -1;
    this.sRw = 0;
    this.sRx = 0;
    this.sRz = 0L;
    this.sRA = -1L;
    this.sRB = -1L;
    this.sRC = 0;
    this.sRD = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.sRt = false;
    this.sRu = null;
    this.appId = "";
    this.sRv = -1;
    this.sRw = 0;
    this.sRx = 0;
    this.sRz = 0L;
    this.sRA = -1L;
    this.sRB = -1L;
    this.sRC = 0;
    this.sRD = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.sRt = bool1;
      this.sRu = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.sRv = paramParcel.readInt();
      this.sRw = paramParcel.readInt();
      this.sRx = paramParcel.readInt();
      this.sRz = paramParcel.readLong();
      this.sRA = paramParcel.readLong();
      this.sRB = paramParcel.readLong();
      this.sRC = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sRD = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int HK(int paramInt)
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
  
  public static FaceDetectReporter cTe()
  {
    AppMethodBeat.i(103755);
    if (sRy == null) {
      try
      {
        if (sRy == null) {
          sRy = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = sRy;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = sRy;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    Log.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.CyF.a(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.sRu != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.sRu;
      localFaceDetectReportInfo.dyP += 1;
      localFaceDetectReportInfo = this.sRu;
      localFaceDetectReportInfo.sRp = ((int)(localFaceDetectReportInfo.sRp + paramLong));
      this.sRu.HJ(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(186368);
    Log.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.sRt), Integer.valueOf(paramInt1), Boolean.FALSE, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int j;
    if ((this.sRu != null) && (!this.sRt))
    {
      Log.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.sRu.toString() });
      this.sRt = true;
      this.sRu.sPx = 0;
      if (this.sRu.dyP != 0) {
        this.sRu.sRq = (this.sRu.sRp / this.sRu.dyP);
      }
      if ((!this.sRu.sRr.containsKey(Integer.valueOf(0))) || (!this.sRu.sRs.containsKey(Integer.valueOf(0)))) {
        break label905;
      }
      j = (int)(((Long)this.sRu.sRs.get(Integer.valueOf(0))).longValue() - ((Long)this.sRu.sRr.get(Integer.valueOf(0))).longValue());
      Log.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + j + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int i;
      if ((this.sRu.sRr.containsKey(Integer.valueOf(4))) && (this.sRu.sRs.containsKey(Integer.valueOf(4))))
      {
        i = (int)(((Long)this.sRu.sRs.get(Integer.valueOf(4))).longValue() - ((Long)this.sRu.sRr.get(Integer.valueOf(4))).longValue());
        Log.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + i + "  hashCode :" + hashCode());
      }
      for (;;)
      {
        int k = i;
        if (this.sRu.sRr.containsKey(Integer.valueOf(6)))
        {
          k = i;
          if (this.sRu.sRs.containsKey(Integer.valueOf(6)))
          {
            k = (int)(((Long)this.sRu.sRs.get(Integer.valueOf(6))).longValue() - ((Long)this.sRu.sRr.get(Integer.valueOf(6))).longValue());
            Log.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + k + "  hashCode :" + hashCode());
          }
        }
        Log.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(hashCode()) });
        h.CyF.a(14006, new Object[] { Long.valueOf(this.sessionId), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.sRu.sRc), Integer.valueOf(this.sRu.sRd), Integer.valueOf(this.sRu.sRe), Integer.valueOf(this.sRu.sRb), Integer.valueOf(this.sRu.sRf), Integer.valueOf(this.sRu.sRg), Integer.valueOf(this.sRu.sRh), Integer.valueOf(this.sRu.sRi), Integer.valueOf(this.sRu.sRj), Integer.valueOf(this.sRu.sRk), Integer.valueOf(this.sRu.sRl), Integer.valueOf(this.sRu.sRm), Integer.valueOf(this.sRu.sRn), Integer.valueOf(this.sRu.sPx), Integer.valueOf(this.sRu.sRo), Integer.valueOf(this.sRu.unstableCount), Integer.valueOf(this.sRu.sRq), Integer.valueOf(j), Integer.valueOf(k), this.appId, Integer.valueOf(this.sRv), Integer.valueOf(this.sRw), Integer.valueOf(this.sRx) });
        AppMethodBeat.o(186368);
        return;
        i = 0;
      }
      label905:
      j = 0;
    }
  }
  
  public final void ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.sRu != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.sRu.sRr.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void ae(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.sRu != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.sRu.sRs.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final long cTf()
  {
    AppMethodBeat.i(103757);
    Log.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.sRu == null) {
      this.sRu = new FaceDetectReportInfo();
    }
    this.sRu.reset();
    this.sRt = false;
    this.sessionId = System.currentTimeMillis();
    this.sRu.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void dr(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    h localh;
    long l2;
    String str;
    if ((this.sRA == -1L) || (this.sRB == -1L) || (this.sRB < this.sRA))
    {
      Log.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.sRA), Long.valueOf(this.sRB) });
      Log.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.sRz), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.sRD), this.appId, Integer.valueOf(this.sRC) });
      localh = h.CyF;
      l2 = this.sRz;
      str = this.appId;
      if (!this.sRD) {
        break label273;
      }
    }
    for (;;)
    {
      localh.a(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.sRC) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.sRB - this.sRA;
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
    if (this.sRt)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.sRu, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.sRv);
      paramParcel.writeInt(this.sRw);
      paramParcel.writeInt(this.sRx);
      paramParcel.writeLong(this.sRz);
      paramParcel.writeLong(this.sRA);
      paramParcel.writeLong(this.sRB);
      paramParcel.writeInt(this.sRC);
      if (!this.sRD) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReporter
 * JD-Core Version:    0.7.0.1
 */