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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebTabUI
  extends LuggageGameWebViewUI
  implements e.a
{
  private int omK;
  private GameTabWidget2 uEU;
  private BroadcastReceiver uEX;
  private String uFE;
  private GameTabData2 uFF;
  
  public GameWebTabUI()
  {
    AppMethodBeat.i(195764);
    this.omK = 0;
    this.uEX = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(195759);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameWebTabUI.this != null) && (!GameWebTabUI.this.isFinishing()))
        {
          ae.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
          GameWebTabUI.this.finish();
        }
        AppMethodBeat.o(195759);
      }
    };
    AppMethodBeat.o(195764);
  }
  
  private void a(GameTabData2.TabItem paramTabItem)
  {
    AppMethodBeat.i(195769);
    if ((paramTabItem == null) || (this.uek == null))
    {
      AppMethodBeat.o(195769);
      return;
    }
    com.tencent.mm.plugin.game.luggage.f.d locald = this.uek;
    String str1 = paramTabItem.upi;
    String str2 = paramTabItem.jumpUrl;
    if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)) || (locald.ufF.containsKey(str1)) || (locald.ufI == null)) {}
    for (;;)
    {
      ae.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s]", new Object[] { paramTabItem.upi, paramTabItem.jumpUrl });
      AppMethodBeat.o(195769);
      return;
      ae.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", new Object[] { str1, str2 });
      Bundle localBundle = new Bundle();
      localBundle.putAll(locald.mParams);
      localBundle.putString("rawUrl", str2);
      com.tencent.mm.plugin.game.luggage.f.g localg = new com.tencent.mm.plugin.game.luggage.f.g(locald.chm, null, localBundle);
      if (localg.eSQ() != null) {
        localg.eSQ().eTj();
      }
      localg.ugE = locald;
      locald.a(localg, str1);
      locald.ufI.addView(localg.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
      localg.g(str2, localBundle);
      locald.ufF.put(str1, localg);
    }
  }
  
  public final boolean Fx()
  {
    AppMethodBeat.i(195766);
    a.fE(this);
    AppMethodBeat.o(195766);
    return true;
  }
  
  public final void cZJ()
  {
    AppMethodBeat.i(195767);
    a.fE(this);
    AppMethodBeat.o(195767);
  }
  
  public final void cZK()
  {
    AppMethodBeat.i(195768);
    super.cZK();
    if (this.uek != null) {
      this.uek.ufH = new d.a()
      {
        public final void HX(final int paramAnonymousInt)
        {
          AppMethodBeat.i(195754);
          ae.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195753);
              if (paramAnonymousInt == 0)
              {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(8);
                AppMethodBeat.o(195753);
                return;
              }
              if (paramAnonymousInt == 1) {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(0);
              }
              AppMethodBeat.o(195753);
            }
          });
          AppMethodBeat.o(195754);
        }
        
        public final void HY(int paramAnonymousInt)
        {
          AppMethodBeat.i(195756);
          ae.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (GameWebTabUI.a(GameWebTabUI.this) == null)
          {
            AppMethodBeat.o(195756);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(false);
            AppMethodBeat.o(195756);
            return;
          }
          if (paramAnonymousInt == 1) {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(true);
          }
          AppMethodBeat.o(195756);
        }
        
        public final boolean aKK()
        {
          AppMethodBeat.i(224260);
          if (GameWebTabUI.a(GameWebTabUI.this) != null)
          {
            boolean bool = GameWebTabUI.a(GameWebTabUI.this).DRr;
            AppMethodBeat.o(224260);
            return bool;
          }
          AppMethodBeat.o(224260);
          return true;
        }
        
        public final int cZW()
        {
          AppMethodBeat.i(195755);
          int i = GameWebTabUI.a(GameWebTabUI.this).getHeight();
          int j = com.tencent.mm.plugin.appbrand.y.g.vM(i);
          ae.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(195755);
          return j;
        }
        
        public final String cZX()
        {
          AppMethodBeat.i(195757);
          if (GameWebTabUI.b(GameWebTabUI.this) != null)
          {
            String str = GameWebTabUI.b(GameWebTabUI.this).toJson();
            AppMethodBeat.o(195757);
            return str;
          }
          AppMethodBeat.o(195757);
          return "";
        }
        
        public final void setPageChanging(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(195758);
          if (GameWebTabUI.a(GameWebTabUI.this) != null) {
            GameWebTabUI.a(GameWebTabUI.this).setPageChanging(paramAnonymousBoolean);
          }
          AppMethodBeat.o(195758);
        }
      };
    }
    AppMethodBeat.o(195768);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(195772);
    super.onConfigurationChanged(paramConfiguration);
    if (this.omK != paramConfiguration.orientation)
    {
      ae.i("MicroMsg.GameWebTabUI", "orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (this.uEU != null) {
        this.uEU.dcW();
      }
      this.omK = paramConfiguration.orientation;
    }
    AppMethodBeat.o(195772);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(195765);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.GameWebTabUI", "onCreate");
    if (this.ueg == null)
    {
      finish();
      AppMethodBeat.o(195765);
      return;
    }
    this.uEU = a.b(this, this.ueg.chr);
    this.uFF = ((GameTabData2)getIntent().getParcelableExtra("game_tab_data"));
    this.uFE = getIntent().getStringExtra("game_tab_key");
    if (this.uFF != null)
    {
      paramBundle = this.uFF.afz().iterator();
      while (paramBundle.hasNext())
      {
        final GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramBundle.next();
        if ((localTabItem.dvm == 2) && (!bu.isNullOrNil(localTabItem.jumpUrl)) && (!localTabItem.upi.equalsIgnoreCase(this.uFE)) && (!localTabItem.uFl))
        {
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195751);
              if ((GameWebTabUI.this.isFinishing()) || (GameWebTabUI.this.isDestroyed()))
              {
                AppMethodBeat.o(195751);
                return;
              }
              GameWebTabUI.a(GameWebTabUI.this, localTabItem);
              AppMethodBeat.o(195751);
            }
          };
          long l = localTabItem.uFm * 1000;
          this.ueg.chr.postDelayed(local1, l);
        }
      }
    }
    this.ueg.chy.Cj().cqV = this;
    if ((this.ueg.chr instanceof ViewGroup))
    {
      paramBundle = (ViewGroup)this.ueg.chr;
      paramBundle.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(195760);
          if (((paramAnonymousView2.getTag() instanceof String)) && ("game_float_view_tag".equalsIgnoreCase((String)paramAnonymousView2.getTag())))
          {
            int i = paramBundle.indexOfChild(paramAnonymousView2);
            ae.i("MicroMsg.GameWebTabUI", "float page index2:%d", new Object[] { Integer.valueOf(i) });
            if (i >= 0)
            {
              paramBundle.removeView(GameWebTabUI.a(GameWebTabUI.this));
              paramBundle.addView(GameWebTabUI.a(GameWebTabUI.this), i - 1);
            }
          }
          AppMethodBeat.o(195760);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
      int i = paramBundle.indexOfChild(paramBundle.findViewWithTag("game_float_view_tag"));
      ae.i("MicroMsg.GameWebTabUI", "float page index1:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        paramBundle.removeView(this.uEU);
        paramBundle.addView(this.uEU, i);
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.uEX, paramBundle, "com.tencent.mm.permission.MM_MESSAGE", null);
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCInteger(1), GameWebTabUI.a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(195765);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(195771);
    super.onDestroy();
    ae.i("MicroMsg.GameWebTabUI", "onDestroy");
    unregisterReceiver(this.uEX);
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", new IPCInteger(2), GameWebTabUI.a.class, null);
    a.fE(this);
    AppMethodBeat.o(195771);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(195770);
    super.onNewIntent(paramIntent);
    overridePendingTransition(2130772069, 2130772069);
    ae.i("MicroMsg.GameWebTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(195770);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    if (bu.nullAsNil(this.uFE).equalsIgnoreCase(str))
    {
      AppMethodBeat.o(195770);
      return;
    }
    this.uFE = str;
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.uEU != null) {
      this.uEU.hi(str, paramIntent);
    }
    if ((this.uFF == null) || (this.uek == null))
    {
      AppMethodBeat.o(195770);
      return;
    }
    a((GameTabData2.TabItem)this.uFF.uEZ.get(str));
    paramIntent = this.uek;
    com.tencent.mm.plugin.game.luggage.f.g localg;
    if (!bu.isNullOrNil(str))
    {
      localg = (com.tencent.mm.plugin.game.luggage.f.g)paramIntent.ufF.get(str);
      if (localg != null)
      {
        ae.i("MicroMsg.GameTabWebPage", "switch to tab: %s", new Object[] { str });
        if ((!(localg instanceof com.tencent.mm.plugin.game.luggage.f.d)) || (paramIntent.ufJ == null)) {
          break label235;
        }
        paramIntent.ufJ.bringToFront();
      }
    }
    for (;;)
    {
      paramIntent.ufK = localg;
      if (this.uEU != null) {
        this.uEU.bringToFront();
      }
      AppMethodBeat.o(195770);
      return;
      label235:
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