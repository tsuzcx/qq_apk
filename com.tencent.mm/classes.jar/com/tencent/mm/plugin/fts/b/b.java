package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m gtT;
  private com.tencent.mm.sdk.b.c<bn> hZz;
  com.tencent.mm.plugin.fts.c.b tHM;
  private com.tencent.mm.sdk.b.c tHh;
  
  public b()
  {
    AppMethodBeat.i(52702);
    this.tHh = new com.tencent.mm.sdk.b.c() {};
    this.hZz = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(52702);
  }
  
  static int M(com.tencent.mm.vfs.k paramk)
  {
    AppMethodBeat.i(52708);
    paramk = new com.tencent.mm.vfs.k(paramk, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!paramk.exists()) {
          continue;
        }
        int j = Integer.parseInt(o.aZT(w.B(paramk.fTh())), 10);
        i = j;
      }
      catch (Exception paramk)
      {
        ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramk, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      ae.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { w.B(paramk.fTh()) });
    }
  }
  
  public static com.tencent.mm.vfs.k cVE()
  {
    AppMethodBeat.i(52706);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asc(), "fts"), "feature");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(52706);
    return localk;
  }
  
  public static com.tencent.mm.vfs.k cVF()
  {
    AppMethodBeat.i(52707);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(cVE(), "fts_feature");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(52707);
    return localk;
  }
  
  /* Error */
  static int cVG()
  {
    // Byte code:
    //   0: ldc_w 327
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
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
    //   53: invokestatic 364	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
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
    //   83: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 364	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 364	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
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
    paramj = this.gtT.a(-65536, paramj);
    AppMethodBeat.o(52703);
    return paramj;
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(52705);
    this.tHh.dead();
    this.hZz.dead();
    this.tHM = null;
    this.gtT = null;
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
      ae.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(52704);
      return false;
    }
    ae.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.gtT = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.tHM = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17));
    this.tHh.alive();
    this.hZz.alive();
    this.gtT.a(131132, new b((byte)0));
    this.gtT.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int tHP;
    private int tHQ;
    
    private a() {}
    
    public final String bhC()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.tHP), Integer.valueOf(this.tHQ) });
      AppMethodBeat.o(52698);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52697);
      ae.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = b.this.tHM;
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).tDu.rawQuery((String)localObject3, null);
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
        localObject2 = b.alz(w.B(b.cVF().fTh()));
        localObject1 = localObject2;
        b.this.tHM.dZ((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label131:
        Object localObject4;
        Object localObject5;
        break label131;
      }
      localObject3 = b.this.tHM.cVP();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject4).field_featureId), localObject4);
      }
      if (b.this.tHM.tDu.inTransaction()) {
        b.this.tHM.commit();
      }
      b.this.tHM.beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
        com.tencent.mm.plugin.fts.a.a.d locald = (com.tencent.mm.plugin.fts.a.a.d)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).tIJ));
        if (locald != null)
        {
          if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != locald.field_timestamp)
          {
            ((HashSet)localObject4).add(locald);
            b.this.tHM.c(com.tencent.mm.plugin.fts.a.c.tDF, locald.field_featureId);
            ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.tDF, String.valueOf(locald.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).tIJ));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      b.this.tHM.commit();
      b.this.tHM.beginTransaction();
      this.tHP = ((HashSet)localObject1).size();
      this.tHQ = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject2).next();
        localObject4 = b.this;
        ((b)localObject4).tHM.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title);
        localObject5 = com.tencent.mm.plugin.fts.a.d.bn(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, false);
        if (!bu.isNullOrNil((String)localObject5)) {
          ((b)localObject4).tHM.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        localObject5 = com.tencent.mm.plugin.fts.a.d.bn(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, true);
        if (!bu.isNullOrNil((String)localObject5)) {
          ((b)localObject4).tHM.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        ((b)localObject4).tHM.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_tag);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().alB(String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        b.this.tHM.c(com.tencent.mm.plugin.fts.a.c.tDF, ((Integer)localObject2).intValue());
      }
      b.this.tHM.commit();
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
      int j = b.M(b.cVF());
      int k = b.cVG();
      ae.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
        com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(ak.getContext().getCacheDir(), "fts/feature/fts_feature.zip");
        Object localObject = o.bb("assets:///fts/feature/fts_feature.zip", 0, -1);
        if (localk.exists()) {
          localk.delete();
        }
        if (!localk.fTg().exists()) {
          localk.fTg().mkdirs();
        }
        o.f(w.B(localk.fTh()), (byte[])localObject, localObject.length);
        localObject = new bn();
        ((bn)localObject).dny.dnz = 35;
        ((bn)localObject).dny.subType = 1;
        ((bn)localObject).dny.filePath = w.B(localk.fTh());
        com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
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
    extends i
  {
    private c(j paramj)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.k paramk)
    {
      AppMethodBeat.i(52700);
      paramk.tFe = com.tencent.mm.plugin.fts.a.a.h.bq(this.tFP.query, true);
      paramk.tGc = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = b.this.tHM.a(paramk.tFe, com.tencent.mm.plugin.fts.a.c.tDF, this.tFP.tFW, true, true);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.i(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localn.tGf))) && (!this.tFP.tFY.contains(localn.tEY)))
        {
          localn.cVt();
          paramk.tGc.add(localn);
          ((HashSet)localObject).add(Long.valueOf(localn.tGf));
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
      if (this.tFP.tFZ != null) {
        Collections.sort(paramk.tGc, this.tFP.tFZ);
      }
      paramk = paramk.tGc.iterator();
      while (paramk.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = b.this.tHM.Hp((int)((com.tencent.mm.plugin.fts.a.a.m)localObject).tGf);
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
      Object localObject = b.alz(this.path);
      b.this.tHM.beginTransaction();
      b.this.tHM.dZ((List)localObject);
      b.this.tHM.commit();
      b.this.tHM.z(com.tencent.mm.plugin.fts.a.c.tDF);
      b.this.gtT.a(131132, new b.a(b.this, (byte)0));
      localObject = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = com.tencent.mm.plugin.fts.a.c.tDF;
      ((e)localObject).tIo.j(arrayOfInt, 1);
      AppMethodBeat.o(52701);
      return true;
    }
    
    public final String getName()
    {
      return "UpdateFeatureIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b
 * JD-Core Version:    0.7.0.1
 */