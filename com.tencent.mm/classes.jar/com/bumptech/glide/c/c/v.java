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
  private static final v<?> aIQ;
  
  static
  {
    AppMethodBeat.i(77313);
    aIQ = new v();
    AppMethodBeat.o(77313);
  }
  
  public static <T> v<T> oY()
  {
    return aIQ;
  }
  
  public final boolean W(Model paramModel)
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
    private static final a<?> aIR;
    
    static
    {
      AppMethodBeat.i(77309);
      aIR = new a();
      AppMethodBeat.o(77309);
    }
    
    public static <T> a<T> oZ()
    {
      return aIR;
    }
    
    public final n<Model, Model> a(r paramr)
    {
      AppMethodBeat.i(77308);
      paramr = v.oY();
      AppMethodBeat.o(77308);
      return paramr;
    }
  }
  
  static final class b<Model>
    implements d<Model>
  {
    private final Model aIS;
    
    b(Model paramModel)
    {
      this.aIS = paramModel;
    }
    
    public final void a(g paramg, d.a<? super Model> parama)
    {
      AppMethodBeat.i(77310);
      parama.R(this.aIS);
      AppMethodBeat.o(77310);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Model> nU()
    {
      AppMethodBeat.i(77311);
      Class localClass = this.aIS.getClass();
      AppMethodBeat.o(77311);
      return localClass;
    }
    
    public final a nV()
    {
      return a.aCP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.v
 * JD-Core Version:    0.7.0.1
 */