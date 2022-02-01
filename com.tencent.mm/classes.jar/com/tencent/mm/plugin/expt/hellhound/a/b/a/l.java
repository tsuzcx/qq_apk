package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final e qlm;
  private final p qlo;
  private a qma;
  
  l()
  {
    AppMethodBeat.i(195265);
    this.qlm = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(195263);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(195263);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ac.m("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(195263);
          return;
        }
        l.this.qlE.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(195263);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(195262);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.qlE;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(195262);
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
        AppMethodBeat.i(195264);
        if (l.this.qlE != null) {
          l.this.qlE.kG(paramAnonymousBoolean);
        }
        AppMethodBeat.o(195264);
      }
    };
    this.qma = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(195265);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195266);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.ciw()) || (!com.tencent.mm.plugin.expt.hellhound.a.ciz())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(195266);
      return;
    }
    ac.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195266);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.ciO().l(716, paramString);
      AppMethodBeat.o(195266);
      return;
      c.ciO().l(717, paramString);
      AppMethodBeat.o(195266);
      return;
      c.ciO().l(718, paramString);
      AppMethodBeat.o(195266);
      return;
      c.ciO().l(719, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195268);
    this.qma.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195268);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195267);
    if (this.mActivityRef != null) {
      this.qlE.a(0, (Activity)this.mActivityRef.get());
    }
    this.qma.a(this.qlm, this.qlo);
    AppMethodBeat.o(195267);
  }
  
  public final void free()
  {
    AppMethodBeat.i(195269);
    this.qlE.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(195269);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195270);
    this.qlE.a(3, null);
    AppMethodBeat.o(195270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */