package midas.x;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class bt
{
  private static final Object a = new Object();
  private static ArrayList<String> b = new ArrayList();
  private static String c = null;
  private static String d = null;
  
  static
  {
    b.add("58.60.9.101");
    b.add("113.96.232.166");
    b.add("157.255.192.104");
    b.add("58.251.116.12");
  }
  
  public static void a() {}
  
  public static void a(Context paramContext)
  {
    kv.a(new kw.d()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousString1);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramAnonymousString2);
        APLog.i("MidasIPDispatcher", localStringBuilder.toString());
      }
      
      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousString1);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramAnonymousString2);
        APLog.d("MidasIPDispatcher", localStringBuilder.toString());
      }
      
      public void c(String paramAnonymousString1, String paramAnonymousString2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousString1);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramAnonymousString2);
        APLog.w("MidasIPDispatcher", localStringBuilder.toString());
      }
    });
    kv.a(new kw.f()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdk.ip.");
        localStringBuilder.append(paramAnonymousString1);
        localAPDataReportManager.insertData(localStringBuilder.toString(), ed.b().g(), null, null, paramAnonymousString2);
      }
    });
    kv.a(new kw.a()
    {
      public String a(String paramAnonymousString)
      {
        return fx.b(paramAnonymousString, bt.d());
      }
      
      public String b(String paramAnonymousString)
      {
        return fx.a(paramAnonymousString, bt.d());
      }
    });
    kv.a(new kw.g()
    {
      public ArrayList<String> a(Context paramAnonymousContext, ky paramAnonymousky, ArrayList<kx> paramAnonymousArrayList, int paramAnonymousInt)
      {
        paramAnonymousky = bt.a(paramAnonymousContext, paramAnonymousky, bt.a(paramAnonymousContext, paramAnonymousky, paramAnonymousArrayList, paramAnonymousInt));
        paramAnonymousContext = new ArrayList();
        paramAnonymousky = paramAnonymousky.iterator();
        while (paramAnonymousky.hasNext()) {
          paramAnonymousContext.add(((kx)paramAnonymousky.next()).a);
        }
        return paramAnonymousContext;
      }
    });
    kv.a(new kw.i()
    {
      public void a(ky paramAnonymousky, final ln paramAnonymousln)
      {
        bs.a().j(new kl()
        {
          public void a(jw paramAnonymous2jw)
          {
            Object localObject = (ce)paramAnonymous2jw;
            if (((ce)localObject).a())
            {
              paramAnonymous2jw = ((ce)localObject).b();
              paramAnonymousln.a(0, paramAnonymous2jw);
              return;
            }
            localObject = paramAnonymousln;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2jw.T());
            ((ln)localObject).a(-1, localStringBuilder.toString());
          }
          
          public void b(jw paramAnonymous2jw)
          {
            ln localln = paramAnonymousln;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2jw.T());
            localln.a(1, localStringBuilder.toString());
          }
          
          public void c(jw paramAnonymous2jw)
          {
            ln localln = paramAnonymousln;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2jw.T());
            localln.a(2, localStringBuilder.toString());
          }
        });
      }
    });
    kv.a(new kw.h()
    {
      public long a(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
      
      public long b(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
      
      public long c(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
      
      public long d(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
      
      public long e(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
      
      public long f(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
    });
    kv.a(new kw.c()
    {
      public void a(ky paramAnonymousky1, ky paramAnonymousky2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNetworkChanged() old=");
        localStringBuilder.append(paramAnonymousky1.a);
        localStringBuilder.append(" -> new=");
        localStringBuilder.append(paramAnonymousky2.a);
        APLog.w("APIPDispatcher", localStringBuilder.toString());
        if (!paramAnonymousky1.a.equals(paramAnonymousky2)) {
          APAppDataInterface.singleton().p("");
        }
      }
    });
    kv.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/Midas/Runtime/run_ver3.txt");
    localObject = ((StringBuilder)localObject).toString();
    kv.a(paramContext.getApplicationContext(), (String)localObject, new ln()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IPDispatcher.init().result(");
        localStringBuilder.append(paramAnonymousInt);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramAnonymousObject);
        localStringBuilder.append(")");
        APLog.d("APIPDispatcher", localStringBuilder.toString());
      }
    });
  }
  
  public static void a(String paramString)
  {
    kv.a(paramString);
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPDispatcher.updateIP() : ip=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", completionTime=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", elapsedTime=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", isSucc=");
    localStringBuilder.append(paramBoolean);
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    kv.a(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static ArrayList<String> b()
  {
    try
    {
      synchronized (a)
      {
        Collections.sort(b, new Comparator()
        {
          public int a(String paramAnonymousString1, String paramAnonymousString2)
          {
            if (Math.random() > 0.5D) {
              return 1;
            }
            return -1;
          }
        });
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHardCodedIPs() e = ");
      localStringBuilder.append(localThrowable.toString());
      APLog.e("APIPDispatcher", localStringBuilder.toString());
      localArrayList = new ArrayList(b);
      return localArrayList;
    }
  }
  
  public static ArrayList<String> b(Context paramContext)
  {
    paramContext = kv.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPDispatcher.getIPs() ips = ");
    localStringBuilder.append(paramContext.toString());
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return paramContext;
  }
  
  private static ArrayList<kx> b(Context paramContext, ky paramky, ArrayList<kx> paramArrayList)
  {
    int i = i.a(g());
    if (i == 2) {
      if (f() == 20) {
        i = 0;
      } else {
        i = 1;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("filterIPsByStrategy() finalIPStrategy : ");
    paramContext.append(i);
    APLog.d("APIPDispatcher", paramContext.toString());
    paramContext = new ArrayList();
    paramky = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      kx localkx = (kx)paramArrayList.next();
      if (i == 0)
      {
        if (localkx.e.intValue() > 0) {
          paramky.add(new kx(localkx));
        } else {
          localArrayList2.add(new kx(localkx));
        }
      }
      else if (i == 3)
      {
        if (localkx.e.intValue() > 0) {
          paramky.add(new kx(localkx));
        } else if ((((Long)localkx.b.first).longValue() > 0L) && (((Long)localkx.b.second).longValue() > 0L)) {
          localArrayList1.add(new kx(localkx));
        } else {
          localArrayList2.add(new kx(localkx));
        }
      }
      else if (i == 1)
      {
        if ((((Long)localkx.b.second).longValue() > 0L) && (((Long)localkx.b.second).longValue() > 0L)) {
          localArrayList1.add(new kx(localkx));
        } else {
          localArrayList2.add(new kx(localkx));
        }
      }
      else if (i == 4)
      {
        if ((((Long)localkx.b.second).longValue() > 0L) && (((Long)localkx.b.second).longValue() > 0L)) {
          localArrayList1.add(new kx(localkx));
        } else if (localkx.e.intValue() > 0) {
          paramky.add(new kx(localkx));
        } else {
          localArrayList2.add(new kx(localkx));
        }
      }
      else {
        localArrayList2.add(new kx(localkx));
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("filterIPsByStrategy() qdList : ");
    paramArrayList.append(paramky);
    paramArrayList.append(", measureList : ");
    paramArrayList.append(localArrayList1);
    paramArrayList.append("otherList : ");
    paramArrayList.append(localArrayList2);
    APLog.d("APIPDispatcher", paramArrayList.toString());
    if (paramky.size() > 1) {
      Collections.sort(paramky, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          return paramAnonymouskx1.e.intValue() - paramAnonymouskx2.e.intValue();
        }
      });
    }
    if (localArrayList1.size() > 1) {
      Collections.sort(localArrayList1, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          if (((Long)paramAnonymouskx1.b.second).longValue() - ((Long)paramAnonymouskx2.b.second).longValue() >= 0L) {
            return 1;
          }
          return -1;
        }
      });
    }
    if (localArrayList2.size() > 1) {
      Collections.sort(localArrayList2, new Comparator()
      {
        public int a(kx paramAnonymouskx1, kx paramAnonymouskx2)
        {
          int i = paramAnonymouskx1.a(8);
          int j = paramAnonymouskx2.a(8);
          if (i != j) {
            return i - j;
          }
          long l1 = paramAnonymouskx1.d() - paramAnonymouskx2.d();
          long l2 = Math.abs(l1);
          i = -1;
          if (l2 > 5000L)
          {
            if (l1 > 0L) {
              i = 1;
            }
            return i;
          }
          l1 = paramAnonymouskx1.e() - paramAnonymouskx2.e();
          if (Math.abs(l1) > 5000L)
          {
            if (l1 > 0L) {
              return -1;
            }
            return 1;
          }
          if (Math.random() > 0.5D) {
            i = 1;
          }
          return i;
        }
      });
    }
    switch (i)
    {
    case 2: 
    default: 
      paramContext.addAll(localArrayList2);
      return paramContext;
    case 4: 
      paramContext.addAll(localArrayList1);
      paramContext.addAll(paramky);
      paramContext.addAll(localArrayList2);
      return paramContext;
    case 3: 
      paramContext.addAll(paramky);
      paramContext.addAll(localArrayList1);
      paramContext.addAll(localArrayList2);
      return paramContext;
    case 1: 
      paramContext.addAll(localArrayList1);
      paramContext.addAll(localArrayList2);
      return paramContext;
    }
    paramContext.addAll(paramky);
    paramContext.addAll(localArrayList2);
    return paramContext;
  }
  
  private static ArrayList<kx> b(Context paramContext, ky paramky, ArrayList<kx> paramArrayList, int paramInt)
  {
    paramContext = new ArrayList();
    if ((a(paramInt)) && (b(paramInt))) {
      switch (i.a(h()))
      {
      default: 
        paramky = paramArrayList.iterator();
        break;
      case 2: 
        paramContext.addAll(paramArrayList);
        return paramContext;
      case 1: 
        paramky = paramArrayList.iterator();
        while (paramky.hasNext())
        {
          paramArrayList = (kx)paramky.next();
          if (fy.c(paramArrayList.a)) {
            paramContext.add(paramArrayList);
          }
        }
      }
    }
    while (paramky.hasNext())
    {
      paramArrayList = (kx)paramky.next();
      if (fy.a(paramArrayList.a))
      {
        paramContext.add(paramArrayList);
        continue;
        paramContext.addAll(paramArrayList);
      }
    }
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = String.valueOf(3);
    }
    c = str;
    try
    {
      paramString = new StringBuilder();
      paramString.append("setIPStrategy() ipStrategy=");
      paramString.append(str);
      APLog.d("APIPDispatcher", paramString.toString());
      new fq().a(a.a().d, "TencentPay", "abtest_type_ip", str);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static String c()
  {
    String str2 = APAppDataInterface.singleton().e();
    String str1;
    if (str2.equals("custom"))
    {
      if (APAppDataInterface.singleton().k().equals("dev")) {
        str1 = "sandbox.api.unipay.qq.com";
      } else {
        str1 = "api.unipay.qq.com";
      }
    }
    else if (str2.equals("dev"))
    {
      str1 = "dev.api.unipay.qq.com";
    }
    else if (str2.equals("test"))
    {
      str1 = "sandbox.api.unipay.qq.com";
    }
    else if (str2.equals("release"))
    {
      str1 = "api.unipay.qq.com";
    }
    else if (str2.equals("testing"))
    {
      str1 = "testing.api.unipay.qq.com";
    }
    else
    {
      str1 = "api.unipay.qq.com";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!!!!Env error = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", so use release domain!!!!!!");
      APLog.e("APIPDispatcher", localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get current env domain, env = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" result = ");
    localStringBuilder.append(str1);
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return str1;
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    d = str;
    try
    {
      paramString = new StringBuilder();
      paramString.append("setIPMode() ipMode=");
      paramString.append(d);
      APLog.d("APIPDispatcher", paramString.toString());
      new fq().a(a.a().d, "TencentPay", "ip_mode", d);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static String e()
  {
    int[] arrayOfInt1 = new int[4];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 5;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 11;
    int[] tmp14_9 = tmp9_5;
    tmp14_9[2] = -7;
    int[] tmp19_14 = tmp14_9;
    tmp19_14[3] = 23;
    tmp19_14;
    int[] arrayOfInt2 = new int[4];
    int[] tmp32_30 = arrayOfInt2;
    tmp32_30[0] = 9;
    int[] tmp37_32 = tmp32_30;
    tmp37_32[1] = -12;
    int[] tmp42_37 = tmp37_32;
    tmp42_37[2] = 2;
    int[] tmp46_42 = tmp42_37;
    tmp46_42[3] = 19;
    tmp46_42;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("caUdsBbJ");
    int k = arrayOfInt2.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      localStringBuffer.append((char)(arrayOfInt2[i] + 99));
      i += 1;
    }
    localStringBuffer.append("BZKE9UZf");
    k = arrayOfInt1.length;
    i = j;
    while (i < k)
    {
      localStringBuffer.append((char)(arrayOfInt1[i] + 77));
      i += 1;
    }
    localStringBuffer.append("gUYGcSSD");
    return localStringBuffer.toString();
  }
  
  private static int f()
  {
    int j = Math.abs(ed.b().n().a.openId.hashCode() / 10 % 100);
    int i = 20;
    if (j >= 25)
    {
      if (j < 50) {}
      while ((j >= 75) && (j < 100))
      {
        i = 21;
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ABTest() ");
    localStringBuilder.append(i);
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return i;
  }
  
  private static String g()
  {
    if (TextUtils.isEmpty(c))
    {
      c = new fq().a(a.a().d, "TencentPay", "abtest_type_ip");
      if (TextUtils.isEmpty(c)) {
        c = String.valueOf(3);
      }
    }
    return c;
  }
  
  private static String h()
  {
    if (TextUtils.isEmpty(d))
    {
      d = new fq().a(a.a().d, "TencentPay", "ip_mode");
      if (TextUtils.isEmpty(d)) {
        d = "0";
      }
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bt
 * JD-Core Version:    0.7.0.1
 */