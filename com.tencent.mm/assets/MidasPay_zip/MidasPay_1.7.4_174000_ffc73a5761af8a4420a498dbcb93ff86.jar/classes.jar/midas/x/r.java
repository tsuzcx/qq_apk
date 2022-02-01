package midas.x;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class r
{
  public ArrayList<aa> a = new ArrayList();
  public ArrayList<z> b = new ArrayList();
  
  private aa b(JSONObject paramJSONObject)
  {
    aa localaa = new aa();
    try
    {
      if (paramJSONObject.has("num")) {
        localaa.a = i.a(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_type"))
      {
        localaa.d = paramJSONObject.getString("send_type");
        if (localaa.d.equals("2"))
        {
          if (paramJSONObject.has("send_num")) {
            localaa.e = i.a(paramJSONObject.getString("send_num"));
          }
        }
        else if ((localaa.d.equals("1")) && (paramJSONObject.has("send_rate"))) {
          localaa.e = i.a(paramJSONObject.getString("send_rate"));
        }
      }
      if (paramJSONObject.has("send_ext")) {
        localaa.b = paramJSONObject.getString("send_ext");
      }
      if (paramJSONObject.has("ex_send"))
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          v localv = new v();
          if (localJSONObject.has("name")) {
            localv.a = localJSONObject.getString("name");
          }
          if (localJSONObject.has("num")) {
            localv.b = localJSONObject.getString("num");
          }
          localArrayList.add(localv);
          i += 1;
        }
        localaa.c = localArrayList;
      }
      return localaa;
    }
    catch (Exception paramJSONObject) {}
    return localaa;
  }
  
  private z c(JSONObject paramJSONObject)
  {
    z localz = new z();
    try
    {
      if (paramJSONObject.has("num")) {
        localz.a = i.a(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_ext")) {
        localz.b = paramJSONObject.getString("send_ext");
      }
      boolean bool = paramJSONObject.has("coin");
      int j = 0;
      ArrayList localArrayList;
      Object localObject1;
      int i;
      Object localObject2;
      if (bool)
      {
        localArrayList = new ArrayList();
        localObject1 = paramJSONObject.getJSONArray("coin");
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          ab localab = new ab();
          if (((JSONObject)localObject2).has("send_type")) {
            localab.a = ((JSONObject)localObject2).getString("send_type");
          }
          if (((JSONObject)localObject2).has("send_num")) {
            localab.b = Integer.parseInt(((JSONObject)localObject2).getString("send_num"));
          }
          localArrayList.add(localab);
          i += 1;
        }
        localz.d = localArrayList;
      }
      if (paramJSONObject.has("ex_send"))
      {
        localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject1 = (JSONObject)paramJSONObject.get(i);
          localObject2 = new v();
          if (((JSONObject)localObject1).has("name")) {
            ((v)localObject2).a = ((JSONObject)localObject1).getString("name");
          }
          if (((JSONObject)localObject1).has("num")) {
            ((v)localObject2).b = ((JSONObject)localObject1).getString("num");
          }
          localArrayList.add(localObject2);
          i += 1;
        }
        localz.c = localArrayList;
      }
      return localz;
    }
    catch (JSONException paramJSONObject) {}
    return localz;
  }
  
  public p a(int paramInt)
  {
    int k = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((aa)this.a.get(i)).a == paramInt) {
        return (p)this.a.get(i);
      }
      i += 1;
    }
    int j = -1;
    Object localObject1 = null;
    i = k;
    while (i < this.b.size())
    {
      z localz = (z)this.b.get(i);
      k = j;
      Object localObject2 = localObject1;
      if (localz.a < paramInt)
      {
        k = j;
        localObject2 = localObject1;
        if (localz.a > j)
        {
          k = localz.a;
          localObject2 = localz;
        }
      }
      i += 1;
      j = k;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getJSONArray("rank_info");
      paramJSONObject = paramJSONObject.getJSONArray("range_info");
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        aa localaa = b(((JSONArray)localObject).getJSONObject(i));
        this.a.add(localaa);
        i += 1;
      }
      while (j < paramJSONObject.length())
      {
        localObject = c(paramJSONObject.getJSONObject(j));
        this.b.add(localObject);
        j += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public boolean a()
  {
    boolean bool1;
    if ((this.a != null) && (this.a.size() > 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.b != null)
    {
      bool2 = bool1;
      if (this.b.size() > 0) {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public int b(int paramInt)
  {
    p localp = a(paramInt);
    if (localp != null) {
      return localp.a(paramInt);
    }
    return 0;
  }
  
  public boolean b()
  {
    int j = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((aa)this.a.get(i)).b())
      {
        bool = true;
        i = j;
        break label50;
      }
      i += 1;
    }
    boolean bool = false;
    i = j;
    label50:
    while (i < this.b.size())
    {
      if (((z)this.b.get(i)).b()) {
        return true;
      }
      i += 1;
    }
    return bool;
  }
  
  public boolean c()
  {
    int j = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((aa)this.a.get(i)).c())
      {
        bool = true;
        i = j;
        break label50;
      }
      i += 1;
    }
    boolean bool = false;
    i = j;
    label50:
    while (i < this.b.size())
    {
      if (((z)this.b.get(i)).c()) {
        return true;
      }
      i += 1;
    }
    return bool;
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.r
 * JD-Core Version:    0.7.0.1
 */