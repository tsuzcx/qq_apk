package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int bufId;
  private int channelCount;
  private c deA;
  private String filePath;
  private int hlh;
  private Bitmap hnN;
  private long hnV;
  private int how;
  private int hox;
  private int hoy;
  private int hpb;
  private int hpf;
  private Point iyP;
  private String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  private a wcN;
  private f wcO;
  private HandlerThread wcP;
  private a wcQ;
  private byte[] wcR;
  private byte[] wcS;
  private a.a wcT;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89609);
    this.videoDuration = -1;
    this.hnV = -1L;
    this.remuxEndTime = -1L;
    this.hpf = -1;
    this.iyP = null;
    this.wcR = null;
    this.wcS = null;
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ae.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89609);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.hpb = paramInt3;
    this.hpf = paramInt4;
    this.hoy = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ayN(paramString1);
    if (locala != null)
    {
      this.how = locala.width;
      this.hox = locala.height;
      this.videoDuration = locala.videoDuration;
      this.videoFps = locala.frameRate;
    }
    this.hnV = 0L;
    this.remuxEndTime = this.videoDuration;
    ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.how), Integer.valueOf(this.hox), Integer.valueOf(this.hoy), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89609);
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(89610);
    this.videoDuration = -1;
    this.hnV = -1L;
    this.remuxEndTime = -1L;
    this.hpf = -1;
    this.iyP = null;
    this.wcR = null;
    this.wcS = null;
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ae.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89610);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.hpb = paramInt3;
    this.hpf = paramInt4;
    this.hoy = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.ayN(paramString1);
    if (locala != null)
    {
      this.how = locala.width;
      this.hox = locala.height;
      this.videoFps = locala.frameRate;
    }
    this.hnV = paramLong1;
    this.remuxEndTime = paramLong2;
    ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.how), Integer.valueOf(this.hox), Integer.valueOf(this.hoy), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89610);
  }
  
  public final int aue()
  {
    AppMethodBeat.i(89611);
    int j = Math.round(this.videoDuration / 1000.0F);
    int i = j;
    if (this.hnV >= 0L)
    {
      i = j;
      if (this.remuxEndTime >= 0L) {
        i = Math.round((float)(this.remuxEndTime - this.hnV) / 1000.0F) + 1;
      }
    }
    this.bufId = MP4MuxerJNI.initDataBufLock(i);
    if (com.tencent.mm.bk.e.Ik(this.filePath))
    {
      ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.wcN = new e();
      if (this.videoDuration <= 0) {
        break label175;
      }
    }
    for (i = this.wcN.e(this.filePath, 0L, this.videoDuration, this.videoFps);; i = this.wcN.e(this.filePath, this.hnV, this.remuxEndTime, this.videoFps))
    {
      ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label277;
      }
      MP4MuxerJNI.releaseDataBufLock(this.bufId);
      AppMethodBeat.o(89611);
      return -1;
      this.wcN = new d();
      break;
      label175:
      if ((this.hnV < 0L) || (this.remuxEndTime < 0L)) {
        break label222;
      }
    }
    label222:
    ae.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.videoDuration), Long.valueOf(this.hnV), Long.valueOf(this.remuxEndTime) });
    MP4MuxerJNI.releaseDataBufLock(this.bufId);
    AppMethodBeat.o(89611);
    return -1;
    label277:
    if ((this.hpf > 0) && (this.hpf < this.videoFps)) {
      this.wcN.qp((int)Math.ceil(this.videoFps / this.hpf));
    }
    if (this.hpf > 0)
    {
      i = Math.min(this.hpf, this.videoFps);
      this.wcO = new f(this.how, this.hox, this.outputWidth, this.outputHeight, this.hpb, i);
      this.wcN.a(new h()
      {
        public final void a(byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(89606);
          if (b.a(b.this) == null)
          {
            b.a(b.this, com.tencent.e.c.d.hh("remuxer_encode", -2));
            b.a(b.this).start();
            b.a(b.this, new b.a(b.this, b.a(b.this).getLooper()));
          }
          Message localMessage;
          byte[] arrayOfByte;
          if (b.b(b.this) != null)
          {
            localMessage = Message.obtain();
            localMessage.what = 1;
            if (paramAnonymousArrayOfByte == null) {
              break label170;
            }
            arrayOfByte = k.wcg.h(Integer.valueOf(paramAnonymousArrayOfByte.length));
            if (arrayOfByte != null) {
              System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
            }
            localMessage.obj = arrayOfByte;
            if (!paramAnonymousBoolean) {
              break label176;
            }
          }
          for (;;)
          {
            localMessage.arg1 = i;
            localMessage.arg2 = ((int)paramAnonymousLong);
            b.b(b.this).sendMessage(localMessage);
            AppMethodBeat.o(89606);
            return;
            label170:
            arrayOfByte = null;
            break;
            label176:
            i = 0;
          }
        }
      });
      this.wcO.wde = new f.a()
      {
        public final void a(int paramAnonymousInt1, ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt2)
        {
          AppMethodBeat.i(89607);
          MP4MuxerJNI.writeH264DataLock(paramAnonymousInt1, paramAnonymousByteBuffer, paramAnonymousInt2);
          AppMethodBeat.o(89607);
        }
      };
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        this.wcO.qq(this.bufId);
        Object localObject1 = this.wcO;
        ae.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).isStart = true;
        this.wcN.dqw();
        this.wcP.quitSafely();
        this.wcP.join();
        this.wcQ = null;
        this.deA = new c();
        try
        {
          this.deA.vT(this.filePath);
          localObject1 = null;
          i = 0;
          if (i >= this.deA.gga.getTrackCount()) {
            break label1003;
          }
          localObject2 = this.deA.getTrackFormat(i);
          localObject1 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject1).startsWith("audio/")) {
            break label915;
          }
          if ((i >= 0) && (localObject2 != null) && (!bu.isNullOrNil((String)localObject1)))
          {
            this.channelCount = ((MediaFormat)localObject2).getInteger("channel-count");
            this.hlh = ((MediaFormat)localObject2).getInteger("sample-rate");
            this.deA.selectTrack(i);
            if (this.hnV > 0L) {
              this.deA.seekTo(this.hnV * 1000L, 0);
            }
            localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
            ((ByteBuffer)localObject1).clear();
            j = this.deA.readSampleData((ByteBuffer)localObject1, 0);
            ae.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[] { Integer.valueOf(j) });
            if (j > 0) {
              break label922;
            }
            ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(j) });
          }
        }
        catch (IOException localIOException)
        {
          long l;
          ae.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localIOException, "muxAudio create extractor failed: %s", new Object[] { localIOException.getMessage() });
          continue;
        }
        localObject2 = this.outputFilePath;
        localObject1 = localObject2;
        if (this.hoy > 0) {
          localObject1 = (String)localObject2 + "tempRotate.mp4";
        }
        l = this.videoDuration;
        if (l > 0L) {
          break label1000;
        }
        l = this.remuxEndTime - this.hnV;
        i = MP4MuxerJNI.muxingLock(this.bufId, this.hlh, 1024, 2, this.channelCount, (String)localObject1, this.wcO.frameCount * 1000.0F / (float)l, null, 0);
        ae.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
        if (this.hoy > 0)
        {
          SightVideoJNI.tagRotateVideoVFS((String)localObject1, this.outputFilePath, this.hoy);
          o.deleteFile((String)localObject1);
        }
        MP4MuxerJNI.releaseDataBufLock(this.bufId);
        k.wcg.ayL();
        AppMethodBeat.o(89611);
        return i;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localException, "decode error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89611);
        return -1;
      }
      i = this.videoFps;
      break;
      label915:
      i += 1;
      continue;
      label922:
      if (this.deA.gga.getSampleTime() < this.remuxEndTime * 1000L) {
        if (this.deA.gga.getSampleTrackIndex() != i)
        {
          ae.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        }
        else
        {
          localException.position(0);
          MP4MuxerJNI.writeAACDataLock(this.bufId, localException, j);
          this.deA.gga.advance();
          continue;
          label1000:
          continue;
          label1003:
          localObject2 = null;
          i = -1;
        }
      }
    }
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void z(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.hnN = paramBitmap;
    }
  }
  
  final class a
    extends aq
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(89608);
      byte[] arrayOfByte;
      int i;
      long l;
      int j;
      label286:
      int k;
      boolean bool;
      if (paramMessage.what == 1)
      {
        arrayOfByte = (byte[])paramMessage.obj;
        if (paramMessage.arg1 != 1) {
          break label643;
        }
        i = 1;
        l = paramMessage.arg2;
        if (b.c(b.this) != null)
        {
          if (b.d(b.this) == null) {
            b.a(b.this, b.e(b.this).aNF());
          }
          if (b.f(b.this) != null)
          {
            paramMessage = b.f(b.this).dpD();
            if (paramMessage != null)
            {
              j = paramMessage.getRowBytes() * paramMessage.getHeight();
              ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(j);
              localByteBuffer.position(0);
              paramMessage.copyPixelsToBuffer(localByteBuffer);
              localByteBuffer.position(0);
              if (b.g(b.this) == null) {
                b.a(b.this, new byte[j]);
              }
              localByteBuffer.get(b.g(b.this));
              SightVideoJNI.blendYuvFrame(arrayOfByte, b.g(b.this), b.d(b.this).x, b.d(b.this).y);
            }
          }
          if (b.h(b.this) != null)
          {
            if (b.g(b.this) == null)
            {
              if ((b.i(b.this) != 90) && (b.i(b.this) != 270)) {
                break label648;
              }
              b.a(b.this, com.tencent.mm.sdk.platformtools.h.a(b.h(b.this), 360 - b.i(b.this)));
              b.a(b.this, Bitmap.createScaledBitmap(b.h(b.this), b.d(b.this).x, b.d(b.this).y, true));
              paramMessage = ByteBuffer.allocateDirect(b.h(b.this).getRowBytes() * b.h(b.this).getHeight());
              paramMessage.position(0);
              b.h(b.this).copyPixelsToBuffer(paramMessage);
              paramMessage.position(0);
              b.a(b.this, new byte[paramMessage.remaining()]);
              paramMessage.get(b.g(b.this));
            }
            SightVideoJNI.blendYuvFrame(arrayOfByte, b.g(b.this), b.d(b.this).x, b.d(b.this).y);
          }
          paramMessage = b.c(b.this);
          j = b.d(b.this).x;
          k = b.d(b.this).y;
          if ((i != 0) || (arrayOfByte == null)) {
            break label721;
          }
          if ((j != paramMessage.targetWidth) || (k != paramMessage.targetHeight)) {
            break label684;
          }
          bool = false;
          label491:
          ae.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMessage.targetWidth), Integer.valueOf(paramMessage.targetHeight), Long.valueOf(l) });
          if (paramMessage.ixX == null) {
            paramMessage.ixX = new byte[paramMessage.targetWidth * paramMessage.targetHeight * 3 >> 1];
          }
          if ((paramMessage.hkE != 19) || (bool)) {
            break label690;
          }
          System.arraycopy(arrayOfByte, 0, paramMessage.ixX, 0, arrayOfByte.length);
          label608:
          paramMessage.ixT += 1;
          paramMessage.b(paramMessage.ixX, false, l);
        }
      }
      for (;;)
      {
        k.wcg.k(arrayOfByte);
        AppMethodBeat.o(89608);
        return;
        label643:
        i = 0;
        break;
        label648:
        if (b.i(b.this) != 180) {
          break label286;
        }
        b.a(b.this, com.tencent.mm.sdk.platformtools.h.a(b.h(b.this), 180.0F));
        break label286;
        label684:
        bool = true;
        break label491;
        label690:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(arrayOfByte, 2, paramMessage.ixX, paramMessage.ixY, j, k, j, k, paramMessage.targetWidth, paramMessage.targetHeight);
        break label608;
        label721:
        paramMessage.b(paramMessage.ixX, true, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */