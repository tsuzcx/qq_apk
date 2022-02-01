package com.bumptech.glide.c.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class x<Data>
  implements n<Uri, Data>
{
  private static final Set<String> aIT;
  private final n<g, Data> aIV;
  
  static
  {
    AppMethodBeat.i(77326);
    aIT = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
    AppMethodBeat.o(77326);
  }
  
  public x(n<g, Data> paramn)
  {
    this.aIV = paramn;
  }
  
  public static final class a
    implements o<Uri, InputStream>
  {
    public final n<Uri, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77323);
      paramr = new x(paramr.b(g.class, InputStream.class));
      AppMethodBeat.o(77323);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.x
 * JD-Core Version:    0.7.0.1
 */