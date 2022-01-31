package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(136771);
    super.a(paramj);
    paramj.mSW = new ArrayList();
    Object localObject = this.mVk.mVi;
    String str = this.mSJ.query;
    int i = this.mSJ.mSR;
    if (str.trim().length() > 0)
    {
      str = com.tencent.mm.plugin.fts.a.d.z(new String[] { str });
      str = String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[] { "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5MetaSOSHistory", "FTS5IndexSOSHistory", "FTS5IndexSOSHistory", str });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).mQr.rawQuery(str, null);
    }
    while (((Cursor)localObject).moveToNext())
    {
      str = ((Cursor)localObject).getString(0);
      m localm = new m();
      localm.content = str;
      paramj.mSW.add(localm);
      continue;
      str = String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT ".concat(String.valueOf(i)), new Object[] { "FTS5MetaSOSHistory" });
      localObject = ((com.tencent.mm.plugin.fts.c.d)localObject).mQr.rawQuery(str, null);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(136771);
  }
  
  public final String getName()
  {
    return "SearchSOSHistoryTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.d.d
 * JD-Core Version:    0.7.0.1
 */