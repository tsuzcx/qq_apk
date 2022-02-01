package com.tencent.mm.plugin.appbrand.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class ac
{
  /* Error */
  public static String a(com.tencent.mm.plugin.appbrand.t paramt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 11
    //   8: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_2
    //   12: invokestatic 23	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: astore 5
    //   17: new 25	java/io/BufferedInputStream
    //   20: dup
    //   21: invokestatic 31	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   24: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload 5
    //   29: invokevirtual 43	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: invokespecial 47	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 9
    //   37: aload 7
    //   39: astore 4
    //   41: aload 8
    //   43: astore_2
    //   44: aload 5
    //   46: invokevirtual 51	android/net/Uri:getPath	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 7
    //   53: astore 4
    //   55: aload 8
    //   57: astore_2
    //   58: aload 5
    //   60: bipush 46
    //   62: invokevirtual 57	java/lang/String:lastIndexOf	(I)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +253 -> 321
    //   71: aload 7
    //   73: astore 4
    //   75: aload 8
    //   77: astore_2
    //   78: aload 5
    //   80: iload_3
    //   81: invokevirtual 61	java/lang/String:substring	(I)Ljava/lang/String;
    //   84: astore 5
    //   86: aload 5
    //   88: astore 6
    //   90: aload 7
    //   92: astore 4
    //   94: aload 8
    //   96: astore_2
    //   97: aload 5
    //   99: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +43 -> 145
    //   105: aload 5
    //   107: astore 6
    //   109: aload 7
    //   111: astore 4
    //   113: aload 8
    //   115: astore_2
    //   116: aload 5
    //   118: ldc 69
    //   120: invokevirtual 73	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   123: ifne +22 -> 145
    //   126: aload 7
    //   128: astore 4
    //   130: aload 8
    //   132: astore_2
    //   133: ldc 69
    //   135: aload 5
    //   137: invokestatic 77	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   140: invokevirtual 81	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 6
    //   145: aload 7
    //   147: astore 4
    //   149: aload 8
    //   151: astore_2
    //   152: new 83	com/tencent/mm/vfs/q
    //   155: dup
    //   156: aload_1
    //   157: new 85	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 87
    //   163: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   169: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: aload 6
    //   174: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 109	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: invokevirtual 112	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   186: astore 5
    //   188: aload 7
    //   190: astore 4
    //   192: aload 8
    //   194: astore_2
    //   195: new 83	com/tencent/mm/vfs/q
    //   198: dup
    //   199: aload 5
    //   201: invokespecial 113	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   204: astore_1
    //   205: aload 7
    //   207: astore 4
    //   209: aload 8
    //   211: astore_2
    //   212: aload_1
    //   213: invokestatic 119	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   216: astore_1
    //   217: aload_1
    //   218: astore 4
    //   220: aload_1
    //   221: astore_2
    //   222: aload 9
    //   224: aload_1
    //   225: invokestatic 125	com/tencent/mm/b/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   228: pop2
    //   229: aload_1
    //   230: astore 4
    //   232: aload_1
    //   233: astore_2
    //   234: new 127	com/tencent/mm/plugin/appbrand/ac/i
    //   237: dup
    //   238: invokespecial 130	com/tencent/mm/plugin/appbrand/ac/i:<init>	()V
    //   241: astore 7
    //   243: aload_1
    //   244: astore 4
    //   246: aload_1
    //   247: astore_2
    //   248: aload_0
    //   249: invokevirtual 136	com/tencent/mm/plugin/appbrand/t:Sh	()Lcom/tencent/mm/plugin/appbrand/jsapi/file/av;
    //   252: new 83	com/tencent/mm/vfs/q
    //   255: dup
    //   256: aload 5
    //   258: invokespecial 113	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   261: aload 6
    //   263: iconst_1
    //   264: aload 7
    //   266: invokevirtual 141	com/tencent/mm/plugin/appbrand/jsapi/file/av:a	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;ZLcom/tencent/mm/plugin/appbrand/ac/i;)Lcom/tencent/mm/plugin/appbrand/appstorage/m;
    //   269: pop
    //   270: aload_1
    //   271: astore 4
    //   273: aload_1
    //   274: astore_2
    //   275: aload 7
    //   277: getfield 145	com/tencent/mm/plugin/appbrand/ac/i:value	Ljava/lang/Object;
    //   280: checkcast 53	java/lang/String
    //   283: astore_0
    //   284: aload 9
    //   286: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   289: aload_1
    //   290: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   293: ldc 11
    //   295: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_0
    //   299: areturn
    //   300: astore_0
    //   301: ldc 156
    //   303: aload_0
    //   304: ldc 158
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: ldc 11
    //   315: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: ldc 158
    //   320: areturn
    //   321: ldc 158
    //   323: astore 5
    //   325: goto -239 -> 86
    //   328: astore_0
    //   329: aload 7
    //   331: astore 4
    //   333: aload 8
    //   335: astore_2
    //   336: ldc 156
    //   338: aload_0
    //   339: ldc 158
    //   341: iconst_0
    //   342: anewarray 4	java/lang/Object
    //   345: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 9
    //   350: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   353: aconst_null
    //   354: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   357: ldc 11
    //   359: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: ldc 158
    //   364: areturn
    //   365: astore_0
    //   366: aload 4
    //   368: astore_2
    //   369: ldc 156
    //   371: aload_0
    //   372: ldc 158
    //   374: iconst_0
    //   375: anewarray 4	java/lang/Object
    //   378: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload 9
    //   383: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   386: aload 4
    //   388: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   391: ldc 11
    //   393: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: ldc 158
    //   398: areturn
    //   399: astore_0
    //   400: aload 9
    //   402: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   405: aload_2
    //   406: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   409: ldc 11
    //   411: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_0
    //   415: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramt	com.tencent.mm.plugin.appbrand.t
    //   0	416	1	paramString1	String
    //   0	416	2	paramString2	String
    //   65	16	3	i	int
    //   39	348	4	localObject1	Object
    //   15	309	5	localObject2	Object
    //   88	174	6	localObject3	Object
    //   4	326	7	locali	com.tencent.mm.plugin.appbrand.ac.i
    //   1	333	8	localObject4	Object
    //   35	366	9	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   17	37	300	java/lang/Exception
    //   212	217	328	java/io/FileNotFoundException
    //   44	51	365	java/lang/Exception
    //   58	66	365	java/lang/Exception
    //   78	86	365	java/lang/Exception
    //   97	105	365	java/lang/Exception
    //   116	126	365	java/lang/Exception
    //   133	145	365	java/lang/Exception
    //   152	188	365	java/lang/Exception
    //   195	205	365	java/lang/Exception
    //   212	217	365	java/lang/Exception
    //   222	229	365	java/lang/Exception
    //   234	243	365	java/lang/Exception
    //   248	270	365	java/lang/Exception
    //   275	284	365	java/lang/Exception
    //   336	348	365	java/lang/Exception
    //   44	51	399	finally
    //   58	66	399	finally
    //   78	86	399	finally
    //   97	105	399	finally
    //   116	126	399	finally
    //   133	145	399	finally
    //   152	188	399	finally
    //   195	205	399	finally
    //   212	217	399	finally
    //   222	229	399	finally
    //   234	243	399	finally
    //   248	270	399	finally
    //   275	284	399	finally
    //   336	348	399	finally
    //   369	381	399	finally
  }
  
  public static boolean ann(String paramString)
  {
    AppMethodBeat.i(49317);
    if ((paramString != null) && (paramString.startsWith("content://")))
    {
      AppMethodBeat.o(49317);
      return true;
    }
    AppMethodBeat.o(49317);
    return false;
  }
  
  public static String h(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(273467);
    if (!TextUtils.isEmpty(paramAppBrandInitConfigWC.nYf))
    {
      paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.nYf;
      AppMethodBeat.o(273467);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.cwV.nYE;
    AppMethodBeat.o(273467);
    return paramAppBrandInitConfigWC;
  }
  
  public static boolean i(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(273469);
    if (!TextUtils.isEmpty(paramAppBrandInitConfigWC.nYf))
    {
      AppMethodBeat.o(273469);
      return true;
    }
    AppMethodBeat.o(273469);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ac
 * JD-Core Version:    0.7.0.1
 */