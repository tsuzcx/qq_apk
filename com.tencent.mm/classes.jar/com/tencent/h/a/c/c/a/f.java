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
  private AtomicBoolean ahXE;
  private MotionEvent.PointerCoords ahYT;
  private final d ahYU;
  private long ahYV;
  private com.tencent.g.a.a ahYW;
  
  public f(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    super(paramc, paramb);
    AppMethodBeat.i(212223);
    this.ahYT = new MotionEvent.PointerCoords();
    this.ahYU = new d(new d.b(), new d.a());
    this.ahXE = new AtomicBoolean(true);
    this.ahYV = 0L;
    this.ahYW = new com.tencent.g.a.a()
    {
      public final void bXC()
      {
        AppMethodBeat.i(212226);
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: mPauseRunnable ] mPauseRunnable");
        f.this.pause();
        AppMethodBeat.o(212226);
      }
    };
    AppMethodBeat.o(212223);
  }
  
  private void Bn(long paramLong)
  {
    AppMethodBeat.i(212230);
    if (this.ahXE.get())
    {
      this.ahXE.set(false);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: resumeEngine ] engine is restart");
      this.ahYV = paramLong;
      this.ahYE.kdh();
      Bo(2000L);
    }
    AppMethodBeat.o(212230);
  }
  
  private void Bo(long paramLong)
  {
    AppMethodBeat.i(212235);
    if ((this.ahYH != null) && (this.ahYH.kdE() != null)) {
      this.ahYH.kdE().removeCallbacks(this.ahYW);
    }
    if (paramLong <= 0L)
    {
      pause();
      AppMethodBeat.o(212235);
      return;
    }
    if ((this.ahYH != null) && (this.ahYH.kdE() != null)) {
      this.ahYH.kdE().postDelayed(this.ahYW, paramLong);
    }
    AppMethodBeat.o(212235);
  }
  
  private void a(int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(212241);
    parami.ahYC = this.ahYU.ahYM.aJe(paramInt);
    AppMethodBeat.o(212241);
  }
  
  private void a(b.a parama, int paramInt, com.tencent.h.a.c.b.i parami)
  {
    AppMethodBeat.i(212247);
    if (parama != null)
    {
      a(paramInt, parami);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: onCallBack ] info : " + parami.ahYC);
      parama.b(parami);
    }
    AppMethodBeat.o(212247);
  }
  
  public final void a(MotionEvent paramMotionEvent, b.a parama)
  {
    AppMethodBeat.i(212260);
    int i = paramMotionEvent.getActionIndex();
    int j = paramMotionEvent.getPointerId(i);
    int k = paramMotionEvent.getActionMasked();
    Object localObject;
    switch (k)
    {
    case 4: 
    default: 
      AppMethodBeat.o(212260);
      return;
    case 0: 
    case 5: 
      paramMotionEvent.getPointerCoords(i, this.ahYT);
      paramMotionEvent = a(1, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown ] pointerId : ".concat(String.valueOf(j)));
      boolean bool = this.ahYU.ahYL.kdG();
      if ((this.ahXE.get()) || (bool)) {
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown111 ] isMainTouchSet : " + bool + ", isEngineStop : " + this.ahXE.get());
      }
      for (;;)
      {
        localObject = new c(j, paramMotionEvent);
        d.b localb = this.ahYU.ahYL;
        localb.ahYQ.put(Integer.valueOf(((c)localObject).ahYI), localObject);
        localb.ahYP.offer(Integer.valueOf(((c)localObject).ahYI));
        this.ahYU.ahYL.kdH();
        Bn(paramMotionEvent.ahYz);
        this.ahYU.ahYM.aJe(j);
        a(parama, j, paramMotionEvent);
        AppMethodBeat.o(212260);
        return;
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleDown pauseEngineWhenDown444 ] ----pause engine----");
        Bo(0L);
      }
    case 2: 
      i = 0;
      while (i < paramMotionEvent.getPointerCount())
      {
        paramMotionEvent.getPointerCoords(i, this.ahYT);
        localObject = a(2, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size);
        a(parama, paramMotionEvent.getPointerId(i), (com.tencent.h.a.c.b.i)localObject);
        i += 1;
      }
      this.ahYU.ahYL.kdH();
      Bn(paramMotionEvent.getEventTime());
      AppMethodBeat.o(212260);
      return;
    }
    paramMotionEvent.getPointerCoords(i, this.ahYT);
    if (k == 3) {}
    for (i = 4;; i = 3)
    {
      paramMotionEvent = a(i, paramMotionEvent.getEventTime(), this.ahYT.pressure, this.ahYT.size);
      a(parama, j, paramMotionEvent);
      parama = this.ahYU.ahYL.aJg(j);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleUp ] main pointer up id : ".concat(String.valueOf(j)));
      if ((parama != null) && ((parama.ahYJ) || (this.ahYU.ahYL.ahYP.size() <= 0)))
      {
        long l1 = Math.abs(paramMotionEvent.ahYz - this.ahYV);
        long l2 = Math.max(Math.min(2000L - l1, 500L), 0L);
        com.tencent.g.c.i.i("sensor_MultiTouch", "[method: handleUp ]  touch interval : " + l1 + ", delay pause : " + l2);
        Bn(paramMotionEvent.ahYz);
        Bo(l2);
      }
      this.ahYU.ahYM.aJf(j);
      break;
    }
  }
  
  void pause()
  {
    AppMethodBeat.i(212266);
    if (this.ahYE != null)
    {
      this.ahXE.set(true);
      com.tencent.g.c.i.i("sensor_MultiTouch", "[method: multi_pause ] " + this.ahYE.aFF());
      this.ahYE.kdi();
    }
    AppMethodBeat.o(212266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.f
 * JD-Core Version:    0.7.0.1
 */