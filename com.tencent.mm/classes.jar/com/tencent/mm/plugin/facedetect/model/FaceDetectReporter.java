package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter qyh;
  public String appId;
  public boolean qyc;
  private FaceDetectReportInfo qyd;
  public int qye;
  public int qyf;
  public int qyg;
  private long qyi;
  public long qyj;
  public long qyk;
  public int qyl;
  public boolean qym;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(103767);
    qyh = new FaceDetectReporter();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103767);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.qyc = false;
    this.qyd = null;
    this.appId = "";
    this.qye = -1;
    this.qyf = 0;
    this.qyg = 0;
    this.qyi = 0L;
    this.qyj = -1L;
    this.qyk = -1L;
    this.qyl = 0;
    this.qym = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(103753);
    this.sessionId = 0L;
    this.qyc = false;
    this.qyd = null;
    this.appId = "";
    this.qye = -1;
    this.qyf = 0;
    this.qyg = 0;
    this.qyi = 0L;
    this.qyj = -1L;
    this.qyk = -1L;
    this.qyl = 0;
    this.qym = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.qyc = bool1;
      this.qyd = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.qye = paramParcel.readInt();
      this.qyf = paramParcel.readInt();
      this.qyg = paramParcel.readInt();
      this.qyi = paramParcel.readLong();
      this.qyj = paramParcel.readLong();
      this.qyk = paramParcel.readLong();
      this.qyl = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qym = bool1;
      AppMethodBeat.o(103753);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static int CT(int paramInt)
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
  
  public static FaceDetectReporter cnC()
  {
    AppMethodBeat.i(103755);
    if (qyh == null) {
      try
      {
        if (qyh == null) {
          qyh = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = qyh;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(103755);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = qyh;
    AppMethodBeat.o(103755);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103756);
    ac.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.wUl.f(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103756);
  }
  
  public final void X(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103764);
    if (this.qyd != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.qyd;
      localFaceDetectReportInfo.cVl += 1;
      localFaceDetectReportInfo = this.qyd;
      localFaceDetectReportInfo.qxY = ((int)(localFaceDetectReportInfo.qxY + paramLong));
      this.qyd.CS(paramInt);
    }
    AppMethodBeat.o(103764);
  }
  
  public final void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103765);
    if (this.qyd != null)
    {
      ac.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.qyd.qya.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103765);
  }
  
  public final void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103766);
    if (this.qyd != null)
    {
      ac.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.qyd.qyb.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(103766);
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
    ac.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.qyc), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i;
    if ((this.qyd != null) && (!this.qyc))
    {
      ac.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.qyd.toString() });
      this.qyc = true;
      this.qyd.qvZ = paramInt5;
      if (this.qyd.cVl != 0) {
        this.qyd.qxZ = (this.qyd.qxY / this.qyd.cVl);
      }
      paramInt5 = 0;
      i = paramInt5;
      if (this.qyd.qya.containsKey(Integer.valueOf(0)))
      {
        i = paramInt5;
        if (this.qyd.qyb.containsKey(Integer.valueOf(0)))
        {
          i = (int)(((Long)this.qyd.qyb.get(Integer.valueOf(0))).longValue() - ((Long)this.qyd.qya.get(Integer.valueOf(0))).longValue());
          ac.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i + "  hashCode :" + hashCode());
        }
      }
      if ((!this.qyd.qya.containsKey(Integer.valueOf(4))) || (!this.qyd.qyb.containsKey(Integer.valueOf(4)))) {
        break label938;
      }
      paramInt5 = (int)(((Long)this.qyd.qyb.get(Integer.valueOf(4))).longValue() - ((Long)this.qyd.qya.get(Integer.valueOf(4))).longValue());
      ac.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + paramInt5 + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int j = paramInt5;
      if (this.qyd.qya.containsKey(Integer.valueOf(6)))
      {
        j = paramInt5;
        if (this.qyd.qyb.containsKey(Integer.valueOf(6)))
        {
          j = (int)(((Long)this.qyd.qyb.get(Integer.valueOf(6))).longValue() - ((Long)this.qyd.qya.get(Integer.valueOf(6))).longValue());
          ac.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + j + "  hashCode :" + hashCode());
        }
      }
      ac.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(hashCode()) });
      h localh = h.wUl;
      long l = this.sessionId;
      if (paramBoolean) {}
      for (paramInt5 = 1;; paramInt5 = 0)
      {
        localh.f(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.qyd.qxK), Integer.valueOf(this.qyd.qxL), Integer.valueOf(this.qyd.qxM), Integer.valueOf(this.qyd.qxJ), Integer.valueOf(this.qyd.qxN), Integer.valueOf(this.qyd.qxO), Integer.valueOf(this.qyd.qxP), Integer.valueOf(this.qyd.qxQ), Integer.valueOf(this.qyd.qxR), Integer.valueOf(this.qyd.qxS), Integer.valueOf(this.qyd.qxT), Integer.valueOf(this.qyd.qxU), Integer.valueOf(this.qyd.qxV), Integer.valueOf(this.qyd.qvZ), Integer.valueOf(this.qyd.qxW), Integer.valueOf(this.qyd.qxX), Integer.valueOf(this.qyd.qxZ), Integer.valueOf(i), Integer.valueOf(j), this.appId, Integer.valueOf(this.qye), Integer.valueOf(this.qyf), Integer.valueOf(this.qyg) });
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
    ac.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bs.eWi().toString() });
    this.qyd = paramFaceDetectReporter.qyd;
    this.qyc = paramFaceDetectReporter.qyc;
    this.sessionId = paramFaceDetectReporter.sessionId;
    this.qyf = paramFaceDetectReporter.qyf;
    this.qyg = paramFaceDetectReporter.qyg;
    long l = this.sessionId;
    if (this.qyd != null) {}
    for (paramFaceDetectReporter = this.qyd.toString();; paramFaceDetectReporter = "null")
    {
      ac.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      AppMethodBeat.o(103759);
      return;
    }
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(103760);
    ac.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    h localh = h.wUl;
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
  
  public final void cX(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(103763);
    h localh;
    long l2;
    String str;
    if ((this.qyj == -1L) || (this.qyk == -1L) || (this.qyk < this.qyj))
    {
      ac.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.qyj), Long.valueOf(this.qyk) });
      ac.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.qyi), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.qym), this.appId, Integer.valueOf(this.qyl) });
      localh = h.wUl;
      l2 = this.qyi;
      str = this.appId;
      if (!this.qym) {
        break label273;
      }
    }
    for (;;)
    {
      localh.f(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.qyl) });
      AppMethodBeat.o(103763);
      return;
      l1 = this.qyk - this.qyj;
      break;
      label273:
      i = 0;
    }
  }
  
  public final long cnD()
  {
    AppMethodBeat.i(103757);
    ac.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.qyd == null) {
      this.qyd = new FaceDetectReportInfo();
    }
    this.qyd.reset();
    this.qyc = false;
    this.sessionId = System.currentTimeMillis();
    this.qyd.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(103757);
    return l;
  }
  
  public final long cnE()
  {
    AppMethodBeat.i(103758);
    ac.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.qyi = System.currentTimeMillis();
    this.qyl = 0;
    this.qym = false;
    this.qyj = -1L;
    this.qyk = -1L;
    long l = this.qyi;
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
    if (this.qyc)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.qyd, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.qye);
      paramParcel.writeInt(this.qyf);
      paramParcel.writeInt(this.qyg);
      paramParcel.writeLong(this.qyi);
      paramParcel.writeLong(this.qyj);
      paramParcel.writeLong(this.qyk);
      paramParcel.writeInt(this.qyl);
      if (!this.qym) {
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