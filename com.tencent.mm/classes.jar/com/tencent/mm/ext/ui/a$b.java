package com.tencent.mm.ext.ui;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class a$b
  implements InvocationHandler
{
  WeakReference<a.a> jRb;
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(258890);
    if (this.jRb == null)
    {
      b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!", new Object[0]);
      AppMethodBeat.o(258890);
      return null;
    }
    paramObject = (a.a)this.jRb.get();
    if (paramObject == null)
    {
      b.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!", new Object[0]);
      AppMethodBeat.o(258890);
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
    paramObject.eG(bool1);
    AppMethodBeat.o(258890);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.ui.a.b
 * JD-Core Version:    0.7.0.1
 */