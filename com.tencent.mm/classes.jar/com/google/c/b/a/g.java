package com.google.c.b.a;

import com.google.c.b.b;
import com.google.c.b.c;
import com.google.c.b.i;
import com.google.c.c.a;
import com.google.c.e;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Map;

public final class g
  implements s
{
  final boolean dEF;
  private final c dEy;
  
  public g(c paramc)
  {
    this.dEy = paramc;
    this.dEF = false;
  }
  
  public final <T> r<T> a(e parame, a<T> parama)
  {
    AppMethodBeat.i(108049);
    Object localObject = parama.dGJ;
    if (!Map.class.isAssignableFrom(parama.dIb))
    {
      AppMethodBeat.o(108049);
      return null;
    }
    Type[] arrayOfType = b.b((Type)localObject, b.c((Type)localObject));
    localObject = arrayOfType[0];
    if ((localObject == Boolean.TYPE) || (localObject == Boolean.class)) {}
    for (localObject = n.dGP;; localObject = parame.a(a.h((Type)localObject)))
    {
      r localr = parame.a(a.h(arrayOfType[1]));
      parama = this.dEy.b(parama);
      parame = new a(parame, arrayOfType[0], (r)localObject, arrayOfType[1], localr, parama);
      AppMethodBeat.o(108049);
      return parame;
    }
  }
  
  final class a<K, V>
    extends r<Map<K, V>>
  {
    private final i<? extends Map<K, V>> dGd;
    private final r<K> dGl;
    private final r<V> dGm;
    
    public a(Type paramType1, r<K> paramr, Type paramType2, r<V> paramr1, i<? extends Map<K, V>> parami)
    {
      AppMethodBeat.i(108040);
      this.dGl = new m(paramType1, paramType2, paramr);
      this.dGm = new m(paramType1, parami, paramr1);
      Object localObject;
      this.dGd = localObject;
      AppMethodBeat.o(108040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.g
 * JD-Core Version:    0.7.0.1
 */