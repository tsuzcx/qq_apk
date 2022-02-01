package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e
  extends Exception
{
  public final int bcb;
  public final int type;
  
  private e(int paramInt1, Throwable paramThrowable, int paramInt2)
  {
    super(null, paramThrowable);
    this.type = paramInt1;
    this.bcb = paramInt2;
  }
  
  public static e a(IOException paramIOException)
  {
    AppMethodBeat.i(91884);
    paramIOException = new e(0, paramIOException, -1);
    AppMethodBeat.o(91884);
    return paramIOException;
  }
  
  static e a(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(91885);
    paramRuntimeException = new e(2, paramRuntimeException, -1);
    AppMethodBeat.o(91885);
    return paramRuntimeException;
  }
  
  public static e b(Exception paramException, int paramInt)
  {
    AppMethodBeat.i(91883);
    paramException = new e(1, paramException, paramInt);
    AppMethodBeat.o(91883);
    return paramException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e
 * JD-Core Version:    0.7.0.1
 */