package com.tencent.mm.plugin.f.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.f.a.b.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@TargetApi(18)
public final class f
{
  static int hUT = 0;
  private int auK = -1;
  public BluetoothDevice gof;
  private BluetoothAdapter hTo;
  private f.a hUM;
  private Runnable hUN;
  private f hUO = this;
  private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> hUP = new HashMap();
  private long hUQ = 0L;
  private ArrayList<BluetoothGattCharacteristic> hUR = new ArrayList();
  private boolean hUS;
  private Context hUm;
  private BluetoothGatt hUn;
  private a hUr;
  private Runnable hUs;
  private Runnable hUu;
  private final LinkedList<byte[]> hUw = new LinkedList();
  private volatile boolean hUx = false;
  private volatile int hUy;
  private final BluetoothGattCallback hUz = new f.1(this);
  public ah mHandler;
  public long mSessionId;
  private HandlerThread mThread;
  
  @TargetApi(18)
  public f(long paramLong, Context paramContext, f.a parama)
  {
    this.hUM = parama;
    this.hUm = paramContext;
    this.hTo = ((BluetoothManager)this.hUm.getSystemService("bluetooth")).getAdapter();
    this.mSessionId = paramLong;
    this.hUy = 3;
    this.gof = this.hTo.getRemoteDevice(com.tencent.mm.plugin.f.a.e.a.cM(paramLong));
    this.hUr = new a();
    this.hUS = false;
    this.mThread = e.aap("BluetoothLESimpleSession_handlerThread");
    this.mThread.start();
    this.mHandler = new f.b(this.mThread.getLooper(), this);
    this.hUs = new f.2(this);
    this.hUu = new f.3(this);
    this.hUN = new f.4(this);
  }
  
  private void awt()
  {
    this.hUx = false;
    this.hUw.clear();
  }
  
  private void awu()
  {
    if (this.hUw.isEmpty()) {
      this.hUx = false;
    }
    label384:
    do
    {
      int i;
      do
      {
        String str;
        HashMap localHashMap;
        do
        {
          return;
          localObject = com.tencent.mm.plugin.f.a.b.a.a.Z((byte[])this.hUw.pop());
          arrayOfByte = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).awy();
          str = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).hVw;
          i = ((com.tencent.mm.plugin.f.a.b.a.a)localObject).hVx;
          localObject = c.cK(((com.tencent.mm.plugin.f.a.b.a.a)localObject).hUQ);
          localHashMap = (HashMap)this.hUP.get(localObject);
          if (localHashMap != null) {
            break;
          }
          y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[] { localObject, b.ee(this.mSessionId), this.gof.getName() });
        } while (this.hUM == null);
        this.hUM.j(this.mSessionId, false);
        return;
        Object localObject = (BluetoothGattCharacteristic)localHashMap.get(str);
        if (localObject == null)
        {
          if (str == null) {
            str = "null";
          }
          for (;;)
          {
            y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", new Object[] { str, b.ee(this.mSessionId), this.gof.getName() });
            if (this.hUM == null) {
              break;
            }
            this.hUM.j(this.mSessionId, false);
            return;
          }
        }
        if (i != 8) {
          break label384;
        }
        this.hUr.hTS = ((BluetoothGattCharacteristic)localObject);
        this.hUr.setData(arrayOfByte);
        byte[] arrayOfByte = this.hUr.awo();
        y.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[] { b.aq(arrayOfByte), str, b.ee(this.mSessionId), this.gof.getName() });
        ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
        this.mHandler.postDelayed(this.hUs, 5000L);
        if (this.hUn.writeCharacteristic((BluetoothGattCharacteristic)localObject)) {
          break;
        }
        y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[] { b.ee(this.mSessionId), this.gof.getName() });
      } while (this.hUM == null);
      this.hUM.j(this.mSessionId, false);
      return;
      this.hUx = true;
      return;
      y.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[] { Integer.valueOf(i), b.ee(this.mSessionId), this.gof.getName() });
    } while (this.hUM == null);
    this.hUM.j(this.mSessionId, false);
  }
  
  private void aww()
  {
    if (this.hUM == null)
    {
      y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[] { b.ee(this.mSessionId), this.gof.getName() });
      return;
    }
    y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[] { b.ee(this.mSessionId), this.gof.getName() });
    if (this.hUM != null) {
      this.hUM.a(this.mSessionId, false, this.hUQ);
    }
    this.hUM = null;
  }
  
  private void releaseResources()
  {
    if (this.hUn == null)
    {
      y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), b.ee(this.mSessionId), this.gof.getName() });
      return;
    }
    hUT -= 1;
    y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(hUT), b.ee(this.mSessionId), this.gof.getName() });
    this.hUS = false;
    this.hUn.close();
    this.mThread.quitSafely();
    this.hUn = null;
    this.mThread = null;
  }
  
  final void awv()
  {
    y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[] { b.ee(this.mSessionId), this.gof.getName() });
    this.hUy = 2;
    this.mHandler.removeCallbacks(this.hUu);
    this.mHandler.removeCallbacks(this.hUN);
    aww();
    releaseResources();
  }
  
  public final boolean connect()
  {
    y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[] { b.ee(this.mSessionId), this.gof.getName() });
    return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f
 * JD-Core Version:    0.7.0.1
 */