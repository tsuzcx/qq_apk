package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$d
  extends h
{
  d$d(d paramd, i parami)
  {
    super(parami);
  }
  
  public final void enter()
  {
    AppMethodBeat.i(86854);
    super.enter();
    this.gYv.yrd.sendEmptyMessageDelayed(d.a.gYC.intValue, this.gYv.gRG.wY().hiV * 1000L);
    AppMethodBeat.o(86854);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(86855);
    super.exit();
    this.gYv.yrd.removeMessages(d.a.gYC.intValue);
    AppMethodBeat.o(86855);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(86852);
    AppMethodBeat.o(86852);
    return "|BackgroundTemporary";
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(86853);
    switch (d.7.gYy[d.a.no(paramMessage.what).ordinal()])
    {
    default: 
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(86853);
      return bool;
    case 2: 
      if (this.gYv.gRG.isInBackStack())
      {
        paramMessage = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(paramMessage);
        com.tencent.luggage.g.d.i(this.gYv.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", new Object[] { Integer.valueOf(paramMessage.importance) });
        if (paramMessage.importance == 100)
        {
          d.a(this.gYv, this.gYv.gYq);
          AppMethodBeat.o(86853);
          return true;
        }
      }
      d.a(this.gYv, this.gYv.gYo);
      AppMethodBeat.o(86853);
      return true;
    case 3: 
      com.tencent.luggage.g.d.i(this.gYv.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
      d.a(this.gYv, this.gYv.gYq);
      AppMethodBeat.o(86853);
      return true;
    }
    d.a(this.gYv, this.gYv.gYm);
    AppMethodBeat.o(86853);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.d
 * JD-Core Version:    0.7.0.1
 */