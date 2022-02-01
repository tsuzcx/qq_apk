package com.tencent.mm.plugin.fts.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.e.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.u;

final class i$b
  extends c
{
  private com.tencent.mm.plugin.fts.a.a.l HpM;
  
  public i$b(i parami, com.tencent.mm.plugin.fts.a.a.l paraml)
  {
    this.HpM = paraml;
  }
  
  private static long fxV()
  {
    AppMethodBeat.i(52770);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE subtype = %d", new Object[] { "FTS5MetaFavorite", Integer.valueOf(9) });
    localObject1 = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long fxW()
  {
    AppMethodBeat.i(52771);
    Object localObject1 = String.format("SELECT count(docid) FROM %s", new Object[] { "FTS5MetaMessage" });
    localObject1 = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long fxX()
  {
    AppMethodBeat.i(52772);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131072), Integer.valueOf(1) });
    localObject1 = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  private static long fxY()
  {
    AppMethodBeat.i(52773);
    Object localObject1 = String.format("SELECT count(docid) FROM %s WHERE type = %d AND subtype = %d", new Object[] { "FTS5MetaContact", Integer.valueOf(131075), Integer.valueOf(38) });
    localObject1 = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().rawQuery((String)localObject1, null);
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
  
  public final boolean aXz()
  {
    AppMethodBeat.i(52769);
    e.HrL.HrP = (d.fxl().length() / 1048576L);
    e.HrL.HrQ = fxX();
    e.HrL.HrR = fxY();
    e.HrL.HrT = fxV();
    e.HrL.HrS = fxW();
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aG(-301L, e.HrL.HrQ);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aG(-302L, e.HrL.HrR);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aG(-303L, e.HrL.HrT);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexDB().aG(-304L, e.HrL.HrS);
    final m localm = new m(this.HpM);
    if (this.HpM.HtC != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52768);
          i.b.a(i.b.this).HtC.b(localm);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.i.b
 * JD-Core Version:    0.7.0.1
 */