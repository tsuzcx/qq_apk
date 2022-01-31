package com.tencent.mm.plugin.expt.hellhound.core.v2.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b
  implements InvocationHandler
{
  public Object may = null;
  public Field maz = null;
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(152310);
    paramObject = paramMethod.getName();
    if (paramObject.equals("onPostOpen")) {
      c.brT().vp(0);
    }
    for (;;)
    {
      try
      {
        paramObject = a.a(this.may, paramMethod, paramArrayOfObject);
        AppMethodBeat.o(152310);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        ab.printErrStackTrace("StoryGalleryHijack", paramObject, "StoryGalleryHijack invoke crash", new Object[0]);
        paramObject = new Object();
        AppMethodBeat.o(152310);
      }
      if (paramObject.equals("onPostClose")) {
        c.brT().vp(1);
      }
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b
 * JD-Core Version:    0.7.0.1
 */