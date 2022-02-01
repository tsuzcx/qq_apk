package com.tencent.luggage.sdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends b, ComponentLogicImp extends a, Component extends f>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> czl;
  
  public a()
  {
    AppMethodBeat.i(146714);
    this.czl = new ConcurrentHashMap(2);
    AppMethodBeat.o(146714);
  }
  
  public final ComponentLogicImp a(ComponentImpType paramComponentImpType, Component paramComponent)
  {
    AppMethodBeat.i(146716);
    Class localClass = (Class)this.czl.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {
      try
      {
        paramComponentImpType = (a)org.a.a.bF(localClass).ak(new Object[] { paramComponent }).object;
        AppMethodBeat.o(146716);
        return paramComponentImpType;
      }
      catch (Exception paramComponentImpType)
      {
        Log.printErrStackTrace("Luggage.AppBrandLogicFactory", paramComponentImpType, "hy: construct failed!", new Object[0]);
        AppMethodBeat.o(146716);
        return null;
      }
    }
    Log.w("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", new Object[] { paramComponentImpType });
    AppMethodBeat.o(146716);
    return null;
  }
  
  public final void a(ComponentImpType paramComponentImpType, Class<? extends ComponentLogicImp> paramClass)
  {
    AppMethodBeat.i(146715);
    this.czl.put(paramComponentImpType.getClass().getName(), paramClass);
    AppMethodBeat.o(146715);
  }
  
  public static abstract class a<Component extends f>
  {
    protected Component czm;
    protected final Map<Class, Object> czn = new HashMap(2);
    
    public a(Component paramComponent)
    {
      this.czm = paramComponent;
    }
    
    public final Component NN()
    {
      try
      {
        f localf = this.czm;
        return localf;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    protected final Collection<Object> NO()
    {
      synchronized (this.czn)
      {
        LinkedList localLinkedList = new LinkedList(this.czn.values());
        return localLinkedList;
      }
    }
    
    public <T> T S(Class<T> paramClass)
    {
      synchronized (this.czn)
      {
        Object localObject1 = paramClass.cast(this.czn.get(paramClass));
        if (localObject1 == null)
        {
          localObject1 = this.czn.values().iterator();
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
      synchronized (this.czn)
      {
        this.czn.put(paramClass, paramT);
        return;
      }
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */