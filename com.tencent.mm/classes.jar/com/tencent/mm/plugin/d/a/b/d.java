package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

@TargetApi(18)
public final class d
{
  private int axc;
  BluetoothDevice hIc;
  private BluetoothAdapter jNi;
  Context jOg;
  BluetoothGatt jOh;
  b jOi;
  BluetoothGattCharacteristic jOj;
  BluetoothGattCharacteristic jOk;
  a jOl;
  Runnable jOm;
  Runnable jOn;
  Runnable jOo;
  d jOp;
  final LinkedList<byte[]> jOq;
  volatile boolean jOr;
  int jOs;
  final BluetoothGattCallback jOt;
  public ak mHandler;
  long mSessionId;
  private HandlerThread mThread;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(18398);
    this.jOq = new LinkedList();
    this.jOr = false;
    this.jOt = new d.1(this);
    this.axc = -1;
    this.axc = hashCode();
    this.jOp = this;
    this.jOi = paramb;
    this.jOg = paramContext;
    this.jNi = ((BluetoothManager)this.jOg.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.jOs = 3;
    this.hIc = this.jNi.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.hO(paramLong));
    this.jOj = null;
    this.jOk = null;
    this.jOl = new a();
    this.mThread = com.tencent.mm.sdk.g.d.aqu("BluetoothLESession_handlerThread");
    this.mThread.start();
    this.mHandler = new d.a(this.mThread.getLooper(), this);
    this.jOm = new d.2(this);
    this.jOn = new d.3(this);
    this.jOo = new d.4(this);
    AppMethodBeat.o(18398);
  }
  
  final void aVW()
  {
    AppMethodBeat.i(18401);
    this.jOr = false;
    this.jOq.clear();
    AppMethodBeat.o(18401);
  }
  
  final void aVX()
  {
    AppMethodBeat.i(18402);
    if (this.jOq.isEmpty())
    {
      this.jOr = false;
      AppMethodBeat.o(18402);
      return;
    }
    byte[] arrayOfByte = (byte[])this.jOq.pop();
    this.jOl.setData(arrayOfByte);
    arrayOfByte = this.jOl.aVR();
    ab.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aO(arrayOfByte) });
    this.jOk.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.jOm, 5000L);
    if (!this.jOh.writeCharacteristic(this.jOk)) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.jOr = true;
    AppMethodBeat.o(18402);
  }
  
  public final void close()
  {
    AppMethodBeat.i(18400);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mThread.quitSafely();
    AppMethodBeat.o(18400);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(18399);
    ab.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(18399);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */