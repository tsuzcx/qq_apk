package c.t.m.g;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ap
{
  private static int a = 4;
  private static int b = 60;
  private static List c;
  private static ScheduledThreadPoolExecutor d = null;
  
  public static void a()
  {
    if (d == null)
    {
      d = new ScheduledThreadPoolExecutor(1);
      a locala = new a((byte)0);
      d.scheduleWithFixedDelay(locala, 3L, b, TimeUnit.SECONDS);
    }
  }
  
  public static void a(String paramString, HashMap paramHashMap)
  {
    o.a();
    paramString = i.a(paramString);
    a(paramHashMap);
    paramString.a(paramHashMap);
    if (c == null) {
      c = new ArrayList();
    }
    c.add(paramString);
    if (al.b(o.a()))
    {
      o.a();
      paramString = i.a("rqd_applaunched");
      paramHashMap = new HashMap();
      a(paramHashMap);
      if (!al.b(o.a())) {
        break label129;
      }
      paramHashMap.put("A21", "Y");
    }
    for (;;)
    {
      paramString.a(paramHashMap);
      c.add(paramString);
      if (c.size() >= a) {
        c(c);
      }
      return;
      label129:
      paramHashMap.put("A21", "N");
    }
  }
  
  private static void a(HashMap paramHashMap)
  {
    am localam = am.k();
    if (localam != null)
    {
      paramHashMap.put("A1", o.e());
      paramHashMap.put("A2", localam.d());
      paramHashMap.put("A4", localam.f());
      paramHashMap.put("A6", localam.g());
      paramHashMap.put("A7", localam.h());
      paramHashMap.put("A23", o.g());
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = o.a();
      Object localObject1 = "null";
      if (an.a((Context)localObject2) != null)
      {
        localObject2 = an.f((Context)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
      paramHashMap.put("A33", (String)localObject1);
      paramHashMap.put("A10", localam.j());
      paramHashMap.put("A9", localam.i());
      paramHashMap.put("A19", aw.a);
      paramHashMap.put("A20", aw.b);
    }
  }
  
  private static void c(List paramList)
  {
    ArrayList localArrayList;
    do
    {
      do
      {
        try
        {
          localObject = new StringBuilder();
          localArrayList = new ArrayList();
          localArrayList.addAll(paramList);
          paramList = localArrayList.iterator();
          while (paramList.hasNext()) {
            ((StringBuilder)localObject).append(i.a((ao)paramList.next()));
          }
          paramList = i.a(((StringBuilder)localObject).toString().getBytes());
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          return;
        }
        paramList = new ak("ABC1234567890DEF".getBytes()).a(paramList);
      } while (paramList.length <= 0);
      Object localObject = x.a();
      String str = "/sdk/beacon.jsp?type=real&size=" + paramList.length;
      ax.b("HttpAccessClientImpl", "createHttpPostRequest...domain:" + "zxcv.3g.qq.com" + ",ports:" + null + ",res:" + str);
      if (TextUtils.isEmpty("zxcv.3g.qq.com")) {
        throw new ab("domain is empty.");
      }
      y localy = new y("zxcv.3g.qq.com", null);
      localy.e = str;
      localy.i = paramList;
      localy.b = ("zxcv.3g.qq.com" + str);
      localy.g = false;
      paramList = ((w)localObject).a(localy);
    } while ((paramList == null) || (paramList.a != 0));
    c.removeAll(localArrayList);
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      if (ap.b() == null) {
        ap.a(new ArrayList());
      }
      if (ap.b().size() > 0) {
        ap.b(ap.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.ap
 * JD-Core Version:    0.7.0.1
 */