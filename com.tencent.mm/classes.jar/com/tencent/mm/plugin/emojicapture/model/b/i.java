package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.a;
import a.f.b.j;
import a.f.b.k;
import a.l.m;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Landroid/media/MediaCodec;", "extractor", "Landroid/media/MediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i
  extends l
{
  final String TAG;
  private final Surface axw;
  MediaExtractor cfO;
  private String cfP;
  MediaCodec eRD;
  private MediaCodec.BufferInfo eRL;
  final long luK;
  private final long luL;
  final int luM;
  private final Object luN;
  private MediaFormat mediaFormat;
  private final String videoPath;
  
  public i(String paramString, Surface paramSurface)
  {
    AppMethodBeat.i(2688);
    this.videoPath = paramString;
    this.axw = paramSurface;
    this.TAG = "MicroMsg.MixVideoDecoder";
    this.cfO = new MediaExtractor();
    this.cfP = "";
    this.luK = 60000L;
    this.luL = 10000L;
    this.luM = 10;
    this.eRL = new MediaCodec.BufferInfo();
    this.luN = new Object();
    try
    {
      ab.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cfO.setDataSource(this.videoPath);
      int j = this.cfO.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = this.cfO.getTrackFormat(i);
        paramSurface = paramString.getString("mime");
        j.p(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (m.d((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          j.p(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.cfP = paramSurface;
          j.p(paramString, "trackFormat");
          this.mediaFormat = paramString;
          paramString = this.TAG;
          paramSurface = new StringBuilder("find video format ");
          MediaFormat localMediaFormat = this.mediaFormat;
          if (localMediaFormat == null) {
            j.ays("mediaFormat");
          }
          ab.i(paramString, localMediaFormat + ", mime: " + this.cfP);
          this.cfO.selectTrack(i);
          AppMethodBeat.o(2688);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(2688);
    }
  }
  
  final boolean UE()
  {
    AppMethodBeat.i(2686);
    Object localObject1 = this.eRD;
    if (localObject1 == null) {
      j.ays("decoder");
    }
    int i = ((MediaCodec)localObject1).dequeueOutputBuffer(this.eRL, this.luL);
    localObject1 = this.eRD;
    if (localObject1 == null) {
      j.ays("decoder");
    }
    localObject1 = ((MediaCodec)localObject1).getOutputBuffers();
    if (i == -1) {
      ab.i(this.TAG, "drainDecoder try again later");
    }
    label73:
    Object localObject4;
    for (;;)
    {
      AppMethodBeat.o(2686);
      return false;
      if (i != -2) {
        break;
      }
      localObject1 = this.TAG;
      ??? = new StringBuilder("drainDecoder output format change: ");
      localObject4 = this.eRD;
      if (localObject4 == null) {
        j.ays("decoder");
      }
      ab.i((String)localObject1, ((MediaCodec)localObject4).getOutputFormat());
      localObject1 = this.eRD;
      if (localObject1 == null) {
        j.ays("decoder");
      }
      localObject1 = ((MediaCodec)localObject1).getOutputFormat();
      j.p(localObject1, "decoder.outputFormat");
      this.mediaFormat = ((MediaFormat)localObject1);
    }
    if (i == -3)
    {
      ??? = this.eRD;
      if (??? == null) {
        j.ays("decoder");
      }
      if (((MediaCodec)???).getOutputBuffers() == null) {
        break label668;
      }
      localObject1 = this.eRD;
      if (localObject1 == null) {
        j.ays("decoder");
      }
      localObject1 = ((MediaCodec)localObject1).getOutputBuffers();
    }
    label668:
    for (;;)
    {
      ??? = this.eRD;
      if (??? == null) {
        j.ays("decoder");
      }
      i = ((MediaCodec)???).dequeueOutputBuffer(this.eRL, this.luL);
      if (i < 0) {
        break label73;
      }
      break;
      if (i < 0)
      {
        ab.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
        break label73;
      }
      ??? = localObject1[i];
      long l = this.eRL.presentationTimeUs;
      if ((this.eRL.flags & 0x4) != 0)
      {
        ab.i(this.TAG, "drainDecoder loop reach eof");
        localObject1 = this.eRD;
        if (localObject1 == null) {
          j.ays("decoder");
        }
        ((MediaCodec)localObject1).releaseOutputBuffer(i, true);
        AppMethodBeat.o(2686);
        return true;
      }
      if ((??? != null) && (this.eRL.size != 0))
      {
        ((ByteBuffer)???).position(this.eRL.offset);
        ((ByteBuffer)???).limit(this.eRL.offset + this.eRL.size);
        ??? = this.eRD;
        if (??? == null) {
          j.ays("decoder");
        }
        ((MediaCodec)???).releaseOutputBuffer(i, true);
        ??? = this.eRL;
        ab.i(this.TAG, "processDecodeBuffer pts: " + ((MediaCodec.BufferInfo)???).presentationTimeUs + ", size: " + ((MediaCodec.BufferInfo)???).size);
        localObject4 = this.lvi;
        if (localObject4 != null) {
          ((a.f.a.b)localObject4).S(Long.valueOf(((MediaCodec.BufferInfo)???).presentationTimeUs * 1000L));
        }
        synchronized (this.luN)
        {
          try
          {
            this.luN.wait(50L);
            localObject4 = y.BMg;
            if ((this.eRL.flags & 0x4) == 0) {
              break label668;
            }
            try
            {
              localObject1 = this.eRD;
              if (localObject1 == null) {
                j.ays("decoder");
              }
              ((MediaCodec)localObject1).stop();
              localObject1 = this.eRD;
              if (localObject1 == null) {
                j.ays("decoder");
              }
              ((MediaCodec)localObject1).release();
            }
            catch (Exception localException1)
            {
              label600:
              break label600;
            }
            AppMethodBeat.o(2686);
            return true;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.printErrStackTrace(this.TAG, (Throwable)localException2, "", new Object[0]);
            }
          }
        }
      }
      else
      {
        ??? = this.eRD;
        if (??? == null) {
          j.ays("decoder");
        }
        ((MediaCodec)???).releaseOutputBuffer(i, true);
      }
    }
  }
  
  public final void boK()
  {
    AppMethodBeat.i(2685);
    synchronized (this.luN)
    {
      try
      {
        this.luN.notifyAll();
        y localy = y.BMg;
        AppMethodBeat.o(2685);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  final void boL()
  {
    AppMethodBeat.i(2687);
    ab.i(this.TAG, "sendDecoderEos");
    Object localObject = this.eRD;
    if (localObject == null) {
      j.ays("decoder");
    }
    int j = ((MediaCodec)localObject).dequeueInputBuffer(this.luK);
    int i = 0;
    while ((j < 0) && (i < this.luM))
    {
      if (!UE())
      {
        AppMethodBeat.o(2687);
        return;
      }
      localObject = this.eRD;
      if (localObject == null) {
        j.ays("decoder");
      }
      j = ((MediaCodec)localObject).dequeueInputBuffer(this.luK);
      i += 1;
    }
    if (j >= 0)
    {
      localObject = this.eRD;
      if (localObject == null) {
        j.ays("decoder");
      }
      localObject = localObject.getInputBuffers()[j];
      ((ByteBuffer)localObject).clear();
      this.cfO.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      localObject = this.eRD;
      if (localObject == null) {
        j.ays("decoder");
      }
      ((MediaCodec)localObject).queueInputBuffer(j, 0, 0, 0L, 4);
    }
    UE();
    AppMethodBeat.o(2687);
  }
  
  public final int init()
  {
    AppMethodBeat.i(2683);
    if ((((i)this).mediaFormat != null) && (!bo.isNullOrNil(this.cfP))) {
      try
      {
        MediaCodec localMediaCodec = MediaCodec.createDecoderByType(this.cfP);
        j.p(localMediaCodec, "MediaCodec.createDecoderByType(mime)");
        this.eRD = localMediaCodec;
        localMediaCodec = this.eRD;
        if (localMediaCodec == null) {
          j.ays("decoder");
        }
        MediaFormat localMediaFormat = this.mediaFormat;
        if (localMediaFormat == null) {
          j.ays("mediaFormat");
        }
        localMediaCodec.configure(localMediaFormat, this.axw, null, 0);
        localMediaCodec = this.eRD;
        if (localMediaCodec == null) {
          j.ays("decoder");
        }
        localMediaCodec.start();
        AppMethodBeat.o(2683);
        return 0;
      }
      catch (Exception localException)
      {
        ab.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(2683);
        return -1;
      }
    }
    AppMethodBeat.o(2683);
    return -1;
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(2684);
    com.tencent.mm.ab.b.a((a)new a(this), "EmojiMixVideoDecoder_decodeThread");
    AppMethodBeat.o(2684);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class a
    extends k
    implements a<y>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.i
 * JD-Core Version:    0.7.0.1
 */