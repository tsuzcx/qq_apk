package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.e;

public class ShowNonWeixinFriendUI
  extends MMActivity
  implements f.a
{
  private long njX = 0L;
  private String njY = "";
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(128757);
    initView();
    AppMethodBeat.o(128757);
  }
  
  public int getLayoutId()
  {
    return r.g.facebookapp_show_non_weixin_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128756);
    ImageView localImageView = (ImageView)findViewById(r.f.invite_friend_avatar_iv);
    TextView localTextView1 = (TextView)findViewById(r.f.invite_friend_nickname_tv);
    TextView localTextView2 = (TextView)findViewById(r.f.invite_friend_not_reg);
    localImageView.setBackgroundDrawable(com.tencent.mm.ci.a.m(this, r.i.default_mobile_avatar));
    localImageView.setImageBitmap(d.Tt(this.njX));
    localTextView1.setText(this.njY);
    localTextView2.setText(getString(r.j.invite_friend_not_reg, new Object[] { this.njY }));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128746);
        ShowNonWeixinFriendUI.this.hideVKB();
        ShowNonWeixinFriendUI.this.finish();
        AppMethodBeat.o(128746);
        return true;
      }
    });
    ((Button)findViewById(r.f.invite_friend_invite_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128752);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/ShowNonWeixinFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new c(ShowNonWeixinFriendUI.this.getString(r.j.facebook_app_id));
        localObject = new Bundle();
        ((Bundle)localObject).putString("message", ShowNonWeixinFriendUI.this.getString(r.j.facebook_invite_message));
        ((Bundle)localObject).putString("to", Long.toString(ShowNonWeixinFriendUI.a(ShowNonWeixinFriendUI.this)));
        paramAnonymousView.a(ShowNonWeixinFriendUI.this, "apprequests", (Bundle)localObject, new c.a()
        {
          public final void K(Bundle paramAnonymous2Bundle)
          {
            AppMethodBeat.i(128750);
            Log.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
            h.a(ShowNonWeixinFriendUI.this.getContext(), r.j.facebook_inviteqqfriends_invite_success, r.j.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
              {
                AppMethodBeat.i(128747);
                ShowNonWeixinFriendUI.this.finish();
                AppMethodBeat.o(128747);
              }
            });
            AppMethodBeat.o(128750);
          }
          
          public final void a(com.tencent.mm.ui.i.a.b paramAnonymous2b)
          {
            AppMethodBeat.i(128749);
            Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
            AppMethodBeat.o(128749);
          }
          
          public final void a(e paramAnonymous2e)
          {
            AppMethodBeat.i(128748);
            Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
            AppMethodBeat.o(128748);
          }
          
          public final void onCancel()
          {
            AppMethodBeat.i(128751);
            Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
            AppMethodBeat.o(128751);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/ShowNonWeixinFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128752);
      }
    });
    AppMethodBeat.o(128756);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128753);
    super.onCreate(paramBundle);
    setMMTitle(r.j.invite_friend_title);
    this.njX = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.njY = getIntent().getStringExtra("Contact_KFacebookName");
    initView();
    AppMethodBeat.o(128753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128754);
    super.onPause();
    q.bhz().e(this);
    AppMethodBeat.o(128754);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128755);
    super.onResume();
    q.bhz().d(this);
    AppMethodBeat.o(128755);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI
 * JD-Core Version:    0.7.0.1
 */