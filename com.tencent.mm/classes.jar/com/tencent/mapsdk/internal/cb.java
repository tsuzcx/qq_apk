package com.tencent.mapsdk.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cb
  implements cd
{
  String a;
  public final cm b = new cm();
  private final Set<a> f = new LinkedHashSet();
  private cf g;
  
  private void a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.d == null) {
        locala.d = new HashMap();
      }
      locala.d.put(paramString1, paramString2);
      if (locala.e != null) {
        locala.e.a(locala.d);
      }
    }
  }
  
  private void c(String paramString)
  {
    this.a = paramString;
  }
  
  private a d(Class paramClass)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.equals(paramClass)) {
        return locala;
      }
    }
    return null;
  }
  
  private a d(String paramString)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a.equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  private cm d()
  {
    return this.b;
  }
  
  private <S extends ch> S e(Class<S> paramClass)
  {
    Object localObject = this.f.iterator();
    a locala;
    while (((Iterator)localObject).hasNext())
    {
      locala = (a)((Iterator)localObject).next();
      if (locala.b == paramClass)
      {
        localObject = locala.c;
        if (localObject == null) {
          break;
        }
      }
    }
    try
    {
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(this, new Object[] { locala.b });
      if ((localObject != null) && (localObject.getClass() == paramClass))
      {
        paramClass = (ch)localObject;
        paramClass.a(locala.d);
        locala.e = paramClass;
        return paramClass;
      }
    }
    catch (InvocationTargetException paramClass)
    {
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      label103:
      break label103;
    }
  }
  
  public final cg.a a(String paramString)
  {
    return b(paramString);
  }
  
  public final String a()
  {
    return this.a;
  }
  
  final void a(cf paramcf)
  {
    if (this.g != paramcf)
    {
      this.g = paramcf;
      paramcf = this.g.a_().iterator();
      while (paramcf.hasNext()) {
        o.a((Class)paramcf.next());
      }
      paramcf = this.g.a();
      this.f.clear();
      paramcf = paramcf.entrySet().iterator();
      Object localObject1;
      while (paramcf.hasNext())
      {
        Object localObject2 = (Map.Entry)paramcf.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (Class)((Map.Entry)localObject2).getValue();
        try
        {
          Method localMethod = cb.class.getDeclaredMethod("b", new Class[] { Class.class });
          this.f.add(new a((String)localObject1, (Class)localObject2, localMethod));
        }
        catch (NoSuchMethodException paramcf)
        {
          throw new IllegalStateException(paramcf);
        }
      }
      paramcf = this.g.c();
      if ((paramcf != null) && (!paramcf.isEmpty()))
      {
        paramcf = paramcf.entrySet().iterator();
        while (paramcf.hasNext())
        {
          localObject1 = (Map.Entry)paramcf.next();
          a((String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue());
        }
      }
    }
  }
  
  public final <T extends p> void a(Class<T> paramClass)
  {
    o.a(paramClass);
  }
  
  public final <T extends cg.a> void a(String paramString, Class<T> paramClass)
  {
    try
    {
      Method localMethod = cb.class.getDeclaredMethod("b", new Class[] { Class.class });
      this.f.add(new a(paramString, paramClass, localMethod));
      return;
    }
    catch (NoSuchMethodException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public final cf b()
  {
    return this.g;
  }
  
  abstract <S extends ch> S b(Class<S> paramClass);
  
  final <S extends ch> S b(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null)
    {
      if (paramString.e != null) {
        return paramString.e;
      }
      return e(paramString.b);
    }
    return null;
  }
  
  final <S extends ch> S c(Class<S> paramClass)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.equals(paramClass)) {
        paramClass = locala;
      }
    }
    while (paramClass != null) {
      if (paramClass.e != null)
      {
        return paramClass.e;
        paramClass = null;
      }
      else
      {
        return e(paramClass.b);
      }
    }
    return null;
  }
  
  static final class a<S extends ch>
  {
    String a;
    Class<S> b;
    Method c;
    Map<String, String> d;
    S e;
    
    a(String paramString, Class paramClass, Method paramMethod)
    {
      this.a = paramString;
      this.b = paramClass;
      this.c = paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cb
 * JD-Core Version:    0.7.0.1
 */