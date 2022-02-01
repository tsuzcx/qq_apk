package com.bumptech.glide.load.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class d
  implements a.a
{
  private final long aIU = 262144000L;
  private final a aIV;
  
  public d(a parama)
  {
    this.aIV = parama;
  }
  
  public final a pf()
  {
    AppMethodBeat.i(77149);
    Object localObject = this.aIV.ph();
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
    localObject = new e((File)localObject, this.aIU);
    AppMethodBeat.o(77149);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract File ph();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.d
 * JD-Core Version:    0.7.0.1
 */