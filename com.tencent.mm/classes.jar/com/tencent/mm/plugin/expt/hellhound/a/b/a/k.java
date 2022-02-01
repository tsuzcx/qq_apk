package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private a sDC;
  com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  k()
  {
    AppMethodBeat.i(220493);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220491);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(220491);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220491);
          return;
        }
        k.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220491);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220490);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220490);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.sCP = new p()
    {
      public final void md(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(220492);
        if (k.this.sDg != null) {
          k.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220492);
      }
    };
    this.sDC = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(220493);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220494);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220494);
      return;
    }
    Log.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220494);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cNJ().m(708, paramString);
      AppMethodBeat.o(220494);
      return;
      c.cNJ().m(709, paramString);
      AppMethodBeat.o(220494);
      return;
      c.cNJ().m(710, paramString);
      AppMethodBeat.o(220494);
      return;
      c.cNJ().m(711, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220497);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220497);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220498);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.sDg.a(3, null);
    AppMethodBeat.o(220498);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220495);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDC.a(this.sCN, this.sCP);
    AppMethodBeat.o(220495);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220496);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.sDC.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */