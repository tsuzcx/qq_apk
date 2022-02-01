package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI16;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "CREATER_GUIDE_URL", "", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "hasExposeOriginalTips", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;)V", "myFinderUser", "originalTag", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "profileSettingCallback", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1;", "profileSettingTag", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "shopInfo", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetLoading", "switchWxProfileSetting", "updateView", "isFromSceneEnd", "plugin-finder_release"})
public final class FinderSettingInfoUI
  extends MMPreference
  implements i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  com.tencent.mm.plugin.finder.utils.b tux;
  private bed udb;
  private ax ueD;
  private String vOl;
  private com.tencent.mm.plugin.finder.api.g vOm;
  private final String vOo;
  private final String vOp;
  private bel vOq;
  private String vOr;
  private String vOs;
  private String vOt;
  private String vOu;
  private final c vOv;
  private bel vcb;
  
  public FinderSettingInfoUI()
  {
    AppMethodBeat.i(252674);
    this.TAG = "Finder.FinderSettingInfoUI";
    this.vOo = "setting_original";
    this.vOp = "settings_show_my_finder";
    this.vOq = new bel();
    this.vcb = new bel();
    this.vOr = ("https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_product.html?scene_id=kf7428");
    this.vOs = ("https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_faq.html?scene_id=kf7467");
    this.vOt = ("https://" + WeChatHosts.domainString(2131761715) + "/touch/scene_faq.html?scene_id=kf7468");
    this.vOu = "";
    this.vOv = new c(this);
    AppMethodBeat.o(252674);
  }
  
  private final void is(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(252671);
    Object localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    this.vOm = c.a.asG(Util.nullAsNil(this.vOl));
    if (this.vOm == null)
    {
      finish();
      AppMethodBeat.o(252671);
      return;
    }
    localObject1 = getPreferenceScreen().bmg("settings_avatar");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
      AppMethodBeat.o(252671);
      throw ((Throwable)localObject1);
    }
    localObject1 = (HeadImgAndNamePreference)localObject1;
    ((HeadImgAndNamePreference)localObject1).a((HeadImgAndNamePreference.a)new d(this));
    Object localObject2 = (Context)this;
    com.tencent.mm.plugin.finder.api.g localg = this.vOm;
    if (localg == null) {
      kotlin.g.b.p.hyc();
    }
    ((HeadImgAndNamePreference)localObject1).setTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localg.getNickname()));
    ((HeadImgAndNamePreference)localObject1).gLE();
    ((HeadImgAndNamePreference)localObject1).bmf(this.vOl);
    ((HeadImgAndNamePreference)localObject1).h((View.OnClickListener)new e(this));
    getPreferenceScreen().jdMethod_do(this.vOo, true);
    localObject1 = com.tencent.mm.plugin.finder.utils.p.vVY;
    if (com.tencent.mm.plugin.finder.utils.p.dBV())
    {
      getPreferenceScreen().jdMethod_do(this.vOo, false);
      localObject1 = h.tKR;
      localObject1 = h.tKR;
      h.a(h.daO(), (LifecycleOwner)this, (Observer)new f(this));
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 6L, 2L);
      }
    }
    localObject1 = this.udb;
    boolean bool1;
    label325:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((bed)localObject1).LNQ;
      if (localObject1 != null) {
        break label623;
      }
      getPreferenceScreen().jdMethod_do("settings_data", true);
      localObject1 = getPreferenceScreen();
      localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.dqH()) {
        break label659;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("settings_creater_guide", bool1);
      Log.i(this.TAG, "update shop:" + this.vOq.appId + ',' + this.vOq.LOg);
      if (Util.isNullOrNil(this.vOq.appId)) {
        break label664;
      }
      getPreferenceScreen().jdMethod_do("settings_shop", false);
      label409:
      localObject1 = this.vOm;
      if (localObject1 == null) {
        break label681;
      }
      i = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_extFlag;
      label426:
      if ((i & 0x20000) <= 0) {
        break label686;
      }
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 7L, 2L);
      }
      getPreferenceScreen().jdMethod_do("setting_live_lottery_history", false);
      label470:
      localObject1 = com.tencent.mm.plugin.finder.utils.x.vXq;
      localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = getPreferenceScreen();
      kotlin.g.b.p.g(localObject2, "preferenceScreen");
      if ((com.tencent.mm.plugin.finder.utils.x.a((Context)localObject1, localObject2, this.vOp)) && (paramBoolean))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 12L, 2L);
      }
      if (this.ueD == null) {
        break label703;
      }
      i = 1;
      label555:
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label708;
      }
    }
    label659:
    label664:
    label681:
    label686:
    label703:
    label708:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("account_management", paramBoolean);
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 10L, 2L);
      }
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(252671);
      return;
      localObject1 = null;
      break;
      label623:
      localObject2 = getPreferenceScreen();
      if (!((aet)localObject1).enable) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject2).jdMethod_do("settings_data", bool1);
        break;
      }
      bool1 = false;
      break label325;
      getPreferenceScreen().jdMethod_do("settings_shop", true);
      break label409;
      i = 0;
      break label426;
      getPreferenceScreen().jdMethod_do("setting_live_lottery_history", true);
      break label470;
      i = 0;
      break label555;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252676);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252676);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252675);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(252675);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return 2132017222;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167614);
    super.onCreate(paramBundle);
    this.vOl = z.aUg();
    Log.i(this.TAG, "myFinderUser " + this.vOl);
    setMMTitle(2131760559);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    getPreferenceScreen().jdMethod_do(this.vOo, true);
    getPreferenceScreen().jdMethod_do(this.vOp, true);
    getPreferenceScreen().notifyDataSetChanged();
    com.tencent.mm.kernel.g.azz().a(3761, (i)this);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252669);
    com.tencent.mm.kernel.g.azz().b(3761, (i)this);
    super.onDestroy();
    AppMethodBeat.o(252669);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    if (paramPreference == null) {
      kotlin.g.b.p.hyc();
    }
    paramf = paramPreference.getKey();
    Log.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (kotlin.g.b.p.j(paramf, "settings_avatar"))
    {
      paramPreference = new Intent();
      paramPreference.setClass((Context)this, FinderSettingDetailInfoUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.b((Context)this, 1L, 1L);
    }
    for (;;)
    {
      AppMethodBeat.o(167616);
      return true;
      if (kotlin.g.b.p.j(paramf, "settings_auth"))
      {
        paramf = new wq();
        paramf.ecI.userName = "gh_4ee148a6ecaa@app";
        paramf.ecI.appId = "wxdfda2588e999a42d";
        paramf.ecI.ecK = "pages/index/index.html";
        paramf.ecI.scene = 1201;
        EventCenter.instance.publish((IEvent)paramf);
        paramf = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 3L, 1L);
      }
      else if (kotlin.g.b.p.j(paramf, "settings_qrcode"))
      {
        paramf = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.fv((Context)this);
        paramf = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 2L, 1L);
      }
      else if (kotlin.g.b.p.j(paramf, "settings_privacy"))
      {
        paramPreference = new Intent();
        paramPreference.setClass((Context)this, FinderSettingPrivacyUI.class);
        paramf = getContext();
        paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
        com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf.startActivity((Intent)paramPreference.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramf = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b((Context)this, 5L, 1L);
      }
      else if (kotlin.g.b.p.j(paramf, "settings_data"))
      {
        paramf = this.udb;
        if (paramf != null)
        {
          paramf = paramf.LNQ;
          if (paramf != null) {
            if (paramf.Lqc == 1)
            {
              if (!Util.isNullOrNil(paramf.lDS))
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf.lDS);
                com.tencent.mm.br.c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
              }
            }
            else if (paramf.Lqc == 2)
            {
              paramPreference = new wq();
              paramPreference.ecI.userName = paramf.Lqd;
              paramPreference.ecI.ecK = paramf.Lqe;
              paramPreference.ecI.scene = 1201;
              EventCenter.instance.publish((IEvent)paramPreference);
            }
          }
        }
      }
      else
      {
        if (kotlin.g.b.p.j(paramf, "settings_creater_guide"))
        {
          paramPreference = new Intent();
          if (LocaleUtil.isSimplifiedChineseAppLang()) {
            paramf = this.vOr;
          }
          for (;;)
          {
            Log.i(this.TAG, "url = ".concat(String.valueOf(paramf)));
            paramPreference.putExtra("rawUrl", paramf);
            com.tencent.mm.br.c.b((Context)this, "webview", ".ui.tools.WebViewUI", paramPreference);
            paramf = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b((Context)this, 4L, 1L);
            break;
            if (LocaleUtil.isTraditionalChineseAppLang())
            {
              paramf = this.vOs;
            }
            else
            {
              kotlin.g.b.p.j(LocaleUtil.getApplicationLanguage(), "en");
              paramf = this.vOt;
            }
          }
        }
        Object localObject;
        if (kotlin.g.b.p.j(paramf, "settings_shop"))
        {
          Log.i(this.TAG, "enter shop:" + this.vOq.appId + ',' + this.vOq.LOg);
          String str = "setting:0" + z.aUg() + ":0:" + Util.getUuidRandom();
          paramf = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a(2L, String.valueOf(this.vOq.appId), Util.getUuidRandom().toString(), 1176L, String.valueOf(SystemClock.elapsedRealtimeNanos()), "setting", "");
          paramf = com.tencent.mm.plugin.finder.utils.a.vUU;
          Context localContext = (Context)this;
          paramPreference = this.vOq.appId;
          paramf = paramPreference;
          if (paramPreference == null) {
            paramf = "";
          }
          localObject = this.vOq.LOg;
          paramPreference = (Preference)localObject;
          if (localObject == null) {
            paramPreference = "";
          }
          com.tencent.mm.plugin.finder.utils.a.a(localContext, paramf, paramPreference, 1176, str);
        }
        else
        {
          if (kotlin.g.b.p.j(paramf, this.vOo))
          {
            paramf = getPreferenceScreen().bmg(this.vOo);
            if (paramf == null)
            {
              paramf = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
              AppMethodBeat.o(167616);
              throw paramf;
            }
            paramf = (NewTipPreference)paramf;
            paramPreference = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a((Context)this, 6L, 1L, paramf.exi());
            paramf = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
            paramPreference = ((PluginFinder)paramf).getRedDotManager().asW("OriginalEntrance");
            paramf = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
            localObject = ((PluginFinder)paramf).getRedDotManager().asX("OriginalEntrance");
            if ((localObject != null) && (paramPreference != null))
            {
              paramf = com.tencent.mm.plugin.finder.report.j.vft;
              paramf = FinderReporterUIC.wzC;
              paramf = FinderReporterUIC.a.fH((Context)this);
              if (paramf == null) {
                break label1187;
              }
            }
            label1187:
            for (paramf = paramf.dIx();; paramf = null)
            {
              com.tencent.mm.plugin.finder.report.j.a("10", (com.tencent.mm.plugin.finder.extension.reddot.k)localObject, paramPreference, 2, paramf, 0, 0, 96);
              paramf = com.tencent.mm.kernel.g.ah(PluginFinder.class);
              kotlin.g.b.p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
              ((PluginFinder)paramf).getRedDotManager().asV("OriginalEntrance");
              paramf = com.tencent.mm.kernel.g.ah(PluginFinder.class);
              kotlin.g.b.p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
              ((PluginFinder)paramf).getRedDotManager().e("FinderSetting", new int[] { 1000 });
              paramf = com.tencent.mm.kernel.g.ah(PluginFinder.class);
              kotlin.g.b.p.g(paramf, "MMKernel.plugin(PluginFinder::class.java)");
              ((PluginFinder)paramf).getRedDotManager().e("ProfileEntrance", new int[] { 1000 });
              paramf = com.tencent.mm.plugin.finder.storage.c.vCb;
              paramf = com.tencent.mm.plugin.finder.storage.c.duB();
              getIntent().putExtra("rawUrl", paramf);
              com.tencent.mm.br.c.b((Context)this, "webview", ".ui.tools.WebViewUI", getIntent());
              break;
            }
          }
          if (kotlin.g.b.p.j(paramf, "setting_live_lottery_history"))
          {
            paramf = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b((Context)this, 7L, 1L);
            paramf = FinderReporterUIC.wzC;
            paramf = (Context)this;
            paramPreference = getIntent();
            kotlin.g.b.p.g(paramPreference, "intent");
            FinderReporterUIC.a.a(paramf, paramPreference, 0L, 0, false, 124);
            paramf = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.a((Activity)this, null, true);
          }
          else if (kotlin.g.b.p.j(paramf, this.vOp))
          {
            paramf = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(paramf, "MMKernel.storage()");
            paramf.azQ().set(ar.a.Omv, Integer.valueOf(1));
            paramf = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b((Context)this, 12L, 1L);
            paramf = getPreferenceScreen().bmg(this.vOp);
            if (paramf == null)
            {
              paramf = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
              AppMethodBeat.o(167616);
              throw paramf;
            }
            boolean bool = ((CheckBoxPreference)paramf).isChecked();
            paramf = y.vXH;
            if (bool != y.dCG())
            {
              Log.i(this.TAG, "change isShowAtWxProfile, now:".concat(String.valueOf(bool)));
              paramf = this.tux;
              if (paramf != null) {
                paramf.end();
              }
              paramf = com.tencent.mm.plugin.finder.utils.b.vVa;
              paramf = getContext();
              kotlin.g.b.p.g(paramf, "context");
              this.tux = b.a.e((Context)paramf, getContext().getString(2131756029), 500L);
              paramf = this.tux;
              if (paramf != null) {
                paramf.begin();
              }
              ((com.tencent.mm.plugin.i.a.x)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a(bool, (ai)this.vOv);
            }
          }
          else if (kotlin.g.b.p.j(paramf, "account_management"))
          {
            paramf = new Intent();
            paramPreference = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b((Context)this, 10L, 1L);
            paramPreference = this.ueD;
            if (paramPreference != null)
            {
              localObject = OccupyFinderUI16.ueF;
              paramf.putExtra(OccupyFinderUI16.deJ(), paramPreference.toByteArray());
              paramPreference = com.tencent.mm.plugin.finder.utils.a.vUU;
              com.tencent.mm.plugin.finder.utils.a.ah((Context)this, paramf);
            }
          }
        }
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post((Runnable)new b(this));
    Object localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.b((Context)this, 1L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.b((Context)this, 2L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.b((Context)this, 3L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.b((Context)this, 4L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.b((Context)this, 5L, 2L);
    localObject = new cd(2);
    com.tencent.mm.kernel.g.azz().b((q)localObject);
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    bed localbed = null;
    AppMethodBeat.i(252670);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramq != null) {}
    for (paramString = Integer.valueOf(paramq.getType());; paramString = null)
    {
      Log.i(str, paramString + " scene:" + paramq);
      paramString = localbed;
      if (paramq != null) {
        paramString = Integer.valueOf(paramq.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(252670);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(252670);
        throw paramString;
      }
      this.udb = ((cd)paramq).cZc();
      localbed = this.udb;
      if (localbed != null)
      {
        paramq = localbed.LNT;
        paramString = paramq;
        if (paramq == null) {
          paramString = new bel();
        }
        this.vOq = paramString;
        paramq = localbed.wxaShopInfo;
        paramString = paramq;
        if (paramq == null) {
          paramString = new bel();
        }
        this.vcb = paramString;
        this.ueD = localbed.LNZ;
        is(true);
        AppMethodBeat.o(252670);
        return;
      }
    }
    AppMethodBeat.o(252670);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(252673);
    super.onStop();
    this.vOu = "";
    AppMethodBeat.o(252673);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167610);
      this.vOw.finish();
      AppMethodBeat.o(167610);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167611);
      FinderSettingInfoUI.a(this.vOw);
      AppMethodBeat.o(167611);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class c
    implements ai<azg>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", "username", "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
  public static final class d
    implements HeadImgAndNamePreference.a
  {
    public final void b(String paramString, ImageView paramImageView)
    {
      AppMethodBeat.i(167612);
      kotlin.g.b.p.h(paramString, "username");
      kotlin.g.b.p.h(paramImageView, "icon");
      if (FinderSettingInfoUI.b(this.vOw) == null)
      {
        Log.e(FinderSettingInfoUI.c(this.vOw), "error self contact is null");
        AppMethodBeat.o(167612);
        return;
      }
      paramString = m.uJa;
      paramString = m.dka();
      Object localObject = FinderSettingInfoUI.b(this.vOw);
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject).field_avatarUrl);
      m localm = m.uJa;
      paramString.a(localObject, paramImageView, m.a(m.a.uJe));
      AppMethodBeat.o(167612);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSettingInfoUI paramFinderSettingInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167613);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (FinderSettingInfoUI.d(this.vOw) != null)
      {
        paramView = new Intent();
        localObject = FinderSettingInfoUI.b(this.vOw);
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        paramView.putStringArrayListExtra("key_url_list", kotlin.a.j.ac(new String[] { ((com.tencent.mm.plugin.finder.api.g)localObject).cXH() }));
        paramView.putExtra("key_preview_avatar", true);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.M((Context)this.vOw, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167613);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class f<T>
    implements Observer<h.a>
  {
    f(FinderSettingInfoUI paramFinderSettingInfoUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */