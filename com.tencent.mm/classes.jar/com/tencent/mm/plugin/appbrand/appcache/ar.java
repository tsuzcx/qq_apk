package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ar
  implements InvocationHandler
{
  private final Map<String, Method> gWn;
  private final ar.b gWo;
  
  private ar(u paramu)
  {
    AppMethodBeat.i(86810);
    this.gWn = new ConcurrentHashMap();
    this.gWo = new ar.b(paramu, (byte)0);
    AppMethodBeat.o(86810);
  }
  
  private static Object a(Method paramMethod)
  {
    AppMethodBeat.i(86808);
    if (paramMethod.getReturnType().equals(j.class))
    {
      paramMethod = j.gZE;
      AppMethodBeat.o(86808);
      return paramMethod;
    }
    AppMethodBeat.o(86808);
    return null;
  }
  
  private Method b(Method paramMethod)
  {
    AppMethodBeat.i(86809);
    String str = paramMethod.toGenericString();
    Method localMethod2 = (Method)this.gWn.get(str);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      paramMethod = y.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      localMethod1 = paramMethod;
      if (paramMethod != null)
      {
        this.gWn.put(str, paramMethod);
        localMethod1 = paramMethod;
      }
    }
    AppMethodBeat.o(86809);
    return localMethod1;
  }
  
  public static IWxaFileSystemWithModularizing o(i parami)
  {
    AppMethodBeat.i(86806);
    try
    {
      parami = new ar(ax.q(parami));
      parami = (IWxaFileSystemWithModularizing)Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[] { IWxaFileSystemWithModularizing.class }, parami);
      AppMethodBeat.o(86806);
      return parami;
    }
    catch (Exception parami)
    {
      ab.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[] { parami });
      parami = new ar.a((byte)0);
      AppMethodBeat.o(86806);
    }
    return parami;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(86807);
    if (paramMethod.getReturnType().equals(Boolean.TYPE))
    {
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(86807);
      return paramObject;
    }
    if (Modifier.isStatic(paramMethod.getModifiers()))
    {
      AppMethodBeat.o(86807);
      return null;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof String)))
    {
      paramObject = this.gWo.yy((String)paramArrayOfObject[0]);
      if (paramObject == null)
      {
        paramObject = a(paramMethod);
        AppMethodBeat.o(86807);
        return paramObject;
      }
      if (paramMethod.getReturnType().equals(ao.class))
      {
        paramObject = paramObject.gVr;
        AppMethodBeat.o(86807);
        return paramObject;
      }
      Method localMethod = b(paramMethod);
      if (localMethod != null)
      {
        paramObject = localMethod.invoke(paramObject, paramArrayOfObject);
        AppMethodBeat.o(86807);
        return paramObject;
      }
    }
    else if (paramMethod.getReturnType().equals(Void.TYPE))
    {
      paramObject = this.gWo.avZ();
      if (paramObject != null)
      {
        paramMethod = b(paramMethod);
        if (paramMethod != null)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            paramMethod.invoke((y)paramObject.next(), paramArrayOfObject);
          }
        }
      }
      AppMethodBeat.o(86807);
      return null;
    }
    paramObject = a(paramMethod);
    AppMethodBeat.o(86807);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar
 * JD-Core Version:    0.7.0.1
 */