package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class m
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private a qUX;
  private final e qUj;
  private final p qUl;
  
  m()
  {
    AppMethodBeat.i(210421);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210419);
        if (m.this.mActivityRef == null)
        {
          AppMethodBeat.o(210419);
          return;
        }
        Activity localActivity = (Activity)m.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210419);
          return;
        }
        m.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210419);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210418);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = m.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210418);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.qUl = new p()
    {
      public final void kZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(210420);
        if (m.this.qUB != null) {
          m.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210420);
      }
    };
    this.qUX = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(1, "18260", "1001");
    AppMethodBeat.o(210421);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210422);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210422);
      return;
    }
    ad.i("HABBYGE-MALI.FinderTimelineMonitor", "FinderTimelineMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210422);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cnO().l(704, paramString);
      AppMethodBeat.o(210422);
      return;
      c.cnO().l(705, paramString);
      AppMethodBeat.o(210422);
      return;
      c.cnO().l(706, paramString);
      AppMethodBeat.o(210422);
      return;
      c.cnO().l(707, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210424);
    this.qUX.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210424);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210423);
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUX.a(this.qUj, this.qUl);
    AppMethodBeat.o(210423);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210425);
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210425);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210426);
    this.qUB.a(3, null);
    AppMethodBeat.o(210426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */