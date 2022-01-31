package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class f$1
  extends BluetoothGattCallback
{
  f$1(f paramf) {}
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(18418);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
    if (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(8, paramBluetoothGattCharacteristic))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(18418);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(18419);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(8, paramBluetoothGattCharacteristic)))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(18419);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(18420);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(7, paramInt, 0))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
    }
    AppMethodBeat.o(18420);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18415);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(f.e(this.jOO)) });
    if (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(4, paramInt2, 0))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
    }
    AppMethodBeat.o(18415);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(18417);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(6, paramInt, 0, paramBluetoothGatt))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
    }
    AppMethodBeat.o(18417);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(18416);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.jOO).sendMessage(f.f(this.jOO).obtainMessage(5, paramInt, 0, paramBluetoothGatt))) {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(18416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f.1
 * JD-Core Version:    0.7.0.1
 */