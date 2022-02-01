package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "addMegaVideoFragment", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeMegaVideoFragment", "clearCache", "plugin-finder_release"})
public final class ad
  extends FinderTabUIC
{
  public ad(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(282563);
    AppMethodBeat.o(282563);
  }
  
  public final IFinderTabProvider dmS()
  {
    AppMethodBeat.i(282559);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(282559);
    return localIFinderTabProvider;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(282562);
    boolean bool = getActiveFragment().onBackPressed();
    AppMethodBeat.o(282562);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(282560);
    super.onCreate(paramBundle);
    if (k.a.a(k.Anu, 11).isEmpty()) {
      qb(false);
    }
    dOQ();
    AppMethodBeat.o(282560);
  }
  
  public final void qb(final boolean paramBoolean)
  {
    AppMethodBeat.i(282561);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(282561);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(ad paramad)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeListTabUIC$generateProvider$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"})
  public static final class b
    implements IFinderTabProvider
  {
    public final List<FinderHomeTabFragment> fragments()
    {
      AppMethodBeat.i(282540);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new FinderLikeFeedGridFragment());
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        ((ArrayList)localObject).add(new FinderLikeMegaVideoFragment());
      }
      localObject = (List)localObject;
      AppMethodBeat.o(282540);
      return localObject;
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
    
    public final g tabContainer()
    {
      AppMethodBeat.i(282541);
      g localg = (g)new com.tencent.mm.plugin.finder.view.tabcomp.b();
      AppMethodBeat.o(282541);
      return localg;
    }
    
    public final f tabViewAction()
    {
      AppMethodBeat.i(282543);
      f localf = (f)new e();
      AppMethodBeat.o(282543);
      return localf;
    }
    
    public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> tabs()
    {
      AppMethodBeat.i(282542);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new c(b.j.finder_tab_title_normal));
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        ((ArrayList)localObject).add(new c(b.j.finder_tab_title_long_video));
      }
      localObject = (List)localObject;
      AppMethodBeat.o(282542);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(ad paramad, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ad
 * JD-Core Version:    0.7.0.1
 */