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
import com.tencent.luggage.h.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.g.a;
import com.tencent.mm.plugin.game.luggage.g.e;
import com.tencent.mm.plugin.game.luggage.g.e.a;
import com.tencent.mm.plugin.game.luggage.g.f.a;
import com.tencent.mm.plugin.game.luggage.g.j;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class LuggageGameWebViewUI
  extends MMSecDataActivity
  implements f.e
{
  protected e xwg;
  private int xwh = -1;
  private boolean xwi = true;
  protected com.tencent.mm.plugin.game.luggage.g.f xwj;
  
  protected void dTl()
  {
    AppMethodBeat.i(186835);
    setContentView(this.xwg.ctl);
    AppMethodBeat.o(186835);
  }
  
  protected void dTn() {}
  
  protected void dTo() {}
  
  protected com.tencent.mm.plugin.game.luggage.g.i g(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(186836);
    String str = paramBundle.getString("float_ball_key");
    boolean bool = paramBundle.getBoolean("float_layer_page", false);
    if (!Util.isNullOrNil(str))
    {
      paramBundle = new com.tencent.mm.plugin.game.luggage.g.i(this.xwg.cts, com.tencent.luggage.d.r.a(getContext(), Integer.valueOf(com.tencent.mm.plugin.webview.luggage.r.aYv(str))), paramBundle);
      AppMethodBeat.o(186836);
      return paramBundle;
    }
    if (bool)
    {
      paramBundle = new a(this.xwg.cts, paramBundle);
      AppMethodBeat.o(186836);
      return paramBundle;
    }
    if (paramBundle.containsKey("game_tab_data"))
    {
      this.xwj = new com.tencent.mm.plugin.game.luggage.g.f(this.xwg.cts, paramBundle);
      dTo();
      paramBundle = this.xwj;
      AppMethodBeat.o(186836);
      return paramBundle;
    }
    paramString = h.aI(getContext(), paramString);
    if (paramString != null)
    {
      paramBundle = new j(this.xwg.cts, paramString, paramBundle);
      AppMethodBeat.o(186836);
      return paramBundle;
    }
    paramBundle = new com.tencent.mm.plugin.game.luggage.g.i(this.xwg.cts, null, paramBundle);
    AppMethodBeat.o(186836);
    return paramBundle;
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
    this.xwg.cto.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(83004);
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(83002);
    e locale = this.xwg;
    com.tencent.luggage.d.h localh = locale.Ln();
    if (localh != null) {
      if (!localh.Lk()) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        dTn();
        finish();
      }
      AppMethodBeat.o(83002);
      return;
      if (locale.ctm.size() > 1) {
        locale.Lo();
      } else {
        i = 0;
      }
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82996);
    super.onCreate(paramBundle);
    boolean bool1 = getIntent().getBooleanExtra("from_shortcut", false);
    boolean bool2 = getIntent().getBooleanExtra("from_game_tab", false);
    if (!bool1) {
      if (Util.isNullOrNil(getIntent().getStringExtra("float_ball_key"))) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!bool2)) {
        overridePendingTransition(MMFragmentActivity.a.OHB, MMFragmentActivity.a.OHC);
      }
      AppBrandMainProcessService.a(new ActiveMainProcessTask());
      Log.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()) });
      paramBundle = getIntent().getStringExtra("rawUrl");
      if (!Util.isNullOrNil(paramBundle)) {
        break;
      }
      Log.e("MicroMsg.LuggageGameWebViewUI", "url is null");
      AppMethodBeat.o(82996);
      return;
    }
    if (((q)com.tencent.mm.kernel.g.af(q.class)).Vt())
    {
      getIntent().putExtra("rawUrl", "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode");
      paramBundle = "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
    }
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.Fd(paramBundle);
    localGameWebPerformanceInfo.url = paramBundle;
    localGameWebPerformanceInfo.hhE = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    localGameWebPerformanceInfo.hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    localGameWebPerformanceInfo.startTime = getIntent().getLongExtra("start_time", localGameWebPerformanceInfo.hhF);
    localGameWebPerformanceInfo.hhK = System.currentTimeMillis();
    localGameWebPerformanceInfo.hhv = 1;
    localGameWebPerformanceInfo.hhy = 1;
    Log.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", new Object[] { paramBundle, Long.valueOf(localGameWebPerformanceInfo.startTime), Long.valueOf(localGameWebPerformanceInfo.hhE), Long.valueOf(localGameWebPerformanceInfo.hhF), Long.valueOf(localGameWebPerformanceInfo.hhK) });
    com.tencent.mm.plugin.webview.ui.tools.game.g.baJ(paramBundle);
    com.tencent.mm.plugin.webview.ui.tools.game.g.bC(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.g.bB(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.g.bK(paramBundle, localGameWebPerformanceInfo.startTime);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    this.xwg = new e(this);
    dTl();
    this.xwg.xxP = new e.a()
    {
      public final boolean Lw()
      {
        AppMethodBeat.i(186832);
        if (LuggageGameWebViewUI.this.xwj != null)
        {
          com.tencent.mm.plugin.game.luggage.g.f localf = LuggageGameWebViewUI.this.xwj;
          if (localf.xxS != null)
          {
            boolean bool = localf.xxS.Lw();
            AppMethodBeat.o(186832);
            return bool;
          }
          AppMethodBeat.o(186832);
          return true;
        }
        AppMethodBeat.o(186832);
        return true;
      }
      
      public final void dTp()
      {
        AppMethodBeat.i(186830);
        if (LuggageGameWebViewUI.this.xwj != null) {
          LuggageGameWebViewUI.this.xwj.setPageChanging(true);
        }
        AppMethodBeat.o(186830);
      }
      
      public final void dTq()
      {
        AppMethodBeat.i(186831);
        if (LuggageGameWebViewUI.this.xwj != null) {
          LuggageGameWebViewUI.this.xwj.setPageChanging(false);
        }
        AppMethodBeat.o(186831);
      }
    };
    this.xwg.a(new m()
    {
      public final com.tencent.luggage.d.h k(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(186833);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", new Object[] { Long.valueOf(l) });
        paramAnonymousBundle.putInt("minimize_secene", 3);
        Object localObject = paramAnonymousBundle.getString("float_ball_key");
        boolean bool = paramAnonymousBundle.getBoolean("float_layer_page", false);
        if ((LuggageGameWebViewUI.a(LuggageGameWebViewUI.this)) || (bool) || (!Util.isNullOrNil((String)localObject)) || (LuggageGameWebViewUI.azC(paramAnonymousString))) {}
        for (localObject = GameWebPerformanceInfo.Fd(paramAnonymousString);; localObject = GameWebPerformanceInfo.Fe(paramAnonymousString))
        {
          if (Util.isNullOrNil(((GameWebPerformanceInfo)localObject).url))
          {
            Log.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", new Object[] { paramAnonymousString });
            ((GameWebPerformanceInfo)localObject).url = paramAnonymousString;
            ((GameWebPerformanceInfo)localObject).hhK = l;
            ((GameWebPerformanceInfo)localObject).hhF = l;
            ((GameWebPerformanceInfo)localObject).startTime = l;
            ((GameWebPerformanceInfo)localObject).hhv = 1;
          }
          ((GameWebPerformanceInfo)localObject).hhM = l;
          if (!bool) {
            LuggageGameWebViewUI.b(LuggageGameWebViewUI.this);
          }
          paramAnonymousString = LuggageGameWebViewUI.this.g(paramAnonymousBundle, paramAnonymousString);
          AppMethodBeat.o(186833);
          return paramAnonymousString;
          com.tencent.mm.plugin.webview.ui.tools.game.g.baJ(paramAnonymousString);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bC(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bB(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bK(paramAnonymousString, l);
        }
      }
    });
    Object localObject1 = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
    if (localObject1 != null)
    {
      localObject1 = ((GameWebViewLaunchParams)localObject1).xvZ;
      if (localObject1 != null)
      {
        Object localObject2 = GameWebPerformanceInfo.Fd(((GameFloatLayerInfo)localObject1).url);
        ((GameWebPerformanceInfo)localObject2).url = ((GameFloatLayerInfo)localObject1).url;
        ((GameWebPerformanceInfo)localObject2).hhE = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        ((GameWebPerformanceInfo)localObject2).hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ((GameWebPerformanceInfo)localObject2).startTime = getIntent().getLongExtra("start_time", ((GameWebPerformanceInfo)localObject2).hhF);
        ((GameWebPerformanceInfo)localObject2).hhK = System.currentTimeMillis();
        ((GameWebPerformanceInfo)localObject2).hhv = 1;
        ((GameWebPerformanceInfo)localObject2).hhy = 1;
        com.tencent.mm.plugin.webview.ui.tools.game.g.bC(((GameFloatLayerInfo)localObject1).url, System.currentTimeMillis());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("rawUrl", ((GameFloatLayerInfo)localObject1).url);
        ((Bundle)localObject2).putBoolean("show_full_screen", ((GameFloatLayerInfo)localObject1).xvW);
        ((Bundle)localObject2).putInt("screen_orientation", ((GameFloatLayerInfo)localObject1).orientation);
        ((Bundle)localObject2).putBoolean("float_layer_page", true);
        ((Bundle)localObject2).putBoolean("needAnimation", false);
        ((Bundle)localObject2).putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
        ((Bundle)localObject2).putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
        this.xwg.a(((GameFloatLayerInfo)localObject1).url, (Bundle)localObject2, false);
        i = 1;
        if (i == 0) {
          break label781;
        }
        localGameWebPerformanceInfo.hhC = 1;
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
            e locale = LuggageGameWebViewUI.this.xwg;
            String str = paramBundle;
            Bundle localBundle = LuggageGameWebViewUI.this.getIntent().getExtras();
            com.tencent.luggage.d.h localh = locale.ctp.k(str, localBundle);
            if (localh == null)
            {
              Log.e("LuggagePageContainer", "No page specified for url %s", new Object[] { str });
              AppMethodBeat.o(170128);
              return;
            }
            locale.ctl.addView(localh.getContentView(), 0);
            locale.ctm.add(localh);
            localh.g(str, localBundle);
            localh.Li();
            locale.Lp();
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
            AppMethodBeat.i(186834);
            Intent localIntent = new Intent();
            localIntent.putExtra("from_scene", 3);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(LuggageGameWebViewUI.this, localIntent, null);
            AppMethodBeat.o(186834);
          }
        }, 300L);
      }
      f.cyc();
      AppMethodBeat.o(82996);
      return;
      i = 0;
      break;
      label781:
      this.xwg.h(paramBundle, getIntent().getExtras());
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
    e.xwe = null;
    e.mHeaders = null;
    e.Nh = 0L;
    this.xwg.destroy();
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
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
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
    Object localObject = this.xwg.Ln();
    if (localObject != null) {
      ((com.tencent.luggage.d.h)localObject).Lj();
    }
    if (this.xwj != null)
    {
      localObject = this.xwj;
      Log.i("MicroMsg.GameTabWebPage", "computeFcp()");
      localObject = ((com.tencent.mm.plugin.game.luggage.g.f)localObject).xxQ.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.game.luggage.g.i locali = (com.tencent.mm.plugin.game.luggage.g.i)((Iterator)localObject).next();
        if (locali != null) {
          locali.at(null);
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
    this.xwg.onResume();
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
    if (this.xwh != -1)
    {
      setRequestedOrientation(this.xwh);
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
    AppMethodBeat.i(186837);
    if (!getIntent().getBooleanExtra("disable_game_tab_home_swipe", false))
    {
      AppMethodBeat.o(186837);
      return true;
    }
    AppMethodBeat.o(186837);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */