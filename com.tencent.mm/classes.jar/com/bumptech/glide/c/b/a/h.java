package com.bumptech.glide.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V>
{
  private final a<K, V> aFN;
  private final Map<K, a<K, V>> aFO;
  
  h()
  {
    AppMethodBeat.i(77087);
    this.aFN = new a();
    this.aFO = new HashMap();
    AppMethodBeat.o(77087);
  }
  
  private void a(a<K, V> parama)
  {
    AppMethodBeat.i(77092);
    d(parama);
    parama.aFS = this.aFN;
    parama.aFR = this.aFN.aFR;
    c(parama);
    AppMethodBeat.o(77092);
  }
  
  private void b(a<K, V> parama)
  {
    AppMethodBeat.i(77093);
    d(parama);
    parama.aFS = this.aFN.aFS;
    parama.aFR = this.aFN;
    c(parama);
    AppMethodBeat.o(77093);
  }
  
  private static <K, V> void c(a<K, V> parama)
  {
    parama.aFR.aFS = parama;
    parama.aFS.aFR = parama;
  }
  
  private static <K, V> void d(a<K, V> parama)
  {
    parama.aFS.aFR = parama.aFR;
    parama.aFR.aFS = parama.aFS;
  }
  
  public final void a(K paramK, V paramV)
  {
    AppMethodBeat.i(77088);
    a locala = (a)this.aFO.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      b(locala);
      this.aFO.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      paramK.add(paramV);
      AppMethodBeat.o(77088);
      return;
      paramK.ou();
    }
  }
  
  public final V b(K paramK)
  {
    AppMethodBeat.i(77089);
    a locala = (a)this.aFO.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      this.aFO.put(paramK, locala);
    }
    for (paramK = locala;; paramK = locala)
    {
      a(paramK);
      paramK = paramK.removeLast();
      AppMethodBeat.o(77089);
      return paramK;
      paramK.ou();
    }
  }
  
  public final V removeLast()
  {
    AppMethodBeat.i(77090);
    for (a locala = this.aFN.aFS; !locala.equals(this.aFN); locala = locala.aFS)
    {
      Object localObject = locala.removeLast();
      if (localObject != null)
      {
        AppMethodBeat.o(77090);
        return localObject;
      }
      d(locala);
      this.aFO.remove(locala.aFP);
      ((m)locala.aFP).ou();
    }
    AppMethodBeat.o(77090);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77091);
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    Object localObject = this.aFN.aFR;
    int i = 0;
    while (!localObject.equals(this.aFN))
    {
      i = 1;
      localStringBuilder.append('{').append(((a)localObject).aFP).append(':').append(((a)localObject).size()).append("}, ");
      localObject = ((a)localObject).aFR;
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
    final K aFP;
    private List<V> aFQ;
    a<K, V> aFR;
    a<K, V> aFS;
    
    a()
    {
      this(null);
    }
    
    a(K paramK)
    {
      AppMethodBeat.i(77083);
      this.aFS = this;
      this.aFR = this;
      this.aFP = paramK;
      AppMethodBeat.o(77083);
    }
    
    public final void add(V paramV)
    {
      AppMethodBeat.i(77086);
      if (this.aFQ == null) {
        this.aFQ = new ArrayList();
      }
      this.aFQ.add(paramV);
      AppMethodBeat.o(77086);
    }
    
    public final V removeLast()
    {
      AppMethodBeat.i(77084);
      int i = size();
      if (i > 0)
      {
        Object localObject = this.aFQ.remove(i - 1);
        AppMethodBeat.o(77084);
        return localObject;
      }
      AppMethodBeat.o(77084);
      return null;
    }
    
    public final int size()
    {
      AppMethodBeat.i(77085);
      if (this.aFQ != null)
      {
        int i = this.aFQ.size();
        AppMethodBeat.o(77085);
        return i;
      }
      AppMethodBeat.o(77085);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.h
 * JD-Core Version:    0.7.0.1
 */