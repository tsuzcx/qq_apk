package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class g
  extends a
{
  public SQLiteStatement HwG;
  public SQLiteStatement HwH;
  private SQLiteStatement HwI;
  
  public static boolean aEE(String paramString)
  {
    AppMethodBeat.i(52814);
    long l = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().Hq(paramString) < l - 5184000000L)
    {
      AppMethodBeat.o(52814);
      return true;
    }
    AppMethodBeat.o(52814);
    return false;
  }
  
  public final void aED(String paramString)
  {
    AppMethodBeat.i(52812);
    this.HwI.bindLong(1, 1L);
    this.HwI.bindString(2, paramString);
    this.HwI.execute();
    AppMethodBeat.o(52812);
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(52811);
    if (aXw()) {
      this.HqR.aG(-100L, 6L);
    }
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { fxn(), fxn() }));
    this.HqR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { fxn(), fxn() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { fxo() });
    this.HwG = this.HqR.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { fxn() });
    this.HwH = this.HqR.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { fxn() });
    this.HwI = this.HqR.compileStatement(str);
    AppMethodBeat.o(52811);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(52817);
    if (!iV(-100, 6))
    {
      AppMethodBeat.o(52817);
      return true;
    }
    AppMethodBeat.o(52817);
    return false;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(52815);
    super.aXx();
    this.HwG.close();
    this.HwH.close();
    this.HwI.close();
    AppMethodBeat.o(52815);
    return true;
  }
  
  public final String dRh()
  {
    AppMethodBeat.i(52816);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { fxn() });
    AppMethodBeat.o(52816);
    return str;
  }
  
  public final int fyb()
  {
    AppMethodBeat.i(52813);
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { fxn() });
    Object localObject2 = this.HqR.rawQuery((String)localObject1, null);
    localObject1 = new ArrayList();
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new com.tencent.mm.plugin.fts.a.a.n();
      ((com.tencent.mm.plugin.fts.a.a.n)localObject3).convertFrom((Cursor)localObject2);
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
      com.tencent.mm.plugin.fts.a.a.n localn = (com.tencent.mm.plugin.fts.a.a.n)localIterator.next();
      bool = false;
      if (localn.type == 262144) {
        localObject2 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((com.tencent.mm.plugin.fts.a.i)localObject2).fj(localn.Hsz, localn.subtype);
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label465;
        }
        if (!localn.query.equals("​chatroom_tophits")) {
          break label403;
        }
        String[] arrayOfString = c.a.HrA.split(localn.HtJ);
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
        localObject2 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
        bool = aEE(localn.Hsz);
      }
      if (!localn.HtJ.equals(localObject2))
      {
        localn.HtJ = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(localn.HtG));
        localLinkedList3.add(localn);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(localn.HtG));
        continue;
        label403:
        if (!localn.HtJ.equals(localObject1))
        {
          localn.HtJ = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(localn.HtG));
          localLinkedList3.add(localn);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(localn.HtG));
          continue;
          label465:
          localLinkedList2.add(Long.valueOf(localn.HtG));
        }
      }
    }
    Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      hP(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.HqR.inTransaction();
      if (!bool) {
        this.HqR.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.n)((Iterator)localObject1).next();
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.fts.a.a.n)localObject2).HtJ))
        {
          this.HwG.bindString(1, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).HtJ);
          this.HwG.execute();
          this.HwH.bindLong(1, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).type);
          this.HwH.bindLong(2, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).subtype);
          this.HwH.bindLong(3, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).HtI);
          this.HwH.bindString(4, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).Hsz);
          this.HwH.bindLong(5, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).timestamp);
          this.HwH.bindString(6, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).query);
          this.HwH.bindLong(7, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).HtH);
          this.HwH.bindLong(8, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).nAz);
          this.HwH.bindString(9, ((com.tencent.mm.plugin.fts.a.a.n)localObject2).HtJ);
          this.HwH.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      N(localLinkedList1, 0);
    }
    int i = localLinkedList2.size();
    AppMethodBeat.o(52813);
    return i;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.FTS.FTS5TopHitsStorage";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g
 * JD-Core Version:    0.7.0.1
 */