package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class be
{
  public static void a(bd parambd, m paramm, z.a parama)
  {
    AppMethodBeat.i(59551);
    ab.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", new Object[] { parambd.appId, Integer.valueOf(parambd.gXf) });
    parama.a(paramm);
    paramm = ((d)g.E(d.class)).we();
    if (paramm == null)
    {
      ab.e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil storage");
      ba.a(parambd.vMK, parambd.appId, b.a.a.gXs, null);
      AppMethodBeat.o(59551);
      return;
    }
    ba.yI(parambd.vMK);
    paramm = paramm.a(parambd.appId, parambd.gXf, parambd.cvs, new String[] { "downloadURL" });
    if (paramm == null)
    {
      ab.e("MicroMsg.AppBrand.ZstdLogic", "onIncrementalPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { parambd.appId, Integer.valueOf(parambd.gXf) });
      AppMethodBeat.o(59551);
      return;
    }
    ba.b(parambd.appId, parambd.cvs, parambd.gXf, paramm.field_downloadURL, parambd.gVA);
    AppMethodBeat.o(59551);
  }
  
  /* Error */
  static boolean a(bd parambd)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 122	com/tencent/mm/plugin/appbrand/appcache/bd:getFilePath	()Ljava/lang/String;
    //   9: astore 5
    //   11: new 124	java/io/File
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 132	java/io/File:exists	()Z
    //   25: ifne +17 -> 42
    //   28: ldc 15
    //   30: ldc 134
    //   32: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 118
    //   37: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 124	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: invokevirtual 137	com/tencent/mm/plugin/appbrand/appcache/bd:awk	()Ljava/lang/String;
    //   50: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 132	java/io/File:exists	()Z
    //   58: ifeq +24 -> 82
    //   61: aload_0
    //   62: invokevirtual 140	java/io/File:delete	()Z
    //   65: ifne +17 -> 82
    //   68: ldc 15
    //   70: ldc 142
    //   72: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc 118
    //   77: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: new 144	com/tencent/mars/zstd/ZstdInputStream
    //   85: dup
    //   86: new 146	java/io/FileInputStream
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 149	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 152	com/tencent/mars/zstd/ZstdInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore_2
    //   98: new 154	java/io/FileOutputStream
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore 4
    //   110: aload_2
    //   111: astore_3
    //   112: sipush 8192
    //   115: newarray byte
    //   117: astore 6
    //   119: aload_0
    //   120: astore 4
    //   122: aload_2
    //   123: astore_3
    //   124: aload_2
    //   125: aload 6
    //   127: iconst_0
    //   128: sipush 8192
    //   131: invokevirtual 159	com/tencent/mars/zstd/ZstdInputStream:read	([BII)I
    //   134: istore_1
    //   135: iload_1
    //   136: iconst_m1
    //   137: if_icmpeq +65 -> 202
    //   140: aload_0
    //   141: astore 4
    //   143: aload_2
    //   144: astore_3
    //   145: aload_0
    //   146: aload 6
    //   148: iconst_0
    //   149: iload_1
    //   150: invokevirtual 163	java/io/FileOutputStream:write	([BII)V
    //   153: goto -34 -> 119
    //   156: astore 5
    //   158: aload_0
    //   159: astore 4
    //   161: aload_2
    //   162: astore_3
    //   163: ldc 15
    //   165: ldc 165
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 5
    //   175: aastore
    //   176: invokestatic 39	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 169	java/io/FileOutputStream:close	()V
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 170	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   195: ldc 118
    //   197: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iconst_0
    //   201: ireturn
    //   202: aload_0
    //   203: astore 4
    //   205: aload_2
    //   206: astore_3
    //   207: aload_0
    //   208: invokevirtual 173	java/io/FileOutputStream:flush	()V
    //   211: aload_0
    //   212: astore 4
    //   214: aload_2
    //   215: astore_3
    //   216: aload 5
    //   218: invokestatic 179	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   221: pop
    //   222: aload_0
    //   223: invokevirtual 169	java/io/FileOutputStream:close	()V
    //   226: aload_2
    //   227: invokevirtual 170	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   230: ldc 118
    //   232: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: iconst_1
    //   236: ireturn
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_2
    //   243: aload 4
    //   245: ifnull +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 169	java/io/FileOutputStream:close	()V
    //   253: aload_2
    //   254: ifnull +7 -> 261
    //   257: aload_2
    //   258: invokevirtual 170	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   261: ldc 118
    //   263: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: goto -43 -> 226
    //   272: astore_0
    //   273: goto -43 -> 230
    //   276: astore_0
    //   277: goto -90 -> 187
    //   280: astore_0
    //   281: goto -86 -> 195
    //   284: astore_3
    //   285: goto -32 -> 253
    //   288: astore_2
    //   289: goto -28 -> 261
    //   292: astore_0
    //   293: aconst_null
    //   294: astore 4
    //   296: goto -53 -> 243
    //   299: astore_0
    //   300: aload_3
    //   301: astore_2
    //   302: goto -59 -> 243
    //   305: astore 5
    //   307: aconst_null
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_2
    //   311: goto -153 -> 158
    //   314: astore 5
    //   316: aconst_null
    //   317: astore_0
    //   318: goto -160 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	parambd	bd
    //   134	16	1	i	int
    //   20	238	2	localObject1	Object
    //   288	1	2	localIOException1	java.io.IOException
    //   301	10	2	localObject2	Object
    //   111	105	3	localObject3	Object
    //   284	17	3	localIOException2	java.io.IOException
    //   108	187	4	localbd	bd
    //   9	7	5	str	String
    //   156	61	5	localException1	java.lang.Exception
    //   305	1	5	localException2	java.lang.Exception
    //   314	1	5	localException3	java.lang.Exception
    //   117	30	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   112	119	156	java/lang/Exception
    //   124	135	156	java/lang/Exception
    //   145	153	156	java/lang/Exception
    //   207	211	156	java/lang/Exception
    //   216	222	156	java/lang/Exception
    //   82	98	237	finally
    //   222	226	268	java/io/IOException
    //   226	230	272	java/io/IOException
    //   183	187	276	java/io/IOException
    //   191	195	280	java/io/IOException
    //   248	253	284	java/io/IOException
    //   257	261	288	java/io/IOException
    //   98	107	292	finally
    //   112	119	299	finally
    //   124	135	299	finally
    //   145	153	299	finally
    //   163	179	299	finally
    //   207	211	299	finally
    //   216	222	299	finally
    //   82	98	305	java/lang/Exception
    //   98	107	314	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, ba.a parama)
  {
    AppMethodBeat.i(59550);
    boolean bool = ba.a(new bd(paramString1, paramString2, paramInt1, paramInt2, parama), parama);
    AppMethodBeat.o(59550);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.be
 * JD-Core Version:    0.7.0.1
 */