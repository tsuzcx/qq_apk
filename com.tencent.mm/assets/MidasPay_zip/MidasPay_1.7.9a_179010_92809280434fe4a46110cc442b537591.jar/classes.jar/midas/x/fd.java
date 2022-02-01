package midas.x;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class fd
{
  public static long a = 600000L;
  public static long b = 86400000L;
  public static long c = 15000L;
  public static volatile ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap();
  public static uc e;
  public static long f = 0L;
  
  public static Long a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    Long localLong = Long.valueOf(0L);
    if (bool) {
      return localLong;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = System.lineSeparator();
    } else {
      localObject = System.getProperty("line.separator");
    }
    Object localObject = paramString2.split((String)localObject);
    int i = localObject.length - 1;
    while (i >= 0)
    {
      paramString2 = localObject[i];
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("packets transmitted,")))
      {
        int j = Integer.valueOf(paramString2.split(",")[1].replace("received", "").trim()).intValue();
        int k = i + 1;
        if (k < localObject.length) {
          paramString2 = localObject[k];
        } else {
          paramString2 = null;
        }
        if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("rtt min/avg/max/mdev")))
        {
          paramString2 = paramString2.split(" ")[3];
          String[] arrayOfString = paramString2.split("/");
          if (arrayOfString.length > 1)
          {
            long l2 = Math.round(Double.valueOf(arrayOfString[1]).doubleValue());
            long l1 = l2;
            if (l2 < 1L) {
              l1 = 1L;
            }
            l1 = (l1 * j + (4 - j) * 15000) / 4L;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("ipSpeedMeasure time : [");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append("->");
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append("] [");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append("->");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append("ms]");
            ed.a("IPMeasure", ((StringBuilder)localObject).toString());
            return Long.valueOf(l1);
          }
        }
      }
      i -= 1;
    }
    return localLong;
  }
  
  public static void a(ExecutorService paramExecutorService, ad paramad, pd parampd)
  {
    long l1 = System.currentTimeMillis();
    if ((paramad.e.size() > 0) && (a(l1)))
    {
      b(l1);
      final long l2 = paramad.c.longValue();
      paramad.c = Long.valueOf(l1);
      b(paramExecutorService, paramad, new a(paramad, l2, parampd));
      return;
    }
    paramExecutorService = new StringBuilder();
    paramExecutorService.append("measure() frequency is too high! Ignored.  Or Size = ");
    paramExecutorService.append(paramad.e.size());
    ed.c("IPMeasure", paramExecutorService.toString());
  }
  
  public static void a(ad paramad)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel() ");
    String str;
    if (paramad == null) {
      str = "Null";
    } else {
      str = paramad.a;
    }
    localStringBuilder.append(str);
    ed.a("IPMeasure", localStringBuilder.toString());
    if (paramad != null)
    {
      if (paramad.a == null) {
        return;
      }
      if (d.containsKey(paramad.a)) {
        d.put(paramad.a, Boolean.valueOf(true));
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    long l = b();
    if (paramLong - l > a) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCanMeasure() time: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("-");
    localStringBuilder.append(l);
    localStringBuilder.append(">");
    localStringBuilder.append(a);
    ed.b("IPMeasure", localStringBuilder.toString());
    return false;
  }
  
  public static boolean a(String paramString)
  {
    paramString = (Boolean)d.get(paramString);
    return (paramString != null) && (paramString.booleanValue());
  }
  
  public static long b()
  {
    if (f <= 0L) {
      f = ld.a("lastMeasureTime", 0L);
    }
    return f;
  }
  
  /* Error */
  public static String b(java.io.InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: new 267	java/io/BufferedReader
    //   12: dup
    //   13: new 269	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 272	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 275	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore 4
    //   26: aload 4
    //   28: astore_2
    //   29: new 135	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   36: astore 8
    //   38: aload 4
    //   40: astore_2
    //   41: getstatic 61	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 19
    //   46: if_icmplt +13 -> 59
    //   49: aload 4
    //   51: astore_2
    //   52: invokestatic 67	java/lang/System:lineSeparator	()Ljava/lang/String;
    //   55: astore_3
    //   56: goto +12 -> 68
    //   59: aload 4
    //   61: astore_2
    //   62: ldc 69
    //   64: invokestatic 73	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore_3
    //   68: aload 4
    //   70: astore_2
    //   71: aload 4
    //   73: invokevirtual 278	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   76: astore 9
    //   78: aload 9
    //   80: ifnull +27 -> 107
    //   83: aload 4
    //   85: astore_2
    //   86: aload 8
    //   88: aload 9
    //   90: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: astore_2
    //   97: aload 8
    //   99: aload_3
    //   100: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: goto -36 -> 68
    //   107: aload 4
    //   109: astore_2
    //   110: aload 8
    //   112: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: aload 4
    //   118: invokevirtual 281	java/io/BufferedReader:close	()V
    //   121: aload_3
    //   122: astore_2
    //   123: aload_0
    //   124: ifnull +211 -> 335
    //   127: aload_0
    //   128: invokevirtual 284	java/io/InputStream:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: astore_0
    //   134: aload_3
    //   135: astore_2
    //   136: aload_0
    //   137: astore 4
    //   139: ldc_w 286
    //   142: aload_1
    //   143: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +39 -> 185
    //   149: new 135	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: ldc_w 291
    //   161: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_0
    //   167: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   170: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: ldc 156
    //   176: aload_1
    //   177: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_3
    //   184: areturn
    //   185: aload 4
    //   187: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   190: aload_2
    //   191: areturn
    //   192: astore_2
    //   193: aload 4
    //   195: astore_3
    //   196: aload_2
    //   197: astore 4
    //   199: goto +13 -> 212
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_3
    //   205: goto +139 -> 344
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_3
    //   213: astore_2
    //   214: ldc_w 286
    //   217: aload_1
    //   218: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifeq +53 -> 274
    //   224: aload_3
    //   225: astore_2
    //   226: new 135	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   233: astore 8
    //   235: aload_3
    //   236: astore_2
    //   237: aload 8
    //   239: ldc_w 297
    //   242: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: astore_2
    //   248: aload 8
    //   250: aload 4
    //   252: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   255: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_3
    //   260: astore_2
    //   261: ldc 156
    //   263: aload 8
    //   265: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 215	midas/x/ed:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: goto +10 -> 281
    //   274: aload_3
    //   275: astore_2
    //   276: aload 4
    //   278: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   281: aload_3
    //   282: ifnull +10 -> 292
    //   285: aload_3
    //   286: invokevirtual 281	java/io/BufferedReader:close	()V
    //   289: goto +3 -> 292
    //   292: aload 7
    //   294: astore_2
    //   295: aload_0
    //   296: ifnull +39 -> 335
    //   299: aload_0
    //   300: invokevirtual 284	java/io/InputStream:close	()V
    //   303: aconst_null
    //   304: areturn
    //   305: aload 6
    //   307: astore_2
    //   308: aload_0
    //   309: astore 4
    //   311: ldc_w 286
    //   314: aload_1
    //   315: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq -133 -> 185
    //   321: new 135	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   328: astore_1
    //   329: aload 5
    //   331: astore_3
    //   332: goto -175 -> 157
    //   335: aload_2
    //   336: areturn
    //   337: astore 4
    //   339: aload_2
    //   340: astore_3
    //   341: aload 4
    //   343: astore_2
    //   344: aload_3
    //   345: ifnull +10 -> 355
    //   348: aload_3
    //   349: invokevirtual 281	java/io/BufferedReader:close	()V
    //   352: goto +3 -> 355
    //   355: aload_0
    //   356: ifnull +61 -> 417
    //   359: aload_0
    //   360: invokevirtual 284	java/io/InputStream:close	()V
    //   363: goto +54 -> 417
    //   366: ldc_w 286
    //   369: aload_1
    //   370: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +40 -> 413
    //   376: new 135	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   383: astore_1
    //   384: aload_1
    //   385: ldc_w 291
    //   388: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: aload_0
    //   394: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   397: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: ldc 156
    //   403: aload_1
    //   404: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: goto +7 -> 417
    //   413: aload_0
    //   414: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   417: goto +5 -> 422
    //   420: aload_2
    //   421: athrow
    //   422: goto -2 -> 420
    //   425: astore_0
    //   426: goto -121 -> 305
    //   429: astore_0
    //   430: goto -64 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramInputStream	java.io.InputStream
    //   0	433	1	paramString	String
    //   28	163	2	localObject1	Object
    //   192	5	2	localException1	Exception
    //   202	1	2	localObject2	Object
    //   213	208	2	localObject3	Object
    //   55	294	3	localObject4	Object
    //   24	174	4	localObject5	Object
    //   208	69	4	localException2	Exception
    //   309	1	4	localInputStream	java.io.InputStream
    //   337	5	4	localObject6	Object
    //   7	323	5	localObject7	Object
    //   1	305	6	localObject8	Object
    //   4	289	7	localObject9	Object
    //   36	228	8	localStringBuilder	StringBuilder
    //   76	13	9	str	String
    // Exception table:
    //   from	to	target	type
    //   116	121	133	java/lang/Exception
    //   127	131	133	java/lang/Exception
    //   29	38	192	java/lang/Exception
    //   41	49	192	java/lang/Exception
    //   52	56	192	java/lang/Exception
    //   62	68	192	java/lang/Exception
    //   71	78	192	java/lang/Exception
    //   86	94	192	java/lang/Exception
    //   97	104	192	java/lang/Exception
    //   110	116	192	java/lang/Exception
    //   9	26	202	finally
    //   9	26	208	java/lang/Exception
    //   29	38	337	finally
    //   41	49	337	finally
    //   52	56	337	finally
    //   62	68	337	finally
    //   71	78	337	finally
    //   86	94	337	finally
    //   97	104	337	finally
    //   110	116	337	finally
    //   214	224	337	finally
    //   226	235	337	finally
    //   237	246	337	finally
    //   248	259	337	finally
    //   261	271	337	finally
    //   276	281	337	finally
    //   285	289	425	java/lang/Exception
    //   299	303	425	java/lang/Exception
    //   348	352	429	java/lang/Exception
    //   359	363	429	java/lang/Exception
  }
  
  public static String b(String paramString)
  {
    if (ud.b(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]/http_monitor.html");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/http_monitor.html");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static ArrayList<Pair<String, Long>> b(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 11
    //   3: ldc 90
    //   5: astore 10
    //   7: new 311	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 312	java/util/ArrayList:<init>	()V
    //   14: astore 19
    //   16: aload_2
    //   17: invokevirtual 313	java/util/ArrayList:size	()I
    //   20: ifle +30 -> 50
    //   23: aload 11
    //   25: iconst_0
    //   26: new 75	java/lang/String
    //   29: dup
    //   30: aload 11
    //   32: aload_2
    //   33: invokevirtual 313	java/util/ArrayList:size	()I
    //   36: iconst_1
    //   37: isub
    //   38: invokevirtual 316	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 75	java/lang/String
    //   44: invokespecial 319	java/lang/String:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 323	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   50: aload_0
    //   51: invokestatic 325	midas/x/fd:a	(Ljava/lang/String;)Z
    //   54: ifeq +14 -> 68
    //   57: ldc 156
    //   59: ldc_w 327
    //   62: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 19
    //   67: areturn
    //   68: aload_2
    //   69: invokevirtual 328	java/util/ArrayList:toString	()Ljava/lang/String;
    //   72: ldc_w 330
    //   75: invokestatic 336	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 9
    //   80: goto +48 -> 128
    //   83: astore 9
    //   85: new 135	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   92: astore 12
    //   94: aload 12
    //   96: ldc_w 338
    //   99: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 12
    //   105: aload 9
    //   107: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   110: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 156
    //   116: aload 12
    //   118: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: ldc 90
    //   126: astore 9
    //   128: new 135	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   135: astore 12
    //   137: aload 12
    //   139: ldc_w 340
    //   142: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 12
    //   148: aload_1
    //   149: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 12
    //   155: ldc_w 342
    //   158: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 12
    //   164: aload_2
    //   165: invokevirtual 313	java/util/ArrayList:size	()I
    //   168: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 12
    //   174: ldc_w 344
    //   177: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 12
    //   183: aload 9
    //   185: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc_w 346
    //   192: aload 12
    //   194: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 349	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: new 311	java/util/ArrayList
    //   203: dup
    //   204: invokespecial 312	java/util/ArrayList:<init>	()V
    //   207: astore 20
    //   209: new 135	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   216: astore 9
    //   218: aload 9
    //   220: ldc_w 351
    //   223: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 9
    //   229: aload 11
    //   231: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 156
    //   237: aload 9
    //   239: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: iconst_0
    //   246: istore_3
    //   247: aconst_null
    //   248: astore 11
    //   250: iload_3
    //   251: aload_2
    //   252: invokevirtual 313	java/util/ArrayList:size	()I
    //   255: if_icmpge +972 -> 1227
    //   258: aload_0
    //   259: invokestatic 325	midas/x/fd:a	(Ljava/lang/String;)Z
    //   262: ifeq +24 -> 286
    //   265: ldc 156
    //   267: ldc_w 327
    //   270: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload 11
    //   275: ifnull +8 -> 283
    //   278: aload 11
    //   280: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   283: aload 19
    //   285: areturn
    //   286: aload_2
    //   287: iload_3
    //   288: invokevirtual 316	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   291: checkcast 75	java/lang/String
    //   294: astore 21
    //   296: getstatic 176	midas/x/fd:e	Lmidas/x/uc;
    //   299: ifnull +18 -> 317
    //   302: getstatic 176	midas/x/fd:e	Lmidas/x/uc;
    //   305: aload 21
    //   307: invokeinterface 363 2 0
    //   312: astore 9
    //   314: goto +10 -> 324
    //   317: aload 21
    //   319: invokestatic 365	midas/x/fd:b	(Ljava/lang/String;)Ljava/lang/String;
    //   322: astore 9
    //   324: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   327: lstore 5
    //   329: new 367	java/net/URL
    //   332: dup
    //   333: aload 9
    //   335: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   338: invokevirtual 372	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   341: checkcast 356	java/net/HttpURLConnection
    //   344: astore 9
    //   346: aload 9
    //   348: sipush 9000
    //   351: invokevirtual 376	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   354: aload 9
    //   356: sipush 9000
    //   359: invokevirtual 379	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   362: aload 9
    //   364: iconst_0
    //   365: invokevirtual 383	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   368: aload 9
    //   370: iconst_0
    //   371: invokevirtual 386	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   374: aload 9
    //   376: iconst_1
    //   377: invokevirtual 389	java/net/HttpURLConnection:setDoInput	(Z)V
    //   380: aload 9
    //   382: invokevirtual 393	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   385: astore 12
    //   387: aload 9
    //   389: invokevirtual 396	java/net/HttpURLConnection:getResponseCode	()I
    //   392: sipush 200
    //   395: if_icmpne +465 -> 860
    //   398: sipush 1024
    //   401: newarray byte
    //   403: astore 13
    //   405: new 398	java/io/ByteArrayOutputStream
    //   408: dup
    //   409: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   412: astore 14
    //   414: aload 10
    //   416: astore 11
    //   418: aload 9
    //   420: astore 15
    //   422: aload 14
    //   424: astore 16
    //   426: aload 12
    //   428: astore 17
    //   430: aload 12
    //   432: aload 13
    //   434: invokevirtual 403	java/io/InputStream:read	([B)I
    //   437: istore 4
    //   439: iload 4
    //   441: ifle +28 -> 469
    //   444: aload 9
    //   446: astore 15
    //   448: aload 14
    //   450: astore 16
    //   452: aload 12
    //   454: astore 17
    //   456: aload 14
    //   458: aload 13
    //   460: iconst_0
    //   461: iload 4
    //   463: invokevirtual 407	java/io/ByteArrayOutputStream:write	([BII)V
    //   466: goto -48 -> 418
    //   469: aload 11
    //   471: astore 13
    //   473: aload 9
    //   475: astore 15
    //   477: aload 14
    //   479: astore 16
    //   481: aload 12
    //   483: astore 17
    //   485: aload 14
    //   487: invokevirtual 410	java/io/ByteArrayOutputStream:flush	()V
    //   490: aload 9
    //   492: astore 15
    //   494: aload 14
    //   496: astore 16
    //   498: aload 12
    //   500: astore 17
    //   502: new 412	org/json/JSONObject
    //   505: dup
    //   506: new 75	java/lang/String
    //   509: dup
    //   510: aload 14
    //   512: invokevirtual 416	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   515: invokespecial 419	java/lang/String:<init>	([B)V
    //   518: invokespecial 420	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   521: astore 10
    //   523: aload 9
    //   525: astore 15
    //   527: aload 14
    //   529: astore 16
    //   531: aload 12
    //   533: astore 17
    //   535: new 135	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   542: astore 18
    //   544: aload 9
    //   546: astore 15
    //   548: aload 14
    //   550: astore 16
    //   552: aload 12
    //   554: astore 17
    //   556: aload 18
    //   558: ldc_w 422
    //   561: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 9
    //   567: astore 15
    //   569: aload 14
    //   571: astore 16
    //   573: aload 12
    //   575: astore 17
    //   577: aload 18
    //   579: aload 21
    //   581: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 9
    //   587: astore 15
    //   589: aload 14
    //   591: astore 16
    //   593: aload 12
    //   595: astore 17
    //   597: aload 18
    //   599: ldc_w 424
    //   602: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 9
    //   608: astore 15
    //   610: aload 14
    //   612: astore 16
    //   614: aload 12
    //   616: astore 17
    //   618: aload 18
    //   620: aload 10
    //   622: invokevirtual 425	org/json/JSONObject:toString	()Ljava/lang/String;
    //   625: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 9
    //   631: astore 15
    //   633: aload 14
    //   635: astore 16
    //   637: aload 12
    //   639: astore 17
    //   641: ldc 156
    //   643: aload 18
    //   645: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload 9
    //   653: astore 15
    //   655: aload 14
    //   657: astore 16
    //   659: aload 12
    //   661: astore 17
    //   663: aload 10
    //   665: ldc_w 427
    //   668: invokevirtual 430	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   671: astore 22
    //   673: aload 14
    //   675: astore 18
    //   677: aload 13
    //   679: astore 10
    //   681: aload 9
    //   683: astore 15
    //   685: aload 14
    //   687: astore 16
    //   689: aload 12
    //   691: astore 17
    //   693: aload 22
    //   695: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: ifne +165 -> 863
    //   701: aload 14
    //   703: astore 18
    //   705: aload 13
    //   707: astore 10
    //   709: aload 9
    //   711: astore 15
    //   713: aload 14
    //   715: astore 16
    //   717: aload 12
    //   719: astore 17
    //   721: aload 22
    //   723: invokestatic 434	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   726: ifne +137 -> 863
    //   729: aload 9
    //   731: astore 15
    //   733: aload 14
    //   735: astore 16
    //   737: aload 12
    //   739: astore 17
    //   741: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   744: lstore 7
    //   746: iload_3
    //   747: ifle +38 -> 785
    //   750: aload 9
    //   752: astore 15
    //   754: aload 14
    //   756: astore 16
    //   758: aload 12
    //   760: astore 17
    //   762: aload 19
    //   764: new 436	android/util/Pair
    //   767: dup
    //   768: aload 21
    //   770: lload 7
    //   772: lload 5
    //   774: lsub
    //   775: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   778: invokespecial 439	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   781: invokevirtual 441	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   784: pop
    //   785: aload 9
    //   787: astore 11
    //   789: aload 14
    //   791: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   794: goto +3 -> 797
    //   797: aload 9
    //   799: astore 14
    //   801: aload 13
    //   803: astore 11
    //   805: aload 12
    //   807: ifnull +89 -> 896
    //   810: aload 13
    //   812: astore 10
    //   814: aload 9
    //   816: astore 11
    //   818: aload 12
    //   820: invokevirtual 284	java/io/InputStream:close	()V
    //   823: aload 9
    //   825: astore 14
    //   827: aload 10
    //   829: astore 11
    //   831: goto +65 -> 896
    //   834: astore 10
    //   836: goto +5 -> 841
    //   839: astore 10
    //   841: aload 11
    //   843: astore 15
    //   845: aload 10
    //   847: astore 11
    //   849: aload 14
    //   851: astore 13
    //   853: aload 15
    //   855: astore 10
    //   857: goto +96 -> 953
    //   860: aconst_null
    //   861: astore 18
    //   863: aload 18
    //   865: ifnull +15 -> 880
    //   868: aload 9
    //   870: astore 11
    //   872: aload 18
    //   874: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   877: goto +3 -> 880
    //   880: aload 9
    //   882: astore 14
    //   884: aload 10
    //   886: astore 11
    //   888: aload 12
    //   890: ifnull +6 -> 896
    //   893: goto -79 -> 814
    //   896: goto +266 -> 1162
    //   899: astore_0
    //   900: aconst_null
    //   901: astore 16
    //   903: goto +283 -> 1186
    //   906: astore 11
    //   908: aconst_null
    //   909: astore 13
    //   911: goto +42 -> 953
    //   914: astore_0
    //   915: goto +13 -> 928
    //   918: astore 11
    //   920: goto +27 -> 947
    //   923: astore_0
    //   924: aload 11
    //   926: astore 9
    //   928: aconst_null
    //   929: astore 16
    //   931: aconst_null
    //   932: astore 12
    //   934: goto +252 -> 1186
    //   937: astore 12
    //   939: aload 11
    //   941: astore 9
    //   943: aload 12
    //   945: astore 11
    //   947: aconst_null
    //   948: astore 13
    //   950: aconst_null
    //   951: astore 12
    //   953: aload 9
    //   955: astore 15
    //   957: aload 13
    //   959: astore 16
    //   961: aload 12
    //   963: astore 17
    //   965: new 135	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   972: astore 14
    //   974: aload 9
    //   976: astore 15
    //   978: aload 13
    //   980: astore 16
    //   982: aload 12
    //   984: astore 17
    //   986: aload 14
    //   988: ldc_w 444
    //   991: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 9
    //   997: astore 15
    //   999: aload 13
    //   1001: astore 16
    //   1003: aload 12
    //   1005: astore 17
    //   1007: aload 14
    //   1009: aload 21
    //   1011: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 9
    //   1017: astore 15
    //   1019: aload 13
    //   1021: astore 16
    //   1023: aload 12
    //   1025: astore 17
    //   1027: aload 14
    //   1029: ldc_w 446
    //   1032: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 9
    //   1038: astore 15
    //   1040: aload 13
    //   1042: astore 16
    //   1044: aload 12
    //   1046: astore 17
    //   1048: aload 14
    //   1050: aload 11
    //   1052: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1055: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 9
    //   1061: astore 15
    //   1063: aload 13
    //   1065: astore 16
    //   1067: aload 12
    //   1069: astore 17
    //   1071: ldc 156
    //   1073: aload 14
    //   1075: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: invokestatic 215	midas/x/ed:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1081: aload 9
    //   1083: astore 15
    //   1085: aload 13
    //   1087: astore 16
    //   1089: aload 12
    //   1091: astore 17
    //   1093: aload 20
    //   1095: aload 11
    //   1097: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1100: invokevirtual 448	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1103: ifne +26 -> 1129
    //   1106: aload 9
    //   1108: astore 15
    //   1110: aload 13
    //   1112: astore 16
    //   1114: aload 12
    //   1116: astore 17
    //   1118: aload 20
    //   1120: aload 11
    //   1122: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1125: invokevirtual 441	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1128: pop
    //   1129: aload 13
    //   1131: ifnull +15 -> 1146
    //   1134: aload 9
    //   1136: astore 11
    //   1138: aload 13
    //   1140: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1143: goto +3 -> 1146
    //   1146: aload 9
    //   1148: astore 14
    //   1150: aload 10
    //   1152: astore 11
    //   1154: aload 12
    //   1156: ifnull -260 -> 896
    //   1159: goto -345 -> 814
    //   1162: iload_3
    //   1163: iconst_1
    //   1164: iadd
    //   1165: istore_3
    //   1166: aload 11
    //   1168: astore 10
    //   1170: aload 14
    //   1172: astore 11
    //   1174: goto -924 -> 250
    //   1177: astore_0
    //   1178: aload 17
    //   1180: astore 12
    //   1182: aload 15
    //   1184: astore 9
    //   1186: aload 16
    //   1188: ifnull +19 -> 1207
    //   1191: aload 9
    //   1193: astore 11
    //   1195: aload 16
    //   1197: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1200: goto +7 -> 1207
    //   1203: astore_0
    //   1204: goto +185 -> 1389
    //   1207: aload 12
    //   1209: ifnull +12 -> 1221
    //   1212: aload 9
    //   1214: astore 11
    //   1216: aload 12
    //   1218: invokevirtual 284	java/io/InputStream:close	()V
    //   1221: aload 9
    //   1223: astore 11
    //   1225: aload_0
    //   1226: athrow
    //   1227: aload 11
    //   1229: ifnull +8 -> 1237
    //   1232: aload 11
    //   1234: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1237: aload 20
    //   1239: invokevirtual 328	java/util/ArrayList:toString	()Ljava/lang/String;
    //   1242: ldc_w 330
    //   1245: invokestatic 336	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1248: astore_0
    //   1249: goto +45 -> 1294
    //   1252: astore_0
    //   1253: new 135	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1260: astore 9
    //   1262: aload 9
    //   1264: ldc_w 450
    //   1267: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 9
    //   1273: aload_0
    //   1274: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1277: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: ldc 156
    //   1283: aload 9
    //   1285: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: invokestatic 164	midas/x/ed:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1291: aload 10
    //   1293: astore_0
    //   1294: new 135	java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1301: astore 9
    //   1303: aload 9
    //   1305: ldc_w 452
    //   1308: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: aload 9
    //   1314: aload_1
    //   1315: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 9
    //   1321: ldc_w 342
    //   1324: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: pop
    //   1328: aload 9
    //   1330: aload_2
    //   1331: invokevirtual 313	java/util/ArrayList:size	()I
    //   1334: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: aload 9
    //   1340: ldc_w 454
    //   1343: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: pop
    //   1347: aload 9
    //   1349: aload 19
    //   1351: invokevirtual 313	java/util/ArrayList:size	()I
    //   1354: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload 9
    //   1360: ldc_w 456
    //   1363: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: aload 9
    //   1369: aload_0
    //   1370: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: ldc_w 346
    //   1377: aload 9
    //   1379: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokestatic 349	midas/x/gd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1385: aload 19
    //   1387: areturn
    //   1388: astore_0
    //   1389: aload 11
    //   1391: ifnull +8 -> 1399
    //   1394: aload 11
    //   1396: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1399: goto +5 -> 1404
    //   1402: aload_0
    //   1403: athrow
    //   1404: goto -2 -> 1402
    //   1407: astore_0
    //   1408: aload 19
    //   1410: areturn
    //   1411: astore 10
    //   1413: goto -616 -> 797
    //   1416: astore 11
    //   1418: aload 9
    //   1420: astore 14
    //   1422: aload 10
    //   1424: astore 11
    //   1426: goto -530 -> 896
    //   1429: astore 11
    //   1431: goto -551 -> 880
    //   1434: astore 11
    //   1436: goto -290 -> 1146
    //   1439: astore_1
    //   1440: goto -233 -> 1207
    //   1443: astore_1
    //   1444: goto -223 -> 1221
    //   1447: astore_0
    //   1448: goto -211 -> 1237
    //   1451: astore_1
    //   1452: goto -53 -> 1399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1455	0	paramString1	String
    //   0	1455	1	paramString2	String
    //   0	1455	2	paramArrayList	ArrayList<String>
    //   246	920	3	i	int
    //   437	25	4	j	int
    //   327	446	5	l1	long
    //   744	27	7	l2	long
    //   78	1	9	str1	String
    //   83	23	9	localException1	Exception
    //   126	1293	9	localObject1	Object
    //   5	823	10	localObject2	Object
    //   834	1	10	localException2	Exception
    //   839	7	10	localException3	Exception
    //   855	437	10	localObject3	Object
    //   1411	12	10	localException4	Exception
    //   1	886	11	localObject4	Object
    //   906	1	11	localException5	Exception
    //   918	22	11	localException6	Exception
    //   945	450	11	localObject5	Object
    //   1416	1	11	localException7	Exception
    //   1424	1	11	localObject6	Object
    //   1429	1	11	localException8	Exception
    //   1434	1	11	localException9	Exception
    //   92	841	12	localObject7	Object
    //   937	7	12	localException10	Exception
    //   951	266	12	localObject8	Object
    //   403	736	13	localObject9	Object
    //   412	1009	14	localObject10	Object
    //   420	763	15	localObject11	Object
    //   424	772	16	localObject12	Object
    //   428	751	17	localObject13	Object
    //   542	331	18	localObject14	Object
    //   14	1395	19	localArrayList1	ArrayList
    //   207	1031	20	localArrayList2	ArrayList
    //   294	716	21	str2	String
    //   671	51	22	str3	String
    // Exception table:
    //   from	to	target	type
    //   68	80	83	java/lang/Exception
    //   456	466	834	java/lang/Exception
    //   485	490	834	java/lang/Exception
    //   502	523	834	java/lang/Exception
    //   535	544	834	java/lang/Exception
    //   556	565	834	java/lang/Exception
    //   577	585	834	java/lang/Exception
    //   597	606	834	java/lang/Exception
    //   618	629	834	java/lang/Exception
    //   641	651	834	java/lang/Exception
    //   663	673	834	java/lang/Exception
    //   693	701	834	java/lang/Exception
    //   721	729	834	java/lang/Exception
    //   741	746	834	java/lang/Exception
    //   762	785	834	java/lang/Exception
    //   430	439	839	java/lang/Exception
    //   387	414	899	finally
    //   387	414	906	java/lang/Exception
    //   346	387	914	finally
    //   346	387	918	java/lang/Exception
    //   329	346	923	finally
    //   329	346	937	java/lang/Exception
    //   430	439	1177	finally
    //   456	466	1177	finally
    //   485	490	1177	finally
    //   502	523	1177	finally
    //   535	544	1177	finally
    //   556	565	1177	finally
    //   577	585	1177	finally
    //   597	606	1177	finally
    //   618	629	1177	finally
    //   641	651	1177	finally
    //   663	673	1177	finally
    //   693	701	1177	finally
    //   721	729	1177	finally
    //   741	746	1177	finally
    //   762	785	1177	finally
    //   965	974	1177	finally
    //   986	995	1177	finally
    //   1007	1015	1177	finally
    //   1027	1036	1177	finally
    //   1048	1059	1177	finally
    //   1071	1081	1177	finally
    //   1093	1106	1177	finally
    //   1118	1129	1177	finally
    //   789	794	1203	finally
    //   818	823	1203	finally
    //   872	877	1203	finally
    //   1138	1143	1203	finally
    //   1195	1200	1203	finally
    //   1216	1221	1203	finally
    //   1225	1227	1203	finally
    //   1237	1249	1252	java/lang/Exception
    //   250	273	1388	finally
    //   286	314	1388	finally
    //   317	324	1388	finally
    //   324	329	1388	finally
    //   278	283	1407	java/lang/Exception
    //   789	794	1411	java/lang/Exception
    //   818	823	1416	java/lang/Exception
    //   872	877	1429	java/lang/Exception
    //   1138	1143	1434	java/lang/Exception
    //   1195	1200	1439	java/lang/Exception
    //   1216	1221	1443	java/lang/Exception
    //   1232	1237	1447	java/lang/Exception
    //   1394	1399	1451	java/lang/Exception
  }
  
  public static ArrayList<Pair<String, Long>> b(ExecutorService paramExecutorService, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString1))
    {
      ed.a("IPMeasure", "ping Thread isInterrupted");
      return localArrayList;
    }
    Object localObject2;
    try
    {
      localObject2 = URLEncoder.encode(paramArrayList.toString(), "UTF-8");
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pingInBackground() report begin e=");
      ((StringBuilder)localObject2).append(localException1.toString());
      ed.a("IPMeasure", ((StringBuilder)localObject2).toString());
      localObject2 = "";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("state=begin&ipv=");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("&ipsize=");
    ((StringBuilder)localObject1).append(paramArrayList.size());
    ((StringBuilder)localObject1).append("&ips=");
    ((StringBuilder)localObject1).append((String)localObject2);
    gd.a("measure.ping", ((StringBuilder)localObject1).toString());
    long l = c / 1000L;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (a(paramString1))
      {
        paramExecutorService = new StringBuilder();
        paramExecutorService.append("ping Thread isInterrupted ip = ");
        paramExecutorService.append(str3);
        ed.a("IPMeasure", paramExecutorService.toString());
        return localArrayList;
      }
      final String str1;
      if (ud.b(str3)) {
        str1 = "ping6";
      } else {
        str1 = "ping";
      }
      Process localProcess = null;
      localObject1 = localProcess;
      try
      {
        localObject3 = new StringBuilder();
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append("/system/bin/");
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(str1);
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(" -c ");
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(String.valueOf(4));
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(" -W ");
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(l);
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(" ");
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(str3);
        localObject1 = localProcess;
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = localProcess;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localProcess;
        localStringBuilder.append("command : ");
        localObject1 = localProcess;
        localStringBuilder.append((String)localObject3);
        localObject1 = localProcess;
        ed.a("IPMeasure", localStringBuilder.toString());
        localObject1 = localProcess;
        localProcess = Runtime.getRuntime().exec((String)localObject3);
        localObject1 = localProcess;
        localProcess.waitFor();
        localObject1 = localProcess;
        int i = localProcess.exitValue();
        localObject1 = localProcess;
        localObject3 = new StringBuilder();
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(str1);
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(" exitValue = ");
        localObject1 = localProcess;
        ((StringBuilder)localObject3).append(i);
        localObject1 = localProcess;
        ed.a("IPMeasure", ((StringBuilder)localObject3).toString());
        localObject1 = localProcess;
        if (i != 0)
        {
          localObject1 = localProcess;
          localObject3 = new StringBuilder();
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append("state=exit&ipv=");
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append(paramString2);
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append("&code=");
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append(i);
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append("&ipsize=");
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append(paramArrayList.size());
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append("&ips=");
          localObject1 = localProcess;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = localProcess;
          gd.a("measure.ping", ((StringBuilder)localObject3).toString());
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        if (localObject1 == null)
        {
          paramExecutorService = new StringBuilder();
          paramExecutorService.append(str1);
          paramExecutorService.append("process is Null");
          ed.a("IPMeasure", paramExecutorService.toString());
          return localArrayList;
        }
        try
        {
          d locald = new d((Process)localObject1, str1);
          try
          {
            paramExecutorService.submit(locald);
          }
          catch (Exception localException3) {}
          localException4.printStackTrace();
        }
        catch (Exception localException4) {}
        String str2 = b(((Process)localObject1).getInputStream(), "input");
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str1);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(str2);
        ed.a("IPMeasure", ((StringBuilder)localObject3).toString());
        localArrayList.add(new Pair(str3, a(str3, str2)));
      }
      if (localObject1 != null) {
        ((Process)localObject1).destroy();
      }
    }
    paramExecutorService = new StringBuilder();
    paramExecutorService.append("ping result = ");
    paramExecutorService.append(localArrayList);
    ed.a("IPMeasure", paramExecutorService.toString());
    return localArrayList;
  }
  
  public static void b(long paramLong)
  {
    f = paramLong;
    ld.b("lastMeasureTime", f);
  }
  
  public static void b(ExecutorService paramExecutorService, String paramString1, ArrayList<String> paramArrayList, final String paramString2, pd parampd)
  {
    long l1 = paramArrayList.size();
    long l2 = c;
    rd.a(paramExecutorService, paramExecutorService, new e(paramString1, paramString2), new Object[] { paramArrayList }, parampd, l1 * l2 + 5000L);
  }
  
  public static void b(final ExecutorService paramExecutorService, final ad paramad, pd parampd)
  {
    int i = ud.a(pc.g, true);
    boolean bool1 = ud.a(i);
    boolean bool2 = ud.b(i);
    final String str = "";
    if (bool1) {
      localObject1 = "4";
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject1 = str;
    if (bool2) {
      localObject1 = "6";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    str = ((StringBuilder)localObject2).toString();
    localObject1 = new ArrayList();
    localObject2 = paramad.e.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      zc localzc = (zc)((Iterator)localObject2).next();
      if ((bool1) && (bool2)) {
        ((ArrayList)localObject1).add(localzc.a);
      } else if ((bool1) && (!bool2))
      {
        if (ud.a(localzc.a)) {
          ((ArrayList)localObject1).add(localzc.a);
        }
      }
      else if ((!bool1) && (bool2) && (ud.b(localzc.a))) {
        ((ArrayList)localObject1).add(localzc.a);
      }
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      paramExecutorService = new StringBuilder();
      paramExecutorService.append("measureCore() return ipList=");
      paramExecutorService.append(localObject1);
      ed.a("IPMeasure", paramExecutorService.toString());
      parampd.a(0, null);
      return;
    }
    d.put(paramad.a, Boolean.valueOf(false));
    c(paramExecutorService, paramad.a, (ArrayList)localObject1, str, new b(parampd, paramExecutorService, paramad, (ArrayList)localObject1, str));
  }
  
  public static boolean b(ad paramad)
  {
    if (paramad == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramad.c.longValue();
    paramad = new StringBuilder();
    paramad.append("isOverdue() time: ");
    paramad.append(l1);
    paramad.append("-");
    paramad.append(l2);
    paramad.append("=");
    l1 -= l2;
    paramad.append(l1);
    paramad.append(">");
    paramad.append(b);
    paramad.append(" : ");
    boolean bool;
    if (l1 > b) {
      bool = true;
    } else {
      bool = false;
    }
    paramad.append(bool);
    ed.a("IPMeasure", paramad.toString());
    return l1 > b;
  }
  
  public static void c(ExecutorService paramExecutorService, final String paramString1, ArrayList<String> paramArrayList, final String paramString2, pd parampd)
  {
    if (a(paramString1)) {
      return;
    }
    long l1 = paramArrayList.size();
    long l2 = c;
    rd.a(paramExecutorService, paramExecutorService, new c(paramExecutorService, paramString1, paramString2), new Object[] { paramArrayList }, parampd, l1 * l2 + 5000L);
  }
  
  public static final class a
    implements pd
  {
    public a(ad paramad, long paramLong, pd parampd) {}
    
    public void a(int paramInt, Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        ArrayList localArrayList = (ArrayList)paramObject;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = 1;
          break label37;
        }
      }
      int i = 0;
      label37:
      if (i == 0) {
        this.a.c = Long.valueOf(l2);
      }
      this.c.a(paramInt, paramObject);
    }
  }
  
  public static final class b
    implements pd
  {
    public b(pd parampd, ExecutorService paramExecutorService, ad paramad, ArrayList paramArrayList, String paramString) {}
    
    public void a(int paramInt, Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        ArrayList localArrayList = (ArrayList)paramObject;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          i = 1;
          break label37;
        }
      }
      int i = 0;
      label37:
      if (i != 0)
      {
        this.a.a(paramInt, paramObject);
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("ping fail, try sMeasure.measure() = ");
      paramObject.append(fd.a());
      ed.a("IPMeasure", paramObject.toString());
      fd.a(paramExecutorService, paramad.a, this.d, str, this.a);
    }
  }
  
  public static final class c
    implements od
  {
    public c(ExecutorService paramExecutorService, String paramString1, String paramString2) {}
    
    public Object a(Object[] paramArrayOfObject)
    {
      return fd.a(this.a, paramString1, paramString2, (ArrayList)paramArrayOfObject[0]);
    }
  }
  
  public static final class d
    implements Runnable
  {
    public d(Process paramProcess, String paramString) {}
    
    public void run()
    {
      String str = fd.a(this.a.getErrorStream(), "error");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" errorStream: ");
      localStringBuilder.append(str);
      ed.a("IPMeasure", localStringBuilder.toString());
    }
  }
  
  public static final class e
    implements od
  {
    public e(String paramString1, String paramString2) {}
    
    public Object a(Object[] paramArrayOfObject)
    {
      return fd.a(this.a, paramString2, (ArrayList)paramArrayOfObject[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.fd
 * JD-Core Version:    0.7.0.1
 */