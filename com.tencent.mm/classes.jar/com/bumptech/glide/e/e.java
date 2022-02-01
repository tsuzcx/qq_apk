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
  private final List<String> aLk;
  private final Map<String, List<a<?, ?>>> aLl;
  
  public e()
  {
    AppMethodBeat.i(77610);
    this.aLk = new ArrayList();
    this.aLl = new HashMap();
    AppMethodBeat.o(77610);
  }
  
  private List<a<?, ?>> U(String paramString)
  {
    try
    {
      AppMethodBeat.i(77615);
      if (!this.aLk.contains(paramString)) {
        this.aLk.add(paramString);
      }
      List localList = (List)this.aLl.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aLl.put(paramString, localObject);
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
      U(paramString).add(new a(paramClass, paramClass1, paramk));
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
      Iterator localIterator = this.aLk.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aLl.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if (locala.e(paramClass, paramClass1)) {
              localArrayList.add(locala.aJa);
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
      Iterator localIterator = this.aLk.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aLl.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala.e(paramClass, paramClass1)) && (!localArrayList.contains(locala.aEo))) {
              localArrayList.add(locala.aEo);
            }
          }
        }
      }
      AppMethodBeat.o(77613);
    }
    finally {}
    return localArrayList;
  }
  
  public final void r(List<String> paramList)
  {
    try
    {
      AppMethodBeat.i(77611);
      Object localObject = new ArrayList(this.aLk);
      this.aLk.clear();
      this.aLk.addAll(paramList);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramList.contains(str)) {
          this.aLk.add(str);
        }
      }
      AppMethodBeat.o(77611);
    }
    finally {}
  }
  
  static final class a<T, R>
  {
    final Class<R> aEo;
    private final Class<T> aFl;
    final k<T, R> aJa;
    
    public a(Class<T> paramClass, Class<R> paramClass1, k<T, R> paramk)
    {
      this.aFl = paramClass;
      this.aEo = paramClass1;
      this.aJa = paramk;
    }
    
    public final boolean e(Class<?> paramClass1, Class<?> paramClass2)
    {
      AppMethodBeat.i(77609);
      if ((this.aFl.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.aEo)))
      {
        AppMethodBeat.o(77609);
        return true;
      }
      AppMethodBeat.o(77609);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.e.e
 * JD-Core Version:    0.7.0.1
 */