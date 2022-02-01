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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(19)
public class GameTabBridgeUI
  extends GameCenterActivity
{
  private BroadcastReceiver IVv;
  
  public GameTabBridgeUI()
  {
    AppMethodBeat.i(42439);
    this.IVv = new BroadcastReceiver()
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
  
  private void fHT()
  {
    AppMethodBeat.i(42446);
    if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      c.g(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(h.a.slide_left_in, h.a.slide_right_out);
      Log.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(42446);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42445);
    Log.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
    fHT();
    sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.HRS);
    AppMethodBeat.o(42445);
  }
  
  public final boolean fHl()
  {
    return false;
  }
  
  public final int fHm()
  {
    return 0;
  }
  
  public final int fHn()
  {
    return 0;
  }
  
  public final String fHo()
  {
    return null;
  }
  
  public final String fHp()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return h.f.HYy;
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
    setMMTitle(h.i.Icp);
    AppMethodBeat.o(42441);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42440);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameTabBridgeUI", "%s create", new Object[] { getClass().getSimpleName() });
    GameTabWidget.rNk = hashCode();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.IVv, paramBundle, com.tencent.mm.plugin.game.a.HRS, null);
    paramBundle = getIntent();
    GameTabData localGameTabData = (GameTabData)paramBundle.getParcelableExtra("tab_data");
    String str = paramBundle.getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(h.e.HXW);
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
    unregisterReceiver(this.IVv);
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