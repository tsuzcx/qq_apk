package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private a zFz;
  
  l()
  {
    AppMethodBeat.i(300378);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300542);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(300542);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300542);
          return;
        }
        l.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300542);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300539);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = l.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300539);
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
        AppMethodBeat.i(300527);
        if (l.this.zFd != null) {
          l.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300527);
      }
    };
    this.zFz = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(5, "18260", "1005");
    AppMethodBeat.o(300378);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300390);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300390);
      return true;
    }
    AppMethodBeat.o(300390);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300398);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300398);
      return;
    }
    Log.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300398);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dJd().I(716, paramString);
      AppMethodBeat.o(300398);
      return;
      c.dJd().I(717, paramString);
      AppMethodBeat.o(300398);
      return;
      c.dJd().I(718, paramString);
      AppMethodBeat.o(300398);
      return;
      c.dJd().I(719, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300420);
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300420);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300426);
    this.zFd.a(3, null);
    AppMethodBeat.o(300426);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300404);
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFz.a(this.zEK, this.zEM);
    AppMethodBeat.o(300404);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300410);
    this.zFz.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.l
 * JD-Core Version:    0.7.0.1
 */