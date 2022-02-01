package com.tencent.mm.plugin.finder.ui.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderSampleTabFragment", "FinderSampleTabFragmentUIC", "FinderSampleTabUIC", "plugin-finder_release"})
public final class FinderSampleTabUI
  extends MMFinderUI
{
  public static final a AyG;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(280642);
    AyG = new a((byte)0);
    AppMethodBeat.o(280642);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280646);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280646);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(280644);
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
    AppMethodBeat.o(280644);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(280640);
    Set localSet = ak.setOf(c.class);
    AppMethodBeat.o(280640);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280641);
    super.onCreate(paramBundle);
    paramBundle = g.Xox;
    FinderTabUIC.a((c)g.b((AppCompatActivity)this).i(c.class), 1);
    AppMethodBeat.o(280641);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
  public static final class FinderSampleTabFragment
    extends FinderHomeTabFragment
  {
    private HashMap _$_findViewCache;
    
    public final void _$_clearFindViewByIdCache()
    {
      AppMethodBeat.i(279643);
      if (this._$_findViewCache != null) {
        this._$_findViewCache.clear();
      }
      AppMethodBeat.o(279643);
    }
    
    public final Set<Class<? extends UIComponent>> importUIComponents()
    {
      AppMethodBeat.i(279641);
      Set localSet = ak.setOf(FinderSampleTabUI.b.class);
      AppMethodBeat.o(279641);
      return localSet;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class b
    extends UIComponent
  {
    public b(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(285965);
      AppMethodBeat.o(285965);
    }
    
    public b(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(285966);
      AppMethodBeat.o(285966);
    }
    
    public final int getLayoutId()
    {
      return b.g.finder_tab_fragment_common_ui;
    }
    
    public final void onCreateAfter(Bundle paramBundle)
    {
      AppMethodBeat.i(285964);
      super.onCreateAfter(paramBundle);
      paramBundle = new StringBuilder("onCreateAfter ");
      Object localObject = getFragment();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(285964);
        throw paramBundle;
      }
      paramBundle = paramBundle.append(((FinderHomeTabFragment)localObject).title).append("  tabType:");
      localObject = getFragment();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(285964);
        throw paramBundle;
      }
      Log.i("SimpleUIComponent", ((FinderHomeTabFragment)localObject).fEH);
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = (TextView)paramBundle.getView().findViewById(b.f.finder_sample_tab_content);
        if (paramBundle != null)
        {
          localObject = new StringBuilder("titleId is :");
          Fragment localFragment = getFragment();
          if (localFragment == null)
          {
            paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
            AppMethodBeat.o(285964);
            throw paramBundle;
          }
          paramBundle.setText((CharSequence)((FinderHomeTabFragment)localFragment).title);
          AppMethodBeat.o(285964);
          return;
        }
      }
      AppMethodBeat.o(285964);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
  public static final class c
    extends FinderTabUIC
  {
    public c(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(289698);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(289698);
    }
    
    public final IFinderTabProvider dmS()
    {
      AppMethodBeat.i(289697);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderTabProvider();
      AppMethodBeat.o(289697);
      return localIFinderTabProvider;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(289696);
      super.onCreate(paramBundle);
      paramBundle = getActivity().getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.hide();
        AppMethodBeat.o(289696);
        return;
      }
      AppMethodBeat.o(289696);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI
 * JD-Core Version:    0.7.0.1
 */