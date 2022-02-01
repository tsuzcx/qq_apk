package com.tencent.midas.jsbridge;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class APX5$1
  implements Runnable
{
  APX5$1(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(217018);
    try
    {
      Method localMethod = Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", new Class[] { Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback") });
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        localMethod.invoke(null, new Object[] { this.val$context.getApplicationContext(), null });
      }
      AppMethodBeat.o(217018);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(217018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APX5.1
 * JD-Core Version:    0.7.0.1
 */