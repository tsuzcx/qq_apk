package com.tencent.d.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class f
{
  public static final long JTC;
  public static final long JTD;
  public static final int JTE;
  public static final long JTF;
  
  static
  {
    AppMethodBeat.i(138395);
    JTC = TimeUnit.SECONDS.toMillis(1L);
    JTD = TimeUnit.MILLISECONDS.toMillis(50L);
    JTE = (int)(JTC / JTD);
    JTF = JTC * 3L;
    AppMethodBeat.o(138395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.f
 * JD-Core Version:    0.7.0.1
 */