package midas.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mg
{
  public static Context a;
  private static long b = 604800000L;
  private static volatile ArrayList<mj> c = new ArrayList();
  private static volatile mj d;
  private static volatile mv e;
  private static volatile mw f;
  private static ExecutorService g;
  private static volatile boolean h = false;
  private static volatile String i = "";
  private static boolean j = true;
  private static String k = "";
  
  public static String a()
  {
    try
    {
      if (TextUtils.isEmpty(i)) {
        return "";
      }
      String str = i;
      return str;
    }
    finally {}
  }
  
  public static ArrayList<String> a(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext();
      c((Context)localObject);
      mj localmj = d;
      ArrayList localArrayList = new ArrayList(localmj.e);
      int m = nd.b(paramContext, false);
      paramContext = new StringBuilder();
      paramContext.append("getIPs() localIPvX=");
      paramContext.append(m);
      paramContext.append("(0x0=none/0x1=v4/0x2=v6), original curNetworkNode.ips = ");
      paramContext.append(localArrayList);
      mn.b("IPDispatcher", paramContext.toString());
      paramContext = new ArrayList();
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = mt.a((Context)localObject, localmj, localArrayList, m);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = ml.a((Context)localObject, localmj, localArrayList);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localObject = mq.a((Context)localObject, localmj, localArrayList, m);
      paramContext.add(Integer.valueOf(((ArrayList)localObject).size()));
      return localObject;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, my parammy)
  {
    try
    {
      mn.b("IPDispatcher", "init() begin...");
      if (h)
      {
        mn.b("IPDispatcher", "init() repeat init, return");
        return;
      }
      h = true;
      f();
      if (a == null) {
        a = paramContext.getApplicationContext();
      }
      if (g == null) {
        g = Executors.newScheduledThreadPool(0, mz.a("Executor"));
      }
      if (e == null) {
        e = new mv(a);
      }
      if (f == null) {
        f = new mw(g, paramString);
      }
      if ((c != null) && (c.size() == 0)) {
        if (!j)
        {
          e.a(new my()
          {
            public void a(int paramAnonymousInt, Object paramAnonymousObject)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("databaseRecords.grabNetworksAndIps().result() (");
              localStringBuilder.append(paramAnonymousInt);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramAnonymousObject);
              mn.b("IPDispatcher", localStringBuilder.toString());
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
              {
                paramAnonymousObject = (ArrayList)paramAnonymousObject;
                if (paramAnonymousObject != null) {
                  nc.a(mg.c(), paramAnonymousObject);
                }
              }
              mg.b(mg.a);
              this.a.a(0, null);
              mg.d();
            }
          });
        }
        else
        {
          paramContext = e.b();
          nc.a(c, paramContext);
          h(a);
          parammy.a(0, null);
          h();
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(i)))
      {
        i = paramString;
        nd.a();
        ms.a();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramLong2 = -paramLong2;
    }
    try
    {
      Object localObject = d;
      if (localObject == null) {
        return;
      }
      localObject = d.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        mi localmi = (mi)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localmi.a)) && (localmi.a.equals(paramString)))
        {
          localmi.a(paramLong1, paramLong2);
          e.a(d, localmi);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(mh.a parama)
  {
    try
    {
      mk.a(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void a(mh.c paramc)
  {
    try
    {
      mm.a(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static void a(mh.d paramd)
  {
    try
    {
      mn.a(paramd);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static void a(mh.f paramf)
  {
    try
    {
      mp.a(paramf);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public static void a(mh.g paramg)
  {
    try
    {
      mq.a(paramg);
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public static void a(mh.h paramh)
  {
    try
    {
      mr.a(paramh);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public static void a(mh.i parami)
  {
    try
    {
      ms.a(parami);
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      j = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b()
  {
    try
    {
      if (f != null)
      {
        f.a();
        f = null;
      }
      if (e != null)
      {
        e.a();
        e = null;
      }
      if (c != null) {
        c.clear();
      }
      if (g != null)
      {
        if (!g.isShutdown()) {
          g.shutdown();
        }
        g = null;
      }
      d = null;
      a = null;
      h = false;
      return;
    }
    finally {}
  }
  
  private static void b(Context paramContext, final mj parammj)
  {
    if (parammj == null) {
      return;
    }
    ms.a(parammj, new my()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check() IPUpdater.update().result(");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        ((StringBuilder)localObject).append(")");
        mn.b("IPDispatcher", ((StringBuilder)localObject).toString());
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          paramAnonymousObject = (ArrayList)paramAnonymousObject;
          localObject = this.a.getSharedPreferences("TencentUnipay", 0).edit();
          ((SharedPreferences.Editor)localObject).putLong("updateIPPreTime", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject).commit();
          mg.a(this.a, parammj, paramAnonymousObject);
          mg.a(this.a, parammj);
        }
      }
    });
  }
  
  private static void b(Context paramContext, mj parammj, ArrayList<mi> paramArrayList)
  {
    if (parammj == null) {
      return;
    }
    if (d == null) {
      paramContext = "Null";
    } else {
      paramContext = d.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fillIPs() identifier pre:");
    localStringBuilder.append(parammj.a);
    localStringBuilder.append(" -> cur:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", ips.size=");
    localStringBuilder.append(paramArrayList.size());
    mn.b("IPDispatcher", localStringBuilder.toString());
    parammj.e.clear();
    parammj.e.addAll(paramArrayList);
    e.a(parammj);
  }
  
  private static void b(Context paramContext, mj parammj, CopyOnWriteArrayList<mi> paramCopyOnWriteArrayList)
  {
    e.a(parammj);
    e.b(parammj);
    i();
  }
  
  private static void b(String paramString)
  {
    k = paramString;
    mu.a("lastNetIdentifier", k);
  }
  
  private static void c(Context paramContext)
  {
    mj localmj = d;
    if (h(paramContext))
    {
      mm.a(localmj, d);
      mo.a(localmj);
    }
    localmj = d;
    boolean bool1 = d(paramContext);
    boolean bool2 = e(paramContext);
    if (bool1)
    {
      b(paramContext, localmj);
      return;
    }
    if ((!bool1) && (bool2)) {
      c(paramContext, localmj);
    }
  }
  
  private static void c(final Context paramContext, mj parammj)
  {
    if (parammj == null) {
      return;
    }
    mo.a(g, parammj, new my()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check() IPMeasure.measure().result(");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        ((StringBuilder)localObject).append(")");
        mn.b("IPDispatcher", ((StringBuilder)localObject).toString());
        if (!this.a.a.equals(mg.e().a)) {
          return;
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          long l = System.currentTimeMillis();
          paramAnonymousObject = ((ArrayList)paramAnonymousObject).iterator();
          while (paramAnonymousObject.hasNext())
          {
            localObject = (Pair)paramAnonymousObject.next();
            Iterator localIterator = this.a.e.iterator();
            while (localIterator.hasNext())
            {
              mi localmi = (mi)localIterator.next();
              if (((String)((Pair)localObject).first).equals(localmi.a)) {
                localmi.b = new Pair(Long.valueOf(l), ((Pair)localObject).second);
              }
            }
          }
          mg.a(paramContext, this.a, this.a.e);
        }
      }
    });
  }
  
  private static boolean d(Context paramContext)
  {
    if ((d.e != null) && (d.e.size() > 0))
    {
      paramContext = d.e.iterator();
      int m = 0;
      while (paramContext.hasNext()) {
        if (((mi)paramContext.next()).c()) {
          m += 1;
        }
      }
      double d1 = d.e.size() - m;
      double d2 = d.e.size();
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      if (d1 < 0.5D)
      {
        paramContext = new StringBuilder();
        paramContext.append("isNeedUpdate() true : goodRate=");
        paramContext.append(d1);
        paramContext.append("<0.5");
        mn.b("IPDispatcher", paramContext.toString());
        return true;
      }
      if (ms.a(d))
      {
        mn.b("IPDispatcher", "isNeedUpdate() true : IPUpdater.isOverdue()");
        return true;
      }
      mn.b("IPDispatcher", "isNeedUpdate() false : default");
      return false;
    }
    mn.b("IPDispatcher", "isNeedUpdate() true : current.Ips is null/empty");
    return true;
  }
  
  private static boolean e(Context paramContext)
  {
    if (mo.b(d))
    {
      mn.b("IPDispatcher", "isNeedMeasure() true : IPMeasure.isOverdue()");
      return true;
    }
    mn.b("IPDispatcher", "isNeedMeasure() false : default");
    return false;
  }
  
  private static void f()
  {
    b = mr.a(b);
    ms.a = mr.b(ms.a);
    ms.b = mr.c(ms.b);
    mo.a = mr.d(mo.a);
    mo.b = mr.e(mo.b);
    mo.c = mr.f(mo.c);
  }
  
  private static boolean f(Context paramContext)
  {
    Object localObject1 = g();
    boolean bool3 = false;
    boolean bool1 = false;
    paramContext = nd.a(paramContext, false);
    boolean bool2 = bool3;
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        bool2 = bool3;
        ((StringBuilder)localObject2).append("checkNetworkSwitch() recordedNetworkIdentifier=");
        bool2 = bool3;
        ((StringBuilder)localObject2).append((String)localObject1);
        bool2 = bool3;
        ((StringBuilder)localObject2).append(", curNetworkIdentifier=");
        bool2 = bool3;
        ((StringBuilder)localObject2).append(paramContext);
        bool2 = bool3;
        mn.b("IPDispatcher", ((StringBuilder)localObject2).toString());
        bool2 = bool3;
        if (TextUtils.isEmpty(paramContext)) {
          break label398;
        }
        bool2 = bool3;
        if (paramContext.equals(localObject1)) {
          break label398;
        }
        bool2 = bool3;
        mn.b("IPDispatcher", "checkNetworkSwitch() changed and set currentNetworkRecord = null");
        bool2 = bool3;
        b(paramContext);
        bool2 = bool3;
        d = null;
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (d == null)
        {
          bool2 = bool1;
          mn.b("IPDispatcher", "checkNetworkSwitch() currentNetworkRecord == null");
          bool2 = bool1;
          localObject2 = c.iterator();
          bool2 = bool1;
          if (((Iterator)localObject2).hasNext())
          {
            bool2 = bool1;
            localObject1 = (mj)((Iterator)localObject2).next();
            bool2 = bool1;
            if (!((mj)localObject1).a.equals(paramContext)) {
              continue;
            }
            bool2 = bool1;
            localObject2 = new StringBuilder();
            bool2 = bool1;
            ((StringBuilder)localObject2).append("checkNetworkSwitch() ");
            bool2 = bool1;
            ((StringBuilder)localObject2).append(paramContext);
            bool2 = bool1;
            ((StringBuilder)localObject2).append(".data is find : ");
            bool2 = bool1;
            ((StringBuilder)localObject2).append(((mj)localObject1).e.toString());
            bool2 = bool1;
            mn.b("IPDispatcher", ((StringBuilder)localObject2).toString());
            bool2 = bool1;
            d = (mj)localObject1;
            bool2 = bool1;
            d.d = Long.valueOf(System.currentTimeMillis());
          }
          bool2 = bool1;
          bool3 = bool1;
          if (d == null)
          {
            bool2 = bool1;
            localObject1 = new StringBuilder();
            bool2 = bool1;
            ((StringBuilder)localObject1).append("checkNetworkSwitch() ");
            bool2 = bool1;
            ((StringBuilder)localObject1).append(paramContext);
            bool2 = bool1;
            ((StringBuilder)localObject1).append(".data is not find : create New");
            bool2 = bool1;
            mn.b("IPDispatcher", ((StringBuilder)localObject1).toString());
            bool2 = bool1;
            d = new mj(paramContext);
            bool2 = bool1;
            c.add(d);
            bool2 = bool1;
            e.c(d);
            return bool1;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        bool3 = bool2;
      }
      return bool3;
      label398:
      paramContext = (Context)localObject1;
    }
  }
  
  private static String g()
  {
    if (TextUtils.isEmpty(k)) {
      k = mu.b("lastNetIdentifier", "");
    }
    if (k == null) {
      k = "";
    }
    return k;
  }
  
  private static void g(Context paramContext)
  {
    if (c == null) {
      return;
    }
    paramContext = c.iterator();
    while (paramContext.hasNext())
    {
      mj localmj = (mj)paramContext.next();
      if (System.currentTimeMillis() - localmj.d.longValue() > b)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDataValid() ");
        localStringBuilder.append(localmj.a);
        localStringBuilder.append(".data is not valid : removed");
        mn.b("IPDispatcher", localStringBuilder.toString());
        if ((localmj == null) || (d == null) || (localmj.a == null) || (!localmj.a.equals(d.a)))
        {
          paramContext.remove();
          e.d(localmj);
        }
      }
    }
    if ((d != null) && (System.currentTimeMillis() - d.d.longValue() > b) && (d.e != null)) {
      d.e.clear();
    }
  }
  
  private static void h()
  {
    f.a(new my()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shareFrom() (");
        ((StringBuilder)localObject1).append(paramAnonymousInt);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(paramAnonymousObject);
        ((StringBuilder)localObject1).append(")");
        mn.b("IPDispatcher", ((StringBuilder)localObject1).toString());
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          localObject1 = (ArrayList)paramAnonymousObject;
          if (localObject1 == null) {
            return;
          }
          ((ArrayList)localObject1).retainAll(mg.c());
          if (((ArrayList)localObject1).size() <= 0) {
            return;
          }
          paramAnonymousObject = new HashMap();
          Object localObject2 = mg.c().iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (mj)((Iterator)localObject2).next();
            paramAnonymousObject.put(((mj)localObject3).a, localObject3);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (mj)((Iterator)localObject1).next();
            Object localObject4 = (mj)paramAnonymousObject.get(((mj)localObject3).a);
            if ((((mj)localObject4).c.longValue() > 0L) && (((mj)localObject3).c.longValue() <= ((mj)localObject4).c.longValue()))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("shareFrom() shared fromNetwork is Old, Skip! Network[");
              ((StringBuilder)localObject2).append(((mj)localObject4).a);
              ((StringBuilder)localObject2).append("] : fromMeasureTime(");
              ((StringBuilder)localObject2).append(((mj)localObject3).c);
              ((StringBuilder)localObject2).append(") <= toMeasureTime(");
              ((StringBuilder)localObject2).append(((mj)localObject4).c);
              ((StringBuilder)localObject2).append(")");
              mn.b("IPDispatcher", ((StringBuilder)localObject2).toString());
            }
            else
            {
              ((mj)localObject3).e.retainAll(((mj)localObject4).e);
              if (((mj)localObject3).e.size() > 0)
              {
                localObject2 = new HashMap();
                Object localObject5 = ((mj)localObject4).e.iterator();
                Object localObject6;
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (mi)((Iterator)localObject5).next();
                  ((HashMap)localObject2).put(((mi)localObject6).a, localObject6);
                }
                ((mj)localObject4).c = ((mj)localObject3).c;
                localObject3 = ((mj)localObject3).e.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (mi)((Iterator)localObject3).next();
                  localObject5 = (mi)((HashMap)localObject2).get(((mi)localObject4).a);
                  if ((((Long)((mi)localObject4).b.first).longValue() > 0L) && (((Long)((mi)localObject4).b.first).longValue() > ((Long)((mi)localObject5).b.first).longValue()))
                  {
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append("shareFrom() setMeasure ");
                    ((StringBuilder)localObject6).append(((mi)localObject5).a);
                    ((StringBuilder)localObject6).append(" = ");
                    ((StringBuilder)localObject6).append(((mi)localObject4).b());
                    ((StringBuilder)localObject6).append(" -> ");
                    ((StringBuilder)localObject6).append(((mi)localObject5).b());
                    mn.b("IPDispatcher", ((StringBuilder)localObject6).toString());
                    ((mi)localObject5).b = new Pair(((mi)localObject4).b.first, ((mi)localObject4).b.second);
                  }
                }
              }
            }
          }
        }
      }
    });
  }
  
  private static boolean h(Context paramContext)
  {
    g(paramContext);
    return f(paramContext);
  }
  
  private static void i()
  {
    f.a(c, new my()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject) {}
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mg
 * JD-Core Version:    0.7.0.1
 */