package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;

public class ShowNonWeixinFriendUI
  extends MMActivity
  implements d.a
{
  private long gKo = 0L;
  private String gKp = "";
  
  public int getLayoutId()
  {
    return 2130969519;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125594);
    ImageView localImageView = (ImageView)findViewById(2131823967);
    TextView localTextView1 = (TextView)findViewById(2131823968);
    TextView localTextView2 = (TextView)findViewById(2131823969);
    localImageView.setBackgroundDrawable(a.k(this, 2131231221));
    localImageView.setImageBitmap(b.qN(this.gKo));
    localTextView1.setText(this.gKp);
    localTextView2.setText(getString(2131300754, new Object[] { this.gKp }));
    setBackBtn(new ShowNonWeixinFriendUI.1(this));
    ((Button)findViewById(2131823970)).setOnClickListener(new ShowNonWeixinFriendUI.2(this));
    AppMethodBeat.o(125594);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125591);
    super.onCreate(paramBundle);
    setMMTitle(2131300756);
    this.gKo = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.gKp = getIntent().getStringExtra("Contact_KFacebookName");
    initView();
    AppMethodBeat.o(125591);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125592);
    super.onPause();
    o.acQ().e(this);
    AppMethodBeat.o(125592);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125593);
    super.onResume();
    o.acQ().d(this);
    AppMethodBeat.o(125593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(125595);
    initView();
    AppMethodBeat.o(125595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI
 * JD-Core Version:    0.7.0.1
 */