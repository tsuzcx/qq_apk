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
import com.tencent.luggage.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.lang.reflect.Field;

public class LuggageGameWebViewUI
  extends MMActivity
{
  private com.tencent.mm.plugin.game.luggage.d.c njk;
  private int njl = -1;
  private boolean njm = true;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(135812);
    fixStatusbar(false);
    super.initSwipeBack();
    AppMethodBeat.o(135812);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(135819);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.njk.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(135819);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(135817);
    if (!this.njk.onBackPressed()) {
      finish();
    }
    AppMethodBeat.o(135817);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(135811);
    super.onCreate(paramBundle);
    overridePendingTransition(MMFragmentActivity.a.zcb, MMFragmentActivity.a.zcc);
    AppBrandMainProcessService.a(new ActiveMainProcessTask());
    ab.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", new Object[] { Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()) });
    paramBundle = getIntent().getStringExtra("rawUrl");
    if (bo.isNullOrNil(paramBundle))
    {
      ab.e("MicroMsg.LuggageGameWebViewUI", "url is null");
      AppMethodBeat.o(135811);
      return;
    }
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.lN(paramBundle);
    localGameWebPerformanceInfo.url = paramBundle;
    localGameWebPerformanceInfo.ezZ = getIntent().getLongExtra("gamecenterui_createtime", 0L);
    localGameWebPerformanceInfo.eAa = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
    localGameWebPerformanceInfo.startTime = getIntent().getLongExtra("start_time", localGameWebPerformanceInfo.eAa);
    localGameWebPerformanceInfo.eAf = System.currentTimeMillis();
    localGameWebPerformanceInfo.ezQ = 1;
    localGameWebPerformanceInfo.ezT = 1;
    ab.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", new Object[] { paramBundle, Long.valueOf(localGameWebPerformanceInfo.startTime), Long.valueOf(localGameWebPerformanceInfo.ezZ), Long.valueOf(localGameWebPerformanceInfo.eAa), Long.valueOf(localGameWebPerformanceInfo.eAf) });
    g.aO(paramBundle, System.currentTimeMillis());
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setFormat(-3);
    this.njk = new com.tencent.mm.plugin.game.luggage.d.c(this);
    setContentView(this.njk.byO);
    this.njk.a(new LuggageGameWebViewUI.1(this));
    Object localObject1 = (GameWebViewLaunchParams)getIntent().getParcelableExtra("launchParams");
    if (localObject1 != null)
    {
      localObject1 = ((GameWebViewLaunchParams)localObject1).njg;
      if (localObject1 != null)
      {
        Object localObject2 = GameWebPerformanceInfo.lN(((GameFloatLayerInfo)localObject1).url);
        ((GameWebPerformanceInfo)localObject2).url = ((GameFloatLayerInfo)localObject1).url;
        ((GameWebPerformanceInfo)localObject2).ezZ = getIntent().getLongExtra("gamecenterui_createtime", 0L);
        ((GameWebPerformanceInfo)localObject2).eAa = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        ((GameWebPerformanceInfo)localObject2).startTime = getIntent().getLongExtra("start_time", ((GameWebPerformanceInfo)localObject2).eAa);
        ((GameWebPerformanceInfo)localObject2).eAf = System.currentTimeMillis();
        ((GameWebPerformanceInfo)localObject2).ezQ = 1;
        ((GameWebPerformanceInfo)localObject2).ezT = 1;
        g.aO(((GameFloatLayerInfo)localObject1).url, System.currentTimeMillis());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("rawUrl", ((GameFloatLayerInfo)localObject1).url);
        ((Bundle)localObject2).putBoolean("show_full_screen", ((GameFloatLayerInfo)localObject1).njd);
        ((Bundle)localObject2).putInt("screen_orientation", ((GameFloatLayerInfo)localObject1).orientation);
        ((Bundle)localObject2).putBoolean("float_layer_page", true);
        ((Bundle)localObject2).putBoolean("needAnimation", false);
        ((Bundle)localObject2).putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
        ((Bundle)localObject2).putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
        this.njk.a(((GameFloatLayerInfo)localObject1).url, (Bundle)localObject2, false);
      }
    }
    for (int i = 1; i != 0; i = 0)
    {
      localGameWebPerformanceInfo.ezX = 1;
      new Handler().postDelayed(new LuggageGameWebViewUI.2(this, paramBundle), 300L);
      AppMethodBeat.o(135811);
      return;
    }
    this.njk.h(paramBundle, getIntent().getExtras());
    AppMethodBeat.o(135811);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(135813);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    supportRequestWindowFeature(9);
    AppMethodBeat.o(135813);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(135816);
    super.onDestroy();
    ab.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
    b.nji = null;
    b.mHeaders = null;
    b.Dt = 0L;
    this.njk.destroy();
    com.tencent.mm.plugin.wepkg.event.c.clear();
    ab.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    int i;
    if (localInputMethodManager != null)
    {
      ab.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
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
          ab.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", localThrowable, "", new Object[0]);
        }
      }
      System.gc();
      AppMethodBeat.o(135816);
      return;
      label231:
      i += 1;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(135815);
    super.onPause();
    ab.i("MicroMsg.LuggageGameWebViewUI", "onPause");
    hideVKB();
    this.njk.onPause();
    AppMethodBeat.o(135815);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(135814);
    super.onResume();
    ab.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
    this.njk.onResume();
    AppMethodBeat.o(135814);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(135818);
    ab.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis()) });
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(135818);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(135820);
    if (this.njl != -1)
    {
      setRequestedOrientation(this.njl);
      AppMethodBeat.o(135820);
      return;
    }
    this.landscapeMode = getSharedPreferences(ah.dsP(), 4).getBoolean("settings_landscape_mode", false);
    if (this.landscapeMode)
    {
      setRequestedOrientation(-1);
      AppMethodBeat.o(135820);
      return;
    }
    setRequestedOrientation(1);
    AppMethodBeat.o(135820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
 * JD-Core Version:    0.7.0.1
 */