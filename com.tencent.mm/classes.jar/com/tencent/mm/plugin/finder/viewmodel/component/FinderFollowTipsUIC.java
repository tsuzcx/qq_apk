package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowTipsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderFollowTipsUIC
  extends UIComponent
{
  public static final a wwq;
  
  static
  {
    AppMethodBeat.i(255536);
    wwq = new a((byte)0);
    AppMethodBeat.o(255536);
  }
  
  public FinderFollowTipsUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255535);
    AppMethodBeat.o(255535);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255534);
    super.onCreateAfter(paramBundle);
    getActivity();
    getActivity();
    AppMethodBeat.o(255534);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowTipsUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowTipsUIC
 * JD-Core Version:    0.7.0.1
 */