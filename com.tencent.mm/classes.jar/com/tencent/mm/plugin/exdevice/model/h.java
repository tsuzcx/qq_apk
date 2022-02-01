package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fm;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class h
  extends s.a
{
  protected static final String TAG;
  private boolean vfA;
  f vfB;
  private j.a vfC;
  
  static
  {
    AppMethodBeat.i(23352);
    TAG = h.class.getName();
    AppMethodBeat.o(23352);
  }
  
  public h()
  {
    AppMethodBeat.i(23345);
    this.vfA = false;
    this.vfB = new f();
    this.vfC = new j.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23343);
        Log.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt3), b.bK(paramAnonymousArrayOfByte) });
        if (1 == paramAnonymousInt1) {
          ae.cZJ().p(paramAnonymousString3, paramAnonymousString2, false);
        }
        for (;;)
        {
          if (ae.cZx().Jw(b.avW(paramAnonymousString2)) != null) {
            Log.d(h.TAG, "the founded device hasn't been binded");
          }
          AppMethodBeat.o(23343);
          return;
          if (2 == paramAnonymousInt1) {
            ae.cZJ().p(paramAnonymousString3, paramAnonymousString2, true);
          } else {
            Log.e(h.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          }
        }
      }
    };
    AppMethodBeat.o(23345);
  }
  
  public static void IW(long paramLong)
  {
    AppMethodBeat.i(23349);
    d locald = ae.cZF();
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.vdE == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23349);
      return;
    }
    if (u.dal().vdz == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23349);
      return;
    }
    if (!u.dal().vdz.Jv(paramLong)) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(23349);
  }
  
  public static boolean a(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(23350);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e(TAG, "no data for transmit");
      AppMethodBeat.o(23350);
      return false;
    }
    if (u.dal().vdz == null)
    {
      Log.e(TAG, "can not send data");
      AppMethodBeat.o(23350);
      return false;
    }
    boolean bool = u.dal().vdz.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      Log.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(23350);
    return bool;
  }
  
  public final void a(long paramLong, final a parama)
  {
    AppMethodBeat.i(23348);
    Object localObject = this.vfB.Jn(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).fAF))
    {
      Log.d(TAG, "device(" + paramLong + ") has been connected");
      parama.a(paramLong, 2, 2, 0, ((f.a)localObject).sjI);
      AppMethodBeat.o(23348);
      return;
    }
    localObject = ae.cZF();
    parama = new k.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23344);
        Log.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        f.a locala = h.a(h.this).Jn(paramAnonymousLong1);
        if (locala != null)
        {
          locala.fAF = paramAnonymousInt2;
          locala.sjI = paramAnonymousLong2;
        }
        for (;;)
        {
          parama.a(paramAnonymousLong1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong2);
          AppMethodBeat.o(23344);
          return;
          Log.i(h.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
        }
      }
    };
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((d)localObject).vdE == null)
    {
      ((d)localObject).vdE = new com.tencent.mm.plugin.exdevice.service.c();
      ((d)localObject).vdE.vjh = new d.3((d)localObject, paramLong, parama);
      ((d)localObject).vdE.fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23348);
      return;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.dal().vdz;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(23348);
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23351);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e(TAG, "data is null or nil");
      AppMethodBeat.o(23351);
      return;
    }
    Log.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), b.bK(paramArrayOfByte) });
    Object localObject1 = ae.cZJ();
    String str = b.Jx(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).vdX)
    {
      localLinkedList = new LinkedList(((e)localObject1).vdX);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new fm();
    ((fm)localObject1).fBt.mac = str;
    ((fm)localObject1).fBt.data = paramArrayOfByte;
    EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(23351);
  }
  
  public final void cZm()
  {
    AppMethodBeat.i(23346);
    if (this.vfA)
    {
      Log.d(TAG, "still scanning. return");
      AppMethodBeat.o(23346);
      return;
    }
    d locald = ae.cZF();
    j.a locala = this.vfC;
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.vdE == null)
    {
      locald.vdE = new com.tencent.mm.plugin.exdevice.service.c();
      locald.vdE.vjh = new d.2(locald, locala);
      locald.vdE.fg(MMApplicationContext.getContext());
    }
    for (;;)
    {
      this.vfA = true;
      AppMethodBeat.o(23346);
      return;
      if (u.dal().vdz == null)
      {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.dal().vdz.a(locala)) {
          Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void cxT()
  {
    AppMethodBeat.i(23347);
    if (!this.vfA)
    {
      Log.d(TAG, "not yet scan. return");
      AppMethodBeat.o(23347);
      return;
    }
    d locald = ae.cZF();
    j.a locala = this.vfC;
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.vdE == null) {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.vfA = false;
      AppMethodBeat.o(23347);
      return;
      if (u.dal().vdz == null) {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.dal().vdz.b(locala)) {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */