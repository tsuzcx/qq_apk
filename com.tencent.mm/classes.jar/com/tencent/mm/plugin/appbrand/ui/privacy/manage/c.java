package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.privacy.AppBrandPrivacyPageContainerUI;
import com.tencent.mm.plugin.appbrand.ui.privacy.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManageEntryPoint;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "dead", "", "show", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.vending.e.a
{
  public static final c.a uiO;
  private final MMActivity activity;
  public final f ngn;
  
  static
  {
    AppMethodBeat.i(323003);
    uiO = new c.a((byte)0);
    AppMethodBeat.o(323003);
  }
  
  public c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(322980);
    this.activity = paramMMActivity;
    paramMMActivity = new f((Context)this.activity, 1, false);
    paramMMActivity.Vtg = new c..ExternalSyntheticLambda0(this);
    paramMMActivity.GAC = new c..ExternalSyntheticLambda1(this);
    ah localah = ah.aiuX;
    this.ngn = paramMMActivity;
    this.activity.keep((com.tencent.mm.vending.e.a)this);
    AppMethodBeat.o(322980);
  }
  
  private static final void a(c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(322998);
    kotlin.g.b.s.u(paramc, "this$0");
    if ((paramMenuItem != null) && (paramMenuItem.getGroupId() == 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) && (paramMenuItem.getItemId() == 0))
      {
        paramMenuItem = AppBrandPrivacyManagePage.uiV;
        paramc = (AppCompatActivity)paramc.activity;
        kotlin.g.b.s.u(paramc, "srcActivity");
        kotlin.g.b.s.u(AppBrandPrivacyPageContainerUI.class, "dstActivityClass");
        Log.i("MicroMsg.AppBrandPrivacyManagePage", "start");
        paramMenuItem = new Intent((Context)paramc, AppBrandPrivacyPageContainerUI.class);
        d.a(paramMenuItem, AppBrandPrivacyManagePage.class);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(paramc, paramMenuItem.aYi(), "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramc.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramc, "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(322998);
      return;
    }
  }
  
  private static final void a(c paramc, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(322987);
    kotlin.g.b.s.u(paramc, "this$0");
    if (params != null) {
      params.add(0, 0, 0, (CharSequence)paramc.activity.getString(ba.i.appbrand_privacy_manage_entry_point_title));
    }
    AppMethodBeat.o(322987);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(323023);
    Log.i("MicroMsg.AppBrandPrivacyManageEntryPoint", "dead");
    this.ngn.cyW();
    AppMethodBeat.o(323023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.c
 * JD-Core Version:    0.7.0.1
 */