package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private a zFz;
  
  n()
  {
    AppMethodBeat.i(300388);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300531);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(300531);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300531);
          return;
        }
        n.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300531);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300523);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = n.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300523);
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
        AppMethodBeat.i(300522);
        if (n.this.zFd != null) {
          n.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300522);
      }
    };
    this.zFz = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(3, "18260", "1003");
    AppMethodBeat.o(300388);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300396);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300396);
      return true;
    }
    AppMethodBeat.o(300396);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300403);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300403);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300403);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dJd().I(712, paramString);
      AppMethodBeat.o(300403);
      return;
      c.dJd().I(713, paramString);
      AppMethodBeat.o(300403);
      return;
      c.dJd().I(714, paramString);
      AppMethodBeat.o(300403);
      return;
      c.dJd().I(715, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300425);
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300425);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300432);
    this.zFd.a(3, null);
    AppMethodBeat.o(300432);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300408);
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFz.a(this.zEK, this.zEM);
    AppMethodBeat.o(300408);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300418);
    this.zFz.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.n
 * JD-Core Version:    0.7.0.1
 */