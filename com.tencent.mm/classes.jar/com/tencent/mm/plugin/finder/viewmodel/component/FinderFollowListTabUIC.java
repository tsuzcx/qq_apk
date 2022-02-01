package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowListNormalFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFollowListTopicFragment;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.d;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isExitTopic", "", "()Z", "setExitTopic", "(Z)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Provider", "Tab", "TabContainer", "plugin-finder_release"})
public final class FinderFollowListTabUIC
  extends FinderTabUIC
{
  boolean wwm;
  
  public FinderFollowListTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255522);
    AppMethodBeat.o(255522);
  }
  
  public final IFinderTabProvider cXB()
  {
    AppMethodBeat.i(255519);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new a();
    AppMethodBeat.o(255519);
    return localIFinderTabProvider;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255520);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.drt())
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255520);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).addIconOptionMenu(0, 2131690901, (MenuItem.OnMenuItemClickListener)new d(this));
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255520);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(255520);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255521);
    super.onResume();
    AppMethodBeat.o(255521);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC;)V", "plugin-finder_release"})
  public final class a
    extends FinderTabProvider
  {
    public a()
    {
      AppMethodBeat.i(255516);
      setTabContainer((g)new FinderFollowListTabUIC.c());
      setTabViewAction((f)new e());
      this$1 = new LinkedList();
      this$1.add(new FinderFollowListTabUIC.b(2131760633));
      if (this.wwn.wwm) {
        this$1.add(new FinderFollowListTabUIC.b(2131760639));
      }
      setTabs((List)this$1);
      this$1 = new LinkedList();
      this$1.add(new FinderFollowListNormalFragment());
      if (this.wwn.wwm) {
        this$1.add(new FinderFollowListTopicFragment());
      }
      setFragments((List)this$1);
      AppMethodBeat.o(255516);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "getLayoutId", "getTabMargin", "", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.view.tabcomp.c
  {
    public b(int paramInt)
    {
      super();
    }
    
    public final int[] cXC()
    {
      return new int[] { 0, 16 };
    }
    
    public final int getLayoutId()
    {
      return 2131494320;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowListTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"})
  public static final class c
    extends d
  {
    public final int getLayoutId()
    {
      return 2131494318;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderFollowListTabUIC paramFinderFollowListTabUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255517);
      paramMenuItem = i.vvu;
      i.a(null);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("need_history", false);
      a locala;
      if (this.wwn.dIM() == 0)
      {
        paramMenuItem.putExtra("request_type", 3);
        locala = a.vUU;
        a.A((Context)this.wwn.getActivity(), paramMenuItem);
      }
      for (;;)
      {
        AppMethodBeat.o(255517);
        return true;
        paramMenuItem.putExtra("request_type", 4);
        locala = a.vUU;
        a.B((Context)this.wwn.getActivity(), paramMenuItem);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderFollowListTabUIC paramFinderFollowListTabUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255518);
      this.wwn.getActivity().finish();
      AppMethodBeat.o(255518);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListTabUIC
 * JD-Core Version:    0.7.0.1
 */