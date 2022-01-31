package com.tencent.mm.plugin.f.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

@TargetApi(18)
public final class d
{
  private int auK = -1;
  BluetoothDevice gof;
  private BluetoothAdapter hTo;
  Context hUm;
  BluetoothGatt hUn;
  b hUo;
  BluetoothGattCharacteristic hUp;
  BluetoothGattCharacteristic hUq;
  a hUr;
  Runnable hUs;
  Runnable hUt;
  Runnable hUu;
  d hUv = this;
  final LinkedList<byte[]> hUw = new LinkedList();
  volatile boolean hUx = false;
  int hUy;
  final BluetoothGattCallback hUz = new BluetoothGattCallback()
  {
    public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
      if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
        y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
      }
    }
    
    public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
    }
    
    public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
        y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
      }
    }
    
    public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.hUy) });
      if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
        y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
      }
    }
    
    public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
        y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
      }
    }
    
    public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
      if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
        y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
      }
    }
  };
  public ah mHandler;
  long mSessionId;
  private HandlerThread mThread;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    this.hUo = paramb;
    this.hUm = paramContext;
    this.hTo = ((BluetoothManager)this.hUm.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.hUy = 3;
    this.gof = this.hTo.getRemoteDevice(com.tencent.mm.plugin.f.a.e.a.cM(paramLong));
    this.hUp = null;
    this.hUq = null;
    this.hUr = new a();
    this.mThread = e.aap("BluetoothLESession_handlerThread");
    this.mThread.start();
    this.mHandler = new d.a(this.mThread.getLooper(), this);
    this.hUs = new d.2(this);
    this.hUt = new d.3(this);
    this.hUu = new d.4(this);
  }
  
  final void awt()
  {
    this.hUx = false;
    this.hUw.clear();
  }
  
  final void awu()
  {
    if (this.hUw.isEmpty())
    {
      this.hUx = false;
      return;
    }
    byte[] arrayOfByte = (byte[])this.hUw.pop();
    this.hUr.setData(arrayOfByte);
    arrayOfByte = this.hUr.awo();
    y.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aq(arrayOfByte) });
    this.hUq.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.hUs, 5000L);
    if (!this.hUn.writeCharacteristic(this.hUq)) {
      y.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.hUx = true;
  }
  
  public final void close()
  {
    y.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      y.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mThread.quitSafely();
  }
  
  public final boolean connect()
  {
    y.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d
 * JD-Core Version:    0.7.0.1
 */