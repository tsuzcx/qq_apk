package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int nWE = 0;
  private int aHQ;
  public BluetoothDevice kKg;
  public aq mHandler;
  public long mSessionId;
  private BluetoothAdapter nUZ;
  private Context nVX;
  private BluetoothGatt nVY;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> nWA;
  private long nWB;
  private ArrayList<BluetoothGattCharacteristic> nWC;
  private boolean nWD;
  private a nWc;
  private Runnable nWd;
  private Runnable nWf;
  private final LinkedList<byte[]> nWh;
  private volatile boolean nWi;
  private volatile int nWj;
  private final BluetoothGattCallback nWk;
  private a nWx;
  private Runnable nWy;
  private f nWz;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.nWh = new LinkedList();
    this.nWi = false;
    this.nWA = new HashMap();
    this.nWB = 0L;
    this.nWC = new ArrayList();
    this.nWk = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22529);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22529);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22530);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 0) && (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic)))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22530);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22531);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(7, paramAnonymousInt, 0))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22531);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22526);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.e(f.this)) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(4, paramAnonymousInt2, 0))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22526);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22528);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22528);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22527);
        ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22527);
      }
    };
    this.aHQ = -1;
    this.aHQ = hashCode();
    this.nWz = this;
    this.nWx = parama;
    this.nVX = paramContext;
    this.nUZ = ((BluetoothManager)this.nVX.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.nWj = 3;
    this.kKg = this.nUZ.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.tw(paramLong));
    this.nWc = new a();
    this.nWD = false;
    this.mHandler = new b(com.tencent.e.j.a.bbi("BluetoothLESimpleSession_handlerThread"), this);
    this.nWd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.vf(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).m(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.nWf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.vf(f.g(f.this)), f.h(f.this).getName() });
        if (3 == f.e(f.this))
        {
          ae.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
          AppMethodBeat.o(22533);
          return;
        }
        if (f.e(f.this) == 1)
        {
          ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
          AppMethodBeat.o(22533);
          return;
        }
        f.this.bNJ();
        AppMethodBeat.o(22533);
      }
    };
    this.nWy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22534);
        if (f.k(f.this))
        {
          if (f.i(f.this) != null) {
            f.i(f.this).a(f.g(f.this), false, f.l(f.this));
          }
          ae.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
          f.m(f.this);
        }
        AppMethodBeat.o(22534);
      }
    };
    AppMethodBeat.o(22538);
  }
  
  private void bNH()
  {
    AppMethodBeat.i(22541);
    this.nWi = false;
    this.nWh.clear();
    AppMethodBeat.o(22541);
  }
  
  private void bNI()
  {
    AppMethodBeat.i(22543);
    if (this.nWh.isEmpty())
    {
      this.nWi = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.d.a.b.a.a.aG((byte[])this.nWh.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).bNM();
    String str = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).nXh;
    int i = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).nXi;
    localObject = c.tu(((com.tencent.mm.plugin.d.a.b.a.a)localObject).nWB);
    HashMap localHashMap = (HashMap)this.nWA.get(localObject);
    if (localHashMap == null)
    {
      ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.vf(this.mSessionId), this.kKg.getName() });
      if (this.nWx != null) {
        this.nWx.m(this.mSessionId, false);
      }
      AppMethodBeat.o(22543);
      return;
    }
    localObject = (BluetoothGattCharacteristic)localHashMap.get(str);
    if (localObject == null)
    {
      if (str == null) {
        str = "null";
      }
      for (;;)
      {
        ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.vf(this.mSessionId), this.kKg.getName() });
        if (this.nWx != null) {
          this.nWx.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.nWc.nVD = ((BluetoothGattCharacteristic)localObject);
      this.nWc.setData(arrayOfByte);
      arrayOfByte = this.nWc.bNC();
      ae.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.bf(arrayOfByte), str, b.vf(this.mSessionId), this.kKg.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.nWd, 5000L);
      if (!this.nVY.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.vf(this.mSessionId), this.kKg.getName() });
        if (this.nWx != null) {
          this.nWx.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.nWi = true;
      AppMethodBeat.o(22543);
      return;
    }
    ae.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.vf(this.mSessionId), this.kKg.getName() });
    if (this.nWx != null) {
      this.nWx.m(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void bNK()
  {
    AppMethodBeat.i(22542);
    if (this.nWx == null)
    {
      ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.vf(this.mSessionId), this.kKg.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.vf(this.mSessionId), this.kKg.getName() });
    if (this.nWx != null) {
      this.nWx.a(this.mSessionId, false, this.nWB);
    }
    this.nWx = null;
    AppMethodBeat.o(22542);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.nVY == null)
    {
      ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.vf(this.mSessionId), this.kKg.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    nWE -= 1;
    ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(nWE), b.vf(this.mSessionId), this.kKg.getName() });
    this.nWD = false;
    this.nVY.close();
    this.mHandler.quitSafely();
    this.nVY = null;
    AppMethodBeat.o(22539);
  }
  
  final void bNJ()
  {
    AppMethodBeat.i(22537);
    ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.vf(this.mSessionId), this.kKg.getName() });
    this.nWj = 2;
    this.mHandler.removeCallbacks(this.nWf);
    this.mHandler.removeCallbacks(this.nWy);
    bNK();
    releaseResources();
    AppMethodBeat.o(22537);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22540);
    ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.vf(this.mSessionId), this.kKg.getName() });
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22540);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void m(long paramLong, boolean paramBoolean) {}
  }
  
  static final class b
    extends aq
  {
    private final WeakReference<f> nWm;
    
    public b(com.tencent.e.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.nWm = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.nWm.get();
      if (localf == null)
      {
        ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
        AppMethodBeat.o(22536);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(22536);
        return;
        f.a(localf);
        AppMethodBeat.o(22536);
        return;
        if ((localf == null) || (paramMessage == null))
        {
          AppMethodBeat.o(22536);
          return;
        }
        f.a(localf, paramMessage.arg1);
        AppMethodBeat.o(22536);
        return;
        if (!f.a(localf, (BluetoothGatt)paramMessage.obj, paramMessage.arg1))
        {
          ae.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.vf(localf.mSessionId), localf.kKg.getName() });
          if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1))) {
            ae.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
          }
          AppMethodBeat.o(22536);
          return;
          Object localObject = paramMessage.obj;
          f.b(localf, paramMessage.arg1);
          AppMethodBeat.o(22536);
          return;
          f.b(localf);
          AppMethodBeat.o(22536);
          return;
          f.a(localf, (byte[])paramMessage.obj);
          AppMethodBeat.o(22536);
          return;
          f.c(localf, paramMessage.arg1);
          AppMethodBeat.o(22536);
          return;
          f.a(localf, (BluetoothGattCharacteristic)paramMessage.obj);
          AppMethodBeat.o(22536);
          return;
          f.c(localf);
          AppMethodBeat.o(22536);
          return;
          f.d(localf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */