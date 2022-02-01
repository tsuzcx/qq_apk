package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getResourceId", "", "goBack", "", "initFeedReproductionBtn", "initMessageMuteBtn", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFeedReproductionClick", "onMessageMuteClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "plugin-finder_release"})
public final class FinderSettingPrivacyUI
  extends MMPreference
{
  private final String TAG;
  private final s<aqf> sSb;
  Dialog tipDialog;
  
  public FinderSettingPrivacyUI()
  {
    AppMethodBeat.i(204786);
    this.TAG = "Finder.FinderSettingPrivacyUI";
    this.sSb = ((s)new FinderSettingPrivacyUI.a(this));
    AppMethodBeat.o(204786);
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(204785);
    Object localObject = getPreferenceScreen().aXe("checkbox_preference_one");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(204785);
      throw ((Throwable)localObject);
    }
    boolean bool = ((CheckBoxPreference)localObject).isChecked();
    localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (bool != com.tencent.mm.plugin.finder.utils.p.cOj())
    {
      localObject = this.tipDialog;
      if (localObject != null)
      {
        ((Dialog)localObject).show();
        localObject = (n)g.ab(n.class);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 1;; i = 2)
      {
        ((n)localObject).b(i, this.sSb);
        AppMethodBeat.o(204785);
        return;
        localObject = (FinderSettingPrivacyUI)this;
        Context localContext = (Context)((FinderSettingPrivacyUI)localObject).getContext();
        ((FinderSettingPrivacyUI)localObject).getContext().getString(2131755906);
        ((FinderSettingPrivacyUI)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, ((FinderSettingPrivacyUI)localObject).getContext().getString(2131755936), false, (DialogInterface.OnCancelListener)FinderSettingPrivacyUI.b.sSd));
        break;
      }
    }
    finish();
    AppMethodBeat.o(204785);
  }
  
  public final int getResourceId()
  {
    return 2131951681;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(204784);
    goBack();
    AppMethodBeat.o(204784);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167619);
    super.onCreate(paramBundle);
    setMMTitle(2131759308);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(167619);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167621);
    if (paramPreference == null) {
      d.g.b.p.gkB();
    }
    paramf = paramPreference.getKey();
    ae.i(this.TAG, "click ".concat(String.valueOf(paramf)));
    if (paramf == null) {}
    int i;
    label364:
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
            case -421449683: 
              if (paramf.equals("feed_reproduction"))
              {
                paramf = getPreferenceScreen().aXe("feed_reproduction");
                if (paramf != null) {
                  break label364;
                }
                paramf = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                AppMethodBeat.o(167621);
                throw paramf;
              }
              break;
            case 541151233: 
              if (paramf.equals("settings_blacklist"))
              {
                paramf = new Intent();
                paramf.setClass((Context)this, FinderBlackListUI.class);
                paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
                com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              break;
            }
          }
        } while (!paramf.equals("settings_message_mute"));
        paramf = getPreferenceScreen().aXe("settings_message_mute");
        if (paramf == null)
        {
          paramf = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167621);
          throw paramf;
        }
        paramf = (CheckBoxPreference)paramf;
      } while (paramf == null);
      bool = paramf.isChecked();
      paramf = g.ajR();
      d.g.b.p.g(paramf, "MMKernel.storage()");
      i = paramf.ajA().getInt(am.a.Jbx, 0);
      if (bool) {
        i |= 0x40;
      }
      for (;;)
      {
        paramf = g.ajR();
        d.g.b.p.g(paramf, "MMKernel.storage()");
        paramf.ajA().set(am.a.Jbx, Integer.valueOf(i));
        ((com.tencent.mm.plugin.i.a.h)g.ab(com.tencent.mm.plugin.i.a.h.class)).lL(bool);
        break;
        i &= 0xFFFFFFBF;
      }
      paramf = (CheckBoxPreference)paramf;
    } while (paramf == null);
    boolean bool = paramf.isChecked();
    paramf = i.syT;
    if (bool)
    {
      i = 1;
      label390:
      i.fK(3, i);
      paramf = g.ajR();
      d.g.b.p.g(paramf, "MMKernel.storage()");
      i = paramf.ajA().getInt(am.a.Jbx, 0);
      if (!bool) {
        break label478;
      }
      i |= 0x100;
    }
    for (;;)
    {
      paramf = g.ajR();
      d.g.b.p.g(paramf, "MMKernel.storage()");
      paramf.ajA().set(am.a.Jbx, Integer.valueOf(i));
      ((k)g.ab(k.class)).lK(bool);
      break;
      i = 2;
      break label390;
      label478:
      i &= 0xFFFFFEFF;
    }
  }
  
  public final void onResume()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167620);
    super.onResume();
    Object localObject = g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    if ((((e)localObject).ajA().getInt(am.a.Jbx, 0) & 0x40) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.d(this.TAG, "initNotRecommendBtn:".concat(String.valueOf(bool1)));
      localObject = getPreferenceScreen().aXe("settings_message_mute");
      if (localObject != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject);
    }
    localObject = (CheckBoxPreference)localObject;
    ((CheckBoxPreference)localObject).setChecked(bool1);
    ((CheckBoxPreference)localObject).fDK();
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJW().value()).intValue() != 1)
    {
      getPreferenceScreen().cT("checkbox_preference_one", true);
      getPreferenceScreen().cT("preference_footer_1", true);
      localObject = g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      if ((((e)localObject).ajA().getInt(am.a.Jbx, 0) & 0x100) == 0) {
        break label303;
      }
    }
    label303:
    for (bool1 = true;; bool1 = false)
    {
      localObject = getPreferenceScreen().aXe("feed_reproduction");
      if (localObject != null) {
        break label308;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject);
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      bool1 = com.tencent.mm.plugin.finder.utils.p.cOj();
      localObject = getPreferenceScreen().aXe("checkbox_preference_one");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167620);
        throw ((Throwable)localObject);
      }
      ((CheckBoxPreference)localObject).uo(bool1);
      break;
    }
    label308:
    localObject = (CheckBoxPreference)localObject;
    ((CheckBoxPreference)localObject).setChecked(bool1);
    ((CheckBoxPreference)localObject).fDK();
    getPreferenceScreen().notifyDataSetChanged();
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJP().value()).intValue() == 1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHp().value()).intValue() == 1)
      {
        i = 1;
        localObject = getPreferenceScreen();
        if (i != 0) {
          break label500;
        }
        bool1 = true;
        label391:
        ((f)localObject).cT("settings_message_mute", bool1);
        localObject = getPreferenceScreen();
        if (i != 0) {
          break label505;
        }
        bool1 = true;
        label415:
        ((f)localObject).cT("settings_message_mute_desc", bool1);
        localObject = getPreferenceScreen();
        com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cGZ()) {
          break label510;
        }
        bool1 = true;
        label446:
        ((f)localObject).cT("feed_reproduction", bool1);
        localObject = getPreferenceScreen();
        localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cGZ()) {
          break label515;
        }
      }
    }
    label515:
    for (bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cT("feed_reproduction_tips", bool1);
      AppMethodBeat.o(167620);
      return;
      i = 0;
      break;
      label500:
      bool1 = false;
      break label391;
      label505:
      bool1 = false;
      break label415;
      label510:
      bool1 = false;
      break label446;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167618);
      FinderSettingPrivacyUI.a(this.sSc);
      AppMethodBeat.o(167618);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */