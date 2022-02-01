package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLocationUIC
  extends UIComponent
{
  public static final a wyJ;
  private boolean qgs;
  private final FinderGlobalLocationVM udf;
  
  static
  {
    AppMethodBeat.i(255839);
    wyJ = new a((byte)0);
    AppMethodBeat.o(255839);
  }
  
  public FinderLocationUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255838);
    paramAppCompatActivity = a.PRN;
    paramAppCompatActivity = a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.udf = ((FinderGlobalLocationVM)paramAppCompatActivity);
    AppMethodBeat.o(255838);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255837);
    Log.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255837);
      return;
      this.udf.cxh();
      AppMethodBeat.o(255837);
      return;
      this.qgs = FinderGlobalLocationVM.dHO();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255835);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255835);
      throw paramBundle;
    }
    this.qgs = FinderGlobalLocationVM.h((MMActivity)paramBundle);
    if (this.qgs) {
      this.udf.cxh();
    }
    AppMethodBeat.o(255835);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255836);
    super.onResume();
    if (!this.qgs)
    {
      this.qgs = FinderGlobalLocationVM.dHO();
      if (this.qgs) {
        this.udf.cxh();
      }
    }
    AppMethodBeat.o(255836);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC
 * JD-Core Version:    0.7.0.1
 */