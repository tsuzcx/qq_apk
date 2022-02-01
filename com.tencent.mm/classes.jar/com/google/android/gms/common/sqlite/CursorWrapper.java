package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper
  extends android.database.CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor zzxu;
  
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    AppMethodBeat.i(4957);
    int i = 0;
    while ((i < 10) && ((paramCursor instanceof android.database.CursorWrapper)))
    {
      paramCursor = ((android.database.CursorWrapper)paramCursor).getWrappedCursor();
      i += 1;
    }
    if (!(paramCursor instanceof AbstractWindowedCursor))
    {
      paramCursor = String.valueOf(paramCursor.getClass().getName());
      if (paramCursor.length() != 0) {}
      for (paramCursor = "Unknown type: ".concat(paramCursor);; paramCursor = new String("Unknown type: "))
      {
        paramCursor = new IllegalArgumentException(paramCursor);
        AppMethodBeat.o(4957);
        throw paramCursor;
      }
    }
    this.zzxu = ((AbstractWindowedCursor)paramCursor);
    AppMethodBeat.o(4957);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(4960);
    this.zzxu.fillWindow(paramInt, paramCursorWindow);
    AppMethodBeat.o(4960);
  }
  
  public CursorWindow getWindow()
  {
    AppMethodBeat.i(4958);
    CursorWindow localCursorWindow = this.zzxu.getWindow();
    AppMethodBeat.o(4958);
    return localCursorWindow;
  }
  
  public AbstractWindowedCursor getWrappedCursor()
  {
    return this.zzxu;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4961);
    boolean bool = this.zzxu.onMove(paramInt1, paramInt2);
    AppMethodBeat.o(4961);
    return bool;
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(4959);
    this.zzxu.setWindow(paramCursorWindow);
    AppMethodBeat.o(4959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.sqlite.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */