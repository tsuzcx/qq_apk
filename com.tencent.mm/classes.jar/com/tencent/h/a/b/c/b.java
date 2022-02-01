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
  f ahXs;
  public b ahXt;
  private a ahXu;
  final Object mLock;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(212139);
    this.mLock = new Object();
    this.ahXu = new a()
    {
      public final void b(com.tencent.h.a.c.b.i paramAnonymousi)
      {
        AppMethodBeat.i(212132);
        synchronized (b.this.mLock)
        {
          if ((b.this.ahXs != null) && (paramAnonymousi != null)) {
            b.this.ahXs.a(paramAnonymousi);
          }
          AppMethodBeat.o(212132);
          return;
        }
      }
    };
    AppMethodBeat.o(212139);
  }
  
  public final void a(MotionEvent paramMotionEvent, com.tencent.h.a.c.c.a.b paramb)
  {
    AppMethodBeat.i(212164);
    if ((kdw()) && (this.ahXt != null)) {
      this.ahXt.a(paramMotionEvent, this.ahXu, paramb);
    }
    AppMethodBeat.o(212164);
  }
  
  public final void a(e parame)
  {
    this.ahXs = ((f)parame);
  }
  
  public final int getTaskId()
  {
    return 10;
  }
  
  public final boolean kdu()
  {
    AppMethodBeat.i(212144);
    com.tencent.g.c.i.i("sensor_TouchTask", "[method: start ] ");
    AppMethodBeat.o(212144);
    return true;
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(212150);
    com.tencent.g.c.i.i("sensor_TouchTask", "[method: stop ] ");
    synchronized (this.mLock)
    {
      this.ahXs = null;
      AppMethodBeat.o(212150);
      return true;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */