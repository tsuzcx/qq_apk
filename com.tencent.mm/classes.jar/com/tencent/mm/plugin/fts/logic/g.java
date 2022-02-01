package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class g
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.b.g Hwi;
  HashSet<String> Hwj;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(52758);
    paraml = new b(paraml);
    paraml = this.msU.a(-65536, paraml);
    AppMethodBeat.o(52758);
    return paraml;
  }
  
  public final void a(String paramString, o paramo, int paramInt, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(52761);
    c localc = new c((byte)0);
    c.a(localc, paramString);
    c.a(localc, paramo);
    c.a(localc, paramInt);
    c.a(localc, paramHashMap);
    this.msU.a(65626, localc);
    AppMethodBeat.o(52761);
  }
  
  public final void aEz(String paramString)
  {
    AppMethodBeat.i(52759);
    if (this.Hwj.add(paramString)) {
      this.Hwi.aED(paramString);
    }
    AppMethodBeat.o(52759);
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52757);
    if (this.Hwj != null) {
      this.Hwj.clear();
    }
    this.Hwi = null;
    this.msU = null;
    AppMethodBeat.o(52757);
    return true;
  }
  
  public final void d(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(52760);
    this.Hwi.b(paramArrayOfInt, paramString);
    AppMethodBeat.o(52760);
  }
  
  public final String getName()
  {
    return "FTS5SearchTopHitsLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52756);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
      AppMethodBeat.o(52756);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
    this.Hwj = new HashSet();
    this.Hwi = ((com.tencent.mm.plugin.fts.b.g)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1));
    this.msU = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.msU.a(65626, new a((byte)0));
    AppMethodBeat.o(52756);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    int Hwk;
    int Hwl;
    
    private a() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52751);
      this.Hwl = g.a(g.this).fyb();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.fts.b.g localg = g.a(g.this);
      Object localObject = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[] { localg.fxn() });
      localObject = localg.HqR.rawQuery((String)localObject, new String[] { String.valueOf(l - 5184000000L) });
      LinkedList localLinkedList = new LinkedList();
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
      }
      ((Cursor)localObject).close();
      localg.hP(localLinkedList);
      this.Hwk = localLinkedList.size();
      AppMethodBeat.o(52751);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(52752);
      String str = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[] { Integer.valueOf(this.Hwl), Integer.valueOf(this.Hwk) });
      AppMethodBeat.o(52752);
      return str;
    }
    
    public final String getName()
    {
      return "BuildTopHitsIndexTask";
    }
  }
  
  final class b
    extends k
  {
    public b(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(52753);
      paramm.FWt = j.cc(this.Htr.query, true);
      Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[] { paramm.FWt.fxx().replaceAll("​", ",") });
      Object localObject2 = new HashSet();
      ((HashSet)localObject2).addAll(this.Htr.HtA);
      paramm.HtF = new ArrayList();
      HashSet localHashSet = new HashSet();
      Object localObject3 = g.a(g.this);
      Object localObject5 = paramm.FWt;
      Object localObject1 = this.Htr.Htx;
      int i = this.Htr.scene;
      int j = this.Htr.Htz + this.Htr.HtA.size();
      Object localObject4 = ((j)localObject5).Hte + '%';
      String str1 = ((j)localObject5).fxx();
      str1 = String.format("AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), str1 });
      String str2 = "AND type IN " + d.G((int[])localObject1);
      if (j > 0) {
        localObject1 = "LIMIT ".concat(String.valueOf(j));
      }
      long l;
      for (;;)
      {
        l = ((j)localObject5).Hti.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[] { ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), "query LIKE ?", str1, str2, "AND scene=?", "AND status >= 0 AND score >= 3", ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), localObject1 });
        localObject1 = ((a)localObject3).HqR.rawQuery((String)localObject1, new String[] { localObject4, String.valueOf(i) });
        try
        {
          for (;;)
          {
            label382:
            if (((Cursor)localObject1).moveToNext())
            {
              localObject3 = new p().l((Cursor)localObject1);
              if (!((HashSet)localObject2).add(((p)localObject3).Hsz)) {
                continue;
              }
              ((p)localObject3).fxB();
              ((p)localObject3).HtQ = "";
              if (((p)localObject3).type != 262144) {
                break label645;
              }
              ((p)localObject3).HtQ = ((com.tencent.mm.plugin.fts.b.c)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17)).Wk((int)((p)localObject3).HtI);
              if (((p)localObject3).HtQ == null) {
                continue;
              }
            }
            label645:
            do
            {
              do
              {
                paramm.HtF.add(localObject3);
                i = paramm.HtF.size();
                j = this.Htr.Htz;
                if (i < j) {
                  break label382;
                }
                ((Cursor)localObject1).close();
                Log.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[] { Integer.valueOf(paramm.HtF.size()) });
                if (paramm.FWt.Htg.length <= 1) {
                  break label1268;
                }
                if (paramm.HtF.size() > 2) {
                  paramm.HtF = paramm.HtF.subList(0, 2);
                }
                ((HashSet)localObject2).clear();
                i = 0;
                while (i < paramm.HtF.size())
                {
                  ((HashSet)localObject2).add(((o)paramm.HtF.get(i)).Hsz);
                  i += 1;
                }
                localObject1 = "";
                break;
              } while (((p)localObject3).type != 131072);
              g.a(g.this);
            } while (!com.tencent.mm.plugin.fts.b.g.aEE(((p)localObject3).Hsz));
            localHashSet.add(((p)localObject3).Hsz);
          }
          localObject1 = new HashSet();
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(52753);
        }
      }
      localObject3 = g.a(g.this);
      localObject5 = paramm.FWt;
      localObject4 = this.Htr.Htx;
      i = this.Htr.scene;
      j = this.Htr.Htz;
      int k = this.Htr.HtA.size();
      localObject5 = ((j)localObject5).fxx();
      localObject4 = " AND type IN " + d.G((int[])localObject4);
      localObject4 = String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (String)localObject4 + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), localObject5 }) + " ORDER BY score desc limit " + (j + k) + ";", new Object[] { ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxn(), ((com.tencent.mm.plugin.fts.b.g)localObject3).fxo() });
      localObject3 = ((a)localObject3).HqR.rawQuery((String)localObject4, new String[] { "​chatroom_tophits" });
      while (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0);
        if (!((HashSet)localObject2).contains(localObject4)) {
          ((HashSet)localObject1).add(localObject4);
        }
      }
      ((Cursor)localObject3).close();
      localObject2 = (com.tencent.mm.plugin.fts.b.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = paramm.FWt;
        localObject5 = ((j)localObject4).fxx();
        l = ((j)localObject4).Hti.size();
        localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[] { ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxn(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), ((com.tencent.mm.plugin.fts.b.b)localObject2).fxo(), localObject5 });
        localObject3 = ((a)localObject2).HqR.rawQuery((String)localObject4, new String[] { localObject3 });
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new p().l((Cursor)localObject3);
          ((p)localObject4).HtQ = "​chatroom_tophits";
          ((p)localObject4).fxB();
          paramm.HtF.add(localObject4);
          if (paramm.HtF.size() >= this.Htr.Htz) {
            break;
          }
        }
        ((Cursor)localObject3).close();
      }
      label1268:
      paramm = localHashSet.iterator();
      while (paramm.hasNext())
      {
        localObject1 = (String)paramm.next();
        g.this.aEz((String)localObject1);
      }
      AppMethodBeat.o(52753);
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
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private HashMap<String, String> HrH;
    private o Hwn;
    private String query;
    private int scene;
    
    private c() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(52754);
      com.tencent.mm.plugin.fts.b.g localg = g.a(g.this);
      Object localObject1 = this.query;
      o localo = this.Hwn;
      int k = this.scene;
      Object localObject3 = this.HrH;
      Object localObject2 = ((String)localObject1).trim();
      ((HashMap)localObject3).remove(localo.Hsz);
      long l = System.currentTimeMillis();
      if (((localo.type == 131072) || (localo.type == 131075)) && (com.tencent.mm.plugin.fts.b.g.aEE(localo.Hsz)))
      {
        Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
        AppMethodBeat.o(52754);
        return true;
      }
      localg.HqR.beginTransaction();
      localObject1 = localo.Hsz;
      int i = localo.subtype;
      Object localObject4 = String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[] { localg.fxn() });
      localObject1 = localg.HqR.rawQuery((String)localObject4, new String[] { localObject2, localObject1, String.valueOf(i), String.valueOf(k) });
      int j;
      if (((Cursor)localObject1).moveToNext())
      {
        i = ((Cursor)localObject1).getInt(0);
        j = ((Cursor)localObject1).getInt(1);
      }
      for (;;)
      {
        ((Cursor)localObject1).close();
        localObject1 = "";
        localObject4 = ((HashMap)localObject3).entrySet().iterator();
        label240:
        Object localObject5;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          if (((String)((Map.Entry)localObject5).getValue()).equals("​chatroom_tophits")) {
            break label1422;
          }
          localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject5).getKey() + "',";
        }
        label1419:
        label1422:
        for (;;)
        {
          break label240;
          if (((String)localObject1).length() > 0)
          {
            localObject1 = "AND aux_index IN (" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
            localObject1 = String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[] { localg.fxn(), Integer.valueOf(k), localObject1 });
            localg.HqR.execSQL((String)localObject1);
          }
          localObject1 = "";
          localObject3 = ((HashMap)localObject3).entrySet().iterator();
          label425:
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            if (!((String)((Map.Entry)localObject4).getValue()).equals("​chatroom_tophits")) {
              break label1419;
            }
            localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject4).getKey() + "',";
          }
          for (;;)
          {
            break label425;
            if (((String)localObject1).length() > 0)
            {
              localObject1 = "AND aux_index IN(" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
              localObject1 = String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[] { localg.fxn(), Integer.valueOf(k), localObject1 });
              localg.HqR.execSQL((String)localObject1, new String[] { "​chatroom_tophits" });
            }
            if ((i >= 0) && (j >= 0)) {
              if (j > 6)
              {
                j += 1;
                label621:
                localObject1 = String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[] { localg.fxn() });
                localg.HqR.execSQL((String)localObject1, new String[] { String.valueOf(j), String.valueOf(l), String.valueOf(i) });
              }
            }
            for (;;)
            {
              localg.HqR.commit();
              localObject1 = c.a.HrE.split((CharSequence)localObject2);
              if ((localObject1.length <= 1) || (localo.type != 131075) || (localo.subtype != 38)) {
                break;
              }
              localObject2 = new HashSet();
              localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
              localObject4 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[] { localg.fxn() });
              localObject4 = localg.HqR.rawQuery((String)localObject4, new String[] { localo.Hsz, "​chatroom_tophits" });
              if (!((Cursor)localObject4).moveToNext()) {
                break label1012;
              }
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).convertFrom((Cursor)localObject4);
              localObject5 = c.a.HrA.split(((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ);
              j = localObject5.length;
              i = 0;
              while (i < j)
              {
                ((HashSet)localObject2).add(localObject5[i]);
                i += 1;
              }
              j += 3;
              break label621;
              localg.HwG.bindString(1, localo.content);
              localg.HwG.execute();
              localg.HwH.bindLong(1, localo.type);
              localg.HwH.bindLong(2, localo.subtype);
              localg.HwH.bindLong(3, localo.HtI);
              localg.HwH.bindString(4, localo.Hsz);
              localg.HwH.bindLong(5, l);
              localg.HwH.bindString(6, (String)localObject2);
              localg.HwH.bindLong(7, 3L);
              localg.HwH.bindLong(8, k);
              localg.HwH.bindString(9, localo.content);
              localg.HwH.execute();
            }
            label1012:
            ((Cursor)localObject4).close();
            i = 0;
            while ((i < localo.HtP.size()) && (i < localObject1.length))
            {
              localObject4 = (i)localo.HtP.get(i);
              if (((HashSet)localObject2).add(((i)localObject4).content)) {
                ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ = (((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ + ((i)localObject4).content + "​");
              }
              i += 1;
            }
            Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[] { ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ });
            if (((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtG > 0L) {
              localg.rp(((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtG);
            }
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtG = 0L;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).query = "​chatroom_tophits";
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtH += 1L;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).nAz = k;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).Hsz = localo.Hsz;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtI = localo.HtI;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).type = localo.type;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).subtype = localo.subtype;
            ((com.tencent.mm.plugin.fts.a.a.n)localObject3).timestamp = l;
            localg.HqR.beginTransaction();
            localg.HwG.bindString(1, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ);
            localg.HwG.execute();
            localg.HwH.bindLong(1, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).type);
            localg.HwH.bindLong(2, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).subtype);
            localg.HwH.bindLong(3, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtI);
            localg.HwH.bindString(4, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).Hsz);
            localg.HwH.bindLong(5, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).timestamp);
            localg.HwH.bindString(6, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).query);
            localg.HwH.bindLong(7, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtH);
            localg.HwH.bindLong(8, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).nAz);
            localg.HwH.bindString(9, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).HtJ);
            localg.HwH.execute();
            localg.HqR.commit();
            break;
          }
        }
        j = -1;
        i = -1;
      }
    }
    
    public final String getName()
    {
      return "UpdateTopHitsWithQueryTask";
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52755);
      String str = String.format("%s : query=%s scene=%d", new Object[] { super.toString(), this.query, Integer.valueOf(this.scene) });
      AppMethodBeat.o(52755);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.g
 * JD-Core Version:    0.7.0.1
 */