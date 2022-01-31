package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class a$v
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long mUG;
  private int mUH = 0;
  
  public a$v(a parama, long paramLong)
  {
    this.mUG = paramLong;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136696);
    String str = String.format("{mLabelId: %d mContactCount: %d}", new Object[] { Long.valueOf(this.mUG), Integer.valueOf(this.mUH) });
    AppMethodBeat.o(136696);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136695);
    Object localObject1 = new ArrayList(32);
    Object localObject2 = a.a(this.mUg);
    long l = this.mUG;
    localObject2 = ((com.tencent.mm.plugin.fts.a.a)localObject2).mQr.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[] { Long.toString(l) });
    while (((Cursor)localObject2).moveToNext()) {
      ((ArrayList)localObject1).add(((Cursor)localObject2).getString(0));
    }
    ((Cursor)localObject2).close();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!a.b(this.mUg).containsKey(localObject2))
      {
        List localList = a.a(this.mUg).c(c.mQJ, (String)localObject2);
        a.b(this.mUg).put(localObject2, localList);
      }
    }
    AppMethodBeat.o(136695);
    return true;
  }
  
  public final String getName()
  {
    return "UpdateLabelTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.v
 * JD-Core Version:    0.7.0.1
 */