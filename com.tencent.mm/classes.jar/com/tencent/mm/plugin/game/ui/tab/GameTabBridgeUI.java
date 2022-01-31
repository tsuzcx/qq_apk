package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(19)
public class GameTabBridgeUI
  extends GameCenterActivity
{
  private BroadcastReceiver nDO;
  
  public GameTabBridgeUI()
  {
    AppMethodBeat.i(112241);
    this.nDO = new GameTabBridgeUI.3(this);
    AppMethodBeat.o(112241);
  }
  
  private void bHx()
  {
    AppMethodBeat.i(112248);
    if (bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(2131034262, 2131034267);
      ab.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(112248);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(112247);
    ab.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
    bHx();
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(112247);
  }
  
  public final boolean bHf()
  {
    return false;
  }
  
  public final int bHg()
  {
    return 0;
  }
  
  public final int bHh()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2130969694;
  }
  
  public final int getScene()
  {
    return 0;
  }
  
  public void initView()
  {
    AppMethodBeat.i(112243);
    setBackBtn(new GameTabBridgeUI.2(this));
    setMMTitle(2131300478);
    AppMethodBeat.o(112243);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112242);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[] { getClass().getSimpleName() });
    GameTabWidget.nDU = hashCode();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.nDO, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    paramBundle = getIntent();
    GameTabData localGameTabData = (GameTabData)paramBundle.getParcelableExtra("tab_data");
    String str = paramBundle.getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(2131824431);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(localGameTabData, str);
    paramBundle.setComponent((ComponentName)paramBundle.getParcelableExtra("next_tab_component"));
    ToolsProcessIPCService.a(null, GameTabWidget.a.class, new c() {});
    AppMethodBeat.o(112242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112245);
    super.onDestroy();
    unregisterReceiver(this.nDO);
    AppMethodBeat.o(112245);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(112246);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(112246);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(112246);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(112244);
    super.onResume();
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(112244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI
 * JD-Core Version:    0.7.0.1
 */