package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class d$1
  extends BluetoothGattCallback
{
  d$1(d paramd) {}
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(18390);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
    if (!this.jOu.mHandler.sendMessage(this.jOu.mHandler.obtainMessage(8, paramBluetoothGattCharacteristic.getValue()))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(18390);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(18391);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(18391);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(18392);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!this.jOu.mHandler.sendMessage(this.jOu.mHandler.obtainMessage(7, paramInt, 0))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
    }
    AppMethodBeat.o(18392);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18387);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(this.jOu.jOs) });
    if (!this.jOu.mHandler.sendMessage(this.jOu.mHandler.obtainMessage(4, paramInt2, 0))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
    }
    AppMethodBeat.o(18387);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(18389);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!this.jOu.mHandler.sendMessage(this.jOu.mHandler.obtainMessage(6, paramInt, 0, paramBluetoothGatt))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
    }
    AppMethodBeat.o(18389);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(18388);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!this.jOu.mHandler.sendMessage(this.jOu.mHandler.obtainMessage(5, paramInt, 0, paramBluetoothGatt))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(18388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d.1
 * JD-Core Version:    0.7.0.1
 */