package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f wiH;
  private final p wiJ;
  com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private a wjw;
  
  k()
  {
    AppMethodBeat.i(255978);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(251173);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(251173);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(251173);
          return;
        }
        k.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(251173);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(251172);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(251172);
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
        AppMethodBeat.i(255778);
        if (k.this.wja != null) {
          k.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(255778);
      }
    };
    this.wjw = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(255978);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255981);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(255981);
      return;
    }
    Log.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255981);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dcB().p(708, paramString);
      AppMethodBeat.o(255981);
      return;
      c.dcB().p(709, paramString);
      AppMethodBeat.o(255981);
      return;
      c.dcB().p(710, paramString);
      AppMethodBeat.o(255981);
      return;
      c.dcB().p(711, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(255988);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(255988);
  }
  
  public final void report()
  {
    AppMethodBeat.i(255990);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.wja.a(3, null);
    AppMethodBeat.o(255990);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(255984);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wjw.a(this.wiH, this.wiJ);
    AppMethodBeat.o(255984);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(255986);
    Log.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.wjw.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(255986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */