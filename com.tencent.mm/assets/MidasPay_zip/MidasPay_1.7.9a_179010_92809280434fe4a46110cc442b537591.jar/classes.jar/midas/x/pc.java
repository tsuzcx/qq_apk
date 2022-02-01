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

public class pc
{
  public static long a = 604800000L;
  public static volatile ArrayList<ad> b = new ArrayList();
  public static volatile ad c;
  public static volatile md d;
  public static volatile nd e;
  public static ExecutorService f;
  public static Context g;
  public static volatile boolean h = false;
  public static volatile String i = "";
  public static boolean j = true;
  public static String k = "";
  
  public static void a(Context paramContext, String paramString, pd parampd)
  {
    try
    {
      ed.a("IPDispatcher", "init() begin...");
      if (h)
      {
        ed.a("IPDispatcher", "init() repeat init, return");
        return;
      }
      h = true;
      f();
      if (g == null) {
        g = paramContext.getApplicationContext();
      }
      if (f == null) {
        f = Executors.newScheduledThreadPool(0, qd.a("Executor"));
      }
      if (d == null) {
        d = new md(g);
      }
      if (e == null) {
        e = new nd(f, paramString);
      }
      if ((b != null) && (b.size() == 0)) {
        if (!j)
        {
          d.a(new a(parampd));
        }
        else
        {
          paramContext = d.a();
          td.a(b, paramContext);
          d(g);
          parampd.a(0, null);
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
        ud.a();
        jd.b();
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
      Object localObject = c;
      if (localObject == null) {
        return;
      }
      localObject = c.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        zc localzc = (zc)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(localzc.a)) && (localzc.a.equals(paramString)))
        {
          localzc.a(paramLong1, paramLong2);
          d.a(c, localzc);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static void a(qc paramqc)
  {
    try
    {
      bd.a(paramqc);
      return;
    }
    finally
    {
      paramqc = finally;
      throw paramqc;
    }
  }
  
  public static void a(sc paramsc)
  {
    try
    {
      dd.a(paramsc);
      return;
    }
    finally
    {
      paramsc = finally;
      throw paramsc;
    }
  }
  
  public static void a(tc paramtc)
  {
    try
    {
      ed.a(paramtc);
      return;
    }
    finally
    {
      paramtc = finally;
      throw paramtc;
    }
  }
  
  public static void a(vc paramvc)
  {
    try
    {
      gd.a(paramvc);
      return;
    }
    finally
    {
      paramvc = finally;
      throw paramvc;
    }
  }
  
  public static void a(wc paramwc)
  {
    try
    {
      hd.a(paramwc);
      return;
    }
    finally
    {
      paramwc = finally;
      throw paramwc;
    }
  }
  
  public static void a(xc paramxc)
  {
    try
    {
      id.a(paramxc);
      return;
    }
    finally
    {
      paramxc = finally;
      throw paramxc;
    }
  }
  
  public static void a(yc paramyc)
  {
    try
    {
      jd.a(paramyc);
      return;
    }
    finally
    {
      paramyc = finally;
      throw paramyc;
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
  
  public static void b(Context paramContext)
  {
    ad localad = c;
    if (d(paramContext))
    {
      dd.a(localad, c);
      fd.a(localad);
    }
    localad = c;
    boolean bool1 = h(paramContext);
    boolean bool2 = g(paramContext);
    if (bool1)
    {
      c(paramContext, localad);
      return;
    }
    if ((!bool1) && (bool2)) {
      b(paramContext, localad);
    }
  }
  
  public static void b(final Context paramContext, ad paramad)
  {
    if (paramad == null) {
      return;
    }
    fd.a(f, paramad, new c(paramad, paramContext));
  }
  
  public static void b(Context paramContext, ad paramad, ArrayList<zc> paramArrayList)
  {
    if (paramad == null) {
      return;
    }
    if (c == null) {
      paramContext = "Null";
    } else {
      paramContext = c.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fillIPs() identifier pre:");
    localStringBuilder.append(paramad.a);
    localStringBuilder.append(" -> cur:");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(", ips.size=");
    localStringBuilder.append(paramArrayList.size());
    ed.a("IPDispatcher", localStringBuilder.toString());
    paramad.e.clear();
    paramad.e.addAll(paramArrayList);
    d.b(paramad);
  }
  
  public static void b(Context paramContext, ad paramad, CopyOnWriteArrayList<zc> paramCopyOnWriteArrayList)
  {
    d.b(paramad);
    d.d(paramad);
    i();
  }
  
  public static void b(String paramString)
  {
    k = paramString;
    ld.b("lastNetIdentifier", k);
  }
  
  public static void c(Context paramContext)
  {
    if (b == null) {
      return;
    }
    paramContext = b.iterator();
    while (paramContext.hasNext())
    {
      ad localad = (ad)paramContext.next();
      if (System.currentTimeMillis() - localad.d.longValue() > a)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkDataValid() ");
        localStringBuilder.append(localad.a);
        localStringBuilder.append(".data is not valid : removed");
        ed.a("IPDispatcher", localStringBuilder.toString());
        if ((localad == null) || (c == null) || (localad.a == null) || (!localad.a.equals(c.a)))
        {
          paramContext.remove();
          d.a(localad);
        }
      }
    }
    if ((c != null) && (System.currentTimeMillis() - c.d.longValue() > a) && (c.e != null)) {
      c.e.clear();
    }
  }
  
  public static void c(Context paramContext, final ad paramad)
  {
    if (paramad == null) {
      return;
    }
    jd.a(paramad, new b(paramContext, paramad));
  }
  
  public static String d()
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
  
  public static boolean d(Context paramContext)
  {
    c(paramContext);
    return e(paramContext);
  }
  
  public static String e()
  {
    if (TextUtils.isEmpty(k)) {
      k = ld.a("lastNetIdentifier", "");
    }
    if (k == null) {
      k = "";
    }
    return k;
  }
  
  public static boolean e(Context paramContext)
  {
    Object localObject1 = e();
    boolean bool3 = false;
    boolean bool1 = false;
    paramContext = ud.b(paramContext, false);
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
        ed.a("IPDispatcher", ((StringBuilder)localObject2).toString());
        bool2 = bool3;
        if (TextUtils.isEmpty(paramContext)) {
          break label400;
        }
        bool2 = bool3;
        if (paramContext.equals(localObject1)) {
          break label400;
        }
        bool2 = bool3;
        ed.a("IPDispatcher", "checkNetworkSwitch() changed and set currentNetworkRecord = null");
        bool2 = bool3;
        b(paramContext);
        bool2 = bool3;
        c = null;
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (c == null)
        {
          bool2 = bool1;
          ed.a("IPDispatcher", "checkNetworkSwitch() currentNetworkRecord == null");
          bool2 = bool1;
          localObject2 = b.iterator();
          bool2 = bool1;
          bool3 = ((Iterator)localObject2).hasNext();
          if (bool3)
          {
            bool2 = bool1;
            localObject1 = (ad)((Iterator)localObject2).next();
            bool2 = bool1;
            if (!((ad)localObject1).a.equals(paramContext)) {
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
            ((StringBuilder)localObject2).append(((ad)localObject1).e.toString());
            bool2 = bool1;
            ed.a("IPDispatcher", ((StringBuilder)localObject2).toString());
            bool2 = bool1;
            c = (ad)localObject1;
            bool2 = bool1;
            c.d = Long.valueOf(System.currentTimeMillis());
          }
          bool2 = bool1;
          bool3 = bool1;
          if (c == null)
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
            ed.a("IPDispatcher", ((StringBuilder)localObject1).toString());
            bool2 = bool1;
            c = new ad(paramContext);
            bool2 = bool1;
            b.add(c);
            bool2 = bool1;
            d.c(c);
            return bool1;
          }
        }
      }
      finally
      {
        paramContext.printStackTrace();
        bool3 = bool2;
      }
      return bool3;
      label400:
      paramContext = (Context)localObject1;
    }
  }
  
  public static ArrayList<String> f(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext();
      b((Context)localObject);
      ad localad = c;
      ArrayList localArrayList = new ArrayList(localad.e);
      int m = ud.a(paramContext, false);
      paramContext = new StringBuilder();
      paramContext.append("getIPs() localIPvX=");
      paramContext.append(m);
      paramContext.append("(0x0=none/0x1=v4/0x2=v6), original curNetworkNode.ips = ");
      paramContext.append(localArrayList);
      ed.a("IPDispatcher", paramContext.toString());
      paramContext = new ArrayList();
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = kd.a((Context)localObject, localad, localArrayList, m);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localArrayList = cd.b((Context)localObject, localad, localArrayList);
      paramContext.add(Integer.valueOf(localArrayList.size()));
      localObject = hd.a((Context)localObject, localad, localArrayList, m);
      paramContext.add(Integer.valueOf(((ArrayList)localObject).size()));
      return localObject;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void f()
  {
    long l = a;
    id.d(l);
    a = l;
    l = jd.a;
    id.e(l);
    jd.a = l;
    l = jd.b;
    id.f(l);
    jd.b = l;
    l = fd.a;
    id.a(l);
    fd.a = l;
    l = fd.b;
    id.b(l);
    fd.b = l;
    l = fd.c;
    id.c(l);
    fd.c = l;
  }
  
  public static void g()
  {
    try
    {
      if (e != null)
      {
        e.a();
        e = null;
      }
      if (d != null)
      {
        d.b();
        d = null;
      }
      if (b != null) {
        b.clear();
      }
      if (f != null)
      {
        if (!f.isShutdown()) {
          f.shutdown();
        }
        f = null;
      }
      c = null;
      g = null;
      h = false;
      return;
    }
    finally {}
  }
  
  public static boolean g(Context paramContext)
  {
    if (fd.b(c))
    {
      ed.a("IPDispatcher", "isNeedMeasure() true : IPMeasure.isOverdue()");
      return true;
    }
    ed.a("IPDispatcher", "isNeedMeasure() false : default");
    return false;
  }
  
  public static void h()
  {
    e.a(new d());
  }
  
  public static boolean h(Context paramContext)
  {
    if ((c.e != null) && (c.e.size() > 0))
    {
      paramContext = c.e.iterator();
      int m = 0;
      while (paramContext.hasNext()) {
        if (((zc)paramContext.next()).b()) {
          m += 1;
        }
      }
      double d1 = c.e.size() - m;
      double d2 = c.e.size();
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      if (d1 < 0.5D)
      {
        paramContext = new StringBuilder();
        paramContext.append("isNeedUpdate() true : goodRate=");
        paramContext.append(d1);
        paramContext.append("<0.5");
        ed.a("IPDispatcher", paramContext.toString());
        return true;
      }
      if (jd.a(c))
      {
        ed.a("IPDispatcher", "isNeedUpdate() true : IPUpdater.isOverdue()");
        return true;
      }
      ed.a("IPDispatcher", "isNeedUpdate() false : default");
      return false;
    }
    ed.a("IPDispatcher", "isNeedUpdate() true : current.Ips is null/empty");
    return true;
  }
  
  public static void i()
  {
    e.a(b, new e());
  }
  
  public static final class a
    implements pd
  {
    public a(pd parampd) {}
    
    public void a(int paramInt, Object paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("databaseRecords.grabNetworksAndIps().result() (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramObject);
      ed.a("IPDispatcher", localStringBuilder.toString());
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        if (paramObject != null) {
          td.a(pc.a(), paramObject);
        }
      }
      pc.a(pc.g);
      this.a.a(0, null);
      pc.b();
    }
  }
  
  public static final class b
    implements pd
  {
    public b(Context paramContext, ad paramad) {}
    
    public void a(int paramInt, Object paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check() IPUpdater.update().result(");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(")");
      ed.a("IPDispatcher", ((StringBuilder)localObject).toString());
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        localObject = this.a.getSharedPreferences("TencentUnipay", 0).edit();
        ((SharedPreferences.Editor)localObject).putLong("updateIPPreTime", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
        pc.a(this.a, paramad, paramObject);
        pc.a(this.a, paramad);
      }
    }
  }
  
  public static final class c
    implements pd
  {
    public c(ad paramad, Context paramContext) {}
    
    public void a(int paramInt, Object paramObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check() IPMeasure.measure().result(");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(")");
      ed.a("IPDispatcher", ((StringBuilder)localObject).toString());
      if (!this.a.a.equals(pc.c().a)) {
        return;
      }
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        long l = System.currentTimeMillis();
        paramObject = ((ArrayList)paramObject).iterator();
        while (paramObject.hasNext())
        {
          localObject = (Pair)paramObject.next();
          Iterator localIterator = this.a.e.iterator();
          while (localIterator.hasNext())
          {
            zc localzc = (zc)localIterator.next();
            if (((String)((Pair)localObject).first).equals(localzc.a)) {
              localzc.b = new Pair(Long.valueOf(l), ((Pair)localObject).second);
            }
          }
        }
        paramObject = paramContext;
        localObject = this.a;
        pc.a(paramObject, (ad)localObject, ((ad)localObject).e);
      }
    }
  }
  
  public static final class d
    implements pd
  {
    public void a(int paramInt, Object paramObject)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareFrom() (");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(")");
      ed.a("IPDispatcher", ((StringBuilder)localObject1).toString());
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        localObject1 = (ArrayList)paramObject;
        if (localObject1 == null) {
          return;
        }
        ((ArrayList)localObject1).retainAll(pc.a());
        if (((ArrayList)localObject1).size() <= 0) {
          return;
        }
        paramObject = new HashMap();
        Object localObject2 = pc.a().iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ad)((Iterator)localObject2).next();
          paramObject.put(((ad)localObject3).a, localObject3);
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ad)((Iterator)localObject1).next();
          Object localObject4 = (ad)paramObject.get(((ad)localObject3).a);
          if ((((ad)localObject4).c.longValue() > 0L) && (((ad)localObject3).c.longValue() <= ((ad)localObject4).c.longValue()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("shareFrom() shared fromNetwork is Old, Skip! Network[");
            ((StringBuilder)localObject2).append(((ad)localObject4).a);
            ((StringBuilder)localObject2).append("] : fromMeasureTime(");
            ((StringBuilder)localObject2).append(((ad)localObject3).c);
            ((StringBuilder)localObject2).append(") <= toMeasureTime(");
            ((StringBuilder)localObject2).append(((ad)localObject4).c);
            ((StringBuilder)localObject2).append(")");
            ed.a("IPDispatcher", ((StringBuilder)localObject2).toString());
          }
          else
          {
            ((ad)localObject3).e.retainAll(((ad)localObject4).e);
            if (((ad)localObject3).e.size() > 0)
            {
              localObject2 = new HashMap();
              Object localObject5 = ((ad)localObject4).e.iterator();
              Object localObject6;
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (zc)((Iterator)localObject5).next();
                ((HashMap)localObject2).put(((zc)localObject6).a, localObject6);
              }
              ((ad)localObject4).c = ((ad)localObject3).c;
              localObject3 = ((ad)localObject3).e.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (zc)((Iterator)localObject3).next();
                localObject5 = (zc)((HashMap)localObject2).get(((zc)localObject4).a);
                if ((((Long)((zc)localObject4).b.first).longValue() > 0L) && (((Long)((zc)localObject4).b.first).longValue() > ((Long)((zc)localObject5).b.first).longValue()))
                {
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("shareFrom() setMeasure ");
                  ((StringBuilder)localObject6).append(((zc)localObject5).a);
                  ((StringBuilder)localObject6).append(" = ");
                  ((StringBuilder)localObject6).append(((zc)localObject4).e());
                  ((StringBuilder)localObject6).append(" -> ");
                  ((StringBuilder)localObject6).append(((zc)localObject5).e());
                  ed.a("IPDispatcher", ((StringBuilder)localObject6).toString());
                  ((zc)localObject5).b = new Pair(((zc)localObject4).b.first, ((zc)localObject4).b.second);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static final class e
    implements pd
  {
    public void a(int paramInt, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.pc
 * JD-Core Version:    0.7.0.1
 */