package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
{
  public List<n> a = null;
  public List<n> b = null;
  public String c;
  public List<n> d = null;
  public HashMap<String, List<n>> e = null;
  public HashMap<String, List<n>> f = null;
  
  public o()
  {
    h();
  }
  
  public static void k()
  {
    o localo = b.a;
    localo.c = "";
    localo.a = new ArrayList();
    b.a.b = new ArrayList();
    b.a.d = new ArrayList();
    b.a.e = new HashMap();
  }
  
  public static boolean l()
  {
    return (!TextUtils.isEmpty(p4.p().e().b())) && (!TextUtils.isEmpty(c6.s0().g()));
  }
  
  public static o m()
  {
    return b.a;
  }
  
  public m a(String paramString)
  {
    paramString = a(b(paramString));
    paramString.c = APTools.b(paramString.a);
    return paramString;
  }
  
  public m a(List<n> paramList)
  {
    m localm = new m();
    if (paramList == null) {
      return localm;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    try
    {
      while (j < paramList.size())
      {
        n localn = (n)paramList.get(j);
        i += i.b(localn.c());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("11 coupon name = ");
        localStringBuilder.append(localn.j);
        APLog.d("FFAIP-C", localStringBuilder.toString());
        if (TextUtils.isEmpty(localm.b)) {
          localm.b = localn.j;
        }
        j += 1;
      }
    }
    catch (Exception paramList)
    {
      APLog.i("getCouponCutDownCost", paramList.toString());
      i = k;
    }
    localm.a = i;
    return localm;
  }
  
  public void a()
  {
    try
    {
      e().clear();
      b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(String paramString, HashMap<String, List<n>> paramHashMap, n paramn)
  {
    if (paramHashMap == null) {
      return;
    }
    try
    {
      if (paramHashMap.get(paramString) == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramn);
        paramHashMap.put(paramString, localArrayList);
        return;
      }
      if (!a(paramn, (List)paramHashMap.get(paramString)))
      {
        ((List)paramHashMap.get(paramString)).add(paramn);
        return;
      }
    }
    catch (Exception paramString)
    {
      APLog.i("saveRecomMapByChannel", paramString.toString());
    }
  }
  
  public void a(List<n> paramList, HashMap<String, List<n>> paramHashMap)
  {
    if (paramList == null) {
      return;
    }
    int k = 0;
    while (k < paramList.size())
    {
      n localn = (n)paramList.get(k);
      List localList = localn.b();
      if ((!localList.contains("qbqd")) && (!localList.contains("qdqb")))
      {
        j = 0;
      }
      else
      {
        a("qbqd", paramHashMap, localn);
        a("qdqb", paramHashMap, localn);
        j = 1;
      }
      int i = j;
      if (localList.contains("qqwallet"))
      {
        a("qqwallet", paramHashMap, localn);
        i = j + 1;
      }
      int j = i;
      if (localList.contains("wechat"))
      {
        a("wechat", paramHashMap, localn);
        j = i + 1;
      }
      if (localList.contains("*"))
      {
        a("channellist", paramHashMap, localn);
        a("qbqd", paramHashMap, localn);
        a("qdqb", paramHashMap, localn);
        a("qqwallet", paramHashMap, localn);
        a("wechat", paramHashMap, localn);
      }
      if (j >= 2) {
        a("channellist", paramHashMap, localn);
      }
      k += 1;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject, this.a);
      b();
      if (paramJSONObject.has("recommend"))
      {
        paramJSONObject = paramJSONObject.getString("recommend");
        k(paramJSONObject);
        i(paramJSONObject);
        return;
      }
      k("");
      i("");
      return;
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("resolveCouponMpInfo err", paramJSONObject.toString());
    }
  }
  
  public void a(JSONObject paramJSONObject, List<n> paramList)
  {
    Object localObject1 = "status";
    Object localObject5 = "code_id";
    Object localObject2 = "batch_id";
    String str3 = "least_price";
    String str4 = "name";
    String str2 = "rank_type";
    String str1 = "amt";
    Object localObject3 = "card_id";
    Object localObject4 = "allow_pay_channel";
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        boolean bool = paramJSONObject.has("coupons");
        if (bool)
        {
          JSONArray localJSONArray1 = paramJSONObject.getJSONArray("coupons");
          i = 0;
          paramJSONObject = (JSONObject)localObject5;
          if (i < localJSONArray1.length())
          {
            localObject5 = (JSONObject)localJSONArray1.get(i);
            if (!((JSONObject)localObject5).has((String)localObject3)) {
              break label708;
            }
            String str7 = ((JSONObject)localObject5).getString((String)localObject3);
            if (!((JSONObject)localObject5).has(str1)) {
              break label708;
            }
            String str8 = ((JSONObject)localObject5).getString(str1);
            if (!((JSONObject)localObject5).has((String)localObject4)) {
              break label583;
            }
            localObject6 = ((JSONObject)localObject5).getString((String)localObject4);
            if (!((JSONObject)localObject5).has(str2)) {
              break label590;
            }
            localObject7 = ((JSONObject)localObject5).getString(str2);
            if (!((JSONObject)localObject5).has(str4)) {
              break label597;
            }
            str5 = ((JSONObject)localObject5).getString(str4);
            if (!((JSONObject)localObject5).has(str3)) {
              break label604;
            }
            str6 = ((JSONObject)localObject5).getString(str3);
            JSONArray localJSONArray2 = ((JSONObject)localObject5).getJSONArray("card_info");
            j = 0;
            localObject5 = localObject2;
            localObject2 = localObject7;
            if (j >= localJSONArray2.length()) {
              break label697;
            }
            Object localObject9 = (JSONObject)localJSONArray2.get(j);
            if (!((JSONObject)localObject9).has((String)localObject5)) {
              break label640;
            }
            localObject8 = ((JSONObject)localObject9).getString((String)localObject5);
            localObject7 = localObject6;
            if (((JSONObject)localObject9).has((String)localObject4))
            {
              localObject7 = localObject6;
              if (!TextUtils.isEmpty(((JSONObject)localObject9).getString((String)localObject4))) {
                localObject7 = ((JSONObject)localObject9).getString((String)localObject4);
              }
            }
            localObject6 = localObject7;
            localObject7 = ((JSONObject)localObject9).getJSONArray("batch_info");
            k = 0;
            if (k >= ((JSONArray)localObject7).length()) {
              break label623;
            }
            Object localObject10 = (JSONObject)((JSONArray)localObject7).get(k);
            if (!((JSONObject)localObject10).has(paramJSONObject)) {
              break label614;
            }
            localObject9 = ((JSONObject)localObject10).getString(paramJSONObject);
            if (!((JSONObject)localObject10).has((String)localObject1)) {
              break label611;
            }
            localObject10 = ((JSONObject)localObject10).getString((String)localObject1);
            if ((TextUtils.isEmpty(str7)) || (TextUtils.isEmpty(str8)) || (TextUtils.isEmpty((CharSequence)localObject8)) || (TextUtils.isEmpty((CharSequence)localObject9))) {
              break label611;
            }
            n localn = new n();
            localn.d(str7);
            localn.b(str8);
            localn.a((String)localObject6);
            localn.a(h((String)localObject6));
            localn.g((String)localObject2);
            localn.j = APTools.a(str5, 1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("coupon name from json = ");
            localStringBuilder.append(str5);
            APLog.d("FFAIP-C", localStringBuilder.toString());
            localn.f(str6);
            localn.c((String)localObject8);
            localn.e((String)localObject9);
            localn.h((String)localObject10);
            paramList.add(localn);
            break label614;
          }
        }
        else
        {
          m().a();
          k("");
          i("");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        APLog.i("resolveCoupon", paramJSONObject.toString());
      }
      return;
      label583:
      Object localObject6 = "";
      continue;
      label590:
      Object localObject7 = "";
      continue;
      label597:
      String str5 = "";
      continue;
      label604:
      String str6 = "";
      continue;
      label611:
      label614:
      k += 1;
      continue;
      label623:
      localObject7 = localObject2;
      localObject2 = localObject1;
      localObject1 = paramJSONObject;
      paramJSONObject = (JSONObject)localObject7;
      break label654;
      label640:
      localObject7 = localObject2;
      localObject2 = localObject1;
      localObject1 = paramJSONObject;
      paramJSONObject = (JSONObject)localObject7;
      label654:
      j += 1;
      localObject7 = localObject3;
      Object localObject8 = localObject4;
      localObject3 = localObject2;
      localObject4 = localObject1;
      localObject2 = paramJSONObject;
      localObject1 = localObject3;
      paramJSONObject = (JSONObject)localObject4;
      localObject3 = localObject7;
      localObject4 = localObject8;
      continue;
      label697:
      localObject2 = localObject4;
      localObject4 = localObject5;
      break label720;
      label708:
      localObject5 = localObject2;
      localObject2 = localObject4;
      localObject4 = localObject5;
      label720:
      i += 1;
      localObject5 = localObject4;
      localObject4 = localObject2;
      localObject2 = localObject5;
    }
  }
  
  public boolean a(String paramString, List<n> paramList)
  {
    if (paramList == null) {
      return true;
    }
    int i = 0;
    while (i < paramList.size())
    {
      new ArrayList();
      List localList = ((n)paramList.get(i)).b();
      if ((!localList.contains(paramString)) && (!localList.contains("*"))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean a(n paramn)
  {
    if (paramn == null) {
      return false;
    }
    return (!TextUtils.isEmpty(paramn.f())) && (!TextUtils.isEmpty(paramn.c())) && (!TextUtils.isEmpty(paramn.d())) && (!TextUtils.isEmpty(paramn.e()));
  }
  
  public boolean a(n paramn, List<n> paramList)
  {
    if (paramn != null)
    {
      if (paramList == null) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (paramn.f().equals(((n)paramList.get(i)).f())) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public List<n> b(String paramString)
  {
    if (d(paramString)) {
      return b((List)c().get(paramString));
    }
    if (f(paramString)) {
      return b((List)f().get(paramString));
    }
    return null;
  }
  
  public List<n> b(List<n> paramList)
  {
    Object localObject = p4.p().e();
    localObject = ((o4)localObject).c.b(((o4)localObject).f.f);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      try
      {
        float f1 = i.a((String)localObject) * 100.0F;
        float f2 = i.a(((n)paramList.get(i)).g());
        String str = ((n)paramList.get(i)).h();
        if ("range".equals(str))
        {
          if ((f1 > f2) || (Float.compare(f1, f2) == 0)) {
            localArrayList.add(paramList.get(i));
          }
        }
        else if (("rank".equals(str)) && (Float.compare(f1, f2) == 0)) {
          localArrayList.add(paramList.get(i));
        }
      }
      catch (Exception localException)
      {
        APLog.w("getCurrentValidCouponList", localException.toString());
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      d().clear();
      c().clear();
      g().clear();
      f().clear();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String c(String paramString)
  {
    List localList = b(paramString);
    paramString = "";
    Object localObject = paramString;
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(((n)localList.get(i)).f());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(((n)localList.get(i)).d());
        ((StringBuilder)localObject).append(";");
        paramString = ((StringBuilder)localObject).toString();
        i += 1;
      }
      localObject = APTools.b(paramString, 1);
    }
    return localObject;
  }
  
  public HashMap<String, List<n>> c()
  {
    return this.f;
  }
  
  public List<n> d()
  {
    return this.d;
  }
  
  public boolean d(String paramString)
  {
    if (d() == null) {
      return false;
    }
    if (c() == null) {
      return false;
    }
    return c().get(paramString) != null;
  }
  
  public List<n> e()
  {
    return this.a;
  }
  
  public boolean e(String paramString)
  {
    return ("qqwallet".equals(paramString)) || ("wechat".equals(paramString)) || ("qbqd".equals(paramString)) || ("qdqb".equals(paramString));
  }
  
  public HashMap<String, List<n>> f()
  {
    return this.e;
  }
  
  public boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!j()) {
      return false;
    }
    if (f() == null) {
      return false;
    }
    return f().get(paramString) != null;
  }
  
  public List<n> g()
  {
    return this.b;
  }
  
  public boolean g(String paramString)
  {
    return b(paramString) != null;
  }
  
  public List<String> h(String paramString)
  {
    paramString = paramString.split(",");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      localArrayList.add(paramString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public final void h()
  {
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.d = new ArrayList();
    this.e = new HashMap();
    this.f = new HashMap();
  }
  
  public void i(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      g().clear();
      f().clear();
      return;
    }
    paramString = paramString.split(",");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      int j = 0;
      while (j < e().size())
      {
        if (((n)e().get(j)).f().equals(localObject))
        {
          localObject = new n();
          ((n)localObject).d(((n)e().get(j)).e());
          ((n)localObject).b(((n)e().get(j)).c());
          ((n)localObject).a(((n)e().get(j)).a());
          ((n)localObject).a(((n)e().get(j)).b());
          ((n)localObject).g(((n)e().get(j)).h());
          ((n)localObject).f(((n)e().get(j)).g());
          ((n)localObject).c(((n)e().get(j)).d());
          ((n)localObject).e(((n)e().get(j)).f());
          ((n)localObject).h(((n)e().get(j)).i());
          ((n)localObject).j = ((n)e().get(j)).j;
          g().add(localObject);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    a(g(), f());
  }
  
  public boolean i()
  {
    return (e() != null) && (e().size() > 0);
  }
  
  public void j(String paramString) {}
  
  public boolean j()
  {
    return (g() != null) && (e().size() > 0);
  }
  
  public void k(String paramString) {}
  
  public static class b
  {
    public static o a = new o(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o
 * JD-Core Version:    0.7.0.1
 */