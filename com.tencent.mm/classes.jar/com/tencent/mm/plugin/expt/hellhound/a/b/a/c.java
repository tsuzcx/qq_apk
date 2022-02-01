package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class c
  implements o
{
  WeakReference<Activity> mActivityRef;
  private final e rch;
  private final p rcj;
  private a rcy;
  com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  c()
  {
    AppMethodBeat.i(196045);
    this.rch = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196043);
        if (c.this.mActivityRef == null)
        {
          AppMethodBeat.o(196043);
          return;
        }
        Activity localActivity = (Activity)c.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ae.m("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(196043);
          return;
        }
        c.this.rcz.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(196043);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(196042);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = c.this.rcz;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(196042);
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
        AppMethodBeat.i(196044);
        if (c.this.rcz != null) {
          c.this.rcz.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(196044);
      }
    };
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(6, "18260", "1006");
    AppMethodBeat.o(196045);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196046);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(196046);
      return;
    }
    ae.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196046);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(720, paramString);
      AppMethodBeat.o(196046);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(721, paramString);
      AppMethodBeat.o(196046);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(722, paramString);
      AppMethodBeat.o(196046);
      return;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(723, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196048);
    this.rcy.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196048);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196047);
    if (this.mActivityRef != null) {
      this.rcz.a(0, (Activity)this.mActivityRef.get());
    }
    this.rcy.a(this.rch, this.rcj);
    AppMethodBeat.o(196047);
  }
  
  public final void free()
  {
    AppMethodBeat.i(196049);
    this.rcz.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(196049);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196050);
    this.rcz.a(3, null);
    AppMethodBeat.o(196050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */