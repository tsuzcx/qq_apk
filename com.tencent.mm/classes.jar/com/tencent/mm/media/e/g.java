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
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.kernel.h;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class g
  extends b
{
  final String TAG;
  HandlerThread kRL;
  aa kTH;
  private Handler kUi;
  private a kUj;
  long startTime;
  
  public g(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = aa.KT(paramd.name);
    p.j(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.kTH = ((aa)localObject);
    localObject = com.tencent.e.c.d.il("MediaCodecTransEncoder_encodeThread", 5);
    p.j(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.kRL = ((HandlerThread)localObject);
    this.kUj = new a(this);
    Log.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWS();
    localObject = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWC();
    this.kTH.a(paramd.aUd(), null, 1);
    if (MMApplicationContext.isMainProcess())
    {
      paramd = h.aHG();
      p.j(paramd, "MMKernel.storage()");
      if (p.h(paramd.aHp().get(ar.a.Vnl, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    Log.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWD();
    if (com.tencent.mm.compatible.util.d.qV(23))
    {
      this.kRL.start();
      this.kUi = new Handler(this.kRL.getLooper());
      paramd = this.kTH;
      localObject = (MediaCodec.Callback)this.kUj;
      Handler localHandler = this.kUi;
      if (localHandler == null) {
        p.bGy("encodeHandler");
      }
      paramd.a((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.kTH.createInputSurface();
      p.j(paramd, "encoder.createInputSurface()");
      h(paramd);
      this.kTH.start();
      paramb.invoke((b)this);
      AppMethodBeat.o(93658);
      return;
      this.kTH.a((MediaCodec.Callback)this.kUj);
    }
  }
  
  public final void aUB()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long aUC()
  {
    AppMethodBeat.i(93657);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  public final void aUx()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.kUi;
      if (localHandler == null) {
        p.bGy("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.kUi;
      if (localHandler == null) {
        p.bGy("encodeHandler");
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
  
  public final void aUy()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.kUi;
      if (localHandler == null) {
        p.bGy("encodeHandler");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      p.k(paramMediaCodec, "codec");
      p.k(paramCodecException, "e");
      Log.e(this.kUk.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.kUk.kTl)
      {
        paramMediaCodec = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXs();
      }
      this.kUk.aUy();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      p.k(paramMediaCodec, "codec");
      Log.i(this.kUk.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      p.k(paramMediaCodec, "codec");
      p.k(paramBufferInfo, "bufferInfo");
      Log.d(this.kUk.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.kUk.kTH.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            Log.i(this.kUk.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            Log.i(this.kUk.TAG, "encode end of stream");
            this.kUk.aUy();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            g localg = this.kUk;
            p.j(paramMediaCodec, "outputBuffer");
            localg.f(paramMediaCodec, paramBufferInfo);
            this.kUk.kTH.u(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(this.kUk.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.kUk.kTl)
          {
            paramMediaCodec = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aXr();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.kUk.kTH.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      p.k(paramMediaCodec, "codec");
      p.k(paramMediaFormat, "format");
      Log.i(this.kUk.TAG, "encoder output format changed " + this.kUk.kTH.avi());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.kUk.kTT)
      {
        if ((this.kUk.kTR) || (this.kUk.kTS) || (0L == this.kUk.startTime))
        {
          Log.i(this.kUk.TAG, "finishEncode() already finish " + this.kUk.hashCode() + ", isFinishEncode:" + this.kUk.kTR + ", isRelease:" + this.kUk.kTS + ", startTime:" + this.kUk.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        x localx = x.aazN;
        Log.i(this.kUk.TAG, "finishEncode() hash:" + this.kUk.hashCode() + "  isFinishEncode:" + this.kUk.kTR + "  startTime:" + this.kUk.startTime);
        this.kUk.kTH.signalEndOfInputStream();
        this.kUk.kTR = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.kUk.kTT)
      {
        if (this.kUk.kTS)
        {
          Log.i(this.kUk.TAG, "releaseEncoder(), already finished " + this.kUk.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        x localx = x.aazN;
        long l = Util.currentTicks();
        Log.i(this.kUk.TAG, "releaseEncoder() start " + this.kUk.hashCode());
        ??? = this.kUk.kTQ;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.kUk.kRL.quitSafely();
        this.kUk.kTH.stop();
        this.kUk.kTH.release();
        this.kUk.aUz().release();
        this.kUk.kTS = true;
        ??? = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWT();
        Log.i(this.kUk.TAG, "releaseEncoder() finish: time:" + Util.ticksToNow(l) + ", " + this.kUk.hashCode());
        AppMethodBeat.o(93653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.e.g
 * JD-Core Version:    0.7.0.1
 */