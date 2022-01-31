package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class e$b
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public e$b(e parame, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.bVk, true);
    y.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[] { paramj.kwi.aVy().replaceAll("​", ",") });
    Object localObject2 = new HashSet();
    ((HashSet)localObject2).addAll(this.kwT.kxd);
    paramj.kxh = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject3 = this.kzz.kzv;
    Object localObject5 = paramj.kwi;
    Object localObject1 = this.kwT.kxa;
    int i = this.kwT.scene;
    int j = this.kwT.kxc + this.kwT.kxd.size();
    Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).kwG + '%';
    String str1 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).aVy();
    str1 = String.format("AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), str1 });
    String str2 = "AND type IN " + d.l((int[])localObject1);
    if (j > 0) {
      localObject1 = "LIMIT " + j;
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).kwK.size();
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), "query LIKE ?", str1, str2, "AND scene=?", "AND status >= 0 AND score >= 3", ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), localObject1 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).kuE.rawQuery((String)localObject1, new String[] { localObject4, String.valueOf(i) });
      try
      {
        for (;;)
        {
          label384:
          if (((Cursor)localObject1).moveToNext())
          {
            localObject3 = new m().j((Cursor)localObject1);
            if (!((HashSet)localObject2).add(((m)localObject3).kwg)) {
              continue;
            }
            ((m)localObject3).aVA();
            ((m)localObject3).userData = "";
            if (((m)localObject3).type != 262144) {
              break label647;
            }
            ((m)localObject3).userData = ((b)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(17)).rz((int)((m)localObject3).kxk);
            if (((m)localObject3).userData == null) {
              continue;
            }
          }
          label647:
          while ((((m)localObject3).type != 131072) || (!com.tencent.mm.plugin.fts.c.e.Eh(((m)localObject3).kwg)))
          {
            paramj.kxh.add(localObject3);
            i = paramj.kxh.size();
            j = this.kwT.kxc;
            if (i < j) {
              break label384;
            }
            ((Cursor)localObject1).close();
            y.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[] { Integer.valueOf(paramj.kxh.size()) });
            if (paramj.kwi.kwI.length <= 1) {
              break label1247;
            }
            if (paramj.kxh.size() > 2) {
              paramj.kxh = paramj.kxh.subList(0, 2);
            }
            ((HashSet)localObject2).clear();
            i = 0;
            while (i < paramj.kxh.size())
            {
              ((HashSet)localObject2).add(((l)paramj.kxh.get(i)).kwg);
              i += 1;
            }
            localObject1 = "";
            break;
          }
          localHashSet.add(((m)localObject3).kwg);
        }
        localObject1 = new HashSet();
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
    }
    localObject3 = this.kzz.kzv;
    localObject5 = paramj.kwi;
    localObject4 = this.kwT.kxa;
    i = this.kwT.scene;
    j = this.kwT.kxc;
    int k = this.kwT.kxd.size();
    localObject5 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).aVy();
    localObject4 = " AND type IN " + d.l((int[])localObject4);
    localObject4 = String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (String)localObject4 + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), localObject5 }) + " ORDER BY score desc limit " + (j + k) + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVs(), ((com.tencent.mm.plugin.fts.c.e)localObject3).aVt() });
    localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject3).kuE.rawQuery((String)localObject4, new String[] { "​chatroom_tophits" });
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = ((Cursor)localObject3).getString(0);
      if (!((HashSet)localObject2).contains(localObject4)) {
        ((HashSet)localObject1).add(localObject4);
      }
    }
    ((Cursor)localObject3).close();
    localObject2 = (com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3);
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      localObject4 = paramj.kwi;
      localObject5 = ((com.tencent.mm.plugin.fts.a.a.g)localObject4).aVy();
      l = ((com.tencent.mm.plugin.fts.a.a.g)localObject4).kwK.size();
      localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject2).aVt(), localObject5 });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject2).kuE.rawQuery((String)localObject4, new String[] { localObject3 });
      if (((Cursor)localObject3).moveToNext())
      {
        localObject4 = new m().j((Cursor)localObject3);
        ((m)localObject4).userData = "​chatroom_tophits";
        ((m)localObject4).aVA();
        paramj.kxh.add(localObject4);
        if (paramj.kxh.size() >= this.kwT.kxc) {
          break;
        }
      }
      ((Cursor)localObject3).close();
    }
    label1247:
    paramj = localHashSet.iterator();
    while (paramj.hasNext())
    {
      localObject1 = (String)paramj.next();
      this.kzz.Ed((String)localObject1);
    }
  }
  
  public final int getId()
  {
    return 8;
  }
  
  public final String getName()
  {
    return "SearchTopHitsTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.b
 * JD-Core Version:    0.7.0.1
 */