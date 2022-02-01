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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class GameTabHomeUI
  extends GameCenterUI5
{
  private BroadcastReceiver snZ;
  public String soc;
  
  public GameTabHomeUI()
  {
    AppMethodBeat.i(42450);
    this.snZ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(42449);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameTabHomeUI.this != null) && (!GameTabHomeUI.this.isFinishing()))
        {
          ad.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
          GameTabHomeUI.this.finish();
        }
        AppMethodBeat.o(42449);
      }
    };
    AppMethodBeat.o(42450);
  }
  
  private void cEu()
  {
    AppMethodBeat.i(42457);
    if (bt.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends"))
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("preferred_tab", 2);
      d.e(this, ".ui.LauncherUI", localIntent);
      finish();
      overridePendingTransition(2130772140, 2130772145);
      ad.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
    }
    AppMethodBeat.o(42457);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(42456);
    ad.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
    cEu();
    sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(42456);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42451);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GameTabHomeUI", "%s create", new Object[] { getClass().getSimpleName() });
    paramBundle = (GameTabData)getIntent().getParcelableExtra("tab_data");
    this.soc = getIntent().getStringExtra("tab_key");
    GameTabWidget localGameTabWidget = (GameTabWidget)findViewById(2131305609);
    a locala = new a(this);
    localGameTabWidget.setAdapter(locala);
    locala.a(paramBundle, this.soc);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.ACTION_EXIT");
    registerReceiver(this.snZ, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
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
    unregisterReceiver(this.snZ);
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
    if (!bt.nullAsNil(this.soc).equals(str))
    {
      ad.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", new Object[] { getClass().getSimpleName(), this.soc, str });
      finish();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    overridePendingTransition(2130772069, 2130772069);
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