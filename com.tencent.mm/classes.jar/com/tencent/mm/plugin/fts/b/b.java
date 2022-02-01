package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m hgI;
  private IListener<bp> iUx;
  com.tencent.mm.plugin.fts.c.b wYL;
  private IListener wYg;
  
  public b()
  {
    AppMethodBeat.i(52702);
    this.wYg = new IListener() {};
    this.iUx = new IListener() {};
    AppMethodBeat.o(52702);
  }
  
  static int S(o paramo)
  {
    AppMethodBeat.i(52708);
    paramo = new o(paramo, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!paramo.exists()) {
          continue;
        }
        int j = Integer.parseInt(s.boY(aa.z(paramo.her())), 10);
        i = j;
      }
      catch (Exception paramo)
      {
        Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramo, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { aa.z(paramo.her()) });
    }
  }
  
  public static o dON()
  {
    AppMethodBeat.i(52706);
    o localo = new o(new o(com.tencent.mm.loader.j.b.aKC(), "fts"), "feature");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(52706);
    return localo;
  }
  
  public static o dOO()
  {
    AppMethodBeat.i(52707);
    o localo = new o(dON(), "fts_feature");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(52707);
    return localo;
  }
  
  /* Error */
  static int dOP()
  {
    // Byte code:
    //   0: ldc_w 337
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 117	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: invokevirtual 343	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: iconst_m1
    //   14: istore_0
    //   15: new 345	java/io/BufferedReader
    //   18: dup
    //   19: new 347	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 349
    //   27: invokevirtual 355	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 358	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 361	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 364	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: invokestatic 368	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 371	java/lang/Integer:intValue	()I
    //   49: istore_1
    //   50: iload_1
    //   51: istore_0
    //   52: aload_3
    //   53: invokestatic 375	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   56: ldc_w 337
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
    //   76: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 97	java/lang/Object
    //   83: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 375	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 375	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   100: ldc_w 337
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
    paramj = this.hgI.a(-65536, paramj);
    AppMethodBeat.o(52703);
    return paramj;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52705);
    this.wYg.dead();
    this.iUx.dead();
    this.wYL = null;
    this.hgI = null;
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(52704);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.hgI = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.wYL = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17));
    this.wYg.alive();
    this.iUx.alive();
    this.hgI.a(131132, new b((byte)0));
    this.hgI.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int wYO;
    private int wYP;
    
    private a() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.wYO), Integer.valueOf(this.wYP) });
      AppMethodBeat.o(52698);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52697);
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = b.this.wYL;
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).wUt.rawQuery((String)localObject3, null);
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
        localObject2 = b.ayD(aa.z(b.dOO().her()));
        localObject1 = localObject2;
        b.this.wYL.eR((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label131:
        Object localObject4;
        Object localObject5;
        break label131;
      }
      localObject3 = b.this.wYL.dOY();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject4).field_featureId), localObject4);
      }
      if (b.this.wYL.wUt.inTransaction()) {
        b.this.wYL.commit();
      }
      b.this.wYL.beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
        com.tencent.mm.plugin.fts.a.a.d locald = (com.tencent.mm.plugin.fts.a.a.d)((HashMap)localObject2).remove(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).wZI));
        if (locald != null)
        {
          if (((com.tencent.mm.plugin.fts.c.b.a)localObject5).timestamp != locald.field_timestamp)
          {
            ((HashSet)localObject4).add(locald);
            b.this.wYL.c(c.wUE, locald.field_featureId);
            ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic().c(c.wUE, String.valueOf(locald.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(((com.tencent.mm.plugin.fts.c.b.a)localObject5).wZI));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      b.this.wYL.commit();
      b.this.wYL.beginTransaction();
      this.wYO = ((HashSet)localObject1).size();
      this.wYP = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.d)((Iterator)localObject2).next();
        localObject4 = b.this;
        ((b)localObject4).wYL.a(262144, 1, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title);
        localObject5 = com.tencent.mm.plugin.fts.a.d.bB(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, false);
        if (!Util.isNullOrNil((String)localObject5)) {
          ((b)localObject4).wYL.a(262144, 2, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        localObject5 = com.tencent.mm.plugin.fts.a.d.bB(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_title, true);
        if (!Util.isNullOrNil((String)localObject5)) {
          ((b)localObject4).wYL.a(262144, 3, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, (String)localObject5);
        }
        ((b)localObject4).wYL.a(262144, 4, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId, String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId), ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_timestamp, ((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_tag);
        ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic().ayF(String.valueOf(((com.tencent.mm.plugin.fts.a.a.d)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        b.this.wYL.c(c.wUE, ((Integer)localObject2).intValue());
      }
      b.this.wYL.commit();
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
      int j = b.S(b.dOO());
      int k = b.dOP();
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
        o localo = new o(MMApplicationContext.getContext().getCacheDir(), "fts/feature/fts_feature.zip");
        Object localObject = s.aW("assets:///fts/feature/fts_feature.zip", 0, -1);
        if (localo.exists()) {
          localo.delete();
        }
        if (!localo.heq().exists()) {
          localo.heq().mkdirs();
        }
        s.f(aa.z(localo.her()), (byte[])localObject, localObject.length);
        localObject = new bp();
        ((bp)localObject).dEN.dEO = 35;
        ((bp)localObject).dEN.subType = 1;
        ((bp)localObject).dEN.filePath = aa.z(localo.her());
        EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
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
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52700);
      paramk.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
      paramk.wXb = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = b.this.wYL.a(paramk.wWd, c.wUE, this.wWO.wWV, true, true);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.i(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localn.wXe))) && (!this.wWO.wWX.contains(localn.wVX)))
        {
          localn.dOC();
          paramk.wXb.add(localn);
          ((HashSet)localObject).add(Long.valueOf(localn.wXe));
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
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      paramk = paramk.wXb.iterator();
      while (paramk.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject).userData = b.this.wYL.Np((int)((com.tencent.mm.plugin.fts.a.a.m)localObject).wXe);
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
      Object localObject = b.ayD(this.path);
      b.this.wYL.beginTransaction();
      b.this.wYL.eR((List)localObject);
      b.this.wYL.commit();
      b.this.wYL.B(c.wUE);
      b.this.hgI.a(131132, new b.a(b.this, (byte)0));
      localObject = ((PluginFTS)g.ah(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = c.wUE;
      ((e)localObject).wZn.j(arrayOfInt, 1);
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