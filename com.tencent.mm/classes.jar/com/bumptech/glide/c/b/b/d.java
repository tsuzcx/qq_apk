package com.bumptech.glide.c.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d
  implements a.a
{
  private final long aGu = 262144000L;
  private final a aGv;
  
  public d(a parama)
  {
    this.aGv = parama;
  }
  
  public final a oy()
  {
    AppMethodBeat.i(77149);
    Object localObject = this.aGv.oA();
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
    localObject = new e((File)localObject, this.aGu);
    AppMethodBeat.o(77149);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract File oA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.d
 * JD-Core Version:    0.7.0.1
 */