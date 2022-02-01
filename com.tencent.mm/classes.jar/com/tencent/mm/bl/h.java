package com.tencent.mm.bl;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

public final class h
  implements a.a
{
  private static int ivS = -1;
  private static int ivU = 1;
  private int bufId;
  int dGc;
  int hiI;
  long hiy;
  com.tencent.mm.compatible.h.c hjX;
  int hjY;
  private boolean ivA;
  boolean ivB;
  private int ivD;
  private int ivE;
  private int ivF;
  private int ivG;
  private int ivH;
  private int ivI;
  private int ivJ;
  private int ivK;
  b ivL;
  private c ivM;
  a ivN;
  VideoTransPara ivO;
  private int ivP;
  String ivQ;
  a ivR;
  private MediaFormat ivT;
  private Object lock;
  long startTimeMs;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.startTimeMs = -1L;
    this.hiy = -1L;
    this.ivB = false;
    this.ivP = 0;
    this.lock = new byte[0];
    this.hiI = -1;
    this.ivA = false;
    ad.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.bufId = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static int qp(int paramInt)
  {
    AppMethodBeat.i(127123);
    int i = paramInt % 16;
    if (i == 0)
    {
      AppMethodBeat.o(127123);
      return paramInt;
    }
    int j = paramInt - Math.min(16, i);
    if (j < 2147483647)
    {
      AppMethodBeat.o(127123);
      return j;
    }
    AppMethodBeat.o(127123);
    return paramInt - i;
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127122);
    ad.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ad.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(127122);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ad.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(127122);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ad.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
      paramInt4 = paramInt1 / 2;
      paramInt3 = paramInt2 / 2;
      paramInt1 = paramInt4;
      if (paramInt4 % 2 != 0) {
        paramInt1 = paramInt4 + 1;
      }
      paramInt2 = paramInt3;
      if (paramInt3 % 2 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      localPoint = new Point(paramInt1, paramInt2);
      AppMethodBeat.o(127122);
      return localPoint;
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ad.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
      paramInt4 = paramInt1 / 2;
      paramInt3 = paramInt2 / 2;
      paramInt1 = paramInt4;
      if (paramInt4 % 2 != 0) {
        paramInt1 = paramInt4 + 1;
      }
      paramInt2 = paramInt3;
      if (paramInt3 % 2 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      localPoint = new Point(paramInt1, paramInt2);
      AppMethodBeat.o(127122);
      return localPoint;
    }
    Point localPoint = new Point();
    double d;
    if (paramInt1 < paramInt2)
    {
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt1 * 1.0D / paramInt3;
      paramInt2 = (int)(paramInt2 / d);
      paramInt1 = paramInt3;
    }
    for (;;)
    {
      paramInt3 = paramInt2;
      if (paramInt2 % 2 != 0) {
        paramInt3 = paramInt2 + 1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 % 2 != 0) {
        paramInt2 = paramInt1 + 1;
      }
      ad.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = qp(localPoint.x);
      localPoint.y = qp(localPoint.y);
      AppMethodBeat.o(127122);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final int a(MediaFormat paramMediaFormat, boolean paramBoolean)
  {
    AppMethodBeat.i(127120);
    ad.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.ivQ, Boolean.valueOf(paramBoolean) });
    this.ivT = paramMediaFormat;
    this.ivA = paramBoolean;
    this.ivR = new d(this.hjX, paramMediaFormat, this.hjY);
    int j = this.ivR.n(this.ivQ, this.startTimeMs, this.hiy);
    bt.aO(bt.HI());
    ad.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      ad.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.ivR.stop();
      this.ivR = null;
      label142:
      this.ivR = new d(this.hjX, paramMediaFormat, this.hjY);
      i = this.ivR.n(this.ivQ, this.startTimeMs, this.hiy);
      this.ivR.a(this);
      ad.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ivS) });
      AppMethodBeat.o(127120);
      return i;
    }
    catch (Exception localException)
    {
      break label142;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(127125);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(127125);
      return;
    }
    Object localObject1 = this.ivR.aNh();
    this.ivD = ((Point)localObject1).x;
    this.ivE = ((Point)localObject1).y;
    long l = bt.HI();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.ivA)
    {
      if ((this.ivK <= 0) || (this.ivJ <= 0))
      {
        this.ivJ = this.ivD;
        this.ivK = this.ivE;
        ad.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.ivJ), Integer.valueOf(this.ivK), Integer.valueOf(this.ivD), Integer.valueOf(this.ivE) });
      }
      if (this.ivT != null)
      {
        k = this.ivT.getInteger("width");
        m = this.ivT.getInteger("height");
        if (this.ivH > 0)
        {
          i = k;
          j = m;
          if (this.ivI > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.ivH = k;
          this.ivI = m;
          ad.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.ivH), Integer.valueOf(this.ivI), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.ivP = this.ivR.aNi();
      k = 0;
      if (this.ivB)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.ivJ, this.ivK, this.ivP, i, j);
        ad.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      }
      if (k < 0) {
        ad.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.ivB) {
        break label1017;
      }
      if (this.ivL == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.ivH, this.ivI, this.ivO.fps, this.ivO.videoBitrate, this.ivO.hVf, 8, this.ivO.hVe, 23.0F, 0, 51);
        this.ivL = new b((byte)0);
        com.tencent.e.h.LTJ.aU(this.ivL);
        ad.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.ivB) });
      }
      label521:
      if ((!this.ivB) && (this.ivN != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = ivU;
        localObject2 = b.iuW.g(Integer.valueOf(paramArrayOfByte.length));
        if (localObject2 != null) {
          System.arraycopy(paramArrayOfByte, 0, localObject2, 0, paramArrayOfByte.length);
        }
        ((Message)localObject1).obj = localObject2;
        if (!paramBoolean) {
          break label1196;
        }
      }
    }
    label1196:
    for (i = 1;; i = 0) {
      for (;;)
      {
        ((Message)localObject1).arg1 = i;
        ((Message)localObject1).arg2 = ((int)paramLong);
        this.ivN.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.ivH = ((Point)localObject1).x;
        this.ivI = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.ivK <= 0) || (this.ivJ <= 0))
        {
          localObject2 = v(this.ivD, this.ivE, this.ivF, this.ivG);
          if (localObject2 != null)
          {
            this.ivJ = ((Point)localObject2).x;
            this.ivK = ((Point)localObject2).y;
            ad.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.ivJ), Integer.valueOf(this.ivK), Integer.valueOf(this.ivD), Integer.valueOf(this.ivE) });
          }
        }
        else
        {
          if (this.ivT == null) {
            break label307;
          }
          k = this.ivT.getInteger("width");
          m = this.ivT.getInteger("height");
          if (this.ivH > 0)
          {
            i = k;
            j = m;
            if (this.ivI > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.ivF, this.ivG);
          if (localObject2 == null) {
            break label957;
          }
          this.ivH = ((Point)localObject2).x;
          this.ivI = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.ivJ = this.ivH;
            this.ivK = this.ivI;
          }
          ad.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.ivH), Integer.valueOf(this.ivI), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.ivJ = this.ivD;
          this.ivK = this.ivE;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.ivH = k;
            this.ivI = m;
          }
          else
          {
            this.ivH = ((Point)localObject1).x;
            this.ivI = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.ivM != null) {
          break label521;
        }
        this.ivM = new c(this.ivH, this.ivI, this.ivO.videoBitrate, this.ivO.fps);
        this.ivM.iuY = new c.a()
        {
          public final void a(int paramAnonymousInt1, ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt2)
          {
            AppMethodBeat.i(127114);
            MP4MuxerJNI.writeH264DataLock(paramAnonymousInt1, paramAnonymousByteBuffer, paramAnonymousInt2);
            AppMethodBeat.o(127114);
          }
        };
        try
        {
          ad.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.ivM.qn(this.bufId)) });
          localObject1 = this.ivM;
          ad.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.ivN == null) {
            this.ivN = new a("remuxer_encode");
          }
          ad.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.ivB) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    ad.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ivF = paramInt1;
    this.ivG = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    ad.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(ivS) });
    try
    {
      if (this.ivR != null) {
        this.ivR.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBufLock(0);
      ivS = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends ap
  {
    private Point ivW = null;
    
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      AppMethodBeat.i(127116);
      byte[] arrayOfByte;
      long l;
      int i;
      int j;
      if (paramMessage.what == h.ivU)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.ivW = h.b(h.this).aNh();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.ivW.x, this.ivW.y, bool, l, h.b(h.this).aNi());
        b.iuW.k(arrayOfByte);
        AppMethodBeat.o(127116);
        return;
        label165:
        bool = false;
        break;
        label171:
        j = 0;
        i = 0;
      }
    }
  }
  
  final class b
    extends com.tencent.e.i.b
  {
    volatile int hjQ;
    int hwa;
    Object hwp;
    boolean ivX;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.hwp = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.hwa == -1)
      {
        this.hwa = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hwa) });
      }
      this.hjQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.hwp)
        {
          if (this.ivX) {
            break label193;
          }
          l = bt.HI();
          ad.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.hjQ), false);
          ad.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hjQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.hjQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(127118);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.VideoTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bt.HI();
      this.hjQ = MP4MuxerJNI.triggerEncodeForSegmentLock(this.hjQ, true);
      ad.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bl.h
 * JD-Core Version:    0.7.0.1
 */