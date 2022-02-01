package com.bumptech.glide.c.b.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f
  extends d
{
  public f(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache");
  }
  
  private f(Context paramContext, final String paramString)
  {
    super(new d.a()
    {
      public final File oA()
      {
        AppMethodBeat.i(77154);
        File localFile = f.this.getCacheDir();
        if (localFile == null)
        {
          AppMethodBeat.o(77154);
          return null;
        }
        if (paramString != null)
        {
          localFile = new File(localFile, paramString);
          AppMethodBeat.o(77154);
          return localFile;
        }
        AppMethodBeat.o(77154);
        return localFile;
      }
    });
    AppMethodBeat.i(77155);
    AppMethodBeat.o(77155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.f
 * JD-Core Version:    0.7.0.1
 */