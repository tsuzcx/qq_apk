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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class c$e
  extends i
{
  public c$e(c paramc, j paramj)
  {
    super(paramj);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(52729);
    afX("start");
    paramk.sxM = h.a(this.syx.query, false, this.sAF.sAE);
    Object localObject1 = h.bi(this.syx.syC, true);
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3)).a((h)localObject1, this.syx.talker, com.tencent.mm.plugin.fts.a.c.swu, com.tencent.mm.plugin.fts.a.c.swy);
    do
    {
      if (!((Cursor)localObject2).moveToNext()) {
        break;
      }
      localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
      ((m)localObject3).sxG = ((Cursor)localObject2).getString(0);
      ((m)localObject3).type = ((Cursor)localObject2).getInt(1);
      ((m)localObject3).sxF = ((Cursor)localObject2).getInt(2);
      ((m)localObject3).sxM = ((h)localObject1);
      if (!localHashMap.containsKey(((m)localObject3).sxG)) {
        localHashMap.put(((m)localObject3).sxG, localObject3);
      }
    } while (localHashMap.size() <= 100);
    ((Cursor)localObject2).close();
    afX("findHitContact");
    localObject2 = this.sAF.sAz.a(paramk.sxM, this.syx.syB, localHashMap.keySet());
    Object localObject3 = new HashMap();
    if (((Cursor)localObject2).moveToNext())
    {
      com.tencent.mm.plugin.fts.a.a.n localn = new com.tencent.mm.plugin.fts.a.a.n().g((Cursor)localObject2);
      localn.sxM = paramk.sxM;
      if (((HashMap)localObject3).containsKey(localn.talker)) {}
      for (localObject1 = (List)((HashMap)localObject3).get(localn.talker);; localObject1 = new ArrayList())
      {
        ((List)localObject1).add(localn);
        ((HashMap)localObject3).put(localn.talker, localObject1);
        break;
      }
    }
    ((Cursor)localObject2).close();
    paramk.syK = new ArrayList();
    localObject1 = ((HashMap)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (m)localHashMap.get(((Map.Entry)localObject2).getKey());
      if (localObject3 != null)
      {
        Collections.sort((List)((Map.Entry)localObject2).getValue(), this.syx.syH);
        ((m)localObject3).userData = ((Map.Entry)localObject2).getValue();
        ((m)localObject3).timestamp = ((m)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
        paramk.syK.add(localObject3);
      }
    }
    Collections.sort(paramk.syK, this.syx.syH);
    afX("findHitMessage");
    AppMethodBeat.o(52729);
  }
  
  public final int getId()
  {
    return 29;
  }
  
  public final String getName()
  {
    return "SearchConvTalkerMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.e
 * JD-Core Version:    0.7.0.1
 */