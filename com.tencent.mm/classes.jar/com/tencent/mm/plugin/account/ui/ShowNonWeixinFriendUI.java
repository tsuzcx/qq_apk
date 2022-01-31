package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;

public class ShowNonWeixinFriendUI
  extends MMActivity
  implements d.a
{
  private long fsM = 0L;
  private String fsN = "";
  
  protected final int getLayoutId()
  {
    return q.g.facebookapp_show_non_weixin_friend;
  }
  
  protected final void initView()
  {
    ImageView localImageView = (ImageView)findViewById(q.f.invite_friend_avatar_iv);
    TextView localTextView1 = (TextView)findViewById(q.f.invite_friend_nickname_tv);
    TextView localTextView2 = (TextView)findViewById(q.f.invite_friend_not_reg);
    localImageView.setBackgroundDrawable(a.g(this, q.i.default_mobile_avatar));
    localImageView.setImageBitmap(b.jU(this.fsM));
    localTextView1.setText(this.fsN);
    localTextView2.setText(getString(q.j.invite_friend_not_reg, new Object[] { this.fsN }));
    setBackBtn(new ShowNonWeixinFriendUI.1(this));
    ((Button)findViewById(q.f.invite_friend_invite_btn)).setOnClickListener(new ShowNonWeixinFriendUI.2(this));
  }
  
  public final void kk(String paramString)
  {
    initView();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(q.j.invite_friend_title);
    this.fsM = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.fsN = getIntent().getStringExtra("Contact_KFacebookName");
    initView();
  }
  
  protected void onPause()
  {
    super.onPause();
    o.JQ().e(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    o.JQ().d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI
 * JD-Core Version:    0.7.0.1
 */