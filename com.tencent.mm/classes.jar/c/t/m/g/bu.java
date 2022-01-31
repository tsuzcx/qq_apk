package c.t.m.g;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class bu
  implements cc, Runnable
{
  private static int b = -1;
  private static bu c = new bu();
  public bi a;
  private Handler d;
  private Map<String, bq> e = new ConcurrentHashMap();
  private Runnable f = new by(this);
  private Runnable g = new ca(this);
  private Runnable h = new cb(this);
  private Map<String, bu.a> i = new HashMap();
  
  private bu.a a(String paramString)
  {
    Object localObject3;
    if (this.i.isEmpty()) {
      try
      {
        Object localObject1 = cj.b("apnrecords", "");
        if (!((String)localObject1).isEmpty())
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject3 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!TextUtils.isEmpty(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
              if (localJSONObject != null)
              {
                bu.a locala = new bu.a((byte)0);
                locala.b = localJSONObject.optInt("lastCode");
                locala.a = localJSONObject.optLong("lastReqTime");
                this.i.put(str, locala);
              }
            }
          }
        }
        localObject3 = (bu.a)this.i.get(paramString);
      }
      catch (Exception localException) {}
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new bu.a((byte)0);
      this.i.put(paramString, localObject2);
    }
    return localObject2;
  }
  
  private static int c(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "http_platform_update_interval_succ";
      if (paramInt != 0) {
        break label48;
      }
      paramInt = 1800000;
    }
    for (;;)
    {
      return x.a.a(str, 60000, 3600000, paramInt);
      if ((paramInt == -4) || (paramInt == -3))
      {
        str = "http_platform_update_interval_nonet";
        break;
      }
      str = "http_platform_update_interval_fail";
      break;
      label48:
      if ((paramInt == -4) || (paramInt == -3)) {
        paramInt = 60000;
      } else {
        paramInt = 300000;
      }
    }
  }
  
  public static bu c()
  {
    return c;
  }
  
  public final void a()
  {
    ((bq)this.e.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.d.removeCallbacks(this.g);
      this.d.post(this.g);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    paramInt = x.a.a("detect_platform_update_random_interval", 0, 1440, 10);
    paramInt = new Random().nextInt(paramInt);
    int j = c(0);
    ae.a().a(this.f, false, paramInt * 60 * 1000 + j);
  }
  
  public final void a(bi parambi)
  {
    this.a = parambi;
    parambi = new bz();
    this.e.put(parambi.c(), parambi);
    parambi = new bs();
    this.e.put(parambi.c(), parambi);
    parambi = new bv();
    this.e.put(parambi.c(), parambi);
  }
  
  public final void b()
  {
    ((bq)this.e.get("settings")).b();
  }
  
  public final void d()
  {
    this.d = x.a.a("HttpPlatformConnection");
    this.d.post(this);
    this.a.c();
  }
  
  public final void run()
  {
    if (x.a.a("http_platform_start_update_on", 0, 1, 0) == 1)
    {
      b = 1;
      this.d.post(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.bu
 * JD-Core Version:    0.7.0.1
 */