package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils.b;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b
{
  final String TAG;
  private HandlerThread nxt;
  private Handler nzQ;
  private a nzR;
  aa nzs;
  private long startTime;
  
  public f(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, ah> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93658);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject2 = aa.Dx(paramd.name);
    s.s(localObject2, "createByCodecName(videoCodecConfig.name)");
    this.nzs = ((aa)localObject2);
    localObject2 = com.tencent.threadpool.c.d.jx("MediaCodecTransEncoder_encodeThread", 5);
    s.s(localObject2, "createMediaCodecThread(\"…ad\",Thread.NORM_PRIORITY)");
    this.nxt = ((HandlerThread)localObject2);
    this.nzR = new a(this);
    Log.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject2 = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.brA();
    localObject2 = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.brk();
    this.nzs.a(paramd.boH(), null, 1);
    if ((MMApplicationContext.isMainProcess()) && (s.p(h.baE().ban().get(at.a.acOG, Integer.valueOf(-1)), Integer.valueOf(1))))
    {
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = new IllegalStateException("leex test error");
      AppMethodBeat.o(93658);
      throw paramd;
    }
    Log.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramd = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.brl();
    if (com.tencent.mm.compatible.util.d.rb(23))
    {
      this.nxt.start();
      this.nzQ = new Handler(this.nxt.getLooper());
      localObject2 = this.nzs;
      MediaCodec.Callback localCallback = (MediaCodec.Callback)this.nzR;
      paramd = this.nzQ;
      if (paramd == null)
      {
        s.bIx("encodeHandler");
        paramd = localObject1;
        ((aa)localObject2).setCallback(localCallback, paramd);
      }
    }
    for (;;)
    {
      paramd = this.nzs.createInputSurface();
      s.s(paramd, "encoder.createInputSurface()");
      l(paramd);
      this.nzs.start();
      paramb.invoke(this);
      AppMethodBeat.o(93658);
      return;
      break;
      this.nzs.setCallback((MediaCodec.Callback)this.nzR);
    }
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(236970);
    s.u(paramf, "this$0");
    synchronized (paramf.bpg())
    {
      if ((paramf.bpc()) || (paramf.bpe()) || (0L == paramf.startTime))
      {
        Log.i(paramf.TAG, "finishEncode() already finish " + paramf.hashCode() + ", isFinishEncode:" + paramf.bpc() + ", isRelease:" + paramf.bpe() + ", startTime:" + paramf.startTime);
        AppMethodBeat.o(236970);
        return;
      }
      ah localah = ah.aiuX;
      Log.i(paramf.TAG, "finishEncode() hash:" + paramf.hashCode() + "  isFinishEncode:" + paramf.bpc() + "  startTime:" + paramf.startTime);
      paramf.nzs.signalEndOfInputStream();
      paramf.bpd();
      AppMethodBeat.o(236970);
      return;
    }
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(236975);
    s.u(paramf, "this$0");
    synchronized (paramf.bpg())
    {
      if (paramf.bpe())
      {
        Log.i(paramf.TAG, s.X("releaseEncoder(), already finished ", Integer.valueOf(paramf.hashCode())));
        AppMethodBeat.o(236975);
        return;
      }
      ah localah = ah.aiuX;
      long l = Util.currentTicks();
      Log.i(paramf.TAG, s.X("releaseEncoder() start ", Integer.valueOf(paramf.hashCode())));
      ??? = paramf.nzz;
      if (??? != null) {
        ((a)???).invoke();
      }
      paramf.nxt.quitSafely();
      paramf.nzs.stop();
      paramf.nzs.release();
      paramf.bpb().release();
      paramf.bpf();
      ??? = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brB();
      Log.i(paramf.TAG, "releaseEncoder() finish: time:" + Util.ticksToNow(l) + ", " + paramf.hashCode());
      AppMethodBeat.o(236975);
      return;
    }
  }
  
  public final void boZ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(93655);
    try
    {
      Handler localHandler = this.nzQ;
      Object localObject1 = localHandler;
      if (localHandler == null)
      {
        s.bIx("encodeHandler");
        localObject1 = null;
      }
      ((Handler)localObject1).removeCallbacksAndMessages(null);
      localObject1 = this.nzQ;
      if (localObject1 == null)
      {
        s.bIx("encodeHandler");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((Handler)localObject1).post(new f..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(93655);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93655);
    }
  }
  
  public final void bpa()
  {
    AppMethodBeat.i(93656);
    try
    {
      Handler localHandler2 = this.nzQ;
      Handler localHandler1 = localHandler2;
      if (localHandler2 == null)
      {
        s.bIx("encodeHandler");
        localHandler1 = null;
      }
      localHandler1.post(new f..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(93656);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, s.X("release encoder error ", localException.getMessage()));
      AppMethodBeat.o(93656);
    }
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(93654);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    AppMethodBeat.o(93654);
  }
  
  public final long bpj()
  {
    AppMethodBeat.i(93657);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93657);
    return l1 - l2;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends MediaCodec.Callback
  {
    a(f paramf) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93651);
      s.u(paramMediaCodec, "codec");
      s.u(paramCodecException, "e");
      Log.e(this.nzS.TAG, s.X("codec Error, e:", paramCodecException));
      if (this.nzS.nyT)
      {
        paramMediaCodec = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bsa();
      }
      this.nzS.bpa();
      AppMethodBeat.o(93651);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93649);
      s.u(paramMediaCodec, "codec");
      Log.i(this.nzS.TAG, s.X("onInputBufferAvailable, index:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(93649);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93648);
      s.u(paramMediaCodec, "codec");
      s.u(paramBufferInfo, "bufferInfo");
      Log.d(this.nzS.TAG, "onOutputBufferAvailable index:" + paramInt + ", info.size: " + paramBufferInfo.size);
      if (paramInt >= 0) {
        try
        {
          paramMediaCodec = this.nzS.nzs.getOutputBuffer(paramInt);
          if ((paramBufferInfo.flags & 0x2) != 0) {
            Log.i(this.nzS.TAG, "codec config!");
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            Log.i(this.nzS.TAG, "encode end of stream");
            this.nzS.bpa();
            AppMethodBeat.o(93648);
            return;
          }
          long l;
          if (paramBufferInfo.size != 0)
          {
            paramMediaCodec.position(paramBufferInfo.offset);
            paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
            f localf = this.nzS;
            s.s(paramMediaCodec, "outputBuffer");
            localf.f(paramMediaCodec, paramBufferInfo);
            paramMediaCodec = this.nzS.nzs;
            l = paramBufferInfo.presentationTimeUs;
          }
          this.nzS.nzs.releaseOutputBuffer(paramInt, false);
        }
        catch (Exception paramMediaCodec)
        {
          try
          {
            if (!paramMediaCodec.fez)
            {
              Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
              Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
            }
            MediaCodecProxyUtils.b.qY(114);
            paramMediaCodec.lXj.releaseOutputBuffer(paramInt, l);
            MediaCodecProxyUtils.b.qY(115);
            AppMethodBeat.o(93648);
            return;
          }
          catch (Exception paramBufferInfo)
          {
            Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy releaseOutputBuffer 2, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
            aa.a(45, paramBufferInfo, paramMediaCodec.lXk);
            AppMethodBeat.o(93648);
            throw paramBufferInfo;
          }
          paramMediaCodec = paramMediaCodec;
          Log.printErrStackTrace(this.nzS.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
          if (this.nzS.nyT)
          {
            paramMediaCodec = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.brZ();
          }
          AppMethodBeat.o(93648);
          return;
        }
      }
      AppMethodBeat.o(93648);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93650);
      s.u(paramMediaCodec, "codec");
      s.u(paramMediaFormat, "format");
      Log.i(this.nzS.TAG, s.X("encoder output format changed ", this.nzS.nzs.getOutputFormat()));
      AppMethodBeat.o(93650);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.f
 * JD-Core Version:    0.7.0.1
 */