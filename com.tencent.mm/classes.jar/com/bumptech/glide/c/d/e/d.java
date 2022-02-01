package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.bumptech.glide.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class d
  implements l<c>
{
  private static boolean a(u<c> paramu, File paramFile)
  {
    AppMethodBeat.i(77501);
    paramu = (c)paramu.get();
    try
    {
      a.b(paramu.getBuffer(), paramFile);
      bool = true;
    }
    catch (IOException paramu)
    {
      for (;;)
      {
        Log.isLoggable("GifEncoder", 5);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(77501);
    return bool;
  }
  
  public final com.bumptech.glide.c.c b(j paramj)
  {
    return com.bumptech.glide.c.c.aCi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.d
 * JD-Core Version:    0.7.0.1
 */