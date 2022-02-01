package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public BluetoothDevice jLq;
  public long mPS;
  public c.a mPT;
  public c.b mPU;
  public c.c mPV;
  public long mSessionId;
  public int mState;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.mPS = paramLong;
    this.mSessionId = paramLong;
    this.mPT = null;
    this.mPU = null;
    this.mPV = null;
    this.mState = 0;
    this.jLq = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.ny(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    ad.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.mPT != null)
    {
      this.mPT.disconnect();
      this.mPT = null;
    }
    if (this.mPU != null)
    {
      this.mPU.cancel();
      this.mPU = null;
    }
    if (this.mPV != null)
    {
      this.mPV.cancel();
      this.mPV = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */