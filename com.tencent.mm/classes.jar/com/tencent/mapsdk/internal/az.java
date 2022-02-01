package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.view.ViewGroup;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnDismissCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;

public abstract interface az
  extends MapDelegate<mk, VectorMap, bt>, er, ob, ss.m, TencentMap.OnIndoorStateChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract boolean A();
  
  public abstract boolean B();
  
  public abstract no C();
  
  public abstract void D();
  
  public abstract void E();
  
  public abstract void F();
  
  public abstract Context G();
  
  public abstract void H();
  
  @Deprecated
  public abstract boolean I();
  
  public abstract boolean J();
  
  public abstract TencentMapOptions K();
  
  public abstract ViewGroup L();
  
  public abstract pk M();
  
  public abstract boolean N();
  
  public abstract CameraPosition a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(Handler paramHandler, Bitmap.Config paramConfig, int paramInt);
  
  public abstract void a(bb parambb);
  
  public abstract void a(bg.a parama);
  
  public abstract void a(es parames);
  
  public abstract void a(ey paramey);
  
  public abstract void a(fe paramfe);
  
  public abstract void a(no paramno, lc paramlc);
  
  public abstract void a(nt paramnt);
  
  public abstract void a(pt parampt);
  
  public abstract void a(rd paramrd);
  
  public abstract void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void a(TencentMap.OnDismissCallback paramOnDismissCallback);
  
  public abstract void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
  
  public abstract void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void a(TencentMapOptions paramTencentMapOptions);
  
  public abstract void a(OverSeaTileProvider paramOverSeaTileProvider);
  
  public abstract void a(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(float paramFloat1, float paramFloat2);
  
  public abstract mk b();
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract void b(es parames);
  
  public abstract void b(ey paramey);
  
  public abstract void b(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void b(String paramString);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b(float paramFloat1, float paramFloat2);
  
  public abstract mj c();
  
  public abstract oo c(String paramString);
  
  public abstract String c(float paramFloat1, float paramFloat2);
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract ri d();
  
  public abstract void d(int paramInt1, int paramInt2);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d(float paramFloat1, float paramFloat2);
  
  public abstract boolean d(String paramString);
  
  public abstract String e();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract boolean e(float paramFloat1, float paramFloat2);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract boolean f();
  
  public abstract void g(boolean paramBoolean);
  
  public abstract boolean g();
  
  public abstract int getEGLContextHash();
  
  public abstract void h(boolean paramBoolean);
  
  public abstract boolean h();
  
  public abstract void i(boolean paramBoolean);
  
  public abstract boolean i();
  
  public abstract void j(boolean paramBoolean);
  
  public abstract boolean j();
  
  public abstract void k();
  
  public abstract void k(boolean paramBoolean);
  
  public abstract void l();
  
  public abstract void l(boolean paramBoolean);
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract boolean o();
  
  public abstract boolean p();
  
  public abstract pt q();
  
  public abstract aa r();
  
  public abstract GeoPoint s();
  
  public abstract int t();
  
  public abstract int u();
  
  public abstract int v();
  
  public abstract int w();
  
  public abstract boolean x();
  
  public abstract void y();
  
  public abstract void z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.az
 * JD-Core Version:    0.7.0.1
 */