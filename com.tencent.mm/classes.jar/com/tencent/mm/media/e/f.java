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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread hhu;
  private Handler hjK;
  private a hjL;
  com.tencent.mm.compatible.deviceinfo.z hjj;
  long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, d.g.a.b<? super b, d.z> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = com.tencent.mm.compatible.deviceinfo.z.vo(paramd.name);
    p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.hjj = ((com.tencent.mm.compatible.deviceinfo.z)localObject);
    localObject = com.tencent.e.c.d.gY("MediaCodecTransEncoder_encodeThread", 5);
    p.g(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.hhu = ((HandlerThread)localObject);
    this.hjL = new a(this);
    ad.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.avm();
    localObject = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.auW();
    this.hjj.a(paramd.atf(), null, 1);
    if (aj.cmR())
    {
      paramd = g.ajC();
      p.g(paramd, "MMKernel.storage()");
      if (p.i(paramd.ajl().get(al.a.IwL, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(aj.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    ad.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.auX();
    if (com.tencent.mm.compatible.util.d.ly(23))
    {
      this.hhu.start();
      this.hjK = new Handler(this.hhu.getLooper());
      paramd = this.hjj;
      localObject = (MediaCodec.Callback)this.hjL;
      Handler localHandler = this.hjK;
      if (localHandler == null) {
        p.bcb("encodeHandler");
      }
      paramd.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.hjj.createInputSurface();
      p.g(paramd, "encoder.createInputSurface()");
      g(paramd);
      this.hjj.start();
      paramb.invoke((b)this);
      AppMethodBeat.o(93658);
      return;
      this.hjj.setCallback((MediaCodec.Callback)this.hjL);
    }
  }
  
  public final void ats()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.hjK;
      if (localHandler == null) {
        p.bcb("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.hjK;
      if (localHandler == null) {
        p.bcb("encodeHandler");
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
  
  public final void att()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.hjK;
      if (localHandler == null) {
        p.bcb("encodeHandler");
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
  
  public final void atv()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = bt.HI();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long atw()
  {
    AppMethodBeat.i(93657);
    long l1 = bt.HI();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      ad.e(this.hjM.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.hjM.hiN)
      {
        paramMediaCodec = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avM();
      }
      this.hjM.att();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      p.h(paramMediaCodec, "codec");
      ad.i(this.hjM.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "bufferInfo");
      ad.d(this.hjM.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.hjM.hjj.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            ad.i(this.hjM.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            ad.i(this.hjM.TAG, "encode end of stream");
            this.hjM.att();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.hjM;
            p.g(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            this.hjM.hjj.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          ad.printErrStackTrace(this.hjM.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.hjM.hiN)
          {
            paramMediaCodec = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.avL();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.hjM.hjj.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      ad.i(this.hjM.TAG, "encoder output format changed " + this.hjM.hjj.getOutputFormat());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.hjM.hjv)
      {
        if ((this.hjM.hjt) || (this.hjM.hju) || (0L == this.hjM.startTime))
        {
          ad.i(this.hjM.TAG, "finishEncode() already finish " + this.hjM.hashCode() + ", isFinishEncode:" + this.hjM.hjt + ", isRelease:" + this.hjM.hju + ", startTime:" + this.hjM.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        d.z localz = d.z.MKo;
        ad.i(this.hjM.TAG, "finishEncode() hash:" + this.hjM.hashCode() + "  isFinishEncode:" + this.hjM.hjt + "  startTime:" + this.hjM.startTime);
        this.hjM.hjj.signalEndOfInputStream();
        this.hjM.hjt = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.hjM.hjv)
      {
        if (this.hjM.hju)
        {
          ad.i(this.hjM.TAG, "releaseEncoder(), already finished " + this.hjM.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        d.z localz = d.z.MKo;
        long l = bt.HI();
        ad.i(this.hjM.TAG, "releaseEncoder() start " + this.hjM.hashCode());
        ??? = this.hjM.hjs;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.hjM.hhu.quitSafely();
        this.hjM.hjj.stop();
        this.hjM.hjj.release();
        this.hjM.atu().release();
        this.hjM.hju = true;
        ??? = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avn();
        ad.i(this.hjM.TAG, "releaseEncoder() finish: time:" + bt.aO(l) + ", " + this.hjM.hashCode());
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