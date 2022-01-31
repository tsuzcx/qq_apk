package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$j
  extends h
{
  public a$j(a parama, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136682);
    paramj.mRX = g.aU(this.mSJ.query, true);
    Object localObject1 = a.a(this.mUg).a(paramj.mRX, this.mSJ.mSP, this.mSJ.mSQ, true, true);
    Object localObject2 = new HashMap();
    HashMap localHashMap = new HashMap();
    while (((Cursor)localObject1).moveToNext())
    {
      m localm = new m().i((Cursor)localObject1);
      if (!this.mSJ.mSS.contains(localm.mRV))
      {
        l locall;
        if (d.h(c.mQI, localm.type))
        {
          locall = (l)((HashMap)localObject2).get(localm.mRV);
          if ((locall == null) || (d.f(c.mQT, localm.mRU, locall.mRU) < 0)) {
            ((HashMap)localObject2).put(localm.mRV, localm);
          }
        }
        while (Thread.interrupted())
        {
          ((Cursor)localObject1).close();
          paramj = new InterruptedException();
          AppMethodBeat.o(136682);
          throw paramj;
          if (d.h(c.mQK, localm.type))
          {
            locall = (l)localHashMap.get(Long.valueOf(localm.mSZ));
            if ((locall == null) || (d.f(c.mQT, localm.mRU, locall.mRU) < 0)) {
              localHashMap.put(Long.valueOf(localm.mSZ), localm);
            }
          }
        }
      }
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(136682);
      throw paramj;
    }
    paramj.mSW = new ArrayList(((HashMap)localObject2).size());
    localObject1 = ((HashMap)localObject2).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      ((m)localObject2).bCa();
      ((m)localObject2).a(paramj.mRX);
      paramj.mSW.add(localObject2);
    }
    paramj.mSW.addAll(localHashMap.values());
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(136682);
      throw paramj;
    }
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    AppMethodBeat.o(136682);
  }
  
  public final int getId()
  {
    return 11;
  }
  
  public final String getName()
  {
    return "SearchContactLogic.SearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.j
 * JD-Core Version:    0.7.0.1
 */