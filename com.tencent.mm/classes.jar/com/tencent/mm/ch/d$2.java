package com.tencent.mm.ch;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class d$2
  extends ah
{
  public final void handleMessage(Message paramMessage)
  {
    y.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[] { Integer.valueOf(paramMessage.what) });
    if (paramMessage.what == 0) {
      d.uFX.b((d.a)paramMessage.obj);
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 1)
      {
        if (d.c(d.uFX) != null)
        {
          d.b localb = (d.b)d.c(d.uFX).get();
          if (localb != null) {
            localb.cxC();
          }
        }
      }
      else {
        d.a(d.uFX, (d.a)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ch.d.2
 * JD-Core Version:    0.7.0.1
 */