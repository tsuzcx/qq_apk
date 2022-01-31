package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.sdk.platformtools.y;
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
  private String bVk;
  private HashMap<String, String> kvs;
  private l kzA;
  private int scene;
  
  private e$c(e parame) {}
  
  public final boolean execute()
  {
    com.tencent.mm.plugin.fts.c.e locale = this.kzz.kzv;
    Object localObject1 = this.bVk;
    l locall = this.kzA;
    int k = this.scene;
    Object localObject3 = this.kvs;
    Object localObject2 = ((String)localObject1).trim();
    ((HashMap)localObject3).remove(locall.kwg);
    boolean bool = locale.kuE.inTransaction();
    if (!bool) {
      locale.kuE.beginTransaction();
    }
    long l = System.currentTimeMillis();
    if (((locall.type == 131072) || (locall.type == 131075)) && (com.tencent.mm.plugin.fts.c.e.Eh(locall.kwg)))
    {
      y.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
      return true;
    }
    localObject1 = locall.kwg;
    int i = locall.kwf;
    Object localObject4 = String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[] { locale.aVs() });
    localObject1 = locale.kuE.rawQuery((String)localObject4, new String[] { localObject2, localObject1, String.valueOf(i), String.valueOf(k) });
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
      label247:
      Object localObject5;
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        if (((String)((Map.Entry)localObject5).getValue()).equals("​chatroom_tophits")) {
          break label1417;
        }
        localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject5).getKey() + "',";
      }
      label1024:
      label1414:
      label1417:
      for (;;)
      {
        break label247;
        if (((String)localObject1).length() > 0)
        {
          localObject1 = "AND aux_index IN (" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
          localObject1 = String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[] { locale.aVs(), Integer.valueOf(k), localObject1 });
          locale.kuE.execSQL((String)localObject1);
        }
        localObject1 = "";
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        label432:
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          if (!((String)((Map.Entry)localObject4).getValue()).equals("​chatroom_tophits")) {
            break label1414;
          }
          localObject1 = (String)localObject1 + "'" + (String)((Map.Entry)localObject4).getKey() + "',";
        }
        for (;;)
        {
          break label432;
          if (((String)localObject1).length() > 0)
          {
            localObject1 = "AND aux_index IN(" + ((String)localObject1).substring(0, ((String)localObject1).length() - 1) + ")";
            localObject1 = String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[] { locale.aVs(), Integer.valueOf(k), localObject1 });
            locale.kuE.execSQL((String)localObject1, new String[] { "​chatroom_tophits" });
          }
          if ((i >= 0) && (j >= 0)) {
            if (j > 6)
            {
              j += 1;
              label628:
              localObject1 = String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[] { locale.aVs() });
              locale.kuE.execSQL((String)localObject1, new String[] { String.valueOf(j), String.valueOf(l), String.valueOf(i) });
            }
          }
          for (;;)
          {
            if (!bool) {
              locale.kuE.commit();
            }
            localObject1 = c.a.kvp.split((CharSequence)localObject2);
            if ((localObject1.length <= 1) || (locall.type != 131075) || (locall.kwf != 38)) {
              break;
            }
            localObject2 = new HashSet();
            localObject3 = new k();
            localObject4 = String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[] { locale.aVs() });
            localObject4 = locale.kuE.rawQuery((String)localObject4, new String[] { locall.kwg, "​chatroom_tophits" });
            if (!((Cursor)localObject4).moveToNext()) {
              break label1024;
            }
            ((k)localObject3).d((Cursor)localObject4);
            localObject5 = c.a.kvl.split(((k)localObject3).kxl);
            j = localObject5.length;
            i = 0;
            while (i < j)
            {
              ((HashSet)localObject2).add(localObject5[i]);
              i += 1;
            }
            j += 3;
            break label628;
            locale.kzT.bindString(1, locall.content);
            locale.kzT.execute();
            locale.kzU.bindLong(1, locall.type);
            locale.kzU.bindLong(2, locall.kwf);
            locale.kzU.bindLong(3, locall.kxk);
            locale.kzU.bindString(4, locall.kwg);
            locale.kzU.bindLong(5, l);
            locale.kzU.bindString(6, (String)localObject2);
            locale.kzU.bindLong(7, 3L);
            locale.kzU.bindLong(8, k);
            locale.kzU.bindString(9, locall.content);
            locale.kzU.execute();
          }
          ((Cursor)localObject4).close();
          i = 0;
          while ((i < locall.kxr.size()) && (i < localObject1.length))
          {
            localObject4 = (f)locall.kxr.get(i);
            if (((HashSet)localObject2).add(((f)localObject4).content)) {
              ((k)localObject3).kxl = (((k)localObject3).kxl + ((f)localObject4).content + "​");
            }
            i += 1;
          }
          y.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[] { ((k)localObject3).kxl });
          if (((k)localObject3).kxi > 0L) {
            locale.h(Long.valueOf(((k)localObject3).kxi));
          }
          ((k)localObject3).kxi = 0L;
          ((k)localObject3).bVk = "​chatroom_tophits";
          ((k)localObject3).kxj += 1L;
          ((k)localObject3).dYk = k;
          ((k)localObject3).kwg = locall.kwg;
          ((k)localObject3).kxk = locall.kxk;
          ((k)localObject3).type = locall.type;
          ((k)localObject3).kwf = locall.kwf;
          ((k)localObject3).timestamp = l;
          locale.kzT.bindString(1, ((k)localObject3).kxl);
          locale.kzT.execute();
          locale.kzU.bindLong(1, ((k)localObject3).type);
          locale.kzU.bindLong(2, ((k)localObject3).kwf);
          locale.kzU.bindLong(3, ((k)localObject3).kxk);
          locale.kzU.bindString(4, ((k)localObject3).kwg);
          locale.kzU.bindLong(5, ((k)localObject3).timestamp);
          locale.kzU.bindString(6, ((k)localObject3).bVk);
          locale.kzU.bindLong(7, ((k)localObject3).kxj);
          locale.kzU.bindLong(8, ((k)localObject3).dYk);
          locale.kzU.bindString(9, ((k)localObject3).kxl);
          locale.kzU.execute();
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
    return String.format("%s : query=%s scene=%d", new Object[] { super.toString(), this.bVk, Integer.valueOf(this.scene) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.c
 * JD-Core Version:    0.7.0.1
 */