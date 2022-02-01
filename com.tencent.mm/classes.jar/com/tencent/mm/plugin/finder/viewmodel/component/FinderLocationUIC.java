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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLocationUIC
  extends UIComponent
{
  public static final a LiD;
  private final FinderGlobalLocationVM KTa;
  private boolean nFG;
  
  static
  {
    AppMethodBeat.i(200446);
    LiD = new a((byte)0);
    AppMethodBeat.o(200446);
  }
  
  public FinderLocationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200445);
    paramMMActivity = a.LCX;
    paramMMActivity = a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.KTa = ((FinderGlobalLocationVM)paramMMActivity);
    AppMethodBeat.o(200445);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(200444);
    ad.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200444);
      return;
      this.KTa.bMk();
      AppMethodBeat.o(200444);
      return;
      this.nFG = FinderGlobalLocationVM.fXe();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200442);
    super.onCreate(paramBundle);
    this.nFG = FinderGlobalLocationVM.r(getActivity());
    if (this.nFG) {
      this.KTa.bMk();
    }
    AppMethodBeat.o(200442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200443);
    super.onResume();
    if (!this.nFG)
    {
      this.nFG = FinderGlobalLocationVM.fXe();
      if (this.nFG) {
        this.KTa.bMk();
      }
    }
    AppMethodBeat.o(200443);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC
 * JD-Core Version:    0.7.0.1
 */