package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class f$b
  extends ak
{
  private final WeakReference<f> jOv;
  
  public f$b(Looper paramLooper, f paramf)
  {
    super(paramLooper);
    AppMethodBeat.i(18424);
    this.jOv = new WeakReference(paramf);
    AppMethodBeat.o(18424);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(18425);
    f localf = (f)this.jOv.get();
    if (localf == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
      AppMethodBeat.o(18425);
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18425);
      return;
      f.a(localf);
      AppMethodBeat.o(18425);
      return;
      if ((localf == null) || (paramMessage == null))
      {
        AppMethodBeat.o(18425);
        return;
      }
      f.a(localf, paramMessage.arg1);
      AppMethodBeat.o(18425);
      return;
      if (!f.a(localf, (BluetoothGatt)paramMessage.obj, paramMessage.arg1))
      {
        ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.jw(localf.mSessionId), localf.hIc.getName() });
        if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1))) {
          ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
        }
        AppMethodBeat.o(18425);
        return;
        Object localObject = paramMessage.obj;
        f.b(localf, paramMessage.arg1);
        AppMethodBeat.o(18425);
        return;
        f.b(localf);
        AppMethodBeat.o(18425);
        return;
        f.a(localf, (byte[])paramMessage.obj);
        AppMethodBeat.o(18425);
        return;
        f.c(localf, paramMessage.arg1);
        AppMethodBeat.o(18425);
        return;
        f.a(localf, (BluetoothGattCharacteristic)paramMessage.obj);
        AppMethodBeat.o(18425);
        return;
        f.c(localf);
        AppMethodBeat.o(18425);
        return;
        f.d(localf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */