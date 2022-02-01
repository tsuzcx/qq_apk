package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.u;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getResourceId", "", "goBack", "", "handleAtShowTab", "initFeedMvReproductionBtn", "initFeedReproductionBtn", "initMessageMuteBtn", "initNoSeeAtTab", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFeedMvReproductionClick", "onFeedReproductionClick", "onMessageMuteClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
public final class FinderSettingPrivacyUI
  extends MMPreference
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final ai<azg> tUo;
  Dialog tipDialog;
  
  public FinderSettingPrivacyUI()
  {
    AppMethodBeat.i(252683);
    this.TAG = "Finder.FinderSettingPrivacyUI";
    this.tUo = ((ai)new a(this));
    AppMethodBeat.o(252683);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(252682);
    Object localObject = getPreferenceScreen().bmg("checkbox_preference_one");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(252682);
      throw ((Throwable)localObject);
    }
    boolean bool = ((CheckBoxPreference)localObject).isChecked();
    localObject = y.vXH;
    if (bool != y.dnv())
    {
      localObject = this.tipDialog;
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        localObject = (x)g.af(x.class);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 1;; i = 2)
      {
        ((x)localObject).b(i, this.tUo);
        AppMethodBeat.o(252682);
        return;
        localObject = (FinderSettingPrivacyUI)this;
        Context localContext = (Context)((FinderSettingPrivacyUI)localObject).getContext();
        ((FinderSettingPrivacyUI)localObject).getContext().getString(2131755998);
        ((FinderSettingPrivacyUI)localObject).tipDialog = ((Dialog)h.a(localContext, ((FinderSettingPrivacyUI)localObject).getContext().getString(2131756029), false, (DialogInterface.OnCancelListener)b.vOy));
        break;
      }
    }
    finish();
    AppMethodBeat.o(252682);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252686);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252686);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252685);
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
    AppMethodBeat.o(252685);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return 2132017223;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(252681);
    goBack();
    AppMethodBeat.o(252681);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167619);
    super.onCreate(paramBundle);
    setMMTitle(2131760431);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(167619);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 2;
    AppMethodBeat.i(167621);
    if (paramPreference == null) {
      kotlin.g.b.p.hyc();
    }
    paramf = paramPreference.getKey();
    Log.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
    label510:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  AppMethodBeat.o(167621);
                  return true;
                  switch (paramf.hashCode())
                  {
                  default: 
                    break;
                  case -1462242975: 
                    if (paramf.equals("feed_mv_reproduction"))
                    {
                      paramf = getPreferenceScreen().bmg("feed_mv_reproduction");
                      if (paramf != null) {
                        break label665;
                      }
                      paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                      AppMethodBeat.o(167621);
                      throw paramf;
                    }
                    break;
                  case 541151233: 
                    if (paramf.equals("settings_blacklist"))
                    {
                      paramf = new Intent();
                      paramf.setClass((Context)this, FinderBlackListUI.class);
                      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
                      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      startActivity((Intent)paramf.pG(0));
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    break;
                  }
                }
              } while (!paramf.equals("setting_no_see_at_tab_tips"));
              paramf = getPreferenceScreen().bmg("setting_no_see_at_tab_tips");
              if (paramf != null) {
                break label824;
              }
              paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
              AppMethodBeat.o(167621);
              throw paramf;
            } while (!paramf.equals("settings_message_mute"));
            paramf = getPreferenceScreen().bmg("settings_message_mute");
            if (paramf != null) {
              break;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(167621);
            throw paramf;
          } while (!paramf.equals("feed_reproduction"));
          paramf = getPreferenceScreen().bmg("feed_reproduction");
          if (paramf != null) {
            break;
          }
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167621);
          throw paramf;
          paramf = (CheckBoxPreference)paramf;
        } while (paramf == null);
        bool = paramf.isChecked();
        paramf = g.aAh();
        kotlin.g.b.p.g(paramf, "MMKernel.storage()");
        i = paramf.azQ().getInt(ar.a.Okw, 0);
        if (bool) {
          i |= 0x40;
        }
        for (;;)
        {
          paramf = g.aAh();
          kotlin.g.b.p.g(paramf, "MMKernel.storage()");
          paramf.azQ().set(ar.a.Okw, Integer.valueOf(i));
          ((com.tencent.mm.plugin.i.a.p)g.af(com.tencent.mm.plugin.i.a.p.class)).mQ(bool);
          break;
          i &= 0xFFFFFFBF;
        }
        paramf = (CheckBoxPreference)paramf;
      } while (paramf == null);
      bool = paramf.isChecked();
      paramPreference = k.vfA;
      if (bool)
      {
        i = 1;
        k.ge(3, i);
        paramPreference = g.aAh();
        kotlin.g.b.p.g(paramPreference, "MMKernel.storage()");
        i = paramPreference.azQ().getInt(ar.a.Okw, 0);
        if (!bool) {
          break label627;
        }
        paramPreference = getContext();
        kotlin.g.b.p.g(paramPreference, "context");
        paramf.setSummary((CharSequence)paramPreference.getResources().getString(2131759369));
        i &= 0xFFFFFEFF;
      }
      for (;;)
      {
        paramf = g.aAh();
        kotlin.g.b.p.g(paramf, "MMKernel.storage()");
        paramf.azQ().set(ar.a.Okw, Integer.valueOf(i));
        ((u)g.af(u.class)).mP(bool);
        break;
        i = 2;
        break label510;
        paramPreference = getContext();
        kotlin.g.b.p.g(paramPreference, "context");
        paramf.setSummary((CharSequence)paramPreference.getResources().getString(2131759758));
        i |= 0x100;
      }
      paramf = (CheckBoxPreference)paramf;
    } while (paramf == null);
    label627:
    boolean bool = paramf.isChecked();
    label665:
    paramPreference = g.aAh();
    kotlin.g.b.p.g(paramPreference, "MMKernel.storage()");
    i = paramPreference.azQ().getInt(ar.a.Okw, 0);
    if (bool)
    {
      paramPreference = getContext();
      kotlin.g.b.p.g(paramPreference, "context");
      paramf.setSummary((CharSequence)paramPreference.getResources().getString(2131759757));
    }
    for (i = 0xFFEDFFFF & i;; i = 0x120000 | i)
    {
      paramf = g.aAh();
      kotlin.g.b.p.g(paramf, "MMKernel.storage()");
      paramf.azQ().set(ar.a.Okw, Integer.valueOf(i));
      ((x)g.af(x.class)).mR(bool);
      break;
      paramPreference = getContext();
      kotlin.g.b.p.g(paramPreference, "context");
      paramf.setSummary((CharSequence)paramPreference.getResources().getString(2131759759));
    }
    label824:
    bool = ((CheckBoxPreference)paramf).isChecked();
    paramf = this.tipDialog;
    if (paramf != null) {
      paramf.show();
    }
    for (;;)
    {
      paramf = (x)g.af(x.class);
      if (bool) {
        i = 1;
      }
      paramf.c(i, (ai)new d(this));
      break;
      paramf = (FinderSettingPrivacyUI)this;
      paramPreference = (Context)paramf.getContext();
      paramf.getContext().getString(2131755998);
      paramf.tipDialog = ((Dialog)h.a(paramPreference, paramf.getContext().getString(2131756029), false, (DialogInterface.OnCancelListener)FinderSettingPrivacyUI.c.vOz));
    }
  }
  
  public final void onResume()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167620);
    super.onResume();
    Object localObject1 = g.aAh();
    kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
    if ((((e)localObject1).azQ().getInt(ar.a.Okw, 0) & 0x40) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d(this.TAG, "initNotRecommendBtn:".concat(String.valueOf(bool1)));
      localObject1 = getPreferenceScreen().bmg("settings_message_mute");
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).gLR();
    localObject1 = g.aAh();
    kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
    if ((((e)localObject1).azQ().getInt(ar.a.Okw, 0) & 0x800) != 0) {}
    for (bool1 = true;; bool1 = false)
    {
      Log.d(this.TAG, "initNoSeeAtTab:".concat(String.valueOf(bool1)));
      localObject1 = getPreferenceScreen().bmg("setting_no_see_at_tab_tips");
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).gLR();
    localObject1 = getPreferenceScreen().bmg("checkbox_preference_one");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).gLR();
    Object localObject2 = c.vCb;
    if (((Number)c.dtN().value()).intValue() != 1)
    {
      getPreferenceScreen().jdMethod_do("checkbox_preference_one", true);
      localObject1 = g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      if ((((e)localObject1).azQ().getInt(ar.a.Okw, 0) & 0x100) != 0) {
        break label410;
      }
    }
    label410:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().bmg("feed_reproduction");
      if (localObject1 != null) {
        break label415;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      localObject2 = y.vXH;
      ((CheckBoxPreference)localObject1).setChecked(y.dnv());
      break;
    }
    label415:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).gLR();
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((CheckBoxPreference)localObject1).setSummary((CharSequence)((AppCompatActivity)localObject2).getResources().getString(2131759369));
      localObject1 = g.aAh();
      kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
      if ((((e)localObject1).azQ().getInt(ar.a.Okw, 0) & 0x120000) != 0) {
        break label583;
      }
    }
    label583:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().bmg("feed_mv_reproduction");
      if (localObject1 != null) {
        break label588;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((CheckBoxPreference)localObject1).setSummary((CharSequence)((AppCompatActivity)localObject2).getResources().getString(2131759758));
      break;
    }
    label588:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).gLR();
    int i;
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((CheckBoxPreference)localObject1).setSummary((CharSequence)((AppCompatActivity)localObject2).getResources().getString(2131759757));
      getPreferenceScreen().notifyDataSetChanged();
      localObject1 = c.vCb;
      if (((Number)c.dtG().value()).intValue() != 1) {
        break label822;
      }
      localObject1 = c.vCb;
      if (((Number)c.dqZ().value()).intValue() != 1) {
        break label822;
      }
      i = 1;
      label700:
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label827;
      }
      bool1 = true;
      label712:
      ((f)localObject1).jdMethod_do("settings_message_mute", bool1);
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label832;
      }
      bool1 = true;
      label736:
      ((f)localObject1).jdMethod_do("settings_message_mute_desc", bool1);
      localObject1 = getPreferenceScreen();
      localObject2 = c.vCb;
      if (c.dqG()) {
        break label837;
      }
    }
    label822:
    label827:
    label832:
    label837:
    for (bool1 = bool2;; bool1 = false)
    {
      ((f)localObject1).jdMethod_do("feed_reproduction", bool1);
      AppMethodBeat.o(167620);
      return;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      ((CheckBoxPreference)localObject1).setSummary((CharSequence)((AppCompatActivity)localObject2).getResources().getString(2131759759));
      break;
      i = 0;
      break label700;
      bool1 = false;
      break label712;
      bool1 = false;
      break label736;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements ai<azg>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b vOy;
    
    static
    {
      AppMethodBeat.i(252678);
      vOy = new b();
      AppMethodBeat.o(252678);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$handleAtShowTab$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class d
    implements ai<azg>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167618);
      FinderSettingPrivacyUI.a(this.vOx);
      AppMethodBeat.o(167618);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */