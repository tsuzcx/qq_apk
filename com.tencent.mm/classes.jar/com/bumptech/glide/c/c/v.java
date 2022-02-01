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
  private static final v<?> aIa;
  
  static
  {
    AppMethodBeat.i(77313);
    aIa = new v();
    AppMethodBeat.o(77313);
  }
  
  public static <T> v<T> oO()
  {
    return aIa;
  }
  
  public final boolean U(Model paramModel)
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
    private static final a<?> aIb;
    
    static
    {
      AppMethodBeat.i(77309);
      aIb = new a();
      AppMethodBeat.o(77309);
    }
    
    public static <T> a<T> oP()
    {
      return aIb;
    }
    
    public final n<Model, Model> a(r paramr)
    {
      AppMethodBeat.i(77308);
      paramr = v.oO();
      AppMethodBeat.o(77308);
      return paramr;
    }
  }
  
  static final class b<Model>
    implements d<Model>
  {
    private final Model aIc;
    
    b(Model paramModel)
    {
      this.aIc = paramModel;
    }
    
    public final void a(g paramg, d.a<? super Model> parama)
    {
      AppMethodBeat.i(77310);
      parama.P(this.aIc);
      AppMethodBeat.o(77310);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Model> nK()
    {
      AppMethodBeat.i(77311);
      Class localClass = this.aIc.getClass();
      AppMethodBeat.o(77311);
      return localClass;
    }
    
    public final a nL()
    {
      return a.aBX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.v
 * JD-Core Version:    0.7.0.1
 */