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
  public static FaceDetectReporter zTA;
  String appId;
  public long sessionId;
  long zTB;
  long zTC;
  public long zTD;
  int zTE;
  boolean zTF;
  public boolean zTv;
  public FaceDetectReportInfo zTw;
  private int zTx;
  public int zTy;
  public int zTz;
  
  static
  {
    AppMethodBeat.i(103767);
    zTA = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.zTv = false;
    this.zTw = null;
    this.appId = "";
    this.zTx = -1;
    this.zTy = 0;
    this.zTz = 0;
    this.zTB = 0L;
    this.zTC = -1L;
    this.zTD = -1L;
    this.zTE = 0;
    this.zTF = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.zTv = false;
    this.zTw = null;
    this.appId = "";
    this.zTx = -1;
    this.zTy = 0;
    this.zTz = 0;
    this.zTB = 0L;
    this.zTC = -1L;
    this.zTD = -1L;
    this.zTE = 0;
    this.zTF = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.zTv = bool1;
      this.zTw = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.zTx = paramParcel.readInt();
      this.zTy = paramParcel.readInt();
      this.zTz = paramParcel.readInt();
      this.zTB = paramParcel.readLong();
      this.zTC = paramParcel.readLong();
      this.zTD = paramParcel.readLong();
      this.zTE = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zTF = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int Mr(int paramInt)
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
  
  public static FaceDetectReporter dOU()
  {
    AppMethodBeat.i(103755);
    if (zTA == null) {
      try
      {
        if (zTA == null) {
          zTA = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = zTA;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = zTA;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void j(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    Log.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.OAn.b(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void ah(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.zTw != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.zTw;
      localFaceDetectReportInfo.hvP += 1;
      localFaceDetectReportInfo = this.zTw;
      localFaceDetectReportInfo.zTr = ((int)(localFaceDetectReportInfo.zTr + paramLong));
      this.zTw.Mq(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void ai(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.zTw != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.zTw.zTt.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void aj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.zTw != null)
    {
      Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.zTw.zTu.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
  }
  
  public final void av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(271898);
    Log.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.zTv), Integer.valueOf(paramInt1), Boolean.FALSE, Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int j;
    if ((this.zTw != null) && (!this.zTv))
    {
      Log.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.zTw.toString() });
      this.zTv = true;
      this.zTw.zRw = 0;
      if (this.zTw.hvP != 0) {
        this.zTw.zTs = (this.zTw.zTr / this.zTw.hvP);
      }
      if ((!this.zTw.zTt.containsKey(Integer.valueOf(0))) || (!this.zTw.zTu.containsKey(Integer.valueOf(0)))) {
        break label906;
      }
      j = (int)(((Long)this.zTw.zTu.get(Integer.valueOf(0))).longValue() - ((Long)this.zTw.zTt.get(Integer.valueOf(0))).longValue());
      Log.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + j + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int i;
      if ((this.zTw.zTt.containsKey(Integer.valueOf(4))) && (this.zTw.zTu.containsKey(Integer.valueOf(4))))
      {
        i = (int)(((Long)this.zTw.zTu.get(Integer.valueOf(4))).longValue() - ((Long)this.zTw.zTt.get(Integer.valueOf(4))).longValue());
        Log.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + i + "  hashCode :" + hashCode());
      }
      for (;;)
      {
        int k = i;
        if (this.zTw.zTt.containsKey(Integer.valueOf(6)))
        {
          k = i;
          if (this.zTw.zTu.containsKey(Integer.valueOf(6)))
          {
            k = (int)(((Long)this.zTw.zTu.get(Integer.valueOf(6))).longValue() - ((Long)this.zTw.zTt.get(Integer.valueOf(6))).longValue());
            Log.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + k + "  hashCode :" + hashCode());
          }
        }
        Log.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(hashCode()) });
        h.OAn.b(14006, new Object[] { Long.valueOf(this.sessionId), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.zTw.zTe), Integer.valueOf(this.zTw.zTf), Integer.valueOf(this.zTw.zTg), Integer.valueOf(this.zTw.zTd), Integer.valueOf(this.zTw.zTh), Integer.valueOf(this.zTw.zTi), Integer.valueOf(this.zTw.zTj), Integer.valueOf(this.zTw.zTk), Integer.valueOf(this.zTw.zTl), Integer.valueOf(this.zTw.zTm), Integer.valueOf(this.zTw.zTn), Integer.valueOf(this.zTw.zTo), Integer.valueOf(this.zTw.zTp), Integer.valueOf(this.zTw.zRw), Integer.valueOf(this.zTw.zTq), Integer.valueOf(this.zTw.unstableCount), Integer.valueOf(this.zTw.zTs), Integer.valueOf(j), Integer.valueOf(k), this.appId, Integer.valueOf(this.zTx), Integer.valueOf(this.zTy), Integer.valueOf(this.zTz) });
        AppMethodBeat.o(271898);
        return;
        i = 0;
      }
      label906:
      j = 0;
    }
  }
  
  public final long dOV()
  {
    AppMethodBeat.i(103757);
    Log.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.zTw == null) {
      this.zTw = new FaceDetectReportInfo();
    }
    this.zTw.reset();
    this.zTv = false;
    this.sessionId = System.currentTimeMillis();
    this.zTw.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void eq(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    h localh;
    long l2;
    String str;
    if ((this.zTC == -1L) || (this.zTD == -1L) || (this.zTD < this.zTC))
    {
      Log.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.zTC), Long.valueOf(this.zTD) });
      Log.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.zTB), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.zTF), this.appId, Integer.valueOf(this.zTE) });
      localh = h.OAn;
      l2 = this.zTB;
      str = this.appId;
      if (!this.zTF) {
        break label273;
      }
    }
    for (;;)
    {
      localh.b(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.zTE) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.zTD - this.zTC;
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
    if (this.zTv)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.zTw, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.zTx);
      paramParcel.writeInt(this.zTy);
      paramParcel.writeInt(this.zTz);
      paramParcel.writeLong(this.zTB);
      paramParcel.writeLong(this.zTC);
      paramParcel.writeLong(this.zTD);
      paramParcel.writeInt(this.zTE);
      if (!this.zTF) {
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