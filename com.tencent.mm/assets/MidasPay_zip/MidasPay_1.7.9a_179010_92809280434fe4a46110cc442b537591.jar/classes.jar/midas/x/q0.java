package midas.x;

import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class q0
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public String d = "";
  public String e = "";
  public boolean f = false;
  public String g = "";
  public String h = "";
  public String i = "";
  public int j = 0;
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      APLog.i("APMidasDownInfo", "resultData=reCheckInfo----jasonFormat---packageInfo");
      localObject1 = new ArrayList();
      a1 locala1 = new a1();
      paramJSONObject = paramJSONObject.getJSONObject("comm_config").getJSONArray("package_info");
      int m = paramJSONObject.length();
      int k = 0;
      while (k < m)
      {
        q0 localq0 = new q0();
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get(k);
        Object localObject2 = locala1.a(localJSONObject.getString("md5"));
        localq0.g = ((String)localObject2).substring(((String)localObject2).length() - 32);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("resultData=");
        ((StringBuilder)localObject2).append(localq0.g);
        APLog.i("APMidasDownInfo", ((StringBuilder)localObject2).toString());
        if (localJSONObject.has("download_url"))
        {
          localq0.e = localJSONObject.getString("download_url");
          if (localq0.e.startsWith("http://"))
          {
            localq0.e = localq0.e.replace("http://", "https://");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reCheckInfo() force https url = ");
            ((StringBuilder)localObject2).append(localq0.e);
            APLog.d("APMidasDownInfo", ((StringBuilder)localObject2).toString());
          }
        }
        boolean bool = localJSONObject.has("size");
        if (bool) {
          try
          {
            localq0.b = Integer.valueOf(localJSONObject.getString("size")).intValue();
          }
          catch (Exception localException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reCheckInfo e1 ");
            ((StringBuilder)localObject2).append(localException.toString());
            APLog.i("APMidasDownInfo", ((StringBuilder)localObject2).toString());
          }
        }
        ((ArrayList)localObject1).add(localq0);
        k += 1;
      }
      r0.p().a((ArrayList)localObject1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reCheckInfo e2 ");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      APLog.i("APMidasDownInfo", ((StringBuilder)localObject1).toString());
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    Object localObject2 = "0";
    Object localObject1 = "file_name";
    String str = "update_mode";
    for (;;)
    {
      int m;
      JSONObject localJSONObject;
      try
      {
        APLog.d("APMidasDownInfo", "Parse update info in json!");
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        locala1 = new a1();
        localJSONArray = paramJSONObject.getJSONObject("comm_config").optJSONArray("update_info");
        if (localJSONArray == null) {
          k = 0;
        } else {
          k = localJSONArray.length();
        }
      }
      catch (Exception paramJSONObject)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        a1 locala1;
        JSONArray localJSONArray;
        int k;
        q0 localq0;
        t0 localt0;
        Object localObject3;
        boolean bool;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reDownInfo e1 ");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        APLog.e("APMidasDownInfo", ((StringBuilder)localObject1).toString());
        return;
      }
      if (m < k)
      {
        localq0 = new q0();
        localt0 = new t0();
        localObject3 = (JSONObject)localJSONArray.get(m);
        localq0.a = ((JSONObject)localObject3).getString((String)localObject1);
        if (!c6.s0().h0())
        {
          if (localq0.a.startsWith("MidasCFT")) {
            break label1207;
          }
          localt0.a = ((JSONObject)localObject3).getString((String)localObject1);
          localq0.j = Integer.valueOf(((JSONObject)localObject3).getString("package_version_code")).intValue();
          if (((JSONObject)localObject3).getString(str).equals("1"))
          {
            r0.p().a(false);
          }
          else if (((JSONObject)localObject3).getString(str).equals("2"))
          {
            r0.p().a(true);
          }
          else if (((JSONObject)localObject3).getString(str).equals("3"))
          {
            r0.p().a(false);
            r0.p().f(true);
          }
          bool = ((JSONObject)localObject3).getString("is_split").equals(paramJSONObject);
          if (bool)
          {
            localq0.f = false;
            localq0.d = ((JSONObject)localObject3).getString("full_download_url");
            if (localq0.d.startsWith("http://"))
            {
              localq0.d = localq0.d.replace("http://", "https://");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("reDownInfo() force https url = ");
              ((StringBuilder)localObject2).append(localq0.d);
              APLog.d("APMidasDownInfo", ((StringBuilder)localObject2).toString());
            }
            try
            {
              localq0.b = Integer.valueOf(((JSONObject)localObject3).getString("size")).intValue();
            }
            catch (Exception localException1)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("reDownInfo e1 ");
              localStringBuilder2.append(localException1.toString());
              APLog.i("APMidasDownInfo", localStringBuilder2.toString());
            }
          }
          else if (((JSONObject)localObject3).getString("is_split").equals("1"))
          {
            localq0.d = ((JSONObject)localObject3).getString("split_download_url");
            if (localq0.d.startsWith("http://"))
            {
              localq0.d = localq0.d.replace("http://", "https://");
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("reDownInfo() force https down_url = ");
              localStringBuilder1.append(localq0.d);
              APLog.d("APMidasDownInfo", localStringBuilder1.toString());
            }
            localq0.e = ((JSONObject)localObject3).getString("full_download_url");
            if (localq0.e.startsWith("http://"))
            {
              localq0.e = localq0.e.replace("http://", "https://");
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("reDownInfo() force https full_url = ");
              localStringBuilder1.append(localq0.e);
              APLog.d("APMidasDownInfo", localStringBuilder1.toString());
            }
            localq0.f = true;
            try
            {
              localq0.b = Integer.valueOf(localObject3.getString("size").split("\\_")[0]).intValue();
              localq0.c = Integer.valueOf(localObject3.getString("size").split("\\_")[1]).intValue();
            }
            catch (Exception localException2)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("reDownInfo e1 ");
              localStringBuilder2.append(localException2.toString());
              APLog.i("APMidasDownInfo", localStringBuilder2.toString());
            }
          }
          localJSONObject = paramJSONObject;
          try
          {
            if (((JSONObject)localObject3).has("diff_md5"))
            {
              paramJSONObject = ((JSONObject)localObject3).getString("diff_md5");
              if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
              {
                paramJSONObject = locala1.a(((JSONObject)localObject3).getString("diff_md5"));
                localq0.i = paramJSONObject.substring(paramJSONObject.length() - 32);
              }
            }
            if (((JSONObject)localObject3).has("update_md5"))
            {
              paramJSONObject = ((JSONObject)localObject3).getString("update_md5");
              if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
              {
                localt0.b = ((JSONObject)localObject3).getString("update_md5");
                paramJSONObject = locala1.a(((JSONObject)localObject3).getString("update_md5"));
                localq0.h = paramJSONObject.substring(paramJSONObject.length() - 32);
              }
            }
          }
          catch (Exception paramJSONObject)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("reDownInfo e1 ");
            localStringBuilder2.append(paramJSONObject.toString());
            APLog.i("APMidasDownInfo", localStringBuilder2.toString());
          }
          try
          {
            paramJSONObject = ((JSONObject)localObject3).getString("is_rollback");
            try
            {
              if (paramJSONObject.equals(localJSONObject)) {
                paramJSONObject = r0.p();
              }
              try
              {
                paramJSONObject.c(false);
              }
              catch (Exception paramJSONObject)
              {
                continue;
              }
              if (!((JSONObject)localObject3).getString("is_rollback").equals("1")) {
                continue;
              }
              r0.p().c(true);
            }
            catch (Exception paramJSONObject) {}
            localObject3 = new StringBuilder();
          }
          catch (Exception paramJSONObject) {}
          ((StringBuilder)localObject3).append("reDownInfo e1 ");
          ((StringBuilder)localObject3).append(paramJSONObject.toString());
          APLog.i("APMidasDownInfo", ((StringBuilder)localObject3).toString());
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("Parse update info in json! Info = ");
          paramJSONObject.append(localq0.a);
          paramJSONObject.append(localq0.b);
          paramJSONObject.append("//");
          paramJSONObject.append(localq0.i);
          APLog.i("APMidasDownInfo", paramJSONObject.toString());
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("Parse update info in json! info = ");
          paramJSONObject.append(localq0.a);
          paramJSONObject.append("//");
          paramJSONObject.append(localq0.h);
          APLog.i("APMidasDownInfo", paramJSONObject.toString());
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("Parse update info in json! Down url = ");
          paramJSONObject.append(localq0.d);
          APLog.i("APMidasDownInfo", paramJSONObject.toString());
          localArrayList1.add(localq0);
          localArrayList2.add(localt0);
          paramJSONObject = localJSONObject;
          break label1207;
        }
      }
      else
      {
        r0.p().b(localArrayList1);
        r0.p().f(localArrayList2);
        return;
        m = 0;
        paramJSONObject = localJSONObject;
        continue;
      }
      continue;
      label1207:
      m += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (q0)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q0
 * JD-Core Version:    0.7.0.1
 */