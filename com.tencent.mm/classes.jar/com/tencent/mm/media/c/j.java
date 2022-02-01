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
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;ILkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class j
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  volatile boolean gOY;
  private boolean gPg;
  private final a gPh;
  
  public j(long paramLong1, long paramLong2, final a parama, Surface paramSurface, int paramInt, b<? super f, y> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt);
    AppMethodBeat.i(93555);
    this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    this.decoderThread = com.tencent.e.c.d.gA("MediaCodecTransDecoderAsync_decodeThread", 5);
    this.gPh = new a(this, parama);
    try
    {
      this.mediaFormat = parama.gRI;
      this.gOr = z.sx(parama.aqN());
      ac.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + parama.aqN());
      if (com.tencent.mm.compatible.util.d.kZ(23))
      {
        this.decoderThread.start();
        parama = this.decoderThread;
        k.g(parama, "decoderThread");
        parama = new Handler(parama.getLooper());
        z localz = this.gOr;
        if (localz == null) {
          k.fOy();
        }
        localz.setCallback((MediaCodec.Callback)this.gPh, parama);
      }
      for (;;)
      {
        parama = this.gOr;
        if (parama == null) {
          k.fOy();
        }
        parama.a(this.mediaFormat, paramSurface, 0);
        if (paramb == null) {
          break;
        }
        paramb.ay(this);
        AppMethodBeat.o(93555);
        return;
        parama = this.gOr;
        if (parama == null) {
          k.fOy();
        }
        parama.setCallback((MediaCodec.Callback)this.gPh);
      }
      AppMethodBeat.o(93555);
    }
    catch (Exception parama)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
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
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "releaseDecoder error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93554);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93553);
    try
    {
      z localz = this.gOr;
      if (localz == null) {
        k.fOy();
      }
      localz.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    a(a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ac.e(this.gPi.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.gPi.gON)
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asW();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asX();
        j.a(this.gPi);
        this.gPi.releaseDecoder();
      }
      AppMethodBeat.o(93552);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93550);
      k.h(paramMediaCodec, "codec");
      ac.i(this.gPi.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
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
          ac.printErrStackTrace(this.gPi.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.gPi.gON)
          {
            paramMediaCodec = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.asV();
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
        paramMediaCodec = this.gPi.gOr;
        if (paramMediaCodec == null) {
          k.fOy();
        }
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      ac.i(this.gPi.TAG, "read sample end");
      this.gPi.gOY = true;
      paramMediaCodec = this.gPi.gOr;
      if (paramMediaCodec == null) {
        k.fOy();
      }
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      k.h(paramMediaCodec, "codec");
      k.h(paramBufferInfo, "bufferInfo");
      ac.i(this.gPi.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.gPi.gnd);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            ac.i(this.gPi.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.gPi.bvf * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.gPi.gOr;
              if (paramMediaCodec == null) {
                k.fOy();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              ac.i(this.gPi.TAG, "decoder pts: " + l + ", not reach start: " + this.gPi.bvf * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.gPi.a(paramInt, paramBufferInfo);
            if ((this.gPi.gOz * 1000L != 1L) && (l >= this.gPi.gOz * 1000L))
            {
              ac.e(this.gPi.TAG, "exceed endTimeMs");
              j.a(this.gPi);
              this.gPi.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            ac.printErrStackTrace(this.gPi.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.gPi.gON)
            {
              paramMediaCodec = com.tencent.mm.media.j.d.gWO;
              com.tencent.mm.media.j.d.asV();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.gPi.gOY));
        ac.i(this.gPi.TAG, "receive eos!");
        j.a(this.gPi);
        this.gPi.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.gPi.gOr;
      if (paramMediaCodec == null) {
        k.fOy();
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      k.h(paramMediaCodec, "codec");
      k.h(paramMediaFormat, "format");
      this.gPi.mediaFormat = paramMediaFormat;
      ac.i(this.gPi.TAG, "decoder output format changed: " + this.gPi.mediaFormat);
      paramMediaCodec = this.gPi.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.gPi.gOH;
        if (paramMediaFormat != null)
        {
          paramMediaFormat.ay(paramMediaCodec);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.c.j
 * JD-Core Version:    0.7.0.1
 */