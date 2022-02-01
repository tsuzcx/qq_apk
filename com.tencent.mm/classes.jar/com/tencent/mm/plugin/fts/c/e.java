package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class e
  extends a
{
  public SQLiteStatement wZL;
  public SQLiteStatement wZM;
  private SQLiteStatement wZN;
  
  public static boolean ayK(String paramString)
  {
    AppMethodBeat.i(52814);
    long l = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEQ(paramString) < l - 5184000000L)
    {
      AppMethodBeat.o(52814);
      return true;
    }
    AppMethodBeat.o(52814);
    return false;
  }
  
  public final void awY()
  {
    AppMethodBeat.i(52811);
    if (awZ()) {
      this.wUt.W(-100L, 5L);
    }
    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { dOt(), dOt() }));
    this.wUt.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { dOt(), dOt() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { dOu() });
    this.wZL = this.wUt.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { dOt() });
    this.wZM = this.wUt.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { dOt() });
    this.wZN = this.wUt.compileStatement(str);
    AppMethodBeat.o(52811);
  }
  
  public final boolean awZ()
  {
    AppMethodBeat.i(52817);
    if (!gD(-100, 5))
    {
      AppMethodBeat.o(52817);
      return true;
    }
    AppMethodBeat.o(52817);
    return false;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(52815);
    super.axa();
    this.wZL.close();
    this.wZM.close();
    this.wZN.close();
    AppMethodBeat.o(52815);
    return true;
  }
  
  public final void ayJ(String paramString)
  {
    AppMethodBeat.i(52812);
    this.wZN.bindLong(1, 1L);
    this.wZN.bindString(2, paramString);
    this.wZN.execute();
    AppMethodBeat.o(52812);
  }
  
  public final String cVp()
  {
    AppMethodBeat.i(52816);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { dOt() });
    AppMethodBeat.o(52816);
    return str;
  }
  
  public final int dOZ()
  {
    AppMethodBeat.i(52813);
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { dOt() });
    Object localObject2 = this.wUt.rawQuery((String)localObject1, null);
    localObject1 = new ArrayList();
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new com.tencent.mm.plugin.fts.a.a.l();
      ((com.tencent.mm.plugin.fts.a.a.l)localObject3).convertFrom((Cursor)localObject2);
      ((List)localObject1).add(localObject3);
    }
    ((Cursor)localObject2).close();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList3 = new LinkedList();
    Iterator localIterator = ((List)localObject1).iterator();
    boolean bool;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)localIterator.next();
      bool = false;
      if (locall.type == 262144) {
        localObject2 = ((n)g.ah(n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((com.tencent.mm.plugin.fts.a.i)localObject2).dX(locall.wVX, locall.wVW);
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label465;
        }
        if (!locall.query.equals("​chatroom_tophits")) {
          break label403;
        }
        String[] arrayOfString = c.a.wVa.split(locall.wXf);
        localObject2 = "";
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          localObject3 = localObject2;
          if (((String)localObject1).indexOf(str) >= 0) {
            localObject3 = (String)localObject2 + str + "​";
          }
          i += 1;
          localObject2 = localObject3;
        }
        localObject2 = ((n)g.ah(n.class)).getFTSIndexStorage(3);
        bool = ayK(locall.wVX);
      }
      if (!locall.wXf.equals(localObject2))
      {
        locall.wXf = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(locall.wXc));
        localLinkedList3.add(locall);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(locall.wXc));
        continue;
        label403:
        if (!locall.wXf.equals(localObject1))
        {
          locall.wXf = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(locall.wXc));
          localLinkedList3.add(locall);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(locall.wXc));
          continue;
          label465:
          localLinkedList2.add(Long.valueOf(locall.wXc));
        }
      }
    }
    Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      eN(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.wUt.inTransaction();
      if (!bool) {
        this.wUt.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.l)((Iterator)localObject1).next();
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.l)localObject2).wXf))
        {
          this.wZL.bindString(1, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wXf);
          this.wZL.execute();
          this.wZM.bindLong(1, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).type);
          this.wZM.bindLong(2, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wVW);
          this.wZM.bindLong(3, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wXe);
          this.wZM.bindString(4, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wVX);
          this.wZM.bindLong(5, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).timestamp);
          this.wZM.bindString(6, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).query);
          this.wZM.bindLong(7, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wXd);
          this.wZM.bindLong(8, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).igp);
          this.wZM.bindString(9, ((com.tencent.mm.plugin.fts.a.a.l)localObject2).wXf);
          this.wZM.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      v(localLinkedList1, 0);
    }
    int i = localLinkedList2.size();
    AppMethodBeat.o(52813);
    return i;
  }
  
  public final String getName()
  {
    return "FTS5TopHitsStorage";
  }
  
  public final int getPriority()
  {
    return 768;
  }
  
  public final String getTableName()
  {
    return "TopHits";
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.e
 * JD-Core Version:    0.7.0.1
 */