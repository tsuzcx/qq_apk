package com.tencent.mm.plugin.f.a.b;

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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d
{
  private int aNf;
  public MMHandler mHandler;
  long mSessionId;
  BluetoothDevice oLg;
  private BluetoothAdapter sif;
  Context sje;
  BluetoothGatt sjf;
  b sjg;
  BluetoothGattCharacteristic sjh;
  BluetoothGattCharacteristic sji;
  a sjj;
  Runnable sjk;
  Runnable sjl;
  Runnable sjm;
  d sjn;
  final LinkedList<byte[]> sjo;
  volatile boolean sjp;
  int sjq;
  final BluetoothGattCallback sjr;
  
  @TargetApi(18)
  public d(long paramLong, Context paramContext, b paramb)
  {
    AppMethodBeat.i(22509);
    this.sjo = new LinkedList();
    this.sjp = false;
    this.sjr = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22501);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, paramAnonymousBluetoothGattCharacteristic.getValue()))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22501);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22502);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(22502);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22503);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, paramAnonymousInt, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22503);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22498);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(d.this.sjq) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, paramAnonymousInt2, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22498);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22500);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22500);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22499);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22499);
      }
    };
    this.aNf = -1;
    this.aNf = hashCode();
    this.sjn = this;
    this.sjg = paramb;
    this.sje = paramContext;
    this.sif = ((BluetoothManager)this.sje.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.sjq = 3;
    this.oLg = this.sif.getRemoteDevice(com.tencent.mm.plugin.f.a.e.a.HP(paramLong));
    this.sjh = null;
    this.sji = null;
    this.sjj = new a();
    this.mHandler = new a(com.tencent.e.j.a.bDn("BluetoothLESession_handlerThread"), this);
    this.sjk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22504);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
        if (d.this.sjg != null) {
          d.this.sjg.siM.m(d.this.mSessionId, false);
        }
        d.this.cyd();
        AppMethodBeat.o(22504);
      }
    };
    this.sjl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22505);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == d.this.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22505);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.sjm);
        d.this.sjq = 2;
        if (d.this.sjg != null) {
          d.this.sjg.siM.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22505);
      }
    };
    this.sjm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22506);
        Log.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
        if (3 == d.this.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
          AppMethodBeat.o(22506);
          return;
        }
        d.this.mHandler.removeCallbacks(d.this.sjl);
        d.this.sjq = 2;
        if (d.this.sjg != null) {
          d.this.sjg.siM.l(d.this.mSessionId, false);
        }
        AppMethodBeat.o(22506);
      }
    };
    AppMethodBeat.o(22509);
  }
  
  public final void close()
  {
    AppMethodBeat.i(22511);
    Log.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
      Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22511);
  }
  
  public final boolean cyb()
  {
    AppMethodBeat.i(22510);
    Log.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22510);
    return bool;
  }
  
  final void cyc()
  {
    AppMethodBeat.i(22512);
    this.sjp = false;
    this.sjo.clear();
    AppMethodBeat.o(22512);
  }
  
  final void cyd()
  {
    AppMethodBeat.i(22513);
    if (this.sjo.isEmpty())
    {
      this.sjp = false;
      AppMethodBeat.o(22513);
      return;
    }
    byte[] arrayOfByte = (byte[])this.sjo.pop();
    this.sjj.setData(arrayOfByte);
    arrayOfByte = this.sjj.cxW();
    Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bK(arrayOfByte) });
    this.sji.setValue(arrayOfByte);
    this.mHandler.postDelayed(this.sjk, 5000L);
    if (!this.sjf.writeCharacteristic(this.sji)) {
      Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
    }
    this.sjp = true;
    AppMethodBeat.o(22513);
  }
  
  static final class a
    extends MMHandler
  {
    private final WeakReference<d> sjt;
    
    public a(com.tencent.e.j.a parama, d paramd)
    {
      super();
      AppMethodBeat.i(179581);
      this.sjt = new WeakReference(paramd);
      AppMethodBeat.o(179581);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      int i = 1;
      AppMethodBeat.i(22508);
      d locald = (d)this.sjt.get();
      if (locald == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
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
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
        if (1 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
          AppMethodBeat.o(22508);
          return;
        }
        if (locald.sjq == 0)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
          AppMethodBeat.o(22508);
          return;
        }
        locald.cyc();
        if (locald.sjf != null)
        {
          if (!locald.sjf.connect())
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
            if (locald.sjg != null) {
              locald.sjg.siM.l(locald.mSessionId, false);
            }
            AppMethodBeat.o(22508);
            return;
          }
          locald.sjq = 0;
          locald.mHandler.postDelayed(locald.sjm, 10000L);
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjf = locald.oLg.connectGatt(locald.sje, false, locald.sjr);
        if (locald.sjf == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjq = 0;
        locald.mHandler.postDelayed(locald.sjm, 10000L);
        AppMethodBeat.o(22508);
        return;
        i = paramMessage.arg1;
        if (i == 2) {}
        for (paramMessage = "Connected";; paramMessage = "Disconnected")
        {
          Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", new Object[] { paramMessage });
          if (i != 2) {
            break label565;
          }
          Log.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[] { Integer.valueOf(locald.sjq) });
          if (3 != locald.sjq) {
            break;
          }
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.sjm);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
          locald.mHandler.removeCallbacks(locald.sjm);
          AppMethodBeat.o(22508);
          return;
        }
        if (!locald.sjf.discoverServices())
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
        AppMethodBeat.o(22508);
        return;
        label565:
        if (i == 0)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
        }
        AppMethodBeat.o(22508);
        return;
        Object localObject = (BluetoothGatt)paramMessage.obj;
        int j = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[] { Integer.valueOf(j) });
        if (3 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          locald.mHandler.removeCallbacks(locald.sjm);
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          locald.mHandler.removeCallbacks(locald.sjm);
          AppMethodBeat.o(22508);
          return;
        }
        if (j != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = ((BluetoothGatt)localObject).getService(UUID.fromString(h.sjT));
        if (paramMessage == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjh = paramMessage.getCharacteristic(UUID.fromString(h.sjV));
        if (locald.sjh == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.sji = paramMessage.getCharacteristic(UUID.fromString(h.sjU));
        if (locald.sji == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        j = locald.sjh.getProperties();
        Log.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[] { Integer.valueOf(j) });
        if ((j & 0x20) == 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
          locald.sjq = 2;
          locald.mHandler.removeCallbacks(locald.sjm);
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
        paramMessage = locald.sjn;
        localObject = locald.sjh;
        if (!paramMessage.sjf.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true))
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
            locald.sjq = 2;
            locald.mHandler.removeCallbacks(locald.sjm);
            if (locald.sjg != null) {
              locald.sjg.siM.l(locald.mSessionId, false);
            }
          }
          AppMethodBeat.o(22508);
          return;
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(UUID.fromString(h.sjS));
          if (localObject == null)
          {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
            i = 0;
          }
          else
          {
            Log.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + ((BluetoothGattDescriptor)localObject).getPermissions());
            if (!((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE))
            {
              Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
              i = 0;
            }
            else if (!paramMessage.sjf.writeDescriptor((BluetoothGattDescriptor)localObject))
            {
              Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
              i = 0;
            }
            else
            {
              paramMessage.mHandler.postDelayed(paramMessage.sjl, 5000L);
            }
          }
        }
        localObject = paramMessage.obj;
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.sjl);
        locald.mHandler.removeCallbacks(locald.sjm);
        if (3 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (1 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
          AppMethodBeat.o(22508);
          return;
        }
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
          locald.sjq = 2;
          if (locald.sjg != null) {
            locald.sjg.siM.l(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjq = 1;
        if (locald.sjg != null) {
          locald.sjg.siM.l(locald.mSessionId, true);
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[] { Integer.valueOf(locald.sjq) });
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
        if (3 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.cyc();
        if (locald.sjf == null)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjq = 3;
        locald.mHandler.removeCallbacks(locald.sjm);
        locald.mHandler.removeCallbacks(locald.sjl);
        locald.sjf.disconnect();
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        if (1 != locald.sjq)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[] { Integer.valueOf(locald.sjq) });
          if (locald.sjg != null) {
            locald.sjg.siM.m(locald.mSessionId, false);
          }
          AppMethodBeat.o(22508);
          return;
        }
        if ((locald.sjf != null) && (locald.sji != null))
        {
          bool1 = true;
          Assert.assertTrue(bool1);
          locald.sjo.add(paramMessage);
          if (!locald.sjp) {
            if (1 != locald.sjo.size()) {
              break label1845;
            }
          }
        }
        label1845:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Assert.assertTrue(bool1);
          locald.cyd();
          AppMethodBeat.o(22508);
          return;
          bool1 = false;
          break;
        }
        i = paramMessage.arg1;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[] { Integer.valueOf(i) });
        locald.mHandler.removeCallbacks(locald.sjk);
        if (i != 0)
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i)));
          if (locald.sjg != null) {
            locald.sjg.siM.m(locald.mSessionId, false);
          }
          locald.cyd();
          AppMethodBeat.o(22508);
          return;
        }
        paramMessage = locald.sjj.cxW();
        Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[] { com.tencent.mm.plugin.exdevice.k.b.bK(paramMessage) });
        if (paramMessage == null)
        {
          Log.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
          if (locald.sjg != null) {
            locald.sjg.siM.m(locald.mSessionId, true);
          }
          locald.cyd();
          AppMethodBeat.o(22508);
          return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
        locald.sji.setValue(paramMessage);
        locald.sjf.writeCharacteristic(locald.sji);
        locald.mHandler.postDelayed(locald.sjk, 5000L);
        AppMethodBeat.o(22508);
        return;
        paramMessage = (byte[])paramMessage.obj;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
        if (Util.isNullOrNil(paramMessage))
        {
          Log.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
          AppMethodBeat.o(22508);
          return;
        }
        localObject = com.tencent.mm.plugin.exdevice.k.b.Y(paramMessage, paramMessage.length);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[] { Integer.valueOf(paramMessage.length) });
        Log.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[] { localObject });
        if (locald.sjg != null) {
          locald.sjg.siM.b(locald.mSessionId, paramMessage);
        }
        AppMethodBeat.o(22508);
        return;
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
        if (3 == locald.sjq)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
          AppMethodBeat.o(22508);
          return;
        }
        locald.cyc();
        if (locald.sjf == null)
        {
          Log.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
          AppMethodBeat.o(22508);
          return;
        }
        locald.sjq = 3;
        locald.sjf.disconnect();
        locald.sjf.close();
        locald.sjf = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d
 * JD-Core Version:    0.7.0.1
 */