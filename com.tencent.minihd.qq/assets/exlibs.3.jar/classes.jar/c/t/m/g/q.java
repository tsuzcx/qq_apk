package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class q
  implements p
{
  private static q a = null;
  
  public static q a()
  {
    try
    {
      if (a == null) {
        a = new q();
      }
      q localq = a;
      return localq;
    }
    finally {}
  }
  
  public static void a(aj paramaj)
  {
    HashMap localHashMap = i.a(paramaj);
    localHashMap.put("B64", paramaj.z);
    if (!TextUtils.isEmpty(paramaj.F)) {
      localHashMap.put("B73", paramaj.z);
    }
    localHashMap.put("B63", paramaj.y);
    localHashMap.put("B65", paramaj.t);
    localHashMap.put("B66", paramaj.x);
    localHashMap.put("B75", paramaj.u);
    localHashMap.put("B67", paramaj.A);
    localHashMap.put("B70", paramaj.E);
    localHashMap.put("B72", paramaj.B);
    localHashMap.put("B74", paramaj.C);
    localHashMap.put("B68", paramaj.D);
    ax.b("AccessSchedulerStatistics", "AppAccessFinished：" + paramaj.toString());
    if (am.k() == null)
    {
      am.a(o.a());
      ap.a();
    }
    ap.a("B_ACSDK_SDKExt_Result", localHashMap);
  }
  
  public final void a(f paramf)
  {
    ax.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
    aj localaj = new aj();
    localaj.a = paramf.b;
    localaj.b = paramf.c;
    localaj.c = paramf.d;
    localaj.d = paramf.a;
    localaj.e = paramf.e;
    localaj.h = paramf.i;
    if (localaj.h == 1) {
      localaj.g = aw.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localaj.i = paramf.j;
      Object localObject = paramf.h;
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label338;
      }
      localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append("|");
      }
      localaj.f = aw.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localaj.j = localStringBuilder.toString();
    localaj.k = paramf.n;
    if (paramf.o) {}
    for (int i = 1;; i = 0)
    {
      localaj.l = i;
      localaj.m = paramf.k;
      localaj.n = paramf.l;
      localaj.o = paramf.m;
      localaj.p = paramf.p;
      localaj.r = paramf.r;
      localaj.q = paramf.q;
      localaj.s = paramf.s;
      localaj.v = paramf.t;
      localaj.y = paramf.f;
      ax.b("AccessSchedulerStatistics", "AccessSchedulerFinished：" + localaj.toString());
      new a(localaj).start();
      return;
      label338:
      localaj.j = "";
      break;
    }
  }
  
  final class a
    extends Thread
  {
    a() {}
    
    public final void run()
    {
      try
      {
        Thread.sleep(10000L);
        HashMap localHashMap = i.a(q.this);
        if (am.k() == null)
        {
          am.a(o.a());
          ap.a();
        }
        ap.a("B_ACSDK_SDK_Result", localHashMap);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.q
 * JD-Core Version:    0.7.0.1
 */