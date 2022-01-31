package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class e
  extends a
{
  public SQLiteStatement kzT;
  public SQLiteStatement kzU;
  public SQLiteStatement kzV;
  
  public static boolean Eh(String paramString)
  {
    long l = System.currentTimeMillis();
    return ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HV(paramString) < l - 5184000000L;
  }
  
  protected final boolean BA()
  {
    return !cT(-100, 3);
  }
  
  protected final boolean BB()
  {
    super.BB();
    this.kzT.close();
    this.kzU.close();
    this.kzV.close();
    return true;
  }
  
  protected final void Bz()
  {
    if (BA()) {
      this.kuE.A(-100L, 3L);
    }
    this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { aVs(), aVs() }));
    this.kuE.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { aVs(), aVs() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { aVt() });
    this.kzT = this.kuE.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { aVs() });
    this.kzU = this.kuE.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { aVs() });
    this.kzV = this.kuE.compileStatement(str);
  }
  
  protected final String aQT()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { aVs() });
  }
  
  public final int aVT()
  {
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { aVs() });
    Object localObject2 = this.kuE.rawQuery((String)localObject1, null);
    localObject1 = new ArrayList();
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new k();
      ((k)localObject3).d((Cursor)localObject2);
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
      k localk = (k)localIterator.next();
      bool = false;
      if (localk.type == 262144) {
        localObject2 = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((i)localObject2).bG(localk.kwg, localk.kwf);
        }
        if (bk.bl((String)localObject1)) {
          break label459;
        }
        if (!localk.bVk.equals("​chatroom_tophits")) {
          break label397;
        }
        String[] arrayOfString = c.a.kvl.split(localk.kxl);
        localObject2 = "";
        int j = arrayOfString.length;
        int i = 0;
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
        localObject2 = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3);
        bool = Eh(localk.kwg);
      }
      if (!localk.kxl.equals(localObject2))
      {
        localk.kxl = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(localk.kxi));
        localLinkedList3.add(localk);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(localk.kxi));
        continue;
        label397:
        if (!localk.kxl.equals(localObject1))
        {
          localk.kxl = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(localk.kxi));
          localLinkedList3.add(localk);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(localk.kxi));
          continue;
          label459:
          localLinkedList2.add(Long.valueOf(localk.kxi));
        }
      }
    }
    y.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      by(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.kuE.inTransaction();
      if (!bool) {
        this.kuE.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (k)((Iterator)localObject1).next();
        if (!bk.bl(((k)localObject2).kxl))
        {
          this.kzT.bindString(1, ((k)localObject2).kxl);
          this.kzT.execute();
          this.kzU.bindLong(1, ((k)localObject2).type);
          this.kzU.bindLong(2, ((k)localObject2).kwf);
          this.kzU.bindLong(3, ((k)localObject2).kxk);
          this.kzU.bindString(4, ((k)localObject2).kwg);
          this.kzU.bindLong(5, ((k)localObject2).timestamp);
          this.kzU.bindString(6, ((k)localObject2).bVk);
          this.kzU.bindLong(7, ((k)localObject2).kxj);
          this.kzU.bindLong(8, ((k)localObject2).dYk);
          this.kzU.bindString(9, ((k)localObject2).kxl);
          this.kzU.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      g(localLinkedList1, 0);
    }
    return localLinkedList2.size();
  }
  
  public final String getName()
  {
    return "FTS5TopHitsStorage";
  }
  
  public final int getPriority()
  {
    return 768;
  }
  
  protected final String getTableName()
  {
    return "TopHits";
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.e
 * JD-Core Version:    0.7.0.1
 */