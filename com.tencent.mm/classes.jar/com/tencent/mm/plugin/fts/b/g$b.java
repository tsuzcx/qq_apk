package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.aq;

final class g$b
  extends a
{
  private j trv;
  
  public g$b(g paramg, j paramj)
  {
    this.trv = paramj;
  }
  
  private static long cTg()
  {
    AppMethodBeat.i(52770);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
    localObject1 = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
      AppMethodBeat.o(52770);
    }
  }
  
  private static long cTh()
  {
    AppMethodBeat.i(52771);
    Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
    localObject1 = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
      AppMethodBeat.o(52771);
    }
  }
  
  private static long cTi()
  {
    AppMethodBeat.i(52772);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
    localObject1 = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
      AppMethodBeat.o(52772);
    }
  }
  
  private static long cTj()
  {
    AppMethodBeat.i(52773);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
    localObject1 = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
      AppMethodBeat.o(52773);
    }
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52769);
    com.tencent.mm.plugin.fts.a.e.ttv.tty = (d.cSD().length() / 1048576L);
    com.tencent.mm.plugin.fts.a.e.ttv.ttz = cTi();
    com.tencent.mm.plugin.fts.a.e.ttv.ttA = cTj();
    com.tencent.mm.plugin.fts.a.e.ttv.ttC = cTg();
    com.tencent.mm.plugin.fts.a.e.ttv.ttB = cTh();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().S(-301L, com.tencent.mm.plugin.fts.a.e.ttv.ttz);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().S(-302L, com.tencent.mm.plugin.fts.a.e.ttv.ttA);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().S(-303L, com.tencent.mm.plugin.fts.a.e.ttv.ttC);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSIndexDB().S(-304L, com.tencent.mm.plugin.fts.a.e.ttv.ttB);
    final k localk = new k(this.trv);
    if (this.trv.tvj != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52768);
          g.b.a(g.b.this).tvj.b(localk);
          AppMethodBeat.o(52768);
        }
      });
    }
    AppMethodBeat.o(52769);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5DBInfoTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.b
 * JD-Core Version:    0.7.0.1
 */