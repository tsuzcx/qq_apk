package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ev;
import com.tencent.mm.plugin.exdevice.service.n.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends n.a
{
  private static final a vdx;
  
  static
  {
    AppMethodBeat.i(23196);
    vdx = new a();
    AppMethodBeat.o(23196);
  }
  
  public static a cYZ()
  {
    return vdx;
  }
  
  public final Bundle p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(23195);
    Log.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle == null)
    {
      Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
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
      Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
    }
    for (;;)
    {
      AppMethodBeat.o(23195);
      return null;
      paramInt = paramBundle.getInt("key_state");
      Log.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
      if (-1 == paramInt)
      {
        Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
      }
      else
      {
        paramBundle = new ev();
        paramBundle.fAM.fAN = paramInt;
        if (!EventCenter.instance.publish(paramBundle)) {
          Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.a
 * JD-Core Version:    0.7.0.1
 */