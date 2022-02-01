package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(18)
public final class a
  extends BluetoothGattCallback
{
  public e kjE;
  
  public a(e parame)
  {
    this.kjE = parame;
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    AppMethodBeat.i(144536);
    this.kjE.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
    AppMethodBeat.o(144536);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144534);
    this.kjE.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    AppMethodBeat.o(144534);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    AppMethodBeat.i(144535);
    this.kjE.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    AppMethodBeat.o(144535);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144532);
    this.kjE.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144532);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144537);
    this.kjE.onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    AppMethodBeat.o(144537);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    AppMethodBeat.i(144538);
    this.kjE.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    AppMethodBeat.o(144538);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144541);
    this.kjE.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144541);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144540);
    this.kjE.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
    AppMethodBeat.o(144540);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144539);
    this.kjE.onReliableWriteCompleted(paramBluetoothGatt, paramInt);
    AppMethodBeat.o(144539);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    AppMethodBeat.i(144533);
    this.kjE.onServicesDiscovered(paramBluetoothGatt, paramInt);
    AppMethodBeat.o(144533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */