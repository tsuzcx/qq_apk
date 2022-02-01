package com.tencent.luggage.sdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends b, ComponentLogicImp extends a, Component extends c>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> cnk;
  
  public a()
  {
    AppMethodBeat.i(146714);
    this.cnk = new ConcurrentHashMap(2);
    AppMethodBeat.o(146714);
  }
  
  public final ComponentLogicImp a(ComponentImpType paramComponentImpType, Component paramComponent)
  {
    AppMethodBeat.i(146716);
    Class localClass = (Class)this.cnk.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {
      try
      {
        paramComponentImpType = (a)org.a.a.bF(localClass).aj(new Object[] { paramComponent }).object;
        AppMethodBeat.o(146716);
        return paramComponentImpType;
      }
      catch (Exception paramComponentImpType)
      {
        ad.printErrStackTrace("Luggage.AppBrandLogicFactory", paramComponentImpType, "hy: construct failed!", new Object[0]);
        AppMethodBeat.o(146716);
        return null;
      }
    }
    ad.w("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", new Object[] { paramComponentImpType });
    AppMethodBeat.o(146716);
    return null;
  }
  
  public final void a(ComponentImpType paramComponentImpType, Class<? extends ComponentLogicImp> paramClass)
  {
    AppMethodBeat.i(146715);
    this.cnk.put(paramComponentImpType.getClass().getName(), paramClass);
    AppMethodBeat.o(146715);
  }
  
  public static abstract class a<Component extends c>
  {
    protected Component cnl;
    protected final Map<Class, Object> cnm = new HashMap(2);
    
    public a(Component paramComponent)
    {
      this.cnl = paramComponent;
    }
    
    public final Component El()
    {
      try
      {
        c localc = this.cnl;
        return localc;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    protected final Collection<Object> Em()
    {
      synchronized (this.cnm)
      {
        LinkedList localLinkedList = new LinkedList(this.cnm.values());
        return localLinkedList;
      }
    }
    
    public <T> T Q(Class<T> paramClass)
    {
      synchronized (this.cnm)
      {
        Object localObject1 = paramClass.cast(this.cnm.get(paramClass));
        if (localObject1 == null)
        {
          localObject1 = this.cnm.values().iterator();
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
    
    protected final <T> void b(Class<T> paramClass, T paramT)
    {
      synchronized (this.cnm)
      {
        this.cnm.put(paramClass, paramT);
        return;
      }
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */