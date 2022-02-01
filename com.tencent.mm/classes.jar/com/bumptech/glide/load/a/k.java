package com.bumptech.glide.load.a;

import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class k
  implements e<InputStream>
{
  private final n aFn;
  
  k(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(76895);
    this.aFn = new n(paramInputStream, paramb);
    this.aFn.mark(5242880);
    AppMethodBeat.o(76895);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(76896);
    this.aFn.release();
    AppMethodBeat.o(76896);
  }
  
  public static final class a
    implements e.a<InputStream>
  {
    private final b aFo;
    
    public a(b paramb)
    {
      this.aFo = paramb;
    }
    
    public final Class<InputStream> os()
    {
      return InputStream.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.a.k
 * JD-Core Version:    0.7.0.1
 */