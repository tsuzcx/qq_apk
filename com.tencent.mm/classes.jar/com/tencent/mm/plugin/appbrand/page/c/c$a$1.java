package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Method;
import org.apache.commons.b.a;

final class c$a$1
  extends m
{
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(176696);
    ae.i("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramMethod.getName(), a.toString(paramArrayOfObject, "NULL") });
    paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
    AppMethodBeat.o(176696);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.c.a.1
 * JD-Core Version:    0.7.0.1
 */