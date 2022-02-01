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
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ao;

public class GameChatTabUI
  extends GameLifeConversationUI
{
  private GameTabWidget2 utB;
  private String utC;
  private k.a utD;
  private BroadcastReceiver utE;
  
  public GameChatTabUI()
  {
    AppMethodBeat.i(206849);
    this.utD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(206847);
        if ((paramAnonymousm.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          GameChatTabUI.d(GameChatTabUI.this);
        }
        AppMethodBeat.o(206847);
      }
    };
    this.utE = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(206848);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameChatTabUI.this != null) && (!GameChatTabUI.this.isFinishing()))
        {
          ad.i("MicroMsg.GameChatTabUI", "GameWebTabUI exit!");
          GameChatTabUI.this.finish();
        }
        AppMethodBeat.o(206848);
      }
    };
    AppMethodBeat.o(206849);
  }
  
  private void dah()
  {
    AppMethodBeat.i(206858);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).daD();
    ad.d("MicroMsg.GameChatTabUI", "get unread count: %d", new Object[] { Integer.valueOf(i) });
    if (this.utB != null) {
      this.utB.setChatMsgUnreadCount(i);
    }
    AppMethodBeat.o(206858);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(206854);
    super.onBackPressed();
    a.fz(this);
    AppMethodBeat.o(206854);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(206857);
    super.onConfigurationChanged(paramConfiguration);
    setRequestedOrientation(1);
    AppMethodBeat.o(206857);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206850);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GameChatTabUI", "onCreate");
    this.utB = a.b(this, getContentView());
    this.utB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206843);
        GameChatTabUI.a(GameChatTabUI.this, GameChatTabUI.a(GameChatTabUI.this).getHeight());
        AppMethodBeat.o(206843);
      }
    });
    if (com.tencent.mm.plugin.game.commlib.a.cWU() != null)
    {
      paramBundle = com.tencent.mm.plugin.game.commlib.a.cWU().uhk;
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.uiT;; paramBundle = null)
    {
      Object localObject = paramBundle;
      if (bt.isNullOrNil(paramBundle)) {
        localObject = "https://game.weixin.qq.com/cgi-bin/h5/static/gamelife/homepage.html";
      }
      this.utC = ((String)localObject);
      ad.i("MicroMsg.GameChatTabUI", "profile entrance: %s", new Object[] { this.utC });
      setMMTitle(2131760012);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
      registerReceiver(this.utE, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
      dah();
      ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.utD);
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
            AppMethodBeat.i(206846);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = com.tencent.mm.game.report.c.grV;
            c.a.a(2L, 201L, 0L, 7L, GameChatTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0)).aLk();
            com.tencent.mm.plugin.game.f.c.aB(GameChatTabUI.this, GameChatTabUI.c(GameChatTabUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206846);
          }
        });
      }
      setRequestedOrientation(1);
      if (this.utB != null) {
        this.utB.dal();
      }
      boolean bool = ao.abX(getResources().getColor(2131101179));
      paramBundle = getContentView();
      int i = getResources().getColor(2131101179);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.ui.statusbar.a.e(paramBundle, i, bool);
        getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101179));
        AppMethodBeat.o(206850);
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(206855);
    super.onDestroy();
    ad.i("MicroMsg.GameChatTabUI", "onDestroy");
    unregisterReceiver(this.utE);
    ((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.utD);
    a.fz(this);
    AppMethodBeat.o(206855);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(206856);
    a.fz(this);
    AppMethodBeat.o(206856);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(206853);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772069, 2130772069);
    ad.i("MicroMsg.GameChatTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(206853);
      return;
    }
    setIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("game_tab_key");
    if (this.utB != null) {
      this.utB.amo(paramIntent);
    }
    AppMethodBeat.o(206853);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(206852);
    super.onPause();
    ad.i("MicroMsg.GameChatTabUI", "onPause");
    g.ajC().ajl().set(al.a.IAo, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c)g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).daF()));
    AppMethodBeat.o(206852);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(206851);
    super.onResume();
    if (getIntent().getBooleanExtra("disable_game_tab_home_swipe", false)) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(206844);
          if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
          {
            AppMethodBeat.o(206844);
            return false;
          }
          GameChatTabUI.b(GameChatTabUI.this);
          AppMethodBeat.o(206844);
          return false;
        }
      });
    }
    if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.qqv, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.GameChatTabUI", "preload profile");
        h.LTJ.q(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206845);
            if ((GameChatTabUI.this.isDestroyed()) || (GameChatTabUI.this.isFinishing()))
            {
              AppMethodBeat.o(206845);
              return;
            }
            GameChatTabUI.amn(GameChatTabUI.c(GameChatTabUI.this));
            AppMethodBeat.o(206845);
          }
        }, 500L);
      }
      AppMethodBeat.o(206851);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI
 * JD-Core Version:    0.7.0.1
 */