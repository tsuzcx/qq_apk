package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136779);
    paramj.mRX = com.tencent.mm.plugin.fts.a.a.g.aU(this.mSJ.query, true);
    ab.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[] { paramj.mRX.bBX().replaceAll("​", ",") });
    Object localObject2 = new HashSet();
    ((HashSet)localObject2).addAll(this.mSJ.mSS);
    paramj.mSW = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject3 = this.mVp.mVl;
    Object localObject5 = paramj.mRX;
    Object localObject1 = this.mSJ.mSP;
    int i = this.mSJ.scene;
    int j = this.mSJ.mSR + this.mSJ.mSS.size();
    Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).mSw + '%';
    String str1 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).bBX();
    str1 = String.format("AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), str1 });
    String str2 = "AND type IN " + d.v((int[])localObject1);
    if (j > 0) {
      localObject1 = "LIMIT ".concat(String.valueOf(j));
    }
    long l;
    for (;;)
    {
      l = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).mSA.size();
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), "query LIKE ?", str1, str2, "AND scene=?", "AND status >= 0 AND score >= 3", ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), localObject1 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).mQr.rawQuery((String)localObject1, new String[] { localObject4, String.valueOf(i) });
      try
      {
        for (;;)
        {
          label382:
          if (((Cursor)localObject1).moveToNext())
          {
            localObject3 = new m().i((Cursor)localObject1);
            if (!((HashSet)localObject2).add(((m)localObject3).mRV)) {
              continue;
            }
            ((m)localObject3).bCa();
            ((m)localObject3).userData = "";
            if (((m)localObject3).type != 262144) {
              break label645;
            }
            ((m)localObject3).userData = ((b)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(17)).wv((int)((m)localObject3).mSZ);
            if (((m)localObject3).userData == null) {
              continue;
            }
          }
          label645:
          while ((((m)localObject3).type != 131072) || (!com.tencent.mm.plugin.fts.c.e.Ps(((m)localObject3).mRV)))
          {
            paramj.mSW.add(localObject3);
            i = paramj.mSW.size();
            j = this.mSJ.mSR;
            if (i < j) {
              break label382;
            }
            ((Cursor)localObject1).close();
            ab.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[] { Integer.valueOf(paramj.mSW.size()) });
            if (paramj.mRX.mSy.length <= 1) {
              break label1250;
            }
            if (paramj.mSW.size() > 2) {
              paramj.mSW = paramj.mSW.subList(0, 2);
            }
            ((HashSet)localObject2).clear();
            i = 0;
            while (i < paramj.mSW.size())
            {
              ((HashSet)localObject2).add(((l)paramj.mSW.get(i)).mRV);
              i += 1;
            }
            localObject1 = "";
            break;
          }
          localHashSet.add(((m)localObject3).mRV);
        }
        localObject1 = new HashSet();
      }
      finally
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(136779);
      }
    }
    localObject3 = this.mVp.mVl;
    localObject5 = paramj.mRX;
    localObject4 = this.mSJ.mSP;
    i = this.mSJ.scene;
    j = this.mSJ.mSR;
    int k = this.mSJ.mSS.size();
    localObject5 = ((com.tencent.mm.plugin.fts.a.a.g)localObject5).bBX();
    localObject4 = " AND type IN " + d.v((int[])localObject4);
    localObject4 = String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (String)localObject4 + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), localObject5 }) + " ORDER BY score desc limit " + (j + k) + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBR(), ((com.tencent.mm.plugin.fts.c.e)localObject3).bBS() });
    localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject3).mQr.rawQuery((String)localObject4, new String[] { "​chatroom_tophits" });
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = ((Cursor)localObject3).getString(0);
      if (!((HashSet)localObject2).contains(localObject4)) {
        ((HashSet)localObject1).add(localObject4);
      }
    }
    ((Cursor)localObject3).close();
    localObject2 = (com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.G(n.class)).getFTSIndexStorage(3);
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      localObject4 = paramj.mRX;
      localObject5 = ((com.tencent.mm.plugin.fts.a.a.g)localObject4).bBX();
      l = ((com.tencent.mm.plugin.fts.a.a.g)localObject4).mSA.size();
      localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBR(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), ((com.tencent.mm.plugin.fts.c.a)localObject2).bBS(), localObject5 });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject2).mQr.rawQuery((String)localObject4, new String[] { localObject3 });
      if (((Cursor)localObject3).moveToNext())
      {
        localObject4 = new m().i((Cursor)localObject3);
        ((m)localObject4).userData = "​chatroom_tophits";
        ((m)localObject4).bCa();
        paramj.mSW.add(localObject4);
        if (paramj.mSW.size() >= this.mSJ.mSR) {
          break;
        }
      }
      ((Cursor)localObject3).close();
    }
    label1250:
    paramj = localHashSet.iterator();
    while (paramj.hasNext())
    {
      localObject1 = (String)paramj.next();
      this.mVp.Pn((String)localObject1);
    }
    AppMethodBeat.o(136779);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.b
 * JD-Core Version:    0.7.0.1
 */