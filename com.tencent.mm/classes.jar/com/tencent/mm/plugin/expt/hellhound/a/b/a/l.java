package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private a sDC;
  com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  l()
  {
    AppMethodBeat.i(220502);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220500);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(220500);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220500);
          return;
        }
        l.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220500);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220499);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220499);
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
        AppMethodBeat.i(220501);
        if (l.this.sDg != null) {
          l.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220501);
      }
    };
    this.sDC = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(220502);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220503);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220503);
      return;
    }
    Log.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220503);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cNJ().m(716, paramString);
      AppMethodBeat.o(220503);
      return;
      c.cNJ().m(717, paramString);
      AppMethodBeat.o(220503);
      return;
      c.cNJ().m(718, paramString);
      AppMethodBeat.o(220503);
      return;
      c.cNJ().m(719, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220506);
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220506);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220507);
    this.sDg.a(3, null);
    AppMethodBeat.o(220507);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220504);
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDC.a(this.sCN, this.sCP);
    AppMethodBeat.o(220504);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220505);
    this.sDC.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */