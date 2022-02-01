package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public abstract interface e
{
  public abstract void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic);
  
  public abstract void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt);
  
  public abstract void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt);
  
  public abstract void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
  
  public abstract void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt);
  
  public abstract void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt);
  
  public abstract void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
  
  public abstract void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
  
  public abstract void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt);
  
  public abstract void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */