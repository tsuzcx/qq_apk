package com.tencent.mm.media.d;

import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a gRA;
  public int frameCount;
  public final int gNJ;
  private f<?> gRv;
  public final ao gRw;
  private boolean gRx;
  private int gRy;
  private boolean gRz;
  private final int height;
  private boolean isStop;
  public long startTime;
  public final Object stopLock;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    gRA = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.gNJ = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.gRw = new ao("X264TransEncoder_writeDataThread");
    this.stopLock = new Object();
    ac.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void a(Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93662);
    k.h(paramBuffer, "data");
    if (this.gNJ < 0)
    {
      ac.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
      AppMethodBeat.o(93662);
      return;
    }
    synchronized (this.stopLock)
    {
      if ((this.isStop) || (this.gRx))
      {
        ac.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93662);
        return;
      }
      long l = bs.Gn();
      SightVideoJNI.writeRGBDataForMMSight(this.gNJ, paramBuffer, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
      paramBuffer = new StringBuilder("writeRGBData ").append(paramInt1).append(", ").append(paramInt2).append(" cost ").append(bs.aO(l)).append("ms, ");
      paramInt1 = this.frameCount;
      this.frameCount = (paramInt1 + 1);
      ac.i("MicroMsg.X264TransEncoder", paramInt1);
      if (!this.gRz)
      {
        paramBuffer = this.gRv;
        if (paramBuffer != null) {
          paramBuffer.begin();
        }
        this.gRz = true;
      }
      paramBuffer = y.KTp;
      AppMethodBeat.o(93662);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.gRx = false;
    this.frameCount = 0;
    this.startTime = bs.Gn();
    SightVideoJNI.setRotateForBufId(this.gNJ, 0);
    this.gRv = f.fEl().fEq().c((a)new b(this));
    this.gRz = false;
    ac.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    ac.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = bs.Gn();
    synchronized (this.stopLock)
    {
      this.isStop = true;
      this.gRx = paramBoolean;
      this.gRw.quit();
      Object localObject2 = this.gRv;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      ac.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bs.aO(l) + "ms");
      localObject2 = y.KTp;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(g paramg) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((g.c(this.gRB)) || (g.d(this.gRB)))
      {
        ac.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = bs.Gn();
      Object localObject = j.uMV.g(Integer.valueOf(this.gRC * this.gRD * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.gRE, (byte[])localObject, this.gRC, this.gRD);
      ac.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + bs.aO(l) + "ms");
      l = bs.Gn();
      SightVideoJNI.writeYuvDataForMMSight(g.e(this.gRB), (byte[])localObject, localObject.length, this.gRC, this.gRD, false, false, this.gRC, this.gRD);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.gRC).append(", ").append(this.gRD).append(" cost ").append(bs.aO(l)).append("ms, ");
      g localg = this.gRB;
      int i = g.f(localg);
      g.a(localg, i + 1);
      ac.i("MicroMsg.X264TransEncoder", i);
      j.uMV.k((byte[])localObject);
      if (!g.g(this.gRB))
      {
        localObject = g.i(this.gRB);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        g.h(this.gRB);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */