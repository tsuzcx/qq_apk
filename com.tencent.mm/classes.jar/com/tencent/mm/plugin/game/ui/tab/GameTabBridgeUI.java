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
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(19)
public class GameTabBridgeUI
  extends GameCenterActivity
{
  private BroadcastReceiver uEX;
  
  public GameTabBridgeUI()
  {
    AppMethodBeat.i(42439);
    this.uEX = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(42438);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabBridgeUI.this != null) && (!GameTabBridgeUI.this.isFinishing()))
        {
          ae.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
          GameTabBridgeUI.this.finish();
        }
        AppMethodBeat.o(42438);
      }
    };
    AppMethodBeat.o(42439);
  }
  
  private void dda()
  {
    AppMethodBeat.i(42446);
    if (bu.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      com.tencent.mm.br.d.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(2130772140, 2130772145);
      ae.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(42446);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42445);
    ae.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
    dda();
    sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(42445);
  }
  
  public final boolean dcA()
  {
    return false;
  }
  
  public final int dcB()
  {
    return 0;
  }
  
  public final int dcC()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131494246;
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
    setMMTitle(2131760012);
    AppMethodBeat.o(42441);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42440);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[] { getClass().getSimpleName() });
    GameTabWidget.kID = hashCode();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.uEX, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    paramBundle = getIntent();
    GameTabData localGameTabData = (GameTabData)paramBundle.getParcelableExtra("tab_data");
    String str = paramBundle.getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(2131305609);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(localGameTabData, str);
    paramBundle.setComponent((ComponentName)paramBundle.getParcelableExtra("next_tab_component"));
    ToolsProcessIPCService.a(GameTabWidget.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(42440);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42443);
    super.onDestroy();
    unregisterReceiver(this.uEX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI
 * JD-Core Version:    0.7.0.1
 */