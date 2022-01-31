package com.tencent.mm.bj;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  implements a.a
{
  private static int fZi = -1;
  private static int fZk = 1;
  long aZw;
  long eRN;
  int eRW;
  private int eRm;
  int eUR;
  private boolean fYO;
  boolean fYP;
  private int fYR;
  private int fYS;
  private int fYT;
  private int fYU;
  private int fYV;
  private int fYW;
  private int fYX;
  private int fYY;
  h.b fYZ;
  Thread fZa;
  private c fZb;
  HandlerThread fZc;
  h.a fZd;
  VideoTransPara fZe;
  private int fZf;
  String fZg;
  a fZh;
  private MediaFormat fZj;
  private Object lock;
  MediaExtractor mediaExtractor;
  int rotate;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(50949);
    this.aZw = -1L;
    this.eRN = -1L;
    this.fYP = false;
    this.fZf = 0;
    this.lock = new byte[0];
    this.eRW = -1;
    this.fYO = false;
    ab.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eRm = paramInt;
    AppMethodBeat.o(50949);
  }
  
  private static int mp(int paramInt)
  {
    AppMethodBeat.i(50953);
    int i = paramInt % 16;
    if (i == 0)
    {
      AppMethodBeat.o(50953);
      return paramInt;
    }
    int j = paramInt - Math.min(16, i);
    if (j < 2147483647)
    {
      AppMethodBeat.o(50953);
      return j;
    }
    AppMethodBeat.o(50953);
    return paramInt - i;
  }
  
  private static Point v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50952);
    ab.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + paramInt1 + "], decoderOutputHeight = [" + paramInt2 + "], specWidth = [" + paramInt3 + "], specHeight = [" + paramInt4 + "]");
    if ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))
    {
      ab.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
      AppMethodBeat.o(50952);
      return null;
    }
    int m = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    int i = Math.max(paramInt3, paramInt4);
    int j = Math.min(paramInt3, paramInt4);
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ab.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
      AppMethodBeat.o(50952);
      return null;
    }
    if ((m / 2 == i) && (k / 2 == j))
    {
      ab.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
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
      AppMethodBeat.o(50952);
      return localPoint;
    }
    m /= 2;
    k /= 2;
    if ((m % 16 == 0) && (Math.abs(m - i) < 16) && (k % 16 == 0) && (Math.abs(k - j) < 16))
    {
      ab.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
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
      AppMethodBeat.o(50952);
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
      ab.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localPoint.x = paramInt2;
      localPoint.y = paramInt3;
      localPoint.x = mp(localPoint.x);
      localPoint.y = mp(localPoint.y);
      AppMethodBeat.o(50952);
      return localPoint;
      paramInt3 = Math.min(paramInt3, paramInt4);
      d = paramInt2 * 1.0D / paramInt3;
      paramInt1 = (int)(paramInt1 / d);
      paramInt2 = paramInt3;
    }
  }
  
  public final int a(MediaFormat paramMediaFormat, boolean paramBoolean)
  {
    AppMethodBeat.i(50950);
    ab.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", new Object[] { paramMediaFormat, this.fZg, Boolean.valueOf(paramBoolean) });
    this.fZj = paramMediaFormat;
    this.fYO = paramBoolean;
    this.fZh = new d(this.mediaExtractor, paramMediaFormat, this.eUR);
    int j = this.fZh.p(this.fZg, this.aZw, this.eRN);
    bo.av(bo.yB());
    ab.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", new Object[] { Integer.valueOf(j) });
    int i = j;
    if (j < 0) {
      ab.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
    }
    try
    {
      this.fZh.stop();
      this.fZh = null;
      label142:
      this.fZh = new d(this.mediaExtractor, paramMediaFormat, this.eUR);
      i = this.fZh.p(this.fZg, this.aZw, this.eRN);
      this.fZh.a(this);
      ab.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(fZi) });
      AppMethodBeat.o(50950);
      return i;
    }
    catch (Exception localException)
    {
      break label142;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(50955);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
      AppMethodBeat.o(50955);
      return;
    }
    Object localObject1 = this.fZh.amc();
    this.fYR = ((Point)localObject1).x;
    this.fYS = ((Point)localObject1).y;
    long l = bo.yB();
    int i = 0;
    int j = 0;
    int k;
    int m;
    label307:
    Object localObject2;
    if (!this.fYO)
    {
      if ((this.fYY <= 0) || (this.fYX <= 0))
      {
        this.fYX = this.fYR;
        this.fYY = this.fYS;
        ab.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.fYX), Integer.valueOf(this.fYY), Integer.valueOf(this.fYR), Integer.valueOf(this.fYS) });
      }
      if (this.fZj != null)
      {
        k = this.fZj.getInteger("width");
        m = this.fZj.getInteger("height");
        if (this.fYV > 0)
        {
          i = k;
          j = m;
          if (this.fYW > 0) {}
        }
        else
        {
          if ((Math.abs(m - ((Point)localObject1).y) <= 0) || (k != ((Point)localObject1).x)) {
            break label628;
          }
          this.fYV = k;
          this.fYW = m;
          ab.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.fYV), Integer.valueOf(this.fYW), Integer.valueOf(k), Integer.valueOf(m), Boolean.FALSE });
          j = m;
          i = k;
        }
      }
      this.fZf = this.fZh.amd();
      k = 0;
      if (this.fYP)
      {
        k = MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y, this.fYX, this.fYY, this.fZf, i, j);
        ab.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      }
      if (k < 0) {
        ab.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", new Object[] { Integer.valueOf(k) });
      }
      if (!this.fYP) {
        break label1025;
      }
      if (this.fYZ == null)
      {
        MP4MuxerJNI.initH264EncoderLock(this.fYV, this.fYW, this.fZe.fps, this.fZe.videoBitrate, this.fZe.fzW, 8, this.fZe.fzV, 23.0F, 0, 51);
        this.fYZ = new h.b(this, (byte)0);
        this.fZa = com.tencent.mm.sdk.g.d.h(this.fYZ, "MediaCodecFFMpegTranscoder_Encoder");
        this.fZa.start();
        ab.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.fYP) });
      }
      label529:
      if ((!this.fYP) && (this.fZd != null))
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = fZk;
        localObject2 = b.fYm.f(Integer.valueOf(paramArrayOfByte.length));
        if (localObject2 != null) {
          System.arraycopy(paramArrayOfByte, 0, localObject2, 0, paramArrayOfByte.length);
        }
        ((Message)localObject1).obj = localObject2;
        if (!paramBoolean) {
          break label1227;
        }
      }
    }
    label707:
    label965:
    label1227:
    for (i = 1;; i = 0) {
      for (;;)
      {
        ((Message)localObject1).arg1 = i;
        ((Message)localObject1).arg2 = ((int)paramLong);
        this.fZd.sendMessage((Message)localObject1);
        AppMethodBeat.o(50955);
        return;
        label628:
        this.fYV = ((Point)localObject1).x;
        this.fYW = ((Point)localObject1).y;
        break;
        boolean bool;
        if ((this.fYY <= 0) || (this.fYX <= 0))
        {
          localObject2 = v(this.fYR, this.fYS, this.fYT, this.fYU);
          if (localObject2 != null)
          {
            this.fYX = ((Point)localObject2).x;
            this.fYY = ((Point)localObject2).y;
            ab.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[] { Integer.valueOf(this.fYX), Integer.valueOf(this.fYY), Integer.valueOf(this.fYR), Integer.valueOf(this.fYS) });
          }
        }
        else
        {
          if (this.fZj == null) {
            break label307;
          }
          k = this.fZj.getInteger("width");
          m = this.fZj.getInteger("height");
          if (this.fYV > 0)
          {
            i = k;
            j = m;
            if (this.fYW > 0) {
              break label307;
            }
          }
          bool = false;
          localObject2 = v(k, m, this.fYT, this.fYU);
          if (localObject2 == null) {
            break label965;
          }
          this.fYV = ((Point)localObject2).x;
          this.fYW = ((Point)localObject2).y;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            this.fYX = this.fYV;
            this.fYY = this.fYW;
          }
          ab.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[] { Integer.valueOf(this.fYV), Integer.valueOf(this.fYW), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          i = k;
          j = m;
          break;
          this.fYX = this.fYR;
          this.fYY = this.fYS;
          break label707;
          if ((Math.abs(m - ((Point)localObject1).y) > 0) && (k == ((Point)localObject1).x))
          {
            this.fYV = k;
            this.fYW = m;
          }
          else
          {
            this.fYV = ((Point)localObject1).x;
            this.fYW = ((Point)localObject1).y;
          }
        }
        if (this.fZb != null) {
          break label529;
        }
        this.fZb = new c(this.fYV, this.fYW, this.fZe.videoBitrate, this.fZe.fps);
        this.fZb.fYo = new h.1(this);
        try
        {
          ab.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", new Object[] { Integer.valueOf(this.fZb.mn(this.eRm)) });
          localObject1 = this.fZb;
          ab.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
          ((c)localObject1).isStart = true;
          if (this.fZc == null)
          {
            this.fZc = com.tencent.mm.sdk.g.d.ey("remuxer_encode", -2);
            this.fZc.start();
            this.fZd = new h.a(this, this.fZc.getLooper());
          }
          ab.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", new Object[] { Boolean.valueOf(this.fYP) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.VideoTranscoder", localException, "init mediaCodecEncoder error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
    }
  }
  
  public final void cI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50951);
    ab.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fYT = paramInt1;
    this.fYU = paramInt2;
    AppMethodBeat.o(50951);
  }
  
  public final void release()
  {
    AppMethodBeat.i(50954);
    ab.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", new Object[] { Integer.valueOf(fZi) });
    try
    {
      if (this.fZh != null) {
        this.fZh.stop();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.VideoTranscoder", "release error: %s", new Object[] { localException.getMessage() });
      return;
    }
    finally
    {
      MP4MuxerJNI.releaseDataBufLock(0);
      fZi = -1;
      AppMethodBeat.o(50954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bj.h
 * JD-Core Version:    0.7.0.1
 */