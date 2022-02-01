package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private a sDC;
  com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  m()
  {
    AppMethodBeat.i(220511);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220509);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(220509);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220509);
          return;
        }
        m.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220509);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220508);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220508);
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
        AppMethodBeat.i(220510);
        if (m.this.sDg != null) {
          m.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220510);
      }
    };
    this.sDC = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(220511);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220512);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220512);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220512);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cNJ().m(704, paramString);
      AppMethodBeat.o(220512);
      return;
      c.cNJ().m(705, paramString);
      AppMethodBeat.o(220512);
      return;
      c.cNJ().m(706, paramString);
      AppMethodBeat.o(220512);
      return;
      c.cNJ().m(707, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220515);
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220515);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220516);
    this.sDg.a(3, null);
    AppMethodBeat.o(220516);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220513);
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDC.a(this.sCN, this.sCP);
    AppMethodBeat.o(220513);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220514);
    this.sDC.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */