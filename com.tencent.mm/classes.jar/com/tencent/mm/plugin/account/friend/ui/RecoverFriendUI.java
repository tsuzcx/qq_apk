package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.account.friend.a.av;
import com.tencent.mm.plugin.account.friend.a.av.1;
import com.tencent.mm.plugin.account.friend.a.av.2;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class RecoverFriendUI
  extends MMActivity
{
  private av mZd;
  
  public RecoverFriendUI()
  {
    AppMethodBeat.i(184454);
    this.mZd = new av(this);
    AppMethodBeat.o(184454);
  }
  
  public int getLayoutId()
  {
    return a.d.recover_friend_list_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(184455);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_session_id");
    String str = getIntent().getStringExtra("key_old_username");
    this.mZd.sessionId = paramBundle;
    this.mZd.mXA = str;
    setMMTitle(a.g.import_contact_friend);
    paramBundle = this.mZd;
    Log.i("MicroMsg.RecoverFriendPresenter", "onUICreate");
    paramBundle.mXz = ((RecoverFriendSortView)paramBundle.activity.findViewById(a.c.friend_sort_view));
    h.aGY().a(3513, paramBundle);
    paramBundle.yo(au.aaO(paramBundle.mXA));
    paramBundle.mXz.getScrollBar().setVisibility(8);
    paramBundle.mXz.getListView().setOnScrollListener(new av.1(paramBundle));
    paramBundle.mXz.mXA = paramBundle.mXA;
    paramBundle.mXz.setOnItemClickListener(new av.2(paramBundle));
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
    av localav = this.mZd;
    Log.i("MicroMsg.RecoverFriendPresenter", "onUIDestroy");
    h.aGY().b(3513, localav);
    localav.dead();
    AppMethodBeat.o(184456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI
 * JD-Core Version:    0.7.0.1
 */