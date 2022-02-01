package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f zEK;
  private final p zEM;
  com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private a zFz;
  
  m()
  {
    AppMethodBeat.i(300374);
    this.zEK = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(300488);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(300488);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(300488);
          return;
        }
        m.this.zFd.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(300488);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(300480);
        com.tencent.mm.plugin.expt.hellhound.ext.a.a locala = m.this.zFd;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(300480);
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
        AppMethodBeat.i(300463);
        if (m.this.zFd != null) {
          m.this.zFd.oO(paramAnonymousBoolean);
        }
        AppMethodBeat.o(300463);
      }
    };
    this.zFz = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(1, "18260", "1001");
    AppMethodBeat.o(300374);
  }
  
  private static boolean dKg()
  {
    AppMethodBeat.i(300381);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dIK()) || (!com.tencent.mm.plugin.expt.hellhound.a.dIN()))
    {
      AppMethodBeat.o(300381);
      return true;
    }
    AppMethodBeat.o(300381);
    return false;
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300394);
    if (dKg())
    {
      Log.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(300394);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300394);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dJd().I(704, paramString);
      AppMethodBeat.o(300394);
      return;
      c.dJd().I(705, paramString);
      AppMethodBeat.o(300394);
      return;
      c.dJd().I(706, paramString);
      AppMethodBeat.o(300394);
      return;
      c.dJd().I(707, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300415);
    this.zFd.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(300415);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300422);
    this.zFd.a(3, null);
    AppMethodBeat.o(300422);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300401);
    if (this.mActivityRef != null) {
      this.zFd.a(0, (Activity)this.mActivityRef.get());
    }
    this.zFz.a(this.zEK, this.zEM);
    AppMethodBeat.o(300401);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300406);
    this.zFz.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.m
 * JD-Core Version:    0.7.0.1
 */