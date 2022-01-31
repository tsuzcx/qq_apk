package com.tencent.mm.plugin.f.a.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class b$c
  extends ah
{
  private WeakReference<b> hUB = null;
  
  public b$c(Looper paramLooper, b paramb)
  {
    super(paramLooper);
    this.hUB = new WeakReference(paramb);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    b localb = (b)this.hUB.get();
    if (localb == null)
    {
      y.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
      return;
    }
    y.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (b.j)paramMessage.obj;
      localb.hXr.j(paramMessage.hXv, paramMessage.hXw);
      return;
    case 4: 
      paramMessage = (b.f)paramMessage.obj;
      localb.hXr.i(paramMessage.hXv, paramMessage.hXw);
      return;
    case 5: 
      paramMessage = (b.g)paramMessage.obj;
      localb.hXr.cL(paramMessage.mSessionId);
      return;
    case 1: 
      paramMessage = (b.h)paramMessage.obj;
      localb.hXr.b(paramMessage.mSessionId, paramMessage.mData);
      return;
    case 2: 
      localb.hXr.nZ(paramMessage.arg1);
      return;
    case 3: 
      b.i locali = (b.i)paramMessage.obj;
      localb.hXr.a(locali.hXy, locali.gnO, paramMessage.arg1, locali.goh, locali.hXz);
      return;
    }
    paramMessage = (b.d)paramMessage.obj;
    localb.hXr.e(paramMessage.mSessionId, paramMessage.hXu, paramMessage.hUg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.d.b.c
 * JD-Core Version:    0.7.0.1
 */