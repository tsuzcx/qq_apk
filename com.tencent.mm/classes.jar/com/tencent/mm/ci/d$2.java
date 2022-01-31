package com.tencent.mm.ci;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class d$2
  extends ak
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76904);
    ab.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[] { Integer.valueOf(paramMessage.what) });
    if (paramMessage.what == 0) {
      d.ySP.b((d.a)paramMessage.obj);
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(76904);
      return;
      if (paramMessage.what == 1)
      {
        if (d.c(d.ySP) != null)
        {
          d.b localb = (d.b)d.c(d.ySP).get();
          if (localb != null) {
            localb.dAv();
          }
        }
      }
      else {
        d.a(d.ySP, (d.a)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ci.d.2
 * JD-Core Version:    0.7.0.1
 */