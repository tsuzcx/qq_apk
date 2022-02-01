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
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.f.a;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.m;
import com.tencent.luggage.h.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.lang.reflect.Field;

public class LuggageGameWebViewUI
  extends MMActivity
  implements e.d
{
  private com.tencent.mm.plugin.game.luggage.d.c sWH;
  private int sWI = -1;
  private boolean sWJ = true;
  
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
    this.sWH.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(83004);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(83002);
    if (!this.sWH.onBackPressed()) {
      finish();
    }
    AppMethodBeat.o(83002);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82996);
    super.onCreate(paramBundle);
    if (!getIntent().getBooleanExtra("from_shortcut", false)) {
      if (bs.isNullOrNil(getIntent().getStringExtra("float_ball_key"))) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        overridePendingTransition(MMFragmentActivity.a.HoR, MMFragmentActivity.a.HoS);
      }
      AppBrandMainProcessService.a(new ActiveMainProcessTask());
      ac.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()) });
      paramBundle = getIntent().getStringExtra("rawUrl");
      if (!bs.isNullOrNil(paramBundle)) {
        break;
      }
      ac.e("MicroMsg.LuggageGameWebViewUI", "url is null");
      AppMethodBeat.o(82996);
      return;
    }
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.tq(paramBundle);
    localGameWebPerformanceInfo.url = paramBundle;
    localGameWebPerformanceInfo.fYS = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    localGameWebPerformanceInfo.fYT = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    localGameWebPerformanceInfo.startTime = getIntent().getLongExtra("start_time", localGameWebPerformanceInfo.fYT);
    localGameWebPerformanceInfo.fYY = System.currentTimeMillis();
    localGameWebPerformanceInfo.fYJ = 1;
    localGameWebPerformanceInfo.fYM = 1;
    ac.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", new Object[] { paramBundle, Long.valueOf(localGameWebPerformanceInfo.startTime), Long.valueOf(localGameWebPerformanceInfo.fYS), Long.valueOf(localGameWebPerformanceInfo.fYT), Long.valueOf(localGameWebPerformanceInfo.fYY) });
    h.aDB(paramBundle);
    h.bx(paramBundle, System.currentTimeMillis());
    h.bw(paramBundle, System.currentTimeMillis());
    h.bF(paramBundle, localGameWebPerformanceInfo.startTime);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    this.sWH = new com.tencent.mm.plugin.game.luggage.d.c(this);
    setContentView(this.sWH.bXb);
    this.sWH.a(new j()
    {
      public final e k(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(82994);
        long l = System.currentTimeMillis();
        ac.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", new Object[] { Long.valueOf(l) });
        paramAnonymousBundle.putInt("minimize_secene", 3);
        String str = paramAnonymousBundle.getString("float_ball_key");
        boolean bool = paramAnonymousBundle.getBoolean("float_layer_page", false);
        if ((LuggageGameWebViewUI.a(LuggageGameWebViewUI.this)) || (bool) || (!bs.isNullOrNil(str)) || (LuggageGameWebViewUI.agV(paramAnonymousString))) {}
        for (GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.tq(paramAnonymousString);; localGameWebPerformanceInfo = GameWebPerformanceInfo.tr(paramAnonymousString))
        {
          if (bs.isNullOrNil(localGameWebPerformanceInfo.url))
          {
            ac.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", new Object[] { paramAnonymousString });
            localGameWebPerformanceInfo.url = paramAnonymousString;
            localGameWebPerformanceInfo.fYY = l;
            localGameWebPerformanceInfo.fYT = l;
            localGameWebPerformanceInfo.startTime = l;
            localGameWebPerformanceInfo.fYJ = 1;
          }
          localGameWebPerformanceInfo.fZa = l;
          if (!bool) {
            LuggageGameWebViewUI.b(LuggageGameWebViewUI.this);
          }
          if (bs.isNullOrNil(str)) {
            break;
          }
          paramAnonymousString = new com.tencent.mm.plugin.game.luggage.d.f(LuggageGameWebViewUI.c(LuggageGameWebViewUI.this).bXi, m.a(LuggageGameWebViewUI.this.getContext(), Integer.valueOf(q.aBB(str))), paramAnonymousBundle);
          AppMethodBeat.o(82994);
          return paramAnonymousString;
          h.aDB(paramAnonymousString);
          h.bx(paramAnonymousString, l);
          h.bw(paramAnonymousString, l);
          h.bF(paramAnonymousString, l);
        }
        if (bool)
        {
          paramAnonymousString = new a(LuggageGameWebViewUI.c(LuggageGameWebViewUI.this).bXi, paramAnonymousBundle);
          AppMethodBeat.o(82994);
          return paramAnonymousString;
        }
        paramAnonymousString = f.ar(LuggageGameWebViewUI.this.getContext(), paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = new com.tencent.mm.plugin.game.luggage.d.g(LuggageGameWebViewUI.c(LuggageGameWebViewUI.this).bXi, paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(82994);
          return paramAnonymousString;
        }
        paramAnonymousString = new com.tencent.mm.plugin.game.luggage.d.f(LuggageGameWebViewUI.c(LuggageGameWebViewUI.this).bXi, null, paramAnonymousBundle);
        AppMethodBeat.o(82994);
        return paramAnonymousString;
      }
    });
    Object localObject1 = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
    if (localObject1 != null)
    {
      localObject1 = ((GameWebViewLaunchParams)localObject1).sWE;
      if (localObject1 != null)
      {
        Object localObject2 = GameWebPerformanceInfo.tq(((GameFloatLayerInfo)localObject1).url);
        ((GameWebPerformanceInfo)localObject2).url = ((GameFloatLayerInfo)localObject1).url;
        ((GameWebPerformanceInfo)localObject2).fYS = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        ((GameWebPerformanceInfo)localObject2).fYT = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ((GameWebPerformanceInfo)localObject2).startTime = getIntent().getLongExtra("start_time", ((GameWebPerformanceInfo)localObject2).fYT);
        ((GameWebPerformanceInfo)localObject2).fYY = System.currentTimeMillis();
        ((GameWebPerformanceInfo)localObject2).fYJ = 1;
        ((GameWebPerformanceInfo)localObject2).fYM = 1;
        h.bx(((GameFloatLayerInfo)localObject1).url, System.currentTimeMillis());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("rawUrl", ((GameFloatLayerInfo)localObject1).url);
        ((Bundle)localObject2).putBoolean("show_full_screen", ((GameFloatLayerInfo)localObject1).sWB);
        ((Bundle)localObject2).putInt("screen_orientation", ((GameFloatLayerInfo)localObject1).orientation);
        ((Bundle)localObject2).putBoolean("float_layer_page", true);
        ((Bundle)localObject2).putBoolean("needAnimation", false);
        ((Bundle)localObject2).putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
        ((Bundle)localObject2).putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
        this.sWH.a(((GameFloatLayerInfo)localObject1).url, (Bundle)localObject2, false);
        i = 1;
        if (i == 0) {
          break label691;
        }
        localGameWebPerformanceInfo.fYQ = 1;
        new Handler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(82995);
            if ((LuggageGameWebViewUI.this.isFinishing()) || (LuggageGameWebViewUI.this.activityHasDestroyed()))
            {
              AppMethodBeat.o(82995);
              return;
            }
            com.tencent.mm.plugin.game.luggage.d.c localc = LuggageGameWebViewUI.c(LuggageGameWebViewUI.this);
            String str = paramBundle;
            Bundle localBundle = LuggageGameWebViewUI.this.getIntent().getExtras();
            e locale = localc.bXf.k(str, localBundle);
            localc.bXb.addView(locale.getContentView(), 0);
            localc.bXc.add(locale);
            locale.g(str, localBundle);
            locale.At();
            localc.Az();
            AppMethodBeat.o(82995);
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
            AppMethodBeat.i(170128);
            Intent localIntent = new Intent();
            localIntent.putExtra("from_scene", 3);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(LuggageGameWebViewUI.this, localIntent, null);
            AppMethodBeat.o(170128);
          }
        }, 300L);
      }
      AppMethodBeat.o(82996);
      return;
      i = 0;
      break;
      label691:
      this.sWH.h(paramBundle, getIntent().getExtras());
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
    ac.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
    d.sWG = null;
    d.mHeaders = null;
    d.Lf = 0L;
    this.sWH.destroy();
    com.tencent.mm.plugin.wepkg.event.c.clear();
    ac.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      ac.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
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
            break label231;
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
          ac.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      AppMethodBeat.o(83001);
      return;
      label231:
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(83000);
    super.onPause();
    ac.i("MicroMsg.LuggageGameWebViewUI", "onPause");
    hideVKB();
    this.sWH.onPause();
    AppMethodBeat.o(83000);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(82999);
    super.onResume();
    ac.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
    this.sWH.onResume();
    AppMethodBeat.o(82999);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(83003);
    ac.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis()) });
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(83003);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(83005);
    if (this.sWI != -1)
    {
      setRequestedOrientation(this.sWI);
      AppMethodBeat.o(83005);
      return;
    }
    this.landscapeMode = getSharedPreferences(ai.eUX(), 4).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      setRequestedOrientation(-1);
      AppMethodBeat.o(83005);
      return;
    }
    setRequestedOrientation(1);
    AppMethodBeat.o(83005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */