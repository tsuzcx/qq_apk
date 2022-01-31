package com.tencent.kinda.framework.app;

import android.os.Looper;
import com.tencent.kinda.gen.KTimerService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class KindaTimerService
  implements KTimerService
{
  private static final String TAG = "KindaTimerService";
  private float interval;
  private boolean needThrottle;
  private ap throttleTimerHandler;
  private VoidCallback timeCheckCallback;
  private ap timerHandler;
  
  public KindaTimerService()
  {
    AppMethodBeat.i(144415);
    this.throttleTimerHandler = new ap(Looper.getMainLooper(), new KindaTimerService.4(this), true);
    AppMethodBeat.o(144415);
  }
  
  public void dispatchAfterImpl(float paramFloat, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144416);
    if (this.throttleTimerHandler == null) {
      this.throttleTimerHandler = new ap(Looper.getMainLooper(), new KindaTimerService.5(this), true);
    }
    this.throttleTimerHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(144411);
        paramVoidCallback.call();
        AppMethodBeat.o(144411);
      }
    }, paramFloat);
    AppMethodBeat.o(144416);
  }
  
  public void initIntervalAndCheckedCallbackImpl(float paramFloat, VoidCallback paramVoidCallback)
  {
    this.interval = paramFloat;
    this.timeCheckCallback = paramVoidCallback;
  }
  
  public double now()
  {
    AppMethodBeat.i(144417);
    double d = System.currentTimeMillis();
    AppMethodBeat.o(144417);
    return d;
  }
  
  public void startTimeCheck()
  {
    AppMethodBeat.i(144412);
    this.timerHandler = new ap(Looper.getMainLooper(), new KindaTimerService.1(this), true);
    ap localap = this.timerHandler;
    long l = (this.interval * 1000.0F);
    localap.ag(l, l);
    ab.d("KindaTimerService", "Kinda timer has started, interval(second): " + this.interval);
    AppMethodBeat.o(144412);
  }
  
  public void stopTimeCheck()
  {
    AppMethodBeat.i(144413);
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      ab.d("KindaTimerService", "Kinda timer has stopped.");
    }
    AppMethodBeat.o(144413);
  }
  
  public void throttleImpl(float paramFloat, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144414);
    if (this.throttleTimerHandler == null) {
      this.throttleTimerHandler = new ap(Looper.getMainLooper(), new KindaTimerService.2(this), true);
    }
    if (this.needThrottle)
    {
      AppMethodBeat.o(144414);
      return;
    }
    paramVoidCallback.call();
    this.needThrottle = true;
    this.throttleTimerHandler.postDelayed(new KindaTimerService.3(this), paramFloat);
    AppMethodBeat.o(144414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaTimerService
 * JD-Core Version:    0.7.0.1
 */