package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.plugin.exdevice.service.n.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n.a
{
  private static final a pwL;
  
  static
  {
    AppMethodBeat.i(23196);
    pwL = new a();
    AppMethodBeat.o(23196);
  }
  
  public static a cgt()
  {
    return pwL;
  }
  
  public final Bundle o(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(23195);
    ac.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle == null)
    {
      ac.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
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
      ac.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
    }
    for (;;)
    {
      AppMethodBeat.o(23195);
      return null;
      paramInt = paramBundle.getInt("key_state");
      ac.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
      if (-1 == paramInt)
      {
        ac.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
      }
      else
      {
        paramBundle = new eh();
        paramBundle.deh.dei = paramInt;
        if (!com.tencent.mm.sdk.b.a.GpY.l(paramBundle)) {
          ac.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.a
 * JD-Core Version:    0.7.0.1
 */