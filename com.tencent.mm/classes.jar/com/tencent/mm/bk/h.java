package com.tencent.mm.bk;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

public final class h
  implements a.a
{
  private static int iyL = -1;
  private static int iyN = 1;
  private int bufId;
  int dHi;
  long hlm;
  int hlw;
  com.tencent.mm.compatible.h.c hmL;
  int hmM;
  private int iyA;
  private int iyB;
  private int iyC;
  private int iyD;
  b iyE;
  private c iyF;
  a iyG;
  VideoTransPara iyH;
  private int iyI;
  String iyJ;
  a iyK;
  private MediaFormat iyM;
  private boolean iyt;
  boolean iyu;
  private int iyw;
  private int iyx;
  private int iyy;
  private int iyz;
  private Object lock;
  long startTimeMs;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.startTimeMs = -1L;
    this.hlm = -1L;
    this.iyu = false;
    this.iyI = 0;
    this.lock = new byte[0];
    this.hlw = -1;
    this.iyt = false;
    ae.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.bufId = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static int qs(int paramInt)
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
    ae.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ae.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(127122);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ae.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(127122);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ae.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
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
      ae.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
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
      ae.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = qs(localPoint.x);
      localPoint.y = qs(localPoint.y);
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
    ae.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.iyJ, Boolean.valueOf(paramBoolean) });
    this.iyM = paramMediaFormat;
    this.iyt = paramBoolean;
    this.iyK = new d(this.hmL, paramMediaFormat, this.hmM);
    int j = this.iyK.n(this.iyJ, this.startTimeMs, this.hlm);
    bu.aO(bu.HQ());
    ae.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      ae.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.iyK.stop();
      this.iyK = null;
      label142:
      this.iyK = new d(this.hmL, paramMediaFormat, this.hmM);
      i = this.iyK.n(this.iyJ, this.startTimeMs, this.hlm);
      this.iyK.a(this);
      ae.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(iyL) });
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
      ae.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(127125);
      return;
    }
    Object localObject1 = this.iyK.aNF();
    this.iyw = ((Point)localObject1).x;
    this.iyx = ((Point)localObject1).y;
    long l = bu.HQ();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.iyt)
    {
      if ((this.iyD <= 0) || (this.iyC <= 0))
      {
        this.iyC = this.iyw;
        this.iyD = this.iyx;
        ae.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.iyC), Integer.valueOf(this.iyD), Integer.valueOf(this.iyw), Integer.valueOf(this.iyx) });
      }
      if (this.iyM != null)
      {
        k = this.iyM.getInteger("width");
        m = this.iyM.getInteger("height");
        if (this.iyA > 0)
        {
          i = k;
          j = m;
          if (this.iyB > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.iyA = k;
          this.iyB = m;
          ae.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.iyA), Integer.valueOf(this.iyB), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.iyI = this.iyK.aNG();
      k = 0;
      if (this.iyu)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.iyC, this.iyD, this.iyI, i, j);
        ae.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      }
      if (k < 0) {
        ae.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.iyu) {
        break label1017;
      }
      if (this.iyE == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.iyA, this.iyB, this.iyH.fps, this.iyH.videoBitrate, this.iyH.hXX, 8, this.iyH.hXW, 23.0F, 0, 51);
        this.iyE = new b((byte)0);
        com.tencent.e.h.MqF.aR(this.iyE);
        ae.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.iyu) });
      }
      label521:
      if ((!this.iyu) && (this.iyG != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = iyN;
        localObject2 = b.ixQ.h(Integer.valueOf(paramArrayOfByte.length));
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
        this.iyG.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.iyA = ((Point)localObject1).x;
        this.iyB = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.iyD <= 0) || (this.iyC <= 0))
        {
          localObject2 = v(this.iyw, this.iyx, this.iyy, this.iyz);
          if (localObject2 != null)
          {
            this.iyC = ((Point)localObject2).x;
            this.iyD = ((Point)localObject2).y;
            ae.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.iyC), Integer.valueOf(this.iyD), Integer.valueOf(this.iyw), Integer.valueOf(this.iyx) });
          }
        }
        else
        {
          if (this.iyM == null) {
            break label307;
          }
          k = this.iyM.getInteger("width");
          m = this.iyM.getInteger("height");
          if (this.iyA > 0)
          {
            i = k;
            j = m;
            if (this.iyB > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.iyy, this.iyz);
          if (localObject2 == null) {
            break label957;
          }
          this.iyA = ((Point)localObject2).x;
          this.iyB = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.iyC = this.iyA;
            this.iyD = this.iyB;
          }
          ae.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.iyA), Integer.valueOf(this.iyB), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.iyC = this.iyw;
          this.iyD = this.iyx;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.iyA = k;
            this.iyB = m;
          }
          else
          {
            this.iyA = ((Point)localObject1).x;
            this.iyB = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.iyF != null) {
          break label521;
        }
        this.iyF = new c(this.iyA, this.iyB, this.iyH.videoBitrate, this.iyH.fps);
        this.iyF.ixS = new c.a()
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
          ae.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.iyF.qq(this.bufId)) });
          localObject1 = this.iyF;
          ae.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.iyG == null) {
            this.iyG = new a("remuxer_encode");
          }
          ae.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.iyu) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    ae.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iyy = paramInt1;
    this.iyz = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    ae.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(iyL) });
    try
    {
      if (this.iyK != null) {
        this.iyK.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBufLock(0);
      iyL = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends aq
  {
    private Point iyP = null;
    
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
      if (paramMessage.what == h.iyN)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.iyP = h.b(h.this).aNF();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.iyP.x, this.iyP.y, bool, l, h.b(h.this).aNG());
        b.ixQ.k(arrayOfByte);
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
    volatile int hmE;
    int hyO;
    Object hzd;
    boolean iyQ;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.hzd = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.hyO == -1)
      {
        this.hyO = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ae.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hyO) });
      }
      this.hmE = 0;
      for (;;)
      {
        int i;
        synchronized (this.hzd)
        {
          if (this.iyQ) {
            break label193;
          }
          l = bu.HQ();
          ae.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.hmE), false);
          ae.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.hmE;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.hmE = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(127118);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.VideoTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bu.HQ();
      this.hmE = MP4MuxerJNI.triggerEncodeForSegmentLock(this.hmE, true);
      ae.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hmE), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bk.h
 * JD-Core Version:    0.7.0.1
 */