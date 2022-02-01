package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.g.a.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class f
{
  static int vvK = 0;
  private int cHb;
  public MMHandler mHandler;
  public long mSessionId;
  public BluetoothDevice rOZ;
  private BluetoothAdapter vug;
  private a vvD;
  private Runnable vvE;
  private f vvF;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> vvG;
  private long vvH;
  private ArrayList<BluetoothGattCharacteristic> vvI;
  private boolean vvJ;
  private Context vvd;
  private BluetoothGatt vve;
  private a vvi;
  private Runnable vvj;
  private Runnable vvl;
  private final LinkedList<byte[]> vvn;
  private volatile boolean vvo;
  private volatile int vvp;
  private final BluetoothGattCallback vvq;
  
  public f(long paramLong, Context paramContext, a parama)
  {
    AppMethodBeat.i(22538);
    this.vvn = new LinkedList();
    this.vvo = false;
    this.vvG = new HashMap();
    this.vvH = 0L;
    this.vvI = new ArrayList();
    this.vvq = new f.1(this);
    this.cHb = -1;
    this.cHb = hashCode();
    this.vvF = this;
    this.vvD = parama;
    this.vvd = paramContext;
    this.vug = ((BluetoothManager)this.vvd.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.vvp = 3;
    this.rOZ = this.vug.getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.kg(paramLong));
    this.vvi = new a();
    this.vvJ = false;
    this.mHandler = new b(com.tencent.threadpool.j.a.bFV("BluetoothLESimpleSession_handlerThread"), this);
    this.vvj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22532);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.lO(f.g(f.this)), f.h(f.this).getName() });
        if (f.i(f.this) != null) {
          f.i(f.this).s(f.g(f.this), false);
        }
        f.j(f.this);
        AppMethodBeat.o(22532);
      }
    };
    this.vvl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22533);
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.lO(f.g(f.this)), f.h(f.this).getName() });
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
        f.this.daV();
        AppMethodBeat.o(22533);
      }
    };
    this.vvE = new Runnable()
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
  
  private void daT()
  {
    AppMethodBeat.i(22541);
    this.vvo = false;
    this.vvn.clear();
    AppMethodBeat.o(22541);
  }
  
  private void daU()
  {
    AppMethodBeat.i(22543);
    if (this.vvn.isEmpty())
    {
      this.vvo = false;
      AppMethodBeat.o(22543);
      return;
    }
    Object localObject = com.tencent.mm.plugin.g.a.b.a.a.bk((byte[])this.vvn.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.g.a.b.a.a)localObject).daY();
    String str = ((com.tencent.mm.plugin.g.a.b.a.a)localObject).vwn;
    int i = ((com.tencent.mm.plugin.g.a.b.a.a)localObject).vwo;
    localObject = c.ke(((com.tencent.mm.plugin.g.a.b.a.a)localObject).vvH);
    HashMap localHashMap = (HashMap)this.vvG.get(localObject);
    if (localHashMap == null)
    {
      Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.lO(this.mSessionId), this.rOZ.getName() });
      if (this.vvD != null) {
        this.vvD.s(this.mSessionId, false);
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
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.lO(this.mSessionId), this.rOZ.getName() });
        if (this.vvD != null) {
          this.vvD.s(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
    }
    if (i == 8)
    {
      this.vvi.vuK = ((BluetoothGattCharacteristic)localObject);
      this.vvi.setData(arrayOfByte);
      arrayOfByte = this.vvi.daO();
      Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.bK(arrayOfByte), str, b.lO(this.mSessionId), this.rOZ.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.vvj, 5000L);
      if (!this.vve.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.lO(this.mSessionId), this.rOZ.getName() });
        if (this.vvD != null) {
          this.vvD.s(this.mSessionId, false);
        }
        AppMethodBeat.o(22543);
        return;
      }
      this.vvo = true;
      AppMethodBeat.o(22543);
      return;
    }
    Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.lO(this.mSessionId), this.rOZ.getName() });
    if (this.vvD != null) {
      this.vvD.s(this.mSessionId, false);
    }
    AppMethodBeat.o(22543);
  }
  
  private void daW()
  {
    AppMethodBeat.i(22542);
    if (this.vvD == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.lO(this.mSessionId), this.rOZ.getName() });
      AppMethodBeat.o(22542);
      return;
    }
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.lO(this.mSessionId), this.rOZ.getName() });
    if (this.vvD != null) {
      this.vvD.a(this.mSessionId, false, this.vvH);
    }
    this.vvD = null;
    AppMethodBeat.o(22542);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(22539);
    if (this.vve == null)
    {
      Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.lO(this.mSessionId), this.rOZ.getName() });
      AppMethodBeat.o(22539);
      return;
    }
    vvK -= 1;
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(vvK), b.lO(this.mSessionId), this.rOZ.getName() });
    this.vvJ = false;
    this.vve.close();
    this.mHandler.quitSafely();
    this.vve = null;
    AppMethodBeat.o(22539);
  }
  
  public final boolean cmB()
  {
    AppMethodBeat.i(22540);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.lO(this.mSessionId), this.rOZ.getName() });
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(22540);
    return bool;
  }
  
  final void daV()
  {
    AppMethodBeat.i(22537);
    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.lO(this.mSessionId), this.rOZ.getName() });
    this.vvp = 2;
    this.mHandler.removeCallbacks(this.vvl);
    this.mHandler.removeCallbacks(this.vvE);
    daW();
    releaseResources();
    AppMethodBeat.o(22537);
  }
  
  public static abstract class a
  {
    public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
    
    public void c(long paramLong, byte[] paramArrayOfByte) {}
    
    public void s(long paramLong, boolean paramBoolean) {}
  }
  
  static final class b
    extends MMHandler
  {
    private final WeakReference<f> vvs;
    
    public b(com.tencent.threadpool.j.a parama, f paramf)
    {
      super();
      AppMethodBeat.i(179582);
      this.vvs = new WeakReference(paramf);
      AppMethodBeat.o(179582);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(22536);
      f localf = (f)this.vvs.get();
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
          Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[] { b.lO(localf.mSessionId), localf.rOZ.getName() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.f
 * JD-Core Version:    0.7.0.1
 */