package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class GameTabHomeUI
  extends GameCenterUI5
{
  private BroadcastReceiver lfT = new GameTabHomeUI.2(this);
  public String lfW;
  
  private void goBack()
  {
    y.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
    if (bk.pm(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.e(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(g.a.slide_left_in, g.a.slide_right_out);
      y.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
    }
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.GameTabHomeUI", "%s create", new Object[] { getClass().getSimpleName() });
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.lfW = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(g.e.tabwidget);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.lfW);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.lfT, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    setBackBtn(new GameTabHomeUI.1(this));
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
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("tab_key");
    if (!bk.pm(this.lfW).equals(str))
    {
      y.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", new Object[] { getClass().getSimpleName(), this.lfW, str });
      finish();
      startActivity(paramIntent);
    }
    overridePendingTransition(g.a.in_no_slide, g.a.in_no_slide);
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
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI
 * JD-Core Version:    0.7.0.1
 */