package com.tencent.mapsdk.internal;

import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnDismissCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.List;

public abstract interface ai
{
  public abstract int A();
  
  public abstract float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt, boolean paramBoolean);
  
  public abstract float a(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean);
  
  public abstract int a(CameraUpdate paramCameraUpdate);
  
  public abstract int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback);
  
  public abstract CameraPosition a();
  
  public abstract CameraPosition a(List<eq> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract CameraPosition a(List<eq> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback);
  
  public abstract CustomLayer a(CustomLayerOptions paramCustomLayerOptions);
  
  public abstract TileOverlay a(TileOverlayOptions paramTileOverlayOptions);
  
  public abstract String a(LatLng paramLatLng);
  
  public abstract List<Rect> a(List<String> paramList);
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(Handler paramHandler, Bitmap.Config paramConfig, int paramInt);
  
  public abstract void a(ez paramez);
  
  public abstract void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void a(TencentMap.OnCompassClickedListener paramOnCompassClickedListener);
  
  public abstract void a(TencentMap.OnDismissCallback paramOnDismissCallback);
  
  public abstract void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
  
  public abstract void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void a(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void a(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void a(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener);
  
  public abstract void a(Language paramLanguage);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt);
  
  public abstract void a(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List<MapRouteSection> paramList, List<LatLng> paramList1);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract float b();
  
  public abstract int b(String paramString);
  
  public abstract void b(float paramFloat1, float paramFloat2);
  
  public abstract void b(int paramInt);
  
  public abstract void b(ez paramez);
  
  public abstract void b(TencentMap.OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void b(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract void b(Language paramLanguage);
  
  public abstract void b(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract float c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e();
  
  public abstract void e(int paramInt);
  
  public abstract void e(boolean paramBoolean);
  
  public abstract int f();
  
  public abstract void f(int paramInt);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract int g();
  
  public abstract void g(boolean paramBoolean);
  
  public abstract void h(boolean paramBoolean);
  
  public abstract boolean h();
  
  public abstract void i();
  
  public abstract void i(boolean paramBoolean);
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract String o();
  
  public abstract Language p();
  
  public abstract void q();
  
  public abstract int r();
  
  public abstract String[] s();
  
  public abstract String t();
  
  public abstract IndoorBuilding u();
  
  public abstract String v();
  
  public abstract boolean w();
  
  public abstract boolean x();
  
  public abstract ArrayList<MapPoi> y();
  
  public abstract String z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ai
 * JD-Core Version:    0.7.0.1
 */