package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.q;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.k;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.WeUIPreference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandDebugUI;", "Lcom/tencent/weui/base/preference/WeUIPreference;", "()V", "activityMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "getActivityMonitor", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setActivityMonitor", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "getFooterResourceId", "", "getResourceId", "onDestroy", "", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "pref", "Landroid/preference/Preference;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDebugUI
  extends WeUIPreference
{
  @Deprecated
  public static final AppBrandDebugUI.a qUq;
  public com.tencent.e.i.d<?> qUp;
  
  static
  {
    AppMethodBeat.i(276770);
    qUq = new AppBrandDebugUI.a((byte)0);
    AppMethodBeat.o(276770);
  }
  
  public final boolean a(com.tencent.weui.base.preference.a parama, Preference paramPreference)
  {
    AppMethodBeat.i(276765);
    kotlin.g.b.p.k(parama, "screen");
    kotlin.g.b.p.k(paramPreference, "pref");
    Object localObject = parama.bEu("pref_key_enable_preload");
    if (localObject == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    if (!((CheckBoxPreference)localObject).isChecked()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      e.jC(bool1);
      localObject = parama.bEu("pref_key_enable_v2_manager");
      if (localObject != null) {
        break;
      }
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    n.jJ(((CheckBoxPreference)localObject).isChecked());
    localObject = parama.bEu("pref_key_enable_single_task_dispatch");
    if (localObject == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    bool1 = ((CheckBoxPreference)localObject).isChecked();
    localObject = parama.bEu("pref_key_enable_three_proc_tasks_dispatch");
    if (localObject == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    boolean bool2 = ((CheckBoxPreference)localObject).isChecked();
    n.jL(bool1);
    n.jK(bool2);
    localObject = parama.bEu("pref_key_enable_single_task_dispatch");
    if (localObject == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    ((CheckBoxPreference)localObject).BT(bool1);
    localObject = parama.bEu("pref_key_enable_three_proc_tasks_dispatch");
    if (localObject == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    ((CheckBoxPreference)localObject).BT(bool2);
    parama = parama.bEu("pref_key_force_open_wxa_app_for_typed_demo");
    if (parama == null)
    {
      parama = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276765);
      throw parama;
    }
    parama = (CheckBoxPreference)parama;
    localObject = com.tencent.mm.plugin.appbrand.launching.t.pUE;
    com.tencent.mm.plugin.appbrand.launching.t.iQ(parama.isChecked());
    parama = paramPreference.getKey();
    if (parama == null) {}
    for (;;)
    {
      AppMethodBeat.o(276765);
      return true;
      switch (parama.hashCode())
      {
      default: 
        break;
      case -12308374: 
        if (parama.equals("pref_key_test_remote_process_status"))
        {
          parama = i.qRL;
          parama = i.a.cjc();
          int j = parama.length;
          int i = 0;
          while (i < j)
          {
            paramPreference = parama[i];
            Log.i("MicroMsg.AppBrandDebugUI", "onPreferenceTreeClick: process:[%s] isAlive:[%b]", new Object[] { paramPreference, Boolean.valueOf(j.Mp(paramPreference)) });
            i += 1;
          }
        }
        break;
      case 1323416913: 
        if (parama.equals("pref_key_test_kill_all"))
        {
          parama = i.qRL;
          i.a.cjb().b(b.cBk);
        }
        break;
      case 1564999238: 
        if (parama.equals("pref_key_preload_next_wxa"))
        {
          parama = i.qRL;
          i.a.cjb().a(LuggageServiceType.cBP, z.qOO);
          Toast.makeText((Context)this, (CharSequence)"preloading", 0).show();
        }
        break;
      case 1361184451: 
        if (parama.equals("pref_key_preload_downgrade"))
        {
          parama = new EditText((Context)this);
          paramPreference = com.tencent.mm.plugin.appbrand.task.preload.a.qSt;
          parama.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.appbrand.task.preload.a.cji()));
          new AlertDialog.Builder((Context)this).setNegativeButton((CharSequence)"Save", (DialogInterface.OnClickListener)new AppBrandDebugUI.d(parama)).setView((View)parama).show();
        }
        break;
      case 811513037: 
        if (parama.equals("pref_key_preload_next_plugin"))
        {
          parama = i.qRL;
          i.a.cjb().a(LuggageServiceType.cBP, z.qOO);
          Toast.makeText((Context)this, (CharSequence)"preloading plugin", 0).show();
        }
        break;
      }
    }
  }
  
  public final int getFooterResourceId()
  {
    return au.g.app_brand_activity_monitor_layout;
  }
  
  public final int getResourceId()
  {
    return au.k.app_brand_debug_preference;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276768);
    super.onDestroy();
    if (((AppBrandDebugUI)this).qUp != null)
    {
      com.tencent.e.i.d locald = this.qUp;
      if (locald == null) {
        kotlin.g.b.p.bGy("activityMonitor");
      }
      locald.cancel(true);
    }
    AppMethodBeat.o(276768);
  }
  
  @SuppressLint({"SetTextI18n"})
  public final void onPostCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(276762);
    if (!d.cjA())
    {
      finish();
      AppMethodBeat.o(276762);
      return;
    }
    super.onPostCreate(paramBundle);
    setTitle((CharSequence)"小程序 DebugUI");
    setTitleColor(androidx.core.content.a.w((Context)this, au.c.FG_0));
    paramBundle = ivl().bEu("pref_key_enable_preload");
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276762);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    if (!e.cjl()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      paramBundle.amm(8);
      paramBundle = ivl().bEu("pref_key_enable_v2_manager");
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276762);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(n.cjZ());
    paramBundle.amm(8);
    paramBundle = ivl().bEu("pref_key_enable_single_task_dispatch");
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276762);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(n.cka());
    paramBundle.amm(8);
    paramBundle = ivl().bEu("pref_key_enable_three_proc_tasks_dispatch");
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276762);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    paramBundle.setChecked(n.ckb());
    paramBundle.amm(8);
    paramBundle = ivl().bEu("pref_key_force_open_wxa_app_for_typed_demo");
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(276762);
      throw paramBundle;
    }
    paramBundle = (CheckBoxPreference)paramBundle;
    com.tencent.mm.plugin.appbrand.launching.t localt = com.tencent.mm.plugin.appbrand.launching.t.pUE;
    paramBundle.setChecked(com.tencent.mm.plugin.appbrand.launching.t.bZQ());
    paramBundle.amm(8);
    paramBundle = i.qRL;
    paramBundle = i.a.cjc();
    int j = paramBundle.length;
    while (i < j)
    {
      localt = paramBundle[i];
      j.b(localt, (com.tencent.mm.ipcinvoker.p)new b(localt));
      j.b(localt, (q)new c(localt));
      i += 1;
    }
    AppMethodBeat.o(276762);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDisconnect"})
  static final class b
    implements com.tencent.mm.ipcinvoker.p
  {
    b(String paramString) {}
    
    public final void aFw()
    {
      AppMethodBeat.i(278102);
      AppBrandDebugUI.cjz();
      Log.i("MicroMsg.AppBrandDebugUI", "onPostCreate: disconnect:" + this.qUr);
      AppMethodBeat.o(278102);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onReconnect"})
  static final class c
    implements q
  {
    c(String paramString) {}
    
    public final void aFx()
    {
      AppMethodBeat.i(267406);
      AppBrandDebugUI.cjz();
      Log.i("MicroMsg.AppBrandDebugUI", "onPostCreate: reconnect:" + this.qUr);
      AppMethodBeat.o(267406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI
 * JD-Core Version:    0.7.0.1
 */