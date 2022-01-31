package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@com.tencent.mm.ui.base.a(19)
public class SoSoProxyUI
  extends MapActivity
{
  protected static final String TAG = "MicroMsg.SoSoProxyUI";
  private com.tencent.mm.plugin.p.a basemapUI;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.basemapUI.dispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.basemapUI.dispatchTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public Resources getResources()
  {
    if ((getAssets() != null) && (ae.getResources() != null)) {
      return ae.getResources();
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if (getAssets() != null)
    {
      localObject1 = localObject2;
      if ("layout_inflater".equals(paramString)) {
        localObject1 = com.tencent.mm.ui.y.a((LayoutInflater)localObject2);
      }
    }
    return localObject1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.basemapUI.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.basemapUI.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SoSoProxyUI", "SoSoProxyUI onCreate");
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("intent_map_key", -1);
    if (c.a.lKH == null) {
      for (;;)
      {
        try
        {
          boolean bool2 = b.foreground;
          if (paramBundle == null) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SoSoProxyUI", "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), getClass().getSimpleName(), Integer.valueOf(hashCode()) });
          finish();
        }
        catch (Throwable paramBundle)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SoSoProxyUI", paramBundle, "summerasyncinit finish:", new Object[0]);
          continue;
        }
        h.nFQ.a(598L, 20L, 1L, false);
        return;
        bool1 = false;
      }
    }
    this.basemapUI = c.a.lKH.c(this, i);
    if (this.basemapUI == null)
    {
      finish();
      return;
    }
    this.basemapUI.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.basemapUI != null) {
      this.basemapUI.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      this.basemapUI.beL();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.basemapUI.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.basemapUI.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.SoSoProxyUI
 * JD-Core Version:    0.7.0.1
 */