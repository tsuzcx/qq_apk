package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final f wiH;
  private final p wiJ;
  com.tencent.mm.plugin.expt.hellhound.a.a.a wja;
  private a wjw;
  
  n()
  {
    AppMethodBeat.i(254921);
    this.wiH = new f()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(256257);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(256257);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          Log.printInfoStack("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(256257);
          return;
        }
        n.this.wja.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(256257);
      }
      
      public final void k(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(256255);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = n.this.wja;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.g(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(256255);
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
        AppMethodBeat.i(252018);
        if (n.this.wja != null) {
          n.this.wja.no(paramAnonymousBoolean);
        }
        AppMethodBeat.o(252018);
      }
    };
    this.wjw = new a();
    this.wja = new com.tencent.mm.plugin.expt.hellhound.a.a.a(3, "18260", "1003");
    AppMethodBeat.o(254921);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(254923);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dcj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(254923);
      return;
    }
    Log.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(254923);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.dcB().p(712, paramString);
      AppMethodBeat.o(254923);
      return;
      c.dcB().p(713, paramString);
      AppMethodBeat.o(254923);
      return;
      c.dcB().p(714, paramString);
      AppMethodBeat.o(254923);
      return;
      c.dcB().p(715, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(254929);
    this.wja.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(254929);
  }
  
  public final void report()
  {
    AppMethodBeat.i(254930);
    this.wja.a(3, null);
    AppMethodBeat.o(254930);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(254925);
    if (this.mActivityRef != null) {
      this.wja.a(0, (Activity)this.mActivityRef.get());
    }
    this.wjw.a(this.wiH, this.wiJ);
    AppMethodBeat.o(254925);
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(254927);
    this.wjw.stopMonitor();
    this.wja.a(1, null);
    AppMethodBeat.o(254927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */