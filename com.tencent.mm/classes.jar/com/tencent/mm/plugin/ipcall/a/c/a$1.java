package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends ah
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 59998)) {
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
        y.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.obj, Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
        switch (paramMessage.arg1)
        {
        case 7: 
        case 8: 
        default: 
          return;
        case 3: 
          y.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
          return;
        case 6: 
          paramMessage = this.lqM;
          y.d("MicroMsg.IPCallEngineManager", "channel connect!");
          if (paramMessage.lqJ)
          {
            y.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
            return;
          }
          int i = paramMessage.lqG.startEngine();
          y.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[] { Integer.valueOf(i) });
          if (i == 0) {}
          for (paramMessage.lqG.pVb = 0;; paramMessage.lqG.pVb = 1)
          {
            paramMessage.lqG.setInactive();
            paramMessage.lqJ = true;
            if (paramMessage.lqL == null) {
              break;
            }
            paramMessage.lqL.bbF();
            return;
          }
        case 4: 
          y.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
          paramMessage = this.lqM;
          y.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
        }
      } while (paramMessage.lqL == null);
      paramMessage.lqL.bbE();
      return;
      y.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
      if (paramMessage.arg2 == 4)
      {
        y.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
        a.a(this.lqM, 34);
        return;
      }
      if (paramMessage.arg2 == 1)
      {
        y.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
        a.a(this.lqM, 20);
        return;
      }
    } while (paramMessage.arg2 != 5);
    y.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
    a.a(this.lqM, 30);
    return;
    y.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
    return;
    y.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
    y.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
    paramMessage = i.bcg();
    y.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
    if (paramMessage.bWb)
    {
      y.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
      return;
    }
    paramMessage.loY = true;
    if (paramMessage.loW != null)
    {
      paramMessage.loW.goN = 2;
      o localo = new o(paramMessage.loW.lpD, paramMessage.loW.lpE, paramMessage.loW.bcw(), paramMessage.loW.lpF, true);
      au.Dk().a(localo, 0);
    }
    paramMessage.sH(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */