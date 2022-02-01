package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import java.net.InetSocketAddress;

public class ApnProxyManager
{
  private static final int jdField_a_of_type_Int = 80;
  private static Uri jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  private static String jdField_a_of_type_JavaLangString = "epc.tmobile.com";
  private static final String b = "ctnet";
  private static final String c = "ctwap";
  private static final String d = "cmnet";
  private static final String e = "cmwap";
  private static final String f = "uninet";
  private static final String g = "uniwap";
  private static final String h = "3gwap";
  private static final String i = "3gnet";
  private static final String j = "10.0.0.172";
  private static final String k = "10.0.0.172";
  private static final String l = "10.0.0.200";
  private static final String m = "apn";
  private static final String n = "port";
  private static final String o = "proxy";
  private static final String p = "10.0.0.172";
  
  public static InetSocketAddress a(Context paramContext)
  {
    String str = Proxy.getDefaultHost();
    int i1 = Proxy.getDefaultPort();
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        if (localNetworkInfo.getType() == 0)
        {
          if (localNetworkInfo.getExtraInfo() != null)
          {
            str = localNetworkInfo.getExtraInfo().toLowerCase();
            if ((!str.startsWith(jdField_a_of_type_JavaLangString)) && (!str.startsWith("ctnet")) && (!str.startsWith("cmnet")) && (!str.startsWith("uninet")) && (!str.startsWith("3gnet"))) {}
          }
        }
        else {
          return null;
        }
        str = Proxy.getHost(paramContext);
        int i2 = Proxy.getPort(paramContext);
        if ((str != null) && (str.trim().length() != 0))
        {
          i1 = i2;
          if (i2 > 0) {}
        }
        else
        {
          str = Proxy.getDefaultHost();
          i2 = Proxy.getDefaultPort();
          if ((str != null) && (str.trim().length() != 0))
          {
            i1 = i2;
            if (i2 > 0) {}
          }
          else
          {
            return b(paramContext);
          }
        }
      }
    }
    if ((str != null) && (str.trim().length() > 0)) {}
    for (paramContext = InetSocketAddress.createUnresolved(str, i1);; paramContext = null) {
      return paramContext;
    }
  }
  
  /* Error */
  private static InetSocketAddress b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 66	com/tencent/mobileqq/activity/widget/qqmusic/utils/ApnProxyManager:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: invokevirtual 148	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull +17 -> 36
    //   22: aload_3
    //   23: ifnull +9 -> 32
    //   26: aload_3
    //   27: invokeinterface 153 1 0
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: areturn
    //   36: aload_3
    //   37: astore_0
    //   38: aload_3
    //   39: invokeinterface 157 1 0
    //   44: pop
    //   45: aload_3
    //   46: astore_0
    //   47: aload_3
    //   48: aload_3
    //   49: ldc 49
    //   51: invokeinterface 161 2 0
    //   56: invokeinterface 165 2 0
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull +11 -> 76
    //   68: aload_3
    //   69: astore_0
    //   70: aload 5
    //   72: invokevirtual 108	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   75: pop
    //   76: aload_3
    //   77: astore_0
    //   78: aload_3
    //   79: aload_3
    //   80: ldc 46
    //   82: invokeinterface 161 2 0
    //   87: invokeinterface 165 2 0
    //   92: astore 6
    //   94: aload 6
    //   96: ifnonnull +25 -> 121
    //   99: aload_3
    //   100: astore_0
    //   101: aload_3
    //   102: invokeinterface 153 1 0
    //   107: iconst_0
    //   108: ifeq +11 -> 119
    //   111: new 167	java/lang/NullPointerException
    //   114: dup
    //   115: invokespecial 168	java/lang/NullPointerException:<init>	()V
    //   118: athrow
    //   119: aconst_null
    //   120: areturn
    //   121: aload_3
    //   122: astore_0
    //   123: aload 6
    //   125: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore_1
    //   129: aload_3
    //   130: astore_0
    //   131: aload_3
    //   132: aload_3
    //   133: ldc 43
    //   135: invokeinterface 161 2 0
    //   140: invokeinterface 165 2 0
    //   145: astore 6
    //   147: aload 6
    //   149: ifnull +11 -> 160
    //   152: aload_3
    //   153: astore_0
    //   154: aload 6
    //   156: invokevirtual 108	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   159: pop
    //   160: aload_3
    //   161: astore_0
    //   162: aload_3
    //   163: invokeinterface 153 1 0
    //   168: aload 6
    //   170: ifnull +63 -> 233
    //   173: aload 6
    //   175: ldc 15
    //   177: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   180: ifeq +53 -> 233
    //   183: aload 5
    //   185: ifnull +272 -> 457
    //   188: aload 5
    //   190: invokevirtual 126	java/lang/String:length	()I
    //   193: ifeq +264 -> 457
    //   196: iload_1
    //   197: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokevirtual 180	java/lang/Integer:intValue	()I
    //   203: ifgt +248 -> 451
    //   206: goto +251 -> 457
    //   209: aload_0
    //   210: iload_1
    //   211: invokestatic 134	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   214: astore_0
    //   215: iconst_0
    //   216: ifeq -182 -> 34
    //   219: new 167	java/lang/NullPointerException
    //   222: dup
    //   223: invokespecial 168	java/lang/NullPointerException:<init>	()V
    //   226: athrow
    //   227: astore_0
    //   228: iconst_0
    //   229: istore_1
    //   230: goto -101 -> 129
    //   233: aload 6
    //   235: ifnull +39 -> 274
    //   238: aload 6
    //   240: ldc 21
    //   242: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   245: ifeq +29 -> 274
    //   248: aload 5
    //   250: ifnull +216 -> 466
    //   253: aload 5
    //   255: invokevirtual 126	java/lang/String:length	()I
    //   258: ifeq +208 -> 466
    //   261: iload_1
    //   262: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 180	java/lang/Integer:intValue	()I
    //   268: ifgt +183 -> 451
    //   271: goto +195 -> 466
    //   274: aload 6
    //   276: ifnull +39 -> 315
    //   279: aload 6
    //   281: ldc 27
    //   283: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   286: ifeq +29 -> 315
    //   289: aload 5
    //   291: ifnull +184 -> 475
    //   294: aload 5
    //   296: invokevirtual 126	java/lang/String:length	()I
    //   299: ifeq +176 -> 475
    //   302: iload_1
    //   303: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   306: invokevirtual 180	java/lang/Integer:intValue	()I
    //   309: ifgt +142 -> 451
    //   312: goto +163 -> 475
    //   315: aload 6
    //   317: ifnull +39 -> 356
    //   320: aload 6
    //   322: ldc 30
    //   324: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   327: ifeq +29 -> 356
    //   330: aload 5
    //   332: ifnull +152 -> 484
    //   335: aload 5
    //   337: invokevirtual 126	java/lang/String:length	()I
    //   340: ifeq +144 -> 484
    //   343: iload_1
    //   344: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: invokevirtual 180	java/lang/Integer:intValue	()I
    //   350: ifgt +101 -> 451
    //   353: goto +131 -> 484
    //   356: aload 5
    //   358: ifnull +20 -> 378
    //   361: aload 5
    //   363: invokevirtual 123	java/lang/String:trim	()Ljava/lang/String;
    //   366: invokevirtual 126	java/lang/String:length	()I
    //   369: istore_2
    //   370: iload_2
    //   371: ifle +7 -> 378
    //   374: iload_1
    //   375: ifgt +76 -> 451
    //   378: iconst_0
    //   379: ifeq +11 -> 390
    //   382: new 167	java/lang/NullPointerException
    //   385: dup
    //   386: invokespecial 168	java/lang/NullPointerException:<init>	()V
    //   389: athrow
    //   390: aconst_null
    //   391: areturn
    //   392: astore 4
    //   394: aconst_null
    //   395: astore_3
    //   396: aload_3
    //   397: astore_0
    //   398: ldc 182
    //   400: aload 4
    //   402: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   405: invokestatic 190	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload_3
    //   409: ifnull +9 -> 418
    //   412: aload_3
    //   413: invokeinterface 153 1 0
    //   418: aconst_null
    //   419: areturn
    //   420: astore_0
    //   421: aload 4
    //   423: astore_3
    //   424: aload_3
    //   425: ifnull +9 -> 434
    //   428: aload_3
    //   429: invokeinterface 153 1 0
    //   434: aload_0
    //   435: athrow
    //   436: astore 4
    //   438: aload_0
    //   439: astore_3
    //   440: aload 4
    //   442: astore_0
    //   443: goto -19 -> 424
    //   446: astore 4
    //   448: goto -52 -> 396
    //   451: aload 5
    //   453: astore_0
    //   454: goto -245 -> 209
    //   457: ldc 40
    //   459: astore_0
    //   460: bipush 80
    //   462: istore_1
    //   463: goto -254 -> 209
    //   466: ldc 36
    //   468: astore_0
    //   469: bipush 80
    //   471: istore_1
    //   472: goto -263 -> 209
    //   475: ldc 36
    //   477: astore_0
    //   478: bipush 80
    //   480: istore_1
    //   481: goto -272 -> 209
    //   484: ldc 36
    //   486: astore_0
    //   487: bipush 80
    //   489: istore_1
    //   490: goto -281 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramContext	Context
    //   128	362	1	i1	int
    //   369	2	2	i2	int
    //   17	423	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   392	30	4	localException1	java.lang.Exception
    //   436	5	4	localObject3	Object
    //   446	1	4	localException2	java.lang.Exception
    //   61	391	5	str1	String
    //   92	229	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   123	129	227	java/lang/NumberFormatException
    //   3	18	392	java/lang/Exception
    //   173	183	392	java/lang/Exception
    //   188	206	392	java/lang/Exception
    //   209	215	392	java/lang/Exception
    //   238	248	392	java/lang/Exception
    //   253	271	392	java/lang/Exception
    //   279	289	392	java/lang/Exception
    //   294	312	392	java/lang/Exception
    //   320	330	392	java/lang/Exception
    //   335	353	392	java/lang/Exception
    //   361	370	392	java/lang/Exception
    //   3	18	420	finally
    //   173	183	420	finally
    //   188	206	420	finally
    //   209	215	420	finally
    //   238	248	420	finally
    //   253	271	420	finally
    //   279	289	420	finally
    //   294	312	420	finally
    //   320	330	420	finally
    //   335	353	420	finally
    //   361	370	420	finally
    //   38	45	436	finally
    //   47	63	436	finally
    //   70	76	436	finally
    //   78	94	436	finally
    //   101	107	436	finally
    //   123	129	436	finally
    //   131	147	436	finally
    //   154	160	436	finally
    //   162	168	436	finally
    //   398	408	436	finally
    //   38	45	446	java/lang/Exception
    //   47	63	446	java/lang/Exception
    //   70	76	446	java/lang/Exception
    //   78	94	446	java/lang/Exception
    //   101	107	446	java/lang/Exception
    //   123	129	446	java/lang/Exception
    //   131	147	446	java/lang/Exception
    //   154	160	446	java/lang/Exception
    //   162	168	446	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnProxyManager
 * JD-Core Version:    0.7.0.1
 */