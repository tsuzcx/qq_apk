package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.location.Location;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.util.Iterator;
import java.util.List;

public final class sh
  implements es
{
  private sj a;
  
  public sh(sj paramsj)
  {
    this.a = paramsj;
  }
  
  public final void a() {}
  
  public final boolean a(float paramFloat)
  {
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224232);
    if (this.a == null)
    {
      AppMethodBeat.o(224232);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224232);
      return false;
    }
    if ((this.a.av != null) && (this.a.aw))
    {
      boolean bool = this.a.av.onDoubleTap(paramFloat1, paramFloat2);
      AppMethodBeat.o(224232);
      return bool;
    }
    AppMethodBeat.o(224232);
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    return false;
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean b(float paramFloat)
  {
    return false;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224258);
    if (this.a == null)
    {
      AppMethodBeat.o(224258);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224258);
      return false;
    }
    Object localObject1 = this.a;
    Object localObject2;
    int i;
    boolean bool1;
    label181:
    boolean bool2;
    label272:
    label347:
    ox localox;
    if (((sj)localObject1).aw)
    {
      localObject1 = (VectorMap)((bn)localObject1).e_;
      localObject2 = ((VectorMap)localObject1).o.k;
      Object localObject3 = ((bi)localObject2).a.f().a(paramFloat1, paramFloat2);
      if ((localObject3 != null) && (((TappedElement)localObject3).type == 3))
      {
        if (((bi)localObject2).h != null) {
          ((bi)localObject2).h.R();
        }
        i = 1;
        if (i == 0)
        {
          if (((VectorMap)localObject1).r == null) {
            break label594;
          }
          localObject2 = ((VectorMap)localObject1).r;
          localObject3 = ((bf)localObject2).g.k.a.f().a(paramFloat1, paramFloat2);
          if ((localObject3 == null) || (((TappedElement)localObject3).type != 6)) {
            break label588;
          }
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (((bf)localObject2).i != null)
            {
              localObject3 = new LatLng();
              if (((bf)localObject2).e != null)
              {
                ((LatLng)localObject3).setAltitude(((bf)localObject2).e.getAltitude());
                ((LatLng)localObject3).setLongitude(((bf)localObject2).e.getLongitude());
                ((LatLng)localObject3).setLatitude(((bf)localObject2).e.getLatitude());
              }
              bool2 = ((bf)localObject2).i.onMyLocationClicked((LatLng)localObject3);
            }
          }
          if (!bool2)
          {
            localObject3 = ((VectorMap)localObject1).a(paramFloat1, paramFloat2);
            if ((localObject3 == null) || (((VectorMap)localObject1).s == null)) {
              break label611;
            }
            localObject2 = ((VectorMap)localObject1).s;
            if ((((oz)localObject2).c == null) || (localObject3 == null) || (((TappedElement)localObject3).type != 4)) {
              break label606;
            }
            long l = ((TappedElement)localObject3).itemId;
            localObject3 = ((oz)localObject2).a.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label628;
            }
            localox = (ox)((Iterator)localObject3).next();
            if ((localox.b == null) || (localox.b.a == null) || (localox.b.a.j == null)) {
              break label600;
            }
            Iterator localIterator = localox.b.a.j.iterator();
            while (localIterator.hasNext())
            {
              localObject1 = (oy.d)localIterator.next();
              nf localnf = (nf)localox.a.b.k.a(nf.class, ((oy.d)localObject1).a);
              if ((localnf != null) && (localnf.e_() == l)) {
                label485:
                if (localObject1 == null) {
                  break label604;
                }
              }
            }
          }
        }
      }
    }
    label521:
    label588:
    label594:
    label600:
    label604:
    label606:
    label611:
    label616:
    label621:
    label628:
    for (localObject1 = ox.a(localox.getId(), (oy.d)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((oz)localObject2).c.onClicked((MapPoi)localObject1);
        i = 1;
        if (i == 0) {
          break label616;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          this.a.b(paramFloat1, paramFloat2);
        }
        if ((this.a.av == null) || (!this.a.aw)) {
          break label621;
        }
        bool1 = this.a.av.onSingleTap(paramFloat1, paramFloat2);
        AppMethodBeat.o(224258);
        return bool1;
        i = 0;
        break;
        bool1 = false;
        break label181;
        bool2 = false;
        break label272;
        localObject1 = null;
        break label485;
        break label347;
        i = 0;
        break label521;
        i = 0;
        break label521;
      }
      AppMethodBeat.o(224258);
      return false;
    }
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224269);
    if (this.a == null)
    {
      AppMethodBeat.o(224269);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224269);
      return false;
    }
    if (this.a.av != null)
    {
      boolean bool = this.a.av.onFling(paramFloat1, paramFloat2);
      AppMethodBeat.o(224269);
      return bool;
    }
    AppMethodBeat.o(224269);
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224279);
    if (this.a == null)
    {
      AppMethodBeat.o(224279);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224279);
      return false;
    }
    if (this.a.av != null)
    {
      boolean bool = this.a.av.onScroll(paramFloat1, paramFloat2);
      AppMethodBeat.o(224279);
      return bool;
    }
    AppMethodBeat.o(224279);
    return false;
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224296);
    if (this.a == null)
    {
      AppMethodBeat.o(224296);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224296);
      return false;
    }
    sj localsj = this.a;
    Object localObject;
    if (localsj.t != null)
    {
      localObject = localsj.c(paramFloat1, paramFloat2);
      if ((localObject != null) && (((String)localObject).trim().length() != 0)) {
        localsj.t.a((String)localObject);
      }
    }
    while (this.a.av != null)
    {
      boolean bool = this.a.av.onLongPress(paramFloat1, paramFloat2);
      AppMethodBeat.o(224296);
      return bool;
      if ((localsj.v != null) && (localsj.aw))
      {
        localObject = new fl(paramFloat1, paramFloat2);
        localObject = jz.a(((VectorMap)localsj.e_).v().a((fl)localObject));
        localsj.v.onMapLongClick((LatLng)localObject);
      }
    }
    AppMethodBeat.o(224296);
    return false;
  }
  
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224400);
    if (this.a == null)
    {
      AppMethodBeat.o(224400);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224400);
      return false;
    }
    sj localsj = this.a;
    localsj.aA += 1;
    if (this.a.av != null)
    {
      boolean bool = this.a.av.onDown(paramFloat1, paramFloat2);
      AppMethodBeat.o(224400);
      return bool;
    }
    AppMethodBeat.o(224400);
    return false;
  }
  
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224412);
    if (this.a == null)
    {
      AppMethodBeat.o(224412);
      return false;
    }
    if (!this.a.aw)
    {
      AppMethodBeat.o(224412);
      return false;
    }
    Object localObject = this.a;
    int i;
    if (this.a.aA > 0)
    {
      sj localsj = this.a;
      i = localsj.aA - 1;
      localsj.aA = i;
    }
    for (;;)
    {
      ((sj)localObject).aA = i;
      if ((!this.a.az) || (!this.a.ay) || (this.a.aA != 0)) {
        break label155;
      }
      localObject = this.a.a();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(224412);
      return false;
      i = 0;
    }
    this.a.az = false;
    this.a.onCameraChangeFinished((CameraPosition)localObject);
    label155:
    if (this.a.av != null)
    {
      boolean bool = this.a.av.onUp(paramFloat1, paramFloat2);
      AppMethodBeat.o(224412);
      return bool;
    }
    AppMethodBeat.o(224412);
    return false;
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sh
 * JD-Core Version:    0.7.0.1
 */