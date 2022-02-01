package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> kwr;
  
  static
  {
    AppMethodBeat.i(143707);
    HashMap localHashMap = new HashMap();
    kwr = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    kwr.put("addMapMarkers", Integer.valueOf(1));
    kwr.put("removeMapMarkers", Integer.valueOf(2));
    kwr.put("addMapLines", Integer.valueOf(3));
    kwr.put("removeMapLines", Integer.valueOf(4));
    kwr.put("includeMapPoints", Integer.valueOf(5));
    kwr.put("addMapControls", Integer.valueOf(6));
    kwr.put("addMapPolygons", Integer.valueOf(7));
    kwr.put("getMapCenterLocation", Integer.valueOf(8));
    kwr.put("moveToMapLocation", Integer.valueOf(9));
    kwr.put("translateMapMarker", Integer.valueOf(10));
    kwr.put("getMapScale", Integer.valueOf(11));
    kwr.put("getMapRegion", Integer.valueOf(12));
    kwr.put("getMapRotate", Integer.valueOf(13));
    kwr.put("getMapSkew", Integer.valueOf(14));
    kwr.put("getMapIndoorFloor", Integer.valueOf(15));
    kwr.put("setMapIndoorFloor", Integer.valueOf(16));
    kwr.put("eraseMapLines", Integer.valueOf(17));
    kwr.put("moveMapMarkerAlong", Integer.valueOf(18));
    AppMethodBeat.o(143707);
  }
  
  public static void Mr(String paramString)
  {
    AppMethodBeat.i(143704);
    if (bs.isNullOrNil(paramString))
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
        if (kwr.containsKey(paramString)) {
          i = ((Integer)kwr.get(paramString)).intValue() * 5 + 20 + 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        ac.e("Luggage.MapReporter", "key is -1, may be err");
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
      sE(i);
      ac.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(143704);
      return;
      i = -1;
    }
  }
  
  public static void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143705);
    if (bs.isNullOrNil(paramString))
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
        if (kwr.containsKey(paramString))
        {
          int j = ((Integer)kwr.get(paramString)).intValue();
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
        ac.e("Luggage.MapReporter", "key is -1, may be err");
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
      sE(i);
      ac.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(143705);
      return;
      i = -1;
    }
  }
  
  public static void sE(int paramInt)
  {
    AppMethodBeat.i(143706);
    ac.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.e
 * JD-Core Version:    0.7.0.1
 */