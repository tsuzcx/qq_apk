package com.google.a.b.a;

import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.c.a;
import com.google.a.e;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Map;

public final class g
  implements s
{
  private final c bKQ;
  final boolean bKX;
  
  public g(c paramc)
  {
    this.bKQ = paramc;
    this.bKX = false;
  }
  
  public final <T> r<T> a(e parame, a<T> parama)
  {
    AppMethodBeat.i(108049);
    Object localObject = parama.bNe;
    if (!Map.class.isAssignableFrom(parama.bOw))
    {
      AppMethodBeat.o(108049);
      return null;
    }
    Type[] arrayOfType = b.b((Type)localObject, b.c((Type)localObject));
    localObject = arrayOfType[0];
    if ((localObject == Boolean.TYPE) || (localObject == Boolean.class)) {}
    for (localObject = n.bNk;; localObject = parame.a(a.h((Type)localObject)))
    {
      r localr = parame.a(a.h(arrayOfType[1]));
      parama = this.bKQ.b(parama);
      parame = new a(parame, arrayOfType[0], (r)localObject, arrayOfType[1], localr, parama);
      AppMethodBeat.o(108049);
      return parame;
    }
  }
  
  final class a<K, V>
    extends r<Map<K, V>>
  {
    private final r<K> bMG;
    private final r<V> bMH;
    private final i<? extends Map<K, V>> bMx;
    
    public a(Type paramType1, r<K> paramr, Type paramType2, r<V> paramr1, i<? extends Map<K, V>> parami)
    {
      AppMethodBeat.i(108040);
      this.bMG = new m(paramType1, paramType2, paramr);
      this.bMH = new m(paramType1, parami, paramr1);
      Object localObject;
      this.bMx = localObject;
      AppMethodBeat.o(108040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */