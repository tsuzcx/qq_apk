package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.b.k;
import d.n.n;
import d.y;
import java.nio.ByteBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j
  extends l
{
  final String TAG;
  c cUM;
  private HandlerThread decoderThread;
  z gnF;
  MediaFormat mediaFormat;
  private String mime;
  private final Object oLF;
  boolean oLH;
  long oLI;
  private final a oLJ;
  private final Surface surface;
  private final int videoDuration;
  private final String videoPath;
  
  public j(String paramString, int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(297);
    this.videoPath = paramString;
    this.videoDuration = paramInt;
    this.surface = paramSurface;
    this.TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    this.cUM = new c();
    this.mime = "";
    this.decoderThread = com.tencent.e.c.d.gv("EmojiMixVideoDecoderAsync_decodeThread", 5);
    this.oLF = new Object();
    this.oLJ = new a(this);
    try
    {
      ad.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cUM.setDataSource(this.videoPath);
      int i = this.cUM.getTrackCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString = this.cUM.getTrackFormat(paramInt);
        k.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.f((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          ad.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.mime);
          this.cUM.selectTrack(paramInt);
          AppMethodBeat.o(297);
          return;
        }
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(297);
    }
  }
  
  public final void bYo()
  {
    AppMethodBeat.i(295);
    synchronized (this.oLF)
    {
      try
      {
        this.oLF.notifyAll();
        y localy = y.JfV;
        AppMethodBeat.o(295);
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
  
  public final int init()
  {
    AppMethodBeat.i(293);
    if ((this.mediaFormat != null) && (!bt.isNullOrNil(this.mime))) {
      try
      {
        this.gnF = z.pl(this.mime);
        Object localObject = this.gnF;
        if (localObject != null) {
          ((z)localObject).a(this.mediaFormat, this.surface, 0);
        }
        if (com.tencent.mm.compatible.util.d.lf(23))
        {
          this.decoderThread.start();
          localObject = this.decoderThread;
          k.g(localObject, "decoderThread");
          localObject = new Handler(((HandlerThread)localObject).getLooper());
          z localz = this.gnF;
          if (localz != null) {
            localz.setCallback((MediaCodec.Callback)this.oLJ, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(293);
          return 0;
          localObject = this.gnF;
          if (localObject != null) {
            ((z)localObject).setCallback((MediaCodec.Callback)this.oLJ);
          }
        }
        AppMethodBeat.o(293);
      }
      catch (Exception localException)
      {
        ad.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(293);
        return -1;
      }
    }
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(296);
    ad.i(this.TAG, "release");
    try
    {
      this.decoderThread.quit();
      z localz = this.gnF;
      if (localz != null) {
        localz.stop();
      }
      localz = this.gnF;
      if (localz != null)
      {
        localz.release();
        AppMethodBeat.o(296);
        return;
      }
      AppMethodBeat.o(296);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(296);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(294);
    if (this.gnF == null)
    {
      localObject = this.oMb;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(294);
        return;
      }
      AppMethodBeat.o(294);
      return;
    }
    Object localObject = this.gnF;
    if (localObject != null)
    {
      ((z)localObject).start();
      AppMethodBeat.o(294);
      return;
    }
    AppMethodBeat.o(294);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(292);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ad.e(this.oLK.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        j.a(this.oLK);
        this.oLK.release();
        paramMediaCodec = this.oLK.oMb;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.invoke();
          AppMethodBeat.o(292);
          return;
        }
      }
      AppMethodBeat.o(292);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(290);
      k.h(paramMediaCodec, "codec");
      ad.i(this.oLK.TAG, "onInputBufferAvailable ".concat(String.valueOf(paramInt)));
      if (paramInt >= 0) {}
      for (;;)
      {
        int j;
        long l;
        try
        {
          if (this.oLK.oLH) {
            break label281;
          }
          paramMediaCodec = this.oLK.gnF;
          if (paramMediaCodec == null) {
            break label306;
          }
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec == null)
          {
            ad.w(this.oLK.TAG, "inputBuffer is null");
            AppMethodBeat.o(290);
            return;
          }
          paramMediaCodec.clear();
          j = this.oLK.cUM.j(paramMediaCodec);
          this.oLK.cUM.advance();
          paramMediaCodec.position(0);
          l = this.oLK.cUM.getSampleTime();
          ad.i(this.oLK.TAG, "sampleTime: " + l + ", sampleSize: " + j);
          if (l <= this.oLK.oLI) {
            break label311;
          }
          this.oLK.oLI = l;
        }
        catch (Exception paramMediaCodec)
        {
          label195:
          ad.printErrStackTrace(this.oLK.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable", new Object[0]);
        }
        ad.i(this.oLK.TAG, "read sample end");
        boolean bool = true;
        label210:
        this.oLK.oLH = bool;
        paramMediaCodec = this.oLK.gnF;
        if (paramMediaCodec != null)
        {
          if (this.oLK.oLH)
          {
            i = 4;
            paramMediaCodec.a(paramInt, j, l, i);
            AppMethodBeat.o(290);
            return;
            label281:
            AppMethodBeat.o(290);
            return;
          }
          int i = 0;
          continue;
        }
        AppMethodBeat.o(290);
        return;
        label306:
        label311:
        do
        {
          bool = false;
          break label210;
          paramMediaCodec = null;
          break;
          if (j < 0) {
            break label195;
          }
        } while (l >= 0L);
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(289);
      k.h(paramMediaCodec, "codec");
      k.h(paramBufferInfo, "info");
      ad.i(this.oLK.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
      if (paramInt >= 0) {}
      for (;;)
      {
        long l1;
        long l2;
        try
        {
          if (paramBufferInfo.size == 0) {
            break label268;
          }
          l1 = paramBufferInfo.presentationTimeUs;
          ad.i(this.oLK.TAG, "presentationTimeUs: " + l1 + ", inputSampleTime: " + this.oLK.oLI);
          paramMediaCodec = this.oLK.gnF;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, true);
          }
          j.a(this.oLK, paramBufferInfo);
          if (this.oLK.oLH)
          {
            l2 = this.oLK.oLI;
            if (0L <= l1) {
              break label300;
            }
            ad.i(this.oLK.TAG, "receive eos!");
            j.a(this.oLK);
            this.oLK.release();
            paramMediaCodec = this.oLK.oMb;
            if (paramMediaCodec == null) {
              continue;
            }
            paramMediaCodec.invoke();
            AppMethodBeat.o(289);
            return;
          }
          paramInt = paramBufferInfo.flags;
          if ((paramInt & 0x4) != 0) {
            continue;
          }
        }
        catch (Exception paramMediaCodec)
        {
          ad.printErrStackTrace(this.oLK.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable", new Object[0]);
          continue;
        }
        AppMethodBeat.o(289);
        return;
        AppMethodBeat.o(289);
        return;
        label268:
        paramMediaCodec = this.oLK.gnF;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(289);
          return;
        }
        AppMethodBeat.o(289);
        return;
        label300:
        if (l2 <= l1) {}
      }
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(291);
      k.h(paramMediaCodec, "codec");
      k.h(paramMediaFormat, "format");
      ad.i(this.oLK.TAG, "onOutputFormatChanged ".concat(String.valueOf(paramMediaFormat)));
      this.oLK.mediaFormat = paramMediaFormat;
      AppMethodBeat.o(291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j
 * JD-Core Version:    0.7.0.1
 */