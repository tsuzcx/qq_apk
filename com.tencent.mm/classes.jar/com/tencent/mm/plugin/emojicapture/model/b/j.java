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
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.b.p;
import d.n.n;
import java.nio.ByteBuffer;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j
  extends l
{
  final String TAG;
  c ddy;
  private HandlerThread decoderThread;
  com.tencent.mm.compatible.deviceinfo.z hir;
  MediaFormat mediaFormat;
  private String mime;
  private final Object pSA;
  boolean pSC;
  long pSD;
  private final a pSE;
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
    this.ddy = new c();
    this.mime = "";
    this.decoderThread = com.tencent.e.c.d.gX("EmojiMixVideoDecoderAsync_decodeThread", 5);
    this.pSA = new Object();
    this.pSE = new a(this);
    try
    {
      ad.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.ddy.setDataSource(this.videoPath);
      int i = this.ddy.getTrackCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString = this.ddy.getTrackFormat(paramInt);
        p.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        p.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.e((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          p.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          ad.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.mime);
          this.ddy.selectTrack(paramInt);
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
  
  public final void ckf()
  {
    AppMethodBeat.i(295);
    synchronized (this.pSA)
    {
      try
      {
        this.pSA.notifyAll();
        d.z localz = d.z.MKo;
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
        this.hir = com.tencent.mm.compatible.deviceinfo.z.vm(this.mime);
        Object localObject = this.hir;
        if (localObject != null) {
          ((com.tencent.mm.compatible.deviceinfo.z)localObject).a(this.mediaFormat, this.surface, 0);
        }
        if (com.tencent.mm.compatible.util.d.ly(23))
        {
          this.decoderThread.start();
          localObject = this.decoderThread;
          p.g(localObject, "decoderThread");
          localObject = new Handler(((HandlerThread)localObject).getLooper());
          com.tencent.mm.compatible.deviceinfo.z localz = this.hir;
          if (localz != null) {
            localz.setCallback((MediaCodec.Callback)this.pSE, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(293);
          return 0;
          localObject = this.hir;
          if (localObject != null) {
            ((com.tencent.mm.compatible.deviceinfo.z)localObject).setCallback((MediaCodec.Callback)this.pSE);
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
      com.tencent.mm.compatible.deviceinfo.z localz = this.hir;
      if (localz != null) {
        localz.stop();
      }
      localz = this.hir;
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
    if (this.hir == null)
    {
      localObject = this.pSW;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(294);
        return;
      }
      AppMethodBeat.o(294);
      return;
    }
    Object localObject = this.hir;
    if (localObject != null)
    {
      ((com.tencent.mm.compatible.deviceinfo.z)localObject).start();
      AppMethodBeat.o(294);
      return;
    }
    AppMethodBeat.o(294);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(292);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      ad.e(this.pSF.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        j.a(this.pSF);
        this.pSF.release();
        paramMediaCodec = this.pSF.pSW;
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
      p.h(paramMediaCodec, "codec");
      ad.i(this.pSF.TAG, "onInputBufferAvailable ".concat(String.valueOf(paramInt)));
      if (paramInt >= 0) {}
      for (;;)
      {
        int j;
        long l;
        try
        {
          if (this.pSF.pSC) {
            break label282;
          }
          paramMediaCodec = this.pSF.hir;
          if (paramMediaCodec == null) {
            break label307;
          }
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec == null)
          {
            ad.w(this.pSF.TAG, "inputBuffer is null");
            AppMethodBeat.o(290);
            return;
          }
          paramMediaCodec.clear();
          j = this.pSF.ddy.readSampleData(paramMediaCodec, 0);
          this.pSF.ddy.advance();
          paramMediaCodec.position(0);
          l = this.pSF.ddy.getSampleTime();
          ad.i(this.pSF.TAG, "sampleTime: " + l + ", sampleSize: " + j);
          if (l <= this.pSF.pSD) {
            break label312;
          }
          this.pSF.pSD = l;
        }
        catch (Exception paramMediaCodec)
        {
          label196:
          ad.printErrStackTrace(this.pSF.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable", new Object[0]);
        }
        ad.i(this.pSF.TAG, "read sample end");
        boolean bool = true;
        label211:
        this.pSF.pSC = bool;
        paramMediaCodec = this.pSF.hir;
        if (paramMediaCodec != null)
        {
          if (this.pSF.pSC)
          {
            i = 4;
            paramMediaCodec.a(paramInt, j, l, i);
            AppMethodBeat.o(290);
            return;
            label282:
            AppMethodBeat.o(290);
            return;
          }
          int i = 0;
          continue;
        }
        AppMethodBeat.o(290);
        return;
        label307:
        label312:
        do
        {
          bool = false;
          break label211;
          paramMediaCodec = null;
          break;
          if (j < 0) {
            break label196;
          }
        } while (l >= 0L);
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(289);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "info");
      ad.i(this.pSF.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
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
          ad.i(this.pSF.TAG, "presentationTimeUs: " + l1 + ", inputSampleTime: " + this.pSF.pSD);
          paramMediaCodec = this.pSF.hir;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, true);
          }
          j.a(this.pSF, paramBufferInfo);
          if (this.pSF.pSC)
          {
            l2 = this.pSF.pSD;
            if (0L <= l1) {
              break label300;
            }
            ad.i(this.pSF.TAG, "receive eos!");
            j.a(this.pSF);
            this.pSF.release();
            paramMediaCodec = this.pSF.pSW;
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
          ad.printErrStackTrace(this.pSF.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable", new Object[0]);
          continue;
        }
        AppMethodBeat.o(289);
        return;
        AppMethodBeat.o(289);
        return;
        label268:
        paramMediaCodec = this.pSF.hir;
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
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      ad.i(this.pSF.TAG, "onOutputFormatChanged ".concat(String.valueOf(paramMediaFormat)));
      this.pSF.mediaFormat = paramMediaFormat;
      AppMethodBeat.o(291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j
 * JD-Core Version:    0.7.0.1
 */