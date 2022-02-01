package com.tencent.mm.plugin.crashfix.patch.b;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b
  extends a
{
  protected b(Object paramObject)
  {
    super(paramObject);
    xfE = "mHandler";
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(145632);
    if (this.xfD != null)
    {
      if ((paramMethod.getName().equals("enqueueToast")) && (paramArrayOfObject[1].getClass().getName().equals("android.widget.Toast$TN"))) {}
      try
      {
        paramObject = paramArrayOfObject[1].getClass().getDeclaredField(xfE);
        paramObject.setAccessible(true);
        com.tencent.mm.plugin.crashfix.c.a.f(paramObject);
        final Handler localHandler = (Handler)paramObject.get(paramArrayOfObject[1]);
        paramObject.set(paramArrayOfObject[1], new Handler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(145631);
            try
            {
              Log.i("MicroMsg.INotificationManagerInvocationHandler", "run on my handler");
              localHandler.handleMessage(paramAnonymousMessage);
              AppMethodBeat.o(145631);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              Log.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
              AppMethodBeat.o(145631);
            }
          }
        });
        Log.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
        paramObject = paramMethod.invoke(this.xfD, paramArrayOfObject);
        AppMethodBeat.o(145632);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Log.e("MicroMsg.INotificationManagerInvocationHandler", paramObject.getMessage());
        }
      }
    }
    AppMethodBeat.o(145632);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.b.b
 * JD-Core Version:    0.7.0.1
 */