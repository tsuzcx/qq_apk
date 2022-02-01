package com.tencent.mapsdk.core.utils.cache;

import com.tencent.mapsdk.internal.jh;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class DiskCache$b
  extends jh
{
  File a;
  private int b;
  
  DiskCache$b(File paramFile, int paramInt)
  {
    this.a = paramFile;
    this.b = paramInt;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(byte[] paramArrayOfByte) {}
  
  public final byte[] b()
  {
    return new byte[this.b];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221198);
    String str = this.a.getName() + "," + this.b;
    AppMethodBeat.o(221198);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.core.utils.cache.DiskCache.b
 * JD-Core Version:    0.7.0.1
 */