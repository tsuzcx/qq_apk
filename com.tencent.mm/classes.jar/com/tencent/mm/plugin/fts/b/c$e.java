package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

final class c$e
  extends h
{
  public c$e(c paramc, i parami)
  {
    super(parami);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136755);
    Pg("start");
    paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.a(this.mSJ.query, false, this.mUU.mUT);
    Object localObject1 = com.tencent.mm.plugin.fts.a.a.g.aU(this.mSJ.mSO, true);
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, this.mSJ.talker, com.tencent.mm.plugin.fts.a.c.mQJ, com.tencent.mm.plugin.fts.a.c.mQN);
    do
    {
      if (!((Cursor)localObject2).moveToNext()) {
        break;
      }
      localObject3 = new m();
      ((l)localObject3).mRV = ((Cursor)localObject2).getString(0);
      ((l)localObject3).type = ((Cursor)localObject2).getInt(1);
      ((l)localObject3).mRU = ((Cursor)localObject2).getInt(2);
      ((l)localObject3).mRX = ((com.tencent.mm.plugin.fts.a.a.g)localObject1);
      if (!localHashMap.containsKey(((l)localObject3).mRV)) {
        localHashMap.put(((l)localObject3).mRV, localObject3);
      }
    } while (localHashMap.size() <= 100);
    ((Cursor)localObject2).close();
    Pg("findHitContact");
    localObject2 = this.mUU.mUM.a(paramj.mRX, this.mSJ.mSN, localHashMap.keySet());
    Object localObject3 = new HashMap();
    if (((Cursor)localObject2).moveToNext())
    {
      m localm = new m().g((Cursor)localObject2);
      localm.mRX = paramj.mRX;
      if (((HashMap)localObject3).containsKey(localm.talker)) {}
      for (localObject1 = (List)((HashMap)localObject3).get(localm.talker);; localObject1 = new ArrayList())
      {
        ((List)localObject1).add(localm);
        ((HashMap)localObject3).put(localm.talker, localObject1);
        break;
      }
    }
    ((Cursor)localObject2).close();
    paramj.mSW = new ArrayList();
    localObject1 = ((HashMap)localObject3).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (l)localHashMap.get(((Map.Entry)localObject2).getKey());
      if (localObject3 != null)
      {
        Collections.sort((List)((Map.Entry)localObject2).getValue(), this.mSJ.mST);
        ((l)localObject3).userData = ((Map.Entry)localObject2).getValue();
        ((l)localObject3).timestamp = ((l)((List)((Map.Entry)localObject2).getValue()).get(0)).timestamp;
        paramj.mSW.add(localObject3);
      }
    }
    Collections.sort(paramj.mSW, this.mSJ.mST);
    Pg("findHitMessage");
    AppMethodBeat.o(136755);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.e
 * JD-Core Version:    0.7.0.1
 */