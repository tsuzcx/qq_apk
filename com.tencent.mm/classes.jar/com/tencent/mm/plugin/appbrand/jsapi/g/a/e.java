package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> jVF;
  
  static
  {
    AppMethodBeat.i(143707);
    HashMap localHashMap = new HashMap();
    jVF = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    jVF.put("addMapMarkers", Integer.valueOf(1));
    jVF.put("removeMapMarkers", Integer.valueOf(2));
    jVF.put("addMapLines", Integer.valueOf(3));
    jVF.put("removeMapLines", Integer.valueOf(4));
    jVF.put("includeMapPoints", Integer.valueOf(5));
    jVF.put("addMapControls", Integer.valueOf(6));
    jVF.put("addMapPolygons", Integer.valueOf(7));
    jVF.put("getMapCenterLocation", Integer.valueOf(8));
    jVF.put("moveToMapLocation", Integer.valueOf(9));
    jVF.put("translateMapMarker", Integer.valueOf(10));
    jVF.put("getMapScale", Integer.valueOf(11));
    jVF.put("getMapRegion", Integer.valueOf(12));
    jVF.put("getMapRotate", Integer.valueOf(13));
    jVF.put("getMapSkew", Integer.valueOf(14));
    jVF.put("getMapIndoorFloor", Integer.valueOf(15));
    jVF.put("setMapIndoorFloor", Integer.valueOf(16));
    jVF.put("eraseMapLines", Integer.valueOf(17));
    jVF.put("moveMapMarkerAlong", Integer.valueOf(18));
    AppMethodBeat.o(143707);
  }
  
  public static void Im(String paramString)
  {
    AppMethodBeat.i(143704);
    if (bt.isNullOrNil(paramString))
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
        if (jVF.containsKey(paramString)) {
          i = ((Integer)jVF.get(paramString)).intValue() * 5 + 20 + 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        ad.e("Luggage.MapReporter", "key is -1, may be err");
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
      rO(i);
      ad.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(143704);
      return;
      i = -1;
    }
  }
  
  public static void c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143705);
    if (bt.isNullOrNil(paramString))
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
        if (jVF.containsKey(paramString))
        {
          int j = ((Integer)jVF.get(paramString)).intValue();
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
        ad.e("Luggage.MapReporter", "key is -1, may be err");
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
      rO(i);
      ad.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(143705);
      return;
      i = -1;
    }
  }
  
  public static void rO(int paramInt)
  {
    AppMethodBeat.i(143706);
    ad.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.e
 * JD-Core Version:    0.7.0.1
 */