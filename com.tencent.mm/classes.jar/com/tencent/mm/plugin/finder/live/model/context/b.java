package com.tencent.mm.plugin.finder.live.model.context;

import androidx.lifecycle.af;
import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.f;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext;", "Lcom/tencent/mm/ui/component/IModel;", "()V", "storeMap", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext$SafeHashMap;", "", "Landroidx/lifecycle/ViewModel;", "viewModel", "Landroidx/lifecycle/ViewModelStore;", "clear", "", "getViewModelStore", "SafeHashMap", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements f
{
  private final a<String, af> CMp = new a();
  private final aj CMq = new aj();
  
  public b()
  {
    Log.i("LiveContext", s.X("init check map ", this.CMp));
    Object localObject2 = aj.class.getDeclaredField("bIx");
    ((Field)localObject2).setAccessible(true);
    Object localObject1 = ((Field)localObject2).get(this.CMq);
    ((Field)localObject2).set(this.CMq, this.CMp);
    localObject2 = ((Field)localObject2).get(this.CMq);
    Log.i("LiveContext", "init check map srcMap1:" + localObject1.hashCode() + " srcMap2:" + localObject2.hashCode() + " storeMap:" + this.CMp.hashCode());
  }
  
  public final void clear()
  {
    Log.i("LiveContext", s.X("LiveContext clear ", Integer.valueOf(this.CMp.size())));
    for (;;)
    {
      try
      {
        synchronized ((Map)this.CMp)
        {
          Iterator localIterator = ((Map)???).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject1 = (Map.Entry)localIterator.next();
          Log.i("LiveContext", s.X("clear ", ((Map.Entry)localObject1).getValue().getClass().getSimpleName()));
          localObject1 = ((Map.Entry)localObject1).getValue();
          if ((localObject1 instanceof c))
          {
            localObject1 = (c)localObject1;
            if (localObject1 == null) {
              continue;
            }
            ((c)localObject1).reset();
          }
        }
        localah = null;
      }
      catch (Exception localException)
      {
        ??? = aw.Gjk;
        aw.a(localException, "LiveContext clear");
        return;
      }
    }
    ah localah = ah.aiuX;
  }
  
  public aj getViewModelStore()
  {
    return this.CMq;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext$SafeHashMap;", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "()V", "clear", "", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<K, V>
    extends HashMap<K, V>
  {
    public final void clear()
    {
      try
      {
        AppMethodBeat.i(359761);
        Log.i("LiveContext", "clear(" + hashCode() + ')');
        super.clear();
        AppMethodBeat.o(359761);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final V get(Object paramObject)
    {
      try
      {
        AppMethodBeat.i(359741);
        paramObject = super.get(paramObject);
        AppMethodBeat.o(359741);
        return paramObject;
      }
      finally
      {
        paramObject = finally;
        throw paramObject;
      }
    }
    
    public final V put(K paramK, V paramV)
    {
      try
      {
        AppMethodBeat.i(359749);
        Log.i("LiveContext", "put(" + hashCode() + ") " + paramK);
        paramK = super.put(paramK, paramV);
        AppMethodBeat.o(359749);
        return paramK;
      }
      finally
      {
        paramK = finally;
        throw paramK;
      }
    }
    
    public final V remove(Object paramObject)
    {
      try
      {
        AppMethodBeat.i(359755);
        Log.i("LiveContext", "remove(" + hashCode() + ") " + paramObject);
        paramObject = super.remove(paramObject);
        AppMethodBeat.o(359755);
        return paramObject;
      }
      finally
      {
        paramObject = finally;
        throw paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.context.b
 * JD-Core Version:    0.7.0.1
 */