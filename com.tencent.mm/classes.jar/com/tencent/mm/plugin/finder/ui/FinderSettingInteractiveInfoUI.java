package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "handleCollectedClick", "", "handleFollowClick", "handleLikedClick", "handleMentionClick", "handlePrivMsgClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "updateView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSettingInteractiveInfoUI
  extends MMPreference
{
  public static final a FUn;
  
  static
  {
    AppMethodBeat.i(347802);
    FUn = new a((byte)0);
    AppMethodBeat.o(347802);
  }
  
  private static final boolean a(FinderSettingInteractiveInfoUI paramFinderSettingInteractiveInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347795);
    s.u(paramFinderSettingInteractiveInfoUI, "this$0");
    paramFinderSettingInteractiveInfoUI.finish();
    AppMethodBeat.o(347795);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_setting_interactive_info_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347818);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_interactive_info);
    setBackBtn(new FinderSettingInteractiveInfoUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(347818);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(347846);
    if (paramPreference == null)
    {
      paramf = null;
      Log.i("FinderSettingInteractiveInfoUI", s.X("click ", paramf));
      if (paramf != null) {
        switch (paramf.hashCode())
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(347846);
      return true;
      paramf = paramPreference.mKey;
      break;
      if (paramf.equals("settings_privacy_msg"))
      {
        paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.hh((Context)this);
        continue;
        if (paramf.equals("settings_follow"))
        {
          paramf = new Intent();
          paramPreference = as.GSQ;
          as.a.a((Context)this, paramf, 0L, 0, false, 124);
          paramf.setClass((Context)this, FinderFollowListUI.class);
          paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleFollowClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleFollowClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          if (paramf.equals("settings_mention"))
          {
            paramf = com.tencent.mm.plugin.finder.utils.a.GfO;
            com.tencent.mm.plugin.finder.utils.a.ha((Context)this);
            continue;
            if (paramf.equals("settings_collected"))
            {
              paramf = new Intent();
              paramPreference = as.GSQ;
              as.a.a((Context)this, paramf, 0L, 0, false, 124);
              paramf.setClass((Context)this, FinderFavFeedUI.class);
              paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleCollectedClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramf.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleCollectedClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              if (paramf.equals("settings_liked"))
              {
                paramf = as.GSQ;
                as.a.a((Context)this, getIntent(), 0L, 0, false, 124);
                getIntent().setClass((Context)this, FinderLikeFeedGridUI.class);
                getIntent().putExtra("finder_username", z.bAW());
                paramf = getIntent();
                paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
                com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleLikedClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent)paramf.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI", "handleLikedClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347828);
    super.onResume();
    if (((bw)h.ax(bw.class)).aBu()) {
      getPreferenceScreen().eh("settings_privacy_msg", true);
    }
    Object localObject1 = getPreferenceScreen().bAi("settings_collected");
    if ((localObject1 instanceof IconPreference))
    {
      localObject1 = (IconPreference)localObject1;
      if (localObject1 != null)
      {
        localObject2 = d.FAy;
        if (((Number)d.eXJ().bmg()).intValue() != 0) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject2 = (CharSequence)getContext().getString(e.h.finder_fav_feed);; localObject2 = (CharSequence)getContext().getString(e.h.finder_fav_feed2))
    {
      ((IconPreference)localObject1).setTitle((CharSequence)localObject2);
      AppMethodBeat.o(347828);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInteractiveInfoUI$Companion;", "", "()V", "KEY_SETTINGS_COLLECTED", "", "KEY_SETTINGS_FOLLOW", "KEY_SETTINGS_LIKED", "KEY_SETTINGS_MENTION", "KEY_SETTINGS_PRIVACY_MSG", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingInteractiveInfoUI
 * JD-Core Version:    0.7.0.1
 */