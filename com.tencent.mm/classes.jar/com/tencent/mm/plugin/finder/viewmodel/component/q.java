package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "addMegaVideoFragment", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeMegaVideoFragment", "clearCache", "plugin-finder_release"})
public final class q
  extends FinderTabUIC
{
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287519);
    AppMethodBeat.o(287519);
  }
  
  public final IFinderTabProvider dmS()
  {
    AppMethodBeat.i(287514);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(287514);
    return localIFinderTabProvider;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(287518);
    boolean bool = getActiveFragment().onBackPressed();
    AppMethodBeat.o(287518);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287516);
    super.onCreate(paramBundle);
    if (k.a.a(k.Anu, 12).isEmpty()) {
      qb(false);
    }
    dOQ();
    AppMethodBeat.o(287516);
  }
  
  public final void qb(final boolean paramBoolean)
  {
    AppMethodBeat.i(287517);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(287517);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public a(q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC$generateProvider$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"})
  public static final class b
    implements IFinderTabProvider
  {
    public final List<FinderHomeTabFragment> fragments()
    {
      AppMethodBeat.i(280824);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new FinderFavFeedFragment());
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        ((ArrayList)localObject).add(new FinderFavMegaVideoFragment());
      }
      localObject = (List)localObject;
      AppMethodBeat.o(280824);
      return localObject;
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
    
    public final g tabContainer()
    {
      AppMethodBeat.i(280825);
      g localg = (g)new com.tencent.mm.plugin.finder.view.tabcomp.b();
      AppMethodBeat.o(280825);
      return localg;
    }
    
    public final f tabViewAction()
    {
      AppMethodBeat.i(280828);
      f localf = (f)new e();
      AppMethodBeat.o(280828);
      return localf;
    }
    
    public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> tabs()
    {
      AppMethodBeat.i(280827);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new c(b.j.finder_tab_title_normal));
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dWj().aSr()).intValue() == 1) {
        ((ArrayList)localObject).add(new c(b.j.finder_tab_title_long_video));
      }
      localObject = (List)localObject;
      AppMethodBeat.o(280827);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(q paramq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.q
 * JD-Core Version:    0.7.0.1
 */