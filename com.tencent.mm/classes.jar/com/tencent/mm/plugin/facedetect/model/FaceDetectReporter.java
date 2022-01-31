package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class FaceDetectReporter
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReporter> CREATOR;
  public static FaceDetectReporter miM;
  public String appId;
  public boolean miH;
  private FaceDetectReportInfo miI;
  public int miJ;
  public int miK;
  public int miL;
  private long miN;
  public long miO;
  public long miP;
  public int miQ;
  public boolean miR;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(242);
    miM = new FaceDetectReporter();
    CREATOR = new FaceDetectReporter.1();
    AppMethodBeat.o(242);
  }
  
  private FaceDetectReporter()
  {
    this.sessionId = 0L;
    this.miH = false;
    this.miI = null;
    this.appId = "";
    this.miJ = -1;
    this.miK = 0;
    this.miL = 0;
    this.miN = 0L;
    this.miO = -1L;
    this.miP = -1L;
    this.miQ = 0;
    this.miR = false;
  }
  
  protected FaceDetectReporter(Parcel paramParcel)
  {
    AppMethodBeat.i(228);
    this.sessionId = 0L;
    this.miH = false;
    this.miI = null;
    this.appId = "";
    this.miJ = -1;
    this.miK = 0;
    this.miL = 0;
    this.miN = 0L;
    this.miO = -1L;
    this.miP = -1L;
    this.miQ = 0;
    this.miR = false;
    this.sessionId = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.miH = bool1;
      this.miI = ((FaceDetectReportInfo)paramParcel.readParcelable(FaceDetectReportInfo.class.getClassLoader()));
      this.appId = paramParcel.readString();
      this.miJ = paramParcel.readInt();
      this.miK = paramParcel.readInt();
      this.miL = paramParcel.readInt();
      this.miN = paramParcel.readLong();
      this.miO = paramParcel.readLong();
      this.miP = paramParcel.readLong();
      this.miQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label205;
      }
    }
    label205:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.miR = bool1;
      AppMethodBeat.o(228);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static FaceDetectReporter buB()
  {
    AppMethodBeat.i(230);
    if (miM == null) {
      try
      {
        if (miM == null) {
          miM = new FaceDetectReporter();
        }
        FaceDetectReporter localFaceDetectReporter1 = miM;
        return localFaceDetectReporter1;
      }
      finally
      {
        AppMethodBeat.o(230);
      }
    }
    FaceDetectReporter localFaceDetectReporter2 = miM;
    AppMethodBeat.o(230);
    return localFaceDetectReporter2;
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231);
    ab.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.qsU.e(14121, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(231);
  }
  
  public static int vG(int paramInt)
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
  
  public final void L(int paramInt, long paramLong)
  {
    AppMethodBeat.i(239);
    if (this.miI != null)
    {
      FaceDetectReportInfo localFaceDetectReportInfo = this.miI;
      localFaceDetectReportInfo.ciX += 1;
      localFaceDetectReportInfo = this.miI;
      localFaceDetectReportInfo.miD = ((int)(localFaceDetectReportInfo.miD + paramLong));
      this.miI.vF(paramInt);
    }
    AppMethodBeat.o(239);
  }
  
  public final void M(int paramInt, long paramLong)
  {
    AppMethodBeat.i(240);
    if (this.miI != null)
    {
      ab.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + paramLong);
      this.miI.miF.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(240);
  }
  
  public final void N(int paramInt, long paramLong)
  {
    AppMethodBeat.i(241);
    if (this.miI != null)
    {
      ab.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + paramLong);
      this.miI.miG.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    AppMethodBeat.o(241);
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(235);
    ab.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    h localh = h.qsU;
    long l = this.sessionId;
    if (paramBoolean) {}
    for (;;)
    {
      localh.e(14005, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(235);
      return;
      i = 0;
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(237);
    ab.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[] { Long.valueOf(this.sessionId), Boolean.valueOf(this.miH), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i;
    if ((this.miI != null) && (!this.miH))
    {
      ab.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[] { this.miI.toString() });
      this.miH = true;
      this.miI.mgC = paramInt5;
      if (this.miI.ciX != 0) {
        this.miI.miE = (this.miI.miD / this.miI.ciX);
      }
      paramInt5 = 0;
      i = paramInt5;
      if (this.miI.miF.containsKey(Integer.valueOf(0)))
      {
        i = paramInt5;
        if (this.miI.miG.containsKey(Integer.valueOf(0)))
        {
          i = (int)(((Long)this.miI.miG.get(Integer.valueOf(0))).longValue() - ((Long)this.miI.miF.get(Integer.valueOf(0))).longValue());
          ab.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + i + "  hashCode :" + hashCode());
        }
      }
      if ((!this.miI.miF.containsKey(Integer.valueOf(4))) || (!this.miI.miG.containsKey(Integer.valueOf(4)))) {
        break label940;
      }
      paramInt5 = (int)(((Long)this.miI.miG.get(Integer.valueOf(4))).longValue() - ((Long)this.miI.miF.get(Integer.valueOf(4))).longValue());
      ab.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + paramInt5 + "  hashCode :" + hashCode());
    }
    for (;;)
    {
      int j = paramInt5;
      if (this.miI.miF.containsKey(Integer.valueOf(6)))
      {
        j = paramInt5;
        if (this.miI.miG.containsKey(Integer.valueOf(6)))
        {
          j = (int)(((Long)this.miI.miG.get(Integer.valueOf(6))).longValue() - ((Long)this.miI.miF.get(Integer.valueOf(6))).longValue());
          ab.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + j + "  hashCode :" + hashCode());
        }
      }
      ab.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(hashCode()) });
      h localh = h.qsU;
      long l = this.sessionId;
      if (paramBoolean) {}
      for (paramInt5 = 1;; paramInt5 = 0)
      {
        localh.e(14006, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt5), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(this.miI.mip), Integer.valueOf(this.miI.miq), Integer.valueOf(this.miI.mir), Integer.valueOf(this.miI.mio), Integer.valueOf(this.miI.mis), Integer.valueOf(this.miI.mit), Integer.valueOf(this.miI.miu), Integer.valueOf(this.miI.miv), Integer.valueOf(this.miI.miw), Integer.valueOf(this.miI.mix), Integer.valueOf(this.miI.miy), Integer.valueOf(this.miI.miz), Integer.valueOf(this.miI.miA), Integer.valueOf(this.miI.mgC), Integer.valueOf(this.miI.miB), Integer.valueOf(this.miI.miC), Integer.valueOf(this.miI.miE), Integer.valueOf(i), Integer.valueOf(j), this.appId, Integer.valueOf(this.miJ), Integer.valueOf(this.miK), Integer.valueOf(this.miL) });
        AppMethodBeat.o(237);
        return;
      }
      label940:
      paramInt5 = 0;
    }
  }
  
  public final void a(FaceDetectReporter paramFaceDetectReporter)
  {
    AppMethodBeat.i(234);
    ab.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[] { bo.dtY().toString() });
    this.miI = paramFaceDetectReporter.miI;
    this.miH = paramFaceDetectReporter.miH;
    this.sessionId = paramFaceDetectReporter.sessionId;
    this.miK = paramFaceDetectReporter.miK;
    this.miL = paramFaceDetectReporter.miL;
    long l = this.sessionId;
    if (this.miI != null) {}
    for (paramFaceDetectReporter = this.miI.toString();; paramFaceDetectReporter = "null")
    {
      ab.v("MicroMsg.FaceDetectReporter", "alvinluo sessionId: %d, info: %s", new Object[] { Long.valueOf(l), paramFaceDetectReporter });
      AppMethodBeat.o(234);
      return;
    }
  }
  
  public final void b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236);
    a(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(236);
  }
  
  public final long buC()
  {
    AppMethodBeat.i(232);
    ab.v("MicroMsg.FaceDetectReporter", "create report session");
    if (this.miI == null) {
      this.miI = new FaceDetectReportInfo();
    }
    this.miI.reset();
    this.miH = false;
    this.sessionId = System.currentTimeMillis();
    this.miI.sessionId = this.sessionId;
    long l = this.sessionId;
    AppMethodBeat.o(232);
    return l;
  }
  
  public final long buD()
  {
    AppMethodBeat.i(233);
    ab.v("MicroMsg.FaceDetectReporter", "create interface called session");
    this.miN = System.currentTimeMillis();
    this.miQ = 0;
    this.miR = false;
    this.miO = -1L;
    this.miP = -1L;
    long l = this.miN;
    AppMethodBeat.o(233);
    return l;
  }
  
  public final void ci(String paramString, int paramInt)
  {
    long l1 = -1L;
    int i = 1;
    AppMethodBeat.i(238);
    h localh;
    long l2;
    String str;
    if ((this.miO == -1L) || (this.miP == -1L) || (this.miP < this.miO))
    {
      ab.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[] { Long.valueOf(this.miO), Long.valueOf(this.miP) });
      ab.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[] { Long.valueOf(this.miN), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), Long.valueOf(l1), Boolean.valueOf(this.miR), this.appId, Integer.valueOf(this.miQ) });
      localh = h.qsU;
      l2 = this.miN;
      str = this.appId;
      if (!this.miR) {
        break label273;
      }
    }
    for (;;)
    {
      localh.e(14560, new Object[] { Long.valueOf(l2), paramString, Integer.valueOf(-1), Integer.valueOf(paramInt), str, Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(this.miQ) });
      AppMethodBeat.o(238);
      return;
      l1 = this.miP - this.miO;
      break;
      label273:
      i = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(229);
    paramParcel.writeLong(this.sessionId);
    int i;
    if (this.miH)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.miI, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.miJ);
      paramParcel.writeInt(this.miK);
      paramParcel.writeInt(this.miL);
      paramParcel.writeLong(this.miN);
      paramParcel.writeLong(this.miO);
      paramParcel.writeLong(this.miP);
      paramParcel.writeInt(this.miQ);
      if (!this.miR) {
        break label133;
      }
    }
    label133:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(229);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReporter
 * JD-Core Version:    0.7.0.1
 */