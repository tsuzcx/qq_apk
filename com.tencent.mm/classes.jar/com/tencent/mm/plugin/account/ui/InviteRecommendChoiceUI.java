package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class InviteRecommendChoiceUI
  extends MMPreference
{
  private f dnn;
  
  protected final boolean XI()
  {
    return false;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_invite_qq_friends"))
    {
      paramf = new Intent(this, RecommendFriendUI.class);
      paramf.putExtra("recommend_type", Integer.toString(0));
      startActivity(paramf);
    }
    do
    {
      return false;
      if (paramf.equals("settings_recommend_by_mail"))
      {
        paramf = new Intent(this, RecommendFriendUI.class);
        paramf.putExtra("recommend_type", Integer.toString(2));
        startActivity(paramf);
        return false;
      }
      if (paramf.equals("settings_recommend_by_mb"))
      {
        paramf = new Intent(this, RecommendFriendUI.class);
        paramf.putExtra("recommend_type", Integer.toString(1));
        startActivity(paramf);
        return false;
      }
      if (paramf.equals("settings_invite_mobile_friends"))
      {
        paramf = new Intent("android.intent.action.VIEW");
        paramf.putExtra("sms_body", getString(q.j.invite_sms, new Object[] { g.DP().Dz().get(2, null) }));
        paramf.setType("vnd.android-dir/mms-sms");
        if (bk.i(this, paramf))
        {
          startActivity(paramf);
          return false;
        }
        Toast.makeText(this, q.j.selectsmsapp_none, 1).show();
        return false;
      }
    } while (!paramf.equals("settings_invite_facebook_friends"));
    startActivity(new Intent(this, InviteFacebookFriendsUI.class));
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(q.j.send_card_to_microblog);
    this.dnn = this.vdd;
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_invite_facebook_friends");
    this.dnn.c(localIconPreference);
    localIconPreference = (IconPreference)this.dnn.add("settings_invite_qq_friends");
    if (q.Gi() == 0) {
      this.dnn.c(localIconPreference);
    }
    localIconPreference = (IconPreference)this.dnn.add("settings_recommend_by_mail");
    if (q.Gi() == 0) {
      this.dnn.c(localIconPreference);
    }
    localIconPreference = (IconPreference)this.dnn.add("settings_recommend_by_mb");
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com") == null) {
      this.dnn.c(localIconPreference);
    }
    setBackBtn(new InviteRecommendChoiceUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return q.k.invite_recommend_friend;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI
 * JD-Core Version:    0.7.0.1
 */