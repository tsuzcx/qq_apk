package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.is;
import com.tencent.mm.f.a.it;
import com.tencent.mm.f.b.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static e noI;
  long noH;
  public MTimerHandler noJ;
  public IListener<it> noK;
  
  public e()
  {
    AppMethodBeat.i(239916);
    this.noH = 0L;
    this.noJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(239788);
        e locale = e.this;
        long l = Util.nowMilliSecond();
        g localg1 = new g();
        g localg2 = localg1.bX(locale.noH).bY(l);
        localg2.gdk = (l - locale.noH);
        localg2.gdQ = -1;
        localg2.bpa();
        h.IzE.p(1559L, 49L, 1L);
        locale.noH = 0L;
        Log.i("MicroMsg.AiFinderLogic", "can not get Finder red dot [%s]", new Object[] { localg1.agI() });
        AppMethodBeat.o(239788);
        return false;
      }
    }, false);
    this.noK = new IListener() {};
    AppMethodBeat.o(239916);
  }
  
  public static e bAZ()
  {
    AppMethodBeat.i(239922);
    if (noI == null) {
      noI = new e();
    }
    e locale = noI;
    AppMethodBeat.o(239922);
    return locale;
  }
  
  public final void yB(int paramInt)
  {
    AppMethodBeat.i(239926);
    if (paramInt > 0)
    {
      is localis = new is();
      localis.fFR.fFS = true;
      localis.fFR.fFT = 113149;
      localis.fFR.scene = paramInt;
      EventCenter.instance.publish(localis);
      this.noH = Util.nowMilliSecond();
    }
    Log.i("MicroMsg.AiFinderLogic", "start to finder sync [%d]", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(239926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */