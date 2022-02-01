package com.bumptech.glide.c.c.a;

import com.bumptech.glide.c.c.g;
import com.bumptech.glide.c.c.m;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.r;
import com.bumptech.glide.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a
  implements n<g, InputStream>
{
  public static final i<Integer> aKN;
  private final m<g, g> aKO;
  
  static
  {
    AppMethodBeat.i(77330);
    aKN = i.b("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    AppMethodBeat.o(77330);
  }
  
  public a()
  {
    this(null);
  }
  
  public a(m<g, g> paramm)
  {
    this.aKO = paramm;
  }
  
  public static final class a
    implements o<g, InputStream>
  {
    private final m<g, g> aKO;
    
    public a()
    {
      AppMethodBeat.i(77327);
      this.aKO = new m(500L);
      AppMethodBeat.o(77327);
    }
    
    public final n<g, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77328);
      paramr = new a(this.aKO);
      AppMethodBeat.o(77328);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */