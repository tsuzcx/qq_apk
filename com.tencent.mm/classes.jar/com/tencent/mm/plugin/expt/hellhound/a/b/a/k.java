package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  private a KFM;
  private final p KFb;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  k()
  {
    AppMethodBeat.i(205423);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205421);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(205421);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205421);
          return;
        }
        k.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205421);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205420);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205420);
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
        AppMethodBeat.i(205422);
        if (k.this.pGv != null) {
          k.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205422);
      }
    };
    this.KFM = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(205423);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205424);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205424);
      return;
    }
    ad.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205424);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cbD().l(708, paramString);
      AppMethodBeat.o(205424);
      return;
      c.cbD().l(709, paramString);
      AppMethodBeat.o(205424);
      return;
      c.cbD().l(710, paramString);
      AppMethodBeat.o(205424);
      return;
      c.cbD().l(711, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205426);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.KFM.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205426);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205425);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFM.a(this.pGj, this.KFb);
    AppMethodBeat.o(205425);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205427);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205427);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205428);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.pGv.a(3, null);
    AppMethodBeat.o(205428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */