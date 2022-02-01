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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int phA = 0;
  private int aHK;
  public BluetoothDevice lOM;
  public MMHandler mHandler;
  public long mSessionId;
  private BluetoothAdapter pfW;
  private Context pgT;
  private BluetoothGatt pgU;
  private a pgY;
  private Runnable pgZ;
  private Runnable phb;
  private final LinkedList<byte[]> phd;
  private volatile boolean phe;
  private volatile int phf;
  private final BluetoothGattCallback phg;
  private a pht;
  private Runnable phu;
  private f phv;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> phw;
  private long phx;
  private ArrayList<BluetoothGattCharacteristic> phy;
  private boolean phz;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.phd = new LinkedList();
    this.phe = false;
    this.phw = new HashMap();
    this.phx = 0L;
    this.phy = new ArrayList();
    this.phg = new BluetoothGattCallback()
    {
      public final void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
      {
        AppMethodBeat.i(22529);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22529);
      }
      
      public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22530);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 0) && (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(8, paramAnonymousBluetoothGattCharacteristic)))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(8) });
        }
        AppMethodBeat.o(22530);
      }
      
      public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
      {
        AppMethodBeat.i(22531);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(7, paramAnonymousInt, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(7) });
        }
        AppMethodBeat.o(22531);
      }
      
      public final void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(22526);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.e(f.this)) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(4, paramAnonymousInt2, 0))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(4) });
        }
        AppMethodBeat.o(22526);
      }
      
      public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
      {
        AppMethodBeat.i(22528);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(6, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(6) });
        }
        AppMethodBeat.o(22528);
      }
      
      public final void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
      {
        AppMethodBeat.i(22527);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (!f.f(f.this).sendMessage(f.f(f.this).obtainMessage(5, paramAnonymousInt, 0, paramAnonymousBluetoothGatt))) {
          Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(5) });
        }
        AppMethodBeat.o(22527);
      }
    };
    this.aHK = -1;
    this.aHK = hashCode();
    this.phv = this;
    this.pht = parama;
    this.pgT = paramContext;
    this.pfW = ((BluetoothManager)this.pgT.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.phf = 3;
    this.lOM = this.pfW.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.BC(paramLong));
    this.pgY = new a();
    this.phz = false;
    this.mHandler = new b(com.tencent.f.j.a.bqt("BluetoothLESimpleSession_handlerThread"), this);
    this.pgZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.Dj(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).m(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.phb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.Dj(f.g(f.this)), f.h(f.this).getName() });
        if (3 == f.e(f.this))
        {
          Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
          AppMethodBeat.o(22533);
          return;
        }
        if (f.e(f.this) == 1)
        {
          Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
          AppMethodBeat.o(22533);
          return;
        }
        f.this.ckJ();
        AppMethodBeat.o(22533);
      }
    };
    this.phu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22534);
        if (f.k(f.this))
        {
          if (f.i(f.this) != null) {
            f.i(f.this).a(f.g(f.this), false, f.l(f.this));
          }
          Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
          f.m(f.this);
        }
        AppMethodBeat.o(22534);
      }
    };
    AppMethodBeat.o(22538);
  }
  
  private void ckH()
  {
    AppMethodBeat.i(22541);
    this.phe = false;
    this.phd.clear();
    AppMethodBeat.o(22541);
  }
  
  private void ckI()
  {
    AppMethodBeat.i(22543);
    if (this.phd.isEmpty())
    {
      this.phe = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.d.a.b.a.a.aX((byte[])this.phd.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).ckM();
    String str = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).pie;
    int i = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).pif;
    localObject = c.BA(((com.tencent.mm.plugin.d.a.b.a.a)localObject).phx);
    HashMap localHashMap = (HashMap)this.phw.get(localObject);
    if (localHashMap == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.Dj(this.mSessionId), this.lOM.getName() });
      if (this.pht != null) {
        this.pht.m(this.mSessionId, false);
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
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.Dj(this.mSessionId), this.lOM.getName() });
        if (this.pht != null) {
          this.pht.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.pgY.pgA = ((BluetoothGattCharacteristic)localObject);
      this.pgY.setData(arrayOfByte);
      arrayOfByte = this.pgY.ckC();
      Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.bw(arrayOfByte), str, b.Dj(this.mSessionId), this.lOM.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.pgZ, 5000L);
      if (!this.pgU.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.Dj(this.mSessionId), this.lOM.getName() });
        if (this.pht != null) {
          this.pht.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.phe = true;
      AppMethodBeat.o(22543);
      return;
    }
    Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.Dj(this.mSessionId), this.lOM.getName() });
    if (this.pht != null) {
      this.pht.m(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void ckK()
  {
    AppMethodBeat.i(22542);
    if (this.pht == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.Dj(this.mSessionId), this.lOM.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.Dj(this.mSessionId), this.lOM.getName() });
    if (this.pht != null) {
      this.pht.a(this.mSessionId, false, this.phx);
    }
    this.pht = null;
    AppMethodBeat.o(22542);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.pgU == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.Dj(this.mSessionId), this.lOM.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    phA -= 1;
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(phA), b.Dj(this.mSessionId), this.lOM.getName() });
    this.phz = false;
    this.pgU.close();
    this.mHandler.quitSafely();
    this.pgU = null;
    AppMethodBeat.o(22539);
  }
  
  final void ckJ()
  {
    AppMethodBeat.i(22537);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.Dj(this.mSessionId), this.lOM.getName() });
    this.phf = 2;
    this.mHandler.removeCallbacks(this.phb);
    this.mHandler.removeCallbacks(this.phu);
    ckK();
    releaseResources();
    AppMethodBeat.o(22537);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(22540);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.Dj(this.mSessionId), this.lOM.getName() });
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
    extends MMHandler
  {
    private final WeakReference<f> phi;
    
    public b(com.tencent.f.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.phi = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.phi.get();
      if (localf == null)
      {
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
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
          Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.Dj(localf.mSessionId), localf.lOM.getName() });
          if (!localf.mHandler.sendMessage(localf.mHandler.obtainMessage(1))) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[] { Integer.valueOf(1) });
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