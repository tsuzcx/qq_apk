package com.tencent.mm.media.e;

import com.tencent.f.e.a;
import com.tencent.f.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a ifC;
  public final int bufId;
  public int frameCount;
  private final int height;
  private int ifA;
  public boolean ifB;
  public f<?> ifx;
  public final MMHandler ify;
  public boolean ifz;
  public boolean isStop;
  public long startTime;
  public final Object stopLock;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    ifC = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.bufId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.ify = new MMHandler("X264TransEncoder_writeDataThread");
    this.stopLock = new Object();
    Log.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.ifz = false;
    this.frameCount = 0;
    this.startTime = Util.currentTicks();
    SightVideoJNI.setRotateForBufId(this.bufId, 0);
    this.ifx = f.hmn().hms().c((a)new b(this));
    this.ifB = false;
    Log.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    Log.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = Util.currentTicks();
    synchronized (this.stopLock)
    {
      this.isStop = true;
      this.ifz = paramBoolean;
      this.ify.quit();
      Object localObject2 = this.ifx;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      Log.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + Util.ticksToNow(l) + "ms");
      localObject2 = x.SXb;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(g paramg) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((g.c(this.ifD)) || (g.d(this.ifD)))
      {
        Log.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = Util.currentTicks();
      Object localObject = k.zwi.h(Integer.valueOf(this.ifE * this.ifF * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.ifG, (byte[])localObject, this.ifE, this.ifF);
      Log.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + Util.ticksToNow(l) + "ms");
      l = Util.currentTicks();
      SightVideoJNI.writeYuvDataForMMSight(g.e(this.ifD), (byte[])localObject, localObject.length, this.ifE, this.ifF, false, false, this.ifE, this.ifF);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.ifE).append(", ").append(this.ifF).append(" cost ").append(Util.ticksToNow(l)).append("ms, ");
      g localg = this.ifD;
      int i = g.f(localg);
      g.a(localg, i + 1);
      Log.i("MicroMsg.X264TransEncoder", i);
      k.zwi.k((byte[])localObject);
      if (!g.g(this.ifD))
      {
        localObject = g.i(this.ifD);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        g.h(this.ifD);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.e.g
 * JD-Core Version:    0.7.0.1
 */