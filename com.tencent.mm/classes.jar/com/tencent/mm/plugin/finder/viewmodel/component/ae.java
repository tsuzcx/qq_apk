package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"})
public final class ae
  extends UIComponent
{
  public static final a Bmw;
  private boolean tCo;
  private final a xSM;
  
  static
  {
    AppMethodBeat.i(278166);
    Bmw = new a((byte)0);
    AppMethodBeat.o(278166);
  }
  
  public ae(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278165);
    paramAppCompatActivity = g.Xox;
    paramAppCompatActivity = g.bD(PluginFinder.class).i(a.class);
    p.j(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.xSM = ((a)paramAppCompatActivity);
    AppMethodBeat.o(278165);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(278163);
    Log.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(278163);
      return;
      this.xSM.cKK();
      AppMethodBeat.o(278163);
      return;
      this.tCo = a.ejZ();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278160);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(278160);
      throw paramBundle;
    }
    this.tCo = a.i((MMActivity)paramBundle);
    if (this.tCo) {
      this.xSM.cKK();
    }
    AppMethodBeat.o(278160);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(278161);
    super.onResume();
    if (!this.tCo)
    {
      this.tCo = a.ejZ();
      if (this.tCo) {
        this.xSM.cKK();
      }
    }
    AppMethodBeat.o(278161);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ae
 * JD-Core Version:    0.7.0.1
 */