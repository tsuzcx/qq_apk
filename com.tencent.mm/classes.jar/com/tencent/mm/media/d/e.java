package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a gqI;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread gmK;
  private ap gmL;
  private final long gqG;
  private boolean gqH;
  private z gqj;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    gqI = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, boolean paramBoolean, d.g.a.b<? super b, y> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93645);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.gqG = 10000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    if (paramBoolean) {}
    for (int i = -2;; i = 0)
    {
      Object localObject = com.tencent.e.c.d.gw("MediaCodecTransEncoder_encodeThread", i);
      k.g(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
      this.gmK = ((HandlerThread)localObject);
      localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.alD();
      ad.i(this.TAG, "create mp4encoder " + hashCode());
      localObject = z.pn(paramd.name);
      k.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
      this.gqj = ((z)localObject);
      this.gqj.a(paramd.ajq(), null, 1);
      if (!aj.cbe()) {
        break;
      }
      paramd = g.afB();
      k.g(paramd, "MMKernel.storage()");
      if (!k.g(paramd.afk().get(ae.a.FmF, Integer.valueOf(-1)), Integer.valueOf(1))) {
        break;
      }
      Toast.makeText(aj.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = (Throwable)new IllegalStateException("leex test error");
      AppMethodBeat.o(93645);
      throw paramd;
    }
    paramd = this.gqj.createInputSurface();
    k.g(paramd, "encoder.createInputSurface()");
    h(paramd);
    this.gqj.start();
    this.gmK.start();
    this.gmL = new ap(this.gmK.getLooper());
    ad.i(this.TAG, "create mp4encoder finish " + hashCode());
    if (paramb != null)
    {
      paramb.aA(this);
      AppMethodBeat.o(93645);
      return;
    }
    AppMethodBeat.o(93645);
  }
  
  public final void ajF()
  {
    AppMethodBeat.i(93641);
    if (this.gqH)
    {
      ad.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    try
    {
      this.gmL.removeCallbacksAndMessages(null);
      this.gmL.post((Runnable)new c(this));
      AppMethodBeat.o(93641);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93641);
    }
  }
  
  public final void ajG()
  {
    AppMethodBeat.i(93642);
    ad.i(this.TAG, "try to release " + hashCode());
    try
    {
      this.gmL.post((Runnable)new d(this));
      AppMethodBeat.o(93642);
      return;
    }
    catch (Exception localException)
    {
      ad.e(this.TAG, "release encoder error " + hashCode() + " \n " + localException.getMessage());
      AppMethodBeat.o(93642);
    }
  }
  
  public final void ajI()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = bt.GC();
    }
    this.gmL.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long ajJ()
  {
    AppMethodBeat.i(93644);
    long l1 = bt.GC();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    ad.i(this.TAG, "finalize");
    if (!this.gqu) {
      this.gqj.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = bt.GC();
      synchronized (this.gqJ.gqv)
      {
        if ((this.gqJ.gqu) || (this.gqJ.gqt))
        {
          ad.i(e.a(this.gqJ), "encodeFrame() stop encodeFrame " + this.gqJ.hashCode() + ", isRelease:" + this.gqJ.gqu + ", isFinishEncode:" + this.gqJ.gqt);
          AppMethodBeat.o(93637);
          return;
        }
        y localy = y.JfV;
        e.b(this.gqJ);
        ad.d(e.a(this.gqJ), " drainEncoder cost " + bt.aS(l) + "  " + this.gqJ.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.gqJ.gqv)
      {
        if ((this.gqJ.gqt) || (this.gqJ.gqu) || (0L == e.c(this.gqJ)))
        {
          ad.i(e.a(this.gqJ), "finishEncode() already finish " + this.gqJ.hashCode() + ", isFinishEncode:" + this.gqJ.gqt + ", isRelease:" + this.gqJ.gqu + ", startTime:" + e.c(this.gqJ));
          AppMethodBeat.o(93638);
          return;
        }
        y localy = y.JfV;
        ad.i(e.a(this.gqJ), "finishEncode() hash:" + this.gqJ.hashCode() + "  isFinishEncode:" + this.gqJ.gqt + "  startTime:" + e.c(this.gqJ));
        e.d(this.gqJ).signalEndOfInputStream();
        this.gqJ.gqt = true;
        e.b(this.gqJ);
        AppMethodBeat.o(93638);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      synchronized (this.gqJ.gqv)
      {
        if (this.gqJ.gqu)
        {
          ad.i(e.a(this.gqJ), "releaseEncoder(), already finished " + this.gqJ.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        y localy = y.JfV;
        long l = bt.GC();
        ad.i(e.a(this.gqJ), "releaseEncoder() start " + this.gqJ.hashCode());
        ??? = this.gqJ.gqs;
        if (??? != null) {
          ((a)???).invoke();
        }
        e.e(this.gqJ).removeCallbacksAndMessages(null);
        e.f(this.gqJ).quitSafely();
        e.d(this.gqJ).stop();
        e.d(this.gqJ).release();
        this.gqJ.ajH().release();
        this.gqJ.gqu = true;
        ??? = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.alE();
        ad.i(e.a(this.gqJ), "releaseEncoder() finish: time:" + bt.aS(l) + ", " + this.gqJ.hashCode());
        AppMethodBeat.o(93639);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.e
 * JD-Core Version:    0.7.0.1
 */