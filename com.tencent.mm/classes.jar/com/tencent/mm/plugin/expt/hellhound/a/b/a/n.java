package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  private a qma;
  
  n()
  {
    AppMethodBeat.i(195283);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195281);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(195281);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195281);
          return;
        }
        n.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195281);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195280);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = n.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195280);
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
        AppMethodBeat.i(195282);
        if (n.this.qlE != null) {
          n.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195282);
      }
    };
    this.qma = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(3, "18260", "1003");
    AppMethodBeat.o(195283);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195284);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195284);
      return;
    }
    ac.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195284);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.ciO().l(712, paramString);
      AppMethodBeat.o(195284);
      return;
      c.ciO().l(713, paramString);
      AppMethodBeat.o(195284);
      return;
      c.ciO().l(714, paramString);
      AppMethodBeat.o(195284);
      return;
      c.ciO().l(715, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195286);
    this.qma.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195286);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195285);
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qma.a(this.qlm, this.qlo);
    AppMethodBeat.o(195285);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195287);
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195287);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195288);
    this.qlE.a(3, null);
    AppMethodBeat.o(195288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */