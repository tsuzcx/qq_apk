package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;

public final class bt
{
  static
  {
    AppMethodBeat.i(90671);
    bt.class.getClassLoader();
    j.vN("wechatzstd");
    AppMethodBeat.o(90671);
  }
  
  public static void a(bs parambs, ae.a parama)
  {
    AppMethodBeat.i(90668);
    bh localbh = ((e)g.ab(e.class)).aYP();
    if (localbh == null)
    {
      bj.a(parambs.Fhz, parambs.appId, b.a.a.jMF, null);
      AppMethodBeat.o(90668);
      return;
    }
    parama.aZY();
    boolean bool = a(parambs);
    parama.fJ(bool);
    ae.i("MicroMsg.AppBrand.ZstdLogic", "processZstd suc:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      bj.a(parambs.Fhz, parambs.appId, parambs.bbp(), parambs.pkgVersion, parambs.duK, parama);
      AppMethodBeat.o(90668);
      return;
    }
    o.deleteFile(parambs.bbp());
    parama = localbh.a(parambs.appId, parambs.pkgVersion, parambs.duK, new String[] { "downloadURL" });
    if (parama == null)
    {
      bj.a(parambs.Fhz, parambs.appId, b.a.a.jMF, null);
      AppMethodBeat.o(90668);
      return;
    }
    bj.Ml(parambs.Fhz);
    bj.b(parambs.appId, parambs.duK, parambs.pkgVersion, parama.field_downloadURL, parambs.jKw);
    AppMethodBeat.o(90668);
  }
  
  public static void a(bs parambs, m paramm, ae.a parama)
  {
    AppMethodBeat.i(90669);
    ae.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, request(%s %d)", new Object[] { parambs.appId, Integer.valueOf(parambs.pkgVersion) });
    parama.a(paramm);
    paramm = ((e)g.ab(e.class)).aYP();
    if (paramm == null)
    {
      ae.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil storage");
      bj.a(parambs.Fhz, parambs.appId, b.a.a.jMF, null);
      AppMethodBeat.o(90669);
      return;
    }
    bj.Ml(parambs.Fhz);
    if ((parambs.jKw instanceof b.c))
    {
      ((b.c)parambs.jKw).bbr();
      paramm = paramm.a(parambs.appId, parambs.pkgVersion, parambs.duK, new String[] { "downloadURL" });
      if (paramm == null)
      {
        ae.e("MicroMsg.AppBrand.ZstdLogic", "onZstdPkgDownloadFail, before fallback full_pkg, nil record(%s %d)", new Object[] { parambs.appId, Integer.valueOf(parambs.pkgVersion) });
        AppMethodBeat.o(90669);
      }
    }
    else
    {
      parambs.jKw.a(parambs.appId, b.a.a.jMz, null);
      AppMethodBeat.o(90669);
      return;
    }
    if (!bj.b(parambs.appId, parambs.duK, parambs.pkgVersion, paramm.field_downloadURL, parambs.jKw)) {
      parambs.jKw.a(parambs.appId, b.a.a.jMF, null);
    }
    AppMethodBeat.o(90669);
  }
  
  /* Error */
  private static boolean a(bs parambs)
  {
    // Byte code:
    //   0: ldc 184
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 187	com/tencent/mm/plugin/appbrand/appcache/bs:getFilePath	()Ljava/lang/String;
    //   9: astore 5
    //   11: new 189	com/tencent/mm/vfs/k
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 191	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 195	com/tencent/mm/vfs/k:exists	()Z
    //   25: ifne +17 -> 42
    //   28: ldc 85
    //   30: ldc 197
    //   32: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 184
    //   37: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 189	com/tencent/mm/vfs/k
    //   45: dup
    //   46: aload_0
    //   47: invokevirtual 102	com/tencent/mm/plugin/appbrand/appcache/bs:bbp	()Ljava/lang/String;
    //   50: invokespecial 191	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 195	com/tencent/mm/vfs/k:exists	()Z
    //   58: ifeq +24 -> 82
    //   61: aload_0
    //   62: invokevirtual 200	com/tencent/mm/vfs/k:delete	()Z
    //   65: ifne +17 -> 82
    //   68: ldc 85
    //   70: ldc 202
    //   72: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc 184
    //   77: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: new 204	com/tencent/mars/zstd/ZstdInputStream
    //   85: dup
    //   86: aload_2
    //   87: getfield 208	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   90: invokestatic 214	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   93: invokestatic 218	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   96: invokespecial 221	com/tencent/mars/zstd/ZstdInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore_2
    //   100: aload_0
    //   101: invokestatic 225	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   104: astore_0
    //   105: aload_0
    //   106: astore 4
    //   108: aload_2
    //   109: astore_3
    //   110: sipush 8192
    //   113: newarray byte
    //   115: astore 6
    //   117: aload_0
    //   118: astore 4
    //   120: aload_2
    //   121: astore_3
    //   122: aload_2
    //   123: aload 6
    //   125: iconst_0
    //   126: sipush 8192
    //   129: invokevirtual 229	com/tencent/mars/zstd/ZstdInputStream:read	([BII)I
    //   132: istore_1
    //   133: iload_1
    //   134: iconst_m1
    //   135: if_icmpeq +65 -> 200
    //   138: aload_0
    //   139: astore 4
    //   141: aload_2
    //   142: astore_3
    //   143: aload_0
    //   144: aload 6
    //   146: iconst_0
    //   147: iload_1
    //   148: invokevirtual 235	java/io/OutputStream:write	([BII)V
    //   151: goto -34 -> 117
    //   154: astore 5
    //   156: aload_0
    //   157: astore 4
    //   159: aload_2
    //   160: astore_3
    //   161: ldc 85
    //   163: ldc 237
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload 5
    //   173: aastore
    //   174: invokestatic 156	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: ifnull +7 -> 185
    //   181: aload_0
    //   182: invokevirtual 240	java/io/OutputStream:close	()V
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 241	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   193: ldc 184
    //   195: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: iconst_0
    //   199: ireturn
    //   200: aload_0
    //   201: astore 4
    //   203: aload_2
    //   204: astore_3
    //   205: aload_0
    //   206: invokevirtual 244	java/io/OutputStream:flush	()V
    //   209: aload_0
    //   210: astore 4
    //   212: aload_2
    //   213: astore_3
    //   214: aload 5
    //   216: invokestatic 118	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   219: pop
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 240	java/io/OutputStream:close	()V
    //   228: aload_2
    //   229: invokevirtual 241	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   232: ldc 184
    //   234: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: iconst_1
    //   238: ireturn
    //   239: astore_0
    //   240: aconst_null
    //   241: astore 4
    //   243: aconst_null
    //   244: astore_2
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 240	java/io/OutputStream:close	()V
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 241	com/tencent/mars/zstd/ZstdInputStream:close	()V
    //   263: ldc 184
    //   265: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: goto -43 -> 228
    //   274: astore_0
    //   275: goto -43 -> 232
    //   278: astore_0
    //   279: goto -94 -> 185
    //   282: astore_0
    //   283: goto -90 -> 193
    //   286: astore_3
    //   287: goto -32 -> 255
    //   290: astore_2
    //   291: goto -28 -> 263
    //   294: astore_0
    //   295: aconst_null
    //   296: astore 4
    //   298: goto -53 -> 245
    //   301: astore_0
    //   302: aload_3
    //   303: astore_2
    //   304: goto -59 -> 245
    //   307: astore 5
    //   309: aconst_null
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_2
    //   313: goto -157 -> 156
    //   316: astore 5
    //   318: aconst_null
    //   319: astore_0
    //   320: goto -164 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	parambs	bs
    //   132	16	1	i	int
    //   20	240	2	localObject1	Object
    //   290	1	2	localIOException1	java.io.IOException
    //   303	10	2	localObject2	Object
    //   109	105	3	localObject3	Object
    //   286	17	3	localIOException2	java.io.IOException
    //   106	191	4	localbs	bs
    //   9	7	5	str	String
    //   154	61	5	localException1	java.lang.Exception
    //   307	1	5	localException2	java.lang.Exception
    //   316	1	5	localException3	java.lang.Exception
    //   115	30	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	117	154	java/lang/Exception
    //   122	133	154	java/lang/Exception
    //   143	151	154	java/lang/Exception
    //   205	209	154	java/lang/Exception
    //   214	220	154	java/lang/Exception
    //   82	100	239	finally
    //   224	228	270	java/io/IOException
    //   228	232	274	java/io/IOException
    //   181	185	278	java/io/IOException
    //   189	193	282	java/io/IOException
    //   250	255	286	java/io/IOException
    //   259	263	290	java/io/IOException
    //   100	105	294	finally
    //   110	117	301	finally
    //   122	133	301	finally
    //   143	151	301	finally
    //   161	177	301	finally
    //   205	209	301	finally
    //   214	220	301	finally
    //   82	100	307	java/lang/Exception
    //   100	105	316	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, bj.a parama)
  {
    AppMethodBeat.i(90667);
    boolean bool = bj.a(new bs(paramString1, paramString2, paramInt1, paramInt2, parama), parama);
    AppMethodBeat.o(90667);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bt
 * JD-Core Version:    0.7.0.1
 */