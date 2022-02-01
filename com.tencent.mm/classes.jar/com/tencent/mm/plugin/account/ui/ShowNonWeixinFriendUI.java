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
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;

public class ShowNonWeixinFriendUI
  extends MMActivity
  implements e.a
{
  private long iXX = 0L;
  private String iXY = "";
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(128757);
    initView();
    AppMethodBeat.o(128757);
  }
  
  public int getLayoutId()
  {
    return 2131493932;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128756);
    ImageView localImageView = (ImageView)findViewById(2131301054);
    TextView localTextView1 = (TextView)findViewById(2131301059);
    TextView localTextView2 = (TextView)findViewById(2131301060);
    localImageView.setBackgroundDrawable(a.l(this, 2131690027));
    localImageView.setImageBitmap(com.tencent.mm.aj.c.zN(this.iXX));
    localTextView1.setText(this.iXY);
    localTextView2.setText(getString(2131760355, new Object[] { this.iXY }));
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
    ((Button)findViewById(2131301057)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128752);
        paramAnonymousView = new com.tencent.mm.ui.g.a.c(ShowNonWeixinFriendUI.this.getString(2131758773));
        Bundle localBundle = new Bundle();
        localBundle.putString("message", ShowNonWeixinFriendUI.this.getString(2131758792));
        localBundle.putString("to", Long.toString(ShowNonWeixinFriendUI.a(ShowNonWeixinFriendUI.this)));
        paramAnonymousView.a(ShowNonWeixinFriendUI.this, "apprequests", localBundle, new c.a()
        {
          public final void a(b paramAnonymous2b)
          {
            AppMethodBeat.i(128749);
            ac.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
            AppMethodBeat.o(128749);
          }
          
          public final void a(com.tencent.mm.ui.g.a.e paramAnonymous2e)
          {
            AppMethodBeat.i(128748);
            ac.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
            AppMethodBeat.o(128748);
          }
          
          public final void onCancel()
          {
            AppMethodBeat.i(128751);
            ac.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
            AppMethodBeat.o(128751);
          }
          
          public final void w(Bundle paramAnonymous2Bundle)
          {
            AppMethodBeat.i(128750);
            ac.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
            h.a(ShowNonWeixinFriendUI.this.getContext(), 2131758797, 2131755906, new DialogInterface.OnClickListener()
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
        });
        AppMethodBeat.o(128752);
      }
    });
    AppMethodBeat.o(128756);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128753);
    super.onCreate(paramBundle);
    setMMTitle(2131760357);
    this.iXX = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.iXY = getIntent().getStringExtra("Contact_KFacebookName");
    initView();
    AppMethodBeat.o(128753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128754);
    super.onPause();
    p.aBh().e(this);
    AppMethodBeat.o(128754);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128755);
    super.onResume();
    p.aBh().d(this);
    AppMethodBeat.o(128755);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI
 * JD-Core Version:    0.7.0.1
 */