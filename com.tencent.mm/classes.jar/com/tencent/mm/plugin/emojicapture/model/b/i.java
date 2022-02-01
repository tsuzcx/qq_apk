package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.n.n;
import d.y;
import java.nio.ByteBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i
  extends l
{
  final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  com.tencent.mm.compatible.h.c cUM;
  z gnF;
  private MediaFormat mediaFormat;
  private String mime;
  final long oLC;
  private final long oLD;
  final int oLE;
  private final Object oLF;
  private final Surface surface;
  private final String videoPath;
  
  public i(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(288);
    this.videoPath = paramString;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.cUM = new com.tencent.mm.compatible.h.c();
    this.mime = "";
    this.oLC = 60000L;
    this.oLD = 10000L;
    this.oLE = 10;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.oLF = new Object();
    try
    {
      ad.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cUM.setDataSource(this.videoPath);
      int j = this.cUM.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = this.cUM.getTrackFormat(i);
        k.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.f((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          paramString = this.TAG;
          paramSurface = new StringBuilder("find video format ");
          MediaFormat localMediaFormat = this.mediaFormat;
          if (localMediaFormat == null) {
            k.aPZ("mediaFormat");
          }
          ad.i(paramString, localMediaFormat + ", mime: " + this.mime);
          this.cUM.selectTrack(i);
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
  
  final boolean ajw()
  {
    AppMethodBeat.i(286);
    Object localObject1 = this.gnF;
    if (localObject1 == null) {
      k.aPZ("decoder");
    }
    int i = ((z)localObject1).dequeueOutputBuffer(this.bufferInfo, this.oLD);
    localObject1 = this.gnF;
    if (localObject1 == null) {
      k.aPZ("decoder");
    }
    localObject1 = ((z)localObject1).getOutputBuffers();
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
      localObject4 = this.gnF;
      if (localObject4 == null) {
        k.aPZ("decoder");
      }
      ad.i((String)localObject1, ((z)localObject4).getOutputFormat());
      localObject1 = this.gnF;
      if (localObject1 == null) {
        k.aPZ("decoder");
      }
      localObject1 = ((z)localObject1).getOutputFormat();
      k.g(localObject1, "decoder.outputFormat");
      this.mediaFormat = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.gnF;
      if (??? == null) {
        k.aPZ("decoder");
      }
      if (((z)???).getOutputBuffers() == null) {
        break label668;
      }
      localObject1 = this.gnF;
      if (localObject1 == null) {
        k.aPZ("decoder");
      }
      localObject1 = ((z)localObject1).getOutputBuffers();
    }
    label668:
    for (;;)
    {
      ??? = this.gnF;
      if (??? == null) {
        k.aPZ("decoder");
      }
      i = ((z)???).dequeueOutputBuffer(this.bufferInfo, this.oLD);
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
        localObject1 = this.gnF;
        if (localObject1 == null) {
          k.aPZ("decoder");
        }
        ((z)localObject1).releaseOutputBuffer(i, true);
        AppMethodBeat.o(286);
        return true;
      }
      if ((??? != null) && (this.bufferInfo.size != 0))
      {
        ((ByteBuffer)???).position(this.bufferInfo.offset);
        ((ByteBuffer)???).limit(this.bufferInfo.offset + this.bufferInfo.size);
        ??? = this.gnF;
        if (??? == null) {
          k.aPZ("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
        ??? = this.bufferInfo;
        ad.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.oMa;
        if (localObject4 != null) {
          ((b)localObject4).aA(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.oLF)
        {
          try
          {
            this.oLF.wait(50L);
            localObject4 = y.JfV;
            if ((this.bufferInfo.flags & 0x4) == 0) {
              break label668;
            }
            try
            {
              localObject1 = this.gnF;
              if (localObject1 == null) {
                k.aPZ("decoder");
              }
              ((z)localObject1).stop();
              localObject1 = this.gnF;
              if (localObject1 == null) {
                k.aPZ("decoder");
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
              ad.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.gnF;
        if (??? == null) {
          k.aPZ("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void bYo()
  {
    AppMethodBeat.i(285);
    synchronized (this.oLF)
    {
      try
      {
        this.oLF.notifyAll();
        y localy = y.JfV;
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
  
  final void bYp()
  {
    AppMethodBeat.i(287);
    ad.i(this.TAG, "sendDecoderEos");
    Object localObject = this.gnF;
    if (localObject == null) {
      k.aPZ("decoder");
    }
    int j = ((z)localObject).dequeueInputBuffer(this.oLC);
    int i = 0;
    while ((j < 0) && (i < this.oLE))
    {
      if (!ajw())
      {
        AppMethodBeat.o(287);
        return;
      }
      localObject = this.gnF;
      if (localObject == null) {
        k.aPZ("decoder");
      }
      j = ((z)localObject).dequeueInputBuffer(this.oLC);
      i += 1;
    }
    if (j >= 0)
    {
      localObject = this.gnF;
      if (localObject == null) {
        k.aPZ("decoder");
      }
      localObject = localObject.getInputBuffers()[j];
      ((ByteBuffer)localObject).clear();
      this.cUM.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      localObject = this.gnF;
      if (localObject == null) {
        k.aPZ("decoder");
      }
      ((z)localObject).a(j, 0, 0L, 4);
    }
    ajw();
    AppMethodBeat.o(287);
  }
  
  public final int init()
  {
    AppMethodBeat.i(283);
    if ((((i)this).mediaFormat != null) && (!bt.isNullOrNil(this.mime))) {
      try
      {
        z localz = z.pl(this.mime);
        k.g(localz, "MediaCodecProxy.createDecoderByType(mime)");
        this.gnF = localz;
        localz = this.gnF;
        if (localz == null) {
          k.aPZ("decoder");
        }
        MediaFormat localMediaFormat = this.mediaFormat;
        if (localMediaFormat == null) {
          k.aPZ("mediaFormat");
        }
        localz.a(localMediaFormat, this.surface, 0);
        localz = this.gnF;
        if (localz == null) {
          k.aPZ("decoder");
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */