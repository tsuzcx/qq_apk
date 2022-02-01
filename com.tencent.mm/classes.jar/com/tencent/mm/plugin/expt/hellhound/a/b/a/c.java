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
  private final f wiH;
  private final p wiJ;
  private a wiZ;
  com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  
  c()
  {
    AppMethodBeat.i(255599);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(255973);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(255973);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(255973);
          return;
        }
        c.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(255973);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(255970);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(255970);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.wiJ = new p()
    {
      public final void np(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(252126);
        if (c.this.wja != null) {
          c.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(252126);
      }
    };
    this.wiZ = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(255599);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255602);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(255602);
      return;
    }
    Log.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255602);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(720, paramString);
      AppMethodBeat.o(255602);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(721, paramString);
      AppMethodBeat.o(255602);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(722, paramString);
      AppMethodBeat.o(255602);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(723, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(255607);
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(255607);
  }
  
  public final void report()
  {
    AppMethodBeat.i(255608);
    this.wja.a(3, null);
    AppMethodBeat.o(255608);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(255604);
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wiZ.a(this.wiH, this.wiJ);
    AppMethodBeat.o(255604);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(255605);
    this.wiZ.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(255605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */