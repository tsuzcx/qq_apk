package com.tencent.mm.plugin.finder.viewmodel.component;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.tabPreload.c;
import com.tencent.mm.plugin.finder.preload.tabPreload.g;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.a;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.n;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "delayTimeMs", "", "getDelayTimeMs", "()J", "delayTimeMs$delegate", "Lkotlin/Lazy;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "homeTabStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "getHomeTabStateVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "homeTabStateVM$delegate", "postMap", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "onDestroy", "", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "startPreload", "tabType", "Companion", "PreloadRunnable", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends UIComponent
  implements h
{
  public static final a GVd;
  final j EVT;
  final HashMap<Integer, Runnable> GVe;
  private final j GVf;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(338037);
    GVd = new a((byte)0);
    AppMethodBeat.o(338037);
  }
  
  public ay(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338024);
    this.rdm = kotlin.k.cm((a)ay.d.GVj);
    this.GVe = new HashMap();
    this.EVT = kotlin.k.cm((a)e.GVk);
    this.GVf = kotlin.k.cm((a)c.GVi);
    AppMethodBeat.o(338024);
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(338078);
    Runnable localRunnable = (Runnable)this.GVe.remove(Integer.valueOf(paramInt4));
    if (localRunnable != null)
    {
      Log.i("FinderTabPreloadUIC", "onFragmentChange: tabType = " + paramInt4 + ", remove inside preload by fragment visible");
      getHandler().removeCallbacks(localRunnable);
    }
    AppMethodBeat.o(338078);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(338068);
    s.u(paramFinderHomeTabFragment, "fragment");
    AppMethodBeat.o(338068);
  }
  
  final long fpb()
  {
    AppMethodBeat.i(338051);
    long l = ((Number)this.GVf.getValue()).longValue();
    AppMethodBeat.o(338051);
    return l;
  }
  
  final MMHandler getHandler()
  {
    AppMethodBeat.i(338043);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(338043);
    return localMMHandler;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338058);
    Object localObject1 = ((Map)this.GVe).entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      getHandler().removeCallbacks((Runnable)((Map.Entry)localObject2).getValue());
    }
    this.GVe.clear();
    if (fpb() > 0L)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((Iterable)((c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(c.class)).EVR).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g)((Iterator)localObject1).next();
        if ((((g)localObject2).EWk.BeG != null) && (((g)localObject2).EWk.EWo == g.g.EWF)) {
          ((g)localObject2).ta(true);
        }
      }
    }
    AppMethodBeat.o(338058);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(338090);
    s.u(this, "this");
    AppMethodBeat.o(338090);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC$PreloadRunnable;", "Ljava/lang/Runnable;", "targetTabType", "", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC;I)V", "getTargetTabType", "()I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class b
    implements Runnable
  {
    private final int GVg;
    
    public b()
    {
      int i;
      this.GVg = i;
    }
    
    public final int fpc()
    {
      return this.GVg;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Long>
  {
    public static final c GVi;
    
    static
    {
      AppMethodBeat.i(338565);
      GVi = new c();
      AppMethodBeat.o(338565);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<d>
  {
    public static final e GVk;
    
    static
    {
      AppMethodBeat.i(338521);
      GVk = new e();
      AppMethodBeat.o(338521);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC$startPreload$runnable$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC$PreloadRunnable;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabPreloadUIC;", "run", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends ay.b
  {
    f(ay paramay, int paramInt)
    {
      super(paramInt);
    }
    
    public final void run()
    {
      AppMethodBeat.i(338561);
      Log.i("FinderTabPreloadUIC", s.X("startPreload: start tabType = ", Integer.valueOf(fpc())));
      ay.a(this.GVh).remove(Integer.valueOf(fpc()));
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(c.class)).Rn(this.AEa);
      String str;
      StringBuilder localStringBuilder;
      if (localObject != null)
      {
        str = ((g)localObject).TAG;
        localStringBuilder = new StringBuilder("[performInsidePreload] tabType=").append(((g)localObject).hJx).append(", cache.resp is null = ");
        if (((g)localObject).EWk.BeG != null) {
          break label170;
        }
      }
      label170:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if ((((g)localObject).EWk.BeG == null) && (((g)localObject).EWb.Rp(((g)localObject).hJx))) {
          g.a((g)localObject, g.g.EWF, (b)new g.n((g)localObject));
        }
        AppMethodBeat.o(338561);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ay
 * JD-Core Version:    0.7.0.1
 */