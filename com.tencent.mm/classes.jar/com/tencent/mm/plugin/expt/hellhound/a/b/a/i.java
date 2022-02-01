package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class i
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final a rcV;
  private final e rch;
  private final p rcj;
  final com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  i()
  {
    AppMethodBeat.i(196054);
    this.rch = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196052);
        if (i.this.mActivityRef == null)
        {
          AppMethodBeat.o(196052);
          return;
        }
        Activity localActivity = (Activity)i.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ae.m("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(196052);
          return;
        }
        i.this.rcz.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(196052);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(196051);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = i.this.rcz;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(196051);
          return;
          paramAnonymousInt = 0;
          continue;
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 2;
        }
      }
    };
    this.rcj = new p()
    {
      public final void kZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196053);
        if (i.this.rcz != null) {
          i.this.rcz.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(196053);
      }
    };
    this.rcV = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(4, "18260", "1004");
    AppMethodBeat.o(196054);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196055);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(196055);
      return;
    }
    ae.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196055);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cpq().l(724, paramString);
      AppMethodBeat.o(196055);
      return;
      c.cpq().l(725, paramString);
      AppMethodBeat.o(196055);
      return;
      c.cpq().l(726, paramString);
      AppMethodBeat.o(196055);
      return;
      c.cpq().l(727, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196057);
    this.rcV.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196057);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196056);
    if (this.mActivityRef != null) {
      this.rcz.a(0, (Activity)this.mActivityRef.get());
    }
    this.rcV.a(this.rch, this.rcj);
    AppMethodBeat.o(196056);
  }
  
  public final void free()
  {
    AppMethodBeat.i(196058);
    this.rcz.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(196058);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196059);
    this.rcz.a(3, null);
    AppMethodBeat.o(196059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */