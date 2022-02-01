package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class c$h
  extends i
{
  public c$h(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(52732);
    afX("start");
    paramk.sxM = h.a(this.syx.query, false, this.sAF.sAE);
    Object localObject1 = h.bi(this.syx.syC, true);
    Object localObject2 = new HashMap();
    Object localObject3 = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((h)localObject1, null, com.tencent.mm.plugin.fts.a.c.swu, com.tencent.mm.plugin.fts.a.c.swy);
    do
    {
      if (!((Cursor)localObject3).moveToNext()) {
        break;
      }
      localObject4 = new com.tencent.mm.plugin.fts.a.a.n();
      ((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxG = ((Cursor)localObject3).getString(0);
      ((com.tencent.mm.plugin.fts.a.a.n)localObject4).type = ((Cursor)localObject3).getInt(1);
      ((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxF = ((Cursor)localObject3).getInt(2);
      ((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxM = ((h)localObject1);
      if (!((HashMap)localObject2).containsKey(((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxG)) {
        ((HashMap)localObject2).put(((com.tencent.mm.plugin.fts.a.a.n)localObject4).sxG, localObject4);
      }
    } while (((HashMap)localObject2).size() <= 100);
    ((Cursor)localObject3).close();
    afX("findHitContact");
    Object localObject4 = this.sAF.sAz.a(paramk.sxM, null, ((HashMap)localObject2).keySet());
    localObject3 = new HashMap();
    if (((Cursor)localObject4).moveToNext())
    {
      com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject4);
      localn.sxM = paramk.sxM;
      localn.userData = Integer.valueOf(1);
      label297:
      m localm;
      int i;
      if (((HashMap)localObject3).containsKey(localn.talker))
      {
        localObject1 = (HashMap)((HashMap)localObject3).get(localn.talker);
        if (!((HashMap)localObject1).containsKey(localn.sxG)) {
          break label422;
        }
        localm = (m)((HashMap)localObject1).get(localn.sxG);
        i = ((Integer)localm.userData).intValue() + 1;
        if (localm.timestamp >= localn.timestamp) {
          break label398;
        }
        localn.userData = Integer.valueOf(i);
        ((HashMap)localObject1).put(localn.sxG, localn);
      }
      for (;;)
      {
        ((HashMap)localObject3).put(localn.talker, localObject1);
        break;
        localObject1 = new HashMap();
        break label297;
        label398:
        localm.userData = Integer.valueOf(i);
        ((HashMap)localObject1).put(localm.sxG, localm);
        continue;
        label422:
        ((HashMap)localObject1).put(localn.sxG, localn);
      }
    }
    ((Cursor)localObject4).close();
    paramk.syK = new ArrayList();
    localObject1 = ((HashMap)localObject2).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (m)((Iterator)localObject1).next();
      if (((HashMap)localObject3).containsKey(((m)localObject2).sxG))
      {
        localObject4 = new ArrayList();
        ((List)localObject4).addAll(((HashMap)((HashMap)localObject3).get(((m)localObject2).sxG)).values());
        Collections.sort((List)localObject4, this.syx.syH);
        ((m)localObject2).userData = localObject4;
        ((m)localObject2).timestamp = ((m)((List)localObject4).get(0)).timestamp;
        paramk.syK.add(localObject2);
      }
    }
    Collections.sort(paramk.syK, this.syx.syH);
    afX("findHitMessage");
    AppMethodBeat.o(52732);
  }
  
  public final int getId()
  {
    return 28;
  }
  
  public final String getName()
  {
    return "SearchTalkerMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.h
 * JD-Core Version:    0.7.0.1
 */