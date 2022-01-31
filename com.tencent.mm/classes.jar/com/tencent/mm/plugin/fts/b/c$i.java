package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class c$i
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public c$i(c paramc, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    DW("start");
    paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.a(this.kwT.bVk, false, this.kze.kzd);
    Object localObject1 = this.kze.kyW;
    Object localObject2 = paramj.kwi.aVy();
    localObject2 = String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[] { ((com.tencent.mm.plugin.fts.c.c)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.c)localObject1).aVt(), localObject2 });
    localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject2, null);
    localObject1 = new ArrayList();
    Object localObject3 = new HashSet();
    Object localObject4 = new ArrayList();
    do
    {
      if (!((Cursor)localObject2).moveToNext()) {
        break;
      }
      String str = ((Cursor)localObject2).getString(3);
      if (((HashSet)localObject3).add(str))
      {
        a locala = new a((byte)0);
        locala.type = ((Cursor)localObject2).getInt(0);
        locala.kwf = ((Cursor)localObject2).getInt(1);
        locala.kxk = ((Cursor)localObject2).getLong(2);
        locala.kwg = ((Cursor)localObject2).getString(3);
        locala.timestamp = ((Cursor)localObject2).getLong(4);
        ((List)localObject1).add(locala);
        ((List)localObject4).add(str);
      }
    } while (((List)localObject1).size() <= this.kwT.kxc);
    ((Cursor)localObject2).close();
    paramj.kxh = new LinkedList();
    DW("findUsername");
    if (((List)localObject4).size() > 0)
    {
      localObject3 = this.kze.kyW.a(paramj.kwi, (List)localObject4);
      localObject2 = new HashMap();
      if (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0).split(" ");
        int i = 0;
        while (i < localObject4.length)
        {
          ((HashMap)localObject2).put(localObject4[i], Integer.valueOf(localObject4[(i + 1)]));
          i += 2;
        }
      }
      ((Cursor)localObject3).close();
      localObject1 = ((List)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a)((Iterator)localObject1).next();
        localObject4 = new l();
        ((l)localObject4).type = ((a)localObject3).type;
        ((l)localObject4).kwf = ((a)localObject3).kwf;
        ((l)localObject4).kxk = ((a)localObject3).kxk;
        ((l)localObject4).kwg = ((a)localObject3).kwg;
        ((l)localObject4).timestamp = ((a)localObject3).timestamp;
        if (((HashMap)localObject2).containsKey(((l)localObject4).kwg)) {}
        for (((l)localObject4).userData = ((HashMap)localObject2).get(((l)localObject4).kwg);; ((l)localObject4).userData = Integer.valueOf(1))
        {
          paramj.kxh.add(localObject4);
          break;
        }
      }
      DW("findCount");
    }
    if ((paramj.kwi.kwJ.length > 1) && (paramj.kxh.size() <= 3))
    {
      localObject1 = com.tencent.mm.plugin.fts.a.a.g.aF(paramj.kwi.kwJ[0], true);
      localObject1 = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3)).a((com.tencent.mm.plugin.fts.a.a.g)localObject1, null, com.tencent.mm.plugin.fts.a.c.kuW, com.tencent.mm.plugin.fts.a.c.kva);
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new l();
        ((l)localObject2).kwg = "create_talker_message​";
        paramj.kxh.add(localObject2);
      }
      ((Cursor)localObject1).close();
      DW("findTalkerConversation");
    }
  }
  
  public final int getId()
  {
    return 24;
  }
  
  public final String getName()
  {
    return "SearchLimitGroupMessage";
  }
  
  private final class a
  {
    int kwf;
    String kwg;
    long kxk;
    long timestamp;
    int type;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.i
 * JD-Core Version:    0.7.0.1
 */