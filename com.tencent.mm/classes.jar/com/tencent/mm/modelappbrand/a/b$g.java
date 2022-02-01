package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public abstract interface b$g
{
  public static final g gSs = new g()
  {
    public final Bitmap decodeStream(InputStream paramAnonymousInputStream)
    {
      AppMethodBeat.i(176002);
      paramAnonymousInputStream = BitmapFactory.decodeStream(paramAnonymousInputStream);
      AppMethodBeat.o(176002);
      return paramAnonymousInputStream;
    }
  };
  
  public abstract Bitmap decodeStream(InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.g
 * JD-Core Version:    0.7.0.1
 */