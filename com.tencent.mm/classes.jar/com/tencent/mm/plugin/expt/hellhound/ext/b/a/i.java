package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  final com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private final a zFz;
  
  i()
  {
    AppMethodBeat.i(300414);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300504);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(300504);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300504);
          return;
        }
        i.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300504);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300496);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = i.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300496);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.zEM = new p()
    {
      public final void oP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(300492);
        if (i.this.zFd != null) {
          i.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300492);
      }
    };
    this.zFz = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(4, "18260", "1004");
    AppMethodBeat.o(300414);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300423);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300423);
      return true;
    }
    AppMethodBeat.o(300423);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300431);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300431);
      return;
    }
    Log.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300431);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dJd().I(724, paramString);
      AppMethodBeat.o(300431);
      return;
      c.dJd().I(725, paramString);
      AppMethodBeat.o(300431);
      return;
      c.dJd().I(726, paramString);
      AppMethodBeat.o(300431);
      return;
      c.dJd().I(727, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300451);
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300451);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300461);
    this.zFd.a(3, null);
    AppMethodBeat.o(300461);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300437);
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFz.a(this.zEK, this.zEM);
    AppMethodBeat.o(300437);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300442);
    this.zFz.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.i
 * JD-Core Version:    0.7.0.1
 */