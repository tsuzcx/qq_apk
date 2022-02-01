package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private m msU;
  private c rpl;
  private MStorage.IOnStorageChange rpm;
  
  public b()
  {
    AppMethodBeat.i(45018);
    this.rpm = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(45010);
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[] { paramAnonymousString, paramAnonymousMStorageEventData });
        switch (paramAnonymousMStorageEventData.eventId)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(45010);
          return;
          if ("batch".equals(paramAnonymousString))
          {
            if ((paramAnonymousMStorageEventData.obj != null) && ((paramAnonymousMStorageEventData.obj instanceof List)))
            {
              paramAnonymousString = ((List)paramAnonymousMStorageEventData.obj).iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousMStorageEventData = (String)paramAnonymousString.next();
                b.b(b.this).a(65616, new b.b(b.this, paramAnonymousMStorageEventData));
              }
              AppMethodBeat.o(45010);
            }
          }
          else
          {
            b.b(b.this).a(65616, new b.b(b.this, paramAnonymousMStorageEventData.obj.toString()));
            AppMethodBeat.o(45010);
            return;
            if ("batch".equals(paramAnonymousString))
            {
              if ((paramAnonymousMStorageEventData.obj != null) && ((paramAnonymousMStorageEventData.obj instanceof List)))
              {
                paramAnonymousString = ((List)paramAnonymousMStorageEventData.obj).iterator();
                while (paramAnonymousString.hasNext())
                {
                  paramAnonymousMStorageEventData = (String)paramAnonymousString.next();
                  b.b(b.this).a(65616, new b.a(b.this, paramAnonymousMStorageEventData));
                }
                AppMethodBeat.o(45010);
              }
            }
            else {
              b.b(b.this).a(65616, new b.a(b.this, paramAnonymousMStorageEventData.obj.toString()));
            }
          }
        }
      }
    };
    AppMethodBeat.o(45018);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(45019);
    paraml = new c(paraml);
    paraml = this.msU.a(-65536, paraml);
    AppMethodBeat.o(45019);
    return paraml;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(45021);
    i.onDestroy();
    i.d(this.rpm);
    this.rpl = null;
    this.msU = null;
    AppMethodBeat.o(45021);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchWeAppLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(45020);
    if (!((n)h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
      AppMethodBeat.o(45020);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
    this.rpl = ((c)((n)h.az(n.class)).getFTSIndexStorage(512));
    this.msU = ((n)h.az(n.class)).getFTSTaskDaemon();
    this.msU.a(65616, new d());
    i.onCreate();
    i.c(this.rpm);
    AppMethodBeat.o(45020);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private String id;
    
    public a(String paramString)
    {
      this.id = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(45011);
      Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[] { this.id });
      b.a(b.this).b(com.tencent.mm.plugin.fts.a.c.Hre, this.id);
      AppMethodBeat.o(45011);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(45012);
      String str = String.format("{id: %s}", new Object[] { this.id });
      AppMethodBeat.o(45012);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteWeAppTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private String id;
    private String name;
    
    public b(String paramString)
    {
      this.id = paramString;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(45013);
      b.a(b.this).beginTransaction();
      b.a(b.this).b(com.tencent.mm.plugin.fts.a.c.Hre, this.id);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = i.Zp(this.id);
      if (localAppBrandRecentTaskInfo != null)
      {
        long l = System.currentTimeMillis();
        String str = Util.nullAsNil(localAppBrandRecentTaskInfo.lYI);
        int i = str.hashCode();
        b.a(b.this).a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.a(b.this).a(393216, 2, i, str, l, d.bZ(localAppBrandRecentTaskInfo.appName, false));
        b.a(b.this).a(393216, 3, i, str, l, d.bZ(localAppBrandRecentTaskInfo.appName, true));
        this.name = localAppBrandRecentTaskInfo.appName;
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[] { str });
      }
      b.a(b.this).commit();
      AppMethodBeat.o(45013);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(45014);
      String str = String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
      AppMethodBeat.o(45014);
      return str;
    }
    
    public final String getName()
    {
      return "InsertWeAppTask";
    }
  }
  
  final class c
    extends k
  {
    c(l paraml)
    {
      super();
    }
    
    /* Error */
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      // Byte code:
      //   0: ldc 20
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: aload_0
      //   7: getfield 30	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   10: getfield 36	com/tencent/mm/plugin/fts/a/a/l:query	Ljava/lang/String;
      //   13: iconst_1
      //   14: invokestatic 42	com/tencent/mm/plugin/fts/a/a/j:cc	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/fts/a/a/j;
      //   17: putfield 48	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   20: aload_1
      //   21: new 50	java/util/ArrayList
      //   24: dup
      //   25: invokespecial 53	java/util/ArrayList:<init>	()V
      //   28: putfield 57	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   31: new 59	java/util/HashSet
      //   34: dup
      //   35: invokespecial 60	java/util/HashSet:<init>	()V
      //   38: astore_3
      //   39: aload_0
      //   40: getfield 13	com/tencent/mm/plugin/appbrand/j/b$c:rpn	Lcom/tencent/mm/plugin/appbrand/j/b;
      //   43: invokestatic 63	com/tencent/mm/plugin/appbrand/j/b:a	(Lcom/tencent/mm/plugin/appbrand/j/b;)Lcom/tencent/mm/plugin/appbrand/j/c;
      //   46: aload_1
      //   47: getfield 48	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   50: getstatic 69	com/tencent/mm/plugin/fts/a/c:Hre	[I
      //   53: aload_0
      //   54: getfield 30	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   57: getfield 72	com/tencent/mm/plugin/fts/a/a/l:Hty	[I
      //   60: iconst_1
      //   61: iconst_1
      //   62: invokevirtual 77	com/tencent/mm/plugin/appbrand/j/c:a	(Lcom/tencent/mm/plugin/fts/a/a/j;[I[IZZ)Landroid/database/Cursor;
      //   65: astore_2
      //   66: aload_2
      //   67: invokeinterface 83 1 0
      //   72: ifeq +111 -> 183
      //   75: new 85	com/tencent/mm/plugin/fts/a/a/p
      //   78: dup
      //   79: invokespecial 86	com/tencent/mm/plugin/fts/a/a/p:<init>	()V
      //   82: astore 4
      //   84: aload 4
      //   86: aload_2
      //   87: invokevirtual 90	com/tencent/mm/plugin/fts/a/a/p:l	(Landroid/database/Cursor;)Lcom/tencent/mm/plugin/fts/a/a/p;
      //   90: pop
      //   91: aload_3
      //   92: aload 4
      //   94: getfield 94	com/tencent/mm/plugin/fts/a/a/p:HtI	J
      //   97: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   100: invokevirtual 104	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   103: ifne -37 -> 66
      //   106: aload_0
      //   107: getfield 30	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   110: getfield 108	com/tencent/mm/plugin/fts/a/a/l:HtA	Ljava/util/HashSet;
      //   113: aload 4
      //   115: getfield 111	com/tencent/mm/plugin/fts/a/a/p:Hsz	Ljava/lang/String;
      //   118: invokevirtual 104	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   121: ifne -55 -> 66
      //   124: aload 4
      //   126: invokevirtual 114	com/tencent/mm/plugin/fts/a/a/p:fxB	()V
      //   129: aload_1
      //   130: getfield 57	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   133: aload 4
      //   135: invokeinterface 119 2 0
      //   140: pop
      //   141: aload_3
      //   142: aload 4
      //   144: getfield 94	com/tencent/mm/plugin/fts/a/a/p:HtI	J
      //   147: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   150: invokevirtual 120	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   153: pop
      //   154: goto -88 -> 66
      //   157: astore_1
      //   158: ldc 20
      //   160: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: aload_1
      //   164: athrow
      //   165: astore_1
      //   166: aload_2
      //   167: ifnull +9 -> 176
      //   170: aload_2
      //   171: invokeinterface 126 1 0
      //   176: ldc 20
      //   178: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   181: aload_1
      //   182: athrow
      //   183: aload_2
      //   184: ifnull +9 -> 193
      //   187: aload_2
      //   188: invokeinterface 126 1 0
      //   193: invokestatic 131	java/lang/Thread:interrupted	()Z
      //   196: ifeq +18 -> 214
      //   199: new 133	java/lang/InterruptedException
      //   202: dup
      //   203: invokespecial 134	java/lang/InterruptedException:<init>	()V
      //   206: astore_1
      //   207: ldc 20
      //   209: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_1
      //   213: athrow
      //   214: aload_0
      //   215: getfield 30	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   218: getfield 138	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   221: ifnull +17 -> 238
      //   224: aload_1
      //   225: getfield 57	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   228: aload_0
      //   229: getfield 30	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   232: getfield 138	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   235: invokestatic 144	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   238: ldc 20
      //   240: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   243: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	244	0	this	c
      //   0	244	1	paramm	com.tencent.mm.plugin.fts.a.a.m
      //   65	123	2	localCursor	android.database.Cursor
      //   38	104	3	localHashSet	java.util.HashSet
      //   82	61	4	localp	com.tencent.mm.plugin.fts.a.a.p
      // Exception table:
      //   from	to	target	type
      //   66	154	157	finally
      //   158	165	165	finally
    }
    
    public final int getId()
    {
      return 21;
    }
    
    public final String getName()
    {
      return "SearchWeAppTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int rpo;
    
    d() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(45016);
      Object localObject = i.coD();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
        AppMethodBeat.o(45016);
        return true;
      }
      this.rpo = ((List)localObject).size();
      b.a(b.this).beginTransaction();
      b.a(b.this).F(com.tencent.mm.plugin.fts.a.c.Hre);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)((Iterator)localObject).next();
        String str = Util.nullAsNil(localAppBrandRecentTaskInfo.lYI);
        int i = str.hashCode();
        long l = System.currentTimeMillis();
        b.a(b.this).a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.a(b.this).a(393216, 2, i, str, l, d.bZ(localAppBrandRecentTaskInfo.appName, false));
        b.a(b.this).a(393216, 3, i, str, l, d.bZ(localAppBrandRecentTaskInfo.appName, true));
      }
      b.a(b.this).commit();
      AppMethodBeat.o(45016);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(45017);
      String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.rpo) });
      AppMethodBeat.o(45017);
      return str;
    }
    
    public final String getName()
    {
      return "UpdateWeAppIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b
 * JD-Core Version:    0.7.0.1
 */