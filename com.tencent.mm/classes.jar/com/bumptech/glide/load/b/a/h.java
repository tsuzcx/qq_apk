package com.bumptech.glide.load.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V>
{
  private final a<K, V> aIo;
  private final Map<K, a<K, V>> aIp;
  
  h()
  {
    AppMethodBeat.i(77087);
    this.aIo = new a();
    this.aIp = new HashMap();
    AppMethodBeat.o(77087);
  }
  
  private void a(a<K, V> parama)
  {
    AppMethodBeat.i(77092);
    d(parama);
    parama.aIs = this.aIo;
    parama.aIr = this.aIo.aIr;
    c(parama);
    AppMethodBeat.o(77092);
  }
  
  private void b(a<K, V> parama)
  {
    AppMethodBeat.i(77093);
    d(parama);
    parama.aIs = this.aIo.aIs;
    parama.aIr = this.aIo;
    c(parama);
    AppMethodBeat.o(77093);
  }
  
  private static <K, V> void c(a<K, V> parama)
  {
    parama.aIr.aIs = parama;
    parama.aIs.aIr = parama;
  }
  
  private static <K, V> void d(a<K, V> parama)
  {
    parama.aIs.aIr = parama.aIr;
    parama.aIr.aIs = parama.aIs;
  }
  
  public final void a(K paramK, V paramV)
  {
    AppMethodBeat.i(77088);
    a locala = (a)this.aIp.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      b(locala);
      this.aIp.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      paramK.add(paramV);
      AppMethodBeat.o(77088);
      return;
      paramK.pb();
    }
  }
  
  public final V b(K paramK)
  {
    AppMethodBeat.i(77089);
    a locala = (a)this.aIp.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      this.aIp.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      a(paramK);
      paramK = paramK.removeLast();
      AppMethodBeat.o(77089);
      return paramK;
      paramK.pb();
    }
  }
  
  public final V removeLast()
  {
    AppMethodBeat.i(77090);
    for (a locala = this.aIo.aIs; !locala.equals(this.aIo); locala = locala.aIs)
    {
      Object localObject = locala.removeLast();
      if (localObject != null)
      {
        AppMethodBeat.o(77090);
        return localObject;
      }
      d(locala);
      this.aIp.remove(locala.key);
      ((m)locala.key).pb();
    }
    AppMethodBeat.o(77090);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77091);
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    Object localObject = this.aIo.aIr;
    int i = 0;
    while (!localObject.equals(this.aIo))
    {
      i = 1;
      localStringBuilder.append('{').append(((a)localObject).key).append(':').append(((a)localObject).size()).append("}, ");
      localObject = ((a)localObject).aIr;
    }
    if (i != 0) {
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    }
    localObject = " )";
    AppMethodBeat.o(77091);
    return localObject;
  }
  
  static final class a<K, V>
  {
    private List<V> aIq;
    a<K, V> aIr;
    a<K, V> aIs;
    final K key;
    
    a()
    {
      this(null);
    }
    
    a(K paramK)
    {
      AppMethodBeat.i(77083);
      this.aIs = this;
      this.aIr = this;
      this.key = paramK;
      AppMethodBeat.o(77083);
    }
    
    public final void add(V paramV)
    {
      AppMethodBeat.i(77086);
      if (this.aIq == null) {
        this.aIq = new ArrayList();
      }
      this.aIq.add(paramV);
      AppMethodBeat.o(77086);
    }
    
    public final V removeLast()
    {
      AppMethodBeat.i(77084);
      int i = size();
      if (i > 0)
      {
        Object localObject = this.aIq.remove(i - 1);
        AppMethodBeat.o(77084);
        return localObject;
      }
      AppMethodBeat.o(77084);
      return null;
    }
    
    public final int size()
    {
      AppMethodBeat.i(77085);
      if (this.aIq != null)
      {
        int i = this.aIq.size();
        AppMethodBeat.o(77085);
        return i;
      }
      AppMethodBeat.o(77085);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.h
 * JD-Core Version:    0.7.0.1
 */