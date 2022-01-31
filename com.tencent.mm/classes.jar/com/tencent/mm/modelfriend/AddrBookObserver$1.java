package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Random;

final class AddrBookObserver$1
  extends ak
{
  AddrBookObserver$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(124497);
    super.handleMessage(paramMessage);
    paramMessage = (Context)paramMessage.obj;
    if (AddrBookObserver.agv() == null)
    {
      AddrBookObserver.v(new Intent());
      AddrBookObserver.agv().setClass(paramMessage, AddrBookObserver.AddrBookService.class);
    }
    float f = new Random(System.currentTimeMillis()).nextFloat();
    AddrBookObserver.agv().putExtra(AddrBookObserver.AddrBookService.fBh, f);
    try
    {
      ab.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
      d.aG(AddrBookObserver.agv());
      AppMethodBeat.o(124497);
      return;
    }
    catch (Exception paramMessage)
    {
      ab.printErrStackTrace("MicroMsg.AddrBookObserver", paramMessage, "startService failed", new Object[0]);
      AppMethodBeat.o(124497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver.1
 * JD-Core Version:    0.7.0.1
 */