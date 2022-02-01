package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public BluetoothDevice kKg;
  public long mSessionId;
  public int mState;
  public long nYF;
  public c.a nYG;
  public c.b nYH;
  public c.c nYI;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.nYF = paramLong;
    this.mSessionId = paramLong;
    this.nYG = null;
    this.nYH = null;
    this.nYI = null;
    this.mState = 0;
    this.kKg = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.tw(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    ae.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.nYG != null)
    {
      this.nYG.disconnect();
      this.nYG = null;
    }
    if (this.nYH != null)
    {
      this.nYH.cancel();
      this.nYH = null;
    }
    if (this.nYI != null)
    {
      this.nYI.cancel();
      this.nYI = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */