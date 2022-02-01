package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.service.m;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.s;
import com.tencent.mm.plugin.findersdk.a.v;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getResourceId", "", "goBack", "", "handleAtShowTab", "initFeedMvReproductionBtn", "initFeedReproductionBtn", "initMessageMuteBtn", "initNoSeeAtTab", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFeedMvReproductionClick", "onFeedReproductionClick", "onMessageMuteClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
public final class FinderSettingPrivacyUI
  extends MMPreference
{
  private final String TAG;
  private HashMap _$_findViewCache;
  Dialog tipDialog;
  private final com.tencent.mm.plugin.findersdk.a.aj<bfc> xFj;
  
  public FinderSettingPrivacyUI()
  {
    AppMethodBeat.i(282478);
    this.TAG = "Finder.FinderSettingPrivacyUI";
    this.xFj = ((com.tencent.mm.plugin.findersdk.a.aj)new a(this));
    AppMethodBeat.o(282478);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(282477);
    Object localObject = getPreferenceScreen().byG("checkbox_preference_one");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(282477);
      throw ((Throwable)localObject);
    }
    boolean bool = ((CheckBoxPreference)localObject).isChecked();
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (bool != com.tencent.mm.plugin.finder.utils.aj.dOO())
    {
      localObject = this.tipDialog;
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        localObject = (m)com.tencent.mm.kernel.h.ae(m.class);
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 1;; i = 2)
      {
        ((m)localObject).b(i, this.xFj);
        AppMethodBeat.o(282477);
        return;
        localObject = (FinderSettingPrivacyUI)this;
        Context localContext = (Context)((FinderSettingPrivacyUI)localObject).getContext();
        ((FinderSettingPrivacyUI)localObject).getContext().getString(b.j.app_tip);
        ((FinderSettingPrivacyUI)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a(localContext, ((FinderSettingPrivacyUI)localObject).getContext().getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)b.Avk));
        break;
      }
    }
    finish();
    AppMethodBeat.o(282477);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(282481);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(282481);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(282480);
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
    AppMethodBeat.o(282480);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return b.m.finder_setting_privacy_pref;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(282476);
    goBack();
    AppMethodBeat.o(282476);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167619);
    super.onCreate(paramBundle);
    setMMTitle(b.j.finder_privacy);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(167619);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 2;
    AppMethodBeat.i(167621);
    if (paramPreference == null) {
      p.iCn();
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
                      paramf = getPreferenceScreen().byG("feed_mv_reproduction");
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
                      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
                      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      startActivity((Intent)paramf.sf(0));
                      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    break;
                  }
                }
              } while (!paramf.equals("setting_no_see_at_tab_tips"));
              paramf = getPreferenceScreen().byG("setting_no_see_at_tab_tips");
              if (paramf != null) {
                break label824;
              }
              paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
              AppMethodBeat.o(167621);
              throw paramf;
            } while (!paramf.equals("settings_message_mute"));
            paramf = getPreferenceScreen().byG("settings_message_mute");
            if (paramf != null) {
              break;
            }
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(167621);
            throw paramf;
          } while (!paramf.equals("feed_reproduction"));
          paramf = getPreferenceScreen().byG("feed_reproduction");
          if (paramf != null) {
            break;
          }
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167621);
          throw paramf;
          paramf = (CheckBoxPreference)paramf;
        } while (paramf == null);
        bool = paramf.isChecked();
        paramf = com.tencent.mm.kernel.h.aHG();
        p.j(paramf, "MMKernel.storage()");
        i = paramf.aHp().getInt(ar.a.Vzn, 0);
        if (bool) {
          i |= 0x40;
        }
        for (;;)
        {
          paramf = com.tencent.mm.kernel.h.aHG();
          p.j(paramf, "MMKernel.storage()");
          paramf.aHp().set(ar.a.Vzn, Integer.valueOf(i));
          ((s)com.tencent.mm.kernel.h.ae(s.class)).oi(bool);
          break;
          i &= 0xFFFFFFBF;
        }
        paramf = (CheckBoxPreference)paramf;
      } while (paramf == null);
      bool = paramf.isChecked();
      paramPreference = n.zWF;
      if (bool)
      {
        i = 1;
        n.gQ(3, i);
        paramPreference = com.tencent.mm.kernel.h.aHG();
        p.j(paramPreference, "MMKernel.storage()");
        i = paramPreference.aHp().getInt(ar.a.Vzn, 0);
        if (!bool) {
          break label627;
        }
        paramPreference = getContext();
        p.j(paramPreference, "context");
        paramf.aF((CharSequence)paramPreference.getResources().getString(b.j.feed_reproduction_tips_on_open));
        i &= 0xFFFFFEFF;
      }
      for (;;)
      {
        paramf = com.tencent.mm.kernel.h.aHG();
        p.j(paramf, "MMKernel.storage()");
        paramf.aHp().set(ar.a.Vzn, Integer.valueOf(i));
        ((v)com.tencent.mm.kernel.h.ae(v.class)).oh(bool);
        break;
        i = 2;
        break label510;
        paramPreference = getContext();
        p.j(paramPreference, "context");
        paramf.aF((CharSequence)paramPreference.getResources().getString(b.j.finder_feed_reproduction_forbid));
        i |= 0x100;
      }
      paramf = (CheckBoxPreference)paramf;
    } while (paramf == null);
    label627:
    boolean bool = paramf.isChecked();
    label665:
    paramPreference = com.tencent.mm.kernel.h.aHG();
    p.j(paramPreference, "MMKernel.storage()");
    i = paramPreference.aHp().getInt(ar.a.Vzn, 0);
    if (bool)
    {
      paramPreference = getContext();
      p.j(paramPreference, "context");
      paramf.aF((CharSequence)paramPreference.getResources().getString(b.j.finder_feed_reproduction_allow2));
    }
    for (i = 0xFFF7FFFF & i;; i = 0x80000 | i)
    {
      paramf = com.tencent.mm.kernel.h.aHG();
      p.j(paramf, "MMKernel.storage()");
      paramf.aHp().set(ar.a.Vzn, Integer.valueOf(i));
      ((m)com.tencent.mm.kernel.h.ae(m.class)).oj(bool);
      break;
      paramPreference = getContext();
      p.j(paramPreference, "context");
      paramf.aF((CharSequence)paramPreference.getResources().getString(b.j.finder_feed_reproduction_forbid2));
    }
    label824:
    bool = ((CheckBoxPreference)paramf).isChecked();
    paramf = this.tipDialog;
    if (paramf != null) {
      paramf.show();
    }
    for (;;)
    {
      paramf = (m)com.tencent.mm.kernel.h.ae(m.class);
      if (bool) {
        i = 1;
      }
      paramf.c(i, (com.tencent.mm.plugin.findersdk.a.aj)new d(this));
      break;
      paramf = (FinderSettingPrivacyUI)this;
      paramPreference = (Context)paramf.getContext();
      paramf.getContext().getString(b.j.app_tip);
      paramf.tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a(paramPreference, paramf.getContext().getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)FinderSettingPrivacyUI.c.Avl));
    }
  }
  
  public final void onResume()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167620);
    super.onResume();
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    if ((((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0) & 0x40) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d(this.TAG, "initNotRecommendBtn:".concat(String.valueOf(bool1)));
      localObject1 = getPreferenceScreen().byG("settings_message_mute");
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).hKY();
    localObject1 = getPreferenceScreen().byG("checkbox_preference_one");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).hKY();
    Object localObject2 = d.AjH;
    if (((Number)d.dUW().aSr()).intValue() != 1)
    {
      getPreferenceScreen().dz("checkbox_preference_one", true);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      if ((((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0) & 0x100) != 0) {
        break label297;
      }
    }
    label297:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().byG("feed_reproduction");
      if (localObject1 != null) {
        break label302;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      ((CheckBoxPreference)localObject1).setChecked(com.tencent.mm.plugin.finder.utils.aj.dOO());
      break;
    }
    label302:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).hKY();
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((CheckBoxPreference)localObject1).aF((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.feed_reproduction_tips_on_open));
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      if ((((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.Vzn, 0) & 0x80000) != 0) {
        break label470;
      }
    }
    label470:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().byG("feed_mv_reproduction");
      if (localObject1 != null) {
        break label475;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((CheckBoxPreference)localObject1).aF((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.finder_feed_reproduction_forbid));
      break;
    }
    label475:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((CheckBoxPreference)localObject1).hKY();
    int i;
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((CheckBoxPreference)localObject1).aF((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.finder_feed_reproduction_allow2));
      getPreferenceScreen().notifyDataSetChanged();
      localObject1 = d.AjH;
      if (((Number)d.dUP().aSr()).intValue() != 1) {
        break label709;
      }
      localObject1 = d.AjH;
      if (((Number)d.dSn().aSr()).intValue() != 1) {
        break label709;
      }
      i = 1;
      label587:
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label714;
      }
      bool1 = true;
      label599:
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_message_mute", bool1);
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label719;
      }
      bool1 = true;
      label623:
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("settings_message_mute_desc", bool1);
      localObject1 = getPreferenceScreen();
      localObject2 = d.AjH;
      if (d.dRT()) {
        break label724;
      }
    }
    label709:
    label714:
    label719:
    label724:
    for (bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.ui.base.preference.f)localObject1).dz("feed_reproduction", bool1);
      AppMethodBeat.o(167620);
      return;
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((CheckBoxPreference)localObject1).aF((CharSequence)((AppCompatActivity)localObject2).getResources().getString(b.j.finder_feed_reproduction_forbid2));
      break;
      i = 0;
      break label587;
      bool1 = false;
      break label599;
      bool1 = false;
      break label623;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.plugin.findersdk.a.aj<bfc>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    public static final b Avk;
    
    static
    {
      AppMethodBeat.i(290116);
      Avk = new b();
      AppMethodBeat.o(290116);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$handleAtShowTab$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.findersdk.a.aj<bfc>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167618);
      FinderSettingPrivacyUI.a(this.Avj);
      AppMethodBeat.o(167618);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */