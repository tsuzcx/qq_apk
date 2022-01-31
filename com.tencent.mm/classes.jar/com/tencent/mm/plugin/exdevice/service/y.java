package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mm.plugin.f.a.a.f.6;
import com.tencent.mm.plugin.f.a.a.f.7;
import com.tencent.mm.plugin.f.a.a.h;
import com.tencent.mm.plugin.f.a.b.e.4;
import com.tencent.mm.plugin.f.a.b.e.a;
import com.tencent.mm.plugin.f.a.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import junit.framework.Assert;

public final class y
  extends h.a
  implements g, com.tencent.mm.plugin.f.a.a.b, a.a
{
  private RemoteCallbackList<t> jzA = new RemoteCallbackList();
  com.tencent.mm.plugin.f.a.b.e jzB;
  private e.a jzC;
  private a jzm = null;
  private RemoteCallbackList<k> jzn = new RemoteCallbackList();
  private RemoteCallbackList<p> jzo = new RemoteCallbackList();
  private RemoteCallbackList<j> jzp = new RemoteCallbackList();
  private RemoteCallbackList<i> jzq = new RemoteCallbackList();
  private RemoteCallbackList<q> jzr = new RemoteCallbackList();
  private RemoteCallbackList<n> jzs = new RemoteCallbackList();
  private final y.l jzt = new y.l((byte)0);
  private int jzu = 0;
  private final com.tencent.mm.plugin.f.a.a.f jzv;
  private final com.tencent.mm.plugin.f.a.d.a jzw;
  private RemoteCallbackList<j> jzx = new RemoteCallbackList();
  private RemoteCallbackList<k> jzy = new RemoteCallbackList();
  private RemoteCallbackList<s> jzz = new RemoteCallbackList();
  private final ah mHandler = new y.a(this, v.aMo().eAg.mnU.getLooper());
  
  public y()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (this.jzv = new com.tencent.mm.plugin.f.a.a.f(this);; this.jzv = null)
    {
      this.jzw = new com.tencent.mm.plugin.f.a.d.a(this);
      this.jzC = new y.1(this);
      com.tencent.mm.compatible.a.a.a(18, new y.2(this));
      return;
    }
  }
  
  private static IInterface a(long paramLong, RemoteCallbackList paramRemoteCallbackList, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    int i = 0;
    while (i < paramInt)
    {
      HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
      if (localHashMap.containsKey(Long.valueOf(paramLong))) {
        return (IInterface)localHashMap.get(Long.valueOf(paramLong));
      }
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
    return null;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[] { Long.valueOf(paramLong) });
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      return false;
    }
    int i = paramRemoteCallbackList.beginBroadcast();
    int j;
    do
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (!paramRemoteCallbackList.getBroadcastItem(j).asBinder().equals(paramIInterface.asBinder()));
    if (j < 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
      localHashMap = new HashMap();
      localHashMap.put(Long.valueOf(paramLong), paramIInterface);
      paramRemoteCallbackList.register(paramIInterface, localHashMap);
      paramRemoteCallbackList.finishBroadcast();
      return true;
    }
    HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(j);
    if (localHashMap == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
      paramRemoteCallbackList.finishBroadcast();
      return false;
    }
    localHashMap.put(Long.valueOf(paramLong), paramIInterface);
    paramRemoteCallbackList.finishBroadcast();
    return true;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    boolean bool1;
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      int i;
      do
      {
        i = paramInt - 1;
        if (i < 0) {
          break;
        }
        paramInt = i;
      } while (!paramRemoteCallbackList.getBroadcastItem(i).asBinder().equals(paramIInterface.asBinder()));
      if (i < 0)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
        return false;
      }
      HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
      if (localHashMap == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
        return false;
      }
      if ((IInterface)localHashMap.remove(Long.valueOf(paramLong)) == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
        return false;
      }
      if (!localHashMap.isEmpty()) {
        return true;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
      bool2 = paramRemoteCallbackList.unregister(paramIInterface);
      bool1 = bool2;
    } while (bool2);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
    return bool2;
  }
  
  private boolean b(long paramLong, p paramp)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      d(paramLong, -1, -1, "null == aTask");
      return false;
    }
    a locala = this.jzm;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[] { Long.valueOf(paramLong) });
    Assert.assertNotNull(paramp);
    a.g localg = new a.g(paramLong, paramp);
    if (locala.mHandler.sendMessage(locala.mHandler.obtainMessage(8, localg))) {}
    for (int i = 0; i != 0; i = -1)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
      d(paramLong, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
      return false;
    }
    if (!a(this.jzo, paramLong, paramp))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
      d(paramLong, -1, -1, "registerRemoteCB Fail!!!");
      return false;
    }
    return true;
  }
  
  private boolean c(j paramj)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
    boolean bool = this.jzp.unregister(paramj);
    if (!bool)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
      return bool;
    }
    this.jzu -= 1;
    return bool;
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.jzo.beginBroadcast();
    p localp = (p)a(paramLong, this.jzo, i);
    if (localp == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = " + paramLong);
      this.jzo.finishBroadcast();
      return;
    }
    try
    {
      localp.aMk().a(paramLong, paramInt1, paramInt2, paramString, localp);
      if (!a(this.jzo, paramLong, localp, i)) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
      }
      this.jzo.finishBroadcast();
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      }
    }
  }
  
  private boolean f(int paramInt, j paramj)
  {
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      throw new IllegalArgumentException("scanImp: null == aCallback");
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
    boolean bool = this.jzp.register(paramj);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
    }
    for (;;)
    {
      if (!bool) {
        try
        {
          paramj.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
          return false;
          this.jzu += 1;
        }
        catch (RemoteException paramj)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { paramj.getMessage() });
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
          }
        }
      }
    }
    a locala = this.jzm;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!b.a(paramInt, locala, new int[0]))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
      }
      try
      {
        paramj.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
        if (!c(paramj)) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        return bool;
        bool = true;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { localRemoteException.getMessage() });
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
    }
  }
  
  private boolean g(int paramInt, j paramj)
  {
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      return false;
    }
    boolean bool = a.qq(paramInt);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
    }
    try
    {
      paramj.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
      if (!c(paramj)) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
      }
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final long a(p paramp)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      return -1L;
    }
    y.l locall = this.jzt;
    if (9223372036854775807L == locall.jyG)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
      locall.jyG = 0L;
    }
    long l = locall.jyG;
    locall.jyG = (1L + l);
    paramp = new k(l, paramp);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(0, paramp)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[] { Integer.valueOf(0) });
      return -1L;
    }
    return l;
  }
  
  public final void a(double paramDouble, com.tencent.mm.plugin.f.a.a.c paramc)
  {
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
      return;
    }
    h localh = paramc.hTe.hTi;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[] { Double.valueOf(paramDouble), com.tencent.mm.plugin.exdevice.j.b.aq(localh.hTJ), Short.valueOf(localh.hTK), Short.valueOf(localh.hTL), Integer.valueOf(localh.hTL & 0xFFFF) });
    try
    {
      int j = this.jzr.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((q)this.jzr.getBroadcastItem(i)).a(paramDouble, localh.hTK, localh.hTL, localh.hTJ, paramc.hTf, paramc.hTe.hTi.hTM, paramc.btt);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[] { Integer.valueOf(i), localRemoteException.toString() });
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramc)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[] { paramc.toString() });
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramc, "", new Object[0]);
      return;
    }
    finally
    {
      this.jzr.finishBroadcast();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte)
  {
    int j = this.jzp.beginBroadcast();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label130;
      }
      try
      {
        ((j)this.jzp.getBroadcastItem(i)).a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramArrayOfByte);
        if ((2 == paramInt1) && (!this.jzp.unregister(this.jzp.getBroadcastItem(i)))) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = " + i);
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
      i += 1;
    }
    label130:
    this.jzp.finishBroadcast();
  }
  
  public final void a(int paramInt, long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i) });
      b localb = new b((byte)0);
      localb.jyD = paramShort2;
      localb.jsU = paramArrayOfByte;
      localb.hXu = paramLong;
      localb.jta = paramShort1;
      localb.mErrorCode = paramInt;
      if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, localb))) {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(6) });
      }
      return;
    }
  }
  
  public final void a(n paramn)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
    if (!this.jzs.register(paramn)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
    }
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramk == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
      return false;
    }
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if ((1 != paramInt) && (paramInt != 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramk = new y.j(paramLong, paramInt, paramk);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(3, paramk)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(3) });
      return false;
    }
    return true;
  }
  
  public final boolean a(i parami)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
    boolean bool = this.jzq.register(parami);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
    }
    return bool;
  }
  
  public final boolean a(s params)
  {
    boolean bool1;
    if (params == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.jzz.register(params);
      bool1 = bool2;
    } while (bool2);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
    return bool2;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    if ((Build.VERSION.SDK_INT < 18) || (this.jzv == null)) {
      return false;
    }
    boolean bool = ae.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if ((!bool) || (localObject == null)) {
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (!this.jzr.register(paramq))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
      return false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.f.a.a.f localf;
      try
      {
        localObject = UUID.fromString(paramString);
        localf = this.jzv;
        com.tencent.mm.plugin.f.a.a.f.hTn = ae.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
        if (localObject == null)
        {
          paramString = "";
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.IBeaconServer", "Ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
          if (localObject != null) {
            break label212;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
          paramBoolean = false;
          if (!paramBoolean) {
            break;
          }
          return true;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[] { paramString.getMessage() });
        return false;
      }
      paramString = ((UUID)localObject).toString();
      continue;
      label212:
      if (paramBoolean) {
        paramBoolean = localf.mHandler.post(new f.6(localf, (UUID)localObject));
      } else {
        paramBoolean = localf.mHandler.post(new f.7(localf, (UUID)localObject));
      }
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
    if (!this.jzr.unregister(paramq)) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
    }
    return false;
  }
  
  public final long[] aMa()
  {
    return a.aMa();
  }
  
  public final void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + paramLong + " oldState" + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    y.c localc = new y.c((byte)0);
    localc.hXu = paramLong;
    localc.jyE = paramInt1;
    localc.jyF = paramInt2;
    localc.jsT = paramInt3;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, localc))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[] { Integer.valueOf(5) });
    }
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = " + paramInt);
    boolean bool1;
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.mHandler.post(new y.3(this, paramInt, paramj));
      bool1 = bool2;
    } while (bool2);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
    return bool2;
  }
  
  public final boolean b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int i = this.jzy.beginBroadcast();
    k localk = (k)a(paramLong1, this.jzy, i);
    if (localk == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + paramLong1);
      this.jzy.finishBroadcast();
      return false;
    }
    try
    {
      localk.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      return false;
    }
    finally
    {
      this.jzy.finishBroadcast();
    }
  }
  
  public final boolean b(long paramLong, int paramInt, k paramk)
  {
    if (paramk == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      return false;
    }
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (paramInt != 0)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    y.e locale = new y.e((byte)0);
    locale.jvT = paramLong;
    locale.jzF = paramInt;
    locale.jzG = paramk;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(7, locale)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(7) });
      return false;
    }
    return true;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    if (0L > paramLong)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
      return false;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
      return false;
    }
    if (paramt == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      return false;
    }
    y.i locali = new y.i((byte)0);
    locali.jvT = paramLong;
    locali.mData = paramArrayOfByte;
    locali.jzJ = paramt;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(10, locali)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(10) });
      return false;
    }
    return true;
  }
  
  public final boolean b(i parami)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
    boolean bool = this.jzq.unregister(parami);
    if (!bool) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
    }
    return bool;
  }
  
  public final void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    y.d locald = new y.d();
    locald.jyG = paramLong;
    locald.jtf = paramInt1;
    locald.jsT = paramInt2;
    locald.ghs = paramString;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, locald))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = " + paramInt);
    boolean bool1;
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.mHandler.post(new y.4(this, paramInt, paramj));
      bool1 = bool2;
    } while (bool2);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
    return bool2;
  }
  
  public final boolean c(long paramLong, int paramInt, k paramk)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!a(this.jzy, paramLong, paramk))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
      try
      {
        paramk.a(paramLong, -1, 4, -1, 0L);
        return false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
    }
    try
    {
      paramk.a(paramLong, -1, 1, -1, 0L);
      if (this.jzB != null)
      {
        com.tencent.mm.plugin.f.a.b.e locale = this.jzB;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[] { Long.valueOf(paramLong) });
        if (!locale.awq())
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
          bool = false;
          if (bool) {
            break label333;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[] { Long.valueOf(paramLong) });
          if (paramk == null) {}
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        for (;;)
        {
          paramk.a(paramLong, 1, 4, -1, 0L);
          return false;
          localRemoteException = localRemoteException;
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          continue;
          com.tencent.mm.plugin.f.a.b.f localf = (com.tencent.mm.plugin.f.a.b.f)localRemoteException.hTU.get(Long.valueOf(paramLong));
          if (localf != null)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
            bool = localf.connect();
          }
          else
          {
            localf = new com.tencent.mm.plugin.f.a.b.f(paramLong, localRemoteException.ze, localRemoteException.hUF);
            if (!localf.connect()) {
              break;
            }
            localRemoteException.G(new e.4(localRemoteException, paramLong, localf));
            bool = true;
          }
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
        boolean bool = false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
    }
    label333:
    return true;
  }
  
  public final boolean c(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.j.b.aq(paramArrayOfByte) });
    if (this.jzB != null)
    {
      Object localObject = this.jzB;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[] { Long.valueOf(paramLong) });
      boolean bool;
      if (!((com.tencent.mm.plugin.f.a.b.e)localObject).awq())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
      }
      for (;;)
      {
        if (!bool)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
          if (paramt != null) {}
          try
          {
            paramt.b(paramLong, -1, -1, "start write data error");
            return false;
            localObject = (com.tencent.mm.plugin.f.a.b.f)((com.tencent.mm.plugin.f.a.b.e)localObject).hTU.get(Long.valueOf(paramLong));
            if (localObject == null)
            {
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
              bool = false;
            }
            else
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.f.a.b.f)localObject).mSessionId), ((com.tencent.mm.plugin.f.a.b.f)localObject).gof.getName() });
              bool = ((com.tencent.mm.plugin.f.a.b.f)localObject).mHandler.sendMessage(((com.tencent.mm.plugin.f.a.b.f)localObject).mHandler.obtainMessage(3, paramArrayOfByte));
            }
          }
          catch (RemoteException paramArrayOfByte)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramArrayOfByte, "", new Object[0]);
            }
          }
        }
      }
    }
    if (!a(this.jzA, paramLong, paramt))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
      return false;
    }
    return true;
  }
  
  public final boolean d(int paramInt, j paramj)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
    }
    for (;;)
    {
      return false;
      if (paramInt != 0)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
        return false;
      }
      boolean bool3 = this.jzx.register(paramj);
      label70:
      com.tencent.mm.plugin.f.a.b.e locale;
      boolean bool1;
      if (bool3)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
        if (this.jzB == null) {
          break label265;
        }
        locale = this.jzB;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
        if (locale.hTW == null) {
          break label183;
        }
        bool1 = true;
        label102:
        Assert.assertTrue(bool1);
        if (locale.awq()) {
          break label188;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool1 = false;
        label125:
        if (bool1) {
          break label265;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
      }
      try
      {
        paramj.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
        if (bool3)
        {
          this.jzx.unregister(paramj);
          return false;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
          break label70;
          label183:
          bool1 = false;
          break label102;
          label188:
          boolean bool2 = locale.hTW.a(true, locale.hTZ);
          bool1 = bool2;
          if (!bool2) {
            break label125;
          }
          locale.hUD.clear();
          bool1 = bool2;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
    }
    label265:
    return true;
  }
  
  /* Error */
  public final boolean d(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_3
    //   4: ifnonnull +105 -> 109
    //   7: ldc_w 1006
    //   10: astore 6
    //   12: ldc 178
    //   14: ldc_w 1008
    //   17: iconst_2
    //   18: anewarray 182	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: lload_1
    //   24: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload 6
    //   32: aastore
    //   33: invokestatic 319	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: getfield 105	com/tencent/mm/plugin/exdevice/service/y:jzz	Landroid/os/RemoteCallbackList;
    //   40: invokevirtual 239	android/os/RemoteCallbackList:beginBroadcast	()I
    //   43: istore 5
    //   45: ldc 178
    //   47: ldc_w 1010
    //   50: iconst_1
    //   51: anewarray 182	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: iload 5
    //   58: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: invokestatic 319	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: iload 4
    //   67: iload 5
    //   69: if_icmpge +91 -> 160
    //   72: aload_0
    //   73: getfield 105	com/tencent/mm/plugin/exdevice/service/y:jzz	Landroid/os/RemoteCallbackList;
    //   76: iload 4
    //   78: invokevirtual 243	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   81: checkcast 1012	com/tencent/mm/plugin/exdevice/service/s
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +30 -> 118
    //   91: aload 6
    //   93: lload_1
    //   94: aload_3
    //   95: invokeinterface 1015 4 0
    //   100: iload 4
    //   102: iconst_1
    //   103: iadd
    //   104: istore 4
    //   106: goto -41 -> 65
    //   109: aload_3
    //   110: invokestatic 621	com/tencent/mm/plugin/exdevice/j/b:aq	([B)Ljava/lang/String;
    //   113: astore 6
    //   115: goto -103 -> 12
    //   118: ldc 178
    //   120: ldc_w 1017
    //   123: invokestatic 221	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: goto -26 -> 100
    //   129: astore_3
    //   130: ldc 178
    //   132: ldc_w 1019
    //   135: invokestatic 221	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: ldc 178
    //   140: aload_3
    //   141: ldc_w 269
    //   144: iconst_0
    //   145: anewarray 182	java/lang/Object
    //   148: invokestatic 273	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 105	com/tencent/mm/plugin/exdevice/service/y:jzz	Landroid/os/RemoteCallbackList;
    //   155: invokevirtual 276	android/os/RemoteCallbackList:finishBroadcast	()V
    //   158: iconst_1
    //   159: ireturn
    //   160: aload_0
    //   161: getfield 105	com/tencent/mm/plugin/exdevice/service/y:jzz	Landroid/os/RemoteCallbackList;
    //   164: invokevirtual 276	android/os/RemoteCallbackList:finishBroadcast	()V
    //   167: iconst_1
    //   168: ireturn
    //   169: astore_3
    //   170: aload_0
    //   171: getfield 105	com/tencent/mm/plugin/exdevice/service/y:jzz	Landroid/os/RemoteCallbackList;
    //   174: invokevirtual 276	android/os/RemoteCallbackList:finishBroadcast	()V
    //   177: aload_3
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	y
    //   0	179	1	paramLong	long
    //   0	179	3	paramArrayOfByte	byte[]
    //   1	104	4	i	int
    //   43	27	5	j	int
    //   10	104	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   72	86	129	android/os/RemoteException
    //   91	100	129	android/os/RemoteException
    //   118	126	129	android/os/RemoteException
    //   72	86	169	finally
    //   91	100	169	finally
    //   118	126	169	finally
    //   130	151	169	finally
  }
  
  public final boolean dZ(long paramLong)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(4) });
      return false;
    }
    return true;
  }
  
  public final boolean e(int paramInt, j paramj)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
      return false;
    }
    if (this.jzB == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
      return false;
    }
    com.tencent.mm.plugin.f.a.b.e locale = this.jzB;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
    boolean bool;
    if (locale.hTW != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue(bool);
      if (!locale.awq())
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
        if (!bool) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
        }
      }
      try
      {
        paramj.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
        return bool;
        bool = false;
        continue;
        locale.mHandler.removeCallbacks(locale.mRunnable);
        bool = locale.hTW.a(false, locale.hTZ);
      }
      catch (RemoteException paramj)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[] { paramj.getMessage() });
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean e(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.jzA.beginBroadcast();
    t localt = (t)a(paramLong, this.jzA, i);
    if (localt == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = " + paramLong);
      this.jzA.finishBroadcast();
      return false;
    }
    try
    {
      localt.b(paramLong, paramInt1, paramInt2, paramString);
      return true;
    }
    catch (RemoteException paramString)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      return false;
    }
    finally
    {
      this.jzA.finishBroadcast();
    }
  }
  
  public final boolean ea(long paramLong)
  {
    return false;
  }
  
  public final boolean eb(long paramLong)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[] { Integer.valueOf(1) });
      return false;
    }
    return true;
  }
  
  public final boolean ec(long paramLong)
  {
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(paramLong))))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(8) });
      return false;
    }
    return true;
  }
  
  public final void ob(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
    int i = this.jzs.beginBroadcast() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_state", paramInt);
        try
        {
          ((n)this.jzs.getBroadcastItem(i)).j(0, localBundle);
          i -= 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[] { Integer.valueOf(i) });
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          }
        }
      }
    }
    this.jzs.finishBroadcast();
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = this.jzm;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    paramArrayOfByte = new a.f(paramLong, paramArrayOfByte);
    if (!locala.mHandler.sendMessage(locala.mHandler.obtainMessage(10, paramArrayOfByte))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[] { Integer.valueOf(10) });
    }
  }
  
  private static final class b
  {
    long hXu = 0L;
    byte[] jsU = null;
    short jta = 0;
    short jyD = 0;
    int mErrorCode = 0;
  }
  
  private static final class k
  {
    long jyG;
    p jzL;
    
    public k(long paramLong, p paramp)
    {
      this.jyG = paramLong;
      this.jzL = paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y
 * JD-Core Version:    0.7.0.1
 */