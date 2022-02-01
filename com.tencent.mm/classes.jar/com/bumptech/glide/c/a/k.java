package com.bumptech.glide.c.a;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class k
  implements e<InputStream>
{
  private final m aFx;
  
  k(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76895);
    this.aFx = new m(paramInputStream, paramb);
    this.aFx.mark(5242880);
    AppMethodBeat.o(76895);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(76896);
    this.aFx.release();
    AppMethodBeat.o(76896);
  }
  
  public static final class a
    implements e.a<InputStream>
  {
    private final b aFy;
    
    public a(b paramb)
    {
      this.aFy = paramb;
    }
    
    public final Class<InputStream> om()
    {
      return InputStream.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.k
 * JD-Core Version:    0.7.0.1
 */