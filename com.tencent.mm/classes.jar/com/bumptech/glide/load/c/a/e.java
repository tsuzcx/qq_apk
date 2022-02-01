package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.URL;

public final class e
  implements n<URL, InputStream>
{
  private final n<g, InputStream> aKH;
  
  public e(n<g, InputStream> paramn)
  {
    this.aKH = paramn;
  }
  
  public static final class a
    implements o<URL, InputStream>
  {
    public final n<URL, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77343);
      paramr = new e(paramr.b(g.class, InputStream.class));
      AppMethodBeat.o(77343);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.a.e
 * JD-Core Version:    0.7.0.1
 */