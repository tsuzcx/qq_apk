package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderNotifyFragment
  extends FinderHomeTabFragment
{
  public static final a FXV;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(347732);
    FXV = new a((byte)0);
    TAG = "FinderNotifyFragment";
    AppMethodBeat.o(347732);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347736);
    Set localSet = ar.setOf(an.class);
    AppMethodBeat.o(347736);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347742);
    super.onCreate(paramBundle);
    Log.i(TAG, s.X("index:", Integer.valueOf(this.hJx)));
    paramBundle = k.aeZF;
    ((an)k.y((Fragment)this).q(an.class)).index = this.hJx;
    AppMethodBeat.o(347742);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(347749);
    s.u(paramLayoutInflater, "inflater");
    Log.i(TAG, " onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(347749);
    return paramLayoutInflater;
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(347755);
    s.u(paramView, "view");
    Log.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AppMethodBeat.o(347755);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderNotifyFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderNotifyFragment
 * JD-Core Version:    0.7.0.1
 */