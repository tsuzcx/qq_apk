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
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private c cSi;
  private int channelCount;
  private String filePath;
  private int gNJ;
  private int gOu;
  private Bitmap gSY;
  private int gTG;
  private int gTH;
  private int gTI;
  private long gTJ;
  private int gUm;
  private int gUq;
  private int grA;
  private int grB;
  private Point icA;
  private String outputFilePath;
  private long remuxEndTime;
  private a uNA;
  private f uNB;
  private HandlerThread uNC;
  private a uND;
  private byte[] uNE;
  private byte[] uNF;
  private a.a uNG;
  private int videoDuration;
  private int videoFps;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89609);
    this.videoDuration = -1;
    this.gTJ = -1L;
    this.remuxEndTime = -1L;
    this.gUq = -1;
    this.icA = null;
    this.uNE = null;
    this.uNF = null;
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89609);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.grA = paramInt1;
    this.grB = paramInt2;
    this.gUm = paramInt3;
    this.gUq = paramInt4;
    this.gTI = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(paramString1);
    if (locala != null)
    {
      this.gTG = locala.width;
      this.gTH = locala.height;
      this.videoDuration = locala.videoDuration;
      this.videoFps = locala.frameRate;
    }
    this.gTJ = 0L;
    this.remuxEndTime = this.videoDuration;
    ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.gTG), Integer.valueOf(this.gTH), Integer.valueOf(this.gTI), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89609);
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(89610);
    this.videoDuration = -1;
    this.gTJ = -1L;
    this.remuxEndTime = -1L;
    this.gUq = -1;
    this.icA = null;
    this.uNE = null;
    this.uNF = null;
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89610);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.grA = paramInt1;
    this.grB = paramInt2;
    this.gUm = paramInt3;
    this.gUq = paramInt4;
    this.gTI = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(paramString1);
    if (locala != null)
    {
      this.gTG = locala.width;
      this.gTH = locala.height;
      this.videoFps = locala.frameRate;
    }
    this.gTJ = paramLong1;
    this.remuxEndTime = paramLong2;
    ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.gTG), Integer.valueOf(this.gTH), Integer.valueOf(this.gTI), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89610);
  }
  
  public final int arc()
  {
    AppMethodBeat.i(89611);
    int j = Math.round(this.videoDuration / 1000.0F);
    int i = j;
    if (this.gTJ >= 0L)
    {
      i = j;
      if (this.remuxEndTime >= 0L) {
        i = Math.round((float)(this.remuxEndTime - this.gTJ) / 1000.0F) + 1;
      }
    }
    this.gNJ = MP4MuxerJNI.initDataBufLock(i);
    if (com.tencent.mm.bk.e.Et(this.filePath))
    {
      ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.uNA = new e();
      if (this.videoDuration <= 0) {
        break label175;
      }
    }
    for (i = this.uNA.e(this.filePath, 0L, this.videoDuration, this.videoFps);; i = this.uNA.e(this.filePath, this.gTJ, this.remuxEndTime, this.videoFps))
    {
      ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label277;
      }
      MP4MuxerJNI.releaseDataBufLock(this.gNJ);
      AppMethodBeat.o(89611);
      return -1;
      this.uNA = new d();
      break;
      label175:
      if ((this.gTJ < 0L) || (this.remuxEndTime < 0L)) {
        break label222;
      }
    }
    label222:
    ac.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.videoDuration), Long.valueOf(this.gTJ), Long.valueOf(this.remuxEndTime) });
    MP4MuxerJNI.releaseDataBufLock(this.gNJ);
    AppMethodBeat.o(89611);
    return -1;
    label277:
    if ((this.gUq > 0) && (this.gUq < this.videoFps)) {
      this.uNA.pK((int)Math.ceil(this.videoFps / this.gUq));
    }
    if (this.gUq > 0)
    {
      i = Math.min(this.gUq, this.videoFps);
      this.uNB = new f(this.gTG, this.gTH, this.grA, this.grB, this.gUm, i);
      this.uNA.a(new h()
      {
        public final void a(byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(89606);
          if (b.a(b.this) == null)
          {
            b.a(b.this, com.tencent.e.c.d.gA("remuxer_encode", -2));
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
            arrayOfByte = j.uMV.g(Integer.valueOf(paramAnonymousArrayOfByte.length));
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
      this.uNB.uNR = new f.a()
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
        this.uNB.pL(this.gNJ);
        Object localObject1 = this.uNB;
        ac.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).isStart = true;
        this.uNA.dea();
        this.uNC.quitSafely();
        this.uNC.join();
        this.uND = null;
        this.cSi = new c();
        try
        {
          this.cSi.sI(this.filePath);
          localObject1 = null;
          i = 0;
          if (i >= this.cSi.fKr.getTrackCount()) {
            break label1002;
          }
          localObject2 = this.cSi.getTrackFormat(i);
          localObject1 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject1).startsWith("audio/")) {
            break label914;
          }
          if ((i >= 0) && (localObject2 != null) && (!bs.isNullOrNil((String)localObject1)))
          {
            this.channelCount = ((MediaFormat)localObject2).getInteger("channel-count");
            this.gOu = ((MediaFormat)localObject2).getInteger("sample-rate");
            this.cSi.selectTrack(i);
            if (this.gTJ > 0L) {
              this.cSi.seekTo(this.gTJ * 1000L, 0);
            }
            localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
            ((ByteBuffer)localObject1).clear();
            j = this.cSi.j((ByteBuffer)localObject1);
            ac.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[] { Integer.valueOf(j) });
            if (j > 0) {
              break label921;
            }
            ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(j) });
          }
        }
        catch (IOException localIOException)
        {
          long l;
          ac.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localIOException, "muxAudio create extractor failed: %s", new Object[] { localIOException.getMessage() });
          continue;
        }
        localObject2 = this.outputFilePath;
        localObject1 = localObject2;
        if (this.gTI > 0) {
          localObject1 = (String)localObject2 + "tempRotate.mp4";
        }
        l = this.videoDuration;
        if (l > 0L) {
          break label999;
        }
        l = this.remuxEndTime - this.gTJ;
        i = MP4MuxerJNI.muxingLock(this.gNJ, this.gOu, 1024, 2, this.channelCount, (String)localObject1, this.uNB.frameCount * 1000.0F / (float)l, null, 0);
        ac.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
        if (this.gTI > 0)
        {
          SightVideoJNI.tagRotateVideoVFS((String)localObject1, this.outputFilePath, this.gTI);
          i.deleteFile((String)localObject1);
        }
        MP4MuxerJNI.releaseDataBufLock(this.gNJ);
        j.uMV.avJ();
        AppMethodBeat.o(89611);
        return i;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localException, "decode error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89611);
        return -1;
      }
      i = this.videoFps;
      break;
      label914:
      i += 1;
      continue;
      label921:
      if (this.cSi.fKr.getSampleTime() < this.remuxEndTime * 1000L) {
        if (this.cSi.fKr.getSampleTrackIndex() != i)
        {
          ac.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        }
        else
        {
          localException.position(0);
          MP4MuxerJNI.writeAACDataLock(this.gNJ, localException, j);
          this.cSi.fKr.advance();
          continue;
          label999:
          continue;
          label1002:
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
  
  public final void y(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.gSY = paramBitmap;
    }
  }
  
  final class a
    extends ao
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
            b.a(b.this, b.e(b.this).aJY());
          }
          if (b.f(b.this) != null)
          {
            paramMessage = b.f(b.this).ddj();
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
              b.a(b.this, com.tencent.mm.sdk.platformtools.f.a(b.h(b.this), 360 - b.i(b.this)));
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
          if ((j != paramMessage.gNU) || (k != paramMessage.gNV)) {
            break label684;
          }
          bool = false;
          label491:
          ac.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMessage.gNU), Integer.valueOf(paramMessage.gNV), Long.valueOf(l) });
          if (paramMessage.ibH == null) {
            paramMessage.ibH = new byte[paramMessage.gNU * paramMessage.gNV * 3 >> 1];
          }
          if ((paramMessage.gNW != 19) || (bool)) {
            break label690;
          }
          System.arraycopy(arrayOfByte, 0, paramMessage.ibH, 0, arrayOfByte.length);
          label608:
          paramMessage.ibD += 1;
          paramMessage.b(paramMessage.ibH, false, l);
        }
      }
      for (;;)
      {
        j.uMV.k(arrayOfByte);
        AppMethodBeat.o(89608);
        return;
        label643:
        i = 0;
        break;
        label648:
        if (b.i(b.this) != 180) {
          break label286;
        }
        b.a(b.this, com.tencent.mm.sdk.platformtools.f.a(b.h(b.this), 180.0F));
        break label286;
        label684:
        bool = true;
        break label491;
        label690:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(arrayOfByte, 2, paramMessage.ibH, paramMessage.ibI, j, k, j, k, paramMessage.gNU, paramMessage.gNV);
        break label608;
        label721:
        paramMessage.b(paramMessage.ibH, true, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */