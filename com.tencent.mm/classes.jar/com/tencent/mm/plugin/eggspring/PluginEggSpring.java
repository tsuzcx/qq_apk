package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.n.n;
import java.io.InputStream;
import java.io.OutputStream;

public class PluginEggSpring
  extends f
  implements c, a
{
  public static final String orA;
  private static final String orx;
  public static final String ory;
  public static final String orz;
  
  static
  {
    AppMethodBeat.i(108141);
    orx = com.tencent.mm.loader.j.b.aiY();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = com.tencent.mm.plugin.eggspring.b.b.orX;
    localObject = new StringBuilder();
    String str = com.tencent.mm.loader.j.b.aia();
    k.g(str, "CConstants.DATAROOT_PUBLIC_PATH()");
    ory = ((StringBuilder)localObject).append(n.h(str, "/data/user/0", "/data/data", false)).append("/emoji/").toString() + "egg_spring/";
    orz = ory + "loading_lucky_bag";
    orA = ory + "lucky_bag";
    AppMethodBeat.o(108141);
  }
  
  /* Error */
  private void copyAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore_3
    //   5: ldc 104
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 110	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   13: invokevirtual 116	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: astore 5
    //   18: aload 5
    //   20: aload_1
    //   21: invokevirtual 122	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore 7
    //   26: new 124	com/tencent/mm/vfs/e
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 127	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 131	com/tencent/mm/vfs/e:exists	()Z
    //   39: istore 4
    //   41: iload 4
    //   43: ifeq +19 -> 62
    //   46: aload 7
    //   48: ifnull +8 -> 56
    //   51: aload 7
    //   53: invokevirtual 136	java/io/InputStream:close	()V
    //   56: ldc 104
    //   58: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_1
    //   63: invokevirtual 140	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   66: invokevirtual 143	com/tencent/mm/vfs/e:mkdirs	()Z
    //   69: pop
    //   70: aload_1
    //   71: invokestatic 149	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   74: astore 8
    //   76: aload_0
    //   77: aload 7
    //   79: aload 8
    //   81: invokespecial 153	com/tencent/mm/plugin/eggspring/PluginEggSpring:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   84: iload_3
    //   85: istore 4
    //   87: aload 8
    //   89: ifnull +11 -> 100
    //   92: aload 8
    //   94: invokevirtual 156	java/io/OutputStream:close	()V
    //   97: iload_3
    //   98: istore 4
    //   100: iload 4
    //   102: ifne +8 -> 110
    //   105: aload_2
    //   106: invokestatic 160	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   109: pop
    //   110: ldc 162
    //   112: ldc 164
    //   114: iconst_1
    //   115: anewarray 166	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: iload 4
    //   122: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: aastore
    //   126: invokestatic 177	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 7
    //   131: ifnull +179 -> 310
    //   134: aload 7
    //   136: invokevirtual 136	java/io/InputStream:close	()V
    //   139: ldc 104
    //   141: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_1
    //   146: ldc 162
    //   148: aload_1
    //   149: ldc 179
    //   151: iconst_0
    //   152: anewarray 166	java/lang/Object
    //   155: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: ldc 104
    //   160: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: return
    //   164: astore_1
    //   165: ldc 162
    //   167: aload_1
    //   168: ldc 185
    //   170: iconst_0
    //   171: anewarray 166	java/lang/Object
    //   174: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -95 -> 84
    //   182: astore 5
    //   184: ldc 104
    //   186: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 5
    //   191: athrow
    //   192: astore_1
    //   193: aload 8
    //   195: ifnull +13 -> 208
    //   198: aload 5
    //   200: ifnull +76 -> 276
    //   203: aload 8
    //   205: invokevirtual 156	java/io/OutputStream:close	()V
    //   208: ldc 104
    //   210: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: ldc 162
    //   218: aload_1
    //   219: ldc 187
    //   221: iconst_0
    //   222: anewarray 166	java/lang/Object
    //   225: invokestatic 183	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: iconst_0
    //   229: istore 4
    //   231: goto -131 -> 100
    //   234: astore 8
    //   236: aload 5
    //   238: aload 8
    //   240: invokevirtual 191	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   243: goto -35 -> 208
    //   246: astore_2
    //   247: ldc 104
    //   249: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_2
    //   253: athrow
    //   254: astore_1
    //   255: aload 7
    //   257: ifnull +12 -> 269
    //   260: aload_2
    //   261: ifnull +41 -> 302
    //   264: aload 7
    //   266: invokevirtual 136	java/io/InputStream:close	()V
    //   269: ldc 104
    //   271: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_1
    //   275: athrow
    //   276: aload 8
    //   278: invokevirtual 156	java/io/OutputStream:close	()V
    //   281: goto -73 -> 208
    //   284: astore_1
    //   285: aload 6
    //   287: astore_2
    //   288: goto -33 -> 255
    //   291: astore 5
    //   293: aload_2
    //   294: aload 5
    //   296: invokevirtual 191	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   299: goto -30 -> 269
    //   302: aload 7
    //   304: invokevirtual 136	java/io/InputStream:close	()V
    //   307: goto -38 -> 269
    //   310: ldc 104
    //   312: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: return
    //   316: astore_1
    //   317: aconst_null
    //   318: astore 5
    //   320: goto -127 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	PluginEggSpring
    //   0	323	1	paramString1	String
    //   0	323	2	paramString2	String
    //   4	175	3	bool1	boolean
    //   39	191	4	bool2	boolean
    //   16	3	5	localAssetManager	android.content.res.AssetManager
    //   182	55	5	localThrowable1	java.lang.Throwable
    //   291	4	5	localThrowable2	java.lang.Throwable
    //   318	1	5	localObject1	Object
    //   1	285	6	localObject2	Object
    //   24	279	7	localInputStream	InputStream
    //   74	130	8	localOutputStream	OutputStream
    //   234	43	8	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   18	26	145	java/io/IOException
    //   51	56	145	java/io/IOException
    //   134	144	145	java/io/IOException
    //   264	269	145	java/io/IOException
    //   269	276	145	java/io/IOException
    //   293	299	145	java/io/IOException
    //   302	307	145	java/io/IOException
    //   76	84	164	java/io/IOException
    //   76	84	182	java/lang/Throwable
    //   165	177	182	java/lang/Throwable
    //   184	192	192	finally
    //   70	76	215	java/io/IOException
    //   92	97	215	java/io/IOException
    //   203	208	215	java/io/IOException
    //   208	215	215	java/io/IOException
    //   236	243	215	java/io/IOException
    //   276	281	215	java/io/IOException
    //   203	208	234	java/lang/Throwable
    //   26	41	246	java/lang/Throwable
    //   62	70	246	java/lang/Throwable
    //   70	76	246	java/lang/Throwable
    //   92	97	246	java/lang/Throwable
    //   105	110	246	java/lang/Throwable
    //   110	129	246	java/lang/Throwable
    //   208	215	246	java/lang/Throwable
    //   216	228	246	java/lang/Throwable
    //   236	243	246	java/lang/Throwable
    //   276	281	246	java/lang/Throwable
    //   247	254	254	finally
    //   26	41	284	finally
    //   62	70	284	finally
    //   70	76	284	finally
    //   92	97	284	finally
    //   105	110	284	finally
    //   110	129	284	finally
    //   203	208	284	finally
    //   208	215	284	finally
    //   216	228	284	finally
    //   236	243	284	finally
    //   276	281	284	finally
    //   264	269	291	java/lang/Throwable
    //   76	84	316	finally
    //   165	177	316	finally
  }
  
  private void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(108138);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(108138);
  }
  
  private void initDir()
  {
    AppMethodBeat.i(108137);
    copyAsset("loading_lucky_bag", orz);
    copyAsset("lucky_bag", orA);
    AppMethodBeat.o(108137);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(108139);
    ad.i("MicroMsg.PluginEggSpring", "execute");
    AppMethodBeat.o(108139);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(108135);
    ad.i("MicroMsg.PluginEggSpring", "onAccountInitialized");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108134);
        if (1 == ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwd, 0))
        {
          ad.i("MicroMsg.PluginEggSpring", "clear useless media.");
          i.cO(PluginEggSpring.orx, true);
          i.cO(PluginEggSpring.ory, true);
          AppMethodBeat.o(108134);
          return;
        }
        PluginEggSpring.access$100(PluginEggSpring.this);
        AppMethodBeat.o(108134);
      }
    }, "init_egg_spring_dir");
    AppMethodBeat.o(108135);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108136);
    ad.i("MicroMsg.PluginEggSpring", "onAccountRelease");
    AppMethodBeat.o(108136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.PluginEggSpring
 * JD-Core Version:    0.7.0.1
 */