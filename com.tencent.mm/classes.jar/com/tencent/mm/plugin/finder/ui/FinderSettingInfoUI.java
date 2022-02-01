package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.iu;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent;
import com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent.a;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.b.b;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "coverSetEvent", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$coverSetEvent$1", "Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$coverSetEvent$1;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;)V", "modifyMpIdentityCallback", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$modifyMpIdentityCallback$2$1", "getModifyMpIdentityCallback", "()Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$modifyMpIdentityCallback$2$1;", "modifyMpIdentityCallback$delegate", "Lkotlin/Lazy;", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "profileSettingCallback", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1;", "profileSettingTag", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "checkPoiNextStep", "", "doPrepareUser", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetLoading", "switchMpIdentity", "switchWxProfileSetting", "updateView", "isFromSceneEnd", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSettingInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  public static final a FUh;
  private bys AwM;
  private ax BkY;
  private String Bre;
  private m Brf;
  b DiB;
  private final String FUi;
  private final coverSetEvent.1 FUj;
  private final j FUk;
  private final c FUl;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(346785);
    FUh = new a((byte)0);
    AppMethodBeat.o(346785);
  }
  
  public FinderSettingInfoUI()
  {
    AppMethodBeat.i(346745);
    this.TAG = "Finder.FinderSettingInfoUI";
    this.FUi = "settings_show_my_finder";
    this.FUj = new IListener(com.tencent.mm.app.f.hfK) {};
    this.FUk = k.cm((kotlin.g.a.a)new b(this));
    this.FUl = new c(this);
    AppMethodBeat.o(346745);
  }
  
  private static final void a(FinderSettingInfoUI paramFinderSettingInfoUI)
  {
    AppMethodBeat.i(346770);
    kotlin.g.b.s.u(paramFinderSettingInfoUI, "this$0");
    paramFinderSettingInfoUI.kD(false);
    AppMethodBeat.o(346770);
  }
  
  private static final boolean a(FinderSettingInfoUI paramFinderSettingInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346767);
    kotlin.g.b.s.u(paramFinderSettingInfoUI, "this$0");
    paramFinderSettingInfoUI.finish();
    AppMethodBeat.o(346767);
    return true;
  }
  
  private final void eJc()
  {
    AppMethodBeat.i(346762);
    Object localObject = this.DiB;
    if (localObject != null) {
      ((b)localObject).end();
    }
    localObject = b.HcE;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    this.DiB = b.a.d((Context)localObject, getContext().getString(e.h.app_waiting), 500L);
    localObject = this.DiB;
    if (localObject != null) {
      ((b)localObject).begin();
    }
    AppMethodBeat.o(346762);
  }
  
  private final void kD(boolean paramBoolean)
  {
    Object localObject2 = null;
    boolean bool2 = true;
    AppMethodBeat.i(346756);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    this.Brf = d.a.auT(Util.nullAsNil(this.Bre));
    if (this.Brf == null)
    {
      finish();
      AppMethodBeat.o(346756);
      return;
    }
    localObject1 = this.AwM;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label187;
      }
      getPreferenceScreen().eh("settings_data", true);
      localObject1 = this.AwM;
      if (localObject1 != null) {
        break label223;
      }
    }
    label187:
    label223:
    for (localObject1 = null;; localObject1 = ((bys)localObject1).aahJ)
    {
      if (localObject1 != null) {
        break label233;
      }
      getPreferenceScreen().eh("settings_poi", true);
      localObject1 = av.GiL;
      if (!av.ffZ()) {
        break label643;
      }
      getPreferenceScreen().eh("settings_mp_identity_switch", false);
      localObject1 = getPreferenceScreen().bAi("settings_mp_identity_switch");
      if (localObject1 != null) {
        break label269;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(346756);
      throw ((Throwable)localObject1);
      localObject1 = ((bys)localObject1).aahw;
      break;
      localObject3 = getPreferenceScreen();
      if (!((aho)localObject1).enable) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject3).eh("settings_data", bool1);
        break;
      }
    }
    label233:
    Object localObject3 = getPreferenceScreen();
    if (((byq)localObject1).aahm == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject3).eh("settings_poi", bool1);
      break;
    }
    label269:
    localObject1 = (CheckBoxPreference)localObject1;
    ((Preference)localObject1).adZV = false;
    localObject3 = av.GiL;
    label375:
    int i;
    if (av.fgb())
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      ((CheckBoxPreference)localObject1).aS((CharSequence)com.tencent.mm.plugin.finder.storage.d.eUE());
      ((CheckBoxPreference)localObject1).setChecked(false);
      ((CheckBoxPreference)localObject1).setEnabled(false);
      if (paramBoolean)
      {
        localObject1 = bb.FuK;
        localObject1 = as.GSQ;
        localObject1 = getContext();
        kotlin.g.b.s.s(localObject1, "context");
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 == null)
        {
          localObject1 = null;
          bb.a((bui)localObject1, "switch_identity_to_bizuin_close", 0);
        }
      }
      else
      {
        localObject1 = au.GiJ;
        localObject1 = (Context)this;
        localObject2 = getPreferenceScreen();
        kotlin.g.b.s.s(localObject2, "preferenceScreen");
        if ((au.a((Context)localObject1, localObject2, this.FUi)) && (paramBoolean))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.b((Context)this, 12L, 2L);
        }
        if (this.BkY == null) {
          break label660;
        }
        i = 1;
        label445:
        localObject1 = getPreferenceScreen();
        if (i != 0) {
          break label665;
        }
      }
    }
    label643:
    label660:
    label665:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("account_management", paramBoolean);
      if (i != 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.b((Context)this, 10L, 2L);
      }
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(346756);
      return;
      localObject1 = ((as)localObject1).fou();
      break;
      localObject3 = av.GiL;
      bool1 = av.fga();
      ((CheckBoxPreference)localObject1).aS((CharSequence)getContext().getResources().getString(e.h.finder_mp_identity_switch_setting_desc));
      ((CheckBoxPreference)localObject1).setChecked(bool1);
      ((CheckBoxPreference)localObject1).setEnabled(true);
      if (!paramBoolean) {
        break label375;
      }
      localObject1 = bb.FuK;
      localObject1 = as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        label605:
        if (!bool1) {
          break label635;
        }
      }
      label635:
      for (localObject2 = "switch_identity_to_bizuin_open";; localObject2 = "switch_identity_to_bizuin_close")
      {
        bb.a((bui)localObject1, (String)localObject2, 0);
        break;
        localObject1 = ((as)localObject1).fou();
        break label605;
      }
      getPreferenceScreen().eh("settings_mp_identity_switch", true);
      break label375;
      i = 0;
      break label445;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_setting_info_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167614);
    super.onCreate(paramBundle);
    paramBundle = as.GSQ;
    paramBundle = as.a.hu((Context)this);
    if (paramBundle != null) {
      as.a(paramBundle, 130);
    }
    this.Bre = com.tencent.mm.model.z.bAW();
    Log.i(this.TAG, kotlin.g.b.s.X("myFinderUser ", this.Bre));
    setMMTitle(e.h.finder_setting_manager);
    setBackBtn(new FinderSettingInfoUI..ExternalSyntheticLambda0(this));
    getPreferenceScreen().eh(this.FUi, true);
    getPreferenceScreen().notifyDataSetChanged();
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167614);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346820);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(346820);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167616);
    kotlin.g.b.s.checkNotNull(paramPreference);
    paramf = paramPreference.mKey;
    Log.i(this.TAG, kotlin.g.b.s.X("click ", paramf));
    if (kotlin.g.b.s.p(paramf, "settings_avatar"))
    {
      paramPreference = new Intent();
      paramPreference.setClass((Context)this, FinderSettingDetailInfoUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(paramf, paramPreference.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramf, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.b((Context)this, 1L, 1L);
    }
    boolean bool;
    label748:
    do
    {
      do
      {
        for (;;)
        {
          AppMethodBeat.o(167616);
          return true;
          if (kotlin.g.b.s.p(paramf, "settings_qrcode"))
          {
            paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
            com.tencent.mm.plugin.finder.utils.a.hb((Context)this);
            paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.b((Context)this, 2L, 1L);
          }
          else if (kotlin.g.b.s.p(paramf, "settings_privacy"))
          {
            paramf = new Intent();
            paramf.setClass((Context)this, FinderSettingPrivacyUI.class);
            paramPreference = this.AwM;
            if (paramPreference != null)
            {
              paramPreference = paramPreference.aahP;
              if (paramPreference != null) {
                paramf.putExtra("privacy_settings", paramPreference.toByteArray());
              }
            }
            paramPreference = getContext();
            paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
            com.tencent.mm.hellhoundlib.a.a.b(paramPreference, paramf.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramPreference.startActivity((Intent)paramf.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramPreference, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.b((Context)this, 5L, 1L);
          }
          else if (kotlin.g.b.s.p(paramf, "settings_data"))
          {
            paramf = this.AwM;
            if (paramf != null)
            {
              paramf = paramf.aahw;
              if (paramf != null) {
                if (paramf.ZqC == 1)
                {
                  if (!Util.isNullOrNil(paramf.rDm))
                  {
                    paramPreference = new Intent();
                    paramPreference.putExtra("rawUrl", paramf.rDm);
                    c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
                  }
                }
                else if (paramf.ZqC == 2)
                {
                  paramPreference = new zp();
                  paramPreference.icM.userName = paramf.ZqD;
                  paramPreference.icM.icO = paramf.ZqE;
                  paramPreference.icM.scene = 1201;
                  paramPreference.publish();
                }
              }
            }
          }
          else if (kotlin.g.b.s.p(paramf, this.FUi))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.addO, Integer.valueOf(1));
            com.tencent.mm.kernel.h.baE().ban().set(at.a.addP, Integer.valueOf(1));
            paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.b((Context)this, 12L, 1L);
            paramf = getPreferenceScreen().bAi(this.FUi);
            if (paramf == null)
            {
              paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
              AppMethodBeat.o(167616);
              throw paramf;
            }
            bool = ((CheckBoxPreference)paramf).isChecked();
            paramf = av.GiL;
            if (bool != av.ffW())
            {
              Log.i(this.TAG, kotlin.g.b.s.X("change isShowAtWxProfile, now:", Boolean.valueOf(bool)));
              eJc();
              ((r)com.tencent.mm.kernel.h.ax(r.class)).a(bool, (ck)this.FUl);
            }
          }
          else
          {
            if (!kotlin.g.b.s.p(paramf, "account_management")) {
              break;
            }
            paramf = new Intent();
            paramPreference = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.b((Context)this, 10L, 1L);
            paramPreference = this.BkY;
            if (paramPreference != null)
            {
              FinderAccountManagent.a locala = FinderAccountManagent.BkX;
              paramf.putExtra(FinderAccountManagent.eei(), paramPreference.toByteArray());
              paramPreference = com.tencent.mm.plugin.finder.utils.a.GfO;
              com.tencent.mm.plugin.finder.utils.a.av((Context)this, paramf);
            }
          }
        }
        if (kotlin.g.b.s.p(paramf, "settings_poi"))
        {
          paramf = this.AwM;
          if (paramf == null) {
            paramf = null;
          }
          for (;;)
          {
            if (paramf == null)
            {
              Log.i(((FinderSettingInfoUI)this).TAG, "poi info error");
              break;
              paramf = paramf.aahJ;
              if (paramf == null)
              {
                paramf = null;
              }
              else
              {
                if (paramf.aaho != 1) {
                  break label832;
                }
                getIntent().putExtra("rawUrl", paramf.aahq);
                c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
              }
            }
          }
          for (;;)
          {
            paramf = ah.aiuX;
            break label748;
            break;
            if ((paramf.aahm == 1) && (paramf.aahp == 1))
            {
              paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
              com.tencent.mm.plugin.finder.utils.a.gY((Context)this);
            }
            else
            {
              paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
              com.tencent.mm.plugin.finder.utils.a.gZ((Context)this);
            }
          }
        }
      } while (!kotlin.g.b.s.p(paramf, "settings_mp_identity_switch"));
      paramf = getPreferenceScreen().bAi("settings_mp_identity_switch");
      if (paramf == null)
      {
        paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167616);
        throw paramf;
      }
      bool = ((CheckBoxPreference)paramf).isChecked();
      paramf = av.GiL;
    } while (bool == av.fga());
    label832:
    Log.i(this.TAG, kotlin.g.b.s.X("change isShowSettingMpIdentitySwitch, now:", Boolean.valueOf(bool)));
    eJc();
    paramf = bb.FuK;
    paramf = as.GSQ;
    paramf = getContext();
    kotlin.g.b.s.s(paramf, "context");
    paramf = as.a.hu((Context)paramf);
    if (paramf == null)
    {
      paramf = null;
      label995:
      if (!bool) {
        break label1050;
      }
    }
    label1050:
    for (paramPreference = "switch_identity_to_bizuin_open";; paramPreference = "switch_identity_to_bizuin_close")
    {
      bb.a(paramf, paramPreference, 1);
      ((r)com.tencent.mm.kernel.h.ax(r.class)).b(bool, (ck)this.FUk.getValue());
      break;
      paramf = paramf.fou();
      break label995;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167615);
    super.onResume();
    getContentView().post(new FinderSettingInfoUI..ExternalSyntheticLambda1(this));
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b((Context)this, 1L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b((Context)this, 2L, 2L);
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b((Context)this, 5L, 2L);
    localObject = new di(2);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(167615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(346834);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramp == null)
    {
      paramString = null;
      Log.i(str, paramString + " scene:" + paramp);
      if (paramp != null) {
        break label120;
      }
    }
    label120:
    for (paramString = localObject;; paramString = Integer.valueOf(paramp.getType()))
    {
      if (paramString != null) {
        break label132;
      }
      AppMethodBeat.o(346834);
      return;
      paramString = Integer.valueOf(paramp.getType());
      break;
    }
    label132:
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(346834);
        throw paramString;
      }
      this.AwM = ((di)paramp).dVy();
      paramString = this.AwM;
      if (paramString != null)
      {
        this.BkY = paramString.aahF;
        kD(true);
      }
    }
    AppMethodBeat.o(346834);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(346870);
    super.onStop();
    AppMethodBeat.o(346870);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$Companion;", "", "()V", "NEED_REFRESH_CONTACT", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$modifyMpIdentityCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<1>
  {
    b(FinderSettingInfoUI paramFinderSettingInfoUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ck<bqe>
  {
    c(FinderSettingInfoUI paramFinderSettingInfoUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI
 * JD-Core Version:    0.7.0.1
 */