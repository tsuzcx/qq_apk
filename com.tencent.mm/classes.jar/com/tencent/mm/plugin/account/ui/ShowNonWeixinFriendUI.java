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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.h.a.c.a;

public class ShowNonWeixinFriendUI
  extends MMActivity
  implements e.a
{
  private long kso = 0L;
  private String ksp = "";
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(128757);
    initView();
    AppMethodBeat.o(128757);
  }
  
  public int getLayoutId()
  {
    return 2131494100;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128756);
    ImageView localImageView = (ImageView)findViewById(2131302708);
    TextView localTextView1 = (TextView)findViewById(2131302713);
    TextView localTextView2 = (TextView)findViewById(2131302714);
    localImageView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this, 2131690057));
    localImageView.setImageBitmap(com.tencent.mm.aj.c.LY(this.kso));
    localTextView1.setText(this.ksp);
    localTextView2.setText(getString(2131761800, new Object[] { this.ksp }));
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
    ((Button)findViewById(2131302711)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128752);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/ShowNonWeixinFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new com.tencent.mm.ui.h.a.c(ShowNonWeixinFriendUI.this.getString(2131759094));
        localObject = new Bundle();
        ((Bundle)localObject).putString("message", ShowNonWeixinFriendUI.this.getString(2131759113));
        ((Bundle)localObject).putString("to", Long.toString(ShowNonWeixinFriendUI.a(ShowNonWeixinFriendUI.this)));
        paramAnonymousView.a(ShowNonWeixinFriendUI.this, "apprequests", (Bundle)localObject, new c.a()
        {
          public final void E(Bundle paramAnonymous2Bundle)
          {
            AppMethodBeat.i(128750);
            Log.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
            h.a(ShowNonWeixinFriendUI.this.getContext(), 2131759118, 2131755998, new DialogInterface.OnClickListener()
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
          
          public final void a(com.tencent.mm.ui.h.a.b paramAnonymous2b)
          {
            AppMethodBeat.i(128749);
            Log.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
            AppMethodBeat.o(128749);
          }
          
          public final void a(com.tencent.mm.ui.h.a.e paramAnonymous2e)
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
    setMMTitle(2131761802);
    this.kso = getIntent().getLongExtra("Contact_KFacebookId", 0L);
    this.ksp = getIntent().getStringExtra("Contact_KFacebookName");
    initView();
    AppMethodBeat.o(128753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128754);
    super.onPause();
    p.aYn().e(this);
    AppMethodBeat.o(128754);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128755);
    super.onResume();
    p.aYn().d(this);
    AppMethodBeat.o(128755);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI
 * JD-Core Version:    0.7.0.1
 */