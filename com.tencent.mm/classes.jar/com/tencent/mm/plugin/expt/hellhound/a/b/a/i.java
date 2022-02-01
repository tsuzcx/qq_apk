package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  WeakReference<Activity> mActivityRef;
  final com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final a qUX;
  private final e qUj;
  private final p qUl;
  
  i()
  {
    AppMethodBeat.i(210394);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210392);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(210392);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210392);
          return;
        }
        i.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210392);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210391);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210391);
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
        AppMethodBeat.i(210393);
        if (i.this.qUB != null) {
          i.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210393);
      }
    };
    this.qUX = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(210394);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210395);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210395);
      return;
    }
    ad.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210395);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cnO().l(724, paramString);
      AppMethodBeat.o(210395);
      return;
      c.cnO().l(725, paramString);
      AppMethodBeat.o(210395);
      return;
      c.cnO().l(726, paramString);
      AppMethodBeat.o(210395);
      return;
      c.cnO().l(727, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210397);
    this.qUX.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210397);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210396);
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUX.a(this.qUj, this.qUl);
    AppMethodBeat.o(210396);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210398);
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210398);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210399);
    this.qUB.a(3, null);
    AppMethodBeat.o(210399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */