package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class e
  implements Comparable<e>
{
  public final long aPF;
  public final boolean aZZ;
  public final long baa;
  public final File file;
  public final String key;
  public final long position;
  
  public e(String paramString, long paramLong1, long paramLong2, long paramLong3, File paramFile)
  {
    AppMethodBeat.i(151973);
    this.key = paramString;
    this.position = paramLong1;
    this.aPF = paramLong2;
    if (paramFile != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.aZZ = bool;
      this.file = paramFile;
      this.baa = paramLong3;
      AppMethodBeat.o(151973);
      return;
    }
  }
  
  public final int d(e parame)
  {
    AppMethodBeat.i(151974);
    if (!this.key.equals(parame.key))
    {
      int i = this.key.compareTo(parame.key);
      AppMethodBeat.o(151974);
      return i;
    }
    long l = this.position - parame.position;
    if (l == 0L)
    {
      AppMethodBeat.o(151974);
      return 0;
    }
    if (l < 0L)
    {
      AppMethodBeat.o(151974);
      return -1;
    }
    AppMethodBeat.o(151974);
    return 1;
  }
  
  public final boolean qA()
  {
    return this.aPF == -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.e
 * JD-Core Version:    0.7.0.1
 */