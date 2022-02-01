package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a
  implements n<g, InputStream>
{
  public static final h<Integer> aKF;
  private final m<g, g> aKG;
  
  static
  {
    AppMethodBeat.i(77330);
    aKF = h.c("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    AppMethodBeat.o(77330);
  }
  
  public a()
  {
    this(null);
  }
  
  public a(m<g, g> paramm)
  {
    this.aKG = paramm;
  }
  
  public static final class a
    implements o<g, InputStream>
  {
    private final m<g, g> aKG;
    
    public a()
    {
      AppMethodBeat.i(77327);
      this.aKG = new m(500L);
      AppMethodBeat.o(77327);
    }
    
    public final n<g, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77328);
      paramr = new a(this.aKG);
      AppMethodBeat.o(77328);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.a.a
 * JD-Core Version:    0.7.0.1
 */