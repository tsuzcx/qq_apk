package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.q;

final class g$b
  extends a
{
  private j BFk;
  
  public g$b(g paramg, j paramj)
  {
    this.BFk = paramj;
  }
  
  private static long ero()
  {
    AppMethodBeat.i(52770);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
    localObject1 = ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long erp()
  {
    AppMethodBeat.i(52771);
    Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
    localObject1 = ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long erq()
  {
    AppMethodBeat.i(52772);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
    localObject1 = ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long err()
  {
    AppMethodBeat.i(52773);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
    localObject1 = ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  public final boolean aEv()
  {
    AppMethodBeat.i(52769);
    e.BHh.BHk = (d.eqG().length() / 1048576L);
    e.BHh.BHl = erq();
    e.BHh.BHm = err();
    e.BHh.BHo = ero();
    e.BHh.BHn = erp();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().ad(-301L, e.BHh.BHl);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().ad(-302L, e.BHh.BHm);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().ad(-303L, e.BHh.BHo);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).getFTSIndexDB().ad(-304L, e.BHh.BHn);
    final k localk = new k(this.BFk);
    if (this.BFk.BIU != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52768);
          g.b.a(g.b.this).BIU.b(localk);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.b
 * JD-Core Version:    0.7.0.1
 */