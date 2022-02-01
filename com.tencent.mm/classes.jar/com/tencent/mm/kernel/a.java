package com.tencent.mm.kernel;

import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h.b;
import androidx.lifecycle.k;
import androidx.lifecycle.m;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/kernel/AccountModelOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "lifecycle", "Lcom/tencent/mm/kernel/AccountModelOwner$AccountLifecycleRegistry;", "store", "Landroidx/lifecycle/ViewModelStore;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewModelStore", "onAccountInitialized", "", "onAccountRelease", "AccountLifecycleRegistry", "Companion", "mmkernel_release"})
public final class a
  implements ab, androidx.lifecycle.l
{
  public static final a.b kbw;
  private final a kbv;
  private final aa store;
  
  static
  {
    AppMethodBeat.i(195633);
    kbw = new a.b((byte)0);
    AppMethodBeat.o(195633);
  }
  
  public a()
  {
    AppMethodBeat.i(195631);
    this.store = new aa();
    this.kbv = new a();
    com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211379);
        a.a(this.kbx).b(h.b.ZP);
        AppMethodBeat.o(211379);
      }
    });
    AppMethodBeat.o(195631);
  }
  
  public final void aGp()
  {
    AppMethodBeat.i(195628);
    com.tencent.e.h.ZvG.bc((Runnable)new c(this));
    AppMethodBeat.o(195628);
  }
  
  public final androidx.lifecycle.h getLifecycle()
  {
    return (androidx.lifecycle.h)this.kbv;
  }
  
  public final aa getViewModelStore()
  {
    return this.store;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/kernel/AccountModelOwner$AccountLifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "(Lcom/tencent/mm/kernel/AccountModelOwner;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "mmkernel_release"})
  public final class a
    extends m
  {
    public a()
    {
      super();
      AppMethodBeat.i(204407);
      AppMethodBeat.o(204407);
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(204404);
      p.k(paramk, "observer");
      super.a(paramk);
      Log.i("MicroMsg.Mvvm.AccountModelOwner", "addObserver totalCount:" + jf() + " observer:" + paramk.hashCode());
      AppMethodBeat.o(204404);
    }
    
    public final void b(k paramk)
    {
      AppMethodBeat.i(204406);
      p.k(paramk, "observer");
      super.b(paramk);
      Log.i("MicroMsg.Mvvm.AccountModelOwner", "removeObserver totalCount:" + jf() + " observer:" + paramk.hashCode());
      AppMethodBeat.o(204406);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(208907);
      a.a(this.kbx).b(h.b.ZQ);
      Log.i("MicroMsg.Mvvm.AccountModelOwner", "onAccountInitialized");
      AppMethodBeat.o(208907);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(197578);
      a.a(this.kbx).b(h.b.ZO);
      a.b(this.kbx).clear();
      Log.i("MicroMsg.Mvvm.AccountModelOwner", "onAccountRelease");
      AppMethodBeat.o(197578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */