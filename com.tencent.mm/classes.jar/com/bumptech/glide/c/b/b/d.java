package com.bumptech.glide.c.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d
  implements a.a
{
  private final long aHk = 262144000L;
  private final a aHl;
  
  public d(a parama)
  {
    this.aHl = parama;
  }
  
  public final a oI()
  {
    AppMethodBeat.i(77149);
    Object localObject = this.aHl.oK();
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
    localObject = new e((File)localObject, this.aHk);
    AppMethodBeat.o(77149);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract File oK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.d
 * JD-Core Version:    0.7.0.1
 */