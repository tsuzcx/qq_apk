package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class b$3
  implements g.a
{
  b$3(b paramb) {}
  
  public final void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18368);
    ab.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[] { paramBluetoothDevice.getName(), paramBluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.LX(paramBluetoothDevice.getAddress())) });
    this.jNV.mHandler.post(new b.3.1(this, paramBluetoothDevice, paramInt, paramArrayOfByte));
    AppMethodBeat.o(18368);
  }
  
  public final void rO(int paramInt)
  {
    AppMethodBeat.i(18369);
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 1) {
      this.jNV.mHandler.post(new b.3.2(this));
    }
    AppMethodBeat.o(18369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b.3
 * JD-Core Version:    0.7.0.1
 */