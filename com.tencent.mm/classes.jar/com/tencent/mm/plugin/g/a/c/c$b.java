package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.h;
import java.io.IOException;
import java.io.InputStream;

public final class c$b
  implements h
{
  private final BluetoothSocket vxP;
  private b vxR;
  a vxS;
  private InputStream vxV;
  private volatile boolean vxW;
  
  public c$b(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    AppMethodBeat.i(22600);
    this.vxP = paramBluetoothSocket;
    this.vxR = paramb;
    this.vxS = parama;
    this.vxW = false;
    this.vxV = null;
    try
    {
      this.vxV = paramBluetoothSocket.getInputStream();
      AppMethodBeat.o(22600);
      return;
    }
    catch (IOException paramb)
    {
      this.vxV = null;
      Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[] { paramb.toString() });
      AppMethodBeat.o(22600);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(22602);
    Log.i("MicroMsg.exdevice.RecvThread", "------cancel------");
    if (this.vxW)
    {
      Log.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
      AppMethodBeat.o(22602);
      return;
    }
    this.vxW = true;
    try
    {
      this.vxP.close();
      AppMethodBeat.o(22602);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[] { localIOException });
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
    Log.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
    if (this.vxV == null)
    {
      Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
      AppMethodBeat.o(22601);
      return;
    }
    byte[] arrayOfByte1 = new byte[2048];
    for (;;)
    {
      if (this.vxW)
      {
        Log.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        AppMethodBeat.o(22601);
        return;
      }
      try
      {
        int i = this.vxV.read(arrayOfByte1);
        if (i > 0)
        {
          Log.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[] { Integer.valueOf(i) });
          Log.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.W(arrayOfByte1, i) });
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          if (this.vxS != null) {
            this.vxS.vxI.c(this.vxR.mSessionId, arrayOfByte2);
          }
        }
      }
      catch (IOException localIOException1)
      {
        Log.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[] { localIOException1.toString() });
        try
        {
          this.vxP.close();
          AppMethodBeat.o(22601);
          return;
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[] { localIOException2.toString() });
          AppMethodBeat.o(22601);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.c.c.b
 * JD-Core Version:    0.7.0.1
 */