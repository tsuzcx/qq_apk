package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fx;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class j
  extends s.a
{
  protected static final String TAG;
  private boolean yrw;
  com.tencent.mm.plugin.exdevice.service.f yrx;
  private com.tencent.mm.plugin.exdevice.service.j.a yry;
  
  static
  {
    AppMethodBeat.i(23352);
    TAG = j.class.getName();
    AppMethodBeat.o(23352);
  }
  
  public j()
  {
    AppMethodBeat.i(23345);
    this.yrw = false;
    this.yrx = new com.tencent.mm.plugin.exdevice.service.f();
    this.yry = new com.tencent.mm.plugin.exdevice.service.j.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt3, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(23343);
        Log.d(j.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Integer.valueOf(paramAnonymousInt3), b.bK(paramAnonymousArrayOfByte) });
        if (1 == paramAnonymousInt1) {
          ah.dGc().s(paramAnonymousString3, paramAnonymousString2, false);
        }
        for (;;)
        {
          if (ah.dFO().lM(b.apW(paramAnonymousString2)) != null) {
            Log.d(j.TAG, "the founded device hasn't been binded");
          }
          AppMethodBeat.o(23343);
          return;
          if (2 == paramAnonymousInt1) {
            ah.dGc().s(paramAnonymousString3, paramAnonymousString2, true);
          } else {
            Log.e(j.TAG, "unknown message type %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
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
      Log.e(TAG, "no data for transmit");
      AppMethodBeat.o(23350);
      return false;
    }
    if (u.dGE().yps == null)
    {
      Log.e(TAG, "can not send data");
      AppMethodBeat.o(23350);
      return false;
    }
    boolean bool = u.dGE().yps.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      Log.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(23350);
    return bool;
  }
  
  public static void lt(long paramLong)
  {
    AppMethodBeat.i(23349);
    f localf = ah.dFY();
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (localf.ypB == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23349);
      return;
    }
    if (u.dGE().yps == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23349);
      return;
    }
    if (!u.dGE().yps.lL(paramLong)) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(23349);
  }
  
  public final void a(long paramLong, final a parama)
  {
    AppMethodBeat.i(23348);
    Object localObject = this.yrx.lD(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).hFs))
    {
      Log.d(TAG, "device(" + paramLong + ") has been connected");
      parama.a(paramLong, 2, 2, 0, ((f.a)localObject).vvH);
      AppMethodBeat.o(23348);
      return;
    }
    localObject = ah.dFY();
    parama = new k.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23344);
        Log.d(j.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        f.a locala = j.a(j.this).lD(paramAnonymousLong1);
        if (locala != null)
        {
          locala.hFs = paramAnonymousInt2;
          locala.vvH = paramAnonymousLong2;
        }
        for (;;)
        {
          parama.a(paramAnonymousLong1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousLong2);
          AppMethodBeat.o(23344);
          return;
          Log.i(j.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
        }
      }
    };
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((f)localObject).ypB == null)
    {
      ((f)localObject).ypB = new com.tencent.mm.plugin.exdevice.service.c();
      ((f)localObject).ypB.yvg = new f.3((f)localObject, paramLong, parama);
      ((f)localObject).ypB.gd(MMApplicationContext.getContext());
      AppMethodBeat.o(23348);
      return;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.dGE().yps;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(23348);
  }
  
  public final void d(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23351);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.e(TAG, "data is null or nil");
      AppMethodBeat.o(23351);
      return;
    }
    Log.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), b.bK(paramArrayOfByte) });
    Object localObject1 = ah.dGc();
    String str = b.lO(paramLong);
    LinkedList localLinkedList;
    synchronized (((g)localObject1).ypU)
    {
      localLinkedList = new LinkedList(((g)localObject1).ypU);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((g.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    while (((Iterator)localObject1).hasNext()) {
      ((g.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new fx();
    ((fx)localObject1).hGi.mac = str;
    ((fx)localObject1).hGi.data = paramArrayOfByte;
    ((fx)localObject1).asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23351);
  }
  
  public final void dFD()
  {
    AppMethodBeat.i(23346);
    if (this.yrw)
    {
      Log.d(TAG, "still scanning. return");
      AppMethodBeat.o(23346);
      return;
    }
    f localf = ah.dFY();
    com.tencent.mm.plugin.exdevice.service.j.a locala = this.yry;
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (localf.ypB == null)
    {
      localf.ypB = new com.tencent.mm.plugin.exdevice.service.c();
      localf.ypB.yvg = new f.2(localf, locala);
      localf.ypB.gd(MMApplicationContext.getContext());
    }
    for (;;)
    {
      this.yrw = true;
      AppMethodBeat.o(23346);
      return;
      if (u.dGE().yps == null)
      {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.dGE().yps.a(locala)) {
          Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void daL()
  {
    AppMethodBeat.i(23347);
    if (!this.yrw)
    {
      Log.d(TAG, "not yet scan. return");
      AppMethodBeat.o(23347);
      return;
    }
    f localf = ah.dFY();
    com.tencent.mm.plugin.exdevice.service.j.a locala = this.yry;
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (localf.ypB == null) {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.yrw = false;
      AppMethodBeat.o(23347);
      return;
      if (u.dGE().yps == null) {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.dGE().yps.b(locala)) {
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.j
 * JD-Core Version:    0.7.0.1
 */