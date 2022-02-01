package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPersonalizedUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "livePref", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "videoPref", "getResourceId", "", "handleLiveClick", "", "handleVideoClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "report21875", "action", "", "type", "updateView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSettingPersonalizedUI
  extends MMPreference
{
  public static final a FUo;
  private CheckBoxPreference FUp;
  private CheckBoxPreference FUq;
  
  static
  {
    AppMethodBeat.i(347449);
    FUo = new a((byte)0);
    AppMethodBeat.o(347449);
  }
  
  private static final void a(FinderSettingPersonalizedUI paramFinderSettingPersonalizedUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347420);
    s.u(paramFinderSettingPersonalizedUI, "this$0");
    ((bd)h.ax(bd.class)).K(false, 2);
    h.baE().ban().set(at.a.adhS, Boolean.FALSE);
    paramFinderSettingPersonalizedUI.ii("0", "live");
    AppMethodBeat.o(347420);
  }
  
  private static final boolean a(FinderSettingPersonalizedUI paramFinderSettingPersonalizedUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347412);
    s.u(paramFinderSettingPersonalizedUI, "this$0");
    paramFinderSettingPersonalizedUI.finish();
    AppMethodBeat.o(347412);
    return true;
  }
  
  private static final void b(FinderSettingPersonalizedUI paramFinderSettingPersonalizedUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347425);
    s.u(paramFinderSettingPersonalizedUI, "this$0");
    paramFinderSettingPersonalizedUI.updateView();
    AppMethodBeat.o(347425);
  }
  
  private static final void c(FinderSettingPersonalizedUI paramFinderSettingPersonalizedUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347433);
    s.u(paramFinderSettingPersonalizedUI, "this$0");
    ((bd)h.ax(bd.class)).K(false, 1);
    h.baE().ban().set(at.a.adhR, Boolean.FALSE);
    paramFinderSettingPersonalizedUI.ii("0", "channel");
    AppMethodBeat.o(347433);
  }
  
  private static final void d(FinderSettingPersonalizedUI paramFinderSettingPersonalizedUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(347439);
    s.u(paramFinderSettingPersonalizedUI, "this$0");
    paramFinderSettingPersonalizedUI.updateView();
    AppMethodBeat.o(347439);
  }
  
  private final void ii(String paramString1, String paramString2)
  {
    AppMethodBeat.i(347406);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("action", paramString1);
    localJSONObject.put("rec_type", paramString2);
    paramString1 = z.FrZ;
    paramString1 = localJSONObject.toString();
    s.s(paramString1, "kvJson.toString()");
    paramString2 = n.bV(paramString1, ",", ";");
    paramString1 = as.GSQ;
    paramString1 = as.a.hu((Context)this);
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.fou())
    {
      z.b(1, "individual_privacy", paramString2, paramString1);
      AppMethodBeat.o(347406);
      return;
    }
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(347393);
    boolean bool1 = h.baE().ban().getBoolean(at.a.adhR, true);
    boolean bool2 = h.baE().ban().getBoolean(at.a.adhS, true);
    CheckBoxPreference localCheckBoxPreference = this.FUp;
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference.adZV = false;
    }
    localCheckBoxPreference = this.FUq;
    if (localCheckBoxPreference != null)
    {
      localCheckBoxPreference.setChecked(bool2);
      localCheckBoxPreference.adZV = false;
    }
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(347393);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_setting_personalize_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347502);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_personalized_ui_title);
    setBackBtn(new FinderSettingPersonalizedUI..ExternalSyntheticLambda4(this));
    this.FUp = ((CheckBoxPreference)getPreferenceScreen().bAi("settings_allow_recommend_video"));
    this.FUq = ((CheckBoxPreference)getPreferenceScreen().bAi("settings_allow_recommend_live"));
    AppMethodBeat.o(347502);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    Context localContext = null;
    Object localObject1 = null;
    AppMethodBeat.i(347539);
    Object localObject2;
    if (paramPreference == null)
    {
      paramf = null;
      Log.i("FinderSettingPersonalizedUI", s.X("click ", paramf));
      if (!s.p(paramf, "settings_allow_recommend_video")) {
        break label227;
      }
      localObject2 = this.FUp;
      if (localObject2 != null)
      {
        if (((CheckBoxPreference)localObject2).isChecked()) {
          break label185;
        }
        localContext = ((Preference)localObject2).mContext;
        paramf = ((Preference)localObject2).mContext;
        if (paramf != null) {
          break label151;
        }
        paramf = null;
        label78:
        paramPreference = ((Preference)localObject2).mContext;
        if (paramPreference != null) {
          break label162;
        }
        paramPreference = null;
        label90:
        localObject2 = ((Preference)localObject2).mContext;
        if (localObject2 != null) {
          break label173;
        }
        label102:
        k.a(localContext, false, paramf, "", paramPreference, (String)localObject1, new FinderSettingPersonalizedUI..ExternalSyntheticLambda3(this), new FinderSettingPersonalizedUI..ExternalSyntheticLambda2(this), e.b.view_question_link_color, 0);
      }
    }
    label151:
    label162:
    label173:
    label185:
    label340:
    label351:
    for (;;)
    {
      AppMethodBeat.o(347539);
      return true;
      paramf = paramPreference.mKey;
      break;
      paramf = paramf.getString(e.h.finder_allow_recommend_video_dlg_title);
      break label78;
      paramPreference = paramPreference.getString(e.h.finder_allow_recommend_dlg_ok);
      break label90;
      localObject1 = ((Context)localObject2).getString(e.h.app_cancel);
      break label102;
      ((bd)h.ax(bd.class)).K(true, 1);
      h.baE().ban().set(at.a.adhR, Boolean.TRUE);
      ii("1", "channel");
      continue;
      label227:
      if (s.p(paramf, "settings_allow_recommend_live"))
      {
        localObject1 = this.FUq;
        if (localObject1 != null)
        {
          if (!((CheckBoxPreference)localObject1).isChecked())
          {
            localObject2 = ((Preference)localObject1).mContext;
            paramf = ((Preference)localObject1).mContext;
            if (paramf == null)
            {
              paramf = null;
              paramPreference = ((Preference)localObject1).mContext;
              if (paramPreference != null) {
                break label340;
              }
              paramPreference = null;
              localObject1 = ((Preference)localObject1).mContext;
              if (localObject1 != null) {
                break label351;
              }
            }
            for (localObject1 = localContext;; localObject1 = ((Context)localObject1).getString(e.h.app_cancel))
            {
              k.a((Context)localObject2, false, paramf, "", paramPreference, (String)localObject1, new FinderSettingPersonalizedUI..ExternalSyntheticLambda1(this), new FinderSettingPersonalizedUI..ExternalSyntheticLambda0(this), e.b.view_question_link_color, 0);
              break;
              paramf = paramf.getString(e.h.finder_allow_recommend_live_dlg_title);
              break label270;
              paramPreference = paramPreference.getString(e.h.finder_allow_recommend_dlg_ok);
              break label281;
            }
          }
          ((bd)h.ax(bd.class)).K(true, 2);
          h.baE().ban().set(at.a.adhS, Boolean.TRUE);
          ii("1", "live");
        }
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347521);
    super.onResume();
    updateView();
    AppMethodBeat.o(347521);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingPersonalizedUI$Companion;", "", "()V", "KEY_ALLOW_RECOMMEND_LIVE", "", "KEY_ALLOW_RECOMMEND_VIDEO", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingPersonalizedUI
 * JD-Core Version:    0.7.0.1
 */