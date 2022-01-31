package com.tencent.mm.plugin.location_soso;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.k.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.w;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@com.tencent.mm.ui.base.a(19)
public class SoSoProxyUI
  extends MapActivity
{
  protected static final String TAG = "MicroMsg.SoSoProxyUI";
  private com.tencent.mm.plugin.k.a basemapUI;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113766);
    if (this.basemapUI.dispatchKeyEvent(paramKeyEvent))
    {
      AppMethodBeat.o(113766);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(113766);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113765);
    if (this.basemapUI.dispatchTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(113765);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(113765);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(113774);
    super.finish();
    AppMethodBeat.o(113774);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(113773);
    if ((getAssets() != null) && (ah.getResources() != null))
    {
      localResources = ah.getResources();
      AppMethodBeat.o(113773);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(113773);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(113772);
    Object localObject = super.getSystemService(paramString);
    if ((getAssets() != null) && ("layout_inflater".equals(paramString)))
    {
      paramString = w.b((LayoutInflater)localObject);
      AppMethodBeat.o(113772);
      return paramString;
    }
    AppMethodBeat.o(113772);
    return localObject;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113771);
    this.basemapUI.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(113771);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(113764);
    this.basemapUI.onBackPressed();
    AppMethodBeat.o(113764);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    AppMethodBeat.i(113763);
    ab.i("MicroMsg.SoSoProxyUI", "SoSoProxyUI onCreate");
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("intent_map_key", -1);
    if (c.a.ohZ == null) {
      for (;;)
      {
        try
        {
          boolean bool2 = b.foreground;
          if (paramBundle == null) {
            continue;
          }
          ab.e("MicroMsg.SoSoProxyUI", "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), getClass().getSimpleName(), Integer.valueOf(hashCode()) });
          finish();
        }
        catch (Throwable paramBundle)
        {
          ab.printErrStackTrace("MicroMsg.SoSoProxyUI", paramBundle, "summerasyncinit finish:", new Object[0]);
          continue;
        }
        h.qsU.idkeyStat(598L, 20L, 1L, false);
        AppMethodBeat.o(113763);
        return;
        bool1 = false;
      }
    }
    this.basemapUI = c.a.ohZ.f(this, i);
    if (this.basemapUI == null)
    {
      finish();
      AppMethodBeat.o(113763);
      return;
    }
    this.basemapUI.onCreate(paramBundle);
    AppMethodBeat.o(113763);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113770);
    if (this.basemapUI != null) {
      this.basemapUI.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(113770);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113767);
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      this.basemapUI.bMf();
      AppMethodBeat.o(113767);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(113767);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113769);
    super.onPause();
    this.basemapUI.onPause();
    AppMethodBeat.o(113769);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113768);
    super.onResume();
    this.basemapUI.onResume();
    AppMethodBeat.o(113768);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.SoSoProxyUI
 * JD-Core Version:    0.7.0.1
 */