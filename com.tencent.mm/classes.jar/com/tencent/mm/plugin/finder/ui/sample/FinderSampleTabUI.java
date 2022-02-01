package com.tencent.mm.plugin.finder.ui.sample;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderSampleTabFragment", "FinderSampleTabFragmentUIC", "FinderSampleTabUIC", "plugin-finder_release"})
public final class FinderSampleTabUI
  extends MMFinderUI
{
  public static final a vRF;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(253040);
    vRF = new a((byte)0);
    AppMethodBeat.o(253040);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(253042);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(253042);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(253041);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(253041);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(253038);
    Set localSet = ak.setOf(FinderSampleTabUIC.class);
    AppMethodBeat.o(253038);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253039);
    super.onCreate(paramBundle);
    paramBundle = a.PRN;
    FinderTabUIC.a((FinderSampleTabUIC)a.b((AppCompatActivity)this).get(FinderSampleTabUIC.class), 1);
    AppMethodBeat.o(253039);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
  public static final class FinderSampleTabFragment
    extends FinderHomeTabFragment
  {
    private HashMap _$_findViewCache;
    
    public final void _$_clearFindViewByIdCache()
    {
      AppMethodBeat.i(253030);
      if (this._$_findViewCache != null) {
        this._$_findViewCache.clear();
      }
      AppMethodBeat.o(253030);
    }
    
    public final Set<Class<? extends UIComponent>> importUIComponents()
    {
      AppMethodBeat.i(253029);
      Set localSet = ak.setOf(FinderSampleTabUI.FinderSampleTabFragmentUIC.class);
      AppMethodBeat.o(253029);
      return localSet;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class FinderSampleTabFragmentUIC
    extends UIComponent
  {
    public FinderSampleTabFragmentUIC(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(253034);
      AppMethodBeat.o(253034);
    }
    
    public FinderSampleTabFragmentUIC(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(253033);
      AppMethodBeat.o(253033);
    }
    
    public final int getLayoutId()
    {
      return 2131494645;
    }
    
    public final void onCreateAfter(Bundle paramBundle)
    {
      AppMethodBeat.i(253032);
      super.onCreateAfter(paramBundle);
      paramBundle = new StringBuilder("onCreateAfter ");
      Object localObject = getFragment();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(253032);
        throw paramBundle;
      }
      paramBundle = paramBundle.append(((FinderHomeTabFragment)localObject).title).append("  tabType:");
      localObject = getFragment();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(253032);
        throw paramBundle;
      }
      Log.i("SimpleUIComponent", ((FinderHomeTabFragment)localObject).dLS);
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = (TextView)paramBundle.getView().findViewById(2131301466);
        if (paramBundle != null)
        {
          localObject = new StringBuilder("titleId is :");
          Fragment localFragment = getFragment();
          if (localFragment == null)
          {
            paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
            AppMethodBeat.o(253032);
            throw paramBundle;
          }
          paramBundle.setText((CharSequence)((FinderHomeTabFragment)localFragment).title);
          AppMethodBeat.o(253032);
          return;
        }
      }
      AppMethodBeat.o(253032);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class FinderSampleTabUIC
    extends FinderTabUIC
  {
    public FinderSampleTabUIC(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(253037);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(253037);
    }
    
    public final IFinderTabProvider cXB()
    {
      AppMethodBeat.i(253036);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderTabProvider();
      AppMethodBeat.o(253036);
      return localIFinderTabProvider;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(253035);
      super.onCreate(paramBundle);
      paramBundle = getActivity().getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.hide();
        AppMethodBeat.o(253035);
        return;
      }
      AppMethodBeat.o(253035);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI
 * JD-Core Version:    0.7.0.1
 */