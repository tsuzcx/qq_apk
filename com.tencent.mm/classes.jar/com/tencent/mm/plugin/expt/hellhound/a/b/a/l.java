package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  private a KFM;
  private final p KFb;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  l()
  {
    AppMethodBeat.i(205432);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205430);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(205430);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205430);
          return;
        }
        l.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205430);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205429);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205429);
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
        AppMethodBeat.i(205431);
        if (l.this.pGv != null) {
          l.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205431);
      }
    };
    this.KFM = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(205432);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205433);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205433);
      return;
    }
    ad.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205433);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cbD().l(716, paramString);
      AppMethodBeat.o(205433);
      return;
      c.cbD().l(717, paramString);
      AppMethodBeat.o(205433);
      return;
      c.cbD().l(718, paramString);
      AppMethodBeat.o(205433);
      return;
      c.cbD().l(719, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205435);
    this.KFM.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205435);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205434);
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFM.a(this.pGj, this.KFb);
    AppMethodBeat.o(205434);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205436);
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205436);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205437);
    this.pGv.a(3, null);
    AppMethodBeat.o(205437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */