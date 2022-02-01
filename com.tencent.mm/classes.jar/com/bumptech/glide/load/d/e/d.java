package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class d
  implements k<c>
{
  private static boolean a(v<c> paramv, File paramFile)
  {
    AppMethodBeat.i(77501);
    paramv = (c)paramv.get();
    try
    {
      a.b(paramv.getBuffer(), paramFile);
      bool = true;
    }
    catch (IOException paramv)
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
  
  public final com.bumptech.glide.load.c b(i parami)
  {
    return com.bumptech.glide.load.c.aEQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.d
 * JD-Core Version:    0.7.0.1
 */