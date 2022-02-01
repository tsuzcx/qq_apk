package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
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

public class e
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.c.e BLm;
  HashSet<String> BLn;
  private com.tencent.mm.plugin.fts.a.m jSC;
  
  public final com.tencent.mm.plugin.fts.a.a.a a(j paramj)
  {
    AppMethodBeat.i(52758);
    paramj = new b(paramj);
    paramj = this.jSC.a(-65536, paramj);
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
    this.jSC.a(65626, localc);
    AppMethodBeat.o(52761);
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52757);
    if (this.BLn != null) {
      this.BLn.clear();
    }
    this.BLm = null;
    this.jSC = null;
    AppMethodBeat.o(52757);
    return true;
  }
  
  public final void aIa(String paramString)
  {
    AppMethodBeat.i(52759);
    if (this.BLn.add(paramString)) {
      this.BLm.aIe(paramString);
    }
    AppMethodBeat.o(52759);
  }
  
  public final void c(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(52760);
    this.BLm.a(paramArrayOfInt, paramString);
    AppMethodBeat.o(52760);
  }
  
  public final String getName()
  {
    return "FTS5SearchTopHitsLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(52756);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
      AppMethodBeat.o(52756);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
    this.BLn = new HashSet();
    this.BLm = ((com.tencent.mm.plugin.fts.c.e)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1));
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.jSC.a(65626, new a((byte)0));
    AppMethodBeat.o(52756);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    int BLo;
    int BLp;
    
    private a() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52751);
      this.BLp = e.a(e.this).ert();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.fts.c.e locale = e.a(e.this);
      Object localObject = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[] { locale.eqI() });
      localObject = locale.BGp.rawQuery((String)localObject, new String[] { String.valueOf(l - 5184000000L) });
      LinkedList localLinkedList = new LinkedList();
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
      }
      ((Cursor)localObject).close();
      locale.fd(localLinkedList);
      this.BLo = localLinkedList.size();
      AppMethodBeat.o(52751);
      return true;
    }
    
    public final String bOl()
    {
      AppMethodBeat.i(52752);
      String str = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[] { Integer.valueOf(this.BLp), Integer.valueOf(this.BLo) });
      AppMethodBeat.o(52752);
      return str;
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
      paramk.BHY = com.tencent.mm.plugin.fts.a.a.h.bJ(this.BIJ.query, true);
      Log.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[] { paramk.BHY.eqQ().replaceAll("​", ",") });
      Object localObject2 = new HashSet();
      ((HashSet)localObject2).addAll(this.BIJ.BIS);
      paramk.BIW = new ArrayList();
      HashSet localHashSet = new HashSet();
      Object localObject3 = e.a(e.this);
      Object localObject5 = paramk.BHY;
      Object localObject1 = this.BIJ.BIP;
      int i = this.BIJ.scene;
      int j = this.BIJ.BIR + this.BIJ.BIS.size();
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).BIw + '%';
      String str1 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).eqQ();
      str1 = String.format("AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), str1 });
      String str2 = "AND type IN " + d.C((int[])localObject1);
      if (j > 0) {
        localObject1 = "LIMIT ".concat(String.valueOf(j));
      }
      long l;
      for (;;)
      {
        l = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).BIA.size();
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), "query LIKE ?", str1, str2, "AND scene=?", "AND status >= 0 AND score >= 3", ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), localObject1 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).BGp.rawQuery((String)localObject1, new String[] { localObject4, String.valueOf(i) });
        try
        {
          for (;;)
          {
            label382:
            if (((Cursor)localObject1).moveToNext())
            {
              localObject3 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject1);
              if (!((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS)) {
                continue;
              }
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).eqT();
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).BJh = "";
              if (((com.tencent.mm.plugin.fts.a.a.n)localObject3).type != 262144) {
                break label645;
              }
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).BJh = ((com.tencent.mm.plugin.fts.c.b)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17)).SD((int)((com.tencent.mm.plugin.fts.a.a.n)localObject3).BIZ);
              if (((com.tencent.mm.plugin.fts.a.a.n)localObject3).BJh == null) {
                continue;
              }
            }
            label645:
            do
            {
              do
              {
                paramk.BIW.add(localObject3);
                i = paramk.BIW.size();
                j = this.BIJ.BIR;
                if (i < j) {
                  break label382;
                }
                ((Cursor)localObject1).close();
                Log.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[] { Integer.valueOf(paramk.BIW.size()) });
                if (paramk.BHY.BIy.length <= 1) {
                  break label1268;
                }
                if (paramk.BIW.size() > 2) {
                  paramk.BIW = paramk.BIW.subList(0, 2);
                }
                ((HashSet)localObject2).clear();
                i = 0;
                while (i < paramk.BIW.size())
                {
                  ((HashSet)localObject2).add(((com.tencent.mm.plugin.fts.a.a.m)paramk.BIW.get(i)).BHS);
                  i += 1;
                }
                localObject1 = "";
                break;
              } while (((com.tencent.mm.plugin.fts.a.a.n)localObject3).type != 131072);
              e.a(e.this);
            } while (!com.tencent.mm.plugin.fts.c.e.aIf(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS));
            localHashSet.add(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS);
          }
          localObject1 = new HashSet();
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(52753);
        }
      }
      localObject3 = e.a(e.this);
      localObject5 = paramk.BHY;
      localObject4 = this.BIJ.BIP;
      i = this.BIJ.scene;
      j = this.BIJ.BIR;
      int k = this.BIJ.BIS.size();
      localObject5 = ((com.tencent.mm.plugin.fts.a.a.h)localObject5).eqQ();
      localObject4 = " AND type IN " + d.C((int[])localObject4);
      localObject4 = String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (String)localObject4 + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), localObject5 }) + " ORDER BY score desc limit " + (j + k) + ";", new Object[] { ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqI(), ((com.tencent.mm.plugin.fts.c.e)localObject3).eqJ() });
      localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject3).BGp.rawQuery((String)localObject4, new String[] { "​chatroom_tophits" });
      while (((Cursor)localObject3).moveToNext())
      {
        localObject4 = ((Cursor)localObject3).getString(0);
        if (!((HashSet)localObject2).contains(localObject4)) {
          ((HashSet)localObject1).add(localObject4);
        }
      }
      ((Cursor)localObject3).close();
      localObject2 = (com.tencent.mm.plugin.fts.c.a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = paramk.BHY;
        localObject5 = ((com.tencent.mm.plugin.fts.a.a.h)localObject4).eqQ();
        l = ((com.tencent.mm.plugin.fts.a.a.h)localObject4).BIA.size();
        localObject4 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), Long.valueOf(l), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqI(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), ((com.tencent.mm.plugin.fts.c.a)localObject2).eqJ(), localObject5 });
        localObject3 = ((com.tencent.mm.plugin.fts.a.a)localObject2).BGp.rawQuery((String)localObject4, new String[] { localObject3 });
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject3);
          ((com.tencent.mm.plugin.fts.a.a.n)localObject4).BJh = "​chatroom_tophits";
          ((com.tencent.mm.plugin.fts.a.a.n)localObject4).eqT();
          paramk.BIW.add(localObject4);
          if (paramk.BIW.size() >= this.BIJ.BIR) {
            break;
          }
        }
        ((Cursor)localObject3).close();
      }
      label1268:
      paramk = localHashSet.iterator();
      while (paramk.hasNext())
      {
        localObject1 = (String)paramk.next();
        e.this.aIa((String)localObject1);
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
    private HashMap<String, String> BHd;
    private com.tencent.mm.plugin.fts.a.a.m BLr;
    private String query;
    private int scene;
    
    private c() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(52754);
      com.tencent.mm.plugin.fts.c.e locale = e.a(e.this);
      Object localObject1 = this.query;
      com.tencent.mm.plugin.fts.a.a.m localm = this.BLr;
      int k = this.scene;
      Object localObject3 = this.BHd;
      Object localObject2 = ((String)localObject1).trim();
      ((HashMap)localObject3).remove(localm.BHS);
      long l = System.currentTimeMillis();
      if (((localm.type == 131072) || (localm.type == 131075)) && (com.tencent.mm.plugin.fts.c.e.aIf(localm.BHS)))
      {
        Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
        AppMethodBeat.o(52754);
        return true;
      }
      locale.BGp.beginTransaction();
      localObject1 = localm.BHS;
      int i = localm.BHR;
      Object localObject4 = String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[] { locale.eqI() });
      localObject1 = locale.BGp.rawQuery((String)localObject4, new String[] { localObject2, localObject1, String.valueOf(i), String.valueOf(k) });
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
            localObject1 = String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[] { locale.eqI(), Integer.valueOf(k), localObject1 });
            locale.BGp.execSQL((String)localObject1);
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
              localObject1 = String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[] { locale.eqI(), Integer.valueOf(k), localObject1 });
              locale.BGp.execSQL((String)localObject1, new String[] { "​chatroom_tophits" });
            }
            if ((i >= 0) && (j >= 0)) {
              if (j > 6)
              {
                j += 1;
                label621:
                localObject1 = String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[] { locale.eqI() });
                locale.BGp.execSQL((String)localObject1, new String[] { String.valueOf(j), String.valueOf(l), String.valueOf(i) });
              }
            }
            for (;;)
            {
              locale.BGp.commit();
              localObject1 = c.a.BHa.split((CharSequence)localObject2);
              if ((localObject1.length <= 1) || (localm.type != 131075) || (localm.BHR != 38)) {
                break;
              }
              localObject2 = new HashSet();
              localObject3 = new l();
              localObject4 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[] { locale.eqI() });
              localObject4 = locale.BGp.rawQuery((String)localObject4, new String[] { localm.BHS, "​chatroom_tophits" });
              if (!((Cursor)localObject4).moveToNext()) {
                break label1012;
              }
              ((l)localObject3).convertFrom((Cursor)localObject4);
              localObject5 = c.a.BGW.split(((l)localObject3).BJa);
              j = localObject5.length;
              i = 0;
              while (i < j)
              {
                ((HashSet)localObject2).add(localObject5[i]);
                i += 1;
              }
              j += 3;
              break label621;
              locale.BLK.bindString(1, localm.content);
              locale.BLK.execute();
              locale.BLL.bindLong(1, localm.type);
              locale.BLL.bindLong(2, localm.BHR);
              locale.BLL.bindLong(3, localm.BIZ);
              locale.BLL.bindString(4, localm.BHS);
              locale.BLL.bindLong(5, l);
              locale.BLL.bindString(6, (String)localObject2);
              locale.BLL.bindLong(7, 3L);
              locale.BLL.bindLong(8, k);
              locale.BLL.bindString(9, localm.content);
              locale.BLL.execute();
            }
            label1012:
            ((Cursor)localObject4).close();
            i = 0;
            while ((i < localm.BJg.size()) && (i < localObject1.length))
            {
              localObject4 = (g)localm.BJg.get(i);
              if (((HashSet)localObject2).add(((g)localObject4).content)) {
                ((l)localObject3).BJa = (((l)localObject3).BJa + ((g)localObject4).content + "​");
              }
              i += 1;
            }
            Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[] { ((l)localObject3).BJa });
            if (((l)localObject3).BIX > 0L) {
              locale.NE(((l)localObject3).BIX);
            }
            ((l)localObject3).BIX = 0L;
            ((l)localObject3).query = "​chatroom_tophits";
            ((l)localObject3).BIY += 1L;
            ((l)localObject3).kVd = k;
            ((l)localObject3).BHS = localm.BHS;
            ((l)localObject3).BIZ = localm.BIZ;
            ((l)localObject3).type = localm.type;
            ((l)localObject3).BHR = localm.BHR;
            ((l)localObject3).timestamp = l;
            locale.BGp.beginTransaction();
            locale.BLK.bindString(1, ((l)localObject3).BJa);
            locale.BLK.execute();
            locale.BLL.bindLong(1, ((l)localObject3).type);
            locale.BLL.bindLong(2, ((l)localObject3).BHR);
            locale.BLL.bindLong(3, ((l)localObject3).BIZ);
            locale.BLL.bindString(4, ((l)localObject3).BHS);
            locale.BLL.bindLong(5, ((l)localObject3).timestamp);
            locale.BLL.bindString(6, ((l)localObject3).query);
            locale.BLL.bindLong(7, ((l)localObject3).BIY);
            locale.BLL.bindLong(8, ((l)localObject3).kVd);
            locale.BLL.bindString(9, ((l)localObject3).BJa);
            locale.BLL.execute();
            locale.BGp.commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e
 * JD-Core Version:    0.7.0.1
 */