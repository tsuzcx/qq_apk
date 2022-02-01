package com.tencent.mapsdk.core.utils.cache;

import com.tencent.mapsdk.internal.ka;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class DiskCache$1
  implements DiskCache.a
{
  public final File a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221158);
    paramString1 = new File(paramString2, paramString1);
    ka.a(paramString1, paramArrayOfByte);
    AppMethodBeat.o(221158);
    return paramString1;
  }
  
  public final boolean a(File paramFile)
  {
    AppMethodBeat.i(221172);
    boolean bool = ka.b(paramFile);
    AppMethodBeat.o(221172);
    return bool;
  }
  
  public final byte[] a(String paramString, File paramFile)
  {
    AppMethodBeat.i(221166);
    paramString = ka.c(paramFile);
    AppMethodBeat.o(221166);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.utils.cache.DiskCache.1
 * JD-Core Version:    0.7.0.1
 */