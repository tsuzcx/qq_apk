package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class n
  implements o
{
  WeakReference<Activity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private a qUX;
  private final e qUj;
  private final p qUl;
  
  n()
  {
    AppMethodBeat.i(210430);
    this.qUj = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(210428);
        if (n.this.mActivityRef == null)
        {
          AppMethodBeat.o(210428);
          return;
        }
        Activity localActivity = (Activity)n.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ad.m("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(210428);
          return;
        }
        n.this.qUB.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(210428);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(210427);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = n.this.qUB;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(210427);
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
        AppMethodBeat.i(210429);
        if (n.this.qUB != null) {
          n.this.qUB.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(210429);
      }
    };
    this.qUX = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(3, "18260", "1003");
    AppMethodBeat.o(210430);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210431);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnw())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(210431);
      return;
    }
    ad.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210431);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cnO().l(712, paramString);
      AppMethodBeat.o(210431);
      return;
      c.cnO().l(713, paramString);
      AppMethodBeat.o(210431);
      return;
      c.cnO().l(714, paramString);
      AppMethodBeat.o(210431);
      return;
      c.cnO().l(715, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210433);
    this.qUX.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210433);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210432);
    if (this.mActivityRef != null) {
      this.qUB.a(0, (Activity)this.mActivityRef.get());
    }
    this.qUX.a(this.qUj, this.qUl);
    AppMethodBeat.o(210432);
  }
  
  public final void free()
  {
    AppMethodBeat.i(210434);
    this.qUB.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(210434);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210435);
    this.qUB.a(3, null);
    AppMethodBeat.o(210435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.n
 * JD-Core Version:    0.7.0.1
 */