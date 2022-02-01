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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.g.b.k;
import d.n.n;
import d.y;
import java.nio.ByteBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j
  extends l
{
  final String TAG;
  c cSi;
  private HandlerThread decoderThread;
  z gOr;
  MediaFormat mediaFormat;
  private String mime;
  private final Object poZ;
  boolean ppb;
  long ppc;
  private final a ppd;
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
    this.cSi = new c();
    this.mime = "";
    this.decoderThread = com.tencent.e.c.d.gz("EmojiMixVideoDecoderAsync_decodeThread", 5);
    this.poZ = new Object();
    this.ppd = new a(this);
    try
    {
      ac.i(this.TAG, "create decoder with path: " + this.videoPath);
      this.cSi.setDataSource(this.videoPath);
      int i = this.cSi.getTrackCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString = this.cSi.getTrackFormat(paramInt);
        k.g(paramString, "extractor.getTrackFormat(i)");
        paramSurface = paramString.getString("mime");
        k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
        if (n.e((CharSequence)paramSurface, (CharSequence)"video") == true)
        {
          paramSurface = paramString.getString("mime");
          k.g(paramSurface, "trackFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = paramSurface;
          this.mediaFormat = paramString;
          ac.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.mime);
          this.cSi.selectTrack(paramInt);
          AppMethodBeat.o(297);
          return;
        }
        paramInt += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)paramString, "init create extractor error", new Object[0]);
      AppMethodBeat.o(297);
    }
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(295);
    synchronized (this.poZ)
    {
      try
      {
        this.poZ.notifyAll();
        y localy = y.KTp;
        AppMethodBeat.o(295);
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
  
  public final int init()
  {
    AppMethodBeat.i(293);
    if ((this.mediaFormat != null) && (!bs.isNullOrNil(this.mime))) {
      try
      {
        this.gOr = z.sx(this.mime);
        Object localObject = this.gOr;
        if (localObject != null) {
          ((z)localObject).a(this.mediaFormat, this.surface, 0);
        }
        if (com.tencent.mm.compatible.util.d.kZ(23))
        {
          this.decoderThread.start();
          localObject = this.decoderThread;
          k.g(localObject, "decoderThread");
          localObject = new Handler(((HandlerThread)localObject).getLooper());
          z localz = this.gOr;
          if (localz != null) {
            localz.setCallback((MediaCodec.Callback)this.ppd, (Handler)localObject);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(293);
          return 0;
          localObject = this.gOr;
          if (localObject != null) {
            ((z)localObject).setCallback((MediaCodec.Callback)this.ppd);
          }
        }
        AppMethodBeat.o(293);
      }
      catch (Exception localException)
      {
        ac.e(this.TAG, "init decoder error " + localException.getMessage());
        AppMethodBeat.o(293);
        return -1;
      }
    }
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(296);
    ac.i(this.TAG, "release");
    try
    {
      this.decoderThread.quit();
      z localz = this.gOr;
      if (localz != null) {
        localz.stop();
      }
      localz = this.gOr;
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
    if (this.gOr == null)
    {
      localObject = this.ppv;
      if (localObject != null)
      {
        ((a)localObject).invoke();
        AppMethodBeat.o(294);
        return;
      }
      AppMethodBeat.o(294);
      return;
    }
    Object localObject = this.gOr;
    if (localObject != null)
    {
      ((z)localObject).start();
      AppMethodBeat.o(294);
      return;
    }
    AppMethodBeat.o(294);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(292);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ac.e(this.ppe.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        j.a(this.ppe);
        this.ppe.release();
        paramMediaCodec = this.ppe.ppv;
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
      ac.i(this.ppe.TAG, "onInputBufferAvailable ".concat(String.valueOf(paramInt)));
      if (paramInt >= 0) {}
      for (;;)
      {
        int j;
        long l;
        try
        {
          if (this.ppe.ppb) {
            break label281;
          }
          paramMediaCodec = this.ppe.gOr;
          if (paramMediaCodec == null) {
            break label306;
          }
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec == null)
          {
            ac.w(this.ppe.TAG, "inputBuffer is null");
            AppMethodBeat.o(290);
            return;
          }
          paramMediaCodec.clear();
          j = this.ppe.cSi.j(paramMediaCodec);
          this.ppe.cSi.advance();
          paramMediaCodec.position(0);
          l = this.ppe.cSi.getSampleTime();
          ac.i(this.ppe.TAG, "sampleTime: " + l + ", sampleSize: " + j);
          if (l <= this.ppe.ppc) {
            break label311;
          }
          this.ppe.ppc = l;
        }
        catch (Exception paramMediaCodec)
        {
          label195:
          ac.printErrStackTrace(this.ppe.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable", new Object[0]);
        }
        ac.i(this.ppe.TAG, "read sample end");
        boolean bool = true;
        label210:
        this.ppe.ppb = bool;
        paramMediaCodec = this.ppe.gOr;
        if (paramMediaCodec != null)
        {
          if (this.ppe.ppb)
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
      ac.i(this.ppe.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
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
          ac.i(this.ppe.TAG, "presentationTimeUs: " + l1 + ", inputSampleTime: " + this.ppe.ppc);
          paramMediaCodec = this.ppe.gOr;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, true);
          }
          j.a(this.ppe, paramBufferInfo);
          if (this.ppe.ppb)
          {
            l2 = this.ppe.ppc;
            if (0L <= l1) {
              break label300;
            }
            ac.i(this.ppe.TAG, "receive eos!");
            j.a(this.ppe);
            this.ppe.release();
            paramMediaCodec = this.ppe.ppv;
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
          ac.printErrStackTrace(this.ppe.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable", new Object[0]);
          continue;
        }
        AppMethodBeat.o(289);
        return;
        AppMethodBeat.o(289);
        return;
        label268:
        paramMediaCodec = this.ppe.gOr;
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
      ac.i(this.ppe.TAG, "onOutputFormatChanged ".concat(String.valueOf(paramMediaFormat)));
      this.ppe.mediaFormat = paramMediaFormat;
      AppMethodBeat.o(291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j
 * JD-Core Version:    0.7.0.1
 */