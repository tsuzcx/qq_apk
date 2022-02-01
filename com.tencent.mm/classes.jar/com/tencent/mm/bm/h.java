package com.tencent.mm.bm;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class h
  implements a.a
{
  private static int mjD = -1;
  private static int mjF = 1;
  private int bufId;
  long endTimeMs;
  int fSM;
  int kTg;
  com.tencent.mm.compatible.i.c kUU;
  private Object lock;
  private int mjA;
  String mjB;
  a mjC;
  private MediaFormat mjE;
  private boolean mjn;
  boolean mjo;
  private int mjq;
  private int mjr;
  private int mjs;
  private int mjt;
  private int mju;
  private int mjv;
  b mjw;
  private c mjx;
  a mjy;
  VideoTransPara mjz;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.mjo = false;
    this.mjA = 0;
    this.lock = new byte[0];
    this.kTg = -1;
    this.mjn = false;
    Log.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.bufId = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static Point x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127122);
    Log.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      Log.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(127122);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      Log.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(127122);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      Log.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
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
      Log.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
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
      Log.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = xh(localPoint.x);
      localPoint.y = xh(localPoint.y);
      AppMethodBeat.o(127122);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  private static int xh(int paramInt)
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
  
  public final int a(MediaFormat paramMediaFormat, boolean paramBoolean)
  {
    AppMethodBeat.i(127120);
    Log.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.mjB, Boolean.valueOf(paramBoolean) });
    this.mjE = paramMediaFormat;
    this.mjn = paramBoolean;
    this.mjC = new d(this.kUU, paramMediaFormat, this.videoTrackIndex);
    int j = this.mjC.m(this.mjB, this.startTimeMs, this.endTimeMs);
    Util.ticksToNow(Util.currentTicks());
    Log.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      Log.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.mjC.stop();
      this.mjC = null;
      label142:
      this.mjC = new d(this.kUU, paramMediaFormat, this.videoTrackIndex);
      i = this.mjC.m(this.mjB, this.startTimeMs, this.endTimeMs);
      this.mjC.a(this);
      Log.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(mjD) });
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
      Log.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(127125);
      return;
    }
    Object localObject1 = this.mjC.brg();
    this.srcWidth = ((Point)localObject1).x;
    this.srcHeight = ((Point)localObject1).y;
    long l = Util.currentTicks();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.mjn)
    {
      if ((this.mjv <= 0) || (this.mju <= 0))
      {
        this.mju = this.srcWidth;
        this.mjv = this.srcHeight;
        Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.mju), Integer.valueOf(this.mjv), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      }
      if (this.mjE != null)
      {
        k = this.mjE.getInteger("width");
        m = this.mjE.getInteger("height");
        if (this.mjs > 0)
        {
          i = k;
          j = m;
          if (this.mjt > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.mjs = k;
          this.mjt = m;
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.mjs), Integer.valueOf(this.mjt), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.mjA = this.mjC.brh();
      k = 0;
      if (this.mjo)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.mju, this.mjv, this.mjA, i, j);
        Log.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      if (k < 0) {
        Log.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.mjo) {
        break label1017;
      }
      if (this.mjw == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.mjs, this.mjt, this.mjz.fps, this.mjz.videoBitrate, this.mjz.lJn, 8, this.mjz.lJm, 23.0F, 0, 51);
        this.mjw = new b((byte)0);
        com.tencent.e.h.ZvG.bh(this.mjw);
        Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.mjo) });
      }
      label521:
      if ((!this.mjo) && (this.mjy != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = mjF;
        localObject2 = b.miJ.k(Integer.valueOf(paramArrayOfByte.length));
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
        this.mjy.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.mjs = ((Point)localObject1).x;
        this.mjt = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.mjv <= 0) || (this.mju <= 0))
        {
          localObject2 = x(this.srcWidth, this.srcHeight, this.mjq, this.mjr);
          if (localObject2 != null)
          {
            this.mju = ((Point)localObject2).x;
            this.mjv = ((Point)localObject2).y;
            Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.mju), Integer.valueOf(this.mjv), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
          }
        }
        else
        {
          if (this.mjE == null) {
            break label307;
          }
          k = this.mjE.getInteger("width");
          m = this.mjE.getInteger("height");
          if (this.mjs > 0)
          {
            i = k;
            j = m;
            if (this.mjt > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = x(k, m, this.mjq, this.mjr);
          if (localObject2 == null) {
            break label957;
          }
          this.mjs = ((Point)localObject2).x;
          this.mjt = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.mju = this.mjs;
            this.mjv = this.mjt;
          }
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.mjs), Integer.valueOf(this.mjt), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.mju = this.srcWidth;
          this.mjv = this.srcHeight;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.mjs = k;
            this.mjt = m;
          }
          else
          {
            this.mjs = ((Point)localObject1).x;
            this.mjt = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.mjx != null) {
          break label521;
        }
        this.mjx = new c(this.mjs, this.mjt, this.mjz.videoBitrate, this.mjz.fps);
        this.mjx.miL = new c.a()
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
          Log.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.mjx.xf(this.bufId)) });
          localObject1 = this.mjx;
          Log.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.mjy == null) {
            this.mjy = new a("remuxer_encode");
          }
          Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.mjo) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    Log.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mjq = paramInt1;
    this.mjr = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    Log.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(mjD) });
    try
    {
      if (this.mjC != null) {
        this.mjC.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBufLock(0);
      mjD = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends MMHandler
  {
    private Point mjH = null;
    
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
      if (paramMessage.what == h.mjF)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.mjH = h.b(h.this).brg();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.mjH.x, this.mjH.y, bool, l, h.b(h.this).brh());
        b.miJ.as(arrayOfByte);
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
    volatile int kUo;
    int lhU;
    Object lik;
    boolean mjI;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.lik = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.lhU == -1)
      {
        this.lhU = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.lhU) });
      }
      this.kUo = 0;
      for (;;)
      {
        int i;
        synchronized (this.lik)
        {
          if (this.mjI) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.kUo), false);
          Log.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.kUo;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.kUo = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(127118);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.VideoTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = Util.currentTicks();
      this.kUo = MP4MuxerJNI.triggerEncodeForSegmentLock(this.kUo, true);
      Log.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bm.h
 * JD-Core Version:    0.7.0.1
 */