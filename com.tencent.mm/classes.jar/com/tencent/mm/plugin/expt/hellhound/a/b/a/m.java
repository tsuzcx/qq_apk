package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  private a KFM;
  private final p KFb;
  WeakReference<Activity> mActivityRef;
  private final d pGj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  m()
  {
    AppMethodBeat.i(205441);
    this.pGj = new d()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205439);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(205439);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(205439);
          return;
        }
        m.this.pGv.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(205439);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(205438);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.pGv;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(205438);
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
        AppMethodBeat.i(205440);
        if (m.this.pGv != null) {
          m.this.pGv.kc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(205440);
      }
    };
    this.KFM = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(205441);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205442);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbq())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(205442);
      return;
    }
    ad.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205442);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cbD().l(704, paramString);
      AppMethodBeat.o(205442);
      return;
      c.cbD().l(705, paramString);
      AppMethodBeat.o(205442);
      return;
      c.cbD().l(706, paramString);
      AppMethodBeat.o(205442);
      return;
      c.cbD().l(707, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205444);
    this.KFM.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205444);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205443);
    if (this.mActivityRef != null) {
      this.pGv.a(0, (Activity)this.mActivityRef.get());
    }
    this.KFM.a(this.pGj, this.KFb);
    AppMethodBeat.o(205443);
  }
  
  public final void free()
  {
    AppMethodBeat.i(205445);
    this.pGv.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(205445);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205446);
    this.pGv.a(3, null);
    AppMethodBeat.o(205446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */