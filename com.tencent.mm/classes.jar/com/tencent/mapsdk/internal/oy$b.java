package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonParser.Deserializer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public final class oy$b
  extends JsonComposer
  implements JsonParser.Deserializer<List<List<LatLng>>>
{
  @Json(name="type")
  String a;
  @Json(deserializer=b.class, name="coordinates")
  List<List<LatLng>> b;
  
  private static List<List<LatLng>> a(Object paramObject)
  {
    AppMethodBeat.i(222907);
    if (paramObject == null)
    {
      AppMethodBeat.o(222907);
      return null;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      ArrayList localArrayList1 = new ArrayList();
      int k = paramObject.length();
      int i = 0;
      while (i < k)
      {
        Object localObject1 = paramObject.get(i);
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject1 instanceof JSONArray))
        {
          localObject1 = (JSONArray)localObject1;
          int m = ((JSONArray)localObject1).length();
          int j = 0;
          while (j < m)
          {
            Object localObject2 = ((JSONArray)localObject1).get(j);
            if ((localObject2 instanceof JSONArray))
            {
              localObject2 = (JSONArray)localObject2;
              if (((JSONArray)localObject2).length() == 2) {
                localArrayList2.add(new LatLng(((JSONArray)localObject2).optDouble(1), ((JSONArray)localObject2).optDouble(0)));
              }
            }
            j += 1;
          }
          if (localArrayList2.size() != m) {
            kh.c("coordinates's data deserialize error!!");
          }
        }
        localArrayList1.add(localArrayList2);
        i += 1;
      }
      if (localArrayList1.size() != k) {
        kh.c("coordinates's area deserialize error!!");
      }
      AppMethodBeat.o(222907);
      return localArrayList1;
    }
    AppMethodBeat.o(222907);
    return null;
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(222917);
    Object localObject = null;
    int j;
    if (this.b != null)
    {
      j = this.b.size();
      localObject = new int[j];
      while (i < j)
      {
        localObject[i] = ((List)this.b.get(i)).size();
        i += 1;
      }
    }
    for (i = j;; i = 0)
    {
      StringBuffer localStringBuffer = new StringBuffer("AreaData{");
      localStringBuffer.append("type='").append(this.a).append('\'');
      localStringBuffer.append(", coordinates=").append(i).append("#").append(Arrays.toString((int[])localObject));
      localStringBuffer.append('}');
      localObject = localStringBuffer.toString();
      AppMethodBeat.o(222917);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oy.b
 * JD-Core Version:    0.7.0.1
 */