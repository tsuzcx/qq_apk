package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.game.protobuf.dk;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;

public class GameChatTabUI
  extends GameLifeConversationUI
{
  private GameTabWidget2 xWR;
  private String xWS;
  private MStorage.IOnStorageChange xWT;
  private com.tencent.mm.pluginsdk.c.a xWU;
  private BroadcastReceiver xWV;
  
  public GameChatTabUI()
  {
    AppMethodBeat.i(204194);
    this.xWT = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(204191);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          GameChatTabUI.d(GameChatTabUI.this);
        }
        AppMethodBeat.o(204191);
      }
    };
    this.xWU = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(204192);
        if ((paramAnonymousIEvent instanceof iy))
        {
          GameChatTabUI.e(GameChatTabUI.this);
          GameChatTabUI.d(GameChatTabUI.this);
        }
        AppMethodBeat.o(204192);
      }
    };
    this.xWV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(204193);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameChatTabUI.this != null) && (!GameChatTabUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameChatTabUI", "GameWebTabUI exit!");
          GameChatTabUI.this.finish();
        }
        AppMethodBeat.o(204193);
      }
    };
    AppMethodBeat.o(204194);
  }
  
  private void dWz()
  {
    AppMethodBeat.i(204203);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dWZ();
    int j = ((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NY(1);
    int k = ((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NY(2);
    Log.d("MicroMsg.GameChatTabUI", "get chat unread count: %d, interactiveUnreadCount:%d, notifyUnreadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    GameTabWidget2 localGameTabWidget2;
    if (this.xWR != null)
    {
      localGameTabWidget2 = this.xWR;
      if (k <= 0) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      localGameTabWidget2.aA(i + j, bool);
      AppMethodBeat.o(204203);
      return;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(204199);
    super.onBackPressed();
    a.gk(this);
    AppMethodBeat.o(204199);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(204202);
    super.onConfigurationChanged(paramConfiguration);
    setRequestedOrientation(1);
    AppMethodBeat.o(204202);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204195);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameChatTabUI", "onCreate");
    this.xWR = a.b(this, getContentView());
    this.xWR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204187);
        GameChatTabUI.a(GameChatTabUI.this, GameChatTabUI.a(GameChatTabUI.this).getHeight());
        AppMethodBeat.o(204187);
      }
    });
    if (com.tencent.mm.plugin.game.commlib.a.dSY() != null)
    {
      paramBundle = com.tencent.mm.plugin.game.commlib.a.dSY().xKZ;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.xMs;; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (Util.isNullOrNil(paramBundle)) {
        localObject = "https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/gamelife/homepage.html";
      }
      this.xWS = ((String)localObject);
      Log.i("MicroMsg.GameChatTabUI", "profile entrance: %s", new Object[] { this.xWS });
      setMMTitle(2131761376);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
      registerReceiver(this.xWV, paramBundle, com.tencent.mm.plugin.game.a.xtn, null);
      ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.xWT);
      com.tencent.mm.pluginsdk.c.a.a(iy.class.getName(), this.xWU);
      paramBundle = getSupportActionBar().getCustomView();
      if ((paramBundle != null) && ((paramBundle instanceof LinearLayout)))
      {
        localObject = paramBundle.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = LayoutInflater.from(this).inflate(2131494900, (LinearLayout)paramBundle, false);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((LinearLayout)paramBundle).addView((View)localObject, localLayoutParams);
        ((View)localObject).setOnClickListener(new GameChatTabUI.4(this));
      }
      setRequestedOrientation(1);
      if (this.xWR != null) {
        this.xWR.dWE();
      }
      boolean bool = ar.aln(getResources().getColor(2131101424));
      paramBundle = getContentView();
      int i = getResources().getColor(2131101424);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.ui.statusbar.a.e(paramBundle, i, bool);
        getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101424));
        AppMethodBeat.o(204195);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(204200);
    super.onDestroy();
    Log.i("MicroMsg.GameChatTabUI", "onDestroy");
    unregisterReceiver(this.xWV);
    ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.xWT);
    com.tencent.mm.pluginsdk.c.a.b(iy.class.getName(), this.xWU);
    a.gk(this);
    AppMethodBeat.o(204200);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(204201);
    a.gk(this);
    AppMethodBeat.o(204201);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(204198);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772082, 2130772082);
    Log.i("MicroMsg.GameChatTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(204198);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.xWR != null) {
      this.xWR.hP(str, paramIntent);
    }
    AppMethodBeat.o(204198);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(204197);
    super.onPause();
    Log.i("MicroMsg.GameChatTabUI", "onPause");
    g.aAh().azQ().set(ar.a.Odb, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa().msgId));
    AppMethodBeat.o(204197);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(204196);
    super.onResume();
    dWz();
    if (getIntent().getBooleanExtra("disable_game_tab_home_swipe", false)) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(204188);
          if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
          {
            AppMethodBeat.o(204188);
            return false;
          }
          GameChatTabUI.b(GameChatTabUI.this);
          AppMethodBeat.o(204188);
          return false;
        }
      });
    }
    if (((com.tencent.mm.game.report.a.b)g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.rOQ, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.GameChatTabUI", "preload profile");
        h.RTc.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204189);
            if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
            {
              AppMethodBeat.o(204189);
              return;
            }
            GameChatTabUI.aAE(GameChatTabUI.c(GameChatTabUI.this));
            AppMethodBeat.o(204189);
          }
        }, 500L);
      }
      AppMethodBeat.o(204196);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI
 * JD-Core Version:    0.7.0.1
 */