package com.tencent.mm.be;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;

public final class h
  implements a.a
{
  private static int pda = -1;
  private static int pdc = 1;
  private int bufId;
  long endTimeMs;
  int hYK;
  private Object lock;
  com.tencent.mm.compatible.i.c nAr;
  int nyO;
  private boolean pcK;
  boolean pcL;
  private int pcN;
  private int pcO;
  private int pcP;
  private int pcQ;
  private int pcR;
  private int pcS;
  b pcT;
  private c pcU;
  a pcV;
  VideoTransPara pcW;
  private int pcX;
  String pcY;
  a pcZ;
  private MediaFormat pdb;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.pcL = false;
    this.pcX = 0;
    this.lock = new byte[0];
    this.nyO = -1;
    this.pcK = false;
    Log.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.bufId = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static Point D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    Log.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.pcY, Boolean.valueOf(paramBoolean) });
    this.pdb = paramMediaFormat;
    this.pcK = paramBoolean;
    this.pcZ = new d(this.nAr, paramMediaFormat, this.videoTrackIndex);
    int j = this.pcZ.o(this.pcY, this.startTimeMs, this.endTimeMs);
    Util.ticksToNow(Util.currentTicks());
    Log.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      Log.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.pcZ.stop();
      this.pcZ = null;
      label142:
      this.pcZ = new d(this.nAr, paramMediaFormat, this.videoTrackIndex);
      i = this.pcZ.o(this.pcY, this.startTimeMs, this.endTimeMs);
      this.pcZ.a(this);
      Log.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(pda) });
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
    Object localObject1 = this.pcZ.bOM();
    this.srcWidth = ((Point)localObject1).x;
    this.srcHeight = ((Point)localObject1).y;
    long l = Util.currentTicks();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.pcK)
    {
      if ((this.pcS <= 0) || (this.pcR <= 0))
      {
        this.pcR = this.srcWidth;
        this.pcS = this.srcHeight;
        Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.pcR), Integer.valueOf(this.pcS), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      }
      if (this.pdb != null)
      {
        k = this.pdb.getInteger("width");
        m = this.pdb.getInteger("height");
        if (this.pcP > 0)
        {
          i = k;
          j = m;
          if (this.pcQ > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.pcP = k;
          this.pcQ = m;
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.pcP), Integer.valueOf(this.pcQ), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.pcX = this.pcZ.bON();
      k = 0;
      if (this.pcL)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.pcR, this.pcS, this.pcX, i, j);
        Log.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      if (k < 0) {
        Log.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.pcL) {
        break label1017;
      }
      if (this.pcT == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.pcP, this.pcQ, this.pcW.fps, this.pcW.videoBitrate, this.pcW.oBP, 8, this.pcW.oBO, 23.0F, 0, 51);
        this.pcT = new b((byte)0);
        com.tencent.threadpool.h.ahAA.bp(this.pcT);
        Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.pcL) });
      }
      label521:
      if ((!this.pcL) && (this.pcV != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = pdc;
        localObject2 = b.pcg.m(Integer.valueOf(paramArrayOfByte.length));
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
        this.pcV.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.pcP = ((Point)localObject1).x;
        this.pcQ = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.pcS <= 0) || (this.pcR <= 0))
        {
          localObject2 = D(this.srcWidth, this.srcHeight, this.pcN, this.pcO);
          if (localObject2 != null)
          {
            this.pcR = ((Point)localObject2).x;
            this.pcS = ((Point)localObject2).y;
            Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.pcR), Integer.valueOf(this.pcS), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
          }
        }
        else
        {
          if (this.pdb == null) {
            break label307;
          }
          k = this.pdb.getInteger("width");
          m = this.pdb.getInteger("height");
          if (this.pcP > 0)
          {
            i = k;
            j = m;
            if (this.pcQ > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = D(k, m, this.pcN, this.pcO);
          if (localObject2 == null) {
            break label957;
          }
          this.pcP = ((Point)localObject2).x;
          this.pcQ = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.pcR = this.pcP;
            this.pcS = this.pcQ;
          }
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.pcP), Integer.valueOf(this.pcQ), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.pcR = this.srcWidth;
          this.pcS = this.srcHeight;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.pcP = k;
            this.pcQ = m;
          }
          else
          {
            this.pcP = ((Point)localObject1).x;
            this.pcQ = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.pcU != null) {
          break label521;
        }
        this.pcU = new c(this.pcP, this.pcQ, this.pcW.videoBitrate, this.pcW.fps);
        this.pcU.pci = new c.a()
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
          Log.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.pcU.xf(this.bufId)) });
          localObject1 = this.pcU;
          Log.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.pcV == null) {
            this.pcV = new a("remuxer_encode");
          }
          Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.pcL) });
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
  
  public final void eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    Log.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pcN = paramInt1;
    this.pcO = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    Log.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(pda) });
    try
    {
      if (this.pcZ != null) {
        this.pcZ.stop();
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
      pda = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends MMHandler
  {
    private Point pde = null;
    
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
      if (paramMessage.what == h.pdc)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label162;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.pde = h.b(h.this).bOM();
          if (h.c(h.this) == null) {
            break label168;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.pde.x, this.pde.y, bool, l, h.b(h.this).bON());
        b.pcg.as(arrayOfByte);
        AppMethodBeat.o(127116);
        return;
        label162:
        bool = false;
        break;
        label168:
        j = 0;
        i = 0;
      }
    }
  }
  
  final class b
    extends com.tencent.threadpool.i.b
  {
    int nMD;
    Object nMT;
    volatile int nzX;
    boolean pdf;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.nMT = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.nMD == -1)
      {
        this.nMD = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.nMD) });
      }
      this.nzX = 0;
      for (;;)
      {
        int i;
        synchronized (this.nMT)
        {
          if (this.pdf) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.nzX), false);
          Log.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.nzX;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.nzX = i;
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
      this.nzX = MP4MuxerJNI.triggerEncodeForSegmentLock(this.nzX, true);
      Log.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.h
 * JD-Core Version:    0.7.0.1
 */