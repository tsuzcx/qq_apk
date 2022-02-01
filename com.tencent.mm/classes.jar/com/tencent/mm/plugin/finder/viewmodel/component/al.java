package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "locationPermissionGrant", "", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends UIComponent
{
  public static final a GSq;
  private final b Bsp;
  private boolean wGs;
  
  static
  {
    AppMethodBeat.i(338195);
    GSq = new a((byte)0);
    AppMethodBeat.o(338195);
  }
  
  public al(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338183);
    paramAppCompatActivity = k.aeZF;
    paramAppCompatActivity = k.cn(PluginFinder.class).q(b.class);
    s.s(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.Bsp = ((b)paramAppCompatActivity);
    AppMethodBeat.o(338183);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(338226);
    Log.i("Finder.LocationUIC", "[onActivityResult] requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(338226);
      return;
      this.Bsp.pH(false);
      AppMethodBeat.o(338226);
      return;
      this.wGs = this.Bsp.dUi();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338206);
    super.onCreate(paramBundle);
    this.wGs = this.Bsp.dUi();
    if (this.wGs) {
      this.Bsp.pH(false);
    }
    AppMethodBeat.o(338206);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338218);
    super.onResume();
    if (!this.wGs)
    {
      this.wGs = this.Bsp.dUi();
      if (this.wGs) {
        this.Bsp.pH(false);
      }
    }
    AppMethodBeat.o(338218);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLocationUIC$Companion;", "", "()V", "REQ_GPS_PERMISSION", "", "REQ_OPEN_GPS", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.al
 * JD-Core Version:    0.7.0.1
 */