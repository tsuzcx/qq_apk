package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  extends CursorWrapper
{
  private static HashSet<Cursor> suT;
  
  static
  {
    AppMethodBeat.i(52498);
    suT = new HashSet();
    AppMethodBeat.o(52498);
  }
  
  public a(Cursor paramCursor)
  {
    super(paramCursor);
    AppMethodBeat.i(52495);
    suT.add(paramCursor);
    ac.v("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[] { Integer.valueOf(paramCursor.hashCode()) });
    AppMethodBeat.o(52495);
  }
  
  public static final void cKg()
  {
    AppMethodBeat.i(52497);
    Iterator localIterator = suT.iterator();
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
        ac.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
        continue;
        suT.clear();
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
    suT.remove(localCursor);
    ac.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
    AppMethodBeat.o(52496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a
 * JD-Core Version:    0.7.0.1
 */