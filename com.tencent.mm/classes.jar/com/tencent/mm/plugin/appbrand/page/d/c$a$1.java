package com.tencent.mm.plugin.appbrand.page.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import org.apache.commons.b.a;

final class c$a$1
  extends l
{
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(176696);
    ad.i("Luggage.WXA.IPageStatusBarHelper.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramMethod.getName(), a.toString(paramArrayOfObject, "NULL") });
    paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
    AppMethodBeat.o(176696);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.c.a.1
 * JD-Core Version:    0.7.0.1
 */