package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f wiH;
  private final p wiJ;
  com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private a wjw;
  
  m()
  {
    AppMethodBeat.i(255369);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(256827);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(256827);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(256827);
          return;
        }
        m.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(256827);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(256823);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(256823);
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
        AppMethodBeat.i(256566);
        if (m.this.wja != null) {
          m.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(256566);
      }
    };
    this.wjw = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(255369);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(255372);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(255372);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255372);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dcB().p(704, paramString);
      AppMethodBeat.o(255372);
      return;
      c.dcB().p(705, paramString);
      AppMethodBeat.o(255372);
      return;
      c.dcB().p(706, paramString);
      AppMethodBeat.o(255372);
      return;
      c.dcB().p(707, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(255378);
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(255378);
  }
  
  public final void report()
  {
    AppMethodBeat.i(255379);
    this.wja.a(3, null);
    AppMethodBeat.o(255379);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(255374);
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wjw.a(this.wiH, this.wiJ);
    AppMethodBeat.o(255374);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(255376);
    this.wjw.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(255376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */