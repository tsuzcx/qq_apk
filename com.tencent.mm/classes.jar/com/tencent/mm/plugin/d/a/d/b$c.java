package com.tencent.mm.plugin.d.a.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class b$c
  extends ak
{
  private WeakReference<b> jOv;
  
  public b$c(Looper paramLooper, b paramb)
  {
    super(paramLooper);
    AppMethodBeat.i(18511);
    this.jOv = null;
    this.jOv = new WeakReference(paramb);
    AppMethodBeat.o(18511);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(18512);
    b localb = (b)this.jOv.get();
    if (localb == null)
    {
      ab.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
      AppMethodBeat.o(18512);
      return;
    }
    ab.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18512);
      return;
      paramMessage = (b.f)paramMessage.obj;
      localb.jRk.l(paramMessage.jRo, paramMessage.jRp);
      AppMethodBeat.o(18512);
      return;
      paramMessage = (b.g)paramMessage.obj;
      localb.jRk.hN(paramMessage.mSessionId);
      AppMethodBeat.o(18512);
      return;
      paramMessage = (b.h)paramMessage.obj;
      localb.jRk.b(paramMessage.mSessionId, paramMessage.mData);
      AppMethodBeat.o(18512);
      return;
      localb.jRk.rN(paramMessage.arg1);
      AppMethodBeat.o(18512);
      return;
      b.i locali = (b.i)paramMessage.obj;
      localb.jRk.a(locali.jRr, locali.mDeviceName, paramMessage.arg1, locali.hIe, locali.jRs);
      AppMethodBeat.o(18512);
      return;
      paramMessage = (b.j)paramMessage.obj;
      localb.jRk.m(paramMessage.jRo, paramMessage.jRp);
      AppMethodBeat.o(18512);
      return;
      paramMessage = (b.d)paramMessage.obj;
      localb.jRk.f(paramMessage.mSessionId, paramMessage.jRn, paramMessage.jOa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.d.b.c
 * JD-Core Version:    0.7.0.1
 */