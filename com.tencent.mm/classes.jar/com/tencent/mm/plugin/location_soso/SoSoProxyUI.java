package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.e;
import com.tencent.mm.ui.af;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@com.tencent.mm.ui.base.a(19)
public class SoSoProxyUI
  extends MapActivity
  implements d.e
{
  protected static final String TAG = "MicroMsg.SoSoProxyUI";
  private com.tencent.mm.plugin.p.a basemapUI;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56232);
    if (this.basemapUI.dispatchKeyEvent(paramKeyEvent))
    {
      AppMethodBeat.o(56232);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(56232);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(56231);
    if (this.basemapUI.dispatchTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(56231);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(56231);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(56240);
    super.finish();
    AppMethodBeat.o(56240);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(56239);
    if ((getAssets() != null) && (MMApplicationContext.getResources() != null))
    {
      localResources = MMApplicationContext.getResources();
      AppMethodBeat.o(56239);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(56239);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(56238);
    Object localObject = super.getSystemService(paramString);
    if ((getAssets() != null) && ("layout_inflater".equals(paramString)))
    {
      paramString = af.b((LayoutInflater)localObject);
      AppMethodBeat.o(56238);
      return paramString;
    }
    AppMethodBeat.o(56238);
    return localObject;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(56237);
    this.basemapUI.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(56237);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(56230);
    this.basemapUI.onBackPressed();
    AppMethodBeat.o(56230);
  }
  
  public void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(260355);
    if ((this.basemapUI instanceof d.e)) {
      ((d.e)this.basemapUI).onBusinessPermissionDenied(paramString);
    }
    AppMethodBeat.o(260355);
  }
  
  public void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(260352);
    if ((this.basemapUI instanceof d.e)) {
      ((d.e)this.basemapUI).onBusinessPermissionGranted(paramString);
    }
    AppMethodBeat.o(260352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    AppMethodBeat.i(56229);
    Log.i("MicroMsg.SoSoProxyUI", "SoSoProxyUI onCreate");
    int i = getIntent().getIntExtra("intent_map_key", -1);
    if (i == 2) {
      requestWindowFeature(1);
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT != 26) {
      setRequestedOrientation(1);
    }
    if (c.a.KkW == null) {
      for (;;)
      {
        try
        {
          boolean bool2 = CrashReportFactory.foreground;
          if (paramBundle == null) {
            continue;
          }
          Log.e("MicroMsg.SoSoProxyUI", "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), getClass().getSimpleName(), Integer.valueOf(hashCode()) });
          finish();
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.SoSoProxyUI", paramBundle, "summerasyncinit finish:", new Object[0]);
          continue;
        }
        h.OAn.idkeyStat(598L, 20L, 1L, false);
        AppMethodBeat.o(56229);
        return;
        bool1 = false;
      }
    }
    this.basemapUI = c.a.KkW.j(this, i);
    if (this.basemapUI == null)
    {
      finish();
      AppMethodBeat.o(56229);
      return;
    }
    this.basemapUI.onCreate(paramBundle);
    AppMethodBeat.o(56229);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(56236);
    if (this.basemapUI != null) {
      this.basemapUI.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(56236);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56233);
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      this.basemapUI.fVv();
      AppMethodBeat.o(56233);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(56233);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(56235);
    super.onPause();
    this.basemapUI.onPause();
    AppMethodBeat.o(56235);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(56234);
    super.onResume();
    this.basemapUI.onResume();
    AppMethodBeat.o(56234);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(260333);
    super.setContentView(paramInt);
    Log.d("MicroMsg.SoSoProxyUI", "setContentView2 %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(260333);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(260332);
    super.setContentView(paramView);
    Log.d("MicroMsg.SoSoProxyUI", "setContentView1 %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(260332);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(260335);
    super.setContentView(paramView, paramLayoutParams);
    Log.d("MicroMsg.SoSoProxyUI", "setContentView3 %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(260335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.SoSoProxyUI
 * JD-Core Version:    0.7.0.1
 */