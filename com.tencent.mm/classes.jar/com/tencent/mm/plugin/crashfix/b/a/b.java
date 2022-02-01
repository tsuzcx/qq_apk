package com.tencent.mm.plugin.crashfix.b.a;

import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b
  implements InvocationHandler
{
  protected Object oCY;
  
  public b(WindowManager paramWindowManager)
  {
    this.oCY = paramWindowManager;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int k = 0;
    AppMethodBeat.i(145623);
    int j = k;
    int m;
    int i;
    if (paramMethod.getName().equals("removeViewImmediate"))
    {
      paramObject = new Throwable().getStackTrace();
      j = k;
      if (paramObject.length > 0)
      {
        m = paramObject.length;
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (paramObject[i].getMethodName().equals("handleDestroyActivity")) {
          j = 1;
        }
      }
      else {
        if (j == 0) {
          break;
        }
      }
      try
      {
        ac.i("MicroMsg.WindowManagerInvocationHandler", "removeViewImmediate");
        paramObject = paramMethod.invoke(this.oCY, paramArrayOfObject);
        AppMethodBeat.o(145623);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        ac.e("MicroMsg.WindowManagerInvocationHandler", "catch it");
        AppMethodBeat.o(145623);
        return null;
      }
      i += 1;
    }
    paramObject = paramMethod.invoke(this.oCY, paramArrayOfObject);
    AppMethodBeat.o(145623);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a.b
 * JD-Core Version:    0.7.0.1
 */