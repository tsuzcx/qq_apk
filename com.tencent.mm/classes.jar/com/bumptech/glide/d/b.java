package com.bumptech.glide.d;

import com.bumptech.glide.load.ImageHeaderParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private final List<ImageHeaderParser> aFx;
  
  public b()
  {
    AppMethodBeat.i(77601);
    this.aFx = new ArrayList();
    AppMethodBeat.o(77601);
  }
  
  public final void b(ImageHeaderParser paramImageHeaderParser)
  {
    try
    {
      AppMethodBeat.i(77602);
      this.aFx.add(paramImageHeaderParser);
      AppMethodBeat.o(77602);
      return;
    }
    finally
    {
      paramImageHeaderParser = finally;
      throw paramImageHeaderParser;
    }
  }
  
  public final List<ImageHeaderParser> pV()
  {
    try
    {
      List localList = this.aFx;
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
 * Qualified Name:     com.bumptech.glide.d.b
 * JD-Core Version:    0.7.0.1
 */