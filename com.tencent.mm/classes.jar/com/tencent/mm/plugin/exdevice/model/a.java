package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.plugin.exdevice.service.n.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends n.a
{
  private static final a lCO;
  
  static
  {
    AppMethodBeat.i(19088);
    lCO = new a();
    AppMethodBeat.o(19088);
  }
  
  public static a bpD()
  {
    return lCO;
  }
  
  public final Bundle m(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(19087);
    ab.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramBundle == null)
    {
      ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
      AppMethodBeat.o(19087);
      return null;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(19087);
      return null;
    }
    if (paramBundle == null) {
      ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
    }
    for (;;)
    {
      AppMethodBeat.o(19087);
      return null;
      paramInt = paramBundle.getInt("key_state");
      ab.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
      if (-1 == paramInt)
      {
        ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
      }
      else
      {
        paramBundle = new ea();
        paramBundle.crQ.crR = paramInt;
        if (!com.tencent.mm.sdk.b.a.ymk.l(paramBundle)) {
          ab.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.a
 * JD-Core Version:    0.7.0.1
 */