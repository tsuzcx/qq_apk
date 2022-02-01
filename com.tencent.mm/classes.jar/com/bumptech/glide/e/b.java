package com.bumptech.glide.e;

import com.bumptech.glide.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private final List<f> aCZ;
  
  public b()
  {
    AppMethodBeat.i(77601);
    this.aCZ = new ArrayList();
    AppMethodBeat.o(77601);
  }
  
  public final void a(f paramf)
  {
    try
    {
      AppMethodBeat.i(77602);
      this.aCZ.add(paramf);
      AppMethodBeat.o(77602);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final List<f> po()
  {
    try
    {
      List localList = this.aCZ;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.b
 * JD-Core Version:    0.7.0.1
 */