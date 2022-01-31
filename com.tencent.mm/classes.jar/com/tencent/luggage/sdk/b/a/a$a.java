package com.tencent.luggage.sdk.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class a$a<Component extends c>
{
  public Component bDN;
  protected final Map<Class, Object> bDO = new HashMap(2);
  
  public a$a(Component paramComponent)
  {
    this.bDN = paramComponent;
  }
  
  protected final <T> void b(Class<T> paramClass, T paramT)
  {
    synchronized (this.bDO)
    {
      this.bDO.put(paramClass, paramT);
      return;
    }
  }
  
  protected final Collection<Object> wi()
  {
    synchronized (this.bDO)
    {
      LinkedList localLinkedList = new LinkedList(this.bDO.values());
      return localLinkedList;
    }
  }
  
  public <T> T x(Class<T> paramClass)
  {
    synchronized (this.bDO)
    {
      Object localObject1 = paramClass.cast(this.bDO.get(paramClass));
      if (localObject1 == null)
      {
        localObject1 = this.bDO.values().iterator();
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
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */