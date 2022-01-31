package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.er;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s.a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class h
  extends s.a
{
  protected static final String TAG;
  private boolean lEQ;
  f lER;
  private j.a lES;
  
  static
  {
    AppMethodBeat.i(19283);
    TAG = h.class.getName();
    AppMethodBeat.o(19283);
  }
  
  public h()
  {
    AppMethodBeat.i(19276);
    this.lEQ = false;
    this.lER = new f();
    this.lES = new h.1(this);
    AppMethodBeat.o(19276);
  }
  
  public static boolean a(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(19281);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e(TAG, "no data for transmit");
      AppMethodBeat.o(19281);
      return false;
    }
    if (u.bqA().lCQ == null)
    {
      ab.e(TAG, "can not send data");
      AppMethodBeat.o(19281);
      return false;
    }
    boolean bool = u.bqA().lCQ.b(paramLong, paramArrayOfByte, paramt);
    if (!bool) {
      ab.e(TAG, "simpleBluetoothSendData error");
    }
    AppMethodBeat.o(19281);
    return bool;
  }
  
  public static void iZ(long paramLong)
  {
    AppMethodBeat.i(19280);
    d locald = ad.bqf();
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
    if (locald.lCV == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(19280);
      return;
    }
    if (u.bqA().lCQ == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(19280);
      return;
    }
    if (!u.bqA().lCQ.ju(paramLong)) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
    }
    AppMethodBeat.o(19280);
  }
  
  public final void a(long paramLong, h.a parama)
  {
    AppMethodBeat.i(19279);
    Object localObject = this.lER.jm(paramLong);
    if ((localObject != null) && (2 == ((f.a)localObject).crJ))
    {
      ab.d(TAG, "device(" + paramLong + ") has been connected");
      parama.a(paramLong, 2, 2, 0, ((f.a)localObject).jOK);
      AppMethodBeat.o(19279);
      return;
    }
    localObject = ad.bqf();
    parama = new h.2(this, parama);
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
    if (((d)localObject).lCV == null)
    {
      ((d)localObject).lCV = new com.tencent.mm.plugin.exdevice.service.c();
      ((d)localObject).lCV.lIv = new d.3((d)localObject, paramLong, parama);
      ((d)localObject).lCV.dM(ah.getContext());
      AppMethodBeat.o(19279);
      return;
    }
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
    localObject = u.bqA().lCQ;
    if ((localObject == null) || (!((m)localObject).a(paramLong, parama))) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
    }
    AppMethodBeat.o(19279);
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19282);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e(TAG, "data is null or nil");
      AppMethodBeat.o(19282);
      return;
    }
    ab.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.j.b.aO(paramArrayOfByte) });
    Object localObject1 = ad.bqj();
    String str = com.tencent.mm.plugin.exdevice.j.b.jw(paramLong);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).lDo)
    {
      localLinkedList = new LinkedList(((e)localObject1).lDo);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).b(str, paramArrayOfByte, true);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).lDp.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(str, paramArrayOfByte, true);
    }
    localObject1 = new er();
    ((er)localObject1).csy.mac = str;
    ((er)localObject1).csy.data = paramArrayOfByte;
    a.ymk.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(19282);
  }
  
  public final void scan()
  {
    AppMethodBeat.i(19277);
    if (this.lEQ)
    {
      ab.d(TAG, "still scanning. return");
      AppMethodBeat.o(19277);
      return;
    }
    d locald = ad.bqf();
    j.a locala = this.lES;
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
    if (locald.lCV == null)
    {
      locald.lCV = new com.tencent.mm.plugin.exdevice.service.c();
      locald.lCV.lIv = new d.2(locald, locala);
      locald.lCV.dM(ah.getContext());
    }
    for (;;)
    {
      this.lEQ = true;
      AppMethodBeat.o(19277);
      return;
      if (u.bqA().lCQ == null)
      {
        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      }
      else
      {
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (!u.bqA().lCQ.a(locala)) {
          ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
      }
    }
  }
  
  public final void stopScan()
  {
    AppMethodBeat.i(19278);
    if (!this.lEQ)
    {
      ab.d(TAG, "not yet scan. return");
      AppMethodBeat.o(19278);
      return;
    }
    d locald = ad.bqf();
    j.a locala = this.lES;
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
    if (locald.lCV == null) {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
    }
    for (;;)
    {
      this.lEQ = false;
      AppMethodBeat.o(19278);
      return;
      if (u.bqA().lCQ == null) {
        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      } else if (!u.bqA().lCQ.b(locala)) {
        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h
 * JD-Core Version:    0.7.0.1
 */