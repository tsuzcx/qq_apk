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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread hki;
  com.tencent.mm.compatible.deviceinfo.z hlX;
  private Handler hmy;
  private a hmz;
  long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, d.g.a.b<? super b, d.z> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = com.tencent.mm.compatible.deviceinfo.z.vK(paramd.name);
    p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.hlX = ((com.tencent.mm.compatible.deviceinfo.z)localObject);
    localObject = com.tencent.e.c.d.hh("MediaCodecTransEncoder_encodeThread", 5);
    p.g(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.hki = ((HandlerThread)localObject);
    this.hmz = new a(this);
    ae.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.avB();
    localObject = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.avl();
    this.hlX.a(paramd.atu(), null, 1);
    if (ak.coh())
    {
      paramd = g.ajR();
      p.g(paramd, "MMKernel.storage()");
      if (p.i(paramd.ajA().get(am.a.IRj, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(ak.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    ae.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.avm();
    if (com.tencent.mm.compatible.util.d.lA(23))
    {
      this.hki.start();
      this.hmy = new Handler(this.hki.getLooper());
      paramd = this.hlX;
      localObject = (MediaCodec.Callback)this.hmz;
      Handler localHandler = this.hmy;
      if (localHandler == null) {
        p.bdF("encodeHandler");
      }
      paramd.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.hlX.createInputSurface();
      p.g(paramd, "encoder.createInputSurface()");
      g(paramd);
      this.hlX.start();
      paramb.invoke((b)this);
      AppMethodBeat.o(93658);
      return;
      this.hlX.setCallback((MediaCodec.Callback)this.hmz);
    }
  }
  
  public final void atH()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.hmy;
      if (localHandler == null) {
        p.bdF("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.hmy;
      if (localHandler == null) {
        p.bdF("encodeHandler");
      }
      localHandler.post((Runnable)new b(this));
      AppMethodBeat.o(93655);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93655);
    }
  }
  
  public final void atI()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.hmy;
      if (localHandler == null) {
        p.bdF("encodeHandler");
      }
      localHandler.post((Runnable)new c(this));
      AppMethodBeat.o(93656);
      return;
    }
    catch (Exception localException)
    {
      ae.e(this.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(93656);
    }
  }
  
  public final void atK()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = bu.HQ();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long atL()
  {
    AppMethodBeat.i(93657);
    long l1 = bu.HQ();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      ae.e(this.hmA.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.hmA.hlB)
      {
        paramMediaCodec = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.awb();
      }
      this.hmA.atI();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      p.h(paramMediaCodec, "codec");
      ae.i(this.hmA.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "bufferInfo");
      ae.d(this.hmA.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.hmA.hlX.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            ae.i(this.hmA.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            ae.i(this.hmA.TAG, "encode end of stream");
            this.hmA.atI();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.hmA;
            p.g(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            this.hmA.hlX.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          ae.printErrStackTrace(this.hmA.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.hmA.hlB)
          {
            paramMediaCodec = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.awa();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.hmA.hlX.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      ae.i(this.hmA.TAG, "encoder output format changed " + this.hmA.hlX.getOutputFormat());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.hmA.hmj)
      {
        if ((this.hmA.hmh) || (this.hmA.hmi) || (0L == this.hmA.startTime))
        {
          ae.i(this.hmA.TAG, "finishEncode() already finish " + this.hmA.hashCode() + ", isFinishEncode:" + this.hmA.hmh + ", isRelease:" + this.hmA.hmi + ", startTime:" + this.hmA.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        d.z localz = d.z.Nhr;
        ae.i(this.hmA.TAG, "finishEncode() hash:" + this.hmA.hashCode() + "  isFinishEncode:" + this.hmA.hmh + "  startTime:" + this.hmA.startTime);
        this.hmA.hlX.signalEndOfInputStream();
        this.hmA.hmh = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.hmA.hmj)
      {
        if (this.hmA.hmi)
        {
          ae.i(this.hmA.TAG, "releaseEncoder(), already finished " + this.hmA.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        d.z localz = d.z.Nhr;
        long l = bu.HQ();
        ae.i(this.hmA.TAG, "releaseEncoder() start " + this.hmA.hashCode());
        ??? = this.hmA.hmg;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.hmA.hki.quitSafely();
        this.hmA.hlX.stop();
        this.hmA.hlX.release();
        this.hmA.atJ().release();
        this.hmA.hmi = true;
        ??? = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avC();
        ae.i(this.hmA.TAG, "releaseEncoder() finish: time:" + bu.aO(l) + ", " + this.hmA.hashCode());
        AppMethodBeat.o(93653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.f
 * JD-Core Version:    0.7.0.1
 */