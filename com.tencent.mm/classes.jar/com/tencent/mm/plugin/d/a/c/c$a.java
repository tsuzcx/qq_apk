package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class c$a
{
  BluetoothSocket jQT;
  final boolean jQU;
  public final b jQV;
  public final a jQW;
  boolean jQX;
  final BluetoothDevice jQY;
  public final ak mHandler;
  private final HandlerThread mThread;
  
  public c$a(b paramb, a parama, BluetoothDevice paramBluetoothDevice)
  {
    AppMethodBeat.i(18487);
    this.jQW = parama;
    this.jQV = paramb;
    this.jQU = true;
    this.jQX = false;
    this.jQY = paramBluetoothDevice;
    this.mThread = com.tencent.mm.sdk.g.d.aqu("BluetoothChatThreads_handlerThread");
    this.mThread.start();
    this.mHandler = new c.a.a(this.mThread.getLooper(), this);
    AppMethodBeat.o(18487);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(18488);
    ab.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
      ab.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[] { Integer.valueOf(1) });
    }
    if (com.tencent.mm.compatible.util.d.fv(18))
    {
      this.mThread.quitSafely();
      AppMethodBeat.o(18488);
      return;
    }
    this.mThread.quit();
    AppMethodBeat.o(18488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.a
 * JD-Core Version:    0.7.0.1
 */