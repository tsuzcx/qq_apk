package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m grs;
  private com.tencent.mm.sdk.b.c<bn> hWH;
  com.tencent.mm.plugin.fts.c.b twV;
  private com.tencent.mm.sdk.b.c twq;
  
  public b()
  {
    AppMethodBeat.i(52702);
    this.twq = new com.tencent.mm.sdk.b.c() {};
    this.hWH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(52702);
  }
  
  static int M(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(52708);
    parame = new com.tencent.mm.vfs.e(parame, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!parame.exists()) {
          continue;
        }
        int j = Integer.parseInt(com.tencent.mm.vfs.i.aYq(q.B(parame.fOK())), 10);
        i = j;
      }
      catch (Exception parame)
      {
        ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", parame, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { q.B(parame.fOK()) });
    }
  }
  
  public static com.tencent.mm.vfs.e cSZ()
  {
    AppMethodBeat.i(52706);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.arN(), "fts"), "feature");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(52706);
    return locale;
  }
  
  public static com.tencent.mm.vfs.e cTa()
  {
    AppMethodBeat.i(52707);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(cSZ(), "fts_feature");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(52707);
    return locale;
  }
  
  /* Error */
  static int cTb()
  {
    // Byte code:
    //   0: ldc_w 327
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   9: invokevirtual 333	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: iconst_m1
    //   14: istore_0
    //   15: new 335	java/io/BufferedReader
    //   18: dup
    //   19: new 337	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 339
    //   27: invokevirtual 345	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 348	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 351	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 354	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: invokestatic 358	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 361	java/lang/Integer:intValue	()I
    //   49: istore_1
    //   50: iload_1
    //   51: istore_0
    //   52: aload_3
    //   53: invokestatic 364	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   56: ldc_w 327
    //   59: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iload_0
    //   63: ireturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 93
    //   72: aload 4
    //   74: aload 4
    //   76: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 97	java/lang/Object
    //   83: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 364	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 364	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   100: ldc_w 327
    //   103: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final com.tencent.mm.plugin.fts.a.a.a a(j paramj)
  {
    AppMethodBeat.i(52703);
    paramj = new c(paramj, (byte)0);
    paramj = this.grs.a(-65536, paramj);
    AppMethodBeat.o(52703);
    return paramj;
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(52705);
    this.twq.dead();
    this.hWH.dead();
    this.twV = null;
    this.grs = null;
    AppMethodBeat.o(52705);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchFeatureLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52704);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(52704);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.grs = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.twV = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17));
    this.twq.alive();
    this.hWH.alive();
    this.grs.a(131132, new b((byte)0));
    this.grs.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int twY;
    private int twZ;
    
    private a() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.twY), Integer.valueOf(this.twZ) });
      AppMethodBeat.o(52698);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52697);
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = b.this.twV;
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tsD.rawQuery((String)localObject3, null);
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.d();
        ((com.tencent.mm.plugin.fts.a.a.d)localObject3).convertFrom((Cursor)localObject1);
        ((List)localObject2).add(localObject3);
      }
      ((Cursor)localObject1).close();
      localObject1 = localObject2;
      if (((List)localObject2).size() == 0) {
        localObject1 = localObject2;
      }
      try
      {
        localObject2 = b.akB(q.B(b.cTa().fOK()));
        localObject1 = localObject2;
        b.this.twV.dV((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label131:
        Object localObject4;
        Object localObject5;
        break label131;
      }
      localObject3 = b.this.twV.cTk();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject4).field_featureId), localObject4);
      }
      if (b.this.twV.tsD.inTransaction()) {
        b.this.twV.commit();
      }
      b.this.twV.beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
        com.tencent.mm.plugin.fts.a.a.d locald = (com.tencent.mm.plugin.fts.a.a.d)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).txS));
        if (locald != null)
        {
          if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != locald.field_timestamp)
          {
            ((HashSet)localObject4).add(locald);
            b.this.twV.c(com.tencent.mm.plugin.fts.a.c.tsO, locald.field_featureId);
            ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tsO, String.valueOf(locald.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).txS));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      b.this.twV.commit();
      b.this.twV.beginTransaction();
      this.twY = ((HashSet)localObject1).size();
      this.twZ = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject2).next();
        localObject4 = b.this;
        ((b)localObject4).twV.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title);
        localObject5 = com.tencent.mm.plugin.fts.a.d.bk(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, false);
        if (!bt.isNullOrNil((String)localObject5)) {
          ((b)localObject4).twV.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        localObject5 = com.tencent.mm.plugin.fts.a.d.bk(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, true);
        if (!bt.isNullOrNil((String)localObject5)) {
          ((b)localObject4).twV.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        ((b)localObject4).twV.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_tag);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().akD(String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        b.this.twV.c(com.tencent.mm.plugin.fts.a.c.tsO, ((Integer)localObject2).intValue());
      }
      b.this.twV.commit();
      AppMethodBeat.o(52697);
      return true;
    }
    
    public final int getId()
    {
      return 5;
    }
    
    public final String getName()
    {
      return "BuildFeatureIndexTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private b() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52699);
      int j = b.M(b.cTa());
      int k = b.cTb();
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      int i = j;
      if (k > j)
      {
        i = j;
        if (k > 0) {
          i = -1;
        }
      }
      if (i < 0)
      {
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(aj.getContext().getCacheDir(), "fts/feature/fts_feature.zip");
        Object localObject = com.tencent.mm.vfs.i.aY("assets:///fts/feature/fts_feature.zip", 0, -1);
        if (locale.exists()) {
          locale.delete();
        }
        if (!locale.fOJ().exists()) {
          locale.fOJ().mkdirs();
        }
        com.tencent.mm.vfs.i.f(q.B(locale.fOK()), (byte[])localObject, localObject.length);
        localObject = new bn();
        ((bn)localObject).dmw.dmx = 35;
        ((bn)localObject).dmw.subType = 1;
        ((bn)localObject).dmw.filePath = q.B(locale.fOK());
        com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
      }
      AppMethodBeat.o(52699);
      return true;
    }
    
    public final String getName()
    {
      return "CheckFeatureResourceTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    private c(j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52700);
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      paramk.tvl = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = b.this.twV.a(paramk.tun, com.tencent.mm.plugin.fts.a.c.tsO, this.tuY.tvf, true, true);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.i(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localn.tvo))) && (!this.tuY.tvh.contains(localn.tuh)))
        {
          localn.cSO();
          paramk.tvl.add(localn);
          ((HashSet)localObject).add(Long.valueOf(localn.tvo));
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(52700);
        throw paramk;
      }
      if (this.tuY.tvi != null) {
        Collections.sort(paramk.tvl, this.tuY.tvi);
      }
      paramk = paramk.tvl.iterator();
      while (paramk.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = b.this.twV.GS((int)((com.tencent.mm.plugin.fts.a.a.m)localObject).tvo);
      }
      AppMethodBeat.o(52700);
    }
    
    public final int getId()
    {
      return 12;
    }
    
    public final String getName()
    {
      return "SearchFeatureTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String path;
    
    public d(String paramString)
    {
      this.path = paramString;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52701);
      Object localObject = b.akB(this.path);
      b.this.twV.beginTransaction();
      b.this.twV.dV((List)localObject);
      b.this.twV.commit();
      b.this.twV.y(com.tencent.mm.plugin.fts.a.c.tsO);
      b.this.grs.a(131132, new b.a(b.this, (byte)0));
      localObject = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = com.tencent.mm.plugin.fts.a.c.tsO;
      ((e)localObject).txx.j(arrayOfInt, 1);
      AppMethodBeat.o(52701);
      return true;
    }
    
    public final String getName()
    {
      return "UpdateFeatureIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b
 * JD-Core Version:    0.7.0.1
 */