package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class GameTabHomeUI
  extends GameCenterUI5
{
  private BroadcastReceiver Dbh;
  public String Dcm;
  
  public GameTabHomeUI()
  {
    AppMethodBeat.i(42450);
    this.Dbh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(42449);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabHomeUI.this != null) && (!GameTabHomeUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
          GameTabHomeUI.this.finish();
        }
        AppMethodBeat.o(42449);
      }
    };
    AppMethodBeat.o(42450);
  }
  
  private void ezS()
  {
    AppMethodBeat.i(42457);
    if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      c.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(g.a.slide_left_in, g.a.slide_right_out);
      Log.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(42457);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42456);
    Log.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
    ezS();
    sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.CfL);
    AppMethodBeat.o(42456);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42451);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameTabHomeUI", "%s create", new Object[] { getClass().getSimpleName() });
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.Dcm = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(g.e.ClO);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.Dcm);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.Dbh, paramBundle, com.tencent.mm.plugin.game.a.CfL, null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42448);
        GameTabHomeUI.a(GameTabHomeUI.this);
        AppMethodBeat.o(42448);
        return true;
      }
    });
    AppMethodBeat.o(42451);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42454);
    super.onDestroy();
    unregisterReceiver(this.Dbh);
    AppMethodBeat.o(42454);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42455);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(42455);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42455);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(42453);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(42453);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("tab_key");
    if (!Util.nullAsNil(this.Dcm).equals(str))
    {
      Log.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", new Object[] { getClass().getSimpleName(), this.Dcm, str });
      finish();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    int i = g.a.Cgw;
    overridePendingTransition(i, i);
    AppMethodBeat.o(42453);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42452);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(42452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI
 * JD-Core Version:    0.7.0.1
 */