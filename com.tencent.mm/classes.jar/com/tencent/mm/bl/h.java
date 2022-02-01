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
  private static int hBV = -1;
  private static int hBX = 1;
  long bxw;
  int dwp;
  private int gmW;
  long gnO;
  int gnX;
  com.tencent.mm.compatible.h.c gqX;
  int gqY;
  private boolean hBD;
  boolean hBE;
  private int hBG;
  private int hBH;
  private int hBI;
  private int hBJ;
  private int hBK;
  private int hBL;
  private int hBM;
  private int hBN;
  b hBO;
  private c hBP;
  a hBQ;
  VideoTransPara hBR;
  private int hBS;
  String hBT;
  a hBU;
  private MediaFormat hBW;
  private Object lock;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(127119);
    this.bxw = -1L;
    this.gnO = -1L;
    this.hBE = false;
    this.hBS = 0;
    this.lock = new byte[0];
    this.gnX = -1;
    this.hBD = false;
    ad.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gmW = paramInt;
    AppMethodBeat.o(127119);
  }
  
  private static int oY(int paramInt)
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
      localPoint.x = oY(localPoint.x);
      localPoint.y = oY(localPoint.y);
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
    ad.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.hBT, Boolean.valueOf(paramBoolean) });
    this.hBW = paramMediaFormat;
    this.hBD = paramBoolean;
    this.hBU = new d(this.gqX, paramMediaFormat, this.gqY);
    int j = this.hBU.q(this.hBT, this.bxw, this.gnO);
    bt.aS(bt.GC());
    ad.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      ad.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.hBU.stop();
      this.hBU = null;
      label142:
      this.hBU = new d(this.gqX, paramMediaFormat, this.gqY);
      i = this.hBU.q(this.hBT, this.bxw, this.gnO);
      this.hBU.a(this);
      ad.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(hBV) });
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
    Object localObject1 = this.hBU.aDh();
    this.hBG = ((Point)localObject1).x;
    this.hBH = ((Point)localObject1).y;
    long l = bt.GC();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.hBD)
    {
      if ((this.hBN <= 0) || (this.hBM <= 0))
      {
        this.hBM = this.hBG;
        this.hBN = this.hBH;
        ad.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.hBM), Integer.valueOf(this.hBN), Integer.valueOf(this.hBG), Integer.valueOf(this.hBH) });
      }
      if (this.hBW != null)
      {
        k = this.hBW.getInteger("width");
        m = this.hBW.getInteger("height");
        if (this.hBK > 0)
        {
          i = k;
          j = m;
          if (this.hBL > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label620;
          }
          this.hBK = k;
          this.hBL = m;
          ad.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.hBK), Integer.valueOf(this.hBL), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.hBS = this.hBU.aDi();
      k = 0;
      if (this.hBE)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.hBM, this.hBN, this.hBS, i, j);
        ad.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      }
      if (k < 0) {
        ad.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.hBE) {
        break label1017;
      }
      if (this.hBO == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.hBK, this.hBL, this.hBR.fps, this.hBR.videoBitrate, this.hBR.hbY, 8, this.hBR.hbX, 23.0F, 0, 51);
        this.hBO = new b((byte)0);
        com.tencent.e.h.Iye.aS(this.hBO);
        ad.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.hBE) });
      }
      label521:
      if ((!this.hBE) && (this.hBQ != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = hBX;
        localObject2 = b.hAZ.g(Integer.valueOf(paramArrayOfByte.length));
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
        this.hBQ.sendMessage((Message)localObject1);
        AppMethodBeat.o(127125);
        return;
        label620:
        this.hBK = ((Point)localObject1).x;
        this.hBL = ((Point)localObject1).y;
        break;
        label699:
        boolean bool;
        if ((this.hBN <= 0) || (this.hBM <= 0))
        {
          localObject2 = v(this.hBG, this.hBH, this.hBI, this.hBJ);
          if (localObject2 != null)
          {
            this.hBM = ((Point)localObject2).x;
            this.hBN = ((Point)localObject2).y;
            ad.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.hBM), Integer.valueOf(this.hBN), Integer.valueOf(this.hBG), Integer.valueOf(this.hBH) });
          }
        }
        else
        {
          if (this.hBW == null) {
            break label307;
          }
          k = this.hBW.getInteger("width");
          m = this.hBW.getInteger("height");
          if (this.hBK > 0)
          {
            i = k;
            j = m;
            if (this.hBL > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.hBI, this.hBJ);
          if (localObject2 == null) {
            break label957;
          }
          this.hBK = ((Point)localObject2).x;
          this.hBL = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.hBM = this.hBK;
            this.hBN = this.hBL;
          }
          ad.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.hBK), Integer.valueOf(this.hBL), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.hBM = this.hBG;
          this.hBN = this.hBH;
          break label699;
          label957:
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.hBK = k;
            this.hBL = m;
          }
          else
          {
            this.hBK = ((Point)localObject1).x;
            this.hBL = ((Point)localObject1).y;
          }
        }
        label1017:
        if (this.hBP != null) {
          break label521;
        }
        this.hBP = new c(this.hBK, this.hBL, this.hBR.videoBitrate, this.hBR.fps);
        this.hBP.hBb = new c.a()
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
          ad.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.hBP.oW(this.gmW)) });
          localObject1 = this.hBP;
          ad.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.hBQ == null) {
            this.hBQ = new a("remuxer_encode");
          }
          ad.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.hBE) });
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
  
  public final void jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127121);
    ad.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hBI = paramInt1;
    this.hBJ = paramInt2;
    AppMethodBeat.o(127121);
  }
  
  public final void release()
  {
    AppMethodBeat.i(127124);
    ad.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(hBV) });
    try
    {
      if (this.hBU != null) {
        this.hBU.stop();
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
      hBV = -1;
      AppMethodBeat.o(127124);
    }
  }
  
  final class a
    extends ap
  {
    private Point hBZ = null;
    
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
      if (paramMessage.what == h.hBX)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label165;
        }
        l = paramMessage.arg2;
        if (h.a(h.this) != null)
        {
          this.hBZ = h.b(h.this).aDh();
          if (h.c(h.this) == null) {
            break label171;
          }
          i = h.c(h.this).getInteger("width");
          j = h.c(h.this).getInteger("height");
        }
      }
      for (;;)
      {
        h.a(h.this).a(arrayOfByte, i, j, this.hBZ.x, this.hBZ.y, bool, l, h.b(h.this).aDi());
        b.hAZ.k(arrayOfByte);
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
    Object gDG;
    int gDr;
    volatile int gqQ;
    boolean hCa;
    
    private b()
    {
      AppMethodBeat.i(127117);
      this.gDG = new Object();
      AppMethodBeat.o(127117);
    }
    
    public final String getKey()
    {
      return "MediaCodecFFMpegTranscoder_Encoder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(127118);
      if (this.gDr == -1)
      {
        this.gDr = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.VideoTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.gDr) });
      }
      this.gqQ = 0;
      for (;;)
      {
        int i;
        synchronized (this.gDG)
        {
          if (this.hCa) {
            break label193;
          }
          l = bt.GC();
          ad.i("MicroMsg.VideoTranscoder", "try trigger encode");
          i = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.gqQ), false);
          ad.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          int j = this.gqQ;
          if (i != j) {}
        }
        try
        {
          Thread.sleep(5L);
          this.gqQ = i;
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
      long l = bt.GC();
      this.gqQ = MP4MuxerJNI.triggerEncodeForSegmentLock(this.gqQ, true);
      ad.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gqQ), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bl.h
 * JD-Core Version:    0.7.0.1
 */