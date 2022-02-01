package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends s.a
{
  protected static final String TAG;
  private boolean pyN;
  f pyO;
  private j.a pyP;
  
  static
  {
    AppMethodBeat.i(23352);
    TAG = h.class.getName();
    AppMethodBeat.o(23352);
  }
  
  public h()
  {
    AppMethodBeat.i(23345);
    this.pyN = false;
    this.pyO = new f();
    this.pyP = new j.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23343);
        ac.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt3), com.tencent.mm.plugin.exdevice.k.b.bd(paramAnonymousArrayOfByte) });
        if (1 == paramAnonymousInt1) {
          ad.cha().n(paramAnonymousString3, paramAnonymousString2, false);
        }
        for (;;)
        {
          if (ad.cgP().sP(com.tencent.mm.plugin.exdevice.k.b.Zs(paramAnonymousString2)) != null) {
            ac.d(h.TAG, "the founded device hasn't been binded");
          }
          AppMethodBeat.o(23343);
          return;
          if (2 == paramAnonymousInt1) {
            ad.cha().n(paramAnonymousString3, paramAnonymousString2, true);
          } else {
            ac.e(h.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
      ac.e(TAG, "no data for transmit");
      AppMethodBeat.o(23350);
      return false;
    }
    if (u.chr().pwN == null)
    {
      ac.e(TAG, "can not send data");
      AppMethodBeat.o(23350);
      return false;
    }
    boolean bool = u.chr().pwN.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      ac.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(23350);
    return bool;
  }
  
  public static void st(long paramLong)
  {
    AppMethodBeat.i(23349);
    d locald = ad.cgW();
    ac.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.pwS == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23349);
      return;
    }
    if (u.chr().pwN == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23349);
      return;
    }
    if (!u.chr().pwN.sO(paramLong)) {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(23349);
  }
  
  public final void a(long paramLong, final a parama)
  {
    AppMethodBeat.i(23348);
    Object localObject = this.pyO.sG(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).dea))
    {
      ac.d(TAG, "device(" + paramLong + ") has been connected");
      parama.b(paramLong, 2, 2, 0, ((f.a)localObject).npZ);
      AppMethodBeat.o(23348);
      return;
    }
    localObject = ad.cgW();
    parama = new k.a()
    {
      public final void b(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23344);
        ac.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        f.a locala = h.a(h.this).sG(paramAnonymousLong1);
        if (locala != null)
        {
          locala.dea = paramAnonymousInt2;
          locala.npZ = paramAnonymousLong2;
        }
        for (;;)
        {
          parama.b(paramAnonymousLong1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong2);
          AppMethodBeat.o(23344);
          return;
          ac.i(h.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
        }
      }
    };
    ac.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((d)localObject).pwS == null)
    {
      ((d)localObject).pwS = new com.tencent.mm.plugin.exdevice.service.c();
      ((d)localObject).pwS.pCr = new d.3((d)localObject, paramLong, parama);
      ((d)localObject).pwS.eE(ai.getContext());
      AppMethodBeat.o(23348);
      return;
    }
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.chr().pwN;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(23348);
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23351);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ac.e(TAG, "data is null or nil");
      AppMethodBeat.o(23351);
      return;
    }
    ac.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.k.b.bd(paramArrayOfByte) });
    Object localObject1 = ad.cha();
    String str = com.tencent.mm.plugin.exdevice.k.b.sQ(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).pxl)
    {
      localLinkedList = new LinkedList(((e)localObject1).pxl);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).pxm.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new ey();
    ((ey)localObject1).deP.mac = str;
    ((ey)localObject1).deP.data = paramArrayOfByte;
    a.GpY.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(23351);
  }
  
  public final void cgF()
  {
    AppMethodBeat.i(23346);
    if (this.pyN)
    {
      ac.d(TAG, "still scanning. return");
      AppMethodBeat.o(23346);
      return;
    }
    d locald = ad.cgW();
    j.a locala = this.pyP;
    ac.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.pwS == null)
    {
      locald.pwS = new com.tencent.mm.plugin.exdevice.service.c();
      locald.pwS.pCr = new d.2(locald, locala);
      locald.pwS.eE(ai.getContext());
    }
    for (;;)
    {
      this.pyN = true;
      AppMethodBeat.o(23346);
      return;
      if (u.chr().pwN == null)
      {
        ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.chr().pwN.a(locala)) {
          ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void stopScan()
  {
    AppMethodBeat.i(23347);
    if (!this.pyN)
    {
      ac.d(TAG, "not yet scan. return");
      AppMethodBeat.o(23347);
      return;
    }
    d locald = ad.cgW();
    j.a locala = this.pyP;
    ac.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.pwS == null) {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.pyN = false;
      AppMethodBeat.o(23347);
      return;
      if (u.chr().pwN == null) {
        ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.chr().pwN.b(locala)) {
        ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */