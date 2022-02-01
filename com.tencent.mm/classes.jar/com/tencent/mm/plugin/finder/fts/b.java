package com.tencent.mm.plugin.finder.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private a Buf;
  com.tencent.mm.plugin.fts.a.a.c Bug;
  private com.tencent.mm.plugin.fts.a.m msU;
  private MStorage.IOnStorageChange rpm;
  
  public b()
  {
    AppMethodBeat.i(330974);
    this.Bug = null;
    this.rpm = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        int i = 1;
        AppMethodBeat.i(331004);
        Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "FinderFollow storage change: event=%s | eventData=%s", new Object[] { paramAnonymousString, paramAnonymousMStorageEventData });
        switch (paramAnonymousMStorageEventData.eventId)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(331004);
          return;
          if ((paramAnonymousMStorageEventData.obj != null) && ((paramAnonymousMStorageEventData.obj instanceof String)) && ("FinderContact".equals(paramAnonymousString)))
          {
            if (b.this.Bug != null) {
              b.b(b.this).a(b.this.Bug);
            }
            paramAnonymousString = b.awh(paramAnonymousMStorageEventData.obj.toString());
            if (paramAnonymousString != null)
            {
              if (paramAnonymousString.field_follow_Flag == com.tencent.mm.plugin.finder.api.m.Axs) {}
              while (i != 0)
              {
                b.this.Bug = new b.b(b.this, paramAnonymousMStorageEventData.obj.toString());
                b.b(b.this).a(65646, b.this.Bug);
                AppMethodBeat.o(331004);
                return;
                i = 0;
              }
            }
            b.this.Bug = new b.a(b.this, paramAnonymousMStorageEventData.obj.toString());
            b.b(b.this).a(65646, b.this.Bug);
          }
        }
      }
    };
    AppMethodBeat.o(330974);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(331000);
    paraml = new c(paraml);
    paraml = this.msU.a(-65536, paraml);
    AppMethodBeat.o(331000);
    return paraml;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(331011);
    ((y)h.ax(y.class)).l(this.rpm);
    this.Buf = null;
    this.msU = null;
    AppMethodBeat.o(331011);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchFinderFollowerLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(331007);
    if (!((n)h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "Create Fail!");
      AppMethodBeat.o(331007);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "Create Success!");
    this.Buf = ((a)((n)h.az(n.class)).getFTSIndexStorage(1792));
    this.msU = ((n)h.az(n.class)).getFTSTaskDaemon();
    this.msU.a(65646, new d());
    ((y)h.ax(y.class)).m(this.rpm);
    AppMethodBeat.o(331007);
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
      AppMethodBeat.i(330946);
      Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "delete we app info id=%s", new Object[] { this.id });
      b.a(b.this).b(com.tencent.mm.plugin.fts.a.c.Hrh, this.id);
      AppMethodBeat.o(330946);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(330973);
      String str = String.format("{id: %s}", new Object[] { this.id });
      AppMethodBeat.o(330973);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteFinderFollowTask";
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
      AppMethodBeat.i(330936);
      b.a(b.this).beginTransaction();
      b.a(b.this).b(com.tencent.mm.plugin.fts.a.c.Hrh, this.id);
      com.tencent.mm.plugin.finder.api.m localm = b.awh(this.id);
      if (localm != null)
      {
        long l = System.currentTimeMillis();
        String str = localm.getUsername();
        int i = str.hashCode();
        b.a(b.this).a(589824, 1, i, str, l, localm.getNickname());
        b.a(b.this).a(589824, 2, i, str, l, d.bZ(localm.getNickname(), false));
        b.a(b.this).a(589824, 3, i, str, l, d.bZ(localm.getNickname(), true));
        this.name = localm.getNickname();
        Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "inserted we app info id = %s", new Object[] { str });
      }
      b.a(b.this).commit();
      AppMethodBeat.o(330936);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(330949);
      String str = String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
      AppMethodBeat.o(330949);
      return str;
    }
    
    public final String getName()
    {
      return "InsertFinderFollowTask";
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
      //   5: ldc 28
      //   7: invokestatic 34	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   10: checkcast 28	com/tencent/mm/plugin/findersdk/a/bw
      //   13: invokeinterface 38 1 0
      //   18: ifeq +16 -> 34
      //   21: ldc 40
      //   23: ldc 42
      //   25: invokestatic 47	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   28: ldc 20
      //   30: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   33: return
      //   34: aload_1
      //   35: aload_0
      //   36: getfield 54	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   39: getfield 60	com/tencent/mm/plugin/fts/a/a/l:query	Ljava/lang/String;
      //   42: iconst_1
      //   43: invokestatic 66	com/tencent/mm/plugin/fts/a/a/j:cc	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/fts/a/a/j;
      //   46: putfield 72	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   49: aload_1
      //   50: new 74	java/util/ArrayList
      //   53: dup
      //   54: invokespecial 77	java/util/ArrayList:<init>	()V
      //   57: putfield 81	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   60: new 83	java/util/HashSet
      //   63: dup
      //   64: invokespecial 84	java/util/HashSet:<init>	()V
      //   67: astore_3
      //   68: aload_0
      //   69: getfield 13	com/tencent/mm/plugin/finder/fts/b$c:Buh	Lcom/tencent/mm/plugin/finder/fts/b;
      //   72: invokestatic 87	com/tencent/mm/plugin/finder/fts/b:a	(Lcom/tencent/mm/plugin/finder/fts/b;)Lcom/tencent/mm/plugin/finder/fts/a;
      //   75: aload_1
      //   76: getfield 72	com/tencent/mm/plugin/fts/a/a/m:FWt	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   79: getstatic 93	com/tencent/mm/plugin/fts/a/c:Hrh	[I
      //   82: aload_0
      //   83: getfield 54	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   86: getfield 96	com/tencent/mm/plugin/fts/a/a/l:Hty	[I
      //   89: iconst_1
      //   90: iconst_1
      //   91: invokevirtual 101	com/tencent/mm/plugin/finder/fts/a:a	(Lcom/tencent/mm/plugin/fts/a/a/j;[I[IZZ)Landroid/database/Cursor;
      //   94: astore_2
      //   95: aload_2
      //   96: invokeinterface 106 1 0
      //   101: ifeq +111 -> 212
      //   104: new 108	com/tencent/mm/plugin/fts/a/a/p
      //   107: dup
      //   108: invokespecial 109	com/tencent/mm/plugin/fts/a/a/p:<init>	()V
      //   111: astore 4
      //   113: aload 4
      //   115: aload_2
      //   116: invokevirtual 113	com/tencent/mm/plugin/fts/a/a/p:l	(Landroid/database/Cursor;)Lcom/tencent/mm/plugin/fts/a/a/p;
      //   119: pop
      //   120: aload_3
      //   121: aload 4
      //   123: getfield 117	com/tencent/mm/plugin/fts/a/a/p:HtI	J
      //   126: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   129: invokevirtual 127	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   132: ifne -37 -> 95
      //   135: aload_0
      //   136: getfield 54	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   139: getfield 131	com/tencent/mm/plugin/fts/a/a/l:HtA	Ljava/util/HashSet;
      //   142: aload 4
      //   144: getfield 134	com/tencent/mm/plugin/fts/a/a/p:Hsz	Ljava/lang/String;
      //   147: invokevirtual 127	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   150: ifne -55 -> 95
      //   153: aload 4
      //   155: invokevirtual 137	com/tencent/mm/plugin/fts/a/a/p:fxB	()V
      //   158: aload_1
      //   159: getfield 81	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   162: aload 4
      //   164: invokeinterface 142 2 0
      //   169: pop
      //   170: aload_3
      //   171: aload 4
      //   173: getfield 117	com/tencent/mm/plugin/fts/a/a/p:HtI	J
      //   176: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   179: invokevirtual 143	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   182: pop
      //   183: goto -88 -> 95
      //   186: astore_1
      //   187: ldc 20
      //   189: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   192: aload_1
      //   193: athrow
      //   194: astore_1
      //   195: aload_2
      //   196: ifnull +9 -> 205
      //   199: aload_2
      //   200: invokeinterface 146 1 0
      //   205: ldc 20
      //   207: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   210: aload_1
      //   211: athrow
      //   212: aload_2
      //   213: ifnull +9 -> 222
      //   216: aload_2
      //   217: invokeinterface 146 1 0
      //   222: invokestatic 151	java/lang/Thread:interrupted	()Z
      //   225: ifeq +18 -> 243
      //   228: new 153	java/lang/InterruptedException
      //   231: dup
      //   232: invokespecial 154	java/lang/InterruptedException:<init>	()V
      //   235: astore_1
      //   236: ldc 20
      //   238: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   241: aload_1
      //   242: athrow
      //   243: aload_0
      //   244: getfield 54	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   247: getfield 158	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   250: ifnull +17 -> 267
      //   253: aload_1
      //   254: getfield 81	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   257: aload_0
      //   258: getfield 54	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   261: getfield 158	com/tencent/mm/plugin/fts/a/a/l:HtB	Ljava/util/Comparator;
      //   264: invokestatic 164	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   267: ldc 20
      //   269: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   272: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	273	0	this	c
      //   0	273	1	paramm	com.tencent.mm.plugin.fts.a.a.m
      //   94	123	2	localCursor	android.database.Cursor
      //   67	104	3	localHashSet	java.util.HashSet
      //   111	61	4	localp	com.tencent.mm.plugin.fts.a.a.p
      // Exception table:
      //   from	to	target	type
      //   95	183	186	finally
      //   187	194	194	finally
    }
    
    public final int getId()
    {
      return 47;
    }
    
    public final String getName()
    {
      return "SearchFinderFollowTask";
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int rpo;
    
    d() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(330947);
      Object localObject = ((y)h.ax(y.class)).ePu();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "FinderFollow recent usage list is nil.");
        AppMethodBeat.o(330947);
        return true;
      }
      this.rpo = ((List)localObject).size();
      b.a(b.this).beginTransaction();
      b.a(b.this).F(com.tencent.mm.plugin.fts.a.c.Hrh);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        au localau = (au)((Iterator)localObject).next();
        if (Util.isNullOrNil(localau.field_nickname))
        {
          Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "contact = " + localau.field_nickname + "， contact.username = " + localau.field_username + ", updateSize = " + this.rpo);
          this.rpo -= 1;
        }
        else
        {
          Log.i("MicroMsg.FTS.FTS5SearchFinderFollowerLogic", "contact = " + localau.field_nickname + "， contact.username = " + localau.field_username + ", updateSize = " + this.rpo);
          String str = localau.field_username;
          int i = str.hashCode();
          long l = System.currentTimeMillis();
          b.a(b.this).a(589824, 1, i, str, l, localau.field_nickname);
          b.a(b.this).a(589824, 2, i, str, l, d.bZ(localau.field_nickname, false));
          b.a(b.this).a(589824, 3, i, str, l, d.bZ(localau.field_nickname, true));
        }
      }
      b.a(b.this).commit();
      AppMethodBeat.o(330947);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(330956);
      String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.rpo) });
      AppMethodBeat.o(330956);
      return str;
    }
    
    public final String getName()
    {
      return "UpdateFinderFollowIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.b
 * JD-Core Version:    0.7.0.1
 */