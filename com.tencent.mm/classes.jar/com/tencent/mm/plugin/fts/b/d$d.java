package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.ArrayList;
import java.util.List;

public final class d$d
  extends com.tencent.mm.plugin.fts.a.a.h
{
  public d$d(d paramd, i parami)
  {
    super(parami);
  }
  
  protected final void a(j paramj)
  {
    super.a(paramj);
    paramj.kxh = new ArrayList();
    Object localObject = this.kzu.kzs;
    String str = this.kwT.bVk;
    int i = this.kwT.kxc;
    if (str.trim().length() > 0)
    {
      str = com.tencent.mm.plugin.fts.a.d.v(new String[] { str });
      str = String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT " + i, new Object[] { "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5IndexSOSHistory", str });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).kuE.rawQuery(str, null);
    }
    while (((Cursor)localObject).moveToNext())
    {
      str = ((Cursor)localObject).getString(0);
      m localm = new m();
      localm.content = str;
      paramj.kxh.add(localm);
      continue;
      str = String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT " + i, new Object[] { "FTS5MetaSOSHistory" });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).kuE.rawQuery(str, null);
    }
    ((Cursor)localObject).close();
  }
  
  public final String getName()
  {
    return "SearchSOSHistoryTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d.d
 * JD-Core Version:    0.7.0.1
 */