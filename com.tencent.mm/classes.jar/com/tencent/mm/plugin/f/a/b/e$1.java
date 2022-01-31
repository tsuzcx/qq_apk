package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.f.a.b.a.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class e$1
  implements c.a
{
  e$1(e parame) {}
  
  public final void awr()
  {
    y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
    if (this.hUG.hUC != null) {
      this.hUG.hUC.awr();
    }
    for (;;)
    {
      this.hUG.hUD.clear();
      return;
      y.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
    }
  }
  
  public final void b(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    long l = b.BU(paramBluetoothDevice.getAddress());
    if (!this.hUG.hUD.contains(Long.valueOf(l)))
    {
      y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[] { paramBluetoothDevice.getName(), paramBluetoothDevice.getAddress(), Long.valueOf(l), b.aq(paramArrayOfByte) });
      this.hUG.hUD.add(Long.valueOf(l));
      if (c.aa(paramArrayOfByte)) {
        this.hUG.hUC.a(paramBluetoothDevice.getAddress(), paramBluetoothDevice.getName(), paramInt, paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.e.1
 * JD-Core Version:    0.7.0.1
 */