package com.bumptech.glide.c.c.a;

import android.net.Uri;
import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b
  implements n<Uri, InputStream>
{
  private static final Set<String> aKK;
  private final n<g, InputStream> aKM;
  
  static
  {
    AppMethodBeat.i(77334);
    aKK = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
    AppMethodBeat.o(77334);
  }
  
  public b(n<g, InputStream> paramn)
  {
    this.aKM = paramn;
  }
  
  public static final class a
    implements o<Uri, InputStream>
  {
    public final n<Uri, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77331);
      paramr = new b(paramr.b(g.class, InputStream.class));
      AppMethodBeat.o(77331);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.a.b
 * JD-Core Version:    0.7.0.1
 */