package com.google.a.b.a;

import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends s<Object>
{
  public static final t bGF;
  private final f bGS;
  
  static
  {
    AppMethodBeat.i(107990);
    bGF = new t()
    {
      public final <T> s<T> a(f paramAnonymousf, com.google.a.c.a<T> paramAnonymousa)
      {
        AppMethodBeat.i(107996);
        if (paramAnonymousa.bIC == Object.class)
        {
          paramAnonymousf = new g(paramAnonymousf);
          AppMethodBeat.o(107996);
          return paramAnonymousf;
        }
        AppMethodBeat.o(107996);
        return null;
      }
    };
    AppMethodBeat.o(107990);
  }
  
  g(f paramf)
  {
    this.bGS = paramf;
  }
  
  public final void a(com.google.a.d.a parama, Object paramObject)
  {
    AppMethodBeat.i(107989);
    if (paramObject == null)
    {
      parama.xI();
      AppMethodBeat.o(107989);
      return;
    }
    s locals = this.bGS.B(paramObject.getClass());
    if ((locals instanceof g))
    {
      parama.xG();
      parama.xH();
      AppMethodBeat.o(107989);
      return;
    }
    locals.a(parama, paramObject);
    AppMethodBeat.o(107989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */