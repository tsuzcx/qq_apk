package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLocationUIC
  extends UIComponent
{
  public static final FinderLocationUIC.a tmX;
  private boolean oSD;
  private final FinderGlobalLocationVM sqv;
  
  static
  {
    AppMethodBeat.i(206246);
    tmX = new FinderLocationUIC.a((byte)0);
    AppMethodBeat.o(206246);
  }
  
  public FinderLocationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206245);
    paramMMActivity = a.KEX;
    paramMMActivity = a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.sqv = ((FinderGlobalLocationVM)paramMMActivity);
    AppMethodBeat.o(206245);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206244);
    ae.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206244);
      return;
      this.sqv.bZr();
      AppMethodBeat.o(206244);
      return;
      this.oSD = FinderGlobalLocationVM.cQK();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206242);
    super.onCreate(paramBundle);
    this.oSD = FinderGlobalLocationVM.h(getActivity());
    if (this.oSD) {
      this.sqv.bZr();
    }
    AppMethodBeat.o(206242);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206243);
    super.onResume();
    if (!this.oSD)
    {
      this.oSD = FinderGlobalLocationVM.cQK();
      if (this.oSD) {
        this.sqv.bZr();
      }
    }
    AppMethodBeat.o(206243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC
 * JD-Core Version:    0.7.0.1
 */