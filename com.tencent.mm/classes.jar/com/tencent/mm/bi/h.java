package com.tencent.mm.bi;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  implements a.a
{
  private static int eJF = -1;
  private static int eJH = 1;
  long aRW = -1L;
  long eIR = -1L;
  int eIU;
  int eIV = -1;
  private int eIz;
  VideoTransPara eJA;
  private int eJB = 0;
  String eJC;
  MediaExtractor eJD;
  a eJE;
  private MediaFormat eJG;
  private boolean eJk = false;
  private int eJm;
  private int eJn;
  private int eJo;
  private int eJp;
  private int eJq;
  private int eJr;
  private int eJs;
  private int eJt;
  boolean eJu = false;
  b eJv;
  Thread eJw;
  private c eJx;
  HandlerThread eJy;
  h.a eJz;
  private Object lock = new byte[0];
  int rotate;
  
  public h(int paramInt)
  {
    y.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eIz = paramInt;
  }
  
  private static int jw(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    int j = paramInt - Math.min(16, i);
    if (j < 2147483647) {
      return j;
    }
    return paramInt - i;
  }
  
  private static Point n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      y.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      y.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      y.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
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
      return new Point(paramInt1, paramInt2);
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      y.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
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
      return new Point(paramInt1, paramInt2);
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
      y.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = jw(localPoint.x);
      localPoint.y = jw(localPoint.y);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final int a(MediaFormat paramMediaFormat, boolean paramBoolean)
  {
    y.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.eJC, Boolean.valueOf(paramBoolean) });
    this.eJG = paramMediaFormat;
    this.eJk = paramBoolean;
    this.eJE = new d(this.eJD, paramMediaFormat, this.eIU);
    int j = this.eJE.i(this.eJC, this.aRW, this.eIR);
    bk.cp(bk.UZ());
    y.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      y.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.eJE.stop();
      this.eJE = null;
      label137:
      this.eJE = new d(this.eJD, paramMediaFormat, this.eIU);
      i = this.eJE.i(this.eJC, this.aRW, this.eIR);
      this.eJE.a(this);
      y.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eJF) });
      return i;
    }
    catch (Exception localException)
    {
      break label137;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      return;
    }
    int j;
    int k;
    int m;
    label233:
    while ((this.eJu) || (this.eJz == null))
    {
      localObject1 = this.eJE.SP();
      this.eJm = ((Point)localObject1).x;
      this.eJn = ((Point)localObject1).y;
      long l = bk.UZ();
      i = 0;
      j = 0;
      if (this.eJk) {
        break label630;
      }
      if ((this.eJt <= 0) || (this.eJs <= 0))
      {
        this.eJs = this.eJm;
        this.eJt = this.eJn;
        y.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.eJs), Integer.valueOf(this.eJt), Integer.valueOf(this.eJm), Integer.valueOf(this.eJn) });
      }
      if (this.eJG != null)
      {
        k = this.eJG.getInteger("width");
        m = this.eJG.getInteger("height");
        if (this.eJq > 0)
        {
          i = k;
          j = m;
          if (this.eJr > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break;
          }
          this.eJq = k;
          this.eJr = m;
          y.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.eJq), Integer.valueOf(this.eJr), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(false) });
          j = m;
          i = k;
        }
      }
      this.eJB = this.eJE.SQ();
      k = 0;
      if (this.eJu) {
        k = MP4MuxerJNI.writeYuvDataForSegment(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.eJs, this.eJt, this.eJB, i, j);
      }
      y.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      if (k < 0) {
        y.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.eJu) {
        break label1004;
      }
      if (this.eJv == null)
      {
        MP4MuxerJNI.initH264Encoder(this.eJq, this.eJr, this.eJA.fps, this.eJA.videoBitrate, this.eJA.ejP, 8, this.eJA.ejO, 23.0F);
        this.eJv = new b((byte)0);
        this.eJw = e.b(this.eJv, "MediaCodecFFMpegTranscoder_Encoder");
        this.eJw.start();
        y.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.eJu) });
      }
    }
    label296:
    Object localObject1 = Message.obtain();
    ((Message)localObject1).what = eJH;
    Object localObject2 = b.eIx.f(Integer.valueOf(paramArrayOfByte.length));
    if (localObject2 != null) {
      System.arraycopy(paramArrayOfByte, 0, localObject2, 0, paramArrayOfByte.length);
    }
    ((Message)localObject1).obj = localObject2;
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      for (;;)
      {
        ((Message)localObject1).arg1 = i;
        ((Message)localObject1).arg2 = ((int)paramLong);
        this.eJz.sendMessage((Message)localObject1);
        return;
        this.eJq = ((Point)localObject1).x;
        this.eJr = ((Point)localObject1).y;
        break label233;
        label630:
        boolean bool;
        if ((this.eJt <= 0) || (this.eJs <= 0))
        {
          localObject2 = n(this.eJm, this.eJn, this.eJo, this.eJp);
          if (localObject2 != null)
          {
            this.eJs = ((Point)localObject2).x;
            this.eJt = ((Point)localObject2).y;
            label688:
            y.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.eJs), Integer.valueOf(this.eJt), Integer.valueOf(this.eJm), Integer.valueOf(this.eJn) });
          }
        }
        else
        {
          if (this.eJG == null) {
            break label296;
          }
          k = this.eJG.getInteger("width");
          m = this.eJG.getInteger("height");
          if (this.eJq > 0)
          {
            i = k;
            j = m;
            if (this.eJr > 0) {
              break label296;
            }
          }
          bool = false;
          localObject2 = n(k, m, this.eJo, this.eJp);
          if (localObject2 == null) {
            break label944;
          }
          this.eJq = ((Point)localObject2).x;
          this.eJr = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.eJs = this.eJq;
            this.eJt = this.eJr;
          }
          y.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.eJq), Integer.valueOf(this.eJr), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.eJs = this.eJm;
          this.eJt = this.eJn;
          break label688;
          label944:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.eJq = k;
            this.eJr = m;
          }
          else
          {
            this.eJq = ((Point)localObject1).x;
            this.eJr = ((Point)localObject1).y;
          }
        }
        label1004:
        if (this.eJx != null) {
          break;
        }
        this.eJx = new c(this.eJq, this.eJr, this.eJA.videoBitrate, this.eJA.fps);
        this.eJx.eIA = new h.1(this);
        try
        {
          y.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.eJx.jv(this.eIz)) });
          localObject1 = this.eJx;
          y.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).bSr = true;
          if (this.eJy == null)
          {
            this.eJy = e.ds("remuxer_encode", -2);
            this.eJy.start();
            this.eJz = new h.a(this, this.eJy.getLooper());
          }
          y.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.eJu) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void by(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eJo = paramInt1;
    this.eJp = paramInt2;
  }
  
  public final void release()
  {
    y.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(eJF) });
    try
    {
      if (this.eJE != null) {
        this.eJE.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBuf(0);
      eJF = -1;
    }
  }
  
  private final class b
    implements Runnable
  {
    volatile int eJK;
    int eJL;
    boolean eJM;
    Object eJN = new Object();
    
    private b() {}
    
    public final void run()
    {
      if (this.eJL == -1)
      {
        this.eJL = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        y.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.eJL) });
      }
      this.eJK = 0;
      for (;;)
      {
        int i;
        synchronized (this.eJN)
        {
          if (this.eJM) {
            break label183;
          }
          l = bk.UZ();
          y.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.eJK), false);
          y.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.eJK;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.eJK = i;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.VideoTranscoder", "thread sleep error");
          }
        }
      }
      label183:
      long l = bk.UZ();
      this.eJK = MP4MuxerJNI.triggerEncodeForSegment(this.eJK, true);
      y.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Long.valueOf(Thread.currentThread().getId()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bi.h
 * JD-Core Version:    0.7.0.1
 */