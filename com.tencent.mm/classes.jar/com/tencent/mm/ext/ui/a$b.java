package com.tencent.mm.ext.ui;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$b
  implements InvocationHandler
{
  WeakReference<a.a> mql;
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(235333);
    if (this.mql == null)
    {
      b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!", new Object[0]);
      AppMethodBeat.o(235333);
      return null;
    }
    paramObject = (a.a)this.mql.get();
    if (paramObject == null)
    {
      b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!", new Object[0]);
      AppMethodBeat.o(235333);
      return null;
    }
    boolean bool1 = bool2;
    if (paramArrayOfObject != null)
    {
      bool1 = bool2;
      if (paramArrayOfObject.length > 0)
      {
        bool1 = bool2;
        if ((paramArrayOfObject[0] instanceof Boolean)) {
          bool1 = ((Boolean)paramArrayOfObject[0]).booleanValue();
        }
      }
    }
    paramObject.onComplete(bool1);
    AppMethodBeat.o(235333);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.a.b
 * JD-Core Version:    0.7.0.1
 */