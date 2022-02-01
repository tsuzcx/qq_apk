package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i
  extends l
{
  final String TAG;
  private MediaCodec.BufferInfo bufferInfo;
  z iec;
  c jto;
  private MediaFormat mediaFormat;
  private String mime;
  final long rpZ;
  private final long rqa;
  final int rqb;
  private final Object rqc;
  private final Surface surface;
  private final String videoPath;
  
  public i(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(288);
    this.videoPath = paramString;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.jto = new c();
    this.mime = "";
    this.rpZ = 60000L;
    this.rqa = 10000L;
    this.rqb = 10;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.rqc = new Object();
    try
    {
      Log.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.jto.setDataSource(this.videoPath);
      int j = this.jto.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = this.jto.getTrackFormat(i);
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
            p.btv("mediaFormat");
          }
          Log.i(paramString, localMediaFormat + ", mime: " + this.mime);
          this.jto.selectTrack(i);
          AppMethodBeat.o(288);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(288);
    }
  }
  
  final boolean aMg()
  {
    AppMethodBeat.i(286);
    Object localObject1 = this.iec;
    if (localObject1 == null) {
      p.btv("decoder");
    }
    int i = ((z)localObject1).dequeueOutputBuffer(this.bufferInfo, this.rqa);
    localObject1 = this.iec;
    if (localObject1 == null) {
      p.btv("decoder");
    }
    localObject1 = ((z)localObject1).getOutputBuffers();
    if (i == -1) {
      Log.i(this.TAG, "drainDecoder try again later");
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
      localObject4 = this.iec;
      if (localObject4 == null) {
        p.btv("decoder");
      }
      Log.i((String)localObject1, ((z)localObject4).getOutputFormat());
      localObject1 = this.iec;
      if (localObject1 == null) {
        p.btv("decoder");
      }
      localObject1 = ((z)localObject1).getOutputFormat();
      p.g(localObject1, "decoder.outputFormat");
      this.mediaFormat = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.iec;
      if (??? == null) {
        p.btv("decoder");
      }
      if (((z)???).getOutputBuffers() == null) {
        break label668;
      }
      localObject1 = this.iec;
      if (localObject1 == null) {
        p.btv("decoder");
      }
      localObject1 = ((z)localObject1).getOutputBuffers();
    }
    label668:
    for (;;)
    {
      ??? = this.iec;
      if (??? == null) {
        p.btv("decoder");
      }
      i = ((z)???).dequeueOutputBuffer(this.bufferInfo, this.rqa);
      if (i < 0) {
        break label73;
      }
      break;
      if (i < 0)
      {
        Log.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label73;
      }
      ??? = localObject1[i];
      long l = this.bufferInfo.presentationTimeUs;
      if ((this.bufferInfo.flags & 0x4) != 0)
      {
        Log.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.iec;
        if (localObject1 == null) {
          p.btv("decoder");
        }
        ((z)localObject1).releaseOutputBuffer(i, true);
        AppMethodBeat.o(286);
        return true;
      }
      if ((??? != null) && (this.bufferInfo.size != 0))
      {
        ((ByteBuffer)???).position(this.bufferInfo.offset);
        ((ByteBuffer)???).limit(this.bufferInfo.offset + this.bufferInfo.size);
        ??? = this.iec;
        if (??? == null) {
          p.btv("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
        ??? = this.bufferInfo;
        Log.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.rqx;
        if (localObject4 != null) {
          ((b)localObject4).invoke(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.rqc)
        {
          try
          {
            this.rqc.wait(50L);
            localObject4 = x.SXb;
            if ((this.bufferInfo.flags & 0x4) == 0) {
              break label668;
            }
            try
            {
              localObject1 = this.iec;
              if (localObject1 == null) {
                p.btv("decoder");
              }
              ((z)localObject1).stop();
              localObject1 = this.iec;
              if (localObject1 == null) {
                p.btv("decoder");
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
              Log.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.iec;
        if (??? == null) {
          p.btv("decoder");
        }
        ((z)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void cJx()
  {
    AppMethodBeat.i(285);
    synchronized (this.rqc)
    {
      try
      {
        this.rqc.notifyAll();
        x localx = x.SXb;
        AppMethodBeat.o(285);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  final void cJy()
  {
    AppMethodBeat.i(287);
    Log.i(this.TAG, "sendDecoderEos");
    Object localObject = this.iec;
    if (localObject == null) {
      p.btv("decoder");
    }
    int j = ((z)localObject).dequeueInputBuffer(this.rpZ);
    int i = 0;
    while ((j < 0) && (i < this.rqb))
    {
      if (!aMg())
      {
        AppMethodBeat.o(287);
        return;
      }
      localObject = this.iec;
      if (localObject == null) {
        p.btv("decoder");
      }
      j = ((z)localObject).dequeueInputBuffer(this.rpZ);
      i += 1;
    }
    if (j >= 0)
    {
      localObject = this.iec;
      if (localObject == null) {
        p.btv("decoder");
      }
      localObject = localObject.getInputBuffers()[j];
      ((ByteBuffer)localObject).clear();
      this.jto.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      localObject = this.iec;
      if (localObject == null) {
        p.btv("decoder");
      }
      ((z)localObject).a(j, 0, 0L, 4);
    }
    aMg();
    AppMethodBeat.o(287);
  }
  
  public final int init()
  {
    AppMethodBeat.i(283);
    if ((((i)this).mediaFormat != null) && (!Util.isNullOrNil(this.mime))) {
      try
      {
        z localz = z.DZ(this.mime);
        p.g(localz, "MediaCodecProxy.createDecoderByType(mime)");
        this.iec = localz;
        localz = this.iec;
        if (localz == null) {
          p.btv("decoder");
        }
        MediaFormat localMediaFormat = this.mediaFormat;
        if (localMediaFormat == null) {
          p.btv("mediaFormat");
        }
        localz.a(localMediaFormat, this.surface, 0);
        localz = this.iec;
        if (localz == null) {
          p.btv("decoder");
        }
        localz.start();
        AppMethodBeat.o(283);
        return 0;
      }
      catch (Exception localException)
      {
        Log.e(this.TAG, "init decoder error " + localException.getMessage());
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
    d.a("EmojiMixVideoDecoder_decodeThread", true, (a)new a(this));
    AppMethodBeat.o(284);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */