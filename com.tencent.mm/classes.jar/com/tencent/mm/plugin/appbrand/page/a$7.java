package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;
import org.apache.commons.b.a;

final class a$7
  extends l
{
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(169504);
    ad.e("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", new Object[] { paramMethod.getName(), a.toString(paramArrayOfObject, "NULL") });
    paramObject = super.invoke(paramObject, paramMethod, paramArrayOfObject);
    AppMethodBeat.o(169504);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.7
 * JD-Core Version:    0.7.0.1
 */