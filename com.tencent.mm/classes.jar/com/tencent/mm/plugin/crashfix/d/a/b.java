package com.tencent.mm.plugin.crashfix.d.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class b
  extends a
{
  protected b(Object paramObject)
  {
    super(paramObject);
    kTe = "mHandler";
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(151903);
    if (this.kTd != null)
    {
      if ((paramMethod.getName().equals("enqueueToast")) && (paramArrayOfObject[1].getClass().getName().equals("android.widget.Toast$TN"))) {}
      try
      {
        paramObject = paramArrayOfObject[1].getClass().getDeclaredField(kTe);
        paramObject.setAccessible(true);
        com.tencent.mm.plugin.crashfix.c.a.b(paramObject);
        Handler localHandler = (Handler)paramObject.get(paramArrayOfObject[1]);
        paramObject.set(paramArrayOfObject[1], new b.1(this, localHandler));
        ab.i("MicroMsg.INotificationManagerInvocationHandler", "replace Toast.TN.mShow succ");
        paramObject = paramMethod.invoke(this.kTd, paramArrayOfObject);
        AppMethodBeat.o(151903);
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
    AppMethodBeat.o(151903);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.a.b
 * JD-Core Version:    0.7.0.1
 */