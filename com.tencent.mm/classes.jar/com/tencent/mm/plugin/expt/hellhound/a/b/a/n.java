package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  private a KFM;
  private final p KFb;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  n()
  {
    AppMethodBeat.i(205450);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205448);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(205448);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205448);
          return;
        }
        n.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205448);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205447);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = n.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205447);
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
        AppMethodBeat.i(205449);
        if (n.this.pGv != null) {
          n.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205449);
      }
    };
    this.KFM = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(3, "18260", "1003");
    AppMethodBeat.o(205450);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205451);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205451);
      return;
    }
    ad.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205451);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cbD().l(712, paramString);
      AppMethodBeat.o(205451);
      return;
      c.cbD().l(713, paramString);
      AppMethodBeat.o(205451);
      return;
      c.cbD().l(714, paramString);
      AppMethodBeat.o(205451);
      return;
      c.cbD().l(715, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205453);
    this.KFM.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205453);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205452);
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFM.a(this.pGj, this.KFb);
    AppMethodBeat.o(205452);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205454);
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205454);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205455);
    this.pGv.a(3, null);
    AppMethodBeat.o(205455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */