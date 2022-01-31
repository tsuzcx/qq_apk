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
    AppMethodBeat.i(89935);
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
        AppMethodBeat.o(89935);
        throw paramCursor;
      }
    }
    this.zzxu = ((AbstractWindowedCursor)paramCursor);
    AppMethodBeat.o(89935);
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(89938);
    this.zzxu.fillWindow(paramInt, paramCursorWindow);
    AppMethodBeat.o(89938);
  }
  
  public CursorWindow getWindow()
  {
    AppMethodBeat.i(89936);
    CursorWindow localCursorWindow = this.zzxu.getWindow();
    AppMethodBeat.o(89936);
    return localCursorWindow;
  }
  
  public AbstractWindowedCursor getWrappedCursor()
  {
    return this.zzxu;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89939);
    boolean bool = this.zzxu.onMove(paramInt1, paramInt2);
    AppMethodBeat.o(89939);
    return bool;
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(89937);
    this.zzxu.setWindow(paramCursorWindow);
    AppMethodBeat.o(89937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.sqlite.CursorWrapper
 * JD-Core Version:    0.7.0.1
 */