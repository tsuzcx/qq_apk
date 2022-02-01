package com.tencent.mm.media.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.e.e.a;
import com.tencent.threadpool.e.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a nzT;
  public final int bufId;
  public final Object cBq;
  public int frameCount;
  private final int height;
  public boolean isStop;
  public f<?> nzU;
  private final MMHandler nzV;
  public boolean nzW;
  private int nzX;
  public boolean nzY;
  public long startTime;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    nzT = new g.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.bufId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.nzV = new MMHandler("X264TransEncoder_writeDataThread");
    this.cBq = new Object();
    Log.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  private static final ah a(g paramg, e.a parama)
  {
    AppMethodBeat.i(236972);
    s.u(paramg, "this$0");
    for (;;)
    {
      if (!paramg.isStop)
      {
        l = Util.currentTicks();
        int i = SightVideoJNI.triggerEncode(paramg.bufId, Math.max(0, paramg.nzX), false);
        Log.i("MicroMsg.X264TransEncoder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramg.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        if (Math.abs(i - paramg.nzX) <= 5) {}
        try
        {
          Thread.sleep(100L);
          paramg.nzX = i;
        }
        catch (Exception parama)
        {
          for (;;)
          {
            Log.e("MicroMsg.X264TransEncoder", "thread sleep error");
          }
        }
      }
    }
    long l = Util.currentTicks();
    if (!paramg.nzW) {
      paramg.nzX = SightVideoJNI.triggerEncode(paramg.bufId, paramg.nzX, true);
    }
    Log.i("MicroMsg.X264TransEncoder", "end: trgger encode use %dms, curEncode index %d, markCancel %s, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramg.nzX), Boolean.valueOf(paramg.nzW), Long.valueOf(Thread.currentThread().getId()) });
    paramg = ah.aiuX;
    AppMethodBeat.o(236972);
    return paramg;
  }
  
  private static final void a(g paramg, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236977);
    s.u(paramg, "this$0");
    s.u(paramArrayOfInt, "$data");
    if ((paramg.isStop) || (paramg.nzW))
    {
      Log.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
      AppMethodBeat.o(236977);
      return;
    }
    long l = Util.currentTicks();
    byte[] arrayOfByte = j.KXq.m(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2));
    SightVideoJNI.rgbaToNV21(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    Log.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + Util.ticksToNow(l) + "ms");
    l = Util.currentTicks();
    SightVideoJNI.writeYuvDataForMMSight(paramg.bufId, arrayOfByte, arrayOfByte.length, paramInt1, paramInt2, false, false, paramInt1, paramInt2);
    paramArrayOfInt = new StringBuilder("writeRGBData ").append(paramInt1).append(", ").append(paramInt2).append(" cost ").append(Util.ticksToNow(l)).append("ms, ");
    paramInt1 = paramg.frameCount;
    paramg.frameCount = (paramInt1 + 1);
    Log.i("MicroMsg.X264TransEncoder", paramInt1);
    j.KXq.as(arrayOfByte);
    if (!paramg.nzY)
    {
      paramArrayOfInt = paramg.nzU;
      if (paramArrayOfInt != null) {
        paramArrayOfInt.begin();
      }
      paramg.nzY = true;
    }
    AppMethodBeat.o(236977);
  }
  
  public final void h(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237001);
    s.u(paramArrayOfInt, "data");
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
      AppMethodBeat.o(237001);
      return;
    }
    synchronized (this.cBq)
    {
      this.nzV.postToWorker(new g..ExternalSyntheticLambda1(this, paramInt1, paramInt2, paramArrayOfInt));
      AppMethodBeat.o(237001);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.nzW = false;
    this.frameCount = 0;
    this.startTime = Util.currentTicks();
    SightVideoJNI.setRotateForBufId(this.bufId, 0);
    this.nzU = f.jZh().jZn().c(new g..ExternalSyntheticLambda0(this));
    this.nzY = false;
    Log.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    Log.i("MicroMsg.X264TransEncoder", s.X("stop isCancel:", Boolean.valueOf(paramBoolean)));
    long l = Util.currentTicks();
    synchronized (this.cBq)
    {
      this.isStop = true;
      this.nzW = paramBoolean;
      this.nzV.quit();
      Object localObject2 = this.nzU;
      if (localObject2 != null) {
        ((f)localObject2).jZk();
      }
      Log.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + Util.ticksToNow(l) + "ms");
      localObject2 = ah.aiuX;
      AppMethodBeat.o(93663);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.g
 * JD-Core Version:    0.7.0.1
 */