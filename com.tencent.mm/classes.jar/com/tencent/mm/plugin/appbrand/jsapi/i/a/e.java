package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> kSx;
  
  static
  {
    AppMethodBeat.i(143707);
    HashMap localHashMap = new HashMap();
    kSx = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    kSx.put("addMapMarkers", Integer.valueOf(1));
    kSx.put("removeMapMarkers", Integer.valueOf(2));
    kSx.put("addMapLines", Integer.valueOf(3));
    kSx.put("removeMapLines", Integer.valueOf(4));
    kSx.put("includeMapPoints", Integer.valueOf(5));
    kSx.put("addMapControls", Integer.valueOf(6));
    kSx.put("addMapPolygons", Integer.valueOf(7));
    kSx.put("getMapCenterLocation", Integer.valueOf(8));
    kSx.put("moveToMapLocation", Integer.valueOf(9));
    kSx.put("translateMapMarker", Integer.valueOf(10));
    kSx.put("getMapScale", Integer.valueOf(11));
    kSx.put("getMapRegion", Integer.valueOf(12));
    kSx.put("getMapRotate", Integer.valueOf(13));
    kSx.put("getMapSkew", Integer.valueOf(14));
    kSx.put("getMapIndoorFloor", Integer.valueOf(15));
    kSx.put("setMapIndoorFloor", Integer.valueOf(16));
    kSx.put("eraseMapLines", Integer.valueOf(17));
    kSx.put("moveMapMarkerAlong", Integer.valueOf(18));
    AppMethodBeat.o(143707);
  }
  
  public static void PP(String paramString)
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
        if (kSx.containsKey(paramString)) {
          i = ((Integer)kSx.get(paramString)).intValue() * 5 + 20 + 0;
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
      th(i);
      ad.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(143704);
      return;
      i = -1;
    }
  }
  
  public static void d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
        if (kSx.containsKey(paramString))
        {
          int j = ((Integer)kSx.get(paramString)).intValue();
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
      th(i);
      ad.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(143705);
      return;
      i = -1;
    }
  }
  
  public static void th(int paramInt)
  {
    AppMethodBeat.i(143706);
    ad.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.e
 * JD-Core Version:    0.7.0.1
 */