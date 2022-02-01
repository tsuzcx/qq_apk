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

public class kv
{
  public static Context a;
  private static long b = 604800000L;
  private static volatile ArrayList<ky> c = new ArrayList();
  private static volatile ky d;
  private static volatile lk e;
  private static volatile ll f;
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
      ky localky = d;
      ArrayList localArrayList = new ArrayList(localky.e);
      int m = ls.b(paramContext, false);
      paramContext = new StringBuilder();
      paramContext.append("getIPs() localIPvX=");
      paramContext.append(m);
      paramContext.append("(0x0=none/0x1=v4/0x2=v6), original curNetworkNode.ips = ");
      paramContext.append(localArrayList);
      lc.b("IPDispatcher", paramContext.toString());
      paramContext = new ArrayList();
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = li.a((Context)localObject, localky, localArrayList, m);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = la.a((Context)localObject, localky, localArrayList);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localObject = lf.a((Context)localObject, localky, localArrayList, m);
      paramContext.add(Integer.valueOf(((ArrayList)localObject).size()));
      return localObject;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, ln paramln)
  {
    try
    {
      lc.b("IPDispatcher", "init() begin...");
      if (h)
      {
        lc.b("IPDispatcher", "init() repeat init, return");
        return;
      }
      h = true;
      f();
      if (a == null) {
        a = paramContext.getApplicationContext();
      }
      if (g == null) {
        g = Executors.newScheduledThreadPool(0, lo.a("Executor"));
      }
      if (e == null) {
        e = new lk(a);
      }
      if (f == null) {
        f = new ll(g, paramString);
      }
      if ((c != null) && (c.size() == 0)) {
        if (!j)
        {
          e.a(new ln()
          {
            public void a(int paramAnonymousInt, Object paramAnonymousObject)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("databaseRecords.grabNetworksAndIps().result() (");
              localStringBuilder.append(paramAnonymousInt);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramAnonymousObject);
              lc.b("IPDispatcher", localStringBuilder.toString());
              if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
              {
                paramAnonymousObject = (ArrayList)paramAnonymousObject;
                if (paramAnonymousObject != null) {
                  lr.a(kv.c(), paramAnonymousObject);
                }
              }
              kv.b(kv.a);
              this.a.a(0, null);
              kv.d();
            }
          });
        }
        else
        {
          paramContext = e.b();
          lr.a(c, paramContext);
          h(a);
          paramln.a(0, null);
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
        ls.a();
        lh.a();
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
        kx localkx = (kx)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localkx.a)) && (localkx.a.equals(paramString)))
        {
          localkx.a(paramLong1, paramLong2);
          e.a(d, localkx);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(kw.a parama)
  {
    try
    {
      kz.a(parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void a(kw.c paramc)
  {
    try
    {
      lb.a(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static void a(kw.d paramd)
  {
    try
    {
      lc.a(paramd);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public static void a(kw.f paramf)
  {
    try
    {
      le.a(paramf);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public static void a(kw.g paramg)
  {
    try
    {
      lf.a(paramg);
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public static void a(kw.h paramh)
  {
    try
    {
      lg.a(paramh);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public static void a(kw.i parami)
  {
    try
    {
      lh.a(parami);
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
  
  private static void b(Context paramContext, final ky paramky)
  {
    if (paramky == null) {
      return;
    }
    lh.a(paramky, new ln()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check() IPUpdater.update().result(");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        ((StringBuilder)localObject).append(")");
        lc.b("IPDispatcher", ((StringBuilder)localObject).toString());
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          paramAnonymousObject = (ArrayList)paramAnonymousObject;
          localObject = this.a.getSharedPreferences("TencentUnipay", 0).edit();
          ((SharedPreferences.Editor)localObject).putLong("updateIPPreTime", System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject).commit();
          kv.a(this.a, paramky, paramAnonymousObject);
          kv.a(this.a, paramky);
        }
      }
    });
  }
  
  private static void b(Context paramContext, ky paramky, ArrayList<kx> paramArrayList)
  {
    if (paramky == null) {
      return;
    }
    if (d == null) {
      paramContext = "Null";
    } else {
      paramContext = d.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fillIPs() identifier pre:");
    localStringBuilder.append(paramky.a);
    localStringBuilder.append(" -> cur:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", ips.size=");
    localStringBuilder.append(paramArrayList.size());
    lc.b("IPDispatcher", localStringBuilder.toString());
    paramky.e.clear();
    paramky.e.addAll(paramArrayList);
    e.a(paramky);
  }
  
  private static void b(Context paramContext, ky paramky, CopyOnWriteArrayList<kx> paramCopyOnWriteArrayList)
  {
    e.a(paramky);
    e.b(paramky);
    i();
  }
  
  private static void b(String paramString)
  {
    k = paramString;
    lj.a("lastNetIdentifier", k);
  }
  
  private static void c(Context paramContext)
  {
    ky localky = d;
    if (h(paramContext))
    {
      lb.a(localky, d);
      ld.a(localky);
    }
    localky = d;
    boolean bool1 = d(paramContext);
    boolean bool2 = e(paramContext);
    if (bool1)
    {
      b(paramContext, localky);
      return;
    }
    if ((!bool1) && (bool2)) {
      c(paramContext, localky);
    }
  }
  
  private static void c(final Context paramContext, ky paramky)
  {
    if (paramky == null) {
      return;
    }
    ld.a(g, paramky, new ln()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check() IPMeasure.measure().result(");
        ((StringBuilder)localObject).append(paramAnonymousInt);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramAnonymousObject);
        ((StringBuilder)localObject).append(")");
        lc.b("IPDispatcher", ((StringBuilder)localObject).toString());
        if (!this.a.a.equals(kv.e().a)) {
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
              kx localkx = (kx)localIterator.next();
              if (((String)((Pair)localObject).first).equals(localkx.a)) {
                localkx.b = new Pair(Long.valueOf(l), ((Pair)localObject).second);
              }
            }
          }
          kv.a(paramContext, this.a, this.a.e);
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
        if (((kx)paramContext.next()).c()) {
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
        lc.b("IPDispatcher", paramContext.toString());
        return true;
      }
      if (lh.a(d))
      {
        lc.b("IPDispatcher", "isNeedUpdate() true : IPUpdater.isOverdue()");
        return true;
      }
      lc.b("IPDispatcher", "isNeedUpdate() false : default");
      return false;
    }
    lc.b("IPDispatcher", "isNeedUpdate() true : current.Ips is null/empty");
    return true;
  }
  
  private static boolean e(Context paramContext)
  {
    if (ld.b(d))
    {
      lc.b("IPDispatcher", "isNeedMeasure() true : IPMeasure.isOverdue()");
      return true;
    }
    lc.b("IPDispatcher", "isNeedMeasure() false : default");
    return false;
  }
  
  private static void f()
  {
    b = lg.a(b);
    lh.a = lg.b(lh.a);
    lh.b = lg.c(lh.b);
    ld.a = lg.d(ld.a);
    ld.b = lg.e(ld.b);
    ld.c = lg.f(ld.c);
  }
  
  private static boolean f(Context paramContext)
  {
    Object localObject1 = g();
    boolean bool3 = false;
    boolean bool1 = false;
    paramContext = ls.a(paramContext, false);
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
        lc.b("IPDispatcher", ((StringBuilder)localObject2).toString());
        bool2 = bool3;
        if (TextUtils.isEmpty(paramContext)) {
          break label398;
        }
        bool2 = bool3;
        if (paramContext.equals(localObject1)) {
          break label398;
        }
        bool2 = bool3;
        lc.b("IPDispatcher", "checkNetworkSwitch() changed and set currentNetworkRecord = null");
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
          lc.b("IPDispatcher", "checkNetworkSwitch() currentNetworkRecord == null");
          bool2 = bool1;
          localObject2 = c.iterator();
          bool2 = bool1;
          if (((Iterator)localObject2).hasNext())
          {
            bool2 = bool1;
            localObject1 = (ky)((Iterator)localObject2).next();
            bool2 = bool1;
            if (!((ky)localObject1).a.equals(paramContext)) {
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
            ((StringBuilder)localObject2).append(((ky)localObject1).e.toString());
            bool2 = bool1;
            lc.b("IPDispatcher", ((StringBuilder)localObject2).toString());
            bool2 = bool1;
            d = (ky)localObject1;
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
            lc.b("IPDispatcher", ((StringBuilder)localObject1).toString());
            bool2 = bool1;
            d = new ky(paramContext);
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
      k = lj.b("lastNetIdentifier", "");
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
      ky localky = (ky)paramContext.next();
      if (System.currentTimeMillis() - localky.d.longValue() > b)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDataValid() ");
        localStringBuilder.append(localky.a);
        localStringBuilder.append(".data is not valid : removed");
        lc.b("IPDispatcher", localStringBuilder.toString());
        if ((localky == null) || (d == null) || (localky.a == null) || (!localky.a.equals(d.a)))
        {
          paramContext.remove();
          e.d(localky);
        }
      }
    }
    if ((d != null) && (System.currentTimeMillis() - d.d.longValue() > b) && (d.e != null)) {
      d.e.clear();
    }
  }
  
  private static void h()
  {
    f.a(new ln()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shareFrom() (");
        ((StringBuilder)localObject1).append(paramAnonymousInt);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(paramAnonymousObject);
        ((StringBuilder)localObject1).append(")");
        lc.b("IPDispatcher", ((StringBuilder)localObject1).toString());
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          localObject1 = (ArrayList)paramAnonymousObject;
          if (localObject1 == null) {
            return;
          }
          ((ArrayList)localObject1).retainAll(kv.c());
          if (((ArrayList)localObject1).size() <= 0) {
            return;
          }
          paramAnonymousObject = new HashMap();
          Object localObject2 = kv.c().iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ky)((Iterator)localObject2).next();
            paramAnonymousObject.put(((ky)localObject3).a, localObject3);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ky)((Iterator)localObject1).next();
            Object localObject4 = (ky)paramAnonymousObject.get(((ky)localObject3).a);
            if ((((ky)localObject4).c.longValue() > 0L) && (((ky)localObject3).c.longValue() <= ((ky)localObject4).c.longValue()))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("shareFrom() shared fromNetwork is Old, Skip! Network[");
              ((StringBuilder)localObject2).append(((ky)localObject4).a);
              ((StringBuilder)localObject2).append("] : fromMeasureTime(");
              ((StringBuilder)localObject2).append(((ky)localObject3).c);
              ((StringBuilder)localObject2).append(") <= toMeasureTime(");
              ((StringBuilder)localObject2).append(((ky)localObject4).c);
              ((StringBuilder)localObject2).append(")");
              lc.b("IPDispatcher", ((StringBuilder)localObject2).toString());
            }
            else
            {
              ((ky)localObject3).e.retainAll(((ky)localObject4).e);
              if (((ky)localObject3).e.size() > 0)
              {
                localObject2 = new HashMap();
                Object localObject5 = ((ky)localObject4).e.iterator();
                Object localObject6;
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (kx)((Iterator)localObject5).next();
                  ((HashMap)localObject2).put(((kx)localObject6).a, localObject6);
                }
                ((ky)localObject4).c = ((ky)localObject3).c;
                localObject3 = ((ky)localObject3).e.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (kx)((Iterator)localObject3).next();
                  localObject5 = (kx)((HashMap)localObject2).get(((kx)localObject4).a);
                  if ((((Long)((kx)localObject4).b.first).longValue() > 0L) && (((Long)((kx)localObject4).b.first).longValue() > ((Long)((kx)localObject5).b.first).longValue()))
                  {
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append("shareFrom() setMeasure ");
                    ((StringBuilder)localObject6).append(((kx)localObject5).a);
                    ((StringBuilder)localObject6).append(" = ");
                    ((StringBuilder)localObject6).append(((kx)localObject4).b());
                    ((StringBuilder)localObject6).append(" -> ");
                    ((StringBuilder)localObject6).append(((kx)localObject5).b());
                    lc.b("IPDispatcher", ((StringBuilder)localObject6).toString());
                    ((kx)localObject5).b = new Pair(((kx)localObject4).b.first, ((kx)localObject4).b.second);
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
    f.a(c, new ln()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject) {}
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.kv
 * JD-Core Version:    0.7.0.1
 */