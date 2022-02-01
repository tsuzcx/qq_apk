package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class l
  implements o
{
  WeakReference<Activity> mActivityRef;
  private a rcV;
  private final e rch;
  private final p rcj;
  com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  l()
  {
    AppMethodBeat.i(196072);
    this.rch = new e()
    {
      public final void a(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(196070);
        if (l.this.mActivityRef == null)
        {
          AppMethodBeat.o(196070);
          return;
        }
        Activity localActivity = (Activity)l.this.mActivityRef.get();
        if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed()))
        {
          ae.m("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, onScroll, is NULL or finishing", new Object[0]);
          AppMethodBeat.o(196070);
          return;
        }
        l.this.rcz.a(localActivity, paramAnonymousViewGroup, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(196070);
      }
      
      public final void l(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
      {
        AppMethodBeat.i(196069);
        com.tencent.mm.plugin.expt.hellhound.a.a.a locala = l.this.rcz;
        switch (paramAnonymousInt)
        {
        default: 
          paramAnonymousInt = -1;
        }
        for (;;)
        {
          locala.h(paramAnonymousViewGroup, paramAnonymousInt);
          AppMethodBeat.o(196069);
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
        AppMethodBeat.i(196071);
        if (l.this.rcz != null) {
          l.this.rcz.kY(paramAnonymousBoolean);
        }
        AppMethodBeat.o(196071);
      }
    };
    this.rcV = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(5, "18260", "1005");
    AppMethodBeat.o(196072);
  }
  
  final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196073);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.coV()) || (!com.tencent.mm.plugin.expt.hellhound.a.coY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor, dontNeedMonitorFinder true !!");
      AppMethodBeat.o(196073);
      return;
    }
    ae.i("HABBYGE-MALI.FinderSearchMonitor", "FinderSearchMonitor, monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196073);
      return;
      this.mActivityRef = new WeakReference(paramActivity);
      c.cpq().l(716, paramString);
      AppMethodBeat.o(196073);
      return;
      c.cpq().l(717, paramString);
      AppMethodBeat.o(196073);
      return;
      c.cpq().l(718, paramString);
      AppMethodBeat.o(196073);
      return;
      c.cpq().l(719, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196075);
    this.rcV.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196075);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196074);
    if (this.mActivityRef != null) {
      this.rcz.a(0, (Activity)this.mActivityRef.get());
    }
    this.rcV.a(this.rch, this.rcj);
    AppMethodBeat.o(196074);
  }
  
  public final void free()
  {
    AppMethodBeat.i(196076);
    this.rcz.a(2, null);
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    AppMethodBeat.o(196076);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196077);
    this.rcz.a(3, null);
    AppMethodBeat.o(196077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.l
 * JD-Core Version:    0.7.0.1
 */