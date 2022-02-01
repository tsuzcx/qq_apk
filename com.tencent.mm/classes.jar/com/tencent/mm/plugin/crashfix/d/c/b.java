package com.tencent.mm.plugin.crashfix.d.c;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b
  extends a
{
  protected b(Object paramObject)
  {
    super(paramObject);
    pnl = "mHandler";
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(145632);
    if (this.pnk != null)
    {
      if ((paramMethod.getName().equals("enqueueToast")) && (paramArrayOfObject[1].getClass().getName().equals("android.widget.Toast$TN"))) {}
      try
      {
        paramObject = paramArrayOfObject[1].getClass().getDeclaredField(pnl);
        paramObject.setAccessible(true);
        com.tencent.mm.plugin.crashfix.c.a.c(paramObject);
        final Handler localHandler = (Handler)paramObject.get(paramArrayOfObject[1]);
        paramObject.set(paramArrayOfObject[1], new Handler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(145631);
            try
            {
              ae.i("MicroMsg.INotificationManagerInvocationHandler", "run on my handler");
              localHandler.handleMessage(paramAnonymousMessage);
              AppMethodBeat.o(145631);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              ae.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
              AppMethodBeat.o(145631);
            }
          }
        });
        ae.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
        paramObject = paramMethod.invoke(this.pnk, paramArrayOfObject);
        AppMethodBeat.o(145632);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          ae.e("MicroMsg.INotificationManagerInvocationHandler", paramObject.getMessage());
        }
      }
    }
    AppMethodBeat.o(145632);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.c.b
 * JD-Core Version:    0.7.0.1
 */