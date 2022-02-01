package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ContentContentTypeInferer3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", "uri", "Landroid/net/Uri;", "inferInner", "inputStream", "Lcom/google/android/exoplayer2/upstream/DataSourceInputStream;", "luggage-commons-jsapi-video-ext_release"})
public final class c
  implements h
{
  public static final c mBV;
  
  static
  {
    AppMethodBeat.i(235241);
    mBV = new c();
    AppMethodBeat.o(235241);
  }
  
  /* Error */
  public final int r(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 51
    //   7: ldc 53
    //   9: aload_1
    //   10: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnonnull +10 -> 30
    //   23: ldc 49
    //   25: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_3
    //   29: ireturn
    //   30: invokestatic 74	com/tencent/mm/plugin/appbrand/jsapi/video/c:bJr	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/c;
    //   33: astore 6
    //   35: aload 6
    //   37: ldc 76
    //   39: invokestatic 82	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 6
    //   44: invokevirtual 86	com/tencent/mm/plugin/appbrand/jsapi/video/c:bJs	()Lcom/google/android/exoplayer2/h/g$a;
    //   47: astore 6
    //   49: aload 6
    //   51: ifnull +17 -> 68
    //   54: aload 6
    //   56: invokeinterface 92 1 0
    //   61: astore 6
    //   63: aload 6
    //   65: ifnonnull +18 -> 83
    //   68: getstatic 98	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/l:mCK	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/b/l;
    //   71: aload_1
    //   72: invokevirtual 100	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/l:r	(Landroid/net/Uri;)I
    //   75: istore_2
    //   76: ldc 49
    //   78: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_2
    //   82: ireturn
    //   83: new 102	com/google/android/exoplayer2/h/i
    //   86: dup
    //   87: aload 6
    //   89: new 104	com/google/android/exoplayer2/h/j
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 107	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;)V
    //   97: invokespecial 110	com/google/android/exoplayer2/h/i:<init>	(Lcom/google/android/exoplayer2/h/g;Lcom/google/android/exoplayer2/h/j;)V
    //   100: astore 6
    //   102: ldc 111
    //   104: newarray byte
    //   106: astore 7
    //   108: aload 6
    //   110: aload 7
    //   112: iconst_0
    //   113: sipush 512
    //   116: invokevirtual 115	com/google/android/exoplayer2/h/i:read	([BII)I
    //   119: istore 4
    //   121: iconst_0
    //   122: istore_2
    //   123: iconst_0
    //   124: istore_3
    //   125: iload_3
    //   126: istore 5
    //   128: iconst_m1
    //   129: iload 4
    //   131: if_icmpeq +169 -> 300
    //   134: iload_3
    //   135: iload 4
    //   137: iadd
    //   138: istore_3
    //   139: new 55	java/lang/String
    //   142: dup
    //   143: aload 7
    //   145: iconst_0
    //   146: iload_3
    //   147: getstatic 121	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   150: invokespecial 124	java/lang/String:<init>	([BIILjava/nio/charset/Charset;)V
    //   153: astore 8
    //   155: iload_2
    //   156: ifne +240 -> 396
    //   159: aload 8
    //   161: ldc 126
    //   163: iconst_0
    //   164: invokestatic 132	kotlin/n/n:J	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   167: ifne +38 -> 205
    //   170: ldc 51
    //   172: ldc 134
    //   174: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iconst_3
    //   178: istore_2
    //   179: aload 6
    //   181: invokevirtual 137	com/google/android/exoplayer2/h/i:close	()V
    //   184: ldc 51
    //   186: ldc 139
    //   188: iload_2
    //   189: invokestatic 142	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   192: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: ldc 49
    //   200: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iload_2
    //   204: ireturn
    //   205: iconst_1
    //   206: istore_2
    //   207: aload 8
    //   209: checkcast 144	java/lang/CharSequence
    //   212: ldc 146
    //   214: checkcast 144	java/lang/CharSequence
    //   217: invokestatic 150	kotlin/n/n:e	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   220: ifne +35 -> 255
    //   223: aload 8
    //   225: checkcast 144	java/lang/CharSequence
    //   228: ldc 152
    //   230: checkcast 144	java/lang/CharSequence
    //   233: invokestatic 150	kotlin/n/n:e	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   236: ifne +19 -> 255
    //   239: aload 8
    //   241: checkcast 144	java/lang/CharSequence
    //   244: ldc 154
    //   246: checkcast 144	java/lang/CharSequence
    //   249: invokestatic 150	kotlin/n/n:e	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   252: ifeq +22 -> 274
    //   255: ldc 51
    //   257: ldc 156
    //   259: iload_3
    //   260: invokestatic 142	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   263: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   266: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: iconst_2
    //   270: istore_2
    //   271: goto -92 -> 179
    //   274: ldc 111
    //   276: iload_3
    //   277: isub
    //   278: istore 5
    //   280: iload 5
    //   282: ifle +117 -> 399
    //   285: aload 6
    //   287: aload 7
    //   289: iload_3
    //   290: iload 5
    //   292: invokevirtual 115	com/google/android/exoplayer2/h/i:read	([BII)I
    //   295: istore 4
    //   297: goto -172 -> 125
    //   300: ldc 51
    //   302: new 158	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 156
    //   308: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: iload 5
    //   313: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: ldc 167
    //   318: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload 4
    //   323: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: iconst_3
    //   333: istore_2
    //   334: goto -155 -> 179
    //   337: astore 7
    //   339: ldc 51
    //   341: ldc 176
    //   343: aload 7
    //   345: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   348: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   351: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: getstatic 98	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/l:mCK	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/b/l;
    //   357: aload_1
    //   358: invokevirtual 100	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/l:r	(Landroid/net/Uri;)I
    //   361: istore_2
    //   362: aload 6
    //   364: invokevirtual 137	com/google/android/exoplayer2/h/i:close	()V
    //   367: goto -183 -> 184
    //   370: astore_1
    //   371: goto -187 -> 184
    //   374: astore_1
    //   375: aload 6
    //   377: invokevirtual 137	com/google/android/exoplayer2/h/i:close	()V
    //   380: ldc 49
    //   382: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aload_1
    //   386: athrow
    //   387: astore_1
    //   388: goto -204 -> 184
    //   391: astore 6
    //   393: goto -13 -> 380
    //   396: goto -189 -> 207
    //   399: iload_3
    //   400: istore 5
    //   402: goto -102 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	c
    //   0	405	1	paramUri	android.net.Uri
    //   75	287	2	i	int
    //   124	276	3	j	int
    //   119	203	4	k	int
    //   126	275	5	m	int
    //   33	343	6	localObject	Object
    //   391	1	6	localException1	java.lang.Exception
    //   106	182	7	arrayOfByte	byte[]
    //   337	7	7	localException2	java.lang.Exception
    //   153	87	8	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   102	121	337	java/lang/Exception
    //   139	155	337	java/lang/Exception
    //   159	177	337	java/lang/Exception
    //   207	255	337	java/lang/Exception
    //   255	269	337	java/lang/Exception
    //   285	297	337	java/lang/Exception
    //   300	332	337	java/lang/Exception
    //   362	367	370	java/lang/Exception
    //   102	121	374	finally
    //   139	155	374	finally
    //   159	177	374	finally
    //   207	255	374	finally
    //   255	269	374	finally
    //   285	297	374	finally
    //   300	332	374	finally
    //   339	362	374	finally
    //   179	184	387	java/lang/Exception
    //   375	380	391	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c
 * JD-Core Version:    0.7.0.1
 */