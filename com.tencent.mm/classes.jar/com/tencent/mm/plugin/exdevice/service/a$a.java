package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class a$a
  extends ak
{
  public a$a(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(19521);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(19521);
      return;
    case 2: 
      a.a(this.lIb).a(2, 0, null, null, null, 0, null);
      AppMethodBeat.o(19521);
      return;
    case 1: 
      paramMessage = (a.c)paramMessage.obj;
      a.a(this.lIb).a(1, 0, null, paramMessage.jRr, paramMessage.mDeviceName, paramMessage.hIe, paramMessage.jRs);
      AppMethodBeat.o(19521);
      return;
    case 3: 
      paramMessage = (a.e)paramMessage.obj;
      a.a(this.lIb).c(paramMessage.lIf, paramMessage.lCE, paramMessage.lCs, paramMessage.hyJ);
      AppMethodBeat.o(19521);
      return;
    case 4: 
      paramMessage = (a.d)paramMessage.obj;
      a.a(this.lIb).b(paramMessage.jRn, paramMessage.lId, paramMessage.lIe, paramMessage.lCs);
      AppMethodBeat.o(19521);
      return;
    case 5: 
      ??? = (a.b)paramMessage.obj;
      a.a(this.lIb).a(paramMessage.arg1, ((a.b)???).jRn, ((a.b)???).lCz, ((a.b)???).lIc, ((a.b)???).lCt);
      AppMethodBeat.o(19521);
      return;
    case 6: 
      AppMethodBeat.o(19521);
      return;
    case 7: 
      AppMethodBeat.o(19521);
      return;
    case 10: 
      paramMessage = (a.f)paramMessage.obj;
      a.a(this.lIb, paramMessage.jRn, paramMessage.mData);
      AppMethodBeat.o(19521);
      return;
    case 8: 
      paramMessage = (a.g)paramMessage.obj;
      a.a(this.lIb, paramMessage.lIf, paramMessage.lIg);
      AppMethodBeat.o(19521);
      return;
    case 9: 
      a.ji(((Long)paramMessage.obj).longValue());
      AppMethodBeat.o(19521);
      return;
    case 11: 
      synchronized (a.b(this.lIb))
      {
        a.a(this.lIb, ((Long)paramMessage.obj).longValue());
        AppMethodBeat.o(19521);
        return;
      }
    }
    synchronized (a.b(this.lIb))
    {
      a.b(this.lIb, ((Long)paramMessage.obj).longValue());
      AppMethodBeat.o(19521);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a.a
 * JD-Core Version:    0.7.0.1
 */