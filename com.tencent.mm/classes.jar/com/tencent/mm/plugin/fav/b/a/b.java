package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m dBO;
  private com.tencent.mm.plugin.fts.a.j kal;
  a kam;
  e kan;
  private j.a kao = new b.1(this);
  
  private int a(String[] paramArrayOfString, int[] paramArrayOfInt, long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    int j = 0;
    String str2 = paramArrayOfString[0];
    String str1 = paramArrayOfString[1];
    paramArrayOfString = paramArrayOfString[2];
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0)
      {
        if (!str2.equalsIgnoreCase(str1)) {
          break label178;
        }
        str1 = null;
        paramArrayOfString = null;
      }
    }
    label178:
    for (;;)
    {
      if ((str1 != null) && (str1.equalsIgnoreCase(paramArrayOfString))) {
        paramArrayOfString = null;
      }
      for (;;)
      {
        this.kam.a(paramArrayOfInt[0], paramLong1, paramString, paramLong2, str2, paramInt);
        j = 1;
        i = j;
        if (str1 != null)
        {
          i = j;
          if (str1.length() > 0)
          {
            this.kam.a(paramArrayOfInt[1], paramLong1, paramString, paramLong2, str1, paramInt);
            i = 2;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length() > 0))
        {
          this.kam.a(paramArrayOfInt[2], paramLong1, paramString, paramLong2, paramArrayOfString, paramInt);
          i += 1;
          return i;
        }
        return i;
      }
    }
  }
  
  protected final boolean BB()
  {
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(this.kao);
    this.kam = null;
    this.dBO = null;
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    if (parami.kwX == 1) {}
    for (parami = new b.f(this, parami);; parami = new e(parami)) {
      return this.dBO.a(-65536, parami);
    }
  }
  
  public final String getName()
  {
    return "FTS5SearchFavoriteLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)com.tencent.mm.kernel.g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
    this.dBO = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon();
    this.kam = ((a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(256));
    this.kal = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB();
    this.kan = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQt();
    this.dBO.a(131122, new b.a(this, (byte)0));
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(this.kao);
    return true;
  }
  
  private final class e
    extends h
  {
    e(i parami)
    {
      super();
    }
    
    protected final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.bVk, true);
      Object localObject1 = new HashMap();
      Object localObject2 = b.this.kam.a(paramj.kwi, c.kuO, null, false, false);
      while (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m().j((Cursor)localObject2);
        l locall = (l)((HashMap)localObject1).get(Long.valueOf(localm.kxk));
        if ((locall == null) || (d.e(c.kvh, localm.kwf, locall.kwf) < 0)) {
          ((HashMap)localObject1).put(Long.valueOf(localm.kxk), localm);
        }
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          throw new InterruptedException();
        }
      }
      ((Cursor)localObject2).close();
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      paramj.kxh = new ArrayList(((HashMap)localObject1).size());
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        paramj.kxh.add(localObject2);
      }
      if (this.kwT.kxe != null) {
        Collections.sort(paramj.kxh, this.kwT.kxe);
      }
    }
    
    public final String getName()
    {
      return "SearchFavoriteTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b
 * JD-Core Version:    0.7.0.1
 */