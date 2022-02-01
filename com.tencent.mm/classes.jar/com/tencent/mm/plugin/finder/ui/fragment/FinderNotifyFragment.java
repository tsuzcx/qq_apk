package com.tencent.mm.plugin.finder.ui.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "plugin-finder_release"})
public final class FinderNotifyFragment
  extends FinderHomeTabFragment
{
  private static final String TAG = "FinderNotifyFragment";
  public static final a vQQ;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(252936);
    vQQ = new a((byte)0);
    TAG = "FinderNotifyFragment";
    AppMethodBeat.o(252936);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252937);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252937);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252932);
    Set localSet = ak.setOf(FinderNotifyUIC.class);
    AppMethodBeat.o(252932);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252933);
    super.onCreate(paramBundle);
    Log.i(TAG, "index:" + this.dLS);
    paramBundle = a.PRN;
    ((FinderNotifyUIC)a.of((Fragment)this).get(FinderNotifyUIC.class)).index = this.dLS;
    AppMethodBeat.o(252933);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(252934);
    p.h(paramLayoutInflater, "inflater");
    Log.i(TAG, " onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(252934);
    return paramLayoutInflater;
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(252935);
    p.h(paramView, "view");
    Log.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(252935);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment
 * JD-Core Version:    0.7.0.1
 */