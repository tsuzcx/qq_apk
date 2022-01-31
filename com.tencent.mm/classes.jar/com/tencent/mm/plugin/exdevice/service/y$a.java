package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.e;
import com.tencent.mm.plugin.d.a.b.e.5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class y$a
  extends ak
{
  public y$a(y paramy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(19657);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19657);
      return;
      paramMessage = (y.d)paramMessage.obj;
      y.a(this.lJc, paramMessage.lIf, paramMessage.lCE, paramMessage.lCs, paramMessage.hyJ);
      AppMethodBeat.o(19657);
      return;
      paramMessage = (y.k)paramMessage.obj;
      if (!y.a(this.lJc, paramMessage.lIf, paramMessage.lJk)) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
      }
      AppMethodBeat.o(19657);
      return;
      long l = ((Long)paramMessage.obj).longValue();
      if (!y.a(this.lJc, l)) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
      }
      AppMethodBeat.o(19657);
      return;
      paramMessage = (y.c)paramMessage.obj;
      y.a(this.lJc, paramMessage.jRn, paramMessage.lId, paramMessage.lIe, paramMessage.lCs);
      AppMethodBeat.o(19657);
      return;
      paramMessage = (y.j)paramMessage.obj;
      if (!y.a(this.lJc, paramMessage.jRn, paramMessage.lJj, paramMessage.lJf)) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
      }
      AppMethodBeat.o(19657);
      return;
      if (!y.b(this.lJc, ((Long)paramMessage.obj).longValue()))
      {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.b)paramMessage.obj;
        y.a(this.lJc, paramMessage.mErrorCode, paramMessage.jRn, paramMessage.lCz, paramMessage.lIc, paramMessage.lCt);
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.e)paramMessage.obj;
        if (!this.lJc.c(paramMessage.lFs, paramMessage.lJe, paramMessage.lJf)) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
        }
        AppMethodBeat.o(19657);
        return;
        l = ((Long)paramMessage.obj).longValue();
        paramMessage = this.lJc;
        ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[] { Long.valueOf(l) });
        if (paramMessage.lJa != null)
        {
          paramMessage = paramMessage.lJa;
          ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[] { Long.valueOf(l) });
          if (!paramMessage.aVT())
          {
            ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
            AppMethodBeat.o(19657);
            return;
          }
          paramMessage.N(new e.5(paramMessage, l));
        }
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.c)paramMessage.obj;
        if (!this.lJc.b(paramMessage.jRn, paramMessage.lId, paramMessage.lIe, paramMessage.lCs, paramMessage.jOK)) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
        }
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.i)paramMessage.obj;
        if (!this.lJc.c(paramMessage.lFs, paramMessage.mData, paramMessage.lJi)) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
        }
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.h)paramMessage.obj;
        if (!this.lJc.e(paramMessage.lFs, paramMessage.lCE, paramMessage.lCs, paramMessage.hyJ)) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
        }
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.f)paramMessage.obj;
        this.lJc.d(paramMessage.lFs, paramMessage.mData);
        AppMethodBeat.o(19657);
        return;
        paramMessage = (y.g)paramMessage.obj;
        y.a(this.lJc, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.a
 * JD-Core Version:    0.7.0.1
 */