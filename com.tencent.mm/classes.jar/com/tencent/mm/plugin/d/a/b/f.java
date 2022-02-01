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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int mNQ = 0;
  private int aFj;
  public BluetoothDevice jLq;
  public ap mHandler;
  private BluetoothAdapter mMl;
  private a mNJ;
  private Runnable mNK;
  private f mNL;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> mNM;
  private long mNN;
  private ArrayList<BluetoothGattCharacteristic> mNO;
  private boolean mNP;
  private Context mNj;
  private BluetoothGatt mNk;
  private a mNo;
  private Runnable mNp;
  private Runnable mNr;
  private final LinkedList<byte[]> mNt;
  private volatile boolean mNu;
  private volatile int mNv;
  private final BluetoothGattCallback mNw;
  public long mSessionId;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.mNt = new LinkedList();
    this.mNu = false;
    this.mNM = new HashMap();
    this.mNN = 0L;
    this.mNO = new ArrayList();
    this.mNw = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22529);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22529);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22530);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 0) && (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic)))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22530);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22531);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(7, paramAnonymousInt, 0))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22531);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22526);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.e(f.this)) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(4, paramAnonymousInt2, 0))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22526);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22528);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22528);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22527);
        ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22527);
      }
    };
    this.aFj = -1;
    this.aFj = hashCode();
    this.mNL = this;
    this.mNJ = parama;
    this.mNj = paramContext;
    this.mMl = ((BluetoothManager)this.mNj.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.mNv = 3;
    this.jLq = this.mMl.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.ny(paramLong));
    this.mNo = new a();
    this.mNP = false;
    this.mHandler = new b(com.tencent.e.j.a.aOc("BluetoothLESimpleSession_handlerThread"), this);
    this.mNp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.pe(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).l(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.mNr = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.pe(f.g(f.this)), f.h(f.this).getName() });
        if (3 == f.e(f.this))
        {
          ad.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
          AppMethodBeat.o(22533);
          return;
        }
        if (f.e(f.this) == 1)
        {
          ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
          AppMethodBeat.o(22533);
          return;
        }
        f.this.bBA();
        AppMethodBeat.o(22533);
      }
    };
    this.mNK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22534);
        if (f.k(f.this))
        {
          if (f.i(f.this) != null) {
            f.i(f.this).a(f.g(f.this), false, f.l(f.this));
          }
          ad.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
          f.m(f.this);
        }
        AppMethodBeat.o(22534);
      }
    };
    AppMethodBeat.o(22538);
  }
  
  private void bBB()
  {
    AppMethodBeat.i(22542);
    if (this.mNJ == null)
    {
      ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.pe(this.mSessionId), this.jLq.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.pe(this.mSessionId), this.jLq.getName() });
    if (this.mNJ != null) {
      this.mNJ.a(this.mSessionId, false, this.mNN);
    }
    this.mNJ = null;
    AppMethodBeat.o(22542);
  }
  
  private void bBy()
  {
    AppMethodBeat.i(22541);
    this.mNu = false;
    this.mNt.clear();
    AppMethodBeat.o(22541);
  }
  
  private void bBz()
  {
    AppMethodBeat.i(22543);
    if (this.mNt.isEmpty())
    {
      this.mNu = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.d.a.b.a.a.aH((byte[])this.mNt.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).bBD();
    String str = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).mOt;
    int i = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).mOu;
    localObject = c.nw(((com.tencent.mm.plugin.d.a.b.a.a)localObject).mNN);
    HashMap localHashMap = (HashMap)this.mNM.get(localObject);
    if (localHashMap == null)
    {
      ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.pe(this.mSessionId), this.jLq.getName() });
      if (this.mNJ != null) {
        this.mNJ.l(this.mSessionId, false);
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
        ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.pe(this.mSessionId), this.jLq.getName() });
        if (this.mNJ != null) {
          this.mNJ.l(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.mNo.mMP = ((BluetoothGattCharacteristic)localObject);
      this.mNo.setData(arrayOfByte);
      arrayOfByte = this.mNo.bBt();
      ad.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.be(arrayOfByte), str, b.pe(this.mSessionId), this.jLq.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.mNp, 5000L);
      if (!this.mNk.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.pe(this.mSessionId), this.jLq.getName() });
        if (this.mNJ != null) {
          this.mNJ.l(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.mNu = true;
      AppMethodBeat.o(22543);
      return;
    }
    ad.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.pe(this.mSessionId), this.jLq.getName() });
    if (this.mNJ != null) {
      this.mNJ.l(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.mNk == null)
    {
      ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.pe(this.mSessionId), this.jLq.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    mNQ -= 1;
    ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(mNQ), b.pe(this.mSessionId), this.jLq.getName() });
    this.mNP = false;
    this.mNk.close();
    this.mHandler.quitSafely();
    this.mNk = null;
    AppMethodBeat.o(22539);
  }
  
  final void bBA()
  {
    AppMethodBeat.i(22537);
    ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.pe(this.mSessionId), this.jLq.getName() });
    this.mNv = 2;
    this.mHandler.removeCallbacks(this.mNr);
    this.mHandler.removeCallbacks(this.mNK);
    bBB();
    releaseResources();
    AppMethodBeat.o(22537);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22540);
    ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.pe(this.mSessionId), this.jLq.getName() });
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22540);
    return bool;
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void b(long paramLong, byte[] paramArrayOfByte) {}
    
    public void l(long paramLong, boolean paramBoolean) {}
  }
  
  static final class b
    extends ap
  {
    private final WeakReference<f> mNy;
    
    public b(com.tencent.e.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.mNy = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.mNy.get();
      if (localf == null)
      {
        ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
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
          ad.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.pe(localf.mSessionId), localf.jLq.getName() });
          if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1))) {
            ad.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
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