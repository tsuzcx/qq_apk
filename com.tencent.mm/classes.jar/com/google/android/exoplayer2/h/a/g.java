package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class g
  implements Comparable<g>
{
  public final boolean bFZ;
  public final long bGa;
  public final File file;
  public final String key;
  public final long length;
  public final long position;
  
  public g(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    AppMethodBeat.i(92993);
    this.key = paramString;
    this.position = paramLong1;
    this.length = paramLong2;
    if (paramFile != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bFZ = bool;
      this.file = paramFile;
      this.bGa = paramLong3;
      AppMethodBeat.o(92993);
      return;
    }
  }
  
  public final int d(g paramg)
  {
    AppMethodBeat.i(92994);
    if (!this.key.equals(paramg.key))
    {
      int i = this.key.compareTo(paramg.key);
      AppMethodBeat.o(92994);
      return i;
    }
    long l = this.position - paramg.position;
    if (l == 0L)
    {
      AppMethodBeat.o(92994);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(92994);
      return -1;
    }
    AppMethodBeat.o(92994);
    return 1;
  }
  
  public final boolean wK()
  {
    return this.length == -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.g
 * JD-Core Version:    0.7.0.1
 */