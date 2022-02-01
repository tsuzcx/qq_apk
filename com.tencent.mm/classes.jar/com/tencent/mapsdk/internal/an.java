package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.util.List;

public abstract interface an
  extends ao, Marker
{
  public abstract int a();
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void a(AnimationListener paramAnimationListener);
  
  public abstract void a(BitmapDescriptor paramBitmapDescriptor1, BitmapDescriptor paramBitmapDescriptor2);
  
  public abstract void a(LatLng paramLatLng);
  
  @Deprecated
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract Point c();
  
  public abstract TencentMap.OnMarkerClickListener d();
  
  public abstract List<LatLng> e();
  
  public abstract List<Boundable<ep>> f();
  
  public abstract TencentMap.InfoWindowAdapter g();
  
  public abstract en h();
  
  public abstract Rect i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.an
 * JD-Core Version:    0.7.0.1
 */