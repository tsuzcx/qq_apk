package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int jON = 0;
  private int axc;
  public BluetoothDevice hIc;
  private BluetoothAdapter jNi;
  private f.a jOG;
  private Runnable jOH;
  private f jOI;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> jOJ;
  private long jOK;
  private ArrayList<BluetoothGattCharacteristic> jOL;
  private boolean jOM;
  private Context jOg;
  private BluetoothGatt jOh;
  private a jOl;
  private Runnable jOm;
  private Runnable jOo;
  private final LinkedList<byte[]> jOq;
  private volatile boolean jOr;
  private volatile int jOs;
  private final BluetoothGattCallback jOt;
  public ak mHandler;
  public long mSessionId;
  private HandlerThread mThread;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, f.a parama)
  {
    AppMethodBeat.i(18427);
    this.jOq = new LinkedList();
    this.jOr = false;
    this.jOJ = new HashMap();
    this.jOK = 0L;
    this.jOL = new ArrayList();
    this.jOt = new f.1(this);
    this.axc = -1;
    this.axc = hashCode();
    this.jOI = this;
    this.jOG = parama;
    this.jOg = paramContext;
    this.jNi = ((BluetoothManager)this.jOg.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.jOs = 3;
    this.hIc = this.jNi.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.hO(paramLong));
    this.jOl = new a();
    this.jOM = false;
    this.mThread = d.aqu("BluetoothLESimpleSession_handlerThread");
    this.mThread.start();
    this.mHandler = new f.b(this.mThread.getLooper(), this);
    this.jOm = new f.2(this);
    this.jOo = new f.3(this);
    this.jOH = new f.4(this);
    AppMethodBeat.o(18427);
  }
  
  private void aVW()
  {
    AppMethodBeat.i(18430);
    this.jOr = false;
    this.jOq.clear();
    AppMethodBeat.o(18430);
  }
  
  private void aVX()
  {
    AppMethodBeat.i(18432);
    if (this.jOq.isEmpty())
    {
      this.jOr = false;
      AppMethodBeat.o(18432);
      return;
    }
    Object localObject = com.tencent.mm.plugin.d.a.b.a.a.as((byte[])this.jOq.pop());
    byte[] arrayOfByte = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).aWb();
    String str = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).jPq;
    int i = ((com.tencent.mm.plugin.d.a.b.a.a)localObject).jPr;
    localObject = c.hM(((com.tencent.mm.plugin.d.a.b.a.a)localObject).jOK);
    HashMap localHashMap = (HashMap)this.jOJ.get(localObject);
    if (localHashMap == null)
    {
      ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.jw(this.mSessionId), this.hIc.getName() });
      if (this.jOG != null) {
        this.jOG.m(this.mSessionId, false);
      }
      AppMethodBeat.o(18432);
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
        ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.jw(this.mSessionId), this.hIc.getName() });
        if (this.jOG != null) {
          this.jOG.m(this.mSessionId, false);
        }
        AppMethodBeat.o(18432);
        return;
      }
    }
    if (i == 8)
    {
      this.jOl.jNM = ((BluetoothGattCharacteristic)localObject);
      this.jOl.setData(arrayOfByte);
      arrayOfByte = this.jOl.aVR();
      ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.aO(arrayOfByte), str, b.jw(this.mSessionId), this.hIc.getName() });
      ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
      this.mHandler.postDelayed(this.jOm, 5000L);
      if (!this.jOh.writeCharacteristic((BluetoothGattCharacteristic)localObject))
      {
        ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.jw(this.mSessionId), this.hIc.getName() });
        if (this.jOG != null) {
          this.jOG.m(this.mSessionId, false);
        }
        AppMethodBeat.o(18432);
        return;
      }
      this.jOr = true;
      AppMethodBeat.o(18432);
      return;
    }
    ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.jw(this.mSessionId), this.hIc.getName() });
    if (this.jOG != null) {
      this.jOG.m(this.mSessionId, false);
    }
    AppMethodBeat.o(18432);
  }
  
  private void aVZ()
  {
    AppMethodBeat.i(18431);
    if (this.jOG == null)
    {
      ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.jw(this.mSessionId), this.hIc.getName() });
      AppMethodBeat.o(18431);
      return;
    }
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.jw(this.mSessionId), this.hIc.getName() });
    if (this.jOG != null) {
      this.jOG.a(this.mSessionId, false, this.jOK);
    }
    this.jOG = null;
    AppMethodBeat.o(18431);
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(18428);
    if (this.jOh == null)
    {
      ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.jw(this.mSessionId), this.hIc.getName() });
      AppMethodBeat.o(18428);
      return;
    }
    jON -= 1;
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(jON), b.jw(this.mSessionId), this.hIc.getName() });
    this.jOM = false;
    this.jOh.close();
    this.mThread.quitSafely();
    this.jOh = null;
    this.mThread = null;
    AppMethodBeat.o(18428);
  }
  
  final void aVY()
  {
    AppMethodBeat.i(18426);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.jw(this.mSessionId), this.hIc.getName() });
    this.jOs = 2;
    this.mHandler.removeCallbacks(this.jOo);
    this.mHandler.removeCallbacks(this.jOH);
    aVZ();
    releaseResources();
    AppMethodBeat.o(18426);
  }
  
  public final boolean connect()
  {
    AppMethodBeat.i(18429);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.jw(this.mSessionId), this.hIc.getName() });
    boolean bool = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    AppMethodBeat.o(18429);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */