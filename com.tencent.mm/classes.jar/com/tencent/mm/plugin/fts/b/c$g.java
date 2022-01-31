package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class c$g
  extends h
{
  public c$g(c paramc, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    DW("start");
    paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.a(this.kwT.bVk, false, this.kze.kzd);
    Object localObject1 = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.kwZ, true);
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, this.kwT.talker, com.tencent.mm.plugin.fts.a.c.kuW, com.tencent.mm.plugin.fts.a.c.kva);
    do
    {
      if (!((Cursor)localObject2).moveToNext()) {
        break;
      }
      localObject3 = new m();
      ((l)localObject3).kwg = ((Cursor)localObject2).getString(0);
      ((l)localObject3).type = ((Cursor)localObject2).getInt(1);
      ((l)localObject3).kwf = ((Cursor)localObject2).getInt(2);
      ((l)localObject3).kwi = ((com.tencent.mm.plugin.fts.a.a.g)localObject1);
      if (!localHashMap.containsKey(((l)localObject3).kwg)) {
        localHashMap.put(((l)localObject3).kwg, localObject3);
      }
    } while (localHashMap.size() <= 100);
    ((Cursor)localObject2).close();
    DW("findHitContact");
    localObject2 = this.kze.kyW.a(paramj.kwi, this.kwT.kwY, localHashMap.keySet());
    Object localObject3 = new HashMap();
    if (((Cursor)localObject2).moveToNext())
    {
      m localm = new m().h((Cursor)localObject2);
      localm.kwi = paramj.kwi;
      if (((HashMap)localObject3).containsKey(localm.talker)) {}
      for (localObject1 = (List)((HashMap)localObject3).get(localm.talker);; localObject1 = new ArrayList())
      {
        ((List)localObject1).add(localm);
        ((HashMap)localObject3).put(localm.talker, localObject1);
        break;
      }
    }
    ((Cursor)localObject2).close();
    paramj.kxh = new ArrayList();
    localObject1 = ((HashMap)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (l)localHashMap.get(((Map.Entry)localObject2).getKey());
      if (localObject3 != null)
      {
        Collections.sort((List)((Map.Entry)localObject2).getValue(), this.kwT.kxe);
        ((l)localObject3).userData = ((Map.Entry)localObject2).getValue();
        ((l)localObject3).timestamp = ((l)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
        paramj.kxh.add(localObject3);
      }
    }
    Collections.sort(paramj.kxh, this.kwT.kxe);
    DW("findHitMessage");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.g
 * JD-Core Version:    0.7.0.1
 */