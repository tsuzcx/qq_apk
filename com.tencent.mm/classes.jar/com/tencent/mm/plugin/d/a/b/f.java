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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int nqc = 0;
  private int aFZ;
  public BluetoothDevice klR;
  public ao mHandler;
  public long mSessionId;
  private BluetoothAdapter nox;
  private a npA;
  private Runnable npB;
  private Runnable npD;
  private final LinkedList<byte[]> npF;
  private volatile boolean npG;
  private volatile int npH;
  private final BluetoothGattCallback npI;
  private a npV;
  private Runnable npW;
  private f npX;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> npY;
  private long npZ;
  private Context npv;
  private BluetoothGatt npw;
  private ArrayList<BluetoothGattCharacteristic> nqa;
  private boolean nqb;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.npF = new LinkedList();
    this.npG = false;
    this.npY = new HashMap();
    this.npZ = 0L;
    this.nqa = new ArrayList();
    this.npI = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22529);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22529);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22530);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 0) && (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic)))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22530);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22531);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(7, paramAnonymousInt, 0))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22531);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22526);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.e(f.this)) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(4, paramAnonymousInt2, 0))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22526);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22528);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22528);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22527);
        ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22527);
      }
    };
    this.aFZ = -1;
    this.aFZ = hashCode();
    this.npX = this;
    this.npV = parama;
    this.npv = paramContext;
    this.nox = ((BluetoothManager)this.npv.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.npH = 3;
    this.klR = this.nox.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.rk(paramLong));
    this.npA = new a();
    this.nqb = false;
    this.mHandler = new b(com.tencent.e.j.a.aTF("BluetoothLESimpleSession_handlerThread"), this);
    this.npB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.sQ(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).m(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.npD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.sQ(f.g(f.this)), f.h(f.this).getName() });
        if (3 == f.e(f.this))
        {
          ac.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
          AppMethodBeat.o(22533);
          return;
        }
        if (f.e(f.this) == 1)
        {
          ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
          AppMethodBeat.o(22533);
          return;
        }
        f.this.bIy();
        AppMethodBeat.o(22533);
      }
    };
    this.npW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22534);
        if (f.k(f.this))
        {
          if (f.i(f.this) != null) {
            f.i(f.this).a(f.g(f.this), false, f.l(f.this));
          }
          ac.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
          f.m(f.this);
        }
        AppMethodBeat.o(22534);
      }
    };
    AppMethodBeat.o(22538);
  }
  
  private void bIw()
  {
    AppMethodBeat.i(22541);
    this.npG = false;
    this.npF.clear();
    AppMethodBeat.o(22541);
  }
  
  private void bIx()
  {
    AppMethodBeat.i(22543);
    if (this.npF.isEmpty())
    {
      this.npG = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.d.a.b.a.a.aG((byte[])this.npF.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).bIB();
    String str = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).nqF;
    int i = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).nqG;
    localObject = c.ri(((com.tencent.mm.plugin.d.a.b.a.a)localObject).npZ);
    HashMap localHashMap = (HashMap)this.npY.get(localObject);
    if (localHashMap == null)
    {
      ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.sQ(this.mSessionId), this.klR.getName() });
      if (this.npV != null) {
        this.npV.m(this.mSessionId, false);
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
        ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.sQ(this.mSessionId), this.klR.getName() });
        if (this.npV != null) {
          this.npV.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.npA.npb = ((BluetoothGattCharacteristic)localObject);
      this.npA.setData(arrayOfByte);
      arrayOfByte = this.npA.bIr();
      ac.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.bd(arrayOfByte), str, b.sQ(this.mSessionId), this.klR.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.npB, 5000L);
      if (!this.npw.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.sQ(this.mSessionId), this.klR.getName() });
        if (this.npV != null) {
          this.npV.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.npG = true;
      AppMethodBeat.o(22543);
      return;
    }
    ac.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.sQ(this.mSessionId), this.klR.getName() });
    if (this.npV != null) {
      this.npV.m(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void bIz()
  {
    AppMethodBeat.i(22542);
    if (this.npV == null)
    {
      ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.sQ(this.mSessionId), this.klR.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.sQ(this.mSessionId), this.klR.getName() });
    if (this.npV != null) {
      this.npV.a(this.mSessionId, false, this.npZ);
    }
    this.npV = null;
    AppMethodBeat.o(22542);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.npw == null)
    {
      ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.sQ(this.mSessionId), this.klR.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    nqc -= 1;
    ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(nqc), b.sQ(this.mSessionId), this.klR.getName() });
    this.nqb = false;
    this.npw.close();
    this.mHandler.quitSafely();
    this.npw = null;
    AppMethodBeat.o(22539);
  }
  
  final void bIy()
  {
    AppMethodBeat.i(22537);
    ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.sQ(this.mSessionId), this.klR.getName() });
    this.npH = 2;
    this.mHandler.removeCallbacks(this.npD);
    this.mHandler.removeCallbacks(this.npW);
    bIz();
    releaseResources();
    AppMethodBeat.o(22537);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22540);
    ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.sQ(this.mSessionId), this.klR.getName() });
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
    extends ao
  {
    private final WeakReference<f> npK;
    
    public b(com.tencent.e.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.npK = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.npK.get();
      if (localf == null)
      {
        ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
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
          ac.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.sQ(localf.mSessionId), localf.klR.getName() });
          if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1))) {
            ac.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */