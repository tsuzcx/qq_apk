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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.a.f.6;
import com.tencent.mm.plugin.d.a.a.f.7;
import com.tencent.mm.plugin.d.a.a.h;
import com.tencent.mm.plugin.d.a.b.e.4;
import com.tencent.mm.plugin.d.a.b.e.a;
import com.tencent.mm.plugin.d.a.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import junit.framework.Assert;

public final class y
  extends h.a
  implements com.tencent.mm.plugin.d.a.a.b, a.a, g
{
  private a lIL;
  private RemoteCallbackList<k> lIM;
  private RemoteCallbackList<p> lIN;
  private RemoteCallbackList<j> lIO;
  private RemoteCallbackList<i> lIP;
  private RemoteCallbackList<q> lIQ;
  private RemoteCallbackList<n> lIR;
  private final y.l lIS;
  private int lIT;
  private final com.tencent.mm.plugin.d.a.a.f lIU;
  private final com.tencent.mm.plugin.d.a.d.a lIV;
  private RemoteCallbackList<j> lIW;
  private RemoteCallbackList<k> lIX;
  private RemoteCallbackList<s> lIY;
  private RemoteCallbackList<t> lIZ;
  com.tencent.mm.plugin.d.a.b.e lJa;
  private e.a lJb;
  private final ak mHandler;
  
  public y()
  {
    AppMethodBeat.i(19658);
    this.lIL = null;
    this.lIM = new RemoteCallbackList();
    this.lIN = new RemoteCallbackList();
    this.lIO = new RemoteCallbackList();
    this.lIP = new RemoteCallbackList();
    this.lIQ = new RemoteCallbackList();
    this.lIR = new RemoteCallbackList();
    this.lIS = new y.l((byte)0);
    this.lIT = 0;
    this.lIW = new RemoteCallbackList();
    this.lIX = new RemoteCallbackList();
    this.lIY = new RemoteCallbackList();
    this.lIZ = new RemoteCallbackList();
    this.lIL = new a(this);
    this.mHandler = new y.a(this, v.bqB().fPW.oNc.getLooper());
    if (Build.VERSION.SDK_INT >= 18) {}
    for (this.lIU = new com.tencent.mm.plugin.d.a.a.f(this);; this.lIU = null)
    {
      this.lIV = new com.tencent.mm.plugin.d.a.d.a(this);
      this.lJb = new y.1(this);
      com.tencent.mm.compatible.a.a.a(18, new y.2(this));
      AppMethodBeat.o(19658);
      return;
    }
  }
  
  private static IInterface a(long paramLong, RemoteCallbackList paramRemoteCallbackList, int paramInt)
  {
    AppMethodBeat.i(19659);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    int i = 0;
    while (i < paramInt)
    {
      HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
      if (localHashMap.containsKey(Long.valueOf(paramLong)))
      {
        paramRemoteCallbackList = (IInterface)localHashMap.get(Long.valueOf(paramLong));
        AppMethodBeat.o(19659);
        return paramRemoteCallbackList;
      }
      i += 1;
    }
    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
    AppMethodBeat.o(19659);
    return null;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface)
  {
    AppMethodBeat.i(19666);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", new Object[] { Long.valueOf(paramLong) });
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      AppMethodBeat.o(19666);
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
      ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
      localHashMap = new HashMap();
      localHashMap.put(Long.valueOf(paramLong), paramIInterface);
      paramRemoteCallbackList.register(paramIInterface, localHashMap);
      paramRemoteCallbackList.finishBroadcast();
      AppMethodBeat.o(19666);
      return true;
    }
    HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(j);
    if (localHashMap == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
      paramRemoteCallbackList.finishBroadcast();
      AppMethodBeat.o(19666);
      return false;
    }
    localHashMap.put(Long.valueOf(paramLong), paramIInterface);
    paramRemoteCallbackList.finishBroadcast();
    AppMethodBeat.o(19666);
    return true;
  }
  
  private static boolean a(RemoteCallbackList paramRemoteCallbackList, long paramLong, IInterface paramIInterface, int paramInt)
  {
    AppMethodBeat.i(19667);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if ((paramRemoteCallbackList == null) || (paramIInterface == null))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
      AppMethodBeat.o(19667);
      return false;
    }
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
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
      AppMethodBeat.o(19667);
      return false;
    }
    HashMap localHashMap = (HashMap)paramRemoteCallbackList.getBroadcastCookie(i);
    if (localHashMap == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
      AppMethodBeat.o(19667);
      return false;
    }
    if ((IInterface)localHashMap.remove(Long.valueOf(paramLong)) == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
      AppMethodBeat.o(19667);
      return false;
    }
    if (!localHashMap.isEmpty())
    {
      AppMethodBeat.o(19667);
      return true;
    }
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
    boolean bool = paramRemoteCallbackList.unregister(paramIInterface);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
    }
    AppMethodBeat.o(19667);
    return bool;
  }
  
  private boolean b(long paramLong, p paramp)
  {
    AppMethodBeat.i(19670);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramp == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      d(paramLong, -1, -1, "null == aTask");
      AppMethodBeat.o(19670);
      return false;
    }
    a locala = this.lIL;
    ab.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", new Object[] { Long.valueOf(paramLong) });
    Assert.assertNotNull(paramp);
    a.g localg = new a.g(paramLong, paramp);
    if (locala.mHandler.sendMessage(locala.mHandler.obtainMessage(8, localg))) {}
    for (int i = 0; i != 0; i = -1)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
      d(paramLong, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
      AppMethodBeat.o(19670);
      return false;
    }
    if (!a(this.lIN, paramLong, paramp))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
      d(paramLong, -1, -1, "registerRemoteCB Fail!!!");
      AppMethodBeat.o(19670);
      return false;
    }
    AppMethodBeat.o(19670);
    return true;
  }
  
  private boolean c(j paramj)
  {
    AppMethodBeat.i(19660);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
    boolean bool = this.lIO.unregister(paramj);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
    }
    for (;;)
    {
      AppMethodBeat.o(19660);
      return bool;
      this.lIT -= 1;
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19676);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.lIN.beginBroadcast();
    p localp = (p)a(paramLong, this.lIN, i);
    if (localp == null)
    {
      ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = ".concat(String.valueOf(paramLong)));
      this.lIN.finishBroadcast();
      AppMethodBeat.o(19676);
      return;
    }
    try
    {
      localp.bqx().a(paramLong, paramInt1, paramInt2, paramString, localp);
      if (!a(this.lIN, paramLong, localp, i)) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
      }
      this.lIN.finishBroadcast();
      AppMethodBeat.o(19676);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
        ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      }
    }
  }
  
  private boolean f(int paramInt, j paramj)
  {
    AppMethodBeat.i(19662);
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      paramj = new IllegalArgumentException("scanImp: null == aCallback");
      AppMethodBeat.o(19662);
      throw paramj;
    }
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
    boolean bool = this.lIO.register(paramj);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
    }
    for (;;)
    {
      if (!bool) {
        try
        {
          paramj.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
          AppMethodBeat.o(19662);
          return false;
          this.lIT += 1;
        }
        catch (RemoteException paramj)
        {
          for (;;)
          {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { paramj.getMessage() });
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
          }
        }
      }
    }
    a locala = this.lIL;
    ab.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (!b.a(paramInt, locala, new int[0]))
    {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
      }
      try
      {
        paramj.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
        if (!c(paramj)) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
        }
        AppMethodBeat.o(19662);
        return bool;
        bool = true;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", new Object[] { localRemoteException.getMessage() });
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
    }
  }
  
  private boolean g(int paramInt, j paramj)
  {
    AppMethodBeat.i(19664);
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      AppMethodBeat.o(19664);
      return false;
    }
    boolean bool = a.uX(paramInt);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
    }
    try
    {
      paramj.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
      if (!c(paramj)) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
      }
      AppMethodBeat.o(19664);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
        ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      }
    }
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(19671);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
    if (paramp == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
      AppMethodBeat.o(19671);
      return -1L;
    }
    y.l locall = this.lIS;
    if (9223372036854775807L == locall.lIf)
    {
      ab.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
      locall.lIf = 0L;
    }
    long l = locall.lIf;
    locall.lIf = (1L + l);
    paramp = new k(l, paramp);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(0, paramp)))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(19671);
      return -1L;
    }
    AppMethodBeat.o(19671);
    return l;
  }
  
  public final void a(double paramDouble, com.tencent.mm.plugin.d.a.a.c paramc)
  {
    AppMethodBeat.i(19682);
    if (paramc == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
      AppMethodBeat.o(19682);
      return;
    }
    h localh = paramc.jMY.jNc;
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", new Object[] { Double.valueOf(paramDouble), com.tencent.mm.plugin.exdevice.j.b.aO(localh.jND), Short.valueOf(localh.jNE), Short.valueOf(localh.jNF), Integer.valueOf(localh.jNF & 0xFFFF) });
    try
    {
      int j = this.lIQ.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((q)this.lIQ.getBroadcastItem(i)).a(paramDouble, localh.jNE, localh.jNF, localh.jND, paramc.jMZ, paramc.jMY.jNc.jNG, paramc.bUD);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", new Object[] { Integer.valueOf(i), localRemoteException.toString() });
              ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramc)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", new Object[] { paramc.toString() });
      ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramc, "", new Object[0]);
      return;
    }
    finally
    {
      this.lIQ.finishBroadcast();
      AppMethodBeat.o(19682);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19675);
    int j = this.lIO.beginBroadcast();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label129;
      }
      try
      {
        ((j)this.lIO.getBroadcastItem(i)).a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramArrayOfByte);
        if ((2 == paramInt1) && (!this.lIO.unregister(this.lIO.getBroadcastItem(i)))) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = ".concat(String.valueOf(i)));
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
        }
      }
      i += 1;
    }
    label129:
    this.lIO.finishBroadcast();
    AppMethodBeat.o(19675);
  }
  
  public final void a(int paramInt, long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19678);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i) });
      b localb = new b((byte)0);
      localb.lIc = paramShort2;
      localb.lCt = paramArrayOfByte;
      localb.jRn = paramLong;
      localb.lCz = paramShort1;
      localb.mErrorCode = paramInt;
      if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, localb))) {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(6) });
      }
      AppMethodBeat.o(19678);
      return;
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(19684);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
    if (!this.lIR.register(paramn)) {
      ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
    }
    AppMethodBeat.o(19684);
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(19668);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (paramk == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
      AppMethodBeat.o(19668);
      return false;
    }
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19668);
      return false;
    }
    if ((1 != paramInt) && (paramInt != 0))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(19668);
      return false;
    }
    paramk = new y.j(paramLong, paramInt, paramk);
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(3, paramk)))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(19668);
      return false;
    }
    AppMethodBeat.o(19668);
    return true;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(19673);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
    boolean bool = this.lIP.register(parami);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
    }
    AppMethodBeat.o(19673);
    return bool;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(19689);
    if (params == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(19689);
      return false;
    }
    boolean bool = this.lIY.register(params);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
    }
    AppMethodBeat.o(19689);
    return bool;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(19681);
    if ((Build.VERSION.SDK_INT < 18) || (this.lIU == null))
    {
      AppMethodBeat.o(19681);
      return false;
    }
    boolean bool = ah.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if ((!bool) || (localObject == null))
    {
      AppMethodBeat.o(19681);
      return false;
    }
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    if (!this.lIQ.register(paramq))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
      AppMethodBeat.o(19681);
      return false;
    }
    for (;;)
    {
      com.tencent.mm.plugin.d.a.a.f localf;
      try
      {
        localObject = UUID.fromString(paramString);
        localf = this.lIU;
        com.tencent.mm.plugin.d.a.a.f.jNh = ah.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
        if (localObject == null)
        {
          paramString = "";
          ab.d("MicroMsg.exdevice.IBeaconServer", "Ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
          if (localObject != null) {
            break label248;
          }
          ab.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
          paramBoolean = false;
          if (!paramBoolean) {
            break;
          }
          AppMethodBeat.o(19681);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "UUID.fromString failed!!!, (%s)", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(19681);
        return false;
      }
      paramString = ((UUID)localObject).toString();
      continue;
      label248:
      if (paramBoolean) {
        paramBoolean = localf.mHandler.post(new f.6(localf, (UUID)localObject));
      } else {
        paramBoolean = localf.mHandler.post(new f.7(localf, (UUID)localObject));
      }
    }
    ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mIBeaconServer.ranging failed!!!");
    if (!this.lIQ.unregister(paramq)) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.unregister failed!!!");
    }
    AppMethodBeat.o(19681);
    return false;
  }
  
  public final void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19679);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + paramLong + " oldState" + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    y.c localc = new y.c((byte)0);
    localc.jRn = paramLong;
    localc.lId = paramInt1;
    localc.lIe = paramInt2;
    localc.lCs = paramInt3;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, localc))) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(19679);
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    AppMethodBeat.i(19661);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
      AppMethodBeat.o(19661);
      return false;
    }
    boolean bool = this.mHandler.post(new y.3(this, paramInt, paramj));
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
    }
    AppMethodBeat.o(19661);
    return bool;
  }
  
  public final boolean b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(19693);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    int i = this.lIX.beginBroadcast();
    k localk = (k)a(paramLong1, this.lIX, i);
    if (localk == null)
    {
      ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(paramLong1)));
      this.lIX.finishBroadcast();
      AppMethodBeat.o(19693);
      return false;
    }
    try
    {
      localk.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
      ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
      return false;
    }
    finally
    {
      this.lIX.finishBroadcast();
      AppMethodBeat.o(19693);
    }
  }
  
  public final boolean b(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(19687);
    if (paramk == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(19687);
      return false;
    }
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19687);
      return false;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(19687);
      return false;
    }
    y.e locale = new y.e((byte)0);
    locale.lFs = paramLong;
    locale.lJe = paramInt;
    locale.lJf = paramk;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(7, locale)))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(19687);
      return false;
    }
    AppMethodBeat.o(19687);
    return true;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(19690);
    if (0L > paramLong)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
      AppMethodBeat.o(19690);
      return false;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
      AppMethodBeat.o(19690);
      return false;
    }
    if (paramt == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
      AppMethodBeat.o(19690);
      return false;
    }
    i locali = new i((byte)0);
    locali.lFs = paramLong;
    locali.mData = paramArrayOfByte;
    locali.lJi = paramt;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(10, locali)))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(19690);
      return false;
    }
    AppMethodBeat.o(19690);
    return true;
  }
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(19674);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
    boolean bool = this.lIP.unregister(parami);
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
    }
    AppMethodBeat.o(19674);
    return bool;
  }
  
  public final long[] bqn()
  {
    AppMethodBeat.i(19665);
    long[] arrayOfLong = a.bqn();
    AppMethodBeat.o(19665);
    return arrayOfLong;
  }
  
  public final void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19677);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    y.d locald = new y.d();
    locald.lIf = paramLong;
    locald.lCE = paramInt1;
    locald.lCs = paramInt2;
    locald.hyJ = paramString;
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, locald))) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(19677);
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    AppMethodBeat.i(19663);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
      AppMethodBeat.o(19663);
      return false;
    }
    boolean bool = this.mHandler.post(new y.4(this, paramInt, paramj));
    if (!bool) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
    }
    AppMethodBeat.o(19663);
    return bool;
  }
  
  public final boolean c(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(19691);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!a(this.lIX, paramLong, paramk))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
      try
      {
        paramk.a(paramLong, -1, 4, -1, 0L);
        AppMethodBeat.o(19691);
        return false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
    }
    try
    {
      paramk.a(paramLong, -1, 1, -1, 0L);
      if (this.lJa != null)
      {
        com.tencent.mm.plugin.d.a.b.e locale = this.lJa;
        ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", new Object[] { Long.valueOf(paramLong) });
        if (!locale.aVT())
        {
          ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
          bool = false;
          if (bool) {
            break label351;
          }
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "connect device(mac=%d) error", new Object[] { Long.valueOf(paramLong) });
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
          AppMethodBeat.o(19691);
          return false;
          localRemoteException = localRemoteException;
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          continue;
          com.tencent.mm.plugin.d.a.b.f localf = (com.tencent.mm.plugin.d.a.b.f)localRemoteException.jNO.get(Long.valueOf(paramLong));
          if (localf != null)
          {
            ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
            bool = localf.connect();
          }
          else
          {
            localf = new com.tencent.mm.plugin.d.a.b.f(paramLong, localRemoteException.zF, localRemoteException.jOz);
            if (!localf.connect()) {
              break;
            }
            localRemoteException.N(new e.4(localRemoteException, paramLong, localf));
            bool = true;
          }
        }
        ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "tmpConnectForScan error");
        boolean bool = false;
      }
      catch (RemoteException paramk)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramk, "", new Object[0]);
        }
      }
      label351:
      AppMethodBeat.o(19691);
    }
    return true;
  }
  
  public final boolean c(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(19692);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", new Object[] { Long.valueOf(paramLong), com.tencent.mm.plugin.exdevice.j.b.aO(paramArrayOfByte) });
    if (this.lJa != null)
    {
      Object localObject = this.lJa;
      ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", new Object[] { Long.valueOf(paramLong) });
      boolean bool;
      if (!((com.tencent.mm.plugin.d.a.b.e)localObject).aVT())
      {
        ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
      }
      for (;;)
      {
        if (!bool)
        {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
          if (paramt != null) {}
          try
          {
            paramt.b(paramLong, -1, -1, "start write data error");
            AppMethodBeat.o(19692);
            return false;
            localObject = (com.tencent.mm.plugin.d.a.b.f)((com.tencent.mm.plugin.d.a.b.e)localObject).jNO.get(Long.valueOf(paramLong));
            if (localObject == null)
            {
              ab.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
              bool = false;
            }
            else
            {
              ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", new Object[] { Integer.valueOf(paramArrayOfByte.length), com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.d.a.b.f)localObject).mSessionId), ((com.tencent.mm.plugin.d.a.b.f)localObject).hIc.getName() });
              bool = ((com.tencent.mm.plugin.d.a.b.f)localObject).mHandler.sendMessage(((com.tencent.mm.plugin.d.a.b.f)localObject).mHandler.obtainMessage(3, paramArrayOfByte));
            }
          }
          catch (RemoteException paramArrayOfByte)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramArrayOfByte, "", new Object[0]);
            }
          }
        }
      }
    }
    if (!a(this.lIZ, paramLong, paramt))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
      AppMethodBeat.o(19692);
      return false;
    }
    AppMethodBeat.o(19692);
    return true;
  }
  
  public final boolean d(int paramInt, j paramj)
  {
    AppMethodBeat.i(19685);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
      AppMethodBeat.o(19685);
      return false;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
      AppMethodBeat.o(19685);
      return false;
    }
    boolean bool3 = this.lIW.register(paramj);
    if (bool3) {
      ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
    }
    for (;;)
    {
      if (this.lJa != null)
      {
        com.tencent.mm.plugin.d.a.b.e locale = this.lJa;
        ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
        boolean bool1;
        if (locale.jNQ != null)
        {
          bool1 = true;
          label120:
          Assert.assertTrue(bool1);
          if (locale.aVT()) {
            break label212;
          }
          ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
          bool1 = false;
          label143:
          if (bool1) {
            break label289;
          }
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
        }
        try
        {
          paramj.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
          if (bool3) {
            this.lIW.unregister(paramj);
          }
          AppMethodBeat.o(19685);
          return false;
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
          continue;
          bool1 = false;
          break label120;
          label212:
          boolean bool2 = locale.jNQ.a(true, locale.jNT);
          bool1 = bool2;
          if (!bool2) {
            break label143;
          }
          locale.jOx.clear();
          bool1 = bool2;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", new Object[] { localRemoteException.getMessage() });
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          }
        }
      }
    }
    label289:
    AppMethodBeat.o(19685);
    return true;
  }
  
  /* Error */
  public final boolean d(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: sipush 19695
    //   6: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_3
    //   10: ifnonnull +105 -> 115
    //   13: ldc_w 1024
    //   16: astore 6
    //   18: ldc 188
    //   20: ldc_w 1026
    //   23: iconst_2
    //   24: anewarray 192	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: lload_1
    //   30: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload 6
    //   38: aastore
    //   39: invokestatic 340	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: getfield 112	com/tencent/mm/plugin/exdevice/service/y:lIY	Landroid/os/RemoteCallbackList;
    //   46: invokevirtual 248	android/os/RemoteCallbackList:beginBroadcast	()I
    //   49: istore 5
    //   51: ldc 188
    //   53: ldc_w 1028
    //   56: iconst_1
    //   57: anewarray 192	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload 5
    //   64: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 340	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iload 4
    //   73: iload 5
    //   75: if_icmpge +97 -> 172
    //   78: aload_0
    //   79: getfield 112	com/tencent/mm/plugin/exdevice/service/y:lIY	Landroid/os/RemoteCallbackList;
    //   82: iload 4
    //   84: invokevirtual 252	android/os/RemoteCallbackList:getBroadcastItem	(I)Landroid/os/IInterface;
    //   87: checkcast 1030	com/tencent/mm/plugin/exdevice/service/s
    //   90: astore 6
    //   92: aload 6
    //   94: ifnull +30 -> 124
    //   97: aload 6
    //   99: lload_1
    //   100: aload_3
    //   101: invokeinterface 1033 4 0
    //   106: iload 4
    //   108: iconst_1
    //   109: iadd
    //   110: istore 4
    //   112: goto -41 -> 71
    //   115: aload_3
    //   116: invokestatic 642	com/tencent/mm/plugin/exdevice/j/b:aO	([B)Ljava/lang/String;
    //   119: astore 6
    //   121: goto -103 -> 18
    //   124: ldc 188
    //   126: ldc_w 1035
    //   129: invokestatic 230	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -26 -> 106
    //   135: astore_3
    //   136: ldc 188
    //   138: ldc_w 1037
    //   141: invokestatic 230	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc 188
    //   146: aload_3
    //   147: ldc_w 274
    //   150: iconst_0
    //   151: anewarray 192	java/lang/Object
    //   154: invokestatic 278	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: getfield 112	com/tencent/mm/plugin/exdevice/service/y:lIY	Landroid/os/RemoteCallbackList;
    //   161: invokevirtual 281	android/os/RemoteCallbackList:finishBroadcast	()V
    //   164: sipush 19695
    //   167: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_1
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 112	com/tencent/mm/plugin/exdevice/service/y:lIY	Landroid/os/RemoteCallbackList;
    //   176: invokevirtual 281	android/os/RemoteCallbackList:finishBroadcast	()V
    //   179: goto -15 -> 164
    //   182: astore_3
    //   183: aload_0
    //   184: getfield 112	com/tencent/mm/plugin/exdevice/service/y:lIY	Landroid/os/RemoteCallbackList;
    //   187: invokevirtual 281	android/os/RemoteCallbackList:finishBroadcast	()V
    //   190: sipush 19695
    //   193: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	y
    //   0	198	1	paramLong	long
    //   0	198	3	paramArrayOfByte	byte[]
    //   1	110	4	i	int
    //   49	27	5	j	int
    //   16	104	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	92	135	android/os/RemoteException
    //   97	106	135	android/os/RemoteException
    //   124	132	135	android/os/RemoteException
    //   78	92	182	finally
    //   97	106	182	finally
    //   124	132	182	finally
    //   136	157	182	finally
  }
  
  public final boolean e(int paramInt, j paramj)
  {
    AppMethodBeat.i(19686);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
      AppMethodBeat.o(19686);
      return false;
    }
    if (this.lJa == null)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
      AppMethodBeat.o(19686);
      return false;
    }
    com.tencent.mm.plugin.d.a.b.e locale = this.lJa;
    ab.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
    boolean bool;
    if (locale.jNQ != null) {
      bool = true;
    }
    for (;;)
    {
      Assert.assertTrue(bool);
      if (!locale.aVT())
      {
        ab.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
        bool = false;
        if (!bool) {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
        }
      }
      try
      {
        paramj.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
        AppMethodBeat.o(19686);
        return bool;
        bool = false;
        continue;
        locale.mHandler.removeCallbacks(locale.mRunnable);
        bool = locale.jNQ.a(false, locale.jNT);
      }
      catch (RemoteException paramj)
      {
        for (;;)
        {
          ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", new Object[] { paramj.getMessage() });
          ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramj, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean e(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19694);
    ab.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    int i = this.lIZ.beginBroadcast();
    t localt = (t)a(paramLong, this.lIZ, i);
    if (localt == null)
    {
      ab.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(paramLong)));
      this.lIZ.finishBroadcast();
      AppMethodBeat.o(19694);
      return false;
    }
    try
    {
      localt.b(paramLong, paramInt1, paramInt2, paramString);
      return true;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
      ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", paramString, "", new Object[0]);
      return false;
    }
    finally
    {
      this.lIZ.finishBroadcast();
      AppMethodBeat.o(19694);
    }
  }
  
  public final boolean jr(long paramLong)
  {
    AppMethodBeat.i(19669);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19669);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(paramLong))))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", new Object[] { Integer.valueOf(4) });
      AppMethodBeat.o(19669);
      return false;
    }
    AppMethodBeat.o(19669);
    return true;
  }
  
  public final boolean js(long paramLong)
  {
    return false;
  }
  
  public final boolean jt(long paramLong)
  {
    AppMethodBeat.i(19672);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", new Object[] { Long.valueOf(paramLong) });
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
      AppMethodBeat.o(19672);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(paramLong))))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(19672);
      return false;
    }
    AppMethodBeat.o(19672);
    return true;
  }
  
  public final boolean ju(long paramLong)
  {
    AppMethodBeat.i(19688);
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19688);
      return false;
    }
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(paramLong))))
    {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(19688);
      return false;
    }
    AppMethodBeat.o(19688);
    return true;
  }
  
  public final void rP(int paramInt)
  {
    AppMethodBeat.i(19683);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", new Object[] { Integer.valueOf(paramInt) });
    int i = this.lIR.beginBroadcast() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_state", paramInt);
        try
        {
          ((n)this.lIR.getBroadcastItem(i)).m(0, localBundle);
          i -= 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", new Object[] { Integer.valueOf(i) });
            ab.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", localRemoteException, "", new Object[0]);
          }
        }
      }
    }
    this.lIR.finishBroadcast();
    AppMethodBeat.o(19683);
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19680);
    ab.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = this.lIL;
    ab.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    paramArrayOfByte = new a.f(paramLong, paramArrayOfByte);
    if (!locala.mHandler.sendMessage(locala.mHandler.obtainMessage(10, paramArrayOfByte))) {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", new Object[] { Integer.valueOf(10) });
    }
    AppMethodBeat.o(19680);
  }
  
  static final class b
  {
    long jRn = 0L;
    byte[] lCt = null;
    short lCz = 0;
    short lIc = 0;
    int mErrorCode = 0;
  }
  
  static final class h
  {
    public String hyJ;
    public int lCE;
    public int lCs;
    public long lFs;
  }
  
  static final class i
  {
    public long lFs;
    public t lJi;
    public byte[] mData;
  }
  
  static final class k
  {
    long lIf;
    p lJk;
    
    public k(long paramLong, p paramp)
    {
      this.lIf = paramLong;
      this.lJk = paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y
 * JD-Core Version:    0.7.0.1
 */