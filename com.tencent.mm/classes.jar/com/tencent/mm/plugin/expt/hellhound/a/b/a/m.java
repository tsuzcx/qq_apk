package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  private a rcV;
  private final e rch;
  private final p rcj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  m()
  {
    AppMethodBeat.i(196081);
    this.rch = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196079);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(196079);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ae.m("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(196079);
          return;
        }
        m.this.rcz.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(196079);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(196078);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.rcz;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(196078);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.rcj = new p()
    {
      public final void kZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196080);
        if (m.this.rcz != null) {
          m.this.rcz.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(196080);
      }
    };
    this.rcV = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(196081);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196082);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(196082);
      return;
    }
    ae.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196082);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cpq().l(704, paramString);
      AppMethodBeat.o(196082);
      return;
      c.cpq().l(705, paramString);
      AppMethodBeat.o(196082);
      return;
      c.cpq().l(706, paramString);
      AppMethodBeat.o(196082);
      return;
      c.cpq().l(707, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196084);
    this.rcV.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196084);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196083);
    if (this.mActivityRef != null) {
      this.rcz.a(0, (Activity)this.mActivityRef.get());
    }
    this.rcV.a(this.rch, this.rcj);
    AppMethodBeat.o(196083);
  }
  
  public final void free()
  {
    AppMethodBeat.i(196085);
    this.rcz.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(196085);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196086);
    this.rcz.a(3, null);
    AppMethodBeat.o(196086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */