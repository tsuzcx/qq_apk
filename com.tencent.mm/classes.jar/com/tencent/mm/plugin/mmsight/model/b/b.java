package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int auC;
  private MediaExtractor eIP;
  private int eIz;
  private Point eJJ = null;
  private String filePath;
  private int jlu = -1;
  private a mkE;
  private f mkF;
  private String mkG;
  private int mkH;
  private int mkI;
  private int mkJ;
  private int mkK;
  private int mkL;
  private int mkM;
  private long mkN = -1L;
  private long mkO = -1L;
  private int mkP = -1;
  private int mkQ;
  private HandlerThread mkR;
  private b.a mkS;
  private Bitmap mkT;
  private byte[] mkU = null;
  private byte[] mkV = null;
  private int videoFps;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      return;
    }
    this.filePath = paramString1;
    this.mkG = paramString2;
    this.mkJ = paramInt1;
    this.mkK = paramInt2;
    this.mkL = paramInt3;
    this.mkP = paramInt4;
    this.mkM = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.MH(paramString1);
    if (locala != null)
    {
      this.mkH = locala.width;
      this.mkI = locala.height;
      this.jlu = locala.jlu;
      this.videoFps = locala.eIM;
    }
    this.mkN = 0L;
    this.mkO = this.jlu;
    y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.mkH), Integer.valueOf(this.mkI), Integer.valueOf(this.mkM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      return;
    }
    this.filePath = paramString1;
    this.mkG = paramString2;
    this.mkJ = paramInt1;
    this.mkK = paramInt2;
    this.mkL = paramInt3;
    this.mkP = paramInt4;
    this.mkM = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.d.MH(paramString1);
    if (locala != null)
    {
      this.mkH = locala.width;
      this.mkI = locala.height;
      this.videoFps = locala.eIM;
    }
    this.mkN = paramLong1;
    this.mkO = paramLong2;
    y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.mkH), Integer.valueOf(this.mkI), Integer.valueOf(this.mkM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public final void B(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.mkT = paramBitmap;
    }
  }
  
  public final int biD()
  {
    j = Math.round(this.jlu / 1000.0F);
    i = j;
    if (this.mkN >= 0L)
    {
      i = j;
      if (this.mkO >= 0L) {
        i = Math.round((float)(this.mkO - this.mkN) / 1000.0F) + 1;
      }
    }
    this.eIz = MP4MuxerJNI.initDataBuf(i);
    if (com.tencent.mm.bi.e.om(this.filePath))
    {
      y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
      this.mkE = new e();
      if (this.jlu <= 0) {
        break label165;
      }
    }
    for (i = this.mkE.e(this.filePath, 0L, this.jlu, this.videoFps);; i = this.mkE.e(this.filePath, this.mkN, this.mkO, this.videoFps))
    {
      y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        break label262;
      }
      MP4MuxerJNI.releaseDataBuf(this.eIz);
      return -1;
      this.mkE = new d();
      break;
      label165:
      if ((this.mkN < 0L) || (this.mkO < 0L)) {
        break label212;
      }
    }
    label212:
    y.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[] { Integer.valueOf(this.jlu), Long.valueOf(this.mkN), Long.valueOf(this.mkO) });
    MP4MuxerJNI.releaseDataBuf(this.eIz);
    return -1;
    label262:
    if ((this.mkP > 0) && (this.mkP < this.videoFps)) {
      this.mkE.ju((int)Math.ceil(this.videoFps / this.mkP));
    }
    if (this.mkP > 0) {}
    for (i = Math.min(this.mkP, this.videoFps);; i = this.videoFps)
    {
      this.mkF = new f(this.mkH, this.mkI, this.mkJ, this.mkK, this.mkL, i);
      this.mkE.a(new b.1(this));
      this.mkF.mle = new f.a()
      {
        public final void a(int paramAnonymousInt1, ByteBuffer paramAnonymousByteBuffer, int paramAnonymousInt2)
        {
          MP4MuxerJNI.writeH264Data(paramAnonymousInt1, paramAnonymousByteBuffer, paramAnonymousInt2);
        }
      };
      try
      {
        this.mkF.jv(this.eIz);
        localObject1 = this.mkF;
        y.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
        ((f)localObject1).bSr = true;
        this.mkE.bjJ();
        this.mkR.quitSafely();
        this.mkR.join();
        this.mkS = null;
        this.eIP = new MediaExtractor();
      }
      catch (Exception localException)
      {
        Object localObject1;
        label477:
        label606:
        long l;
        label519:
        y.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localException, "decode error: %s", new Object[] { localException.getMessage() });
        return -1;
      }
      try
      {
        this.eIP.setDataSource(this.filePath);
        localObject1 = null;
        i = 0;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", localIOException, "muxAudio create extractor failed: %s", new Object[] { localIOException.getMessage() });
        break label665;
        if (this.eIP.getSampleTime() >= this.mkO * 1000L) {
          break label665;
        }
        if (this.eIP.getSampleTrackIndex() == i) {
          break label927;
        }
        y.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
        break label665;
        localIOException.position(0);
        MP4MuxerJNI.writeAACData(this.eIz, localIOException, j);
        this.eIP.advance();
        break label606;
        break label727;
        localObject2 = null;
        i = -1;
        break label519;
        i += 1;
        break label477;
      }
      if (i >= this.eIP.getTrackCount()) {
        break label958;
      }
      localObject2 = this.eIP.getTrackFormat(i);
      localObject1 = ((MediaFormat)localObject2).getString("mime");
      if (!((String)localObject1).startsWith("audio/")) {
        break label966;
      }
      if ((i >= 0) && (localObject2 != null) && (!bk.bl((String)localObject1)))
      {
        this.auC = ((MediaFormat)localObject2).getInteger("channel-count");
        this.mkQ = ((MediaFormat)localObject2).getInteger("sample-rate");
        this.eIP.selectTrack(i);
        if (this.mkN > 0L) {
          this.eIP.seekTo(this.mkN * 1000L, 0);
        }
        localObject1 = ByteBuffer.allocateDirect(((MediaFormat)localObject2).getInteger("max-input-size"));
        ((ByteBuffer)localObject1).clear();
        j = this.eIP.readSampleData((ByteBuffer)localObject1, 0);
        y.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[] { Integer.valueOf(j) });
        if (j > 0) {
          break;
        }
        y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(j) });
      }
      label665:
      localObject2 = this.mkG;
      localObject1 = localObject2;
      if (this.mkM > 0) {
        localObject1 = (String)localObject2 + "tempRotate.mp4";
      }
      l = this.jlu;
      if (l > 0L) {
        break label955;
      }
      l = this.mkO - this.mkN;
      label727:
      i = MP4MuxerJNI.muxing(this.eIz, this.mkQ, 1024, 2, this.auC, (String)localObject1, this.mkF.frameCount * 1000.0F / (float)l, null, 0);
      y.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[] { Integer.valueOf(i) });
      if (this.mkM > 0)
      {
        SightVideoJNI.tagRotateVideo((String)localObject1, this.mkG, this.mkM);
        com.tencent.mm.vfs.e.deleteFile((String)localObject1);
      }
      MP4MuxerJNI.releaseDataBuf(this.eIz);
      j.mji.ET();
      return i;
    }
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b
 * JD-Core Version:    0.7.0.1
 */