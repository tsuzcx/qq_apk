package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.c;

final class a$1
  implements r.c
{
  a$1(a parama) {}
  
  public final void a(final Object paramObject, final r.a parama)
  {
    AppMethodBeat.i(14098);
    if ((parama != null) && (parama.ywN))
    {
      AppMethodBeat.o(14098);
      return;
    }
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(14097);
        Looper.myQueue().removeIdleHandler(this);
        if ((a.a(a.1.this.jVZ) == null) || (a.a(a.1.this.jVZ).isFinishing()))
        {
          AppMethodBeat.o(14097);
          return false;
        }
        a.a(a.1.this.jVZ, parama);
        AppMethodBeat.o(14097);
        return false;
      }
    });
    AppMethodBeat.o(14098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.1
 * JD-Core Version:    0.7.0.1
 */