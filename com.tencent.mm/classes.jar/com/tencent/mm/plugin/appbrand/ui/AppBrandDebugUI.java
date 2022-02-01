package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.WeUIPreference;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandDebugUI;", "Lcom/tencent/weui/base/preference/WeUIPreference;", "()V", "activityMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "getActivityMonitor", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setActivityMonitor", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "getFooterResourceId", "", "getResourceId", "onDestroy", "", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "pref", "Landroid/preference/Preference;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDebugUI
  extends WeUIPreference
{
  @Deprecated
  public static final AppBrandDebugUI.a nSO;
  public d<?> nSN;
  
  static
  {
    AppMethodBeat.i(229478);
    nSO = new AppBrandDebugUI.a((byte)0);
    AppMethodBeat.o(229478);
  }
  
  public final boolean a(com.tencent.weui.base.preference.a parama, Preference paramPreference)
  {
    AppMethodBeat.i(229476);
    kotlin.g.b.p.h(parama, "screen");
    kotlin.g.b.p.h(paramPreference, "pref");
    Preference localPreference = parama.brv("pref_key_enable_preload");
    if (localPreference == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    if (!((CheckBoxPreference)localPreference).isChecked()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      e.iG(bool1);
      localPreference = parama.brv("pref_key_enable_v2_manager");
      if (localPreference != null) {
        break;
      }
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    p.iN(((CheckBoxPreference)localPreference).isChecked());
    localPreference = parama.brv("pref_key_enable_single_task_dispatch");
    if (localPreference == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    bool1 = ((CheckBoxPreference)localPreference).isChecked();
    localPreference = parama.brv("pref_key_enable_three_proc_tasks_dispatch");
    if (localPreference == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    boolean bool2 = ((CheckBoxPreference)localPreference).isChecked();
    p.iP(bool1);
    p.iO(bool2);
    localPreference = parama.brv("pref_key_enable_single_task_dispatch");
    if (localPreference == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    ((CheckBoxPreference)localPreference).xZ(bool1);
    parama = parama.brv("pref_key_enable_three_proc_tasks_dispatch");
    if (parama == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229476);
      throw parama;
    }
    ((CheckBoxPreference)parama).xZ(bool2);
    parama = paramPreference.getKey();
    if (parama == null) {}
    for (;;)
    {
      AppMethodBeat.o(229476);
      return true;
      switch (parama.hashCode())
      {
      default: 
        break;
      case 811513037: 
        if (parama.equals("pref_key_preload_next_plugin"))
        {
          h.bWb().e(z.nMw);
          Toast.makeText((Context)this, (CharSequence)"preloading", 0).show();
        }
        break;
      case 1323416913: 
        if (parama.equals("pref_key_test_kill_all")) {
          h.bWb().zn(2);
        }
        break;
      case 1564999238: 
        if (parama.equals("pref_key_preload_next_wxa"))
        {
          h.bWb().a(g.nPD, z.nMw);
          Toast.makeText((Context)this, (CharSequence)"preloading", 0).show();
        }
        break;
      case 1361184451: 
        if (parama.equals("pref_key_preload_downgrade"))
        {
          parama = new EditText((Context)this);
          paramPreference = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
          parama.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.appbrand.task.preload.a.bWD()));
          new AlertDialog.Builder((Context)this).setNegativeButton((CharSequence)"Save", (DialogInterface.OnClickListener)new c(parama)).setView((View)parama).show();
        }
        break;
      }
    }
  }
  
  public final int getFooterResourceId()
  {
    return 2131493005;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229477);
    super.onDestroy();
    if (((AppBrandDebugUI)this).nSN != null)
    {
      d locald = this.nSN;
      if (locald == null) {
        kotlin.g.b.p.btv("activityMonitor");
      }
      locald.cancel(true);
    }
    AppMethodBeat.o(229477);
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229475);
    if (!f.bWW())
    {
      finish();
      AppMethodBeat.o(229475);
      return;
    }
    super.onPostCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.setTitle((CharSequence)"AppBrand Client Debug");
    }
    paramBundle = hrD().brv("pref_key_enable_preload");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229475);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    if (!e.bWG()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      paramBundle.aez(8);
      paramBundle = hrD().brv("pref_key_enable_v2_manager");
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229475);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(p.bXu());
    paramBundle.aez(8);
    paramBundle = hrD().brv("pref_key_enable_single_task_dispatch");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229475);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(p.bXv());
    paramBundle.aez(8);
    paramBundle = hrD().brv("pref_key_enable_three_proc_tasks_dispatch");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(229475);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(p.bXw());
    paramBundle.aez(8);
    paramBundle = c.nOr;
    c.c((m)new AppBrandDebugUI.b(this));
    AppMethodBeat.o(229475);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(EditText paramEditText) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(229474);
      paramDialogInterface = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
      com.tencent.mm.plugin.appbrand.task.preload.a.zo(Integer.parseInt(this.nSQ.getText().toString()));
      AppMethodBeat.o(229474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI
 * JD-Core Version:    0.7.0.1
 */