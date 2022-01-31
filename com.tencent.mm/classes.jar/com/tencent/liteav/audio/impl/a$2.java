package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$2
  implements BluetoothProfile.ServiceListener
{
  a$2(a parama) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    AppMethodBeat.i(66705);
    TXCLog.i(a.a(this.a), "onServiceConnected, profile = ".concat(String.valueOf(paramInt)));
    if (paramInt != 1)
    {
      TXCLog.e(a.a(this.a), "profile not HEADSET, ignore");
      AppMethodBeat.o(66705);
      return;
    }
    a.a(this.a, (BluetoothHeadset)paramBluetoothProfile);
    a.b(this.a);
    AppMethodBeat.o(66705);
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    AppMethodBeat.i(66706);
    TXCLog.i(a.a(this.a), "onServiceDisconnected, profile = ".concat(String.valueOf(paramInt)));
    if (paramInt != 1)
    {
      TXCLog.e(a.a(this.a), "profile not HEADSET, ignore");
      AppMethodBeat.o(66706);
      return;
    }
    a.a(this.a, null);
    this.a.b(a.c(this.a));
    AppMethodBeat.o(66706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.2
 * JD-Core Version:    0.7.0.1
 */