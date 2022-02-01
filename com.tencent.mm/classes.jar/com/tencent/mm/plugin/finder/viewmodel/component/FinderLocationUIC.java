package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLocationUIC
  extends UIComponent
{
  public static final a tcd;
  private boolean oMb;
  private final FinderGlobalLocationVM shA;
  
  static
  {
    AppMethodBeat.i(205619);
    tcd = new a((byte)0);
    AppMethodBeat.o(205619);
  }
  
  public FinderLocationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205618);
    paramMMActivity = a.KiD;
    paramMMActivity = a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.shA = ((FinderGlobalLocationVM)paramMMActivity);
    AppMethodBeat.o(205618);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(205617);
    ad.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205617);
      return;
      this.shA.bYc();
      AppMethodBeat.o(205617);
      return;
      this.oMb = FinderGlobalLocationVM.cOa();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205615);
    super.onCreate(paramBundle);
    this.oMb = FinderGlobalLocationVM.h(getActivity());
    if (this.oMb) {
      this.shA.bYc();
    }
    AppMethodBeat.o(205615);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205616);
    super.onResume();
    if (!this.oMb)
    {
      this.oMb = FinderGlobalLocationVM.cOa();
      if (this.oMb) {
        this.shA.bYc();
      }
    }
    AppMethodBeat.o(205616);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC
 * JD-Core Version:    0.7.0.1
 */