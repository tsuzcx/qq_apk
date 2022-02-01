package com.tencent.mm.plugin.exdevice.service;

import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.g.a.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b
  implements c
{
  private static b yuV = null;
  private MMHandler mHandler;
  private com.tencent.mm.plugin.g.a.d.b yuR;
  private final Vector<r> yuS;
  private final HashMap<Long, Integer> yuT;
  private final HashMap<Long, Integer> yuU;
  private CountDownLatch yuW;
  
  public b()
  {
    AppMethodBeat.i(23614);
    this.yuR = null;
    this.yuS = new Vector();
    this.yuT = new HashMap();
    this.yuU = new HashMap();
    this.mHandler = new MMHandler(v.dGF().oTi.getSerialTag());
    long l1 = Thread.currentThread().getId();
    long l2 = Looper.getMainLooper().getThread().getId();
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if ((Build.VERSION.SDK_INT == 14) || (Build.VERSION.SDK_INT == 15))
    {
      if (l1 == l2)
      {
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
        this.yuR = new com.tencent.mm.plugin.g.a.d.b(MMApplicationContext.getContext(), this, v.dGF().oTi);
        AppMethodBeat.o(23614);
        return;
      }
      new MMHandler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23607);
          b.a(b.this, new com.tencent.mm.plugin.g.a.d.b(MMApplicationContext.getContext(), b.this, v.dGF().oTi));
          Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
          b.a(b.this).countDown();
          AppMethodBeat.o(23607);
        }
      });
      this.yuW = new CountDownLatch(1);
    }
    try
    {
      this.yuW.await();
      label208:
      Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
      AppMethodBeat.o(23614);
      return;
      this.yuR = new com.tencent.mm.plugin.g.a.d.b(MMApplicationContext.getContext(), this, v.dGF().oTi);
      AppMethodBeat.o(23614);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label208;
    }
  }
  
  public static boolean Lg(final int paramInt)
  {
    AppMethodBeat.i(23617);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", new Object[] { Integer.valueOf(paramInt) });
    b localb = dGh();
    boolean bool = localb.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23609);
        if (!b.a(b.this, paramInt)) {
          Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
        }
        AppMethodBeat.o(23609);
      }
    });
    if (!bool) {
      Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(23617);
    return bool;
  }
  
  public static boolean a(final int paramInt, final r paramr, final int... paramVarArgs)
  {
    AppMethodBeat.i(23616);
    b localb = dGh();
    boolean bool = localb.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23608);
        if (!b.a(b.this, paramInt, paramr, paramVarArgs)) {
          Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
        }
        AppMethodBeat.o(23608);
      }
    });
    if (!bool) {
      Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(23616);
    return bool;
  }
  
  public static boolean connect(final long paramLong)
  {
    AppMethodBeat.i(23620);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = dGh();
    boolean bool = localb.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23612);
        if (!b.a(b.this, paramLong)) {
          Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
        }
        AppMethodBeat.o(23612);
      }
    });
    if (!bool) {
      Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(23620);
    return bool;
  }
  
  public static void createSession(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(23618);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    b localb = dGh();
    if (!localb.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23610);
        b.a(b.this, paramLong1, this.yvc);
        AppMethodBeat.o(23610);
      }
    })) {
      Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(23618);
  }
  
  private static b dGh()
  {
    AppMethodBeat.i(23615);
    if (yuV != null)
    {
      localb = yuV;
      AppMethodBeat.o(23615);
      return localb;
    }
    b localb = new b();
    yuV = localb;
    AppMethodBeat.o(23615);
    return localb;
  }
  
  public static void destroySession(final long paramLong)
  {
    AppMethodBeat.i(23621);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", new Object[] { Long.valueOf(paramLong) });
    b localb = dGh();
    if (!localb.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23613);
        b.b(b.this, paramLong);
        AppMethodBeat.o(23613);
      }
    })) {
      Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
    }
    AppMethodBeat.o(23621);
  }
  
  public static boolean sendData(final long paramLong, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(23619);
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "----sendData---- aSessionId = %d, datalength = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      Assert.assertNotNull(paramArrayOfByte);
      b localb = dGh();
      boolean bool = localb.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23611);
          if (!b.a(b.this, paramLong, this.yve)) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
          }
          AppMethodBeat.o(23611);
        }
      });
      if (!bool) {
        Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
      }
      AppMethodBeat.o(23619);
      return bool;
      i = paramArrayOfByte.length;
    }
  }
  
  public final void GO(int paramInt)
  {
    AppMethodBeat.i(23623);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.yuS.isEmpty())
    {
      Log.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
      AppMethodBeat.o(23623);
      return;
    }
    Iterator localIterator = this.yuS.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr != null) {
        localr.GO(paramInt);
      }
    }
    this.yuS.clear();
    AppMethodBeat.o(23623);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23624);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.d("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (!this.yuS.isEmpty()) {
        break;
      }
      Log.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
      AppMethodBeat.o(23624);
      return;
    }
    Iterator localIterator = this.yuS.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).a(paramString1, paramString2, paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(23624);
  }
  
  public final void c(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23626);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = ".concat(String.valueOf(paramLong)));
    Java2CExDevice.onBluetoothRecvData(paramLong, paramArrayOfByte);
    AppMethodBeat.o(23626);
  }
  
  public final void k(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(23622);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + paramLong1 + " aDeviceID = " + paramLong2);
    Assert.assertTrue(this.yuT.containsKey(Long.valueOf(paramLong2)));
    if (!this.yuU.containsKey(Long.valueOf(paramLong1))) {
      this.yuU.put(Long.valueOf(paramLong1), (Integer)this.yuT.get(Long.valueOf(paramLong2)));
    }
    Java2CExDevice.onBluetoothSessionCreated(paramLong2, paramLong3, paramLong1);
    AppMethodBeat.o(23622);
  }
  
  public final void kf(long paramLong)
  {
    AppMethodBeat.i(23628);
    Java2CExDevice.onBluetoothError(paramLong, 0);
    AppMethodBeat.o(23628);
  }
  
  public final void r(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(23625);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + paramLong + "Connected = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothConnected(paramLong);
      AppMethodBeat.o(23625);
      return;
    }
    Java2CExDevice.onBluetoothDisconnected(paramLong);
    AppMethodBeat.o(23625);
  }
  
  public final void s(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(23627);
    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + paramLong + "success = " + paramBoolean);
    if (paramBoolean)
    {
      Java2CExDevice.onBluetoothSendDataCompleted(paramLong);
      AppMethodBeat.o(23627);
      return;
    }
    Java2CExDevice.onBluetoothError(paramLong, 0);
    AppMethodBeat.o(23627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b
 * JD-Core Version:    0.7.0.1
 */