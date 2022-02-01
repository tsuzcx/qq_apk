package com.tencent.mm.bk;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.f.i;
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
  private static int jtZ = -1;
  private static int jub = 1;
  private int bufId;
  int dYT;
  long endTimeMs;
  int ies;
  com.tencent.mm.compatible.i.c igg;
  private boolean jtJ;
  boolean jtK;
  private int jtM;
  private int jtN;
  private int jtO;
  private int jtP;
  private int jtQ;
  private int jtR;
  b jtS;
  private c jtT;
  a jtU;
  VideoTransPara jtV;
  private int jtW;
  String jtX;
  a jtY;
  private MediaFormat jua;
  private Object lock;
  private int srcHeight;
  private int srcWidth;
  long startTimeMs;
  int videoTrackIndex;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.startTimeMs = -1L;
    this.endTimeMs = -1L;
    this.jtK = false;
    this.jtW = 0;
    this.lock = new byte[0];
    this.ies = -1;
    this.jtJ = false;
    Log.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.bufId = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static int uh(int paramInt)
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
      localPoint.x = uh(localPoint.x);
      localPoint.y = uh(localPoint.y);
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
    Log.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.jtX, Boolean.valueOf(paramBoolean) });
    this.jua = paramMediaFormat;
    this.jtJ = paramBoolean;
    this.jtY = new d(this.igg, paramMediaFormat, this.videoTrackIndex);
    int j = this.jtY.n(this.jtX, this.startTimeMs, this.endTimeMs);
    Util.ticksToNow(Util.currentTicks());
    Log.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      Log.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.jtY.stop();
      this.jtY = null;
      label142:
      this.jtY = new d(this.igg, paramMediaFormat, this.videoTrackIndex);
      i = this.jtY.n(this.jtX, this.startTimeMs, this.endTimeMs);
      this.jtY.a(this);
      Log.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(jtZ) });
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
    Object localObject1 = this.jtY.bhJ();
    this.srcWidth = ((Point)localObject1).x;
    this.srcHeight = ((Point)localObject1).y;
    long l = Util.currentTicks();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.jtJ)
    {
      if ((this.jtR <= 0) || (this.jtQ <= 0))
      {
        this.jtQ = this.srcWidth;
        this.jtR = this.srcHeight;
        Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
      }
      if (this.jua != null)
      {
        k = this.jua.getInteger("width");
        m = this.jua.getInteger("height");
        if (this.jtO > 0)
        {
          i = k;
          j = m;
          if (this.jtP > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.jtO = k;
          this.jtP = m;
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.jtW = this.jtY.bhK();
      k = 0;
      if (this.jtK)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.jtQ, this.jtR, this.jtW, i, j);
        Log.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      if (k < 0) {
        Log.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.jtK) {
        break label1017;
      }
      if (this.jtS == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.jtO, this.jtP, this.jtV.fps, this.jtV.videoBitrate, this.jtV.iSV, 8, this.jtV.iSU, 23.0F, 0, 51);
        this.jtS = new b((byte)0);
        com.tencent.f.h.RTc.ba(this.jtS);
        Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.jtK) });
      }
      label521:
      if ((!this.jtK) && (this.jtU != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = jub;
        localObject2 = b.jtf.h(Integer.valueOf(paramArrayOfByte.length));
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
        this.jtU.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.jtO = ((Point)localObject1).x;
        this.jtP = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.jtR <= 0) || (this.jtQ <= 0))
        {
          localObject2 = v(this.srcWidth, this.srcHeight, this.jtM, this.jtN);
          if (localObject2 != null)
          {
            this.jtQ = ((Point)localObject2).x;
            this.jtR = ((Point)localObject2).y;
            Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight) });
          }
        }
        else
        {
          if (this.jua == null) {
            break label307;
          }
          k = this.jua.getInteger("width");
          m = this.jua.getInteger("height");
          if (this.jtO > 0)
          {
            i = k;
            j = m;
            if (this.jtP > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.jtM, this.jtN);
          if (localObject2 == null) {
            break label957;
          }
          this.jtO = ((Point)localObject2).x;
          this.jtP = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.jtQ = this.jtO;
            this.jtR = this.jtP;
          }
          Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.jtQ = this.srcWidth;
          this.jtR = this.srcHeight;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.jtO = k;
            this.jtP = m;
          }
          else
          {
            this.jtO = ((Point)localObject1).x;
            this.jtP = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.jtT != null) {
          break label521;
        }
        this.jtT = new c(this.jtO, this.jtP, this.jtV.videoBitrate, this.jtV.fps);
        this.jtT.jth = new c.a()
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
          Log.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.jtT.ug(this.bufId)) });
          localObject1 = this.jtT;
          Log.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.jtU == null) {
            this.jtU = new a("remuxer_encode");
          }
          Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.jtK) });
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
  
  public final void dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    Log.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.jtM = paramInt1;
    this.jtN = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    Log.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(jtZ) });
    try
    {
      if (this.jtY != null) {
        this.jtY.stop();
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
      jtZ = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends MMHandler
  {
    private Point jud = null;
    
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
      if (paramMessage.what == h.jub)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.jud = h.b(h.this).bhJ();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.jud.x, this.jud.y, bool, l, h.b(h.this).bhK());
        b.jtf.k(arrayOfByte);
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
    extends com.tencent.f.i.b
  {
    volatile int ifA;
    int isP;
    Object ite;
    boolean jue;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.ite = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.isP == -1)
      {
        this.isP = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.isP) });
      }
      this.ifA = 0;
      for (;;)
      {
        int i;
        synchronized (this.ite)
        {
          if (this.jue) {
            break label193;
          }
          l = Util.currentTicks();
          Log.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.ifA), false);
          Log.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.ifA;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.ifA = i;
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
      this.ifA = MP4MuxerJNI.triggerEncodeForSegmentLock(this.ifA, true);
      Log.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bk.h
 * JD-Core Version:    0.7.0.1
 */