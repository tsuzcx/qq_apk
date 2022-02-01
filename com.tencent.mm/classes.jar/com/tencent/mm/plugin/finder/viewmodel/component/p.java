package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.plugin.finder.view.tabcomp.h;
import com.tencent.mm.plugin.finder.view.tabcomp.i;
import com.tencent.mm.plugin.finder.view.tabcomp.l;
import com.tencent.mm.plugin.finder.view.tabcomp.m;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "addMegaVideoFragment", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeMegaVideoFragment", "clearCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends FinderTabUIC
{
  public p(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337686);
    AppMethodBeat.o(337686);
  }
  
  public final IFinderTabProvider dTN()
  {
    AppMethodBeat.i(337695);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new b();
    AppMethodBeat.o(337695);
    return localIFinderTabProvider;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(337717);
    boolean bool = getActiveFragment().onBackPressed();
    AppMethodBeat.o(337717);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(337703);
    super.onCreate(paramBundle);
    if (k.a.a(k.FNg, 12).isEmpty()) {
      vl(false);
    }
    eKo();
    AppMethodBeat.o(337703);
  }
  
  public final void vl(final boolean paramBoolean)
  {
    AppMethodBeat.i(337710);
    com.tencent.mm.ae.d.uiThread((a)new c(this, paramBoolean));
    AppMethodBeat.o(337710);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements a<ah>
  {
    public a(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavListTabUIC$generateProvider$1", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "fragments", "", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "isDynamic", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements IFinderTabProvider
  {
    public final List<FinderHomeTabFragment> fragments()
    {
      AppMethodBeat.i(337783);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new FinderFavFeedFragment());
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUT().bmg()).intValue() == 1) {
        ((ArrayList)localObject).add(new FinderFavMegaVideoFragment());
      }
      localObject = (List)localObject;
      AppMethodBeat.o(337783);
      return localObject;
    }
    
    public final boolean isDynamic()
    {
      return true;
    }
    
    public final n tabContainer()
    {
      AppMethodBeat.i(337789);
      n localn = (n)new h();
      AppMethodBeat.o(337789);
      return localn;
    }
    
    public final m tabViewAction()
    {
      AppMethodBeat.i(337799);
      m localm = (m)new l();
      AppMethodBeat.o(337799);
      return localm;
    }
    
    public final List<g> tabs()
    {
      AppMethodBeat.i(337794);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new i(e.h.finder_tab_title_normal));
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eUT().bmg()).intValue() == 1) {
        ((ArrayList)localObject).add(new i(e.h.finder_tab_title_long_video));
      }
      localObject = (List)localObject;
      AppMethodBeat.o(337794);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(p paramp, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.p
 * JD-Core Version:    0.7.0.1
 */