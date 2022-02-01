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
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private a Fci;
  private f Fcj;
  private HandlerThread Fck;
  private a Fcl;
  private byte[] Fcm;
  private byte[] Fcn;
  private a.a Fco;
  private int bufId;
  private int channelCount;
  private String filePath;
  private int kSP;
  private Bitmap kVU;
  private int kWE;
  private int kWF;
  private int kWG;
  private long kWc;
  private int kXk;
  private int kXo;
  private c miS;
  private Point mjH;
  private String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89609);
    this.videoDuration = -1;
    this.kWc = -1L;
    this.remuxEndTime = -1L;
    this.kXo = -1;
    this.mjH = null;
    this.Fcm = null;
    this.Fcn = null;
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
    this.kXk = paramInt3;
    this.kXo = paramInt4;
    this.kWG = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aYg(paramString1);
    if (localb != null)
    {
      this.kWE = localb.width;
      this.kWF = localb.height;
      this.videoDuration = localb.videoDuration;
      this.videoFps = localb.frameRate;
    }
    this.kWc = 0L;
    this.remuxEndTime = this.videoDuration;
    Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.kWE), Integer.valueOf(this.kWF), Integer.valueOf(this.kWG), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89609);
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(89610);
    this.videoDuration = -1;
    this.kWc = -1L;
    this.remuxEndTime = -1L;
    this.kXo = -1;
    this.mjH = null;
    this.Fcm = null;
    this.Fcn = null;
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
    this.kXk = paramInt3;
    this.kXo = paramInt4;
    this.kWG = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aYg(paramString1);
    if (localb != null)
    {
      this.kWE = localb.width;
      this.kWF = localb.height;
      this.videoFps = localb.frameRate;
    }
    this.kWc = paramLong1;
    this.remuxEndTime = paramLong2;
    Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.kWE), Integer.valueOf(this.kWF), Integer.valueOf(this.kWG), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89610);
  }
  
  public final void A(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.kVU = paramBitmap;
    }
  }
  
  public final int aUW()
  {
    AppMethodBeat.i(89611);
    int j = Math.round(this.videoDuration / 1000.0F);
    int i = j;
    if (this.kWc >= 0L)
    {
      i = j;
      if (this.remuxEndTime >= 0L) {
        i = Math.round((float)(this.remuxEndTime - this.kWc) / 1000.0F) + 1;
      }
    }
    this.bufId = MP4MuxerJNI.initDataBufLock(i);
    if (com.tencent.mm.bm.e.Yt(this.filePath))
    {
      Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.Fci = new e();
      if (this.videoDuration <= 0) {
        break label175;
      }
    }
    for (i = this.Fci.e(this.filePath, 0L, this.videoDuration, this.videoFps);; i = this.Fci.e(this.filePath, this.kWc, this.remuxEndTime, this.videoFps))
    {
      Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label277;
      }
      MP4MuxerJNI.releaseDataBufLock(this.bufId);
      AppMethodBeat.o(89611);
      return -1;
      this.Fci = new d();
      break;
      label175:
      if ((this.kWc < 0L) || (this.remuxEndTime < 0L)) {
        break label222;
      }
    }
    label222:
    Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.videoDuration), Long.valueOf(this.kWc), Long.valueOf(this.remuxEndTime) });
    MP4MuxerJNI.releaseDataBufLock(this.bufId);
    AppMethodBeat.o(89611);
    return -1;
    label277:
    if ((this.kXo > 0) && (this.kXo < this.videoFps)) {
      this.Fci.xe((int)Math.ceil(this.videoFps / this.kXo));
    }
    if (this.kXo > 0)
    {
      i = Math.min(this.kXo, this.videoFps);
      this.Fcj = new f(this.kWE, this.kWF, this.outputWidth, this.outputHeight, this.kXk, i);
      this.Fci.a(new h()
      {
        public final void a(byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(89606);
          if (b.a(b.this) == null)
          {
            b.a(b.this, com.tencent.e.c.d.il("remuxer_encode", -2));
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
            arrayOfByte = j.FbH.k(Integer.valueOf(paramAnonymousArrayOfByte.length));
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
      this.Fcj.Fcz = new f.a()
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
        this.Fcj.xf(this.bufId);
        Object localObject1 = this.Fcj;
        Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).isStart = true;
        this.Fci.eTP();
        this.Fck.quitSafely();
        this.Fck.join();
        this.Fcl = null;
        this.miS = new c();
        try
        {
          this.miS.setDataSource(this.filePath);
          localObject1 = null;
          i = 0;
          if (i >= this.miS.jvU.getTrackCount()) {
            break label1003;
          }
          localObject2 = this.miS.getTrackFormat(i);
          localObject1 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject1).startsWith("audio/")) {
            break label915;
          }
          if ((i >= 0) && (localObject2 != null) && (!Util.isNullOrNil((String)localObject1)))
          {
            this.channelCount = ((MediaFormat)localObject2).getInteger("channel-count");
            this.kSP = ((MediaFormat)localObject2).getInteger("sample-rate");
            this.miS.selectTrack(i);
            if (this.kWc > 0L) {
              this.miS.seekTo(this.kWc * 1000L, 0);
            }
            localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
            ((ByteBuffer)localObject1).clear();
            j = this.miS.readSampleData((ByteBuffer)localObject1, 0);
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
        if (this.kWG > 0) {
          localObject1 = (String)localObject2 + "tempRotate.mp4";
        }
        l = this.videoDuration;
        if (l > 0L) {
          break label1000;
        }
        l = this.remuxEndTime - this.kWc;
        i = MP4MuxerJNI.muxingLock(this.bufId, this.kSP, 1024, 2, this.channelCount, (String)localObject1, this.Fcj.frameCount * 1000.0F / (float)l, null, 0);
        Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
        if (this.kWG > 0)
        {
          SightVideoJNI.tagRotateVideoVFS((String)localObject1, this.outputFilePath, this.kWG);
          u.deleteFile((String)localObject1);
        }
        MP4MuxerJNI.releaseDataBufLock(this.bufId);
        j.FbH.baL();
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
      if (this.miS.jvU.getSampleTime() < this.remuxEndTime * 1000L) {
        if (this.miS.jvU.getSampleTrackIndex() != i)
        {
          Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        }
        else
        {
          localException.position(0);
          MP4MuxerJNI.writeAACDataLock(this.bufId, localException, j);
          this.miS.jvU.advance();
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
            b.a(b.this, b.e(b.this).brg());
          }
          if (b.f(b.this) != null)
          {
            paramMessage = b.f(b.this).eSZ();
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
          if (paramMessage.miQ == null) {
            paramMessage.miQ = new byte[paramMessage.targetWidth * paramMessage.targetHeight * 3 >> 1];
          }
          if ((paramMessage.colorFormat != 19) || (bool)) {
            break label690;
          }
          System.arraycopy(arrayOfByte, 0, paramMessage.miQ, 0, arrayOfByte.length);
          label608:
          paramMessage.miM += 1;
          paramMessage.b(paramMessage.miQ, false, l);
        }
      }
      for (;;)
      {
        j.FbH.as(arrayOfByte);
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
        MP4MuxerJNI.yuv420pTo420XXAndScaleLock(arrayOfByte, 2, paramMessage.miQ, paramMessage.miR, j, k, j, k, paramMessage.targetWidth, paramMessage.targetHeight);
        break label608;
        label721:
        paramMessage.b(paramMessage.miQ, true, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */