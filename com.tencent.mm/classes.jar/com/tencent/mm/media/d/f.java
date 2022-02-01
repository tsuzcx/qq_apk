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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread gNx;
  z gQR;
  private Handler gRs;
  private a gRt;
  long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, d.g.a.b<? super b, y> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = z.sz(paramd.name);
    k.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.gQR = ((z)localObject);
    localObject = com.tencent.e.c.d.gA("MediaCodecTransEncoder_encodeThread", 5);
    k.g(localObject, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.gNx = ((HandlerThread)localObject);
    this.gRt = new a(this);
    ac.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.asz();
    localObject = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.asj();
    this.gQR.a(paramd.aqq(), null, 1);
    if (ai.cin())
    {
      paramd = g.agR();
      k.g(paramd, "MMKernel.storage()");
      if (k.g(paramd.agA().get(ah.a.GKt, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(ai.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(93658);
        throw paramd;
      }
    }
    ac.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.ask();
    if (com.tencent.mm.compatible.util.d.kZ(23))
    {
      this.gNx.start();
      this.gRs = new Handler(this.gNx.getLooper());
      paramd = this.gQR;
      localObject = (MediaCodec.Callback)this.gRt;
      Handler localHandler = this.gRs;
      if (localHandler == null) {
        k.aVY("encodeHandler");
      }
      paramd.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramd = this.gQR.createInputSurface();
      k.g(paramd, "encoder.createInputSurface()");
      g(paramd);
      this.gQR.start();
      paramb.ay((b)this);
      AppMethodBeat.o(93658);
      return;
      this.gQR.setCallback((MediaCodec.Callback)this.gRt);
    }
  }
  
  public final void aqE()
  {
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.gRs;
      if (localHandler == null) {
        k.aVY("encodeHandler");
      }
      localHandler.removeCallbacksAndMessages(null);
      localHandler = this.gRs;
      if (localHandler == null) {
        k.aVY("encodeHandler");
      }
      localHandler.post((Runnable)new b(this));
      AppMethodBeat.o(93655);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93655);
    }
  }
  
  public final void aqF()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler = this.gRs;
      if (localHandler == null) {
        k.aVY("encodeHandler");
      }
      localHandler.post((Runnable)new c(this));
      AppMethodBeat.o(93656);
      return;
    }
    catch (Exception localException)
    {
      ac.e(this.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(93656);
    }
  }
  
  public final void aqH()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = bs.Gn();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long aqI()
  {
    AppMethodBeat.i(93657);
    long l1 = bs.Gn();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class a
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      k.h(paramMediaCodec, "codec");
      k.h(paramCodecException, "e");
      ac.e(this.gRu.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
      if (this.gRu.gON)
      {
        paramMediaCodec = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asZ();
      }
      this.gRu.aqF();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      k.h(paramMediaCodec, "codec");
      ac.i(this.gRu.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      k.h(paramMediaCodec, "codec");
      k.h(paramBufferInfo, "bufferInfo");
      ac.d(this.gRu.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.gRu.gQR.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            ac.i(this.gRu.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            ac.i(this.gRu.TAG, "encode end of stream");
            this.gRu.aqF();
            AppMethodBeat.o(93648);
            return;
          }
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.gRu;
            k.g(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            this.gRu.gQR.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
          }
          AppMethodBeat.o(93648);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          ac.printErrStackTrace(this.gRu.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.gRu.gON)
          {
            paramMediaCodec = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.asY();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      this.gRu.gQR.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      k.h(paramMediaCodec, "codec");
      k.h(paramMediaFormat, "format");
      ac.i(this.gRu.TAG, "encoder output format changed " + this.gRu.gQR.getOutputFormat());
      AppMethodBeat.o(93650);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93652);
      synchronized (this.gRu.gRd)
      {
        if ((this.gRu.gRb) || (this.gRu.gRc) || (0L == this.gRu.startTime))
        {
          ac.i(this.gRu.TAG, "finishEncode() already finish " + this.gRu.hashCode() + ", isFinishEncode:" + this.gRu.gRb + ", isRelease:" + this.gRu.gRc + ", startTime:" + this.gRu.startTime);
          AppMethodBeat.o(93652);
          return;
        }
        y localy = y.KTp;
        ac.i(this.gRu.TAG, "finishEncode() hash:" + this.gRu.hashCode() + "  isFinishEncode:" + this.gRu.gRb + "  startTime:" + this.gRu.startTime);
        this.gRu.gQR.signalEndOfInputStream();
        this.gRu.gRb = true;
        AppMethodBeat.o(93652);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93653);
      synchronized (this.gRu.gRd)
      {
        if (this.gRu.gRc)
        {
          ac.i(this.gRu.TAG, "releaseEncoder(), already finished " + this.gRu.hashCode());
          AppMethodBeat.o(93653);
          return;
        }
        y localy = y.KTp;
        long l = bs.Gn();
        ac.i(this.gRu.TAG, "releaseEncoder() start " + this.gRu.hashCode());
        ??? = this.gRu.gRa;
        if (??? != null) {
          ((a)???).invoke();
        }
        this.gRu.gNx.quitSafely();
        this.gRu.gQR.stop();
        this.gRu.gQR.release();
        this.gRu.aqG().release();
        this.gRu.gRc = true;
        ??? = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asA();
        ac.i(this.gRu.TAG, "releaseEncoder() finish: time:" + bs.aO(l) + ", " + this.gRu.hashCode());
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