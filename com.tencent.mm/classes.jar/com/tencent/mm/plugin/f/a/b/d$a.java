package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

final class d$a
  extends ah
{
  private final WeakReference<d> hUB;
  
  public d$a(Looper paramLooper, d paramd)
  {
    super(paramLooper);
    this.hUB = new WeakReference(paramd);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    int i = 1;
    d locald = (d)this.hUB.get();
    if (locald == null) {
      y.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
    }
    label182:
    label206:
    label487:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                                switch (paramMessage.what)
                                {
                                default: 
                                  return;
                                case 0: 
                                  y.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                                  if (1 == locald.hUy)
                                  {
                                    y.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                                    return;
                                  }
                                  if (locald.hUy == 0)
                                  {
                                    y.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                                    return;
                                  }
                                  locald.awt();
                                  if (locald.hUn == null) {
                                    break label206;
                                  }
                                  if (locald.hUn.connect()) {
                                    break label182;
                                  }
                                  y.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                                }
                              } while (locald.hUo == null);
                              locald.hUo.hTT.i(locald.mSessionId, false);
                              return;
                              locald.hUy = 0;
                              locald.mHandler.postDelayed(locald.hUu, 10000L);
                              return;
                              locald.hUn = locald.gof.connectGatt(locald.hUm, false, locald.hUz);
                              if (locald.hUn != null) {
                                break;
                              }
                              y.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                            } while (locald.hUo == null);
                            locald.hUo.hTT.i(locald.mSessionId, false);
                            return;
                            locald.hUy = 0;
                            locald.mHandler.postDelayed(locald.hUu, 10000L);
                            return;
                            i = paramMessage.arg1;
                            if (i == 2) {}
                            for (paramMessage = "Connected";; paramMessage = "Disconnected")
                            {
                              y.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
                              if (i != 2) {
                                break label487;
                              }
                              y.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.hUy) });
                              if (3 != locald.hUy) {
                                break;
                              }
                              y.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                              locald.mHandler.removeCallbacks(locald.hUu);
                              return;
                            }
                            if (1 == locald.hUy)
                            {
                              y.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                              locald.mHandler.removeCallbacks(locald.hUu);
                              return;
                            }
                            if (locald.hUn.discoverServices()) {
                              break;
                            }
                            y.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            locald.hUy = 2;
                            locald.mHandler.removeCallbacks(locald.hUu);
                          } while (locald.hUo == null);
                          locald.hUo.hTT.i(locald.mSessionId, false);
                          return;
                          y.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                          return;
                        } while (i != 0);
                        y.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        locald.hUy = 2;
                        locald.mHandler.removeCallbacks(locald.hUu);
                      } while (locald.hUo == null);
                      locald.hUo.hTT.i(locald.mSessionId, false);
                      return;
                      localObject = (BluetoothGatt)paramMessage.obj;
                      j = paramMessage.arg1;
                      y.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
                      if (3 == locald.hUy)
                      {
                        y.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        locald.mHandler.removeCallbacks(locald.hUu);
                        return;
                      }
                      if (1 == locald.hUy)
                      {
                        y.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        locald.mHandler.removeCallbacks(locald.hUu);
                        return;
                      }
                      if (j == 0) {
                        break;
                      }
                      y.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                      locald.hUy = 2;
                      locald.mHandler.removeCallbacks(locald.hUu);
                    } while (locald.hUo == null);
                    locald.hUo.hTT.i(locald.mSessionId, false);
                    return;
                    paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.hVb));
                    if (paramMessage != null) {
                      break;
                    }
                    y.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                    locald.hUy = 2;
                    locald.mHandler.removeCallbacks(locald.hUu);
                  } while (locald.hUo == null);
                  locald.hUo.hTT.i(locald.mSessionId, false);
                  return;
                  locald.hUp = paramMessage.getCharacteristic(UUID.fromString(h.hVd));
                  if (locald.hUp != null) {
                    break;
                  }
                  y.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                  locald.hUy = 2;
                  locald.mHandler.removeCallbacks(locald.hUu);
                } while (locald.hUo == null);
                locald.hUo.hTT.i(locald.mSessionId, false);
                return;
                locald.hUq = paramMessage.getCharacteristic(UUID.fromString(h.hVc));
                if (locald.hUq != null) {
                  break;
                }
                y.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                locald.hUy = 2;
                locald.mHandler.removeCallbacks(locald.hUu);
              } while (locald.hUo == null);
              locald.hUo.hTT.i(locald.mSessionId, false);
              return;
              int j = locald.hUp.getProperties();
              y.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
              if ((j & 0x20) != 0) {
                break;
              }
              y.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
              locald.hUy = 2;
              locald.mHandler.removeCallbacks(locald.hUu);
            } while (locald.hUo == null);
            locald.hUo.hTT.i(locald.mSessionId, false);
            return;
            y.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
            paramMessage = locald.hUv;
            localObject = locald.hUp;
            if (!paramMessage.hUn.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
            {
              y.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
              i = 0;
            }
            while (i == 0)
            {
              y.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
              locald.hUy = 2;
              locald.mHandler.removeCallbacks(locald.hUu);
              if (locald.hUo == null) {
                break;
              }
              locald.hUo.hTT.i(locald.mSessionId, false);
              return;
              localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.hVa));
              if (localObject == null)
              {
                y.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                i = 0;
              }
              else
              {
                y.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
                if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
                {
                  y.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                  i = 0;
                }
                else if (!paramMessage.hUn.writeDescriptor((BluetoothGattDescriptor)localObject))
                {
                  y.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                  i = 0;
                }
                else
                {
                  paramMessage.mHandler.postDelayed(paramMessage.hUt, 5000L);
                }
              }
            }
            localObject = paramMessage.obj;
            i = paramMessage.arg1;
            y.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
            locald.mHandler.removeCallbacks(locald.hUt);
            locald.mHandler.removeCallbacks(locald.hUu);
            if (3 == locald.hUy)
            {
              y.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
              return;
            }
            if (1 == locald.hUy)
            {
              y.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
              return;
            }
            if (i == 0) {
              break;
            }
            y.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
            locald.hUy = 2;
          } while (locald.hUo == null);
          locald.hUo.hTT.i(locald.mSessionId, false);
          return;
          locald.hUy = 1;
          if (locald.hUo != null) {
            locald.hUo.hTT.i(locald.mSessionId, true);
          }
          y.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.hUy) });
          return;
          y.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
          if (3 == locald.hUy)
          {
            y.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
            return;
          }
          locald.awt();
          if (locald.hUn == null)
          {
            y.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
            return;
          }
          locald.hUy = 3;
          locald.mHandler.removeCallbacks(locald.hUu);
          locald.mHandler.removeCallbacks(locald.hUt);
          locald.hUn.disconnect();
          return;
          paramMessage = (byte[])paramMessage.obj;
          y.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
          if (1 == locald.hUy) {
            break;
          }
          y.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.hUy) });
        } while (locald.hUo == null);
        locald.hUo.hTT.j(locald.mSessionId, false);
        return;
        if ((locald.hUn == null) || (locald.hUq == null)) {
          break;
        }
        bool1 = true;
        Assert.assertTrue(bool1);
        locald.hUw.add(paramMessage);
      } while (locald.hUx);
      if (1 == locald.hUw.size()) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Assert.assertTrue(bool1);
        locald.awu();
        return;
        bool1 = false;
        break;
      }
      i = paramMessage.arg1;
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
      locald.mHandler.removeCallbacks(locald.hUs);
      if (i != 0)
      {
        y.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i);
        if (locald.hUo != null) {
          locald.hUo.hTT.j(locald.mSessionId, false);
        }
        locald.awu();
        return;
      }
      paramMessage = locald.hUr.awo();
      y.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.j.b.aq(paramMessage) });
      if (paramMessage == null)
      {
        y.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
        if (locald.hUo != null) {
          locald.hUo.hTT.j(locald.mSessionId, true);
        }
        locald.awu();
        return;
      }
      y.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
      locald.hUq.setValue(paramMessage);
      locald.hUn.writeCharacteristic(locald.hUq);
      locald.mHandler.postDelayed(locald.hUs, 5000L);
      return;
      paramMessage = (byte[])paramMessage.obj;
      y.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
      if (bk.bE(paramMessage))
      {
        y.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
        return;
      }
      Object localObject = com.tencent.mm.plugin.exdevice.j.b.Q(paramMessage, paramMessage.length);
      y.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
      y.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
    } while (locald.hUo == null);
    locald.hUo.hTT.b(locald.mSessionId, paramMessage);
    return;
    y.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
    if (3 == locald.hUy)
    {
      y.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
      return;
    }
    locald.awt();
    if (locald.hUn == null)
    {
      y.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
      return;
    }
    locald.hUy = 3;
    locald.hUn.disconnect();
    locald.hUn.close();
    locald.hUn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */