package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d
{
  private int aFZ;
  BluetoothDevice klR;
  public ao mHandler;
  long mSessionId;
  private BluetoothAdapter nox;
  a npA;
  Runnable npB;
  Runnable npC;
  Runnable npD;
  d npE;
  final LinkedList<byte[]> npF;
  volatile boolean npG;
  int npH;
  final BluetoothGattCallback npI;
  Context npv;
  BluetoothGatt npw;
  b npx;
  BluetoothGattCharacteristic npy;
  BluetoothGattCharacteristic npz;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.npF = new LinkedList();
    this.npG = false;
    this.npI = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22501);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22501);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22502);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(22502);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22503);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22503);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22498);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.npH) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22498);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22500);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22500);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22499);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22499);
      }
    };
    this.aFZ = -1;
    this.aFZ = hashCode();
    this.npE = this;
    this.npx = paramb;
    this.npv = paramContext;
    this.nox = ((BluetoothManager)this.npv.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.npH = 3;
    this.klR = this.nox.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.rk(paramLong));
    this.npy = null;
    this.npz = null;
    this.npA = new a();
    this.mHandler = new a(com.tencent.e.j.a.aTF("BluetoothLESession_handlerThread"), this);
    this.npB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        ac.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.npx != null) {
          d.this.npx.npc.m(d.this.mSessionId, false);
        }
        d.this.bIx();
        AppMethodBeat.o(22504);
      }
    };
    this.npC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        ac.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.npD);
        d.this.npH = 2;
        if (d.this.npx != null) {
          d.this.npx.npc.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.npD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        ac.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.npC);
        d.this.npH = 2;
        if (d.this.npx != null) {
          d.this.npx.npc.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  final void bIw()
  {
    AppMethodBeat.i(22512);
    this.npG = false;
    this.npF.clear();
    AppMethodBeat.o(22512);
  }
  
  final void bIx()
  {
    AppMethodBeat.i(22513);
    if (this.npF.isEmpty())
    {
      this.npG = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.npF.pop();
    this.npA.setData(arrayOfByte);
    arrayOfByte = this.npA.bIr();
    ac.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bd(arrayOfByte) });
    this.npz.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.npB, 5000L);
    if (!this.npw.writeCharacteristic(this.npz)) {
      ac.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.npG = true;
    AppMethodBeat.o(22513);
  }
  
  public final void close()
  {
    AppMethodBeat.i(22511);
    ac.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      ac.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22511);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22510);
    ac.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  static final class a
    extends ao
  {
    private final WeakReference<d> npK;
    
    public a(com.tencent.e.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.npK = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.npK.get();
      if (locald == null)
      {
        ac.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
        AppMethodBeat.o(22508);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22508);
        return;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
        if (1 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.npH == 0)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bIw();
        if (locald.npw != null)
        {
          if (!locald.npw.connect())
          {
            ac.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.npx != null) {
              locald.npx.npc.l(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.npH = 0;
          locald.mHandler.postDelayed(locald.npD, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.npw = locald.klR.connectGatt(locald.npv, false, locald.npI);
        if (locald.npw == null)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.npH = 0;
        locald.mHandler.postDelayed(locald.npD, 10000L);
        AppMethodBeat.o(22508);
        return;
        i = paramMessage.arg1;
        if (i == 2) {}
        for (paramMessage = "Connected";; paramMessage = "Disconnected")
        {
          ac.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
          if (i != 2) {
            break label565;
          }
          ac.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.npH) });
          if (3 != locald.npH) {
            break;
          }
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.npD);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.npD);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.npw.discoverServices())
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ac.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
        AppMethodBeat.o(22508);
        return;
        label565:
        if (i == 0)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.npD);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.npD);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.nqk));
        if (paramMessage == null)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.npy = paramMessage.getCharacteristic(UUID.fromString(h.nqm));
        if (locald.npy == null)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.npz = paramMessage.getCharacteristic(UUID.fromString(h.nql));
        if (locald.npz == null)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.npy.getProperties();
        ac.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.npH = 2;
          locald.mHandler.removeCallbacks(locald.npD);
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        ac.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.npE;
        localObject = locald.npy;
        if (!paramMessage.npw.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            ac.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.npH = 2;
            locald.mHandler.removeCallbacks(locald.npD);
            if (locald.npx != null) {
              locald.npx.npc.l(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.nqj));
          if (localObject == null)
          {
            ac.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
            i = 0;
          }
          else
          {
            ac.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
            if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
            {
              ac.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
              i = 0;
            }
            else if (!paramMessage.npw.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              ac.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.npC, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.npC);
        locald.mHandler.removeCallbacks(locald.npD);
        if (3 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.npH = 2;
          if (locald.npx != null) {
            locald.npx.npc.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.npH = 1;
        if (locald.npx != null) {
          locald.npx.npc.l(locald.mSessionId, true);
        }
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.npH) });
        AppMethodBeat.o(22508);
        return;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bIw();
        if (locald.npw == null)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.npH = 3;
        locald.mHandler.removeCallbacks(locald.npD);
        locald.mHandler.removeCallbacks(locald.npC);
        locald.npw.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.npH)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.npH) });
          if (locald.npx != null) {
            locald.npx.npc.m(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.npw != null) && (locald.npz != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.npF.add(paramMessage);
          if (!locald.npG) {
            if (1 != locald.npF.size()) {
              break label1845;
            }
          }
        }
        label1845:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.bIx();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.npB);
        if (i != 0)
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.npx != null) {
            locald.npx.npc.m(locald.mSessionId, false);
          }
          locald.bIx();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.npA.bIr();
        ac.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bd(paramMessage) });
        if (paramMessage == null)
        {
          ac.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.npx != null) {
            locald.npx.npc.m(locald.mSessionId, true);
          }
          locald.bIx();
          AppMethodBeat.o(22508);
          return;
        }
        ac.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.npz.setValue(paramMessage);
        locald.npw.writeCharacteristic(locald.npz);
        locald.mHandler.postDelayed(locald.npB, 5000L);
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
        if (bs.cv(paramMessage))
        {
          ac.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
          AppMethodBeat.o(22508);
          return;
        }
        localObject = com.tencent.mm.plugin.exdevice.k.b.T(paramMessage, paramMessage.length);
        ac.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        ac.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.npx != null) {
          locald.npx.npc.b(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        ac.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.npH)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.bIw();
        if (locald.npw == null)
        {
          ac.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.npH = 3;
        locald.npw.disconnect();
        locald.npw.close();
        locald.npw = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */