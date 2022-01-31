package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public BluetoothDevice hIc;
  public long jQP;
  public c.a jQQ;
  public c.b jQR;
  public c.c jQS;
  public long mSessionId;
  public int mState;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(18483);
    this.jQP = paramLong;
    this.mSessionId = paramLong;
    this.jQQ = null;
    this.jQR = null;
    this.jQS = null;
    this.mState = 0;
    this.hIc = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.hO(paramLong));
    AppMethodBeat.o(18483);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(18484);
    ab.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.jQQ != null)
    {
      this.jQQ.disconnect();
      this.jQQ = null;
    }
    if (this.jQR != null)
    {
      this.jQR.cancel();
      this.jQR = null;
    }
    if (this.jQS != null)
    {
      this.jQS.cancel();
      this.jQS = null;
    }
    AppMethodBeat.o(18484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */