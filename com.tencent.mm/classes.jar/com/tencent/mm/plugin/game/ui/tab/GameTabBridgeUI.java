package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(19)
public class GameTabBridgeUI
  extends GameCenterActivity
{
  private BroadcastReceiver lfT = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && ("com.tencent.mm.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabBridgeUI.this != null) && (!GameTabBridgeUI.this.isFinishing()))
      {
        y.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
        GameTabBridgeUI.this.finish();
      }
    }
  };
  
  private void goBack()
  {
    y.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
    if (bk.pm(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.e(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(g.a.slide_left_in, g.a.slide_right_out);
      y.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
    }
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
  }
  
  protected final boolean aZX()
  {
    return false;
  }
  
  public final int aZY()
  {
    return 0;
  }
  
  public final int aZZ()
  {
    return 0;
  }
  
  public final int baa()
  {
    return 0;
  }
  
  protected final int getLayoutId()
  {
    return g.f.game_bridge_layout;
  }
  
  protected final void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GameTabBridgeUI.a(GameTabBridgeUI.this);
        return true;
      }
    });
    setMMTitle(g.i.game_wechat_game);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[] { getClass().getSimpleName() });
    GameTabWidget.lfZ = hashCode();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.lfT, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    paramBundle = getIntent();
    GameTabData localGameTabData = (GameTabData)paramBundle.getParcelableExtra("tab_data");
    String str = paramBundle.getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(g.e.tabwidget);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(localGameTabData, str);
    paramBundle.setComponent((ComponentName)paramBundle.getParcelableExtra("next_tab_component"));
    ToolsProcessIPCService.a(null, GameTabWidget.a.class, new GameTabBridgeUI.1(this, System.currentTimeMillis(), paramBundle));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.lfT);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI
 * JD-Core Version:    0.7.0.1
 */