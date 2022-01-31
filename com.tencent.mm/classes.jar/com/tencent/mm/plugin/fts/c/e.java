package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class e
  extends a
{
  public SQLiteStatement mVK;
  public SQLiteStatement mVL;
  private SQLiteStatement mVM;
  
  public static boolean Ps(String paramString)
  {
    AppMethodBeat.i(136841);
    long l = System.currentTimeMillis();
    if (((j)g.E(j.class)).bPQ().TE(paramString) < l - 5184000000L)
    {
      AppMethodBeat.o(136841);
      return true;
    }
    AppMethodBeat.o(136841);
    return false;
  }
  
  public final void Pn()
  {
    AppMethodBeat.i(136838);
    if (Po()) {
      this.mQr.M(-100L, 3L);
    }
    this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[] { bBR(), bBR() }));
    this.mQr.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[] { bBR(), bBR() }));
    String str = String.format("INSERT INTO %s (content) VALUES (?);", new Object[] { bBS() });
    this.mVK = this.mQr.compileStatement(str);
    str = String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { bBR() });
    this.mVL = this.mQr.compileStatement(str);
    str = String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[] { bBR() });
    this.mVM = this.mQr.compileStatement(str);
    AppMethodBeat.o(136838);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(136844);
    if (!er(-100, 3))
    {
      AppMethodBeat.o(136844);
      return true;
    }
    AppMethodBeat.o(136844);
    return false;
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136842);
    super.Pp();
    this.mVK.close();
    this.mVL.close();
    this.mVM.close();
    AppMethodBeat.o(136842);
    return true;
  }
  
  public final void Pr(String paramString)
  {
    AppMethodBeat.i(136839);
    this.mVM.bindLong(1, 1L);
    this.mVM.bindString(2, paramString);
    this.mVM.execute();
    AppMethodBeat.o(136839);
  }
  
  public final int bCw()
  {
    AppMethodBeat.i(136840);
    Object localObject1 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[] { bBR() });
    Object localObject2 = this.mQr.rawQuery((String)localObject1, null);
    localObject1 = new ArrayList();
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new k();
      ((k)localObject3).convertFrom((Cursor)localObject2);
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
        localObject2 = ((n)g.G(n.class)).getFTSIndexStorage(17);
      }
      for (;;)
      {
        localObject1 = null;
        if (!bool) {
          localObject1 = ((i)localObject2).co(localk.mRV, localk.mRU);
        }
        if (bo.isNullOrNil((String)localObject1)) {
          break label464;
        }
        if (!localk.query.equals("​chatroom_tophits")) {
          break label402;
        }
        String[] arrayOfString = c.a.mQY.split(localk.mTa);
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
        localObject2 = ((n)g.G(n.class)).getFTSIndexStorage(3);
        bool = Ps(localk.mRV);
      }
      if (!localk.mTa.equals(localObject2))
      {
        localk.mTa = ((String)localObject2);
        localLinkedList2.add(Long.valueOf(localk.mSX));
        localLinkedList3.add(localk);
      }
      else
      {
        localLinkedList1.add(Long.valueOf(localk.mSX));
        continue;
        label402:
        if (!localk.mTa.equals(localObject1))
        {
          localk.mTa = ((String)localObject1);
          localLinkedList2.add(Long.valueOf(localk.mSX));
          localLinkedList3.add(localk);
        }
        else
        {
          localLinkedList1.add(Long.valueOf(localk.mSX));
          continue;
          label464:
          localLinkedList2.add(Long.valueOf(localk.mSX));
        }
      }
    }
    ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList3.size()), Integer.valueOf(localLinkedList1.size()) });
    if (localLinkedList2.size() > 0) {
      bS(localLinkedList2);
    }
    if (localLinkedList3.size() > 0)
    {
      bool = this.mQr.inTransaction();
      if (!bool) {
        this.mQr.beginTransaction();
      }
      localObject1 = localLinkedList3.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (k)((Iterator)localObject1).next();
        if (!bo.isNullOrNil(((k)localObject2).mTa))
        {
          this.mVK.bindString(1, ((k)localObject2).mTa);
          this.mVK.execute();
          this.mVL.bindLong(1, ((k)localObject2).type);
          this.mVL.bindLong(2, ((k)localObject2).mRU);
          this.mVL.bindLong(3, ((k)localObject2).mSZ);
          this.mVL.bindString(4, ((k)localObject2).mRV);
          this.mVL.bindLong(5, ((k)localObject2).timestamp);
          this.mVL.bindString(6, ((k)localObject2).query);
          this.mVL.bindLong(7, ((k)localObject2).mSY);
          this.mVL.bindLong(8, ((k)localObject2).foo);
          this.mVL.bindString(9, ((k)localObject2).mTa);
          this.mVL.execute();
        }
      }
      if (!bool) {
        commit();
      }
    }
    if (localLinkedList1.size() > 0) {
      l(localLinkedList1, 0);
    }
    int i = localLinkedList2.size();
    AppMethodBeat.o(136840);
    return i;
  }
  
  public final String bxi()
  {
    AppMethodBeat.i(136843);
    String str = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[] { bBR() });
    AppMethodBeat.o(136843);
    return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.e
 * JD-Core Version:    0.7.0.1
 */