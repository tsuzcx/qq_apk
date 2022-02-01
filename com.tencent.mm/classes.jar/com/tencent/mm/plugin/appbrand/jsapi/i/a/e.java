package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> kWg;
  
  static
  {
    AppMethodBeat.i(143707);
    HashMap localHashMap = new HashMap();
    kWg = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    kWg.put("addMapMarkers", Integer.valueOf(1));
    kWg.put("removeMapMarkers", Integer.valueOf(2));
    kWg.put("addMapLines", Integer.valueOf(3));
    kWg.put("removeMapLines", Integer.valueOf(4));
    kWg.put("includeMapPoints", Integer.valueOf(5));
    kWg.put("addMapControls", Integer.valueOf(6));
    kWg.put("addMapPolygons", Integer.valueOf(7));
    kWg.put("getMapCenterLocation", Integer.valueOf(8));
    kWg.put("moveToMapLocation", Integer.valueOf(9));
    kWg.put("translateMapMarker", Integer.valueOf(10));
    kWg.put("getMapScale", Integer.valueOf(11));
    kWg.put("getMapRegion", Integer.valueOf(12));
    kWg.put("getMapRotate", Integer.valueOf(13));
    kWg.put("getMapSkew", Integer.valueOf(14));
    kWg.put("getMapIndoorFloor", Integer.valueOf(15));
    kWg.put("setMapIndoorFloor", Integer.valueOf(16));
    kWg.put("eraseMapLines", Integer.valueOf(17));
    kWg.put("moveMapMarkerAlong", Integer.valueOf(18));
    AppMethodBeat.o(143707);
  }
  
  public static void Qy(String paramString)
  {
    AppMethodBeat.i(143704);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143704);
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
        if (kWg.containsKey(paramString)) {
          i = ((Integer)kWg.get(paramString)).intValue() * 5 + 20 + 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        ae.e("Luggage.MapReporter", "key is -1, may be err");
        AppMethodBeat.o(143704);
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
      tk(i);
      ae.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(143704);
      return;
      i = -1;
    }
  }
  
  public static void d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143705);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143705);
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
        if (kWg.containsKey(paramString))
        {
          int j = ((Integer)kWg.get(paramString)).intValue();
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
        ae.e("Luggage.MapReporter", "key is -1, may be err");
        AppMethodBeat.o(143705);
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
      tk(i);
      ae.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(143705);
      return;
      i = -1;
    }
  }
  
  public static void tk(int paramInt)
  {
    AppMethodBeat.i(143706);
    ae.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.e
 * JD-Core Version:    0.7.0.1
 */