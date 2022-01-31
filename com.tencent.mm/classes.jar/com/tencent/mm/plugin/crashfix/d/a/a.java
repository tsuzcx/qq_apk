package com.tencent.mm.plugin.crashfix.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class a
  implements InvocationHandler
{
  protected static String kTe = "mShow";
  protected Object kTd;
  
  protected a(Object paramObject)
  {
    this.kTd = paramObject;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(151901);
    if (this.kTd != null)
    {
      if ((paramMethod.getName().equals("enqueueToast")) && (paramArrayOfObject[1].getClass().getName().equals("android.widget.Toast$TN"))) {}
      try
      {
        paramObject = paramArrayOfObject[1].getClass().getDeclaredField(kTe);
        paramObject.setAccessible(true);
        com.tencent.mm.plugin.crashfix.c.a.b(paramObject);
        final Runnable localRunnable = (Runnable)paramObject.get(paramArrayOfObject[1]);
        paramObject.set(paramArrayOfObject[1], new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151900);
            try
            {
              ab.i("MicroMsg.INotificationManagerInvocationHandler", "run on my runnable");
              localRunnable.run();
              AppMethodBeat.o(151900);
              return;
            }
            catch (Exception localException)
            {
              ab.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
              AppMethodBeat.o(151900);
            }
          }
        });
        ab.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
        paramObject = paramMethod.invoke(this.kTd, paramArrayOfObject);
        AppMethodBeat.o(151901);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          ab.e("MicroMsg.INotificationManagerInvocationHandler", paramObject.getMessage());
        }
      }
    }
    AppMethodBeat.o(151901);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.a
 * JD-Core Version:    0.7.0.1
 */