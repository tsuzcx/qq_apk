package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  private final p KFb;
  private a KFq;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  c()
  {
    AppMethodBeat.i(205405);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205403);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(205403);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205403);
          return;
        }
        c.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205403);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205402);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205402);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.KFb = new p()
    {
      public final void yx(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205404);
        if (c.this.pGv != null) {
          c.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205404);
      }
    };
    this.KFq = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(205405);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205406);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205406);
      return;
    }
    ad.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205406);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(720, paramString);
      AppMethodBeat.o(205406);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(721, paramString);
      AppMethodBeat.o(205406);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(722, paramString);
      AppMethodBeat.o(205406);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().l(723, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205408);
    this.KFq.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205408);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205407);
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFq.a(this.pGj, this.KFb);
    AppMethodBeat.o(205407);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205409);
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205409);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205410);
    this.pGv.a(3, null);
    AppMethodBeat.o(205410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */