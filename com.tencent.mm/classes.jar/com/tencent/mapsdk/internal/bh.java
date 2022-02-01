package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public final class bh
{
  public final Map<String, eq> a;
  public final List<eq> b;
  public final List<eq> c;
  public final List<eq> d;
  public final List<em> e;
  public final az f;
  public final Comparator<Levelable> g;
  public final be h;
  private IndoorBuilding i;
  private final Comparator<Levelable> j;
  
  public bh(az paramaz, bd parambd)
  {
    AppMethodBeat.i(224918);
    this.a = new ConcurrentHashMap();
    this.b = new CopyOnWriteArrayList();
    this.c = new CopyOnWriteArrayList();
    this.d = new CopyOnWriteArrayList();
    this.e = new CopyOnWriteArrayList();
    this.j = new Comparator()
    {
      private static int a(Levelable paramAnonymousLevelable1, Levelable paramAnonymousLevelable2)
      {
        AppMethodBeat.i(223005);
        int i = Float.compare(paramAnonymousLevelable1.getZIndex(), paramAnonymousLevelable2.getZIndex());
        AppMethodBeat.o(223005);
        return i;
      }
    };
    this.g = new Comparator()
    {
      private static int a(Levelable paramAnonymousLevelable1, Levelable paramAnonymousLevelable2)
      {
        AppMethodBeat.i(223029);
        if (paramAnonymousLevelable1.getLevel() == paramAnonymousLevelable2.getLevel())
        {
          i = Float.compare(paramAnonymousLevelable1.getZIndex(), paramAnonymousLevelable2.getZIndex());
          AppMethodBeat.o(223029);
          return i;
        }
        int i = paramAnonymousLevelable1.getLevel();
        int j = paramAnonymousLevelable2.getLevel();
        AppMethodBeat.o(223029);
        return i - j;
      }
    };
    this.f = paramaz;
    this.h = new be(parambd);
    AppMethodBeat.o(224918);
  }
  
  private Arc a(ArcOptions paramArcOptions)
  {
    AppMethodBeat.i(224927);
    paramArcOptions = new om(paramArcOptions, this.f);
    ar localar = new ar(paramArcOptions);
    this.a.put(paramArcOptions.getId(), localar);
    this.c.add(localar);
    a(paramArcOptions);
    AppMethodBeat.o(224927);
    return localar;
  }
  
  private Polygon a(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(224932);
    paramPolygonOptions = new or(this.f, paramPolygonOptions);
    aw localaw = new aw(paramPolygonOptions);
    this.a.put(paramPolygonOptions.getId(), localaw);
    this.d.add(localaw);
    a(paramPolygonOptions);
    AppMethodBeat.o(224932);
    return localaw;
  }
  
  private void a(eq parameq)
  {
    AppMethodBeat.i(225038);
    be localbe = this.h;
    synchronized (localbe.a)
    {
      if (localbe.a.contains(parameq))
      {
        if ((parameq instanceof em)) {
          a((em)parameq);
        }
        AppMethodBeat.o(225038);
        return;
      }
      localbe.a.add(parameq);
    }
  }
  
  private void a(GL10 paramGL10)
  {
    AppMethodBeat.i(225055);
    this.h.a(paramGL10);
    AppMethodBeat.o(225055);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225066);
    boolean bool = this.h.a(paramFloat1, paramFloat2);
    AppMethodBeat.o(225066);
    return bool;
  }
  
  private void b(eq parameq)
  {
    AppMethodBeat.i(225048);
    be localbe = this.h;
    if (parameq != null) {
      synchronized (localbe.a)
      {
        localbe.a.remove(parameq);
        localbe.b.add(parameq);
        AppMethodBeat.o(225048);
        return;
      }
    }
    AppMethodBeat.o(225048);
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(224941);
    paramString = (eq)this.a.remove(paramString);
    if (paramString != null)
    {
      this.b.remove(paramString);
      this.c.remove(paramString);
      this.d.remove(paramString);
      if ((paramString instanceof au))
      {
        ao localao = ((au)paramString).f_();
        if (localao != null) {
          this.e.remove(localao);
        }
      }
    }
    if (paramString != null)
    {
      AppMethodBeat.o(224941);
      return true;
    }
    AppMethodBeat.o(224941);
    return false;
  }
  
  private List<eq> c()
  {
    return this.b;
  }
  
  private List<eq> d()
  {
    return this.c;
  }
  
  private List<eq> e()
  {
    return this.d;
  }
  
  private List<Arc> f()
  {
    AppMethodBeat.i(224974);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      eq localeq = (eq)localIterator.next();
      if ((localeq instanceof ar)) {
        localArrayList.add((ar)localeq);
      }
    }
    Collections.sort(localArrayList, this.j);
    AppMethodBeat.o(224974);
    return localArrayList;
  }
  
  private List<Marker> g()
  {
    AppMethodBeat.i(224984);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      eq localeq = (eq)localIterator.next();
      if ((localeq instanceof av)) {
        localArrayList.add((av)localeq);
      }
    }
    Collections.sort(localArrayList, this.j);
    AppMethodBeat.o(224984);
    return localArrayList;
  }
  
  private List<Polyline> h()
  {
    AppMethodBeat.i(224995);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      eq localeq = (eq)localIterator.next();
      if ((localeq instanceof ax)) {
        localArrayList.add((ax)localeq);
      }
    }
    Collections.sort(localArrayList, this.j);
    AppMethodBeat.o(224995);
    return localArrayList;
  }
  
  private List<Polygon> i()
  {
    AppMethodBeat.i(225006);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      eq localeq = (eq)localIterator.next();
      if ((localeq instanceof aw)) {
        localArrayList.add((aw)localeq);
      }
    }
    Collections.sort(localArrayList, this.g);
    AppMethodBeat.o(225006);
    return localArrayList;
  }
  
  private List<Circle> j()
  {
    AppMethodBeat.i(225017);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      eq localeq = (eq)localIterator.next();
      if ((localeq instanceof as)) {
        localArrayList.add((as)localeq);
      }
    }
    Collections.sort(localArrayList, this.j);
    AppMethodBeat.o(225017);
    return localArrayList;
  }
  
  private void k()
  {
    AppMethodBeat.i(225027);
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(225027);
  }
  
  public final eq a(String paramString)
  {
    AppMethodBeat.i(225121);
    paramString = (eq)this.a.get(paramString);
    AppMethodBeat.o(225121);
    return paramString;
  }
  
  public final <T extends eq> T a(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(225134);
    paramString = (eq)this.a.get(paramString);
    if ((paramString != null) && (paramString.getClass() == paramClass))
    {
      AppMethodBeat.o(225134);
      return paramString;
    }
    AppMethodBeat.o(225134);
    return null;
  }
  
  public final Circle a(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(225080);
    on localon = new on(this.f);
    localon.a(paramCircleOptions);
    paramCircleOptions = new as(localon);
    this.a.put(localon.getId(), paramCircleOptions);
    this.d.add(paramCircleOptions);
    a(localon);
    AppMethodBeat.o(225080);
    return paramCircleOptions;
  }
  
  public final Marker a(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(225100);
    sj localsj = (sj)this.f;
    oq localoq = new oq(localsj);
    localoq.setMarkerOptions(paramMarkerOptions);
    paramMarkerOptions = new av(localoq);
    this.a.put(localoq.getId(), paramMarkerOptions);
    this.b.add(paramMarkerOptions);
    if (localsj.ap != null) {
      localsj.ap.a(localoq);
    }
    a(localoq);
    AppMethodBeat.o(225100);
    return paramMarkerOptions;
  }
  
  public final Polyline a(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(225090);
    os localos = new os(this.f);
    localos.setPolylineOptions(paramPolylineOptions);
    paramPolylineOptions = new ax(localos);
    this.a.put(localos.getId(), paramPolylineOptions);
    this.c.add(paramPolylineOptions);
    a(localos);
    AppMethodBeat.o(225090);
    return paramPolylineOptions;
  }
  
  public final void a()
  {
    AppMethodBeat.i(225147);
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        eq localeq = (eq)localIterator.next();
        if (localeq != null)
        {
          localeq.remove();
          localIterator.remove();
        }
      }
    }
    finally
    {
      AppMethodBeat.o(225147);
    }
    this.b.clear();
    this.c.clear();
    this.d.clear();
    AppMethodBeat.o(225147);
  }
  
  public final void a(em paramem)
  {
    AppMethodBeat.i(225112);
    if ((paramem != null) && (paramem.m() != null))
    {
      if (this.i == null) {
        break label54;
      }
      paramem.a(this.i);
    }
    for (;;)
    {
      this.e.add(paramem);
      AppMethodBeat.o(225112);
      return;
      label54:
      paramem.o();
    }
  }
  
  public final boolean a(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(225164);
    this.i = paramIndoorBuilding;
    Iterator localIterator = this.e.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      em localem = (em)localIterator.next();
      if (localem.m() != null)
      {
        boolean bool2 = true;
        bool1 = true;
        if (paramIndoorBuilding != null)
        {
          localem.a(paramIndoorBuilding);
        }
        else
        {
          localem.o();
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(225164);
    return bool1;
  }
  
  public final Iterable<eq> b()
  {
    AppMethodBeat.i(225176);
    Collection localCollection = this.a.values();
    AppMethodBeat.o(225176);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bh
 * JD-Core Version:    0.7.0.1
 */