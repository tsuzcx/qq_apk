package com.tencent.mm.media.e;

import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class h
{
  public static final h.a kUq;
  public final Object aFF;
  public final int bufId;
  public int frameCount;
  private final int height;
  public boolean isStop;
  public f<?> kUl;
  public final MMHandler kUm;
  public boolean kUn;
  private int kUo;
  public boolean kUp;
  public long startTime;
  private final int width;
  
  static
  {
    AppMethodBeat.i(93666);
    kUq = new h.a((byte)0);
    AppMethodBeat.o(93666);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93665);
    this.bufId = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.kUm = new MMHandler("X264TransEncoder_writeDataThread");
    this.aFF = new Object();
    Log.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(93665);
  }
  
  public final void start()
  {
    AppMethodBeat.i(93661);
    this.isStop = false;
    this.kUn = false;
    this.frameCount = 0;
    this.startTime = Util.currentTicks();
    SightVideoJNI.setRotateForBufId(this.bufId, 0);
    this.kUl = f.ipN().ipT().c((a)new b(this));
    this.kUp = false;
    Log.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(93661);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(93663);
    Log.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = Util.currentTicks();
    synchronized (this.aFF)
    {
      this.isStop = true;
      this.kUn = paramBoolean;
      this.kUm.quit();
      Object localObject2 = this.kUl;
      if (localObject2 != null) {
        ((f)localObject2).ipQ();
      }
      Log.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + Util.ticksToNow(l) + "ms");
      localObject2 = x.aazN;
      AppMethodBeat.o(93663);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  static final class b<I, O>
    implements a<E, R>
  {
    b(h paramh) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
  public static final class c
    implements Runnable
  {
    public c(h paramh, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(93660);
      if ((h.c(this.kUr)) || (h.d(this.kUr)))
      {
        Log.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
        AppMethodBeat.o(93660);
        return;
      }
      long l = Util.currentTicks();
      Object localObject = j.FbH.k(Integer.valueOf(this.kUs * this.kUt * 3 / 2));
      SightVideoJNI.rgbaToNV21(this.kUu, (byte[])localObject, this.kUs, this.kUt);
      Log.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + Util.ticksToNow(l) + "ms");
      l = Util.currentTicks();
      SightVideoJNI.writeYuvDataForMMSight(h.e(this.kUr), (byte[])localObject, localObject.length, this.kUs, this.kUt, false, false, this.kUs, this.kUt);
      StringBuilder localStringBuilder = new StringBuilder("writeRGBData ").append(this.kUs).append(", ").append(this.kUt).append(" cost ").append(Util.ticksToNow(l)).append("ms, ");
      h localh = this.kUr;
      int i = h.f(localh);
      h.a(localh, i + 1);
      Log.i("MicroMsg.X264TransEncoder", i);
      j.FbH.as((byte[])localObject);
      if (!h.g(this.kUr))
      {
        localObject = h.i(this.kUr);
        if (localObject != null) {
          ((f)localObject).begin();
        }
        h.h(this.kUr);
      }
      AppMethodBeat.o(93660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.h
 * JD-Core Version:    0.7.0.1
 */