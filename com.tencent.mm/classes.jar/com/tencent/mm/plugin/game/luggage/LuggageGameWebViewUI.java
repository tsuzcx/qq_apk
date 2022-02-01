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
import com.tencent.luggage.d.i;
import com.tencent.luggage.d.i.a;
import com.tencent.luggage.d.m;
import com.tencent.luggage.h.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.f.a;
import com.tencent.mm.plugin.game.luggage.f.c.a;
import com.tencent.mm.plugin.game.luggage.f.d;
import com.tencent.mm.plugin.game.luggage.f.d.a;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.lang.reflect.Field;

public class LuggageGameWebViewUI
  extends MMActivity
  implements e.e
{
  protected com.tencent.mm.plugin.game.luggage.f.c ueg;
  private int uei = -1;
  private boolean uej = true;
  protected d uek;
  
  protected void cZJ() {}
  
  protected void cZK() {}
  
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
    this.ueg.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(83004);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(83002);
    if (!this.ueg.onBackPressed())
    {
      cZJ();
      finish();
    }
    AppMethodBeat.o(83002);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82996);
    super.onCreate(paramBundle);
    boolean bool1 = getIntent().getBooleanExtra("from_shortcut", false);
    boolean bool2 = getIntent().getBooleanExtra("from_game_tab", false);
    if (!bool1) {
      if (bu.isNullOrNil(getIntent().getStringExtra("float_ball_key"))) {
        break label151;
      }
    }
    label151:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!bool2)) {
        overridePendingTransition(MMFragmentActivity.a.Jxh, MMFragmentActivity.a.Jxi);
      }
      AppBrandMainProcessService.a(new ActiveMainProcessTask());
      ae.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()) });
      paramBundle = getIntent().getStringExtra("rawUrl");
      if (!bu.isNullOrNil(paramBundle)) {
        break;
      }
      ae.e("MicroMsg.LuggageGameWebViewUI", "url is null");
      AppMethodBeat.o(82996);
      return;
    }
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wP(paramBundle);
    localGameWebPerformanceInfo.url = paramBundle;
    localGameWebPerformanceInfo.guP = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    localGameWebPerformanceInfo.guQ = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    localGameWebPerformanceInfo.startTime = getIntent().getLongExtra("start_time", localGameWebPerformanceInfo.guQ);
    localGameWebPerformanceInfo.guV = System.currentTimeMillis();
    localGameWebPerformanceInfo.guG = 1;
    localGameWebPerformanceInfo.guJ = 1;
    ae.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", new Object[] { paramBundle, Long.valueOf(localGameWebPerformanceInfo.startTime), Long.valueOf(localGameWebPerformanceInfo.guP), Long.valueOf(localGameWebPerformanceInfo.guQ), Long.valueOf(localGameWebPerformanceInfo.guV) });
    com.tencent.mm.plugin.webview.ui.tools.game.g.aKv(paramBundle);
    com.tencent.mm.plugin.webview.ui.tools.game.g.bB(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.g.bA(paramBundle, System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.game.g.bJ(paramBundle, localGameWebPerformanceInfo.startTime);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    this.ueg = new com.tencent.mm.plugin.game.luggage.f.c(this);
    setContentView(this.ueg.chr);
    this.ueg.ufE = new c.a()
    {
      public final boolean aKK()
      {
        AppMethodBeat.i(224256);
        if (LuggageGameWebViewUI.this.uek != null)
        {
          d locald = LuggageGameWebViewUI.this.uek;
          if (locald.ufH != null)
          {
            boolean bool = locald.ufH.aKK();
            AppMethodBeat.o(224256);
            return bool;
          }
          AppMethodBeat.o(224256);
          return true;
        }
        AppMethodBeat.o(224256);
        return true;
      }
      
      public final void cZL()
      {
        AppMethodBeat.i(192976);
        if (LuggageGameWebViewUI.this.uek != null) {
          LuggageGameWebViewUI.this.uek.setPageChanging(true);
        }
        AppMethodBeat.o(192976);
      }
      
      public final void cZM()
      {
        AppMethodBeat.i(192977);
        if (LuggageGameWebViewUI.this.uek != null) {
          LuggageGameWebViewUI.this.uek.setPageChanging(false);
        }
        AppMethodBeat.o(192977);
      }
    };
    this.ueg.a(new m()
    {
      public final com.tencent.luggage.d.h k(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(192978);
        long l = System.currentTimeMillis();
        ae.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", new Object[] { Long.valueOf(l) });
        paramAnonymousBundle.putInt("minimize_secene", 3);
        String str = paramAnonymousBundle.getString("float_ball_key");
        boolean bool = paramAnonymousBundle.getBoolean("float_layer_page", false);
        if ((LuggageGameWebViewUI.a(LuggageGameWebViewUI.this)) || (bool) || (!bu.isNullOrNil(str)) || (LuggageGameWebViewUI.amq(paramAnonymousString))) {}
        for (GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.wP(paramAnonymousString);; localGameWebPerformanceInfo = GameWebPerformanceInfo.wQ(paramAnonymousString))
        {
          if (bu.isNullOrNil(localGameWebPerformanceInfo.url))
          {
            ae.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", new Object[] { paramAnonymousString });
            localGameWebPerformanceInfo.url = paramAnonymousString;
            localGameWebPerformanceInfo.guV = l;
            localGameWebPerformanceInfo.guQ = l;
            localGameWebPerformanceInfo.startTime = l;
            localGameWebPerformanceInfo.guG = 1;
          }
          localGameWebPerformanceInfo.guX = l;
          if (!bool) {
            LuggageGameWebViewUI.b(LuggageGameWebViewUI.this);
          }
          if (bu.isNullOrNil(str)) {
            break;
          }
          paramAnonymousString = new com.tencent.mm.plugin.game.luggage.f.g(LuggageGameWebViewUI.this.ueg.chy, com.tencent.luggage.d.r.a(LuggageGameWebViewUI.this.getContext(), Integer.valueOf(com.tencent.mm.plugin.webview.luggage.r.aIt(str))), paramAnonymousBundle);
          AppMethodBeat.o(192978);
          return paramAnonymousString;
          com.tencent.mm.plugin.webview.ui.tools.game.g.aKv(paramAnonymousString);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bB(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bA(paramAnonymousString, l);
          com.tencent.mm.plugin.webview.ui.tools.game.g.bJ(paramAnonymousString, l);
        }
        if (bool)
        {
          paramAnonymousString = new a(LuggageGameWebViewUI.this.ueg.chy, paramAnonymousBundle);
          AppMethodBeat.o(192978);
          return paramAnonymousString;
        }
        if (paramAnonymousBundle.containsKey("game_tab_data"))
        {
          LuggageGameWebViewUI.this.uek = new d(LuggageGameWebViewUI.this.ueg.chy, paramAnonymousBundle);
          LuggageGameWebViewUI.this.cZK();
          paramAnonymousString = LuggageGameWebViewUI.this.uek;
          AppMethodBeat.o(192978);
          return paramAnonymousString;
        }
        paramAnonymousString = h.av(LuggageGameWebViewUI.this.getContext(), paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = new com.tencent.mm.plugin.game.luggage.f.h(LuggageGameWebViewUI.this.ueg.chy, paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(192978);
          return paramAnonymousString;
        }
        paramAnonymousString = new com.tencent.mm.plugin.game.luggage.f.g(LuggageGameWebViewUI.this.ueg.chy, null, paramAnonymousBundle);
        AppMethodBeat.o(192978);
        return paramAnonymousString;
      }
    });
    Object localObject1 = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
    if (localObject1 != null)
    {
      localObject1 = ((GameWebViewLaunchParams)localObject1).uec;
      if (localObject1 != null)
      {
        Object localObject2 = GameWebPerformanceInfo.wP(((GameFloatLayerInfo)localObject1).url);
        ((GameWebPerformanceInfo)localObject2).url = ((GameFloatLayerInfo)localObject1).url;
        ((GameWebPerformanceInfo)localObject2).guP = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        ((GameWebPerformanceInfo)localObject2).guQ = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ((GameWebPerformanceInfo)localObject2).startTime = getIntent().getLongExtra("start_time", ((GameWebPerformanceInfo)localObject2).guQ);
        ((GameWebPerformanceInfo)localObject2).guV = System.currentTimeMillis();
        ((GameWebPerformanceInfo)localObject2).guG = 1;
        ((GameWebPerformanceInfo)localObject2).guJ = 1;
        com.tencent.mm.plugin.webview.ui.tools.game.g.bB(((GameFloatLayerInfo)localObject1).url, System.currentTimeMillis());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("rawUrl", ((GameFloatLayerInfo)localObject1).url);
        ((Bundle)localObject2).putBoolean("show_full_screen", ((GameFloatLayerInfo)localObject1).uea);
        ((Bundle)localObject2).putInt("screen_orientation", ((GameFloatLayerInfo)localObject1).orientation);
        ((Bundle)localObject2).putBoolean("float_layer_page", true);
        ((Bundle)localObject2).putBoolean("needAnimation", false);
        ((Bundle)localObject2).putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
        ((Bundle)localObject2).putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
        this.ueg.a(((GameFloatLayerInfo)localObject1).url, (Bundle)localObject2, false);
        i = 1;
        if (i == 0) {
          break label744;
        }
        localGameWebPerformanceInfo.guN = 1;
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
            com.tencent.mm.plugin.game.luggage.f.c localc = LuggageGameWebViewUI.this.ueg;
            String str = paramBundle;
            Bundle localBundle = LuggageGameWebViewUI.this.getIntent().getExtras();
            com.tencent.luggage.d.h localh = localc.chv.k(str, localBundle);
            if (localh == null)
            {
              ae.e("LuggagePageContainer", "No page specified for url %s", new Object[] { str });
              AppMethodBeat.o(170128);
              return;
            }
            localc.chr.addView(localh.getContentView(), 0);
            localc.chs.add(localh);
            localh.g(str, localBundle);
            localh.BT();
            localc.BZ();
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
            AppMethodBeat.i(192979);
            Intent localIntent = new Intent();
            localIntent.putExtra("from_scene", 3);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(LuggageGameWebViewUI.this, localIntent, null);
            AppMethodBeat.o(192979);
          }
        }, 300L);
      }
      f.cal();
      AppMethodBeat.o(82996);
      return;
      i = 0;
      break;
      label744:
      this.ueg.h(paramBundle, getIntent().getExtras());
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
    ae.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
    e.uee = null;
    e.mHeaders = null;
    e.MX = 0L;
    this.ueg.destroy();
    com.tencent.mm.plugin.wepkg.event.c.clear();
    ae.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      ae.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
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
          ae.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
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
    ae.i("MicroMsg.LuggageGameWebViewUI", "onPause");
    hideVKB();
    this.ueg.onPause();
    AppMethodBeat.o(83000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(82999);
    super.onResume();
    ae.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
    this.ueg.onResume();
    AppMethodBeat.o(82999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(83003);
    AppMethodBeat.at(this, paramBoolean);
    ae.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis()) });
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(83003);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(83005);
    if (this.uei != -1)
    {
      setRequestedOrientation(this.uei);
      AppMethodBeat.o(83005);
      return;
    }
    this.landscapeMode = getSharedPreferences(ak.fow(), 4).getBoolean("settings_landscape_mode", false);
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
    AppMethodBeat.i(192980);
    if (!getIntent().getBooleanExtra("disable_game_tab_home_swipe", false))
    {
      AppMethodBeat.o(192980);
      return true;
    }
    AppMethodBeat.o(192980);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */