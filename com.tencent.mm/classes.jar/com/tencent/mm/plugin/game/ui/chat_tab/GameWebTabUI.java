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
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.game.luggage.f.d.a;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebTabUI
  extends LuggageGameWebViewUI
  implements e.a
{
  private int ogL;
  private GameTabWidget2 utB;
  private BroadcastReceiver utE;
  private String uui;
  private GameTabData2 uuj;
  
  public GameWebTabUI()
  {
    AppMethodBeat.i(206940);
    this.ogL = 0;
    this.utE = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(206935);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameWebTabUI.this != null) && (!GameWebTabUI.this.isFinishing()))
        {
          ad.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
          GameWebTabUI.this.finish();
        }
        AppMethodBeat.o(206935);
      }
    };
    AppMethodBeat.o(206940);
  }
  
  private void a(GameTabData2.TabItem paramTabItem)
  {
    AppMethodBeat.i(206945);
    if ((paramTabItem == null) || (this.tTs == null))
    {
      AppMethodBeat.o(206945);
      return;
    }
    com.tencent.mm.plugin.game.luggage.f.d locald = this.tTs;
    String str1 = paramTabItem.uea;
    String str2 = paramTabItem.jumpUrl;
    if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)) || (locald.tUL.containsKey(str1)) || (locald.tUO == null)) {}
    for (;;)
    {
      ad.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s]", new Object[] { paramTabItem.uea, paramTabItem.jumpUrl });
      AppMethodBeat.o(206945);
      return;
      ad.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", new Object[] { str1, str2 });
      Bundle localBundle = new Bundle();
      localBundle.putAll(locald.mParams);
      localBundle.putString("rawUrl", str2);
      com.tencent.mm.plugin.game.luggage.f.g localg = new com.tencent.mm.plugin.game.luggage.f.g(locald.chm, null, localBundle);
      if (localg.ePe() != null) {
        localg.ePe().ePx();
      }
      localg.tVG = locald;
      locald.a(localg, str1);
      locald.tUO.addView(localg.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
      localg.g(str2, localBundle);
      locald.tUL.put(str1, localg);
    }
  }
  
  public final boolean Fr()
  {
    AppMethodBeat.i(206942);
    a.fz(this);
    AppMethodBeat.o(206942);
    return true;
  }
  
  public final void cXc()
  {
    AppMethodBeat.i(206943);
    a.fz(this);
    AppMethodBeat.o(206943);
  }
  
  public final void cXd()
  {
    AppMethodBeat.i(206944);
    super.cXd();
    if (this.tTs != null) {
      this.tTs.tUN = new d.a()
      {
        public final void HA(final int paramAnonymousInt)
        {
          AppMethodBeat.i(206931);
          ad.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(206930);
              if (paramAnonymousInt == 0)
              {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(8);
                AppMethodBeat.o(206930);
                return;
              }
              if (paramAnonymousInt == 1) {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(0);
              }
              AppMethodBeat.o(206930);
            }
          });
          AppMethodBeat.o(206931);
        }
        
        public final void HB(int paramAnonymousInt)
        {
          AppMethodBeat.i(206933);
          ad.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 0)
          {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(false);
            AppMethodBeat.o(206933);
            return;
          }
          if (paramAnonymousInt == 1) {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(true);
          }
          AppMethodBeat.o(206933);
        }
        
        public final int cXm()
        {
          AppMethodBeat.i(206932);
          int i = GameWebTabUI.a(GameWebTabUI.this).getHeight();
          int j = com.tencent.mm.plugin.appbrand.z.g.vH(i);
          ad.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(206932);
          return j;
        }
        
        public final String cXn()
        {
          AppMethodBeat.i(206934);
          if (GameWebTabUI.b(GameWebTabUI.this) != null)
          {
            String str = GameWebTabUI.b(GameWebTabUI.this).toJson();
            AppMethodBeat.o(206934);
            return str;
          }
          AppMethodBeat.o(206934);
          return "";
        }
      };
    }
    AppMethodBeat.o(206944);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(206948);
    super.onConfigurationChanged(paramConfiguration);
    if (this.ogL != paramConfiguration.orientation)
    {
      ad.i("MicroMsg.GameWebTabUI", "orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (this.utB != null) {
        this.utB.dal();
      }
      this.ogL = paramConfiguration.orientation;
    }
    AppMethodBeat.o(206948);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(206941);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.GameWebTabUI", "onCreate");
    if (this.tTp == null)
    {
      finish();
      AppMethodBeat.o(206941);
      return;
    }
    this.utB = a.b(this, this.tTp.chr);
    this.uuj = ((GameTabData2)getIntent().getParcelableExtra("game_tab_data"));
    this.uui = getIntent().getStringExtra("game_tab_key");
    if (this.uuj != null)
    {
      paramBundle = this.uuj.afl().iterator();
      while (paramBundle.hasNext())
      {
        final GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramBundle.next();
        if ((localTabItem.duh == 2) && (!bt.isNullOrNil(localTabItem.jumpUrl)) && (!localTabItem.uea.equalsIgnoreCase(this.uui)) && (!localTabItem.utS))
        {
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(206928);
              if ((GameWebTabUI.this.isFinishing()) || (GameWebTabUI.this.isDestroyed()))
              {
                AppMethodBeat.o(206928);
                return;
              }
              GameWebTabUI.a(GameWebTabUI.this, localTabItem);
              AppMethodBeat.o(206928);
            }
          };
          long l = localTabItem.utT * 1000;
          this.tTp.chr.postDelayed(local1, l);
        }
      }
    }
    this.tTp.chy.Cg().cqs = this;
    if ((this.tTp.chr instanceof ViewGroup))
    {
      paramBundle = (ViewGroup)this.tTp.chr;
      paramBundle.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(206936);
          if (((paramAnonymousView2.getTag() instanceof String)) && ("game_float_view_tag".equalsIgnoreCase((String)paramAnonymousView2.getTag())))
          {
            int i = paramBundle.indexOfChild(paramAnonymousView2);
            ad.i("MicroMsg.GameWebTabUI", "float page index2:%d", new Object[] { Integer.valueOf(i) });
            if (i >= 0)
            {
              paramBundle.removeView(GameWebTabUI.a(GameWebTabUI.this));
              paramBundle.addView(GameWebTabUI.a(GameWebTabUI.this), i - 1);
            }
          }
          AppMethodBeat.o(206936);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
      int i = paramBundle.indexOfChild(paramBundle.findViewWithTag("game_float_view_tag"));
      ad.i("MicroMsg.GameWebTabUI", "float page index1:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        paramBundle.removeView(this.utB);
        paramBundle.addView(this.utB, i);
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.utE, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCInteger(1), GameWebTabUI.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(206941);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(206947);
    super.onDestroy();
    ad.i("MicroMsg.GameWebTabUI", "onDestroy");
    unregisterReceiver(this.utE);
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCInteger(2), GameWebTabUI.a.class, null);
    a.fz(this);
    AppMethodBeat.o(206947);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(206946);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772069, 2130772069);
    ad.i("MicroMsg.GameWebTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(206946);
      return;
    }
    setIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("game_tab_key");
    if (bt.nullAsNil(this.uui).equalsIgnoreCase(paramIntent))
    {
      AppMethodBeat.o(206946);
      return;
    }
    this.uui = paramIntent;
    if (this.utB != null) {
      this.utB.amo(paramIntent);
    }
    if ((this.uuj == null) || (this.tTs == null))
    {
      AppMethodBeat.o(206946);
      return;
    }
    a((GameTabData2.TabItem)this.uuj.utG.get(paramIntent));
    com.tencent.mm.plugin.game.luggage.f.d locald = this.tTs;
    com.tencent.mm.plugin.game.luggage.f.g localg;
    if (!bt.isNullOrNil(paramIntent))
    {
      localg = (com.tencent.mm.plugin.game.luggage.f.g)locald.tUL.get(paramIntent);
      if (localg != null)
      {
        ad.i("MicroMsg.GameTabWebPage", "switch to tab: %s", new Object[] { paramIntent });
        if ((!(localg instanceof com.tencent.mm.plugin.game.luggage.f.d)) || (locald.tUP == null)) {
          break label226;
        }
        locald.tUP.bringToFront();
      }
    }
    for (;;)
    {
      locald.tUQ = localg;
      if (this.utB != null) {
        this.utB.bringToFront();
      }
      AppMethodBeat.o(206946);
      return;
      label226:
      localg.mContentView.bringToFront();
    }
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