package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  WeakReference<Activity> mActivityRef;
  private a qlD;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  
  c()
  {
    AppMethodBeat.i(195238);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195236);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(195236);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195236);
          return;
        }
        c.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195236);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195235);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195235);
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
        AppMethodBeat.i(195237);
        if (c.this.qlE != null) {
          c.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195237);
      }
    };
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(195238);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195239);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195239);
      return;
    }
    ac.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195239);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(720, paramString);
      AppMethodBeat.o(195239);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(721, paramString);
      AppMethodBeat.o(195239);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(722, paramString);
      AppMethodBeat.o(195239);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.ciO().l(723, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195241);
    this.qlD.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195241);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195240);
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qlD.a(this.qlm, this.qlo);
    AppMethodBeat.o(195240);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195242);
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195242);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195243);
    this.qlE.a(3, null);
    AppMethodBeat.o(195243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */