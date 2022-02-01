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
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.game.report.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ao;

public class GameChatTabUI
  extends GameLifeConversationUI
{
  private GameTabWidget2 uEU;
  private String uEV;
  private k.a uEW;
  private BroadcastReceiver uEX;
  
  public GameChatTabUI()
  {
    AppMethodBeat.i(195671);
    this.uEW = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(195669);
        if ((paramAnonymousm.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          GameChatTabUI.d(GameChatTabUI.this);
        }
        AppMethodBeat.o(195669);
      }
    };
    this.uEX = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195670);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameChatTabUI.this != null) && (!GameChatTabUI.this.isFinishing()))
        {
          ae.i("MicroMsg.GameChatTabUI", "GameWebTabUI exit!");
          GameChatTabUI.this.finish();
        }
        AppMethodBeat.o(195670);
      }
    };
    AppMethodBeat.o(195671);
  }
  
  private void dcS()
  {
    AppMethodBeat.i(195680);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).ddp();
    ae.d("MicroMsg.GameChatTabUI", "get unread count: %d", new Object[] { Integer.valueOf(i) });
    if (this.uEU != null) {
      this.uEU.setChatMsgUnreadCount(i);
    }
    AppMethodBeat.o(195680);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(195676);
    super.onBackPressed();
    a.fE(this);
    AppMethodBeat.o(195676);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(195679);
    super.onConfigurationChanged(paramConfiguration);
    setRequestedOrientation(1);
    AppMethodBeat.o(195679);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195672);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.GameChatTabUI", "onCreate");
    this.uEU = a.b(this, getContentView());
    this.uEU.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195665);
        GameChatTabUI.a(GameChatTabUI.this, GameChatTabUI.a(GameChatTabUI.this).getHeight());
        AppMethodBeat.o(195665);
      }
    });
    if (com.tencent.mm.plugin.game.commlib.a.cZy() != null)
    {
      paramBundle = com.tencent.mm.plugin.game.commlib.a.cZy().usH;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.uuq;; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (bu.isNullOrNil(paramBundle)) {
        localObject = "https://game.weixin.qq.com/cgi-bin/h5/static/gamelife/homepage.html";
      }
      this.uEV = ((String)localObject);
      ae.i("MicroMsg.GameChatTabUI", "profile entrance: %s", new Object[] { this.uEV });
      setMMTitle(2131760012);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
      registerReceiver(this.uEX, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
      dcS();
      ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.uEW);
      paramBundle = getSupportActionBar().getCustomView();
      if ((paramBundle != null) && ((paramBundle instanceof LinearLayout)))
      {
        localObject = paramBundle.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = LayoutInflater.from(this).inflate(2131496404, (LinearLayout)paramBundle, false);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.gravity = 16;
        ((LinearLayout)paramBundle).addView((View)localObject, localLayoutParams);
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(195668);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = com.tencent.mm.game.report.c.guw;
            c.a.a(2L, 201L, 0L, 7L, GameChatTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0)).aLH();
            com.tencent.mm.plugin.game.f.c.aD(GameChatTabUI.this, GameChatTabUI.c(GameChatTabUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195668);
          }
        });
      }
      setRequestedOrientation(1);
      if (this.uEU != null) {
        this.uEU.dcW();
      }
      boolean bool = ao.acF(getResources().getColor(2131101179));
      paramBundle = getContentView();
      int i = getResources().getColor(2131101179);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.ui.statusbar.a.e(paramBundle, i, bool);
        getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101179));
        AppMethodBeat.o(195672);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(195677);
    super.onDestroy();
    ae.i("MicroMsg.GameChatTabUI", "onDestroy");
    unregisterReceiver(this.uEX);
    ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.uEW);
    a.fE(this);
    AppMethodBeat.o(195677);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(195678);
    a.fE(this);
    AppMethodBeat.o(195678);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(195675);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772069, 2130772069);
    ae.i("MicroMsg.GameChatTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(195675);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.uEU != null) {
      this.uEU.hi(str, paramIntent);
    }
    AppMethodBeat.o(195675);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(195674);
    super.onPause();
    ae.i("MicroMsg.GameChatTabUI", "onPause");
    g.ajR().ajA().set(am.a.IUN, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).ddr()));
    AppMethodBeat.o(195674);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(195673);
    super.onResume();
    if (getIntent().getBooleanExtra("disable_game_tab_home_swipe", false)) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(195666);
          if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
          {
            AppMethodBeat.o(195666);
            return false;
          }
          GameChatTabUI.b(GameChatTabUI.this);
          AppMethodBeat.o(195666);
          return false;
        }
      });
    }
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qxd, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.GameChatTabUI", "preload profile");
        h.MqF.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195667);
            if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
            {
              AppMethodBeat.o(195667);
              return;
            }
            GameChatTabUI.ann(GameChatTabUI.c(GameChatTabUI.this));
            AppMethodBeat.o(195667);
          }
        }, 500L);
      }
      AppMethodBeat.o(195673);
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