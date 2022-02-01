package com.tencent.mm.plugin.game.luggage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.d.i.a;
import com.tencent.luggage.d.m;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.game.luggage.page.a;
import com.tencent.mm.plugin.game.luggage.page.e.a;
import com.tencent.mm.plugin.game.luggage.page.f.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class LuggageGameWebViewUI
  extends MMSecDataActivity
  implements e.e
{
  private boolean AXE = true;
  protected com.tencent.mm.plugin.game.luggage.page.e ItM;
  private int ItN = -1;
  protected com.tencent.mm.plugin.game.luggage.page.f ItO;
  
  protected void fEo()
  {
    AppMethodBeat.i(276949);
    setContentView(this.ItM.ejj);
    AppMethodBeat.o(276949);
  }
  
  protected void fEr() {}
  
  protected void fEs() {}
  
  protected GameWebPage g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(276956);
    String str = paramBundle.getString("float_ball_key");
    boolean bool = paramBundle.getBoolean("float_layer_page", false);
    if (!Util.isNullOrNil(str))
    {
      paramBundle = new GameWebPage(this.ItM.ejq, com.tencent.luggage.d.r.a(getContext(), Integer.valueOf(s.bka(str))), paramBundle);
      AppMethodBeat.o(276956);
      return paramBundle;
    }
    if (bool)
    {
      paramBundle = new a(this.ItM.ejq, paramBundle);
      AppMethodBeat.o(276956);
      return paramBundle;
    }
    if (paramBundle.containsKey("game_tab_data"))
    {
      this.ItO = new com.tencent.mm.plugin.game.luggage.page.f(this.ItM.ejq, paramBundle);
      fEs();
      paramBundle = this.ItO;
      AppMethodBeat.o(276956);
      return paramBundle;
    }
    paramString = h.aT(getContext(), paramString);
    if (paramString != null)
    {
      paramBundle = new com.tencent.mm.plugin.game.luggage.page.i(this.ItM.ejq, paramString, paramBundle);
      AppMethodBeat.o(276956);
      return paramBundle;
    }
    paramBundle = new GameWebPage(this.ItM.ejq, null, paramBundle);
    AppMethodBeat.o(276956);
    return paramBundle;
  }
  
  public int getForceOrientation()
  {
    return this.ItN;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(82997);
    fixStatusbar(false);
    super.initSwipeBack();
    AppMethodBeat.o(82997);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(83004);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.ItM.ejm.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(83004);
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(83002);
    com.tencent.mm.plugin.game.luggage.page.e locale = this.ItM;
    com.tencent.luggage.d.h localh = locale.aol();
    if (localh != null) {
      if (!localh.aoj()) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        fEr();
        finish();
      }
      AppMethodBeat.o(83002);
      return;
      if (locale.ejk.size() > 1) {
        locale.aom();
      } else {
        i = 0;
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82996);
    super.onCreate(paramBundle);
    this.ItN = getIntent().getIntExtra("screen_orientation", -1);
    boolean bool1 = getIntent().getBooleanExtra("from_shortcut", false);
    boolean bool2 = getIntent().getBooleanExtra("from_game_tab", false);
    if (!bool1) {
      if (Util.isNullOrNil(getIntent().getStringExtra("float_ball_key"))) {
        break label191;
      }
    }
    label191:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!bool2)) {
        overridePendingTransition(MMFragmentActivity.a.adFr, MMFragmentActivity.a.adFs);
      }
      if (getIntent().getBooleanExtra("game_from_detail_back", false)) {
        overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
      }
      new ActiveMainProcessTask().bQt();
      Log.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()) });
      paramBundle = getIntent().getStringExtra("rawUrl");
      if (!Util.isNullOrNil(paramBundle)) {
        break;
      }
      Log.e("MicroMsg.LuggageGameWebViewUI", "url is null");
      AppMethodBeat.o(82996);
      return;
    }
    if (((com.tencent.mm.api.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.r.class)).aBu())
    {
      getIntent().putExtra("rawUrl", "https://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode");
      paramBundle = "https://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
    }
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.EI(paramBundle);
    localGameWebPerformanceInfo.url = paramBundle;
    localGameWebPerformanceInfo.mtU = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    localGameWebPerformanceInfo.mtV = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    localGameWebPerformanceInfo.startTime = getIntent().getLongExtra("start_time", localGameWebPerformanceInfo.mtV);
    localGameWebPerformanceInfo.mua = System.currentTimeMillis();
    localGameWebPerformanceInfo.mtL = 1;
    localGameWebPerformanceInfo.mtO = 1;
    Log.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", new Object[] { paramBundle, Long.valueOf(localGameWebPerformanceInfo.startTime), Long.valueOf(localGameWebPerformanceInfo.mtU), Long.valueOf(localGameWebPerformanceInfo.mtV), Long.valueOf(localGameWebPerformanceInfo.mua) });
    com.tencent.mm.plugin.webview.ui.tools.game.h.bml(paramBundle);
    com.tencent.mm.plugin.webview.ui.tools.game.h.bU(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.h.bT(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.h.cc(paramBundle, localGameWebPerformanceInfo.startTime);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    this.ItM = new com.tencent.mm.plugin.game.luggage.page.e(this);
    fEo();
    this.ItM.IvO = new e.a()
    {
      public final boolean aou()
      {
        AppMethodBeat.i(276932);
        if (LuggageGameWebViewUI.this.ItO != null)
        {
          com.tencent.mm.plugin.game.luggage.page.f localf = LuggageGameWebViewUI.this.ItO;
          if (localf.IvR != null)
          {
            boolean bool = localf.IvR.aou();
            AppMethodBeat.o(276932);
            return bool;
          }
          AppMethodBeat.o(276932);
          return true;
        }
        AppMethodBeat.o(276932);
        return true;
      }
      
      public final void fEt()
      {
        AppMethodBeat.i(276927);
        if (LuggageGameWebViewUI.this.ItO != null) {
          LuggageGameWebViewUI.this.ItO.setPageChanging(true);
        }
        AppMethodBeat.o(276927);
      }
      
      public final void fEu()
      {
        AppMethodBeat.i(276929);
        if (LuggageGameWebViewUI.this.ItO != null) {
          LuggageGameWebViewUI.this.ItO.setPageChanging(false);
        }
        AppMethodBeat.o(276929);
      }
    };
    this.ItM.a(new m()
    {
      public final com.tencent.luggage.d.h p(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(276934);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", new Object[] { Long.valueOf(l) });
        paramAnonymousBundle.putInt("minimize_secene", 3);
        Object localObject = paramAnonymousBundle.getString("float_ball_key");
        boolean bool = paramAnonymousBundle.getBoolean("float_layer_page", false);
        if ((LuggageGameWebViewUI.a(LuggageGameWebViewUI.this)) || (bool) || (!Util.isNullOrNil((String)localObject)) || (LuggageGameWebViewUI.aFY(paramAnonymousString))) {}
        for (localObject = GameWebPerformanceInfo.EI(paramAnonymousString);; localObject = GameWebPerformanceInfo.EJ(paramAnonymousString))
        {
          if (Util.isNullOrNil(((GameWebPerformanceInfo)localObject).url))
          {
            Log.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", new Object[] { paramAnonymousString });
            ((GameWebPerformanceInfo)localObject).url = paramAnonymousString;
            ((GameWebPerformanceInfo)localObject).mua = l;
            ((GameWebPerformanceInfo)localObject).mtV = l;
            ((GameWebPerformanceInfo)localObject).startTime = l;
            ((GameWebPerformanceInfo)localObject).mtL = 1;
          }
          ((GameWebPerformanceInfo)localObject).muc = l;
          if (!bool) {
            LuggageGameWebViewUI.b(LuggageGameWebViewUI.this);
          }
          paramAnonymousString = LuggageGameWebViewUI.this.g(paramAnonymousBundle, paramAnonymousString);
          AppMethodBeat.o(276934);
          return paramAnonymousString;
          com.tencent.mm.plugin.webview.ui.tools.game.h.bml(paramAnonymousString);
          com.tencent.mm.plugin.webview.ui.tools.game.h.bU(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.h.bT(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.h.cc(paramAnonymousString, l);
        }
      }
    });
    Object localObject1 = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
    if (localObject1 != null)
    {
      localObject1 = ((GameWebViewLaunchParams)localObject1).ItE;
      if (localObject1 != null)
      {
        Object localObject2 = GameWebPerformanceInfo.EI(((GameFloatLayerInfo)localObject1).url);
        ((GameWebPerformanceInfo)localObject2).url = ((GameFloatLayerInfo)localObject1).url;
        ((GameWebPerformanceInfo)localObject2).mtU = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        ((GameWebPerformanceInfo)localObject2).mtV = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ((GameWebPerformanceInfo)localObject2).startTime = getIntent().getLongExtra("start_time", ((GameWebPerformanceInfo)localObject2).mtV);
        ((GameWebPerformanceInfo)localObject2).mua = System.currentTimeMillis();
        ((GameWebPerformanceInfo)localObject2).mtL = 1;
        ((GameWebPerformanceInfo)localObject2).mtO = 1;
        com.tencent.mm.plugin.webview.ui.tools.game.h.bU(((GameFloatLayerInfo)localObject1).url, System.currentTimeMillis());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("rawUrl", ((GameFloatLayerInfo)localObject1).url);
        ((Bundle)localObject2).putBoolean("show_full_screen", ((GameFloatLayerInfo)localObject1).ItB);
        ((Bundle)localObject2).putInt("screen_orientation", ((GameFloatLayerInfo)localObject1).orientation);
        ((Bundle)localObject2).putBoolean("float_layer_page", true);
        ((Bundle)localObject2).putBoolean("needAnimation", false);
        ((Bundle)localObject2).putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
        ((Bundle)localObject2).putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
        this.ItM.a(((GameFloatLayerInfo)localObject1).url, (Bundle)localObject2, false);
        i = 1;
        if (i == 0) {
          break label820;
        }
        localGameWebPerformanceInfo.mtS = 1;
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(170128);
            if ((LuggageGameWebViewUI.this.isFinishing()) || (LuggageGameWebViewUI.this.activityHasDestroyed()))
            {
              AppMethodBeat.o(170128);
              return;
            }
            com.tencent.mm.plugin.game.luggage.page.e locale = LuggageGameWebViewUI.this.ItM;
            String str = paramBundle;
            Bundle localBundle = LuggageGameWebViewUI.this.getIntent().getExtras();
            com.tencent.luggage.d.h localh = locale.ejn.p(str, localBundle);
            if (localh == null)
            {
              Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { str });
              AppMethodBeat.o(170128);
              return;
            }
            locale.ejj.addView(localh.getContentView(), 0);
            locale.ejk.add(localh);
            localh.l(str, localBundle);
            localh.aoh();
            locale.aon();
            AppMethodBeat.o(170128);
          }
        }, 300L);
      }
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_download_floagt_ball_shutdown_entrance", false)) {
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276928);
            Intent localIntent = new Intent();
            localIntent.putExtra("from_scene", 3);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).a(LuggageGameWebViewUI.this, localIntent, null);
            AppMethodBeat.o(276928);
          }
        }, 300L);
      }
      f.dqb();
      AppMethodBeat.o(82996);
      return;
      i = 0;
      break;
      label820:
      this.ItM.m(paramBundle, getIntent().getExtras());
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(82998);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    supportRequestWindowFeature(9);
    AppMethodBeat.o(82998);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(83001);
    super.onDestroy();
    Log.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
    e.ItK = null;
    e.mHeaders = null;
    e.dX = 0L;
    this.ItM.destroy();
    com.tencent.mm.plugin.wepkg.event.c.clear();
    Log.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      Log.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
      i = 0;
    }
    for (;;)
    {
      if (i < 3)
      {
        Object localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
        try
        {
          localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
          if (!((Field)localObject1).isAccessible()) {
            ((Field)localObject1).setAccessible(true);
          }
          Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
          if ((localObject2 == null) || (!(localObject2 instanceof View))) {
            break label234;
          }
          localObject2 = (View)localObject2;
          if ((((View)localObject2).getContext() instanceof ContextWrapper))
          {
            if (((ContextWrapper)((View)localObject2).getContext()).getBaseContext() == this) {
              ((Field)localObject1).set(localInputMethodManager, null);
            }
          }
          else if (((View)localObject2).getContext() == this) {
            ((Field)localObject1).set(localInputMethodManager, null);
          }
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
          break label234;
        }
      }
      System.gc();
      f.remove();
      AppMethodBeat.o(83001);
      return;
      label234:
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(83000);
    super.onPause();
    Log.i("MicroMsg.LuggageGameWebViewUI", "onPause");
    hideVKB();
    Object localObject = this.ItM.aol();
    if (localObject != null) {
      ((com.tencent.luggage.d.h)localObject).aoi();
    }
    if (this.ItO != null)
    {
      localObject = this.ItO;
      Log.i("MicroMsg.GameTabWebPage", "computeFcp()");
      localObject = ((com.tencent.mm.plugin.game.luggage.page.f)localObject).IvP.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameWebPage localGameWebPage = (GameWebPage)((Iterator)localObject).next();
        if (localGameWebPage != null) {
          localGameWebPage.aI(null);
        }
      }
    }
    AppMethodBeat.o(83000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(82999);
    super.onResume();
    Log.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
    this.ItM.onResume();
    AppMethodBeat.o(82999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(83003);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis()) });
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(83003);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(83005);
    if (this.ItN != -1)
    {
      setRequestedOrientation(this.ItN);
      AppMethodBeat.o(83005);
      return;
    }
    this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      setRequestedOrientation(-1);
      AppMethodBeat.o(83005);
      return;
    }
    setRequestedOrientation(1);
    AppMethodBeat.o(83005);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(276976);
    if (!getIntent().getBooleanExtra("disable_game_page_swipe", false))
    {
      AppMethodBeat.o(276976);
      return true;
    }
    AppMethodBeat.o(276976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */