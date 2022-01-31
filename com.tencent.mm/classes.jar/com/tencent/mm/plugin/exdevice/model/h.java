package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.h.a.eo;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends s.a
{
  protected static final String TAG = h.class.getName();
  private boolean jvr = false;
  f jvs = new f();
  private j.a jvt = new h.1(this);
  
  public static boolean a(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    boolean bool1 = false;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      y.e(TAG, "no data for transmit");
    }
    boolean bool2;
    do
    {
      return bool1;
      if (u.aMn().jtr == null)
      {
        y.e(TAG, "can not send data");
        return false;
      }
      bool2 = u.aMn().jtr.b(paramLong, paramArrayOfByte, paramt);
      bool1 = bool2;
    } while (bool2);
    y.e(TAG, "simpleBluetoothSendData error");
    return bool2;
  }
  
  public static void dH(long paramLong)
  {
    d locald = ad.aLS();
    y.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.jtw == null) {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    do
    {
      return;
      if (u.aMn().jtr == null)
      {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        return;
      }
    } while (u.aMn().jtr.ec(paramLong));
    y.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
  }
  
  public final void a(long paramLong, h.a parama)
  {
    Object localObject = this.jvs.dU(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).bKp))
    {
      y.d(TAG, "device(" + paramLong + ") has been connected");
      parama.a(paramLong, 2, 2, 0, ((f.a)localObject).hUQ);
    }
    do
    {
      return;
      localObject = ad.aLS();
      parama = new h.2(this, parama);
      y.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
      if (((d)localObject).jtw == null)
      {
        ((d)localObject).jtw = new com.tencent.mm.plugin.exdevice.service.c();
        ((d)localObject).jtw.jyW = new d.3((d)localObject, paramLong, parama);
        ((d)localObject).jtw.da(ae.getContext());
        return;
      }
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
      localObject = u.aMn().jtr;
    } while ((localObject != null) && (((m)localObject).a(paramLong, parama)));
    y.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
  }
  
  public final void aLB()
  {
    if (this.jvr)
    {
      y.d(TAG, "still scanning. return");
      return;
    }
    d locald = ad.aLS();
    j.a locala = this.jvt;
    y.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.jtw == null)
    {
      locald.jtw = new com.tencent.mm.plugin.exdevice.service.c();
      locald.jtw.jyW = new d.2(locald, locala);
      locald.jtw.da(ae.getContext());
    }
    for (;;)
    {
      this.jvr = true;
      return;
      if (u.aMn().jtr == null)
      {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        y.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.aMn().jtr.a(locala)) {
          y.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void awl()
  {
    if (!this.jvr)
    {
      y.d(TAG, "not yet scan. return");
      return;
    }
    d locald = ad.aLS();
    j.a locala = this.jvt;
    y.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.jtw == null) {
      y.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.jvr = false;
      return;
      if (u.aMn().jtr == null) {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.aMn().jtr.b(locala)) {
        y.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      y.e(TAG, "data is null or nil");
      return;
    }
    y.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.j.b.aq(paramArrayOfByte) });
    Object localObject1 = ad.aLW();
    String str = com.tencent.mm.plugin.exdevice.j.b.ee(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).jtP)
    {
      localLinkedList = new LinkedList(((e)localObject1).jtP);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).jtQ.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new eo();
    ((eo)localObject1).bLe.mac = str;
    ((eo)localObject1).bLe.data = paramArrayOfByte;
    a.udP.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */