package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends s.a
{
  protected static final String TAG;
  private boolean oVC;
  f oVD;
  private j.a oVE;
  
  static
  {
    AppMethodBeat.i(23352);
    TAG = h.class.getName();
    AppMethodBeat.o(23352);
  }
  
  public h()
  {
    AppMethodBeat.i(23345);
    this.oVC = false;
    this.oVD = new f();
    this.oVE = new j.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23343);
        com.tencent.mm.sdk.platformtools.ad.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt3), com.tencent.mm.plugin.exdevice.k.b.be(paramAnonymousArrayOfByte) });
        if (1 == paramAnonymousInt1) {
          ad.bZR().n(paramAnonymousString3, paramAnonymousString2, false);
        }
        for (;;)
        {
          if (ad.bZG().pd(com.tencent.mm.plugin.exdevice.k.b.Vg(paramAnonymousString2)) != null) {
            com.tencent.mm.sdk.platformtools.ad.d(h.TAG, "the founded device hasn't been binded");
          }
          AppMethodBeat.o(23343);
          return;
          if (2 == paramAnonymousInt1) {
            ad.bZR().n(paramAnonymousString3, paramAnonymousString2, true);
          } else {
            com.tencent.mm.sdk.platformtools.ad.e(h.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "no data for transmit");
      AppMethodBeat.o(23350);
      return false;
    }
    if (u.cai().oTC == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "can not send data");
      AppMethodBeat.o(23350);
      return false;
    }
    boolean bool = u.cai().oTC.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(23350);
    return bool;
  }
  
  public static void oH(long paramLong)
  {
    AppMethodBeat.i(23349);
    d locald = ad.bZN();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.oTH == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23349);
      return;
    }
    if (u.cai().oTC == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23349);
      return;
    }
    if (!u.cai().oTC.pc(paramLong)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(23349);
  }
  
  public final void a(long paramLong, final a parama)
  {
    AppMethodBeat.i(23348);
    Object localObject = this.oVD.oU(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).dgF))
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "device(" + paramLong + ") has been connected");
      parama.b(paramLong, 2, 2, 0, ((f.a)localObject).mNN);
      AppMethodBeat.o(23348);
      return;
    }
    localObject = ad.bZN();
    parama = new k.a()
    {
      public final void b(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23344);
        com.tencent.mm.sdk.platformtools.ad.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        f.a locala = h.a(h.this).oU(paramAnonymousLong1);
        if (locala != null)
        {
          locala.dgF = paramAnonymousInt2;
          locala.mNN = paramAnonymousLong2;
        }
        for (;;)
        {
          parama.b(paramAnonymousLong1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong2);
          AppMethodBeat.o(23344);
          return;
          com.tencent.mm.sdk.platformtools.ad.i(h.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
        }
      }
    };
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((d)localObject).oTH == null)
    {
      ((d)localObject).oTH = new com.tencent.mm.plugin.exdevice.service.c();
      ((d)localObject).oTH.oZg = new d.3((d)localObject, paramLong, parama);
      ((d)localObject).oTH.ew(aj.getContext());
      AppMethodBeat.o(23348);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.cai().oTC;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(23348);
  }
  
  public final void bZw()
  {
    AppMethodBeat.i(23346);
    if (this.oVC)
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "still scanning. return");
      AppMethodBeat.o(23346);
      return;
    }
    d locald = ad.bZN();
    j.a locala = this.oVE;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.oTH == null)
    {
      locald.oTH = new com.tencent.mm.plugin.exdevice.service.c();
      locald.oTH.oZg = new d.2(locald, locala);
      locald.oTH.ew(aj.getContext());
    }
    for (;;)
    {
      this.oVC = true;
      AppMethodBeat.o(23346);
      return;
      if (u.cai().oTC == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.cai().oTC.a(locala)) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23351);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "data is null or nil");
      AppMethodBeat.o(23351);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.k.b.be(paramArrayOfByte) });
    Object localObject1 = ad.bZR();
    String str = com.tencent.mm.plugin.exdevice.k.b.pe(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).oUa)
    {
      localLinkedList = new LinkedList(((e)localObject1).oUa);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).oUb.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new ex();
    ((ex)localObject1).dhu.mac = str;
    ((ex)localObject1).dhu.data = paramArrayOfByte;
    a.ESL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(23351);
  }
  
  public final void stopScan()
  {
    AppMethodBeat.i(23347);
    if (!this.oVC)
    {
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "not yet scan. return");
      AppMethodBeat.o(23347);
      return;
    }
    d locald = ad.bZN();
    j.a locala = this.oVE;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.oTH == null) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.oVC = false;
      AppMethodBeat.o(23347);
      return;
      if (u.cai().oTC == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.cai().oTC.b(locala)) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */