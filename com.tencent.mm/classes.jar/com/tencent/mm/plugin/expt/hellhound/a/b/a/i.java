package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  private a qma;
  
  i()
  {
    AppMethodBeat.i(195247);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195245);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(195245);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195245);
          return;
        }
        i.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195245);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195244);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195244);
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
        AppMethodBeat.i(195246);
        if (i.this.qlE != null) {
          i.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195246);
      }
    };
    this.qma = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(195247);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195248);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195248);
      return;
    }
    ac.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195248);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.ciO().l(724, paramString);
      AppMethodBeat.o(195248);
      return;
      c.ciO().l(725, paramString);
      AppMethodBeat.o(195248);
      return;
      c.ciO().l(726, paramString);
      AppMethodBeat.o(195248);
      return;
      c.ciO().l(727, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195250);
    this.qma.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195250);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195249);
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qma.a(this.qlm, this.qlo);
    AppMethodBeat.o(195249);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195251);
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195251);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195252);
    this.qlE.a(3, null);
    AppMethodBeat.o(195252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */