package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ad;
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

public final class e
  extends com.tencent.mm.plugin.fts.a.b
{
  private com.tencent.mm.plugin.fts.a.m grs;
  com.tencent.mm.plugin.fts.c.e txx;
  HashSet<String> txy;
  
  public final com.tencent.mm.plugin.fts.a.a.a a(j paramj)
  {
    AppMethodBeat.i(52758);
    paramj = new b(paramj);
    paramj = this.grs.a(-65536, paramj);
    AppMethodBeat.o(52758);
    return paramj;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.fts.a.a.m paramm, int paramInt, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(52761);
    c localc = new c((byte)0);
    c.a(localc, paramString);
    c.a(localc, paramm);
    c.a(localc, paramInt);
    c.a(localc, paramHashMap);
    this.grs.a(65626, localc);
    AppMethodBeat.o(52761);
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(52757);
    if (this.txy != null) {
      this.txy.clear();
    }
    this.txx = null;
    this.grs = null;
    AppMethodBeat.o(52757);
    return true;
  }
  
  public final void akD(String paramString)
  {
    AppMethodBeat.i(52759);
    if (this.txy.add(paramString)) {
      this.txx.akH(paramString);
    }
    AppMethodBeat.o(52759);
  }
  
  public final void c(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(52760);
    this.txx.a(paramArrayOfInt, paramString);
    AppMethodBeat.o(52760);
  }
  
  public final String getName()
  {
    return "FTS5SearchTopHitsLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52756);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
      AppMethodBeat.o(52756);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
    this.txy = new HashSet();
    this.txx = ((com.tencent.mm.plugin.fts.c.e)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1));
    this.grs = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.grs.a(65626, new a((byte)0));
    AppMethodBeat.o(52756);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    int txA;
    int txz;
    
    private a() {}
    
    public final String bgU()
    {
      AppMethodBeat.i(52752);
      String str = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[] { Integer.valueOf(this.txA), Integer.valueOf(this.txz) });
      AppMethodBeat.o(52752);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(52751);
      this.txA = e.this.txx.cTl();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.fts.c.e locale = e.this.txx;
      Object localObject = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[] { locale.cSF() });
      localObject = locale.tsD.rawQuery((String)localObject, new String[] { String.valueOf(l - 5184000000L) });
      LinkedList localLinkedList = new LinkedList();
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
      }
      ((Cursor)localObject).close();
      locale.dR(localLinkedList);
      this.txz = localLinkedList.size();
      AppMethodBeat.o(52751);
      return true;
    }
    
    public final String getName()
    {
      return "BuildTopHitsIndexTask";
    }
  }
  
  final class b
    extends i
  {
    public b(j paramj)
    {
      super();
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(52753);
      paramk.tun = com.tencent.mm.plugin.fts.a.a.h.bn(this.tuY.query, true);
      ad.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[] { paramk.tun.cSL().replaceAll("​", ",") });
      Object localObject2 = new HashSet();
      ((HashSet)localObject2).addAll(this.tuY.tvh);
      paramk.tvl = new ArrayList();
      HashSet localHashSet = new HashSet();
      Object localObject3 = e.this.txx;
      Object localObject5 = paramk.tun;
      Object localObject1 = this.tuY.tve;
      int i = this.tuY.scene;
      int j = this.tuY.tvg + this.tuY.tvh.size();
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).tuL + '%';
      String str1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).cSL();
      str1 = String.format("AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), str1 });
      String str2 = "AND type IN " + d.z((int[])localObject1);
      if (j > 0) {
        localObject1 = "LIMIT ".concat(String.valueOf(j));
      }
      long l;
      for (;;)
      {
        l = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).tuP.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), "query LIKE ?", str1, str2, "AND scene=?", "AND status >= 0 AND score >= 3", ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), localObject1 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).tsD.rawQuery((String)localObject1, new String[] { localObject4, String.valueOf(i) });
        try
        {
          for (;;)
          {
            label382:
            if (((Cursor)localObject1).moveToNext())
            {
              localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
              if (!((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh)) {
                continue;
              }
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).cSO();
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).userData = "";
              if (((com.tencent.mm.plugin.fts.a.a.n)localObject3).type != 262144) {
                break label645;
              }
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).userData = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17)).GS((int)((com.tencent.mm.plugin.fts.a.a.n)localObject3).tvo);
              if (((com.tencent.mm.plugin.fts.a.a.n)localObject3).userData == null) {
                continue;
              }
            }
            label645:
            while ((((com.tencent.mm.plugin.fts.a.a.n)localObject3).type != 131072) || (!com.tencent.mm.plugin.fts.c.e.akI(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh)))
            {
              paramk.tvl.add(localObject3);
              i = paramk.tvl.size();
              j = this.tuY.tvg;
              if (i < j) {
                break label382;
              }
              ((Cursor)localObject1).close();
              ad.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[] { Integer.valueOf(paramk.tvl.size()) });
              if (paramk.tun.tuN.length <= 1) {
                break label1250;
              }
              if (paramk.tvl.size() > 2) {
                paramk.tvl = paramk.tvl.subList(0, 2);
              }
              ((HashSet)localObject2).clear();
              i = 0;
              while (i < paramk.tvl.size())
              {
                ((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)paramk.tvl.get(i)).tuh);
                i += 1;
              }
              localObject1 = "";
              break;
            }
            localHashSet.add(((com.tencent.mm.plugin.fts.a.a.n)localObject3).tuh);
          }
          localObject1 = new HashSet();
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(52753);
        }
      }
      localObject3 = e.this.txx;
      localObject5 = paramk.tun;
      localObject4 = this.tuY.tve;
      i = this.tuY.scene;
      j = this.tuY.tvg;
      int k = this.tuY.tvh.size();
      localObject5 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).cSL();
      localObject4 = " AND type IN " + d.z((int[])localObject4);
      localObject4 = String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (String)localObject4 + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), localObject5 }) + " ORDER BY score desc limit " + (j + k) + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSF(), ((com.tencent.mm.plugin.fts.c.e)localObject3).cSG() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject3).tsD.rawQuery((String)localObject4, new String[] { "​chatroom_tophits" });
      while (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0);
        if (!((HashSet)localObject2).contains(localObject4)) {
          ((HashSet)localObject1).add(localObject4);
        }
      }
      ((Cursor)localObject3).close();
      localObject2 = (com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = paramk.tun;
        localObject5 = ((com.tencent.mm.plugin.fts.a.a.h)localObject4).cSL();
        l = ((com.tencent.mm.plugin.fts.a.a.h)localObject4).tuP.size();
        localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSF(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), ((com.tencent.mm.plugin.fts.c.a)localObject2).cSG(), localObject5 });
        localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject2).tsD.rawQuery((String)localObject4, new String[] { localObject3 });
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject3);
          ((com.tencent.mm.plugin.fts.a.a.n)localObject4).userData = "​chatroom_tophits";
          ((com.tencent.mm.plugin.fts.a.a.n)localObject4).cSO();
          paramk.tvl.add(localObject4);
          if (paramk.tvl.size() >= this.tuY.tvg) {
            break;
          }
        }
        ((Cursor)localObject3).close();
      }
      label1250:
      paramk = localHashSet.iterator();
      while (paramk.hasNext())
      {
        localObject1 = (String)paramk.next();
        e.this.akD((String)localObject1);
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
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String query;
    private int scene;
    private HashMap<String, String> ttr;
    private com.tencent.mm.plugin.fts.a.a.m txC;
    
    private c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(52754);
      com.tencent.mm.plugin.fts.c.e locale = e.this.txx;
      Object localObject1 = this.query;
      com.tencent.mm.plugin.fts.a.a.m localm = this.txC;
      int k = this.scene;
      Object localObject3 = this.ttr;
      Object localObject2 = ((String)localObject1).trim();
      ((HashMap)localObject3).remove(localm.tuh);
      long l = System.currentTimeMillis();
      if (((localm.type == 131072) || (localm.type == 131075)) && (com.tencent.mm.plugin.fts.c.e.akI(localm.tuh)))
      {
        ad.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
        AppMethodBeat.o(52754);
        return true;
      }
      locale.tsD.beginTransaction();
      localObject1 = localm.tuh;
      int i = localm.tug;
      Object localObject4 = String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[] { locale.cSF() });
      localObject1 = locale.tsD.rawQuery((String)localObject4, new String[] { localObject2, localObject1, String.valueOf(i), String.valueOf(k) });
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
            localObject1 = String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[] { locale.cSF(), Integer.valueOf(k), localObject1 });
            locale.tsD.execSQL((String)localObject1);
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
              localObject1 = String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[] { locale.cSF(), Integer.valueOf(k), localObject1 });
              locale.tsD.execSQL((String)localObject1, new String[] { "​chatroom_tophits" });
            }
            if ((i >= 0) && (j >= 0)) {
              if (j > 6)
              {
                j += 1;
                label621:
                localObject1 = String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[] { locale.cSF() });
                locale.tsD.execSQL((String)localObject1, new String[] { String.valueOf(j), String.valueOf(l), String.valueOf(i) });
              }
            }
            for (;;)
            {
              locale.tsD.commit();
              localObject1 = c.a.tto.split((CharSequence)localObject2);
              if ((localObject1.length <= 1) || (localm.type != 131075) || (localm.tug != 38)) {
                break;
              }
              localObject2 = new HashSet();
              localObject3 = new l();
              localObject4 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[] { locale.cSF() });
              localObject4 = locale.tsD.rawQuery((String)localObject4, new String[] { localm.tuh, "​chatroom_tophits" });
              if (!((Cursor)localObject4).moveToNext()) {
                break label1012;
              }
              ((l)localObject3).convertFrom((Cursor)localObject4);
              localObject5 = c.a.ttk.split(((l)localObject3).tvp);
              j = localObject5.length;
              i = 0;
              while (i < j)
              {
                ((HashSet)localObject2).add(localObject5[i]);
                i += 1;
              }
              j += 3;
              break label621;
              locale.txV.bindString(1, localm.content);
              locale.txV.execute();
              locale.txW.bindLong(1, localm.type);
              locale.txW.bindLong(2, localm.tug);
              locale.txW.bindLong(3, localm.tvo);
              locale.txW.bindString(4, localm.tuh);
              locale.txW.bindLong(5, l);
              locale.txW.bindString(6, (String)localObject2);
              locale.txW.bindLong(7, 3L);
              locale.txW.bindLong(8, k);
              locale.txW.bindString(9, localm.content);
              locale.txW.execute();
            }
            label1012:
            ((Cursor)localObject4).close();
            i = 0;
            while ((i < localm.tvv.size()) && (i < localObject1.length))
            {
              localObject4 = (com.tencent.mm.plugin.fts.a.a.g)localm.tvv.get(i);
              if (((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.g)localObject4).content)) {
                ((l)localObject3).tvp = (((l)localObject3).tvp + ((com.tencent.mm.plugin.fts.a.a.g)localObject4).content + "​");
              }
              i += 1;
            }
            ad.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[] { ((l)localObject3).tvp });
            if (((l)localObject3).tvm > 0L) {
              locale.xz(((l)localObject3).tvm);
            }
            ((l)localObject3).tvm = 0L;
            ((l)localObject3).query = "​chatroom_tophits";
            ((l)localObject3).tvn += 1L;
            ((l)localObject3).hki = k;
            ((l)localObject3).tuh = localm.tuh;
            ((l)localObject3).tvo = localm.tvo;
            ((l)localObject3).type = localm.type;
            ((l)localObject3).tug = localm.tug;
            ((l)localObject3).timestamp = l;
            locale.tsD.beginTransaction();
            locale.txV.bindString(1, ((l)localObject3).tvp);
            locale.txV.execute();
            locale.txW.bindLong(1, ((l)localObject3).type);
            locale.txW.bindLong(2, ((l)localObject3).tug);
            locale.txW.bindLong(3, ((l)localObject3).tvo);
            locale.txW.bindString(4, ((l)localObject3).tuh);
            locale.txW.bindLong(5, ((l)localObject3).timestamp);
            locale.txW.bindString(6, ((l)localObject3).query);
            locale.txW.bindLong(7, ((l)localObject3).tvn);
            locale.txW.bindLong(8, ((l)localObject3).hki);
            locale.txW.bindString(9, ((l)localObject3).tvp);
            locale.txW.execute();
            locale.tsD.commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e
 * JD-Core Version:    0.7.0.1
 */