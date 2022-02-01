package com.tencent.f.c;

import android.os.HandlerThread;
import com.tencent.f.d;
import com.tencent.f.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
{
  private static ConcurrentLinkedQueue<Long> RTD;
  
  static
  {
    AppMethodBeat.i(183234);
    RTD = new ConcurrentLinkedQueue();
    AppMethodBeat.o(183234);
  }
  
  static HandlerThread hy(String paramString, int paramInt)
  {
    AppMethodBeat.i(183232);
    paramString = new HandlerThread("[GT]".concat(String.valueOf(paramString)))
    {
      public final void interrupt()
      {
        AppMethodBeat.i(183224);
        super.interrupt();
        d.RSR.a(this, getName(), getId());
        AppMethodBeat.o(183224);
      }
      
      public final boolean quit()
      {
        AppMethodBeat.i(183222);
        d.RSR.a(this, getName(), getId());
        boolean bool = super.quit();
        AppMethodBeat.o(183222);
        return bool;
      }
      
      public final boolean quitSafely()
      {
        AppMethodBeat.i(183223);
        d.RSR.a(this, getName(), getId());
        boolean bool = super.quitSafely();
        AppMethodBeat.o(183223);
        return bool;
      }
      
      public final void start()
      {
        try
        {
          AppMethodBeat.i(183225);
          super.start();
          d.RSR.b(this, getName(), getId());
          AppMethodBeat.o(183225);
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
    };
    paramString.setPriority(android.support.v4.b.a.clamp(paramInt, 1, 10));
    AppMethodBeat.o(183232);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.c.a
 * JD-Core Version:    0.7.0.1
 */