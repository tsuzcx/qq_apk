package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Random;

final class AddrBookObserver$1
  extends ah
{
  AddrBookObserver$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (Context)paramMessage.obj;
    if (AddrBookObserver.NH() == null)
    {
      AddrBookObserver.h(new Intent());
      AddrBookObserver.NH().setClass(paramMessage, AddrBookObserver.AddrBookService.class);
    }
    float f = new Random(System.currentTimeMillis()).nextFloat();
    AddrBookObserver.NH().putExtra(AddrBookObserver.AddrBookService.ekQ, f);
    try
    {
      y.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
      paramMessage.startService(AddrBookObserver.NH());
      return;
    }
    catch (Exception paramMessage)
    {
      y.printErrStackTrace("MicroMsg.AddrBookObserver", paramMessage, "startService failed", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver.1
 * JD-Core Version:    0.7.0.1
 */