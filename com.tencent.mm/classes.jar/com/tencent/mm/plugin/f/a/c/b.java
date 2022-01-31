package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public BluetoothDevice gof;
  public long hWW;
  public c.a hWX;
  public c.b hWY;
  public c.c hWZ;
  public long mSessionId;
  public int mState;
  
  public b(long paramLong)
  {
    this.hWW = paramLong;
    this.mSessionId = paramLong;
    this.hWX = null;
    this.hWY = null;
    this.hWZ = null;
    this.mState = 0;
    this.gof = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.cM(paramLong));
  }
  
  public final void disconnect()
  {
    y.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.hWX != null)
    {
      this.hWX.disconnect();
      this.hWX = null;
    }
    if (this.hWY != null)
    {
      this.hWY.cancel();
      e.Y(this.hWY);
      this.hWY = null;
    }
    if (this.hWZ != null)
    {
      this.hWZ.cancel();
      e.Y(this.hWY);
      this.hWZ = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.b
 * JD-Core Version:    0.7.0.1
 */