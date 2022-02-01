package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a gRq;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread gNx;
  private ao gNy;
  private z gQR;
  private final long gRo;
  private boolean gRp;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    gRq = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, boolean paramBoolean, d.g.a.b<? super b, y> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(93645);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.gRo = 10000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    if (paramBoolean) {}
    for (int i = -2;; i = 0)
    {
      Object localObject = com.tencent.e.c.d.gA("MediaCodecTransEncoder_encodeThread", i);
      k.g(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
      this.gNx = ((HandlerThread)localObject);
      localObject = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asx();
      ac.i(this.TAG, "create mp4encoder " + hashCode());
      localObject = z.sz(paramd.name);
      k.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
      this.gQR = ((z)localObject);
      this.gQR.a(paramd.aqq(), null, 1);
      if (!ai.cin()) {
        break;
      }
      paramd = g.agR();
      k.g(paramd, "MMKernel.storage()");
      if (!k.g(paramd.agA().get(ah.a.GKu, Integer.valueOf(-1)), Integer.valueOf(1))) {
        break;
      }
      Toast.makeText(ai.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
      paramd = (Throwable)new IllegalStateException("leex test error");
      AppMethodBeat.o(93645);
      throw paramd;
    }
    paramd = this.gQR.createInputSurface();
    k.g(paramd, "encoder.createInputSurface()");
    g(paramd);
    this.gQR.start();
    this.gNx.start();
    this.gNy = new ao(this.gNx.getLooper());
    ac.i(this.TAG, "create mp4encoder finish " + hashCode());
    if (paramb != null)
    {
      paramb.ay(this);
      AppMethodBeat.o(93645);
      return;
    }
    AppMethodBeat.o(93645);
  }
  
  public final void aqE()
  {
    AppMethodBeat.i(93641);
    if (this.gRp)
    {
      ac.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    try
    {
      this.gNy.removeCallbacksAndMessages(null);
      this.gNy.post((Runnable)new c(this));
      AppMethodBeat.o(93641);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(93641);
    }
  }
  
  public final void aqF()
  {
    AppMethodBeat.i(93642);
    ac.i(this.TAG, "try to release " + hashCode());
    try
    {
      this.gNy.post((Runnable)new d(this));
      AppMethodBeat.o(93642);
      return;
    }
    catch (Exception localException)
    {
      ac.e(this.TAG, "release encoder error " + hashCode() + " \n " + localException.getMessage());
      AppMethodBeat.o(93642);
    }
  }
  
  public final void aqH()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = bs.Gn();
    }
    this.gNy.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long aqI()
  {
    AppMethodBeat.i(93644);
    long l1 = bs.Gn();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    ac.i(this.TAG, "finalize");
    if (!this.gRc) {
      this.gQR.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = bs.Gn();
      synchronized (this.gRr.gRd)
      {
        if ((this.gRr.gRc) || (this.gRr.gRb))
        {
          ac.i(e.a(this.gRr), "encodeFrame() stop encodeFrame " + this.gRr.hashCode() + ", isRelease:" + this.gRr.gRc + ", isFinishEncode:" + this.gRr.gRb);
          AppMethodBeat.o(93637);
          return;
        }
        y localy = y.KTp;
        e.b(this.gRr);
        ac.d(e.a(this.gRr), " drainEncoder cost " + bs.aO(l) + "  " + this.gRr.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.gRr.gRd)
      {
        if ((this.gRr.gRb) || (this.gRr.gRc) || (0L == e.c(this.gRr)))
        {
          ac.i(e.a(this.gRr), "finishEncode() already finish " + this.gRr.hashCode() + ", isFinishEncode:" + this.gRr.gRb + ", isRelease:" + this.gRr.gRc + ", startTime:" + e.c(this.gRr));
          AppMethodBeat.o(93638);
          return;
        }
        y localy = y.KTp;
        ac.i(e.a(this.gRr), "finishEncode() hash:" + this.gRr.hashCode() + "  isFinishEncode:" + this.gRr.gRb + "  startTime:" + e.c(this.gRr));
        e.d(this.gRr).signalEndOfInputStream();
        this.gRr.gRb = true;
        e.b(this.gRr);
        AppMethodBeat.o(93638);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      synchronized (this.gRr.gRd)
      {
        if (this.gRr.gRc)
        {
          ac.i(e.a(this.gRr), "releaseEncoder(), already finished " + this.gRr.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        y localy = y.KTp;
        long l = bs.Gn();
        ac.i(e.a(this.gRr), "releaseEncoder() start " + this.gRr.hashCode());
        ??? = this.gRr.gRa;
        if (??? != null) {
          ((a)???).invoke();
        }
        e.e(this.gRr).removeCallbacksAndMessages(null);
        e.f(this.gRr).quitSafely();
        e.d(this.gRr).stop();
        e.d(this.gRr).release();
        this.gRr.aqG().release();
        this.gRr.gRc = true;
        ??? = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asy();
        ac.i(e.a(this.gRr), "releaseEncoder() finish: time:" + bs.aO(l) + ", " + this.gRr.hashCode());
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