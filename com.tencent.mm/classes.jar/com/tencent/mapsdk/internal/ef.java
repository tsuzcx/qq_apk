package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonParser.Deserializer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class ef
  implements JsonParser.Deserializer<List<WeightedLatLng>>
{
  private static List<WeightedLatLng> a(Object paramObject)
  {
    AppMethodBeat.i(221442);
    if (paramObject == null)
    {
      AppMethodBeat.o(221442);
      return null;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      if (paramObject.length() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramObject.length())
        {
          localArrayList.add(Double.valueOf(paramObject.optDouble(i)));
          i += 1;
        }
        paramObject = a(localArrayList);
        AppMethodBeat.o(221442);
        return paramObject;
      }
    }
    AppMethodBeat.o(221442);
    return null;
  }
  
  private static List<WeightedLatLng> a(List<Double> paramList)
  {
    AppMethodBeat.i(221430);
    if (paramList.size() < 3)
    {
      AppMethodBeat.o(221430);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WeightedLatLng(new LatLng(((Double)paramList.get(0)).doubleValue(), ((Double)paramList.get(1)).doubleValue()), ((Double)paramList.get(2)).doubleValue()));
    int i = 3;
    while (i < paramList.size())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)localArrayList.get(i / 3 - 1);
      double d1 = localWeightedLatLng.getPoint().latitude;
      double d2 = ((Double)paramList.get(i)).doubleValue() / 1000000.0D;
      double d3 = localWeightedLatLng.getPoint().longitude;
      double d4 = ((Double)paramList.get(i + 1)).doubleValue() / 1000000.0D;
      double d5 = localWeightedLatLng.getIntensity();
      double d6 = ((Double)paramList.get(i + 2)).doubleValue() / 100.0D;
      localArrayList.add(new WeightedLatLng(new LatLng(d1 + d2, d3 + d4), d6 + d5));
      i += 3;
    }
    AppMethodBeat.o(221430);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ef
 * JD-Core Version:    0.7.0.1
 */