package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  private a qma;
  
  m()
  {
    AppMethodBeat.i(195274);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195272);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(195272);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195272);
          return;
        }
        m.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195272);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195271);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195271);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.qlo = new p()
    {
      public final void kH(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(195273);
        if (m.this.qlE != null) {
          m.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195273);
      }
    };
    this.qma = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(195274);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195275);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195275);
      return;
    }
    ac.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195275);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.ciO().l(704, paramString);
      AppMethodBeat.o(195275);
      return;
      c.ciO().l(705, paramString);
      AppMethodBeat.o(195275);
      return;
      c.ciO().l(706, paramString);
      AppMethodBeat.o(195275);
      return;
      c.ciO().l(707, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195277);
    this.qma.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195277);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195276);
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qma.a(this.qlm, this.qlo);
    AppMethodBeat.o(195276);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195278);
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195278);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195279);
    this.qlE.a(3, null);
    AppMethodBeat.o(195279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */