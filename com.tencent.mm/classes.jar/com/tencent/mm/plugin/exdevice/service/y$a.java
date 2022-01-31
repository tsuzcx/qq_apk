package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.f.a.b.e;
import com.tencent.mm.plugin.f.a.b.e.5;
import com.tencent.mm.sdk.platformtools.ah;

final class y$a
  extends ah
{
  public y$a(y paramy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 0: 
    case 1: 
    case 5: 
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          do
          {
            long l;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        paramMessage = (y.d)paramMessage.obj;
                        y.a(this.jzD, paramMessage.jyG, paramMessage.jtf, paramMessage.jsT, paramMessage.ghs);
                        return;
                        paramMessage = (y.k)paramMessage.obj;
                      } while (y.a(this.jzD, paramMessage.jyG, paramMessage.jzL));
                      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                      return;
                      l = ((Long)paramMessage.obj).longValue();
                    } while (y.a(this.jzD, l));
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    return;
                    paramMessage = (y.c)paramMessage.obj;
                    y.a(this.jzD, paramMessage.hXu, paramMessage.jyE, paramMessage.jyF, paramMessage.jsT);
                    return;
                    paramMessage = (y.j)paramMessage.obj;
                  } while (y.a(this.jzD, paramMessage.hXu, paramMessage.jzK, paramMessage.jzG));
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                  return;
                } while (y.b(this.jzD, ((Long)paramMessage.obj).longValue()));
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                return;
                paramMessage = (y.b)paramMessage.obj;
                y.a(this.jzD, paramMessage.mErrorCode, paramMessage.hXu, paramMessage.jta, paramMessage.jyD, paramMessage.jsU);
                return;
                paramMessage = (y.e)paramMessage.obj;
              } while (this.jzD.c(paramMessage.jvT, paramMessage.jzF, paramMessage.jzG));
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
              return;
              l = ((Long)paramMessage.obj).longValue();
              paramMessage = this.jzD;
              com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[] { Long.valueOf(l) });
            } while (paramMessage.jzB == null);
            paramMessage = paramMessage.jzB;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[] { Long.valueOf(l) });
            if (!paramMessage.awq())
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
              return;
            }
            paramMessage.G(new e.5(paramMessage, l));
            return;
            paramMessage = (y.c)paramMessage.obj;
          } while (this.jzD.b(paramMessage.hXu, paramMessage.jyE, paramMessage.jyF, paramMessage.jsT, paramMessage.hUQ));
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
          return;
          paramMessage = (y.i)paramMessage.obj;
        } while (this.jzD.c(paramMessage.jvT, paramMessage.mData, paramMessage.jzJ));
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
        return;
        paramMessage = (y.h)paramMessage.obj;
      } while (this.jzD.e(paramMessage.jvT, paramMessage.jtf, paramMessage.jsT, paramMessage.ghs));
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
      return;
    case 12: 
      paramMessage = (y.f)paramMessage.obj;
      this.jzD.d(paramMessage.jvT, paramMessage.mData);
      return;
    }
    paramMessage = (y.g)paramMessage.obj;
    y.a(this.jzD, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.a
 * JD-Core Version:    0.7.0.1
 */