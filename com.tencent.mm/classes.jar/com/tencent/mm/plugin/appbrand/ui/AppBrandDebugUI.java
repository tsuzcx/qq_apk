package com.tencent.mm.plugin.appbrand.ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.k;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.threadpool.i.d;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.WeUIPreference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandDebugUI;", "Lcom/tencent/weui/base/preference/WeUIPreference;", "()V", "activityMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "getActivityMonitor", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setActivityMonitor", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "onPreferenceChangeListeners", "Ljava/util/HashMap;", "", "Lkotlin/Function1;", "Landroid/preference/Preference;", "", "Lkotlin/collections/HashMap;", "getFooterResourceId", "", "getResourceId", "handleIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPostCreate", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "pref", "registerPreference", "P", "key", "onChange", "resetTitleForPrefWxaPageSwitchEnterTimeout", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandDebugUI
  extends WeUIPreference
{
  private static final AppBrandDebugUI.a tZp;
  public d<?> tZq;
  private final HashMap<String, kotlin.g.a.b<Preference, ah>> tZr;
  
  static
  {
    AppMethodBeat.i(321940);
    tZp = new AppBrandDebugUI.a((byte)0);
    AppMethodBeat.o(321940);
  }
  
  public AppBrandDebugUI()
  {
    AppMethodBeat.i(321929);
    this.tZr = new HashMap();
    AppMethodBeat.o(321929);
  }
  
  private static final void a(EditText paramEditText, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(321937);
    s.u(paramEditText, "$editView");
    try
    {
      paramDialogInterface = com.tencent.mm.plugin.appbrand.task.preload.a.tWY;
      com.tencent.mm.plugin.appbrand.task.preload.a.Dj(Integer.parseInt(paramEditText.getText().toString()));
      AppMethodBeat.o(321937);
      return;
    }
    catch (NumberFormatException paramEditText)
    {
      AppMethodBeat.o(321937);
    }
  }
  
  private final <P extends Preference> void a(String paramString, kotlin.g.a.b<? super P, ah> paramb1, kotlin.g.a.b<? super P, ah> paramb2)
  {
    AppMethodBeat.i(321931);
    Preference localPreference = this.aicv.bGT(paramString);
    if ((localPreference instanceof Preference)) {}
    for (;;)
    {
      if (localPreference != null)
      {
        localPreference.setPersistent(false);
        paramb1.invoke(localPreference);
        this.tZr.put(paramString, paramb2);
      }
      AppMethodBeat.o(321931);
      return;
      localPreference = null;
    }
  }
  
  private static final boolean a(AppBrandDebugUI paramAppBrandDebugUI, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(321939);
    s.u(paramAppBrandDebugUI, "this$0");
    c.jT(Util.getLong(paramCharSequence.toString(), c.cKN()));
    paramAppBrandDebugUI.cKK();
    paramAppBrandDebugUI = paramAppBrandDebugUI.aicv;
    if (paramAppBrandDebugUI != null) {
      paramAppBrandDebugUI.notifyDataSetChanged();
    }
    AppMethodBeat.o(321939);
    return true;
  }
  
  private static final void agd(String paramString)
  {
    AppMethodBeat.i(321935);
    s.u(paramString, "$processName");
    Log.i("MicroMsg.AppBrandDebugUI", s.X("onPostCreate: disconnect:", paramString));
    AppMethodBeat.o(321935);
  }
  
  private static final void age(String paramString)
  {
    AppMethodBeat.i(321936);
    s.u(paramString, "$processName");
    Log.i("MicroMsg.AppBrandDebugUI", s.X("onPostCreate: reconnect:", paramString));
    AppMethodBeat.o(321936);
  }
  
  private final void cKK()
  {
    AppMethodBeat.i(321933);
    Preference localPreference = this.aicv.bGT("pref_key_wxa_page_switch_enter_timeout");
    if (localPreference != null) {
      localPreference.setTitle((CharSequence)("页面切换 进入超时时间:" + c.cKN() + "ms"));
    }
    AppMethodBeat.o(321933);
  }
  
  private final void cKL()
  {
    AppMethodBeat.i(321934);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      AppMethodBeat.o(321934);
      return;
    }
    Object localObject2 = localIntent.getStringExtra("appId");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(321934);
      throw ((Throwable)localObject1);
    }
    String str = n.bq((CharSequence)localObject1).toString();
    int i;
    if (((CharSequence)str).length() == 0) {
      i = 1;
    }
    while (i == 0)
    {
      localObject2 = localIntent.getStringExtra("versionType");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "0";
      }
      i = Integer.parseInt(n.bq((CharSequence)localObject1).toString());
      localObject2 = localIntent.getStringExtra("enterPath");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(321934);
        throw ((Throwable)localObject1);
        i = 0;
      }
      else
      {
        localObject1 = n.bq((CharSequence)localObject1).toString();
        localObject2 = new g();
        ((g)localObject2).appId = str;
        ((g)localObject2).euz = i;
        ((g)localObject2).qAF = ((String)localObject1);
        ((g)localObject2).scene = 1001;
        ((t)h.ax(t.class)).a((Context)this, (g)localObject2);
        finish();
      }
    }
    AppMethodBeat.o(321934);
  }
  
  public final boolean a(com.tencent.weui.base.preference.a parama, Preference paramPreference)
  {
    AppMethodBeat.i(321948);
    s.u(parama, "screen");
    s.u(paramPreference, "pref");
    parama = (kotlin.g.a.b)this.tZr.get(paramPreference.getKey());
    if (parama != null)
    {
      parama.invoke(paramPreference);
      AppMethodBeat.o(321948);
      return true;
    }
    parama = paramPreference.getKey();
    if (parama != null) {
      switch (parama.hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(321948);
      return true;
      if (parama.equals("pref_key_test_kill_all"))
      {
        parama = i.tWq;
        i.a.cJV().b(com.tencent.luggage.sdk.processes.b.etQ);
        continue;
        if (parama.equals("pref_key_preload_next_wxa"))
        {
          parama = i.tWq;
          i.a.cJV().a(LuggageServiceType.euv, ab.tTF);
          Toast.makeText((Context)this, (CharSequence)"preloading", 0).show();
          continue;
          if (parama.equals("pref_key_preload_downgrade"))
          {
            parama = new EditText((Context)this);
            paramPreference = com.tencent.mm.plugin.appbrand.task.preload.a.tWY;
            parama.setText((CharSequence)String.valueOf(com.tencent.mm.plugin.appbrand.task.preload.a.cKi()));
            new AlertDialog.Builder((Context)this).setNegativeButton((CharSequence)"Save", new AppBrandDebugUI..ExternalSyntheticLambda0(parama)).setView((View)parama).show();
            continue;
            if (parama.equals("pref_key_preload_next_plugin"))
            {
              parama = i.tWq;
              i.a.cJV().a(LuggageServiceType.euv, ab.tTF);
              Toast.makeText((Context)this, (CharSequence)"preloading plugin", 0).show();
              continue;
              if (parama.equals("pref_key_wxa_page_switch_enter_timeout"))
              {
                k.a((Context)this, "输入数字", "", "", new AppBrandDebugUI..ExternalSyntheticLambda3(this));
                continue;
                if (parama.equals("pref_key_test_remote_process_status"))
                {
                  parama = i.tWq;
                  parama = i.a.cJW();
                  int j = parama.length;
                  int i = 0;
                  while (i < j)
                  {
                    paramPreference = parama[i];
                    Log.i("MicroMsg.AppBrandDebugUI", "onPreferenceTreeClick: process:[%s] isAlive:[%b]", new Object[] { paramPreference, Boolean.valueOf(j.EX(paramPreference)) });
                    i += 1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final int getFooterResourceId()
  {
    return ba.g.app_brand_activity_monitor_layout;
  }
  
  public final int getResourceId()
  {
    return ba.k.app_brand_debug_preference;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(321947);
    super.onCreate(paramBundle);
    cKL();
    AppMethodBeat.o(321947);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(321949);
    super.onDestroy();
    d locald;
    if (this.tZq != null)
    {
      locald = this.tZq;
      if (locald == null) {
        break label41;
      }
    }
    for (;;)
    {
      locald.cancel(true);
      AppMethodBeat.o(321949);
      return;
      label41:
      s.bIx("activityMonitor");
      locald = null;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(321946);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    cKL();
    AppMethodBeat.o(321946);
  }
  
  public final void onPostCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(321945);
    if (!c.cKM())
    {
      finish();
      AppMethodBeat.o(321945);
      return;
    }
    super.onPostCreate(paramBundle);
    setTitle((CharSequence)"小程序 DebugUI");
    setActionBarColor(androidx.core.content.a.w((Context)this, ba.c.BG_0));
    a("pref_key_enable_preload", (kotlin.g.a.b)b.tZs, (kotlin.g.a.b)m.tZC);
    a("pref_key_enable_v2_manager", (kotlin.g.a.b)x.tZN, (kotlin.g.a.b)z.tZP);
    a("pref_key_force_open_wxa_app_debug", (kotlin.g.a.b)aa.tZQ, (kotlin.g.a.b)ab.tZR);
    a("pref_key_enable_capsule_hotspot", (kotlin.g.a.b)ac.tZS, (kotlin.g.a.b)ad.tZT);
    a("pref_key_enable_single_task_dispatch", (kotlin.g.a.b)ae.tZU, (kotlin.g.a.b)new c(this));
    a("pref_key_enable_three_proc_tasks_dispatch", (kotlin.g.a.b)d.tZu, (kotlin.g.a.b)new e(this));
    a("pref_key_force_open_wxa_app_for_typed_demo", (kotlin.g.a.b)f.tZv, (kotlin.g.a.b)g.tZw);
    a("pref_key_close_demo_info_for_wxa_app_warm_launch", (kotlin.g.a.b)h.tZx, (kotlin.g.a.b)i.tZy);
    a("pref_key_block_splash", (kotlin.g.a.b)j.tZz, (kotlin.g.a.b)k.tZA);
    a("pref_key_force_center_inside", (kotlin.g.a.b)l.tZB, (kotlin.g.a.b)n.tZD);
    a("pref_key_force_not_center_inside", (kotlin.g.a.b)o.tZE, (kotlin.g.a.b)p.tZF);
    a("pref_key_enable_privacy_mock", (kotlin.g.a.b)q.tZG, (kotlin.g.a.b)r.tZH);
    a("pref_key_enable_console_panel", (kotlin.g.a.b)s.tZI, (kotlin.g.a.b)t.tZJ);
    a("pref_key_mock_bluetooth_scope", (kotlin.g.a.b)u.tZK, (kotlin.g.a.b)v.tZL);
    cKK();
    a("pref_key_enable_wxa_launch_process_debug_hint", (kotlin.g.a.b)w.tZM, (kotlin.g.a.b)y.tZO);
    paramBundle = i.tWq;
    paramBundle = i.a.cJW();
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      String str = paramBundle[i];
      j.b(str, new AppBrandDebugUI..ExternalSyntheticLambda1(str));
      j.b(str, new AppBrandDebugUI..ExternalSyntheticLambda2(str));
      i += 1;
    }
    AppMethodBeat.o(321945);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final aa tZQ;
    
    static
    {
      AppMethodBeat.i(321966);
      tZQ = new aa();
      AppMethodBeat.o(321966);
    }
    
    aa()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final ab tZR;
    
    static
    {
      AppMethodBeat.i(321968);
      tZR = new ab();
      AppMethodBeat.o(321968);
    }
    
    ab()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final ac tZS;
    
    static
    {
      AppMethodBeat.i(321963);
      tZS = new ac();
      AppMethodBeat.o(321963);
    }
    
    ac()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final ad tZT;
    
    static
    {
      AppMethodBeat.i(322494);
      tZT = new ad();
      AppMethodBeat.o(322494);
    }
    
    ad()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final ae tZU;
    
    static
    {
      AppMethodBeat.i(322499);
      tZU = new ae();
      AppMethodBeat.o(322499);
    }
    
    ae()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final b tZs;
    
    static
    {
      AppMethodBeat.i(322367);
      tZs = new b();
      AppMethodBeat.o(322367);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    c(AppBrandDebugUI paramAppBrandDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final d tZu;
    
    static
    {
      AppMethodBeat.i(322374);
      tZu = new d();
      AppMethodBeat.o(322374);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    e(AppBrandDebugUI paramAppBrandDebugUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final f tZv;
    
    static
    {
      AppMethodBeat.i(322387);
      tZv = new f();
      AppMethodBeat.o(322387);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final g tZw;
    
    static
    {
      AppMethodBeat.i(322389);
      tZw = new g();
      AppMethodBeat.o(322389);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final h tZx;
    
    static
    {
      AppMethodBeat.i(322394);
      tZx = new h();
      AppMethodBeat.o(322394);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final i tZy;
    
    static
    {
      AppMethodBeat.i(322406);
      tZy = new i();
      AppMethodBeat.o(322406);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final j tZz;
    
    static
    {
      AppMethodBeat.i(322423);
      tZz = new j();
      AppMethodBeat.o(322423);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final k tZA;
    
    static
    {
      AppMethodBeat.i(322417);
      tZA = new k();
      AppMethodBeat.o(322417);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final l tZB;
    
    static
    {
      AppMethodBeat.i(322419);
      tZB = new l();
      AppMethodBeat.o(322419);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final m tZC;
    
    static
    {
      AppMethodBeat.i(322421);
      tZC = new m();
      AppMethodBeat.o(322421);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final n tZD;
    
    static
    {
      AppMethodBeat.i(322435);
      tZD = new n();
      AppMethodBeat.o(322435);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final o tZE;
    
    static
    {
      AppMethodBeat.i(322432);
      tZE = new o();
      AppMethodBeat.o(322432);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final p tZF;
    
    static
    {
      AppMethodBeat.i(322437);
      tZF = new p();
      AppMethodBeat.o(322437);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final q tZG;
    
    static
    {
      AppMethodBeat.i(322299);
      tZG = new q();
      AppMethodBeat.o(322299);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final r tZH;
    
    static
    {
      AppMethodBeat.i(322302);
      tZH = new r();
      AppMethodBeat.o(322302);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final s tZI;
    
    static
    {
      AppMethodBeat.i(322304);
      tZI = new s();
      AppMethodBeat.o(322304);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final t tZJ;
    
    static
    {
      AppMethodBeat.i(322308);
      tZJ = new t();
      AppMethodBeat.o(322308);
    }
    
    t()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final u tZK;
    
    static
    {
      AppMethodBeat.i(322312);
      tZK = new u();
      AppMethodBeat.o(322312);
    }
    
    u()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final v tZL;
    
    static
    {
      AppMethodBeat.i(322318);
      tZL = new v();
      AppMethodBeat.o(322318);
    }
    
    v()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final w tZM;
    
    static
    {
      AppMethodBeat.i(322320);
      tZM = new w();
      AppMethodBeat.o(322320);
    }
    
    w()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final x tZN;
    
    static
    {
      AppMethodBeat.i(322326);
      tZN = new x();
      AppMethodBeat.o(322326);
    }
    
    x()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final y tZO;
    
    static
    {
      AppMethodBeat.i(322342);
      tZO = new y();
      AppMethodBeat.o(322342);
    }
    
    y()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/weui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.b<CheckBoxPreference, ah>
  {
    public static final z tZP;
    
    static
    {
      AppMethodBeat.i(322332);
      tZP = new z();
      AppMethodBeat.o(322332);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI
 * JD-Core Version:    0.7.0.1
 */