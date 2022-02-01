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
  public static FaceDetectReporter wxu;
  String appId;
  public long sessionId;
  public boolean wxp;
  public FaceDetectReportInfo wxq;
  private int wxr;
  public int wxs;
  public int wxt;
  long wxv;
  long wxw;
  public long wxx;
  int wxy;
  boolean wxz;
  
  static
  {
    AppMethodBeat.i(103767);
    wxu = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.wxp = false;
    this.wxq = null;
    this.appId = "";
    this.wxr = -1;
    this.wxs = 0;
    this.wxt = 0;
    this.wxv = 0L;
    this.wxw = -1L;
    this.wxx = -1L;
    this.wxy = 0;
    this.wxz = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.wxp = false;
    this.wxq = null;
    this.appId = "";
    this.wxr = -1;
    this.wxs = 0;
    this.wxt = 0;
    this.wxv = 0L;
    this.wxw = -1L;
    this.wxx = -1L;
    this.wxy = 0;
    this.wxz = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.wxp = bool1;
      this.wxq = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.wxr = paramParcel.readInt();
      this.wxs = paramParcel.readInt();
      this.wxt = paramParcel.readInt();
      this.wxv = paramParcel.readLong();
      this.wxw = paramParcel.readLong();
      this.wxx = paramParcel.readLong();
      this.wxy = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wxz = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int Lu(int paramInt)
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
  
  public static FaceDetectReporter dij()
  {
    AppMethodBeat.i(103755);
    if (wxu == null) {
      try
      {
        if (wxu == null) {
          wxu = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = wxu;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = wxu;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    Log.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.IzE.a(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.wxq != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.wxq;
      localFaceDetectReportInfo.frE += 1;
      localFaceDetectReportInfo = this.wxq;
      localFaceDetectReportInfo.wxl = ((int)(localFaceDetectReportInfo.wxl + paramLong));
      this.wxq.Lt(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195741);
    Log.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.wxp), Integer.valueOf(paramInt1), Boolean.FALSE, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int j;
    if ((this.wxq != null) && (!this.wxp))
    {
      Log.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.wxq.toString() });
      this.wxp = true;
      this.wxq.wvr = 0;
      if (this.wxq.frE != 0) {
        this.wxq.wxm = (this.wxq.wxl / this.wxq.frE);
      }
      if ((!this.wxq.wxn.containsKey(Integer.valueOf(0))) || (!this.wxq.wxo.containsKey(Integer.valueOf(0)))) {
        break label905;
      }
      j = (int)(((Long)this.wxq.wxo.get(Integer.valueOf(0))).longValue() - ((Long)this.wxq.wxn.get(Integer.valueOf(0))).longValue());
      Log.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + j + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int i;
      if ((this.wxq.wxn.containsKey(Integer.valueOf(4))) && (this.wxq.wxo.containsKey(Integer.valueOf(4))))
      {
        i = (int)(((Long)this.wxq.wxo.get(Integer.valueOf(4))).longValue() - ((Long)this.wxq.wxn.get(Integer.valueOf(4))).longValue());
        Log.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + i + "  hashCode :" + hashCode());
      }
      for (;;)
      {
        int k = i;
        if (this.wxq.wxn.containsKey(Integer.valueOf(6)))
        {
          k = i;
          if (this.wxq.wxo.containsKey(Integer.valueOf(6)))
          {
            k = (int)(((Long)this.wxq.wxo.get(Integer.valueOf(6))).longValue() - ((Long)this.wxq.wxn.get(Integer.valueOf(6))).longValue());
            Log.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + k + "  hashCode :" + hashCode());
          }
        }
        Log.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(hashCode()) });
        h.IzE.a(14006, new Object[] { Long.valueOf(this.sessionId), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.wxq.wwY), Integer.valueOf(this.wxq.wwZ), Integer.valueOf(this.wxq.wxa), Integer.valueOf(this.wxq.wwX), Integer.valueOf(this.wxq.wxb), Integer.valueOf(this.wxq.wxc), Integer.valueOf(this.wxq.wxd), Integer.valueOf(this.wxq.wxe), Integer.valueOf(this.wxq.wxf), Integer.valueOf(this.wxq.wxg), Integer.valueOf(this.wxq.wxh), Integer.valueOf(this.wxq.wxi), Integer.valueOf(this.wxq.wxj), Integer.valueOf(this.wxq.wvr), Integer.valueOf(this.wxq.wxk), Integer.valueOf(this.wxq.unstableCount), Integer.valueOf(this.wxq.wxm), Integer.valueOf(j), Integer.valueOf(k), this.appId, Integer.valueOf(this.wxr), Integer.valueOf(this.wxs), Integer.valueOf(this.wxt) });
        AppMethodBeat.o(195741);
        return;
        i = 0;
      }
      label905:
      j = 0;
    }
  }
  
  public final void ae(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.wxq != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.wxq.wxn.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void af(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.wxq != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.wxq.wxo.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final void dM(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    h localh;
    long l2;
    String str;
    if ((this.wxw == -1L) || (this.wxx == -1L) || (this.wxx < this.wxw))
    {
      Log.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.wxw), Long.valueOf(this.wxx) });
      Log.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.wxv), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.wxz), this.appId, Integer.valueOf(this.wxy) });
      localh = h.IzE;
      l2 = this.wxv;
      str = this.appId;
      if (!this.wxz) {
        break label273;
      }
    }
    for (;;)
    {
      localh.a(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.wxy) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.wxx - this.wxw;
      break;
      label273:
      i = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final long dik()
  {
    AppMethodBeat.i(103757);
    Log.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.wxq == null) {
      this.wxq = new FaceDetectReportInfo();
    }
    this.wxq.reset();
    this.wxp = false;
    this.sessionId = System.currentTimeMillis();
    this.wxq.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(103754);
    paramParcel.writeLong(this.sessionId);
    int i;
    if (this.wxp)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.wxq, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.wxr);
      paramParcel.writeInt(this.wxs);
      paramParcel.writeInt(this.wxt);
      paramParcel.writeLong(this.wxv);
      paramParcel.writeLong(this.wxw);
      paramParcel.writeLong(this.wxx);
      paramParcel.writeInt(this.wxy);
      if (!this.wxz) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReporter
 * JD-Core Version:    0.7.0.1
 */