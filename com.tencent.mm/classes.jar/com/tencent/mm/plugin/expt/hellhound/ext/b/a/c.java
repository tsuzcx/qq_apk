package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  private a zFc;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  
  c()
  {
    AppMethodBeat.i(300405);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300509);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(300509);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300509);
          return;
        }
        c.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300509);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300500);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = c.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300500);
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
        AppMethodBeat.i(300497);
        if (c.this.zFd != null) {
          c.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300497);
      }
    };
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(6, "18260", "1006");
    AppMethodBeat.o(300405);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300413);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300413);
      return true;
    }
    AppMethodBeat.o(300413);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300427);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300427);
      return;
    }
    Log.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300427);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(720, paramString);
      AppMethodBeat.o(300427);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(721, paramString);
      AppMethodBeat.o(300427);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(722, paramString);
      AppMethodBeat.o(300427);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(723, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300445);
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300445);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300454);
    this.zFd.a(3, null);
    AppMethodBeat.o(300454);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300433);
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFc.a(this.zEK, this.zEM);
    AppMethodBeat.o(300433);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300440);
    this.zFc.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.c
 * JD-Core Version:    0.7.0.1
 */