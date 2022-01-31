package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  extends CursorWrapper
{
  private static HashSet<Cursor> ktt = new HashSet();
  
  public a(Cursor paramCursor)
  {
    super(paramCursor);
    ktt.add(paramCursor);
    y.v("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[] { Integer.valueOf(paramCursor.hashCode()) });
  }
  
  public static final void aVi()
  {
    Iterator localIterator = ktt.iterator();
    for (;;)
    {
      Cursor localCursor;
      if (localIterator.hasNext())
      {
        localCursor = (Cursor)localIterator.next();
        if (localCursor.isClosed()) {
          continue;
        }
      }
      try
      {
        localCursor.close();
        label41:
        y.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
        continue;
        ktt.clear();
        return;
      }
      catch (Exception localException)
      {
        break label41;
      }
    }
  }
  
  public final void close()
  {
    super.close();
    Cursor localCursor = getWrappedCursor();
    ktt.remove(localCursor);
    y.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a
 * JD-Core Version:    0.7.0.1
 */