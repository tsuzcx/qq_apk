package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  extends CursorWrapper
{
  private static HashSet<Cursor> tCl;
  
  static
  {
    AppMethodBeat.i(52498);
    tCl = new HashSet();
    AppMethodBeat.o(52498);
  }
  
  public a(Cursor paramCursor)
  {
    super(paramCursor);
    AppMethodBeat.i(52495);
    tCl.add(paramCursor);
    ae.v("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[] { Integer.valueOf(paramCursor.hashCode()) });
    AppMethodBeat.o(52495);
  }
  
  public static final void cVa()
  {
    AppMethodBeat.i(52497);
    Iterator localIterator = tCl.iterator();
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
        label46:
        ae.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
        continue;
        tCl.clear();
        AppMethodBeat.o(52497);
        return;
      }
      catch (Exception localException)
      {
        break label46;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(52496);
    super.close();
    Cursor localCursor = getWrappedCursor();
    tCl.remove(localCursor);
    ae.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
    AppMethodBeat.o(52496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a
 * JD-Core Version:    0.7.0.1
 */