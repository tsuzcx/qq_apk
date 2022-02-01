package com.bumptech.glide.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V>
{
  private final a<K, V> aIu;
  private final Map<K, a<K, V>> aIv;
  
  h()
  {
    AppMethodBeat.i(77087);
    this.aIu = new a();
    this.aIv = new HashMap();
    AppMethodBeat.o(77087);
  }
  
  private void a(a<K, V> parama)
  {
    AppMethodBeat.i(77092);
    d(parama);
    parama.aIz = this.aIu;
    parama.aIy = this.aIu.aIy;
    c(parama);
    AppMethodBeat.o(77092);
  }
  
  private void b(a<K, V> parama)
  {
    AppMethodBeat.i(77093);
    d(parama);
    parama.aIz = this.aIu.aIz;
    parama.aIy = this.aIu;
    c(parama);
    AppMethodBeat.o(77093);
  }
  
  private static <K, V> void c(a<K, V> parama)
  {
    parama.aIy.aIz = parama;
    parama.aIz.aIy = parama;
  }
  
  private static <K, V> void d(a<K, V> parama)
  {
    parama.aIz.aIy = parama.aIy;
    parama.aIy.aIz = parama.aIz;
  }
  
  public final void a(K paramK, V paramV)
  {
    AppMethodBeat.i(77088);
    a locala = (a)this.aIv.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      b(locala);
      this.aIv.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      paramK.add(paramV);
      AppMethodBeat.o(77088);
      return;
      paramK.oW();
    }
  }
  
  public final V b(K paramK)
  {
    AppMethodBeat.i(77089);
    a locala = (a)this.aIv.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      this.aIv.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      a(paramK);
      paramK = paramK.removeLast();
      AppMethodBeat.o(77089);
      return paramK;
      paramK.oW();
    }
  }
  
  public final V removeLast()
  {
    AppMethodBeat.i(77090);
    for (a locala = this.aIu.aIz; !locala.equals(this.aIu); locala = locala.aIz)
    {
      Object localObject = locala.removeLast();
      if (localObject != null)
      {
        AppMethodBeat.o(77090);
        return localObject;
      }
      d(locala);
      this.aIv.remove(locala.aIw);
      ((m)locala.aIw).oW();
    }
    AppMethodBeat.o(77090);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77091);
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    Object localObject = this.aIu.aIy;
    int i = 0;
    while (!localObject.equals(this.aIu))
    {
      i = 1;
      localStringBuilder.append('{').append(((a)localObject).aIw).append(':').append(((a)localObject).size()).append("}, ");
      localObject = ((a)localObject).aIy;
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
    final K aIw;
    private List<V> aIx;
    a<K, V> aIy;
    a<K, V> aIz;
    
    a()
    {
      this(null);
    }
    
    a(K paramK)
    {
      AppMethodBeat.i(77083);
      this.aIz = this;
      this.aIy = this;
      this.aIw = paramK;
      AppMethodBeat.o(77083);
    }
    
    public final void add(V paramV)
    {
      AppMethodBeat.i(77086);
      if (this.aIx == null) {
        this.aIx = new ArrayList();
      }
      this.aIx.add(paramV);
      AppMethodBeat.o(77086);
    }
    
    public final V removeLast()
    {
      AppMethodBeat.i(77084);
      int i = size();
      if (i > 0)
      {
        Object localObject = this.aIx.remove(i - 1);
        AppMethodBeat.o(77084);
        return localObject;
      }
      AppMethodBeat.o(77084);
      return null;
    }
    
    public final int size()
    {
      AppMethodBeat.i(77085);
      if (this.aIx != null)
      {
        int i = this.aIx.size();
        AppMethodBeat.o(77085);
        return i;
      }
      AppMethodBeat.o(77085);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.h
 * JD-Core Version:    0.7.0.1
 */