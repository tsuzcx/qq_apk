package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class k
  implements o
{
  WeakReference<Activity> mActivityRef;
  private a rcV;
  private final e rch;
  private final p rcj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  k()
  {
    AppMethodBeat.i(196063);
    this.rch = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196061);
        if (k.this.mActivityRef == null)
        {
          AppMethodBeat.o(196061);
          return;
        }
        Activity localActivity = (Activity)k.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ae.m("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(196061);
          return;
        }
        k.this.rcz.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(196061);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(196060);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = k.this.rcz;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(196060);
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
        AppMethodBeat.i(196062);
        if (k.this.rcz != null) {
          k.this.rcz.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(196062);
      }
    };
    this.rcV = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(2, "18260", "1002");
    AppMethodBeat.o(196063);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196064);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(196064);
      return;
    }
    ae.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196064);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cpq().l(708, paramString);
      AppMethodBeat.o(196064);
      return;
      c.cpq().l(709, paramString);
      AppMethodBeat.o(196064);
      return;
      c.cpq().l(710, paramString);
      AppMethodBeat.o(196064);
      return;
      c.cpq().l(711, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196066);
    ae.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
    this.rcV.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196066);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196065);
    ae.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
    if (this.mActivityRef != null) {
      this.rcz.a(0, (Activity)this.mActivityRef.get());
    }
    this.rcV.a(this.rch, this.rcj);
    AppMethodBeat.o(196065);
  }
  
  public final void free()
  {
    AppMethodBeat.i(196067);
    ae.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
    this.rcz.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(196067);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196068);
    ae.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
    this.rcz.a(3, null);
    AppMethodBeat.o(196068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.k
 * JD-Core Version:    0.7.0.1
 */