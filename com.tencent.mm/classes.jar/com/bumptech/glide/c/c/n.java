package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public abstract interface n<Model, Data>
{
  public abstract boolean U(Model paramModel);
  
  public abstract a<Data> b(Model paramModel, int paramInt1, int paramInt2, j paramj);
  
  public static final class a<Data>
  {
    public final h aDo;
    public final List<h> aHH;
    public final d<Data> aHI;
    
    public a(h paramh, d<Data> paramd)
    {
      this(paramh, Collections.emptyList(), paramd);
      AppMethodBeat.i(77267);
      AppMethodBeat.o(77267);
    }
    
    private a(h paramh, List<h> paramList, d<Data> paramd)
    {
      AppMethodBeat.i(77268);
      this.aDo = ((h)i.checkNotNull(paramh, "Argument must not be null"));
      this.aHH = ((List)i.checkNotNull(paramList, "Argument must not be null"));
      this.aHI = ((d)i.checkNotNull(paramd, "Argument must not be null"));
      AppMethodBeat.o(77268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.n
 * JD-Core Version:    0.7.0.1
 */