package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

@TargetApi(18)
public final class a
  extends BluetoothGattCallback
{
  public e gmd;
  
  public a(e parame)
  {
    this.gmd = parame;
  }
  
  public final void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    this.gmd.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
  }
  
  public final void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    this.gmd.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public final void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    this.gmd.onCharacteristicWrite(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public final void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.gmd.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public final void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    this.gmd.onDescriptorRead(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public final void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    this.gmd.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public final void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.gmd.onMtuChanged(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public final void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.gmd.onReadRemoteRssi(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public final void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    this.gmd.onReliableWriteCompleted(paramBluetoothGatt, paramInt);
  }
  
  public final void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    this.gmd.onServicesDiscovered(paramBluetoothGatt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */