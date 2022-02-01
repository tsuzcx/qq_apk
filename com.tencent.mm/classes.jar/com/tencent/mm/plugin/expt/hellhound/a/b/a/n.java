package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private a sDC;
  com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  n()
  {
    AppMethodBeat.i(220520);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220518);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(220518);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220518);
          return;
        }
        n.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220518);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220517);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = n.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220517);
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
        AppMethodBeat.i(220519);
        if (n.this.sDg != null) {
          n.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220519);
      }
    };
    this.sDC = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(3, "18260", "1003");
    AppMethodBeat.o(220520);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220521);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220521);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220521);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cNJ().m(712, paramString);
      AppMethodBeat.o(220521);
      return;
      c.cNJ().m(713, paramString);
      AppMethodBeat.o(220521);
      return;
      c.cNJ().m(714, paramString);
      AppMethodBeat.o(220521);
      return;
      c.cNJ().m(715, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220524);
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220524);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220525);
    this.sDg.a(3, null);
    AppMethodBeat.o(220525);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220522);
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDC.a(this.sCN, this.sCP);
    AppMethodBeat.o(220522);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220523);
    this.sDC.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */