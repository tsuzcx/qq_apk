package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements g.a
{
  b$3(b paramb) {}
  
  public final void b(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramBluetoothDevice.getName(), paramBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.BU(paramBluetoothDevice.getAddress())) });
    this.hUb.mHandler.post(new b.3.1(this, paramBluetoothDevice, paramInt, paramArrayOfByte));
  }
  
  public final void oa(int paramInt)
  {
    y.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 1) {
      this.hUb.mHandler.post(new b.3.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.b.3
 * JD-Core Version:    0.7.0.1
 */