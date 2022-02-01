package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f sCN;
  private final p sCP;
  private final a sDC;
  final com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  i()
  {
    AppMethodBeat.i(220484);
    this.sCN = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(220482);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(220482);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(220482);
          return;
        }
        i.this.sDg.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(220482);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(220481);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.sDg;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(220481);
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
        AppMethodBeat.i(220483);
        if (i.this.sDg != null) {
          i.this.sDg.mc(paramAnonymousBoolean);
        }
        AppMethodBeat.o(220483);
      }
    };
    this.sDC = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(220484);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220485);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNr())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(220485);
      return;
    }
    Log.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220485);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cNJ().m(724, paramString);
      AppMethodBeat.o(220485);
      return;
      c.cNJ().m(725, paramString);
      AppMethodBeat.o(220485);
      return;
      c.cNJ().m(726, paramString);
      AppMethodBeat.o(220485);
      return;
      c.cNJ().m(727, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220488);
    this.sDg.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(220488);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220489);
    this.sDg.a(3, null);
    AppMethodBeat.o(220489);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220486);
    if (this.mActivityRef != null) {
      this.sDg.a(0, (Activity)this.mActivityRef.get());
    }
    this.sDC.a(this.sCN, this.sCP);
    AppMethodBeat.o(220486);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220487);
    this.sDC.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */