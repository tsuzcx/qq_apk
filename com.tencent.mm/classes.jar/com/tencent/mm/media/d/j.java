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
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class j
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  volatile boolean ieI;
  private boolean ieQ;
  private final a ieR;
  
  public j(long paramLong1, long paramLong2, final com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, x> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt, paramBoolean);
    AppMethodBeat.i(258662);
    this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    this.decoderThread = com.tencent.f.c.d.hB("MediaCodecTransDecoderAsync_decodeThread", 5);
    this.ieR = new a(this, parama);
    try
    {
      this.mediaFormat = parama.igh;
      this.iec = z.DZ(parama.aMs());
      Log.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + parama.aMs());
      if (com.tencent.mm.compatible.util.d.oD(23))
      {
        this.decoderThread.start();
        parama = this.decoderThread;
        p.g(parama, "decoderThread");
        parama = new Handler(parama.getLooper());
        z localz = this.iec;
        if (localz == null) {
          p.hyc();
        }
        localz.setCallback((MediaCodec.Callback)this.ieR, parama);
      }
      for (;;)
      {
        parama = this.iec;
        if (parama == null) {
          p.hyc();
        }
        parama.a(this.mediaFormat, paramSurface, 0);
        if (paramb == null) {
          break;
        }
        paramb.invoke(this);
        AppMethodBeat.o(258662);
        return;
        parama = this.iec;
        if (parama == null) {
          p.hyc();
        }
        parama.setCallback((MediaCodec.Callback)this.ieR);
      }
      AppMethodBeat.o(258662);
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(258662);
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
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "releaseDecoder error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93554);
    }
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(93553);
    try
    {
      z localz = this.iec;
      if (localz == null) {
        p.hyc();
      }
      localz.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    a(com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      Log.e(this.ieS.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.ieS.iex)
      {
        paramMediaCodec = e.ilC;
        e.aOL();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = e.ilC;
        e.aOM();
        this.ieS.releaseDecoder();
        paramMediaCodec = this.ieS.ier;
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
      Log.i(this.ieS.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      if (paramInt >= 0)
      {
        try
        {
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
          if (paramMediaCodec != null) {
            break label105;
          }
          paramMediaCodec = new t("null cannot be cast to non-null type java.nio.ByteBuffer");
          AppMethodBeat.o(93550);
          throw paramMediaCodec;
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.ieS.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.ieS.iex)
          {
            paramMediaCodec = e.ilC;
            e.aOK();
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
      if (com.tencent.mm.media.f.a.a(parama, paramMediaCodec))
      {
        long l = parama.getSampleTime();
        int i = parama.sampleSize;
        Log.i(this.ieS.TAG, "input sampleTime:" + l + ", sampleSize:" + i);
        paramMediaCodec.position(0);
        paramMediaCodec = this.ieS.iec;
        if (paramMediaCodec == null) {
          p.hyc();
        }
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      Log.i(this.ieS.TAG, "read sample end");
      this.ieS.ieI = true;
      paramMediaCodec = this.ieS.iec;
      if (paramMediaCodec == null) {
        p.hyc();
      }
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "bufferInfo");
      Log.i(this.ieS.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.ieS.isFinished);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            Log.i(this.ieS.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.ieS.startTimeMs * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.ieS.iec;
              if (paramMediaCodec == null) {
                p.hyc();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              Log.i(this.ieS.TAG, "decoder pts: " + l + ", not reach start: " + this.ieS.startTimeMs * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.ieS.a(paramInt, paramBufferInfo);
            if ((this.ieS.endTimeMs * 1000L != 1L) && (l >= this.ieS.endTimeMs * 1000L))
            {
              Log.e(this.ieS.TAG, "exceed endTimeMs");
              j.a(this.ieS);
              this.ieS.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            Log.printErrStackTrace(this.ieS.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.ieS.iex)
            {
              paramMediaCodec = e.ilC;
              e.aOK();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.ieS.ieI));
        Log.i(this.ieS.TAG, "receive eos!");
        j.a(this.ieS);
        this.ieS.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.ieS.iec;
      if (paramMediaCodec == null) {
        p.hyc();
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      this.ieS.mediaFormat = paramMediaFormat;
      Log.i(this.ieS.TAG, "decoder output format changed: " + this.ieS.mediaFormat);
      paramMediaCodec = this.ieS.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.ieS.ieq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.d.j
 * JD-Core Version:    0.7.0.1
 */