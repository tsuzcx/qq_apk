package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class InviteRecommendChoiceUI
  extends MMPreference
{
  private f screen;
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2131951687;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128054);
    setMMTitle(2131763055);
    this.screen = getPreferenceScreen();
    IconPreference localIconPreference = (IconPreference)this.screen.aVD("settings_invite_facebook_friends");
    b.aJm();
    this.screen.d(localIconPreference);
    localIconPreference = (IconPreference)this.screen.aVD("settings_invite_qq_friends");
    if (u.aAl() == 0) {
      this.screen.d(localIconPreference);
    }
    localIconPreference = (IconPreference)this.screen.aVD("settings_recommend_by_mail");
    if (u.aAl() == 0) {
      this.screen.d(localIconPreference);
    }
    localIconPreference = (IconPreference)this.screen.aVD("settings_recommend_by_mb");
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com") == null) {
      this.screen.d(localIconPreference);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128051);
        InviteRecommendChoiceUI.this.hideVKB();
        InviteRecommendChoiceUI.this.finish();
        AppMethodBeat.o(128051);
        return true;
      }
    });
    AppMethodBeat.o(128054);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128052);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(128052);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(128053);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_invite_qq_friends"))
    {
      paramf = new Intent(this, RecommendFriendUI.class);
      paramf.putExtra("recommend_type", Integer.toString(0));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(128053);
      return false;
      if (paramf.equals("settings_recommend_by_mail"))
      {
        paramf = new Intent(this, RecommendFriendUI.class);
        paramf.putExtra("recommend_type", Integer.toString(2));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_recommend_by_mb"))
      {
        paramf = new Intent(this, RecommendFriendUI.class);
        paramf.putExtra("recommend_type", Integer.toString(1));
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_invite_mobile_friends"))
      {
        paramf = new Intent("android.intent.action.VIEW");
        paramf.putExtra("sms_body", getString(2131760373, new Object[] { g.ajC().ajl().get(2, null) }));
        paramf.setType("vnd.android-dir/mms-sms");
        if (bt.aj(this, paramf))
        {
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          Toast.makeText(this, 2131763024, 1).show();
        }
      }
      else if (paramf.equals("settings_invite_facebook_friends"))
      {
        paramf = new Intent(this, InviteFacebookFriendsUI.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI
 * JD-Core Version:    0.7.0.1
 */