package com.tencent.mm.media.d;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodeThread", "Ljava/lang/Thread;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g
{
  public static final g.a eUM;
  public final Object eRH;
  public final int eRm;
  public Thread eUH;
  public final al eUI;
  public boolean eUJ;
  private int eUK;
  public boolean eUL;
  public int frameCount;
  private final int height;
  public boolean isStop;
  public long startTime;
  private final int width;
  
  static
  {
    AppMethodBeat.i(12968);
    eUM = new g.a((byte)0);
    AppMethodBeat.o(12968);
  }
  
  public g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12967);
    this.eRm = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.eUI = new al("X264TransEncoder_writeDataThread");
    this.eRH = new Object();
    ab.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
    AppMethodBeat.o(12967);
  }
  
  public final void start()
  {
    AppMethodBeat.i(155524);
    this.isStop = false;
    this.eUJ = false;
    this.frameCount = 0;
    this.startTime = bo.yB();
    SightVideoJNI.setRotateForBufId(this.eRm, 0);
    this.eUH = d.h((Runnable)new g.b(this), "X264TransEncoder_encodeThread");
    this.eUL = false;
    ab.i("MicroMsg.X264TransEncoder", "start");
    AppMethodBeat.o(155524);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(12966);
    ab.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(paramBoolean)));
    long l = bo.yB();
    synchronized (this.eRH)
    {
      this.isStop = true;
      this.eUJ = paramBoolean;
      this.eUI.quit();
      Object localObject2 = this.eUH;
      if (localObject2 != null) {
        ((Thread)localObject2).join();
      }
      ab.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + bo.av(l) + "ms");
      localObject2 = y.BMg;
      AppMethodBeat.o(12966);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */