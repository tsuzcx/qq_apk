package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  private a KFM;
  private final p KFb;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  i()
  {
    AppMethodBeat.i(205414);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205412);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(205412);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205412);
          return;
        }
        i.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205412);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205411);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205411);
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
        AppMethodBeat.i(205413);
        if (i.this.pGv != null) {
          i.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205413);
      }
    };
    this.KFM = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(205414);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205415);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205415);
      return;
    }
    ad.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205415);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cbD().l(724, paramString);
      AppMethodBeat.o(205415);
      return;
      c.cbD().l(725, paramString);
      AppMethodBeat.o(205415);
      return;
      c.cbD().l(726, paramString);
      AppMethodBeat.o(205415);
      return;
      c.cbD().l(727, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205417);
    this.KFM.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205417);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205416);
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFM.a(this.pGj, this.KFb);
    AppMethodBeat.o(205416);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205418);
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205418);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205419);
    this.pGv.a(3, null);
    AppMethodBeat.o(205419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */