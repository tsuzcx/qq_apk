package com.tencent.mapsdk.vector;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.bt;
import com.tencent.mapsdk.internal.kl;
import com.tencent.mapsdk.internal.mk;
import com.tencent.mapsdk.internal.sj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public class VectorMapDelegateProxy
  implements MapDelegate<mk, VectorMap, bt>
{
  private sj mMapDelegate;
  
  public VectorMapDelegateProxy(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221086);
    this.mMapDelegate = new sj(paramContext, paramTencentMapOptions, paramViewGroup);
    AppMethodBeat.o(221086);
  }
  
  public VectorMap createMap(mk parammk)
  {
    AppMethodBeat.i(221090);
    parammk = (VectorMap)this.mMapDelegate.a(parammk);
    AppMethodBeat.o(221090);
    return parammk;
  }
  
  public bt createMapView(mk parammk, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221087);
    parammk = this.mMapDelegate.a(parammk, paramViewGroup);
    AppMethodBeat.o(221087);
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
    AppMethodBeat.i(221097);
    bt localbt = this.mMapDelegate.getMapRenderView();
    AppMethodBeat.o(221097);
    return localbt;
  }
  
  public boolean isOpaque()
  {
    AppMethodBeat.i(221144);
    boolean bool = this.mMapDelegate.isOpaque();
    AppMethodBeat.o(221144);
    return bool;
  }
  
  public boolean isTouchable()
  {
    AppMethodBeat.i(221109);
    boolean bool = this.mMapDelegate.isTouchable();
    AppMethodBeat.o(221109);
    return bool;
  }
  
  public void onCreated()
  {
    AppMethodBeat.i(221148);
    kl.b("DG_ON_CREATED");
    this.mMapDelegate.onCreated();
    kl.d("DG_ON_CREATED");
    AppMethodBeat.o(221148);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(221190);
    kl.b("DG_ON_DESTROY");
    this.mMapDelegate.onDestroy();
    kl.d("DG_ON_DESTROY");
    kl.d("API_STATUS");
    kl.a();
    AppMethodBeat.o(221190);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(221168);
    kl.b("DG_ON_PAUSE");
    this.mMapDelegate.onPause();
    kl.d("DG_ON_PAUSE");
    AppMethodBeat.o(221168);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(221177);
    kl.b("DG_ON_RESTART");
    this.mMapDelegate.onRestart();
    kl.d("DG_ON_RESTART");
    AppMethodBeat.o(221177);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(221163);
    kl.b("DG_ON_RESUME");
    this.mMapDelegate.onResume();
    kl.d("DG_ON_RESUME");
    AppMethodBeat.o(221163);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221125);
    kl.b("DG_ON_SIZE_CHANGED");
    this.mMapDelegate.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    kl.d("DG_ON_SIZE_CHANGED");
    AppMethodBeat.o(221125);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(221154);
    kl.b("DG_ON_START");
    this.mMapDelegate.onStart();
    kl.d("DG_ON_START");
    AppMethodBeat.o(221154);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(221183);
    kl.b("DG_ON_STOP");
    this.mMapDelegate.onStop();
    kl.d("DG_ON_STOP");
    AppMethodBeat.o(221183);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221131);
    kl.b("DG_ON_SURFACE_CHANGED");
    kl.a("DG_ON_SURFACE_CHANGED", "width", Integer.valueOf(paramInt1));
    kl.a("DG_ON_SURFACE_CHANGED", "height", Integer.valueOf(paramInt2));
    this.mMapDelegate.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    kl.d("DG_ON_SURFACE_CHANGED");
    AppMethodBeat.o(221131);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(221116);
    boolean bool = this.mMapDelegate.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(221116);
    return bool;
  }
  
  public void onUpdateOptions(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(221197);
    kl.b("DG_ON_UPDATE_OPTIONS");
    this.mMapDelegate.onUpdateOptions(paramTencentMapOptions);
    kl.d("DG_ON_UPDATE_OPTIONS");
    AppMethodBeat.o(221197);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    AppMethodBeat.i(221119);
    this.mMapDelegate.setOnTop(paramBoolean);
    AppMethodBeat.o(221119);
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    AppMethodBeat.i(221139);
    this.mMapDelegate.setOpaque(paramBoolean);
    AppMethodBeat.o(221139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.vector.VectorMapDelegateProxy
 * JD-Core Version:    0.7.0.1
 */