package com.tencent.mm.plugin.appbrand.platform.window.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import org.apache.commons.c.a;

final class k$a$1
  extends r
{
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(176745);
    Log.i("Luggage.WXA.WindowAndroidActivityCutoutHandler.Dummy", "dummy invoke method(%s) args(%s)", new Object[] { paramMethod.getName(), a.w(paramArrayOfObject, "NULL") });
    paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
    AppMethodBeat.o(176745);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.k.a.1
 * JD-Core Version:    0.7.0.1
 */