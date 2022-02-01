package midas.x;

import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ap
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public String d = "";
  public String e = "";
  public boolean f = false;
  public boolean g = false;
  public String h = "";
  public String i = "";
  public String j = "";
  public int k = 0;
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int n;
      try
      {
        APLog.d("APMidasDownInfo", "Parse update info in json!");
        localObject = new ArrayList();
        localArrayList = new ArrayList();
        localaz = new az();
        paramJSONObject = paramJSONObject.getJSONObject("comm_config").optJSONArray("update_info");
        if (paramJSONObject == null) {
          m = 0;
        } else {
          m = paramJSONObject.length();
        }
      }
      catch (Exception paramJSONObject)
      {
        ArrayList localArrayList;
        az localaz;
        int m;
        ap localap;
        as localas;
        JSONObject localJSONObject;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder5;
        StringBuilder localStringBuilder3;
        StringBuilder localStringBuilder1;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reDownInfo e1 ");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        APLog.e("APMidasDownInfo", ((StringBuilder)localObject).toString());
        return;
      }
      if (n < m)
      {
        localap = new ap();
        localas = new as();
        localJSONObject = (JSONObject)paramJSONObject.get(n);
        localap.a = localJSONObject.getString("file_name");
        if ((fy.a().K()) || (!localap.a.startsWith("MidasCFT")))
        {
          localas.a = localJSONObject.getString("file_name");
          localap.k = Integer.valueOf(localJSONObject.getString("package_version_code")).intValue();
          if (localJSONObject.getString("update_mode").equals("1"))
          {
            localap.g = false;
            aq.a().a(false);
          }
          else if (localJSONObject.getString("update_mode").equals("2"))
          {
            localap.g = true;
            aq.a().a(true);
          }
          else if (localJSONObject.getString("update_mode").equals("3"))
          {
            localap.g = false;
            aq.a().a(false);
            aq.a().b(true);
          }
          if (localJSONObject.getString("is_split").equals("0"))
          {
            localap.f = false;
            localap.d = localJSONObject.getString("full_download_url");
            if (localap.d.startsWith("http://"))
            {
              localap.d = localap.d.replace("http://", "https://");
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("reDownInfo() force https url = ");
              localStringBuilder2.append(localap.d);
              APLog.d("APMidasDownInfo", localStringBuilder2.toString());
            }
            try
            {
              localap.b = Integer.valueOf(localJSONObject.getString("size")).intValue();
            }
            catch (Exception localException2)
            {
              localStringBuilder5 = new StringBuilder();
              localStringBuilder5.append("reDownInfo e1 ");
              localStringBuilder5.append(localException2.toString());
              APLog.i("APMidasDownInfo", localStringBuilder5.toString());
            }
          }
          else if (localJSONObject.getString("is_split").equals("1"))
          {
            localap.d = localJSONObject.getString("split_download_url");
            if (localap.d.startsWith("http://"))
            {
              localap.d = localap.d.replace("http://", "https://");
              localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("reDownInfo() force https down_url = ");
              localStringBuilder3.append(localap.d);
              APLog.d("APMidasDownInfo", localStringBuilder3.toString());
            }
            localap.e = localJSONObject.getString("full_download_url");
            if (localap.e.startsWith("http://"))
            {
              localap.e = localap.e.replace("http://", "https://");
              localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("reDownInfo() force https full_url = ");
              localStringBuilder3.append(localap.e);
              APLog.d("APMidasDownInfo", localStringBuilder3.toString());
            }
            localap.f = true;
            try
            {
              localap.b = Integer.valueOf(localJSONObject.getString("size").split("\\_")[0]).intValue();
              localap.c = Integer.valueOf(localJSONObject.getString("size").split("\\_")[1]).intValue();
            }
            catch (Exception localException3)
            {
              localStringBuilder5 = new StringBuilder();
              localStringBuilder5.append("reDownInfo e1 ");
              localStringBuilder5.append(localException3.toString());
              APLog.i("APMidasDownInfo", localStringBuilder5.toString());
            }
          }
          try
          {
            String str;
            if (localJSONObject.has("diff_md5"))
            {
              str = localJSONObject.getString("diff_md5");
              if ((str != null) && (str.length() > 0))
              {
                str = localaz.b(localJSONObject.getString("diff_md5"));
                localap.j = str.substring(str.length() - 32);
              }
            }
            if (localJSONObject.has("update_md5"))
            {
              str = localJSONObject.getString("update_md5");
              if ((str != null) && (str.length() > 0))
              {
                localas.b = localJSONObject.getString("update_md5");
                str = localaz.b(localJSONObject.getString("update_md5"));
                localap.i = str.substring(str.length() - 32);
              }
            }
          }
          catch (Exception localException4)
          {
            localStringBuilder5 = new StringBuilder();
            localStringBuilder5.append("reDownInfo e1 ");
            localStringBuilder5.append(localException4.toString());
            APLog.i("APMidasDownInfo", localStringBuilder5.toString());
          }
          try
          {
            if (localJSONObject.getString("is_rollback").equals("0")) {
              aq.a().c(false);
            } else if (localJSONObject.getString("is_rollback").equals("1")) {
              aq.a().c(true);
            }
          }
          catch (Exception localException1)
          {
            StringBuilder localStringBuilder4 = new StringBuilder();
            localStringBuilder4.append("reDownInfo e1 ");
            localStringBuilder4.append(localException1.toString());
            APLog.i("APMidasDownInfo", localStringBuilder4.toString());
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Parse update info in json! Info = ");
          localStringBuilder1.append(localap.a);
          localStringBuilder1.append(localap.b);
          localStringBuilder1.append("//");
          localStringBuilder1.append(localap.j);
          APLog.i("APMidasDownInfo", localStringBuilder1.toString());
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Parse update info in json! info = ");
          localStringBuilder1.append(localap.a);
          localStringBuilder1.append("//");
          localStringBuilder1.append(localap.i);
          APLog.i("APMidasDownInfo", localStringBuilder1.toString());
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Parse update info in json! Down url = ");
          localStringBuilder1.append(localap.d);
          APLog.i("APMidasDownInfo", localStringBuilder1.toString());
          ((ArrayList)localObject).add(localap);
          localArrayList.add(localas);
        }
      }
      else
      {
        aq.a().a((ArrayList)localObject);
        aq.a().c(localArrayList);
        return;
        n = 0;
        continue;
      }
      n += 1;
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      APLog.i("APMidasDownInfo", "resultData=reCheckInfo----jasonFormat---packageInfo");
      localObject1 = new ArrayList();
      az localaz = new az();
      paramJSONObject = paramJSONObject.getJSONObject("comm_config").getJSONArray("package_info");
      int n = paramJSONObject.length();
      int m = 0;
      while (m < n)
      {
        ap localap = new ap();
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get(m);
        Object localObject2 = localaz.b(localJSONObject.getString("md5"));
        localap.h = ((String)localObject2).substring(((String)localObject2).length() - 32);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("resultData=");
        ((StringBuilder)localObject2).append(localap.h);
        APLog.i("APMidasDownInfo", ((StringBuilder)localObject2).toString());
        if (localJSONObject.has("download_url"))
        {
          localap.e = localJSONObject.getString("download_url");
          if (localap.e.startsWith("http://"))
          {
            localap.e = localap.e.replace("http://", "https://");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reCheckInfo() force https url = ");
            ((StringBuilder)localObject2).append(localap.e);
            APLog.d("APMidasDownInfo", ((StringBuilder)localObject2).toString());
          }
        }
        boolean bool = localJSONObject.has("size");
        if (bool) {
          try
          {
            localap.b = Integer.valueOf(localJSONObject.getString("size")).intValue();
          }
          catch (Exception localException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reCheckInfo e1 ");
            ((StringBuilder)localObject2).append(localException.toString());
            APLog.i("APMidasDownInfo", ((StringBuilder)localObject2).toString());
          }
        }
        ((ArrayList)localObject1).add(localap);
        m += 1;
      }
      aq.a().b((ArrayList)localObject1);
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
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ap)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ap
 * JD-Core Version:    0.7.0.1
 */