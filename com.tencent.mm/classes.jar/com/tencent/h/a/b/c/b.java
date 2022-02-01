package com.tencent.h.a.b.c;

import android.view.MotionEvent;
import com.tencent.h.a.a.c;
import com.tencent.h.a.b.c.a.a;
import com.tencent.h.a.b.c.a.e;
import com.tencent.h.a.b.c.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
  implements com.tencent.h.a.c.c.a.a.b
{
  f ZSS;
  public b ZST;
  private a ZSU;
  final Object mLock;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(207866);
    this.mLock = new Object();
    this.ZSU = new a()
    {
      public final void b(com.tencent.h.a.c.b.i paramAnonymousi)
      {
        AppMethodBeat.i(207789);
        synchronized (b.this.mLock)
        {
          if ((b.this.ZSS != null) && (paramAnonymousi != null)) {
            b.this.ZSS.a(paramAnonymousi);
          }
          AppMethodBeat.o(207789);
          return;
        }
      }
    };
    AppMethodBeat.o(207866);
  }
  
  public final boolean TV()
  {
    AppMethodBeat.i(207873);
    com.tencent.g.c.i.i("sensor_TouchTask", "[method: stop ] ");
    synchronized (this.mLock)
    {
      this.ZSS = null;
      AppMethodBeat.o(207873);
      return true;
    }
  }
  
  public final void a(MotionEvent paramMotionEvent, com.tencent.h.a.c.c.a.b paramb)
  {
    AppMethodBeat.i(207878);
    if ((iua()) && (this.ZST != null)) {
      this.ZST.a(paramMotionEvent, this.ZSU, paramb);
    }
    AppMethodBeat.o(207878);
  }
  
  public final void a(e parame)
  {
    this.ZSS = ((f)parame);
  }
  
  public final int getTaskId()
  {
    return 10;
  }
  
  public final boolean itY()
  {
    AppMethodBeat.i(207870);
    com.tencent.g.c.i.i("sensor_TouchTask", "[method: start ] ");
    AppMethodBeat.o(207870);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.h.a.c.b.i parami);
  }
  
  public static abstract interface b
  {
    public abstract void a(MotionEvent paramMotionEvent, b.a parama, com.tencent.h.a.c.c.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */