package com.bumptech.glide.d;

import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  private final List<String> aMS;
  private final Map<String, List<a<?, ?>>> aMT;
  
  public e()
  {
    AppMethodBeat.i(77610);
    this.aMS = new ArrayList();
    this.aMT = new HashMap();
    AppMethodBeat.o(77610);
  }
  
  private List<a<?, ?>> U(String paramString)
  {
    try
    {
      AppMethodBeat.i(77615);
      if (!this.aMS.contains(paramString)) {
        this.aMS.add(paramString);
      }
      List localList = (List)this.aMT.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aMT.put(paramString, localObject);
      }
      AppMethodBeat.o(77615);
      return localObject;
    }
    finally {}
  }
  
  public final <T, R> void a(String paramString, j<T, R> paramj, Class<T> paramClass, Class<R> paramClass1)
  {
    try
    {
      AppMethodBeat.i(77614);
      U(paramString).add(new a(paramClass, paramClass1, paramj));
      AppMethodBeat.o(77614);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final <T, R> List<j<T, R>> f(Class<T> paramClass, Class<R> paramClass1)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77612);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aMS.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aMT.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if (locala.e(paramClass, paramClass1)) {
              localArrayList.add(locala.aKJ);
            }
          }
        }
      }
      AppMethodBeat.o(77612);
    }
    finally {}
    return localArrayList;
  }
  
  public final <T, R> List<Class<R>> g(Class<T> paramClass, Class<R> paramClass1)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(77613);
      localArrayList = new ArrayList();
      Iterator localIterator = this.aMS.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (List)this.aMT.get(localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala.e(paramClass, paramClass1)) && (!localArrayList.contains(locala.aFX))) {
              localArrayList.add(locala.aFX);
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
      Object localObject = new ArrayList(this.aMS);
      this.aMS.clear();
      this.aMS.addAll(paramList);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramList.contains(str)) {
          this.aMS.add(str);
        }
      }
      AppMethodBeat.o(77611);
    }
    finally {}
  }
  
  static final class a<T, R>
  {
    final Class<R> aFX;
    private final Class<T> aGU;
    final j<T, R> aKJ;
    
    public a(Class<T> paramClass, Class<R> paramClass1, j<T, R> paramj)
    {
      this.aGU = paramClass;
      this.aFX = paramClass1;
      this.aKJ = paramj;
    }
    
    public final boolean e(Class<?> paramClass1, Class<?> paramClass2)
    {
      AppMethodBeat.i(77609);
      if ((this.aGU.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.aFX)))
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
 * Qualified Name:     com.bumptech.glide.d.e
 * JD-Core Version:    0.7.0.1
 */