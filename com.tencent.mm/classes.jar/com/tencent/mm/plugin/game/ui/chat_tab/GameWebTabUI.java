package com.tencent.mm.plugin.game.ui.chat_tab;

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
import androidx.lifecycle.q;
import com.tencent.luggage.d.s;
import com.tencent.luggage.l.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mb;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.a;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.f.a;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameWebTabUI
  extends LuggageGameWebViewUI
  implements e.a
{
  private static com.tencent.mm.ipcinvoker.f<Bundle> IWJ;
  private GameTabWidget2 IVu;
  private BroadcastReceiver IVv;
  private String IWG;
  private GameTabData2 IWH;
  private boolean IWI;
  private IListener IWK;
  private int vPB;
  
  static
  {
    AppMethodBeat.i(276745);
    IWJ = new com.tencent.mm.ipcinvoker.f() {};
    AppMethodBeat.o(276745);
  }
  
  public GameWebTabUI()
  {
    AppMethodBeat.i(276710);
    this.vPB = 0;
    this.IWI = true;
    this.IVv = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(276648);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.game.ACTION_EXIT".equals(paramAnonymousIntent.getAction())) && (GameWebTabUI.this != null) && (!GameWebTabUI.this.isFinishing()))
        {
          Log.i("MicroMsg.GameWebTabUI", "GameWebTabUI exit!");
          GameWebTabUI.this.finish();
        }
        AppMethodBeat.o(276648);
      }
    };
    this.IWK = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(276710);
  }
  
  private void a(GameTabData2.TabItem paramTabItem, boolean paramBoolean)
  {
    AppMethodBeat.i(276725);
    if ((paramTabItem == null) || (this.ItO == null))
    {
      AppMethodBeat.o(276725);
      return;
    }
    com.tencent.mm.plugin.game.luggage.page.f localf = this.ItO;
    String str1 = paramTabItem.IFL;
    String str2 = paramTabItem.jumpUrl;
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (localf.IvP.containsKey(str1)) || (localf.IvS == null)) {}
    for (;;)
    {
      Log.i("MicroMsg.GameWebTabUI", "Preload tabItem[key:%s, url:%s, isPreload:%b]", new Object[] { paramTabItem.IFL, paramTabItem.jumpUrl, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(276725);
      return;
      Log.i("MicroMsg.GameTabWebPage", "insertTabHomeWeb, tabKey:%s, url:%s", new Object[] { str1, str2 });
      Bundle localBundle = new Bundle();
      localBundle.putAll(localf.ejT);
      localBundle.putString("rawUrl", str2);
      GameWebPage localGameWebPage = new GameWebPage(localf.eje, null, localBundle);
      if (localGameWebPage.iuf() != null) {
        localGameWebPage.iuf().iuD();
      }
      localGameWebPage.Ixc = localf;
      localGameWebPage.Ixd = paramBoolean;
      if ((localf.wry != null) && (localf.wry.isPaused()) && (paramBoolean))
      {
        localGameWebPage.Ixf = true;
        Log.i("MicroMsg.GameTabWebPage", "mockFetchFcp, url:%s", new Object[] { str2 });
      }
      localf.a(localGameWebPage, str1);
      localf.IvS.addView(localGameWebPage.mContentView, 0, new FrameLayout.LayoutParams(-1, -1));
      localGameWebPage.l(str2, localBundle);
      localf.IvP.put(str1, localGameWebPage);
    }
  }
  
  public final boolean ati()
  {
    AppMethodBeat.i(276754);
    b.hX(this);
    AppMethodBeat.o(276754);
    return true;
  }
  
  public final void fEr()
  {
    AppMethodBeat.i(276757);
    b.hX(this);
    AppMethodBeat.o(276757);
  }
  
  public final void fEs()
  {
    AppMethodBeat.i(276761);
    super.fEs();
    if (this.ItO != null) {
      this.ItO.IvR = new f.a()
      {
        public final void Xn(final int paramAnonymousInt)
        {
          AppMethodBeat.i(276668);
          Log.i("MicroMsg.GameWebTabUI", "showGameTab, isShowTab:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276715);
              if (paramAnonymousInt == 0)
              {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(8);
                AppMethodBeat.o(276715);
                return;
              }
              if (paramAnonymousInt == 1) {
                GameWebTabUI.a(GameWebTabUI.this).setVisibility(0);
              }
              AppMethodBeat.o(276715);
            }
          });
          AppMethodBeat.o(276668);
        }
        
        public final void Xo(int paramAnonymousInt)
        {
          AppMethodBeat.i(276690);
          Log.i("MicroMsg.GameWebTabUI", "disableTabSwitch, isSwitchEnable:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (GameWebTabUI.a(GameWebTabUI.this) == null)
          {
            AppMethodBeat.o(276690);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(false);
            AppMethodBeat.o(276690);
            return;
          }
          if (paramAnonymousInt == 1) {
            GameWebTabUI.a(GameWebTabUI.this).setTabSwitchEnable(true);
          }
          AppMethodBeat.o(276690);
        }
        
        public final void aGh(String paramAnonymousString)
        {
          AppMethodBeat.i(276736);
          if (GameWebTabUI.a(GameWebTabUI.this) != null)
          {
            GameTabWidget2 localGameTabWidget2 = GameWebTabUI.a(GameWebTabUI.this);
            localGameTabWidget2.post(new GameTabWidget2.2(localGameTabWidget2, paramAnonymousString));
          }
          AppMethodBeat.o(276736);
        }
        
        public final boolean aou()
        {
          AppMethodBeat.i(276727);
          if (GameWebTabUI.a(GameWebTabUI.this) != null)
          {
            boolean bool = GameWebTabUI.a(GameWebTabUI.this).IWq;
            AppMethodBeat.o(276727);
            return bool;
          }
          AppMethodBeat.o(276727);
          return true;
        }
        
        public final int fEF()
        {
          AppMethodBeat.i(276682);
          int i = GameWebTabUI.a(GameWebTabUI.this).getHeight();
          int j = com.tencent.mm.plugin.appbrand.af.i.DA(i);
          Log.i("MicroMsg.GameWebTabUI", "tabHeight:%d, heightInH5:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(276682);
          return j;
        }
        
        public final String fEG()
        {
          AppMethodBeat.i(276704);
          if (GameWebTabUI.b(GameWebTabUI.this) != null)
          {
            String str = GameWebTabUI.b(GameWebTabUI.this).toJson();
            AppMethodBeat.o(276704);
            return str;
          }
          AppMethodBeat.o(276704);
          return "";
        }
        
        public final void setPageChanging(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(276718);
          if (GameWebTabUI.a(GameWebTabUI.this) != null) {
            GameWebTabUI.a(GameWebTabUI.this).setPageChanging(paramAnonymousBoolean);
          }
          AppMethodBeat.o(276718);
        }
      };
    }
    AppMethodBeat.o(276761);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(276773);
    super.onConfigurationChanged(paramConfiguration);
    if (this.vPB != paramConfiguration.orientation)
    {
      Log.i("MicroMsg.GameWebTabUI", "orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (this.IVu != null) {
        this.IVu.fHN();
      }
      this.vPB = paramConfiguration.orientation;
    }
    AppMethodBeat.o(276773);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(276751);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.GameWebTabUI", "onCreate");
    if (this.ItM == null)
    {
      finish();
      AppMethodBeat.o(276751);
      return;
    }
    com.tencent.mm.plugin.game.commlib.e.b.fM(this);
    this.IVu = b.c(this, this.ItM.ejj);
    this.IWH = ((GameTabData2)getIntent().getParcelableExtra("game_tab_data"));
    this.IWG = getIntent().getStringExtra("game_tab_key");
    if (this.IWH != null)
    {
      paramBundle = this.IWH.aVf().iterator();
      while (paramBundle.hasNext())
      {
        final GameTabData2.TabItem localTabItem = (GameTabData2.TabItem)paramBundle.next();
        if ((localTabItem.hJx == 2) && (!Util.isNullOrNil(localTabItem.jumpUrl)) && (!localTabItem.IFL.equalsIgnoreCase(this.IWG)) && (!localTabItem.IWj))
        {
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276654);
              if ((GameWebTabUI.this.isFinishing()) || (GameWebTabUI.this.isDestroyed()))
              {
                AppMethodBeat.o(276654);
                return;
              }
              GameWebTabUI.a(GameWebTabUI.this, localTabItem);
              AppMethodBeat.o(276654);
            }
          };
          long l = localTabItem.IWk * 1000;
          this.ItM.ejj.postDelayed(local1, l);
        }
      }
    }
    this.ItM.ejq.aoy().ewY = this;
    if ((this.ItM.ejj instanceof ViewGroup))
    {
      paramBundle = (ViewGroup)this.ItM.ejj;
      paramBundle.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          AppMethodBeat.i(276646);
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
          AppMethodBeat.o(276646);
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
      int i = paramBundle.indexOfChild(paramBundle.findViewWithTag("game_float_view_tag"));
      Log.i("MicroMsg.GameWebTabUI", "float page index1:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0)
      {
        paramBundle.removeView(this.IVu);
        paramBundle.addView(this.IVu, i);
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mm.game.ACTION_EXIT");
    registerReceiver(this.IVv, paramBundle, a.HRS, null);
    this.IWK.alive();
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(1), GameWebTabUI.a.class, IWJ);
    AppMethodBeat.o(276751);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276770);
    super.onDestroy();
    Log.i("MicroMsg.GameWebTabUI", "onDestroy");
    com.tencent.mm.plugin.game.commlib.e.b.fN(this);
    unregisterReceiver(this.IVv);
    this.IWK.dead();
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(2), GameWebTabUI.a.class, null);
    b.hX(this);
    AppMethodBeat.o(276770);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(276765);
    super.onNewIntent(paramIntent);
    int i = h.a.HSF;
    overridePendingTransition(i, i);
    Log.i("MicroMsg.GameWebTabUI", "onNewIntent");
    if (paramIntent == null)
    {
      AppMethodBeat.o(276765);
      return;
    }
    setIntent(paramIntent);
    String str = paramIntent.getStringExtra("game_tab_key");
    if (Util.nullAsNil(this.IWG).equalsIgnoreCase(str))
    {
      AppMethodBeat.o(276765);
      return;
    }
    this.IWG = str;
    paramIntent = paramIntent.getStringExtra("game_red_dot_tab_key");
    if (this.IVu != null) {
      this.IVu.jf(str, paramIntent);
    }
    if ((this.IWH == null) || (this.ItO == null))
    {
      AppMethodBeat.o(276765);
      return;
    }
    a((GameTabData2.TabItem)this.IWH.IVW.get(str), false);
    paramIntent = this.ItO;
    GameWebPage localGameWebPage;
    if (!Util.isNullOrNil(str))
    {
      localGameWebPage = (GameWebPage)paramIntent.IvP.get(str);
      if (localGameWebPage != null)
      {
        Log.i("MicroMsg.GameTabWebPage", "switch to tab: %s", new Object[] { str });
        if ((!(localGameWebPage instanceof com.tencent.mm.plugin.game.luggage.page.f)) || (paramIntent.IvT == null)) {
          break label240;
        }
        paramIntent.IvT.bringToFront();
      }
    }
    for (;;)
    {
      paramIntent.IvU = localGameWebPage;
      if (this.IVu != null) {
        this.IVu.bringToFront();
      }
      AppMethodBeat.o(276765);
      return;
      label240:
      localGameWebPage.mContentView.bringToFront();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(276768);
    super.onResume();
    if (!this.IWI) {
      com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, new IPCInteger(3), GameWebTabUI.a.class, IWJ);
    }
    this.IWI = false;
    AppMethodBeat.o(276768);
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