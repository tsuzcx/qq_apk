package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.we;
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
  com.tencent.mm.plugin.fts.a.m fUc;
  private com.tencent.mm.sdk.b.c<bk> hdz;
  private com.tencent.mm.sdk.b.c rqV;
  com.tencent.mm.plugin.fts.c.b rrA;
  
  public b()
  {
    AppMethodBeat.i(52702);
    this.rqV = new com.tencent.mm.sdk.b.c() {};
    this.hdz = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(52702);
  }
  
  static int N(com.tencent.mm.vfs.e parame)
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
        int j = Integer.parseInt(com.tencent.mm.vfs.i.aMP(q.B(parame.fhU())), 10);
        i = j;
      }
      catch (Exception parame)
      {
        ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", parame, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { q.B(parame.fhU()) });
    }
  }
  
  /* Error */
  static int cxA()
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   9: invokevirtual 309	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: iconst_m1
    //   14: istore_0
    //   15: new 311	java/io/BufferedReader
    //   18: dup
    //   19: new 313	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 315
    //   27: invokevirtual 321	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 324	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 327	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 330	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: invokestatic 334	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 337	java/lang/Integer:intValue	()I
    //   49: istore_1
    //   50: iload_1
    //   51: istore_0
    //   52: aload_3
    //   53: invokestatic 340	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   56: ldc_w 303
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
    //   76: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 97	java/lang/Object
    //   83: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 340	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 340	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   100: ldc_w 303
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
  
  public static com.tencent.mm.vfs.e cxy()
  {
    AppMethodBeat.i(52706);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aia(), "fts"), "feature");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(52706);
    return locale;
  }
  
  public static com.tencent.mm.vfs.e cxz()
  {
    AppMethodBeat.i(52707);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(cxy(), "fts_feature");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(52707);
    return locale;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(j paramj)
  {
    AppMethodBeat.i(52703);
    paramj = new c(paramj, (byte)0);
    paramj = this.fUc.a(-65536, paramj);
    AppMethodBeat.o(52703);
    return paramj;
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(52705);
    this.rqV.dead();
    this.hdz.dead();
    this.rrA = null;
    this.fUc = null;
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
    this.fUc = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.rrA = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17));
    this.rqV.alive();
    this.hdz.alive();
    this.fUc.a(131132, new b((byte)0));
    this.fUc.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int rrD;
    private int rrE;
    
    private a() {}
    
    public final String aWs()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.rrD), Integer.valueOf(this.rrE) });
      AppMethodBeat.o(52698);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52697);
      ad.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = b.this.rrA;
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).rni.rawQuery((String)localObject3, null);
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
        localObject2 = b.abl(q.B(b.cxz().fhU()));
        localObject1 = localObject2;
        b.this.rrA.dH((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label131:
        Object localObject4;
        Object localObject5;
        break label131;
      }
      localObject3 = b.this.rrA.cxJ();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject4).field_featureId), localObject4);
      }
      if (b.this.rrA.rni.inTransaction()) {
        b.this.rrA.commit();
      }
      b.this.rrA.beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
        com.tencent.mm.plugin.fts.a.a.d locald = (com.tencent.mm.plugin.fts.a.a.d)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).rsx));
        if (locald != null)
        {
          if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != locald.field_timestamp)
          {
            ((HashSet)localObject4).add(locald);
            b.this.rrA.c(com.tencent.mm.plugin.fts.a.c.rnt, locald.field_featureId);
            ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.rnt, String.valueOf(locald.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).rsx));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      b.this.rrA.commit();
      b.this.rrA.beginTransaction();
      this.rrD = ((HashSet)localObject1).size();
      this.rrE = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject2).next();
        localObject4 = b.this;
        ((b)localObject4).rrA.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title);
        localObject5 = com.tencent.mm.plugin.fts.a.d.aZ(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, false);
        if (!bt.isNullOrNil((String)localObject5)) {
          ((b)localObject4).rrA.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        localObject5 = com.tencent.mm.plugin.fts.a.d.aZ(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, true);
        if (!bt.isNullOrNil((String)localObject5)) {
          ((b)localObject4).rrA.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        ((b)localObject4).rrA.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_tag);
        ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic().abn(String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        b.this.rrA.c(com.tencent.mm.plugin.fts.a.c.rnt, ((Integer)localObject2).intValue());
      }
      b.this.rrA.commit();
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
      int j = b.N(b.cxz());
      int k = b.cxA();
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
        Object localObject = com.tencent.mm.vfs.i.aR("assets:///fts/feature/fts_feature.zip", 0, -1);
        if (locale.exists()) {
          locale.delete();
        }
        if (!locale.fhT().exists()) {
          locale.fhT().mkdirs();
        }
        com.tencent.mm.vfs.i.f(q.B(locale.fhU()), (byte[])localObject, localObject.length);
        localObject = new bk();
        ((bk)localObject).ddG.ddH = 35;
        ((bk)localObject).ddG.subType = 1;
        ((bk)localObject).ddG.filePath = q.B(locale.fhU());
        com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
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
      paramk.roS = com.tencent.mm.plugin.fts.a.a.h.bc(this.rpD.query, true);
      paramk.rpQ = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = b.this.rrA.a(paramk.roS, com.tencent.mm.plugin.fts.a.c.rnt, this.rpD.rpK, true, true);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.j(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localn.rpT))) && (!this.rpD.rpM.contains(localn.roN)))
        {
          localn.cxn();
          paramk.rpQ.add(localn);
          ((HashSet)localObject).add(Long.valueOf(localn.rpT));
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
      if (this.rpD.rpN != null) {
        Collections.sort(paramk.rpQ, this.rpD.rpN);
      }
      paramk = paramk.rpQ.iterator();
      while (paramk.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = b.this.rrA.DH((int)((com.tencent.mm.plugin.fts.a.a.m)localObject).rpT);
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
      Object localObject = b.abl(this.path);
      b.this.rrA.beginTransaction();
      b.this.rrA.dH((List)localObject);
      b.this.rrA.commit();
      b.this.rrA.y(com.tencent.mm.plugin.fts.a.c.rnt);
      b.this.fUc.a(131132, new b.a(b.this, (byte)0));
      localObject = ((PluginFTS)g.ad(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = com.tencent.mm.plugin.fts.a.c.rnt;
      ((e)localObject).rsc.g(arrayOfInt, 1);
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