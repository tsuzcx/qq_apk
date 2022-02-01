package com.tencent.mm.plugin.appbrand.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m fUc;
  c jpu;
  private k.a jpv;
  
  public b()
  {
    AppMethodBeat.i(45018);
    this.jpv = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(45010);
        ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[] { paramAnonymousString, paramAnonymousm });
        switch (paramAnonymousm.jqR)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(45010);
          return;
          if ("batch".equals(paramAnonymousString))
          {
            if ((paramAnonymousm.obj != null) && ((paramAnonymousm.obj instanceof List)))
            {
              paramAnonymousString = ((List)paramAnonymousm.obj).iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousm = (String)paramAnonymousString.next();
                b.this.fUc.a(65616, new b.b(b.this, paramAnonymousm));
              }
              AppMethodBeat.o(45010);
            }
          }
          else
          {
            b.this.fUc.a(65616, new b.b(b.this, paramAnonymousm.obj.toString()));
            AppMethodBeat.o(45010);
            return;
            if ("batch".equals(paramAnonymousString))
            {
              if ((paramAnonymousm.obj != null) && ((paramAnonymousm.obj instanceof List)))
              {
                paramAnonymousString = ((List)paramAnonymousm.obj).iterator();
                while (paramAnonymousString.hasNext())
                {
                  paramAnonymousm = (String)paramAnonymousString.next();
                  b.this.fUc.a(65616, new b.a(b.this, paramAnonymousm));
                }
                AppMethodBeat.o(45010);
              }
            }
            else {
              b.this.fUc.a(65616, new b.a(b.this, paramAnonymousm.obj.toString()));
            }
          }
        }
      }
    };
    AppMethodBeat.o(45018);
  }
  
  public final a a(j paramj)
  {
    AppMethodBeat.i(45019);
    paramj = new c(paramj);
    paramj = this.fUc.a(-65536, paramj);
    AppMethodBeat.o(45019);
    return paramj;
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(45021);
    i.onDestroy();
    i.d(this.jpv);
    this.jpu = null;
    this.fUc = null;
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
      AppMethodBeat.o(45020);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
    this.jpu = ((c)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(512));
    this.fUc = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.fUc.a(65616, new d());
    i.onCreate();
    i.c(this.jpv);
    AppMethodBeat.o(45020);
    return true;
  }
  
  final class a
    extends a
  {
    private String id;
    
    public a(String paramString)
    {
      this.id = paramString;
    }
    
    public final String aWs()
    {
      AppMethodBeat.i(45012);
      String str = String.format("{id: %s}", new Object[] { this.id });
      AppMethodBeat.o(45012);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45011);
      ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[] { this.id });
      b.this.jpu.a(com.tencent.mm.plugin.fts.a.c.rnv, this.id);
      AppMethodBeat.o(45011);
      return true;
    }
    
    public final String getName()
    {
      return "DeleteWeAppTask";
    }
  }
  
  final class b
    extends a
  {
    private String id;
    private String name;
    
    public b(String paramString)
    {
      this.id = paramString;
    }
    
    public final String aWs()
    {
      AppMethodBeat.i(45014);
      String str = String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
      AppMethodBeat.o(45014);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45013);
      b.this.jpu.beginTransaction();
      b.this.jpu.a(com.tencent.mm.plugin.fts.a.c.rnv, this.id);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = i.Hp(this.id);
      if (localAppBrandRecentTaskInfo != null)
      {
        long l = System.currentTimeMillis();
        String str = bt.nullAsNil(localAppBrandRecentTaskInfo.fGf);
        int i = str.hashCode();
        b.this.jpu.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.this.jpu.a(393216, 2, i, str, l, d.aZ(localAppBrandRecentTaskInfo.appName, false));
        b.this.jpu.a(393216, 3, i, str, l, d.aZ(localAppBrandRecentTaskInfo.appName, true));
        this.name = localAppBrandRecentTaskInfo.appName;
        ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[] { str });
      }
      b.this.jpu.commit();
      AppMethodBeat.o(45013);
      return true;
    }
    
    public final String getName()
    {
      return "InsertWeAppTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.i
  {
    c(j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(45015);
      paramk.roS = h.bc(this.rpD.query, true);
      paramk.rpQ = new ArrayList();
      HashSet localHashSet = new HashSet();
      Cursor localCursor = b.this.jpu.a(paramk.roS, com.tencent.mm.plugin.fts.a.c.rnv, this.rpD.rpK, true, true);
      try
      {
        while (localCursor.moveToNext())
        {
          com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
          localn.j(localCursor);
          if ((!localHashSet.contains(Long.valueOf(localn.rpT))) && (!this.rpD.rpM.contains(localn.roN)))
          {
            localn.cxn();
            paramk.rpQ.add(localn);
            localHashSet.add(Long.valueOf(localn.rpT));
          }
        }
        if (localCursor == null) {
          break label193;
        }
      }
      catch (Throwable paramk)
      {
        AppMethodBeat.o(45015);
        throw paramk;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        AppMethodBeat.o(45015);
      }
      localCursor.close();
      label193:
      if (Thread.interrupted())
      {
        paramk = new InterruptedException();
        AppMethodBeat.o(45015);
        throw paramk;
      }
      if (this.rpD.rpN != null) {
        Collections.sort(paramk.rpQ, this.rpD.rpN);
      }
      AppMethodBeat.o(45015);
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
    extends a
  {
    private int jpx;
    
    d() {}
    
    public final String aWs()
    {
      AppMethodBeat.i(45017);
      String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.jpx) });
      AppMethodBeat.o(45017);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45016);
      Object localObject = i.aWv();
      if (((List)localObject).isEmpty())
      {
        ad.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
        AppMethodBeat.o(45016);
        return true;
      }
      this.jpx = ((List)localObject).size();
      b.this.jpu.beginTransaction();
      b.this.jpu.y(com.tencent.mm.plugin.fts.a.c.rnv);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)((Iterator)localObject).next();
        String str = bt.nullAsNil(localAppBrandRecentTaskInfo.fGf);
        int i = str.hashCode();
        long l = System.currentTimeMillis();
        b.this.jpu.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.this.jpu.a(393216, 2, i, str, l, d.aZ(localAppBrandRecentTaskInfo.appName, false));
        b.this.jpu.a(393216, 3, i, str, l, d.aZ(localAppBrandRecentTaskInfo.appName, true));
      }
      b.this.jpu.commit();
      AppMethodBeat.o(45016);
      return true;
    }
    
    public final String getName()
    {
      return "UpdateWeAppIndexTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.b
 * JD-Core Version:    0.7.0.1
 */