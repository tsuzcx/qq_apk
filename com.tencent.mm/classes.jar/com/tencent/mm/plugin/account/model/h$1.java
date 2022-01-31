package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$1
  extends ak
{
  h$1(h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(124688);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(124688);
      return;
      if (this.gAR.gAQ != null)
      {
        this.gAR.gAQ.onError(paramMessage.arg1, (String)paramMessage.obj);
        AppMethodBeat.o(124688);
        return;
        if (this.gAR.gAQ != null) {
          this.gAR.gAQ.u(paramMessage.getData());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h.1
 * JD-Core Version:    0.7.0.1
 */