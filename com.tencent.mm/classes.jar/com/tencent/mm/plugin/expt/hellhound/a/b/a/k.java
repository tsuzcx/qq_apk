package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private a qUX;
  private final e qUj;
  private final p qUl;
  
  k()
  {
    AppMethodBeat.i(210403);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210401);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(210401);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210401);
          return;
        }
        k.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210401);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210400);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210400);
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
        AppMethodBeat.i(210402);
        if (k.this.qUB != null) {
          k.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210402);
      }
    };
    this.qUX = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(210403);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210404);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210404);
      return;
    }
    ad.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210404);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cnO().l(708, paramString);
      AppMethodBeat.o(210404);
      return;
      c.cnO().l(709, paramString);
      AppMethodBeat.o(210404);
      return;
      c.cnO().l(710, paramString);
      AppMethodBeat.o(210404);
      return;
      c.cnO().l(711, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210406);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.qUX.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210406);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210405);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUX.a(this.qUj, this.qUl);
    AppMethodBeat.o(210405);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210407);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210407);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210408);
    ad.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.qUB.a(3, null);
    AppMethodBeat.o(210408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */