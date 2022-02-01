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
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.f.a.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int sjL = 0;
  private int aNf;
  public MMHandler mHandler;
  public long mSessionId;
  public BluetoothDevice oLg;
  private BluetoothAdapter sif;
  private a sjE;
  private Runnable sjF;
  private f sjG;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> sjH;
  private long sjI;
  private ArrayList<BluetoothGattCharacteristic> sjJ;
  private boolean sjK;
  private Context sje;
  private BluetoothGatt sjf;
  private a sjj;
  private Runnable sjk;
  private Runnable sjm;
  private final LinkedList<byte[]> sjo;
  private volatile boolean sjp;
  private volatile int sjq;
  private final BluetoothGattCallback sjr;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.sjo = new LinkedList();
    this.sjp = false;
    this.sjH = new HashMap();
    this.sjI = 0L;
    this.sjJ = new ArrayList();
    this.sjr = new BluetoothGattCallback()
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
    this.aNf = -1;
    this.aNf = hashCode();
    this.sjG = this;
    this.sjE = parama;
    this.sje = paramContext;
    this.sif = ((BluetoothManager)this.sje.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.sjq = 3;
    this.oLg = this.sif.getRemoteDevice(com.tencent.mm.plugin.f.a.e.a.HP(paramLong));
    this.sjj = new a();
    this.sjK = false;
    this.mHandler = new b(com.tencent.e.j.a.bDn("BluetoothLESimpleSession_handlerThread"), this);
    this.sjk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.Jx(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).m(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.sjm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.Jx(f.g(f.this)), f.h(f.this).getName() });
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
        f.this.cye();
        AppMethodBeat.o(22533);
      }
    };
    this.sjF = new Runnable()
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
  
  private void cyc()
  {
    AppMethodBeat.i(22541);
    this.sjp = false;
    this.sjo.clear();
    AppMethodBeat.o(22541);
  }
  
  private void cyd()
  {
    AppMethodBeat.i(22543);
    if (this.sjo.isEmpty())
    {
      this.sjp = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.f.a.b.a.a.bk((byte[])this.sjo.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).cyh();
    String str = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).sko;
    int i = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).skp;
    localObject = c.HN(((com.tencent.mm.plugin.f.a.b.a.a)localObject).sjI);
    HashMap localHashMap = (HashMap)this.sjH.get(localObject);
    if (localHashMap == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.Jx(this.mSessionId), this.oLg.getName() });
      if (this.sjE != null) {
        this.sjE.m(this.mSessionId, false);
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
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.Jx(this.mSessionId), this.oLg.getName() });
        if (this.sjE != null) {
          this.sjE.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.sjj.siL = ((BluetoothGattCharacteristic)localObject);
      this.sjj.setData(arrayOfByte);
      arrayOfByte = this.sjj.cxW();
      Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.bK(arrayOfByte), str, b.Jx(this.mSessionId), this.oLg.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.sjk, 5000L);
      if (!this.sjf.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.Jx(this.mSessionId), this.oLg.getName() });
        if (this.sjE != null) {
          this.sjE.m(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.sjp = true;
      AppMethodBeat.o(22543);
      return;
    }
    Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.Jx(this.mSessionId), this.oLg.getName() });
    if (this.sjE != null) {
      this.sjE.m(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void cyf()
  {
    AppMethodBeat.i(22542);
    if (this.sjE == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.Jx(this.mSessionId), this.oLg.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.Jx(this.mSessionId), this.oLg.getName() });
    if (this.sjE != null) {
      this.sjE.a(this.mSessionId, false, this.sjI);
    }
    this.sjE = null;
    AppMethodBeat.o(22542);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.sjf == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.Jx(this.mSessionId), this.oLg.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    sjL -= 1;
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(sjL), b.Jx(this.mSessionId), this.oLg.getName() });
    this.sjK = false;
    this.sjf.close();
    this.mHandler.quitSafely();
    this.sjf = null;
    AppMethodBeat.o(22539);
  }
  
  public final boolean cyb()
  {
    AppMethodBeat.i(22540);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.Jx(this.mSessionId), this.oLg.getName() });
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22540);
    return bool;
  }
  
  final void cye()
  {
    AppMethodBeat.i(22537);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.Jx(this.mSessionId), this.oLg.getName() });
    this.sjq = 2;
    this.mHandler.removeCallbacks(this.sjm);
    this.mHandler.removeCallbacks(this.sjF);
    cyf();
    releaseResources();
    AppMethodBeat.o(22537);
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
    private final WeakReference<f> sjt;
    
    public b(com.tencent.e.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.sjt = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.sjt.get();
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
          Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.Jx(localf.mSessionId), localf.oLg.getName() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f
 * JD-Core Version:    0.7.0.1
 */