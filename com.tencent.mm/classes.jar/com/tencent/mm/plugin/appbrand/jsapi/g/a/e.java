package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> hPQ;
  
  static
  {
    AppMethodBeat.i(93885);
    HashMap localHashMap = new HashMap();
    hPQ = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    hPQ.put("addMapMarkers", Integer.valueOf(1));
    hPQ.put("removeMapMarkers", Integer.valueOf(2));
    hPQ.put("addMapLines", Integer.valueOf(3));
    hPQ.put("removeMapLines", Integer.valueOf(4));
    hPQ.put("includeMapPoints", Integer.valueOf(5));
    hPQ.put("addMapControls", Integer.valueOf(6));
    hPQ.put("addMapPolygons", Integer.valueOf(7));
    hPQ.put("getMapCenterLocation", Integer.valueOf(8));
    hPQ.put("moveToMapLocation", Integer.valueOf(9));
    hPQ.put("translateMapMarker", Integer.valueOf(10));
    hPQ.put("getMapScale", Integer.valueOf(11));
    hPQ.put("getMapRegion", Integer.valueOf(12));
    hPQ.put("getMapRotate", Integer.valueOf(13));
    hPQ.put("getMapSkew", Integer.valueOf(14));
    hPQ.put("getMapIndoorFloor", Integer.valueOf(15));
    hPQ.put("setMapIndoorFloor", Integer.valueOf(16));
    hPQ.put("eraseMapLines", Integer.valueOf(17));
    AppMethodBeat.o(93885);
  }
  
  public static void Cj(String paramString)
  {
    AppMethodBeat.i(93882);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(93882);
      return;
    }
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label58:
        if (hPQ.containsKey(paramString)) {
          i = ((Integer)hPQ.get(paramString)).intValue() * 5 + 20 + 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        d.e("Luggage.MapReporter", "key is -1, may be err");
        AppMethodBeat.o(93882);
        return;
        if (!paramString.equals("insertMap")) {
          break;
        }
        i = 0;
        break label58;
        if (!paramString.equals("updateMap")) {
          break;
        }
        i = 1;
        break label58;
        if (!paramString.equals("removeMap")) {
          break;
        }
        i = 2;
        break label58;
        i = 0;
        continue;
        i = 3;
        continue;
        i = 6;
        continue;
      }
      oe(i);
      d.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(93882);
      return;
      i = -1;
    }
  }
  
  public static void d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93883);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(93883);
      return;
    }
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label58:
        if (hPQ.containsKey(paramString))
        {
          int j = ((Integer)hPQ.get(paramString)).intValue();
          if (paramBoolean2) {
            if (paramBoolean1)
            {
              i = 3;
              label123:
              i += j * 5 + 20;
            }
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        d.e("Luggage.MapReporter", "key is -1, may be err");
        AppMethodBeat.o(93883);
        return;
        if (!paramString.equals("insertMap")) {
          break;
        }
        i = 0;
        break label58;
        if (!paramString.equals("updateMap")) {
          break;
        }
        i = 1;
        break label58;
        if (!paramString.equals("removeMap")) {
          break;
        }
        i = 2;
        break label58;
        if (paramBoolean1)
        {
          i = 1;
          continue;
        }
        i = 2;
        continue;
        if (paramBoolean1)
        {
          i = 4;
          continue;
        }
        i = 5;
        continue;
        if (paramBoolean1)
        {
          i = 7;
          continue;
        }
        i = 8;
        continue;
        i = 4;
        break label123;
        if (paramBoolean1)
        {
          i = 1;
          break label123;
        }
        i = 2;
        break label123;
      }
      oe(i);
      d.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(93883);
      return;
      i = -1;
    }
  }
  
  public static void oe(int paramInt)
  {
    AppMethodBeat.i(93884);
    d.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.r(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(93884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.e
 * JD-Core Version:    0.7.0.1
 */