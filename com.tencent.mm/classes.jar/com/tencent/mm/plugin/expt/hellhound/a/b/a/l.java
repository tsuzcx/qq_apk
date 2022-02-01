package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private a qUX;
  private final e qUj;
  private final p qUl;
  
  l()
  {
    AppMethodBeat.i(210412);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210410);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(210410);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210410);
          return;
        }
        l.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210410);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210409);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210409);
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
        AppMethodBeat.i(210411);
        if (l.this.qUB != null) {
          l.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210411);
      }
    };
    this.qUX = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(210412);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210413);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210413);
      return;
    }
    ad.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210413);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cnO().l(716, paramString);
      AppMethodBeat.o(210413);
      return;
      c.cnO().l(717, paramString);
      AppMethodBeat.o(210413);
      return;
      c.cnO().l(718, paramString);
      AppMethodBeat.o(210413);
      return;
      c.cnO().l(719, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210415);
    this.qUX.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210415);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210414);
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUX.a(this.qUj, this.qUl);
    AppMethodBeat.o(210414);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210416);
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210416);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210417);
    this.qUB.a(3, null);
    AppMethodBeat.o(210417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */