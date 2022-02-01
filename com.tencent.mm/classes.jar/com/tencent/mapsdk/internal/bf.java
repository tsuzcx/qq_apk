package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.LocationSource.OnLocationChangedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public final class bf
  implements ah
{
  public z a;
  Circle b;
  public TencentMap.OnMyLocationChangeListener c;
  MyLocationStyle d;
  public Location e;
  BitmapDescriptor f;
  public mk g;
  int h;
  public TencentMap.OnMyLocationClickListener i;
  private LocationSource.OnLocationChangedListener j;
  private LocationSource k;
  private boolean l;
  private int m;
  private BitmapDescriptor n;
  
  public bf(mk parammk, z paramz)
  {
    AppMethodBeat.i(225101);
    this.a = null;
    this.j = null;
    this.k = null;
    this.l = false;
    this.b = null;
    this.c = null;
    this.d = new MyLocationStyle();
    this.m = Color.argb(102, 0, 163, 255);
    this.e = null;
    this.g = parammk;
    this.a = paramz;
    this.j = h();
    AppMethodBeat.o(225101);
  }
  
  private void a(Location paramLocation)
  {
    AppMethodBeat.i(225131);
    if (paramLocation == null)
    {
      AppMethodBeat.o(225131);
      return;
    }
    Object localObject2 = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    if (this.b == null)
    {
      localObject1 = new CircleOptions();
      ((CircleOptions)localObject1).radius(paramLocation.getAccuracy()).center((LatLng)localObject2).fillColor(this.d.getFillColor()).strokeColor(this.d.getStrokeColor()).strokeWidth(this.d.getStrokeWidth());
      localObject2 = this.g;
      if (((mk)localObject2).J != null) {
        break label216;
      }
    }
    label216:
    for (Object localObject1 = null;; localObject1 = ((mk)localObject2).J.a((CircleOptions)localObject1))
    {
      this.b = ((Circle)localObject1);
      if (this.h == 0)
      {
        localObject2 = this.d.getMyLocationIcon();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = f();
        }
        localObject2 = ((BitmapDescriptor)localObject1).getBitmap(this.g.getContext());
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          this.f = ((BitmapDescriptor)localObject1);
          this.h = this.g.a(((BitmapDescriptor)localObject1).getFormater().getBitmapId(), this.d.getAnchorU(), this.d.getAnchorV());
        }
      }
      localObject1 = this.d;
      if ((paramLocation != null) && (localObject1 != null)) {
        break;
      }
      AppMethodBeat.o(225131);
      return;
    }
    localObject2 = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    if (this.b != null)
    {
      this.b.setCenter((LatLng)localObject2);
      this.b.setRadius(paramLocation.getAccuracy());
    }
    this.g.a(GeoPoint.from((LatLng)localObject2), 0.0F, 0.0F, false);
    switch (((MyLocationStyle)localObject1).getMyLocationType())
    {
    default: 
      this.g.a(paramLocation.getBearing());
      if (this.a != null) {
        this.a.a(CameraUpdateFactory.newLatLng((LatLng)localObject2));
      }
      break;
    }
    do
    {
      AppMethodBeat.o(225131);
      return;
      AppMethodBeat.o(225131);
      return;
      this.g.a(paramLocation.getBearing());
      AppMethodBeat.o(225131);
      return;
    } while (this.a == null);
    localObject1 = this.a.a();
    this.a.a(CameraUpdateFactory.rotateTo(paramLocation.getBearing(), ((CameraPosition)localObject1).tilt));
    AppMethodBeat.o(225131);
  }
  
  private void a(TencentMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    this.c = paramOnMyLocationChangeListener;
  }
  
  private void a(TencentMap.OnMyLocationClickListener paramOnMyLocationClickListener)
  {
    this.i = paramOnMyLocationClickListener;
  }
  
  private void a(MyLocationStyle paramMyLocationStyle, Location paramLocation)
  {
    AppMethodBeat.i(225156);
    if ((paramLocation == null) || (paramMyLocationStyle == null))
    {
      AppMethodBeat.o(225156);
      return;
    }
    LatLng localLatLng = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    if (this.b != null)
    {
      this.b.setCenter(localLatLng);
      this.b.setRadius(paramLocation.getAccuracy());
    }
    this.g.a(GeoPoint.from(localLatLng), 0.0F, 0.0F, false);
    switch (paramMyLocationStyle.getMyLocationType())
    {
    default: 
      this.g.a(paramLocation.getBearing());
      if (this.a != null) {
        this.a.a(CameraUpdateFactory.newLatLng(localLatLng));
      }
      break;
    }
    do
    {
      AppMethodBeat.o(225156);
      return;
      AppMethodBeat.o(225156);
      return;
      this.g.a(paramLocation.getBearing());
      AppMethodBeat.o(225156);
      return;
    } while (this.a == null);
    paramMyLocationStyle = this.a.a();
    this.a.a(CameraUpdateFactory.rotateTo(paramLocation.getBearing(), paramMyLocationStyle.tilt));
    AppMethodBeat.o(225156);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225189);
    Object localObject = this.g.k.a.f().a(paramFloat1, paramFloat2);
    if ((localObject != null) && (((TappedElement)localObject).type == 6)) {}
    for (boolean bool = true; (bool) && (this.i != null); bool = false)
    {
      localObject = new LatLng();
      if (this.e != null)
      {
        ((LatLng)localObject).setAltitude(this.e.getAltitude());
        ((LatLng)localObject).setLongitude(this.e.getLongitude());
        ((LatLng)localObject).setLatitude(this.e.getLatitude());
      }
      bool = this.i.onMyLocationClicked((LatLng)localObject);
      AppMethodBeat.o(225189);
      return bool;
    }
    AppMethodBeat.o(225189);
    return bool;
  }
  
  private void b(Location paramLocation)
  {
    AppMethodBeat.i(225142);
    LatLng localLatLng = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
    Object localObject;
    if (this.b == null)
    {
      localObject = new CircleOptions();
      ((CircleOptions)localObject).radius(paramLocation.getAccuracy()).center(localLatLng).fillColor(this.d.getFillColor()).strokeColor(this.d.getStrokeColor()).strokeWidth(this.d.getStrokeWidth());
      paramLocation = this.g;
      if (paramLocation.J != null) {
        break label195;
      }
    }
    label195:
    for (paramLocation = null;; paramLocation = paramLocation.J.a((CircleOptions)localObject))
    {
      this.b = paramLocation;
      if (this.h == 0)
      {
        localObject = this.d.getMyLocationIcon();
        paramLocation = (Location)localObject;
        if (localObject == null) {
          paramLocation = f();
        }
        localObject = paramLocation.getBitmap(this.g.getContext());
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          this.f = paramLocation;
          this.h = this.g.a(paramLocation.getFormater().getBitmapId(), this.d.getAnchorU(), this.d.getAnchorV());
        }
      }
      AppMethodBeat.o(225142);
      return;
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(225111);
    c();
    this.a = null;
    AppMethodBeat.o(225111);
  }
  
  private LocationSource.OnLocationChangedListener h()
  {
    AppMethodBeat.i(225166);
    LocationSource.OnLocationChangedListener local1 = new LocationSource.OnLocationChangedListener()
    {
      public final void onLocationChanged(Location paramAnonymousLocation)
      {
        AppMethodBeat.i(222827);
        if (paramAnonymousLocation == null)
        {
          AppMethodBeat.o(222827);
          return;
        }
        bf localbf;
        Object localObject2;
        Object localObject1;
        if (bf.this.e == null)
        {
          bf.this.e = new Location(paramAnonymousLocation);
          localbf = bf.this;
          if (paramAnonymousLocation != null)
          {
            localObject2 = new LatLng(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude());
            if (localbf.b == null)
            {
              localObject1 = new CircleOptions();
              ((CircleOptions)localObject1).radius(paramAnonymousLocation.getAccuracy()).center((LatLng)localObject2).fillColor(localbf.d.getFillColor()).strokeColor(localbf.d.getStrokeColor()).strokeWidth(localbf.d.getStrokeWidth());
              localObject2 = localbf.g;
              if (((mk)localObject2).J != null) {
                break label391;
              }
              localObject1 = null;
              label144:
              localbf.b = ((Circle)localObject1);
            }
            if (localbf.h == 0)
            {
              localObject2 = localbf.d.getMyLocationIcon();
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = localbf.f();
              }
              localObject2 = ((BitmapDescriptor)localObject1).getBitmap(localbf.g.getContext());
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localbf.f = ((BitmapDescriptor)localObject1);
                localbf.h = localbf.g.a(((BitmapDescriptor)localObject1).getFormater().getBitmapId(), localbf.d.getAnchorU(), localbf.d.getAnchorV());
              }
            }
            localObject1 = localbf.d;
            if ((paramAnonymousLocation != null) && (localObject1 != null)) {
              break label403;
            }
          }
        }
        for (;;)
        {
          if (bf.this.c != null) {
            bf.this.c.onMyLocationChange(paramAnonymousLocation);
          }
          AppMethodBeat.o(222827);
          return;
          bf.this.e.setLongitude(paramAnonymousLocation.getLongitude());
          bf.this.e.setLatitude(paramAnonymousLocation.getLatitude());
          bf.this.e.setAccuracy(paramAnonymousLocation.getAccuracy());
          bf.this.e.setProvider(paramAnonymousLocation.getProvider());
          bf.this.e.setTime(paramAnonymousLocation.getTime());
          bf.this.e.setSpeed(paramAnonymousLocation.getSpeed());
          bf.this.e.setAltitude(paramAnonymousLocation.getAltitude());
          break;
          label391:
          localObject1 = ((mk)localObject2).J.a((CircleOptions)localObject1);
          break label144;
          label403:
          localObject2 = new LatLng(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude());
          if (localbf.b != null)
          {
            localbf.b.setCenter((LatLng)localObject2);
            localbf.b.setRadius(paramAnonymousLocation.getAccuracy());
          }
          localbf.g.a(GeoPoint.from((LatLng)localObject2), 0.0F, 0.0F, false);
          switch (((MyLocationStyle)localObject1).getMyLocationType())
          {
          case 2: 
          default: 
            localbf.g.a(paramAnonymousLocation.getBearing());
            if (localbf.a != null) {
              localbf.a.a(CameraUpdateFactory.newLatLng((LatLng)localObject2));
            }
            break;
          case 1: 
            localbf.g.a(paramAnonymousLocation.getBearing());
            break;
          case 3: 
            if (localbf.a != null)
            {
              localObject1 = localbf.a.a();
              localbf.a.a(CameraUpdateFactory.rotateTo(paramAnonymousLocation.getBearing(), ((CameraPosition)localObject1).tilt));
            }
            break;
          }
        }
      }
    };
    AppMethodBeat.o(225166);
    return local1;
  }
  
  private BitmapDescriptor i()
  {
    return this.f;
  }
  
  public final void a()
  {
    AppMethodBeat.i(225261);
    if (this.b != null)
    {
      this.b.setVisible(false);
      this.b.remove();
      this.b = null;
    }
    AppMethodBeat.o(225261);
  }
  
  public final void a(LocationSource paramLocationSource)
  {
    AppMethodBeat.i(225296);
    this.k = paramLocationSource;
    if ((!this.l) || (paramLocationSource == null))
    {
      AppMethodBeat.o(225296);
      return;
    }
    this.k.activate(this.j);
    AppMethodBeat.o(225296);
  }
  
  public final void a(MyLocationStyle paramMyLocationStyle)
  {
    AppMethodBeat.i(225331);
    if (paramMyLocationStyle == null)
    {
      AppMethodBeat.o(225331);
      return;
    }
    this.d = paramMyLocationStyle;
    if (this.b != null)
    {
      this.b.setFillColor(paramMyLocationStyle.getFillColor());
      this.b.setStrokeColor(paramMyLocationStyle.getStrokeColor());
      this.b.setStrokeWidth(paramMyLocationStyle.getStrokeWidth());
    }
    if ((this.h != 0) && (this.f != null))
    {
      Object localObject2 = paramMyLocationStyle.getMyLocationIcon();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = f();
      }
      localObject2 = ((BitmapDescriptor)localObject1).getBitmap(this.g.getContext());
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        localObject1 = ((BitmapDescriptor)localObject1).getFormater().getBitmapId();
        if (!this.f.getFormater().getBitmapId().equals(localObject1))
        {
          this.f = paramMyLocationStyle.getMyLocationIcon();
          this.h = this.g.a((String)localObject1, paramMyLocationStyle.getAnchorU(), paramMyLocationStyle.getAnchorV());
        }
      }
    }
    AppMethodBeat.o(225331);
  }
  
  public final void b()
  {
    AppMethodBeat.i(225273);
    if (this.l)
    {
      AppMethodBeat.o(225273);
      return;
    }
    this.l = true;
    if (this.j == null) {
      this.j = h();
    }
    this.g.e(false);
    if (this.b != null) {
      this.b.setVisible(true);
    }
    if (this.k != null) {
      this.k.activate(this.j);
    }
    AppMethodBeat.o(225273);
  }
  
  public final void c()
  {
    AppMethodBeat.i(225283);
    if (this.b != null)
    {
      this.b.setVisible(false);
      this.b.remove();
      this.b = null;
    }
    if (!this.l)
    {
      AppMethodBeat.o(225283);
      return;
    }
    this.l = false;
    this.g.e(true);
    this.h = 0;
    this.j = null;
    if (this.k != null) {
      this.k.deactivate();
    }
    AppMethodBeat.o(225283);
  }
  
  public final boolean d()
  {
    return this.l;
  }
  
  public final Location e()
  {
    AppMethodBeat.i(225315);
    if (this.e == null)
    {
      AppMethodBeat.o(225315);
      return null;
    }
    Location localLocation = new Location(this.e);
    AppMethodBeat.o(225315);
    return localLocation;
  }
  
  final BitmapDescriptor f()
  {
    AppMethodBeat.i(225304);
    if (this.n == null) {
      this.n = BitmapDescriptorFactory.fromAsset(this.g, "navi_marker_location.png");
    }
    BitmapDescriptor localBitmapDescriptor = this.n;
    AppMethodBeat.o(225304);
    return localBitmapDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bf
 * JD-Core Version:    0.7.0.1
 */