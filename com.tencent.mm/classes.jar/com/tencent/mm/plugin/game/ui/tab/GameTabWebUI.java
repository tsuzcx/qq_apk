package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameTabWebUI
  extends GameWebViewUI
{
  private Activity activity;
  private BroadcastReceiver xWV;
  private String xXH;
  
  public GameTabWebUI()
  {
    AppMethodBeat.i(42461);
    this.xWV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(42460);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabWebUI.a(GameTabWebUI.this) != null) && (!GameTabWebUI.a(GameTabWebUI.this).isFinishing()))
        {
          Log.i("MicroMsg.GameTabWebUI", "%s exit!", new Object[] { GameTabWebUI.a(GameTabWebUI.this).getClass().getSimpleName() });
          GameTabWebUI.a(GameTabWebUI.this).finish();
        }
        AppMethodBeat.o(42460);
      }
    };
    AppMethodBeat.o(42461);
  }
  
  private void dWK()
  {
    AppMethodBeat.i(42467);
    if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      c.f(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(2130772165, 2130772170);
      Log.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
    }
    AppMethodBeat.o(42467);
  }
  
  public final void goBack()
  {
    AppMethodBeat.i(42466);
    Log.i("MicroMsg.GameTabWebUI", "%s goBack!", new Object[] { this.activity.getClass().getSimpleName() });
    dWK();
    sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
    AppMethodBeat.o(42466);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(42465);
    super.onBackPressed();
    goBack();
    AppMethodBeat.o(42465);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42462);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameTabWebUI", "%s create", new Object[] { getClass().getSimpleName() });
    this.activity = this;
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.xXH = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = new GameTabWidget(this);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.xXH);
    ((LinearLayout)findViewById(2131310394)).addView(localGameTabWidget);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.xWV, paramBundle, com.tencent.mm.plugin.game.a.xtn, null);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(42459);
        GameTabWebUI.this.goBack();
        AppMethodBeat.o(42459);
        return true;
      }
    });
    AppMethodBeat.o(42462);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42464);
    super.onDestroy();
    unregisterReceiver(this.xWV);
    AppMethodBeat.o(42464);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(42463);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(42463);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("tab_key");
    if (!Util.nullAsNil(this.xXH).equals(str))
    {
      Log.i("MicroMsg.GameTabWebUI", "reload %s", new Object[] { this.activity.getClass().getSimpleName() });
      finish();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/game/ui/tab/GameTabWebUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/tab/GameTabWebUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    overridePendingTransition(2130772082, 2130772082);
    AppMethodBeat.o(42463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWebUI
 * JD-Core Version:    0.7.0.1
 */