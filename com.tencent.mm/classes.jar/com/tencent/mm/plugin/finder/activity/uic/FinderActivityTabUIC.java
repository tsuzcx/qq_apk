package com.tencent.mm.plugin.finder.activity.uic;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityLatestFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.d;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "Provider", "Tab", "TabContainer", "plugin-finder_release"})
public final class FinderActivityTabUIC
  extends FinderTabUIC
{
  public FinderActivityTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242146);
    AppMethodBeat.o(242146);
  }
  
  public final IFinderTabProvider cXB()
  {
    AppMethodBeat.i(242145);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new a();
    AppMethodBeat.o(242145);
    return localIFinderTabProvider;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;)V", "plugin-finder_release"})
  public final class a
    extends FinderTabProvider
  {
    public a()
    {
      AppMethodBeat.i(242144);
      setTabContainer((g)new FinderActivityTabUIC.c());
      setTabViewAction((f)new e());
      this$1 = new LinkedList();
      this$1.add(new FinderActivityTabUIC.b(2131759499));
      this$1.add(new FinderActivityTabUIC.b(2131759505));
      setTabs((List)this$1);
      this$1 = new LinkedList();
      Object localObject = new FinderActivityFragment();
      ((FinderHomeTabFragment)localObject).dLS = 0;
      this$1.add(localObject);
      localObject = new FinderActivityLatestFragment();
      ((FinderHomeTabFragment)localObject).dLS = 1;
      this$1.add(localObject);
      setFragments((List)this$1);
      AppMethodBeat.o(242144);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
  public static final class b
    extends c
  {
    public b(int paramInt)
    {
      super();
    }
    
    public final int[] cXC()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return 2131494595;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"})
  public static final class c
    extends d
  {
    public final int getLayoutId()
    {
      return 2131494198;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityTabUIC
 * JD-Core Version:    0.7.0.1
 */