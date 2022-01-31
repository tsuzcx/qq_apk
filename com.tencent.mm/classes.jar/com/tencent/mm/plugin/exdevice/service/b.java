package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.d.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b
  implements c
{
  private static b lIl = null;
  private CountDownLatch countDownLatch;
  private com.tencent.mm.plugin.d.a.d.b lIh;
  private final Vector<r> lIi;
  private final HashMap<Long, Integer> lIj;
  private final HashMap<Long, Integer> lIk;
  private ak mHandler;
  
  public b()
  {
    AppMethodBeat.i(19546);
    this.lIh = null;
    this.lIi = new Vector();
    this.lIj = new HashMap();
    this.lIk = new HashMap();
    this.mHandler = new ak(v.bqB().fPW.oNc.getLooper());
    long l1 = Thread.currentThread().getId();
    long l2 = Looper.getMainLooper().getThread().getId();
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((Build.VERSION.SDK_INT == 14) || (Build.VERSION.SDK_INT == 15))
    {
      if (l1 == l2)
      {
        ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
        this.lIh = new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), this, v.bqB().fPW);
        AppMethodBeat.o(19546);
        return;
      }
      new ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new b.1(this));
      this.countDownLatch = new CountDownLatch(1);
    }
    try
    {
      this.countDownLatch.await();
      label211:
      ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
      AppMethodBeat.o(19546);
      return;
      this.lIh = new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), this, v.bqB().fPW);
      AppMethodBeat.o(19546);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label211;
    }
  }
  
  public static boolean a(int paramInt, r paramr, int... paramVarArgs)
  {
    AppMethodBeat.i(19548);
    b localb = bqo();
    boolean bool = localb.mHandler.post(new b.2(localb, paramInt, paramr, paramVarArgs));
    if (!bool) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(19548);
    return bool;
  }
  
  private static b bqo()
  {
    AppMethodBeat.i(19547);
    if (lIl != null)
    {
      localb = lIl;
      AppMethodBeat.o(19547);
      return localb;
    }
    b localb = new b();
    lIl = localb;
    AppMethodBeat.o(19547);
    return localb;
  }
  
  public static boolean connect(long paramLong)
  {
    AppMethodBeat.i(19552);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = bqo();
    boolean bool = localb.mHandler.post(new b.6(localb, paramLong));
    if (!bool) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(19552);
    return bool;
  }
  
  public static void createSession(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(19550);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    b localb = bqo();
    if (!localb.mHandler.post(new b.4(localb, paramLong1, paramLong2))) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(19550);
  }
  
  public static void destroySession(long paramLong)
  {
    AppMethodBeat.i(19553);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = bqo();
    if (!localb.mHandler.post(new b.7(localb, paramLong))) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(19553);
  }
  
  public static boolean sendData(long paramLong, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(19551);
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "----sendData---- aSessionId = %d, datalength = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      Assert.assertNotNull(paramArrayOfByte);
      b localb = bqo();
      boolean bool = localb.mHandler.post(new b.5(localb, paramLong, paramArrayOfByte));
      if (!bool) {
        ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
      }
      AppMethodBeat.o(19551);
      return bool;
      i = paramArrayOfByte.length;
    }
  }
  
  public static boolean uX(int paramInt)
  {
    AppMethodBeat.i(19549);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[] { Integer.valueOf(paramInt) });
    b localb = bqo();
    boolean bool = localb.mHandler.post(new b.3(localb, paramInt));
    if (!bool) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(19549);
    return bool;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19556);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ab.d("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (!this.lIi.isEmpty()) {
        break;
      }
      ab.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
      AppMethodBeat.o(19556);
      return;
    }
    Iterator localIterator = this.lIi.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).a(paramString1, paramString2, paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(19556);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19558);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = ".concat(String.valueOf(paramLong)));
    Java2CExDevice.onBluetoothRecvData(paramLong, paramArrayOfByte);
    AppMethodBeat.o(19558);
  }
  
  public final void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(19554);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + paramLong1 + " aDeviceID = " + paramLong2);
    Assert.assertTrue(this.lIj.containsKey(Long.valueOf(paramLong2)));
    if (!this.lIk.containsKey(Long.valueOf(paramLong1))) {
      this.lIk.put(Long.valueOf(paramLong1), this.lIj.get(Long.valueOf(paramLong2)));
    }
    Java2CExDevice.onBluetoothSessionCreated(paramLong2, paramLong3, paramLong1);
    AppMethodBeat.o(19554);
  }
  
  public final void hN(long paramLong)
  {
    AppMethodBeat.i(19560);
    Java2CExDevice.onBluetoothError(paramLong, 0);
    AppMethodBeat.o(19560);
  }
  
  public final void l(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(19557);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + paramLong + "Connected = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothConnected(paramLong);
      AppMethodBeat.o(19557);
      return;
    }
    Java2CExDevice.onBluetoothDisconnected(paramLong);
    AppMethodBeat.o(19557);
  }
  
  public final void m(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(19559);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + paramLong + "success = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothSendDataCompleted(paramLong);
      AppMethodBeat.o(19559);
      return;
    }
    Java2CExDevice.onBluetoothError(paramLong, 0);
    AppMethodBeat.o(19559);
  }
  
  public final void rN(int paramInt)
  {
    AppMethodBeat.i(19555);
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lIi.isEmpty())
    {
      ab.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
      AppMethodBeat.o(19555);
      return;
    }
    Iterator localIterator = this.lIi.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr != null) {
        localr.rN(paramInt);
      }
    }
    this.lIi.clear();
    AppMethodBeat.o(19555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b
 * JD-Core Version:    0.7.0.1
 */