package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.d.c;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;

public abstract class b
  extends a
{
  protected com.tencent.mm.plugin.p.d KfB;
  public Activity activity;
  protected float cxM = 0.0F;
  protected float cxN = 0.0F;
  protected int type = 0;
  
  public b(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void c(LatLng paramLatLng) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
      this.activity.finish();
      return true;
    }
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean fVv()
  {
    return false;
  }
  
  public abstract SoSoMapView fVw();
  
  public void fVx() {}
  
  public void fVy() {}
  
  public final View findViewById(int paramInt)
  {
    return this.activity.findViewById(paramInt);
  }
  
  public abstract int getLayoutId();
  
  public final String getString(int paramInt)
  {
    return this.activity.getString(paramInt);
  }
  
  public final void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    this.activity.setContentView(getLayoutId());
    this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
    Log.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[] { Integer.valueOf(this.type) });
    this.KfB = d.iL(this.activity);
    if (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, null)) {
      ((FrameLayout)findViewById(a.e.mapview_content)).addView((SoSoMapView)this.KfB);
    }
    this.KfB.setMapViewOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(56000);
        int i = paramAnonymousMotionEvent.getAction();
        Log.i("MicroMsg.MMBaseMapUI", "map action ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(56000);
          return false;
          b.this.cxM = paramAnonymousMotionEvent.getX();
          b.this.cxN = paramAnonymousMotionEvent.getY();
          b.this.fVx();
          continue;
          if ((Math.abs(paramAnonymousMotionEvent.getX() - b.this.cxM) > 10.0F) || (Math.abs(paramAnonymousMotionEvent.getY() - b.this.cxN) > 10.0F)) {
            b.this.fVy();
          }
        }
      }
    });
    this.KfB.setMapAnchor(0.5F, 0.5F);
    fVw().getMap().setOnMapClickListener(new TencentMap.OnMapClickListener()
    {
      public final void onMapClick(LatLng paramAnonymousLatLng)
      {
        AppMethodBeat.i(264973);
        b.this.c(paramAnonymousLatLng);
        AppMethodBeat.o(264973);
      }
    });
    fVw().getMap().setOnMapPoiClickListener(new TencentMap.OnMapPoiClickListener()
    {
      public final void onClicked(MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(264975);
        b.this.c(paramAnonymousMapPoi.getPosition());
        AppMethodBeat.o(264975);
      }
    });
  }
  
  public void onDestroy()
  {
    this.KfB.destroy();
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.b
 * JD-Core Version:    0.7.0.1
 */