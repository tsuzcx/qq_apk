package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class f$1
  extends BluetoothGattCallback
{
  f$1(f paramf) {}
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(22529);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
    if (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(8, paramBluetoothGattCharacteristic))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(22529);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(22530);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(8, paramBluetoothGattCharacteristic)))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(22530);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(22531);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(7, paramInt, 0))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
    }
    AppMethodBeat.o(22531);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22526);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(f.e(this.vvL)) });
    if (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(4, paramInt2, 0))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
    }
    AppMethodBeat.o(22526);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(22528);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(6, paramInt, 0, paramBluetoothGatt))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
    }
    AppMethodBeat.o(22528);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(22527);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!f.f(this.vvL).sendMessage(f.f(this.vvL).obtainMessage(5, paramInt, 0, paramBluetoothGatt))) {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(22527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.f.1
 * JD-Core Version:    0.7.0.1
 */