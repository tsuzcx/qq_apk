package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int bufId;
  private int channelCount;
  private String filePath;
  private int iee;
  private int ihQ;
  private int ihR;
  private int ihS;
  private Bitmap ihg;
  private long iho;
  private int iiB;
  private int iix;
  private c jto;
  private Point jud;
  private String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  private a zwO;
  private f zwP;
  private HandlerThread zwQ;
  private a zwR;
  private byte[] zwS;
  private byte[] zwT;
  private a.a zwU;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89609);
    this.videoDuration = -1;
    this.iho = -1L;
    this.remuxEndTime = -1L;
    this.iiB = -1;
    this.jud = null;
    this.zwS = null;
    this.zwT = null;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89609);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.iix = paramInt3;
    this.iiB = paramInt4;
    this.ihS = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.aNx(paramString1);
    if (locala != null)
    {
      this.ihQ = locala.width;
      this.ihR = locala.height;
      this.videoDuration = locala.videoDuration;
      this.videoFps = locala.frameRate;
    }
    this.iho = 0L;
    this.remuxEndTime = this.videoDuration;
    Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89609);
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(89610);
    this.videoDuration = -1;
    this.iho = -1L;
    this.remuxEndTime = -1L;
    this.iiB = -1;
    this.jud = null;
    this.zwS = null;
    this.zwT = null;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89610);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.iix = paramInt3;
    this.iiB = paramInt4;
    this.ihS = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.aNx(paramString1);
    if (locala != null)
    {
      this.ihQ = locala.width;
      this.ihR = locala.height;
      this.videoFps = locala.frameRate;
    }
    this.iho = paramLong1;
    this.remuxEndTime = paramLong2;
    Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89610);
  }
  
  public final void D(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.ihg = paramBitmap;
    }
  }
  
  public final int aMG()
  {
    AppMethodBeat.i(89611);
    int j = Math.round(this.videoDuration / 1000.0F);
    int i = j;
    if (this.iho >= 0L)
    {
      i = j;
      if (this.remuxEndTime >= 0L) {
        i = Math.round((float)(this.remuxEndTime - this.iho) / 1000.0F) + 1;
      }
    }
    this.bufId = MP4MuxerJNI.initDataBufLock(i);
    if (com.tencent.mm.bk.e.QW(this.filePath))
    {
      Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.zwO = new e();
      if (this.videoDuration <= 0) {
        break label175;
      }
    }
    for (i = this.zwO.e(this.filePath, 0L, this.videoDuration, this.videoFps);; i = this.zwO.e(this.filePath, this.iho, this.remuxEndTime, this.videoFps))
    {
      Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label277;
      }
      MP4MuxerJNI.releaseDataBufLock(this.bufId);
      AppMethodBeat.o(89611);
      return -1;
      this.zwO = new d();
      break;
      label175:
      if ((this.iho < 0L) || (this.remuxEndTime < 0L)) {
        break label222;
      }
    }
    label222:
    Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.videoDuration), Long.valueOf(this.iho), Long.valueOf(this.remuxEndTime) });
    MP4MuxerJNI.releaseDataBufLock(this.bufId);
    AppMethodBeat.o(89611);
    return -1;
    label277:
    if ((this.iiB > 0) && (this.iiB < this.videoFps)) {
      this.zwO.uf((int)Math.ceil(this.videoFps / this.iiB));
    }
    if (this.iiB > 0)
    {
      i = Math.min(this.iiB, this.videoFps);
      this.zwP = new f(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, this.iix, i);
      this.zwO.a(new h()
      {
        public final void a(byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(89606);
          if (b.a(b.this) == null)
          {
            b.a(b.this, com.tencent.f.c.d.hB("remuxer_encode", -2));
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
            arrayOfByte = k.zwi.h(Integer.valueOf(paramAnonymousArrayOfByte.length));
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
      this.zwP.zxf = new f.a()
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
        this.zwP.ug(this.bufId);
        Object localObject1 = this.zwP;
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).isStart = true;
        this.zwO.ekm();
        this.zwQ.quitSafely();
        this.zwQ.join();
        this.zwR = null;
        this.jto = new c();
        try
        {
          this.jto.setDataSource(this.filePath);
          localObject1 = null;
          i = 0;
          if (i >= this.jto.gLF.getTrackCount()) {
            break label1003;
          }
          localObject2 = this.jto.getTrackFormat(i);
          localObject1 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject1).startsWith("audio/")) {
            break label915;
          }
          if ((i >= 0) && (localObject2 != null) && (!Util.isNullOrNil((String)localObject1)))
          {
            this.channelCount = ((MediaFormat)localObject2).getInteger("channel-count");
            this.iee = ((MediaFormat)localObject2).getInteger("sample-rate");
            this.jto.selectTrack(i);
            if (this.iho > 0L) {
              this.jto.seekTo(this.iho * 1000L, 0);
            }
            localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
            ((ByteBuffer)localObject1).clear();
            j = this.jto.readSampleData((ByteBuffer)localObject1, 0);
            Log.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[] { Integer.valueOf(j) });
            if (j > 0) {
              break label922;
            }
            Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(j) });
          }
        }
        catch (IOException localIOException)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localIOException, "muxAudio create extractor failed: %s", new Object[] { localIOException.getMessage() });
          continue;
        }
        localObject2 = this.outputFilePath;
        localObject1 = localObject2;
        if (this.ihS > 0) {
          localObject1 = (String)localObject2 + "tempRotate.mp4";
        }
        l = this.videoDuration;
        if (l > 0L) {
          break label1000;
        }
        l = this.remuxEndTime - this.iho;
        i = MP4MuxerJNI.muxingLock(this.bufId, this.iee, 1024, 2, this.channelCount, (String)localObject1, this.zwP.frameCount * 1000.0F / (float)l, null, 0);
        Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
        if (this.ihS > 0)
        {
          SightVideoJNI.tagRotateVideoVFS((String)localObject1, this.outputFilePath, this.ihS);
          s.deleteFile((String)localObject1);
        }
        MP4MuxerJNI.releaseDataBufLock(this.bufId);
        k.zwi.aRR();
        AppMethodBeat.o(89611);
        return i;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localException, "decode error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89611);
        return -1;
      }
      i = this.videoFps;
      break;
      label915:
      i += 1;
      continue;
      label922:
      if (this.jto.gLF.getSampleTime() < this.remuxEndTime * 1000L) {
        if (this.jto.gLF.getSampleTrackIndex() != i)
        {
          Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        }
        else
        {
          localException.position(0);
          MP4MuxerJNI.writeAACDataLock(this.bufId, localException, j);
          this.jto.gLF.advance();
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
  
  final class a
    extends MMHandler
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
            b.a(b.this, b.e(b.this).bhJ());
          }
          if (b.f(b.this) != null)
          {
            paramMessage = b.f(b.this).ejs();
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
              b.a(b.this, BitmapUtil.rotate(b.h(b.this), 360 - b.i(b.this)));
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
          Log.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMessage.targetWidth), Integer.valueOf(paramMessage.targetHeight), Long.valueOf(l) });
          if (paramMessage.jtm == null) {
            paramMessage.jtm = new byte[paramMessage.targetWidth * paramMessage.targetHeight * 3 >> 1];
          }
          if ((paramMessage.colorFormat != 19) || (bool)) {
            break label690;
          }
          System.arraycopy(arrayOfByte, 0, paramMessage.jtm, 0, arrayOfByte.length);
          label608:
          paramMessage.jti += 1;
          paramMessage.b(paramMessage.jtm, false, l);
        }
      }
      for (;;)
      {
        k.zwi.k(arrayOfByte);
        AppMethodBeat.o(89608);
        return;
        label643:
        i = 0;
        break;
        label648:
        if (b.i(b.this) != 180) {
          break label286;
        }
        b.a(b.this, BitmapUtil.rotate(b.h(b.this), 180.0F));
        break label286;
        label684:
        bool = true;
        break label491;
        label690:
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(arrayOfByte, 2, paramMessage.jtm, paramMessage.jtn, j, k, j, k, paramMessage.targetWidth, paramMessage.targetHeight);
        break label608;
        label721:
        paramMessage.b(paramMessage.jtm, true, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */