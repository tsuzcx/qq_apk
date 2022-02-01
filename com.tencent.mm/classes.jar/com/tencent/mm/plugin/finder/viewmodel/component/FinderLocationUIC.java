package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLocationUIC
  extends UIComponent
{
  public static final FinderLocationUIC.a seg;
  private boolean oiH;
  private final FinderGlobalLocationVM rss;
  
  static
  {
    AppMethodBeat.i(204572);
    seg = new FinderLocationUIC.a((byte)0);
    AppMethodBeat.o(204572);
  }
  
  public FinderLocationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204571);
    paramMMActivity = a.IrY;
    paramMMActivity = a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.rss = ((FinderGlobalLocationVM)paramMMActivity);
    AppMethodBeat.o(204571);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204570);
    ac.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204570);
      return;
      this.rss.bTx();
      AppMethodBeat.o(204570);
      return;
      this.oiH = FinderGlobalLocationVM.cFG();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204568);
    super.onCreate(paramBundle);
    this.oiH = FinderGlobalLocationVM.g(getActivity());
    if (this.oiH) {
      this.rss.bTx();
    }
    AppMethodBeat.o(204568);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204569);
    super.onResume();
    if (!this.oiH)
    {
      this.oiH = FinderGlobalLocationVM.cFG();
      if (this.oiH) {
        this.rss.bTx();
      }
    }
    AppMethodBeat.o(204569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC
 * JD-Core Version:    0.7.0.1
 */