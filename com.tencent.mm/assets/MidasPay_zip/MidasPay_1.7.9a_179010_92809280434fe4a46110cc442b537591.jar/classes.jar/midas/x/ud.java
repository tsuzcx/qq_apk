package midas.x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Patterns;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ud
{
  public static volatile long a = 0L;
  public static volatile String b = "";
  public static volatile Object c = new Object();
  public static volatile int d = -1;
  public static volatile long e;
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    i = d;
    k = 1;
    boolean bool;
    if ((i >= 0) && (l - e < 10000L)) {
      bool = paramBoolean;
    } else {
      bool = true;
    }
    if (!bool) {
      return d;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getLocalIPvX() finalRefresh=True : originRefresh=");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", localIPvX=");
    ((StringBuilder)localObject1).append(d);
    ((StringBuilder)localObject1).append(", ");
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append(" - ");
    ((StringBuilder)localObject1).append(e);
    ((StringBuilder)localObject1).append(" >= ");
    ((StringBuilder)localObject1).append(10000L);
    ((StringBuilder)localObject1).append("?");
    ed.b("NetworkStatus", ((StringBuilder)localObject1).toString());
    e = l;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (Build.VERSION.SDK_INT < 21) {
        break label334;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getLinkProperties(paramContext.getActiveNetwork());
        break label264;
      }
      localObject1 = paramContext.getAllNetworks();
      j = localObject1.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int j;
        Object localObject2;
        NetworkInfo localNetworkInfo;
        label264:
        label328:
        label334:
        label507:
        continue;
        label515:
        label531:
        label612:
        i += 1;
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
        i = -1;
        continue;
        paramContext = null;
      }
    }
    if (i < j)
    {
      localObject2 = localObject1[i];
      localNetworkInfo = paramContext.getNetworkInfo((Network)localObject2);
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        paramContext = paramContext.getLinkProperties((Network)localObject2);
        if (paramContext != null)
        {
          localObject1 = paramContext.getLinkAddresses().iterator();
          i = 0;
        }
        for (;;)
        {
          j = i;
          try
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label515;
            }
            paramContext = (LinkAddress)((Iterator)localObject1).next();
            if (paramContext == null) {
              break label743;
            }
            paramContext = paramContext.getAddress();
            j = a(paramContext);
            i |= j;
          }
          finally
          {
            break label328;
          }
        }
        j = k;
        break label531;
        localObject1 = paramContext.getActiveNetworkInfo();
        if (localObject1 == null) {
          break label748;
        }
        i = ((NetworkInfo)localObject1).getType();
        paramContext = ConnectivityManager.class.getDeclaredMethod("getLinkProperties", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(i) });
        localObject1 = paramContext.getClass().getDeclaredField("mLinkAddresses");
        ((Field)localObject1).setAccessible(true);
        paramContext = (ArrayList)((Field)localObject1).get(paramContext);
        if (paramContext != null)
        {
          i = paramContext.size();
          if (i > 0)
          {
            localObject1 = Class.forName("android.net.LinkAddress").getDeclaredMethod("getAddress", new Class[0]);
            localObject2 = paramContext.iterator();
            i = 0;
          }
        }
        try
        {
          while (((Iterator)localObject2).hasNext())
          {
            paramContext = ((Iterator)localObject2).next();
            if (paramContext == null) {
              break label753;
            }
            paramContext = (InetAddress)((Method)localObject1).invoke(paramContext, new Object[0]);
            j = a(paramContext);
            i |= j;
          }
          j = i;
        }
        finally
        {
          break label507;
        }
        j = k;
        break label531;
        j = 0;
        k = 0;
        i = j;
        j = k;
        break label531;
        i = 0;
        j = k;
        if (j == 0)
        {
          ed.a("NetworkStatus", "getLocalIPvX() by 1.ConnectivityManager");
          if (d != i) {
            d = i;
          }
        }
        else
        {
          ed.a("NetworkStatus", "getLocalIPvX() by 2.NetworkInterface");
          j = i;
          do
          {
            do
            {
              try
              {
                paramContext = NetworkInterface.getNetworkInterfaces();
                k = i;
                if (paramContext != null)
                {
                  k = i;
                  j = i;
                  if (paramContext.hasMoreElements())
                  {
                    j = i;
                    localObject1 = (NetworkInterface)paramContext.nextElement();
                  }
                }
              }
              catch (SocketException paramContext)
              {
                for (;;)
                {
                  k = j;
                }
              }
              try
              {
                paramBoolean = ((NetworkInterface)localObject1).isUp();
              }
              catch (SocketException localSocketException)
              {
                break label612;
              }
              paramBoolean = false;
            } while (!paramBoolean);
            j = i;
            localObject1 = ((NetworkInterface)localObject1).getInetAddresses();
          } while (localObject1 == null);
          k = i;
          for (;;)
          {
            i = k;
            j = k;
            if (!((Enumeration)localObject1).hasMoreElements()) {
              break;
            }
            j = k;
            i = a((InetAddress)((Enumeration)localObject1).nextElement());
            k |= i;
          }
          if (d != k) {
            d = k;
          }
        }
        if (d < 0) {
          d = 0;
        }
        return d;
      }
    }
  }
  
  public static int a(InetAddress paramInetAddress)
  {
    if ((paramInetAddress != null) && (!paramInetAddress.isLoopbackAddress()) && (!paramInetAddress.isLinkLocalAddress()) && (!paramInetAddress.isAnyLocalAddress()))
    {
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
      if ((paramInetAddress instanceof Inet4Address)) {
        return 1;
      }
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "no_isp_code";
    }
    paramContext = paramContext.getSimOperator();
    StringBuilder localStringBuilder;
    if (paramContext != null)
    {
      if (paramContext.length() < 5) {
        return "no_isp_code";
      }
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label122;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext.printStackTrace();
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label127;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label127;
        }
      }
      paramContext = localStringBuilder.toString();
      return paramContext;
      return "no_isp_code";
      label122:
      int j = 0;
      continue;
      label127:
      j += 1;
    }
  }
  
  public static void a()
  {
    synchronized (c)
    {
      b = "";
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected());
  }
  
  public static boolean a(String paramString)
  {
    return Patterns.IP_ADDRESS.matcher(paramString).matches();
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      }
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        if (a((NetworkInfo)localObject))
        {
          if (b((NetworkInfo)localObject)) {
            return 1000;
          }
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext == null) {
            return -1;
          }
          int i = paramContext.getNetworkType();
          switch (i)
          {
          default: 
            return -1;
          case 13: 
          case 18: 
            return 4;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
          case 17: 
            return 3;
          }
          return 2;
        }
      }
      else {
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNetWorkType() e = ");
      ((StringBuilder)localObject).append(paramContext.toString());
      ed.b("NetworkStatus", ((StringBuilder)localObject).toString());
    }
    return -1;
  }
  
  public static String b(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    boolean bool1;
    if (l - a >= 10000L) {
      bool1 = true;
    } else {
      bool1 = paramBoolean;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      synchronized (c)
      {
        if (TextUtils.isEmpty(b)) {
          bool1 = true;
        }
        bool2 = bool1;
      }
    }
    if (!bool2) {
      return b;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("getNetworkIdentifier() finalRefresh=True : originRefresh=");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append(", networkIdentifier=");
    ((StringBuilder)???).append(b);
    ((StringBuilder)???).append(", ");
    ((StringBuilder)???).append(l);
    ((StringBuilder)???).append(" - ");
    ((StringBuilder)???).append(a);
    ((StringBuilder)???).append(" >= ");
    ((StringBuilder)???).append(10000L);
    ((StringBuilder)???).append("?");
    ed.b("NetworkStatus", ((StringBuilder)???).toString());
    a = l;
    int i = b(paramContext);
    if (i != -1)
    {
      if (i != 0)
      {
        if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
        {
          if (i != 1000) {
            b = "default_net";
          } else {
            b = c(paramContext);
          }
        }
        else {
          b = a(paramContext);
        }
      }
      else {
        b = "none_net";
      }
    }
    else {
      b = "other_net";
    }
    paramContext = new StringBuilder();
    paramContext.append(pc.d());
    paramContext.append("-");
    paramContext.append(b);
    b = paramContext.toString();
    return b;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo != null) && (paramNetworkInfo.isConnected()) && (paramNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"));
  }
  
  public static boolean b(String paramString)
  {
    return c(paramString);
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 82
    //   3: invokevirtual 88	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 90	android/net/ConnectivityManager
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +7 -> 18
    //   14: ldc_w 365
    //   17: areturn
    //   18: aload_2
    //   19: invokevirtual 154	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +497 -> 521
    //   27: aload_2
    //   28: invokevirtual 158	android/net/NetworkInfo:getType	()I
    //   31: iconst_1
    //   32: if_icmpeq +7 -> 39
    //   35: ldc_w 365
    //   38: areturn
    //   39: aload_0
    //   40: ldc_w 367
    //   43: invokevirtual 88	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   46: checkcast 369	android/net/wifi/WifiManager
    //   49: astore 4
    //   51: aload 4
    //   53: ifnonnull +7 -> 60
    //   56: ldc_w 365
    //   59: areturn
    //   60: aconst_null
    //   61: astore_3
    //   62: aload_3
    //   63: astore_2
    //   64: aload_0
    //   65: ldc_w 371
    //   68: invokestatic 376	midas/x/sd:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   71: ifeq +19 -> 90
    //   74: aload 4
    //   76: invokevirtual 380	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   79: astore_2
    //   80: goto +10 -> 90
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 383	java/lang/Throwable:printStackTrace	()V
    //   88: aload_3
    //   89: astore_2
    //   90: aload_2
    //   91: ifnonnull +7 -> 98
    //   94: ldc_w 365
    //   97: areturn
    //   98: aload_2
    //   99: invokevirtual 388	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   102: astore 4
    //   104: aload 4
    //   106: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +7 -> 116
    //   112: ldc_w 365
    //   115: areturn
    //   116: aload 4
    //   118: astore_3
    //   119: ldc_w 390
    //   122: aload 4
    //   124: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +392 -> 519
    //   130: aload 4
    //   132: astore_3
    //   133: ldc_w 396
    //   136: aload_2
    //   137: invokevirtual 399	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   140: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +376 -> 519
    //   146: aload_0
    //   147: iconst_0
    //   148: invokestatic 401	midas/x/ud:a	(Landroid/content/Context;Z)I
    //   151: istore_1
    //   152: iload_1
    //   153: invokestatic 403	midas/x/ud:a	(I)Z
    //   156: ifeq +17 -> 173
    //   159: iload_1
    //   160: invokestatic 405	midas/x/ud:b	(I)Z
    //   163: ifeq +10 -> 173
    //   166: ldc_w 407
    //   169: astore_0
    //   170: goto +14 -> 184
    //   173: iload_1
    //   174: invokestatic 405	midas/x/ud:b	(I)Z
    //   177: ifeq +12 -> 189
    //   180: ldc_w 409
    //   183: astore_0
    //   184: aload_0
    //   185: astore_2
    //   186: goto +24 -> 210
    //   189: iload_1
    //   190: invokestatic 403	midas/x/ud:a	(I)Z
    //   193: ifeq +10 -> 203
    //   196: ldc_w 411
    //   199: astore_0
    //   200: goto -16 -> 184
    //   203: ldc_w 413
    //   206: astore_0
    //   207: goto -23 -> 184
    //   210: new 43	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   217: astore_0
    //   218: aload_0
    //   219: ldc_w 415
    //   222: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_0
    //   227: getstatic 95	android/os/Build$VERSION:SDK_INT	I
    //   230: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: ldc_w 417
    //   238: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: ldc 71
    //   244: aload_0
    //   245: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 419	midas/x/ed:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: new 43	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   258: astore_0
    //   259: aload_0
    //   260: ldc_w 421
    //   263: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_0
    //   268: getstatic 95	android/os/Build$VERSION:SDK_INT	I
    //   271: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_0
    //   276: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: astore_3
    //   280: aload_3
    //   281: astore_0
    //   282: getstatic 95	android/os/Build$VERSION:SDK_INT	I
    //   285: bipush 27
    //   287: if_icmplt +117 -> 404
    //   290: new 43	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   297: astore_0
    //   298: aload_0
    //   299: aload_3
    //   300: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_0
    //   305: ldc_w 423
    //   308: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_0
    //   313: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore_0
    //   317: new 43	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   324: astore_3
    //   325: aload_3
    //   326: aload_0
    //   327: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_3
    //   332: ldc_w 425
    //   335: invokestatic 430	midas/x/td:a	(Ljava/lang/String;)I
    //   338: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore_0
    //   347: new 43	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   354: astore_3
    //   355: aload_3
    //   356: aload_0
    //   357: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_3
    //   362: ldc_w 432
    //   365: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_3
    //   370: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: astore_0
    //   374: new 43	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   381: astore_3
    //   382: aload_3
    //   383: aload_0
    //   384: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_3
    //   389: ldc_w 434
    //   392: invokestatic 430	midas/x/td:a	(Ljava/lang/String;)I
    //   395: invokevirtual 58	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload_3
    //   400: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: astore_0
    //   404: aload_0
    //   405: astore_3
    //   406: getstatic 95	android/os/Build$VERSION:SDK_INT	I
    //   409: bipush 28
    //   411: if_icmplt +60 -> 471
    //   414: getstatic 438	midas/x/pc:g	Landroid/content/Context;
    //   417: ldc_w 440
    //   420: invokevirtual 88	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   423: checkcast 442	android/location/LocationManager
    //   426: astore_3
    //   427: new 43	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   434: astore 4
    //   436: aload 4
    //   438: aload_0
    //   439: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 4
    //   445: ldc_w 444
    //   448: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 4
    //   454: aload_3
    //   455: ldc_w 446
    //   458: invokevirtual 449	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   461: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 4
    //   467: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: astore_3
    //   471: new 43	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   478: astore_0
    //   479: aload_0
    //   480: ldc_w 451
    //   483: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_0
    //   488: aload_2
    //   489: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_0
    //   494: ldc_w 453
    //   497: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_0
    //   502: aload_3
    //   503: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: ldc_w 455
    //   510: aload_0
    //   511: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 458	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: aload_2
    //   518: astore_3
    //   519: aload_3
    //   520: areturn
    //   521: ldc_w 365
    //   524: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	paramContext	Context
    //   151	39	1	i	int
    //   9	71	2	localObject1	Object
    //   83	2	2	localObject2	Object
    //   89	429	2	localObject3	Object
    //   61	459	3	localObject4	Object
    //   49	417	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   64	80	83	finally
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::")))) {
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (paramString.endsWith("::")) {
        ((List)localObject).add("");
      } else if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    }
    if (localObject.length > 8) {
      return false;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (k < localObject.length)
      {
        paramString = localObject[k];
        if (paramString.length() == 0)
        {
          int m = i + 1;
          i = m;
          if (m > 1) {
            return false;
          }
        }
        else
        {
          if ((k == localObject.length - 1) && (paramString.contains(".")))
          {
            if (!a(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label305;
          }
          if (paramString.length() > 4) {
            return false;
          }
        }
      }
      try
      {
        i = Integer.parseInt(paramString, 16);
        if (i >= 0)
        {
          if (i > 65535) {
            return false;
          }
          i = 0;
          j += 1;
          label305:
          k += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (j <= 8) {
      return (j >= 8) || (bool);
    }
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ud
 * JD-Core Version:    0.7.0.1
 */