package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

final class e$1
  implements c.a
{
  e$1(e parame) {}
  
  public final void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18403);
    long l = b.LX(paramBluetoothDevice.getAddress());
    if (!this.jOA.jOx.contains(Long.valueOf(l)))
    {
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramBluetoothDevice.getName(), paramBluetoothDevice.getAddress(), Long.valueOf(l), b.aO(paramArrayOfByte) });
      this.jOA.jOx.add(Long.valueOf(l));
      if (c.at(paramArrayOfByte)) {
        this.jOA.jOw.a(paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), paramInt, paramArrayOfByte);
      }
    }
    AppMethodBeat.o(18403);
  }
  
  public final void aVU()
  {
    AppMethodBeat.i(18404);
    ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
    if (this.jOA.jOw != null) {
      this.jOA.jOw.aVU();
    }
    for (;;)
    {
      this.jOA.jOx.clear();
      AppMethodBeat.o(18404);
      return;
      ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e.1
 * JD-Core Version:    0.7.0.1
 */