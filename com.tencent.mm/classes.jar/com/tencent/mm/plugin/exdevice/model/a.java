package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.mm.h.a.dx;
import com.tencent.mm.plugin.exdevice.service.n.a;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends n.a
{
  private static final a jtp = new a();
  
  public static a aLq()
  {
    return jtp;
  }
  
  public final Bundle j(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle == null) {
      y.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
    }
    do
    {
      return null;
      switch (paramInt)
      {
      default: 
        return null;
      }
      if (paramBundle == null)
      {
        y.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        return null;
      }
      paramInt = paramBundle.getInt("key_state");
      y.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
      if (-1 == paramInt)
      {
        y.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
        return null;
      }
      paramBundle = new dx();
      paramBundle.bKw.bKx = paramInt;
    } while (com.tencent.mm.sdk.b.a.udP.m(paramBundle));
    y.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.a
 * JD-Core Version:    0.7.0.1
 */