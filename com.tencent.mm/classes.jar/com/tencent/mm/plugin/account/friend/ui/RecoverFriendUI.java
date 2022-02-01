package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
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
  private av khE;
  
  public RecoverFriendUI()
  {
    AppMethodBeat.i(184454);
    this.khE = new av(this);
    AppMethodBeat.o(184454);
  }
  
  public int getLayoutId()
  {
    return 2131496074;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(184455);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_session_id");
    String str = getIntent().getStringExtra("key_old_username");
    this.khE.sessionId = paramBundle;
    this.khE.kgb = str;
    setMMTitle(2131761772);
    paramBundle = this.khE;
    Log.i("MicroMsg.RecoverFriendPresenter", "onUICreate");
    paramBundle.kga = ((RecoverFriendSortView)paramBundle.activity.findViewById(2131301791));
    g.azz().a(3513, paramBundle);
    paramBundle.vk(au.Ti(paramBundle.kgb));
    paramBundle.kga.getScrollBar().setVisibility(8);
    paramBundle.kga.getListView().setOnScrollListener(new av.1(paramBundle));
    paramBundle.kga.kgb = paramBundle.kgb;
    paramBundle.kga.setOnItemClickListener(new av.2(paramBundle));
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
    av localav = this.khE;
    Log.i("MicroMsg.RecoverFriendPresenter", "onUIDestroy");
    g.azz().b(3513, localav);
    localav.dead();
    AppMethodBeat.o(184456);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecoverFriendUI
 * JD-Core Version:    0.7.0.1
 */