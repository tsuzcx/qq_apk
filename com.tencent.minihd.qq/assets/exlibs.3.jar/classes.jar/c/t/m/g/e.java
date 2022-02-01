package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class e
  implements a, n, Runnable
{
  public String a = null;
  public String b = null;
  public String c = null;
  private Set d = null;
  private BlockingQueue e = null;
  private p f;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    ax.a("AccessSchedulerImpl", "new AccessSchedulerImpl...");
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = new CopyOnWriteArraySet();
    this.d.add("dispatcher.3g.qq.com");
    this.e = new ArrayBlockingQueue(1);
    this.f = q.a();
    j.a().a(this);
  }
  
  public final ai a()
  {
    return b.a.b().b.f;
  }
  
  public final s.a a(String paramString)
  {
    if (this.d.contains(paramString))
    {
      paramString = t.a().a(paramString);
      if (paramString != null)
      {
        if (paramString.b()) {
          ax.c("AccessSchedulerImpl", "iplist was expired");
        }
        return paramString;
      }
      ax.c("AccessSchedulerImpl", "getAccessIPListByDomainname... domain access info not found in db...");
    }
    for (;;)
    {
      return null;
      ax.c("AccessSchedulerImpl", "getAccessIPListByDomainname...domain not registered. domain:" + paramString + ", registered domains:" + this.d);
    }
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.d.add(str);
      }
    }
  }
  
  public final void b()
  {
    ax.b("AccessSchedulerImpl", "onAccessSchedulerTriggered... try to addTask");
    ax.b("AccessSchedulerImpl", "addTask...");
    try
    {
      ax.a("AccessSchedulerImpl", "before add, queue size:" + this.e.size());
      boolean bool = this.e.add(new i());
      ax.a("AccessSchedulerImpl", "addTask ret:" + bool);
      ax.a("AccessSchedulerImpl", "after add, queue size:" + this.e.size());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        ax.a("AccessSchedulerImpl", "addTask exception...", localThrowable);
      }
    }
  }
  
  public final void run()
  {
    ax.b("AccessSchedulerImpl", "AccessSchedulerImpl run start...");
    t.a();
    for (;;)
    {
      Object localObject;
      try
      {
        ax.a("AccessSchedulerImpl", "try take a task...");
        this.e.take();
        ax.a("AccessSchedulerImpl", "task taked, try scheduler...");
        ax.b("AccessSchedulerImpl", "scheduler...begin");
        localObject = t.a();
        String str = aw.a();
        if ((TextUtils.isEmpty(str)) || (str.equals("unknown")))
        {
          ax.c("AccessSchedulerStorageManager", "updateApnUserTime... failed with apnName:" + str);
          str = "";
          if (!TextUtils.isEmpty(str)) {
            break label147;
          }
          ax.c("AccessSchedulerImpl", "can not get current apn, do not scheduler");
          continue;
        }
        ((t)localObject).a.b(localThrowable);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      ax.b("AccessSchedulerStorageManager", "updateApnUseTime... apnName:" + localThrowable);
      continue;
      label147:
      if (!h.a)
      {
        ax.b("AccessSchedulerImpl", "schedulerOn is off. return");
      }
      else if (!t.a().a(this.d))
      {
        ax.b("AccessSchedulerImpl", "scheduler...no need scheduler. return");
      }
      else
      {
        f localf = new f();
        localf.b = o.b();
        localf.c = o.c();
        localf.d = o.d();
        localf.a = o.f();
        o.g();
        localf.e = o.e();
        localObject = this.d;
        localf.h = new ArrayList();
        localf.h.addAll((Collection)localObject);
        localf.g = aw.a();
        localf.i = aw.c();
        localf.j = aw.d();
        ax.a("AccessSchedulerImpl", "request info:" + localf.b + "," + localf.c + "," + localf.d + "," + localf.a + "," + localf.e + "," + localf.h + "," + null + "," + localf.i + "," + localf.j);
        localObject = localf.a();
        if (localObject != null)
        {
          ax.b("AccessSchedulerImpl", "scheduler...response:" + new StringBuilder("accessInfo:").append(((g)localObject).a).append(", sdkCfgInfo:").append(((g)localObject).b).append(", sdkAccessInfo:").append(((g)localObject).c).toString());
          t.a().a(((g)localObject).a);
          b.a locala = b.a.b();
          d locald = ((g)localObject).b;
          if (locald != null)
          {
            ax.b("AccessSchedulerConfiguration", "updateSdkCfInfo...SdkCfgInfo:" + locald);
            if ((locald.a < 2000) || (locald.a > 60000))
            {
              ax.c("AccessSchedulerConfiguration", "updateSdkCfInfo...connectTimeout:" + locald.a + " is checked to 20s");
              locald.a = 20000;
            }
            if ((locald.b < 2000) || (locald.b > 60000))
            {
              ax.c("AccessSchedulerConfiguration", "updateSdkCfInfo...readTimeout:" + locald.b + " is checked to 20s");
              locald.b = 20000;
            }
            locala.b = locald;
            locala.b.b();
          }
          locala = b.a.b();
          localObject = ((g)localObject).c;
          if (localObject != null)
          {
            locala.a = ((c)localObject);
            locala.a.b();
          }
        }
        ax.b("AccessSchedulerImpl", "scheduler...end. apn:" + null + ", retCode:" + localf.k + ",failInfo:" + localf.l);
        this.f.a(localf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.e
 * JD-Core Version:    0.7.0.1
 */