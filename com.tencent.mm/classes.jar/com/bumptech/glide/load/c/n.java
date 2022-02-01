package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public abstract interface n<Model, Data>
{
  public abstract boolean X(Model paramModel);
  
  public abstract a<Data> b(Model paramModel, int paramInt1, int paramInt2, i parami);
  
  public static final class a<Data>
  {
    public final g aFO;
    public final List<g> aKg;
    public final d<Data> aKh;
    
    public a(g paramg, d<Data> paramd)
    {
      this(paramg, Collections.emptyList(), paramd);
      AppMethodBeat.i(77267);
      AppMethodBeat.o(77267);
    }
    
    private a(g paramg, List<g> paramList, d<Data> paramd)
    {
      AppMethodBeat.i(77268);
      this.aFO = ((g)j.checkNotNull(paramg, "Argument must not be null"));
      this.aKg = ((List)j.checkNotNull(paramList, "Argument must not be null"));
      this.aKh = ((d)j.checkNotNull(paramd, "Argument must not be null"));
      AppMethodBeat.o(77268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.n
 * JD-Core Version:    0.7.0.1
 */