package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.el;
import com.tencent.mm.plugin.exdevice.service.n.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n.a
{
  private static final a qgV;
  
  static
  {
    AppMethodBeat.i(23196);
    qgV = new a();
    AppMethodBeat.o(23196);
  }
  
  public static a cmn()
  {
    return qgV;
  }
  
  public final Bundle o(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(23195);
    ae.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle == null)
    {
      ae.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
      AppMethodBeat.o(23195);
      return null;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(23195);
      return null;
    }
    if (paramBundle == null) {
      ae.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
    }
    for (;;)
    {
      AppMethodBeat.o(23195);
      return null;
      paramInt = paramBundle.getInt("key_state");
      ae.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
      if (-1 == paramInt)
      {
        ae.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
      }
      else
      {
        paramBundle = new el();
        paramBundle.dqI.dqJ = paramInt;
        if (!com.tencent.mm.sdk.b.a.IvT.l(paramBundle)) {
          ae.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.a
 * JD-Core Version:    0.7.0.1
 */