package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.h;
import java.util.LinkedList;

final class e$a
  extends com.tencent.mm.plugin.fts.a.a.a
{
  int mVn;
  int mVo;
  
  private e$a(e parame) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(136778);
    String str = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[] { Integer.valueOf(this.mVo), Integer.valueOf(this.mVn) });
    AppMethodBeat.o(136778);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136777);
    this.mVo = this.mVp.mVl.bCw();
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.fts.c.e locale = this.mVp.mVl;
    Object localObject = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[] { locale.bBR() });
    localObject = locale.mQr.rawQuery((String)localObject, new String[] { String.valueOf(l - 5184000000L) });
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext()) {
      localLinkedList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
    }
    ((Cursor)localObject).close();
    locale.bS(localLinkedList);
    this.mVn = localLinkedList.size();
    AppMethodBeat.o(136777);
    return true;
  }
  
  public final String getName()
  {
    return "BuildTopHitsIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.e.a
 * JD-Core Version:    0.7.0.1
 */