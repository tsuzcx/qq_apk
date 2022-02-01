package com.bumptech.glide.e;

import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  private final List<String> aKu;
  private final Map<String, List<a<?, ?>>> aKv;
  
  public e()
  {
    AppMethodBeat.i(77610);
    this.aKu = new ArrayList();
    this.aKv = new HashMap();
    AppMethodBeat.o(77610);
  }
  
  private List<a<?, ?>> S(String paramString)
  {
    try
    {
      AppMethodBeat.i(77615);
      if (!this.aKu.contains(paramString)) {
        this.aKu.add(paramString);
      }
      List localList = (List)this.aKv.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aKv.put(paramString, localObject);
      }
      AppMethodBeat.o(77615);
      return localObject;
    }
    finally {}
  }
  
  public final <T, R> void a(String paramString, k<T, R> paramk, Class<T> paramClass, Class<R> paramClass1)
  {
    try
    {
      AppMethodBeat.i(77614);
      S(paramString).add(new a(paramClass, paramClass1, paramk));
      AppMethodBeat.o(77614);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final <T, R> List<k<T, R>> g(Class<T> paramClass, Class<R> paramClass1)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77612);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aKu.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aKv.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if (locala.e(paramClass, paramClass1)) {
              localArrayList.add(locala.aIk);
            }
          }
        }
      }
      AppMethodBeat.o(77612);
    }
    finally {}
    return localArrayList;
  }
  
  public final <T, R> List<Class<R>> h(Class<T> paramClass, Class<R> paramClass1)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77613);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aKu.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aKv.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala.e(paramClass, paramClass1)) && (!localArrayList.contains(locala.aDx))) {
              localArrayList.add(locala.aDx);
            }
          }
        }
      }
      AppMethodBeat.o(77613);
    }
    finally {}
    return localArrayList;
  }
  
  public final void s(List<String> paramList)
  {
    try
    {
      AppMethodBeat.i(77611);
      Object localObject = new ArrayList(this.aKu);
      this.aKu.clear();
      this.aKu.addAll(paramList);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramList.contains(str)) {
          this.aKu.add(str);
        }
      }
      AppMethodBeat.o(77611);
    }
    finally {}
  }
  
  static final class a<T, R>
  {
    final Class<R> aDx;
    private final Class<T> aEv;
    final k<T, R> aIk;
    
    public a(Class<T> paramClass, Class<R> paramClass1, k<T, R> paramk)
    {
      this.aEv = paramClass;
      this.aDx = paramClass1;
      this.aIk = paramk;
    }
    
    public final boolean e(Class<?> paramClass1, Class<?> paramClass2)
    {
      AppMethodBeat.i(77609);
      if ((this.aEv.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.aDx)))
      {
        AppMethodBeat.o(77609);
        return true;
      }
      AppMethodBeat.o(77609);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.e
 * JD-Core Version:    0.7.0.1
 */