package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.io.InputStream;

public final class c$b
  implements h
{
  private final BluetoothSocket nsh;
  private b nsj;
  a nsk;
  private InputStream nsn;
  private volatile boolean nso;
  
  public c$b(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    AppMethodBeat.i(22600);
    this.nsh = paramBluetoothSocket;
    this.nsj = paramb;
    this.nsk = parama;
    this.nso = false;
    this.nsn = null;
    try
    {
      this.nsn = paramBluetoothSocket.getInputStream();
      AppMethodBeat.o(22600);
      return;
    }
    catch (IOException paramb)
    {
      this.nsn = null;
      ac.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[] { paramb.toString() });
      AppMethodBeat.o(22600);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(22602);
    ac.i("MicroMsg.exdevice.RecvThread", "------cancel------");
    if (this.nso)
    {
      ac.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
      AppMethodBeat.o(22602);
      return;
    }
    this.nso = true;
    try
    {
      this.nsh.close();
      AppMethodBeat.o(22602);
      return;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[] { localIOException });
      AppMethodBeat.o(22602);
    }
  }
  
  public final String getKey()
  {
    return "BluetoothChatSession_recv";
  }
  
  public final void run()
  {
    AppMethodBeat.i(22601);
    ac.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
    if (this.nsn == null)
    {
      ac.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
      AppMethodBeat.o(22601);
      return;
    }
    byte[] arrayOfByte1 = new byte[2048];
    for (;;)
    {
      if (this.nso)
      {
        ac.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        AppMethodBeat.o(22601);
        return;
      }
      try
      {
        int i = this.nsn.read(arrayOfByte1);
        if (i > 0)
        {
          ac.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[] { Integer.valueOf(i) });
          ac.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.T(arrayOfByte1, i) });
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          if (this.nsk != null) {
            this.nsk.nsa.b(this.nsj.mSessionId, arrayOfByte2);
          }
        }
      }
      catch (IOException localIOException1)
      {
        ac.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[] { localIOException1.toString() });
        try
        {
          this.nsh.close();
          AppMethodBeat.o(22601);
          return;
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[] { localIOException2.toString() });
          AppMethodBeat.o(22601);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.b
 * JD-Core Version:    0.7.0.1
 */