package com.bumptech.glide.load.c.a;

import android.net.Uri;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b
  implements n<Uri, InputStream>
{
  private static final Set<String> aKC;
  private final n<g, InputStream> aKE;
  
  static
  {
    AppMethodBeat.i(77334);
    aKC = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
    AppMethodBeat.o(77334);
  }
  
  public b(n<g, InputStream> paramn)
  {
    this.aKE = paramn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.a.b
 * JD-Core Version:    0.7.0.1
 */