package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.j;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m ezf;
  private c<bg> fAZ;
  com.tencent.mm.plugin.fts.c.b mUI;
  private c mUc;
  
  public b()
  {
    AppMethodBeat.i(136724);
    this.mUc = new b.1(this);
    this.fAZ = new b.2(this);
    AppMethodBeat.o(136724);
  }
  
  public static com.tencent.mm.vfs.b bCk()
  {
    AppMethodBeat.i(136728);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.eQw, "fts"), "feature");
    if (!localb.exists()) {
      localb.mkdirs();
    }
    AppMethodBeat.o(136728);
    return localb;
  }
  
  public static com.tencent.mm.vfs.b bCl()
  {
    AppMethodBeat.i(136729);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(bCk(), "fts_feature");
    if (!localb.exists()) {
      localb.mkdirs();
    }
    AppMethodBeat.o(136729);
    return localb;
  }
  
  /* Error */
  static int bCm()
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 56	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: invokevirtual 297	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: iconst_m1
    //   14: istore_0
    //   15: new 299	java/io/BufferedReader
    //   18: dup
    //   19: new 301	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 303
    //   27: invokevirtual 309	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 312	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 315	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 318	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: invokestatic 193	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 196	java/lang/Integer:intValue	()I
    //   49: istore_1
    //   50: iload_1
    //   51: istore_0
    //   52: aload_3
    //   53: invokestatic 324	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   56: ldc_w 291
    //   59: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iload_0
    //   63: ireturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 84
    //   72: aload 4
    //   74: aload 4
    //   76: invokevirtual 327	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 78	java/lang/Object
    //   83: invokestatic 331	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 324	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 324	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   100: ldc_w 291
    //   103: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_3
    //   107: athrow
    //   108: astore_3
    //   109: goto -13 -> 96
    //   112: astore 4
    //   114: goto -46 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	49	0	i	int
    //   49	2	1	j	int
    //   12	85	2	localObject1	Object
    //   36	51	3	localBufferedReader	java.io.BufferedReader
    //   93	14	3	localObject2	Object
    //   108	1	3	localObject3	Object
    //   64	11	4	localException1	Exception
    //   112	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	37	64	java/lang/Exception
    //   15	37	93	finally
    //   39	50	108	finally
    //   70	86	108	finally
    //   39	50	112	java/lang/Exception
  }
  
  static int k(com.tencent.mm.vfs.b paramb)
  {
    AppMethodBeat.i(136730);
    paramb = new com.tencent.mm.vfs.b(paramb, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!paramb.exists()) {
          continue;
        }
        int j = Integer.parseInt(com.tencent.mm.vfs.e.cS(j.p(paramb.dQJ())), 10);
        i = j;
      }
      catch (Exception paramb)
      {
        ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramb, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(136730);
      return i;
      ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { j.p(paramb.dQJ()) });
    }
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136727);
    this.mUc.dead();
    this.fAZ.dead();
    this.mUI = null;
    this.ezf = null;
    AppMethodBeat.o(136727);
    return true;
  }
  
  public final a a(i parami)
  {
    AppMethodBeat.i(136725);
    parami = new b.c(this, parami, (byte)0);
    parami = this.ezf.a(-65536, parami);
    AppMethodBeat.o(136725);
    return parami;
  }
  
  public final String getName()
  {
    return "FTS5SearchFeatureLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136726);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(136726);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    this.mUI = ((com.tencent.mm.plugin.fts.c.b)((n)g.G(n.class)).getFTSIndexStorage(17));
    this.mUc.alive();
    this.fAZ.alive();
    this.ezf.a(131132, new b.b(this, (byte)0));
    this.ezf.a(131133, new b.a(this, (byte)0));
    AppMethodBeat.o(136726);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b
 * JD-Core Version:    0.7.0.1
 */