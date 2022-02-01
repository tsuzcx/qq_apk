package com.google.a.b.a;

import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Map;

public final class f
  implements t
{
  private final c bFb;
  final boolean bFi;
  
  public f(c paramc, boolean paramBoolean)
  {
    this.bFb = paramc;
    this.bFi = paramBoolean;
  }
  
  public final <T> s<T> a(com.google.a.f paramf, a<T> parama)
  {
    AppMethodBeat.i(108049);
    Object localObject = parama.bHl;
    if (!Map.class.isAssignableFrom(parama.bIC))
    {
      AppMethodBeat.o(108049);
      return null;
    }
    Type[] arrayOfType = b.b((Type)localObject, b.c((Type)localObject));
    localObject = arrayOfType[0];
    if ((localObject == Boolean.TYPE) || (localObject == Boolean.class)) {}
    for (localObject = m.bHr;; localObject = paramf.a(a.h((Type)localObject)))
    {
      s locals = paramf.a(a.h(arrayOfType[1]));
      parama = this.bFb.b(parama);
      paramf = new a(paramf, arrayOfType[0], (s)localObject, arrayOfType[1], locals, parama);
      AppMethodBeat.o(108049);
      return paramf;
    }
  }
  
  final class a<K, V>
    extends s<Map<K, V>>
  {
    private final h<? extends Map<K, V>> bGJ;
    private final s<K> bGP;
    private final s<V> bGQ;
    
    public a(Type paramType1, s<K> params, Type paramType2, s<V> params1, h<? extends Map<K, V>> paramh)
    {
      AppMethodBeat.i(108040);
      this.bGP = new l(paramType1, paramType2, params);
      this.bGQ = new l(paramType1, paramh, params1);
      Object localObject;
      this.bGJ = localObject;
      AppMethodBeat.o(108040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */