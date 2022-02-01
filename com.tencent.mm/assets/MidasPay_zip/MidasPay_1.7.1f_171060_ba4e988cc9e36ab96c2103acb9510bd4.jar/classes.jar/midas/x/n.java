package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class n
{
  private boolean a = false;
  private String b = "";
  private List<m> c = null;
  private List<m> d = null;
  private String e = "";
  private List<m> f = null;
  private HashMap<String, List<m>> g = null;
  private HashMap<String, List<m>> h = null;
  
  private n()
  {
    m();
  }
  
  public static n a()
  {
    return a.a;
  }
  
  public static void b()
  {
    a.a.e = "";
    a.a.c = new ArrayList();
    a.a.d = new ArrayList();
    a.a.f = new ArrayList();
    a.a.g = new HashMap();
  }
  
  public static boolean l()
  {
    return (!TextUtils.isEmpty(ed.b().n().b())) && (!TextUtils.isEmpty(fp.a().D()));
  }
  
  private void m()
  {
    this.e = "";
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.f = new ArrayList();
    this.g = new HashMap();
    this.h = new HashMap();
  }
  
  public int a(List<m> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    try
    {
      while (i < paramList.size())
      {
        int k = i.a(((m)paramList.get(i)).b());
        j += k;
        i += 1;
      }
      return j;
    }
    catch (Exception paramList)
    {
      APLog.i("getCouponCutDownCost", paramList.toString());
    }
    return 0;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString, HashMap<String, List<m>> paramHashMap, m paramm)
  {
    if (paramHashMap == null) {
      return;
    }
    try
    {
      if (paramHashMap.get(paramString) == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramm);
        paramHashMap.put(paramString, localArrayList);
        return;
      }
      if (!a(paramm, (List)paramHashMap.get(paramString)))
      {
        ((List)paramHashMap.get(paramString)).add(paramm);
        return;
      }
    }
    catch (Exception paramString)
    {
      APLog.i("saveRecomMapByChannel", paramString.toString());
    }
  }
  
  public void a(List<m> paramList, HashMap<String, List<m>> paramHashMap)
  {
    if (paramList == null) {
      return;
    }
    int k = 0;
    while (k < paramList.size())
    {
      m localm = (m)paramList.get(k);
      List localList = localm.f();
      if ((!localList.contains("qbqd")) && (!localList.contains("qdqb")))
      {
        j = 0;
      }
      else
      {
        a("qbqd", paramHashMap, localm);
        a("qdqb", paramHashMap, localm);
        j = 1;
      }
      int i = j;
      if (localList.contains("qqwallet"))
      {
        a("qqwallet", paramHashMap, localm);
        i = j + 1;
      }
      int j = i;
      if (localList.contains("wechat"))
      {
        a("wechat", paramHashMap, localm);
        j = i + 1;
      }
      if (localList.contains("*"))
      {
        a("channellist", paramHashMap, localm);
        a("qbqd", paramHashMap, localm);
        a("qdqb", paramHashMap, localm);
        a("qqwallet", paramHashMap, localm);
        a("wechat", paramHashMap, localm);
      }
      if (j >= 2) {
        a("channellist", paramHashMap, localm);
      }
      k += 1;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject, this.c);
      j();
      if (paramJSONObject.has("recommend"))
      {
        paramJSONObject = paramJSONObject.getString("recommend");
        a(paramJSONObject);
        b(paramJSONObject);
        return;
      }
      a("");
      b("");
      return;
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("resolveCouponMpInfo err", paramJSONObject.toString());
    }
  }
  
  public void a(JSONObject paramJSONObject, List<m> paramList)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      Object localObject1;
      int j;
      Object localObject4;
      int k;
      try
      {
        if (paramJSONObject.has("coupons"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("coupons");
          i = 0;
          if (i < paramJSONObject.length())
          {
            localObject2 = "";
            String str1 = "";
            String str2 = "";
            localObject3 = (JSONObject)paramJSONObject.get(i);
            localObject1 = paramJSONObject;
            if (!((JSONObject)localObject3).has("card_id")) {
              break label514;
            }
            String str3 = ((JSONObject)localObject3).getString("card_id");
            localObject1 = paramJSONObject;
            if (!((JSONObject)localObject3).has("amt")) {
              break label514;
            }
            String str4 = ((JSONObject)localObject3).getString("amt");
            localObject1 = localObject2;
            if (((JSONObject)localObject3).has("allow_pay_channel")) {
              localObject1 = ((JSONObject)localObject3).getString("allow_pay_channel");
            }
            if (((JSONObject)localObject3).has("rank_type")) {
              str1 = ((JSONObject)localObject3).getString("rank_type");
            }
            if (((JSONObject)localObject3).has("least_price")) {
              str2 = ((JSONObject)localObject3).getString("least_price");
            }
            JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("card_info");
            j = 0;
            localObject2 = localObject1;
            localObject1 = paramJSONObject;
            if (j >= localJSONArray.length()) {
              break label514;
            }
            Object localObject5 = (JSONObject)localJSONArray.get(j);
            localObject3 = paramJSONObject;
            localObject4 = localObject2;
            if (!((JSONObject)localObject5).has("batch_id")) {
              break label498;
            }
            String str5 = ((JSONObject)localObject5).getString("batch_id");
            localObject1 = localObject2;
            if (((JSONObject)localObject5).has("allow_pay_channel"))
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(((JSONObject)localObject5).getString("allow_pay_channel"))) {
                localObject1 = ((JSONObject)localObject5).getString("allow_pay_channel");
              }
            }
            localObject2 = ((JSONObject)localObject5).getJSONArray("batch_info");
            k = 0;
            localObject3 = paramJSONObject;
            localObject4 = localObject1;
            if (k >= ((JSONArray)localObject2).length()) {
              break label498;
            }
            localObject4 = (JSONObject)((JSONArray)localObject2).get(k);
            if (!((JSONObject)localObject4).has("code_id")) {
              break label489;
            }
            localObject3 = ((JSONObject)localObject4).getString("code_id");
            if (!((JSONObject)localObject4).has("status")) {
              break label489;
            }
            localObject4 = ((JSONObject)localObject4).getString("status");
            if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              break label489;
            }
            localObject5 = new m();
            ((m)localObject5).a(str3);
            ((m)localObject5).b(str4);
            ((m)localObject5).d((String)localObject1);
            ((m)localObject5).a(f((String)localObject1));
            ((m)localObject5).e(str1);
            ((m)localObject5).c(str2);
            ((m)localObject5).f(str5);
            ((m)localObject5).g((String)localObject3);
            ((m)localObject5).h((String)localObject4);
            paramList.add(localObject5);
            break label489;
          }
        }
        else
        {
          a().k();
          a("");
          b("");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        APLog.i("resolveCoupon", paramJSONObject.toString());
      }
      return;
      label489:
      k += 1;
      continue;
      label498:
      j += 1;
      paramJSONObject = (JSONObject)localObject3;
      Object localObject2 = localObject4;
      continue;
      label514:
      i += 1;
      paramJSONObject = (JSONObject)localObject1;
    }
  }
  
  public boolean a(String paramString, List<m> paramList)
  {
    if (paramList == null) {
      return true;
    }
    int i = 0;
    while (i < paramList.size())
    {
      new ArrayList();
      List localList = ((m)paramList.get(i)).f();
      if ((!localList.contains(paramString)) && (!localList.contains("*"))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean a(m paramm)
  {
    if (paramm == null) {
      return false;
    }
    return (!TextUtils.isEmpty(paramm.h())) && (!TextUtils.isEmpty(paramm.b())) && (!TextUtils.isEmpty(paramm.g())) && (!TextUtils.isEmpty(paramm.a()));
  }
  
  public boolean a(m paramm, List<m> paramList)
  {
    if (paramm != null)
    {
      if (paramList == null) {
        return false;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (paramm.h().equals(((m)paramList.get(i)).h())) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return false;
  }
  
  public List<m> b(List<m> paramList)
  {
    Object localObject = ed.b().n();
    localObject = ((ec)localObject).b.b(((ec)localObject).e.g);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      try
      {
        float f1 = i.c((String)localObject) * 100.0F;
        float f2 = i.c(((m)paramList.get(i)).c());
        String str = ((m)paramList.get(i)).e();
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
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      d().clear();
      e().clear();
      return;
    }
    paramString = paramString.split(",");
    int i = 0;
    while (i < paramString.length)
    {
      Object localObject = paramString[i];
      int j = 0;
      while (j < c().size())
      {
        if (((m)c().get(j)).h().equals(localObject))
        {
          localObject = new m();
          ((m)localObject).a(((m)c().get(j)).a());
          ((m)localObject).b(((m)c().get(j)).b());
          ((m)localObject).d(((m)c().get(j)).d());
          ((m)localObject).a(((m)c().get(j)).f());
          ((m)localObject).e(((m)c().get(j)).e());
          ((m)localObject).c(((m)c().get(j)).c());
          ((m)localObject).f(((m)c().get(j)).g());
          ((m)localObject).g(((m)c().get(j)).h());
          ((m)localObject).h(((m)c().get(j)).i());
          d().add(localObject);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    a(d(), e());
  }
  
  public List<m> c()
  {
    return this.c;
  }
  
  public boolean c(String paramString)
  {
    return h(paramString) != null;
  }
  
  public List<m> d()
  {
    return this.d;
  }
  
  public boolean d(String paramString)
  {
    if (f() == null) {
      return false;
    }
    if (i() == null) {
      return false;
    }
    return i().get(paramString) != null;
  }
  
  public HashMap<String, List<m>> e()
  {
    return this.g;
  }
  
  public boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!g()) {
      return false;
    }
    if (e() == null) {
      return false;
    }
    return e().get(paramString) != null;
  }
  
  public List<m> f()
  {
    return this.f;
  }
  
  public List<String> f(String paramString)
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
  
  public String g(String paramString)
  {
    return APTools.a(a(h(paramString)));
  }
  
  public boolean g()
  {
    return (d() != null) && (c().size() > 0);
  }
  
  public List<m> h(String paramString)
  {
    if (d(paramString)) {
      return b((List)i().get(paramString));
    }
    if (e(paramString)) {
      return b((List)e().get(paramString));
    }
    return null;
  }
  
  public boolean h()
  {
    return (c() != null) && (c().size() > 0);
  }
  
  public String i(String paramString)
  {
    List localList = h(paramString);
    paramString = "";
    Object localObject = paramString;
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(((m)localList.get(i)).h());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(((m)localList.get(i)).g());
        ((StringBuilder)localObject).append(";");
        paramString = ((StringBuilder)localObject).toString();
        i += 1;
      }
      localObject = APTools.a(paramString, 1);
    }
    return localObject;
  }
  
  public HashMap<String, List<m>> i()
  {
    return this.h;
  }
  
  public void j()
  {
    try
    {
      f().clear();
      i().clear();
      d().clear();
      e().clear();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean j(String paramString)
  {
    return ("qqwallet".equals(paramString)) || ("wechat".equals(paramString)) || ("qbqd".equals(paramString)) || ("qdqb".equals(paramString));
  }
  
  public void k()
  {
    try
    {
      c().clear();
      j();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k(String paramString)
  {
    this.e = paramString;
  }
  
  static class a
  {
    static n a = new n(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.n
 * JD-Core Version:    0.7.0.1
 */