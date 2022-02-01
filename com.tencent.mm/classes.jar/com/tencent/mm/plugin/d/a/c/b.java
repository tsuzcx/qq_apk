package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public BluetoothDevice lOM;
  public long mSessionId;
  public int mState;
  public long pjD;
  public c.a pjE;
  public c.b pjF;
  public c.c pjG;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.pjD = paramLong;
    this.mSessionId = paramLong;
    this.pjE = null;
    this.pjF = null;
    this.pjG = null;
    this.mState = 0;
    this.lOM = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.BC(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    Log.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.pjE != null)
    {
      this.pjE.disconnect();
      this.pjE = null;
    }
    if (this.pjF != null)
    {
      this.pjF.cancel();
      this.pjF = null;
    }
    if (this.pjG != null)
    {
      this.pjG.cancel();
      this.pjG = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.b
 * JD-Core Version:    0.7.0.1
 */