package a.j.b.a.b;

import a.j.b.a.c.d.b.s;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/PackagePartProvider;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "packageParts", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/HashMap;", "visitedModules", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "findPackageParts", "", "packageFqName", "getAnnotationsOnBinaryModule", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "moduleName", "registerModule", "", "EmptyEnumeration", "descriptors.runtime"})
public final class j
  implements s
{
  private final ClassLoader BRf;
  private final HashSet<String> BRo;
  private final HashMap<String, LinkedHashSet<String>> BRp;
  
  public j(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(119056);
    this.BRf = paramClassLoader;
    this.BRo = new HashSet();
    this.BRp = new HashMap();
    AppMethodBeat.o(119056);
  }
  
  /* Error */
  public final void ak(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 86
    //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 87
    //   10: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 66	a/j/b/a/b/j:BRo	Ljava/util/HashSet;
    //   17: aload_1
    //   18: invokevirtual 91	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   21: ifne +11 -> 32
    //   24: ldc 86
    //   26: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: new 93	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 95
    //   38: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 103
    //   47: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_3
    //   54: aload_0
    //   55: getfield 61	a/j/b/a/b/j:BRf	Ljava/lang/ClassLoader;
    //   58: aload_3
    //   59: invokevirtual 113	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   62: astore_1
    //   63: aload_1
    //   64: ldc 115
    //   66: invokestatic 118	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   69: aload_1
    //   70: ldc 120
    //   72: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: new 122	a/a/n$a
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 125	a/a/n$a:<init>	(Ljava/util/Enumeration;)V
    //   83: checkcast 127	java/util/Iterator
    //   86: astore 4
    //   88: aload 4
    //   90: invokeinterface 131 1 0
    //   95: ifeq +319 -> 414
    //   98: aload 4
    //   100: invokeinterface 135 1 0
    //   105: checkcast 137	java/net/URL
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 141	java/net/URL:openStream	()Ljava/io/InputStream;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull -27 -> 88
    //   118: aload_1
    //   119: checkcast 143	java/io/Closeable
    //   122: astore 5
    //   124: aload 5
    //   126: checkcast 145	java/io/InputStream
    //   129: astore_2
    //   130: getstatic 151	a/j/b/a/c/e/b/a/k:Cqx	La/j/b/a/c/e/b/a/k$a;
    //   133: astore_1
    //   134: aload_2
    //   135: ldc 120
    //   137: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   140: new 153	java/io/ByteArrayOutputStream
    //   143: dup
    //   144: sipush 8192
    //   147: aload_2
    //   148: invokevirtual 157	java/io/InputStream:available	()I
    //   151: invokestatic 163	java/lang/Math:max	(II)I
    //   154: invokespecial 165	java/io/ByteArrayOutputStream:<init>	(I)V
    //   157: astore 6
    //   159: aload_2
    //   160: aload 6
    //   162: checkcast 167	java/io/OutputStream
    //   165: invokestatic 173	a/e/a:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   168: pop2
    //   169: aload 6
    //   171: invokevirtual 177	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   174: astore_2
    //   175: aload_2
    //   176: ldc 179
    //   178: invokestatic 118	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   181: getstatic 185	a/j/b/a/c/j/a/j$a:CyP	La/j/b/a/c/j/a/j$a;
    //   184: checkcast 187	a/j/b/a/c/j/a/j
    //   187: astore 6
    //   189: getstatic 193	a/j/b/a/b/j$b:BRr	La/j/b/a/b/j$b;
    //   192: checkcast 195	a/f/a/b
    //   195: astore 7
    //   197: aload_1
    //   198: ldc 120
    //   200: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc 197
    //   206: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   209: aload 6
    //   211: ldc 199
    //   213: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   216: aload 7
    //   218: ldc 201
    //   220: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   223: aload_2
    //   224: aload_3
    //   225: aload 7
    //   227: invokestatic 207	a/j/b/a/c/e/b/a/k$a:a	([BLjava/lang/String;La/f/a/b;)La/j/b/a/c/e/b/a/k;
    //   230: getfield 211	a/j/b/a/c/e/b/a/k:Cqs	Ljava/util/Map;
    //   233: invokeinterface 217 1 0
    //   238: invokeinterface 223 1 0
    //   243: astore_2
    //   244: aload_2
    //   245: invokeinterface 131 1 0
    //   250: ifeq +147 -> 397
    //   253: aload_2
    //   254: invokeinterface 135 1 0
    //   259: checkcast 225	java/util/Map$Entry
    //   262: astore_1
    //   263: aload_1
    //   264: invokeinterface 228 1 0
    //   269: checkcast 230	java/lang/String
    //   272: astore 7
    //   274: aload_1
    //   275: invokeinterface 233 1 0
    //   280: checkcast 235	a/j/b/a/c/e/b/a/m
    //   283: astore 6
    //   285: aload_0
    //   286: getfield 71	a/j/b/a/b/j:BRp	Ljava/util/HashMap;
    //   289: checkcast 213	java/util/Map
    //   292: astore 8
    //   294: aload 8
    //   296: aload 7
    //   298: invokeinterface 239 2 0
    //   303: astore_1
    //   304: aload_1
    //   305: ifnonnull +123 -> 428
    //   308: new 241	java/util/LinkedHashSet
    //   311: dup
    //   312: invokespecial 242	java/util/LinkedHashSet:<init>	()V
    //   315: astore_1
    //   316: aload 8
    //   318: aload 7
    //   320: aload_1
    //   321: invokeinterface 246 3 0
    //   326: pop
    //   327: aload_1
    //   328: checkcast 241	java/util/LinkedHashSet
    //   331: aload 6
    //   333: invokevirtual 249	a/j/b/a/c/e/b/a/m:elY	()Ljava/util/Set;
    //   336: checkcast 251	java/util/Collection
    //   339: invokevirtual 255	java/util/LinkedHashSet:addAll	(Ljava/util/Collection;)Z
    //   342: pop
    //   343: goto -99 -> 244
    //   346: astore_2
    //   347: ldc 86
    //   349: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_2
    //   353: athrow
    //   354: astore_1
    //   355: aload 5
    //   357: aload_2
    //   358: invokestatic 260	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   361: ldc 86
    //   363: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_1
    //   369: aload_1
    //   370: checkcast 85	java/lang/Throwable
    //   373: astore_1
    //   374: ldc 86
    //   376: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: aload_0
    //   383: monitorexit
    //   384: aload_1
    //   385: athrow
    //   386: astore_1
    //   387: getstatic 264	a/j/b/a/b/j$a:BRq	La/j/b/a/b/j$a;
    //   390: checkcast 266	java/util/Enumeration
    //   393: astore_1
    //   394: goto -331 -> 63
    //   397: getstatic 272	a/y:BMg	La/y;
    //   400: astore_1
    //   401: aload 5
    //   403: aconst_null
    //   404: invokestatic 260	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   407: goto -319 -> 88
    //   410: astore_1
    //   411: goto -323 -> 88
    //   414: ldc 86
    //   416: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: goto -390 -> 29
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: goto -70 -> 355
    //   428: goto -101 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	j
    //   0	431	1	paramString	String
    //   129	125	2	localObject1	Object
    //   346	12	2	localThrowable	java.lang.Throwable
    //   424	1	2	localObject2	Object
    //   53	172	3	str	String
    //   86	13	4	localIterator	java.util.Iterator
    //   122	280	5	localCloseable	java.io.Closeable
    //   157	175	6	localObject3	Object
    //   195	124	7	localObject4	Object
    //   292	25	8	localMap	java.util.Map
    // Exception table:
    //   from	to	target	type
    //   124	244	346	java/lang/Throwable
    //   244	304	346	java/lang/Throwable
    //   308	327	346	java/lang/Throwable
    //   327	343	346	java/lang/Throwable
    //   397	401	346	java/lang/Throwable
    //   347	354	354	finally
    //   109	114	368	java/lang/UnsupportedOperationException
    //   118	124	368	java/lang/UnsupportedOperationException
    //   355	368	368	java/lang/UnsupportedOperationException
    //   401	407	368	java/lang/UnsupportedOperationException
    //   2	29	381	finally
    //   32	54	381	finally
    //   54	63	381	finally
    //   63	88	381	finally
    //   88	109	381	finally
    //   109	114	381	finally
    //   118	124	381	finally
    //   355	368	381	finally
    //   369	381	381	finally
    //   387	394	381	finally
    //   401	407	381	finally
    //   414	419	381	finally
    //   54	63	386	java/io/IOException
    //   109	114	410	java/lang/Exception
    //   118	124	410	java/lang/Exception
    //   355	368	410	java/lang/Exception
    //   401	407	410	java/lang/Exception
    //   124	244	422	finally
    //   244	304	422	finally
    //   308	327	422	finally
    //   327	343	422	finally
    //   397	401	422	finally
  }
  
  /* Error */
  public final java.util.List<String> ayw(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 275
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 276
    //   12: invokestatic 49	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 71	a/j/b/a/b/j:BRp	Ljava/util/HashMap;
    //   19: aload_1
    //   20: invokevirtual 277	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 241	java/util/LinkedHashSet
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +34 -> 62
    //   31: aload_1
    //   32: checkcast 279	java/lang/Iterable
    //   35: invokestatic 285	a/a/j:m	(Ljava/lang/Iterable;)Ljava/util/List;
    //   38: astore_1
    //   39: aload_1
    //   40: astore_2
    //   41: aload_1
    //   42: ifnonnull +10 -> 52
    //   45: getstatic 291	a/a/v:BMx	La/a/v;
    //   48: checkcast 293	java/util/List
    //   51: astore_2
    //   52: ldc_w 275
    //   55: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -25 -> 39
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	j
    //   0	72	1	paramString	String
    //   40	21	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	67	finally
    //   31	39	67	finally
    //   45	52	67	finally
    //   52	58	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.b.j
 * JD-Core Version:    0.7.0.1
 */