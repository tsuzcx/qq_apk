package com.tencent.mm.kernel;

import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.mvvm.f;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/AccountModelOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "accountScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getAccountScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "setAccountScope", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "lifecycle", "Lcom/tencent/mm/kernel/AccountModelOwner$AccountLifecycleRegistry;", "store", "Landroidx/lifecycle/ViewModelStore;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewModelStore", "onAccountInitialized", "", "onAccountRelease", "AccountLifecycleRegistry", "Companion", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ak, q
{
  public static final a.b mBA;
  public LifecycleScope mBB;
  final a mBC;
  private final aj store;
  
  static
  {
    AppMethodBeat.i(235238);
    mBA = new a.b((byte)0);
    AppMethodBeat.o(235238);
  }
  
  public a()
  {
    AppMethodBeat.i(235235);
    this.store = new aj();
    this.mBC = new a();
    AppMethodBeat.o(235235);
  }
  
  public final void aZq()
  {
    AppMethodBeat.i(235241);
    a locala = this.mBC;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToCreateState start");
    Object localObject1 = locala.observerMap;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (List)localObject1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)ab.aivy;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        Object localObject3 = localObject2.getClass().getMethods();
        s.s(localObject3, "observer::class.java.methods");
        localObject3 = (Object[])localObject3;
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Method localMethod = (Method)localObject3[i];
          z localz = (z)localMethod.getAnnotation(z.class);
          if ((localz != null) && (localz.Ho() == j.a.ON_CREATE)) {
            localMethod.invoke(localObject2, new Object[0]);
          }
          i += 1;
        }
      }
      localObject2 = (Map)localObject1;
      localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((p)((Map.Entry)((Iterator)localObject2).next()).getValue());
      }
    }
    locala.state = j.b.bHi;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToCreateState end");
    this.mBB = new LifecycleScope("AccountScope", (q)this, 4);
    AppMethodBeat.o(235241);
  }
  
  public final j getLifecycle()
  {
    return (j)this.mBC;
  }
  
  public final aj getViewModelStore()
  {
    return this.store;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/AccountModelOwner$AccountLifecycleRegistry;", "Lcom/tencent/mm/kernel/mvvm/PluginLifecycleRegistry;", "(Lcom/tencent/mm/kernel/AccountModelOwner;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends f
  {
    public a()
    {
      AppMethodBeat.i(235244);
      AppMethodBeat.o(235244);
    }
    
    public final void addObserver(p paramp)
    {
      AppMethodBeat.i(235246);
      s.u(paramp, "observer");
      super.addObserver(paramp);
      StringBuilder localStringBuilder = new StringBuilder("addObserver totalCount:");
      Object localObject = this.observerMap;
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((ConcurrentHashMap)localObject).size()))
      {
        Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", localObject + " observer:" + paramp);
        AppMethodBeat.o(235246);
        return;
      }
    }
    
    public final void removeObserver(p paramp)
    {
      AppMethodBeat.i(235249);
      s.u(paramp, "observer");
      super.removeObserver(paramp);
      StringBuilder localStringBuilder = new StringBuilder("removeObserver totalCount:");
      Object localObject = this.observerMap;
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((ConcurrentHashMap)localObject).size()))
      {
        Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", localObject + " observer:" + paramp);
        AppMethodBeat.o(235249);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */