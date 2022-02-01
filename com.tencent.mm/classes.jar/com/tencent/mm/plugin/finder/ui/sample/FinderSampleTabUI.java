package com.tencent.mm.plugin.finder.ui.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectTab", "Companion", "FinderSampleTabFragment", "FinderSampleTabFragmentUIC", "FinderSampleTabUIC", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSampleTabUI
  extends MMFinderUI
{
  public static final a FXY;
  
  static
  {
    AppMethodBeat.i(347136);
    FXY = new a((byte)0);
    AppMethodBeat.o(347136);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347146);
    Set localSet = ar.setOf(c.class);
    AppMethodBeat.o(347146);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347151);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    paramBundle = k.d((AppCompatActivity)this).q(c.class);
    s.s(paramBundle, "UICProvider.of(this).get…SampleTabUIC::class.java)");
    FinderTabUIC.a((FinderTabUIC)paramBundle, 1);
    AppMethodBeat.o(347151);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class FinderSampleTabFragment
    extends FinderHomeTabFragment
  {
    public final Set<Class<? extends UIComponent>> importUIComponents()
    {
      AppMethodBeat.i(347141);
      Set localSet = ar.setOf(FinderSampleTabUI.b.class);
      AppMethodBeat.o(347141);
      return localSet;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabFragmentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends UIComponent
  {
    public b(AppCompatActivity paramAppCompatActivity)
    {
      super();
      AppMethodBeat.i(347128);
      AppMethodBeat.o(347128);
    }
    
    public b(Fragment paramFragment)
    {
      super();
      AppMethodBeat.i(347132);
      AppMethodBeat.o(347132);
    }
    
    public final int getLayoutId()
    {
      return e.f.finder_tab_fragment_common_ui;
    }
    
    public final void onCreateAfter(Bundle paramBundle)
    {
      Fragment localFragment1 = null;
      AppMethodBeat.i(347143);
      super.onCreateAfter(paramBundle);
      paramBundle = new StringBuilder("onCreateAfter ");
      Fragment localFragment2 = getFragment();
      if (localFragment2 == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(347143);
        throw paramBundle;
      }
      paramBundle = paramBundle.append(((FinderHomeTabFragment)localFragment2).title).append("  tabType:");
      localFragment2 = getFragment();
      if (localFragment2 == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(347143);
        throw paramBundle;
      }
      Log.i("SimpleUIComponent", ((FinderHomeTabFragment)localFragment2).hJx);
      paramBundle = getFragment();
      if (paramBundle == null)
      {
        paramBundle = localFragment1;
        if (paramBundle == null) {
          break label203;
        }
        localFragment1 = getFragment();
        if (localFragment1 == null)
        {
          paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
          AppMethodBeat.o(347143);
          throw paramBundle;
        }
      }
      else
      {
        paramBundle = paramBundle.getView();
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = paramBundle.findViewById(e.e.finder_sample_tab_content))
        {
          paramBundle = (TextView)paramBundle;
          break;
        }
      }
      paramBundle.setText((CharSequence)s.X("titleId is :", Integer.valueOf(((FinderHomeTabFragment)localFragment1).title)));
      label203:
      AppMethodBeat.o(347143);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/sample/FinderSampleTabUI$FinderSampleTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends FinderTabUIC
  {
    public c(MMActivity paramMMActivity)
    {
      super();
      AppMethodBeat.i(347129);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC init cons");
      AppMethodBeat.o(347129);
    }
    
    public final IFinderTabProvider dTN()
    {
      AppMethodBeat.i(347140);
      Log.i("Finder.FinderTabUIC", "FinderBizTabUIC generateProvider");
      IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new FinderTabProvider();
      AppMethodBeat.o(347140);
      return localIFinderTabProvider;
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(347134);
      super.onCreate(paramBundle);
      paramBundle = getActivity().getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      AppMethodBeat.o(347134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.sample.FinderSampleTabUI
 * JD-Core Version:    0.7.0.1
 */