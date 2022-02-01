package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ba;
import com.tencent.mm.plugin.findersdk.a.be;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "privacySetting", "Lcom/tencent/mm/protocal/protobuf/FinderPrivacySetting;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getResourceId", "", "goBack", "", "handleAtShowTab", "handleInfoExport", "initFeedMvReproductionBtn", "initFeedReproductionBtn", "initMessageMuteBtn", "initNoSeeAtTab", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFeedMvReproductionClick", "onFeedReproductionClick", "onMessageMuteClick", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSettingPrivacyUI
  extends MMPreference
{
  public static final a FUr;
  private final ck<bqe> Bcx;
  private btf FUs;
  Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(347311);
    FUr = new a((byte)0);
    AppMethodBeat.o(347311);
  }
  
  public FinderSettingPrivacyUI()
  {
    AppMethodBeat.i(347272);
    this.Bcx = ((ck)new b(this));
    AppMethodBeat.o(347272);
  }
  
  private static final boolean a(FinderSettingPrivacyUI paramFinderSettingPrivacyUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347292);
    s.u(paramFinderSettingPrivacyUI, "this$0");
    paramFinderSettingPrivacyUI.goBack();
    AppMethodBeat.o(347292);
    return true;
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(347284);
    Object localObject = getPreferenceScreen().bAi("checkbox_preference_one");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(347284);
      throw ((Throwable)localObject);
    }
    boolean bool = ((CheckBoxPreference)localObject).isChecked();
    localObject = aw.Gjk;
    if (bool != aw.eKm())
    {
      localObject = this.tipDialog;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null)
        {
          localObject = (FinderSettingPrivacyUI)this;
          Context localContext = (Context)((FinderSettingPrivacyUI)localObject).getContext();
          ((FinderSettingPrivacyUI)localObject).getContext().getString(e.h.app_tip);
          ((FinderSettingPrivacyUI)localObject).tipDialog = ((Dialog)k.a(localContext, ((FinderSettingPrivacyUI)localObject).getContext().getString(e.h.app_waiting), false, FinderSettingPrivacyUI..ExternalSyntheticLambda0.INSTANCE));
        }
        localObject = (r)h.ax(r.class);
        if (!bool) {
          break label166;
        }
      }
      label166:
      for (int i = 1;; i = 2)
      {
        ((r)localObject).b(i, this.Bcx);
        AppMethodBeat.o(347284);
        return;
        ((Dialog)localObject).show();
        localObject = ah.aiuX;
        break;
      }
    }
    finish();
    AppMethodBeat.o(347284);
  }
  
  private static final void r(DialogInterface paramDialogInterface) {}
  
  private static final void s(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_setting_privacy_pref;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(347342);
    goBack();
    AppMethodBeat.o(347342);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167619);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_privacy);
    setBackBtn(new FinderSettingPrivacyUI..ExternalSyntheticLambda2(this));
    paramBundle = (com.tencent.mm.bx.a)new btf();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("privacy_settings");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      this.FUs = ((btf)paramBundle);
      AppMethodBeat.o(167619);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = null;
    int i = 2;
    AppMethodBeat.i(167621);
    s.checkNotNull(paramPreference);
    paramPreference = paramPreference.mKey;
    Log.i("Finder.FinderSettingPrivacyUI", s.X("click ", paramPreference));
    if (paramPreference != null) {}
    switch (paramPreference.hashCode())
    {
    default: 
    case 541151233: 
    case 1697865235: 
    case 197211010: 
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(167621);
            return true;
            if (paramPreference.equals("settings_blacklist"))
            {
              paramf = new Intent();
              paramf.setClass((Context)this, FinderBlackListUI.class);
              paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        } while (!paramPreference.equals("setting_no_see_at_tab_tips"));
        paramPreference = getPreferenceScreen().bAi("setting_no_see_at_tab_tips");
        if (paramPreference != null) {
          break;
        }
        paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167621);
        throw paramf;
      } while (!paramPreference.equals("settings_personal_info_export"));
      paramPreference = new Intent();
      paramf = this.FUs;
      if (paramf != null) {
        break;
      }
    }
    for (paramf = null;; paramf = paramf.aabb)
    {
      paramPreference.putExtra("rawUrl", paramf);
      c.b((Context)getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      break;
      if (!paramPreference.equals("feed_mv_reproduction")) {
        break;
      }
      paramf = getPreferenceScreen().bAi("feed_mv_reproduction");
      if (paramf == null)
      {
        paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
        AppMethodBeat.o(167621);
        throw paramf;
        if (!paramPreference.equals("settings_message_mute")) {
          break;
        }
        paramf = getPreferenceScreen().bAi("settings_message_mute");
        if (paramf == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167621);
          throw paramf;
          if (!paramPreference.equals("feed_reproduction")) {
            break;
          }
          paramf = getPreferenceScreen().bAi("feed_reproduction");
          if (paramf != null) {
            break label527;
          }
          paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
          AppMethodBeat.o(167621);
          throw paramf;
        }
        bool = ((CheckBoxPreference)paramf).isChecked();
        i = h.baE().ban().getInt(at.a.adbs, 0);
        if (bool) {
          i |= 0x40;
        }
        for (;;)
        {
          h.baE().ban().set(at.a.adbs, Integer.valueOf(i));
          ((ba)h.ax(ba.class)).pK(bool);
          break;
          i &= 0xFFFFFFBF;
        }
        label527:
        paramf = (CheckBoxPreference)paramf;
        bool = paramf.isChecked();
        paramPreference = z.FrZ;
        if (bool)
        {
          i = 1;
          label549:
          z.ig(3, i);
          i = h.baE().ban().getInt(at.a.adbs, 0);
          if (!bool) {
            break label639;
          }
          paramf.aS((CharSequence)getContext().getResources().getString(e.h.feed_reproduction_tips_on_open));
          i &= 0xFFFFFEFF;
        }
        for (;;)
        {
          h.baE().ban().set(at.a.adbs, Integer.valueOf(i));
          ((be)h.ax(be.class)).pJ(bool);
          break;
          i = 2;
          break label549;
          label639:
          paramf.aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_forbid));
          i |= 0x100;
        }
      }
      paramf = (CheckBoxPreference)paramf;
      boolean bool = paramf.isChecked();
      i = h.baE().ban().getInt(at.a.adbs, 0);
      if (bool) {
        paramf.aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_allow2));
      }
      for (i = 0xFFF7FFFF & i;; i = 0x80000 | i)
      {
        h.baE().ban().set(at.a.adbs, Integer.valueOf(i));
        ((r)h.ax(r.class)).pL(bool);
        break;
        paramf.aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_forbid2));
      }
      bool = ((CheckBoxPreference)paramPreference).isChecked();
      paramPreference = this.tipDialog;
      if (paramPreference == null) {}
      for (;;)
      {
        if (paramf == null)
        {
          paramf = (FinderSettingPrivacyUI)this;
          paramPreference = (Context)paramf.getContext();
          paramf.getContext().getString(e.h.app_tip);
          paramf.tipDialog = ((Dialog)k.a(paramPreference, paramf.getContext().getString(e.h.app_waiting), false, FinderSettingPrivacyUI..ExternalSyntheticLambda1.INSTANCE));
        }
        paramf = (r)h.ax(r.class);
        if (bool) {
          i = 1;
        }
        paramf.c(i, (ck)new c(this));
        break;
        paramPreference.show();
        paramf = ah.aiuX;
      }
    }
  }
  
  public final void onResume()
  {
    boolean bool2 = false;
    AppMethodBeat.i(167620);
    super.onResume();
    if ((h.baE().ban().getInt(at.a.adbs, 0) & 0x40) != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("Finder.FinderSettingPrivacyUI", s.X("initNotRecommendBtn:", Boolean.valueOf(bool1)));
      localObject1 = getPreferenceScreen().bAi("settings_message_mute");
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((Preference)localObject1).adZV = false;
    localObject1 = getPreferenceScreen().bAi("checkbox_preference_one");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
    }
    localObject1 = (CheckBoxPreference)localObject1;
    ((Preference)localObject1).adZV = false;
    Object localObject2 = d.FAy;
    if (((Number)d.eTv().bmg()).intValue() != 1)
    {
      getPreferenceScreen().eh("checkbox_preference_one", true);
      if ((h.baE().ban().getInt(at.a.adbs, 0) & 0x100) != 0) {
        break label274;
      }
    }
    label274:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().bAi("feed_reproduction");
      if (localObject1 != null) {
        break label279;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      localObject2 = aw.Gjk;
      ((CheckBoxPreference)localObject1).setChecked(aw.eKm());
      break;
    }
    label279:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((Preference)localObject1).adZV = false;
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      ((CheckBoxPreference)localObject1).aS((CharSequence)getContext().getResources().getString(e.h.feed_reproduction_tips_on_open));
      if ((h.baE().ban().getInt(at.a.adbs, 0) & 0x80000) != 0) {
        break label412;
      }
    }
    label412:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = getPreferenceScreen().bAi("feed_mv_reproduction");
      if (localObject1 != null) {
        break label417;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
      AppMethodBeat.o(167620);
      throw ((Throwable)localObject1);
      ((CheckBoxPreference)localObject1).aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_forbid));
      break;
    }
    label417:
    localObject1 = (CheckBoxPreference)localObject1;
    ((CheckBoxPreference)localObject1).setChecked(bool1);
    ((Preference)localObject1).adZV = false;
    int i;
    if (((CheckBoxPreference)localObject1).isChecked())
    {
      ((CheckBoxPreference)localObject1).aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_allow2));
      getPreferenceScreen().notifyDataSetChanged();
      localObject1 = d.FAy;
      if (((Number)d.eTo().bmg()).intValue() != 1) {
        break label686;
      }
      localObject1 = d.FAy;
      if (((Number)d.eQA().bmg()).intValue() != 1) {
        break label686;
      }
      i = 1;
      label518:
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label691;
      }
      bool1 = true;
      label530:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_message_mute", bool1);
      localObject1 = getPreferenceScreen();
      if (i != 0) {
        break label696;
      }
      bool1 = true;
      label554:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("settings_message_mute_desc", bool1);
      localObject1 = getPreferenceScreen();
      localObject2 = d.FAy;
      if (d.eQg()) {
        break label701;
      }
      bool1 = true;
      label585:
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("feed_reproduction", bool1);
      localObject2 = getPreferenceScreen();
      localObject1 = this.FUs;
      if (localObject1 != null) {
        break label706;
      }
    }
    label686:
    label691:
    label696:
    label701:
    label706:
    for (localObject1 = null;; localObject1 = ((btf)localObject1).aabb)
    {
      localObject1 = (CharSequence)localObject1;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((CharSequence)localObject1).length() != 0) {}
      }
      else
      {
        bool1 = true;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject2).eh("settings_personal_info_export", bool1);
      AppMethodBeat.o(167620);
      return;
      ((CheckBoxPreference)localObject1).aS((CharSequence)getContext().getResources().getString(e.h.finder_feed_reproduction_forbid2));
      break;
      i = 0;
      break label518;
      bool1 = false;
      break label530;
      bool1 = false;
      break label554;
      bool1 = false;
      break label585;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$Companion;", "", "()V", "PRIVACY_SETTINGS", "", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ck<bqe>
  {
    b(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSettingPrivacyUI$handleAtShowTab$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ck<bqe>
  {
    c(FinderSettingPrivacyUI paramFinderSettingPrivacyUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPrivacyUI
 * JD-Core Version:    0.7.0.1
 */