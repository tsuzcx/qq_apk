package com.tencent.mm.plugin.backup.bakoldlogic.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String END = "img";
  private static String hKd = "icon_";
  private static String hKe = "iphone";
  private static String hKf = "android";
  private static String hKg = "s60v3";
  private static String hKh = "s60v5";
  private static a hNq;
  private Map<String, a.a> hKj = null;
  
  public a()
  {
    auu();
  }
  
  /* Error */
  private void auu()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: new 59	java/util/HashMap
    //   8: dup
    //   9: invokespecial 60	java/util/HashMap:<init>	()V
    //   12: putfield 50	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKj	Ljava/util/Map;
    //   15: invokestatic 66	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   18: invokevirtual 72	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 74
    //   25: invokevirtual 80	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore_3
    //   29: new 82	java/io/BufferedReader
    //   32: dup
    //   33: new 84	java/io/InputStreamReader
    //   36: dup
    //   37: aload_3
    //   38: ldc 86
    //   40: invokespecial 89	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   43: invokespecial 92	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore 5
    //   52: aload_3
    //   53: astore 6
    //   55: aload 4
    //   57: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 7
    //   62: aload 7
    //   64: ifnull +413 -> 477
    //   67: aload 4
    //   69: astore 5
    //   71: aload_3
    //   72: astore 6
    //   74: aload 7
    //   76: getstatic 24	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKd	Ljava/lang/String;
    //   79: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   82: ifeq -34 -> 48
    //   85: aload 4
    //   87: astore 5
    //   89: aload_3
    //   90: astore 6
    //   92: new 6	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a
    //   95: dup
    //   96: invokespecial 103	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:<init>	()V
    //   99: astore 7
    //   101: aload 4
    //   103: astore 5
    //   105: aload_3
    //   106: astore 6
    //   108: aload 4
    //   110: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnull +327 -> 444
    //   120: aload 4
    //   122: astore 5
    //   124: aload_3
    //   125: astore 6
    //   127: aload 8
    //   129: getstatic 28	com/tencent/mm/plugin/backup/bakoldlogic/b/a:END	Ljava/lang/String;
    //   132: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   135: ifne +309 -> 444
    //   138: aload 4
    //   140: astore 5
    //   142: aload_3
    //   143: astore 6
    //   145: aload 8
    //   147: ldc 105
    //   149: invokevirtual 109	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   152: istore_2
    //   153: aload 4
    //   155: astore 5
    //   157: aload_3
    //   158: astore 6
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: aload 8
    //   165: invokevirtual 113	java/lang/String:length	()I
    //   168: if_icmpge +276 -> 444
    //   171: aload 4
    //   173: astore 5
    //   175: aload_3
    //   176: astore 6
    //   178: aload 8
    //   180: iload_2
    //   181: iconst_1
    //   182: iadd
    //   183: invokevirtual 117	java/lang/String:substring	(I)Ljava/lang/String;
    //   186: astore 9
    //   188: aload 4
    //   190: astore 5
    //   192: aload_3
    //   193: astore 6
    //   195: aload 8
    //   197: getstatic 32	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKe	Ljava/lang/String;
    //   200: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   203: ifeq +110 -> 313
    //   206: aload 4
    //   208: astore 5
    //   210: aload_3
    //   211: astore 6
    //   213: aload 7
    //   215: aload 9
    //   217: putfield 124	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:hKl	Ljava/lang/String;
    //   220: aload 4
    //   222: astore 5
    //   224: aload_3
    //   225: astore 6
    //   227: aload_0
    //   228: getfield 50	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKj	Ljava/util/Map;
    //   231: aload 7
    //   233: getfield 127	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:hKk	Ljava/lang/String;
    //   236: aload 7
    //   238: invokeinterface 133 3 0
    //   243: pop
    //   244: goto -143 -> 101
    //   247: astore 7
    //   249: aload 4
    //   251: astore 5
    //   253: aload_3
    //   254: astore 6
    //   256: ldc 135
    //   258: aload 7
    //   260: ldc 137
    //   262: iconst_0
    //   263: anewarray 139	java/lang/Object
    //   266: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload 4
    //   271: ifnull +8 -> 279
    //   274: aload 4
    //   276: invokevirtual 148	java/io/BufferedReader:close	()V
    //   279: iload_1
    //   280: istore_2
    //   281: aload_3
    //   282: ifnull +9 -> 291
    //   285: aload_3
    //   286: invokevirtual 151	java/io/InputStream:close	()V
    //   289: iload_1
    //   290: istore_2
    //   291: ldc 135
    //   293: new 153	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 155
    //   299: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: iload_2
    //   303: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 169	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: return
    //   313: aload 4
    //   315: astore 5
    //   317: aload_3
    //   318: astore 6
    //   320: aload 8
    //   322: getstatic 36	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKf	Ljava/lang/String;
    //   325: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   328: ifeq +46 -> 374
    //   331: aload 4
    //   333: astore 5
    //   335: aload_3
    //   336: astore 6
    //   338: aload 7
    //   340: aload 9
    //   342: putfield 127	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:hKk	Ljava/lang/String;
    //   345: goto -125 -> 220
    //   348: astore 4
    //   350: aload 6
    //   352: astore_3
    //   353: aload 5
    //   355: ifnull +8 -> 363
    //   358: aload 5
    //   360: invokevirtual 148	java/io/BufferedReader:close	()V
    //   363: aload_3
    //   364: ifnull +7 -> 371
    //   367: aload_3
    //   368: invokevirtual 151	java/io/InputStream:close	()V
    //   371: aload 4
    //   373: athrow
    //   374: aload 4
    //   376: astore 5
    //   378: aload_3
    //   379: astore 6
    //   381: aload 8
    //   383: getstatic 40	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKg	Ljava/lang/String;
    //   386: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   389: ifeq +20 -> 409
    //   392: aload 4
    //   394: astore 5
    //   396: aload_3
    //   397: astore 6
    //   399: aload 7
    //   401: aload 9
    //   403: putfield 172	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:hKm	Ljava/lang/String;
    //   406: goto -186 -> 220
    //   409: aload 4
    //   411: astore 5
    //   413: aload_3
    //   414: astore 6
    //   416: aload 8
    //   418: getstatic 44	com/tencent/mm/plugin/backup/bakoldlogic/b/a:hKh	Ljava/lang/String;
    //   421: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   424: ifeq -204 -> 220
    //   427: aload 4
    //   429: astore 5
    //   431: aload_3
    //   432: astore 6
    //   434: aload 7
    //   436: aload 9
    //   438: putfield 175	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:hKn	Ljava/lang/String;
    //   441: goto -221 -> 220
    //   444: aload 4
    //   446: astore 5
    //   448: aload_3
    //   449: astore 6
    //   451: ldc 135
    //   453: ldc 177
    //   455: iconst_1
    //   456: anewarray 139	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 7
    //   463: invokevirtual 178	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:toString	()Ljava/lang/String;
    //   466: aastore
    //   467: invokestatic 181	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: iload_1
    //   471: iconst_1
    //   472: iadd
    //   473: istore_1
    //   474: goto -426 -> 48
    //   477: aload 4
    //   479: invokevirtual 148	java/io/BufferedReader:close	()V
    //   482: iload_1
    //   483: istore_2
    //   484: aload_3
    //   485: ifnull -194 -> 291
    //   488: aload_3
    //   489: invokevirtual 151	java/io/InputStream:close	()V
    //   492: iload_1
    //   493: istore_2
    //   494: goto -203 -> 291
    //   497: astore_3
    //   498: iload_1
    //   499: istore_2
    //   500: goto -209 -> 291
    //   503: astore_3
    //   504: goto -133 -> 371
    //   507: astore 4
    //   509: aconst_null
    //   510: astore 5
    //   512: aconst_null
    //   513: astore_3
    //   514: goto -161 -> 353
    //   517: astore 4
    //   519: aconst_null
    //   520: astore 5
    //   522: goto -169 -> 353
    //   525: astore_3
    //   526: iload_1
    //   527: istore_2
    //   528: goto -237 -> 291
    //   531: astore 7
    //   533: aconst_null
    //   534: astore 4
    //   536: aconst_null
    //   537: astore_3
    //   538: iload_2
    //   539: istore_1
    //   540: goto -291 -> 249
    //   543: astore 7
    //   545: aconst_null
    //   546: astore 4
    //   548: iload_2
    //   549: istore_1
    //   550: goto -301 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	a
    //   3	547	1	i	int
    //   1	548	2	j	int
    //   21	468	3	localObject1	Object
    //   497	1	3	localException1	java.lang.Exception
    //   503	1	3	localException2	java.lang.Exception
    //   513	1	3	localObject2	Object
    //   525	1	3	localException3	java.lang.Exception
    //   537	1	3	localObject3	Object
    //   46	286	4	localBufferedReader	java.io.BufferedReader
    //   348	130	4	localObject4	Object
    //   507	1	4	localObject5	Object
    //   517	1	4	localObject6	Object
    //   534	13	4	localObject7	Object
    //   50	471	5	localObject8	Object
    //   53	397	6	localObject9	Object
    //   60	177	7	localObject10	Object
    //   247	215	7	localIOException1	java.io.IOException
    //   531	1	7	localIOException2	java.io.IOException
    //   543	1	7	localIOException3	java.io.IOException
    //   113	304	8	str1	String
    //   186	251	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   55	62	247	java/io/IOException
    //   74	85	247	java/io/IOException
    //   92	101	247	java/io/IOException
    //   108	115	247	java/io/IOException
    //   127	138	247	java/io/IOException
    //   145	153	247	java/io/IOException
    //   160	171	247	java/io/IOException
    //   178	188	247	java/io/IOException
    //   195	206	247	java/io/IOException
    //   213	220	247	java/io/IOException
    //   227	244	247	java/io/IOException
    //   320	331	247	java/io/IOException
    //   338	345	247	java/io/IOException
    //   381	392	247	java/io/IOException
    //   399	406	247	java/io/IOException
    //   416	427	247	java/io/IOException
    //   434	441	247	java/io/IOException
    //   451	470	247	java/io/IOException
    //   55	62	348	finally
    //   74	85	348	finally
    //   92	101	348	finally
    //   108	115	348	finally
    //   127	138	348	finally
    //   145	153	348	finally
    //   160	171	348	finally
    //   178	188	348	finally
    //   195	206	348	finally
    //   213	220	348	finally
    //   227	244	348	finally
    //   256	269	348	finally
    //   320	331	348	finally
    //   338	345	348	finally
    //   381	392	348	finally
    //   399	406	348	finally
    //   416	427	348	finally
    //   434	441	348	finally
    //   451	470	348	finally
    //   477	482	497	java/lang/Exception
    //   488	492	497	java/lang/Exception
    //   358	363	503	java/lang/Exception
    //   367	371	503	java/lang/Exception
    //   22	29	507	finally
    //   29	48	517	finally
    //   274	279	525	java/lang/Exception
    //   285	289	525	java/lang/Exception
    //   22	29	531	java/io/IOException
    //   29	48	543	java/io/IOException
  }
  
  public static a.a xE(String paramString)
  {
    if (hNq == null) {
      hNq = new a();
    }
    Object localObject = hNq;
    if (((a)localObject).hKj == null) {
      ((a)localObject).auu();
    }
    localObject = ((a)localObject).hKj.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if ((locala.hKl != null) && (locala.hKl.equals(paramString))) {
        return locala;
      }
    }
    return null;
  }
  
  public static a.a xF(String paramString)
  {
    if (hNq == null)
    {
      locala = new a();
      hNq = locala;
      a(locala);
    }
    a locala = hNq;
    if (locala.hKj == null) {
      locala.auu();
    }
    return (a.a)locala.hKj.get(paramString);
  }
  
  public final void ati()
  {
    hNq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.a
 * JD-Core Version:    0.7.0.1
 */