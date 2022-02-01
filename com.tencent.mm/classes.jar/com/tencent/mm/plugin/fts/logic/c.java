package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c
  extends com.tencent.mm.plugin.fts.a.b
{
  private IListener HuW;
  private com.tencent.mm.plugin.fts.b.c HvE;
  private com.tencent.mm.plugin.fts.a.m msU;
  private IListener<cd> oDs;
  
  public c()
  {
    AppMethodBeat.i(52702);
    this.HuW = new FTS5SearchFeatureLogic.1(this, com.tencent.mm.app.f.hfK);
    this.oDs = new FTS5SearchFeatureLogic.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(52702);
  }
  
  private static int T(u paramu)
  {
    AppMethodBeat.i(52708);
    paramu = new u(paramu, "version.info");
    int i = -1;
    for (;;)
    {
      try
      {
        if (!paramu.jKS()) {
          continue;
        }
        int j = Integer.parseInt(y.bEn(ah.v(paramu.jKT())), 10);
        i = j;
      }
      catch (Exception paramu)
      {
        Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramu, "getFeatureVersion", new Object[0]);
        continue;
      }
      AppMethodBeat.o(52708);
      return i;
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { ah.v(paramu.jKT()) });
    }
  }
  
  private static u fxN()
  {
    AppMethodBeat.i(52706);
    u localu = new u(new u(com.tencent.mm.loader.i.b.bms(), "fts"), "feature");
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(52706);
    return localu;
  }
  
  public static u fxO()
  {
    AppMethodBeat.i(52707);
    u localu = new u(fxN(), "fts_feature");
    if (!localu.jKS()) {
      localu.jKY();
    }
    AppMethodBeat.o(52707);
    return localu;
  }
  
  /* Error */
  private static int fxP()
  {
    // Byte code:
    //   0: ldc_w 413
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_m1
    //   7: istore_1
    //   8: invokestatic 419	com/tencent/mm/compatible/util/h:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_2
    //   12: iload_1
    //   13: istore_0
    //   14: aload_2
    //   15: ifnull +42 -> 57
    //   18: new 421	java/io/BufferedReader
    //   21: dup
    //   22: new 423	java/io/InputStreamReader
    //   25: dup
    //   26: aload_2
    //   27: ldc_w 425
    //   30: invokevirtual 431	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: invokespecial 434	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: invokespecial 437	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: invokevirtual 440	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: invokestatic 443	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   49: invokevirtual 446	java/lang/Integer:intValue	()I
    //   52: istore_0
    //   53: aload_3
    //   54: invokestatic 450	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   57: ldc_w 413
    //   60: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iload_0
    //   64: ireturn
    //   65: astore 4
    //   67: aconst_null
    //   68: astore_3
    //   69: aload_3
    //   70: astore_2
    //   71: ldc 99
    //   73: aload 4
    //   75: aload 4
    //   77: invokevirtual 453	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   80: iconst_0
    //   81: anewarray 103	java/lang/Object
    //   84: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_3
    //   88: invokestatic 450	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   91: iload_1
    //   92: istore_0
    //   93: goto -36 -> 57
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_2
    //   100: invokestatic 450	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   103: ldc_w 413
    //   106: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_3
    //   110: athrow
    //   111: astore_3
    //   112: goto -13 -> 99
    //   115: astore 4
    //   117: goto -48 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	80	0	i	int
    //   7	85	1	j	int
    //   11	89	2	localObject1	Object
    //   39	49	3	localBufferedReader	java.io.BufferedReader
    //   96	14	3	localObject2	Object
    //   111	1	3	localObject3	Object
    //   65	11	4	localException1	Exception
    //   115	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	40	65	java/lang/Exception
    //   18	40	96	finally
    //   42	53	111	finally
    //   71	87	111	finally
    //   42	53	115	java/lang/Exception
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(52703);
    paraml = new c(paraml, (byte)0);
    paraml = this.msU.a(-65536, paraml);
    AppMethodBeat.o(52703);
    return paraml;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52705);
    this.HuW.dead();
    this.oDs.dead();
    this.HvE = null;
    this.msU = null;
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
    if (!((n)com.tencent.mm.kernel.h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      AppMethodBeat.o(52704);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.msU = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon();
    this.HvE = ((com.tencent.mm.plugin.fts.b.c)((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexStorage(17));
    this.HuW.alive();
    this.oDs.alive();
    this.msU.a(131132, new b((byte)0));
    this.msU.a(131133, new a((byte)0));
    AppMethodBeat.o(52704);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int HvH;
    private int add;
    
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52697);
      Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
      Object localObject1 = c.a(c.this);
      Object localObject2 = new ArrayList();
      Object localObject3 = String.format("SELECT * FROM Feature", new Object[0]);
      localObject1 = ((a)localObject1).HqR.rawQuery((String)localObject3, null);
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.fts.a.a.f();
        ((com.tencent.mm.plugin.fts.a.a.f)localObject3).convertFrom((Cursor)localObject1);
        ((List)localObject2).add(localObject3);
      }
      ((Cursor)localObject1).close();
      localObject1 = localObject2;
      if (((List)localObject2).size() == 0) {
        localObject1 = localObject2;
      }
      try
      {
        localObject2 = c.aEw(ah.v(c.fxO().jKT()));
        localObject1 = localObject2;
        c.a(c.this).hU((List)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        label131:
        Object localObject4;
        break label131;
      }
      localObject3 = c.a(c.this).fxZ();
      localObject2 = new HashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.fts.a.a.f)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((com.tencent.mm.plugin.fts.a.a.f)localObject4).field_featureId), localObject4);
      }
      if (c.a(c.this).inTransaction()) {
        c.a(c.this).commit();
      }
      c.a(c.this).beginTransaction();
      localObject1 = new HashSet();
      localObject4 = new HashSet();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.fts.b.c.a locala = (com.tencent.mm.plugin.fts.b.c.a)((Iterator)localObject3).next();
        com.tencent.mm.plugin.fts.a.a.f localf = (com.tencent.mm.plugin.fts.a.a.f)((HashMap)localObject2).remove(Integer.valueOf(locala.HwD));
        if (localf != null)
        {
          if (locala.timestamp != localf.field_timestamp)
          {
            ((HashSet)localObject4).add(localf);
            c.a(c.this).c(com.tencent.mm.plugin.fts.a.c.Hrc, localf.field_featureId);
            ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic().d(com.tencent.mm.plugin.fts.a.c.Hrc, String.valueOf(localf.field_featureId));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(locala.HwD));
        }
      }
      ((HashSet)localObject4).addAll(((HashMap)localObject2).values());
      c.a(c.this).commit();
      c.a(c.this).beginTransaction();
      this.HvH = ((HashSet)localObject1).size();
      this.add = ((HashSet)localObject4).size();
      localObject2 = ((HashSet)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.fts.a.a.f)((Iterator)localObject2).next();
        c.a(c.this, (com.tencent.mm.plugin.fts.a.a.f)localObject3);
        ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic().aEz(String.valueOf(((com.tencent.mm.plugin.fts.a.a.f)localObject3).field_featureId));
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        c.a(c.this).c(com.tencent.mm.plugin.fts.a.c.Hrc, ((Integer)localObject2).intValue());
      }
      c.a(c.this).commit();
      AppMethodBeat.o(52697);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52698);
      String str = String.format("{remove: %d add: %d}", new Object[] { Integer.valueOf(this.HvH), Integer.valueOf(this.add) });
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private b() {}
    
    /* Error */
    public final boolean aXz()
    {
      // Byte code:
      //   0: ldc 23
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 33	com/tencent/mm/plugin/fts/logic/c:fxO	()Lcom/tencent/mm/vfs/u;
      //   8: invokestatic 37	com/tencent/mm/plugin/fts/logic/c:U	(Lcom/tencent/mm/vfs/u;)I
      //   11: istore_2
      //   12: invokestatic 41	com/tencent/mm/plugin/fts/logic/c:fxQ	()I
      //   15: istore_3
      //   16: ldc 43
      //   18: ldc 45
      //   20: iconst_2
      //   21: anewarray 47	java/lang/Object
      //   24: dup
      //   25: iconst_0
      //   26: iload_2
      //   27: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   30: aastore
      //   31: dup
      //   32: iconst_1
      //   33: iload_3
      //   34: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   37: aastore
      //   38: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   41: iload_2
      //   42: istore_1
      //   43: iload_3
      //   44: iload_2
      //   45: if_icmple +11 -> 56
      //   48: iload_2
      //   49: istore_1
      //   50: iload_3
      //   51: ifle +5 -> 56
      //   54: iconst_m1
      //   55: istore_1
      //   56: iload_1
      //   57: ifge +159 -> 216
      //   60: invokestatic 64	com/tencent/mm/compatible/util/h:getAssets	()Landroid/content/res/AssetManager;
      //   63: astore 4
      //   65: aload 4
      //   67: ifnull +149 -> 216
      //   70: new 66	com/tencent/mm/vfs/u
      //   73: dup
      //   74: invokestatic 72	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   77: invokevirtual 78	android/content/Context:getCacheDir	()Ljava/io/File;
      //   80: ldc 80
      //   82: invokespecial 83	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   85: astore 5
      //   87: aload 5
      //   89: invokevirtual 86	com/tencent/mm/vfs/u:jKS	()Z
      //   92: ifeq +9 -> 101
      //   95: aload 5
      //   97: invokevirtual 89	com/tencent/mm/vfs/u:diJ	()Z
      //   100: pop
      //   101: aload 5
      //   103: invokevirtual 92	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
      //   106: invokevirtual 86	com/tencent/mm/vfs/u:jKS	()Z
      //   109: ifne +12 -> 121
      //   112: aload 5
      //   114: invokevirtual 92	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
      //   117: invokevirtual 95	com/tencent/mm/vfs/u:jKY	()Z
      //   120: pop
      //   121: aload 4
      //   123: ldc 80
      //   125: invokevirtual 101	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   128: astore 4
      //   130: new 103	com/tencent/mm/vfs/aa
      //   133: dup
      //   134: aload 5
      //   136: invokespecial 106	com/tencent/mm/vfs/aa:<init>	(Lcom/tencent/mm/vfs/u;)V
      //   139: astore 6
      //   141: aload 4
      //   143: aload 6
      //   145: invokestatic 112	org/apache/commons/b/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
      //   148: pop
      //   149: aload 6
      //   151: invokevirtual 115	com/tencent/mm/vfs/aa:close	()V
      //   154: new 117	com/tencent/mm/autogen/a/cd
      //   157: dup
      //   158: invokespecial 118	com/tencent/mm/autogen/a/cd:<init>	()V
      //   161: astore 6
      //   163: aload 6
      //   165: getfield 122	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
      //   168: bipush 35
      //   170: putfield 128	com/tencent/mm/autogen/a/cd$a:hCh	I
      //   173: aload 6
      //   175: getfield 122	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
      //   178: iconst_1
      //   179: putfield 131	com/tencent/mm/autogen/a/cd$a:subType	I
      //   182: aload 6
      //   184: getfield 122	com/tencent/mm/autogen/a/cd:hCg	Lcom/tencent/mm/autogen/a/cd$a;
      //   187: aload 5
      //   189: invokevirtual 135	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   192: invokestatic 141	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   195: putfield 145	com/tencent/mm/autogen/a/cd$a:filePath	Ljava/lang/String;
      //   198: aload 6
      //   200: invokestatic 151	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   203: invokevirtual 155	com/tencent/mm/autogen/a/cd:asyncPublish	(Landroid/os/Looper;)V
      //   206: aload 4
      //   208: ifnull +8 -> 216
      //   211: aload 4
      //   213: invokevirtual 158	java/io/InputStream:close	()V
      //   216: ldc 23
      //   218: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: iconst_1
      //   222: ireturn
      //   223: astore 5
      //   225: aload 6
      //   227: invokevirtual 115	com/tencent/mm/vfs/aa:close	()V
      //   230: ldc 23
      //   232: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   235: aload 5
      //   237: athrow
      //   238: astore 5
      //   240: aload 4
      //   242: ifnull +8 -> 250
      //   245: aload 4
      //   247: invokevirtual 158	java/io/InputStream:close	()V
      //   250: ldc 23
      //   252: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   255: aload 5
      //   257: athrow
      //   258: astore 4
      //   260: goto -44 -> 216
      //   263: astore 6
      //   265: aload 5
      //   267: aload 6
      //   269: invokevirtual 167	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   272: goto -42 -> 230
      //   275: astore 4
      //   277: aload 5
      //   279: aload 4
      //   281: invokevirtual 167	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   284: goto -34 -> 250
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	287	0	this	b
      //   42	15	1	i	int
      //   11	38	2	j	int
      //   15	36	3	k	int
      //   63	183	4	localObject1	Object
      //   258	1	4	localObject2	Object
      //   275	5	4	localThrowable1	java.lang.Throwable
      //   85	103	5	localu	u
      //   223	13	5	localObject3	Object
      //   238	40	5	localObject4	Object
      //   139	87	6	localObject5	Object
      //   263	5	6	localThrowable2	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   141	149	223	finally
      //   130	141	238	finally
      //   149	206	238	finally
      //   230	238	238	finally
      //   265	272	238	finally
      //   121	130	258	finally
      //   211	216	258	finally
      //   250	258	258	finally
      //   277	284	258	finally
      //   225	230	263	finally
      //   245	250	275	finally
    }
    
    public final String getName()
    {
      return "CheckFeatureResourceTask";
    }
  }
  
  final class c
    extends k
  {
    private c(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52700);
      paramm.FWt = j.cc(this.Htr.query, true);
      paramm.HtF = new ArrayList();
      Object localObject = new HashSet();
      Cursor localCursor = c.a(c.this).a(paramm.FWt, com.tencent.mm.plugin.fts.a.c.Hrc, this.Htr.Hty, true, true);
      while (localCursor.moveToNext())
      {
        p localp = new p();
        localp.l(localCursor);
        if ((!((HashSet)localObject).contains(Long.valueOf(localp.HtI))) && (!this.Htr.HtA.contains(localp.Hsz)))
        {
          localp.fxB();
          paramm.HtF.add(localp);
          ((HashSet)localObject).add(Long.valueOf(localp.HtI));
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(52700);
        throw paramm;
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
      }
      paramm = paramm.HtF.iterator();
      while (paramm.hasNext())
      {
        localObject = (o)paramm.next();
        ((o)localObject).HtQ = c.a(c.this).Wk((int)((o)localObject).HtI);
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
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private String path;
    
    public d(String paramString)
    {
      this.path = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52701);
      Object localObject = c.aEw(this.path);
      c.a(c.this).beginTransaction();
      c.a(c.this).hU((List)localObject);
      c.a(c.this).commit();
      c.a(c.this).F(com.tencent.mm.plugin.fts.a.c.Hrc);
      c.b(c.this).a(131132, new c.a(c.this, (byte)0));
      localObject = ((PluginFTS)com.tencent.mm.kernel.h.az(PluginFTS.class)).getTopHitsLogic();
      int[] arrayOfInt = com.tencent.mm.plugin.fts.a.c.Hrc;
      ((g)localObject).Hwi.w(arrayOfInt, 1);
      AppMethodBeat.o(52701);
      return true;
    }
    
    public final String getName()
    {
      return "UpdateFeatureIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.c
 * JD-Core Version:    0.7.0.1
 */