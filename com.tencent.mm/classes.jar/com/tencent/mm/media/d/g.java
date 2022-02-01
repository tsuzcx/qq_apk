package com.tencent.mm.media.d;

import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a gqS;
  public int frameCount;
  public final int gmW;
  private f<?> gqN;
  public final ap gqO;
  private boolean gqP;
  private int gqQ;
  private boolean gqR;
  private final int height;
  private boolean isStop;
  public long startTime;
  public final Object stopLock;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    gqS = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.gmW = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.gqO = new ap("X264TransEncoder_writeDataThread");
    this.stopLock = new Object();
    ad.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void a(Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93662);
    k.h(paramBuffer, "data");
    if (this.gmW < 0)
    {
      ad.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
      AppMethodBeat.o(93662);
      return;
    }
    synchronized (this.stopLock)
    {
      if ((this.isStop) || (this.gqP))
      {
        ad.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93662);
        return;
      }
      long l = bt.GC();
      SightVideoJNI.writeRGBDataForMMSight(this.gmW, paramBuffer, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
      paramBuffer = new StringBuilder("writeRGBData ").append(paramInt1).append(", ").append(paramInt2).append(" cost ").append(bt.aS(l)).append("ms, ");
      paramInt1 = this.frameCount;
      this.frameCount = (paramInt1 + 1);
      ad.i("MicroMsg.X264TransEncoder", paramInt1);
      if (!this.gqR)
      {
        paramBuffer = this.gqN;
        if (paramBuffer != null) {
          paramBuffer.begin();
        }
        this.gqR = true;
      }
      paramBuffer = y.JfV;
      AppMethodBeat.o(93662);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.gqP = false;
    this.frameCount = 0;
    this.startTime = bt.GC();
    SightVideoJNI.setRotateForBufId(this.gmW, 0);
    this.gqN = f.fnV().foa().c((a)new b(this));
    this.gqR = false;
    ad.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    ad.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = bt.GC();
    synchronized (this.stopLock)
    {
      this.isStop = true;
      this.gqP = paramBoolean;
      this.gqO.quit();
      Object localObject2 = this.gqN;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      ad.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bt.aS(l) + "ms");
      localObject2 = y.JfV;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(g paramg) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((g.c(this.gqT)) || (g.d(this.gqT)))
      {
        ad.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = bt.GC();
      Object localObject = j.tEA.g(Integer.valueOf(this.gqU * this.gqV * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.gqW, (byte[])localObject, this.gqU, this.gqV);
      ad.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bt.aS(l) + "ms");
      l = bt.GC();
      SightVideoJNI.writeYuvDataForMMSight(g.e(this.gqT), (byte[])localObject, localObject.length, this.gqU, this.gqV, false, false, this.gqU, this.gqV);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.gqU).append(", ").append(this.gqV).append(" cost ").append(bt.aS(l)).append("ms, ");
      g localg = this.gqT;
      int i = g.f(localg);
      g.a(localg, i + 1);
      ad.i("MicroMsg.X264TransEncoder", i);
      j.tEA.k((byte[])localObject);
      if (!g.g(this.gqT))
      {
        localObject = g.i(this.gqT);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        g.h(this.gqT);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */