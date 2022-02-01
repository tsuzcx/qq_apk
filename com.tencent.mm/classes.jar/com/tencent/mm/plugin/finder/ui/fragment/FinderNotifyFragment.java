package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "plugin-finder_release"})
public final class FinderNotifyFragment
  extends FinderHomeTabFragment
{
  public static final a AyC;
  private static final String TAG = "FinderNotifyFragment";
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(230278);
    AyC = new a((byte)0);
    TAG = "FinderNotifyFragment";
    AppMethodBeat.o(230278);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(230283);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(230283);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(230265);
    Set localSet = ak.setOf(ag.class);
    AppMethodBeat.o(230265);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230269);
    super.onCreate(paramBundle);
    Log.i(TAG, "index:" + this.fEH);
    paramBundle = g.Xox;
    ((ag)g.h((Fragment)this).i(ag.class)).index = this.fEH;
    AppMethodBeat.o(230269);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(230271);
    p.k(paramLayoutInflater, "inflater");
    Log.i(TAG, " onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(230271);
    return paramLayoutInflater;
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(230273);
    p.k(paramView, "view");
    Log.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(230273);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment
 * JD-Core Version:    0.7.0.1
 */