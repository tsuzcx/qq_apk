package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.v;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;ILkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class j
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  volatile boolean hlM;
  private boolean hlU;
  private final a hlV;
  
  public j(long paramLong1, long paramLong2, final com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, b<? super f, d.z> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt);
    AppMethodBeat.i(93555);
    this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    this.decoderThread = com.tencent.e.c.d.hh("MediaCodecTransDecoderAsync_decodeThread", 5);
    this.hlV = new a(this, parama);
    try
    {
      this.mediaFormat = parama.hmO;
      this.hlf = com.tencent.mm.compatible.deviceinfo.z.vI(parama.atQ());
      ae.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + parama.atQ());
      if (com.tencent.mm.compatible.util.d.lA(23))
      {
        this.decoderThread.start();
        parama = this.decoderThread;
        p.g(parama, "decoderThread");
        parama = new Handler(parama.getLooper());
        com.tencent.mm.compatible.deviceinfo.z localz = this.hlf;
        if (localz == null) {
          p.gkB();
        }
        localz.setCallback((MediaCodec.Callback)this.hlV, parama);
      }
      for (;;)
      {
        parama = this.hlf;
        if (parama == null) {
          p.gkB();
        }
        parama.a(this.mediaFormat, paramSurface, 0);
        if (paramb == null) {
          break;
        }
        paramb.invoke(this);
        AppMethodBeat.o(93555);
        return;
        parama = this.hlf;
        if (parama == null) {
          p.gkB();
        }
        parama.setCallback((MediaCodec.Callback)this.hlV);
      }
      AppMethodBeat.o(93555);
    }
    catch (Exception parama)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
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
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "releaseDecoder error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93554);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93553);
    try
    {
      com.tencent.mm.compatible.deviceinfo.z localz = this.hlf;
      if (localz == null) {
        p.gkB();
      }
      localz.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    a(com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      ae.e(this.hlW.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.hlW.hlB)
      {
        paramMediaCodec = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avY();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avZ();
        this.hlW.releaseDecoder();
        paramMediaCodec = this.hlW.hlv;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.invoke();
          AppMethodBeat.o(93552);
          return;
        }
      }
      AppMethodBeat.o(93552);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93550);
      p.h(paramMediaCodec, "codec");
      ae.i(this.hlW.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
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
          ae.printErrStackTrace(this.hlW.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.hlW.hlB)
          {
            paramMediaCodec = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.avX();
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
      if (parama.j(paramMediaCodec))
      {
        long l = parama.getSampleTime();
        int i = parama.sampleSize;
        paramMediaCodec.position(0);
        paramMediaCodec = this.hlW.hlf;
        if (paramMediaCodec == null) {
          p.gkB();
        }
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      ae.i(this.hlW.TAG, "read sample end");
      this.hlW.hlM = true;
      paramMediaCodec = this.hlW.hlf;
      if (paramMediaCodec == null) {
        p.gkB();
      }
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "bufferInfo");
      ae.i(this.hlW.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.hlW.gJv);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            ae.i(this.hlW.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.hlW.startTimeMs * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.hlW.hlf;
              if (paramMediaCodec == null) {
                p.gkB();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              ae.i(this.hlW.TAG, "decoder pts: " + l + ", not reach start: " + this.hlW.startTimeMs * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.hlW.a(paramInt, paramBufferInfo);
            if ((this.hlW.hlm * 1000L != 1L) && (l >= this.hlW.hlm * 1000L))
            {
              ae.e(this.hlW.TAG, "exceed endTimeMs");
              j.a(this.hlW);
              this.hlW.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            ae.printErrStackTrace(this.hlW.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.hlW.hlB)
            {
              paramMediaCodec = com.tencent.mm.media.k.d.hrI;
              com.tencent.mm.media.k.d.avX();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.hlW.hlM));
        ae.i(this.hlW.TAG, "receive eos!");
        j.a(this.hlW);
        this.hlW.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.hlW.hlf;
      if (paramMediaCodec == null) {
        p.gkB();
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      this.hlW.mediaFormat = paramMediaFormat;
      ae.i(this.hlW.TAG, "decoder output format changed: " + this.hlW.mediaFormat);
      paramMediaCodec = this.hlW.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.hlW.hlu;
        if (paramMediaFormat != null)
        {
          paramMediaFormat.invoke(paramMediaCodec);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.j
 * JD-Core Version:    0.7.0.1
 */