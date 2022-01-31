package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR = new FaceDetectReporter.1();
  public static FaceDetectReporter jOw = new FaceDetectReporter();
  public String appId = "";
  public long fKz = 0L;
  public int jOA = 0;
  public boolean jOB = false;
  public boolean jOu = false;
  private FaceDetectReportInfo jOv = null;
  private long jOx = 0L;
  public long jOy = -1L;
  public long jOz = -1L;
  
  private FaceDetectReporter() {}
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    this.fKz = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jOu = bool1;
      this.jOv = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.jOx = paramParcel.readLong();
      this.jOy = paramParcel.readLong();
      this.jOz = paramParcel.readLong();
      this.jOA = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label154;
      }
    }
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jOB = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static FaceDetectReporter aOy()
  {
    if (jOw == null) {
      try
      {
        if (jOw == null) {
          jOw = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter = jOw;
        return localFaceDetectReporter;
      }
      finally {}
    }
    return jOw;
  }
  
  public static void e(long paramLong, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.nFQ.f(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static int qL(int paramInt)
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
  
  public final void L(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    y.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    h localh = h.nFQ;
    long l = this.fKz;
    if (paramBoolean) {}
    for (;;)
    {
      localh.f(14005, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i) });
      return;
      i = 0;
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    y.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.fKz), Boolean.valueOf(this.jOu), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if ((this.jOv != null) && (!this.jOu))
    {
      y.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.jOv.toString() });
      this.jOu = true;
      this.jOv.jMw = paramInt5;
      if (this.jOv.bCi != 0) {
        this.jOv.jOr = (this.jOv.jOq / this.jOv.bCi);
      }
      if ((!this.jOv.jOs.containsKey(Integer.valueOf(0))) || (!this.jOv.jOt.containsKey(Integer.valueOf(0)))) {
        break label688;
      }
    }
    label688:
    for (paramInt5 = (int)(((Long)this.jOv.jOt.get(Integer.valueOf(0))).longValue() - ((Long)this.jOv.jOs.get(Integer.valueOf(0))).longValue());; paramInt5 = 0)
    {
      if ((this.jOv.jOs.containsKey(Integer.valueOf(4))) && (this.jOv.jOt.containsKey(Integer.valueOf(4)))) {}
      for (int i = (int)(((Long)this.jOv.jOt.get(Integer.valueOf(4))).longValue() - ((Long)this.jOv.jOs.get(Integer.valueOf(4))).longValue());; i = 0)
      {
        y.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(i) });
        h localh = h.nFQ;
        long l = this.fKz;
        if (paramBoolean) {}
        for (int j = 1;; j = 0)
        {
          localh.f(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.jOv.jOc), Integer.valueOf(this.jOv.jOd), Integer.valueOf(this.jOv.jOe), Integer.valueOf(this.jOv.jOb), Integer.valueOf(this.jOv.jOf), Integer.valueOf(this.jOv.jOg), Integer.valueOf(this.jOv.jOh), Integer.valueOf(this.jOv.jOi), Integer.valueOf(this.jOv.jOj), Integer.valueOf(this.jOv.jOk), Integer.valueOf(this.jOv.jOl), Integer.valueOf(this.jOv.jOm), Integer.valueOf(this.jOv.jOn), Integer.valueOf(this.jOv.jMw), Integer.valueOf(this.jOv.jOo), Integer.valueOf(this.jOv.jOp), Integer.valueOf(this.jOv.jOr), Integer.valueOf(paramInt5), Integer.valueOf(i), this.appId });
          return;
        }
      }
    }
  }
  
  public final void a(FaceDetectReporter paramFaceDetectReporter)
  {
    y.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bk.csb().toString() });
    this.jOv = paramFaceDetectReporter.jOv;
    this.jOu = paramFaceDetectReporter.jOu;
    this.fKz = paramFaceDetectReporter.fKz;
    long l = this.fKz;
    if (this.jOv != null) {}
    for (paramFaceDetectReporter = this.jOv.toString();; paramFaceDetectReporter = "null")
    {
      y.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      return;
    }
  }
  
  public final long aOA()
  {
    y.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.jOx = System.currentTimeMillis();
    this.jOA = 0;
    this.jOB = false;
    this.jOy = -1L;
    this.jOz = -1L;
    return this.jOx;
  }
  
  public final long aOz()
  {
    y.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.jOv == null) {
      this.jOv = new FaceDetectReportInfo();
    }
    this.jOv.reset();
    this.jOu = false;
    this.fKz = System.currentTimeMillis();
    this.jOv.fKz = this.fKz;
    return this.fKz;
  }
  
  public final void bA(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    h localh;
    long l2;
    String str;
    if ((this.jOy == -1L) || (this.jOz == -1L) || (this.jOz < this.jOy))
    {
      y.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.jOy), Long.valueOf(this.jOz) });
      y.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.jOx), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.jOB), this.appId, Integer.valueOf(this.jOA) });
      localh = h.nFQ;
      l2 = this.jOx;
      str = this.appId;
      if (!this.jOB) {
        break label261;
      }
    }
    for (;;)
    {
      localh.f(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.jOA) });
      return;
      l1 = this.jOz - this.jOy;
      break;
      label261:
      i = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void u(int paramInt, long paramLong)
  {
    if (this.jOv != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.jOv;
      localFaceDetectReportInfo.bCi += 1;
      localFaceDetectReportInfo = this.jOv;
      localFaceDetectReportInfo.jOq = ((int)(localFaceDetectReportInfo.jOq + paramLong));
      this.jOv.qK(paramInt);
    }
  }
  
  public final void v(int paramInt, long paramLong)
  {
    if (this.jOv != null) {
      this.jOv.jOs.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
  }
  
  public final void w(int paramInt, long paramLong)
  {
    if (this.jOv != null) {
      this.jOv.jOt.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeLong(this.fKz);
    int i;
    if (this.jOu)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.jOv, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeLong(this.jOx);
      paramParcel.writeLong(this.jOy);
      paramParcel.writeLong(this.jOz);
      paramParcel.writeInt(this.jOA);
      if (!this.jOB) {
        break label97;
      }
    }
    label97:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
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