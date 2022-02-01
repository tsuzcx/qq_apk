package c.t.m.g;

import android.os.Bundle;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cc
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public cf c;
  
  cc() {}
  
  public cc(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new cf(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              ce localce = new ce(paramJSONObject.getJSONObject(i));
              this.b.add(localce);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = cf.a;
              cj.b("DetailsData", "DetailsData: unknown json " + paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          cj.a("DetailsData", "json error", paramJSONObject);
        }
      }
    }
  }
  
  private static cf a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    cf localcf;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localcf = cf.a(cf.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localcf.b = ((JSONObject)localObject1).optString("n");
        localcf.d = ((JSONObject)localObject1).optString("p");
        localcf.e = ((JSONObject)localObject1).optString("c");
        localcf.f = ((JSONObject)localObject1).optString("d");
        localcf.c = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localcf.k.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localcf.k.putParcelable("addrdesp.landmark", new ca((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localcf.k.putParcelable("addrdesp.second_landmark", new ca((JSONObject)localObject1));
        }
      }
      localObject1 = localcf;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new ca(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((ca)localObject2).b)) {
        localcf.i = ((ca)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((ca)localObject2).b)) {
          localcf.j = ((ca)localObject2).a;
        }
      }
    }
    localcf.k.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localcf;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.cc
 * JD-Core Version:    0.7.0.1
 */