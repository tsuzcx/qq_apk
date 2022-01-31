package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int awU;
  private MediaExtractor cfO;
  private int eRG;
  private int eRm;
  private int eVA;
  private Bitmap eVZ;
  private int eWJ;
  private int eWK;
  private int eWL;
  private long eWM;
  private long eWN;
  private String eXn;
  private int eXo;
  private int eXp;
  private int eXq;
  private int eXu;
  private Point fZm;
  private String filePath;
  private a oJU;
  private f oJV;
  private HandlerThread oJW;
  private b.a oJX;
  private byte[] oJY;
  private byte[] oJZ;
  private a.a oKa;
  private int videoFps;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76694);
    this.eVA = -1;
    this.eWM = -1L;
    this.eWN = -1L;
    this.eXu = -1;
    this.fZm = null;
    this.oJY = null;
    this.oJZ = null;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(76694);
      return;
    }
    this.filePath = paramString1;
    this.eXn = paramString2;
    this.eXo = paramInt1;
    this.eXp = paramInt2;
    this.eXq = paramInt3;
    this.eXu = paramInt4;
    this.eWL = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo(paramString1);
    if (locala != null)
    {
      this.eWJ = locala.width;
      this.eWK = locala.height;
      this.eVA = locala.eVA;
      this.videoFps = locala.eRw;
    }
    this.eWM = 0L;
    this.eWN = this.eVA;
    ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.eWJ), Integer.valueOf(this.eWK), Integer.valueOf(this.eWL), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(76694);
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(76695);
    this.eVA = -1;
    this.eWM = -1L;
    this.eWN = -1L;
    this.eXu = -1;
    this.fZm = null;
    this.oJY = null;
    this.oJZ = null;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(76695);
      return;
    }
    this.filePath = paramString1;
    this.eXn = paramString2;
    this.eXo = paramInt1;
    this.eXp = paramInt2;
    this.eXq = paramInt3;
    this.eXu = paramInt4;
    this.eWL = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.Zo(paramString1);
    if (locala != null)
    {
      this.eWJ = locala.width;
      this.eWK = locala.height;
      this.videoFps = locala.eRw;
    }
    this.eWM = paramLong1;
    this.eWN = paramLong2;
    ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.eWJ), Integer.valueOf(this.eWK), Integer.valueOf(this.eWL), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(76695);
  }
  
  public final int Va()
  {
    AppMethodBeat.i(76696);
    int j = Math.round(this.eVA / 1000.0F);
    int i = j;
    if (this.eWM >= 0L)
    {
      i = j;
      if (this.eWN >= 0L) {
        i = Math.round((float)(this.eWN - this.eWM) / 1000.0F) + 1;
      }
    }
    this.eRm = MP4MuxerJNI.initDataBufLock(i);
    if (com.tencent.mm.bj.e.vB(this.filePath))
    {
      ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.oJU = new e();
      if (this.eVA <= 0) {
        break label175;
      }
    }
    for (i = this.oJU.e(this.filePath, 0L, this.eVA, this.videoFps);; i = this.oJU.e(this.filePath, this.eWM, this.eWN, this.videoFps))
    {
      ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label277;
      }
      MP4MuxerJNI.releaseDataBufLock(this.eRm);
      AppMethodBeat.o(76696);
      return -1;
      this.oJU = new d();
      break;
      label175:
      if ((this.eWM < 0L) || (this.eWN < 0L)) {
        break label222;
      }
    }
    label222:
    ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.eVA), Long.valueOf(this.eWM), Long.valueOf(this.eWN) });
    MP4MuxerJNI.releaseDataBufLock(this.eRm);
    AppMethodBeat.o(76696);
    return -1;
    label277:
    if ((this.eXu > 0) && (this.eXu < this.videoFps)) {
      this.oJU.mm((int)Math.ceil(this.videoFps / this.eXu));
    }
    if (this.eXu > 0)
    {
      i = Math.min(this.eXu, this.videoFps);
      this.oJV = new f(this.eWJ, this.eWK, this.eXo, this.eXp, this.eXq, i);
      this.oJU.a(new b.1(this));
      this.oJV.oKl = new f.a()
      {
        public final void a(int paramAnonymousInt1, ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt2)
        {
          AppMethodBeat.i(76692);
          MP4MuxerJNI.writeH264DataLock(paramAnonymousInt1, paramAnonymousByteBuffer, paramAnonymousInt2);
          AppMethodBeat.o(76692);
        }
      };
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        this.oJV.mn(this.eRm);
        Object localObject1 = this.oJV;
        ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).isStart = true;
        this.oJU.bRx();
        this.oJW.quitSafely();
        this.oJW.join();
        this.oJX = null;
        this.cfO = new MediaExtractor();
        try
        {
          this.cfO.setDataSource(this.filePath);
          localObject1 = null;
          i = 0;
          if (i >= this.cfO.getTrackCount()) {
            break label991;
          }
          localObject2 = this.cfO.getTrackFormat(i);
          localObject1 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject1).startsWith("audio/")) {
            break label912;
          }
          if ((i >= 0) && (localObject2 != null) && (!bo.isNullOrNil((String)localObject1)))
          {
            this.awU = ((MediaFormat)localObject2).getInteger("channel-count");
            this.eRG = ((MediaFormat)localObject2).getInteger("sample-rate");
            this.cfO.selectTrack(i);
            if (this.eWM > 0L) {
              this.cfO.seekTo(this.eWM * 1000L, 0);
            }
            localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
            ((ByteBuffer)localObject1).clear();
            j = this.cfO.readSampleData((ByteBuffer)localObject1, 0);
            ab.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[] { Integer.valueOf(j) });
            if (j > 0) {
              break label919;
            }
            ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(j) });
          }
        }
        catch (IOException localIOException)
        {
          long l;
          ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localIOException, "muxAudio create extractor failed: %s", new Object[] { localIOException.getMessage() });
          continue;
        }
        localObject2 = this.eXn;
        localObject1 = localObject2;
        if (this.eWL > 0) {
          localObject1 = (String)localObject2 + "tempRotate.mp4";
        }
        l = this.eVA;
        if (l > 0L) {
          break label988;
        }
        l = this.eWN - this.eWM;
        i = MP4MuxerJNI.muxingLock(this.eRm, this.eRG, 1024, 2, this.awU, (String)localObject1, this.oJV.frameCount * 1000.0F / (float)l, null, 0);
        ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
        if (this.eWL > 0)
        {
          SightVideoJNI.tagRotateVideo((String)localObject1, this.eXn, this.eWL);
          com.tencent.mm.vfs.e.deleteFile((String)localObject1);
        }
        MP4MuxerJNI.releaseDataBufLock(this.eRm);
        j.oJp.XJ();
        AppMethodBeat.o(76696);
        return i;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localException, "decode error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(76696);
        return -1;
      }
      i = this.videoFps;
      break;
      label912:
      i += 1;
      continue;
      label919:
      if (this.cfO.getSampleTime() < this.eWN * 1000L) {
        if (this.cfO.getSampleTrackIndex() != i)
        {
          ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        }
        else
        {
          localException.position(0);
          MP4MuxerJNI.writeAACDataLock(this.eRm, localException, j);
          this.cfO.advance();
          continue;
          label988:
          continue;
          label991:
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
  
  public final void p(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.eVZ = paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */