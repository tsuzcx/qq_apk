package c.t.m.g;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bz
  extends bq
{
  private static boolean a = false;
  
  public final void a(bm parambm)
  {
    Object localObject3 = new bp();
    Object localObject2 = new bo();
    Object localObject1 = new bn();
    try
    {
      if ((cm.a(((bo)localObject2).b)) || (!a))
      {
        parambm.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      for (;;)
      {
        if (cm.a(((bo)localObject2).b))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("model", ((bp)localObject3).a);
          localJSONObject.put("osVersion", ((bp)localObject3).b);
          localJSONObject.put("imei", ((bp)localObject3).c);
          localJSONObject.put("imsi", ((bp)localObject3).d);
          localJSONObject.put("pseudoId", ((bp)localObject3).e);
          parambm.a.put("RegistDeviceInfo", localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("platform", ((bo)localObject2).a);
        ((JSONObject)localObject3).put("deviceId", ((bo)localObject2).b);
        ((JSONObject)localObject3).put("sdkVersion", ((bo)localObject2).c);
        parambm.a.put("BindDeviceInfo", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("bundle", ((bn)localObject1).a);
        ((JSONObject)localObject2).put("verCode", ((bn)localObject1).b);
        ((JSONObject)localObject2).put("verName", ((bn)localObject1).c);
        ((JSONObject)localObject2).put("appId", ((bn)localObject1).e);
        ((JSONObject)localObject2).put("uuid", ((bn)localObject1).d);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        parambm.a.put("AppState", localObject1);
        localObject1 = cj.a(x.g());
        parambm.a.put("netType", localObject1);
        localObject1 = bk.a(x.j().intValue());
        parambm.a.put("oper", localObject1);
        return;
        parambm.a.put("needUpdateState", Integer.valueOf(0));
      }
      return;
    }
    catch (Exception parambm) {}
  }
  
  public final void a(JSONObject arg1)
  {
    try
    {
      String str1 = ???.optString("result");
      boolean bool = TextUtils.isEmpty(str1);
      if (!bool) {
        try
        {
          if (Integer.parseInt(str1) == 1002)
          {
            cj.a("");
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
      String str2 = ???.optString("deviceId");
      Object localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject2 = cj.a();
        if ((!TextUtils.isEmpty(str2)) && (!str2.equals(localObject2))) {
          cj.a(str2);
        }
      }
      for (;;)
      {
        str2 = ???.optString("oper");
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        localObject2 = bk.a();
        String str3 = x.b();
        if ((cm.a(str3)) || ("unknown".equals(str3)) || (cm.a(str2)) || ("unknown".equals(str2))) {
          break;
        }
        synchronized (((bk)localObject2).a)
        {
          if (!str2.equals((String)((bk)localObject2).a.get(str3)))
          {
            ((bk)localObject2).a.put(str3, str2);
            str2 = ((bk)localObject2).b();
            cj.a("HalleyOperInfo_" + m.b(), str2);
          }
          return;
        }
        cj.a("");
      }
      return;
    }
    catch (Throwable ???) {}
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.bz
 * JD-Core Version:    0.7.0.1
 */