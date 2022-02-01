package com.tencent.magicbrush.ui;

import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/EglSurfaceSwapLockerAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameTimeMillis", "", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
final class e
  extends a
  implements Runnable
{
  private final a.b eKA;
  private double eKF;
  
  public e(MBRuntime paramMBRuntime, c paramc)
  {
    super(paramMBRuntime, paramc);
    AppMethodBeat.i(229021);
    this.eKA = a.b.eKu;
    AppMethodBeat.o(229021);
  }
  
  public final a.b avR()
  {
    return this.eKA;
  }
  
  public final void onCreate() {}
  
  public final void onPause()
  {
    this.eKF = 0.0D;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(140222);
    this.eKq.post((Runnable)this);
    AppMethodBeat.o(140222);
  }
  
  public final void run()
  {
    AppMethodBeat.i(140223);
    if (this.Uz)
    {
      this.eKq.post((Runnable)this);
      if (this.eKF == 0.0D) {
        this.eKF = SystemClock.elapsedRealtime();
      }
      x(this.eKF);
      this.eKF = SystemClock.elapsedRealtime();
    }
    AppMethodBeat.o(140223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.ui.e
 * JD-Core Version:    0.7.0.1
 */