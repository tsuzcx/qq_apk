package com.tencent.mm.media.c;

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
import com.tencent.mm.media.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;ILkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class j
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  volatile boolean goo;
  private boolean goy;
  private final a goz;
  
  public j(long paramLong1, long paramLong2, final a parama, Surface paramSurface, int paramInt, b<? super f, y> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt);
    AppMethodBeat.i(93555);
    this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    this.decoderThread = com.tencent.e.c.d.gw("MediaCodecTransDecoderAsync_decodeThread", 5);
    this.goz = new a(this, parama);
    try
    {
      this.mediaFormat = parama.gra;
      this.gnF = z.pl(parama.ajO());
      ad.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + parama.ajO());
      if (com.tencent.mm.compatible.util.d.lf(23))
      {
        this.decoderThread.start();
        parama = this.decoderThread;
        k.g(parama, "decoderThread");
        parama = new Handler(parama.getLooper());
        z localz = this.gnF;
        if (localz == null) {
          k.fvU();
        }
        localz.setCallback((MediaCodec.Callback)this.goz, parama);
      }
      for (;;)
      {
        parama = this.gnF;
        if (parama == null) {
          k.fvU();
        }
        parama.a(this.mediaFormat, paramSurface, 0);
        if (paramb == null) {
          break;
        }
        paramb.aA(this);
        AppMethodBeat.o(93555);
        return;
        parama = this.gnF;
        if (parama == null) {
          k.fvU();
        }
        parama.setCallback((MediaCodec.Callback)this.goz);
      }
      AppMethodBeat.o(93555);
    }
    catch (Exception parama)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(93555);
      throw parama;
    }
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(93554);
    super.releaseDecoder();
    try
    {
      this.decoderThread.quit();
      AppMethodBeat.o(93554);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "releaseDecoder error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93554);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93553);
    try
    {
      z localz = this.gnF;
      if (localz == null) {
        k.fvU();
      }
      localz.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    a(a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ad.e(this.goA.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.goA.god)
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.ame();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.amf();
        j.a(this.goA);
        this.goA.releaseDecoder();
      }
      AppMethodBeat.o(93552);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93550);
      k.h(paramMediaCodec, "codec");
      ad.i(this.goA.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      if (paramInt >= 0)
      {
        try
        {
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec != null) {
            break label105;
          }
          paramMediaCodec = new v("null cannot be cast to non-null type java.nio.ByteBuffer");
          AppMethodBeat.o(93550);
          throw paramMediaCodec;
        }
        catch (Exception paramMediaCodec)
        {
          ad.printErrStackTrace(this.goA.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.goA.god)
          {
            paramMediaCodec = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.amd();
          }
        }
      }
      else
      {
        AppMethodBeat.o(93550);
        return;
      }
      label105:
      paramMediaCodec.clear();
      if (parama.k(paramMediaCodec))
      {
        long l = parama.getSampleTime();
        int i = parama.sampleSize;
        paramMediaCodec.position(0);
        paramMediaCodec = this.goA.gnF;
        if (paramMediaCodec == null) {
          k.fvU();
        }
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      ad.i(this.goA.TAG, "read sample end");
      this.goA.goo = true;
      paramMediaCodec = this.goA.gnF;
      if (paramMediaCodec == null) {
        k.fvU();
      }
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      k.h(paramMediaCodec, "codec");
      k.h(paramBufferInfo, "bufferInfo");
      ad.i(this.goA.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.goA.goa);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            ad.i(this.goA.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.goA.bxw * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.goA.gnF;
              if (paramMediaCodec == null) {
                k.fvU();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              ad.i(this.goA.TAG, "decoder pts: " + l + ", not reach start: " + this.goA.bxw * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.goA.a(paramInt, paramBufferInfo);
            if ((this.goA.gnO * 1000L != 1L) && (l >= this.goA.gnO * 1000L))
            {
              ad.e(this.goA.TAG, "exceed endTimeMs");
              j.a(this.goA);
              this.goA.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            ad.printErrStackTrace(this.goA.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.goA.god)
            {
              paramMediaCodec = com.tencent.mm.media.j.d.gwr;
              com.tencent.mm.media.j.d.amd();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.goA.goo));
        ad.i(this.goA.TAG, "receive eos!");
        j.a(this.goA);
        this.goA.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.goA.gnF;
      if (paramMediaCodec == null) {
        k.fvU();
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      k.h(paramMediaCodec, "codec");
      k.h(paramMediaFormat, "format");
      this.goA.mediaFormat = paramMediaFormat;
      ad.i(this.goA.TAG, "decoder output format changed: " + this.goA.mediaFormat);
      paramMediaCodec = this.goA.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.goA.gnW;
        if (paramMediaFormat != null)
        {
          paramMediaFormat.aA(paramMediaCodec);
          AppMethodBeat.o(93551);
          return;
        }
        AppMethodBeat.o(93551);
        return;
      }
      AppMethodBeat.o(93551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.c.j
 * JD-Core Version:    0.7.0.1
 */