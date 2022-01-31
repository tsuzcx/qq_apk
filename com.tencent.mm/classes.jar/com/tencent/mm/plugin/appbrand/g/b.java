package com.tencent.mm.plugin.appbrand.g;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m dBO;
  c fYt;
  private j.a fYu = new b.1(this);
  
  protected final boolean BB()
  {
    i.onDestroy();
    i.f(this.fYu);
    this.fYt = null;
    this.dBO = null;
    return true;
  }
  
  public final a a(com.tencent.mm.plugin.fts.a.a.i parami)
  {
    parami = new c(parami);
    return this.dBO.a(-65536, parami);
  }
  
  public final String getName()
  {
    return "FTS5SearchWeAppLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)com.tencent.mm.kernel.g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
    this.fYt = ((c)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(512));
    this.dBO = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon();
    this.dBO.a(65616, new b.d(this));
    i.onCreate();
    i.e(this.fYu);
    return true;
  }
  
  final class c
    extends h
  {
    c(com.tencent.mm.plugin.fts.a.a.i parami)
    {
      super();
    }
    
    protected final void a(j paramj)
    {
      paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.bVk, true);
      paramj.kxh = new ArrayList();
      HashSet localHashSet = new HashSet();
      Cursor localCursor = b.this.fYt.a(paramj.kwi, com.tencent.mm.plugin.fts.a.c.kuR, this.kwT.kxb, true, true);
      try
      {
        while (localCursor.moveToNext())
        {
          com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m();
          localm.j(localCursor);
          if ((!localHashSet.contains(Long.valueOf(localm.kxk))) && (!this.kwT.kxd.contains(localm.kwg)))
          {
            localm.aVA();
            paramj.kxh.add(localm);
            localHashSet.add(Long.valueOf(localm.kxk));
          }
        }
        if (localCursor == null) {
          break label178;
        }
      }
      catch (Throwable paramj)
      {
        throw paramj;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      localCursor.close();
      label178:
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      if (this.kwT.kxe != null) {
        Collections.sort(paramj.kxh, this.kwT.kxe);
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b
 * JD-Core Version:    0.7.0.1
 */