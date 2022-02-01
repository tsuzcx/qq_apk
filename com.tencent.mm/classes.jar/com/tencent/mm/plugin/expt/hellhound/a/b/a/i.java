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
  private final f wiH;
  private final p wiJ;
  final com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private final a wjw;
  
  i()
  {
    AppMethodBeat.i(251210);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(251643);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(251643);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(251643);
          return;
        }
        i.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(251643);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(251642);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(251642);
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
        AppMethodBeat.i(254238);
        if (i.this.wja != null) {
          i.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(254238);
      }
    };
    this.wjw = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(251210);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(251211);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(251211);
      return;
    }
    Log.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251211);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dcB().p(724, paramString);
      AppMethodBeat.o(251211);
      return;
      c.dcB().p(725, paramString);
      AppMethodBeat.o(251211);
      return;
      c.dcB().p(726, paramString);
      AppMethodBeat.o(251211);
      return;
      c.dcB().p(727, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(251214);
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(251214);
  }
  
  public final void report()
  {
    AppMethodBeat.i(251215);
    this.wja.a(3, null);
    AppMethodBeat.o(251215);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(251212);
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wjw.a(this.wiH, this.wiJ);
    AppMethodBeat.o(251212);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(251213);
    this.wjw.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(251213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */