package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(19)
public class GameTabBridgeUI
  extends GameCenterActivity
{
  private BroadcastReceiver Dbh;
  
  public GameTabBridgeUI()
  {
    AppMethodBeat.i(42439);
    this.Dbh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(42438);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabBridgeUI.this != null) && (!GameTabBridgeUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
          GameTabBridgeUI.this.finish();
        }
        AppMethodBeat.o(42438);
      }
    };
    AppMethodBeat.o(42439);
  }
  
  private void ezS()
  {
    AppMethodBeat.i(42446);
    if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      c.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(g.a.slide_left_in, g.a.slide_right_out);
      Log.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(42446);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42445);
    Log.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
    ezS();
    sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.CfL);
    AppMethodBeat.o(42445);
  }
  
  public final boolean ezp()
  {
    return false;
  }
  
  public final int ezq()
  {
    return 0;
  }
  
  public final int ezr()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return g.f.Cmq;
  }
  
  public final int getScene()
  {
    return 0;
  }
  
  public void initView()
  {
    AppMethodBeat.i(42441);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42437);
        GameTabBridgeUI.a(GameTabBridgeUI.this);
        AppMethodBeat.o(42437);
        return true;
      }
    });
    setMMTitle(g.i.Cqg);
    AppMethodBeat.o(42441);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42440);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[] { getClass().getSimpleName() });
    GameTabWidget.oJw = hashCode();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.Dbh, paramBundle, com.tencent.mm.plugin.game.a.CfL, null);
    paramBundle = getIntent();
    GameTabData localGameTabData = (GameTabData)paramBundle.getParcelableExtra("tab_data");
    String str = paramBundle.getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(g.e.ClO);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(localGameTabData, str);
    paramBundle.setComponent((ComponentName)paramBundle.getParcelableExtra("next_tab_component"));
    ToolsProcessIPCService.a(GameTabWidget.a.class, new f() {});
    AppMethodBeat.o(42440);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42443);
    super.onDestroy();
    unregisterReceiver(this.Dbh);
    AppMethodBeat.o(42443);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(42444);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(42444);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(42444);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42442);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(42442);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI
 * JD-Core Version:    0.7.0.1
 */