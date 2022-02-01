package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public long mSessionId;
  public int mState;
  public BluetoothDevice oLg;
  public long slM;
  public c.a slN;
  public c.b slO;
  public c.c slP;
  
  public b(long paramLong)
  {
    AppMethodBeat.i(22594);
    this.slM = paramLong;
    this.mSessionId = paramLong;
    this.slN = null;
    this.slO = null;
    this.slP = null;
    this.mState = 0;
    this.oLg = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.HP(paramLong));
    AppMethodBeat.o(22594);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22595);
    Log.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
    this.mState = 0;
    if (this.slN != null)
    {
      this.slN.disconnect();
      this.slN = null;
    }
    if (this.slO != null)
    {
      this.slO.cancel();
      this.slO = null;
    }
    if (this.slP != null)
    {
      this.slP.cancel();
      this.slP = null;
    }
    AppMethodBeat.o(22595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.b
 * JD-Core Version:    0.7.0.1
 */