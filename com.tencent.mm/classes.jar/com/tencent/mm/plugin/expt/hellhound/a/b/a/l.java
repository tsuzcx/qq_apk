package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f wiH;
  private final p wiJ;
  com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private a wjw;
  
  l()
  {
    AppMethodBeat.i(254020);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(256790);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(256790);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(256790);
          return;
        }
        l.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(256790);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(256788);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(256788);
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
        AppMethodBeat.i(256650);
        if (l.this.wja != null) {
          l.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(256650);
      }
    };
    this.wjw = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(254020);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(254023);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(254023);
      return;
    }
    Log.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(254023);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dcB().p(716, paramString);
      AppMethodBeat.o(254023);
      return;
      c.dcB().p(717, paramString);
      AppMethodBeat.o(254023);
      return;
      c.dcB().p(718, paramString);
      AppMethodBeat.o(254023);
      return;
      c.dcB().p(719, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(254029);
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(254029);
  }
  
  public final void report()
  {
    AppMethodBeat.i(254031);
    this.wja.a(3, null);
    AppMethodBeat.o(254031);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(254025);
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wjw.a(this.wiH, this.wiJ);
    AppMethodBeat.o(254025);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(254026);
    this.wjw.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(254026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */