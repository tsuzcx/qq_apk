package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public long mSessionId;
  public int mState;
  public BluetoothDevice rOZ;
  public long vxL;
  public c.a vxM;
  public c.b vxN;
  public c.c vxO;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.vxL = paramLong;
    this.mSessionId = paramLong;
    this.vxM = null;
    this.vxN = null;
    this.vxO = null;
    this.mState = 0;
    this.rOZ = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.kg(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    Log.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.vxM != null)
    {
      this.vxM.disconnect();
      this.vxM = null;
    }
    if (this.vxN != null)
    {
      this.vxN.cancel();
      this.vxN = null;
    }
    if (this.vxO != null)
    {
      this.vxO.cancel();
      this.vxO = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.c.b
 * JD-Core Version:    0.7.0.1
 */