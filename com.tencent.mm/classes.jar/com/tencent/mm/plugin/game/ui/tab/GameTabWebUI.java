package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class GameTabWebUI
  extends GameWebViewUI
{
  private Activity activity;
  private BroadcastReceiver lfT = new GameTabWebUI.2(this);
  private String lfW;
  
  private void goBack()
  {
    y.i("MicroMsg.GameTabWebUI", "%s goBack!", new Object[] { this.activity.getClass().getSimpleName() });
    if (bk.pm(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.e(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(R.a.slide_left_in, R.a.slide_right_out);
      y.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
    }
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    goBack();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.GameTabWebUI", "%s create", new Object[] { getClass().getSimpleName() });
    this.activity = this;
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.lfW = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = new GameTabWidget(this);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.lfW);
    ((LinearLayout)findViewById(R.h.webview_keyboard_ll)).addView(localGameTabWidget);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.lfT, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GameTabWebUI.a(GameTabWebUI.this);
        return true;
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.lfT);
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
      y.i("MicroMsg.GameTabWebUI", "reload %s", new Object[] { this.activity.getClass().getSimpleName() });
      finish();
      startActivity(paramIntent);
    }
    overridePendingTransition(R.a.in_no_slide, R.a.in_no_slide);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWebUI
 * JD-Core Version:    0.7.0.1
 */