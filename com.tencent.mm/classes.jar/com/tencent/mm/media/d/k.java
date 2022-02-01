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
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class k
  extends f
{
  final String TAG;
  private HandlerThread decoderThread;
  private boolean kTE;
  private final a kTF;
  volatile boolean kTv;
  
  public k(long paramLong1, long paramLong2, final com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean, b<? super f, x> paramb)
  {
    super(paramLong1, paramLong2, parama, paramSurface, paramInt, paramBoolean);
    AppMethodBeat.i(258281);
    this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    this.decoderThread = com.tencent.e.c.d.il("MediaCodecTransDecoderAsync_decodeThread", 5);
    this.kTF = new a(this, parama);
    try
    {
      this.mediaFormat = parama.kUV;
      this.kSN = aa.KR(parama.aUI());
      Log.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + parama.aUI());
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        this.decoderThread.start();
        parama = this.decoderThread;
        p.j(parama, "decoderThread");
        parama = new Handler(parama.getLooper());
        aa localaa = this.kSN;
        if (localaa == null) {
          p.iCn();
        }
        localaa.a((MediaCodec.Callback)this.kTF, parama);
      }
      for (;;)
      {
        parama = this.kSN;
        if (parama == null) {
          p.iCn();
        }
        parama.a(this.mediaFormat, paramSurface, 0);
        if (paramb == null) {
          break;
        }
        paramb.invoke(this);
        AppMethodBeat.o(258281);
        return;
        parama = this.kSN;
        if (parama == null) {
          p.iCn();
        }
        parama.a((MediaCodec.Callback)this.kTF);
      }
      AppMethodBeat.o(258281);
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)parama, "create decoder error:" + parama.getMessage(), new Object[0]);
      parama = (Throwable)new IllegalStateException("init decoder error");
      AppMethodBeat.o(258281);
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
      aa localaa = this.kSN;
      if (localaa == null) {
        p.iCn();
      }
      localaa.start();
      AppMethodBeat.o(93553);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "startDecode error", new Object[0]);
      AppMethodBeat.o(93553);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    a(com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93552);
      p.k(paramMediaCodec, "codec");
      p.k(paramCodecException, "e");
      Log.e(this.kTG.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
      if (this.kTG.kTl)
      {
        paramMediaCodec = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXp();
      }
      if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
      {
        paramMediaCodec = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXq();
        this.kTG.releaseDecoder();
        paramMediaCodec = this.kTG.kTf;
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
      p.k(paramMediaCodec, "codec");
      Log.i(this.kTG.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
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
          Log.printErrStackTrace(this.kTG.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          if (this.kTG.kTl)
          {
            paramMediaCodec = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aXo();
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
        Log.i(this.kTG.TAG, "input sampleTime:" + l + ", sampleSize:" + i);
        paramMediaCodec.position(0);
        paramMediaCodec = this.kTG.kSN;
        if (paramMediaCodec == null) {
          p.iCn();
        }
        paramMediaCodec.a(paramInt, i, l, 0);
        AppMethodBeat.o(93550);
        return;
      }
      Log.i(this.kTG.TAG, "read sample end");
      this.kTG.kTv = true;
      paramMediaCodec = this.kTG.kSN;
      if (paramMediaCodec == null) {
        p.iCn();
      }
      paramMediaCodec.a(paramInt, 0, 0L, 4);
      AppMethodBeat.o(93550);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93549);
      p.k(paramMediaCodec, "codec");
      p.k(paramBufferInfo, "bufferInfo");
      Log.i(this.kTG.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.kTG.isFinished);
      if (paramInt >= 0)
      {
        do
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            Log.i(this.kTG.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.kTG.startTimeMs * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.kTG.kSN;
              if (paramMediaCodec == null) {
                p.iCn();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              Log.i(this.kTG.TAG, "decoder pts: " + l + ", not reach start: " + this.kTG.startTimeMs * 1000L);
              AppMethodBeat.o(93549);
              return;
            }
            this.kTG.a(paramInt, paramBufferInfo);
            if ((this.kTG.endTimeMs * 1000L != 1L) && (l >= this.kTG.endTimeMs * 1000L))
            {
              Log.e(this.kTG.TAG, "exceed endTimeMs");
              k.a(this.kTG);
              this.kTG.releaseDecoder();
              AppMethodBeat.o(93549);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            Log.printErrStackTrace(this.kTG.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.kTG.kTl)
            {
              paramMediaCodec = com.tencent.mm.media.k.f.laB;
              com.tencent.mm.media.k.f.aXo();
            }
            AppMethodBeat.o(93549);
            return;
          }
        } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.kTG.kTv));
        Log.i(this.kTG.TAG, "receive eos!");
        k.a(this.kTG);
        this.kTG.releaseDecoder();
        AppMethodBeat.o(93549);
        return;
      }
      paramMediaCodec = this.kTG.kSN;
      if (paramMediaCodec == null) {
        p.iCn();
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93549);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93551);
      p.k(paramMediaCodec, "codec");
      p.k(paramMediaFormat, "format");
      this.kTG.mediaFormat = paramMediaFormat;
      Log.i(this.kTG.TAG, "decoder output format changed: " + this.kTG.mediaFormat);
      paramMediaCodec = this.kTG.mediaFormat;
      if (paramMediaCodec != null)
      {
        paramMediaFormat = this.kTG.kTe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.k
 * JD-Core Version:    0.7.0.1
 */