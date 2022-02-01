package com.tencent.kinda.framework.app;

import android.os.Looper;
import com.tencent.kinda.gen.KTimerService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class KindaTimerService
  implements KTimerService
{
  private static final String TAG = "KindaTimerService";
  private float interval;
  private boolean needThrottle;
  private av throttleTimerHandler;
  private VoidCallback timeCheckCallback;
  private av timerHandler;
  
  public KindaTimerService()
  {
    AppMethodBeat.i(18522);
    this.throttleTimerHandler = new av(Looper.getMainLooper(), new av.a()
    {
      public boolean onTimerExpired()
      {
        return true;
      }
    }, true);
    AppMethodBeat.o(18522);
  }
  
  public void dispatchAfterImpl(float paramFloat, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18523);
    if (this.throttleTimerHandler == null) {
      this.throttleTimerHandler = new av(Looper.getMainLooper(), new av.a()
      {
        public boolean onTimerExpired()
        {
          return true;
        }
      }, true);
    }
    this.throttleTimerHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18518);
        paramVoidCallback.call();
        AppMethodBeat.o(18518);
      }
    }, paramFloat);
    AppMethodBeat.o(18523);
  }
  
  public void initIntervalAndCheckedCallbackImpl(float paramFloat, VoidCallback paramVoidCallback)
  {
    this.interval = paramFloat;
    this.timeCheckCallback = paramVoidCallback;
  }
  
  public double now()
  {
    AppMethodBeat.i(18524);
    double d = System.currentTimeMillis();
    AppMethodBeat.o(18524);
    return d;
  }
  
  public void startTimeCheck()
  {
    AppMethodBeat.i(18519);
    if ((this.timerHandler != null) && (!this.timerHandler.fkZ())) {
      this.timerHandler.stopTimer();
    }
    this.timerHandler = new av(Looper.getMainLooper(), new av.a()
    {
      public boolean onTimerExpired()
      {
        AppMethodBeat.i(18516);
        KindaTimerService.this.timeCheckCallback.call();
        ad.d("KindaTimerService", "A callback to C++ from Kinda timer was performed.");
        AppMethodBeat.o(18516);
        return true;
      }
    }, true);
    av localav = this.timerHandler;
    long l = (this.interval * 1000.0F);
    localav.az(l, l);
    ad.d("KindaTimerService", "Kinda timer has started, interval(second): " + this.interval);
    AppMethodBeat.o(18519);
  }
  
  public void stopTimeCheck()
  {
    AppMethodBeat.i(18520);
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      ad.d("KindaTimerService", "Kinda timer has stopped.");
    }
    AppMethodBeat.o(18520);
  }
  
  public void throttleImpl(float paramFloat, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18521);
    if (this.throttleTimerHandler == null) {
      this.throttleTimerHandler = new av(Looper.getMainLooper(), new av.a()
      {
        public boolean onTimerExpired()
        {
          return true;
        }
      }, true);
    }
    if (this.needThrottle)
    {
      AppMethodBeat.o(18521);
      return;
    }
    paramVoidCallback.call();
    this.needThrottle = true;
    this.throttleTimerHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18517);
        KindaTimerService.access$102(KindaTimerService.this, false);
        AppMethodBeat.o(18517);
      }
    }, paramFloat);
    AppMethodBeat.o(18521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaTimerService
 * JD-Core Version:    0.7.0.1
 */