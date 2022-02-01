package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.protobuf.dl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;

public final class a
  implements c
{
  String Dbc;
  GameTabWidget2 Dbg;
  private BroadcastReceiver Dbh;
  private MStorage.IOnStorageChange Dbi;
  private com.tencent.mm.pluginsdk.d.a Dbj;
  MMActivity tmY;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(189792);
    this.Dbh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(190034);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (a.this.tmY != null) && (!a.this.tmY.isFinishing()))
        {
          Log.i("MicroMsg.ChatTabPresenter", "gamecenter exit!");
          a.this.tmY.finish();
        }
        AppMethodBeat.o(190034);
      }
    };
    this.Dbi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(192902);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
          a.this.ezG();
        }
        AppMethodBeat.o(192902);
      }
    };
    this.Dbj = new com.tencent.mm.pluginsdk.d.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(201267);
        if ((paramAnonymousIEvent instanceof jo)) {
          a.this.ezG();
        }
        AppMethodBeat.o(201267);
      }
    };
    this.tmY = paramMMActivity;
    AppMethodBeat.o(189792);
  }
  
  private static String ezF()
  {
    AppMethodBeat.i(189842);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.game.commlib.a.ewg() != null)
    {
      dl localdl = com.tencent.mm.plugin.game.commlib.a.ewg().CPg;
      localObject1 = localObject2;
      if (localdl != null) {
        localObject1 = localdl.CQB;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "https://" + WeChatHosts.domainString(g.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gamelife/homepage.html";
    }
    AppMethodBeat.o(189842);
    return localObject2;
  }
  
  public static void onPause()
  {
    AppMethodBeat.i(189817);
    Log.i("MicroMsg.ChatTabPresenter", "onPause");
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vri, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).eAj().msgId));
    AppMethodBeat.o(189817);
  }
  
  public final void a(View paramView, final c.a parama)
  {
    AppMethodBeat.i(189806);
    Log.i("MicroMsg.ChatTabPresenter", "onCreate");
    this.Dbg = b.b(this.tmY, paramView);
    this.Dbg.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200516);
        if (parama != null) {
          parama.TW(a.this.Dbg.getHeight());
        }
        AppMethodBeat.o(200516);
      }
    });
    this.Dbc = ezF();
    parama.aKq(this.Dbc);
    Log.i("MicroMsg.ChatTabPresenter", "profile entrance: %s", new Object[] { this.Dbc });
    this.tmY.setMMTitle(g.i.Cqg);
    parama = new IntentFilter();
    parama.addAction("com.tencent.mm.game.ACTION_EXIT");
    this.tmY.registerReceiver(this.Dbh, parama, com.tencent.mm.plugin.game.a.CfL, null);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.Dbi);
    com.tencent.mm.pluginsdk.d.a.a(jo.class.getName(), this.Dbj);
    this.tmY.setRequestedOrientation(1);
    if (this.Dbg != null) {
      this.Dbg.ezM();
    }
    boolean bool = au.auk(this.tmY.getResources().getColor(g.b.white));
    int i = this.tmY.getResources().getColor(g.b.white);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.f(paramView, i, bool);
      this.tmY.getSupportActionBar().getCustomView().setBackgroundColor(this.tmY.getResources().getColor(g.b.white));
      this.tmY.setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(202109);
          b.gE(a.this.tmY);
          AppMethodBeat.o(202109);
          return false;
        }
      });
      AppMethodBeat.o(189806);
      return;
    }
  }
  
  public final void cN()
  {
    AppMethodBeat.i(189837);
    Log.i("MicroMsg.ChatTabPresenter", "onConfigurationChanged");
    this.tmY.setRequestedOrientation(1);
    AppMethodBeat.o(189837);
  }
  
  public final void evQ()
  {
    AppMethodBeat.i(189838);
    Log.i("MicroMsg.ChatTabPresenter", "finishPage");
    b.gE(this.tmY);
    AppMethodBeat.o(189838);
  }
  
  final void ezG()
  {
    AppMethodBeat.i(189847);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).eAi();
    int j = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(1);
    int k = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(2);
    Log.d("MicroMsg.ChatTabPresenter", "get chat unread count: %d, interactiveUnreadCount:%d, notifyUnreadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    GameTabWidget2 localGameTabWidget2;
    if (this.Dbg != null)
    {
      localGameTabWidget2 = this.Dbg;
      if (k <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      localGameTabWidget2.aE(i + j, bool);
      AppMethodBeat.o(189847);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(189831);
    Log.i("MicroMsg.ChatTabPresenter", "onBackPressed");
    b.gE(this.tmY);
    AppMethodBeat.o(189831);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189823);
    Log.i("MicroMsg.ChatTabPresenter", "onDestroy");
    this.tmY.unregisterReceiver(this.Dbh);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.Dbi);
    com.tencent.mm.pluginsdk.d.a.b(jo.class.getName(), this.Dbj);
    b.gE(this.tmY);
    AppMethodBeat.o(189823);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(189829);
    Object localObject = this.tmY;
    int i = g.a.Cgw;
    ((MMActivity)localObject).overridePendingTransition(i, i);
    Log.i("MicroMsg.ChatTabPresenter", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(189829);
      return;
    }
    this.tmY.setIntent(paramIntent);
    localObject = paramIntent.getStringExtra("game_tab_key");
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.Dbg != null) {
      this.Dbg.hY((String)localObject, paramIntent);
    }
    AppMethodBeat.o(189829);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(189812);
    Log.i("MicroMsg.ChatTabPresenter", "onResume");
    ezG();
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.game.report.a.b.class)).a(b.a.vuS, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.ChatTabPresenter", "preload profile");
        com.tencent.e.h.ZvG.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193408);
            if ((a.this.tmY.isDestroyed()) || (a.this.tmY.isFinishing()))
            {
              AppMethodBeat.o(193408);
              return;
            }
            String str = a.this.Dbc;
            if (!Util.isNullOrNil(str))
            {
              Log.i("MicroMsg.ChatTabPresenter", "preload url: %s", new Object[] { str });
              oo localoo = new oo();
              localoo.fNq.type = 3;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str);
              localoo.fNq.intent = localIntent;
              EventCenter.instance.publish(localoo);
            }
            AppMethodBeat.o(193408);
          }
        }, 500L);
      }
      AppMethodBeat.o(189812);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.a
 * JD-Core Version:    0.7.0.1
 */