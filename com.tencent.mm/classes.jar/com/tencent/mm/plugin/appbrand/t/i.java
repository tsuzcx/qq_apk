package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class i
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(140985);
    paramObject = paramMethod.getReturnType();
    if (paramObject.equals(Integer.TYPE))
    {
      AppMethodBeat.o(140985);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Long.TYPE))
    {
      AppMethodBeat.o(140985);
      return Long.valueOf(0L);
    }
    if (paramObject.equals(Double.TYPE))
    {
      AppMethodBeat.o(140985);
      return Double.valueOf(0.0D);
    }
    if (paramObject.equals(Float.TYPE))
    {
      AppMethodBeat.o(140985);
      return Float.valueOf(0.0F);
    }
    if (paramObject.equals(Short.TYPE))
    {
      AppMethodBeat.o(140985);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Byte.TYPE))
    {
      AppMethodBeat.o(140985);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Character.TYPE))
    {
      AppMethodBeat.o(140985);
      return Integer.valueOf(0);
    }
    if (paramObject.equals(Boolean.TYPE))
    {
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(140985);
      return paramObject;
    }
    if (paramObject.equals(Boolean.class))
    {
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(140985);
      return paramObject;
    }
    if (paramObject.isInterface())
    {
      AppMethodBeat.o(140985);
      return null;
    }
    AppMethodBeat.o(140985);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.i
 * JD-Core Version:    0.7.0.1
 */