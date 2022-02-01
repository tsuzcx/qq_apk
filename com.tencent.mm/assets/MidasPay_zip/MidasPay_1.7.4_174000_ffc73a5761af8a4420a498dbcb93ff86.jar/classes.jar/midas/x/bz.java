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

public class bz
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
    mg.a(new mh.d()
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
    mg.a(new mh.f()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdk.ip.");
        localStringBuilder.append(paramAnonymousString1);
        localAPDataReportManager.insertData(localStringBuilder.toString(), em.b().g(), null, null, paramAnonymousString2);
      }
    });
    mg.a(new mh.a()
    {
      public String a(String paramAnonymousString)
      {
        return gh.b(paramAnonymousString, bz.d());
      }
      
      public String b(String paramAnonymousString)
      {
        return gh.a(paramAnonymousString, bz.d());
      }
    });
    mg.a(new mh.g()
    {
      public ArrayList<String> a(Context paramAnonymousContext, mj paramAnonymousmj, ArrayList<mi> paramAnonymousArrayList, int paramAnonymousInt)
      {
        paramAnonymousmj = bz.a(paramAnonymousContext, paramAnonymousmj, bz.a(paramAnonymousContext, paramAnonymousmj, paramAnonymousArrayList, paramAnonymousInt));
        paramAnonymousContext = new ArrayList();
        paramAnonymousmj = paramAnonymousmj.iterator();
        while (paramAnonymousmj.hasNext()) {
          paramAnonymousContext.add(((mi)paramAnonymousmj.next()).a);
        }
        return paramAnonymousContext;
      }
    });
    mg.a(new mh.i()
    {
      public void a(mj paramAnonymousmj, final my paramAnonymousmy)
      {
        by.a().j(new lw()
        {
          public void a(lh paramAnonymous2lh)
          {
            Object localObject = (ck)paramAnonymous2lh;
            if (((ck)localObject).a())
            {
              paramAnonymous2lh = ((ck)localObject).b();
              paramAnonymousmy.a(0, paramAnonymous2lh);
              return;
            }
            localObject = paramAnonymousmy;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2lh.V());
            ((my)localObject).a(-1, localStringBuilder.toString());
          }
          
          public void b(lh paramAnonymous2lh)
          {
            my localmy = paramAnonymousmy;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2lh.V());
            localmy.a(1, localStringBuilder.toString());
          }
          
          public void c(lh paramAnonymous2lh)
          {
            my localmy = paramAnonymousmy;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramAnonymous2lh.V());
            localmy.a(2, localStringBuilder.toString());
          }
        });
      }
    });
    mg.a(new mh.h()
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
    mg.a(new mh.c()
    {
      public void a(mj paramAnonymousmj1, mj paramAnonymousmj2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onNetworkChanged() old=");
        localStringBuilder.append(paramAnonymousmj1.a);
        localStringBuilder.append(" -> new=");
        localStringBuilder.append(paramAnonymousmj2.a);
        APLog.w("APIPDispatcher", localStringBuilder.toString());
        if (!paramAnonymousmj1.a.equals(paramAnonymousmj2)) {
          APAppDataInterface.singleton().p("");
        }
      }
    });
    mg.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/Midas/Runtime/run_ver3.txt");
    localObject = ((StringBuilder)localObject).toString();
    mg.a(paramContext.getApplicationContext(), (String)localObject, new my()
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
    mg.a(paramString);
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
    mg.a(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static ArrayList<String> b()
  {
    if (!APAppDataInterface.singleton().e().equals("release")) {
      return new ArrayList();
    }
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
    paramContext = mg.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPDispatcher.getIPs() ips = ");
    localStringBuilder.append(paramContext.toString());
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return paramContext;
  }
  
  private static ArrayList<mi> b(Context paramContext, mj parammj, ArrayList<mi> paramArrayList)
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
    parammj = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      mi localmi = (mi)paramArrayList.next();
      if (i == 0)
      {
        if (localmi.e.intValue() > 0) {
          parammj.add(new mi(localmi));
        } else {
          localArrayList2.add(new mi(localmi));
        }
      }
      else if (i == 3)
      {
        if (localmi.e.intValue() > 0) {
          parammj.add(new mi(localmi));
        } else if ((((Long)localmi.b.first).longValue() > 0L) && (((Long)localmi.b.second).longValue() > 0L)) {
          localArrayList1.add(new mi(localmi));
        } else {
          localArrayList2.add(new mi(localmi));
        }
      }
      else if (i == 1)
      {
        if ((((Long)localmi.b.second).longValue() > 0L) && (((Long)localmi.b.second).longValue() > 0L)) {
          localArrayList1.add(new mi(localmi));
        } else {
          localArrayList2.add(new mi(localmi));
        }
      }
      else if (i == 4)
      {
        if ((((Long)localmi.b.second).longValue() > 0L) && (((Long)localmi.b.second).longValue() > 0L)) {
          localArrayList1.add(new mi(localmi));
        } else if (localmi.e.intValue() > 0) {
          parammj.add(new mi(localmi));
        } else {
          localArrayList2.add(new mi(localmi));
        }
      }
      else {
        localArrayList2.add(new mi(localmi));
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("filterIPsByStrategy() qdList : ");
    paramArrayList.append(parammj);
    paramArrayList.append(", measureList : ");
    paramArrayList.append(localArrayList1);
    paramArrayList.append("otherList : ");
    paramArrayList.append(localArrayList2);
    APLog.d("APIPDispatcher", paramArrayList.toString());
    if (parammj.size() > 1) {
      Collections.sort(parammj, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          return paramAnonymousmi1.e.intValue() - paramAnonymousmi2.e.intValue();
        }
      });
    }
    if (localArrayList1.size() > 1) {
      Collections.sort(localArrayList1, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          if (((Long)paramAnonymousmi1.b.second).longValue() - ((Long)paramAnonymousmi2.b.second).longValue() >= 0L) {
            return 1;
          }
          return -1;
        }
      });
    }
    if (localArrayList2.size() > 1) {
      Collections.sort(localArrayList2, new Comparator()
      {
        public int a(mi paramAnonymousmi1, mi paramAnonymousmi2)
        {
          int i = paramAnonymousmi1.a(8);
          int j = paramAnonymousmi2.a(8);
          if (i != j) {
            return i - j;
          }
          long l1 = paramAnonymousmi1.d() - paramAnonymousmi2.d();
          long l2 = Math.abs(l1);
          i = -1;
          if (l2 > 5000L)
          {
            if (l1 > 0L) {
              i = 1;
            }
            return i;
          }
          l1 = paramAnonymousmi1.e() - paramAnonymousmi2.e();
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
      paramContext.addAll(parammj);
      paramContext.addAll(localArrayList2);
      return paramContext;
    case 3: 
      paramContext.addAll(parammj);
      paramContext.addAll(localArrayList1);
      paramContext.addAll(localArrayList2);
      return paramContext;
    case 1: 
      paramContext.addAll(localArrayList1);
      paramContext.addAll(localArrayList2);
      return paramContext;
    }
    paramContext.addAll(parammj);
    paramContext.addAll(localArrayList2);
    return paramContext;
  }
  
  private static ArrayList<mi> b(Context paramContext, mj parammj, ArrayList<mi> paramArrayList, int paramInt)
  {
    paramContext = new ArrayList();
    if ((a(paramInt)) && (b(paramInt))) {
      switch (i.a(h()))
      {
      default: 
        parammj = paramArrayList.iterator();
        break;
      case 2: 
        paramContext.addAll(paramArrayList);
        return paramContext;
      case 1: 
        parammj = paramArrayList.iterator();
        while (parammj.hasNext())
        {
          paramArrayList = (mi)parammj.next();
          if (gi.c(paramArrayList.a)) {
            paramContext.add(paramArrayList);
          }
        }
      }
    }
    while (parammj.hasNext())
    {
      paramArrayList = (mi)parammj.next();
      if (gi.a(paramArrayList.a))
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
      new fz().a(a.a().d, "TencentPay", "abtest_type_ip", str);
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
      new fz().a(a.a().d, "TencentPay", "ip_mode", d);
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
    int j = Math.abs(em.b().n().a.openId.hashCode() / 10 % 100);
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
      c = new fz().a(a.a().d, "TencentPay", "abtest_type_ip");
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
      d = new fz().a(a.a().d, "TencentPay", "ip_mode");
      if (TextUtils.isEmpty(d)) {
        d = "0";
      }
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bz
 * JD-Core Version:    0.7.0.1
 */