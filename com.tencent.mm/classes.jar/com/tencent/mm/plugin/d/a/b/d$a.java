package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

final class d$a
  extends ak
{
  private final WeakReference<d> jOv;
  
  public d$a(Looper paramLooper, d paramd)
  {
    super(paramLooper);
    AppMethodBeat.i(18396);
    this.jOv = new WeakReference(paramd);
    AppMethodBeat.o(18396);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    int i = 1;
    AppMethodBeat.i(18397);
    d locald = (d)this.jOv.get();
    if (locald == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
      AppMethodBeat.o(18397);
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18397);
      return;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
      if (1 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
        AppMethodBeat.o(18397);
        return;
      }
      if (locald.jOs == 0)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
        AppMethodBeat.o(18397);
        return;
      }
      locald.aVW();
      if (locald.jOh != null)
      {
        if (!locald.jOh.connect())
        {
          ab.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
          if (locald.jOi != null) {
            locald.jOi.jNN.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(18397);
          return;
        }
        locald.jOs = 0;
        locald.mHandler.postDelayed(locald.jOo, 10000L);
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOh = locald.hIc.connectGatt(locald.jOg, false, locald.jOt);
      if (locald.jOh == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOs = 0;
      locald.mHandler.postDelayed(locald.jOo, 10000L);
      AppMethodBeat.o(18397);
      return;
      i = paramMessage.arg1;
      if (i == 2) {}
      for (paramMessage = "Connected";; paramMessage = "Disconnected")
      {
        ab.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
        if (i != 2) {
          break label565;
        }
        ab.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.jOs) });
        if (3 != locald.jOs) {
          break;
        }
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
        locald.mHandler.removeCallbacks(locald.jOo);
        AppMethodBeat.o(18397);
        return;
      }
      if (1 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
        locald.mHandler.removeCallbacks(locald.jOo);
        AppMethodBeat.o(18397);
        return;
      }
      if (!locald.jOh.discoverServices())
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      ab.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
      AppMethodBeat.o(18397);
      return;
      label565:
      if (i == 0)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
      }
      AppMethodBeat.o(18397);
      return;
      Object localObject = (BluetoothGatt)paramMessage.obj;
      int j = paramMessage.arg1;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
      if (3 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
        locald.mHandler.removeCallbacks(locald.jOo);
        AppMethodBeat.o(18397);
        return;
      }
      if (1 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
        locald.mHandler.removeCallbacks(locald.jOo);
        AppMethodBeat.o(18397);
        return;
      }
      if (j != 0)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.jOV));
      if (paramMessage == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOj = paramMessage.getCharacteristic(UUID.fromString(h.jOX));
      if (locald.jOj == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOk = paramMessage.getCharacteristic(UUID.fromString(h.jOW));
      if (locald.jOk == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      j = locald.jOj.getProperties();
      ab.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
      if ((j & 0x20) == 0)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
        locald.jOs = 2;
        locald.mHandler.removeCallbacks(locald.jOo);
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      ab.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
      paramMessage = locald.jOp;
      localObject = locald.jOj;
      if (!paramMessage.jOh.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          ab.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
          locald.jOs = 2;
          locald.mHandler.removeCallbacks(locald.jOo);
          if (locald.jOi != null) {
            locald.jOi.jNN.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(18397);
        return;
        localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.jOU));
        if (localObject == null)
        {
          ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
          i = 0;
        }
        else
        {
          ab.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
          if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
          {
            ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
            i = 0;
          }
          else if (!paramMessage.jOh.writeDescriptor((BluetoothGattDescriptor)localObject))
          {
            ab.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
            i = 0;
          }
          else
          {
            paramMessage.mHandler.postDelayed(paramMessage.jOn, 5000L);
          }
        }
      }
      localObject = paramMessage.obj;
      i = paramMessage.arg1;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
      locald.mHandler.removeCallbacks(locald.jOn);
      locald.mHandler.removeCallbacks(locald.jOo);
      if (3 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
        AppMethodBeat.o(18397);
        return;
      }
      if (1 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
        AppMethodBeat.o(18397);
        return;
      }
      if (i != 0)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
        locald.jOs = 2;
        if (locald.jOi != null) {
          locald.jOi.jNN.l(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOs = 1;
      if (locald.jOi != null) {
        locald.jOi.jNN.l(locald.mSessionId, true);
      }
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.jOs) });
      AppMethodBeat.o(18397);
      return;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
      if (3 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
        AppMethodBeat.o(18397);
        return;
      }
      locald.aVW();
      if (locald.jOh == null)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOs = 3;
      locald.mHandler.removeCallbacks(locald.jOo);
      locald.mHandler.removeCallbacks(locald.jOn);
      locald.jOh.disconnect();
      AppMethodBeat.o(18397);
      return;
      paramMessage = (byte[])paramMessage.obj;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
      if (1 != locald.jOs)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.jOs) });
        if (locald.jOi != null) {
          locald.jOi.jNN.m(locald.mSessionId, false);
        }
        AppMethodBeat.o(18397);
        return;
      }
      if ((locald.jOh != null) && (locald.jOk != null))
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        locald.jOq.add(paramMessage);
        if (!locald.jOr) {
          if (1 != locald.jOq.size()) {
            break label1845;
          }
        }
      }
      label1845:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        locald.aVX();
        AppMethodBeat.o(18397);
        return;
        bool1 = false;
        break;
      }
      i = paramMessage.arg1;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
      locald.mHandler.removeCallbacks(locald.jOm);
      if (i != 0)
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
        if (locald.jOi != null) {
          locald.jOi.jNN.m(locald.mSessionId, false);
        }
        locald.aVX();
        AppMethodBeat.o(18397);
        return;
      }
      paramMessage = locald.jOl.aVR();
      ab.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aO(paramMessage) });
      if (paramMessage == null)
      {
        ab.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
        if (locald.jOi != null) {
          locald.jOi.jNN.m(locald.mSessionId, true);
        }
        locald.aVX();
        AppMethodBeat.o(18397);
        return;
      }
      ab.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
      locald.jOk.setValue(paramMessage);
      locald.jOh.writeCharacteristic(locald.jOk);
      locald.mHandler.postDelayed(locald.jOm, 5000L);
      AppMethodBeat.o(18397);
      return;
      paramMessage = (byte[])paramMessage.obj;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
      if (bo.ce(paramMessage))
      {
        ab.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
        AppMethodBeat.o(18397);
        return;
      }
      localObject = com.tencent.mm.plugin.exdevice.j.b.R(paramMessage, paramMessage.length);
      ab.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
      ab.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
      if (locald.jOi != null) {
        locald.jOi.jNN.b(locald.mSessionId, paramMessage);
      }
      AppMethodBeat.o(18397);
      return;
      ab.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
      if (3 == locald.jOs)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
        AppMethodBeat.o(18397);
        return;
      }
      locald.aVW();
      if (locald.jOh == null)
      {
        ab.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
        AppMethodBeat.o(18397);
        return;
      }
      locald.jOs = 3;
      locald.jOh.disconnect();
      locald.jOh.close();
      locald.jOh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */