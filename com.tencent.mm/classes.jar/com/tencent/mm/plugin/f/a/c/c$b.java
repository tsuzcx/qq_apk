package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.InputStream;

public final class c$b
  implements h
{
  private final BluetoothSocket slQ;
  private b slS;
  a slT;
  private InputStream slW;
  private volatile boolean slX;
  
  public c$b(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    AppMethodBeat.i(22600);
    this.slQ = paramBluetoothSocket;
    this.slS = paramb;
    this.slT = parama;
    this.slX = false;
    this.slW = null;
    try
    {
      this.slW = paramBluetoothSocket.getInputStream();
      AppMethodBeat.o(22600);
      return;
    }
    catch (IOException paramb)
    {
      this.slW = null;
      Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[] { paramb.toString() });
      AppMethodBeat.o(22600);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(22602);
    Log.i("MicroMsg.exdevice.RecvThread", "------cancel------");
    if (this.slX)
    {
      Log.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
      AppMethodBeat.o(22602);
      return;
    }
    this.slX = true;
    try
    {
      this.slQ.close();
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
    if (this.slW == null)
    {
      Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
      AppMethodBeat.o(22601);
      return;
    }
    byte[] arrayOfByte1 = new byte[2048];
    for (;;)
    {
      if (this.slX)
      {
        Log.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        AppMethodBeat.o(22601);
        return;
      }
      try
      {
        int i = this.slW.read(arrayOfByte1);
        if (i > 0)
        {
          Log.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[] { Integer.valueOf(i) });
          Log.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Y(arrayOfByte1, i) });
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          if (this.slT != null) {
            this.slT.slJ.b(this.slS.mSessionId, arrayOfByte2);
          }
        }
      }
      catch (IOException localIOException1)
      {
        Log.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[] { localIOException1.toString() });
        try
        {
          this.slQ.close();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.c.b
 * JD-Core Version:    0.7.0.1
 */