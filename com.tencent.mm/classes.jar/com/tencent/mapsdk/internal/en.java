package com.tencent.mapsdk.internal;

import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public abstract interface en
  extends eq
{
  public static final String a = "tencent_map_infowindow_view";
  public static final String b = "tencent_map_infowindow_content_title";
  public static final String c = "tencent_map_infowindow_content_snippet";
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(LatLng paramLatLng);
  
  public abstract void a(MarkerOptions paramMarkerOptions);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract View g();
  
  public abstract void i_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.en
 * JD-Core Version:    0.7.0.1
 */