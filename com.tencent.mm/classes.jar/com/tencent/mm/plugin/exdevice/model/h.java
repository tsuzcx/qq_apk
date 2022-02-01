package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends s.a
{
  protected static final String TAG;
  private boolean qiX;
  f qiY;
  private j.a qiZ;
  
  static
  {
    AppMethodBeat.i(23352);
    TAG = h.class.getName();
    AppMethodBeat.o(23352);
  }
  
  public h()
  {
    AppMethodBeat.i(23345);
    this.qiX = false;
    this.qiY = new f();
    this.qiZ = new j.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23343);
        ae.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt3), com.tencent.mm.plugin.exdevice.k.b.bf(paramAnonymousArrayOfByte) });
        if (1 == paramAnonymousInt1) {
          ad.cmU().n(paramAnonymousString3, paramAnonymousString2, false);
        }
        for (;;)
        {
          if (ad.cmJ().ve(com.tencent.mm.plugin.exdevice.k.b.adP(paramAnonymousString2)) != null) {
            ae.d(h.TAG, "the founded device hasn't been binded");
          }
          AppMethodBeat.o(23343);
          return;
          if (2 == paramAnonymousInt1) {
            ad.cmU().n(paramAnonymousString3, paramAnonymousString2, true);
          } else {
            ae.e(h.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          }
        }
      }
    };
    AppMethodBeat.o(23345);
  }
  
  public static boolean a(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(23350);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ae.e(TAG, "no data for transmit");
      AppMethodBeat.o(23350);
      return false;
    }
    if (u.cnl().qgX == null)
    {
      ae.e(TAG, "can not send data");
      AppMethodBeat.o(23350);
      return false;
    }
    boolean bool = u.cnl().qgX.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      ae.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(23350);
    return bool;
  }
  
  public static void uI(long paramLong)
  {
    AppMethodBeat.i(23349);
    d locald = ad.cmQ();
    ae.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.qhc == null)
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23349);
      return;
    }
    if (u.cnl().qgX == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23349);
      return;
    }
    if (!u.cnl().qgX.vd(paramLong)) {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(23349);
  }
  
  public final void a(long paramLong, final a parama)
  {
    AppMethodBeat.i(23348);
    Object localObject = this.qiY.uV(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).dqB))
    {
      ae.d(TAG, "device(" + paramLong + ") has been connected");
      parama.a(paramLong, 2, 2, 0, ((f.a)localObject).nWB);
      AppMethodBeat.o(23348);
      return;
    }
    localObject = ad.cmQ();
    parama = new k.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23344);
        ae.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        f.a locala = h.a(h.this).uV(paramAnonymousLong1);
        if (locala != null)
        {
          locala.dqB = paramAnonymousInt2;
          locala.nWB = paramAnonymousLong2;
        }
        for (;;)
        {
          parama.a(paramAnonymousLong1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong2);
          AppMethodBeat.o(23344);
          return;
          ae.i(h.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
        }
      }
    };
    ae.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((d)localObject).qhc == null)
    {
      ((d)localObject).qhc = new com.tencent.mm.plugin.exdevice.service.c();
      ((d)localObject).qhc.qmB = new d.3((d)localObject, paramLong, parama);
      ((d)localObject).qhc.eI(ak.getContext());
      AppMethodBeat.o(23348);
      return;
    }
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.cnl().qgX;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(23348);
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23351);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ae.e(TAG, "data is null or nil");
      AppMethodBeat.o(23351);
      return;
    }
    ae.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.k.b.bf(paramArrayOfByte) });
    Object localObject1 = ad.cmU();
    String str = com.tencent.mm.plugin.exdevice.k.b.vf(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).qhv)
    {
      localLinkedList = new LinkedList(((e)localObject1).qhv);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).qhw.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new fc();
    ((fc)localObject1).drq.mac = str;
    ((fc)localObject1).drq.data = paramArrayOfByte;
    a.IvT.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(23351);
  }
  
  public final void cmz()
  {
    AppMethodBeat.i(23346);
    if (this.qiX)
    {
      ae.d(TAG, "still scanning. return");
      AppMethodBeat.o(23346);
      return;
    }
    d locald = ad.cmQ();
    j.a locala = this.qiZ;
    ae.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.qhc == null)
    {
      locald.qhc = new com.tencent.mm.plugin.exdevice.service.c();
      locald.qhc.qmB = new d.2(locald, locala);
      locald.qhc.eI(ak.getContext());
    }
    for (;;)
    {
      this.qiX = true;
      AppMethodBeat.o(23346);
      return;
      if (u.cnl().qgX == null)
      {
        ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.cnl().qgX.a(locala)) {
          ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void stopScan()
  {
    AppMethodBeat.i(23347);
    if (!this.qiX)
    {
      ae.d(TAG, "not yet scan. return");
      AppMethodBeat.o(23347);
      return;
    }
    d locald = ad.cmQ();
    j.a locala = this.qiZ;
    ae.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.qhc == null) {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.qiX = false;
      AppMethodBeat.o(23347);
      return;
      if (u.cnl().qgX == null) {
        ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.cnl().qgX.b(locala)) {
        ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */