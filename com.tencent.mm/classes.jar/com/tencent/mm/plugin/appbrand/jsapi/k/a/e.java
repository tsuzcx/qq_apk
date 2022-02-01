package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static final Map<String, Integer> mbp;
  
  static
  {
    AppMethodBeat.i(143707);
    HashMap localHashMap = new HashMap();
    mbp = localHashMap;
    localHashMap.put("addMapCircles", Integer.valueOf(0));
    mbp.put("addMapMarkers", Integer.valueOf(1));
    mbp.put("removeMapMarkers", Integer.valueOf(2));
    mbp.put("addMapLines", Integer.valueOf(3));
    mbp.put("removeMapLines", Integer.valueOf(4));
    mbp.put("includeMapPoints", Integer.valueOf(5));
    mbp.put("addMapControls", Integer.valueOf(6));
    mbp.put("addMapPolygons", Integer.valueOf(7));
    mbp.put("getMapCenterLocation", Integer.valueOf(8));
    mbp.put("moveToMapLocation", Integer.valueOf(9));
    mbp.put("translateMapMarker", Integer.valueOf(10));
    mbp.put("getMapScale", Integer.valueOf(11));
    mbp.put("getMapRegion", Integer.valueOf(12));
    mbp.put("getMapRotate", Integer.valueOf(13));
    mbp.put("getMapSkew", Integer.valueOf(14));
    mbp.put("getMapIndoorFloor", Integer.valueOf(15));
    mbp.put("setMapIndoorFloor", Integer.valueOf(16));
    mbp.put("eraseMapLines", Integer.valueOf(17));
    mbp.put("moveMapMarkerAlong", Integer.valueOf(18));
    AppMethodBeat.o(143707);
  }
  
  public static void ZZ(String paramString)
  {
    AppMethodBeat.i(143704);
    if (Util.isNullOrNil(paramString))
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
        if (mbp.containsKey(paramString)) {
          i = ((Integer)mbp.get(paramString)).intValue() * 5 + 20 + 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i == -1)
      {
        Log.e("Luggage.MapReporter", "key is -1, may be err");
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
      xg(i);
      Log.v("Luggage.MapReporter", "name:%s invoke key:%d", new Object[] { paramString, Integer.valueOf(i) });
      AppMethodBeat.o(143704);
      return;
      i = -1;
    }
  }
  
  public static void e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(143705);
    if (Util.isNullOrNil(paramString))
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
        if (mbp.containsKey(paramString))
        {
          int j = ((Integer)mbp.get(paramString)).intValue();
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
        Log.e("Luggage.MapReporter", "key is -1, may be err");
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
      xg(i);
      Log.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i) });
      AppMethodBeat.o(143705);
      return;
      i = -1;
    }
  }
  
  public static void xg(int paramInt)
  {
    AppMethodBeat.i(143706);
    Log.v("Luggage.MapReporter", "reportKey:%d", new Object[] { Integer.valueOf(paramInt) });
    ((a)com.tencent.luggage.a.e.N(a.class)).idkeyStat(1020L, paramInt, 1L, false);
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a.e
 * JD-Core Version:    0.7.0.1
 */