package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.n.n;
import java.nio.ByteBuffer;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i
  extends l
{
  final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  com.tencent.mm.compatible.h.c ddy;
  com.tencent.mm.compatible.deviceinfo.z hir;
  private MediaFormat mediaFormat;
  private String mime;
  private final Object pSA;
  final long pSx;
  private final long pSy;
  final int pSz;
  private final Surface surface;
  private final String videoPath;
  
  public i(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(288);
    this.videoPath = paramString;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.ddy = new com.tencent.mm.compatible.h.c();
    this.mime = "";
    this.pSx = 60000L;
    this.pSy = 10000L;
    this.pSz = 10;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.pSA = new Object();
    try
    {
      ad.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.ddy.setDataSource(this.videoPath);
      int j = this.ddy.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = this.ddy.getTrackFormat(i);
        p.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        p.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.e((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          p.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          paramString = this.TAG;
          paramSurface = new StringBuilder("find video format ");
          MediaFormat localMediaFormat = this.mediaFormat;
          if (localMediaFormat == null) {
            p.bcb("mediaFormat");
          }
          ad.i(paramString, localMediaFormat + ", mime: " + this.mime);
          this.ddy.selectTrack(i);
          AppMethodBeat.o(288);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(288);
    }
  }
  
  final boolean atq()
  {
    AppMethodBeat.i(286);
    Object localObject1 = this.hir;
    if (localObject1 == null) {
      p.bcb("decoder");
    }
    int i = ((com.tencent.mm.compatible.deviceinfo.z)localObject1).dequeueOutputBuffer(this.bufferInfo, this.pSy);
    localObject1 = this.hir;
    if (localObject1 == null) {
      p.bcb("decoder");
    }
    localObject1 = ((com.tencent.mm.compatible.deviceinfo.z)localObject1).getOutputBuffers();
    if (i == -1) {
      ad.i(this.TAG, "drainDecoder try again later");
    }
    label73:
    Object localObject4;
    for (;;)
    {
      AppMethodBeat.o(286);
      return false;
      if (i != -2) {
        break;
      }
      localObject1 = this.TAG;
      ??? = new StringBuilder("drainDecoder output format change: ");
      localObject4 = this.hir;
      if (localObject4 == null) {
        p.bcb("decoder");
      }
      ad.i((String)localObject1, ((com.tencent.mm.compatible.deviceinfo.z)localObject4).getOutputFormat());
      localObject1 = this.hir;
      if (localObject1 == null) {
        p.bcb("decoder");
      }
      localObject1 = ((com.tencent.mm.compatible.deviceinfo.z)localObject1).getOutputFormat();
      p.g(localObject1, "decoder.outputFormat");
      this.mediaFormat = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.hir;
      if (??? == null) {
        p.bcb("decoder");
      }
      if (((com.tencent.mm.compatible.deviceinfo.z)???).getOutputBuffers() == null) {
        break label668;
      }
      localObject1 = this.hir;
      if (localObject1 == null) {
        p.bcb("decoder");
      }
      localObject1 = ((com.tencent.mm.compatible.deviceinfo.z)localObject1).getOutputBuffers();
    }
    label668:
    for (;;)
    {
      ??? = this.hir;
      if (??? == null) {
        p.bcb("decoder");
      }
      i = ((com.tencent.mm.compatible.deviceinfo.z)???).dequeueOutputBuffer(this.bufferInfo, this.pSy);
      if (i < 0) {
        break label73;
      }
      break;
      if (i < 0)
      {
        ad.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label73;
      }
      ??? = localObject1[i];
      long l = this.bufferInfo.presentationTimeUs;
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        ad.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.hir;
        if (localObject1 == null) {
          p.bcb("decoder");
        }
        ((com.tencent.mm.compatible.deviceinfo.z)localObject1).releaseOutputBuffer(i, true);
        AppMethodBeat.o(286);
        return true;
      }
      if ((??? != null) && (this.bufferInfo.size != 0))
      {
        ((ByteBuffer)???).position(this.bufferInfo.offset);
        ((ByteBuffer)???).limit(this.bufferInfo.offset + this.bufferInfo.size);
        ??? = this.hir;
        if (??? == null) {
          p.bcb("decoder");
        }
        ((com.tencent.mm.compatible.deviceinfo.z)???).releaseOutputBuffer(i, true);
        ??? = this.bufferInfo;
        ad.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.pSV;
        if (localObject4 != null) {
          ((b)localObject4).invoke(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.pSA)
        {
          try
          {
            this.pSA.wait(50L);
            localObject4 = d.z.MKo;
            if ((this.bufferInfo.flags & 0x4) == 0) {
              break label668;
            }
            try
            {
              localObject1 = this.hir;
              if (localObject1 == null) {
                p.bcb("decoder");
              }
              ((com.tencent.mm.compatible.deviceinfo.z)localObject1).stop();
              localObject1 = this.hir;
              if (localObject1 == null) {
                p.bcb("decoder");
              }
              ((com.tencent.mm.compatible.deviceinfo.z)localObject1).release();
            }
            catch (Exception localException1)
            {
              label600:
              break label600;
            }
            AppMethodBeat.o(286);
            return true;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.hir;
        if (??? == null) {
          p.bcb("decoder");
        }
        ((com.tencent.mm.compatible.deviceinfo.z)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void ckf()
  {
    AppMethodBeat.i(285);
    synchronized (this.pSA)
    {
      try
      {
        this.pSA.notifyAll();
        d.z localz = d.z.MKo;
        AppMethodBeat.o(285);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  final void ckg()
  {
    AppMethodBeat.i(287);
    ad.i(this.TAG, "sendDecoderEos");
    Object localObject = this.hir;
    if (localObject == null) {
      p.bcb("decoder");
    }
    int j = ((com.tencent.mm.compatible.deviceinfo.z)localObject).dequeueInputBuffer(this.pSx);
    int i = 0;
    while ((j < 0) && (i < this.pSz))
    {
      if (!atq())
      {
        AppMethodBeat.o(287);
        return;
      }
      localObject = this.hir;
      if (localObject == null) {
        p.bcb("decoder");
      }
      j = ((com.tencent.mm.compatible.deviceinfo.z)localObject).dequeueInputBuffer(this.pSx);
      i += 1;
    }
    if (j >= 0)
    {
      localObject = this.hir;
      if (localObject == null) {
        p.bcb("decoder");
      }
      localObject = localObject.getInputBuffers()[j];
      ((ByteBuffer)localObject).clear();
      this.ddy.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      localObject = this.hir;
      if (localObject == null) {
        p.bcb("decoder");
      }
      ((com.tencent.mm.compatible.deviceinfo.z)localObject).a(j, 0, 0L, 4);
    }
    atq();
    AppMethodBeat.o(287);
  }
  
  public final int init()
  {
    AppMethodBeat.i(283);
    if ((((i)this).mediaFormat != null) && (!bt.isNullOrNil(this.mime))) {
      try
      {
        com.tencent.mm.compatible.deviceinfo.z localz = com.tencent.mm.compatible.deviceinfo.z.vm(this.mime);
        p.g(localz, "MediaCodecProxy.createDecoderByType(mime)");
        this.hir = localz;
        localz = this.hir;
        if (localz == null) {
          p.bcb("decoder");
        }
        MediaFormat localMediaFormat = this.mediaFormat;
        if (localMediaFormat == null) {
          p.bcb("mediaFormat");
        }
        localz.a(localMediaFormat, this.surface, 0);
        localz = this.hir;
        if (localz == null) {
          p.bcb("decoder");
        }
        localz.start();
        AppMethodBeat.o(283);
        return 0;
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(283);
        return -1;
      }
    }
    AppMethodBeat.o(283);
    return -1;
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(284);
    com.tencent.mm.ad.c.a("EmojiMixVideoDecoder_decodeThread", true, (a)new a(this));
    AppMethodBeat.o(284);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<d.z>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */