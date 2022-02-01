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
  private final List<String> aNb;
  private final Map<String, List<a<?, ?>>> aNc;
  
  public e()
  {
    AppMethodBeat.i(77610);
    this.aNb = new ArrayList();
    this.aNc = new HashMap();
    AppMethodBeat.o(77610);
  }
  
  private List<a<?, ?>> T(String paramString)
  {
    try
    {
      AppMethodBeat.i(77615);
      if (!this.aNb.contains(paramString)) {
        this.aNb.add(paramString);
      }
      List localList = (List)this.aNc.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aNc.put(paramString, localObject);
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
      T(paramString).add(new a(paramClass, paramClass1, paramk));
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
      Iterator localIterator = this.aNb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aNc.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if (locala.e(paramClass, paramClass1)) {
              localArrayList.add(locala.aKR);
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
      Iterator localIterator = this.aNb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aNc.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala.e(paramClass, paramClass1)) && (!localArrayList.contains(locala.aGf))) {
              localArrayList.add(locala.aGf);
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
      Object localObject = new ArrayList(this.aNb);
      this.aNb.clear();
      this.aNb.addAll(paramList);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramList.contains(str)) {
          this.aNb.add(str);
        }
      }
      AppMethodBeat.o(77611);
    }
    finally {}
  }
  
  static final class a<T, R>
  {
    final Class<R> aGf;
    private final Class<T> aHc;
    final k<T, R> aKR;
    
    public a(Class<T> paramClass, Class<R> paramClass1, k<T, R> paramk)
    {
      this.aHc = paramClass;
      this.aGf = paramClass1;
      this.aKR = paramk;
    }
    
    public final boolean e(Class<?> paramClass1, Class<?> paramClass2)
    {
      AppMethodBeat.i(77609);
      if ((this.aHc.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.aGf)))
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