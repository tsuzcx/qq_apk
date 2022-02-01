package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  public static final a kUg;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread kRL;
  private MMHandler kRM;
  private aa kTH;
  private final long kUe;
  private boolean kUf;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    kUg = new a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public f(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(258126);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.kUe = 50000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    Object localObject = com.tencent.e.c.d.il("MediaCodecTransEncoder_encodeThread", 0);
    p.j(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
    this.kRL = ((HandlerThread)localObject);
    localObject = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aWQ();
    Log.i(this.TAG, "create mp4encoder " + hashCode());
    localObject = aa.KT(paramd.name);
    p.j(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.kTH = ((aa)localObject);
    this.kTH.a(paramd.aUd(), null, 1);
    if (MMApplicationContext.isMainProcess())
    {
      paramd = h.aHG();
      p.j(paramd, "MMKernel.storage()");
      if (p.h(paramd.aHp().get(ar.a.Vnm, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(258126);
        throw paramd;
      }
    }
    paramd = this.kTH.createInputSurface();
    p.j(paramd, "encoder.createInputSurface()");
    h(paramd);
    this.kTH.start();
    this.kRL.start();
    this.kRM = new MMHandler(this.kRL.getLooper());
    Log.i(this.TAG, "create mp4encoder finish " + hashCode());
    paramb.invoke(this);
    AppMethodBeat.o(258126);
  }
  
  public final void aUB()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    this.kRM.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long aUC()
  {
    AppMethodBeat.i(93644);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  public final void aUx()
  {
    AppMethodBeat.i(93641);
    if (this.kUf)
    {
      Log.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    this.kRM.removeCallbacksAndMessages(null);
    this.kRM.post((Runnable)new c(this));
    AppMethodBeat.o(93641);
  }
  
  public final void aUy()
  {
    AppMethodBeat.i(93642);
    Log.i(this.TAG, "try to release " + hashCode());
    this.kRM.post((Runnable)new d(this));
    AppMethodBeat.o(93642);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    Log.i(this.TAG, "finalize");
    if (!this.kTS) {
      this.kTH.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder$Companion;", "", "()V", "TIMEOUT", "", "plugin-mediaeditor_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = Util.currentTicks();
      synchronized (this.kUh.kTT)
      {
        if ((this.kUh.kTS) || (this.kUh.kTR))
        {
          Log.i(f.a(this.kUh), "encodeFrame() stop encodeFrame " + this.kUh.hashCode() + ", isRelease:" + this.kUh.kTS + ", isFinishEncode:" + this.kUh.kTR);
          AppMethodBeat.o(93637);
          return;
        }
        x localx = x.aazN;
        f.b(this.kUh);
        Log.d(f.a(this.kUh), " drainEncoder cost " + Util.ticksToNow(l) + "  " + this.kUh.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.kUh.kTT)
      {
        if ((this.kUh.kTR) || (this.kUh.kTS) || (0L == f.c(this.kUh)))
        {
          Log.i(f.a(this.kUh), "finishEncode() already finish " + this.kUh.hashCode() + ", isFinishEncode:" + this.kUh.kTR + ", isRelease:" + this.kUh.kTS + ", startTime:" + f.c(this.kUh));
          AppMethodBeat.o(93638);
          return;
        }
        x localx = x.aazN;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      long l;
      synchronized (this.kUh.kTT)
      {
        if (this.kUh.kTS)
        {
          Log.i(f.a(this.kUh), "releaseEncoder(), already finished " + this.kUh.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        x localx = x.aazN;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.e.f
 * JD-Core Version:    0.7.0.1
 */