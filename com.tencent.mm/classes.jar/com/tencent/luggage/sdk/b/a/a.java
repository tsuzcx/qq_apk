package com.tencent.luggage.sdk.b.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends a.b, ComponentLogicImp extends a.a, Component extends c>
{
  private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> bDM;
  
  public a()
  {
    AppMethodBeat.i(140679);
    this.bDM = new ConcurrentHashMap(2);
    AppMethodBeat.o(140679);
  }
  
  public final ComponentLogicImp a(ComponentImpType paramComponentImpType, Component paramComponent)
  {
    AppMethodBeat.i(140681);
    Class localClass = (Class)this.bDM.get(paramComponentImpType.getClass().getName());
    if (localClass != null) {}
    try
    {
      paramComponentImpType = org.apache.commons.b.c.a.a(localClass, new Class[] { paramComponent.getClass() });
      if (paramComponentImpType == null)
      {
        d.e("Luggage.AppBrandLogicFactory", "hy: constructor is null, return");
        AppMethodBeat.o(140681);
        return null;
      }
      paramComponentImpType = (a.a)paramComponentImpType.newInstance(new Object[] { paramComponent });
      AppMethodBeat.o(140681);
      return paramComponentImpType;
    }
    catch (InstantiationException paramComponentImpType)
    {
      d.printErrStackTrace("Luggage.AppBrandLogicFactory", paramComponentImpType, "hy: construct failed!", new Object[0]);
      AppMethodBeat.o(140681);
      return null;
      d.w("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", new Object[] { paramComponentImpType });
      AppMethodBeat.o(140681);
      return null;
    }
    catch (IllegalAccessException paramComponentImpType)
    {
      break label85;
    }
    catch (InvocationTargetException paramComponentImpType)
    {
      label85:
      break label85;
    }
  }
  
  public final void a(ComponentImpType paramComponentImpType, Class<? extends ComponentLogicImp> paramClass)
  {
    AppMethodBeat.i(140680);
    this.bDM.put(paramComponentImpType.getClass().getName(), paramClass);
    AppMethodBeat.o(140680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a
 * JD-Core Version:    0.7.0.1
 */