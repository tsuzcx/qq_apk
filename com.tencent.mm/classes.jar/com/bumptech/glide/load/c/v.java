package com.bumptech.glide.load.c;

import com.bumptech.glide.f.b;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v<Model>
  implements n<Model, Model>
{
  private static final v<?> aKz;
  
  static
  {
    AppMethodBeat.i(77313);
    aKz = new v();
    AppMethodBeat.o(77313);
  }
  
  public static <T> v<T> pv()
  {
    return aKz;
  }
  
  public final boolean X(Model paramModel)
  {
    return true;
  }
  
  public final n.a<Model> b(Model paramModel, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77312);
    paramModel = new n.a(new b(paramModel), new b(paramModel));
    AppMethodBeat.o(77312);
    return paramModel;
  }
  
  public static final class a<Model>
    implements o<Model, Model>
  {
    private static final a<?> aKA;
    
    static
    {
      AppMethodBeat.i(77309);
      aKA = new a();
      AppMethodBeat.o(77309);
    }
    
    public static <T> a<T> pw()
    {
      return aKA;
    }
    
    public final n<Model, Model> a(r paramr)
    {
      AppMethodBeat.i(77308);
      paramr = v.pv();
      AppMethodBeat.o(77308);
      return paramr;
    }
  }
  
  static final class b<Model>
    implements d<Model>
  {
    private final Model aKB;
    
    b(Model paramModel)
    {
      this.aKB = paramModel;
    }
    
    public final void a(g paramg, d.a<? super Model> parama)
    {
      AppMethodBeat.i(77310);
      parama.S(this.aKB);
      AppMethodBeat.o(77310);
    }
    
    public final void cancel() {}
    
    public final void cleanup() {}
    
    public final Class<Model> os()
    {
      AppMethodBeat.i(77311);
      Class localClass = this.aKB.getClass();
      AppMethodBeat.o(77311);
      return localClass;
    }
    
    public final a ot()
    {
      return a.aEG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.v
 * JD-Core Version:    0.7.0.1
 */