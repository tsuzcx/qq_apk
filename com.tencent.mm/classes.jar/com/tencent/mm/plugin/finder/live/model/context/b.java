package com.tencent.mm.plugin.finder.live.model.context;

import androidx.lifecycle.aa;
import androidx.lifecycle.x;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext;", "Lcom/tencent/mm/ui/component/IModel;", "()V", "storeMap", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/ViewModel;", "Lkotlin/collections/HashMap;", "viewModel", "Landroidx/lifecycle/ViewModelStore;", "clear", "", "getViewModelStore", "plugin-finder-base_release"})
public abstract class b
  implements c
{
  private final HashMap<String, x> ykt = new HashMap();
  private final aa yku = new aa();
  
  public b()
  {
    Log.i("LiveContext", "init check map " + this.ykt);
    Object localObject2 = aa.class.getDeclaredField("aaP");
    p.j(localObject2, "ViewModelStore::class.ja….getDeclaredField(\"mMap\")");
    ((Field)localObject2).setAccessible(true);
    Object localObject1 = ((Field)localObject2).get(this.yku);
    ((Field)localObject2).set(this.yku, this.ykt);
    localObject2 = ((Field)localObject2).get(this.yku);
    Log.i("LiveContext", "init check map srcMap1:" + localObject1.hashCode() + " srcMap2:" + localObject2.hashCode() + " storeMap:" + this.ykt.hashCode());
  }
  
  public final void clear()
  {
    Log.i("LiveContext", "LiveContext clear " + this.ykt.size());
    Iterator localIterator = ((Map)this.ykt).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = ((Map.Entry)localIterator.next()).getValue();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof a)) {
        localObject1 = null;
      }
      localObject1 = (a)localObject1;
      if (localObject1 != null) {
        ((a)localObject1).reset();
      }
    }
  }
  
  public aa getViewModelStore()
  {
    return this.yku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.context.b
 * JD-Core Version:    0.7.0.1
 */