package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class a$n
  extends h
{
  public a$n(a parama, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, true);
    Object localObject2 = a.a(this.kyt).a(paramj.kwi, new int[] { 131075 }, null, true, true);
    Object localObject1 = new HashMap();
    Object localObject4;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new m().j((Cursor)localObject2);
      if (!this.kwT.kxd.contains(((m)localObject3).kwg))
      {
        localObject4 = (l)((HashMap)localObject1).get(((m)localObject3).kwg);
        if ((localObject4 == null) || (d.e(c.kvg, ((m)localObject3).kwf, ((l)localObject4).kwf) < 0)) {
          ((HashMap)localObject1).put(((m)localObject3).kwg, localObject3);
        }
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          throw new InterruptedException();
        }
      }
    }
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((HashMap)localObject1).size());
    Object localObject3 = ((HashMap)localObject1).values().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (m)((Iterator)localObject3).next();
      ((m)localObject4).aVA();
      ((m)localObject4).a(paramj.kwi);
      ((ArrayList)localObject2).add(localObject4);
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
    }
    if (this.kwT.kxe != null) {
      Collections.sort((List)localObject2, this.kwT.kxe);
    }
    paramj.kxh = new ArrayList(((HashMap)localObject1).size());
    localObject1 = new StringBuffer();
    int i = 0;
    while (i < ((ArrayList)localObject2).size())
    {
      localObject3 = (l)((ArrayList)localObject2).get(i);
      ((StringBuffer)localObject1).append(((l)localObject3).kwE);
      ((StringBuffer)localObject1).append("|");
      ((StringBuffer)localObject1).append(((l)localObject3).timestamp);
      ((StringBuffer)localObject1).append(" ");
      paramj.kxh.add(localObject3);
      if (i >= this.kwT.kxc) {
        break;
      }
      i += 1;
    }
    if ((paramj.kwi.kwK.size() > 1) && (a.a(this.kyt).b(paramj.kwi)))
    {
      localObject2 = new l();
      ((l)localObject2).kwg = "create_chatroom​";
      paramj.kxh.add(0, localObject2);
      ((StringBuffer)localObject1).append(" needCreateChatroom");
    }
    y.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[] { ((StringBuffer)localObject1).toString() });
  }
  
  public final int getId()
  {
    return 19;
  }
  
  public final String getName()
  {
    return "SearchChatroomTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.n
 * JD-Core Version:    0.7.0.1
 */