package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class dg
{
  private static HandlerThread m;
  private static volatile dg n;
  public final Context a;
  public final dh b;
  public final ExecutorService c;
  final PackageManager d;
  public final TelephonyManager e;
  public final WifiManager f;
  public final LocationManager g;
  public final TencentHttpClient h;
  String i;
  private final HashMap<String, di> j;
  private CountDownLatch k;
  private final SharedPreferences l;
  private List<et> o;
  
  private dg(Context paramContext)
  {
    this.a = paramContext;
    this.d = paramContext.getPackageManager();
    this.e = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.f = ((WifiManager)paramContext.getSystemService("wifi"));
    this.g = ((LocationManager)paramContext.getSystemService("location"));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", j.e(paramContext.getPackageName()));
    this.h = TencentHttpClientFactory.getInstance().getTencentHttpClient(paramContext, (Bundle)localObject);
    this.l = paramContext.getSharedPreferences("LocationSDK", 0);
    localObject = new dg.1();
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), (ThreadFactory)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.c = ((ExecutorService)localObject);
    localObject = new HandlerThread("GeoLocationService");
    m = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    this.j = new HashMap();
    if (Build.VERSION.SDK_INT >= 12) {
      this.j.put("cell", new dj("cell"));
    }
    this.b = new dh();
    try
    {
      this.b.h = b(paramContext);
      a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        j.a("AppContext", 6, "transactionTooLarge");
      }
    }
  }
  
  public static dg a(Context paramContext)
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new dg(paramContext);
      }
      return n;
    }
    finally {}
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentGeoLocationSDK")) {
          return paramContext.getString("TencentGeoLocationSDK");
        }
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          return paramContext;
        }
        return "";
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private String b(String paramString)
  {
    dh localdh = this.b;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", localdh.d());
    localHashMap.put("app_name", c(localdh.i));
    localHashMap.put("app_label", c(localdh.j));
    localHashMap.put("l", paramString);
    try
    {
      paramString = new JSONObject(localHashMap);
      localdh = this.b;
      localHashMap = new HashMap();
      localHashMap.put("imei", c(localdh.a()));
      localHashMap.put("imsi", c(localdh.b()));
      localHashMap.put("n", c(j.c(localdh.d)));
      localHashMap.put("qq", c(j.c(localdh.f)));
      localHashMap.put("mac", c(localdh.c().toLowerCase(Locale.ENGLISH)));
      localHashMap.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
      paramString = paramString.put("attribute", new JSONObject(localHashMap)).toString();
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static HandlerThread d()
  {
    if ((m == null) || (!m.isAlive()) || (m.getLooper() == null))
    {
      HandlerThread localHandlerThread = new HandlerThread("GeoLocationService");
      m = localHandlerThread;
      localHandlerThread.start();
    }
    return m;
  }
  
  public final di a(String paramString)
  {
    return (di)this.j.get(paramString);
  }
  
  public final void a()
  {
    this.k = new CountDownLatch(1);
    new Thread(new dg.2(this)).start();
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        if (this.o == null) {
          this.o = new ArrayList();
        }
        Object localObject1 = this.o.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label191;
        }
        localObject2 = ((et)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        i1 = 1;
        if (i1 != 0) {
          return;
        }
        localObject1 = paramObject.getClass().getDeclaredMethods();
        int i2 = localObject1.length;
        i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        localObject2 = localObject1[i1];
        localObject3 = ((Method)localObject2).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label184;
        }
        localObject3 = ((Method)localObject2).getParameterTypes();
        if (localObject3.length != 1) {
          throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
        }
      }
      finally {}
      Object localObject2 = new et(localObject3[0], (Method)localObject2, paramObject);
      this.o.add(localObject2);
      label184:
      i1 += 1;
      continue;
      label191:
      int i1 = 0;
    }
  }
  
  /* Error */
  public final void b(@org.eclipse.jdt.annotation.Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 340	c/t/m/g/dg:o	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 349 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 354 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 358 1 0
    //   40: checkcast 360	c/t/m/g/et
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 367	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 408	c/t/m/g/et:a	Ljava/lang/Class;
    //   54: invokevirtual 411	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 414	c/t/m/g/et:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 363	c/t/m/g/et:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 418	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: ldc 184
    //   91: ldc 223
    //   93: aload 4
    //   95: invokestatic 421	c/t/m/g/j:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -73 -> 25
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	dg
    //   0	106	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localet	et
    //   87	7	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	101	finally
    //   18	25	101	finally
    //   25	58	101	finally
    //   62	84	101	finally
    //   89	98	101	finally
  }
  
  public final boolean b()
  {
    return this.e != null;
  }
  
  public final dh c()
  {
    if (-1L > 0L) {}
    try
    {
      if (!this.k.await(-1L, TimeUnit.MILLISECONDS))
      {
        return null;
        this.k.await();
      }
      return this.b;
    }
    catch (InterruptedException localInterruptedException) {}
    return null;
  }
  
  public final String e()
  {
    if (!de.a().d("up_apps")) {
      return "";
    }
    long l1 = this.l.getLong("location_time", 0L);
    if (System.currentTimeMillis() - l1 > 259200000L) {}
    for (;;)
    {
      try
      {
        Object localObject2 = this.d.getInstalledPackages(8192);
        Object localObject1 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        int i1 = 1;
        if (((Iterator)localObject2).hasNext())
        {
          PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
          i2 = localPackageInfo.applicationInfo.flags;
          Object localObject3 = localPackageInfo.applicationInfo;
          if (((i2 & 0x1) > 0) || (i1 > 60)) {
            break label326;
          }
          localObject3 = localPackageInfo.applicationInfo.loadLabel(this.d).toString();
          if ((((String)localObject3).length() > 30) || (((String)localObject3).startsWith("com.")) || (((String)localObject3).contains("theme"))) {
            break label329;
          }
          if (!((String)localObject3).contains("CheilPengtai")) {
            break label337;
          }
          break label329;
          if (i2 != 0) {
            break label326;
          }
          ((StringBuilder)localObject1).append(localPackageInfo.applicationInfo.packageName);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append('_');
          ((StringBuilder)localObject1).append(localPackageInfo.versionName);
          ((StringBuilder)localObject1).append('|');
          i1 += 1;
          break label334;
        }
        this.l.edit().putLong("location_time", System.currentTimeMillis()).apply();
        localObject1 = b(((StringBuilder)localObject1).toString());
        return localObject1;
      }
      catch (Exception localException)
      {
        this.l.edit().putLong("location_time", System.currentTimeMillis()).apply();
      }
      return "";
      label326:
      break label334;
      label329:
      int i2 = 1;
      continue;
      label334:
      continue;
      label337:
      i2 = 0;
    }
  }
  
  final PackageInfo f()
  {
    try
    {
      PackageInfo localPackageInfo = this.d.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return new PackageInfo();
  }
  
  /* Error */
  final String g()
  {
    // Byte code:
    //   0: ldc 223
    //   2: astore_3
    //   3: aload_0
    //   4: getfield 113	c/t/m/g/dg:l	Landroid/content/SharedPreferences;
    //   7: ldc_w 528
    //   10: ldc 223
    //   12: invokeinterface 531 3 0
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload 4
    //   24: invokestatic 536	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +6 -> 33
    //   30: aload 4
    //   32: areturn
    //   33: aload 4
    //   35: astore_3
    //   36: invokestatic 542	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   39: astore 5
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: invokeinterface 547 1 0
    //   51: ifeq +166 -> 217
    //   54: aload 5
    //   56: invokeinterface 550 1 0
    //   61: checkcast 538	java/net/NetworkInterface
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull -24 -> 44
    //   71: aload 4
    //   73: invokevirtual 551	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   76: ldc_w 553
    //   79: invokevirtual 556	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq -38 -> 44
    //   85: aload 4
    //   87: invokevirtual 560	java/net/NetworkInterface:getHardwareAddress	()[B
    //   90: astore 4
    //   92: aload 4
    //   94: ifnull -50 -> 44
    //   97: aload 4
    //   99: arraylength
    //   100: ifeq -56 -> 44
    //   103: new 281	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   110: astore 6
    //   112: aload 4
    //   114: arraylength
    //   115: istore_2
    //   116: iconst_0
    //   117: istore_1
    //   118: iload_1
    //   119: iload_2
    //   120: if_icmpge +36 -> 156
    //   123: aload 6
    //   125: ldc_w 562
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 4
    //   136: iload_1
    //   137: baload
    //   138: invokestatic 568	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   141: aastore
    //   142: invokestatic 572	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: iload_1
    //   150: iconst_1
    //   151: iadd
    //   152: istore_1
    //   153: goto -35 -> 118
    //   156: aload 6
    //   158: invokevirtual 573	java/lang/StringBuilder:length	()I
    //   161: ifle +16 -> 177
    //   164: aload 6
    //   166: aload 6
    //   168: invokevirtual 573	java/lang/StringBuilder:length	()I
    //   171: iconst_1
    //   172: isub
    //   173: invokevirtual 577	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 4
    //   184: aload 4
    //   186: astore_3
    //   187: aload_0
    //   188: getfield 113	c/t/m/g/dg:l	Landroid/content/SharedPreferences;
    //   191: invokeinterface 505 1 0
    //   196: ldc_w 528
    //   199: aload 4
    //   201: invokeinterface 580 3 0
    //   206: invokeinterface 514 1 0
    //   211: aload 4
    //   213: astore_3
    //   214: goto -170 -> 44
    //   217: aload_3
    //   218: areturn
    //   219: astore 4
    //   221: ldc_w 582
    //   224: bipush 6
    //   226: aload 4
    //   228: invokevirtual 583	java/lang/Throwable:toString	()Ljava/lang/String;
    //   231: invokestatic 189	c/t/m/g/j:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_3
    //   235: areturn
    //   236: astore 4
    //   238: goto -17 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	dg
    //   117	36	1	i1	int
    //   115	6	2	i2	int
    //   2	233	3	localObject1	Object
    //   17	195	4	localObject2	Object
    //   219	8	4	localThrowable1	java.lang.Throwable
    //   236	1	4	localThrowable2	java.lang.Throwable
    //   39	16	5	localEnumeration	java.util.Enumeration
    //   110	68	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	19	219	java/lang/Throwable
    //   22	30	219	java/lang/Throwable
    //   36	41	219	java/lang/Throwable
    //   187	211	219	java/lang/Throwable
    //   44	66	236	java/lang/Throwable
    //   71	92	236	java/lang/Throwable
    //   97	116	236	java/lang/Throwable
    //   123	149	236	java/lang/Throwable
    //   156	177	236	java/lang/Throwable
    //   177	184	236	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.dg
 * JD-Core Version:    0.7.0.1
 */