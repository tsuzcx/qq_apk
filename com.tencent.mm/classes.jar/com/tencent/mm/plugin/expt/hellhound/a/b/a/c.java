package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  WeakReference<Activity> mActivityRef;
  private a qUA;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final e qUj;
  private final p qUl;
  
  c()
  {
    AppMethodBeat.i(210385);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210383);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(210383);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210383);
          return;
        }
        c.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210383);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210382);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210382);
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
        AppMethodBeat.i(210384);
        if (c.this.qUB != null) {
          c.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210384);
      }
    };
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(210385);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210386);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210386);
      return;
    }
    ad.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210386);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(720, paramString);
      AppMethodBeat.o(210386);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(721, paramString);
      AppMethodBeat.o(210386);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(722, paramString);
      AppMethodBeat.o(210386);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(723, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210388);
    this.qUA.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210388);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210387);
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUA.a(this.qUj, this.qUl);
    AppMethodBeat.o(210387);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210389);
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210389);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210390);
    this.qUB.a(3, null);
    AppMethodBeat.o(210390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */