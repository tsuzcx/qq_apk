package com.tencent.i.a.b.c;

import android.view.MotionEvent;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.a.a;
import com.tencent.i.a.b.c.a.e;
import com.tencent.i.a.b.c.a.f;
import com.tencent.i.a.c.b.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  extends a
  implements com.tencent.i.a.c.c.a.a.b
{
  f Srp;
  public b Srq;
  private a Srr;
  final Object mLock;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(214710);
    this.mLock = new Object();
    this.Srr = new a()
    {
      public final void b(i paramAnonymousi)
      {
        AppMethodBeat.i(214709);
        synchronized (b.this.mLock)
        {
          if ((b.this.Srp != null) && (paramAnonymousi != null)) {
            b.this.Srp.a(paramAnonymousi);
          }
          AppMethodBeat.o(214709);
          return;
        }
      }
    };
    AppMethodBeat.o(214710);
  }
  
  public final boolean Qt()
  {
    AppMethodBeat.i(214712);
    h.i("sensor_TouchTask", "[method: stop ] ");
    synchronized (this.mLock)
    {
      this.Srp = null;
      AppMethodBeat.o(214712);
      return true;
    }
  }
  
  public final void a(MotionEvent paramMotionEvent, com.tencent.i.a.c.c.a.b paramb)
  {
    AppMethodBeat.i(214713);
    if ((this.Srt.get()) && (this.Srq != null)) {
      this.Srq.a(paramMotionEvent, this.Srr, paramb);
    }
    AppMethodBeat.o(214713);
  }
  
  public final void a(e parame)
  {
    this.Srp = ((f)parame);
  }
  
  public final int getTaskId()
  {
    return 10;
  }
  
  public final boolean hqp()
  {
    AppMethodBeat.i(214711);
    h.i("sensor_TouchTask", "[method: start ] ");
    AppMethodBeat.o(214711);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void b(i parami);
  }
  
  public static abstract interface b
  {
    public abstract void a(MotionEvent paramMotionEvent, b.a parama, com.tencent.i.a.c.c.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */