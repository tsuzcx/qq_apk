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

public class a2
{
  public static final Object a = new Object();
  public static ArrayList<String> b = new ArrayList();
  public static String c = null;
  public static String d = null;
  
  static
  {
    b.add("58.60.9.101");
    b.add("113.96.232.166");
    b.add("157.255.192.104");
    b.add("58.251.116.12");
  }
  
  public static int a()
  {
    int j = Math.abs(p4.p().e().b.openId.hashCode() / 10 % 100);
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
  
  public static ArrayList<String> a(Context paramContext)
  {
    paramContext = pc.f(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IPDispatcher.getIPs() ips = ");
    localStringBuilder.append(paramContext.toString());
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return paramContext;
  }
  
  public static void a(String paramString)
  {
    pc.a(paramString);
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
    pc.a(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static ArrayList<zc> b(Context paramContext, ad paramad, ArrayList<zc> paramArrayList)
  {
    int i = i.b(g());
    if (i == 2) {
      if (a() == 20) {
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
    paramad = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zc localzc = (zc)paramArrayList.next();
      if (i == 0)
      {
        if (localzc.e.intValue() > 0) {
          paramad.add(new zc(localzc));
        } else {
          localArrayList2.add(new zc(localzc));
        }
      }
      else if (i == 3)
      {
        if (localzc.e.intValue() > 0) {
          paramad.add(new zc(localzc));
        } else if ((((Long)localzc.b.first).longValue() > 0L) && (((Long)localzc.b.second).longValue() > 0L)) {
          localArrayList1.add(new zc(localzc));
        } else {
          localArrayList2.add(new zc(localzc));
        }
      }
      else if (i == 1)
      {
        if ((((Long)localzc.b.second).longValue() > 0L) && (((Long)localzc.b.second).longValue() > 0L)) {
          localArrayList1.add(new zc(localzc));
        } else {
          localArrayList2.add(new zc(localzc));
        }
      }
      else if (i == 4)
      {
        if ((((Long)localzc.b.second).longValue() > 0L) && (((Long)localzc.b.second).longValue() > 0L)) {
          localArrayList1.add(new zc(localzc));
        } else if (localzc.e.intValue() > 0) {
          paramad.add(new zc(localzc));
        } else {
          localArrayList2.add(new zc(localzc));
        }
      }
      else {
        localArrayList2.add(new zc(localzc));
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("filterIPsByStrategy() qdList : ");
    paramArrayList.append(paramad);
    paramArrayList.append(", measureList : ");
    paramArrayList.append(localArrayList1);
    paramArrayList.append("otherList : ");
    paramArrayList.append(localArrayList2);
    APLog.d("APIPDispatcher", paramArrayList.toString());
    if (paramad.size() > 1) {
      Collections.sort(paramad, new a());
    }
    if (localArrayList1.size() > 1) {
      Collections.sort(localArrayList1, new b());
    }
    if (localArrayList2.size() > 1) {
      Collections.sort(localArrayList2, new c());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramContext.addAll(localArrayList2);
            return paramContext;
          }
          paramContext.addAll(localArrayList1);
          paramContext.addAll(paramad);
          paramContext.addAll(localArrayList2);
          return paramContext;
        }
        paramContext.addAll(paramad);
        paramContext.addAll(localArrayList1);
        paramContext.addAll(localArrayList2);
        return paramContext;
      }
      paramContext.addAll(localArrayList1);
      paramContext.addAll(localArrayList2);
      return paramContext;
    }
    paramContext.addAll(paramad);
    paramContext.addAll(localArrayList2);
    return paramContext;
  }
  
  public static ArrayList<zc> b(Context paramContext, ad paramad, ArrayList<zc> paramArrayList, int paramInt)
  {
    paramContext = new ArrayList();
    if ((a(paramInt)) && (b(paramInt)))
    {
      paramInt = i.b(f());
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          paramad = paramArrayList.iterator();
          while (paramad.hasNext())
          {
            paramArrayList = (zc)paramad.next();
            if (m6.b(paramArrayList.a)) {
              paramContext.add(paramArrayList);
            }
          }
        }
        paramContext.addAll(paramArrayList);
        return paramContext;
      }
      paramad = paramArrayList.iterator();
    }
    while (paramad.hasNext())
    {
      paramArrayList = (zc)paramad.next();
      if (m6.c(paramArrayList.a))
      {
        paramContext.add(paramArrayList);
        continue;
        paramContext.addAll(paramArrayList);
      }
    }
    return paramContext;
  }
  
  public static void b(Context paramContext)
  {
    pc.a(new d());
    pc.a(new e());
    pc.a(new f());
    pc.a(new g());
    pc.a(new h());
    pc.a(new i());
    pc.a(new j());
    pc.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject).append("/tencent/Midas/Runtime/run_ver3.txt");
    localObject = ((StringBuilder)localObject).toString();
    pc.a(paramContext.getApplicationContext(), (String)localObject, new k());
  }
  
  public static void b(String paramString)
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
      new d6().a(a.r().d, "TencentPay", "ip_mode", d);
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
    String str = APAppDataInterface.singleton().h();
    boolean bool = str.equals("custom");
    Object localObject = "sandbox.api.unipay.qq.com";
    if (bool)
    {
      if (APAppDataInterface.singleton().f().equals("dev")) {}
    }
    else {
      for (;;)
      {
        localObject = "api.unipay.qq.com";
        break;
        if (str.equals("dev"))
        {
          localObject = "dev.api.unipay.qq.com";
          break;
        }
        if (str.equals("test")) {
          break;
        }
        if (!str.equals("release"))
        {
          if (str.equals("testing"))
          {
            localObject = "testing.api.unipay.qq.com";
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("!!!!!!Env error = ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", so use release domain!!!!!!");
          APLog.e("APIPDispatcher", ((StringBuilder)localObject).toString());
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get current env domain, env = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" result = ");
    localStringBuilder.append((String)localObject);
    APLog.d("APIPDispatcher", localStringBuilder.toString());
    return localObject;
  }
  
  public static void c(String paramString)
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
      new d6().a(a.r().d, "TencentPay", "abtest_type_ip", str);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String d()
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
  
  public static ArrayList<String> e()
  {
    if (!APAppDataInterface.singleton().h().equals("release")) {
      return new ArrayList();
    }
    synchronized (a)
    {
      Collections.sort(b, new l());
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHardCodedIPs() e = ");
      localStringBuilder.append(localObject2.toString());
      APLog.e("APIPDispatcher", localStringBuilder.toString());
      ArrayList localArrayList = new ArrayList(b);
      return localArrayList;
    }
    finally {}
  }
  
  public static String f()
  {
    if (TextUtils.isEmpty(d))
    {
      d = new d6().a(a.r().d, "TencentPay", "ip_mode");
      if (TextUtils.isEmpty(d)) {
        d = "0";
      }
    }
    return d;
  }
  
  public static String g()
  {
    if (TextUtils.isEmpty(c))
    {
      c = new d6().a(a.r().d, "TencentPay", "abtest_type_ip");
      if (TextUtils.isEmpty(c)) {
        c = String.valueOf(3);
      }
    }
    return c;
  }
  
  public static void h() {}
  
  public static final class a
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      return paramzc1.e.intValue() - paramzc2.e.intValue();
    }
  }
  
  public static final class b
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      if (((Long)paramzc1.b.second).longValue() - ((Long)paramzc2.b.second).longValue() >= 0L) {
        return 1;
      }
      return -1;
    }
  }
  
  public static final class c
    implements Comparator<zc>
  {
    public int a(zc paramzc1, zc paramzc2)
    {
      int i = paramzc1.a(8);
      int j = paramzc2.a(8);
      if (i != j) {
        return i - j;
      }
      long l1 = paramzc1.c() - paramzc2.c();
      long l2 = Math.abs(l1);
      i = 1;
      if (l2 > 5000L)
      {
        if (l1 > 0L) {
          return 1;
        }
        return -1;
      }
      l1 = paramzc1.d() - paramzc2.d();
      if (Math.abs(l1) > 5000L)
      {
        if (l1 > 0L) {
          i = -1;
        }
        return i;
      }
      if (Math.random() > 0.5D) {
        return 1;
      }
      return -1;
    }
  }
  
  public static final class d
    implements tc
  {
    public void a(String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramString2);
      APLog.w("MidasIPDispatcher", localStringBuilder.toString());
    }
    
    public void b(String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramString2);
      APLog.d("MidasIPDispatcher", localStringBuilder.toString());
    }
    
    public void c(String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramString2);
      APLog.i("MidasIPDispatcher", localStringBuilder.toString());
    }
  }
  
  public static final class e
    implements vc
  {
    public void a(String paramString1, String paramString2)
    {
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sdk.ip.");
      localStringBuilder.append(paramString1);
      localAPDataReportManager.insertData(localStringBuilder.toString(), p4.p().g(), null, null, paramString2);
    }
  }
  
  public static final class f
    implements qc
  {
    public String a(String paramString)
    {
      return l6.a(paramString, a2.b());
    }
    
    public String b(String paramString)
    {
      return l6.c(paramString, a2.b());
    }
  }
  
  public static final class g
    implements wc
  {
    public ArrayList<String> a(Context paramContext, ad paramad, ArrayList<zc> paramArrayList, int paramInt)
    {
      paramad = a2.a(paramContext, paramad, a2.a(paramContext, paramad, paramArrayList, paramInt));
      paramContext = new ArrayList();
      paramad = paramad.iterator();
      while (paramad.hasNext()) {
        paramContext.add(((zc)paramad.next()).a);
      }
      return paramContext;
    }
  }
  
  public static final class h
    implements yc
  {
    public void a(ad paramad, final pd parampd)
    {
      z1.d().b(new a(parampd));
    }
    
    public class a
      implements fc
    {
      public a(pd parampd) {}
      
      public void a(ob paramob)
      {
        Object localObject = (l2)paramob;
        if (((l2)localObject).h())
        {
          paramob = ((l2)localObject).g();
          parampd.a(0, paramob);
          return;
        }
        localObject = parampd;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramob.c());
        ((pd)localObject).a(-1, localStringBuilder.toString());
      }
      
      public void b(ob paramob)
      {
        pd localpd = parampd;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramob.c());
        localpd.a(1, localStringBuilder.toString());
      }
      
      public void c(ob paramob)
      {
        pd localpd = parampd;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramob.c());
        localpd.a(2, localStringBuilder.toString());
      }
    }
  }
  
  public static final class i
    implements xc
  {
    public long a(long paramLong)
    {
      return paramLong;
    }
    
    public long b(long paramLong)
    {
      return paramLong;
    }
    
    public long c(long paramLong)
    {
      return paramLong;
    }
    
    public long d(long paramLong)
    {
      return paramLong;
    }
    
    public long e(long paramLong)
    {
      return paramLong;
    }
    
    public long f(long paramLong)
    {
      return paramLong;
    }
  }
  
  public static final class j
    implements sc
  {
    public void a(ad paramad1, ad paramad2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetworkChanged() old=");
      localStringBuilder.append(paramad1.a);
      localStringBuilder.append(" -> new=");
      localStringBuilder.append(paramad2.a);
      APLog.w("APIPDispatcher", localStringBuilder.toString());
      if (!paramad1.a.equals(paramad2)) {
        APAppDataInterface.singleton().n("");
      }
    }
  }
  
  public static final class k
    implements pd
  {
    public void a(int paramInt, Object paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IPDispatcher.init().result(");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(")");
      APLog.d("APIPDispatcher", localStringBuilder.toString());
    }
  }
  
  public static final class l
    implements Comparator<String>
  {
    public int a(String paramString1, String paramString2)
    {
      if (Math.random() > 0.5D) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a2
 * JD-Core Version:    0.7.0.1
 */