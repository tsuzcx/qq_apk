package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.f.a.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b
  implements c
{
  private static b jyM = null;
  private CountDownLatch countDownLatch;
  private com.tencent.mm.plugin.f.a.d.b jyI = null;
  private final Vector<r> jyJ = new Vector();
  private final HashMap<Long, Integer> jyK = new HashMap();
  private final HashMap<Long, Integer> jyL = new HashMap();
  private ah mHandler = new ah(v.aMo().eAg.mnU.getLooper());
  
  public b()
  {
    long l1 = Thread.currentThread().getId();
    long l2 = Looper.getMainLooper().getThread().getId();
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((Build.VERSION.SDK_INT == 14) || (Build.VERSION.SDK_INT == 15))
    {
      if (l1 == l2)
      {
        y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
        this.jyI = new com.tencent.mm.plugin.f.a.d.b(ae.getContext(), this, v.aMo().eAg);
        return;
      }
      new ah(Looper.getMainLooper()).postAtFrontOfQueueV2(new b.1(this));
      this.countDownLatch = new CountDownLatch(1);
    }
    try
    {
      this.countDownLatch.await();
      label199:
      y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
      return;
      this.jyI = new com.tencent.mm.plugin.f.a.d.b(ae.getContext(), this, v.aMo().eAg);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label199;
    }
  }
  
  public static boolean a(int paramInt, r paramr, int... paramVarArgs)
  {
    boolean bool1;
    if (paramr == null)
    {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      b localb = aMb();
      bool2 = localb.mHandler.post(new b.2(localb, paramInt, paramr, paramVarArgs));
      bool1 = bool2;
    } while (bool2);
    y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
    return bool2;
  }
  
  private static b aMb()
  {
    if (jyM != null) {
      return jyM;
    }
    b localb = new b();
    jyM = localb;
    return localb;
  }
  
  public static boolean connect(long paramLong)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = aMb();
    boolean bool = localb.mHandler.post(new b.6(localb, paramLong));
    if (!bool) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
    }
    return bool;
  }
  
  public static void createSession(long paramLong1, long paramLong2)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    b localb = aMb();
    if (!localb.mHandler.post(new b.4(localb, paramLong1, paramLong2))) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
    }
  }
  
  public static void destroySession(long paramLong)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = aMb();
    if (!localb.mHandler.post(new b.7(localb, paramLong))) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
    }
  }
  
  public static boolean qq(int paramInt)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[] { Integer.valueOf(paramInt) });
    b localb = aMb();
    boolean bool = localb.mHandler.post(new b.3(localb, paramInt));
    if (!bool) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
    }
    return bool;
  }
  
  public static boolean sendData(long paramLong, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "----sendData---- aSessionId = %d, datalength = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      Assert.assertNotNull(paramArrayOfByte);
      b localb = aMb();
      boolean bool = localb.mHandler.post(new b.5(localb, paramLong, paramArrayOfByte));
      if (!bool) {
        y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
      }
      return bool;
      i = paramArrayOfByte.length;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      y.d("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (!this.jyJ.isEmpty()) {
        break label78;
      }
      y.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
    }
    for (;;)
    {
      return;
      i = paramArrayOfByte.length;
      break;
      label78:
      Iterator localIterator = this.jyJ.iterator();
      while (localIterator.hasNext()) {
        ((r)localIterator.next()).a(paramString1, paramString2, paramInt1, paramInt2, paramArrayOfByte);
      }
    }
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = " + paramLong);
    Java2CExDevice.onBluetoothRecvData(paramLong, paramArrayOfByte);
  }
  
  public final void cL(long paramLong)
  {
    Java2CExDevice.onBluetoothError(paramLong, 0);
  }
  
  public final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + paramLong1 + " aDeviceID = " + paramLong2);
    Assert.assertTrue(this.jyK.containsKey(Long.valueOf(paramLong2)));
    if (!this.jyL.containsKey(Long.valueOf(paramLong1))) {
      this.jyL.put(Long.valueOf(paramLong1), this.jyK.get(Long.valueOf(paramLong2)));
    }
    Java2CExDevice.onBluetoothSessionCreated(paramLong2, paramLong3, paramLong1);
  }
  
  public final void i(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + paramLong + "Connected = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothConnected(paramLong);
      return;
    }
    Java2CExDevice.onBluetoothDisconnected(paramLong);
  }
  
  public final void j(long paramLong, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + paramLong + "success = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothSendDataCompleted(paramLong);
      return;
    }
    Java2CExDevice.onBluetoothError(paramLong, 0);
  }
  
  public final void nZ(int paramInt)
  {
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jyJ.isEmpty())
    {
      y.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
      return;
    }
    Iterator localIterator = this.jyJ.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr != null) {
        localr.nZ(paramInt);
      }
    }
    this.jyJ.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b
 * JD-Core Version:    0.7.0.1
 */