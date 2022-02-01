package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public BluetoothDevice klR;
  public long mSessionId;
  public int mState;
  public long nsd;
  public c.a nse;
  public c.b nsf;
  public c.c nsg;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.nsd = paramLong;
    this.mSessionId = paramLong;
    this.nse = null;
    this.nsf = null;
    this.nsg = null;
    this.mState = 0;
    this.klR = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.rk(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    ac.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.nse != null)
    {
      this.nse.disconnect();
      this.nse = null;
    }
    if (this.nsf != null)
    {
      this.nsf.cancel();
      this.nsf = null;
    }
    if (this.nsg != null)
    {
      this.nsg.cancel();
      this.nsg = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */