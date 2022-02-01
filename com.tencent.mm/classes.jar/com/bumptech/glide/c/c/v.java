package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.bumptech.glide.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v<Model>
  implements n<Model, Model>
{
  private static final v<?> aKH;
  
  static
  {
    AppMethodBeat.i(77313);
    aKH = new v();
    AppMethodBeat.o(77313);
  }
  
  public static <T> v<T> pq()
  {
    return aKH;
  }
  
  public final boolean X(Model paramModel)
  {
    return true;
  }
  
  public final n.a<Model> b(Model paramModel, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77312);
    paramModel = new n.a(new b(paramModel), new b(paramModel));
    AppMethodBeat.o(77312);
    return paramModel;
  }
  
  public static final class a<Model>
    implements o<Model, Model>
  {
    private static final a<?> aKI;
    
    static
    {
      AppMethodBeat.i(77309);
      aKI = new a();
      AppMethodBeat.o(77309);
    }
    
    public static <T> a<T> pr()
    {
      return aKI;
    }
    
    public final n<Model, Model> a(r paramr)
    {
      AppMethodBeat.i(77308);
      paramr = v.pq();
      AppMethodBeat.o(77308);
      return paramr;
    }
  }
  
  static final class b<Model>
    implements d<Model>
  {
    private final Model aKJ;
    
    b(Model paramModel)
    {
      this.aKJ = paramModel;
    }
    
    public final void a(g paramg, d.a<? super Model> parama)
    {
      AppMethodBeat.i(77310);
      parama.S(this.aKJ);
      AppMethodBeat.o(77310);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Model> om()
    {
      AppMethodBeat.i(77311);
      Class localClass = this.aKJ.getClass();
      AppMethodBeat.o(77311);
      return localClass;
    }
    
    public final a on()
    {
      return a.aEG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.v
 * JD-Core Version:    0.7.0.1
 */