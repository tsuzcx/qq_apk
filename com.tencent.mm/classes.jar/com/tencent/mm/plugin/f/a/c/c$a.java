package com.tencent.mm.plugin.f.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class c$a
{
  BluetoothSocket hXa;
  final boolean hXb;
  public final b hXc;
  public final a hXd;
  boolean hXe;
  final BluetoothDevice hXf;
  public final ah mHandler;
  private final HandlerThread mThread;
  
  public c$a(b paramb, a parama, BluetoothDevice paramBluetoothDevice)
  {
    this.hXd = parama;
    this.hXc = paramb;
    this.hXb = true;
    this.hXe = false;
    this.hXf = paramBluetoothDevice;
    this.mThread = e.aap("BluetoothChatThreads_handlerThread");
    this.mThread.start();
    this.mHandler = new c.a.a(this.mThread.getLooper(), this);
  }
  
  public final void disconnect()
  {
    y.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
      y.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[] { Integer.valueOf(1) });
    }
    if (d.gF(18))
    {
      this.mThread.quitSafely();
      return;
    }
    this.mThread.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.c.a
 * JD-Core Version:    0.7.0.1
 */