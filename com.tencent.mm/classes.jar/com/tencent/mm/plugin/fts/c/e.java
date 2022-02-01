package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
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
  public SQLiteStatement BLK;
  public SQLiteStatement BLL;
  private SQLiteStatement BLM;
  
  public static boolean aIf(String paramString)
  {
    AppMethodBeat.i(52814);
    long l = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aPa(paramString) < l - 5184000000L)
    {
      AppMethodBeat.o(52814);
      return true;
    }
    AppMethodBeat.o(52814);
    return false;
  }
  
  public final void aEr()
  {
    AppMethodBeat.i(52811);
    if (aEs()) {
      this.BGp.ad(-100L, 5L);
    }
    this.BGp.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { eqI(), eqI() }));
    this.BGp.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { eqI(), eqI() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { eqJ() });
    this.BLK = this.BGp.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { eqI() });
    this.BLL = this.BGp.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { eqI() });
    this.BLM = this.BGp.compileStatement(str);
    AppMethodBeat.o(52811);
  }
  
  public final boolean aEs()
  {
    AppMethodBeat.i(52817);
    if (!hw(-100, 5))
    {
      AppMethodBeat.o(52817);
      return true;
    }
    AppMethodBeat.o(52817);
    return false;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(52815);
    super.aEt();
    this.BLK.close();
    this.BLL.close();
    this.BLM.close();
    AppMethodBeat.o(52815);
    return true;
  }
  
  public final void aIe(String paramString)
  {
    AppMethodBeat.i(52812);
    this.BLM.bindLong(1, 1L);
    this.BLM.bindString(2, paramString);
    this.BLM.execute();
    AppMethodBeat.o(52812);
  }
  
  public final String dkv()
  {
    AppMethodBeat.i(52816);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { eqI() });
    AppMethodBeat.o(52816);
    return str;
  }
  
  public final int ert()
  {
    AppMethodBeat.i(52813);
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { eqI() });
    Object localObject2 = this.BGp.rawQuery((String)localObject1, null);
    localObject1 = new ArrayList();
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new l();
      ((l)localObject3).convertFrom((Cursor)localObject2);
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
      l locall = (l)localIterator.next();
      bool = false;
      if (locall.type == 262144) {
        localObject2 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((com.tencent.mm.plugin.fts.a.i)localObject2).eu(locall.BHS, locall.BHR);
        }
        if (Util.isNullOrNil((String)localObject1)) {
          break label465;
        }
        if (!locall.query.equals("​chatroom_tophits")) {
          break label403;
        }
        String[] arrayOfString = c.a.BGW.split(locall.BJa);
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
        localObject2 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
        bool = aIf(locall.BHS);
      }
      if (!locall.BJa.equals(localObject2))
      {
        locall.BJa = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(locall.BIX));
        localLinkedList3.add(locall);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(locall.BIX));
        continue;
        label403:
        if (!locall.BJa.equals(localObject1))
        {
          locall.BJa = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(locall.BIX));
          localLinkedList3.add(locall);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(locall.BIX));
          continue;
          label465:
          localLinkedList2.add(Long.valueOf(locall.BIX));
        }
      }
    }
    Log.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      fd(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.BGp.inTransaction();
      if (!bool) {
        this.BGp.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        if (!Util.isNullOrNil(((l)localObject2).BJa))
        {
          this.BLK.bindString(1, ((l)localObject2).BJa);
          this.BLK.execute();
          this.BLL.bindLong(1, ((l)localObject2).type);
          this.BLL.bindLong(2, ((l)localObject2).BHR);
          this.BLL.bindLong(3, ((l)localObject2).BIZ);
          this.BLL.bindString(4, ((l)localObject2).BHS);
          this.BLL.bindLong(5, ((l)localObject2).timestamp);
          this.BLL.bindString(6, ((l)localObject2).query);
          this.BLL.bindLong(7, ((l)localObject2).BIY);
          this.BLL.bindLong(8, ((l)localObject2).kVd);
          this.BLL.bindString(9, ((l)localObject2).BJa);
          this.BLL.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      u(localLinkedList1, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.e
 * JD-Core Version:    0.7.0.1
 */