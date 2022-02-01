package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.av;
import com.tencent.mm.plugin.account.friend.a.av.1;
import com.tencent.mm.plugin.account.friend.a.av.2;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class RecoverFriendUI
  extends MMActivity
{
  private av jjC;
  
  public RecoverFriendUI()
  {
    AppMethodBeat.i(184454);
    this.jjC = new av(this);
    AppMethodBeat.o(184454);
  }
  
  public int getLayoutId()
  {
    return 2131495228;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(184455);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_session_id");
    String str = getIntent().getStringExtra("key_old_username");
    this.jjC.sessionId = paramBundle;
    this.jjC.jhY = str;
    setMMTitle(2131760328);
    paramBundle = this.jjC;
    ae.i("MicroMsg.RecoverFriendPresenter", "onUICreate");
    paramBundle.jhX = ((RecoverFriendSortView)paramBundle.activity.findViewById(2131300301));
    g.ajj().a(3513, paramBundle);
    paramBundle.ru(au.Kk(paramBundle.jhY));
    paramBundle.jhX.getScrollBar().setVisibility(8);
    paramBundle.jhX.getListView().setOnScrollListener(new av.1(paramBundle));
    paramBundle.jhX.jhY = paramBundle.jhY;
    paramBundle.jhX.setOnItemClickListener(new av.2(paramBundle));
    paramBundle.alive();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(184453);
        RecoverFriendUI.this.finish();
        AppMethodBeat.o(184453);
        return true;
      }
    });
    AppMethodBeat.o(184455);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(184456);
    super.onDestroy();
    av localav = this.jjC;
    ae.i("MicroMsg.RecoverFriendPresenter", "onUIDestroy");
    g.ajj().b(3513, localav);
    localav.dead();
    AppMethodBeat.o(184456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI
 * JD-Core Version:    0.7.0.1
 */