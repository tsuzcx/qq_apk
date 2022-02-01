package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser.Deserializer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class ee
  implements JsonParser.Deserializer<List<LatLng>>
{
  private static List<LatLng> a(Object paramObject)
  {
    AppMethodBeat.i(221444);
    if (paramObject == null)
    {
      AppMethodBeat.o(221444);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (((paramObject.get(0) instanceof Double)) || ((paramObject.get(0) instanceof Integer)))
      {
        if (paramObject.length() < 2)
        {
          AppMethodBeat.o(221444);
          return null;
        }
        if (paramObject.length() == 2) {
          localArrayList.add(new LatLng(paramObject.getDouble(0), paramObject.getDouble(1)));
        }
      }
      while (!(paramObject.get(0) instanceof JSONArray)) {
        for (;;)
        {
          AppMethodBeat.o(221444);
          return localArrayList;
          localArrayList.add(new LatLng(paramObject.getDouble(0), paramObject.getDouble(1), paramObject.getDouble(2)));
        }
      }
      int i = 0;
      label157:
      JSONArray localJSONArray;
      if (i < paramObject.length())
      {
        localJSONArray = (JSONArray)paramObject.get(i);
        if (localJSONArray.length() < 2)
        {
          AppMethodBeat.o(221444);
          return null;
        }
        if (localJSONArray.length() <= 2) {
          break label233;
        }
        localArrayList.add(new LatLng(localJSONArray.getDouble(0), localJSONArray.getDouble(1), localJSONArray.getDouble(2)));
      }
      for (;;)
      {
        i += 1;
        break label157;
        break;
        label233:
        localArrayList.add(new LatLng(localJSONArray.getDouble(0), localJSONArray.getDouble(1)));
      }
    }
    AppMethodBeat.o(221444);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ee
 * JD-Core Version:    0.7.0.1
 */