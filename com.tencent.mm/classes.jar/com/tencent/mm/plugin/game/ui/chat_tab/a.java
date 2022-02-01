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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.autogen.a.py;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.dp;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.threadpool.i;

public final class a
  implements c
{
  String IVq;
  GameTabWidget2 IVu;
  private BroadcastReceiver IVv;
  private MStorage.IOnStorageChange IVw;
  private IListenerMStorage IVx;
  private IListener Ipg;
  MMActivity wry;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(276603);
    this.IVv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(276608);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (a.this.wry != null) && (!a.this.wry.isFinishing()))
        {
          Log.i("MicroMsg.ChatTabPresenter", "gamecenter exit!");
          a.this.wry.finish();
        }
        AppMethodBeat.o(276608);
      }
    };
    this.IVw = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(276615);
        if ((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.f.a)) {
          a.this.fHF();
        }
        AppMethodBeat.o(276615);
      }
    };
    this.IVx = new ChatTabPresenter.6(this);
    this.Ipg = new ChatTabPresenter.7(this, com.tencent.mm.app.f.hfK);
    this.wry = paramMMActivity;
    AppMethodBeat.o(276603);
  }
  
  private static String fHE()
  {
    AppMethodBeat.i(276617);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (com.tencent.mm.plugin.game.commlib.a.fDW() != null)
    {
      dp localdp = com.tencent.mm.plugin.game.commlib.a.fDW().IJq;
      localObject1 = localObject2;
      if (localdp != null) {
        localObject1 = localdp.IKN;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/gamelife/homepage.html";
    }
    AppMethodBeat.o(276617);
    return localObject2;
  }
  
  public static void onPause()
  {
    AppMethodBeat.i(276610);
    Log.i("MicroMsg.ChatTabPresenter", "onPause");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acSK, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIj().msgId));
    AppMethodBeat.o(276610);
  }
  
  public final void a(View paramView, final c.a parama)
  {
    AppMethodBeat.i(276629);
    Log.i("MicroMsg.ChatTabPresenter", "onCreate");
    this.IVu = b.c(this.wry, paramView);
    this.IVu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276607);
        if (parama != null) {
          parama.XQ(a.this.IVu.getHeight());
        }
        AppMethodBeat.o(276607);
      }
    });
    this.IVq = fHE();
    parama.aHg(this.IVq);
    Log.i("MicroMsg.ChatTabPresenter", "profile entrance: %s", new Object[] { this.IVq });
    this.wry.setMMTitle(h.i.Icp);
    parama = new IntentFilter();
    parama.addAction("com.tencent.mm.game.ACTION_EXIT");
    this.wry.registerReceiver(this.IVv, parama, com.tencent.mm.plugin.game.a.HRS, null);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.IVw);
    IListenerMStorage.a(kp.class.getName(), this.IVx);
    this.Ipg.alive();
    this.wry.setRequestedOrientation(1);
    if (this.IVu != null) {
      this.IVu.fHN();
    }
    boolean bool = bb.aAF(this.wry.getResources().getColor(h.b.white));
    int i = this.wry.getResources().getColor(h.b.white);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.h(paramView, i, bool);
      this.wry.getSupportActionBar().getCustomView().setBackgroundColor(this.wry.getResources().getColor(h.b.white));
      this.wry.setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(276620);
          b.hX(a.this.wry);
          AppMethodBeat.o(276620);
          return false;
        }
      });
      AppMethodBeat.o(276629);
      return;
    }
  }
  
  public final void dG()
  {
    AppMethodBeat.i(276659);
    Log.i("MicroMsg.ChatTabPresenter", "onConfigurationChanged");
    this.wry.setRequestedOrientation(1);
    AppMethodBeat.o(276659);
  }
  
  public final void fHD()
  {
    AppMethodBeat.i(276669);
    Log.i("MicroMsg.ChatTabPresenter", "finishPage");
    b.hX(this.wry);
    AppMethodBeat.o(276669);
  }
  
  final void fHF()
  {
    AppMethodBeat.i(276684);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIi();
    int j = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(1);
    int k = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(2);
    Object localObject = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    boolean bool = com.tencent.mm.plugin.game.chatroom.j.a.fCY();
    Log.d("MicroMsg.ChatTabPresenter", "get chat unread count: %d, interactiveUnreadCount:%d, notifyUnreadCount:%d, hasChatRoomUnreadMsg:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool) });
    if (this.IVu != null)
    {
      localObject = this.IVu;
      if ((k <= 0) && (!bool)) {
        break label145;
      }
    }
    label145:
    for (bool = true;; bool = false)
    {
      ((GameTabWidget2)localObject).be(i + j, bool);
      AppMethodBeat.o(276684);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(276655);
    Log.i("MicroMsg.ChatTabPresenter", "onBackPressed");
    b.hX(this.wry);
    AppMethodBeat.o(276655);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276644);
    Log.i("MicroMsg.ChatTabPresenter", "onDestroy");
    this.wry.unregisterReceiver(this.IVv);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.IVw);
    IListenerMStorage.b(kp.class.getName(), this.IVx);
    this.Ipg.dead();
    b.hX(this.wry);
    AppMethodBeat.o(276644);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(276651);
    Object localObject = this.wry;
    int i = h.a.HSF;
    ((MMActivity)localObject).overridePendingTransition(i, i);
    Log.i("MicroMsg.ChatTabPresenter", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(276651);
      return;
    }
    this.wry.setIntent(paramIntent);
    localObject = paramIntent.getStringExtra("game_tab_key");
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.IVu != null) {
      this.IVu.jf((String)localObject, paramIntent);
    }
    AppMethodBeat.o(276651);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(276638);
    Log.i("MicroMsg.ChatTabPresenter", "onResume");
    fHF();
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.c.a.yHM, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.ChatTabPresenter", "preload profile");
        com.tencent.threadpool.h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276612);
            if ((a.this.wry.isDestroyed()) || (a.this.wry.isFinishing()))
            {
              AppMethodBeat.o(276612);
              return;
            }
            String str = a.this.IVq;
            if (!Util.isNullOrNil(str))
            {
              Log.i("MicroMsg.ChatTabPresenter", "preload url: %s", new Object[] { str });
              py localpy = new py();
              localpy.hTd.type = 3;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str);
              localpy.hTd.intent = localIntent;
              localpy.publish();
            }
            AppMethodBeat.o(276612);
          }
        }, 500L);
      }
      AppMethodBeat.o(276638);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.a
 * JD-Core Version:    0.7.0.1
 */