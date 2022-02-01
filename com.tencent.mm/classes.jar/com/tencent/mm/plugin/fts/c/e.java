package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class e
  extends a
{
  public SQLiteStatement rsA;
  public SQLiteStatement rsB;
  private SQLiteStatement rsC;
  
  public static boolean abs(String paramString)
  {
    AppMethodBeat.i(52814);
    long l = System.currentTimeMillis();
    if (((k)g.ab(k.class)).cOI().agI(paramString) < l - 5184000000L)
    {
      AppMethodBeat.o(52814);
      return true;
    }
    AppMethodBeat.o(52814);
    return false;
  }
  
  public final void abr(String paramString)
  {
    AppMethodBeat.i(52812);
    this.rsC.bindLong(1, 1L);
    this.rsC.bindString(2, paramString);
    this.rsC.execute();
    AppMethodBeat.o(52812);
  }
  
  public final void acM()
  {
    AppMethodBeat.i(52811);
    if (acN()) {
      this.rni.U(-100L, 5L);
    }
    this.rni.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { cxe(), cxe() }));
    this.rni.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { cxe(), cxe() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { cxf() });
    this.rsA = this.rni.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { cxe() });
    this.rsB = this.rni.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { cxe() });
    this.rsC = this.rni.compileStatement(str);
    AppMethodBeat.o(52811);
  }
  
  public final boolean acN()
  {
    AppMethodBeat.i(52817);
    if (!fH(-100, 5))
    {
      AppMethodBeat.o(52817);
      return true;
    }
    AppMethodBeat.o(52817);
    return false;
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(52815);
    super.acO();
    this.rsA.close();
    this.rsB.close();
    this.rsC.close();
    AppMethodBeat.o(52815);
    return true;
  }
  
  public final String ciy()
  {
    AppMethodBeat.i(52816);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { cxe() });
    AppMethodBeat.o(52816);
    return str;
  }
  
  public final int cxK()
  {
    AppMethodBeat.i(52813);
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { cxe() });
    Object localObject2 = this.rni.rawQuery((String)localObject1, null);
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
        localObject2 = ((n)g.ad(n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((i)localObject2).di(locall.roN, locall.roM);
        }
        if (bt.isNullOrNil((String)localObject1)) {
          break label465;
        }
        if (!locall.query.equals("​chatroom_tophits")) {
          break label403;
        }
        String[] arrayOfString = c.a.rnP.split(locall.rpU);
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
        localObject2 = ((n)g.ad(n.class)).getFTSIndexStorage(3);
        bool = abs(locall.roN);
      }
      if (!locall.rpU.equals(localObject2))
      {
        locall.rpU = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(locall.rpR));
        localLinkedList3.add(locall);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(locall.rpR));
        continue;
        label403:
        if (!locall.rpU.equals(localObject1))
        {
          locall.rpU = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(locall.rpR));
          localLinkedList3.add(locall);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(locall.rpR));
          continue;
          label465:
          localLinkedList2.add(Long.valueOf(locall.rpR));
        }
      }
    }
    ad.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      dD(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.rni.inTransaction();
      if (!bool) {
        this.rni.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        if (!bt.isNullOrNil(((l)localObject2).rpU))
        {
          this.rsA.bindString(1, ((l)localObject2).rpU);
          this.rsA.execute();
          this.rsB.bindLong(1, ((l)localObject2).type);
          this.rsB.bindLong(2, ((l)localObject2).roM);
          this.rsB.bindLong(3, ((l)localObject2).rpT);
          this.rsB.bindString(4, ((l)localObject2).roN);
          this.rsB.bindLong(5, ((l)localObject2).timestamp);
          this.rsB.bindString(6, ((l)localObject2).query);
          this.rsB.bindLong(7, ((l)localObject2).rpS);
          this.rsB.bindLong(8, ((l)localObject2).gri);
          this.rsB.bindString(9, ((l)localObject2).rpU);
          this.rsB.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      o(localLinkedList1, 0);
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