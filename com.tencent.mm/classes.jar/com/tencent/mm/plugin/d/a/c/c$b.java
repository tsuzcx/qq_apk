package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.InputStream;

public final class c$b
  implements Runnable
{
  private final BluetoothSocket jQT;
  private b jQV;
  a jQW;
  private InputStream jQZ;
  private volatile boolean jRa;
  
  public c$b(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    AppMethodBeat.i(18489);
    this.jQT = paramBluetoothSocket;
    this.jQV = paramb;
    this.jQW = parama;
    this.jRa = false;
    this.jQZ = null;
    try
    {
      this.jQZ = paramBluetoothSocket.getInputStream();
      AppMethodBeat.o(18489);
      return;
    }
    catch (IOException paramb)
    {
      this.jQZ = null;
      ab.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[] { paramb.toString() });
      AppMethodBeat.o(18489);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(18491);
    ab.i("MicroMsg.exdevice.RecvThread", "------cancel------");
    if (this.jRa)
    {
      ab.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
      AppMethodBeat.o(18491);
      return;
    }
    this.jRa = true;
    try
    {
      this.jQT.close();
      AppMethodBeat.o(18491);
      return;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[] { localIOException });
      AppMethodBeat.o(18491);
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(18490);
    ab.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
    if (this.jQZ == null)
    {
      ab.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
      AppMethodBeat.o(18490);
      return;
    }
    byte[] arrayOfByte1 = new byte[2048];
    for (;;)
    {
      if (this.jRa)
      {
        ab.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        AppMethodBeat.o(18490);
        return;
      }
      try
      {
        int i = this.jQZ.read(arrayOfByte1);
        if (i > 0)
        {
          ab.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[] { Integer.valueOf(i) });
          ab.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.R(arrayOfByte1, i) });
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          if (this.jQW != null) {
            this.jQW.jQL.b(this.jQV.mSessionId, arrayOfByte2);
          }
        }
      }
      catch (IOException localIOException1)
      {
        ab.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[] { localIOException1.toString() });
        try
        {
          this.jQT.close();
          AppMethodBeat.o(18490);
          return;
        }
        catch (IOException localIOException2)
        {
          ab.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[] { localIOException2.toString() });
          AppMethodBeat.o(18490);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.b
 * JD-Core Version:    0.7.0.1
 */