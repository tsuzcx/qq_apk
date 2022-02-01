package com.tencent.mm.bk;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

public final class h
  implements a.a
{
  private static int icw = -1;
  private static int icy = 1;
  long bvf;
  int duc;
  private int gNJ;
  int gOI;
  long gOz;
  com.tencent.mm.compatible.h.c gRF;
  int gRG;
  private boolean ice;
  boolean icf;
  private int ich;
  private int ici;
  private int icj;
  private int ick;
  private int icl;
  private int icm;
  private int icn;
  private int ico;
  b icp;
  private c icq;
  a icr;
  VideoTransPara ics;
  private int ict;
  String icu;
  a icv;
  private MediaFormat icx;
  private Object lock;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.bvf = -1L;
    this.gOz = -1L;
    this.icf = false;
    this.ict = 0;
    this.lock = new byte[0];
    this.gOI = -1;
    this.ice = false;
    ac.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gNJ = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static int pN(int paramInt)
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
    ac.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ac.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(127122);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ac.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(127122);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ac.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
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
      ac.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
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
      ac.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = pN(localPoint.x);
      localPoint.y = pN(localPoint.y);
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
    ac.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.icu, Boolean.valueOf(paramBoolean) });
    this.icx = paramMediaFormat;
    this.ice = paramBoolean;
    this.icv = new d(this.gRF, paramMediaFormat, this.gRG);
    int j = this.icv.n(this.icu, this.bvf, this.gOz);
    bs.aO(bs.Gn());
    ac.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      ac.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.icv.stop();
      this.icv = null;
      label142:
      this.icv = new d(this.gRF, paramMediaFormat, this.gRG);
      i = this.icv.n(this.icu, this.bvf, this.gOz);
      this.icv.a(this);
      ac.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(icw) });
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
      ac.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(127125);
      return;
    }
    Object localObject1 = this.icv.aJY();
    this.ich = ((Point)localObject1).x;
    this.ici = ((Point)localObject1).y;
    long l = bs.Gn();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.ice)
    {
      if ((this.ico <= 0) || (this.icn <= 0))
      {
        this.icn = this.ich;
        this.ico = this.ici;
        ac.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.icn), Integer.valueOf(this.ico), Integer.valueOf(this.ich), Integer.valueOf(this.ici) });
      }
      if (this.icx != null)
      {
        k = this.icx.getInteger("width");
        m = this.icx.getInteger("height");
        if (this.icl > 0)
        {
          i = k;
          j = m;
          if (this.icm > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.icl = k;
          this.icm = m;
          ac.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.icl), Integer.valueOf(this.icm), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.ict = this.icv.aJZ();
      k = 0;
      if (this.icf)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.icn, this.ico, this.ict, i, j);
        ac.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      }
      if (k < 0) {
        ac.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.icf) {
        break label1017;
      }
      if (this.icp == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.icl, this.icm, this.ics.fps, this.ics.videoBitrate, this.ics.hCA, 8, this.ics.hCz, 23.0F, 0, 51);
        this.icp = new b((byte)0);
        com.tencent.e.h.JZN.aV(this.icp);
        ac.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.icf) });
      }
      label521:
      if ((!this.icf) && (this.icr != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = icy;
        localObject2 = b.ibA.g(Integer.valueOf(paramArrayOfByte.length));
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
        this.icr.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.icl = ((Point)localObject1).x;
        this.icm = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.ico <= 0) || (this.icn <= 0))
        {
          localObject2 = v(this.ich, this.ici, this.icj, this.ick);
          if (localObject2 != null)
          {
            this.icn = ((Point)localObject2).x;
            this.ico = ((Point)localObject2).y;
            ac.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.icn), Integer.valueOf(this.ico), Integer.valueOf(this.ich), Integer.valueOf(this.ici) });
          }
        }
        else
        {
          if (this.icx == null) {
            break label307;
          }
          k = this.icx.getInteger("width");
          m = this.icx.getInteger("height");
          if (this.icl > 0)
          {
            i = k;
            j = m;
            if (this.icm > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.icj, this.ick);
          if (localObject2 == null) {
            break label957;
          }
          this.icl = ((Point)localObject2).x;
          this.icm = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.icn = this.icl;
            this.ico = this.icm;
          }
          ac.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.icl), Integer.valueOf(this.icm), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.icn = this.ich;
          this.ico = this.ici;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.icl = k;
            this.icm = m;
          }
          else
          {
            this.icl = ((Point)localObject1).x;
            this.icm = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.icq != null) {
          break label521;
        }
        this.icq = new c(this.icl, this.icm, this.ics.videoBitrate, this.ics.fps);
        this.icq.ibC = new c.a()
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
          ac.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.icq.pL(this.gNJ)) });
          localObject1 = this.icq;
          ac.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.icr == null) {
            this.icr = new a("remuxer_encode");
          }
          ac.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.icf) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    ac.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.icj = paramInt1;
    this.ick = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    ac.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(icw) });
    try
    {
      if (this.icv != null) {
        this.icv.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBufLock(0);
      icw = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends ao
  {
    private Point icA = null;
    
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
      if (paramMessage.what == h.icy)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.icA = h.b(h.this).aJY();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.icA.x, this.icA.y, bool, l, h.b(h.this).aJZ());
        b.ibA.k(arrayOfByte);
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
    volatile int gRy;
    int hdS;
    Object heh;
    boolean icB;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.heh = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.hdS == -1)
      {
        this.hdS = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ac.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.hdS) });
      }
      this.gRy = 0;
      for (;;)
      {
        int i;
        synchronized (this.heh)
        {
          if (this.icB) {
            break label193;
          }
          l = bs.Gn();
          ac.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.gRy), false);
          ac.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gRy;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.gRy = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(127118);
          throw localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.VideoTranscoder", "thread sleep error");
          }
        }
      }
      label193:
      long l = bs.Gn();
      this.gRy = MP4MuxerJNI.triggerEncodeForSegmentLock(this.gRy, true);
      ac.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bk.h
 * JD-Core Version:    0.7.0.1
 */