package com.tencent.mm.media.e;

import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a hmG;
  public final int bufId;
  public int frameCount;
  private final int height;
  private f<?> hmB;
  public final aq hmC;
  private boolean hmD;
  private int hmE;
  private boolean hmF;
  private boolean isStop;
  public long startTime;
  public final Object stopLock;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    hmG = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.bufId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.hmC = new aq("X264TransEncoder_writeDataThread");
    this.stopLock = new Object();
    ae.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void a(Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93662);
    p.h(paramBuffer, "data");
    if (this.bufId < 0)
    {
      ae.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
      AppMethodBeat.o(93662);
      return;
    }
    synchronized (this.stopLock)
    {
      if ((this.isStop) || (this.hmD))
      {
        ae.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93662);
        return;
      }
      long l = bu.HQ();
      SightVideoJNI.writeRGBDataForMMSight(this.bufId, paramBuffer, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
      paramBuffer = new StringBuilder("writeRGBData ").append(paramInt1).append(", ").append(paramInt2).append(" cost ").append(bu.aO(l)).append("ms, ");
      paramInt1 = this.frameCount;
      this.frameCount = (paramInt1 + 1);
      ae.i("MicroMsg.X264TransEncoder", paramInt1);
      if (!this.hmF)
      {
        paramBuffer = this.hmB;
        if (paramBuffer != null) {
          paramBuffer.begin();
        }
        this.hmF = true;
      }
      paramBuffer = z.Nhr;
      AppMethodBeat.o(93662);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.hmD = false;
    this.frameCount = 0;
    this.startTime = bu.HQ();
    SightVideoJNI.setRotateForBufId(this.bufId, 0);
    this.hmB = f.gac().gah().c((a)new b(this));
    this.hmF = false;
    ae.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    ae.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = bu.HQ();
    synchronized (this.stopLock)
    {
      this.isStop = true;
      this.hmD = paramBoolean;
      this.hmC.quit();
      Object localObject2 = this.hmB;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      ae.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bu.aO(l) + "ms");
      localObject2 = z.Nhr;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(g paramg) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((g.c(this.hmH)) || (g.d(this.hmH)))
      {
        ae.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = bu.HQ();
      Object localObject = k.wcg.h(Integer.valueOf(this.hmI * this.hmJ * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.hmK, (byte[])localObject, this.hmI, this.hmJ);
      ae.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bu.aO(l) + "ms");
      l = bu.HQ();
      SightVideoJNI.writeYuvDataForMMSight(g.e(this.hmH), (byte[])localObject, localObject.length, this.hmI, this.hmJ, false, false, this.hmI, this.hmJ);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.hmI).append(", ").append(this.hmJ).append(" cost ").append(bu.aO(l)).append("ms, ");
      g localg = this.hmH;
      int i = g.f(localg);
      g.a(localg, i + 1);
      ae.i("MicroMsg.X264TransEncoder", i);
      k.wcg.k((byte[])localObject);
      if (!g.g(this.hmH))
      {
        localObject = g.i(this.hmH);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        g.h(this.hmH);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.g
 * JD-Core Version:    0.7.0.1
 */