package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class a$1
  extends ak
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(21822);
    if ((paramMessage == null) || (paramMessage.what != 59998))
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(21822);
      return;
    }
    ab.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj, Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21822);
      return;
      paramMessage = this.nOi;
      ab.d("MicroMsg.IPCallEngineManager", "channel connect!");
      if (paramMessage.nOf)
      {
        ab.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
        AppMethodBeat.o(21822);
        return;
      }
      int i = paramMessage.nOc.startEngine();
      ab.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
      if (i == 0) {}
      for (paramMessage.nOc.tAD = 0;; paramMessage.nOc.tAD = 1)
      {
        paramMessage.nOc.setInactive();
        paramMessage.nOf = true;
        if (paramMessage.nOh != null) {
          paramMessage.nOh.bIN();
        }
        AppMethodBeat.o(21822);
        return;
      }
      ab.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
      AppMethodBeat.o(21822);
      return;
      ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
      paramMessage = this.nOi;
      ab.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
      if (paramMessage.nOh != null) {
        paramMessage.nOh.bIM();
      }
      AppMethodBeat.o(21822);
      return;
      ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
      if (paramMessage.arg2 == 4)
      {
        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
        a.a(this.nOi, 34);
        AppMethodBeat.o(21822);
        return;
      }
      if (paramMessage.arg2 == 1)
      {
        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
        a.a(this.nOi, 20);
        AppMethodBeat.o(21822);
        return;
      }
      if (paramMessage.arg2 == 5)
      {
        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
        a.a(this.nOi, 30);
        AppMethodBeat.o(21822);
        return;
        ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
        AppMethodBeat.o(21822);
        return;
        ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
        ab.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
        paramMessage = i.bJn();
        ab.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
        if (paramMessage.cDO)
        {
          ab.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
          AppMethodBeat.o(21822);
          return;
        }
        paramMessage.nMu = true;
        if (paramMessage.nMs != null)
        {
          paramMessage.nMs.hIJ = 2;
          o localo = new o(paramMessage.nMs.nMZ, paramMessage.nMs.nNa, paramMessage.nMs.bJD(), paramMessage.nMs.nNb, true);
          aw.Rc().a(localo, 0);
        }
        paramMessage.xI(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */