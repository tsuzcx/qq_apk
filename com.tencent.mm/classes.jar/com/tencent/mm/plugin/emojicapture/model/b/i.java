package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.n.n;
import d.y;
import java.nio.ByteBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i
  extends l
{
  final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  com.tencent.mm.compatible.h.c cSi;
  z gOr;
  private MediaFormat mediaFormat;
  private String mime;
  final long poW;
  private final long poX;
  final int poY;
  private final Object poZ;
  private final Surface surface;
  private final String videoPath;
  
  public i(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(288);
    this.videoPath = paramString;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.cSi = new com.tencent.mm.compatible.h.c();
    this.mime = "";
    this.poW = 60000L;
    this.poX = 10000L;
    this.poY = 10;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.poZ = new Object();
    try
    {
      ac.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cSi.setDataSource(this.videoPath);
      int j = this.cSi.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = this.cSi.getTrackFormat(i);
        k.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.e((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          paramString = this.TAG;
          paramSurface = new StringBuilder("find video format ");
          MediaFormat localMediaFormat = this.mediaFormat;
          if (localMediaFormat == null) {
            k.aVY("mediaFormat");
          }
          ac.i(paramString, localMediaFormat + ", mime: " + this.mime);
          this.cSi.selectTrack(i);
          AppMethodBeat.o(288);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(288);
    }
  }
  
  final boolean aqv()
  {
    AppMethodBeat.i(286);
    Object localObject1 = this.gOr;
    if (localObject1 == null) {
      k.aVY("decoder");
    }
    int i = ((z)localObject1).dequeueOutputBuffer(this.bufferInfo, this.poX);
    localObject1 = this.gOr;
    if (localObject1 == null) {
      k.aVY("decoder");
    }
    localObject1 = ((z)localObject1).getOutputBuffers();
    if (i == -1) {
      ac.i(this.TAG, "drainDecoder try again later");
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
      localObject4 = this.gOr;
      if (localObject4 == null) {
        k.aVY("decoder");
      }
      ac.i((String)localObject1, ((z)localObject4).getOutputFormat());
      localObject1 = this.gOr;
      if (localObject1 == null) {
        k.aVY("decoder");
      }
      localObject1 = ((z)localObject1).getOutputFormat();
      k.g(localObject1, "decoder.outputFormat");
      this.mediaFormat = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.gOr;
      if (??? == null) {
        k.aVY("decoder");
      }
      if (((z)???).getOutputBuffers() == null) {
        break label668;
      }
      localObject1 = this.gOr;
      if (localObject1 == null) {
        k.aVY("decoder");
      }
      localObject1 = ((z)localObject1).getOutputBuffers();
    }
    label668:
    for (;;)
    {
      ??? = this.gOr;
      if (??? == null) {
        k.aVY("decoder");
      }
      i = ((z)???).dequeueOutputBuffer(this.bufferInfo, this.poX);
      if (i < 0) {
        break label73;
      }
      break;
      if (i < 0)
      {
        ac.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label73;
      }
      ??? = localObject1[i];
      long l = this.bufferInfo.presentationTimeUs;
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        ac.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.gOr;
        if (localObject1 == null) {
          k.aVY("decoder");
        }
        ((z)localObject1).releaseOutputBuffer(i, true);
        AppMethodBeat.o(286);
        return true;
      }
      if ((??? != null) && (this.bufferInfo.size != 0))
      {
        ((ByteBuffer)???).position(this.bufferInfo.offset);
        ((ByteBuffer)???).limit(this.bufferInfo.offset + this.bufferInfo.size);
        ??? = this.gOr;
        if (??? == null) {
          k.aVY("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
        ??? = this.bufferInfo;
        ac.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.ppu;
        if (localObject4 != null) {
          ((b)localObject4).ay(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.poZ)
        {
          try
          {
            this.poZ.wait(50L);
            localObject4 = y.KTp;
            if ((this.bufferInfo.flags & 0x4) == 0) {
              break label668;
            }
            try
            {
              localObject1 = this.gOr;
              if (localObject1 == null) {
                k.aVY("decoder");
              }
              ((z)localObject1).stop();
              localObject1 = this.gOr;
              if (localObject1 == null) {
                k.aVY("decoder");
              }
              ((z)localObject1).release();
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
              ac.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.gOr;
        if (??? == null) {
          k.aVY("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(285);
    synchronized (this.poZ)
    {
      try
      {
        this.poZ.notifyAll();
        y localy = y.KTp;
        AppMethodBeat.o(285);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  final void cfC()
  {
    AppMethodBeat.i(287);
    ac.i(this.TAG, "sendDecoderEos");
    Object localObject = this.gOr;
    if (localObject == null) {
      k.aVY("decoder");
    }
    int j = ((z)localObject).dequeueInputBuffer(this.poW);
    int i = 0;
    while ((j < 0) && (i < this.poY))
    {
      if (!aqv())
      {
        AppMethodBeat.o(287);
        return;
      }
      localObject = this.gOr;
      if (localObject == null) {
        k.aVY("decoder");
      }
      j = ((z)localObject).dequeueInputBuffer(this.poW);
      i += 1;
    }
    if (j >= 0)
    {
      localObject = this.gOr;
      if (localObject == null) {
        k.aVY("decoder");
      }
      localObject = localObject.getInputBuffers()[j];
      ((ByteBuffer)localObject).clear();
      this.cSi.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      localObject = this.gOr;
      if (localObject == null) {
        k.aVY("decoder");
      }
      ((z)localObject).a(j, 0, 0L, 4);
    }
    aqv();
    AppMethodBeat.o(287);
  }
  
  public final int init()
  {
    AppMethodBeat.i(283);
    if ((((i)this).mediaFormat != null) && (!bs.isNullOrNil(this.mime))) {
      try
      {
        z localz = z.sx(this.mime);
        k.g(localz, "MediaCodecProxy.createDecoderByType(mime)");
        this.gOr = localz;
        localz = this.gOr;
        if (localz == null) {
          k.aVY("decoder");
        }
        MediaFormat localMediaFormat = this.mediaFormat;
        if (localMediaFormat == null) {
          k.aVY("mediaFormat");
        }
        localz.a(localMediaFormat, this.surface, 0);
        localz = this.gOr;
        if (localz == null) {
          k.aVY("decoder");
        }
        localz.start();
        AppMethodBeat.o(283);
        return 0;
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "init decoder error " + localException.getMessage());
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
    com.tencent.mm.ac.c.a("EmojiMixVideoDecoder_decodeThread", true, (a)new a(this));
    AppMethodBeat.o(284);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */