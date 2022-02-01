package com.tencent.mm.plugin.appbrand.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class y
{
  public static boolean Ve(String paramString)
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
  
  /* Error */
  public static String a(com.tencent.mm.plugin.appbrand.o paramo, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 31
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_2
    //   12: invokestatic 37	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   15: astore 5
    //   17: new 39	java/io/BufferedInputStream
    //   20: dup
    //   21: invokestatic 45	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   24: invokevirtual 51	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload 5
    //   29: invokevirtual 57	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   32: invokespecial 61	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 9
    //   37: aload 7
    //   39: astore 4
    //   41: aload 8
    //   43: astore_2
    //   44: aload 5
    //   46: invokevirtual 65	android/net/Uri:getPath	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 7
    //   53: astore 4
    //   55: aload 8
    //   57: astore_2
    //   58: aload 5
    //   60: bipush 46
    //   62: invokevirtual 69	java/lang/String:lastIndexOf	(I)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +256 -> 324
    //   71: aload 7
    //   73: astore 4
    //   75: aload 8
    //   77: astore_2
    //   78: aload 5
    //   80: iload_3
    //   81: invokevirtual 73	java/lang/String:substring	(I)Ljava/lang/String;
    //   84: astore 5
    //   86: aload 5
    //   88: astore 6
    //   90: aload 7
    //   92: astore 4
    //   94: aload 8
    //   96: astore_2
    //   97: aload 5
    //   99: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +43 -> 145
    //   105: aload 5
    //   107: astore 6
    //   109: aload 7
    //   111: astore 4
    //   113: aload 8
    //   115: astore_2
    //   116: aload 5
    //   118: ldc 81
    //   120: invokevirtual 20	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   123: ifne +22 -> 145
    //   126: aload 7
    //   128: astore 4
    //   130: aload 8
    //   132: astore_2
    //   133: ldc 81
    //   135: aload 5
    //   137: invokestatic 85	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   140: invokevirtual 89	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore 6
    //   145: aload 7
    //   147: astore 4
    //   149: aload 8
    //   151: astore_2
    //   152: new 91	com/tencent/mm/vfs/e
    //   155: dup
    //   156: aload_1
    //   157: new 93	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 95
    //   163: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   169: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: aload 6
    //   174: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 117	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: invokevirtual 121	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   186: invokestatic 127	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   189: astore 5
    //   191: aload 7
    //   193: astore 4
    //   195: aload 8
    //   197: astore_2
    //   198: new 91	com/tencent/mm/vfs/e
    //   201: dup
    //   202: aload 5
    //   204: invokespecial 128	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   207: astore_1
    //   208: aload 7
    //   210: astore 4
    //   212: aload 8
    //   214: astore_2
    //   215: aload_1
    //   216: invokestatic 134	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   219: astore_1
    //   220: aload_1
    //   221: astore 4
    //   223: aload_1
    //   224: astore_2
    //   225: aload 9
    //   227: aload_1
    //   228: invokestatic 140	com/tencent/mm/b/e:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   231: pop2
    //   232: aload_1
    //   233: astore 4
    //   235: aload_1
    //   236: astore_2
    //   237: new 142	com/tencent/mm/plugin/appbrand/z/i
    //   240: dup
    //   241: invokespecial 145	com/tencent/mm/plugin/appbrand/z/i:<init>	()V
    //   244: astore 7
    //   246: aload_1
    //   247: astore 4
    //   249: aload_1
    //   250: astore_2
    //   251: aload_0
    //   252: invokevirtual 151	com/tencent/mm/plugin/appbrand/o:EY	()Lcom/tencent/mm/plugin/appbrand/jsapi/file/ar;
    //   255: new 91	com/tencent/mm/vfs/e
    //   258: dup
    //   259: aload 5
    //   261: invokespecial 128	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   264: aload 6
    //   266: iconst_1
    //   267: aload 7
    //   269: invokevirtual 156	com/tencent/mm/plugin/appbrand/jsapi/file/ar:a	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;ZLcom/tencent/mm/plugin/appbrand/z/i;)Lcom/tencent/mm/plugin/appbrand/appstorage/l;
    //   272: pop
    //   273: aload_1
    //   274: astore 4
    //   276: aload_1
    //   277: astore_2
    //   278: aload 7
    //   280: getfield 160	com/tencent/mm/plugin/appbrand/z/i:value	Ljava/lang/Object;
    //   283: checkcast 17	java/lang/String
    //   286: astore_0
    //   287: aload 9
    //   289: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   292: aload_1
    //   293: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   296: ldc 31
    //   298: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_0
    //   302: areturn
    //   303: astore_0
    //   304: ldc 168
    //   306: aload_0
    //   307: ldc 170
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: ldc 31
    //   318: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: ldc 170
    //   323: areturn
    //   324: ldc 170
    //   326: astore 5
    //   328: goto -242 -> 86
    //   331: astore_0
    //   332: aload 7
    //   334: astore 4
    //   336: aload 8
    //   338: astore_2
    //   339: ldc 168
    //   341: aload_0
    //   342: ldc 170
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 9
    //   353: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   356: aconst_null
    //   357: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   360: ldc 31
    //   362: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: ldc 170
    //   367: areturn
    //   368: astore_0
    //   369: aload 4
    //   371: astore_2
    //   372: ldc 168
    //   374: aload_0
    //   375: ldc 170
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 9
    //   386: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   389: aload 4
    //   391: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   394: ldc 31
    //   396: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: ldc 170
    //   401: areturn
    //   402: astore_0
    //   403: aload 9
    //   405: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   408: aload_2
    //   409: invokestatic 166	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   412: ldc 31
    //   414: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload_0
    //   418: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramo	com.tencent.mm.plugin.appbrand.o
    //   0	419	1	paramString1	String
    //   0	419	2	paramString2	String
    //   65	16	3	i	int
    //   39	351	4	localObject1	Object
    //   15	312	5	localObject2	Object
    //   88	177	6	localObject3	Object
    //   4	329	7	locali	com.tencent.mm.plugin.appbrand.z.i
    //   1	336	8	localObject4	Object
    //   35	369	9	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   17	37	303	java/lang/Exception
    //   215	220	331	java/io/FileNotFoundException
    //   44	51	368	java/lang/Exception
    //   58	66	368	java/lang/Exception
    //   78	86	368	java/lang/Exception
    //   97	105	368	java/lang/Exception
    //   116	126	368	java/lang/Exception
    //   133	145	368	java/lang/Exception
    //   152	191	368	java/lang/Exception
    //   198	208	368	java/lang/Exception
    //   215	220	368	java/lang/Exception
    //   225	232	368	java/lang/Exception
    //   237	246	368	java/lang/Exception
    //   251	273	368	java/lang/Exception
    //   278	287	368	java/lang/Exception
    //   339	351	368	java/lang/Exception
    //   44	51	402	finally
    //   58	66	402	finally
    //   78	86	402	finally
    //   97	105	402	finally
    //   116	126	402	finally
    //   133	145	402	finally
    //   152	191	402	finally
    //   198	208	402	finally
    //   215	220	402	finally
    //   225	232	402	finally
    //   237	246	402	finally
    //   251	273	402	finally
    //   278	287	402	finally
    //   339	351	402	finally
    //   372	384	402	finally
  }
  
  public static String j(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(188944);
    if (!TextUtils.isEmpty(paramAppBrandInitConfigWC.jXy))
    {
      paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.jXy;
      AppMethodBeat.o(188944);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.cmv.jXU;
    AppMethodBeat.o(188944);
    return paramAppBrandInitConfigWC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.y
 * JD-Core Version:    0.7.0.1
 */