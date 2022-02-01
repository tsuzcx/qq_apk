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
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.game.luggage.g.f;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebTabUI
  extends LuggageGameWebViewUI
  implements com.tencent.luggage.h.f.a
{
  private int pzw;
  private GameTabWidget2 xWR;
  private BroadcastReceiver xWV;
  private String xXH;
  private GameTabData2 xXI;
  private boolean xXJ;
  private d<Bundle> xXK;
  
  public GameWebTabUI()
  {
    AppMethodBeat.i(204293);
    this.pzw = 0;
    this.xXJ = true;
    this.xXK = new d() {};
    this.xWV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(204285);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameWebTabUI.this != null) && (!GameWebTabUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
          GameWebTabUI.this.finish();
        }
        AppMethodBeat.o(204285);
      }
    };
    AppMethodBeat.o(204293);
  }
  
  private void a(GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(204298);
    if ((paramTabItem == null) || (this.xwj == null))
    {
      AppMethodBeat.o(204298);
      return;
    }
    f localf = this.xwj;
    String str1 = paramTabItem.xHB;
    String str2 = paramTabItem.jumpUrl;
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (localf.xxQ.containsKey(str1)) || (localf.xxT == null)) {}
    for (;;)
    {
      Log.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s, isPreload:%b]", new Object[] { paramTabItem.xHB, paramTabItem.jumpUrl, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(204298);
      return;
      Log.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", new Object[] { str1, str2 });
      Bundle localBundle = new Bundle();
      localBundle.putAll(localf.mParams);
      localBundle.putString("rawUrl", str2);
      com.tencent.mm.plugin.game.luggage.g.i locali = new com.tencent.mm.plugin.game.luggage.g.i(localf.ctg, null, localBundle);
      if (locali.gbC() != null) {
        locali.gbC().gbW();
      }
      locali.xyT = localf;
      locali.xyU = paramBoolean;
      if ((localf.pQZ != null) && (localf.pQZ.isPaused()))
      {
        locali.xyW = true;
        Log.i("MicroMsg.GameTabWebPage", "mockFetchFcp, isPreload:%b, url:%s", new Object[] { Boolean.valueOf(paramBoolean), str2 });
      }
      localf.a(locali, str1);
      localf.xxT.addView(locali.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
      locali.g(str2, localBundle);
      localf.xxQ.put(str1, locali);
    }
  }
  
  public final boolean Pg()
  {
    AppMethodBeat.i(204295);
    a.gk(this);
    AppMethodBeat.o(204295);
    return true;
  }
  
  public final void dTn()
  {
    AppMethodBeat.i(204296);
    a.gk(this);
    AppMethodBeat.o(204296);
  }
  
  public final void dTo()
  {
    AppMethodBeat.i(204297);
    super.dTo();
    if (this.xwj != null) {
      this.xwj.xxS = new com.tencent.mm.plugin.game.luggage.g.f.a()
      {
        public final boolean Lw()
        {
          AppMethodBeat.i(204284);
          if (GameWebTabUI.a(GameWebTabUI.this) != null)
          {
            boolean bool = GameWebTabUI.a(GameWebTabUI.this).xXs;
            AppMethodBeat.o(204284);
            return bool;
          }
          AppMethodBeat.o(204284);
          return true;
        }
        
        public final void Oa(final int paramAnonymousInt)
        {
          AppMethodBeat.i(204279);
          Log.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204278);
              if (paramAnonymousInt == 0)
              {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(8);
                AppMethodBeat.o(204278);
                return;
              }
              if (paramAnonymousInt == 1) {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(0);
              }
              AppMethodBeat.o(204278);
            }
          });
          AppMethodBeat.o(204279);
        }
        
        public final void Ob(int paramAnonymousInt)
        {
          AppMethodBeat.i(204281);
          Log.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (GameWebTabUI.a(GameWebTabUI.this) == null)
          {
            AppMethodBeat.o(204281);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(false);
            AppMethodBeat.o(204281);
            return;
          }
          if (paramAnonymousInt == 1) {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(true);
          }
          AppMethodBeat.o(204281);
        }
        
        public final int dTE()
        {
          AppMethodBeat.i(204280);
          int i = GameWebTabUI.a(GameWebTabUI.this).getHeight();
          int j = g.zB(i);
          Log.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(204280);
          return j;
        }
        
        public final String dTF()
        {
          AppMethodBeat.i(204282);
          if (GameWebTabUI.b(GameWebTabUI.this) != null)
          {
            String str = GameWebTabUI.b(GameWebTabUI.this).toJson();
            AppMethodBeat.o(204282);
            return str;
          }
          AppMethodBeat.o(204282);
          return "";
        }
        
        public final void setPageChanging(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(204283);
          if (GameWebTabUI.a(GameWebTabUI.this) != null) {
            GameWebTabUI.a(GameWebTabUI.this).setPageChanging(paramAnonymousBoolean);
          }
          AppMethodBeat.o(204283);
        }
      };
    }
    AppMethodBeat.o(204297);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(204302);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pzw != paramConfiguration.orientation)
    {
      Log.i("MicroMsg.GameWebTabUI", "orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (this.xWR != null) {
        this.xWR.dWE();
      }
      this.pzw = paramConfiguration.orientation;
    }
    AppMethodBeat.o(204302);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(204294);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameWebTabUI", "onCreate");
    if (this.xwg == null)
    {
      finish();
      AppMethodBeat.o(204294);
      return;
    }
    this.xWR = a.b(this, this.xwg.ctl);
    this.xXI = ((GameTabData2)getIntent().getParcelableExtra("game_tab_data"));
    this.xXH = getIntent().getStringExtra("game_tab_key");
    if (this.xXI != null)
    {
      paramBundle = this.xXI.avn().iterator();
      while (paramBundle.hasNext())
      {
        final GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramBundle.next();
        if ((localTabItem.dLS == 2) && (!Util.isNullOrNil(localTabItem.jumpUrl)) && (!localTabItem.xHB.equalsIgnoreCase(this.xXH)) && (!localTabItem.xXk))
        {
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204276);
              if ((GameWebTabUI.this.isFinishing()) || (GameWebTabUI.this.isDestroyed()))
              {
                AppMethodBeat.o(204276);
                return;
              }
              GameWebTabUI.a(GameWebTabUI.this, localTabItem);
              AppMethodBeat.o(204276);
            }
          };
          long l = localTabItem.xXl * 1000;
          this.xwg.ctl.postDelayed(local1, l);
        }
      }
    }
    this.xwg.cts.LA().cDn = this;
    if ((this.xwg.ctl instanceof ViewGroup))
    {
      paramBundle = (ViewGroup)this.xwg.ctl;
      paramBundle.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(204286);
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
          AppMethodBeat.o(204286);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
      int i = paramBundle.indexOfChild(paramBundle.findViewWithTag("game_float_view_tag"));
      Log.i("MicroMsg.GameWebTabUI", "float page index1:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        paramBundle.removeView(this.xWR);
        paramBundle.addView(this.xWR, i);
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.xWV, paramBundle, com.tencent.mm.plugin.game.a.xtn, null);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCInteger(1), GameWebTabUI.a.class, this.xXK);
    AppMethodBeat.o(204294);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(204301);
    super.onDestroy();
    Log.i("MicroMsg.GameWebTabUI", "onDestroy");
    unregisterReceiver(this.xWV);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCInteger(2), GameWebTabUI.a.class, null);
    a.gk(this);
    AppMethodBeat.o(204301);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(204299);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772082, 2130772082);
    Log.i("MicroMsg.GameWebTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(204299);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    if (Util.nullAsNil(this.xXH).equalsIgnoreCase(str))
    {
      AppMethodBeat.o(204299);
      return;
    }
    this.xXH = str;
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.xWR != null) {
      this.xWR.hP(str, paramIntent);
    }
    if ((this.xXI == null) || (this.xwj == null))
    {
      AppMethodBeat.o(204299);
      return;
    }
    a((GameTabData2.TabItem)this.xXI.xWX.get(str), false);
    paramIntent = this.xwj;
    com.tencent.mm.plugin.game.luggage.g.i locali;
    if (!Util.isNullOrNil(str))
    {
      locali = (com.tencent.mm.plugin.game.luggage.g.i)paramIntent.xxQ.get(str);
      if (locali != null)
      {
        Log.i("MicroMsg.GameTabWebPage", "switch to tab: %s", new Object[] { str });
        if ((!(locali instanceof f)) || (paramIntent.xxU == null)) {
          break label236;
        }
        paramIntent.xxU.bringToFront();
      }
    }
    for (;;)
    {
      paramIntent.xxV = locali;
      if (this.xWR != null) {
        this.xWR.bringToFront();
      }
      AppMethodBeat.o(204299);
      return;
      label236:
      locali.mContentView.bringToFront();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(204300);
    super.onResume();
    if (!this.xXJ) {
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCInteger(3), GameWebTabUI.a.class, this.xXK);
    }
    this.xXJ = false;
    AppMethodBeat.o(204300);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI
 * JD-Core Version:    0.7.0.1
 */