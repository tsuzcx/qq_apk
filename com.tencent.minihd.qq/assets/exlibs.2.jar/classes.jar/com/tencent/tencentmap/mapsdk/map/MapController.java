package com.tencent.tencentmap.mapsdk.map;

import android.os.Message;

public final class MapController
{
  private n a;
  
  MapController(n paramn)
  {
    this.a = paramn;
  }
  
  public void animateTo(GeoPoint paramGeoPoint)
  {
    this.a.e.a(paramGeoPoint, null, null);
  }
  
  public void animateTo(GeoPoint paramGeoPoint, Message paramMessage)
  {
    this.a.e.a(paramGeoPoint, paramMessage, null);
  }
  
  public void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable)
  {
    this.a.e.a(paramGeoPoint, null, paramRunnable);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {
      return;
    }
    this.a.a.a(paramFloat1, paramFloat2);
    this.a.c.a(-paramFloat1, -paramFloat2);
    this.a.a.a(false, false, false);
  }
  
  public void setCenter(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {}
    while ((this.a == null) || (this.a.c == null)) {
      return;
    }
    this.a.a.a(paramGeoPoint);
  }
  
  public int setZoom(int paramInt)
  {
    paramInt = this.a.a(paramInt);
    this.a.a.a();
    this.a.a.a(paramInt);
    this.a.a.a(true);
    return paramInt;
  }
  
  public boolean zoomIn()
  {
    return this.a.e.a(1);
  }
  
  public boolean zoomInFixing(int paramInt1, int paramInt2)
  {
    int i = this.a.a.e();
    int j = this.a.a.f();
    if (paramInt1 > i)
    {
      if (paramInt2 <= j) {
        break label61;
      }
      paramInt1 = j;
    }
    for (;;)
    {
      return this.a.e.a(i, paramInt1);
      i = paramInt1;
      if (paramInt1 >= 0) {
        break;
      }
      i = 0;
      break;
      label61:
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
    }
  }
  
  public boolean zoomOut()
  {
    return this.a.e.b(1);
  }
  
  public boolean zoomOutFixing(int paramInt1, int paramInt2)
  {
    int i = this.a.a.e();
    int j = this.a.a.f();
    if (paramInt1 > i)
    {
      if (paramInt2 <= j) {
        break label61;
      }
      paramInt1 = j;
    }
    for (;;)
    {
      return this.a.e.b(i, paramInt1);
      i = paramInt1;
      if (paramInt1 >= 0) {
        break;
      }
      i = 0;
      break;
      label61:
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
    }
  }
  
  public void zoomToSpan(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    do
    {
      return;
      localGeoPoint2 = this.a.a.h();
    } while (localGeoPoint2 == null);
    paramInt1 /= 2;
    paramInt2 /= 2;
    GeoPoint localGeoPoint1 = new GeoPoint(localGeoPoint2.getLatitudeE6() - paramInt1, localGeoPoint2.getLongitudeE6() + paramInt2);
    GeoPoint localGeoPoint2 = new GeoPoint(localGeoPoint2.getLatitudeE6() + paramInt1, localGeoPoint2.getLongitudeE6() - paramInt2);
    this.a.a.a(localGeoPoint1, localGeoPoint2, false);
  }
  
  public void zoomToSpan(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    this.a.a.a(paramGeoPoint1, paramGeoPoint2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapController
 * JD-Core Version:    0.7.0.1
 */