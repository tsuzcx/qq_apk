package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  private a qma;
  
  k()
  {
    AppMethodBeat.i(195256);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195254);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(195254);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195254);
          return;
        }
        k.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195254);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195253);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195253);
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
        AppMethodBeat.i(195255);
        if (k.this.qlE != null) {
          k.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195255);
      }
    };
    this.qma = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(195256);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195257);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195257);
      return;
    }
    ac.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195257);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.ciO().l(708, paramString);
      AppMethodBeat.o(195257);
      return;
      c.ciO().l(709, paramString);
      AppMethodBeat.o(195257);
      return;
      c.ciO().l(710, paramString);
      AppMethodBeat.o(195257);
      return;
      c.ciO().l(711, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195259);
    ac.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.qma.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195259);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195258);
    ac.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qma.a(this.qlm, this.qlo);
    AppMethodBeat.o(195258);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195260);
    ac.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195260);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195261);
    ac.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.qlE.a(3, null);
    AppMethodBeat.o(195261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */