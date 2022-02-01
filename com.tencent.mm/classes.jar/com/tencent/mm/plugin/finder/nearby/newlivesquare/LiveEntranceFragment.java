package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/LiveEntranceFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "isForceNightMode", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveEntranceFragment
  extends MMFinderFragment
{
  private boolean ALp;
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(340235);
    Set localSet = ar.setOf(new Class[] { d.class, e.class });
    AppMethodBeat.o(340235);
    return localSet;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(340238);
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getArguments();
    if ((paramViewGroup != null) && (paramViewGroup.getInt("key_use_dark_style", 1) == 1)) {}
    for (;;)
    {
      this.ALp = bool;
      AppMethodBeat.o(340238);
      return paramLayoutInflater;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.LiveEntranceFragment
 * JD-Core Version:    0.7.0.1
 */