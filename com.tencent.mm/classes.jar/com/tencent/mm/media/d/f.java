package com.tencent.mm.media.d;

import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "isEnd", "", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "release", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  final String TAG;
  HandlerThread eRb;
  volatile boolean eRq;
  private Handler eUE;
  private f.a eUF;
  MediaCodec eUg;
  private long startTime;
  
  public f(com.tencent.mm.media.b.c paramc, a.f.a.b<? super b, y> paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(12963);
    this.TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    Object localObject = MediaCodec.createByCodecName(paramc.name);
    j.p(localObject, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
    this.eUg = ((MediaCodec)localObject);
    localObject = com.tencent.mm.sdk.g.d.aqu("MediaCodecTransEncoder_encodeThread");
    j.p(localObject, "ThreadPool.newFreeHandle…ansEncoder_encodeThread\")");
    this.eRb = ((HandlerThread)localObject);
    this.eUF = new f.a(this);
    ab.i(this.TAG, "MediaCodecTransEncoderAsync start");
    localObject = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.asj();
    this.eUg.configure(paramc.Ux(), null, null, 1);
    ab.i(this.TAG, "MediaCodecTransEncoderAsync end");
    paramc = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.ask();
    if (com.tencent.mm.compatible.util.d.fv(23))
    {
      this.eRb.start();
      this.eUE = new Handler(this.eRb.getLooper());
      paramc = this.eUg;
      localObject = (MediaCodec.Callback)this.eUF;
      Handler localHandler = this.eUE;
      if (localHandler == null) {
        j.ays("encodeHandler");
      }
      paramc.setCallback((MediaCodec.Callback)localObject, localHandler);
    }
    for (;;)
    {
      paramc = this.eUg.createInputSurface();
      j.p(paramc, "encoder.createInputSurface()");
      e(paramc);
      this.eUg.start();
      paramb.S((b)this);
      AppMethodBeat.o(12963);
      return;
      this.eUg.setCallback((MediaCodec.Callback)this.eUF);
    }
  }
  
  public final void UN()
  {
    AppMethodBeat.i(12960);
    Handler localHandler = this.eUE;
    if (localHandler == null) {
      j.ays("encodeHandler");
    }
    localHandler.post((Runnable)new f.b(this));
    AppMethodBeat.o(12960);
  }
  
  public final void UP()
  {
    AppMethodBeat.i(12959);
    if (0L == this.startTime) {
      this.startTime = bo.yB();
    }
    AppMethodBeat.o(12959);
  }
  
  public final long UQ()
  {
    AppMethodBeat.i(12962);
    long l1 = bo.yB();
    long l2 = this.startTime;
    AppMethodBeat.o(12962);
    return l1 - l2;
  }
  
  public final void release()
  {
    AppMethodBeat.i(12961);
    ab.i(this.TAG, "release");
    Handler localHandler = this.eUE;
    if (localHandler == null) {
      j.ays("encodeHandler");
    }
    localHandler.post((Runnable)new f.c(this));
    try
    {
      UO().release();
      AppMethodBeat.o(12961);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "codeSurface release error", new Object[0]);
      AppMethodBeat.o(12961);
    }
  }
  
  public final void releaseEncoder()
  {
    AppMethodBeat.i(156656);
    this.eRq = true;
    release();
    try
    {
      this.eUg.stop();
      this.eUg.release();
      this.eRq = true;
      AppMethodBeat.o(156656);
      return;
    }
    catch (Exception localException)
    {
      ab.e(this.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(156656);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */