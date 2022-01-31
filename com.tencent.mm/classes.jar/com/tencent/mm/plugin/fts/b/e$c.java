package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

final class e$c
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private HashMap<String, String> mRf;
  private l mVq;
  private String query;
  private int scene;
  
  private e$c(e parame) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136780);
    com.tencent.mm.plugin.fts.c.e locale = this.mVp.mVl;
    Object localObject1 = this.query;
    l locall = this.mVq;
    int k = this.scene;
    Object localObject3 = this.mRf;
    Object localObject2 = ((String)localObject1).trim();
    ((HashMap)localObject3).remove(locall.mRV);
    boolean bool = locale.mQr.inTransaction();
    if (!bool) {
      locale.mQr.beginTransaction();
    }
    long l = System.currentTimeMillis();
    if (((locall.type == 131072) || (locall.type == 131075)) && (com.tencent.mm.plugin.fts.c.e.Ps(locall.mRV)))
    {
      ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
      AppMethodBeat.o(136780);
      return true;
    }
    localObject1 = locall.mRV;
    int i = locall.mRU;
    Object localObject4 = String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[] { locale.bBR() });
    localObject1 = locale.mQr.rawQuery((String)localObject4, new String[] { localObject2, localObject1, String.valueOf(i), String.valueOf(k) });
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
      label257:
      Object localObject5;
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        if (((String)((Map.Entry)localObject5).getValue()).equals("​chatroom_tophits")) {
          break label1428;
        }
        localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject5).getKey() + "',";
      }
      label1035:
      label1425:
      label1428:
      for (;;)
      {
        break label257;
        if (((String)localObject1).length() > 0)
        {
          localObject1 = "AND aux_index IN (" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
          localObject1 = String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[] { locale.bBR(), Integer.valueOf(k), localObject1 });
          locale.mQr.execSQL((String)localObject1);
        }
        localObject1 = "";
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        label442:
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          if (!((String)((Map.Entry)localObject4).getValue()).equals("​chatroom_tophits")) {
            break label1425;
          }
          localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject4).getKey() + "',";
        }
        for (;;)
        {
          break label442;
          if (((String)localObject1).length() > 0)
          {
            localObject1 = "AND aux_index IN(" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
            localObject1 = String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[] { locale.bBR(), Integer.valueOf(k), localObject1 });
            locale.mQr.execSQL((String)localObject1, new String[] { "​chatroom_tophits" });
          }
          if ((i >= 0) && (j >= 0)) {
            if (j > 6)
            {
              j += 1;
              label638:
              localObject1 = String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[] { locale.bBR() });
              locale.mQr.execSQL((String)localObject1, new String[] { String.valueOf(j), String.valueOf(l), String.valueOf(i) });
            }
          }
          for (;;)
          {
            if (!bool) {
              locale.mQr.commit();
            }
            localObject1 = c.a.mRc.split((CharSequence)localObject2);
            if ((localObject1.length <= 1) || (locall.type != 131075) || (locall.mRU != 38)) {
              break;
            }
            localObject2 = new HashSet();
            localObject3 = new k();
            localObject4 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[] { locale.bBR() });
            localObject4 = locale.mQr.rawQuery((String)localObject4, new String[] { locall.mRV, "​chatroom_tophits" });
            if (!((Cursor)localObject4).moveToNext()) {
              break label1035;
            }
            ((k)localObject3).convertFrom((Cursor)localObject4);
            localObject5 = c.a.mQY.split(((k)localObject3).mTa);
            j = localObject5.length;
            i = 0;
            while (i < j)
            {
              ((HashSet)localObject2).add(localObject5[i]);
              i += 1;
            }
            j += 3;
            break label638;
            locale.mVK.bindString(1, locall.content);
            locale.mVK.execute();
            locale.mVL.bindLong(1, locall.type);
            locale.mVL.bindLong(2, locall.mRU);
            locale.mVL.bindLong(3, locall.mSZ);
            locale.mVL.bindString(4, locall.mRV);
            locale.mVL.bindLong(5, l);
            locale.mVL.bindString(6, (String)localObject2);
            locale.mVL.bindLong(7, 3L);
            locale.mVL.bindLong(8, k);
            locale.mVL.bindString(9, locall.content);
            locale.mVL.execute();
          }
          ((Cursor)localObject4).close();
          i = 0;
          while ((i < locall.mTg.size()) && (i < localObject1.length))
          {
            localObject4 = (f)locall.mTg.get(i);
            if (((HashSet)localObject2).add(((f)localObject4).content)) {
              ((k)localObject3).mTa = (((k)localObject3).mTa + ((f)localObject4).content + "​");
            }
            i += 1;
          }
          ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[] { ((k)localObject3).mTa });
          if (((k)localObject3).mSX > 0L) {
            locale.g(Long.valueOf(((k)localObject3).mSX));
          }
          ((k)localObject3).mSX = 0L;
          ((k)localObject3).query = "​chatroom_tophits";
          ((k)localObject3).mSY += 1L;
          ((k)localObject3).foo = k;
          ((k)localObject3).mRV = locall.mRV;
          ((k)localObject3).mSZ = locall.mSZ;
          ((k)localObject3).type = locall.type;
          ((k)localObject3).mRU = locall.mRU;
          ((k)localObject3).timestamp = l;
          locale.mVK.bindString(1, ((k)localObject3).mTa);
          locale.mVK.execute();
          locale.mVL.bindLong(1, ((k)localObject3).type);
          locale.mVL.bindLong(2, ((k)localObject3).mRU);
          locale.mVL.bindLong(3, ((k)localObject3).mSZ);
          locale.mVL.bindString(4, ((k)localObject3).mRV);
          locale.mVL.bindLong(5, ((k)localObject3).timestamp);
          locale.mVL.bindString(6, ((k)localObject3).query);
          locale.mVL.bindLong(7, ((k)localObject3).mSY);
          locale.mVL.bindLong(8, ((k)localObject3).foo);
          locale.mVL.bindString(9, ((k)localObject3).mTa);
          locale.mVL.execute();
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
    AppMethodBeat.i(136781);
    String str = String.format("%s : query=%s scene=%d", new Object[] { super.toString(), this.query, Integer.valueOf(this.scene) });
    AppMethodBeat.o(136781);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.c
 * JD-Core Version:    0.7.0.1
 */