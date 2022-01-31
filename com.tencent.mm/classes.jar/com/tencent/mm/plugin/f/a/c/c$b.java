package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;

public final class c$b
  implements Runnable
{
  private final BluetoothSocket hXa;
  private b hXc;
  a hXd;
  private InputStream hXg;
  private volatile boolean hXh;
  
  public c$b(b paramb, a parama, BluetoothSocket paramBluetoothSocket)
  {
    this.hXa = paramBluetoothSocket;
    this.hXc = paramb;
    this.hXd = parama;
    this.hXh = false;
    this.hXg = null;
    try
    {
      this.hXg = paramBluetoothSocket.getInputStream();
      return;
    }
    catch (IOException paramb)
    {
      this.hXg = null;
      y.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[] { paramb.toString() });
    }
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.exdevice.RecvThread", "------cancel------");
    if (this.hXh)
    {
      y.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
      return;
    }
    this.hXh = true;
    e.Y(this);
    try
    {
      this.hXa.close();
      return;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[] { localIOException });
    }
  }
  
  public final void run()
  {
    y.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
    if (this.hXg == null)
    {
      y.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
      return;
    }
    byte[] arrayOfByte1 = new byte[2048];
    for (;;)
    {
      if (this.hXh)
      {
        y.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        return;
      }
      try
      {
        int i = this.hXg.read(arrayOfByte1);
        if (i > 0)
        {
          y.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[] { Integer.valueOf(i) });
          y.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.Q(arrayOfByte1, i) });
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
          if (this.hXd != null) {
            this.hXd.hWS.b(this.hXc.mSessionId, arrayOfByte2);
          }
        }
      }
      catch (IOException localIOException1)
      {
        y.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[] { localIOException1.toString() });
        try
        {
          this.hXa.close();
          return;
        }
        catch (IOException localIOException2)
        {
          y.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[] { localIOException2.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.c.b
 * JD-Core Version:    0.7.0.1
 */