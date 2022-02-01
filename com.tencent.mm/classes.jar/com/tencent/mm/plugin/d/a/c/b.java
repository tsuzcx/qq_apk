package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public BluetoothDevice kGR;
  public long mSessionId;
  public int mState;
  public long nSZ;
  public c.a nTa;
  public c.b nTb;
  public c.c nTc;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.nSZ = paramLong;
    this.mSessionId = paramLong;
    this.nTa = null;
    this.nTb = null;
    this.nTc = null;
    this.mState = 0;
    this.kGR = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.ti(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    ad.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.nTa != null)
    {
      this.nTa.disconnect();
      this.nTa = null;
    }
    if (this.nTb != null)
    {
      this.nTb.cancel();
      this.nTb = null;
    }
    if (this.nTc != null)
    {
      this.nTc.cancel();
      this.nTc = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */