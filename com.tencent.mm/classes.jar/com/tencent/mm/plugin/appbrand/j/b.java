package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m hgI;
  c lqS;
  private MStorage.IOnStorageChange lqT;
  
  public b()
  {
    AppMethodBeat.i(45018);
    this.lqT = new MStorage.IOnStorageChange()
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
                b.this.hgI.a(65616, new b.b(b.this, paramAnonymousMStorageEventData));
              }
              AppMethodBeat.o(45010);
            }
          }
          else
          {
            b.this.hgI.a(65616, new b.b(b.this, paramAnonymousMStorageEventData.obj.toString()));
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
                  b.this.hgI.a(65616, new b.a(b.this, paramAnonymousMStorageEventData));
                }
                AppMethodBeat.o(45010);
              }
            }
            else {
              b.this.hgI.a(65616, new b.a(b.this, paramAnonymousMStorageEventData.obj.toString()));
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
    paramj = this.hgI.a(-65536, paramj);
    AppMethodBeat.o(45019);
    return paramj;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(45021);
    i.onDestroy();
    i.d(this.lqT);
    this.lqS = null;
    this.hgI = null;
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
      AppMethodBeat.o(45020);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
    this.lqS = ((c)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(512));
    this.hgI = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.hgI.a(65616, new d());
    i.onCreate();
    i.c(this.lqT);
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
    
    public final String bCQ()
    {
      AppMethodBeat.i(45012);
      String str = String.format("{id: %s}", new Object[] { this.id });
      AppMethodBeat.o(45012);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45011);
      Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[] { this.id });
      b.this.lqS.a(com.tencent.mm.plugin.fts.a.c.wUG, this.id);
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
    
    public final String bCQ()
    {
      AppMethodBeat.i(45014);
      String str = String.format("{name: %s id: %s}", new Object[] { this.name, this.id });
      AppMethodBeat.o(45014);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45013);
      b.this.lqS.beginTransaction();
      b.this.lqS.a(com.tencent.mm.plugin.fts.a.c.wUG, this.id);
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = i.YG(this.id);
      if (localAppBrandRecentTaskInfo != null)
      {
        long l = System.currentTimeMillis();
        String str = Util.nullAsNil(localAppBrandRecentTaskInfo.gLc);
        int i = str.hashCode();
        b.this.lqS.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.this.lqS.a(393216, 2, i, str, l, d.bB(localAppBrandRecentTaskInfo.appName, false));
        b.this.lqS.a(393216, 3, i, str, l, d.bB(localAppBrandRecentTaskInfo.appName, true));
        this.name = localAppBrandRecentTaskInfo.appName;
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[] { str });
      }
      b.this.lqS.commit();
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
      paramk.wWd = h.bE(this.wWO.query, true);
      paramk.wXb = new ArrayList();
      HashSet localHashSet = new HashSet();
      Cursor localCursor = b.this.lqS.a(paramk.wWd, com.tencent.mm.plugin.fts.a.c.wUG, this.wWO.wWV, true, true);
      try
      {
        while (localCursor.moveToNext())
        {
          com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n();
          localn.i(localCursor);
          if ((!localHashSet.contains(Long.valueOf(localn.wXe))) && (!this.wWO.wWX.contains(localn.wVX)))
          {
            localn.dOC();
            paramk.wXb.add(localn);
            localHashSet.add(Long.valueOf(localn.wXe));
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
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
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
    private int lqV;
    
    d() {}
    
    public final String bCQ()
    {
      AppMethodBeat.i(45017);
      String str = String.format("{updateSize: %d}", new Object[] { Integer.valueOf(this.lqV) });
      AppMethodBeat.o(45017);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(45016);
      Object localObject = i.bCT();
      if (((List)localObject).isEmpty())
      {
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
        AppMethodBeat.o(45016);
        return true;
      }
      this.lqV = ((List)localObject).size();
      b.this.lqS.beginTransaction();
      b.this.lqS.B(com.tencent.mm.plugin.fts.a.c.wUG);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)((Iterator)localObject).next();
        String str = Util.nullAsNil(localAppBrandRecentTaskInfo.gLc);
        int i = str.hashCode();
        long l = System.currentTimeMillis();
        b.this.lqS.a(393216, 1, i, str, l, localAppBrandRecentTaskInfo.appName);
        b.this.lqS.a(393216, 2, i, str, l, d.bB(localAppBrandRecentTaskInfo.appName, false));
        b.this.lqS.a(393216, 3, i, str, l, d.bB(localAppBrandRecentTaskInfo.appName, true));
      }
      b.this.lqS.commit();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b
 * JD-Core Version:    0.7.0.1
 */