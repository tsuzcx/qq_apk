package com.tencent.mm.media.e;

import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a hjS;
  public final int bufId;
  public int frameCount;
  private final int height;
  private f<?> hjN;
  public final ap hjO;
  private boolean hjP;
  private int hjQ;
  private boolean hjR;
  private boolean isStop;
  public long startTime;
  public final Object stopLock;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    hjS = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.bufId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.hjO = new ap("X264TransEncoder_writeDataThread");
    this.stopLock = new Object();
    ad.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void a(Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93662);
    p.h(paramBuffer, "data");
    if (this.bufId < 0)
    {
      ad.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
      AppMethodBeat.o(93662);
      return;
    }
    synchronized (this.stopLock)
    {
      if ((this.isStop) || (this.hjP))
      {
        ad.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93662);
        return;
      }
      long l = bt.HI();
      SightVideoJNI.writeRGBDataForMMSight(this.bufId, paramBuffer, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
      paramBuffer = new StringBuilder("writeRGBData ").append(paramInt1).append(", ").append(paramInt2).append(" cost ").append(bt.aO(l)).append("ms, ");
      paramInt1 = this.frameCount;
      this.frameCount = (paramInt1 + 1);
      ad.i("MicroMsg.X264TransEncoder", paramInt1);
      if (!this.hjR)
      {
        paramBuffer = this.hjN;
        if (paramBuffer != null) {
          paramBuffer.begin();
        }
        this.hjR = true;
      }
      paramBuffer = z.MKo;
      AppMethodBeat.o(93662);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.hjP = false;
    this.frameCount = 0;
    this.startTime = bt.HI();
    SightVideoJNI.setRotateForBufId(this.bufId, 0);
    this.hjN = f.fVD().fVI().c((a)new b(this));
    this.hjR = false;
    ad.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    ad.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = bt.HI();
    synchronized (this.stopLock)
    {
      this.isStop = true;
      this.hjP = paramBoolean;
      this.hjO.quit();
      Object localObject2 = this.hjN;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      ad.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bt.aO(l) + "ms");
      localObject2 = z.MKo;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(g paramg) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((g.c(this.hjT)) || (g.d(this.hjT)))
      {
        ad.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = bt.HI();
      Object localObject = k.vQc.g(Integer.valueOf(this.hjU * this.hjV * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.hjW, (byte[])localObject, this.hjU, this.hjV);
      ad.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bt.aO(l) + "ms");
      l = bt.HI();
      SightVideoJNI.writeYuvDataForMMSight(g.e(this.hjT), (byte[])localObject, localObject.length, this.hjU, this.hjV, false, false, this.hjU, this.hjV);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.hjU).append(", ").append(this.hjV).append(" cost ").append(bt.aO(l)).append("ms, ");
      g localg = this.hjT;
      int i = g.f(localg);
      g.a(localg, i + 1);
      ad.i("MicroMsg.X264TransEncoder", i);
      k.vQc.k((byte[])localObject);
      if (!g.g(this.hjT))
      {
        localObject = g.i(this.hjT);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        g.h(this.hjT);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.g
 * JD-Core Version:    0.7.0.1
 */