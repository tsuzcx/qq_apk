package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private a zFz;
  
  k()
  {
    AppMethodBeat.i(300438);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300505);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(300505);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300505);
          return;
        }
        k.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300505);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300490);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = k.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300490);
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
        AppMethodBeat.i(300481);
        if (k.this.zFd != null) {
          k.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300481);
      }
    };
    this.zFz = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(2, "18260", "1002");
    AppMethodBeat.o(300438);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300444);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300444);
      return true;
    }
    AppMethodBeat.o(300444);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300456);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300456);
      return;
    }
    Log.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300456);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dJd().I(708, paramString);
      AppMethodBeat.o(300456);
      return;
      c.dJd().I(709, paramString);
      AppMethodBeat.o(300456);
      return;
      c.dJd().I(710, paramString);
      AppMethodBeat.o(300456);
      return;
      c.dJd().I(711, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300476);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300476);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300484);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.zFd.a(3, null);
    AppMethodBeat.o(300484);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300465);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFz.a(this.zEK, this.zEM);
    AppMethodBeat.o(300465);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300470);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.zFz.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.k
 * JD-Core Version:    0.7.0.1
 */