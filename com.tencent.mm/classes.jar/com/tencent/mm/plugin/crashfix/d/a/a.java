package com.tencent.mm.plugin.crashfix.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class a
  implements InvocationHandler
{
  protected static String oDf = "mShow";
  protected Object oDe;
  
  protected a(Object paramObject)
  {
    this.oDe = paramObject;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(145630);
    if (this.oDe != null)
    {
      if ((paramMethod.getName().equals("enqueueToast")) && (paramArrayOfObject[1].getClass().getName().equals("android.widget.Toast$TN"))) {}
      try
      {
        paramObject = paramArrayOfObject[1].getClass().getDeclaredField(oDf);
        paramObject.setAccessible(true);
        com.tencent.mm.plugin.crashfix.c.a.c(paramObject);
        final Runnable localRunnable = (Runnable)paramObject.get(paramArrayOfObject[1]);
        paramObject.set(paramArrayOfObject[1], new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(145629);
            try
            {
              ac.i("MicroMsg.INotificationManagerInvocationHandler", "run on my runnable");
              localRunnable.run();
              AppMethodBeat.o(145629);
              return;
            }
            catch (Exception localException)
            {
              ac.i("MicroMsg.INotificationManagerInvocationHandler", "protect succ");
              AppMethodBeat.o(145629);
            }
          }
        });
        ac.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
        paramObject = paramMethod.invoke(this.oDe, paramArrayOfObject);
        AppMethodBeat.o(145630);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          ac.e("MicroMsg.INotificationManagerInvocationHandler", paramObject.getMessage());
        }
      }
    }
    AppMethodBeat.o(145630);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.a
 * JD-Core Version:    0.7.0.1
 */