package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.nio.ByteBuffer;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread ide;
  z ieT;
  private Handler ifu;
  private a ifv;
  long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = z.Eb(paramd.name);
    p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.ieT = ((z)localObject);
    localObject = com.tencent.f.c.d.hB("MediaCodecTransEncoder_encodeThread", 5);
    p.g(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.ide = ((HandlerThread)localObject);
    this.ifv = new a(this);
    Log.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aOo();
    localObject = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNY();
    this.ieT.a(paramd.aLU(), null, 1);
    if (MMApplicationContext.isMainProcess())
    {
      paramd = g.aAh();
      p.g(paramd, "MMKernel.storage()");
      if (p.j(paramd.azQ().get(ar.a.NZl, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    Log.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNZ();
    if (com.tencent.mm.compatible.util.d.oD(23))
    {
      this.ide.start();
      this.ifu = new Handler(this.ide.getLooper());
      paramd = this.ieT;
      localObject = (MediaCodec.Callback)this.ifv;
      Handler localHandler = this.ifu;
      if (localHandler == null) {
        p.btv("encodeHandler");
      }
      paramd.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.ieT.createInputSurface();
      p.g(paramd, "encoder.createInputSurface()");
      g(paramd);
      this.ieT.start();
      paramb.invoke((b)this);
      AppMethodBeat.o(93658);
      return;
      this.ieT.setCallback((MediaCodec.Callback)this.ifv);
    }
  }
  
  public final void aMi()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.ifu;
      if (localHandler == null) {
        p.btv("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.ifu;
      if (localHandler == null) {
        p.btv("encodeHandler");
      }
      localHandler.post((Runnable)new b(this));
      AppMethodBeat.o(93655);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93655);
    }
  }
  
  public final void aMj()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.ifu;
      if (localHandler == null) {
        p.btv("encodeHandler");
      }
      localHandler.post((Runnable)new c(this));
      AppMethodBeat.o(93656);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(93656);
    }
  }
  
  public final void aMl()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long aMm()
  {
    AppMethodBeat.i(93657);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      Log.e(this.ifw.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.ifw.iex)
      {
        paramMediaCodec = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOO();
      }
      this.ifw.aMj();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      p.h(paramMediaCodec, "codec");
      Log.i(this.ifw.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "bufferInfo");
      Log.d(this.ifw.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.ifw.ieT.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            Log.i(this.ifw.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            Log.i(this.ifw.TAG, "encode end of stream");
            this.ifw.aMj();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.ifw;
            p.g(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            this.ifw.ieT.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.ifw.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.ifw.iex)
          {
            paramMediaCodec = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aON();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.ifw.ieT.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      Log.i(this.ifw.TAG, "encoder output format changed " + this.ifw.ieT.getOutputFormat());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.ifw.iff)
      {
        if ((this.ifw.ifd) || (this.ifw.ife) || (0L == this.ifw.startTime))
        {
          Log.i(this.ifw.TAG, "finishEncode() already finish " + this.ifw.hashCode() + ", isFinishEncode:" + this.ifw.ifd + ", isRelease:" + this.ifw.ife + ", startTime:" + this.ifw.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        x localx = x.SXb;
        Log.i(this.ifw.TAG, "finishEncode() hash:" + this.ifw.hashCode() + "  isFinishEncode:" + this.ifw.ifd + "  startTime:" + this.ifw.startTime);
        this.ifw.ieT.signalEndOfInputStream();
        this.ifw.ifd = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.ifw.iff)
      {
        if (this.ifw.ife)
        {
          Log.i(this.ifw.TAG, "releaseEncoder(), already finished " + this.ifw.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        x localx = x.SXb;
        long l = Util.currentTicks();
        Log.i(this.ifw.TAG, "releaseEncoder() start " + this.ifw.hashCode());
        ??? = this.ifw.ifc;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.ifw.ide.quitSafely();
        this.ifw.ieT.stop();
        this.ifw.ieT.release();
        this.ifw.aMk().release();
        this.ifw.ife = true;
        ??? = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOp();
        Log.i(this.ifw.TAG, "releaseEncoder() finish: time:" + Util.ticksToNow(l) + ", " + this.ifw.hashCode());
        AppMethodBeat.o(93653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.e.f
 * JD-Core Version:    0.7.0.1
 */