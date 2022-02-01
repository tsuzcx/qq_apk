package com.tencent.mm.media.d;

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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread gmK;
  private Handler gqK;
  private a gqL;
  z gqj;
  long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, d.g.a.b<? super b, y> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = z.pn(paramd.name);
    k.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.gqj = ((z)localObject);
    localObject = com.tencent.e.c.d.gw("MediaCodecTransEncoder_encodeThread", 5);
    k.g(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.gmK = ((HandlerThread)localObject);
    this.gqL = new a(this);
    ad.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.alF();
    localObject = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.alp();
    this.gqj.a(paramd.ajq(), null, 1);
    if (aj.cbe())
    {
      paramd = g.afB();
      k.g(paramd, "MMKernel.storage()");
      if (k.g(paramd.afk().get(ae.a.FmE, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(aj.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    ad.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.alq();
    if (com.tencent.mm.compatible.util.d.lf(23))
    {
      this.gmK.start();
      this.gqK = new Handler(this.gmK.getLooper());
      paramd = this.gqj;
      localObject = (MediaCodec.Callback)this.gqL;
      Handler localHandler = this.gqK;
      if (localHandler == null) {
        k.aPZ("encodeHandler");
      }
      paramd.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.gqj.createInputSurface();
      k.g(paramd, "encoder.createInputSurface()");
      h(paramd);
      this.gqj.start();
      paramb.aA((b)this);
      AppMethodBeat.o(93658);
      return;
      this.gqj.setCallback((MediaCodec.Callback)this.gqL);
    }
  }
  
  public final void ajF()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.gqK;
      if (localHandler == null) {
        k.aPZ("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.gqK;
      if (localHandler == null) {
        k.aPZ("encodeHandler");
      }
      localHandler.post((Runnable)new b(this));
      AppMethodBeat.o(93655);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93655);
    }
  }
  
  public final void ajG()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.gqK;
      if (localHandler == null) {
        k.aPZ("encodeHandler");
      }
      localHandler.post((Runnable)new c(this));
      AppMethodBeat.o(93656);
      return;
    }
    catch (Exception localException)
    {
      ad.e(this.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(93656);
    }
  }
  
  public final void ajI()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = bt.GC();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long ajJ()
  {
    AppMethodBeat.i(93657);
    long l1 = bt.GC();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ad.e(this.gqM.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.gqM.god)
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.amh();
      }
      this.gqM.ajG();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      k.h(paramMediaCodec, "codec");
      ad.i(this.gqM.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      k.h(paramMediaCodec, "codec");
      k.h(paramBufferInfo, "bufferInfo");
      ad.d(this.gqM.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.gqM.gqj.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            ad.i(this.gqM.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            ad.i(this.gqM.TAG, "encode end of stream");
            this.gqM.ajG();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.gqM;
            k.g(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            this.gqM.gqj.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          ad.printErrStackTrace(this.gqM.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.gqM.god)
          {
            paramMediaCodec = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.amg();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.gqM.gqj.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      k.h(paramMediaCodec, "codec");
      k.h(paramMediaFormat, "format");
      ad.i(this.gqM.TAG, "encoder output format changed " + this.gqM.gqj.getOutputFormat());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.gqM.gqv)
      {
        if ((this.gqM.gqt) || (this.gqM.gqu) || (0L == this.gqM.startTime))
        {
          ad.i(this.gqM.TAG, "finishEncode() already finish " + this.gqM.hashCode() + ", isFinishEncode:" + this.gqM.gqt + ", isRelease:" + this.gqM.gqu + ", startTime:" + this.gqM.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        y localy = y.JfV;
        ad.i(this.gqM.TAG, "finishEncode() hash:" + this.gqM.hashCode() + "  isFinishEncode:" + this.gqM.gqt + "  startTime:" + this.gqM.startTime);
        this.gqM.gqj.signalEndOfInputStream();
        this.gqM.gqt = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.gqM.gqv)
      {
        if (this.gqM.gqu)
        {
          ad.i(this.gqM.TAG, "releaseEncoder(), already finished " + this.gqM.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        y localy = y.JfV;
        long l = bt.GC();
        ad.i(this.gqM.TAG, "releaseEncoder() start " + this.gqM.hashCode());
        ??? = this.gqM.gqs;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.gqM.gmK.quitSafely();
        this.gqM.gqj.stop();
        this.gqM.gqj.release();
        this.gqM.ajH().release();
        this.gqM.gqu = true;
        ??? = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.alG();
        ad.i(this.gqM.TAG, "releaseEncoder() finish: time:" + bt.aS(l) + ", " + this.gqM.hashCode());
        AppMethodBeat.o(93653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */