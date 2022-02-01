package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "addMegaVideoFragment", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeMegaVideoFragment", "clearCache", "plugin-finder_release"})
public final class FinderFavListTabUIC
  extends FinderTabUIC
{
  public FinderFavListTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255492);
    AppMethodBeat.o(255492);
  }
  
  public final IFinderTabProvider cXB()
  {
    AppMethodBeat.i(255488);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(255488);
    return localIFinderTabProvider;
  }
  
  public final void nR(final boolean paramBoolean)
  {
    AppMethodBeat.i(255490);
    d.h((kotlin.g.a.a)new c(this, paramBoolean));
    AppMethodBeat.o(255490);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255491);
    boolean bool = getActiveFragment().onBackPressed();
    AppMethodBeat.o(255491);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255489);
    super.onCreate(paramBundle);
    if (l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 12).isEmpty()) {
      nR(false);
    }
    dnx();
    AppMethodBeat.o(255489);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(FinderFavListTabUIC paramFinderFavListTabUIC)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC$generateProvider$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"})
  public static final class b
    implements IFinderTabProvider
  {
    public final List<FinderHomeTabFragment> fragments()
    {
      AppMethodBeat.i(255483);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new FinderFavFeedFragment());
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() == 1) {
        ((ArrayList)localObject).add(new FinderFavMegaVideoFragment());
      }
      localObject = (List)localObject;
      AppMethodBeat.o(255483);
      return localObject;
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
    
    public final g tabContainer()
    {
      AppMethodBeat.i(255484);
      g localg = (g)new com.tencent.mm.plugin.finder.view.tabcomp.b();
      AppMethodBeat.o(255484);
      return localg;
    }
    
    public final f tabViewAction()
    {
      AppMethodBeat.i(255486);
      f localf = (f)new e();
      AppMethodBeat.o(255486);
      return localf;
    }
    
    public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> tabs()
    {
      AppMethodBeat.i(255485);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new com.tencent.mm.plugin.finder.view.tabcomp.c(2131760618));
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dvJ().value()).intValue() == 1) {
        ((ArrayList)localObject).add(new com.tencent.mm.plugin.finder.view.tabcomp.c(2131760617));
      }
      localObject = (List)localObject;
      AppMethodBeat.o(255485);
      return localObject;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(FinderFavListTabUIC paramFinderFavListTabUIC, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFavListTabUIC
 * JD-Core Version:    0.7.0.1
 */