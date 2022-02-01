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

public class mo
{
  public static long a = 600000L;
  public static long b = 86400000L;
  public static long c = 15000L;
  private static volatile ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap();
  private static mh.e e;
  private static long f = 0L;
  
  private static Long a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return Long.valueOf(0L);
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
            mn.b("IPMeasure", ((StringBuilder)localObject).toString());
            return Long.valueOf(l1);
          }
        }
      }
      i -= 1;
    }
    return Long.valueOf(0L);
  }
  
  public static void a(ExecutorService paramExecutorService, mj parammj, my parammy)
  {
    long l1 = System.currentTimeMillis();
    if ((parammj.e.size() > 0) && (a(l1)))
    {
      b(l1);
      final long l2 = parammj.c.longValue();
      parammj.c = Long.valueOf(l1);
      b(paramExecutorService, parammj, new my()
      {
        public void a(int paramAnonymousInt, Object paramAnonymousObject)
        {
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
          {
            ArrayList localArrayList = (ArrayList)paramAnonymousObject;
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
          this.c.a(paramAnonymousInt, paramAnonymousObject);
        }
      });
      return;
    }
    paramExecutorService = new StringBuilder();
    paramExecutorService.append("measure() frequency is too high! Ignored.  Or Size = ");
    paramExecutorService.append(parammj.e.size());
    mn.c("IPMeasure", paramExecutorService.toString());
  }
  
  public static void a(mj parammj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel() ");
    String str;
    if (parammj == null) {
      str = "Null";
    } else {
      str = parammj.a;
    }
    localStringBuilder.append(str);
    mn.b("IPMeasure", localStringBuilder.toString());
    if (parammj != null)
    {
      if (parammj.a == null) {
        return;
      }
      if (d.containsKey(parammj.a)) {
        d.put(parammj.a, Boolean.valueOf(true));
      }
      return;
    }
  }
  
  private static boolean a(long paramLong)
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
    mn.a("IPMeasure", localStringBuilder.toString());
    return false;
  }
  
  private static boolean a(String paramString)
  {
    paramString = (Boolean)d.get(paramString);
    return (paramString != null) && (paramString.booleanValue());
  }
  
  private static long b()
  {
    if (f <= 0L) {
      f = mu.b("lastMeasureTime", 0L);
    }
    return f;
  }
  
  /* Error */
  private static String b(java.io.InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: new 267	java/io/BufferedReader
    //   3: dup
    //   4: new 269	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 272	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 275	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: new 135	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   25: astore 5
    //   27: aload_3
    //   28: astore_2
    //   29: getstatic 61	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 19
    //   34: if_icmplt +13 -> 47
    //   37: aload_3
    //   38: astore_2
    //   39: invokestatic 67	java/lang/System:lineSeparator	()Ljava/lang/String;
    //   42: astore 4
    //   44: goto +12 -> 56
    //   47: aload_3
    //   48: astore_2
    //   49: ldc 69
    //   51: invokestatic 73	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 278	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnull +26 -> 92
    //   69: aload_3
    //   70: astore_2
    //   71: aload 5
    //   73: aload 6
    //   75: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: astore_2
    //   81: aload 5
    //   83: aload 4
    //   85: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: goto -33 -> 56
    //   92: aload_3
    //   93: astore_2
    //   94: aload 5
    //   96: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload_3
    //   102: invokevirtual 281	java/io/BufferedReader:close	()V
    //   105: aload_0
    //   106: ifnull +62 -> 168
    //   109: aload_0
    //   110: invokevirtual 284	java/io/InputStream:close	()V
    //   113: goto +55 -> 168
    //   116: astore_0
    //   117: ldc_w 286
    //   120: aload_1
    //   121: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifeq +40 -> 164
    //   127: new 135	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   134: astore_1
    //   135: aload_1
    //   136: ldc_w 291
    //   139: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_1
    //   144: aload_0
    //   145: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   148: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 156
    //   154: aload_1
    //   155: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   168: aload 4
    //   170: areturn
    //   171: astore 4
    //   173: goto +13 -> 186
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_3
    //   179: goto +156 -> 335
    //   182: astore 4
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_3
    //   187: astore_2
    //   188: ldc_w 286
    //   191: aload_1
    //   192: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +53 -> 248
    //   198: aload_3
    //   199: astore_2
    //   200: new 135	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   207: astore 5
    //   209: aload_3
    //   210: astore_2
    //   211: aload 5
    //   213: ldc_w 297
    //   216: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: astore_2
    //   222: aload 5
    //   224: aload 4
    //   226: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   229: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: astore_2
    //   235: ldc 156
    //   237: aload 5
    //   239: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 215	midas/x/mn:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto +10 -> 255
    //   248: aload_3
    //   249: astore_2
    //   250: aload 4
    //   252: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   255: aload_3
    //   256: ifnull +10 -> 266
    //   259: aload_3
    //   260: invokevirtual 281	java/io/BufferedReader:close	()V
    //   263: goto +3 -> 266
    //   266: aload_0
    //   267: ifnull +59 -> 326
    //   270: aload_0
    //   271: invokevirtual 284	java/io/InputStream:close	()V
    //   274: aconst_null
    //   275: areturn
    //   276: ldc_w 286
    //   279: aload_1
    //   280: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq +39 -> 322
    //   286: new 135	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   293: astore_1
    //   294: aload_1
    //   295: ldc_w 291
    //   298: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_1
    //   303: aload_0
    //   304: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   307: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc 156
    //   313: aload_1
    //   314: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aconst_null
    //   321: areturn
    //   322: aload_0
    //   323: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   326: aconst_null
    //   327: areturn
    //   328: astore 4
    //   330: aload_2
    //   331: astore_3
    //   332: aload 4
    //   334: astore_2
    //   335: aload_3
    //   336: ifnull +10 -> 346
    //   339: aload_3
    //   340: invokevirtual 281	java/io/BufferedReader:close	()V
    //   343: goto +3 -> 346
    //   346: aload_0
    //   347: ifnull +61 -> 408
    //   350: aload_0
    //   351: invokevirtual 284	java/io/InputStream:close	()V
    //   354: goto +54 -> 408
    //   357: ldc_w 286
    //   360: aload_1
    //   361: invokevirtual 289	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   364: ifeq +40 -> 404
    //   367: new 135	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   374: astore_1
    //   375: aload_1
    //   376: ldc_w 291
    //   379: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_1
    //   384: aload_0
    //   385: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   388: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 156
    //   394: aload_1
    //   395: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: goto +7 -> 408
    //   404: aload_0
    //   405: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   408: aload_2
    //   409: athrow
    //   410: astore_0
    //   411: goto -135 -> 276
    //   414: astore_0
    //   415: goto -58 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramInputStream	java.io.InputStream
    //   0	418	1	paramString	String
    //   17	77	2	localObject1	Object
    //   176	1	2	localObject2	Object
    //   187	222	2	localObject3	Object
    //   15	325	3	localObject4	Object
    //   42	127	4	str1	String
    //   171	1	4	localException1	Exception
    //   182	69	4	localException2	Exception
    //   328	5	4	localObject5	Object
    //   25	213	5	localStringBuilder	StringBuilder
    //   62	12	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   101	105	116	java/lang/Exception
    //   109	113	116	java/lang/Exception
    //   18	27	171	java/lang/Exception
    //   29	37	171	java/lang/Exception
    //   39	44	171	java/lang/Exception
    //   49	56	171	java/lang/Exception
    //   58	64	171	java/lang/Exception
    //   71	79	171	java/lang/Exception
    //   81	89	171	java/lang/Exception
    //   94	101	171	java/lang/Exception
    //   0	16	176	finally
    //   0	16	182	java/lang/Exception
    //   18	27	328	finally
    //   29	37	328	finally
    //   39	44	328	finally
    //   49	56	328	finally
    //   58	64	328	finally
    //   71	79	328	finally
    //   81	89	328	finally
    //   94	101	328	finally
    //   188	198	328	finally
    //   200	209	328	finally
    //   211	220	328	finally
    //   222	233	328	finally
    //   235	245	328	finally
    //   250	255	328	finally
    //   259	263	410	java/lang/Exception
    //   270	274	410	java/lang/Exception
    //   339	343	414	java/lang/Exception
    //   350	354	414	java/lang/Exception
  }
  
  private static String b(String paramString)
  {
    if (nd.b(paramString))
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
  private static ArrayList<Pair<String, Long>> b(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: new 311	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 312	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload_2
    //   10: invokevirtual 313	java/util/ArrayList:size	()I
    //   13: ifle +28 -> 41
    //   16: aload_2
    //   17: iconst_0
    //   18: new 75	java/lang/String
    //   21: dup
    //   22: aload_2
    //   23: aload_2
    //   24: invokevirtual 313	java/util/ArrayList:size	()I
    //   27: iconst_1
    //   28: isub
    //   29: invokevirtual 316	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   32: checkcast 75	java/lang/String
    //   35: invokespecial 319	java/lang/String:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 323	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   41: aload_0
    //   42: invokestatic 325	midas/x/mo:a	(Ljava/lang/String;)Z
    //   45: ifeq +14 -> 59
    //   48: ldc 156
    //   50: ldc_w 327
    //   53: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 17
    //   58: areturn
    //   59: aload_2
    //   60: invokevirtual 328	java/util/ArrayList:toString	()Ljava/lang/String;
    //   63: ldc_w 330
    //   66: invokestatic 336	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 9
    //   71: goto +48 -> 119
    //   74: astore 9
    //   76: new 135	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   83: astore 10
    //   85: aload 10
    //   87: ldc_w 338
    //   90: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 10
    //   96: aload 9
    //   98: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   101: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 156
    //   107: aload 10
    //   109: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 90
    //   117: astore 9
    //   119: new 135	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   126: astore 10
    //   128: aload 10
    //   130: ldc_w 340
    //   133: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 10
    //   139: aload_1
    //   140: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 10
    //   146: ldc_w 342
    //   149: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 10
    //   155: aload_2
    //   156: invokevirtual 313	java/util/ArrayList:size	()I
    //   159: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 10
    //   165: ldc_w 344
    //   168: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 10
    //   174: aload 9
    //   176: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc_w 346
    //   183: aload 10
    //   185: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 349	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: new 311	java/util/ArrayList
    //   194: dup
    //   195: invokespecial 312	java/util/ArrayList:<init>	()V
    //   198: astore 18
    //   200: new 135	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   207: astore 9
    //   209: aload 9
    //   211: ldc_w 351
    //   214: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 9
    //   220: aload_2
    //   221: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 156
    //   227: aload 9
    //   229: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aconst_null
    //   236: astore 10
    //   238: iconst_0
    //   239: istore_3
    //   240: iload_3
    //   241: aload_2
    //   242: invokevirtual 313	java/util/ArrayList:size	()I
    //   245: if_icmpge +921 -> 1166
    //   248: aload_0
    //   249: invokestatic 325	midas/x/mo:a	(Ljava/lang/String;)Z
    //   252: ifeq +24 -> 276
    //   255: ldc 156
    //   257: ldc_w 327
    //   260: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 10
    //   265: ifnull +8 -> 273
    //   268: aload 10
    //   270: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   273: aload 17
    //   275: areturn
    //   276: aload_2
    //   277: iload_3
    //   278: invokevirtual 316	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   281: checkcast 75	java/lang/String
    //   284: astore 19
    //   286: getstatic 176	midas/x/mo:e	Lmidas/x/mh$e;
    //   289: ifnull +18 -> 307
    //   292: getstatic 176	midas/x/mo:e	Lmidas/x/mh$e;
    //   295: aload 19
    //   297: invokeinterface 363 2 0
    //   302: astore 9
    //   304: goto +10 -> 314
    //   307: aload 19
    //   309: invokestatic 365	midas/x/mo:b	(Ljava/lang/String;)Ljava/lang/String;
    //   312: astore 9
    //   314: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   317: lstore 5
    //   319: new 367	java/net/URL
    //   322: dup
    //   323: aload 9
    //   325: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   328: invokevirtual 372	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   331: checkcast 356	java/net/HttpURLConnection
    //   334: astore 9
    //   336: aload 9
    //   338: sipush 9000
    //   341: invokevirtual 376	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   344: aload 9
    //   346: sipush 9000
    //   349: invokevirtual 379	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   352: aload 9
    //   354: iconst_0
    //   355: invokevirtual 383	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   358: aload 9
    //   360: iconst_0
    //   361: invokevirtual 386	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   364: aload 9
    //   366: iconst_1
    //   367: invokevirtual 389	java/net/HttpURLConnection:setDoInput	(Z)V
    //   370: aload 9
    //   372: invokevirtual 393	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   375: astore 10
    //   377: aload 9
    //   379: invokevirtual 396	java/net/HttpURLConnection:getResponseCode	()I
    //   382: sipush 200
    //   385: if_icmpne +413 -> 798
    //   388: sipush 1024
    //   391: newarray byte
    //   393: astore 11
    //   395: new 398	java/io/ByteArrayOutputStream
    //   398: dup
    //   399: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   402: astore 12
    //   404: aload 10
    //   406: astore 13
    //   408: aload 9
    //   410: astore 14
    //   412: aload 12
    //   414: astore 15
    //   416: aload 10
    //   418: aload 11
    //   420: invokevirtual 403	java/io/InputStream:read	([B)I
    //   423: istore 4
    //   425: iload 4
    //   427: ifle +28 -> 455
    //   430: aload 10
    //   432: astore 13
    //   434: aload 9
    //   436: astore 14
    //   438: aload 12
    //   440: astore 15
    //   442: aload 12
    //   444: aload 11
    //   446: iconst_0
    //   447: iload 4
    //   449: invokevirtual 407	java/io/ByteArrayOutputStream:write	([BII)V
    //   452: goto -48 -> 404
    //   455: aload 10
    //   457: astore 13
    //   459: aload 9
    //   461: astore 14
    //   463: aload 12
    //   465: astore 15
    //   467: aload 12
    //   469: invokevirtual 410	java/io/ByteArrayOutputStream:flush	()V
    //   472: aload 10
    //   474: astore 13
    //   476: aload 9
    //   478: astore 14
    //   480: aload 12
    //   482: astore 15
    //   484: new 412	org/json/JSONObject
    //   487: dup
    //   488: new 75	java/lang/String
    //   491: dup
    //   492: aload 12
    //   494: invokevirtual 416	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   497: invokespecial 419	java/lang/String:<init>	([B)V
    //   500: invokespecial 420	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   503: astore 11
    //   505: aload 10
    //   507: astore 13
    //   509: aload 9
    //   511: astore 14
    //   513: aload 12
    //   515: astore 15
    //   517: new 135	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   524: astore 16
    //   526: aload 10
    //   528: astore 13
    //   530: aload 9
    //   532: astore 14
    //   534: aload 12
    //   536: astore 15
    //   538: aload 16
    //   540: ldc_w 422
    //   543: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 10
    //   549: astore 13
    //   551: aload 9
    //   553: astore 14
    //   555: aload 12
    //   557: astore 15
    //   559: aload 16
    //   561: aload 19
    //   563: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 10
    //   569: astore 13
    //   571: aload 9
    //   573: astore 14
    //   575: aload 12
    //   577: astore 15
    //   579: aload 16
    //   581: ldc_w 424
    //   584: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 10
    //   590: astore 13
    //   592: aload 9
    //   594: astore 14
    //   596: aload 12
    //   598: astore 15
    //   600: aload 16
    //   602: aload 11
    //   604: invokevirtual 425	org/json/JSONObject:toString	()Ljava/lang/String;
    //   607: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 10
    //   613: astore 13
    //   615: aload 9
    //   617: astore 14
    //   619: aload 12
    //   621: astore 15
    //   623: ldc 156
    //   625: aload 16
    //   627: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 10
    //   635: astore 13
    //   637: aload 9
    //   639: astore 14
    //   641: aload 12
    //   643: astore 15
    //   645: aload 11
    //   647: ldc_w 427
    //   650: invokevirtual 430	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: astore 11
    //   655: aload 12
    //   657: astore 16
    //   659: aload 10
    //   661: astore 13
    //   663: aload 9
    //   665: astore 14
    //   667: aload 12
    //   669: astore 15
    //   671: aload 11
    //   673: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   676: ifne +125 -> 801
    //   679: aload 12
    //   681: astore 16
    //   683: aload 10
    //   685: astore 13
    //   687: aload 9
    //   689: astore 14
    //   691: aload 12
    //   693: astore 15
    //   695: aload 11
    //   697: invokestatic 434	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   700: ifne +101 -> 801
    //   703: aload 10
    //   705: astore 13
    //   707: aload 9
    //   709: astore 14
    //   711: aload 12
    //   713: astore 15
    //   715: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   718: lstore 7
    //   720: iload_3
    //   721: ifle +38 -> 759
    //   724: aload 10
    //   726: astore 13
    //   728: aload 9
    //   730: astore 14
    //   732: aload 12
    //   734: astore 15
    //   736: aload 17
    //   738: new 436	android/util/Pair
    //   741: dup
    //   742: aload 19
    //   744: lload 7
    //   746: lload 5
    //   748: lsub
    //   749: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   752: invokespecial 439	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   755: invokevirtual 441	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   758: pop
    //   759: aload 9
    //   761: astore 11
    //   763: aload 12
    //   765: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   768: aload 9
    //   770: astore 11
    //   772: aload 10
    //   774: ifnull +56 -> 830
    //   777: aload 9
    //   779: astore 11
    //   781: aload 10
    //   783: invokevirtual 284	java/io/InputStream:close	()V
    //   786: aload 9
    //   788: astore 11
    //   790: goto +40 -> 830
    //   793: astore 11
    //   795: goto +104 -> 899
    //   798: aconst_null
    //   799: astore 16
    //   801: aload 16
    //   803: ifnull +15 -> 818
    //   806: aload 9
    //   808: astore 11
    //   810: aload 16
    //   812: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   815: goto +3 -> 818
    //   818: aload 9
    //   820: astore 11
    //   822: aload 10
    //   824: ifnull +6 -> 830
    //   827: goto -50 -> 777
    //   830: aload 11
    //   832: astore 10
    //   834: goto +270 -> 1104
    //   837: astore_0
    //   838: aconst_null
    //   839: astore_1
    //   840: goto +283 -> 1123
    //   843: astore 11
    //   845: aconst_null
    //   846: astore 12
    //   848: goto +51 -> 899
    //   851: astore_0
    //   852: aconst_null
    //   853: astore 10
    //   855: aload 10
    //   857: astore_1
    //   858: goto +265 -> 1123
    //   861: astore 11
    //   863: aconst_null
    //   864: astore 10
    //   866: aload 10
    //   868: astore 12
    //   870: goto +29 -> 899
    //   873: astore_0
    //   874: aconst_null
    //   875: astore_1
    //   876: aload 10
    //   878: astore 9
    //   880: aload_1
    //   881: astore 10
    //   883: goto +240 -> 1123
    //   886: astore 11
    //   888: aconst_null
    //   889: astore 12
    //   891: aload 10
    //   893: astore 9
    //   895: aload 12
    //   897: astore 10
    //   899: aload 10
    //   901: astore 13
    //   903: aload 9
    //   905: astore 14
    //   907: aload 12
    //   909: astore 15
    //   911: new 135	java/lang/StringBuilder
    //   914: dup
    //   915: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   918: astore 16
    //   920: aload 10
    //   922: astore 13
    //   924: aload 9
    //   926: astore 14
    //   928: aload 12
    //   930: astore 15
    //   932: aload 16
    //   934: ldc_w 444
    //   937: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload 10
    //   943: astore 13
    //   945: aload 9
    //   947: astore 14
    //   949: aload 12
    //   951: astore 15
    //   953: aload 16
    //   955: aload 19
    //   957: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload 10
    //   963: astore 13
    //   965: aload 9
    //   967: astore 14
    //   969: aload 12
    //   971: astore 15
    //   973: aload 16
    //   975: ldc_w 446
    //   978: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 10
    //   984: astore 13
    //   986: aload 9
    //   988: astore 14
    //   990: aload 12
    //   992: astore 15
    //   994: aload 16
    //   996: aload 11
    //   998: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1001: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload 10
    //   1007: astore 13
    //   1009: aload 9
    //   1011: astore 14
    //   1013: aload 12
    //   1015: astore 15
    //   1017: ldc 156
    //   1019: aload 16
    //   1021: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 215	midas/x/mn:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1027: aload 10
    //   1029: astore 13
    //   1031: aload 9
    //   1033: astore 14
    //   1035: aload 12
    //   1037: astore 15
    //   1039: aload 18
    //   1041: aload 11
    //   1043: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1046: invokevirtual 448	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1049: ifne +26 -> 1075
    //   1052: aload 10
    //   1054: astore 13
    //   1056: aload 9
    //   1058: astore 14
    //   1060: aload 12
    //   1062: astore 15
    //   1064: aload 18
    //   1066: aload 11
    //   1068: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1071: invokevirtual 441	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1074: pop
    //   1075: aload 12
    //   1077: ifnull +15 -> 1092
    //   1080: aload 9
    //   1082: astore 11
    //   1084: aload 12
    //   1086: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1089: goto +3 -> 1092
    //   1092: aload 9
    //   1094: astore 11
    //   1096: aload 10
    //   1098: ifnull -268 -> 830
    //   1101: goto -324 -> 777
    //   1104: iload_3
    //   1105: iconst_1
    //   1106: iadd
    //   1107: istore_3
    //   1108: goto -868 -> 240
    //   1111: astore_0
    //   1112: aload 15
    //   1114: astore_1
    //   1115: aload 14
    //   1117: astore 9
    //   1119: aload 13
    //   1121: astore 10
    //   1123: aload_1
    //   1124: ifnull +22 -> 1146
    //   1127: aload 9
    //   1129: astore 11
    //   1131: aload_1
    //   1132: invokevirtual 442	java/io/ByteArrayOutputStream:close	()V
    //   1135: goto +11 -> 1146
    //   1138: astore_0
    //   1139: aload 11
    //   1141: astore 10
    //   1143: goto +185 -> 1328
    //   1146: aload 10
    //   1148: ifnull +12 -> 1160
    //   1151: aload 9
    //   1153: astore 11
    //   1155: aload 10
    //   1157: invokevirtual 284	java/io/InputStream:close	()V
    //   1160: aload 9
    //   1162: astore 11
    //   1164: aload_0
    //   1165: athrow
    //   1166: aload 10
    //   1168: ifnull +8 -> 1176
    //   1171: aload 10
    //   1173: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1176: aload 18
    //   1178: invokevirtual 328	java/util/ArrayList:toString	()Ljava/lang/String;
    //   1181: ldc_w 330
    //   1184: invokestatic 336	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1187: astore_0
    //   1188: goto +45 -> 1233
    //   1191: astore_0
    //   1192: new 135	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1199: astore 9
    //   1201: aload 9
    //   1203: ldc_w 450
    //   1206: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload 9
    //   1212: aload_0
    //   1213: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1216: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: pop
    //   1220: ldc 156
    //   1222: aload 9
    //   1224: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 164	midas/x/mn:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1230: ldc 90
    //   1232: astore_0
    //   1233: new 135	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1240: astore 9
    //   1242: aload 9
    //   1244: ldc_w 452
    //   1247: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: pop
    //   1251: aload 9
    //   1253: aload_1
    //   1254: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload 9
    //   1260: ldc_w 342
    //   1263: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload 9
    //   1269: aload_2
    //   1270: invokevirtual 313	java/util/ArrayList:size	()I
    //   1273: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload 9
    //   1279: ldc_w 454
    //   1282: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload 9
    //   1288: aload 17
    //   1290: invokevirtual 313	java/util/ArrayList:size	()I
    //   1293: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload 9
    //   1299: ldc_w 456
    //   1302: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload 9
    //   1308: aload_0
    //   1309: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: ldc_w 346
    //   1316: aload 9
    //   1318: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 349	midas/x/mp:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1324: aload 17
    //   1326: areturn
    //   1327: astore_0
    //   1328: aload 10
    //   1330: ifnull +8 -> 1338
    //   1333: aload 10
    //   1335: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1338: aload_0
    //   1339: athrow
    //   1340: astore_0
    //   1341: aload 17
    //   1343: areturn
    //   1344: astore 11
    //   1346: goto -578 -> 768
    //   1349: astore 10
    //   1351: aload 9
    //   1353: astore 11
    //   1355: goto -525 -> 830
    //   1358: astore 11
    //   1360: goto -542 -> 818
    //   1363: astore 11
    //   1365: goto -273 -> 1092
    //   1368: astore_1
    //   1369: goto -223 -> 1146
    //   1372: astore_1
    //   1373: goto -213 -> 1160
    //   1376: astore_0
    //   1377: goto -201 -> 1176
    //   1380: astore_1
    //   1381: goto -43 -> 1338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1384	0	paramString1	String
    //   0	1384	1	paramString2	String
    //   0	1384	2	paramArrayList	ArrayList<String>
    //   239	869	3	i	int
    //   423	25	4	j	int
    //   317	430	5	l1	long
    //   718	27	7	l2	long
    //   69	1	9	str1	String
    //   74	23	9	localException1	Exception
    //   117	1235	9	localObject1	Object
    //   83	1251	10	localObject2	Object
    //   1349	1	10	localException2	Exception
    //   393	396	11	localObject3	Object
    //   793	1	11	localException3	Exception
    //   808	23	11	localObject4	Object
    //   843	1	11	localException4	Exception
    //   861	1	11	localException5	Exception
    //   886	181	11	localException6	Exception
    //   1082	81	11	localObject5	Object
    //   1344	1	11	localException7	Exception
    //   1353	1	11	localObject6	Object
    //   1358	1	11	localException8	Exception
    //   1363	1	11	localException9	Exception
    //   402	683	12	localObject7	Object
    //   406	714	13	localObject8	Object
    //   410	706	14	localObject9	Object
    //   414	699	15	localObject10	Object
    //   524	496	16	localObject11	Object
    //   7	1335	17	localArrayList1	ArrayList
    //   198	979	18	localArrayList2	ArrayList
    //   284	672	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   59	71	74	java/lang/Exception
    //   416	425	793	java/lang/Exception
    //   442	452	793	java/lang/Exception
    //   467	472	793	java/lang/Exception
    //   484	505	793	java/lang/Exception
    //   517	526	793	java/lang/Exception
    //   538	547	793	java/lang/Exception
    //   559	567	793	java/lang/Exception
    //   579	588	793	java/lang/Exception
    //   600	611	793	java/lang/Exception
    //   623	633	793	java/lang/Exception
    //   645	655	793	java/lang/Exception
    //   671	679	793	java/lang/Exception
    //   695	703	793	java/lang/Exception
    //   715	720	793	java/lang/Exception
    //   736	759	793	java/lang/Exception
    //   377	404	837	finally
    //   377	404	843	java/lang/Exception
    //   336	377	851	finally
    //   336	377	861	java/lang/Exception
    //   319	336	873	finally
    //   319	336	886	java/lang/Exception
    //   416	425	1111	finally
    //   442	452	1111	finally
    //   467	472	1111	finally
    //   484	505	1111	finally
    //   517	526	1111	finally
    //   538	547	1111	finally
    //   559	567	1111	finally
    //   579	588	1111	finally
    //   600	611	1111	finally
    //   623	633	1111	finally
    //   645	655	1111	finally
    //   671	679	1111	finally
    //   695	703	1111	finally
    //   715	720	1111	finally
    //   736	759	1111	finally
    //   911	920	1111	finally
    //   932	941	1111	finally
    //   953	961	1111	finally
    //   973	982	1111	finally
    //   994	1005	1111	finally
    //   1017	1027	1111	finally
    //   1039	1052	1111	finally
    //   1064	1075	1111	finally
    //   763	768	1138	finally
    //   781	786	1138	finally
    //   810	815	1138	finally
    //   1084	1089	1138	finally
    //   1131	1135	1138	finally
    //   1155	1160	1138	finally
    //   1164	1166	1138	finally
    //   1176	1188	1191	java/lang/Exception
    //   240	263	1327	finally
    //   276	304	1327	finally
    //   307	314	1327	finally
    //   314	319	1327	finally
    //   268	273	1340	java/lang/Exception
    //   763	768	1344	java/lang/Exception
    //   781	786	1349	java/lang/Exception
    //   810	815	1358	java/lang/Exception
    //   1084	1089	1363	java/lang/Exception
    //   1131	1135	1368	java/lang/Exception
    //   1155	1160	1372	java/lang/Exception
    //   1171	1176	1376	java/lang/Exception
    //   1333	1338	1380	java/lang/Exception
  }
  
  private static ArrayList<Pair<String, Long>> b(ExecutorService paramExecutorService, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramString1))
    {
      mn.b("IPMeasure", "ping Thread isInterrupted");
      return localArrayList;
    }
    Object localObject2 = "";
    Object localObject3;
    try
    {
      String str1 = URLEncoder.encode(paramArrayList.toString(), "UTF-8");
      localObject2 = str1;
    }
    catch (Exception localException1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("pingInBackground() report begin e=");
      ((StringBuilder)localObject3).append(localException1.toString());
      mn.b("IPMeasure", ((StringBuilder)localObject3).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("state=begin&ipv=");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("&ipsize=");
    ((StringBuilder)localObject1).append(paramArrayList.size());
    ((StringBuilder)localObject1).append("&ips=");
    ((StringBuilder)localObject1).append((String)localObject2);
    mp.a("measure.ping", ((StringBuilder)localObject1).toString());
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
        mn.b("IPMeasure", paramExecutorService.toString());
        return localArrayList;
      }
      if (nd.b(str3)) {}
      for (localObject3 = "ping6";; localObject3 = "ping") {
        break;
      }
      Object localObject4;
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("/system/bin/");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(" -c ");
        ((StringBuilder)localObject1).append(String.valueOf(4));
        ((StringBuilder)localObject1).append(" -W ");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(str3);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("command : ");
        ((StringBuilder)localObject4).append((String)localObject1);
        mn.b("IPMeasure", ((StringBuilder)localObject4).toString());
        localObject4 = Runtime.getRuntime().exec((String)localObject1);
        try
        {
          ((Process)localObject4).waitFor();
          int i = ((Process)localObject4).exitValue();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(" exitValue = ");
          ((StringBuilder)localObject1).append(i);
          mn.b("IPMeasure", ((StringBuilder)localObject1).toString());
          localObject1 = localObject4;
          if (i == 0) {
            break label574;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("state=exit&ipv=");
          ((StringBuilder)localObject1).append(paramString2);
          ((StringBuilder)localObject1).append("&code=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("&ipsize=");
          ((StringBuilder)localObject1).append(paramArrayList.size());
          ((StringBuilder)localObject1).append("&ips=");
          ((StringBuilder)localObject1).append((String)localObject2);
          mp.a("measure.ping", ((StringBuilder)localObject1).toString());
        }
        catch (Exception localException4)
        {
          localObject1 = localObject4;
        }
        localException5.printStackTrace();
      }
      catch (Exception localException5)
      {
        localObject1 = null;
      }
      label574:
      if (localObject1 == null)
      {
        paramExecutorService = new StringBuilder();
        paramExecutorService.append((String)localObject3);
        paramExecutorService.append("process is Null");
        mn.b("IPMeasure", paramExecutorService.toString());
        return localArrayList;
      }
      try
      {
        localObject4 = new Runnable()
        {
          public void run()
          {
            String str = mo.a(this.a.getErrorStream(), "error");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.b);
            localStringBuilder.append(" errorStream: ");
            localStringBuilder.append(str);
            mn.b("IPMeasure", localStringBuilder.toString());
          }
        };
        try
        {
          paramExecutorService.submit((Runnable)localObject4);
        }
        catch (Exception localException2) {}
        localException3.printStackTrace();
      }
      catch (Exception localException3) {}
      String str2 = b(((Process)localObject1).getInputStream(), "input");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(": ");
      localStringBuilder.append(str2);
      mn.b("IPMeasure", localStringBuilder.toString());
      localArrayList.add(new Pair(str3, a(str3, str2)));
      if (localObject1 != null) {
        ((Process)localObject1).destroy();
      }
    }
    paramExecutorService = new StringBuilder();
    paramExecutorService.append("ping result = ");
    paramExecutorService.append(localArrayList);
    mn.b("IPMeasure", paramExecutorService.toString());
    return localArrayList;
  }
  
  private static void b(long paramLong)
  {
    f = paramLong;
    mu.a("lastMeasureTime", f);
  }
  
  private static void b(ExecutorService paramExecutorService, final String paramString1, ArrayList<String> paramArrayList, final String paramString2, my parammy)
  {
    if (a(paramString1)) {
      return;
    }
    long l1 = paramArrayList.size();
    long l2 = c;
    na.a(paramExecutorService, paramExecutorService, new mx()
    {
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        return mo.a(this.a, paramString1, paramString2, (ArrayList)paramAnonymousArrayOfObject[0]);
      }
    }, new Object[] { paramArrayList }, parammy, l1 * l2 + 5000L);
  }
  
  public static void b(final ExecutorService paramExecutorService, final mj parammj, my parammy)
  {
    int i = nd.b(mg.a, true);
    boolean bool1 = nd.a(i);
    boolean bool2 = nd.b(i);
    if (bool1) {
      localObject1 = "4";
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    if (bool2) {
      localObject1 = "6";
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject1 = new ArrayList();
    Iterator localIterator = parammj.e.iterator();
    while (localIterator.hasNext())
    {
      mi localmi = (mi)localIterator.next();
      if ((bool1) && (bool2)) {
        ((ArrayList)localObject1).add(localmi.a);
      } else if ((bool1) && (!bool2))
      {
        if (nd.a(localmi.a)) {
          ((ArrayList)localObject1).add(localmi.a);
        }
      }
      else if ((!bool1) && (bool2) && (nd.b(localmi.a))) {
        ((ArrayList)localObject1).add(localmi.a);
      }
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      paramExecutorService = new StringBuilder();
      paramExecutorService.append("measureCore() return ipList=");
      paramExecutorService.append(localObject1);
      mn.b("IPMeasure", paramExecutorService.toString());
      parammy.a(0, null);
      return;
    }
    d.put(parammj.a, Boolean.valueOf(false));
    b(paramExecutorService, parammj.a, (ArrayList)localObject1, (String)localObject2, new my()
    {
      public void a(int paramAnonymousInt, Object paramAnonymousObject)
      {
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof ArrayList)))
        {
          ArrayList localArrayList = (ArrayList)paramAnonymousObject;
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
          this.a.a(paramAnonymousInt, paramAnonymousObject);
          return;
        }
        paramAnonymousObject = new StringBuilder();
        paramAnonymousObject.append("ping fail, try sMeasure.measure() = ");
        paramAnonymousObject.append(mo.a());
        mn.b("IPMeasure", paramAnonymousObject.toString());
        mo.a(paramExecutorService, parammj.a, this.d, this.e, this.a);
      }
    });
  }
  
  public static boolean b(mj parammj)
  {
    if (parammj == null) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = parammj.c.longValue();
    parammj = new StringBuilder();
    parammj.append("isOverdue() time: ");
    parammj.append(l1);
    parammj.append("-");
    parammj.append(l2);
    parammj.append("=");
    l1 -= l2;
    parammj.append(l1);
    parammj.append(">");
    parammj.append(b);
    parammj.append(" : ");
    boolean bool;
    if (l1 > b) {
      bool = true;
    } else {
      bool = false;
    }
    parammj.append(bool);
    mn.b("IPMeasure", parammj.toString());
    return l1 > b;
  }
  
  private static void c(ExecutorService paramExecutorService, String paramString1, ArrayList<String> paramArrayList, final String paramString2, my parammy)
  {
    long l1 = paramArrayList.size();
    long l2 = c;
    na.a(paramExecutorService, paramExecutorService, new mx()
    {
      public Object a(Object[] paramAnonymousArrayOfObject)
      {
        return mo.a(this.a, paramString2, (ArrayList)paramAnonymousArrayOfObject[0]);
      }
    }, new Object[] { paramArrayList }, parammy, l1 * l2 + 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mo
 * JD-Core Version:    0.7.0.1
 */