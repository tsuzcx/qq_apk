package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private a sDf;
  com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  c()
  {
    AppMethodBeat.i(220475);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220473);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(220473);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220473);
          return;
        }
        c.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220473);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220472);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220472);
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
        AppMethodBeat.i(220474);
        if (c.this.sDg != null) {
          c.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220474);
      }
    };
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(220475);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220476);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220476);
      return;
    }
    Log.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220476);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(720, paramString);
      AppMethodBeat.o(220476);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(721, paramString);
      AppMethodBeat.o(220476);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(722, paramString);
      AppMethodBeat.o(220476);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(723, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220479);
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220479);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220480);
    this.sDg.a(3, null);
    AppMethodBeat.o(220480);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220477);
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDf.a(this.sCN, this.sCP);
    AppMethodBeat.o(220477);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220478);
    this.sDf.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */