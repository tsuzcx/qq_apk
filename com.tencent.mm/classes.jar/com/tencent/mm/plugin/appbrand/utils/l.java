package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.b.a;

public class l
  implements InvocationHandler
{
  public static <I> I g(String paramString, Class<I> paramClass)
  {
    AppMethodBeat.i(176786);
    paramString = new l()
    {
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(176785);
        ad.i(this.lMn, "dummy invoke method(%s) args(%s)", new Object[] { paramAnonymousMethod.getName(), a.toString(paramAnonymousArrayOfObject, "NULL") });
        paramAnonymousObject = super.invoke(paramAnonymousObject, paramAnonymousMethod, paramAnonymousArrayOfObject);
        AppMethodBeat.o(176785);
        return paramAnonymousObject;
      }
    };
    paramString = paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramString));
    AppMethodBeat.o(176786);
    return paramString;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(147718);
    paramObject = paramMethod.getReturnType();
    if (paramObject.equals(Integer.TYPE))
    {
      AppMethodBeat.o(147718);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Long.TYPE))
    {
      AppMethodBeat.o(147718);
      return Long.valueOf(0L);
    }
    if (paramObject.equals(Double.TYPE))
    {
      AppMethodBeat.o(147718);
      return Double.valueOf(0.0D);
    }
    if (paramObject.equals(Float.TYPE))
    {
      AppMethodBeat.o(147718);
      return Float.valueOf(0.0F);
    }
    if (paramObject.equals(Short.TYPE))
    {
      AppMethodBeat.o(147718);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Byte.TYPE))
    {
      AppMethodBeat.o(147718);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Character.TYPE))
    {
      AppMethodBeat.o(147718);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Boolean.TYPE))
    {
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(147718);
      return paramObject;
    }
    if (paramObject.equals(Boolean.class))
    {
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(147718);
      return paramObject;
    }
    if (paramObject.isInterface())
    {
      AppMethodBeat.o(147718);
      return null;
    }
    AppMethodBeat.o(147718);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.l
 * JD-Core Version:    0.7.0.1
 */