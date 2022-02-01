package com.tencent.h.a.c.c.a;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.tencent.h.a.b.c.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
  extends a
{
  private AtomicBoolean ZTe;
  private MotionEvent.PointerCoords ZUt;
  private final d ZUu;
  private long ZUv;
  private com.tencent.g.a.a ZUw;
  
  public f(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(208025);
    this.ZUt = new MotionEvent.PointerCoords();
    this.ZUu = new d(new d.b(), new d.a());
    this.ZTe = new AtomicBoolean(true);
    this.ZUv = 0L;
    this.ZUw = new com.tencent.g.a.a()
    {
      public final void byO()
      {
        AppMethodBeat.i(208082);
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: mPauseRunnable ] mPauseRunnable");
        f.this.pause();
        AppMethodBeat.o(208082);
      }
    };
    AppMethodBeat.o(208025);
  }
  
  private void Xa(long paramLong)
  {
    AppMethodBeat.i(208029);
    if (this.ZTe.get())
    {
      this.ZTe.set(false);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: resumeEngine ] engine is restart");
      this.ZUv = paramLong;
      this.ZUe.itL();
      Xb(2000L);
    }
    AppMethodBeat.o(208029);
  }
  
  private void Xb(long paramLong)
  {
    AppMethodBeat.i(208032);
    if (this.ZUh != null) {
      this.ZUh.iui().removeCallbacks(this.ZUw);
    }
    if (paramLong <= 0L)
    {
      pause();
      AppMethodBeat.o(208032);
      return;
    }
    if (this.ZUh != null) {
      this.ZUh.iui().postDelayed(this.ZUw, paramLong);
    }
    AppMethodBeat.o(208032);
  }
  
  private void a(int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(208037);
    parami.ZUc = this.ZUu.ZUm.aCr(paramInt);
    AppMethodBeat.o(208037);
  }
  
  private void a(b.a parama, int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(208039);
    if (parama != null)
    {
      a(paramInt, parami);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: onCallBack ] info : " + parami.ZUc);
      parama.b(parami);
    }
    AppMethodBeat.o(208039);
  }
  
  public final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    AppMethodBeat.i(208027);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    int k = paramMotionEvent.getActionMasked();
    Object localObject;
    switch (k)
    {
    case 4: 
    default: 
      AppMethodBeat.o(208027);
      return;
    case 0: 
    case 5: 
      paramMotionEvent.getPointerCoords(i, this.ZUt);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown ] pointerId : ".concat(String.valueOf(j)));
      boolean bool = this.ZUu.ZUl.iuk();
      if ((this.ZTe.get()) || (bool)) {
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown111 ] isMainTouchSet : " + bool + ", isEngineStop : " + this.ZTe.get());
      }
      for (;;)
      {
        localObject = new c(j, paramMotionEvent);
        d.b localb = this.ZUu.ZUl;
        localb.ZUq.put(Integer.valueOf(((c)localObject).ZUi), localObject);
        localb.ZUp.offer(Integer.valueOf(((c)localObject).ZUi));
        this.ZUu.ZUl.iul();
        Xa(paramMotionEvent.ZTZ);
        this.ZUu.ZUm.aCr(j);
        a(parama, j, paramMotionEvent);
        AppMethodBeat.o(208027);
        return;
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown444 ] ----pause engine----");
        Xb(0L);
      }
    case 2: 
      i = 0;
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.ZUt);
        localObject = a(2, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size);
        a(parama, paramMotionEvent.getPointerId(i), (com.tencent.h.a.c.b.i)localObject);
        i += 1;
      }
      this.ZUu.ZUl.iul();
      Xa(paramMotionEvent.getEventTime());
      AppMethodBeat.o(208027);
      return;
    }
    paramMotionEvent.getPointerCoords(i, this.ZUt);
    if (k == 3) {}
    for (i = 4;; i = 3)
    {
      paramMotionEvent = a(i, paramMotionEvent.getEventTime(), this.ZUt.pressure, this.ZUt.size);
      a(parama, j, paramMotionEvent);
      parama = this.ZUu.ZUl.aCt(j);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleUp ] main pointer up id : ".concat(String.valueOf(j)));
      if ((parama != null) && ((parama.ZUj) || (this.ZUu.ZUl.ZUp.size() <= 0)))
      {
        long l1 = Math.abs(paramMotionEvent.ZTZ - this.ZUv);
        long l2 = Math.max(Math.min(2000L - l1, 500L), 0L);
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleUp ]  touch interval : " + l1 + ", delay pause : " + l2);
        Xa(paramMotionEvent.ZTZ);
        Xb(l2);
      }
      this.ZUu.ZUm.aCs(j);
      break;
    }
  }
  
  void pause()
  {
    AppMethodBeat.i(208033);
    if (this.ZUe != null)
    {
      this.ZTe.set(true);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: multi_pause ] " + this.ZUe.adH());
      this.ZUe.itM();
    }
    AppMethodBeat.o(208033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.f
 * JD-Core Version:    0.7.0.1
 */