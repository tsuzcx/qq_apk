package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class cb
{
  static
  {
    AppMethodBeat.i(90671);
    cb.class.getClassLoader();
    j.KW("wechatzstd");
    AppMethodBeat.o(90671);
  }
  
  public static void a(ca paramca, af.a parama)
  {
    AppMethodBeat.i(90668);
    bm localbm = ((e)h.ae(e.class)).bFb();
    if (localbm == null)
    {
      bq.a(paramca.QYU, paramca.appId, b.a.a.nIM, null);
      AppMethodBeat.o(90668);
      return;
    }
    parama.bGv();
    boolean bool = a(paramca);
    parama.hq(bool);
    Log.i("MicroMsg.AppBrand.ZstdLogic", "processZstd, appId:%s, success:%b", new Object[] { paramca.appId, Boolean.valueOf(bool) });
    if (bool)
    {
      bq.a(paramca.QYU, paramca.appId, paramca.bHM(), paramca.pkgVersion, paramca.fES, parama);
      AppMethodBeat.o(90668);
      return;
    }
    u.deleteFile(paramca.bHM());
    parama = localbm.b(paramca.appId, paramca.pkgVersion, paramca.fES, new String[] { "downloadURL" });
    if (parama == null)
    {
      bq.a(paramca.QYU, paramca.appId, b.a.a.nIM, null);
      AppMethodBeat.o(90668);
      return;
    }
    bq.ade(paramca.QYU);
    bq.c(paramca.appId, paramca.fES, paramca.pkgVersion, parama.field_downloadURL, paramca.nGp);
    AppMethodBeat.o(90668);
  }
  
  public static void a(ca paramca, l paraml, af.a parama)
  {
    AppMethodBeat.i(90669);
    Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", new Object[] { paramca.appId, Integer.valueOf(paramca.pkgVersion) });
    parama.a(paraml);
    paraml = ((e)h.ae(e.class)).bFb();
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil storage");
      bq.a(paramca.QYU, paramca.appId, b.a.a.nIM, null);
      AppMethodBeat.o(90669);
      return;
    }
    bq.ade(paramca.QYU);
    if (!(paramca.nGp instanceof b.c))
    {
      paramca.nGp.a(paramca.appId, b.a.a.nIG, null);
      AppMethodBeat.o(90669);
      return;
    }
    paraml = paraml.b(paramca.appId, paramca.pkgVersion, paramca.fES, new String[] { "downloadURL" });
    if (paraml == null)
    {
      Log.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { paramca.appId, Integer.valueOf(paramca.pkgVersion) });
      AppMethodBeat.o(90669);
      return;
    }
    if (!bq.c(paramca.appId, paramca.fES, paramca.pkgVersion, paraml.field_downloadURL, paramca.nGp)) {
      paramca.nGp.a(paramca.appId, b.a.a.nIM, null);
    }
    AppMethodBeat.o(90669);
  }
  
  /* Error */
  private static boolean a(ca paramca)
  {
    // Byte code:
    //   0: ldc 182
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 185	com/tencent/mm/plugin/appbrand/appcache/ca:getFilePath	()Ljava/lang/String;
    //   9: astore 5
    //   11: new 187	com/tencent/mm/vfs/q
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 189	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 193	com/tencent/mm/vfs/q:ifE	()Z
    //   25: ifne +17 -> 42
    //   28: ldc 85
    //   30: ldc 195
    //   32: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 182
    //   37: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 187	com/tencent/mm/vfs/q
    //   45: dup
    //   46: aload_0
    //   47: invokevirtual 102	com/tencent/mm/plugin/appbrand/appcache/ca:bHM	()Ljava/lang/String;
    //   50: invokespecial 189	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 193	com/tencent/mm/vfs/q:ifE	()Z
    //   58: ifeq +24 -> 82
    //   61: aload_0
    //   62: invokevirtual 198	com/tencent/mm/vfs/q:cFq	()Z
    //   65: ifne +17 -> 82
    //   68: ldc 85
    //   70: ldc 200
    //   72: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc 182
    //   77: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: new 202	com/tencent/mars/zstd/ZstdInputStream
    //   85: dup
    //   86: aload_2
    //   87: invokevirtual 205	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   90: invokestatic 209	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   93: invokespecial 212	com/tencent/mars/zstd/ZstdInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore_2
    //   97: aload_0
    //   98: invokestatic 216	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   101: astore_0
    //   102: aload_0
    //   103: astore 4
    //   105: aload_2
    //   106: astore_3
    //   107: sipush 8192
    //   110: newarray byte
    //   112: astore 6
    //   114: aload_0
    //   115: astore 4
    //   117: aload_2
    //   118: astore_3
    //   119: aload_2
    //   120: aload 6
    //   122: iconst_0
    //   123: sipush 8192
    //   126: invokevirtual 220	com/tencent/mars/zstd/ZstdInputStream:read	([BII)I
    //   129: istore_1
    //   130: iload_1
    //   131: iconst_m1
    //   132: if_icmpeq +65 -> 197
    //   135: aload_0
    //   136: astore 4
    //   138: aload_2
    //   139: astore_3
    //   140: aload_0
    //   141: aload 6
    //   143: iconst_0
    //   144: iload_1
    //   145: invokevirtual 226	java/io/OutputStream:write	([BII)V
    //   148: goto -34 -> 114
    //   151: astore 5
    //   153: aload_0
    //   154: astore 4
    //   156: aload_2
    //   157: astore_3
    //   158: ldc 85
    //   160: ldc 228
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload 5
    //   170: aastore
    //   171: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 231	java/io/OutputStream:close	()V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 232	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   190: ldc 182
    //   192: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: ireturn
    //   197: aload_0
    //   198: astore 4
    //   200: aload_2
    //   201: astore_3
    //   202: aload_0
    //   203: invokevirtual 235	java/io/OutputStream:flush	()V
    //   206: aload_0
    //   207: astore 4
    //   209: aload_2
    //   210: astore_3
    //   211: aload 5
    //   213: invokestatic 118	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   216: pop
    //   217: aload_0
    //   218: ifnull +7 -> 225
    //   221: aload_0
    //   222: invokevirtual 231	java/io/OutputStream:close	()V
    //   225: aload_2
    //   226: invokevirtual 232	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   229: ldc 182
    //   231: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: iconst_1
    //   235: ireturn
    //   236: astore_0
    //   237: aconst_null
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_2
    //   242: aload 4
    //   244: ifnull +8 -> 252
    //   247: aload 4
    //   249: invokevirtual 231	java/io/OutputStream:close	()V
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 232	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   260: ldc 182
    //   262: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_0
    //   266: athrow
    //   267: astore_0
    //   268: goto -43 -> 225
    //   271: astore_0
    //   272: goto -43 -> 229
    //   275: astore_0
    //   276: goto -94 -> 182
    //   279: astore_0
    //   280: goto -90 -> 190
    //   283: astore_3
    //   284: goto -32 -> 252
    //   287: astore_2
    //   288: goto -28 -> 260
    //   291: astore_0
    //   292: aconst_null
    //   293: astore 4
    //   295: goto -53 -> 242
    //   298: astore_0
    //   299: aload_3
    //   300: astore_2
    //   301: goto -59 -> 242
    //   304: astore 5
    //   306: aconst_null
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_2
    //   310: goto -157 -> 153
    //   313: astore 5
    //   315: aconst_null
    //   316: astore_0
    //   317: goto -164 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramca	ca
    //   129	16	1	i	int
    //   20	237	2	localObject1	Object
    //   287	1	2	localIOException1	java.io.IOException
    //   300	10	2	localObject2	Object
    //   106	105	3	localObject3	Object
    //   283	17	3	localIOException2	java.io.IOException
    //   103	191	4	localca	ca
    //   9	7	5	str	String
    //   151	61	5	localException1	java.lang.Exception
    //   304	1	5	localException2	java.lang.Exception
    //   313	1	5	localException3	java.lang.Exception
    //   112	30	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	114	151	java/lang/Exception
    //   119	130	151	java/lang/Exception
    //   140	148	151	java/lang/Exception
    //   202	206	151	java/lang/Exception
    //   211	217	151	java/lang/Exception
    //   82	97	236	finally
    //   221	225	267	java/io/IOException
    //   225	229	271	java/io/IOException
    //   178	182	275	java/io/IOException
    //   186	190	279	java/io/IOException
    //   247	252	283	java/io/IOException
    //   256	260	287	java/io/IOException
    //   97	102	291	finally
    //   107	114	298	finally
    //   119	130	298	finally
    //   140	148	298	finally
    //   158	174	298	finally
    //   202	206	298	finally
    //   211	217	298	finally
    //   82	97	304	java/lang/Exception
    //   97	102	313	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, bq.a parama)
  {
    AppMethodBeat.i(90667);
    boolean bool = bq.a(new ca(paramString1, paramString2, paramInt1, paramInt2, parama), parama);
    AppMethodBeat.o(90667);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.cb
 * JD-Core Version:    0.7.0.1
 */