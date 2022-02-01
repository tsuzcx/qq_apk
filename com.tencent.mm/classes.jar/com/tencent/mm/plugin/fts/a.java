package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  extends CursorWrapper
{
  private static HashSet<Cursor> HpL;
  
  static
  {
    AppMethodBeat.i(52498);
    HpL = new HashSet();
    AppMethodBeat.o(52498);
  }
  
  public a(Cursor paramCursor)
  {
    super(paramCursor);
    AppMethodBeat.i(52495);
    HpL.add(paramCursor);
    Log.i("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[] { Integer.valueOf(paramCursor.hashCode()) });
    AppMethodBeat.o(52495);
  }
  
  public static final void fxc()
  {
    AppMethodBeat.i(52497);
    Iterator localIterator = HpL.iterator();
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
        Log.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
        continue;
        HpL.clear();
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
    HpL.remove(localCursor);
    Log.i("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[] { Integer.valueOf(localCursor.hashCode()) });
    AppMethodBeat.o(52496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a
 * JD-Core Version:    0.7.0.1
 */