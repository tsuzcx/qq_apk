package com.bumptech.glide.c.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d
  implements a.a
{
  private final long aJb = 262144000L;
  private final a aJc;
  
  public d(a parama)
  {
    this.aJc = parama;
  }
  
  public final a pa()
  {
    AppMethodBeat.i(77149);
    Object localObject = this.aJc.pc();
    if (localObject == null)
    {
      AppMethodBeat.o(77149);
      return null;
    }
    if ((!((File)localObject).mkdirs()) && ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())))
    {
      AppMethodBeat.o(77149);
      return null;
    }
    localObject = new e((File)localObject, this.aJb);
    AppMethodBeat.o(77149);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract File pc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.d
 * JD-Core Version:    0.7.0.1
 */