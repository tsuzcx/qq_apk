package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e
  extends b
{
  public static final e.a ifs;
  private final String TAG;
  private final MediaCodec.BufferInfo bufferInfo;
  private HandlerThread ide;
  private MMHandler idf;
  private z ieT;
  private final long ifq;
  private boolean ifr;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(93646);
    ifs = new e.a((byte)0);
    AppMethodBeat.o(93646);
  }
  
  public e(com.tencent.mm.media.b.d paramd, kotlin.g.a.b<? super b, x> paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(218732);
    this.TAG = "MicroMsg.MediaCodecTransEncoder";
    this.ifq = 50000L;
    this.bufferInfo = new MediaCodec.BufferInfo();
    Object localObject = com.tencent.f.c.d.hB("MediaCodecTransEncoder_encodeThread", 0);
    p.g(localObject, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
    this.ide = ((HandlerThread)localObject);
    localObject = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aOm();
    Log.i(this.TAG, "create mp4encoder " + hashCode());
    localObject = z.Eb(paramd.name);
    p.g(localObject, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
    this.ieT = ((z)localObject);
    this.ieT.a(paramd.aLU(), null, 1);
    if (MMApplicationContext.isMainProcess())
    {
      paramd = g.aAh();
      p.g(paramd, "MMKernel.storage()");
      if (p.j(paramd.azQ().get(ar.a.NZm, Integer.valueOf(-1)), Integer.valueOf(1)))
      {
        Toast.makeText(MMApplicationContext.getContext(), (CharSequence)"remuxer 抛出异常", 0).show();
        paramd = (Throwable)new IllegalStateException("leex test error");
        AppMethodBeat.o(218732);
        throw paramd;
      }
    }
    paramd = this.ieT.createInputSurface();
    p.g(paramd, "encoder.createInputSurface()");
    g(paramd);
    this.ieT.start();
    this.ide.start();
    this.idf = new MMHandler(this.ide.getLooper());
    Log.i(this.TAG, "create mp4encoder finish " + hashCode());
    paramb.invoke(this);
    AppMethodBeat.o(218732);
  }
  
  public final void aMi()
  {
    AppMethodBeat.i(93641);
    if (this.ifr)
    {
      Log.e(this.TAG, "has received eos");
      AppMethodBeat.o(93641);
      return;
    }
    this.idf.removeCallbacksAndMessages(null);
    this.idf.post((Runnable)new c(this));
    AppMethodBeat.o(93641);
  }
  
  public final void aMj()
  {
    AppMethodBeat.i(93642);
    Log.i(this.TAG, "try to release " + hashCode());
    this.idf.post((Runnable)new d(this));
    AppMethodBeat.o(93642);
  }
  
  public final void aMl()
  {
    AppMethodBeat.i(93640);
    if (0L == this.startTime) {
      this.startTime = Util.currentTicks();
    }
    this.idf.post((Runnable)new b(this));
    AppMethodBeat.o(93640);
  }
  
  public final long aMm()
  {
    AppMethodBeat.i(93644);
    long l1 = Util.currentTicks();
    long l2 = this.startTime;
    AppMethodBeat.o(93644);
    return l1 - l2;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93643);
    Log.i(this.TAG, "finalize");
    if (!this.ife) {
      this.ieT.release();
    }
    AppMethodBeat.o(93643);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93637);
      long l = Util.currentTicks();
      synchronized (this.ift.iff)
      {
        if ((this.ift.ife) || (this.ift.ifd))
        {
          Log.i(e.a(this.ift), "encodeFrame() stop encodeFrame " + this.ift.hashCode() + ", isRelease:" + this.ift.ife + ", isFinishEncode:" + this.ift.ifd);
          AppMethodBeat.o(93637);
          return;
        }
        x localx = x.SXb;
        e.b(this.ift);
        Log.d(e.a(this.ift), " drainEncoder cost " + Util.ticksToNow(l) + "  " + this.ift.hashCode());
        AppMethodBeat.o(93637);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93638);
      synchronized (this.ift.iff)
      {
        if ((this.ift.ifd) || (this.ift.ife) || (0L == e.c(this.ift)))
        {
          Log.i(e.a(this.ift), "finishEncode() already finish " + this.ift.hashCode() + ", isFinishEncode:" + this.ift.ifd + ", isRelease:" + this.ift.ife + ", startTime:" + e.c(this.ift));
          AppMethodBeat.o(93638);
          return;
        }
        x localx = x.SXb;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(93639);
      long l;
      synchronized (this.ift.iff)
      {
        if (this.ift.ife)
        {
          Log.i(e.a(this.ift), "releaseEncoder(), already finished " + this.ift.hashCode());
          AppMethodBeat.o(93639);
          return;
        }
        x localx = x.SXb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.e.e
 * JD-Core Version:    0.7.0.1
 */