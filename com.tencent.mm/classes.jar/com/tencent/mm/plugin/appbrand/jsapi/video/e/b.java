package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/ContentContentTypeInferer3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContentTypeInferer;", "()V", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "inferInner", "inputStream", "Ljava/io/InputStream;", "luggage-commons-jsapi-video-ext_release"})
public final class b
  implements d
{
  public static final b pzD;
  
  static
  {
    AppMethodBeat.i(229071);
    pzD = new b();
    AppMethodBeat.o(229071);
  }
  
  /* Error */
  public final int a(com.tencent.mm.plugin.appbrand.jsapi.video.f paramf, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 51
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 53
    //   7: ldc 55
    //   9: aload_2
    //   10: invokestatic 61	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 65	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_2
    //   20: ifnonnull +10 -> 30
    //   23: ldc 51
    //   25: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_3
    //   29: ireturn
    //   30: aload_1
    //   31: ifnull +30 -> 61
    //   34: aload_1
    //   35: invokeinterface 76 1 0
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +17 -> 61
    //   47: aload 7
    //   49: invokeinterface 82 1 0
    //   54: astore 7
    //   56: aload 7
    //   58: ifnonnull +19 -> 77
    //   61: getstatic 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/j:pAg	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/j;
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 90	com/tencent/mm/plugin/appbrand/jsapi/video/e/j:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/f;Landroid/net/Uri;)I
    //   69: istore_3
    //   70: ldc 51
    //   72: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iload_3
    //   76: ireturn
    //   77: getstatic 96	com/tencent/mm/plugin/appbrand/jsapi/video/e/g:pzQ	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/g;
    //   80: astore 8
    //   82: invokestatic 100	com/tencent/mm/plugin/appbrand/jsapi/video/e/g:bWn	()Z
    //   85: ifeq +126 -> 211
    //   88: new 102	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/i
    //   91: dup
    //   92: aload 7
    //   94: aload_2
    //   95: invokespecial 105	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/i:<init>	(Lcom/google/android/exoplayer2/h/g;Landroid/net/Uri;)V
    //   98: checkcast 107	java/io/InputStream
    //   101: astore 7
    //   103: ldc 108
    //   105: newarray byte
    //   107: astore 8
    //   109: aload 7
    //   111: aload 8
    //   113: iconst_0
    //   114: sipush 1024
    //   117: invokevirtual 112	java/io/InputStream:read	([BII)I
    //   120: istore 5
    //   122: iconst_0
    //   123: istore_3
    //   124: iconst_0
    //   125: istore 4
    //   127: iload 4
    //   129: istore 6
    //   131: iconst_m1
    //   132: iload 5
    //   134: if_icmpeq +206 -> 340
    //   137: iload 4
    //   139: iload 5
    //   141: iadd
    //   142: istore 4
    //   144: new 57	java/lang/String
    //   147: dup
    //   148: aload 8
    //   150: iconst_0
    //   151: iload 4
    //   153: getstatic 118	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   156: invokespecial 121	java/lang/String:<init>	([BIILjava/nio/charset/Charset;)V
    //   159: astore 9
    //   161: iload_3
    //   162: ifne +275 -> 437
    //   165: aload 9
    //   167: ldc 123
    //   169: iconst_0
    //   170: invokestatic 129	kotlin/n/n:M	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   173: ifne +63 -> 236
    //   176: ldc 53
    //   178: ldc 131
    //   180: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iconst_3
    //   184: istore_3
    //   185: aload 7
    //   187: invokevirtual 134	java/io/InputStream:close	()V
    //   190: ldc 53
    //   192: ldc 136
    //   194: iload_3
    //   195: invokestatic 139	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   198: invokevirtual 65	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: ldc 51
    //   206: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: iload_3
    //   210: ireturn
    //   211: new 141	com/google/android/exoplayer2/h/i
    //   214: dup
    //   215: aload 7
    //   217: new 143	com/google/android/exoplayer2/h/j
    //   220: dup
    //   221: aload_2
    //   222: invokespecial 146	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;)V
    //   225: invokespecial 149	com/google/android/exoplayer2/h/i:<init>	(Lcom/google/android/exoplayer2/h/g;Lcom/google/android/exoplayer2/h/j;)V
    //   228: checkcast 107	java/io/InputStream
    //   231: astore 7
    //   233: goto -130 -> 103
    //   236: iconst_1
    //   237: istore_3
    //   238: aload 9
    //   240: checkcast 151	java/lang/CharSequence
    //   243: ldc 153
    //   245: checkcast 151	java/lang/CharSequence
    //   248: invokestatic 157	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   251: ifne +35 -> 286
    //   254: aload 9
    //   256: checkcast 151	java/lang/CharSequence
    //   259: ldc 159
    //   261: checkcast 151	java/lang/CharSequence
    //   264: invokestatic 157	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   267: ifne +19 -> 286
    //   270: aload 9
    //   272: checkcast 151	java/lang/CharSequence
    //   275: ldc 161
    //   277: checkcast 151	java/lang/CharSequence
    //   280: invokestatic 157	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   283: ifeq +23 -> 306
    //   286: ldc 53
    //   288: ldc 163
    //   290: iload 4
    //   292: invokestatic 139	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: invokevirtual 65	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iconst_2
    //   302: istore_3
    //   303: goto -118 -> 185
    //   306: ldc 108
    //   308: iload 4
    //   310: isub
    //   311: sipush 1024
    //   314: invokestatic 169	kotlin/k/i:ow	(II)I
    //   317: istore 6
    //   319: iload 6
    //   321: ifle +119 -> 440
    //   324: aload 7
    //   326: aload 8
    //   328: iload 4
    //   330: iload 6
    //   332: invokevirtual 112	java/io/InputStream:read	([BII)I
    //   335: istore 5
    //   337: goto -210 -> 127
    //   340: ldc 53
    //   342: new 171	java/lang/StringBuilder
    //   345: dup
    //   346: ldc 163
    //   348: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   351: iload 6
    //   353: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc 180
    //   358: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: iload 5
    //   363: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: iconst_3
    //   373: istore_3
    //   374: goto -189 -> 185
    //   377: astore 8
    //   379: ldc 53
    //   381: aload 8
    //   383: checkcast 189	java/lang/Throwable
    //   386: ldc 191
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: getstatic 88	com/tencent/mm/plugin/appbrand/jsapi/video/e/j:pAg	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/j;
    //   398: aload_1
    //   399: aload_2
    //   400: invokevirtual 90	com/tencent/mm/plugin/appbrand/jsapi/video/e/j:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/f;Landroid/net/Uri;)I
    //   403: istore_3
    //   404: aload 7
    //   406: invokevirtual 134	java/io/InputStream:close	()V
    //   409: goto -219 -> 190
    //   412: astore_1
    //   413: goto -223 -> 190
    //   416: astore_1
    //   417: aload 7
    //   419: invokevirtual 134	java/io/InputStream:close	()V
    //   422: ldc 51
    //   424: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_1
    //   428: athrow
    //   429: astore_1
    //   430: goto -240 -> 190
    //   433: astore_2
    //   434: goto -12 -> 422
    //   437: goto -199 -> 238
    //   440: iload 4
    //   442: istore 6
    //   444: goto -104 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	b
    //   0	447	1	paramf	com.tencent.mm.plugin.appbrand.jsapi.video.f
    //   0	447	2	paramUri	android.net.Uri
    //   69	335	3	i	int
    //   125	316	4	j	int
    //   120	242	5	k	int
    //   129	314	6	m	int
    //   40	378	7	localObject1	Object
    //   80	247	8	localObject2	Object
    //   377	5	8	localException	java.lang.Exception
    //   159	112	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   103	122	377	java/lang/Exception
    //   144	161	377	java/lang/Exception
    //   165	183	377	java/lang/Exception
    //   238	286	377	java/lang/Exception
    //   286	301	377	java/lang/Exception
    //   306	319	377	java/lang/Exception
    //   324	337	377	java/lang/Exception
    //   340	372	377	java/lang/Exception
    //   404	409	412	java/lang/Exception
    //   103	122	416	finally
    //   144	161	416	finally
    //   165	183	416	finally
    //   238	286	416	finally
    //   286	301	416	finally
    //   306	319	416	finally
    //   324	337	416	finally
    //   340	372	416	finally
    //   379	404	416	finally
    //   185	190	429	java/lang/Exception
    //   417	422	433	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b
 * JD-Core Version:    0.7.0.1
 */