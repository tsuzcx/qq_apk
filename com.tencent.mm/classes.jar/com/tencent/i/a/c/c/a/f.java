package com.tencent.i.a.c.c.a;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.tencent.h.c.h;
import com.tencent.i.a.b.c.b.a;
import com.tencent.i.a.c.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
  extends a
{
  private AtomicBoolean SrB;
  private MotionEvent.PointerCoords SsQ;
  private final d SsR;
  private long SsS;
  private com.tencent.h.a.a SsT;
  
  public f(com.tencent.i.a.a.c paramc, com.tencent.i.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(214780);
    this.SsQ = new MotionEvent.PointerCoords();
    this.SsR = new d(new d.b(), new d.a());
    this.SrB = new AtomicBoolean(true);
    this.SsS = 0L;
    this.SsT = new com.tencent.h.a.a()
    {
      public final void boF()
      {
        AppMethodBeat.i(214779);
        h.i("sensor_MultiTouch", "[method: mPauseRunnable ] mPauseRunnable");
        f.this.pause();
        AppMethodBeat.o(214779);
      }
    };
    AppMethodBeat.o(214780);
  }
  
  private void OK(long paramLong)
  {
    AppMethodBeat.i(214782);
    if (this.SrB.get())
    {
      this.SrB.set(false);
      h.i("sensor_MultiTouch", "[method: resumeEngine ] engine is restart");
      this.SsS = paramLong;
      this.SsB.hqe();
      OL(2000L);
    }
    AppMethodBeat.o(214782);
  }
  
  private void OL(long paramLong)
  {
    AppMethodBeat.i(214783);
    if (this.SsE != null) {
      this.SsE.hqz().removeCallbacks(this.SsT);
    }
    if (paramLong <= 0L)
    {
      pause();
      AppMethodBeat.o(214783);
      return;
    }
    if (this.SsE != null) {
      this.SsE.hqz().postDelayed(this.SsT, paramLong);
    }
    AppMethodBeat.o(214783);
  }
  
  private void a(int paramInt, i parami)
  {
    AppMethodBeat.i(214785);
    parami.Ssz = this.SsR.SsJ.asD(paramInt);
    AppMethodBeat.o(214785);
  }
  
  private void a(b.a parama, int paramInt, i parami)
  {
    AppMethodBeat.i(214786);
    if (parama != null)
    {
      a(paramInt, parami);
      h.i("sensor_MultiTouch", "[method: onCallBack ] info : " + parami.Ssz);
      parama.b(parami);
    }
    AppMethodBeat.o(214786);
  }
  
  public final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    AppMethodBeat.i(214781);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    int k = paramMotionEvent.getActionMasked();
    Object localObject;
    switch (k)
    {
    case 4: 
    default: 
      AppMethodBeat.o(214781);
      return;
    case 0: 
    case 5: 
      paramMotionEvent.getPointerCoords(i, this.SsQ);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
      h.i("sensor_MultiTouch", "[method: handleDown ] pointerId : ".concat(String.valueOf(j)));
      boolean bool = this.SsR.SsI.hqB();
      if ((this.SrB.get()) || (bool)) {
        h.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown111 ] isMainTouchSet : " + bool + ", isEngineStop : " + this.SrB.get());
      }
      for (;;)
      {
        localObject = new c(j, paramMotionEvent);
        d.b localb = this.SsR.SsI;
        localb.SsN.put(Integer.valueOf(((c)localObject).SsF), localObject);
        localb.SsM.offer(Integer.valueOf(((c)localObject).SsF));
        this.SsR.SsI.hqC();
        OK(paramMotionEvent.Ssw);
        this.SsR.SsJ.asD(j);
        a(parama, j, paramMotionEvent);
        AppMethodBeat.o(214781);
        return;
        h.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown444 ] ----pause engine----");
        OL(0L);
      }
    case 2: 
      i = 0;
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.SsQ);
        localObject = a(2, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
        a(parama, paramMotionEvent.getPointerId(i), (i)localObject);
        i += 1;
      }
      this.SsR.SsI.hqC();
      OK(paramMotionEvent.getEventTime());
      AppMethodBeat.o(214781);
      return;
    }
    paramMotionEvent.getPointerCoords(i, this.SsQ);
    if (k == 3) {}
    for (i = 4;; i = 3)
    {
      paramMotionEvent = a(i, paramMotionEvent.getEventTime(), this.SsQ.pressure, this.SsQ.size);
      a(parama, j, paramMotionEvent);
      parama = this.SsR.SsI.asF(j);
      h.i("sensor_MultiTouch", "[method: handleUp ] main pointer up id : ".concat(String.valueOf(j)));
      if ((parama != null) && ((parama.SsG) || (this.SsR.SsI.SsM.size() <= 0)))
      {
        long l1 = Math.abs(paramMotionEvent.Ssw - this.SsS);
        long l2 = Math.max(Math.min(2000L - l1, 500L), 0L);
        h.i("sensor_MultiTouch", "[method: handleUp ]  touch interval : " + l1 + ", delay pause : " + l2);
        OK(paramMotionEvent.Ssw);
        OL(l2);
      }
      this.SsR.SsJ.asE(j);
      break;
    }
  }
  
  final void pause()
  {
    AppMethodBeat.i(214784);
    if (this.SsB != null)
    {
      this.SrB.set(true);
      h.i("sensor_MultiTouch", "[method: multi_pause ] " + this.SsB.YY());
      this.SsB.hqf();
    }
    AppMethodBeat.o(214784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.f
 * JD-Core Version:    0.7.0.1
 */