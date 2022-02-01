package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a hjI;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread hhu;
  private ap hhv;
  private final long hjG;
  private boolean hjH;
  private com.tencent.mm.compatible.deviceinfo.z hjj;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    hjI = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, boolean paramBoolean, d.g.a.b<? super b, d.z> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93645);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.hjG = 10000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    if (paramBoolean) {}
    for (int i = -2;; i = 0)
    {
      Object localObject = com.tencent.e.c.d.gY("MediaCodecTransEncoder_encodeThread", i);
      p.g(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
      this.hhu = ((HandlerThread)localObject);
      localObject = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avk();
      ad.i(this.TAG, "create mp4encoder " + hashCode());
      localObject = com.tencent.mm.compatible.deviceinfo.z.vo(paramd.name);
      p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
      this.hjj = ((com.tencent.mm.compatible.deviceinfo.z)localObject);
      this.hjj.a(paramd.atf(), null, 1);
      if (!aj.cmR()) {
        break;
      }
      paramd = g.ajC();
      p.g(paramd, "MMKernel.storage()");
      if (!p.i(paramd.ajl().get(al.a.IwM, Integer.valueOf(-1)), Integer.valueOf(1))) {
        break;
      }
      Toast.makeText(aj.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = (Throwable)new IllegalStateException("leex test error");
      AppMethodBeat.o(93645);
      throw paramd;
    }
    paramd = this.hjj.createInputSurface();
    p.g(paramd, "encoder.createInputSurface()");
    g(paramd);
    this.hjj.start();
    this.hhu.start();
    this.hhv = new ap(this.hhu.getLooper());
    ad.i(this.TAG, "create mp4encoder finish " + hashCode());
    if (paramb != null)
    {
      paramb.invoke(this);
      AppMethodBeat.o(93645);
      return;
    }
    AppMethodBeat.o(93645);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(93641);
    if (this.hjH)
    {
      ad.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    try
    {
      this.hhv.removeCallbacksAndMessages(null);
      this.hhv.post((Runnable)new c(this));
      AppMethodBeat.o(93641);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93641);
    }
  }
  
  public final void att()
  {
    AppMethodBeat.i(93642);
    ad.i(this.TAG, "try to release " + hashCode());
    try
    {
      this.hhv.post((Runnable)new d(this));
      AppMethodBeat.o(93642);
      return;
    }
    catch (Exception localException)
    {
      ad.e(this.TAG, "release encoder error " + hashCode() + " \n " + localException.getMessage());
      AppMethodBeat.o(93642);
    }
  }
  
  public final void atv()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = bt.HI();
    }
    this.hhv.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long atw()
  {
    AppMethodBeat.i(93644);
    long l1 = bt.HI();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    ad.i(this.TAG, "finalize");
    if (!this.hju) {
      this.hjj.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = bt.HI();
      synchronized (this.hjJ.hjv)
      {
        if ((this.hjJ.hju) || (this.hjJ.hjt))
        {
          ad.i(e.a(this.hjJ), "encodeFrame() stop encodeFrame " + this.hjJ.hashCode() + ", isRelease:" + this.hjJ.hju + ", isFinishEncode:" + this.hjJ.hjt);
          AppMethodBeat.o(93637);
          return;
        }
        d.z localz = d.z.MKo;
        e.b(this.hjJ);
        ad.d(e.a(this.hjJ), " drainEncoder cost " + bt.aO(l) + "  " + this.hjJ.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.hjJ.hjv)
      {
        if ((this.hjJ.hjt) || (this.hjJ.hju) || (0L == e.c(this.hjJ)))
        {
          ad.i(e.a(this.hjJ), "finishEncode() already finish " + this.hjJ.hashCode() + ", isFinishEncode:" + this.hjJ.hjt + ", isRelease:" + this.hjJ.hju + ", startTime:" + e.c(this.hjJ));
          AppMethodBeat.o(93638);
          return;
        }
        d.z localz = d.z.MKo;
        ad.i(e.a(this.hjJ), "finishEncode() hash:" + this.hjJ.hashCode() + "  isFinishEncode:" + this.hjJ.hjt + "  startTime:" + e.c(this.hjJ));
        e.d(this.hjJ).signalEndOfInputStream();
        this.hjJ.hjt = true;
        e.b(this.hjJ);
        AppMethodBeat.o(93638);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      synchronized (this.hjJ.hjv)
      {
        if (this.hjJ.hju)
        {
          ad.i(e.a(this.hjJ), "releaseEncoder(), already finished " + this.hjJ.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        d.z localz = d.z.MKo;
        long l = bt.HI();
        ad.i(e.a(this.hjJ), "releaseEncoder() start " + this.hjJ.hashCode());
        ??? = this.hjJ.hjs;
        if (??? != null) {
          ((a)???).invoke();
        }
        e.e(this.hjJ).removeCallbacksAndMessages(null);
        e.f(this.hjJ).quitSafely();
        e.d(this.hjJ).stop();
        e.d(this.hjJ).release();
        this.hjJ.atu().release();
        this.hjJ.hju = true;
        ??? = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avl();
        ad.i(e.a(this.hjJ), "releaseEncoder() finish: time:" + bt.aO(l) + ", " + this.hjJ.hashCode());
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