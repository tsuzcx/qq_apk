package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameTabWebUI
  extends GameWebViewUI
{
  private Activity activity;
  private BroadcastReceiver nDO;
  private String nDR;
  
  public GameTabWebUI()
  {
    AppMethodBeat.i(112263);
    this.nDO = new GameTabWebUI.2(this);
    AppMethodBeat.o(112263);
  }
  
  private void bHx()
  {
    AppMethodBeat.i(112269);
    if (bo.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(2131034262, 2131034267);
      ab.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
    }
    AppMethodBeat.o(112269);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(112268);
    ab.i("MicroMsg.GameTabWebUI", "%s goBack!", new Object[] { this.activity.getClass().getSimpleName() });
    bHx();
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(112268);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(112267);
    super.onBackPressed();
    goBack();
    AppMethodBeat.o(112267);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112264);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.GameTabWebUI", "%s create", new Object[] { getClass().getSimpleName() });
    this.activity = this;
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.nDR = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = new GameTabWidget(this);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.nDR);
    ((LinearLayout)findViewById(2131823716)).addView(localGameTabWidget);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.nDO, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(112261);
        GameTabWebUI.a(GameTabWebUI.this);
        AppMethodBeat.o(112261);
        return true;
      }
    });
    AppMethodBeat.o(112264);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112266);
    super.onDestroy();
    unregisterReceiver(this.nDO);
    AppMethodBeat.o(112266);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(112265);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(112265);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("tab_key");
    if (!bo.nullAsNil(this.nDR).equals(str))
    {
      ab.i("MicroMsg.GameTabWebUI", "reload %s", new Object[] { this.activity.getClass().getSimpleName() });
      finish();
      startActivity(paramIntent);
    }
    overridePendingTransition(2131034195, 2131034195);
    AppMethodBeat.o(112265);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWebUI
 * JD-Core Version:    0.7.0.1
 */