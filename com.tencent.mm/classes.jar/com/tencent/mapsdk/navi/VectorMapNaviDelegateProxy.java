package com.tencent.mapsdk.navi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.bt;
import com.tencent.mapsdk.internal.mk;
import com.tencent.mapsdk.internal.rs;
import com.tencent.mapsdk.internal.rt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public class VectorMapNaviDelegateProxy
  implements MapDelegate<mk, rs, bt>
{
  private rt mMapDelegate;
  
  public VectorMapNaviDelegateProxy(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221079);
    this.mMapDelegate = new rt(paramContext, paramTencentMapOptions, paramViewGroup);
    AppMethodBeat.o(221079);
  }
  
  public rs createMap(mk parammk)
  {
    AppMethodBeat.i(221082);
    parammk = (rs)this.mMapDelegate.a(parammk);
    AppMethodBeat.o(221082);
    return parammk;
  }
  
  public bt createMapView(mk parammk, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221080);
    parammk = this.mMapDelegate.a(parammk, paramViewGroup);
    AppMethodBeat.o(221080);
    return parammk;
  }
  
  public TencentMap getMap()
  {
    return this.mMapDelegate.e_;
  }
  
  public mk getMapContext()
  {
    return (mk)this.mMapDelegate.d_;
  }
  
  public bt getMapRenderView()
  {
    AppMethodBeat.i(221084);
    bt localbt = this.mMapDelegate.getMapRenderView();
    AppMethodBeat.o(221084);
    return localbt;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(221118);
    boolean bool = this.mMapDelegate.isOpaque();
    AppMethodBeat.o(221118);
    return bool;
  }
  
  public boolean isTouchable()
  {
    AppMethodBeat.i(221088);
    boolean bool = this.mMapDelegate.isTouchable();
    AppMethodBeat.o(221088);
    return bool;
  }
  
  public void onCreated()
  {
    AppMethodBeat.i(221123);
    this.mMapDelegate.onCreated();
    AppMethodBeat.o(221123);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(221159);
    this.mMapDelegate.onDestroy();
    AppMethodBeat.o(221159);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(221141);
    this.mMapDelegate.onPause();
    AppMethodBeat.o(221141);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(221146);
    this.mMapDelegate.onRestart();
    AppMethodBeat.o(221146);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(221135);
    this.mMapDelegate.onResume();
    AppMethodBeat.o(221135);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221101);
    this.mMapDelegate.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(221101);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(221127);
    this.mMapDelegate.onStart();
    AppMethodBeat.o(221127);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(221151);
    this.mMapDelegate.onStop();
    AppMethodBeat.o(221151);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221105);
    this.mMapDelegate.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    AppMethodBeat.o(221105);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221091);
    boolean bool = this.mMapDelegate.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(221091);
    return bool;
  }
  
  public void onUpdateOptions(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(221167);
    this.mMapDelegate.onUpdateOptions(paramTencentMapOptions);
    AppMethodBeat.o(221167);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    AppMethodBeat.i(221095);
    this.mMapDelegate.setOnTop(paramBoolean);
    AppMethodBeat.o(221095);
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    AppMethodBeat.i(221112);
    this.mMapDelegate.setOpaque(paramBoolean);
    AppMethodBeat.o(221112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.navi.VectorMapNaviDelegateProxy
 * JD-Core Version:    0.7.0.1
 */