package com.tencent.luggage.sdk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends b, ComponentLogicImp extends a, Component extends c>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> cnm;
  
  public a()
  {
    AppMethodBeat.i(146714);
    this.cnm = new ConcurrentHashMap(2);
    AppMethodBeat.o(146714);
  }
  
  public final ComponentLogicImp a(ComponentImpType paramComponentImpType, Component paramComponent)
  {
    AppMethodBeat.i(146716);
    Class localClass = (Class)this.cnm.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {
      try
      {
        paramComponentImpType = (a)org.a.a.bF(localClass).ai(new Object[] { paramComponent }).object;
        AppMethodBeat.o(146716);
        return paramComponentImpType;
      }
      catch (Exception paramComponentImpType)
      {
        ae.printErrStackTrace("Luggage.AppBrandLogicFactory", paramComponentImpType, "hy: construct failed!", new Object[0]);
        AppMethodBeat.o(146716);
        return null;
      }
    }
    ae.w("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", new Object[] { paramComponentImpType });
    AppMethodBeat.o(146716);
    return null;
  }
  
  public final void a(ComponentImpType paramComponentImpType, Class<? extends ComponentLogicImp> paramClass)
  {
    AppMethodBeat.i(146715);
    this.cnm.put(paramComponentImpType.getClass().getName(), paramClass);
    AppMethodBeat.o(146715);
  }
  
  public static abstract class a<Component extends c>
  {
    protected Component cnn;
    protected final Map<Class, Object> cno = new HashMap(2);
    
    public a(Component paramComponent)
    {
      this.cnn = paramComponent;
    }
    
    public final Component Eo()
    {
      try
      {
        c localc = this.cnn;
        return localc;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    protected final Collection<Object> Ep()
    {
      synchronized (this.cno)
      {
        LinkedList localLinkedList = new LinkedList(this.cno.values());
        return localLinkedList;
      }
    }
    
    public <T> T Q(Class<T> paramClass)
    {
      synchronized (this.cno)
      {
        Object localObject1 = paramClass.cast(this.cno.get(paramClass));
        if (localObject1 == null)
        {
          localObject1 = this.cno.values().iterator();
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
      synchronized (this.cno)
      {
        this.cno.put(paramClass, paramT);
        return;
      }
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */