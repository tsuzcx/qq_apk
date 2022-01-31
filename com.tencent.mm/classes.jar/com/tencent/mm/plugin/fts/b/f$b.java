package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.File;

final class f$b
  extends a
{
  private f$b(f paramf) {}
  
  private static long aVO()
  {
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
    localObject1 = ((n)g.t(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        long l = ((Cursor)localObject1).getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  private static long aVP()
  {
    Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
    localObject1 = ((n)g.t(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        long l = ((Cursor)localObject1).getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  private static long aVQ()
  {
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
    localObject1 = ((n)g.t(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        long l = ((Cursor)localObject1).getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  private static long aVR()
  {
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
    localObject1 = ((n)g.t(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
    try
    {
      if (((Cursor)localObject1).moveToNext())
      {
        long l = ((Cursor)localObject1).getLong(0);
        return l;
      }
      return 0L;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  public final boolean execute()
  {
    Object localObject1 = new StringBuffer();
    long l = d.aVq().length();
    com.tencent.mm.plugin.fts.a.e.kvw.kvy = (l / 1048576L);
    ((StringBuffer)localObject1).append("[DBSize]=" + bk.ht(l));
    ((StringBuffer)localObject1).append("\n");
    com.tencent.mm.plugin.fts.a.e.kvw.kvz = aVQ();
    com.tencent.mm.plugin.fts.a.e.kvw.kvA = aVR();
    com.tencent.mm.plugin.fts.a.e.kvw.kvC = aVO();
    com.tencent.mm.plugin.fts.a.e.kvw.kvB = aVP();
    ((n)g.t(n.class)).getFTSIndexDB().A(-301L, com.tencent.mm.plugin.fts.a.e.kvw.kvz);
    ((n)g.t(n.class)).getFTSIndexDB().A(-302L, com.tencent.mm.plugin.fts.a.e.kvw.kvA);
    ((n)g.t(n.class)).getFTSIndexDB().A(-303L, com.tencent.mm.plugin.fts.a.e.kvw.kvC);
    ((n)g.t(n.class)).getFTSIndexDB().A(-304L, com.tencent.mm.plugin.fts.a.e.kvw.kvB);
    ((StringBuffer)localObject1).append("[WXContact]=" + com.tencent.mm.plugin.fts.a.e.kvw.kvz);
    ((StringBuffer)localObject1).append("\n");
    ((StringBuffer)localObject1).append("[WXChatroom]=" + com.tencent.mm.plugin.fts.a.e.kvw.kvA);
    ((StringBuffer)localObject1).append("\n");
    ((StringBuffer)localObject1).append("[Favorite]=" + com.tencent.mm.plugin.fts.a.e.kvw.kvC);
    ((StringBuffer)localObject1).append("\n");
    ((StringBuffer)localObject1).append("[Message]=" + com.tencent.mm.plugin.fts.a.e.kvw.kvB);
    Object localObject2 = ((StringBuffer)localObject1).toString();
    y.i("MicroMsg.FTS.FTSSearchTestLogic", (String)localObject2);
    localObject1 = new b(c.kvi, "FTS5IndexMicroMsgInfo.txt");
    if (((b)localObject1).exists()) {
      ((b)localObject1).delete();
    }
    if (!((b)localObject1).cLq().exists()) {
      ((b)localObject1).cLq().mkdirs();
    }
    String str = j.n(((b)localObject1).cLr());
    localObject2 = ((String)localObject2).getBytes();
    y.i("MicroMsg.FTS.FTSSearchTestLogic", "write fts info %d %s", new Object[] { Integer.valueOf(com.tencent.mm.vfs.e.b(str, (byte[])localObject2, localObject2.length)), j.n(((b)localObject1).cLr()) });
    return true;
  }
  
  public final String getName()
  {
    return "FTS5DBInfoTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f.b
 * JD-Core Version:    0.7.0.1
 */