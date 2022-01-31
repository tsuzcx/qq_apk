package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m ezf;
  private com.tencent.mm.plugin.fts.a.j muH;
  a muI;
  e muJ;
  private k.a muK;
  
  public b()
  {
    AppMethodBeat.i(5312);
    this.muK = new b.1(this);
    AppMethodBeat.o(5312);
  }
  
  private int a(String[] paramArrayOfString, int[] paramArrayOfInt, long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    AppMethodBeat.i(5315);
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
          break label190;
        }
        str1 = null;
        paramArrayOfString = null;
      }
    }
    label190:
    for (;;)
    {
      if ((str1 != null) && (str1.equalsIgnoreCase(paramArrayOfString))) {
        paramArrayOfString = null;
      }
      for (;;)
      {
        this.muI.a(paramArrayOfInt[0], paramLong1, paramString, paramLong2, str2, paramInt);
        j = 1;
        i = j;
        if (str1 != null)
        {
          i = j;
          if (str1.length() > 0)
          {
            this.muI.a(paramArrayOfInt[1], paramLong1, paramString, paramLong2, str1, paramInt);
            i = 2;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length() > 0))
        {
          this.muI.a(paramArrayOfInt[2], paramLong1, paramString, paramLong2, paramArrayOfString, paramInt);
          i += 1;
        }
        for (;;)
        {
          AppMethodBeat.o(5315);
          return i;
        }
      }
    }
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(5314);
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(this.muK);
    this.muI = null;
    this.ezf = null;
    AppMethodBeat.o(5314);
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    AppMethodBeat.i(5311);
    if (parami.hdl == 1) {}
    for (parami = new b.f(this, parami);; parami = new e(parami))
    {
      parami = this.ezf.a(-65536, parami);
      AppMethodBeat.o(5311);
      return parami;
    }
  }
  
  public final String getName()
  {
    return "FTS5SearchFavoriteLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(5313);
    if (!((n)com.tencent.mm.kernel.g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
      AppMethodBeat.o(5313);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
    this.ezf = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSTaskDaemon();
    this.muI = ((a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(256));
    this.muH = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSMainDB();
    this.muJ = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwI();
    this.ezf.a(131122, new b.a(this, (byte)0));
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(this.muK);
    AppMethodBeat.o(5313);
    return true;
  }
  
  final class e
    extends h
  {
    e(i parami)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      AppMethodBeat.i(5309);
      paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.aU(this.mSJ.query, true);
      Object localObject1 = new HashMap();
      Object localObject2 = b.this.muI.a(paramj.mRX, c.mQB, null, false, false);
      while (((Cursor)localObject2).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m().i((Cursor)localObject2);
        l locall = (l)((HashMap)localObject1).get(Long.valueOf(localm.mSZ));
        if ((locall == null) || (d.f(c.mQU, localm.mRU, locall.mRU) < 0)) {
          ((HashMap)localObject1).put(Long.valueOf(localm.mSZ), localm);
        }
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          paramj = new InterruptedException();
          AppMethodBeat.o(5309);
          throw paramj;
        }
      }
      ((Cursor)localObject2).close();
      if (Thread.interrupted())
      {
        paramj = new InterruptedException();
        AppMethodBeat.o(5309);
        throw paramj;
      }
      paramj.mSW = new ArrayList(((HashMap)localObject1).size());
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        paramj.mSW.add(localObject2);
      }
      if (this.mSJ.mST != null) {
        Collections.sort(paramj.mSW, this.mSJ.mST);
      }
      AppMethodBeat.o(5309);
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