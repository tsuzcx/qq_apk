package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebTabUI
  extends LuggageGameWebViewUI
  implements com.tencent.luggage.k.f.a
{
  private static com.tencent.mm.ipcinvoker.f<Bundle> Dcp;
  private GameTabWidget2 Dbg;
  private BroadcastReceiver Dbh;
  private String Dcm;
  private GameTabData2 Dcn;
  private boolean Dco;
  private IListener Dcq;
  private int sJy;
  
  static
  {
    AppMethodBeat.i(198858);
    Dcp = new com.tencent.mm.ipcinvoker.f() {};
    AppMethodBeat.o(198858);
  }
  
  public GameWebTabUI()
  {
    AppMethodBeat.i(198791);
    this.sJy = 0;
    this.Dco = true;
    this.Dbh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(197598);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameWebTabUI.this != null) && (!GameWebTabUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
          GameWebTabUI.this.finish();
        }
        AppMethodBeat.o(197598);
      }
    };
    this.Dcq = new IListener() {};
    AppMethodBeat.o(198791);
  }
  
  private void a(GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(198820);
    if ((paramTabItem == null) || (this.CAe == null))
    {
      AppMethodBeat.o(198820);
      return;
    }
    com.tencent.mm.plugin.game.luggage.g.f localf = this.CAe;
    String str1 = paramTabItem.CLE;
    String str2 = paramTabItem.jumpUrl;
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (localf.CCa.containsKey(str1)) || (localf.CCd == null)) {}
    for (;;)
    {
      Log.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s, isPreload:%b]", new Object[] { paramTabItem.CLE, paramTabItem.jumpUrl, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(198820);
      return;
      Log.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", new Object[] { str1, str2 });
      Bundle localBundle = new Bundle();
      localBundle.putAll(localf.mParams);
      localBundle.putString("rawUrl", str2);
      com.tencent.mm.plugin.game.luggage.g.i locali = new com.tencent.mm.plugin.game.luggage.g.i(localf.crm, null, localBundle);
      if (locali.gUx() != null) {
        locali.gUx().gUS();
      }
      locali.CDb = localf;
      locali.CDc = paramBoolean;
      if ((localf.tmY != null) && (localf.tmY.isPaused()) && (paramBoolean))
      {
        locali.CDe = true;
        Log.i("MicroMsg.GameTabWebPage", "mockFetchFcp, url:%s", new Object[] { str2 });
      }
      localf.a(locali, str1);
      localf.CCd.addView(locali.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
      locali.l(str2, localBundle);
      localf.CCa.put(str1, locali);
    }
  }
  
  public final boolean SF()
  {
    AppMethodBeat.i(198803);
    b.gE(this);
    AppMethodBeat.o(198803);
    return true;
  }
  
  public final void ewx()
  {
    AppMethodBeat.i(198804);
    b.gE(this);
    AppMethodBeat.o(198804);
  }
  
  public final void ewy()
  {
    AppMethodBeat.i(198807);
    super.ewy();
    if (this.CAe != null) {
      this.CAe.CCc = new com.tencent.mm.plugin.game.luggage.g.f.a()
      {
        public final boolean Om()
        {
          AppMethodBeat.i(209557);
          if (GameWebTabUI.a(GameWebTabUI.this) != null)
          {
            boolean bool = GameWebTabUI.a(GameWebTabUI.this).DbX;
            AppMethodBeat.o(209557);
            return bool;
          }
          AppMethodBeat.o(209557);
          return true;
        }
        
        public final void Tt(final int paramAnonymousInt)
        {
          AppMethodBeat.i(209547);
          Log.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204293);
              if (paramAnonymousInt == 0)
              {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(8);
                AppMethodBeat.o(204293);
                return;
              }
              if (paramAnonymousInt == 1) {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(0);
              }
              AppMethodBeat.o(204293);
            }
          });
          AppMethodBeat.o(209547);
        }
        
        public final void Tu(int paramAnonymousInt)
        {
          AppMethodBeat.i(209551);
          Log.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (GameWebTabUI.a(GameWebTabUI.this) == null)
          {
            AppMethodBeat.o(209551);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(false);
            AppMethodBeat.o(209551);
            return;
          }
          if (paramAnonymousInt == 1) {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(true);
          }
          AppMethodBeat.o(209551);
        }
        
        public final int ewN()
        {
          AppMethodBeat.i(209548);
          int i = GameWebTabUI.a(GameWebTabUI.this).getHeight();
          int j = g.Dg(i);
          Log.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(209548);
          return j;
        }
        
        public final String ewO()
        {
          AppMethodBeat.i(209554);
          if (GameWebTabUI.b(GameWebTabUI.this) != null)
          {
            String str = GameWebTabUI.b(GameWebTabUI.this).toJson();
            AppMethodBeat.o(209554);
            return str;
          }
          AppMethodBeat.o(209554);
          return "";
        }
        
        public final void setPageChanging(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(209555);
          if (GameWebTabUI.a(GameWebTabUI.this) != null) {
            GameWebTabUI.a(GameWebTabUI.this).setPageChanging(paramAnonymousBoolean);
          }
          AppMethodBeat.o(209555);
        }
      };
    }
    AppMethodBeat.o(198807);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(198846);
    super.onConfigurationChanged(paramConfiguration);
    if (this.sJy != paramConfiguration.orientation)
    {
      Log.i("MicroMsg.GameWebTabUI", "orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (this.Dbg != null) {
        this.Dbg.ezM();
      }
      this.sJy = paramConfiguration.orientation;
    }
    AppMethodBeat.o(198846);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(198800);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameWebTabUI", "onCreate");
    if (this.CAb == null)
    {
      finish();
      AppMethodBeat.o(198800);
      return;
    }
    this.Dbg = b.b(this, this.CAb.crr);
    this.Dcn = ((GameTabData2)getIntent().getParcelableExtra("game_tab_data"));
    this.Dcm = getIntent().getStringExtra("game_tab_key");
    if (this.Dcn != null)
    {
      paramBundle = this.Dcn.aCj().iterator();
      while (paramBundle.hasNext())
      {
        final GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramBundle.next();
        if ((localTabItem.fEH == 2) && (!Util.isNullOrNil(localTabItem.jumpUrl)) && (!localTabItem.CLE.equalsIgnoreCase(this.Dcm)) && (!localTabItem.DbP))
        {
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210009);
              if ((GameWebTabUI.this.isFinishing()) || (GameWebTabUI.this.isDestroyed()))
              {
                AppMethodBeat.o(210009);
                return;
              }
              GameWebTabUI.a(GameWebTabUI.this, localTabItem);
              AppMethodBeat.o(210009);
            }
          };
          long l = localTabItem.DbQ * 1000;
          this.CAb.crr.postDelayed(local1, l);
        }
      }
    }
    this.CAb.cry.Oq().cDU = this;
    if ((this.CAb.crr instanceof ViewGroup))
    {
      paramBundle = (ViewGroup)this.CAb.crr;
      paramBundle.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(191157);
          if (((paramAnonymousView2.getTag() instanceof String)) && ("game_float_view_tag".equalsIgnoreCase((String)paramAnonymousView2.getTag())))
          {
            int i = paramBundle.indexOfChild(paramAnonymousView2);
            Log.i("MicroMsg.GameWebTabUI", "float page index2:%d", new Object[] { Integer.valueOf(i) });
            if (i >= 0)
            {
              paramBundle.removeView(GameWebTabUI.a(GameWebTabUI.this));
              paramBundle.addView(GameWebTabUI.a(GameWebTabUI.this), i - 1);
            }
          }
          AppMethodBeat.o(191157);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
      int i = paramBundle.indexOfChild(paramBundle.findViewWithTag("game_float_view_tag"));
      Log.i("MicroMsg.GameWebTabUI", "float page index1:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        paramBundle.removeView(this.Dbg);
        paramBundle.addView(this.Dbg, i);
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.Dbh, paramBundle, com.tencent.mm.plugin.game.a.CfL, null);
    EventCenter.instance.addListener(this.Dcq);
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(1), a.class, Dcp);
    AppMethodBeat.o(198800);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198843);
    super.onDestroy();
    Log.i("MicroMsg.GameWebTabUI", "onDestroy");
    unregisterReceiver(this.Dbh);
    EventCenter.instance.removeListener(this.Dcq);
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(2), a.class, null);
    b.gE(this);
    AppMethodBeat.o(198843);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(198835);
    super.onNewIntent(paramIntent);
    int i = g.a.Cgw;
    overridePendingTransition(i, i);
    Log.i("MicroMsg.GameWebTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(198835);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    if (Util.nullAsNil(this.Dcm).equalsIgnoreCase(str))
    {
      AppMethodBeat.o(198835);
      return;
    }
    this.Dcm = str;
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.Dbg != null) {
      this.Dbg.hY(str, paramIntent);
    }
    if ((this.Dcn == null) || (this.CAe == null))
    {
      AppMethodBeat.o(198835);
      return;
    }
    a((GameTabData2.TabItem)this.Dcn.DbC.get(str), false);
    paramIntent = this.CAe;
    com.tencent.mm.plugin.game.luggage.g.i locali;
    if (!Util.isNullOrNil(str))
    {
      locali = (com.tencent.mm.plugin.game.luggage.g.i)paramIntent.CCa.get(str);
      if (locali != null)
      {
        Log.i("MicroMsg.GameTabWebPage", "switch to tab: %s", new Object[] { str });
        if ((!(locali instanceof com.tencent.mm.plugin.game.luggage.g.f)) || (paramIntent.CCe == null)) {
          break label240;
        }
        paramIntent.CCe.bringToFront();
      }
    }
    for (;;)
    {
      paramIntent.CCf = locali;
      if (this.Dbg != null) {
        this.Dbg.bringToFront();
      }
      AppMethodBeat.o(198835);
      return;
      label240:
      locali.mContentView.bringToFront();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(198839);
    super.onResume();
    if (!this.Dco) {
      com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(3), a.class, Dcp);
    }
    this.Dco = false;
    AppMethodBeat.o(198839);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static class a
    implements d<IPCInteger, Bundle>
  {
    private MStorage.IOnStorageChange Dbi;
    private com.tencent.mm.pluginsdk.d.a Dbj;
    private com.tencent.mm.ipcinvoker.f<Bundle> Dcw;
    
    private a()
    {
      AppMethodBeat.i(196094);
      this.Dbi = new MStorage.IOnStorageChange()
      {
        public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
        {
          AppMethodBeat.i(194724);
          if (((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null)) {
            GameWebTabUI.a.a(GameWebTabUI.a.this).aH(GameWebTabUI.a.ezO());
          }
          AppMethodBeat.o(194724);
        }
      };
      this.Dbj = new com.tencent.mm.pluginsdk.d.a()
      {
        public final void g(IEvent paramAnonymousIEvent)
        {
          AppMethodBeat.i(191062);
          if (((paramAnonymousIEvent instanceof jo)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null)) {
            GameWebTabUI.a.a(GameWebTabUI.a.this).aH(GameWebTabUI.a.ezO());
          }
          AppMethodBeat.o(191062);
        }
      };
      AppMethodBeat.o(196094);
    }
    
    private static Bundle ezN()
    {
      AppMethodBeat.i(196099);
      int i = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).eAi();
      int j = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(1);
      int k = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.c.class)).Tn(2);
      Bundle localBundle = new Bundle();
      localBundle.putInt("msg_unread_count", i + j);
      localBundle.putInt("notify_unread_count", k);
      AppMethodBeat.o(196099);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI
 * JD-Core Version:    0.7.0.1
 */