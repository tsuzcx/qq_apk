package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a hmw;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread hki;
  private aq hkj;
  private com.tencent.mm.compatible.deviceinfo.z hlX;
  private final long hmu;
  private boolean hmv;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    hmw = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, boolean paramBoolean, d.g.a.b<? super b, d.z> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93645);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.hmu = 50000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    if (paramBoolean) {}
    for (int i = -2;; i = 0)
    {
      Object localObject = com.tencent.e.c.d.hh("MediaCodecTransEncoder_encodeThread", i);
      p.g(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
      this.hki = ((HandlerThread)localObject);
      localObject = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avz();
      ae.i(this.TAG, "create mp4encoder " + hashCode());
      localObject = com.tencent.mm.compatible.deviceinfo.z.vK(paramd.name);
      p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
      this.hlX = ((com.tencent.mm.compatible.deviceinfo.z)localObject);
      this.hlX.a(paramd.atu(), null, 1);
      if (!ak.coh()) {
        break;
      }
      paramd = g.ajR();
      p.g(paramd, "MMKernel.storage()");
      if (!p.i(paramd.ajA().get(am.a.IRk, Integer.valueOf(-1)), Integer.valueOf(1))) {
        break;
      }
      Toast.makeText(ak.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = (Throwable)new IllegalStateException("leex test error");
      AppMethodBeat.o(93645);
      throw paramd;
    }
    paramd = this.hlX.createInputSurface();
    p.g(paramd, "encoder.createInputSurface()");
    g(paramd);
    this.hlX.start();
    this.hki.start();
    this.hkj = new aq(this.hki.getLooper());
    ae.i(this.TAG, "create mp4encoder finish " + hashCode());
    if (paramb != null)
    {
      paramb.invoke(this);
      AppMethodBeat.o(93645);
      return;
    }
    AppMethodBeat.o(93645);
  }
  
  public final void atH()
  {
    AppMethodBeat.i(93641);
    if (this.hmv)
    {
      ae.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    try
    {
      this.hkj.removeCallbacksAndMessages(null);
      this.hkj.post((Runnable)new c(this));
      AppMethodBeat.o(93641);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93641);
    }
  }
  
  public final void atI()
  {
    AppMethodBeat.i(93642);
    ae.i(this.TAG, "try to release " + hashCode());
    try
    {
      this.hkj.post((Runnable)new d(this));
      AppMethodBeat.o(93642);
      return;
    }
    catch (Exception localException)
    {
      ae.e(this.TAG, "release encoder error " + hashCode() + " \n " + localException.getMessage());
      AppMethodBeat.o(93642);
    }
  }
  
  public final void atK()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = bu.HQ();
    }
    this.hkj.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long atL()
  {
    AppMethodBeat.i(93644);
    long l1 = bu.HQ();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    ae.i(this.TAG, "finalize");
    if (!this.hmi) {
      this.hlX.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = bu.HQ();
      synchronized (this.hmx.hmj)
      {
        if ((this.hmx.hmi) || (this.hmx.hmh))
        {
          ae.i(e.a(this.hmx), "encodeFrame() stop encodeFrame " + this.hmx.hashCode() + ", isRelease:" + this.hmx.hmi + ", isFinishEncode:" + this.hmx.hmh);
          AppMethodBeat.o(93637);
          return;
        }
        d.z localz = d.z.Nhr;
        e.b(this.hmx);
        ae.d(e.a(this.hmx), " drainEncoder cost " + bu.aO(l) + "  " + this.hmx.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.hmx.hmj)
      {
        if ((this.hmx.hmh) || (this.hmx.hmi) || (0L == e.c(this.hmx)))
        {
          ae.i(e.a(this.hmx), "finishEncode() already finish " + this.hmx.hashCode() + ", isFinishEncode:" + this.hmx.hmh + ", isRelease:" + this.hmx.hmi + ", startTime:" + e.c(this.hmx));
          AppMethodBeat.o(93638);
          return;
        }
        d.z localz = d.z.Nhr;
        ae.i(e.a(this.hmx), "finishEncode() hash:" + this.hmx.hashCode() + "  isFinishEncode:" + this.hmx.hmh + "  startTime:" + e.c(this.hmx));
        e.d(this.hmx).signalEndOfInputStream();
        this.hmx.hmh = true;
        e.b(this.hmx);
        AppMethodBeat.o(93638);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      synchronized (this.hmx.hmj)
      {
        if (this.hmx.hmi)
        {
          ae.i(e.a(this.hmx), "releaseEncoder(), already finished " + this.hmx.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        d.z localz = d.z.Nhr;
        long l = bu.HQ();
        ae.i(e.a(this.hmx), "releaseEncoder() start " + this.hmx.hashCode());
        ??? = this.hmx.hmg;
        if (??? != null) {
          ((a)???).invoke();
        }
        e.e(this.hmx).removeCallbacksAndMessages(null);
        e.f(this.hmx).quitSafely();
        e.d(this.hmx).stop();
        e.d(this.hmx).release();
        this.hmx.atJ().release();
        this.hmx.hmi = true;
        ??? = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avA();
        ae.i(e.a(this.hmx), "releaseEncoder() finish: time:" + bu.aO(l) + ", " + this.hmx.hashCode());
        AppMethodBeat.o(93639);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.e
 * JD-Core Version:    0.7.0.1
 */