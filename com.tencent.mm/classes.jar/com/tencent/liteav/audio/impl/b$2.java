package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import java.util.List;

class b$2
  implements BluetoothProfile.ServiceListener
{
  b$2(b paramb) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      b.a(this.a, (BluetoothHeadset)paramBluetoothProfile);
      paramBluetoothProfile = b.b(this.a).getConnectedDevices();
      if ((paramBluetoothProfile != null) && (paramBluetoothProfile.size() > 0))
      {
        paramBluetoothProfile = (BluetoothDevice)paramBluetoothProfile.get(0);
        b.a(this.a, paramBluetoothProfile);
      }
    }
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    if (paramInt == 1) {
      b.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.b.2
 * JD-Core Version:    0.7.0.1
 */