package com.tencent.luggage.sdk.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class a$a<Component extends f>
{
  private Component eqB;
  private final Map<Class, Object> eqC = new HashMap(2);
  
  public a$a(Component paramComponent)
  {
    this.eqB = paramComponent;
  }
  
  protected final void a(a parama)
  {
    synchronized (this.eqC)
    {
      this.eqC.putAll(parama.eqC);
      return;
    }
  }
  
  public <T> T aa(Class<T> paramClass)
  {
    synchronized (this.eqC)
    {
      Object localObject1 = paramClass.cast(this.eqC.get(paramClass));
      if (localObject1 == null)
      {
        localObject1 = this.eqC.values().iterator();
        Object localObject2;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((Iterator)localObject1).next();
        } while (!paramClass.isInstance(localObject2));
        paramClass = paramClass.cast(localObject2);
        return paramClass;
      }
      return localObject1;
      return null;
    }
  }
  
  public final Component aqX()
  {
    try
    {
      f localf = this.eqB;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final Collection<Object> aqY()
  {
    synchronized (this.eqC)
    {
      LinkedList localLinkedList = new LinkedList(this.eqC.values());
      return localLinkedList;
    }
  }
  
  protected final <T> void b(Class<T> paramClass, T paramT)
  {
    synchronized (this.eqC)
    {
      this.eqC.put(paramClass, paramT);
      return;
    }
  }
  
  protected final void cleanup()
  {
    synchronized (this.eqC)
    {
      this.eqC.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */