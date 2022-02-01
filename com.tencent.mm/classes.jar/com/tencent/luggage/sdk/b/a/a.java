package com.tencent.luggage.sdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends b, ComponentLogicImp extends a, Component extends e>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> cyh;
  
  public a()
  {
    AppMethodBeat.i(146714);
    this.cyh = new ConcurrentHashMap(2);
    AppMethodBeat.o(146714);
  }
  
  public final ComponentLogicImp a(ComponentImpType paramComponentImpType, Component paramComponent)
  {
    AppMethodBeat.i(146716);
    Class localClass = (Class)this.cyh.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {
      try
      {
        paramComponentImpType = (a)org.a.a.ce(localClass).ao(new Object[] { paramComponent }).object;
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
    this.cyh.put(paramComponentImpType.getClass().getName(), paramClass);
    AppMethodBeat.o(146715);
  }
  
  public static abstract class a<Component extends e>
  {
    private Component cyi;
    private final Map<Class, Object> cyj = new HashMap(2);
    
    public a(Component paramComponent)
    {
      this.cyi = paramComponent;
    }
    
    public final Component QK()
    {
      try
      {
        e locale = this.cyi;
        return locale;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    protected final Collection<Object> QL()
    {
      synchronized (this.cyj)
      {
        LinkedList localLinkedList = new LinkedList(this.cyj.values());
        return localLinkedList;
      }
    }
    
    public <T> T R(Class<T> paramClass)
    {
      synchronized (this.cyj)
      {
        Object localObject1 = paramClass.cast(this.cyj.get(paramClass));
        if (localObject1 == null)
        {
          localObject1 = this.cyj.values().iterator();
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
    
    protected final void a(a parama)
    {
      synchronized (this.cyj)
      {
        this.cyj.putAll(parama.cyj);
        return;
      }
    }
    
    protected final <T> void b(Class<T> paramClass, T paramT)
    {
      synchronized (this.cyj)
      {
        this.cyj.put(paramClass, paramT);
        return;
      }
    }
    
    protected final void cleanup()
    {
      synchronized (this.cyj)
      {
        this.cyj.clear();
      }
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */