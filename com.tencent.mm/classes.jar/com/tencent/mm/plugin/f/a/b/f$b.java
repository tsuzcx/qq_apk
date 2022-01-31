package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class f$b
  extends ah
{
  private final WeakReference<f> hUB;
  
  public f$b(Looper paramLooper, f paramf)
  {
    super(paramLooper);
    this.hUB = new WeakReference(paramf);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    f localf = (f)this.hUB.get();
    if (localf == null) {
      y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
    }
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          f.a(localf);
          return;
        case 4: 
          f.a(localf, paramMessage.arg1);
          return;
        }
      } while (f.a(localf, (BluetoothGatt)paramMessage.obj, paramMessage.arg1));
      y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.ee(localf.mSessionId), localf.gof.getName() });
    } while (localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1)));
    y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
    return;
    Object localObject = paramMessage.obj;
    f.b(localf, paramMessage.arg1);
    return;
    f.b(localf);
    return;
    f.a(localf, (byte[])paramMessage.obj);
    return;
    f.c(localf, paramMessage.arg1);
    return;
    f.a(localf, (BluetoothGattCharacteristic)paramMessage.obj);
    return;
    f.c(localf);
    return;
    f.d(localf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */