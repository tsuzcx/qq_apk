package com.tencent.mm.kernel.mvvm;

import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.plugin.PluginLifecycleRegistry;
import com.tencent.mm.sdk.statecenter.BaseState;
import com.tencent.mm.sdk.statecenter.ServiceStateCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/mvvm/IMvvmPlugin;", "()V", "lifecycle", "Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry;", "getLifecycle", "()Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry;", "lifecycle$delegate", "Lkotlin/Lazy;", "pluginComponentSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "Lkotlin/collections/HashSet;", "stateCenterPLC", "Lcom/tencent/mm/kernel/mvvm/MvvmStateCenterPLC;", "store", "Landroidx/lifecycle/ViewModelStore;", "getStore", "()Landroidx/lifecycle/ViewModelStore;", "store$delegate", "workerScopePLC", "Lcom/tencent/mm/kernel/mvvm/MvvmWorkerPLC;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Landroidx/lifecycle/Lifecycle;", "getLogTag", "", "getStateCenter", "Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "getViewModelStore", "getWorkScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "importPluginComponents", "set", "Ljava/lang/Class;", "onAccountInit", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountInitAfter", "onAccountInitBefore", "onAccountInitialized", "onAccountRelease", "onAccountReleaseAfter", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MvvmPlugin
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, a
{
  private final kotlin.j hfL = k.cm((kotlin.g.a.a)a.mFx);
  private final kotlin.j mFt = k.cm((kotlin.g.a.a)MvvmPlugin.b.mFy);
  private c<?> mFu;
  private d mFv;
  private final HashSet<e> mFw = new HashSet();
  
  private final PluginLifecycleRegistry getLifecycle()
  {
    return (PluginLifecycleRegistry)this.hfL.getValue();
  }
  
  private final aj getStore()
  {
    return (aj)this.mFt.getValue();
  }
  
  public void execute(g paramg) {}
  
  public final androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)getLifecycle();
  }
  
  public String getLogTag()
  {
    return "MicroMsg.Mvvm.MvvmPlugin";
  }
  
  public final <State extends BaseState> ServiceStateCenter<State> getStateCenter()
  {
    Object localObject = this.mFu;
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof ServiceStateCenter); localObject = ((c)localObject).mFz) {
      return localObject;
    }
    return null;
  }
  
  public final aj getViewModelStore()
  {
    return getStore();
  }
  
  public final LifecycleScope getWorkScope()
  {
    d locald = this.mFv;
    if (locald == null) {
      return null;
    }
    return locald.mFA;
  }
  
  public void importPluginComponents(HashSet<Class<? extends e>> paramHashSet)
  {
    s.u(paramHashSet, "set");
  }
  
  public void onAccountInit(f.c paramc) {}
  
  public void onAccountInitAfter(f.c paramc) {}
  
  public void onAccountInitBefore(f.c paramc) {}
  
  public final void onAccountInitialized(f.c paramc)
  {
    Log.i(getLogTag(), "onAccountInitialized start");
    Object localObject1 = new HashSet();
    importPluginComponents((HashSet)localObject1);
    Object localObject2 = getLogTag();
    Object localObject4 = (Iterable)localObject1;
    Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(((Class)((Iterator)localObject4).next()).getName());
    }
    Log.i((String)localObject2, s.X("create component:", (List)localObject3));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Class)((Iterator)localObject1).next();
      localObject3 = e.mFB;
      localObject2 = e.a.a((a)this, (Class)localObject2);
      this.mFw.add(localObject2);
      if ((localObject2 instanceof c)) {
        this.mFu = ((c)localObject2);
      }
      if ((localObject2 instanceof d)) {
        this.mFv = ((d)localObject2);
      }
    }
    onAccountInitBefore(paramc);
    localObject1 = ((Iterable)this.mFw).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e)((Iterator)localObject1).next()).bbx();
    }
    Log.i(getLogTag(), "onAccountInitialized before end");
    onAccountInit(paramc);
    localObject1 = ((Iterable)this.mFw).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e)((Iterator)localObject1).next()).bbz();
    }
    Log.i(getLogTag(), "onAccountInitialized init end");
    getLifecycle().moveToCreateState();
    onAccountInitAfter(paramc);
    paramc = ((Iterable)this.mFw).iterator();
    while (paramc.hasNext()) {
      paramc.next();
    }
    Log.i(getLogTag(), "onAccountInitialized after end");
  }
  
  public final void onAccountRelease()
  {
    Iterator localIterator = ((Iterable)this.mFw).iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).onAccountRelease();
    }
    this.mFw.clear();
    onAccountReleaseAfter();
    getViewModelStore().clear();
    getLifecycle().moveToDestroyState();
    Log.i(getLogTag(), "onAccountRelease");
  }
  
  public void onAccountReleaseAfter() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/plugin/PluginLifecycleRegistry;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<PluginLifecycleRegistry>
  {
    public static final a mFx;
    
    static
    {
      AppMethodBeat.i(235266);
      mFx = new a();
      AppMethodBeat.o(235266);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.MvvmPlugin
 * JD-Core Version:    0.7.0.1
 */