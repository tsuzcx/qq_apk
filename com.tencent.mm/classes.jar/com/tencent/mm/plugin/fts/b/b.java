package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.f.a.zu;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private com.tencent.mm.plugin.fts.c.b BKL;
  private IListener BKc;
  private com.tencent.mm.plugin.fts.a.m jSC;
  private IListener<bu> lKQ;
  
  public b()
  {
    AppMethodBeat.i(52702);
    this.BKc = new IListener() {};
    this.lKQ = new IListener() {};
    AppMethodBeat.o(52702);
  }
  
  private static int R(q paramq)
  {
    AppMethodBeat.i(52708);
    paramq = new q(paramq, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!paramq.ifE()) {
          continue;
        }
        int j = Integer.parseInt(u.bBS(paramq.bOF()), 10);
        i = j;
      }
      catch (Exception paramq)
      {
        Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramq, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { paramq.bOF() });
    }
  }
  
  private static q erg()
  {
    AppMethodBeat.i(52706);
    q localq = new q(new q(com.tencent.mm.loader.j.b.aSE(), "fts"), "feature");
    if (!localq.ifE()) {
      localq.ifL();
    }
    AppMethodBeat.o(52706);
    return localq;
  }
  
  public static q erh()
  {
    AppMethodBeat.i(52707);
    q localq = new q(erg(), "fts_feature");
    if (!localq.ifE()) {
      localq.ifL();
    }
    AppMethodBeat.o(52707);
    return localq;
  }
  
  /* Error */
  private static int eri()
  {
    // Byte code:
    //   0: ldc_w 399
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 212	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: invokevirtual 405	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: iconst_m1
    //   14: istore_0
    //   15: new 407	java/io/BufferedReader
    //   18: dup
    //   19: new 409	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 411
    //   27: invokevirtual 417	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: invokespecial 420	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 423	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: aload_3
    //   40: invokevirtual 426	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: invokestatic 429	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 432	java/lang/Integer:intValue	()I
    //   49: istore_1
    //   50: iload_1
    //   51: istore_0
    //   52: aload_3
    //   53: invokestatic 436	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   56: ldc_w 399
    //   59: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iload_0
    //   63: ireturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 87
    //   72: aload 4
    //   74: aload 4
    //   76: invokevirtual 439	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   79: iconst_0
    //   80: anewarray 91	java/lang/Object
    //   83: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 436	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   90: goto -34 -> 56
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: invokestatic 436	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   100: ldc_w 399
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
    paramj = this.jSC.a(-65536, paramj);
    AppMethodBeat.o(52703);
    return paramj;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52705);
    this.BKc.dead();
    this.lKQ.dead();
    this.BKL = null;
    this.jSC = null;
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(52704);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.BKL = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17));
    this.BKc.alive();
    this.lKQ.alive();
    this.jSC.a(131132, new b((byte)0));
    this.jSC.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int BKO;
    private int add;
    
    private a() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52697);
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = b.a(b.this);
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).BGp.rawQuery((String)localObject3, null);
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new d();
        ((d)localObject3).convertFrom((Cursor)localObject1);
        ((List)localObject2).add(localObject3);
      }
      ((Cursor)localObject1).close();
      localObject1 = localObject2;
      if (((List)localObject2).size() == 0) {
        localObject1 = localObject2;
      }
      try
      {
        localObject2 = b.aHY(b.erh().bOF());
        localObject1 = localObject2;
        b.a(b.this).fh((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label128:
        Object localObject4;
        break label128;
      }
      localObject3 = b.a(b.this).ers();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (d)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((d)localObject4).field_featureId), localObject4);
      }
      if (b.a(b.this).BGp.inTransaction()) {
        b.a(b.this).commit();
      }
      b.a(b.this).beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.fts.c.b.a locala = (com.tencent.mm.plugin.fts.c.b.a)((Iterator)localObject3).next();
        d locald = (d)((HashMap)localObject2).remove(Integer.valueOf(locala.BLH));
        if (locald != null)
        {
          if (locala.timestamp != locald.field_timestamp)
          {
            ((HashSet)localObject4).add(locald);
            b.a(b.this).c(c.BGA, locald.field_featureId);
            ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic().c(c.BGA, String.valueOf(locald.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(locala.BLH));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      b.a(b.this).commit();
      b.a(b.this).beginTransaction();
      this.BKO = ((HashSet)localObject1).size();
      this.add = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (d)((Iterator)localObject2).next();
        b.a(b.this, (d)localObject3);
        ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic().aIa(String.valueOf(((d)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        b.a(b.this).c(c.BGA, ((Integer)localObject2).intValue());
      }
      b.a(b.this).commit();
      AppMethodBeat.o(52697);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.BKO), Integer.valueOf(this.add) });
      AppMethodBeat.o(52698);
      return str;
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52699);
      int j = b.S(b.erh());
      int k = b.erj();
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
        q localq = new q(MMApplicationContext.getContext().getCacheDir(), "fts/feature/fts_feature.zip");
        Object localObject = u.aY("assets:///fts/feature/fts_feature.zip", 0, -1);
        if (localq.ifE()) {
          localq.cFq();
        }
        if (!localq.ifB().ifE()) {
          localq.ifB().ifK();
        }
        u.H(localq.bOF(), (byte[])localObject);
        localObject = new bu();
        ((bu)localObject).fxB.fxC = 35;
        ((bu)localObject).fxB.subType = 1;
        ((bu)localObject).fxB.filePath = localq.bOF();
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      paramk.BIW = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = b.a(b.this).a(paramk.BHY, c.BGA, this.BIJ.BIQ, true, true);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
        localn.k(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localn.BIZ))) && (!this.BIJ.BIS.contains(localn.BHS)))
        {
          localn.eqT();
          paramk.BIW.add(localn);
          ((HashSet)localObject).add(Long.valueOf(localn.BIZ));
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
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
      }
      paramk = paramk.BIW.iterator();
      while (paramk.hasNext())
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.m)paramk.next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject).BJh = b.a(b.this).SD((int)((com.tencent.mm.plugin.fts.a.a.m)localObject).BIZ);
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
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52701);
      Object localObject = b.aHY(this.path);
      b.a(b.this).beginTransaction();
      b.a(b.this).fh((List)localObject);
      b.a(b.this).commit();
      b.a(b.this).B(c.BGA);
      b.b(b.this).a(131132, new b.a(b.this, (byte)0));
      localObject = ((PluginFTS)com.tencent.mm.kernel.h.ag(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = c.BGA;
      ((e)localObject).BLm.j(arrayOfInt, 1);
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