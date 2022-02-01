package midas.x;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
{
  public ArrayList<b0> a = new ArrayList();
  public ArrayList<a0> b = new ArrayList();
  
  public q a(int paramInt)
  {
    int k = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((b0)this.a.get(i)).a == paramInt) {
        return (q)this.a.get(i);
      }
      i += 1;
    }
    int j = -1;
    Object localObject1 = null;
    i = k;
    while (i < this.b.size())
    {
      a0 locala0 = (a0)this.b.get(i);
      int m = locala0.a;
      k = j;
      Object localObject2 = localObject1;
      if (m < paramInt)
      {
        k = j;
        localObject2 = localObject1;
        if (m > j)
        {
          localObject2 = locala0;
          k = m;
        }
      }
      i += 1;
      j = k;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void a()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.b;
    if (localArrayList != null) {
      localArrayList.clear();
    }
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
        b0 localb0 = c(((JSONArray)localObject).getJSONObject(i));
        this.a.add(localb0);
        i += 1;
      }
      while (j < paramJSONObject.length())
      {
        localObject = b(paramJSONObject.getJSONObject(j));
        this.b.add(localObject);
        j += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public int b(int paramInt)
  {
    q localq = a(paramInt);
    if (localq != null) {
      return localq.a(paramInt);
    }
    return 0;
  }
  
  public final a0 b(JSONObject paramJSONObject)
  {
    a0 locala0 = new a0();
    try
    {
      if (paramJSONObject.has("num")) {
        locala0.a = i.b(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_ext")) {
        locala0.b = paramJSONObject.getString("send_ext");
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
          c0 localc0 = new c0();
          if (((JSONObject)localObject2).has("send_type")) {
            localc0.a = ((JSONObject)localObject2).getString("send_type");
          }
          if (((JSONObject)localObject2).has("send_num")) {
            localc0.b = Integer.parseInt(((JSONObject)localObject2).getString("send_num"));
          }
          localArrayList.add(localc0);
          i += 1;
        }
        locala0.d = localArrayList;
      }
      if (paramJSONObject.has("ex_send"))
      {
        localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject1 = (JSONObject)paramJSONObject.get(i);
          localObject2 = new w();
          if (((JSONObject)localObject1).has("name")) {
            ((w)localObject2).a = ((JSONObject)localObject1).getString("name");
          }
          if (((JSONObject)localObject1).has("num")) {
            ((w)localObject2).b = ((JSONObject)localObject1).getString("num");
          }
          localArrayList.add(localObject2);
          i += 1;
        }
        locala0.c = localArrayList;
      }
      return locala0;
    }
    catch (JSONException paramJSONObject) {}
    return locala0;
  }
  
  public boolean b()
  {
    int j = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((b0)this.a.get(i)).b())
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
      if (((a0)this.b.get(i)).b()) {
        return true;
      }
      i += 1;
    }
    return bool;
  }
  
  public final b0 c(JSONObject paramJSONObject)
  {
    b0 localb0 = new b0();
    try
    {
      if (paramJSONObject.has("num")) {
        localb0.a = i.b(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_type"))
      {
        localb0.d = paramJSONObject.getString("send_type");
        if (localb0.d.equals("2"))
        {
          if (paramJSONObject.has("send_num")) {
            localb0.e = i.b(paramJSONObject.getString("send_num"));
          }
        }
        else if ((localb0.d.equals("1")) && (paramJSONObject.has("send_rate"))) {
          localb0.e = i.b(paramJSONObject.getString("send_rate"));
        }
      }
      if (paramJSONObject.has("send_ext")) {
        localb0.b = paramJSONObject.getString("send_ext");
      }
      if (paramJSONObject.has("ex_send"))
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          w localw = new w();
          if (localJSONObject.has("name")) {
            localw.a = localJSONObject.getString("name");
          }
          if (localJSONObject.has("num")) {
            localw.b = localJSONObject.getString("num");
          }
          localArrayList.add(localw);
          i += 1;
        }
        localb0.c = localArrayList;
      }
      return localb0;
    }
    catch (Exception paramJSONObject) {}
    return localb0;
  }
  
  public boolean c()
  {
    int j = 0;
    int i = 0;
    while (i < this.a.size())
    {
      if (((b0)this.a.get(i)).c())
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
      if (((a0)this.b.get(i)).c()) {
        return true;
      }
      i += 1;
    }
    return bool;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.a;
    boolean bool1;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localArrayList = this.b;
    boolean bool2 = bool1;
    if (localArrayList != null)
    {
      bool2 = bool1;
      if (localArrayList.size() > 0) {
        bool2 = false;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s
 * JD-Core Version:    0.7.0.1
 */