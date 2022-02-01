package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  private static int a = 10000;
  private static int b = 15000;
  private static int c = 5000;
  private static int d = 20000;
  private static int e = 25000;
  private static int f = 15000;
  private static int g = 1;
  private static int h = 3;
  private static ArrayList<a> i;
  private static long j;
  private static long k;
  private static long l;
  private static long m;
  private static long n;
  private static long o;
  private static long p;
  private static long q;
  private static long r;
  private static long s;
  private static int t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private static boolean y = false;
  private static int z = -1;
  
  static
  {
    a();
  }
  
  private static a a(long paramLong)
  {
    if (i == null) {
      i = new ArrayList();
    }
    int i3;
    int i1;
    synchronized (i)
    {
      int i2;
      Object localObject1;
      if (i.size() > 20)
      {
        int i4 = i.size();
        i3 = 0;
        i2 = 0;
        i1 = 0;
        if (i1 < i4 / 2) {
          break label266;
        }
        if (i2 != 0)
        {
          j = ((a)i.get(0)).d;
          k = ((a)i.get(0)).d;
          m = ((a)i.get(0)).e;
          n = ((a)i.get(0)).e;
          q = ((a)i.get(0)).f;
          r = ((a)i.get(0)).f;
          if (((a)i.get(0)).h > 0L) {
            u = (int)(((a)i.get(0)).g * 1000 / ((a)i.get(0)).h);
          }
          v = u;
          localObject1 = i.iterator();
        }
      }
      label266:
      do
      {
        a locala;
        do
        {
          if (!((Iterator)localObject1).hasNext())
          {
            localObject1 = new a();
            ((a)localObject1).b = paramLong;
            i.add(localObject1);
            return localObject1;
            if ((((a)i.get(i3)).h <= 0L) && (System.currentTimeMillis() - ((a)i.get(i3)).c <= 600000L)) {
              break label524;
            }
            i.remove(i3);
            i2 = 1;
            break;
          }
          locala = (a)((Iterator)localObject1).next();
          if (locala.d > j) {
            j = locala.d;
          }
          if (locala.d < k) {
            k = locala.d;
          }
          if (locala.e > m) {
            m = locala.e;
          }
          if (locala.e < n) {
            n = locala.e;
          }
          if (locala.f > q) {
            q = locala.f;
          }
          if (locala.f < r) {
            r = locala.f;
          }
        } while (locala.h <= 0L);
        i1 = (int)(locala.g * 1000 / locala.h);
        if (i1 > u) {
          u = i1;
        }
      } while (i1 >= v);
      v = i1;
    }
    for (;;)
    {
      i1 += 1;
      break;
      label524:
      i3 += 1;
    }
  }
  
  public static void a()
  {
    a = 12000;
    b = 20000;
    c = 8000;
    d = 20000;
    e = 25000;
    f = 15000;
    g = 1;
    h = 3;
    Object localObject = (ConnectivityManager)c.c().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        int i1 = ((NetworkInfo)localObject).getType();
        if (((NetworkInfo)localObject).isConnected())
        {
          y = true;
          z = i1;
          if (i1 == 0)
          {
            localObject = ((TelephonyManager)c.c().getSystemService("phone")).getSubscriberId();
            if ((localObject != null) && (((String)localObject).length() > 3) && (!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
            {
              a = 15000;
              b = 25000;
              c = 10000;
              d = 25000;
              e = 35000;
              f = 15000;
              g = 2;
              h = 4;
            }
          }
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    a locala1 = b(Thread.currentThread().getId());
    if (locala1 == null) {
      return;
    }
    locala1.h = (System.currentTimeMillis() - locala1.c);
    locala1.c = System.currentTimeMillis();
    locala1.g = paramInt;
    long l1;
    if (locala1.h == 0L) {
      l1 = 1L;
    }
    for (;;)
    {
      w = (int)(paramInt * 1000 / l1);
      if (w > u)
      {
        paramInt = w;
        label82:
        u = paramInt;
        if (w >= v) {
          break label253;
        }
        paramInt = w;
        label99:
        v = paramInt;
        paramInt = 0;
        l1 = 0L;
        if (i == null) {}
      }
      synchronized (i)
      {
        Iterator localIterator = i.iterator();
        if (!localIterator.hasNext())
        {
          if (l1 > 0L) {
            t = (int)(paramInt * 1000 / l1);
          }
          if ((x > 0) && (locala1.e < c) && (locala1.f < f)) {
            x -= 1;
          }
          locala1.a = null;
          locala1.j = ((int)locala1.e);
          locala1.k = locala1.k;
          locala1.l = 0;
          locala1.m = 0;
          return;
          l1 = locala1.h;
          continue;
          paramInt = u;
          break label82;
          label253:
          if (v == 0)
          {
            paramInt = w;
            break label99;
          }
          paramInt = v;
          break label99;
        }
        a locala2 = (a)localIterator.next();
        paramInt += locala2.g;
        l1 += locala2.h;
      }
    }
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    a locala2 = b(Thread.currentThread().getId());
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = a(Thread.currentThread().getId());
    }
    if (locala1 == null) {
      return;
    }
    locala1.a = paramHttpURLConnection;
    locala1.c = System.currentTimeMillis();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      x += 1;
    }
    a locala = c(Thread.currentThread().getId());
    if (locala != null)
    {
      locala.a = null;
      locala.i = (System.currentTimeMillis() - locala.c);
    }
  }
  
  public static long b()
  {
    long l2 = (x + 1) * 1000L;
    long l1 = l2;
    if (l2 > 10000L) {
      l1 = 10000L;
    }
    return l1;
  }
  
  private static a b(long paramLong)
  {
    if (i == null) {
      return null;
    }
    synchronized (i)
    {
      Iterator localIterator = i.iterator();
      a locala;
      do
      {
        if (!localIterator.hasNext()) {
          return null;
        }
        locala = (a)localIterator.next();
      } while (locala.b != paramLong);
      return locala;
    }
  }
  
  public static int c()
  {
    int i2 = a;
    int i1 = i2;
    if (l > 0L)
    {
      i1 = i2;
      if (m > 0L) {
        i1 = (int)(Math.max(o, l) + m - n);
      }
    }
    Object localObject = (ConnectivityManager)c.c().getSystemService("connectivity");
    i2 = i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      i2 = i1;
      if (localObject != null)
      {
        if ((((NetworkInfo)localObject).isConnected()) || (!((NetworkInfo)localObject).isAvailable())) {
          break label216;
        }
        i2 = b;
      }
    }
    for (;;)
    {
      i2 += x * c;
      i1 = i2;
      if (i2 <= c) {
        i1 = c;
      }
      i2 = i1;
      if (i1 <= m) {
        i2 = (int)(m + c);
      }
      i1 = i2;
      if (i2 >= b) {
        i1 = b;
      }
      a locala = b(Thread.currentThread().getId());
      localObject = locala;
      if (locala == null) {
        localObject = a(Thread.currentThread().getId());
      }
      i2 = i1;
      if (i1 < ((a)localObject).j + c) {
        i2 = ((a)localObject).j + c;
      }
      i1 = i2;
      if (i2 >= b) {
        i1 = b;
      }
      ((a)localObject).j = i1;
      return i1;
      label216:
      i2 = i1;
      if (m > 0L)
      {
        i2 = i1;
        if (m < c) {
          i2 = c;
        }
      }
    }
  }
  
  private static a c(long paramLong)
  {
    if (i != null) {
      for (;;)
      {
        int i1;
        synchronized (i)
        {
          i1 = i.size() - 1;
          if (i1 < 0) {
            break;
          }
          if (((a)i.get(i1)).b == paramLong)
          {
            a locala = (a)i.remove(i1);
            return locala;
          }
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  public static int d()
  {
    int i2 = d;
    int i1 = i2;
    if (p > 0L)
    {
      i1 = i2;
      if (q > 0L) {
        i1 = (int)(Math.max(s, p) + q - r);
      }
    }
    Object localObject = (ConnectivityManager)c.c().getSystemService("connectivity");
    i2 = i1;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      i2 = i1;
      if (localObject != null)
      {
        if ((((NetworkInfo)localObject).isConnected()) || (!((NetworkInfo)localObject).isAvailable())) {
          break label229;
        }
        i2 = e;
      }
    }
    for (;;)
    {
      i2 += x * c;
      i1 = i2;
      if (i2 <= f) {
        i1 = f;
      }
      i2 = i1;
      if (i1 <= q) {
        i2 = (int)(q + f);
      }
      i1 = i2;
      if (i2 >= e) {
        i1 = e;
      }
      localObject = b(Thread.currentThread().getId());
      i2 = i1;
      if (localObject != null)
      {
        i2 = i1;
        if (i1 < ((a)localObject).k + f) {
          i2 = ((a)localObject).k + f;
        }
        i1 = i2;
        if (i2 < ((a)localObject).j + f) {
          i1 = ((a)localObject).j + f;
        }
        i2 = i1;
        if (i1 >= e) {
          i2 = e;
        }
        ((a)localObject).k = i2;
      }
      return i2;
      label229:
      i2 = i1;
      if (q > 0L)
      {
        i2 = i1;
        if (q < f) {
          i2 = f;
        }
      }
    }
  }
  
  public static void e()
  {
    Object localObject1 = b(Thread.currentThread().getId());
    if (localObject1 == null) {}
    long l1;
    label77:
    do
    {
      return;
      ((a)localObject1).e = (System.currentTimeMillis() - ((a)localObject1).c);
      ((a)localObject1).c = System.currentTimeMillis();
      o = ((a)localObject1).e;
      if (((a)localObject1).e <= m) {
        break;
      }
      l1 = ((a)localObject1).e;
      m = l1;
      if (((a)localObject1).e >= n) {
        break label143;
      }
      l1 = ((a)localObject1).e;
      n = l1;
    } while (i == null);
    localObject1 = i;
    int i1 = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = i.iterator();
        if (localIterator.hasNext()) {
          break label166;
        }
        if (i1 > 0) {
          l /= i1;
        }
        return;
      }
      finally {}
      l1 = m;
      break;
      label143:
      if (n == 0L)
      {
        l1 = ((a)localObject1).e;
        break label77;
      }
      l1 = n;
      break label77;
      label166:
      a locala = (a)localObject2.next();
      if (locala.e > 0L)
      {
        l += locala.e;
        i1 += 1;
      }
    }
  }
  
  public static void f()
  {
    Object localObject1 = b(Thread.currentThread().getId());
    if (localObject1 == null) {}
    long l1;
    label77:
    do
    {
      return;
      ((a)localObject1).f = (System.currentTimeMillis() - ((a)localObject1).c);
      ((a)localObject1).c = System.currentTimeMillis();
      s = ((a)localObject1).f;
      if (((a)localObject1).f <= q) {
        break;
      }
      l1 = ((a)localObject1).f;
      q = l1;
      if (((a)localObject1).f >= r) {
        break label143;
      }
      l1 = ((a)localObject1).f;
      r = l1;
    } while (i == null);
    localObject1 = i;
    int i1 = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = i.iterator();
        if (localIterator.hasNext()) {
          break label166;
        }
        if (i1 > 0) {
          p /= i1;
        }
        return;
      }
      finally {}
      l1 = q;
      break;
      label143:
      if (r == 0L)
      {
        l1 = ((a)localObject1).f;
        break label77;
      }
      l1 = r;
      break label77;
      label166:
      a locala = (a)localObject2.next();
      if (locala.f > 0L)
      {
        p += locala.f;
        i1 += 1;
      }
    }
  }
  
  public static class a
  {
    public HttpURLConnection a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public long h;
    public long i;
    public int j;
    public int k;
    public int l;
    public int m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.b
 * JD-Core Version:    0.7.0.1
 */